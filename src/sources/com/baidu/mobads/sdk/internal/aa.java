package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9739a = "LoadRemoteDex";

    /* renamed from: i, reason: collision with root package name */
    private static aa f9740i;

    /* renamed from: b, reason: collision with root package name */
    private IXAdContainerFactory f9741b;

    /* renamed from: c, reason: collision with root package name */
    private bn f9742c;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f9745f;

    /* renamed from: g, reason: collision with root package name */
    private Context f9746g;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9749k;

    /* renamed from: d, reason: collision with root package name */
    private int f9743d = 5000;

    /* renamed from: e, reason: collision with root package name */
    private Handler f9744e = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private bs f9747h = bs.a();

    /* renamed from: j, reason: collision with root package name */
    private AtomicBoolean f9748j = new AtomicBoolean(false);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f9750a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f9751b = 2;

        void onFailure();

        void onSuccess();
    }

    private aa() {
    }

    private void f() {
        this.f9748j.set(true);
        if (ao.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bn bnVar = new bn(Class.forName(x.aP, true, getClass().getClassLoader()), this.f9746g);
                this.f9742c = bnVar;
                this.f9741b = bnVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f9745f = new ab(this);
        j();
        if (g.f10244a == null) {
            synchronized (by.class) {
                if (g.f10244a == null) {
                    g.f10244a = new by(this.f9746g);
                }
            }
        }
        if (this.f9741b != null) {
            k();
            return;
        }
        if (g.f10244a != null) {
            this.f9747h.a(f9739a, "start load apk");
            try {
                g.f10244a.a(new ac(this));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f9747h.a(f9739a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
    }

    private void i() {
        Runnable runnable = this.f9745f;
        if (runnable != null) {
            this.f9744e.removeCallbacks(runnable);
        }
        this.f9745f = null;
    }

    private void j() {
        Runnable runnable = this.f9745f;
        if (runnable != null) {
            this.f9744e.postDelayed(runnable, this.f9743d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f9748j.set(false);
        bk.a(this.f9746g);
        i();
        q.a().a(1);
        cm.a(this.f9746g).b();
        cm.a(this.f9746g).a();
    }

    public IXAdContainerFactory c() {
        if (this.f9746g == null) {
            return null;
        }
        if (this.f9741b == null && !this.f9748j.get()) {
            f();
        }
        return this.f9741b;
    }

    public String d() {
        if (this.f9741b == null) {
            return "";
        }
        return "_" + this.f9741b.getRemoteVersion();
    }

    public boolean e() {
        return this.f9749k;
    }

    public Context b() {
        return this.f9746g;
    }

    public static aa a() {
        if (f9740i == null) {
            synchronized (aa.class) {
                if (f9740i == null) {
                    f9740i = new aa();
                }
            }
        }
        return f9740i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f9747h.c(f9739a, "init Context is null,error");
            return;
        }
        this.f9746g = context.getApplicationContext();
        q.a().a(aVar);
        if (this.f9741b != null) {
            k();
        } else {
            if (this.f9748j.get()) {
                return;
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f9747h.a(f9739a, "加载dex失败原因=" + str);
        this.f9748j.set(false);
        i();
        q.a().a(2);
    }
}
