package jdk.internal.misc;

import java.io.InvalidClassException;
import java.io.ObjectInputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@FunctionalInterface
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface JavaObjectInputStreamAccess {
    void checkArray(ObjectInputStream objectInputStream, Class<?> cls, int i10) throws InvalidClassException;
}