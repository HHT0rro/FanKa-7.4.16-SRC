package com.cupidapp.live.base.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemPushSetting.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12373a = new a(null);

    /* compiled from: SystemPushSetting.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            kotlin.jvm.internal.s.h(from, "from(context)");
            try {
                return from.areNotificationsEnabled();
            } catch (Exception unused) {
                return false;
            }
        }

        @NotNull
        public final PushPermissionType b(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            if (a(context)) {
                return PushPermissionType.On;
            }
            return PushPermissionType.Off;
        }

        public final void c(@Nullable Context context) {
            if (context == null) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                    intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
                    context.startActivity(intent);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent2.putExtra("app_package", context.getPackageName());
                    intent2.putExtra("app_uid", context.getApplicationInfo().uid);
                    context.startActivity(intent2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                z0.h.o(context);
            }
        }
    }
}
