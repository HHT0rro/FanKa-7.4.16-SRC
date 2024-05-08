package javax.net.ssl;

import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SSLSessionContext {
    Enumeration<byte[]> getIds();

    SSLSession getSession(byte[] bArr);

    int getSessionCacheSize();

    int getSessionTimeout();

    void setSessionCacheSize(int i10) throws IllegalArgumentException;

    void setSessionTimeout(int i10) throws IllegalArgumentException;
}
