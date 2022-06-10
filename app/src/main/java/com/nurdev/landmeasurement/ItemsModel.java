package com.nurdev.landmeasurement;

import java.io.Serializable;

public class ItemsModel implements Serializable {
    private String name;
    private String icon;
    private String url,version,pid;

    public ItemsModel(String name, String icon,String url,String version, String pid) {
        this.name = name;
        this.icon = icon;
        this.url=url;
        this.version=version;
        this.pid=pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
