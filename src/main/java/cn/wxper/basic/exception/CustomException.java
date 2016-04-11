package cn.wxper.basic.exception;

/**
 * Created by basic on 2016/4/11.
 */
public class CustomException extends Exception{

    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
