package com.huawei.hmf.orb.aidl.communicate;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ClientIdentity {
    public String appID;
    public String packageName;

    public ClientIdentity() {
    }

    public boolean isCore() {
        return true;
    }

    public boolean isValid() {
        return !(TextUtils.isEmpty(this.appID) || TextUtils.isEmpty(this.packageName));
    }

    public String toString() {
        return "ClientIdentity{appID='" + this.appID + "', packageName='" + this.packageName + "'}";
    }

    public ClientIdentity(RequestHeader requestHeader) {
        this.appID = requestHeader.appId;
        this.packageName = requestHeader.packageName;
    }
}
