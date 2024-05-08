package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class DefaultFileSystem {
    DefaultFileSystem() {
    }

    public static FileSystem getFileSystem() {
        return new UnixFileSystem();
    }
}
