package com.cupidapp.live.push.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.RequiresApi;
import com.cupidapp.live.R$string;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PushChannelUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f17904a = new c();

    @RequiresApi(26)
    public final void a(@NotNull NotificationManager notificationManager, @NotNull Context context) {
        s.i(notificationManager, "<this>");
        s.i(context, "context");
        e(notificationManager, context);
        f(notificationManager, context);
        c(notificationManager, context);
        d(notificationManager, context);
        b(notificationManager, context);
        g(notificationManager, context);
    }

    @RequiresApi(26)
    public final void b(NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("push_channel_free", context.getResources().getString(R$string.push_channel_free), 2);
        notificationChannel.enableVibration(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @RequiresApi(26)
    public final void c(NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("push_channel_interaction", context.getResources().getString(R$string.push_channel_interaction), 3);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{0, 200, 200, 200});
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @RequiresApi(26)
    public final void d(NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("push_channel_live", context.getResources().getString(R$string.push_channel_live), 3);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{0, 200, 200, 200});
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @RequiresApi(26)
    public final void e(NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("push_channel_message", context.getResources().getString(R$string.push_channel_message), 4);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{0, 200, 200, 200});
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @RequiresApi(26)
    public final void f(NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("push_channel_relationship", context.getResources().getString(R$string.push_channel_relationship), 4);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{0, 200, 200, 200});
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @RequiresApi(26)
    public final void g(NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("push_channel_system", context.getResources().getString(R$string.push_channel_system), 1);
        notificationChannel.enableVibration(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }
}
