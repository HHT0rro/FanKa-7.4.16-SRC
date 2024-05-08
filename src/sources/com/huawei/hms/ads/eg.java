package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.android.util.HwNotchSizeUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class eg extends ed {
    private static final String B = "true";
    private static final String C = "156";
    private static final String I = "HnDeviceImpl";
    private static final byte[] S = new byte[0];
    private static el Z;

    private eg(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String V = V("msc.build.platform.version");
        this.V.V(V);
        return V;
    }

    private static el I(Context context) {
        el elVar;
        synchronized (S) {
            if (Z == null) {
                Z = new eg(context);
            }
            elVar = Z;
        }
        return elVar;
    }

    public static el V(Context context) {
        return I(context);
    }

    private String V(String str) {
        String Code = com.huawei.openalliance.ad.utils.ay.Code(str);
        return Code == null ? com.huawei.openalliance.ad.constant.u.aT : Code;
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean B() {
        return !TextUtils.isEmpty(Z());
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public String C() {
        return com.huawei.openalliance.ad.utils.ay.Code(com.huawei.openalliance.ad.utils.j.V);
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public int Code(View view) {
        StringBuilder sb2;
        try {
            if (!HwNotchSizeUtil.hasNotchInScreen()) {
                return 0;
            }
            int[] notchSize = HwNotchSizeUtil.getNotchSize();
            if (notchSize.length >= 2) {
                return notchSize[1];
            }
            return 0;
        } catch (Exception e2) {
            e = e2;
            sb2 = new StringBuilder();
            sb2.append("getNotchHeight error:");
            sb2.append(e.getClass().getSimpleName());
            gl.I(I, sb2.toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb2 = new StringBuilder();
            sb2.append("getNotchHeight error:");
            sb2.append(e.getClass().getSimpleName());
            gl.I(I, sb2.toString());
            return 0;
        }
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean Code() {
        return C.equals(com.huawei.openalliance.ad.utils.ay.Code("msc.config.optb"));
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.ay.Code("msc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public String Z() {
        String C2 = this.V.C();
        if (TextUtils.isEmpty(C2)) {
            C2 = F();
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eg.1
                @Override // java.lang.Runnable
                public void run() {
                    eg.this.F();
                }
            });
        }
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.u.aT, C2)) {
            return null;
        }
        return C2;
    }
}
