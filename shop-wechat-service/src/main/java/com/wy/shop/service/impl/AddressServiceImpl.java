package com.wy.shop.service.impl;

import com.wy.shop.entity.Address;
import com.wy.shop.mapper.AddressMapper;
import com.wy.shop.mapper.RegionMapper;
import com.wy.shop.service.AddressService;
import com.wy.shop.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : WangYB
 * @time: 2020/11/9  15:18
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<AddressVo> getAddresses(Integer uid) {
        List<Address> addresses = addressMapper.getAddresses(uid);
        List<AddressVo> addressVoList = new ArrayList<>();
        for (Address address : addresses) {
            AddressVo addressVo = new AddressVo();
            String provinceName = regionMapper.findNameById(address.getProvince_id());
            String cityName = regionMapper.findNameById(address.getCity_id());
            String districtName = regionMapper.findNameById(address.getDistrict_id());
            addressVo.setId(address.getId());
            addressVo.setAddress(address.getAddress());
            addressVo.setCountry_id(address.getCountry_id());
            addressVo.setProvince_id(address.getProvince_id());
            addressVo.setCity_id(address.getCity_id());
            addressVo.setDistrict_id(address.getDistrict_id());
            addressVo.setIs_default(address.getIs_default());
            addressVo.setIs_delete(address.getIs_delete());
            addressVo.setMobile(address.getMobile());
            addressVo.setName(address.getName());
            addressVo.setUser_id(address.getUser_id());
            addressVo.setProvince_name(provinceName);
            addressVo.setCity_name(cityName);
            addressVo.setDistrict_name(districtName);
            addressVo.setFull_region(provinceName + cityName + districtName);
            addressVoList.add(addressVo);
        }
        return addressVoList;
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressMapper.findAddressById(id);
    }

    @Override
    public Address saveAddress(Address address) {
        address.setCountry_id(0);
        if (address.getIs_default() == null) {
            address.setIs_default(0);
        }
        address.setIs_delete(0);

        addressMapper.saveAddress(address);
        int id = addressMapper.queryRecentId();
        Address recentAddress = addressMapper.findAddressById(id);
        return recentAddress;
    }

}
