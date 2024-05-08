package o6;

import java.io.IOException;

/* compiled from: DataSink.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface i {

    /* compiled from: DataSink.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        i a();
    }

    void a(com.google.android.exoplayer2.upstream.b bVar) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i10, int i11) throws IOException;
}
