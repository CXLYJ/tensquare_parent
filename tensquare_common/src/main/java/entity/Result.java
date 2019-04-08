package entity;

/**
 * Created by lyj on 2019/1/18.
 */
public class Result {

    private boolean flag; //是否成功
    private Integer code; //返回状态码
    private String message; //返回信息
    private Object date; //返回数据

    public  Result(){}

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object date) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
