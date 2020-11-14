package com.shop.service.impl;

import com.shop.entity.Gallery;
import com.shop.mapper.GalleryMapper;
import com.shop.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryMapper galleryMapper;

    @Override
    public List<Gallery> getSpecificationGallery(Integer goods_id) {
        List<Gallery> specificationGallery = galleryMapper.getSpecificationGallery(goods_id);
        return specificationGallery;
    }

}
