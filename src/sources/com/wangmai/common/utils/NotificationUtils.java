package com.wangmai.common.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NotificationUtils {
    public static final String TAG = "NotificationUtils";
    public static volatile NotificationUtils notificationUtils;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ICallback {
        void doOperation();
    }

    public static String buildNotificationChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("com.wm.ad.sdk.lib", "com.wm.ad.sdk.lib", 4);
        notificationChannel.enableLights(false);
        notificationChannel.setShowBadge(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        notificationManager.createNotificationChannel(notificationChannel);
        return notificationChannel.getId();
    }

    public static NotificationCompat.Builder buildNotificationCompat(Context context) {
        NotificationCompat.Builder builder;
        DebugLog.D(TAG, "buildNotificationCompat");
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new NotificationCompat.Builder(context, buildNotificationChannel(context));
        } else {
            builder = new NotificationCompat.Builder(context, (String) null);
        }
        builder.setContentTitle("手机优化中");
        builder.setContentText("正在优化您的手机");
        builder.setSmallIcon(context.getApplicationInfo().icon);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        builder.setAutoCancel(true);
        builder.setDefaults(4);
        builder.setPriority(-1);
        return builder;
    }

    public static NotificationUtils getInstance() {
        if (notificationUtils == null) {
            synchronized (NotificationUtils.class) {
                if (notificationUtils == null) {
                    notificationUtils = new NotificationUtils();
                }
            }
        }
        return notificationUtils;
    }

    public void buildNotification(Context context, Intent intent, ICallback iCallback) {
        NotificationCompat.Builder buildNotificationCompat = buildNotificationCompat(context);
        buildNotificationCompat.setFullScreenIntent(PendingIntent.getActivity(context, 0, intent, 134217728), true);
        NotificationManagerCompat from = NotificationManagerCompat.from(context);
        from.cancel(99);
        if (iCallback != null) {
            iCallback.doOperation();
        }
        from.notify(99, buildNotificationCompat.build());
        ThreadUtils.mMainHandler.postDelayed(new NotificationRunnable(from), 1000L);
    }
}
