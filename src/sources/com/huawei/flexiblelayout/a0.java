package com.huawei.flexiblelayout;

import android.content.Context;
import android.graphics.Rect;
import com.huawei.flexiblelayout.css.util.EmuiHelper;

/* compiled from: HwSafeAreaInsets.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a0 extends y {

    /* renamed from: b, reason: collision with root package name */
    private Rect f27711b;

    /* compiled from: HwSafeAreaInsets.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a0 f27712a = new a0();

        private b() {
        }
    }

    public static a0 a() {
        return b.f27712a;
    }

    @Override // com.huawei.flexiblelayout.services.safearea.SafeAreaInsets
    public Integer getSafeAreaBottom() {
        Context context = this.f28673a;
        if (context == null) {
            return 0;
        }
        if (this.f27711b == null) {
            return null;
        }
        return Integer.valueOf(com.huawei.flexiblelayout.css.util.a.b(context, r1.bottom));
    }

    @Override // com.huawei.flexiblelayout.services.safearea.SafeAreaInsets
    public Integer getSafeAreaEnd() {
        Context context = this.f28673a;
        if (context == null) {
            return 0;
        }
        if (this.f27711b == null) {
            return null;
        }
        return Integer.valueOf(com.huawei.flexiblelayout.css.util.a.b(context, r1.right));
    }

    @Override // com.huawei.flexiblelayout.services.safearea.SafeAreaInsets
    public Integer getSafeAreaStart() {
        Context context = this.f28673a;
        if (context == null) {
            return 0;
        }
        if (this.f27711b == null) {
            return null;
        }
        return Integer.valueOf(com.huawei.flexiblelayout.css.util.a.b(context, r1.left));
    }

    @Override // com.huawei.flexiblelayout.services.safearea.SafeAreaInsets
    public Integer getSafeAreaTop() {
        Context context = this.f28673a;
        if (context == null) {
            return 0;
        }
        if (this.f27711b == null) {
            return null;
        }
        return Integer.valueOf(com.huawei.flexiblelayout.css.util.a.b(context, r1.top));
    }

    private a0() {
        this.f27711b = EmuiHelper.getInstance().getSafeAreaRect();
    }
}
