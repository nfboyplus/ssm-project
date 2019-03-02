package com.ssm.service;

import com.ssm.entity.VideoInfo;

import java.util.List;

/**
 * created on 2019/2/16 13:08
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public interface VideoInfoService {

    public List<VideoInfo> getVideoAll(VideoInfo videoInfo);

    public int addVideo(VideoInfo videoInfo);

    public VideoInfo getVideoInfo(int id);
}
