package java.nio.file;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DirectoryStream<T> extends Closeable, Iterable<T> {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Filter<T> {
        boolean accept(T t2) throws IOException;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    Iterator<T> iterator2();
}
