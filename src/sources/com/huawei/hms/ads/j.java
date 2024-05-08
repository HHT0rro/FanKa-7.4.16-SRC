package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.IHiAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {
    private static final String Code = "AdsInitialization";
    private static j I;
    private static final Object V = new Object();
    private Context B;
    private RequestOptions C;
    private IHiAd Z;

    public static j Code() {
        j jVar;
        synchronized (V) {
            if (I == null) {
                I = new j();
            }
            jVar = I;
        }
        return jVar;
    }

    private boolean S() {
        return this.Z != null;
    }

    public boolean B() {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return true;
        }
        return iHiAd.isAppInstalledNotify();
    }

    public int C() {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return 0;
        }
        return iHiAd.getAppActivateStyle();
    }

    public void Code(float f10) {
        if (f10 < 0.0f || f10 > 1.0f || !S()) {
            return;
        }
        this.Z.setAppVolume(f10);
    }

    public void Code(int i10) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setBrand(i10);
    }

    public void Code(Context context) {
        Code(context, null);
    }

    public void Code(Context context, String str) {
        if (this.Z != null) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        synchronized (V) {
            this.B = context.getApplicationContext();
            if (this.Z == null) {
                IHiAd hiAd = HiAd.getInstance(context);
                this.Z = hiAd;
                hiAd.initLog(true, 3);
                RequestOptions requestOptions = this.C;
                if (requestOptions != null) {
                    this.Z.setRequestConfiguration(requestOptions);
                }
                this.Z.enableUserInfo(true);
                this.Z.setApplicationCode(str);
            }
        }
    }

    public void Code(RequestOptions requestOptions) {
        if (S()) {
            this.Z.setRequestConfiguration(requestOptions);
        } else {
            this.C = requestOptions;
        }
    }

    public void Code(String str) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setConsent(str);
    }

    public void Code(boolean z10) {
        if (S()) {
            this.Z.setAppMuted(z10);
        }
    }

    public RequestOptions I() {
        if (S()) {
            return this.Z.getRequestConfiguration();
        }
        if (this.C == null) {
            this.C = new RequestOptions.Builder().build();
        }
        return this.C;
    }

    public String V() {
        return "13.4.62.302";
    }

    public void V(int i10) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setAppActivateStyle(i10);
    }

    public void V(boolean z10) {
        IHiAd iHiAd = this.Z;
        if (iHiAd == null) {
            return;
        }
        iHiAd.setAppInstalledNotify(z10);
    }

    public Context Z() {
        return this.B;
    }
}
