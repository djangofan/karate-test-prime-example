package com.intuit.karate.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/headers")
public class HeadersController {

    @GetMapping
    public ResponseEntity getToken(HttpServletResponse response) {
        response.addHeader("Set-Cookie", "guid=3f0a56cd-4038-4bdf-bca9-d811a2af6bf8; Expires=Tue, 08 Oct 2019 14:21:03 GMT");
        response.addHeader("Set-Cookie", "testCookie=testValue; Expires=Tue, 08-Oct-2019 14:21:03 GMT");
        return ResponseEntity.ok().build();
    }
}
