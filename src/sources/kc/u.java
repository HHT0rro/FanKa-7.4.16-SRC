package kc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.push.g7;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class u {

    /* renamed from: g, reason: collision with root package name */
    public static u f50859g;

    /* renamed from: a, reason: collision with root package name */
    public Context f50860a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f50862c;

    /* renamed from: f, reason: collision with root package name */
    public Messenger f50865f;

    /* renamed from: d, reason: collision with root package name */
    public List<Message> f50863d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f50864e = false;

    /* renamed from: b, reason: collision with root package name */
    public Messenger f50861b = new Messenger(new v(this, Looper.getMainLooper()));

    public u(Context context) {
        this.f50862c = false;
        this.f50860a = context.getApplicationContext();
        if (g()) {
            fc.c.m("use miui push service");
            this.f50862c = true;
        }
    }

    public static u e(Context context) {
        if (f50859g == null) {
            f50859g = new u(context);
        }
        return f50859g;
    }

    public final Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public final synchronized void f(Intent intent) {
        if (this.f50864e) {
            Message a10 = a(intent);
            if (this.f50863d.size() >= 50) {
                this.f50863d.remove(0);
            }
            this.f50863d.add(a10);
            return;
        }
        if (this.f50865f == null) {
            this.f50860a.bindService(intent, new w(this), 1);
            this.f50864e = true;
            this.f50863d.clear();
            this.f50863d.add(a(intent));
        } else {
            try {
                this.f50865f.send(a(intent));
            } catch (RemoteException unused) {
                this.f50865f = null;
                this.f50864e = false;
            }
        }
    }

    public final boolean g() {
        if (com.xiaomi.push.e.f47191f) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f50860a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean h(Intent intent) {
        try {
            if (g7.f() || Build.VERSION.SDK_INT < 26) {
                this.f50860a.startService(intent);
                return true;
            }
            f(intent);
            return true;
        } catch (Exception e2) {
            fc.c.k(e2);
            return false;
        }
    }
}
