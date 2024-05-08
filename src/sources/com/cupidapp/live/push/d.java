package com.cupidapp.live.push;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.utils.j;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FKPushNotificationManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f17893b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f17894c;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17892a = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final HashSet<String> f17895d = new HashSet<>();

    /* compiled from: FKPushNotificationManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            Object systemService = AppApplication.f11612d.h().getSystemService("notification");
            NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
            if (notificationManager != null) {
                notificationManager.cancelAll();
            }
        }

        public final void b(@NotNull FKPushType type) {
            s.i(type, "type");
            Object systemService = AppApplication.f11612d.h().getSystemService("notification");
            s.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).cancel(type.notifyId());
        }

        public final void c(@NotNull Context context) {
            s.i(context, "context");
            if (Build.VERSION.SDK_INT >= 26) {
                Object systemService = context.getSystemService("notification");
                s.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                notificationManager.deleteNotificationChannel("notify_finka_channel_001");
                com.cupidapp.live.push.util.c.f17904a.a(notificationManager, context);
            }
        }

        @Nullable
        public final String d(@NotNull FKPushMessageModel pushModel) {
            Map<String, String> hwPushCategory;
            s.i(pushModel, "pushModel");
            ConstantsResult q10 = g.f52734a.q();
            String str = (q10 == null || (hwPushCategory = q10.getHwPushCategory()) == null) ? null : hwPushCategory.get(pushModel.getPushMessageType());
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case -1334615602:
                    if (str.equals("CATEGORY_SOCIAL")) {
                        return NotificationCompat.CATEGORY_SOCIAL;
                    }
                    return null;
                case -1330046381:
                    if (str.equals("CATEGORY_STATUS")) {
                        return "status";
                    }
                    return null;
                case -1324893040:
                    if (str.equals("CATEGORY_SYSTEM")) {
                        return NotificationCompat.CATEGORY_SYSTEM;
                    }
                    return null;
                case -1304065766:
                    if (str.equals("CATEGORY_RECOMMENDATION")) {
                        return NotificationCompat.CATEGORY_RECOMMENDATION;
                    }
                    return null;
                case -810816257:
                    if (str.equals("CATEGORY_CALL")) {
                        return "call";
                    }
                    return null;
                case -594086834:
                    if (str.equals("CATEGORY_PROGRESS")) {
                        return "progress";
                    }
                    return null;
                case -111611245:
                    if (str.equals("CATEGORY_REMINDER")) {
                        return NotificationCompat.CATEGORY_REMINDER;
                    }
                    return null;
                case 275317158:
                    if (str.equals("CATEGORY_MESSAGE")) {
                        return "msg";
                    }
                    return null;
                case 632970160:
                    if (str.equals("CATEGORY_ALARM")) {
                        return NotificationCompat.CATEGORY_ALARM;
                    }
                    return null;
                case 636693755:
                    if (str.equals("CATEGORY_EMAIL")) {
                        return "email";
                    }
                    return null;
                case 636859239:
                    if (str.equals("CATEGORY_ERROR")) {
                        return NotificationCompat.CATEGORY_ERROR;
                    }
                    return null;
                case 636965881:
                    if (str.equals("CATEGORY_EVENT")) {
                        return "event";
                    }
                    return null;
                case 647015022:
                    if (str.equals("CATEGORY_PROMO")) {
                        return NotificationCompat.CATEGORY_PROMO;
                    }
                    return null;
                case 784795912:
                    if (str.equals("CATEGORY_TRANSPORT")) {
                        return NotificationCompat.CATEGORY_TRANSPORT;
                    }
                    return null;
                case 845562940:
                    if (str.equals("CATEGORY_WORKOUT")) {
                        return NotificationCompat.CATEGORY_WORKOUT;
                    }
                    return null;
                case 1304545364:
                    if (str.equals("CATEGORY_SERVICE")) {
                        return "service";
                    }
                    return null;
                case 1383563244:
                    if (str.equals("CATEGORY_STOPWATCH")) {
                        return NotificationCompat.CATEGORY_STOPWATCH;
                    }
                    return null;
                case 1781645139:
                    if (str.equals("CATEGORY_LOCATION_SHARING")) {
                        return NotificationCompat.CATEGORY_LOCATION_SHARING;
                    }
                    return null;
                case 1817295809:
                    if (str.equals("CATEGORY_MISSED_CALL")) {
                        return NotificationCompat.CATEGORY_MISSED_CALL;
                    }
                    return null;
                case 2139370485:
                    if (str.equals("CATEGORY_NAVIGATION")) {
                        return NotificationCompat.CATEGORY_NAVIGATION;
                    }
                    return null;
                default:
                    return null;
            }
        }

        public final boolean e() {
            return d.f17894c;
        }

        public final boolean f() {
            return d.f17893b;
        }

        @NotNull
        public final HashSet<String> g() {
            return d.f17895d;
        }

        public final void h(@NotNull Activity activity, @Nullable FKPushMessageModel fKPushMessageModel) {
            s.i(activity, "activity");
            if (fKPushMessageModel == null) {
                return;
            }
            BindPushTokenUtilKt.f(activity, fKPushMessageModel);
        }

        public final void i(boolean z10) {
            m3.d dVar = m3.d.f51803a;
            Context applicationContext = AppApplication.f11612d.h().getApplicationContext();
            s.h(applicationContext, "AppApplication.shareInstance.applicationContext");
            dVar.i(applicationContext, z10);
            d.f17894c = z10;
        }

        public final void j(boolean z10) {
            m3.d dVar = m3.d.f51803a;
            Context applicationContext = AppApplication.f11612d.h().getApplicationContext();
            s.h(applicationContext, "AppApplication.shareInstance.applicationContext");
            dVar.i(applicationContext, z10);
            d.f17893b = z10;
        }

        public final void k(@NotNull Context context, @NotNull FKPushMessageModel pushModel) {
            s.i(context, "context");
            s.i(pushModel, "pushModel");
            if (f()) {
                return;
            }
            if (pushModel.getNotifyId() == FKPushType.InboxMessageNew.notifyId() && e()) {
                return;
            }
            String channel = pushModel.getChannel();
            if (channel == null) {
                channel = "push_channel_message";
            }
            Intent intent = new Intent(context, (Class<?>) PushNotificationActivity.class);
            intent.putExtra("pushModel", pushModel);
            PendingIntent activity = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 134217728);
            Object systemService = context.getSystemService("notification");
            s.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            boolean z10 = false;
            NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, channel).setContentText(pushModel.getContent()).setPriority(0).setContentTitle(pushModel.getTitle()).setSmallIcon(R$mipmap.ic_launcher).setContentIntent(activity).setAutoCancel(true);
            s.h(autoCancel, "Builder(context, channel…     .setAutoCancel(true)");
            String d10 = d(pushModel);
            j.f12332a.a("FKPushNotificationManager", "triggerPushNotification category:" + d10);
            if (d10 != null) {
                if (d10.length() > 0) {
                    z10 = true;
                }
            }
            if (z10) {
                autoCancel.setCategory(d10);
            }
            Notification build = autoCancel.build();
            s.h(build, "notificationBuilder.build()");
            if (Build.VERSION.SDK_INT < 26) {
                com.cupidapp.live.push.util.d dVar = com.cupidapp.live.push.util.d.f17905a;
                dVar.a(context, pushModel.getLocalSound(), pushModel.getSoundEnable(), null);
                dVar.b(context, pushModel.getVibrate());
            }
            notificationManager.notify(pushModel.getNotifyId(), build);
        }
    }
}
