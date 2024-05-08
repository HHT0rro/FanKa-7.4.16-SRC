package com.huawei.flexiblelayout;

import android.animation.AnimatorSet;
import android.view.View;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.effect.FLEffect;
import org.json.JSONObject;

/* compiled from: ScaleEffect.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n implements FLEffect {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28263d = "ScaleEffect";

    /* renamed from: e, reason: collision with root package name */
    public static final String f28264e = "scale";

    /* renamed from: a, reason: collision with root package name */
    private AnimatorSet f28265a;

    /* renamed from: b, reason: collision with root package name */
    private AnimatorSet f28266b;

    /* renamed from: c, reason: collision with root package name */
    private a f28267c;

    /* compiled from: ScaleEffect.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private float f28268a;

        /* renamed from: b, reason: collision with root package name */
        private int f28269b;

        /* renamed from: c, reason: collision with root package name */
        private int f28270c;

        /* compiled from: ScaleEffect.java */
        /* renamed from: com.huawei.flexiblelayout.n$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0274a {

            /* renamed from: d, reason: collision with root package name */
            private static final float f28271d = 1.0f;

            /* renamed from: e, reason: collision with root package name */
            private static final int f28272e = 100;

            /* renamed from: a, reason: collision with root package name */
            private String f28273a;

            /* renamed from: b, reason: collision with root package name */
            private String f28274b;

            /* renamed from: c, reason: collision with root package name */
            private String f28275c;

            public C0274a a(String str) {
                this.f28274b = str;
                return this;
            }

            public C0274a b(String str) {
                this.f28275c = str;
                return this;
            }

            public C0274a c(String str) {
                this.f28273a = str;
                return this;
            }

            public a a() {
                a aVar = new a();
                try {
                    aVar.f28268a = Float.parseFloat(this.f28273a);
                } catch (Exception e2) {
                    aVar.f28268a = 1.0f;
                    Log.w(n.f28263d, "Scale setScale e:" + e2.getMessage());
                }
                try {
                    aVar.f28269b = Integer.parseInt(this.f28274b);
                } catch (Exception e10) {
                    aVar.f28269b = 100;
                    Log.w(n.f28263d, "Scale mInDuration e:" + e10.getMessage());
                }
                try {
                    aVar.f28270c = Integer.parseInt(this.f28275c);
                } catch (Exception e11) {
                    aVar.f28270c = 100;
                    Log.w(n.f28263d, "Scale mOutDuration e:" + e11.getMessage());
                }
                return aVar;
            }
        }

        public float c() {
            return this.f28268a;
        }

        public int b() {
            return this.f28270c;
        }

        public int a() {
            return this.f28269b;
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("scaleSize");
            String optString2 = jSONObject.optString("inDuration");
            this.f28267c = new a.C0274a().c(optString).a(optString2).b(jSONObject.optString("outDuration")).a();
        }
    }

    private void b(View view) {
        if (this.f28267c == null) {
            return;
        }
        AnimatorSet animatorSet = this.f28265a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f28266b;
        if (animatorSet2 == null) {
            this.f28266b = q.a(this.f28267c.c(), this.f28267c.b(), view);
        } else {
            animatorSet2.start();
        }
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffect
    public void apply(View view, JSONObject jSONObject) {
        a(jSONObject);
        a(view);
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffect
    public void unapply(View view) {
        b(view);
    }

    private void a(View view) {
        if (this.f28267c == null) {
            return;
        }
        AnimatorSet animatorSet = this.f28266b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f28265a;
        if (animatorSet2 == null) {
            this.f28265a = q.b(this.f28267c.c(), this.f28267c.a(), view);
        } else {
            animatorSet2.start();
        }
    }
}
