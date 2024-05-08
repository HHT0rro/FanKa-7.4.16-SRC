package com.kwad.sdk.core.imageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
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
