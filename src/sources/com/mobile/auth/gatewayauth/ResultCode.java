package com.mobile.auth.gatewayauth;

import com.mobile.auth.gatewayauth.annotations.AuthNumber;

@AuthNumber
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ResultCode {
    public static final String CODE_AUTHPAGE_ON_RESULT = "600022";
    public static final String CODE_AUTH_PRIVACY_CLOSE = "700007";
    public static final String CODE_BI_LIFE_BODY_VERIFY_READY_STARTING = "700005";
    public static final String CODE_CLICK_AUTH_PRIVACY_CONFIRM = "700008";
    public static final String CODE_CLICK_AUTH_PRIVACY_WEBURL = "700009";
    public static final String CODE_ERROR_ANALYZE_SDK_BLACKLIST = "600018";
    public static final String CODE_ERROR_ANALYZE_SDK_INFO = "600017";
    public static final String CODE_ERROR_CALL_PRE_LOGIN_IN_AUTH_PAGE = "600026";
    public static final String CODE_ERROR_CLIENT_TIMESTAMP = "600032";

    @Deprecated
    public static final String CODE_ERROR_ENV_CHECK_FAIL = "600025";
    public static final String CODE_ERROR_ENV_CHECK_SUCCESS = "600024";
    public static final String CODE_ERROR_FEATURE_INVALID = "600033";
    public static final String CODE_ERROR_FUNCTION_DEMOTE = "600013";
    public static final String CODE_ERROR_FUNCTION_LIMIT = "600014";
    public static final String CODE_ERROR_FUNCTION_TIME_OUT = "600015";
    public static final String CODE_ERROR_GET_CONFIG_FAIL = "600004";
    public static final String CODE_ERROR_INVALID_PARAM = "600025";
    public static final String CODE_ERROR_LOAD_CUSTOM_VIEWS = "600023";
    public static final String CODE_ERROR_NETWORK = "600031";
    public static final String CODE_ERROR_NET_SIM_CHANGE = "600021";
    public static final String CODE_ERROR_NO_MOBILE_NETWORK_FAIL = "600008";
    public static final String CODE_ERROR_NO_PERMISSION_FAIL = "600006";
    public static final String CODE_ERROR_NO_SIM_FAIL = "600007";
    public static final String CODE_ERROR_OPERATOR_UNKNOWN_FAIL = "600009";
    public static final String CODE_ERROR_OUT_OF_SERVICE = "600036";
    public static final String CODE_ERROR_PHONE_UNSAFE_FAIL = "600005";
    public static final String CODE_ERROR_SDK_INFO_INVALID = "600034";
    public static final String CODE_ERROR_START_AUTHPAGE_FAIL = "600002";
    public static final String CODE_ERROR_STAT_BUSY = "600035";
    public static final String CODE_ERROR_UNKNOWN_FAIL = "600010";
    public static final String CODE_ERROR_USER_CANCEL = "700000";
    public static final String CODE_ERROR_USER_CHECKBOX = "700003";
    public static final String CODE_ERROR_USER_CONTROL_CANCEL_BYBTN = "700010";
    public static final String CODE_ERROR_USER_CONTROL_CANCEL_BYKEY = "700011";
    public static final String CODE_ERROR_USER_LOGIN_BTN = "700002";
    public static final String CODE_ERROR_USER_PROTOCOL_CONTROL = "700004";
    public static final String CODE_ERROR_USER_SWITCH = "700001";
    public static final String CODE_FAILED = "600030";
    public static final String CODE_GET_MASK_FAIL = "600012";
    public static final String CODE_GET_TOKEN_FAIL = "600011";

    @Deprecated
    public static final String CODE_GET_TOKEN_SUCCESS = "600000";
    public static final String CODE_INNER_TOP_REQUEST_FAILED = "300001";
    public static final String CODE_START_AUTHPAGE_SUCCESS = "600001";
    public static final String CODE_START_AUTH_PRIVACY = "700006";
    public static final String CODE_SUCCESS = "600000";
    public static final String CUCC_CODE_ERROR = "1";
    public static final String CUCC_MSG_ERROR_MOBILE_ERROR = "移动网络未开启";
    public static final String CUCC_MSG_ERROR_NET_ERROR = "获取鉴权信息失败";
    public static final String CUCC_MSG_ERROR_TIME_OUT = "请求超时";
    public static final String MSG_AUTHPAGE_ON_RESULT = "授权页收到onActivityResult";
    public static final String MSG_AUTH_PRIVACY_CLOSE = "隐私协议二次弹窗关闭";
    public static final String MSG_BI_LIFE_BODY_VERIFY_READY_STARTING = "活体认证页面准备启动";

    @Deprecated
    public static final String MSG_CHECK_ENV_PARAM_ERROR = "终端检测参数错误";
    public static final String MSG_CLICK_AUTH_PRIVACY_CONFIRM = "隐私协议二次弹窗同意并继续";
    public static final String MSG_CLICK_AUTH_PRIVACY_WEBURL = "隐私协议二次弹窗点击协议富文本文字";
    public static final String MSG_ERROR_ANALYZE_SDK_BLACKLIST_INFO = "当前号码已被运营商管控，暂时无法使用该功能，请尝试其他方式";
    public static final String MSG_ERROR_ANALYZE_SDK_INFO = "AppID Secret解析失败";
    public static final String MSG_ERROR_CALL_PRE_LOGIN_IN_AUTH_PAGE = "授权页已加载时不允许调用加速或预取号接口";
    public static final String MSG_ERROR_CLIENT_TIMESTAMP = "客户端设备时间错误";
    public static final String MSG_ERROR_ENV_CHECK_SUCCESS = "终端支持认证";
    public static final String MSG_ERROR_FEATURE_INVALID = "功能未开通";
    public static final String MSG_ERROR_FUNCTION_DEMOTE = "系统维护，功能不可用";
    public static final String MSG_ERROR_FUNCTION_LIMIT = "该功能已达最大调用次数";
    public static final String MSG_ERROR_FUNCTION_TIME_OUT = "请求超时";
    public static final String MSG_ERROR_GET_CONFIG_FAIL = "获取运营商配置信息失败";
    public static final String MSG_ERROR_INVALID_PARAM = "参数错误";
    public static final String MSG_ERROR_LOAD_CUSTOM_VIEWS = "加载自定义控件异常";
    public static final String MSG_ERROR_NETWORK = "网络错误";
    public static final String MSG_ERROR_NET_SIM_CHANGE = "用户已切换上网卡";
    public static final String MSG_ERROR_NO_MOBILE_NETWORK_FAIL = "蜂窝网络未开启";
    public static final String MSG_ERROR_NO_PERMISSION_FAIL = "read phone state 权限未授权";
    public static final String MSG_ERROR_NO_SIM_FAIL = "SIM卡无法检测";
    public static final String MSG_ERROR_OPERATOR_UNKNOWN_FAIL = "无法判运营商";
    public static final String MSG_ERROR_OUT_OF_SERVICE = "业务停机";
    public static final String MSG_ERROR_PHONE_UNSAFE_FAIL = "手机终端不安全";
    public static final String MSG_ERROR_SDK_INFO_INVALID = "不合法的SDK密钥";
    public static final String MSG_ERROR_START_AUTHPAGE_FAIL = "唤起授权页失败";
    public static final String MSG_ERROR_STAT_BUSY = "状态繁忙";
    public static final String MSG_ERROR_UNKNOWN_FAIL = "未知异常";
    public static final String MSG_ERROR_USER_CANCEL = "用户取消操作";
    public static final String MSG_ERROR_USER_CHECKBOX = "点击check box事件";
    public static final String MSG_ERROR_USER_CONTROL_CANCEL_BYBTN = "用户自己控制取消操作";
    public static final String MSG_ERROR_USER_CONTROL_CANCEL_BYKEY = "用户自己控制取消操作";
    public static final String MSG_ERROR_USER_LOGIN_BTN_NO_CHECK = "点击登录按钮事件";
    public static final String MSG_ERROR_USER_PROTOCOL_CONTROL = "点击协议富文本文字事件";
    public static final String MSG_ERROR_USER_SWITCH = "用户切换其他登录方式";
    public static final String MSG_FAILED = "失败";
    public static final String MSG_GET_MASK_FAIL = "预取号失败";
    public static final String MSG_GET_TOKEN_FAIL = "获取token失败";

    @Deprecated
    public static final String MSG_GET_TOKEN_SUCCESS = "获取token成功";
    public static final String MSG_INNER_TOP_REQUEST_FAILED = "网关请求失败";
    public static final String MSG_START_AUTHPAGE_SUCCESS = "唤起授权页成功";
    public static final String MSG_START_AUTH_PRIVACY = "点击一键登录拉起授权页二次弹窗";
    public static final String MSG_SUCCESS = "成功";
}
