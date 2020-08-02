package com.prayerlaputa.gatewaywithjwt.controller;

import com.prayerlaputa.gatewaywithjwt.constant.JwtConst;
import com.prayerlaputa.gatewaywithjwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenglong.yu
 * created on 2020/8/1
 */
@RestController
public class JwtRegisterController {

    @Resource
    private JwtService jwtService;

    @GetMapping("/api/register")
    public String register(String username, HttpServletResponse response) {
        String jwt = jwtService.generateToken(username);
        response.setHeader(JwtConst.JWT_HEADER_NAME, jwt);
        return String.format("JWT for %s :\n%s", username, jwt);
    }


}
