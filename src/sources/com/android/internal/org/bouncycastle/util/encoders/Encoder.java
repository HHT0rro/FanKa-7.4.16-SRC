package com.android.internal.org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Encoder {
    int decode(String str, OutputStream outputStream) throws IOException;

    int decode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException;

    int encode(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException;
}
