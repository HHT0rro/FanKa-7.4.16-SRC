package com.android.framework.protobuf;

import com.android.framework.protobuf.ArrayDecoders;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Schema<T> {
    boolean equals(T t2, T t10);

    int getSerializedSize(T t2);

    int hashCode(T t2);

    boolean isInitialized(T t2);

    void makeImmutable(T t2);

    void mergeFrom(T t2, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t2, T t10);

    void mergeFrom(T t2, byte[] bArr, int i10, int i11, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t2, Writer writer) throws IOException;
}
