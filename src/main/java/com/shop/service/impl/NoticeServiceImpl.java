package com.shop.service.impl;

import com.shop.entity.Notice;
import com.shop.mapper.NoticeMapper;
import com.shop.service.NoticeService;
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
