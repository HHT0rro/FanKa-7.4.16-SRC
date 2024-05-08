package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ec implements el {
    private static final String I = "BaseDeviceImpl";
    public Context Code;
    public com.huawei.openalliance.ad.utils.am V;

    public ec(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = com.huawei.openalliance.ad.utils.am.Code(applicationContext);
    }

    @Override // com.huawei.hms.ads.el
    public boolean B() {
        return false;
    }

    @Override // com.huawei.hms.ads.el
    public String C() {
        return null;
    }

    @Override // com.huawei.hms.ads.el
    public int Code(View view) {
        return 0;
    }

    @Override // com.huawei.hms.ads.el
    public boolean Code() {
        return true;
    }

    @Override // com.huawei.hms.ads.el
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.el
    public boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            gl.I(I, "check widget available error");
            return false;
        }
    }

    @Override // com.huawei.hms.ads.el
    public boolean I() {
        return true;
    }

    @Override // com.huawei.hms.ads.el
    public boolean S() {
        return false;
    }

    @Override // com.huawei.hms.ads.el
    public boolean V() {
        return true;
    }

    @Override // com.huawei.hms.ads.el
    public String Z() {
        return null;
    }
}
