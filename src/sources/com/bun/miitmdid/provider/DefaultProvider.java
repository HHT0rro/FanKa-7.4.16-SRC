package com.bun.miitmdid.provider;

import com.bun.miitmdid.interfaces.IdSupplier;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DefaultProvider implements IdSupplier {
    public String AAID;
    public String OAID;
    public String VAID;
    public boolean isSupport;

    public DefaultProvider() {
        this.OAID = "";
        this.VAID = "";
        this.AAID = "";
        this.isSupport = false;
    }

    public DefaultProvider(String str, String str2, String str3, boolean z10) {
        this.OAID = str;
        this.VAID = str2;
        this.AAID = str3;
        this.isSupport = z10;
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getAAID() {
        return (String) Utils.rL(new Object[]{this, 41, 1598952044263L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getOAID() {
        return (String) Utils.rL(new Object[]{this, 42, 1598952044264L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public String getVAID() {
        return (String) Utils.rL(new Object[]{this, 43, 1598952044265L});
    }

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 44, 1598952044266L})).booleanValue();
    }
}
