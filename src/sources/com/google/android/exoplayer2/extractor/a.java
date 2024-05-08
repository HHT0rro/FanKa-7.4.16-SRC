package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.m;

/* compiled from: CeaUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    public static void a(long j10, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        while (true) {
            if (parsableByteArray.a() <= 1) {
                return;
            }
            int c4 = c(parsableByteArray);
            int c10 = c(parsableByteArray);
            int e2 = parsableByteArray.e() + c10;
            if (c10 == -1 || c10 > parsableByteArray.a()) {
                m.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                e2 = parsableByteArray.f();
            } else if (c4 == 4 && c10 >= 8) {
                int D = parsableByteArray.D();
                int J = parsableByteArray.J();
                int n10 = J == 49 ? parsableByteArray.n() : 0;
                int D2 = parsableByteArray.D();
                if (J == 47) {
                    parsableByteArray.Q(1);
                }
                boolean z10 = D == 181 && (J == 49 || J == 47) && D2 == 3;
                if (J == 49) {
                    z10 &= n10 == 1195456820;
                }
                if (z10) {
                    b(j10, parsableByteArray, trackOutputArr);
                }
            }
            parsableByteArray.P(e2);
        }
    }

    public static void b(long j10, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int D = parsableByteArray.D();
        if ((D & 64) != 0) {
            parsableByteArray.Q(1);
            int i10 = (D & 31) * 3;
            int e2 = parsableByteArray.e();
            for (TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.P(e2);
                trackOutput.a(parsableByteArray, i10);
                if (j10 != -9223372036854775807L) {
                    trackOutput.d(j10, 1, i10, 0, null);
                }
            }
        }
    }

    public static int c(ParsableByteArray parsableByteArray) {
        int i10 = 0;
        while (parsableByteArray.a() != 0) {
            int D = parsableByteArray.D();
            i10 += D;
            if (D != 255) {
                return i10;
            }
        }
        return -1;
    }
}
