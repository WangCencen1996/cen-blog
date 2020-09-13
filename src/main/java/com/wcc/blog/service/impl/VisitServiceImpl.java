package com.wcc.blog.service.impl;

import com.wcc.blog.mapper.VisitMapper;
import com.wcc.blog.pojo.Visit;
import com.wcc.blog.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitMapper visitMapper;
    @Override
    public void saveIP(String ip) {
        System.out.println("VisitServiceImpl");
        System.out.println(ip);
        Visit visit = new Visit();
        visit.setIp(ip);
        visit.setCreateTime(new Date());
        System.out.println(visit);
        visitMapper.saveIP(visit);
    }
}
