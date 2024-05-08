package com.kwad.framework.filedownloader.download;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public final long afO;
    public final long afP;
    public final long afQ;
    public final long contentLength;

    public a(long j10, long j11, long j12, long j13) {
        this.afO = j10;
        this.afP = j11;
        this.afQ = j12;
        this.contentLength = j13;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("range[%d, %d) current offset[%d]", Long.valueOf(this.afO), Long.valueOf(this.afQ), Long.valueOf(this.afP));
    }
}
