package com.google.android.exoplayer2.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.StringRes;

/* compiled from: NotificationUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t {
    public static void a(Context context, String str, @StringRes int i10, @StringRes int i11, int i12) {
        if (j0.f22990a >= 26) {
            NotificationManager notificationManager = (NotificationManager) a.e((NotificationManager) context.getSystemService("notification"));
            NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(i10), i12);
            if (i11 != 0) {
                notificationChannel.setDescription(context.getString(i11));
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
