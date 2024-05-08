package com.android.internal.policy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KeyInterceptionInfo {
    public final int layoutParamsPrivateFlags;
    public final int layoutParamsType;
    public final String windowTitle;

    public KeyInterceptionInfo(int type, int flags, String title) {
        this.layoutParamsType = type;
        this.layoutParamsPrivateFlags = flags;
        this.windowTitle = title;
    }
}
