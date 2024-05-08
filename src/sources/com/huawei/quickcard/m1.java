package com.huawei.quickcard;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.yoga.QuickCardYogaNodeFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34111a = "QuickYogaNodeUtils";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f34112b;

    public static boolean a(Context context) {
        if (f34112b) {
            return true;
        }
        if (!QuickCardEngine.isInitialized()) {
            CardLogUtils.e(f34111a, "engine not initialized");
            f34112b = false;
            return false;
        }
        try {
            QuickCardYogaNodeFactory.make();
            f34112b = true;
        } catch (Throwable unused) {
            f34112b = b(context);
        }
        return f34112b;
    }

    private static boolean b(Context context) {
        try {
            SoLoader.init(context, false);
            YogaLoadHelper.initYogaSource(context);
            YogaLoadHelper.loadYoga();
            QuickCardYogaNodeFactory.make();
            return true;
        } catch (Throwable th) {
            CardLogUtils.e(f34111a, "try make node fail:" + th.getMessage());
            return false;
        }
    }
}
