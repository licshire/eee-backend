package club.zenyuca.core.util;

import club.zenyuca.core.beans.Result;

public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setData(null);
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }

    public static boolean isSeccess(Result result) {
        return result.getCode() == 0;
    }
}
