package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.j4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k4 implements j4.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f47911b;

    /* renamed from: a, reason: collision with root package name */
    public PendingIntent f47910a = null;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f47912c = 0;

    public k4(Context context) {
        this.f47911b = null;
        this.f47911b = context;
    }

    @Override // com.xiaomi.push.j4.a
    public void a() {
        if (this.f47910a != null) {
            try {
                ((AlarmManager) this.f47911b.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f47910a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f47910a = null;
                fc.c.m("unregister timer");
                this.f47912c = 0L;
                throw th;
            }
            this.f47910a = null;
            fc.c.m("unregister timer");
            this.f47912c = 0L;
        }
        this.f47912c = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r7.f47912c < java.lang.System.currentTimeMillis()) goto L17;
     */
    @Override // com.xiaomi.push.j4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r8) {
        /*
            r7 = this;
            long r0 = r7.b()
            r2 = 0
            if (r8 != 0) goto Lf
            long r4 = r7.f47912c
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto Lf
            return
        Lf:
            if (r8 == 0) goto L14
            r7.a()
        L14:
            if (r8 != 0) goto L2d
            long r4 = r7.f47912c
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 != 0) goto L1d
            goto L2d
        L1d:
            long r2 = r7.f47912c
            long r2 = r2 + r0
            r7.f47912c = r2
            long r2 = r7.f47912c
            long r4 = java.lang.System.currentTimeMillis()
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L3a
            goto L33
        L2d:
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r2 = r2 % r0
            long r0 = r0 - r2
        L33:
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 + r0
            r7.f47912c = r2
        L3a:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r0 = kc.n.f50831m
            r8.<init>(r0)
            android.content.Context r0 = r7.f47911b
            java.lang.String r0 = r0.getPackageName()
            r8.setPackage(r0)
            long r0 = r7.f47912c
            r7.d(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.k4.a(boolean):void");
    }

    @Override // com.xiaomi.push.j4.a
    /* renamed from: a */
    public boolean mo3063a() {
        return this.f47912c != 0;
    }

    public long b() {
        return a5.f();
    }

    public final void c(AlarmManager alarmManager, long j10, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j10), pendingIntent);
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }

    public void d(Intent intent, long j10) {
        AlarmManager alarmManager = (AlarmManager) this.f47911b.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f47911b, 0, intent, 0);
        this.f47910a = broadcast;
        if (Build.VERSION.SDK_INT >= 23) {
            k0.e(alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j10), this.f47910a);
        } else {
            c(alarmManager, j10, broadcast);
        }
        fc.c.m("register timer " + j10);
    }
}
