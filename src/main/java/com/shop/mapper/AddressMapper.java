package com.shop.mapper;

import com.shop.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/11/9  15:02
 */
@Mapper
public interface AddressMapper {

    public List<Address> getAddresses(Integer uid);

    public Address findAddressById(Integer id);

    public void saveAddress(Address address);

    public Integer queryRecentId();

}
