package com.ccqstark.smalluser.common;

/**
 * @author ccqstark
 * @description API错误码枚举
 * @date 2021/1/12 10:04 下午
 */
public enum ResultCode implements IErrorCode {

    SUCCESS("00000", "操作成功"),
    UNAUTHORIZED("A0311", "暂未登录或登录已经过期"),
    FORBIDDEN("A0312", "没有相关权限"),
    LOGIN_FAILED("A0210", "账号或密码错误"),
    ROLE_ERROR("A0210","身份选择错误"),
    EMAIL_CODE_ERROR("A0132", "邮箱验证码错误"),
    PARAMETER_LACK("A0410", "字段填写不完整"),
    FILE_TYPE_ERROR("A0701", "文件类型不匹配"),
    FILE_TOO_BIG("A0702", "文件大小超出限制"),
    FAILED("B0001", "请求失败"),
    EMAIL_SENT_FAILED("C0503", "邮件发送失败"),
    TPL_NOT_FOUND("QP404","暂未创建简历模版"),
    RESUME_NOT_FOUND("QR404","暂未提交报名表"),
    NOTICE_NOT_FOUND("QN404", "暂未创建面试公告");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
