package cn.yunhe.java.dao.inter.goods;

import cn.yunhe.java.pojo.MallGoodsClass;

import java.util.List;


public interface MallGoodsClassDao {
	
	/**
	 * 生成树
	 * @return
	 */
	List<MallGoodsClass> queryParent(String gcParentId);
	
	/**
	 * 查询
	 * @param gcId
	 * @return
	 */
	MallGoodsClass selectById(Integer gcId);
	
    /**
     * 删除
     * @param gcId
     * @return
     */
    int deleteById(Integer gcId);
    
    /**
     * 修改
     * @param mgc
     * @return
     */
    int update(MallGoodsClass mgc);
    
    
    /**
     * 保存商品分类信息
     * @param record
     * @return
     */
    int insertSelective(MallGoodsClass record); 


}