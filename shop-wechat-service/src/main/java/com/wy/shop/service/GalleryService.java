package com.wy.shop.service;


import com.wy.shop.entity.Gallery;

import java.util.List;

public interface GalleryService {

    public List<Gallery> getSpecificationGallery(Integer goods_id);

}
