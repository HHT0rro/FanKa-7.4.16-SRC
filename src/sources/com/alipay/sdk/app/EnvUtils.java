package com.alipay.sdk.app;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EnvUtils {
    private static EnvEnum mEnv = EnvEnum.ONLINE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static boolean isSandBox() {
        return mEnv == EnvEnum.SANDBOX;
    }

    public static void setEnv(EnvEnum envEnum) {
        mEnv = envEnum;
    }
}
