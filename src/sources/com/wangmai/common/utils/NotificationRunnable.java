package com.wangmai.common.utils;

import androidx.core.app.NotificationManagerCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NotificationRunnable implements Runnable {
    public static final int NOTIFICATION_ID = 99;
    public static final String TAG = NotificationRunnable.class.getSimpleName();
    public final NotificationManagerCompat notificationManagerCompat;

    public NotificationRunnable(NotificationManagerCompat notificationManagerCompat) {
        this.notificationManagerCompat = notificationManagerCompat;
    }

    @Override // java.lang.Runnable
    public void run() {
        DebugLog.D(TAG, "取消通知");
        this.notificationManagerCompat.cancel(99);
    }
}
