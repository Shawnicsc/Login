package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id == #{id}")
    @ResultMap("brandResultMap")
    Brand selectById( @Param("id") int id);

    /**
     * 新增
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
    /**
     * 修改
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);
}
