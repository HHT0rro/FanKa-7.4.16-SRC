package com.huawei.quickcard;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.huawei.quickcard.utils.StrUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f0 implements IManufacturerDeviceInfo {

    /* renamed from: b, reason: collision with root package name */
    private static final String f33668b = "HiHonorDeviceInfo";

    /* renamed from: a, reason: collision with root package name */
    private final String f33669a;

    public f0(String str) {
        this.f33669a = StrUtils.null2Empty(str);
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    @NonNull
    public h0 getFoldedState() {
        CardLogUtils.d(f33668b, "invoke getFoldState, manufacturer::" + manufacturerName() + ", os::" + osType());
        return h0.UNKNOWN;
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public boolean isFoldable() {
        return false;
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public String manufacturerName() {
        return this.f33669a;
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public /* synthetic */ String osType() {
        return com.huawei.quickcard.framework.configuration.device.a.a(this);
    }
}
