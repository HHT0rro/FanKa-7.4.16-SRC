package com.huawei.quickcard;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.ReflectUtils;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.huawei.quickcard.utils.DeviceInfoUtils;
import com.huawei.quickcard.utils.SystemUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o0 implements IManufacturerDeviceInfo {

    /* renamed from: c, reason: collision with root package name */
    public static final String f34137c = "HUAWEI";

    /* renamed from: d, reason: collision with root package name */
    private static final String f34138d = "HwDeviceInfo";

    /* renamed from: a, reason: collision with root package name */
    private final boolean f34139a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f34140b;

    public o0() {
        this(SystemUtils.isHarmonyOS());
    }

    private boolean a() {
        return (TextUtils.isEmpty(SystemUtils.systemPropertiesGet("ro.config.hw_fold_disp")) && TextUtils.isEmpty(SystemUtils.systemPropertiesGet("persist.sys.fold.disp.size"))) ? false : true;
    }

    private boolean b() {
        Object reflectPublicMethodSimply = ReflectUtils.reflectPublicMethodSimply("com.huawei.android.fsm.HwFoldScreenManagerEx", "isFoldable");
        if (reflectPublicMethodSimply instanceof Boolean) {
            return ((Boolean) reflectPublicMethodSimply).booleanValue();
        }
        return false;
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    @NonNull
    public h0 getFoldedState() {
        CardLogUtils.d(f34138d, "invoke getFoldState, manufacturer::" + manufacturerName() + ", os::" + osType());
        Object reflectPublicMethodSimply = ReflectUtils.reflectPublicMethodSimply("com.huawei.android.fsm.HwFoldScreenManagerEx", "getFoldableState");
        return DeviceInfoUtils.transformFoldState(reflectPublicMethodSimply instanceof Integer ? ((Integer) reflectPublicMethodSimply).intValue() : 0);
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public boolean isFoldable() {
        if (this.f34140b == null) {
            this.f34140b = Boolean.FALSE;
            if (this.f34139a) {
                this.f34140b = Boolean.valueOf(b());
            } else {
                this.f34140b = Boolean.valueOf(a());
            }
        }
        return this.f34140b.booleanValue();
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public String manufacturerName() {
        return "HUAWEI";
    }

    @Override // com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo
    public String osType() {
        return this.f34139a ? IManufacturerDeviceInfo.OS_HARMONY : "android";
    }

    public o0(boolean z10) {
        this.f34140b = null;
        this.f34139a = z10;
    }
}
