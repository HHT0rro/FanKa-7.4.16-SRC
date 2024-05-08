package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IExposer {
    public static final String SDK_DEFAULT = "0";
    public static final String SDK_MMA = "1";

    void onExpose(String str, String str2, ExposeCallback exposeCallback);
}
