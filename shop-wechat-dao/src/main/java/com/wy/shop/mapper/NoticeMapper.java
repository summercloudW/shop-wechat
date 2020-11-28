package com.wy.shop.mapper;

import com.wy.shop.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface NoticeMapper {

    public List<Notice> getNoticeList();

}
