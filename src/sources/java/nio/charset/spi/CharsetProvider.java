package java.nio.charset.spi;

import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CharsetProvider {
    public abstract Charset charsetForName(String str);

    public abstract Iterator<Charset> charsets();

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("charsetProvider"));
            return null;
        }
        return null;
    }

    private CharsetProvider(Void ignore) {
    }

    protected CharsetProvider() {
        this(checkPermission());
    }
}
