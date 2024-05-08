package com.android.internal.os;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ZygoteConfigSocExtImpl implements IZygoteConfigSocExt {
    private static volatile ZygoteConfigSocExtImpl sInstance;

    public ZygoteConfigSocExtImpl(Object base) {
    }

    public static ZygoteConfigSocExtImpl getInstance(Object base) {
        if (sInstance == null) {
            synchronized (ZygoteConfigSocExtImpl.class) {
                if (sInstance == null) {
                    sInstance = new ZygoteConfigSocExtImpl(base);
                }
            }
        }
        return sInstance;
    }
}
