package com.shop.service.impl;

import com.shop.entity.Address;
import com.shop.mapper.AddressMapper;
import com.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author : WangYB
 * @time: 2020/11/9  15:18
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddresses(Integer uid) {
        return addressMapper.getAddresses(uid);
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressMapper.findAddressById(id);
    }

    @Override
    public Address saveAddress(Address address) {
        addressMapper.saveAddress(address);
        int id = addressMapper.queryRecentId();
        Address recentAddress = addressMapper.findAddressById(id);
        return recentAddress;
    }

}
