package org.example.kotime.controller;

import org.example.kotime.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanct
 * @since 1.2
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    private TestService testService;


    @RequestMapping("/aInsert")
    public Long aInsert() {
        return testService.aInsert();
    }

    @RequestMapping("/cUpdate")
    public void cUpdate() {
        testService.cUpdate();
    }

    @RequestMapping("/bDelete")
    public void bDelete() {
        testService.bDelete();
    }

}
