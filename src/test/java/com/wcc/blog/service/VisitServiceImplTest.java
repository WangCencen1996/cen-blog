package com.wcc.blog.service;

import com.wcc.blog.BlogApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class VisitServiceImplTest extends BlogApplicationTests {
    @Autowired
    private VisitService visitService;
    @Test
    public void svae(){
        visitService.saveIP("127.136.1.1");
    }
}
