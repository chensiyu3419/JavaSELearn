package com.javase.learn.domain;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 9005924357841690183L;
    private boolean success;

    private String resultMessage;

    private T Obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getObj() {
        return Obj;
    }

    public void setObj(T obj) {
        Obj = obj;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", resultMessage='" + resultMessage + '\'' +
                ", Obj=" + Obj +
                '}';
    }
}
