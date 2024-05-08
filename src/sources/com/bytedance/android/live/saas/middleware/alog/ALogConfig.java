package com.bytedance.android.live.saas.middleware.alog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ALogConfig {
    private ILogProtocol aLogService;
    private boolean isDebug;
    private boolean standalone;

    public ALogConfig(ILogProtocol iLogProtocol, boolean z10) {
        this(iLogProtocol, z10, false);
    }

    public ALogConfig(ILogProtocol iLogProtocol, boolean z10, boolean z11) {
        this.aLogService = iLogProtocol;
        this.standalone = z10;
        this.isDebug = z11;
    }

    public ILogProtocol getALogService() {
        return this.aLogService;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void setALogService(ILogProtocol iLogProtocol) {
        this.aLogService = iLogProtocol;
    }

    public void setDebug(boolean z10) {
        this.isDebug = z10;
    }

    public void setStandalone(boolean z10) {
        this.standalone = z10;
    }
}
