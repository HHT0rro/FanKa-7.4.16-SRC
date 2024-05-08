package jb;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FlushedInputStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends FilterInputStream {
    public b(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long j11 = 0;
        while (j11 < j10) {
            long skip = this.in.skip(j10 - j11);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j11 += skip;
        }
        return j11;
    }
}
