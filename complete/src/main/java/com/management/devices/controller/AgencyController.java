package com.management.devices.controller;

import com.management.devices.common.enums.ResponseCode;
import com.management.devices.database.entity.Agency;
import com.management.devices.model.out.BaseResponse;
import com.management.devices.model.out.ResponseAgency;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

@RestController
public class AgencyController {

//    @GetMapping("/getAgencyAll")
//    @ResponseBody
//    public BaseResponse getAgencyAll() {
//        BaseResponse result = new BaseResponse();
//        Logger logger = Logger.getLogger("getAgencyAll");
//
//        try {
//            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession session = sqlSessionFactory.openSession();
//
//            Map params = new HashMap();
//            List agencies = session.selectList(
//                    "Agency.getAgencyAll", params);
//            session.commit();
//            session.close();
//            result.setResponseCode(ResponseCode.SUCCESS.code);
//            result.setDescription(ResponseCode.SUCCESS.text);
//            result.setData(agencies);
//        } catch (Exception ex) {
//            logger.error("error => " + ex);
//        }
//        return result;
//    }

    @PostMapping("/getAgencyAll")
    @ResponseBody
    public BaseResponse getAgencyAll(@RequestBody Map<String, String> body) {
        BaseResponse result = new BaseResponse();
        Logger logger = Logger.getLogger("getAgencyAll");
        logger.info("getAgencyAll is starting");
        logger.info("info => " + body);
        result.setTransNo(body.get("transNo"));
        try {
            Map params = new HashMap();
            List agencies = Application.storeProcedureDAO.getAgencyAll(params);
            result.setResponseCode(ResponseCode.SUCCESS.code);
            result.setDescription(ResponseCode.SUCCESS.text);
            result.setData(agencies);
        } catch (Exception ex) {
            logger.error("error => " + ex);
        }
        return result;
    }

//    @PostMapping("/greeting")
//    @ResponseBody
//    public Greeting greeting(@RequestBody Map<String, String> body) {
//        try {
//            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession session = sqlSessionFactory.openSession();
//
//            List students = session.selectList(
//                    "Student.callById", body);
//
//            //Print the student details
//            for (int i = 0; i < students.size(); i++) {
//                Student student = (Student) students.get(i);
//                System.out.println("Details of the student are:: ");
//                System.out.println("Id :"+student.getId());
//                System.out.println("Name :"+student.getName());
//                System.out.println("Branch :"+student.getBranch());
//                System.out.println("Percentage :"+student.getPercentage());
//                System.out.println("Email :"+student.getEmail());
//                System.out.println("Phone :"+student.getPhone());
//            }
//            session.commit();
//            session.close();
//        } catch (Exception ex) {
//            System.out.println("error => " + ex);
//        }
//
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, "xxxxx"));
//    }
}
