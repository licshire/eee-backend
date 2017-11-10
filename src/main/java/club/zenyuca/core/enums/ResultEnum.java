package club.zenyuca.core.enums;

public enum ResultEnum {
    未知错误(-1, "未知错误"),
    成功(0, "成功"),
    用户名或密码错误(100, "用户名或密码错误")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
