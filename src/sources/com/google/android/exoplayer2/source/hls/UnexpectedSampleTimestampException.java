package com.google.android.exoplayer2.source.hls;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final x5.n mediaChunk;
    public final long rejectedSampleTimeUs;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UnexpectedSampleTimestampException(x5.n r9, long r10, long r12) {
        /*
            r8 = this;
            long r0 = com.google.android.exoplayer2.h.e(r12)
            long r2 = r9.f54512g
            long r4 = r9.f54513h
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 103(0x67, float:1.44E-43)
            r6.<init>(r7)
            java.lang.String r7 = "Unexpected sample timestamp: "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r0 = " in chunk ["
            r6.append(r0)
            r6.append(r2)
            java.lang.String r0 = ", "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = "]"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r8.<init>(r0)
            r8.mediaChunk = r9
            r8.lastAcceptedSampleTimeUs = r10
            r8.rejectedSampleTimeUs = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.UnexpectedSampleTimestampException.<init>(x5.n, long, long):void");
    }
}
