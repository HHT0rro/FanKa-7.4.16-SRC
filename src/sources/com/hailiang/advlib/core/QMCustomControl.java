package com.hailiang.advlib.core;

import android.content.pm.PackageInfo;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class QMCustomControl {
    public String getAndroidId() {
        return null;
    }

    public List<PackageInfo> getAppList() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevImsi() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public String getOaid() {
        return null;
    }

    public IQLocation getQLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }
}
