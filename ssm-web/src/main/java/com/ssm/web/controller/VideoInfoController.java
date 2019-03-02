package com.ssm.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.entity.VideoInfo;
import com.ssm.service.VideoInfoService;
import com.ssm.service.VideoTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * created on 2019/2/16 13:11
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Controller
public class VideoInfoController {

    private static Logger log = Logger.getLogger(VideoInfoController.class);

    private static final String INDEXVIDEO = "indexVideo";
    private static final String LOADADDVIDEO = "loadAddVideo";
    private static final String VIDEODETAILS = "videoDetails";
    @Autowired
    private VideoInfoService videoInfoService;

    @Autowired
    private VideoTypeService videoTypeService;

    /**
     * 查询视频列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/indexVideo")
    public String indexVideo(HttpServletRequest request, Integer pageIndex) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        //页数，一定要在调用 DAO 方法之前
        Page startPage = PageHelper.startPage(pageIndex, 2);
        request.setAttribute("listVideo", videoInfoService.getVideoAll(null));
        //分页总数
        request.setAttribute("pages", startPage.getPages());
        return INDEXVIDEO;
    }

    @RequestMapping("/loadAddVideo")
    public String loadAddVideo(HttpServletRequest request) {
        request.setAttribute("listVideoType", videoTypeService.getVideoType(null));
        return LOADADDVIDEO;
    }

    @RequestMapping("/addVideo")
    public String addVideo(@RequestParam(value = "file",required = false) MultipartFile file, VideoInfo videoInfo,
                           HttpServletRequest request, HttpServletResponse response){
        String imageName = System.currentTimeMillis() + ".png";
        String path = request.getSession().getServletContext().getRealPath("/static/imgs");
        File targetFile  = new File(path, imageName);
        if (!targetFile.exists()){
            targetFile.mkdirs();//创建文件夹
        }
        try {
            //保存
            file.transferTo(targetFile);
        } catch (IOException e) {
            log.error(e);
            request.setAttribute("result", "上传图片失败！");
            return LOADADDVIDEO;
        }
        videoInfo.setVideoUrl(imageName);
        try {
            log.info("##### videoInfoService.addVideo(videoInfo) #####  videoInfo:{}" + videoInfo.toString());
            videoInfoService.addVideo(videoInfo);
        }catch (Exception e){
            log.error(e);
            request.setAttribute("result", "保存数据错误！");
            return LOADADDVIDEO;
        }
        return "redirect:/indexVideo";
    }

    @RequestMapping("/getVideo")
    public String getVideo(Integer id, HttpServletRequest request){
        VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
        request.setAttribute("videoInfo", videoInfo);
        return VIDEODETAILS;
    }

}
