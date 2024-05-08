package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class qK8iQ {

    /* renamed from: b, reason: collision with root package name */
    public static WT9z5 f45922b;

    /* renamed from: a, reason: collision with root package name */
    public static List<JD1Ej> f45921a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static Set<String> f45923c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public static final spXPg f45924d = new spXPg();

    /* renamed from: e, reason: collision with root package name */
    public static ShGzN f45925e = new ShGzN();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN implements WT9z5 {
        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityPaused(Activity activity) {
            pZo7n a10 = pZo7n.a();
            activity.getApplicationContext();
            a10.a(activity.getClass().getName());
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // com.tencent.turingface.sdk.mfa.WT9z5
        public final void onActivityResumed(Activity activity) {
            WT9z5 wT9z5 = qK8iQ.f45922b;
            if (wT9z5 != null) {
                wT9z5.onActivityResumed(activity);
            }
            int i10 = qK8iQ.f45923c.contains(activity.getClass().getName()) ? 100 : 999;
            pZo7n a10 = pZo7n.a();
            activity.getApplicationContext();
            a10.a(activity.getClass().getName(), i10, qK8iQ.f45924d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements JD1Ej {
        @Override // com.tencent.turingface.sdk.mfa.JD1Ej
        public final void a(String str, int i10, int i11, OCkqn oCkqn) {
            Iterator<JD1Ej> iterator2 = qK8iQ.f45921a.iterator2();
            while (iterator2.hasNext()) {
                JD1Ej next = iterator2.next();
                if (next != null) {
                    next.a(str, i10, i11, oCkqn);
                }
            }
        }
    }
}
