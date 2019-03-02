package com.ssm.web.controller;

import com.ssm.entity.VideoType;
import com.ssm.service.VideoTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created on 2019/2/15 15:06
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Controller
public class TestController {

    private static Logger log = Logger.getLogger(TestController.class);

    @Autowired
    private VideoTypeService videoTypeService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @RequestMapping("/getVideoTypeList")
    public List<VideoType> getVideoTypeList(){
        List<VideoType> listVideoType = videoTypeService.getVideoType(null);
        for (VideoType vt : listVideoType){
            log.info(vt.toString());
        }
        return listVideoType;
    }

}
