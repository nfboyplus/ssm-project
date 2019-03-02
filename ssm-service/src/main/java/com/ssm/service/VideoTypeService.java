package com.ssm.service;

import com.ssm.entity.VideoType;

import java.util.List;

/**
 * created on 2019/2/15 15:39
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public interface VideoTypeService {

    public List<VideoType> getVideoType(VideoType videoType);
}
