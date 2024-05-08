package java.nio.file;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface FileVisitor<T> {
    FileVisitResult postVisitDirectory(T t2, IOException iOException) throws IOException;

    FileVisitResult preVisitDirectory(T t2, BasicFileAttributes basicFileAttributes) throws IOException;

    FileVisitResult visitFile(T t2, BasicFileAttributes basicFileAttributes) throws IOException;

    FileVisitResult visitFileFailed(T t2, IOException iOException) throws IOException;
}
