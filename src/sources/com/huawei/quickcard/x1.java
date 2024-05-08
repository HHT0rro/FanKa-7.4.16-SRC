package com.huawei.quickcard;

import com.huawei.quickcard.base.BuildConfig;
import com.huawei.quickcard.cardmanager.config.VersionConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class x1 implements VersionConfig {
    @Override // com.huawei.quickcard.cardmanager.config.VersionConfig
    public int getPlatformVersion() {
        return 1012;
    }

    @Override // com.huawei.quickcard.cardmanager.config.VersionConfig
    public String getSdkVersionName() {
        return BuildConfig.QUICKCARD_ENGINE_VERSION_NAME;
    }
}
