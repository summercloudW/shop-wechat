package com.shop.mapper;

import com.shop.entity.Specification;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpecificationMapper {

    public Specification getSpecification(Integer specification_id);

}
