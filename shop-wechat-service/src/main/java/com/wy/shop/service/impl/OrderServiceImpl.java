package com.wy.shop.service.impl;

import com.wy.shop.entity.Address;
import com.wy.shop.entity.Order;
import com.wy.shop.entity.SubmitInfo;
import com.wy.shop.mapper.ExtCartMapper;
import com.wy.shop.mapper.OrderMapper;
import com.wy.shop.request.AddressInfoReq;
import com.wy.shop.service.OrderService;
import com.wy.shop.vo.OrderCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ExtCartMapper extCartMapper;

    @Override
    @Transactional
    public OrderCountVo getOrderCount(Integer userid) {
        Integer toDeliveryCount = orderMapper.getToDeliveryCount(userid);
        Integer toPayOrderCount = orderMapper.getToPayOrderCount(userid);
        Integer toReceiveOrderCount = orderMapper.getToReceiveOrderCount(userid);

        OrderCountVo orderCountVo = new OrderCountVo();
        orderCountVo.setToDelivery(toDeliveryCount);
        orderCountVo.setToPay(toPayOrderCount);
        orderCountVo.setToReceive(toReceiveOrderCount);

        return orderCountVo;
    }

    @Override
    public Order submitOrderInfo(Integer uid, AddressInfoReq addressInfoReq) {
        SubmitInfo submitInfo = extCartMapper.getSubmitInfo(uid, addressInfoReq.getAddressId());
        Order order = new Order();

        order.setAddress(submitInfo.getAddress());
        order.setCity(submitInfo.getCity());
        order.setConsignee(submitInfo.getConsignee());
        order.setCountry(0);
        order.setMobile(submitInfo.getMobile());
        order.setOffline_pay(addressInfoReq.getOfflinePay());
        order.setDistrict(submitInfo.getDistrict());
        order.setPostscript(addressInfoReq.getPostscript());
        order.setProvince(submitInfo.getProvince());
        order.setUser_id(uid);
        order.setAdd_time(new Date().getTime()/1000);
        order.setActual_price(new BigDecimal(addressInfoReq.getActualPrice()));
        order.setFreight_price(addressInfoReq.getFreightPrice());
        order.setChange_price(submitInfo.getGoods_price().subtract(submitInfo.getOrder_price()));
        order.setOrder_status(101);
        order.setOrder_price(submitInfo.getOrder_price());
        order.setOrder_sn(
                generateOrderSn(submitInfo.getMobile()));
        order.setPrint_info(
                generatePrintInfo(submitInfo.getProductNameGroup(), submitInfo.getNumberGroup()));

        orderMapper.submitOrder(order);
        Integer id = orderMapper.queryRecentId();
        Order recentOrder = orderMapper.getOrderByRecentId(id);
        return recentOrder;
    }

    /**
     * 生成订单编号
     * @param mobile
     * @return
     *
     */
    public String generateOrderSn(String mobile) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(date);
        String mobileStr = mobile.substring(mobile.length() - 4, mobile.length());
        Random random = new Random();
        int randomNum = random.nextInt(9000) + 1000;
        String randomNumStr = String.valueOf(randomNum);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(dateStr)
                .append(mobileStr)
                .append(randomNum);
        return stringBuilder.toString();
    }

    /**
     * 生成打印的商品信息
     * @param productNameGroup
     * @param numberGroup
     * @return
     */
    public String generatePrintInfo(String productNameGroup, String numberGroup) {
        String[] productNames = productNameGroup.split(",");
        String[] numbers = numberGroup.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < productNames.length; i++) {
            stringBuilder
                    .append(i+1)
                    .append("、")
                    .append(productNames[i])
                    .append(" ")
                    .append("【")
                    .append(numbers[i])
                    .append("】 ");
        }
        return stringBuilder.toString();
    }

}
