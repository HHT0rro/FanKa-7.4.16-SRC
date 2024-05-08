package java.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "1.2")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Certificate {
    void decode(InputStream inputStream) throws KeyException, IOException;

    void encode(OutputStream outputStream) throws KeyException, IOException;

    String getFormat();

    Principal getGuarantor();

    Principal getPrincipal();

    PublicKey getPublicKey();

    String toString(boolean z10);
}
