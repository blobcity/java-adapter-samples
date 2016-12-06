package com.blobcity.demo.interpreter;

import com.blobcity.db.Db;
import com.blobcity.db.annotations.Entity;
import com.blobcity.db.annotations.Primary;

/**
 * Database entity representing a single apache log entry
 */
@Entity(ds = "demo", collection = "Logs")
public class Logs extends Db {
    @Primary
    private String _id;
    private String ip;
    private String client;
    private String user;
    private String time;
    private String method;
    private String request;
    private String protocol;
    private String resp_code;
    private int size;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getResp_code() {
        return resp_code;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
