<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style>
<!--
object {
	left:0;
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 14px;
	font: inherit;
	vertical-align: baseline;
}

.fileupload-block {
	position: relative;
	width: 100px;
	height: 100px;
	text-align: center;
	line-height: 100px;
	overflow: hidden;
	border: solid 1px #ddd;
	border-radius: 2px;
	cursor: default;	
	margin-left: auto;
	margin-right: auto;	
}

.fileupload-info {
	
}

.fileupload-file {
	font-size: 200px;
	display: inline-block;
	position: absolute;
	top: 0;
	right: 0;
	filter: alpha(opacity = 0);
	-moz-opacity: 0;
	-khtml-opacity: 0;
	opacity: 0;
	cursor: pointer;
	width: 100px;
	height: 100px;
}

.fileupload-image {
	margin:auto;
}

.fileupload-delete {
	display: inline-block;
	position: absolute;
	height: 18px;
	width:18px;
	padding: 3px;
	top: 1px;
	right: 1px;
	line-height: 18px;
	cursor: pointer;
}
.imgBtn{
	margin-left:auto;
	margin-right: auto;
}

-->
</style>
<script type="text/javascript">
  
</script>
    <div class="layui-btn-group">
        <a id="btnSave"  href="javascript:classSave();" title="保存"  class="layui-btn layui-btn-sm">
        	<i class="layui-icon">&#xe654;</i>保存
        </a>
        <a id="btnDel" ask="确定要删除吗?" gcId="${mgc.gcId}" url="goodsClass/deleteClass.do" title="删除"  
               href="javascript:deleteClass();" class="layui-btn layui-btn-sm">
        	<i class="layui-icon">&#xe640;</i>删除
        </a>       
    </div> 
 <fieldset>
       <legend>商品分类详情</legend>
  <form class="layui-form layui-form-pane" lay-filter="gcForm" id="gcForm" action="goodsClass/updateGoodsClass.do">
	  <div class="layui-form-item">
	    <label class="layui-form-label">分类名称：</label>
	    <div class="layui-input-block">
	      <input type="text" name="gcName" lay-verify="gcName" value="${mgc.gcName}" maxlength="10" autocomplete="off" placeholder="请输入分类名称" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label"> 父级分类：</label>
	    <div class="layui-input-inline">
	       <input type="text" name="pGcName" readonly autocomplete="off" class="layui-input" value="${mgc.gcParentName}">
	      <input type="hidden" name="gcId" value="${mgc.gcId}"/>
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">排序ID:</label>
	      <div class="layui-input-inline">
	        <input type="text" name="gcSort" lay-verify="required|phone" autocomplete="off" value="${mgc.gcSort}" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">描述:</label>
		    <div class="layui-input-block">
		      <textarea name="gcDescription" placeholder="请输入描述信息" rows="5" cols="100" maxLength="255" class="layui-textarea">${mgc.gcDescription }</textarea>
		    </div>
		 </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">分类图片：</label>
	      <div class="layui-input-block">
                <div class="fileupload-block" style="width:${imgW}px;height:${imgH}px;">
                
					<img class="fileupload-image" id="Img" src='${dfsPath}' tValue="${gcPicPath}"
					  style="display:inline;width:${imgW}px;height:${imgH}px;" />

					<img class="fileupload-delete" id="Delete" onclick="deleteImage();"
						 style="position:absolute;z-index:20;display:none;" src="images/x.jpg"/>
	                        	 
	                <label for="updinput" class="fileupload-file" title="点击上传图片" style="width:${imgW}px;height:${imgH}px;">
	                     <input type="file"  accept=".jpg,.gif,.png,.jpeg,.bmp" class="image" id="updinput" name="image" 
	                        data-url="goodsClass/uploadImage" wValue="${imgW}" hValue="${imgH}"
	                        style="display:none;"  multiple/> 	                        
	                </label>
	                
	                 <input class="fileupload-input" id="Input" type="hidden" name="gcPicpath" value="${gcPicPath}"/>
			         <label><span class="text-dot"></span></label>
	            </div>  
	            <div>
			        <input id="imgBtn" type="button" class="imgBtn" onclick="upload();" style="display:none" value="上传选中图片"/>  	       			
	            	<div class="" id="img-progress"></div>
	            </div> 
	 	      </div>
	    </div>
	  </div>
 </form>
 </fieldset>
	<script type="text/javascript">
	layui.config({
	    base: "js/common/"
	}).use(["common", "element", "layer", "form", "table", "jquery"], function(){
			var elem = layui.element;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var $ = layui.jquery;
			layui.common.init();		
		/**
		 删除商品分类
		**/
		window.deleteClass = function(){
		    var $this = $("#btnDel");
		    var _gcId = $this.attr("gcId");	
		    if(_gcId==""){
		       layer.msg("请在左侧选择商品分类信息后删除!", {icon: 5,time: 2000});
		      return;
		    }	    
		    layer.open({
                    icon:3,
                    title: "删除",
                    content : $this.attr("ask"),
                    btn: ['确认', '取消'],
                    yes: function(index, layero){
                        $.ajax({
                            type:"post",
                            url:$this.attr("url"),
                            data:{gcId : _gcId},
                            dataType:"json",
                            success:function(json){
                                if(json.statusCode == 200){
                                    layer.msg(json.message, {icon: 6,time: 2000});
						            $("form")[0].reset();
						            $this.attr("gcId","")
                                    var treeObj = $.fn.zTree.getZTreeObj("goodsClass");
							        var nodes = treeObj.getSelectedNodes();
						            for (var i = 0, l = nodes.length; i < l; i++) {
						                treeObj.removeNode(nodes[i]);
						            }
                                }else{
                                    layer.msg(json.message, {icon: 5,time: 2000});
                                }
                            }
                        });
                    },
                    btn2: function(index, layero){ }
                });
        };
	
	  //图片上传
	  $("#updinput").fileupload({
				dataType:"json",		
				maxFileSize:"500000",			
				success: function (data) {							
					if(data.statusCode=="200"){
						var w = $(this).attr("wValue");
						var h = $(this).attr("hValue");	
						$("#Img").attr("tValue",data.model);				
						$("#Img").attr("src",data.forwardUrl).css("display","block");
						$("#image>object").css("height","600");
						$("#Delete").css("display","block");
						//初始化截图工具
						$("#Img").cropper({aspectRatio: w/h});
						mycroper=true;
						$("#imgBtn").css("display","block");
					}else if(data.statusCode=="300"){
						layer.msg(data.message, {icon: 5,time: 2000});
					}
				}
			 });  	
	
        //图片剪切
 	   var mycroper=false;
		//上传选中的图片部分并显示
		window.upload = function (){
		    var delFile = $("#Img").attr("tValue");
			//获取截图工具选中的部分
			var cut = $("#Img").cropper("getCroppedCanvas").toDataURL("image/jpeg");
			cut = cut.substring(23);
			$.post("goodsClass/uploadCanvas",{"canvasData":cut,"gcId":"${goodId}","delFile":delFile},function(json){
				if(json.statusCode=="200"){
					$("#Img").attr("src",json.forwardUrl).css("display","block");
					$("#image>object").css("height","0");
					$("#Delete").css("display","block");
					$("#Input").val(json.model);
					if(mycroper){
						$("#Img").cropper("destroy");
						mycroper=false;
						}
					$("#imgBtn").css("display","none");
				}
				setTimeout(function(){},2000);
			},"json");
		};
		//删除图片
		window.deleteImage = function(){
			$("#Img").removeAttr("src").css("display","none");
			$("#image>object").css("height",600);
			$("#Delete").css("display","none");
			$("#Input").val("");
			//销毁截图工具
			if(mycroper){
				$("#Img").cropper("destroy");
				mycroper=false;
			}
			$("#imgBtn").css("display","none");
		};
		
     window.classSaved = function(data) {        
        if (data.statusCode == 200) {
            layer.msg(data.message, {icon: 6,time: 2000});
            var treeObj = $.fn.zTree.getZTreeObj("goodsClass");
            var nodes = treeObj.getSelectedNodes();
            nodes[0].name = data.model.gcName;
            treeObj.updateNode(nodes[0]);
        }else{
        	layer.msg(data.message, {icon: 5,time: 2000});
        }
    }; 
    window.classSave = function() {
        var $this = $("#gcForm");
        $.post($this.attr("action"),$this.serialize(),classSaved,"json");
    };  	
});
</script>