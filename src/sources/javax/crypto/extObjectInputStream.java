package javax.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: SealedObject.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class extObjectInputStream extends ObjectInputStream {
    private static ClassLoader systemClassLoader = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public extObjectInputStream(InputStream in) throws IOException, StreamCorruptedException {
        super(in);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass v2) throws IOException, ClassNotFoundException {
        try {
            return super.resolveClass(v2);
        } catch (ClassNotFoundException e2) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                if (systemClassLoader == null) {
                    systemClassLoader = ClassLoader.getSystemClassLoader();
                }
                loader = systemClassLoader;
                if (loader == null) {
                    throw new ClassNotFoundException(v2.getName());
                }
            }
            return Class.forName(v2.getName(), false, loader);
        }
    }
}
