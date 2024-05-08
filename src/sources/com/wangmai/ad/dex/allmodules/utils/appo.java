package com.wangmai.ad.dex.allmodules.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.wangmai.common.utils.NotificationUtils;
import com.wangmai.common.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: NotificationUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appo {
    public static void appa(Context context, int i10, String str, String str2, String str3) {
        Notification.Builder builder;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.cancel(i10);
        PendingIntent activity = PendingIntent.getActivity(context, (int) SystemClock.uptimeMillis(), appd.appb(context, str), 134217728);
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, NotificationUtils.TAG);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle(str2).setContentText(str3).setContentIntent(activity).setSmallIcon(context.getApplicationInfo().icon).setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(NotificationUtils.TAG, "下载完成通知", 3));
        }
        try {
            notificationManager.notify(i10, builder.build());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(NotificationUtils.TAG, "downloaded notify exception：" + th.toString());
        }
    }

    public static void appa(Context context, int i10, String str, String str2) {
        Notification.Builder builder;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.cancel(i10);
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, NotificationUtils.TAG);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle(str).setContentText(str2).setSmallIcon(context.getApplicationInfo().icon);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(NotificationUtils.TAG, "下载失败通知", 3));
        }
        try {
            notificationManager.notify(i10, builder.build());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(NotificationUtils.TAG, "download failed notify exception：" + th.toString());
        }
    }

    public static void appa(Context context, int i10, int i11, int i12, String str, String str2) {
        Notification.Builder builder;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (i11 != i12) {
                if (Build.VERSION.SDK_INT >= 26) {
                    builder = new Notification.Builder(context, NotificationUtils.TAG);
                } else {
                    builder = new Notification.Builder(context);
                }
                builder.setContentTitle(str).setContentText(str2).setSmallIcon(context.getApplicationInfo().icon).setProgress(i12, i11, false);
                if (Build.VERSION.SDK_INT >= 26) {
                    notificationManager.createNotificationChannel(new NotificationChannel(NotificationUtils.TAG, "下载中通知", 2));
                }
                try {
                    notificationManager.notify(i10, builder.build());
                    return;
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(NotificationUtils.TAG, "downloading notify exception：" + th.toString());
                    return;
                }
            }
            notificationManager.cancel(i10);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe(NotificationUtils.TAG, "downloadingNotify error:" + th2.toString());
        }
    }

    public static int appa(String str) {
        int appa2 = appa(Utils.md5Decode(str).getBytes());
        appa.appa.appf.appd.appa("createNotificationId", Integer.valueOf(appa2));
        return appa2;
    }

    public static int appa(byte[] bArr) {
        try {
            return new DataInputStream(new ByteArrayInputStream(bArr)).readInt();
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
