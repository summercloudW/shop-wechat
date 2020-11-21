package com.shop.service.impl;

import com.shop.entity.Specification;
import com.shop.mapper.SpecificationMapper;
import com.shop.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    @Override
    public Specification getSpecification(Integer specification_id) {
        return specificationMapper.getSpecification(specification_id);
    }

}
