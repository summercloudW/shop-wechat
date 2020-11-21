package com.shop.mapper;

import com.shop.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapper {

//    @Select("SELECT * FROM hiolabs_notice")
    public List<Notice> getNoticeList();

}
