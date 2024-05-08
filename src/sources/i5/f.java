package i5;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: Sniffer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f49799a = new ParsableByteArray(8);

    /* renamed from: b, reason: collision with root package name */
    public int f49800b;

    public final long a(d5.d dVar) throws IOException {
        int i10 = 0;
        dVar.j(this.f49799a.d(), 0, 1);
        int i11 = this.f49799a.d()[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (~i12);
        dVar.j(this.f49799a.d(), 1, i13);
        while (i10 < i13) {
            i10++;
            i14 = (this.f49799a.d()[i10] & 255) + (i14 << 8);
        }
        this.f49800b += i13 + 1;
        return i14;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(d5.d r18) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            long r2 = r18.b()
            r4 = 1024(0x400, double:5.06E-321)
            r6 = -1
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L16
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L15
            goto L16
        L15:
            r4 = r2
        L16:
            int r5 = (int) r4
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r0.f49799a
            byte[] r4 = r4.d()
            r6 = 0
            r7 = 4
            r1.j(r4, r6, r7)
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r0.f49799a
            long r9 = r4.F()
            r0.f49800b = r7
        L2a:
            r11 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r4 = 1
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L56
            int r7 = r0.f49800b
            int r7 = r7 + r4
            r0.f49800b = r7
            if (r7 != r5) goto L3a
            return r6
        L3a:
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r0.f49799a
            byte[] r7 = r7.d()
            r1.j(r7, r6, r4)
            r4 = 8
            long r9 = r9 << r4
            r11 = -256(0xffffffffffffff00, double:NaN)
            long r9 = r9 & r11
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r0.f49799a
            byte[] r4 = r4.d()
            r4 = r4[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r9 = r9 | r11
            goto L2a
        L56:
            long r9 = r17.a(r18)
            int r5 = r0.f49800b
            long r11 = (long) r5
            r13 = -9223372036854775808
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 == 0) goto La3
            if (r8 == 0) goto L6c
            long r7 = r11 + r9
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 < 0) goto L6c
            goto La3
        L6c:
            int r2 = r0.f49800b
            long r7 = (long) r2
            long r15 = r11 + r9
            int r3 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r3 >= 0) goto L9d
            long r2 = r17.a(r18)
            int r5 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r5 != 0) goto L7e
            return r6
        L7e:
            long r2 = r17.a(r18)
            r7 = 0
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 < 0) goto L9c
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r15 <= 0) goto L90
            goto L9c
        L90:
            if (r5 == 0) goto L6c
            int r3 = (int) r2
            r1.q(r3)
            int r2 = r0.f49800b
            int r2 = r2 + r3
            r0.f49800b = r2
            goto L6c
        L9c:
            return r6
        L9d:
            long r1 = (long) r2
            int r3 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r3 != 0) goto La3
            r6 = 1
        La3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.b(d5.d):boolean");
    }
}
