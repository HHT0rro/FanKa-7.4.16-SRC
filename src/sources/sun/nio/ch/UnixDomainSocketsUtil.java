package sun.nio.ch;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import jdk.internal.util.StaticProperty;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixDomainSocketsUtil {
    private UnixDomainSocketsUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Charset getCharset() {
        return StandardCharsets.UTF_8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getTempDir() {
        return StaticProperty.javaIoTmpDir();
    }
}
