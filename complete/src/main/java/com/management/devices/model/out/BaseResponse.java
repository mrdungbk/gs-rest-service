package com.management.devices.model.out;
import com.management.devices.common.enums.ResponseCode;
import java.io.Serializable;

public class BaseResponse implements Serializable {
    private boolean result;
    private String transNo;
    private String Code;
    private String description;
    private Object data;

    public BaseResponse() {
        result = false;
        Code = "999";
        description = "It is default code!";
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        this.Code = code;
        if (ResponseCode.SUCCESS.code.equals(code)) {
            this.result = Boolean.TRUE;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("result=");
        sb.append(result);
        sb.append(", Code='").append(Code).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", transNo='").append(transNo).append('\'');
        return sb.toString();
    }
}
