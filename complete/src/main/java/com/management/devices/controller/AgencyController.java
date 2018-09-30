package com.management.devices.controller;
import com.management.devices.model.out.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

@RestController
public class AgencyController {

    @PostMapping("/getAgencyAll")
    @ResponseBody
    public BaseResponse getAgencyAll(@RequestBody Map body) {
        BaseResponse result = new BaseResponse();
        Logger logger = Logger.getLogger("getAgencyAll");
        logger.info("getAgencyAll is starting");
        logger.info("info => " + body);
        result.setTransNo(body.remove("transNo").toString());
        try {
            List agencies = Application.storeProcedureDAO.getAgencyAll(body);
            logger.info("result => " + body);

            result.setCode(body.remove("code").toString());
            result.setDescription(body.remove("description").toString());
            body.put("dataList", agencies);
            result.setData(body);
        } catch (Exception ex) {
            logger.error("error => " + ex);
        }
        return result;
    }

}
