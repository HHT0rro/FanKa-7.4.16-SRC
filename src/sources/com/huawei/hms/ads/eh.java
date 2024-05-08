package com.huawei.hms.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.hihonor.android.app.HwMultiWindowEx;
import com.hihonor.android.content.pm.ApplicationInfoEx;
import com.hihonor.android.fsm.HwFoldScreenManagerEx;
import com.hihonor.android.view.DisplaySideRegionEx;
import com.hihonor.android.view.WindowManagerEx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class eh extends ee {
    private static em Code;
    private static final byte[] V = new byte[0];

    private eh(Context context) {
    }

    public static em Code(Context context) {
        return V(context);
    }

    private static em V(Context context) {
        em emVar;
        synchronized (V) {
            if (Code == null) {
                Code = new eh(context);
            }
            emVar = Code;
        }
        return emVar;
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public String B() {
        return "com.hihonor.android.os.Build";
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public String C() {
        return "com.hihonor.android.os.SystemPropertiesEx";
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public int Code(ApplicationInfo applicationInfo) {
        return new ApplicationInfoEx(applicationInfo).getHwFlags();
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public Rect Code(WindowInsets windowInsets) {
        DisplaySideRegionEx displaySideRegion = WindowManagerEx.LayoutParamsEx.getDisplaySideRegion(windowInsets);
        if (displaySideRegion != null) {
            return displaySideRegion.getSafeInsets();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public void Code(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return;
        }
        new WindowManagerEx.LayoutParamsEx(layoutParams).setDisplaySideMode(1);
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public boolean Code() {
        return HwMultiWindowEx.isInMultiWindowMode();
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public String I() {
        return "com.hihonor.android.net.wifi.WifiManagerCommonEx";
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public int S() {
        return HwFoldScreenManagerEx.getDisplayMode();
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public boolean V() {
        return HwFoldScreenManagerEx.isFoldable();
    }

    @Override // com.huawei.hms.ads.ee, com.huawei.hms.ads.em
    public String Z() {
        return "com.hihonor.android.os.Build$VERSION";
    }
}
