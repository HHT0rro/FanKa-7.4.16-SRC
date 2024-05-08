package wc;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.wangmai.common.utils.PrivateInfoHelper;

/* compiled from: DeviceIdManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f54329b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f54330c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile String f54331d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile String f54332e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile String f54333f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile String f54334g;

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f54335h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile String f54336i;

    /* renamed from: a, reason: collision with root package name */
    public Application f54337a;

    /* compiled from: DeviceIdManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f54338a;

        public a(c cVar) {
            this.f54338a = cVar;
        }

        @Override // wc.c
        public void oaidError(Exception exc) {
            String unused = b.f54333f = "";
            c cVar = this.f54338a;
            if (cVar != null) {
                cVar.oaidError(exc);
            }
        }

        @Override // wc.c
        public void oaidSucc(String str) {
            String unused = b.f54333f = str;
            c cVar = this.f54338a;
            if (cVar != null) {
                cVar.oaidSucc(b.f54333f);
            }
        }
    }

    public static b k() {
        if (f54329b == null) {
            synchronized (b.class) {
                if (f54329b == null) {
                    f54329b = new b();
                }
            }
        }
        return f54329b;
    }

    public String a() {
        if (TextUtils.isEmpty(f54331d)) {
            f54331d = e.d(this.f54337a).c("KEY_CLIENT_ID");
            if (TextUtils.isEmpty(f54331d)) {
                f54331d = wc.a.h();
                e.d(this.f54337a).e("KEY_CLIENT_ID", f54331d);
            }
        }
        if (f54331d == null) {
            f54331d = "";
        }
        return f54331d;
    }

    public String b(Context context, c cVar) {
        if (TextUtils.isEmpty(f54333f)) {
            f54333f = wc.a.m();
            if (TextUtils.isEmpty(f54333f)) {
                f54333f = e.d(this.f54337a).c(PrivateInfoHelper.KEY_OAID);
            }
            if (TextUtils.isEmpty(f54333f)) {
                wc.a.g(context, new a(cVar));
            }
        }
        if (f54333f == null) {
            f54333f = "";
        }
        if (cVar != null) {
            cVar.oaidSucc(f54333f);
        }
        return f54333f;
    }

    public void d(Application application) {
        e(application, false);
    }

    public void e(Application application, boolean z10) {
        this.f54337a = application;
        if (f54330c) {
            return;
        }
        wc.a.e(application);
        f54330c = true;
        f.c(z10);
    }

    public String f() {
        if (f54335h == null) {
            f54335h = e.d(this.f54337a).c("KEY_PSEUDO_ID");
            if (TextUtils.isEmpty(f54335h)) {
                f54335h = wc.a.o();
                e.d(this.f54337a).e("KEY_PSEUDO_ID", f54335h);
            }
        }
        if (f54335h == null) {
            f54335h = "";
        }
        return f54335h;
    }

    public String g(Context context) {
        if (f54336i == null) {
            f54336i = wc.a.i(context);
            if (f54336i == null) {
                f54336i = "";
            }
        }
        return f54336i;
    }

    public String h() {
        if (f54334g == null) {
            f54334g = e.d(this.f54337a).c("KEY_WIDEVINE_ID");
            if (TextUtils.isEmpty(f54334g)) {
                f54334g = wc.a.q();
                e.d(this.f54337a).e("KEY_WIDEVINE_ID", f54334g);
            }
        }
        if (f54334g == null) {
            f54334g = "";
        }
        return f54334g;
    }

    public String i(Context context) {
        if (TextUtils.isEmpty(f54332e)) {
            f54332e = e.d(this.f54337a).c(PrivateInfoHelper.KEY_IMEI);
            if (TextUtils.isEmpty(f54332e)) {
                f54332e = wc.a.p(context);
                e.d(this.f54337a).e(PrivateInfoHelper.KEY_IMEI, f54332e);
            }
        }
        if (f54332e == null) {
            f54332e = "";
        }
        return f54332e;
    }
}
