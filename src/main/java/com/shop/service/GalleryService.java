package com.shop.service;

import com.shop.entity.Gallery;

import java.util.List;

public interface GalleryService {

    public List<Gallery> getSpecificationGallery(Integer goods_id);

}
