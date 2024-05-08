package com.huawei.hms.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: PushNotification.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static int f30421a;

    public static synchronized void a(Context context, o oVar) {
        int hashCode;
        int i10;
        int i11;
        int hashCode2;
        synchronized (n.class) {
            if (context != null) {
                if (!a(oVar)) {
                    HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + oVar.o());
                    if (f30421a == 0) {
                        f30421a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(oVar.k())) {
                        String p10 = oVar.p();
                        if (!TextUtils.isEmpty(p10)) {
                            int hashCode3 = p10.hashCode();
                            oVar.a(hashCode3);
                            HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (oVar.r() != -1) {
                            hashCode = oVar.r();
                            i10 = (oVar.j() + System.currentTimeMillis()).hashCode();
                            i11 = i10 + 1;
                            hashCode2 = (oVar.r() + oVar.j() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = f30421a + 1;
                            i10 = hashCode + 1;
                            i11 = i10 + 1;
                            hashCode2 = i11 + 1;
                            f30421a = hashCode2;
                        }
                    } else {
                        hashCode = (oVar.k() + oVar.j()).hashCode();
                        i10 = f30421a + 1;
                        i11 = i10 + 1;
                        f30421a = i11;
                        hashCode2 = (oVar.k() + oVar.j() + context.getPackageName()).hashCode();
                    }
                    HMSLog.d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i10 + ",delNotifyId:" + i11 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i10;
                    iArr[2] = i11;
                    if (oVar.e() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification a10 = e.d() ? a(context, oVar, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && a10 != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, a10);
                        l.a(context, oVar.o(), oVar.b(), ADEvent.PRICE_FILTER);
                    }
                }
            }
        }
    }

    private static PendingIntent b(Context context, o oVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], a(context, oVar, iArr, "2", 268435456), e.a());
    }

    private static PendingIntent c(Context context, o oVar, int[] iArr) {
        Intent a10 = a(context, oVar, iArr, "1", 268435456);
        if (a()) {
            a10.setClass(context, TransActivity.class);
            a10.setFlags(268468224);
            return PendingIntent.getActivity(context, iArr[1], a10, e.a());
        }
        return PendingIntent.getBroadcast(context, iArr[1], a10, e.a());
    }

    private static void d(o oVar, Notification.Builder builder) {
        String t2 = oVar.t();
        String i10 = oVar.i();
        if (TextUtils.isEmpty(i10)) {
            builder.setContentText(t2);
            return;
        }
        builder.setContentText(i10);
        if (TextUtils.isEmpty(t2)) {
            return;
        }
        builder.setContentTitle(t2);
    }

    private static void b(Context context, Notification.Builder builder, o oVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String j10 = oVar.j();
            if (TextUtils.isEmpty(j10)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", j10);
            builder.setExtras(bundle);
        }
    }

    private static void c(o oVar, Notification.Builder builder) {
        builder.setTicker(oVar.w());
    }

    private static void b(o oVar, Notification.Builder builder) {
        String s2 = oVar.s();
        if (TextUtils.isEmpty(s2)) {
            return;
        }
        builder.setSubText(s2);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private static Intent a(Context context, o oVar, int[] iArr, String str, int i10) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", oVar.n()).putExtra("selfshow_token", oVar.x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i10);
        return intent;
    }

    private static Notification a(Context context, o oVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (j.a(oVar) == k.STYLE_BIGTEXT) {
            j.a(builder, oVar.f(), oVar);
        }
        h.a(context, builder, oVar);
        b(oVar, builder);
        d(oVar, builder);
        a(context, oVar, builder);
        a(builder);
        a(oVar, builder);
        c(oVar, builder);
        builder.setContentIntent(c(context, oVar, iArr));
        builder.setDeleteIntent(b(context, oVar, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, oVar);
        a(context, builder, oVar);
        return builder.build();
    }

    private static void a(Context context, Notification.Builder builder, o oVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !e.a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String j10 = oVar.j();
        HMSLog.i("PushSelfShowLog", "the package name of notification is:" + j10);
        if (!TextUtils.isEmpty(j10)) {
            String a10 = e.a(context, j10);
            HMSLog.i("PushSelfShowLog", "the app name is:" + a10);
            if (a10 != null) {
                bundle.putCharSequence("android.extraAppName", a10);
            }
        }
        builder.setExtras(bundle);
    }

    private static void a(Context context, o oVar, Notification.Builder builder) {
        Bitmap a10 = h.a(context, oVar);
        if (a10 != null) {
            builder.setLargeIcon(a10);
        }
    }

    private static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    private static void a(o oVar, Notification.Builder builder) {
        builder.setAutoCancel(oVar.d() == 1);
        builder.setOngoing(false);
    }

    private static boolean a(o oVar) {
        return oVar == null || (TextUtils.isEmpty(oVar.t()) && TextUtils.isEmpty(oVar.i()));
    }
}
