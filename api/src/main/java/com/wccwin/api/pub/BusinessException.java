package com.wccwin.api.pub;

/**
 * 业务逻辑异常
 */
public class BusinessException extends Exception {

    private int status;//对应classpath下的exception.properties

    private BusinessException(String msg){
        super(msg);
    }

    /**
     * 异常构建方法
     * @param status
     * @return
     */
    public static BusinessException error(int status){
        String msg = ErrorMsgConfig.getErrorMsg(status);
        BusinessException exception = new BusinessException(msg);
        exception.setStatus(status);
        return exception;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}





