package java.security.cert;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface X509Extension {
    Set<String> getCriticalExtensionOIDs();

    byte[] getExtensionValue(String str);

    Set<String> getNonCriticalExtensionOIDs();

    boolean hasUnsupportedCriticalExtension();
}
