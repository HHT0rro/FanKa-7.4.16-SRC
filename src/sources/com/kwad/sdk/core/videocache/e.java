package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends k {
    private final p aBR;
    private final com.kwad.sdk.core.videocache.a.b aBS;
    private b aBT;

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.aBS = bVar;
        this.aBR = pVar;
    }

    private String b(d dVar) {
        String Gy = this.aBR.Gy();
        boolean z10 = !TextUtils.isEmpty(Gy);
        long Go = this.aBS.isCompleted() ? this.aBS.Go() : this.aBR.length();
        boolean z11 = Go >= 0;
        boolean z12 = dVar.aBQ;
        long j10 = z12 ? Go - dVar.aBP : Go;
        boolean z13 = z11 && z12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dVar.aBQ ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb2.append("Accept-Ranges: bytes\n");
        sb2.append(z11 ? format("Content-Length: %d\n", Long.valueOf(j10)) : "");
        sb2.append(z13 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aBP), Long.valueOf(Go - 1), Long.valueOf(Go)) : "");
        sb2.append(z10 ? format("Content-Type: %s\n", Gy) : "");
        sb2.append("\n");
        return sb2.toString();
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.aBT = bVar;
    }

    @Override // com.kwad.sdk.core.videocache.k
    public final void dr(int i10) {
        b bVar = this.aBT;
        if (bVar != null) {
            bVar.a(this.aBS.file, i10);
        }
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j10 = dVar.aBP;
        if (a(dVar)) {
            a(bufferedOutputStream, j10);
        } else {
            b(bufferedOutputStream, j10);
        }
    }

    private boolean a(d dVar) {
        long length = this.aBR.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.aBQ && ((float) dVar.aBP) > ((float) this.aBS.Go()) + (((float) length) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j10) {
        byte[] bArr = new byte[1024];
        while (true) {
            int a10 = a(bArr, j10, 1024);
            if (a10 == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, a10);
                j10 += a10;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[Catch: all -> 0x0037, LOOP:0: B:8:0x0024->B:10:0x002b, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:7:0x001d, B:8:0x0024, B:10:0x002b, B:12:0x0030), top: B:6:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.io.OutputStream r3, long r4) {
        /*
            r2 = this;
            com.kwad.sdk.core.videocache.p r0 = r2.aBR
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.h
            if (r1 == 0) goto Lf
            com.kwad.sdk.core.videocache.h r1 = new com.kwad.sdk.core.videocache.h
            com.kwad.sdk.core.videocache.h r0 = (com.kwad.sdk.core.videocache.h) r0
            r1.<init>(r0)
        Ld:
            r0 = r1
            goto L1b
        Lf:
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.j
            if (r1 == 0) goto L1b
            com.kwad.sdk.core.videocache.j r1 = new com.kwad.sdk.core.videocache.j
            com.kwad.sdk.core.videocache.j r0 = (com.kwad.sdk.core.videocache.j) r0
            r1.<init>(r0)
            goto Ld
        L1b:
            int r5 = (int) r4
            long r4 = (long) r5
            r0.at(r4)     // Catch: java.lang.Throwable -> L37
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L37
        L24:
            int r5 = r0.read(r4)     // Catch: java.lang.Throwable -> L37
            r1 = -1
            if (r5 == r1) goto L30
            r1 = 0
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L37
            goto L24
        L30:
            r3.flush()     // Catch: java.lang.Throwable -> L37
            r0.close()
            return
        L37:
            r3 = move-exception
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.e.b(java.io.OutputStream, long):void");
    }
}
