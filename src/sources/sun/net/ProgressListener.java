package sun.net;

import java.util.EventListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ProgressListener extends EventListener {
    void progressFinish(ProgressEvent progressEvent);

    void progressStart(ProgressEvent progressEvent);

    void progressUpdate(ProgressEvent progressEvent);
}
