package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbstractAD<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f38089a;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f38093e;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f38091c = false;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f38092d = false;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f38090b = new Handler(Looper.getMainLooper());

    private void b(final Context context, final String str, final String str2) {
        this.f38093e = true;
        if (b.b().d()) {
            final String a10 = b.b().a();
            if (a.a(context)) {
                this.f38092d = true;
                b.f38267g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = b.b().c().getPOFactory();
                            AbstractAD.this.f38090b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        POFactory pOFactory2 = pOFactory;
                                        if (pOFactory2 != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            AbstractAD abstractAD = AbstractAD.this;
                                            abstractAD.f38089a = (T) abstractAD.a(context, pOFactory2, a10, str, str2);
                                            AbstractAD.this.f38091c = true;
                                            AbstractAD abstractAD2 = AbstractAD.this;
                                            T t2 = abstractAD2.f38089a;
                                            if (t2 == null) {
                                                abstractAD2.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            } else {
                                                abstractAD2.a((AbstractAD) t2);
                                            }
                                        } else {
                                            AbstractAD.this.f38091c = true;
                                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                        AbstractAD.this.f38091c = true;
                                        AbstractAD.this.a(2001);
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                            AbstractAD.this.f38091c = true;
                            AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                        }
                    }
                });
                return;
            } else {
                GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                a(4002);
                return;
            }
        }
        a(2003);
    }

    public abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    public final void a(final int i10) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i10);
        } else {
            this.f38090b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i10);
                }
            });
        }
    }

    public final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    public final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    public abstract void a(T t2);

    public final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    public final boolean a() {
        return this.f38093e && this.f38092d;
    }

    public abstract void b(int i10);

    public final boolean b() {
        return this.f38091c;
    }
}
