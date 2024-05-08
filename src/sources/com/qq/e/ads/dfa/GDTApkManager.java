package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GDTApkManager {

    /* renamed from: a, reason: collision with root package name */
    private DFA f38140a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38141b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f38142c = false;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f38143d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private Context f38144e;

    public GDTApkManager(Context context, IGDTApkListener iGDTApkListener) {
        if (b.b().d()) {
            a(context, b.b().a(), iGDTApkListener);
        }
    }

    private void a(Context context, String str, final IGDTApkListener iGDTApkListener) {
        if (TextUtils.isEmpty(str) || context == null) {
            GDTLogger.e("初始化错误：GDTApkManager 构造失败，Context和appID不能为空");
        } else {
            if (!a.a(context)) {
                GDTLogger.e("初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明");
                return;
            }
            this.f38141b = true;
            this.f38144e = context;
            b.f38267g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = b.b().c().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f38140a = b.b().c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.f38142c = true;
                                        while (GDTApkManager.this.f38143d.getAndDecrement() > 0) {
                                            GDTApkManager.this.loadGDTApk();
                                        }
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化时发生异常", th);
                    }
                }
            });
        }
    }

    public final void loadGDTApk() {
        if (this.f38141b) {
            if (!this.f38142c) {
                this.f38143d.incrementAndGet();
                return;
            }
            DFA dfa = this.f38140a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("调用loadGDTApk失败，实例未被正常初始化");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f38140a;
        if (dfa != null) {
            dfa.startInstall(this.f38144e, gDTApk);
        }
    }
}
