package com.wy.shop.mapper;

import com.wy.shop.entity.Specification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SpecificationMapper {

    public Specification getSpecification(Integer specification_id);

}
