package pers.zx.common.result;

/**
 * @author zxupup
 * <p>Description: 响应状态码枚举类</p>
 * @date 2019/5/10 17:13
 */
public enum CodeEnum {
    SUCCESS(200),//操作成功
    FAIL(300),//操作失败
    UNAUTHORIZED(401),//身份验证失败（签名错误）
    NOT_FOUND(404),//找不到资源
    METHOD_NOT_ALLOWED(405),//请求中指定的方法不被允许
    PRECONDITION_FAILED(412),//请求头中指定的一些前提条件失败，例如请求参数错误或为空
    SERVER_ERROR(500); //服务器内部错误

    private Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
