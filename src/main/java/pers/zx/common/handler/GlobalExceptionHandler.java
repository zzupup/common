package pers.zx.common.handler;

import pers.zx.common.exception.BizException;
import pers.zx.common.result.AccessResult;
import pers.zx.common.result.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author zxupup
 * <p>Description:  全局异常处理器</p>
 * @date 2019/2/25 17:03
 */
@RestControllerAdvice//该注解注释全局异常处理器，不指定包默认加了@Controller和@RestController都能控制
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//声明要捕获的异常类
    public AccessResult handle(Exception e) {
        e.printStackTrace();//打印异常信息
        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            return new AccessResult(bizException.getCode(), bizException.getMsg());
        } else {
            return new AccessResult(CodeEnum.SERVER_ERROR.getCode(),"系统错误");
        }
    }
}
