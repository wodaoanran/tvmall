package cn.yunhe.java.dao;

import cn.yunhe.java.pojo.TvOrder;
import cn.yunhe.java.pojo.TvOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TvOrderMapper {
    long countByExample(TvOrderExample example);

    int deleteByExample(TvOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(TvOrder record);

    int insertSelective(TvOrder record);

    List<TvOrder> selectByExample(TvOrderExample example);

    TvOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") TvOrder record, @Param("example") TvOrderExample example);

    int updateByExample(@Param("record") TvOrder record, @Param("example") TvOrderExample example);

    int updateByPrimaryKeySelective(TvOrder record);

    int updateByPrimaryKey(TvOrder record);
}