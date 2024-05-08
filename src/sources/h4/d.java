package h4;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface d {
    InputStream a() throws IOException;

    int available() throws IOException;

    int b();

    void close() throws IOException;

    byte peek() throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    void reset() throws IOException;

    long skip(long j10) throws IOException;
}
