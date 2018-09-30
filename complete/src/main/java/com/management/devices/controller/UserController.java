package com.management.devices.controller;

import com.management.devices.model.out.BaseResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse login(@RequestBody Map<String, String> body) {
        BaseResponse result = new BaseResponse();
        Logger logger = Logger.getLogger("login");
        logger.info("login is starting");
        logger.info("info => " + body);
        result.setTransNo(body.remove("transNo"));
        try {
            Application.storeProcedureDAO.login(body);
            result.setCode(body.remove("code"));
            result.setDescription(body.remove("description"));
            body.remove("pass");
            result.setData(body);
        } catch (Exception ex) {
            logger.error("error => " + ex);
        }
        return result;
    }

    @PostMapping("/logout")
    @ResponseBody
    public BaseResponse logout(@RequestBody Map<String, String> body) {
        BaseResponse result = new BaseResponse();
        Logger logger = Logger.getLogger("logout");
        logger.info("logout is starting");
        logger.info("info => " + body);
        result.setTransNo(body.remove("transNo"));
        try {
            Application.storeProcedureDAO.logout(body);
            result.setCode(body.remove("code"));
            result.setDescription(body.remove("description"));
            result.setData(body);
        } catch (Exception ex) {
            logger.error("error => " + ex);
        }
        return result;
    }
}
