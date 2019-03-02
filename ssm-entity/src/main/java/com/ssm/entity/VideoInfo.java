package com.ssm.entity;

public class VideoInfo {
    private Integer id;

    private String videoName;

    private String videoUrl;

    private String videoHtml;

    private Integer videoTypeId;

    private Integer videoDel;

    private String typeName;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoHtml() {
        return videoHtml;
    }

    public void setVideoHtml(String videoHtml) {
        this.videoHtml = videoHtml == null ? null : videoHtml.trim();
    }

    public Integer getVideoTypeId() {
        return videoTypeId;
    }

    public void setVideoTypeId(Integer videoTypeId) {
        this.videoTypeId = videoTypeId;
    }

    public Integer getVideoDel() {
        return videoDel;
    }

    public void setVideoDel(Integer videoDel) {
    	if(videoDel==null){
    		videoDel=0;
    	}
        this.videoDel = videoDel;
    }

	public String getTypeName() {
	
		return typeName;
	}

	public void setTypeName(String typeName) {
	
		this.typeName = typeName;
	}

}