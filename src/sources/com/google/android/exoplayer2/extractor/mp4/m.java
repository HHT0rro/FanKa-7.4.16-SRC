package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: Sniffer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f20227a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i10, boolean z10) {
        if ((i10 >>> 8) == 3368816) {
            return true;
        }
        if (i10 == 1751476579 && z10) {
            return true;
        }
        for (int i11 : f20227a) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(d5.d dVar) throws IOException {
        return c(dVar, true, false);
    }

    public static boolean c(d5.d dVar, boolean z10, boolean z11) throws IOException {
        boolean z12;
        long b4 = dVar.b();
        long j10 = 4096;
        long j11 = -1;
        if (b4 != -1 && b4 <= 4096) {
            j10 = b4;
        }
        int i10 = (int) j10;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z13 = false;
        int i11 = 0;
        boolean z14 = false;
        while (i11 < i10) {
            parsableByteArray.L(8);
            if (!dVar.l(parsableByteArray.d(), z13 ? 1 : 0, 8, true)) {
                break;
            }
            long F = parsableByteArray.F();
            int n10 = parsableByteArray.n();
            int i12 = 16;
            if (F == 1) {
                dVar.j(parsableByteArray.d(), 8, 8);
                parsableByteArray.O(16);
                F = parsableByteArray.w();
            } else {
                if (F == 0) {
                    long b10 = dVar.b();
                    if (b10 != j11) {
                        F = (b10 - dVar.o()) + 8;
                    }
                }
                i12 = 8;
            }
            long j12 = i12;
            if (F < j12) {
                return z13;
            }
            i11 += i12;
            if (n10 == 1836019574) {
                i10 += (int) F;
                if (b4 != -1 && i10 > b4) {
                    i10 = (int) b4;
                }
                j11 = -1;
            } else {
                if (n10 == 1836019558 || n10 == 1836475768) {
                    z12 = true;
                    break;
                }
                long j13 = b4;
                if ((i11 + F) - j12 >= i10) {
                    break;
                }
                int i13 = (int) (F - j12);
                i11 += i13;
                if (n10 == 1718909296) {
                    if (i13 < 8) {
                        return false;
                    }
                    parsableByteArray.L(i13);
                    dVar.j(parsableByteArray.d(), 0, i13);
                    int i14 = i13 / 4;
                    int i15 = 0;
                    while (true) {
                        if (i15 >= i14) {
                            break;
                        }
                        if (i15 == 1) {
                            parsableByteArray.Q(4);
                        } else if (a(parsableByteArray.n(), z11)) {
                            z14 = true;
                            break;
                        }
                        i15++;
                    }
                    if (!z14) {
                        return false;
                    }
                } else if (i13 != 0) {
                    dVar.q(i13);
                }
                b4 = j13;
                j11 = -1;
                z13 = false;
            }
        }
        z12 = false;
        return z14 && z10 == z12;
    }

    public static boolean d(d5.d dVar, boolean z10) throws IOException {
        return c(dVar, false, z10);
    }
}
