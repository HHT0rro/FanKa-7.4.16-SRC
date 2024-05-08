package com.huawei.hmf.services.inject;

import android.app.PendingIntent;
import com.huawei.hmf.orb.aidl.RemoteUIModule;
import com.huawei.hmf.services.Module;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteUIModuleCreator implements InjectInstanceCreator<RemoteUIModule> {
    private final PendingIntent mPendingIntent;

    public RemoteUIModuleCreator(PendingIntent pendingIntent) {
        this.mPendingIntent = pendingIntent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.services.inject.InjectInstanceCreator
    public RemoteUIModule createInstance(Module module, String str) {
        return new RemoteUIModule(module, module.createUIModule(str), this.mPendingIntent);
    }
}
