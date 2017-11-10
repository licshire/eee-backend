package club.zenyuca.core.exception;

import club.zenyuca.core.enums.ResultEnum;

public class EeeException extends RuntimeException {
    private Integer code;

    public EeeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
