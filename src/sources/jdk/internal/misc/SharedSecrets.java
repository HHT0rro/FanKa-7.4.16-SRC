package jdk.internal.misc;

import java.io.ObjectInputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SharedSecrets {
    private static JavaIOFileDescriptorAccess javaIOFileDescriptorAccess;
    private static JavaObjectInputStreamAccess javaObjectInputStreamAccess;
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void setJavaIOFileDescriptorAccess(JavaIOFileDescriptorAccess jiofda) {
        javaIOFileDescriptorAccess = jiofda;
    }

    public static JavaIOFileDescriptorAccess getJavaIOFileDescriptorAccess() {
        if (javaIOFileDescriptorAccess == null) {
            try {
                Class.forName("java.io.FileDescriptor");
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return javaIOFileDescriptorAccess;
    }

    public static JavaObjectInputStreamAccess getJavaObjectInputStreamAccess() {
        if (javaObjectInputStreamAccess == null) {
            unsafe.ensureClassInitialized(ObjectInputStream.class);
        }
        return javaObjectInputStreamAccess;
    }

    public static void setJavaObjectInputStreamAccess(JavaObjectInputStreamAccess access) {
        javaObjectInputStreamAccess = access;
    }
}
