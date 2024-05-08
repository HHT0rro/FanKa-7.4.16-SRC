package sun.nio.fs;

import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
interface DynamicFileAttributeView {
    Map<String, Object> readAttributes(String[] strArr) throws IOException;

    void setAttribute(String str, Object obj) throws IOException;
}
