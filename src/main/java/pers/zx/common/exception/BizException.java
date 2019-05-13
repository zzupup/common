package pers.zx.common.exception;

import pers.zx.common.result.CodeEnum;

/**
 * @author zxupup
 * <p>Description:  自定义业务异常基类，所有业务异常都必须继承于此异常 。
 * 注意要继承自RuntimeException，底层RuntimeException继承了Exception,
 * spring框架只对抛出的异常是RuntimeException才会进行事务回滚，
 * 如果是抛出的是Exception，是不会进行事务回滚的</p>
 * @date 2019/2/25 17:03
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -5875371379845226068L;

    /**
     * Token 验证不通过
     */
    public static final BizException UNAUTHORIZED = new BizException(CodeEnum.UNAUTHORIZED.getCode(), "用户信息过期，请重新登录");
    /**
     * 请求方式不被允许(错误)
     */
    public static final BizException METHOD_NOT_ALLOWED = new BizException(CodeEnum.METHOD_NOT_ALLOWED.getCode(), "请求方式错误");
    /**
     * 请求地址不存在
     */
    public static final BizException NOT_FOUND = new BizException(CodeEnum.NOT_FOUND.getCode(), "请求地址不存在");

    /**
     * 会话超时　获取session时，如果是空，throws 下面这个异常 拦截器会拦截爆会话超时页面
     */
    //public static final BizException SESSION_IS_OUT_TIME = new BizException(90040006, "会话超时");


    /**
     * 具体异常码
     */
    protected Integer code;
    /**
     * 异常信息
     */
    protected String msg;

    public BizException() {
        super();
    }

    public BizException(Integer code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }
}
