package com.android.internal.logging;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface UiEventLogger {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface UiEventEnum {
        public static final int RESERVE_NEW_UI_EVENT_ID = Integer.MIN_VALUE;

        int getId();
    }

    void log(UiEventEnum uiEventEnum);

    void log(UiEventEnum uiEventEnum, int i10, String str);

    void log(UiEventEnum uiEventEnum, InstanceId instanceId);

    void logWithInstanceId(UiEventEnum uiEventEnum, int i10, String str, InstanceId instanceId);

    void logWithInstanceIdAndPosition(UiEventEnum uiEventEnum, int i10, String str, InstanceId instanceId, int i11);

    void logWithPosition(UiEventEnum uiEventEnum, int i10, String str, int i11);
}
