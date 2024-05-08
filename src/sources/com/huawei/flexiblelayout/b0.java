package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.css.util.EmuiHelper;
import com.huawei.flexiblelayout.services.safearea.SafeAreaInsets;

/* compiled from: SafeAreaInsetsFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b0 {

    /* compiled from: SafeAreaInsetsFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b0 f27727a = new b0();

        private a() {
        }
    }

    public static b0 b() {
        return a.f27727a;
    }

    private boolean c() {
        return EmuiHelper.getInstance().isHwPhone();
    }

    public SafeAreaInsets a() {
        if (c()) {
            return a0.a();
        }
        return z.a();
    }
}
