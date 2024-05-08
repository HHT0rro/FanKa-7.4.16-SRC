package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class da {

    /* renamed from: b, reason: collision with root package name */
    private static volatile da f36025b;

    /* renamed from: a, reason: collision with root package name */
    private Context f36026a;

    /* renamed from: c, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f36027c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f36028d;

    private da(Context context) {
        this.f36026a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Context context = this.f36026a;
            if (context == null) {
                return;
            }
            h a10 = h.a(context, "re_po_rt");
            if (a10.b(df.f36084w, 0) == 0) {
                return;
            }
            final int[] iArr = {0};
            final int[] iArr2 = {a10.b(df.f36072k, 1)};
            if (this.f36026a instanceof Application) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.kuaishou.weapon.p0.da.2
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            int[] iArr3 = iArr;
                            iArr3[0] = iArr3[0] + 1;
                            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) da.this.f36026a).unregisterActivityLifecycleCallbacks(da.this.f36027c);
                                        return;
                                    }
                                    iArr2[0] = r1[0] - 1;
                                    cx.a(da.this.f36026a).a(106);
                                    dd.a(da.this.f36026a).a(106);
                                    db.a(da.this.f36026a).a(106, 0);
                                    cy.a(da.this.f36026a).a(106);
                                    cz.a(da.this.f36026a).a(106);
                                    de.a(da.this.f36026a).a(106);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                };
                this.f36027c = activityLifecycleCallbacks;
                ((Application) this.f36026a).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable unused) {
        }
    }

    public static da a(Context context) {
        if (f36025b == null) {
            synchronized (da.class) {
                if (f36025b == null) {
                    f36025b = new da(context);
                }
            }
        }
        return f36025b;
    }

    public void a() {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h a10 = h.a(da.this.f36026a, "re_po_rt");
                        boolean e2 = a10.e("a1_p_s_p_s");
                        boolean e10 = a10.e("a1_p_s_p_s_c_b");
                        if ((e2 || e10) && !da.this.f36028d) {
                            da.this.f36028d = true;
                            da.this.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
