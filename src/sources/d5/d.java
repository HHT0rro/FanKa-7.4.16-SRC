package d5;

import java.io.IOException;

/* compiled from: ExtractorInput.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface d extends o6.g {
    long b();

    boolean f(byte[] bArr, int i10, int i11, boolean z10) throws IOException;

    int g(int i10) throws IOException;

    long getPosition();

    int h(byte[] bArr, int i10, int i11) throws IOException;

    void j(byte[] bArr, int i10, int i11) throws IOException;

    boolean l(byte[] bArr, int i10, int i11, boolean z10) throws IOException;

    void m();

    long o();

    void q(int i10) throws IOException;

    void r(int i10) throws IOException;

    @Override // o6.g
    int read(byte[] bArr, int i10, int i11) throws IOException;

    void readFully(byte[] bArr, int i10, int i11) throws IOException;

    boolean s(int i10, boolean z10) throws IOException;
}
