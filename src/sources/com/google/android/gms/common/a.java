package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.k;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f23367d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final a f23368e = new a();

    /* renamed from: f, reason: collision with root package name */
    @RecentlyNonNull
    public static final int f23369f = b.f23516a;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    public String f23370c;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* renamed from: com.google.android.gms.common.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class HandlerC0212a extends h7.g {

        /* renamed from: a, reason: collision with root package name */
        public final Context f23371a;

        public HandlerC0212a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f23371a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Don't know how to handle this message: ");
                sb2.append(i10);
            } else {
                int g3 = a.this.g(this.f23371a);
                if (a.this.i(g3)) {
                    a.this.o(this.f23371a, g3);
                }
            }
        }
    }

    @NonNull
    public static a m() {
        return f23368e;
    }

    @Nullable
    public static Dialog p(@NonNull Context context, int i10, com.google.android.gms.common.internal.j jVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(k.g(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String i11 = k.i(context, i10);
        if (i11 != null) {
            builder.setPositiveButton(i11, jVar);
        }
        String b4 = k.b(context, i10);
        if (b4 != null) {
            builder.setTitle(b4);
        }
        String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10));
        new IllegalArgumentException();
        return builder.create();
    }

    public static void r(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.N0(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else {
            ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @Override // com.google.android.gms.common.b
    @RecentlyNullable
    public Intent b(@Nullable Context context, @RecentlyNonNull int i10, @Nullable String str) {
        return super.b(context, i10, str);
    }

    @Override // com.google.android.gms.common.b
    @RecentlyNullable
    public PendingIntent c(@RecentlyNonNull Context context, @RecentlyNonNull int i10, @RecentlyNonNull int i11) {
        return super.c(context, i10, i11);
    }

    @Override // com.google.android.gms.common.b
    @NonNull
    public final String e(@RecentlyNonNull int i10) {
        return super.e(i10);
    }

    @Override // com.google.android.gms.common.b
    @RecentlyNonNull
    public int g(@RecentlyNonNull Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.b
    @RecentlyNonNull
    public int h(@RecentlyNonNull Context context, @RecentlyNonNull int i10) {
        return super.h(context, i10);
    }

    @Override // com.google.android.gms.common.b
    @RecentlyNonNull
    public final boolean i(@RecentlyNonNull int i10) {
        return super.i(i10);
    }

    @RecentlyNullable
    public Dialog k(@RecentlyNonNull Activity activity, @RecentlyNonNull int i10, @RecentlyNonNull int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i10, com.google.android.gms.common.internal.j.a(activity, b(activity, i10, "d"), i11), onCancelListener);
    }

    @RecentlyNullable
    public PendingIntent l(@RecentlyNonNull Context context, @RecentlyNonNull ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return c(context, connectionResult.getErrorCode(), 0);
    }

    @RecentlyNonNull
    public boolean n(@RecentlyNonNull Activity activity, @RecentlyNonNull int i10, @RecentlyNonNull int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog k10 = k(activity, i10, i11, onCancelListener);
        if (k10 == null) {
            return false;
        }
        r(activity, k10, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(@RecentlyNonNull Context context, @RecentlyNonNull int i10) {
        t(context, i10, null, d(context, i10, 0, "n"));
    }

    @VisibleForTesting(otherwise = 2)
    public final String q() {
        String str;
        synchronized (f23367d) {
            str = this.f23370c;
        }
        return str;
    }

    public final void s(Context context) {
        new HandlerC0212a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final void t(Context context, int i10, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        int i11;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null);
        new IllegalArgumentException();
        if (i10 == 18) {
            s(context);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String f10 = k.f(context, i10);
        String h10 = k.h(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) com.google.android.gms.common.internal.h.h(context.getSystemService("notification"));
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(f10).setStyle(new NotificationCompat.BigTextStyle().bigText(h10));
        if (b7.g.c(context)) {
            com.google.android.gms.common.internal.h.j(b7.k.d());
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (b7.g.e(context)) {
                style.addAction(R$drawable.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R$string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(17301642).setTicker(resources.getString(com.google.android.gms.base.R$string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(h10);
        }
        if (b7.k.g()) {
            com.google.android.gms.common.internal.h.j(b7.k.g());
            String q10 = q();
            if (q10 == null) {
                q10 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String a10 = k.a(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", a10, 4));
                } else if (!a10.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(a10);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            style.setChannelId(q10);
        }
        Notification build = style.build();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            i11 = 10436;
            d.f23520b.set(false);
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, build);
    }

    @RecentlyNonNull
    public final boolean u(@RecentlyNonNull Context context, @RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull int i10) {
        PendingIntent l10 = l(context, connectionResult);
        if (l10 == null) {
            return false;
        }
        t(context, connectionResult.getErrorCode(), null, GoogleApiActivity.a(context, l10, i10));
        return true;
    }
}
