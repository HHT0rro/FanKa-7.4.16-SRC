package com.google.android.exoplayer2.extractor;

import d5.n;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface Extractor {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public @interface ReadResult {
    }

    void a(long j10, long j11);

    void b(d5.e eVar);

    int f(d5.d dVar, n nVar) throws IOException;

    boolean g(d5.d dVar) throws IOException;

    void release();
}
