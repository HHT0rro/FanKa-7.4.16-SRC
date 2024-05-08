package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class InstallConfig implements Serializable {
    private static final long serialVersionUID = 546555599564481045L;
    private String appBtnInstallWay;
    private String creativeInstallWay;

    public String Code() {
        return this.creativeInstallWay;
    }

    public void Code(String str) {
        this.creativeInstallWay = str;
    }

    public String V() {
        return this.appBtnInstallWay;
    }

    public void V(String str) {
        this.appBtnInstallWay = str;
    }
}
