package java.nio.file;

import java.io.IOException;
import java.nio.file.WatchEvent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Watchable {
    WatchKey register(WatchService watchService, WatchEvent.Kind<?>... kindArr) throws IOException;

    WatchKey register(WatchService watchService, WatchEvent.Kind<?>[] kindArr, WatchEvent.Modifier... modifierArr) throws IOException;
}
