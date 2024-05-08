package com.kwad.framework.filedownloader.event;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus ahf;
    private final Class<?> ahg;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.ahf = connectStatus;
        this.ahg = cls;
    }

    public final ConnectStatus vT() {
        return this.ahf;
    }
}
