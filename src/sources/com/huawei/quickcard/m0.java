package com.huawei.quickcard;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.ReflectUtils;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.huawei.quickcard.utils.DeviceInfoUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m0 implements IManufacturerDeviceInfo {

    /* renamed from: b, reason: collision with root package name */
    public static final String f34108b = "HONOR";

    /* renamed from: c, reason: collision with root package name */
    private static final String f34109c = "HiHonorDeviceInfo";

    /* renamed from: a, reason: collision with root package name */
    private Boolean f34110a = null;

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    @NonNull
    public h0 getFoldedState() {
        CardLogUtils.d(f34109c, "invoke getFoldState, manufacturer::" + manufacturerName() + ", os::" + osType());
        Object reflectPublicMethodSimply = ReflectUtils.reflectPublicMethodSimply("com.hihonor.android.fsm.HwFoldScreenManagerEx", "getFoldableState");
        return DeviceInfoUtils.transformFoldState(reflectPublicMethodSimply instanceof Integer ? ((Integer) reflectPublicMethodSimply).intValue() : 0);
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public boolean isFoldable() {
        if (this.f34110a == null) {
            this.f34110a = Boolean.FALSE;
            Object reflectPublicMethodSimply = ReflectUtils.reflectPublicMethodSimply("com.hihonor.android.fsm.HwFoldScreenManagerEx", "isFoldable");
            if (reflectPublicMethodSimply instanceof Boolean) {
                this.f34110a = (Boolean) reflectPublicMethodSimply;
            }
        }
        return this.f34110a.booleanValue();
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public String manufacturerName() {
        return "HONOR";
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public /* synthetic */ String osType() {
        return com.huawei.quickcard.framework.configuration.device.a.a(this);
    }
}
