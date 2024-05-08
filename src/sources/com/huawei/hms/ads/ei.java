package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.util.HwNotchSizeUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ei extends ed {
    private static final String B = "display_notch_status";
    private static final int C = 0;
    private static final byte[] D = new byte[0];
    private static el F = null;
    private static final String I = "HwDeviceImpl";
    private static final String S = "true";
    private static final String Z = "156";

    private ei(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String V = V("hw_sc.build.platform.version");
        this.V.V(V);
        return V;
    }

    private static el I(Context context) {
        el elVar;
        synchronized (D) {
            if (F == null) {
                F = new ei(context);
            }
            elVar = F;
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
        return com.huawei.openalliance.ad.utils.ay.Code(com.huawei.openalliance.ad.utils.j.Code);
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
        return Z.equals(com.huawei.openalliance.ad.utils.ay.Code("ro.config.hw_optb"));
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean I() {
        return com.huawei.openalliance.ad.utils.l.Code(this.Code);
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.ay.Code("hw_mc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.ec, com.huawei.hms.ads.el
    public String Z() {
        String C2 = this.V.C();
        if (TextUtils.isEmpty(C2)) {
            C2 = F();
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.ei.1
                @Override // java.lang.Runnable
                public void run() {
                    ei.this.F();
                }
            });
        }
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.u.aT, C2)) {
            return null;
        }
        return C2;
    }
}
