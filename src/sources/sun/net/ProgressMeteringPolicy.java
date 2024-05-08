package sun.net;

import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ProgressMeteringPolicy {
    int getProgressUpdateThreshold();

    boolean shouldMeterInput(URL url, String str);
}
