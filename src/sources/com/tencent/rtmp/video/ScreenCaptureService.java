package com.tencent.rtmp.video;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ScreenCaptureService extends Service {
    private static final String CHANNEL_ID = "notification_id";
    private static final int NOTIFICATION_ID = 13957237;
    private static final String TAG = "ScreenCaptureService";

    private Notification createNotification() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel(CHANNEL_ID, "notification_name", 2));
        }
        Notification.Builder defaults = new Notification.Builder(this).setDefaults(1);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            defaults.setChannelId(CHANNEL_ID);
        }
        return defaults.build();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        LiteavLog.i(TAG, "Service on bind");
        try {
            startForeground(NOTIFICATION_ID, createNotification());
        } catch (Throwable th) {
            LiteavLog.e(TAG, "start foreground failed.", th);
        }
        return new Binder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LiteavLog.i(TAG, "Service on unbind");
        stopForeground(true);
        return super.onUnbind(intent);
    }
}
