package com.management.devices.controller;

import com.management.devices.common.enums.ResponseCode;
import com.management.devices.model.out.BaseResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Reader;
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
            result.setCode(ResponseCode.SUCCESS.code);
            result.setDescription(ResponseCode.SUCCESS.text);
            body.remove("pass");
            result.setData(body);
        } catch (Exception ex) {
            logger.error("error => " + ex);
        }
        return result;
    }
}
