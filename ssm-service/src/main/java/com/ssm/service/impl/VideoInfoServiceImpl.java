package com.ssm.service.impl;

import com.ssm.dao.VideoInfoMapper;
import com.ssm.entity.VideoInfo;
import com.ssm.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 2019/2/16 13:09
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Service
public class VideoInfoServiceImpl implements VideoInfoService {

    @Autowired
    private VideoInfoMapper videoInfoMapper;

    /**
     * 查询
     *
     * @param videoInfo
     * @return
     */
    @Override
    public List<VideoInfo> getVideoAll(VideoInfo videoInfo) {
        return videoInfoMapper.selectAll(videoInfo);
    }

    /**
     * 添加
     *
     * @param videoInfo
     * @return
     */
    @Override
    public int addVideo(VideoInfo videoInfo) {
        return videoInfoMapper.insert(videoInfo);
    }

    @Override
    public VideoInfo getVideoInfo(int id) {
        return videoInfoMapper.selectByPrimaryKey(id);
    }

}
