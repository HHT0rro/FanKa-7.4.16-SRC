package com.kwad.sdk.core.network;

import com.mobile.auth.gatewayauth.ResultCode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public final int errorCode;
    public final String msg;
    public static e avt = new e(-1, "请求超时事件");
    public static e avu = new e(-2, "请求异常");
    public static e avv = new e(-1000, "该业务组件未加载");
    public static e avw = new e(40001, ResultCode.MSG_ERROR_NETWORK);
    public static e avx = new e(40002, "数据解析错误");
    public static e avy = new e(40003, "数据为空");
    public static e avz = new e(40004, "视频资源缓存失败");
    public static e avA = new e(40005, "网络超时");
    public static e avB = new e(40007, "图片下载失败");
    public static e avC = new e(40008, "广告场景不匹配");
    public static e avD = new e(40009, "广告加载异常");
    public static e avE = new e(40010, "activity场景不匹配");
    public static e avF = new e(40011, "sdk初始化失败");
    public static e avG = new e(40012, "权限未开启");
    public static e avH = new e(100006, "更多视频请前往快手App查看");
    public static e avI = new e(100007, "复制链接失败，请稍后重试");
    public static e avJ = new e(100008, "内容有点敏感，不可以发送哦");
    public static e avK = new e(130001, "数据不存在");
    public static e avL = new e(0, "网络超时");

    private e(int i10, String str) {
        this.errorCode = i10;
        this.msg = str;
    }
}
