package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e implements DynamicModule.VersionPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29898a = "e";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt("module_version") > 0) {
            Logger.i(f29898a, "Prefer remote: The version of remote module " + str + u.bD + remoteModuleInfo.getInt("module_version"));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt("local_module_version") <= 0) {
            Logger.i(f29898a, "Cannot get module info in remote or local.");
            return new Bundle();
        }
        Logger.i(f29898a, "Choose local: The version of local module " + str + u.bD + localModuleInfo.getInt("local_module_version"));
        return localModuleInfo;
    }
}
