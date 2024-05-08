package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.s0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface SampleStream {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public @interface ReadDataResult {
    }

    void a() throws IOException;

    int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10);

    boolean isReady();

    int l(long j10);
}
