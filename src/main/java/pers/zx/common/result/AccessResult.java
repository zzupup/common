package pers.zx.common.result;

/**
 * @author zxupup
 * <p>Description: 统一返回结果类</p>
 * @date 2019/5/7 13:25
 */
public class AccessResult<T> {

    //状态码：200（OK 操作成功）、300（操作失败） 、401（Unauthorized 身份验证失败）、404（Not Found 找不到资源）、412（Precondition Failed 请求头中指定的一些前提条件失败）、500（Internal Server Error 服务器内部错误）……
    private Integer code;
    //提示信息，比如：“注册用户成功！”
    private String msg;
    //具体的内容
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public AccessResult() {

    }

    public AccessResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 此构造方法在全局异常处理器中用到
     *
     * @param code 异常的状态码，如：401（身份验证失败）、500（服务器内部错误）
     * @param msg  异常的提示信息
     */
    public AccessResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 系统内部异常
     *
     * @param msg 返回的提示信息
     */
    public void exception(String msg) {
        this.code = CodeEnum.SERVER_ERROR.getCode();
        this.msg = msg;
    }

    /**
     * 请求成功
     *
     * @param msg 返回的提示信息
     */
    public void success(String msg) {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = msg;
    }

    /**
     * 请求数据失败
     *
     * @param msg 返回的提示信息
     */
    public void fail(String msg) {
        this.code = CodeEnum.FAIL.getCode();
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
