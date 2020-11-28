package com.wy.shop.service;


import com.wy.shop.entity.Address;
import com.wy.shop.vo.AddressVo;

import java.util.List;

/**
 *
 * @author : WangYB
 * @time: 2020/11/9  15:17
 *
 */
public interface AddressService {

    public List<AddressVo> getAddresses(Integer uid);

    public Address findAddressById(Integer id);

    public Address saveAddress(Address address);

}
