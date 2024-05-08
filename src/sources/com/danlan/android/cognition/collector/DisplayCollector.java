package com.danlan.android.cognition.collector;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Point;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DisplayCollector extends SubCollector {
    private Context mcontext;

    public DisplayCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    private int[] getScreenSize() {
        int[] iArr = new int[2];
        try {
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService(StringFog.decrypt("VkpKR05U"));
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                iArr[0] = point.x;
                iArr[1] = point.y;
            }
        } catch (Exception unused) {
        }
        return iArr;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("UkBWRkRNYERPUE1XWA=="), getScreenDensity());
            safeJSONObject.put(StringFog.decrypt("UkBWRkRNbERIRExX"), getScreenSize()[1]);
            safeJSONObject.put(StringFog.decrypt("UkBWRkRNc0hFV0w="), getScreenSize()[0]);
            safeJSONObject.put(StringFog.decrypt("SFBpVk1XTXVOVkdL"), isSupportMultiTouch());
            safeJSONObject.put(StringFog.decrypt("UkBWRkRNZlNIRExXT0ZXUg=="), getScreenBrightness());
            safeJSONObject.put(StringFog.decrypt("SFB3RlVwR1NERkpvTkBP"), isSetScreenLock());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("RUpXU01CXQ=="), safeJSONObject);
        collectDone();
    }

    public final int getScreenBrightness() {
        try {
            return Settings.System.getInt(this.mcontext.getContentResolver(), StringFog.decrypt("UkBWRkRNe0NTSkNLVU1BUlI="));
        } catch (Settings.SettingNotFoundException unused) {
            return 0;
        }
    }

    public final String getScreenDensity() {
        int i10 = this.mcontext.getResources().getDisplayMetrics().densityDpi;
        return StringFog.decrypt(i10 != 120 ? i10 != 160 ? i10 != 240 ? i10 != 320 ? i10 != 480 ? i10 != 640 ? "TldMRlM=" : "WVtcS0VTTQ==" : "WVtMR1FK" : "WUtAU0g=" : "SUdUSg==" : "TEdUSg==" : "TUdUSg==");
    }

    public final boolean isSetScreenLock() {
        try {
            return ((KeyguardManager) this.mcontext.getSystemService(StringFog.decrypt("SkZdRFRCVkU="))).isKeyguardSecure();
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isSupportMultiTouch() {
        return this.mContext.getPackageManager().hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9XS1ZCS1dCU0ZBTQ9OUU1VSlBMVEBM"));
    }
}
