package com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data;

import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class BaseIPCRequest extends AutoParcelable {
    public static final String CALL_TYPE_AGD_PRO_SDK = "AGDPROSDK";
    public static final String CALL_TYPE_AGD_SDK = "AGDSDK";

    /* renamed from: b, reason: collision with root package name */
    public String f27575b;

    public String getMediaPkg() {
        return this.f27575b;
    }

    public abstract String getMethod();

    public void setCallType(String str) {
    }

    public void setMediaPkg(String str) {
        this.f27575b = str;
    }
}
