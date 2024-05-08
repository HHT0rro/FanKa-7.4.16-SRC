package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TextDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class o0 {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final LottieAnimationView f2069b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, String> f2068a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2071d = true;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final LottieDrawable f2070c = null;

    public o0(LottieAnimationView lottieAnimationView) {
        this.f2069b = lottieAnimationView;
    }

    public String a(String str) {
        return str;
    }

    public String b(String str, String str2) {
        return a(str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String c(String str, String str2) {
        if (this.f2071d && this.f2068a.containsKey(str2)) {
            return this.f2068a.get(str2);
        }
        String b4 = b(str, str2);
        if (this.f2071d) {
            this.f2068a.put(str2, b4);
        }
        return b4;
    }

    public final void d() {
        LottieAnimationView lottieAnimationView = this.f2069b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        LottieDrawable lottieDrawable = this.f2070c;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public void e(String str, String str2) {
        this.f2068a.put(str, str2);
        d();
    }
}
