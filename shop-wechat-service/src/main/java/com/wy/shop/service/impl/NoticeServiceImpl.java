package com.wy.shop.service.impl;

import com.wy.shop.entity.Notice;
import com.wy.shop.mapper.NoticeMapper;
import com.wy.shop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getListNotice() {
        return noticeMapper.getNoticeList();
    }

}
