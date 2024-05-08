package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogStartup.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum NoAdReason {
    IS_MI_PHONE("当前设备是小米手机"),
    NOT_SIGN_IN("用户未登录"),
    NOT_REACH_COLD_START_INTERVAL("未达到冷启动间隔时长"),
    NOT_REACH_HOT_START_INTERVAL("未达到热启动间隔时长"),
    SERVER_NOT_RETURN_AD_DATA("服务端未返回广告"),
    NOT_REACH_SHOW_AD_CONDITION("广告列表中没有符合请求条件的广告"),
    AD_PRIVILEGE_TURN_ON("广告特权开启"),
    AD_REQUEST_SUCCESS_BUT_SHOW_TIMEOUT("广告请求成功，但是展示超时");


    @NotNull
    private final String value;

    NoAdReason(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
