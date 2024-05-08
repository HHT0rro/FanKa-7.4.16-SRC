package com.bytedance.android.live.saas.middleware.applog;

import com.bytedance.android.live.base.api.IHostPermission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AppLogConfig {
    private String appLogId;
    private IHostPermission hostPermission;
    private IAppLog impl;
    private boolean isToBVersion;
    private boolean standalone;

    public AppLogConfig() {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
    }

    public AppLogConfig(IAppLog iAppLog, boolean z10) {
        this(iAppLog, z10, false);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z10, boolean z11) {
        this(iAppLog, z10, z11, null);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z10, boolean z11, String str) {
        this(iAppLog, z10, z11, str, null);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z10, boolean z11, String str, IHostPermission iHostPermission) {
        this.impl = iAppLog;
        this.standalone = z10;
        this.isToBVersion = z11;
        this.appLogId = str;
        this.hostPermission = iHostPermission;
    }

    public String getAppLogId() {
        return this.appLogId;
    }

    public IHostPermission getHostPermission() {
        return this.hostPermission;
    }

    public IAppLog getImpl() {
        return this.impl;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isToBVersion() {
        return this.isToBVersion;
    }

    public void setAppLogId(String str) {
        this.appLogId = str;
    }

    public void setHostPermission(IHostPermission iHostPermission) {
        this.hostPermission = iHostPermission;
    }

    public void setImpl(IAppLog iAppLog) {
        this.impl = iAppLog;
    }

    public void setStandalone(boolean z10) {
        this.standalone = z10;
    }

    public void setToBVersion(boolean z10) {
        this.isToBVersion = z10;
    }
}
