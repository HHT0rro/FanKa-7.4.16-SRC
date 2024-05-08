package com.cupidapp.live.liveshow.beauty.databeauty.license;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface EffectLicenseProvider {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LICENSE_MODE_ENUM {
        OFFLINE_LICENSE,
        ONLINE_LICENSE
    }

    String a();

    boolean b(String str);

    String c();

    int d();

    LICENSE_MODE_ENUM e();
}
