package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.huawei.appgallery.agd.common.constant.SystemPropertyValues;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ed extends ec {
    private static final int B = 0;
    private static final String I = "BaseHwnDeviceImpl";
    private static final String Z = "display_notch_status";

    public ed(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean Code(Context context) {
        try {
            int i10 = Settings.Secure.getInt(context.getContentResolver(), Z);
            gl.Code(I, "isNotchEnable, displayNotch: %s", Integer.valueOf(i10));
            return i10 == 0;
        } catch (Throwable th) {
            gl.V(I, "isNotchEnable err:" + th.getClass().getSimpleName());
            return Build.VERSION.SDK_INT >= 26 && Code((View) null) > 0;
        }
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean V() {
        String Code = com.huawei.openalliance.ad.utils.ay.Code(SystemPropertyValues.PROP_REGION_KEY);
        if (!TextUtils.isEmpty(Code)) {
            return "cn".equalsIgnoreCase(Code);
        }
        String Code2 = com.huawei.openalliance.ad.utils.ay.Code(SystemPropertyValues.PROP_LOCALE_KEY);
        if (!TextUtils.isEmpty(Code2)) {
            return Code2.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String Z2 = com.huawei.openalliance.ad.utils.ay.Z();
        if (TextUtils.isEmpty(Z2)) {
            return false;
        }
        return "cn".equalsIgnoreCase(Z2);
    }
}
