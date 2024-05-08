package java.security.cert;

import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Extension {
    void encode(OutputStream outputStream) throws IOException;

    String getId();

    byte[] getValue();

    boolean isCritical();
}
