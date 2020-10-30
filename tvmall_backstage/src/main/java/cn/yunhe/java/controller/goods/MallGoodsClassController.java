package cn.yunhe.java.controller.goods;

import cn.yunhe.java.controller.common.BaseController;
import cn.yunhe.java.pojo.MallGoodsClass;
import cn.yunhe.java.services.goods.MallGoodsClassService;
import cn.yunhe.java.util.Base64ToImage;
import cn.yunhe.java.util.DateUtils;
import cn.yunhe.java.util.ImageUtil;
import cn.yunhe.java.util.LoadProperties;
import cn.yunhe.java.util.objects.AjaxDone;
import cn.yunhe.java.util.objects.ZTreeNode;
import org.apache.commons.io.FileUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("goodsClass")
public class MallGoodsClassController extends BaseController {

//    @Autowired
//    private MallGoodsClassService service;
    @Reference(group = "tvmall_java",version = "2.0")
    private MallGoodsClassService service;
    /**
     * 到商品分类页面
     * @return
     */
    @RequestMapping("toMgr")
    public String query(){
        return "goods/goodsclass/goodsClassMgr";
    }

    /**
     * 商品分类树
     * @param id
     * 返回数据字典的Json格式数据
     */
    @ResponseBody
    @RequestMapping("tree")
    public List<ZTreeNode> tree(String id) {
        List<ZTreeNode> list = new ArrayList<ZTreeNode>();
        if (id != null)
        {
            list = service.queryParent(id);
            return list;
        }
        list = service.queryParent("0");
        return list ;
    }

    /**
     *
     * @return
     * 到修改商品分类页面
     */
    @RequestMapping("toGcUpd")
    public String toUpdGoodsClass(String gcId, HttpServletRequest request , ModelMap model) {
        try {
            MallGoodsClass mgc = service.queryById(Integer.parseInt(gcId));
            //model.addAttribute(mgc);
            model.addAttribute("mgc", mgc);

            String picPath = mgc.getGcPicpath();
            if(picPath==null||"".equals(picPath)) {
                //model.put("gcPicPath", request.getSession().getServletContext().getRealPath("/images/")+"/noPic.png");
                model.put("dfsPath", "images/noPic.png");
            }else {
                model.put("gcPicPath", mgc.getGcPicpath());
                //拼接fastDFS图片路径
                model.put("dfsPath", LoadProperties.findValue("viewUrl")+"/?path="+mgc.getGcPicpath());
            }

            String imgW = LoadProperties.findValue("imgW");
            String imgH = LoadProperties.findValue("imgH");
            model.put("imgW", imgW);
            model.put("imgH", imgH);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "goods/goodsclass/toGcUpd";
    }

    /**
     * 删除商品分类信息
     * @param gcId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteClass")
    public AjaxDone deleteGcClass(String gcId) {
        try {
            int rst = service.deleteById(Integer.parseInt(gcId));
            if(rst==-1) {
                return new AjaxDone("300","该商品分类有子分类,请先删除其子分类!");
            }
            if(rst>=0) {
                return new AjaxDone("200","删除成功!");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return  new AjaxDone("300","系统繁忙,请稍后重试!");
    }

    /**
     * 上传原始图片
     * @return
     */
    @ResponseBody
    @RequestMapping("uploadImage")
    public AjaxDone updateImage(@RequestParam("image") CommonsMultipartFile image) {
        try {
            String imageFileName = image.getOriginalFilename();

            if (imageFileName.indexOf(".jpg") == -1
                    && imageFileName.indexOf(".gif") == -1
                    && imageFileName.indexOf(".png") == -1
                    && imageFileName.indexOf(".jpeg") == -1) {
                return new AjaxDone("300", "文件格式不正确，请上传 *.png,*.jpeg,*.gif,*.jpg类型图片");
            }
             String extName = imageFileName.substring(imageFileName.lastIndexOf("."),imageFileName.length());
            if (image != null && !image.isEmpty()) {
		    	 // 老方法实现图片上传与回显
                String path = LoadProperties.findValue("imgPath")+ "/"+ DateUtils.getSystemDateTimeByFormat("yyyyMMddHHmmss")+ extName;
		    	  File file = new File(path);
		    	  if (!file.getParentFile().exists()) {
		    		  file.getParentFile().mkdirs();
		    	  }
				FileUtils.copyInputStreamToFile(image.getInputStream(), file);
				String rtnPath = LoadProperties.findValue("viewUrl")+"?path="+file.getPath();

                return new AjaxDone("200", "上传成功",rtnPath,null);
            } else {
                return new AjaxDone("300", "文件格式不正确，请上传 *.png,*.jpeg,*.gif,*.jpg类型图片");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxDone("300", "上传失败");
    }

    /**
     * 上传剪切后的图片
     * @return
     */
    @ResponseBody
    @RequestMapping("uploadCanvas")
    public AjaxDone updateConvars(String gcId,String canvasData,String delFile) {
        try {
            String path = LoadProperties.findValue("imgPath")+ "/";
            String fileName = DateUtils.getSystemDateTimeByFormat("yyyyMMddHHmmss")+".jpg";

            File file = Base64ToImage.decodeBase64ToImage(canvasData, path, fileName);

            //删除原图片
            if(delFile!=null) {
                File delete = new File(delFile);
                if (delete != null) {
                    delete.delete();
                }
            }
            if(file!=null) {
                String imgW = LoadProperties.findValue("imgW");
                String imgH = LoadProperties.findValue("imgH");
                //保存canvas转成的缩略图
                String filePath = ImageUtil.thumbnailImage(file.getPath(),Integer.parseInt(imgW),Integer.parseInt(imgH), true);
                String rtnPath = LoadProperties.findValue("viewUrl")+"?path="+filePath;
                //删除canvas原图
                file.delete();
                return new AjaxDone("200","上传成功!",rtnPath,filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxDone("300","系统繁忙,请稍后重试!");
    }

    /**
     * 保存商品分类信息
     * @return
     */
    @ResponseBody
    @RequestMapping("updateGoodsClass")
    public AjaxDone saveGoodsClass(Integer gcId,String gcName,Short gcSort,String gcDescription,String gcPicpath ) {
        try {
            MallGoodsClass mgc = new MallGoodsClass();
            mgc.setGcId(gcId);
            mgc.setGcName(gcName);
            mgc.setGcSort(gcSort);
            mgc.setGcDescription(gcDescription);
            mgc.setGcPicpath(gcPicpath);

            int rst = service.update(mgc);
            if(rst>0) {
                Map<String,String> rtnMap = new HashMap<String,String>();
                rtnMap.put("gcName", mgc.getGcName());
                return new AjaxDone("200","保存成功!","",rtnMap);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return new AjaxDone("300","系统繁忙,请稍后重试!");
    }

    /**
     * 新增父级商品分类
     * @return
     */
    @ResponseBody
    @RequestMapping("addParentClass")
    public AjaxDone addParentClass() {
        MallGoodsClass mgc = new MallGoodsClass();
        mgc.setGcName("新增分类");
        mgc.setGcParentId(0);
        mgc.setGcSort((short)255);

        try{
            int rst = service.insert(mgc);
            if(rst>0)
                return new AjaxDone("200","添加父级分类成功!","",mgc);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxDone("300","系统繁忙,请稍后重试!");
    }

    /**
     * 添加子级分类
     * @param gcId
     * @param treeNodeLevel
     * @return
     */
    @ResponseBody
    @RequestMapping("addSubClass")
    public AjaxDone addSubClass(String gcId,String treeNodeLevel) {
        if("2".equals(treeNodeLevel)){
            return new AjaxDone("300", "最多创建三级商品分类!");
        }
        MallGoodsClass mgc = new MallGoodsClass();
        mgc.setGcName("新增下级分类");
        mgc.setGcParentId(Integer.parseInt(gcId));
        mgc.setGcSort((short)255);
        try{
            int rst = service.insert(mgc);
            if(rst>0)
                return new AjaxDone("200","添加子级分类成功","",mgc);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new AjaxDone("300","系统繁忙,请稍后重试!");
    }
}
