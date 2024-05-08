package com.alipay.sdk.app;

import com.mobile.auth.gatewayauth.ResultCode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum k {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, ResultCode.MSG_ERROR_INVALID_PARAM),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");


    /* renamed from: h, reason: collision with root package name */
    private int f4425h;

    /* renamed from: i, reason: collision with root package name */
    private String f4426i;

    k(int i10, String str) {
        this.f4425h = i10;
        this.f4426i = str;
    }

    public void a(int i10) {
        this.f4425h = i10;
    }

    public String b() {
        return this.f4426i;
    }

    public static k b(int i10) {
        if (i10 == 4001) {
            return PARAMS_ERROR;
        }
        if (i10 == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i10 == 8000) {
            return PAY_WAITTING;
        }
        if (i10 == 9000) {
            return SUCCEEDED;
        }
        if (i10 == 6001) {
            return CANCELED;
        }
        if (i10 != 6002) {
            return FAILED;
        }
        return NETWORK_ERROR;
    }

    public int a() {
        return this.f4425h;
    }

    public void a(String str) {
        this.f4426i = str;
    }
}
