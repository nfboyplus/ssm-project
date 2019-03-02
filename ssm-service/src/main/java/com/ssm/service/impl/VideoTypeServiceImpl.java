package com.ssm.service.impl;

import com.ssm.dao.VideoTypeMapper;
import com.ssm.entity.VideoType;
import com.ssm.service.VideoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 2019/2/15 15:40
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Service
public class VideoTypeServiceImpl implements VideoTypeService {

    @Autowired
    private VideoTypeMapper videoTypeMapper;

    @Override
    public List<VideoType> getVideoType(VideoType videoType) {
        return videoTypeMapper.selectList(videoType);
    }
}
