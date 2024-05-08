package b6;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.h0;

/* compiled from: RtspTrackTiming.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final long f1374a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1375b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f1376c;

    public y(long j10, int i10, Uri uri) {
        this.f1374a = j10;
        this.f1375b = i10;
        this.f1376c = uri;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #0 {Exception -> 0x008d, blocks: (B:7:0x0027, B:19:0x006f, B:24:0x0074, B:25:0x0079, B:28:0x007a, B:29:0x0081, B:31:0x0049, B:34:0x0053, B:37:0x005d), top: B:6:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.common.collect.ImmutableList<b6.y> a(java.lang.String r18, android.net.Uri r19) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.common.collect.ImmutableList$a r0 = new com.google.common.collect.ImmutableList$a
            r0.<init>()
            java.lang.String r1 = ","
            r2 = r18
            java.lang.String[] r1 = com.google.android.exoplayer2.util.j0.M0(r2, r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L10:
            if (r4 >= r2) goto Lc1
            r5 = r1[r4]
            java.lang.String r6 = ";"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.j0.M0(r5, r6)
            int r7 = r6.length
            r12 = 0
            r13 = 0
            r14 = -1
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L23:
            if (r12 >= r7) goto L93
            r8 = r6[r12]
            java.lang.String r9 = "="
            java.lang.String[] r9 = com.google.android.exoplayer2.util.j0.N0(r8, r9)     // Catch: java.lang.Exception -> L8d
            r11 = r9[r3]     // Catch: java.lang.Exception -> L8d
            r3 = 1
            r9 = r9[r3]     // Catch: java.lang.Exception -> L8d
            int r10 = r11.hashCode()     // Catch: java.lang.Exception -> L8d
            r3 = 113759(0x1bc5f, float:1.5941E-40)
            r17 = r1
            r1 = 2
            if (r10 == r3) goto L5d
            r3 = 116079(0x1c56f, float:1.62661E-40)
            if (r10 == r3) goto L53
            r3 = 1524180539(0x5ad9263b, float:3.05610524E16)
            if (r10 == r3) goto L49
            goto L67
        L49:
            java.lang.String r3 = "rtptime"
            boolean r3 = r11.equals(r3)     // Catch: java.lang.Exception -> L8d
            if (r3 == 0) goto L67
            r3 = 2
            goto L68
        L53:
            java.lang.String r3 = "url"
            boolean r3 = r11.equals(r3)     // Catch: java.lang.Exception -> L8d
            if (r3 == 0) goto L67
            r3 = 0
            goto L68
        L5d:
            java.lang.String r3 = "seq"
            boolean r3 = r11.equals(r3)     // Catch: java.lang.Exception -> L8d
            if (r3 == 0) goto L67
            r3 = 1
            goto L68
        L67:
            r3 = -1
        L68:
            if (r3 == 0) goto L81
            r10 = 1
            if (r3 == r10) goto L7a
            if (r3 != r1) goto L74
            long r15 = java.lang.Long.parseLong(r9)     // Catch: java.lang.Exception -> L8d
            goto L7e
        L74:
            r0 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r11, r0)     // Catch: java.lang.Exception -> L8d
            throw r0     // Catch: java.lang.Exception -> L8d
        L7a:
            int r14 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.Exception -> L8d
        L7e:
            r1 = r19
            goto L87
        L81:
            r1 = r19
            android.net.Uri r13 = b(r9, r1)     // Catch: java.lang.Exception -> L8d
        L87:
            int r12 = r12 + 1
            r1 = r17
            r3 = 0
            goto L23
        L8d:
            r0 = move-exception
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r8, r0)
            throw r0
        L93:
            r17 = r1
            r1 = r19
            if (r13 == 0) goto Lbb
            java.lang.String r3 = r13.getScheme()
            if (r3 == 0) goto Lbb
            r3 = -1
            r8 = r15
            if (r14 != r3) goto Lac
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 == 0) goto Lbb
        Lac:
            b6.y r3 = new b6.y
            r3.<init>(r8, r14, r13)
            r0.a(r3)
            int r4 = r4 + 1
            r1 = r17
            r3 = 0
            goto L10
        Lbb:
            r0 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r5, r0)
            throw r0
        Lc1:
            com.google.common.collect.ImmutableList r0 = r0.k()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.y.a(java.lang.String, android.net.Uri):com.google.common.collect.ImmutableList");
    }

    @VisibleForTesting
    public static Uri b(String str, Uri uri) {
        com.google.android.exoplayer2.util.a.a(((String) com.google.android.exoplayer2.util.a.e(uri.getScheme())).equals("rtsp"));
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        String valueOf = String.valueOf(str);
        Uri parse2 = Uri.parse(valueOf.length() != 0 ? "rtsp://".concat(valueOf) : new String("rtsp://"));
        String uri2 = uri.toString();
        if (((String) com.google.android.exoplayer2.util.a.e(parse2.getHost())).equals(uri.getHost())) {
            return parse2;
        }
        if (uri2.endsWith("/")) {
            return h0.e(uri2, str);
        }
        return h0.e(uri2.concat("/"), str);
    }
}
