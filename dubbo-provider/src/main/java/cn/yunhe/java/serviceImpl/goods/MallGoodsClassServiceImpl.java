package cn.yunhe.java.serviceImpl.goods;

import cn.yunhe.java.dao.inter.goods.MallGoodsClassDao;
import cn.yunhe.java.pojo.MallGoodsClass;
import cn.yunhe.java.services.goods.MallGoodsClassService;
import cn.yunhe.java.util.objects.ZTreeNode;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service(group = "tvmall_java",version = "2.0",cluster = "failover")
public class MallGoodsClassServiceImpl implements MallGoodsClassService {

    @Autowired
    private MallGoodsClassDao dao;

    @Override
    public List<ZTreeNode> queryParent(String gcParentId) {
        List<MallGoodsClass> gcList = dao.queryParent(gcParentId);
        List<ZTreeNode> rtnList = new ArrayList<ZTreeNode>();
        for(MallGoodsClass mgc : gcList){
            ZTreeNode item = new ZTreeNode(mgc.getGcName(),mgc.getGcId().toString());
            item.setIsParent(mgc.getChildNum()>0);
            rtnList.add(item);
        }
        return rtnList;
    }

    @Override
    public MallGoodsClass queryById(Integer gcId) {
        MallGoodsClass mgc = dao.selectById(gcId);
        return mgc;
    }

    @Override
    public int deleteById(Integer gcId) {
        MallGoodsClass mgc = dao.selectById(gcId);
        if(mgc.getChildNum()>0)
            return -1; //-1表示有子节点,删除当前节点,必须先删除其子节点
        int rst = dao.deleteById(mgc.getGcId());
        return rst;
    }

    @Override
    public int insert(MallGoodsClass mgc) {
        return dao.insertSelective(mgc);
    }

    @Override
    public int update(MallGoodsClass mgc) {
        int rst = dao.update(mgc);
        return rst;
    }

    @Override
    public boolean isExistsChild(String gcId) {
        return false;
    }
}
