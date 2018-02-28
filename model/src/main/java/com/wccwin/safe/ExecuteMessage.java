package com.wccwin.safe;

public class ExecuteMessage {

    private String success;
    private String error;


    public ExecuteMessage() {
    }

    public ExecuteMessage(String success, String error) {
        this.success = success;
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
