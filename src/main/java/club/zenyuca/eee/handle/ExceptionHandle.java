package club.zenyuca.eee.handle;

import club.zenyuca.core.beans.Result;
import club.zenyuca.core.enums.ResultEnum;
import club.zenyuca.core.exception.EeeException;
import club.zenyuca.core.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof EeeException) {
            EeeException girlException = (EeeException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("[异常信息] = {}", e.getMessage());
            return ResultUtil.error(ResultEnum.未知错误.getCode(), ResultEnum.未知错误.getMsg());
        }
    }
}
