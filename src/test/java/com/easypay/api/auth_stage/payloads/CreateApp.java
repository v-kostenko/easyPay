package com.easypay.api.auth_stage.payloads;

public class CreateApp {
    private String logoPath;
    private String hintImagesPath;
    private String apiVersion;
    private String appId;
    private String pageId;
    private String requestedSessionId;
    private Object error;

    public CreateApp(){

    }

    public CreateApp(String logoPath, String hintImagesPath, String apiVersion, String appId, String pageId, String requestedSessionId, Object error) {
        this.logoPath = logoPath;
        this.hintImagesPath = hintImagesPath;
        this.apiVersion = apiVersion;
        this.appId = appId;
        this.pageId = pageId;
        this.requestedSessionId = requestedSessionId;
        this.error = error;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getHintImagesPath() {
        return hintImagesPath;
    }

    public void setHintImagesPath(String hintImagesPath) {
        this.hintImagesPath = hintImagesPath;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getRequestedSessionId() {
        return requestedSessionId;
    }

    public void setRequestedSessionId(String requestedSessionId) {
        this.requestedSessionId = requestedSessionId;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CreateApp{" +
                "logoPath='" + logoPath + '\'' +
                ", hintImagesPath='" + hintImagesPath + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                ", appId='" + appId + '\'' +
                ", pageId='" + pageId + '\'' +
                ", requestedSessionId='" + requestedSessionId + '\'' +
                ", error=" + error +
                '}';
    }
}
