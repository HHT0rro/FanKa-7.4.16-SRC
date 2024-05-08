package com.huawei.hmf.orb.aidl.communicate;

import com.huawei.hmf.orb.IMessageEntity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CallObject {
    private boolean export;
    public Class<? extends AIDLRequest<?>> requestClass = null;

    public CallObject(boolean z10) {
        this.export = z10;
    }

    public boolean isExport() {
        return this.export;
    }

    public AIDLRequest<IMessageEntity> makeRequest() {
        try {
            return (AIDLRequest) this.requestClass.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return "CallObject{export=" + this.export + ", requestClass=" + this.requestClass.getName() + '}';
    }
}
