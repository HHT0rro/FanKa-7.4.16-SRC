package com.huawei.hms.ads.dynamicloader.versionstrategy;

import com.huawei.hms.ads.uiengineloader.af;
import com.huawei.hms.ads.uiengineloader.ag;
import com.huawei.hms.ads.uiengineloader.ah;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VersionStrategyFactory {
    public static final int PREFER_DECOMPRESS = 1;
    public static final int PREFER_HIGHEST_OR_DECOMPRESS = 2;

    public static ah getVersionPolicy(int i10) {
        if (i10 == 1) {
            return new af();
        }
        if (i10 != 2) {
            return null;
        }
        return new ag();
    }
}
