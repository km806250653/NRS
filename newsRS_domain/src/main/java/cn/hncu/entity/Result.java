package cn.hncu.entity;

import java.io.Serializable;

/**
 * Created by Enzo Cotter on 2019/4/15.
 */
public class Result implements Serializable {
    private Boolean success;
    private String msg;

    public Result() {
    }

    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
