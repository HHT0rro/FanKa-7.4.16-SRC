package com.cupidapp.live.login.model;

import com.irisdt.util.NetworkUtils;
import com.mobile.auth.gatewayauth.Constant;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AliAuthModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum VendorType {
    CMCC(Constant.CMCC, NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_MOBILE),
    CUCC(Constant.CUCC, NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_UNICOM),
    CTCC(Constant.CTCC, NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_TELECOM);


    @NotNull
    private final String vendor;

    @NotNull
    private final String vendorName;

    VendorType(String str, String str2) {
        this.vendor = str;
        this.vendorName = str2;
    }

    @NotNull
    public final String getVendor() {
        return this.vendor;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }
}
