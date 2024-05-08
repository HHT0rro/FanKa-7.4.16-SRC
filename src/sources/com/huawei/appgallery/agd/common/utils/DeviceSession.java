package com.huawei.appgallery.agd.common.utils;

import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.support.storage.BaseSharedPreference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DeviceSession {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f27377c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static DeviceSession f27378d;

    /* renamed from: a, reason: collision with root package name */
    public final BaseSharedPreference f27379a = new BaseSharedPreference(ApplicationWrapper.getInstance().getContext());

    /* renamed from: b, reason: collision with root package name */
    public String f27380b;

    public static DeviceSession getSession() {
        DeviceSession deviceSession;
        synchronized (f27377c) {
            if (f27378d == null) {
                f27378d = new DeviceSession();
            }
            deviceSession = f27378d;
        }
        return deviceSession;
    }

    public String getServiceZone() {
        return this.f27379a.getString("appstore.service.zone", "");
    }

    public String getThirdId() {
        return this.f27380b;
    }

    public int getVersionCode() {
        return this.f27379a.getInt("appstore.client.version.code.param", -1);
    }

    public void setServiceZone(String str) {
        this.f27379a.putString("appstore.service.zone", str);
    }

    public void setThirdId(String str) {
        this.f27380b = str;
    }

    public void setVersionCode(int i10) {
        this.f27379a.putInt("appstore.client.version.code.param", i10);
    }
}
