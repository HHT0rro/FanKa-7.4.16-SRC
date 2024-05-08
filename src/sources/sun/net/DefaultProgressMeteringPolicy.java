package sun.net;

import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: ProgressMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class DefaultProgressMeteringPolicy implements ProgressMeteringPolicy {
    @Override // sun.net.ProgressMeteringPolicy
    public boolean shouldMeterInput(URL url, String method) {
        return false;
    }

    @Override // sun.net.ProgressMeteringPolicy
    public int getProgressUpdateThreshold() {
        return 8192;
    }
}
