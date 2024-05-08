package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import android.content.Context;
import com.android.internal.logging.nano.MetricsProto;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class flIYu {

    /* renamed from: d, reason: collision with root package name */
    public static Context f45796d;

    /* renamed from: a, reason: collision with root package name */
    public static final WOMZP<IEttU> f45793a = new WOMZP<>(3);

    /* renamed from: b, reason: collision with root package name */
    public static final WOMZP<IEttU> f45794b = new WOMZP<>(3);

    /* renamed from: c, reason: collision with root package name */
    public static long f45795c = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final spXPg f45797e = new spXPg();

    /* renamed from: f, reason: collision with root package name */
    public static final ShGzN f45798f = new ShGzN();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN implements WT9z5 {
        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityPaused(Activity activity) {
            pZo7n a10 = pZo7n.a();
            activity.getApplicationContext();
            a10.a(activity.getClass().getName());
        }

        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityResumed(Activity activity) {
            pZo7n a10 = pZo7n.a();
            Context context = flIYu.f45796d;
            a10.a(activity.getClass().getName(), MetricsProto.MetricsEvent.ASSIST_GESTURE_RELEASED, flIYu.f45797e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements JD1Ej {
        @Override // com.tencent.turingface.sdk.mfa.JD1Ej
        public final void a(String str, int i10, int i11, OCkqn oCkqn) {
            if (i11 != 2 && i11 != 3) {
                long abs = oCkqn != null ? Math.abs(oCkqn.f45643b - flIYu.f45795c) : 1000L;
                flIYu.f45795c = System.currentTimeMillis();
                if (abs < 1000) {
                    return;
                }
                WOMZP<IEttU> womzp = flIYu.f45793a;
                synchronized (womzp) {
                    womzp.a(new IEttU(str, i11, oCkqn));
                }
                return;
            }
            WOMZP<IEttU> womzp2 = flIYu.f45794b;
            synchronized (womzp2) {
                womzp2.a(new IEttU(str, i11, oCkqn));
            }
        }
    }
}
