package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0003l.f;
import com.autonavi.aps.amapapi.utils.b;
import com.huawei.quickcard.CardContext;
import com.kuaishou.weapon.p0.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class APSService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public f f8124a;

    /* renamed from: b, reason: collision with root package name */
    public int f8125b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8126c = false;

    private void a(Context context) {
        try {
            if (this.f8124a == null) {
                this.f8124a = new f(context);
            }
            this.f8124a.a();
        } catch (Throwable th) {
            b.a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.f8124a.a(intent);
        } catch (Throwable th) {
            b.a(th, "APSService", CardContext.ON_BIND_FUNC);
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f8124a.c();
            if (this.f8126c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            b.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        int i12;
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra(t.f36220e, 0);
                    Notification notification = (Notification) intent.getParcelableExtra("h");
                    if (intExtra2 != 0 && notification != null) {
                        startForeground(intExtra2, notification);
                        this.f8126c = true;
                        this.f8125b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && (i12 = this.f8125b) > 0) {
                        this.f8125b = i12 - 1;
                    }
                    if (this.f8125b <= 0) {
                        stopForeground(true);
                        this.f8126c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            return this.f8124a.b();
        } catch (Throwable th) {
            b.a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i10, i11);
        }
    }
}
