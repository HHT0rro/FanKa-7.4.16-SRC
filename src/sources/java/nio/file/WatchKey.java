package java.nio.file;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface WatchKey {
    void cancel();

    boolean isValid();

    List<WatchEvent<?>> pollEvents();

    boolean reset();

    Watchable watchable();
}
