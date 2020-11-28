package com.wy.shop.mapper;

import com.wy.shop.entity.Address;
import com.wy.shop.entity.ExtAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/9  15:02
 */
@Component
@Mapper
public interface AddressMapper {

    public List<Address> getAddresses(Integer uid);

    public Address findAddressById(Integer id);

    public void saveAddress(@Param("address") Address address);

    public Integer queryRecentId();

    public ExtAddress findExtAddressById(Integer id);

}
