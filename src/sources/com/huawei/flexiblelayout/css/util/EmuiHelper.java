package com.huawei.flexiblelayout.css.util;

import android.graphics.Rect;
import com.huawei.flexiblelayout.log.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class EmuiHelper {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28008c = "EmuiHelper";

    /* renamed from: d, reason: collision with root package name */
    private static final String f28009d = "com.huawei.android.view.ExtDisplaySizeUtilEx";

    /* renamed from: e, reason: collision with root package name */
    private static final String f28010e = "getDisplaySafeInsets";

    /* renamed from: f, reason: collision with root package name */
    private static final int f28011f = 21;

    /* renamed from: a, reason: collision with root package name */
    private int f28012a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f28013b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final EmuiHelper f28014a = new EmuiHelper();

        private b() {
        }
    }

    public static EmuiHelper getInstance() {
        return b.f28014a;
    }

    public int getEmuiVersion() {
        int i10 = this.f28012a;
        if (i10 > 0) {
            return i10;
        }
        try {
            int intValue = ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "ro.build.hw_emui_api_level", 0)).intValue();
            this.f28012a = intValue;
            return intValue;
        } catch (ClassNotFoundException e2) {
            Log.e(f28008c, "ClassNotFoundException while getting hw_emui_api_level: ", e2);
            return 0;
        } catch (Exception e10) {
            Log.e(f28008c, "Exception while getting hw_emui_api_level: ", e10);
            return 0;
        }
    }

    public Rect getSafeAreaRect() {
        Rect rect = this.f28013b;
        if (rect != null) {
            return rect;
        }
        if (getEmuiVersion() < 21) {
            return null;
        }
        this.f28013b = com.huawei.flexiblelayout.css.util.b.a(f28009d, f28010e);
        return null;
    }

    public boolean isHwPhone() {
        return getEmuiVersion() > 0;
    }

    private EmuiHelper() {
    }
}
