package x4;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import java.nio.ByteBuffer;
import okio.Utf8;

/* compiled from: Ac3Util.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f54366a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f54367b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f54368c = {24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f54369d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f54370e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT, 640};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f54371f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, TTAdConstant.LIVE_FEED_URL_CODE, 487, MetricsProto.MetricsEvent.DIALOG_SERVICE_ACCESS_WARNING, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_PROCESS_OUTGOING_CALLS, MetricsProto.MetricsEvent.WIFI_NETWORK_RECOMMENDATION_SAVED_NETWORK_EVALUATOR, 975, MetricsProto.MetricsEvent.ACTION_TEXT_SELECTION_DRAG, MetricsProto.MetricsEvent.FIELD_SELECTION_SMART_RANGE_END, MetricsProto.MetricsEvent.FIELD_HIDDEN_API_ACCESS_DENIED};

    /* compiled from: Ac3Util.java */
    /* renamed from: x4.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0838b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f54372a;

        /* renamed from: b, reason: collision with root package name */
        public final int f54373b;

        /* renamed from: c, reason: collision with root package name */
        public final int f54374c;

        /* renamed from: d, reason: collision with root package name */
        public final int f54375d;

        /* renamed from: e, reason: collision with root package name */
        public final int f54376e;

        /* renamed from: f, reason: collision with root package name */
        public final int f54377f;

        public C0838b(@Nullable String str, int i10, int i11, int i12, int i13, int i14) {
            this.f54372a = str;
            this.f54373b = i10;
            this.f54375d = i11;
            this.f54374c = i12;
            this.f54376e = i13;
            this.f54377f = i14;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i10 = position; i10 <= limit; i10++) {
            if ((j0.H(byteBuffer, i10 + 4) & (-2)) == -126718022) {
                return i10 - position;
            }
        }
        return -1;
    }

    public static int b(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0) {
            return -1;
        }
        int[] iArr = f54367b;
        if (i10 >= iArr.length || i11 < 0) {
            return -1;
        }
        int[] iArr2 = f54371f;
        if (i12 >= iArr2.length) {
            return -1;
        }
        int i13 = iArr[i10];
        if (i13 == 44100) {
            return (iArr2[i12] + (i11 % 2)) * 2;
        }
        int i14 = f54370e[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }

    public static Format c(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        int i10 = f54367b[(parsableByteArray.D() & 192) >> 6];
        int D = parsableByteArray.D();
        int i11 = f54369d[(D & 56) >> 3];
        if ((D & 4) != 0) {
            i11++;
        }
        return new Format.b().S(str).e0("audio/ac3").H(i11).f0(i10).L(drmInitData).V(str2).E();
    }

    public static int d(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f54366a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static C0838b e(com.google.android.exoplayer2.util.u uVar) {
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int h10;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int e2 = uVar.e();
        uVar.r(40);
        boolean z10 = uVar.h(5) > 10;
        uVar.p(e2);
        int i20 = -1;
        if (z10) {
            uVar.r(16);
            int h11 = uVar.h(2);
            if (h11 == 0) {
                i20 = 0;
            } else if (h11 == 1) {
                i20 = 1;
            } else if (h11 == 2) {
                i20 = 2;
            }
            uVar.r(3);
            int h12 = (uVar.h(11) + 1) * 2;
            int h13 = uVar.h(2);
            if (h13 == 3) {
                i16 = f54368c[uVar.h(2)];
                h10 = 3;
                i15 = 6;
            } else {
                h10 = uVar.h(2);
                i15 = f54366a[h10];
                i16 = f54367b[h13];
            }
            int i21 = i15 * 256;
            int h14 = uVar.h(3);
            boolean g3 = uVar.g();
            int i22 = f54369d[h14] + (g3 ? 1 : 0);
            uVar.r(10);
            if (uVar.g()) {
                uVar.r(8);
            }
            if (h14 == 0) {
                uVar.r(5);
                if (uVar.g()) {
                    uVar.r(8);
                }
            }
            if (i20 == 1 && uVar.g()) {
                uVar.r(16);
            }
            if (uVar.g()) {
                if (h14 > 2) {
                    uVar.r(2);
                }
                if ((h14 & 1) == 0 || h14 <= 2) {
                    i18 = 6;
                } else {
                    i18 = 6;
                    uVar.r(6);
                }
                if ((h14 & 4) != 0) {
                    uVar.r(i18);
                }
                if (g3 && uVar.g()) {
                    uVar.r(5);
                }
                if (i20 == 0) {
                    if (uVar.g()) {
                        i19 = 6;
                        uVar.r(6);
                    } else {
                        i19 = 6;
                    }
                    if (h14 == 0 && uVar.g()) {
                        uVar.r(i19);
                    }
                    if (uVar.g()) {
                        uVar.r(i19);
                    }
                    int h15 = uVar.h(2);
                    if (h15 == 1) {
                        uVar.r(5);
                    } else if (h15 == 2) {
                        uVar.r(12);
                    } else if (h15 == 3) {
                        int h16 = uVar.h(5);
                        if (uVar.g()) {
                            uVar.r(5);
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                uVar.r(4);
                            }
                            if (uVar.g()) {
                                if (uVar.g()) {
                                    uVar.r(4);
                                }
                                if (uVar.g()) {
                                    uVar.r(4);
                                }
                            }
                        }
                        if (uVar.g()) {
                            uVar.r(5);
                            if (uVar.g()) {
                                uVar.r(7);
                                if (uVar.g()) {
                                    uVar.r(8);
                                }
                            }
                        }
                        uVar.r((h16 + 2) * 8);
                        uVar.c();
                    }
                    if (h14 < 2) {
                        if (uVar.g()) {
                            uVar.r(14);
                        }
                        if (h14 == 0 && uVar.g()) {
                            uVar.r(14);
                        }
                    }
                    if (uVar.g()) {
                        if (h10 == 0) {
                            uVar.r(5);
                        } else {
                            for (int i23 = 0; i23 < i15; i23++) {
                                if (uVar.g()) {
                                    uVar.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (uVar.g()) {
                uVar.r(5);
                if (h14 == 2) {
                    uVar.r(4);
                }
                if (h14 >= 6) {
                    uVar.r(2);
                }
                if (uVar.g()) {
                    uVar.r(8);
                }
                if (h14 == 0 && uVar.g()) {
                    uVar.r(8);
                }
                if (h13 < 3) {
                    uVar.q();
                }
            }
            if (i20 == 0 && h10 != 3) {
                uVar.q();
            }
            if (i20 == 2 && (h10 == 3 || uVar.g())) {
                i17 = 6;
                uVar.r(6);
            } else {
                i17 = 6;
            }
            str = (uVar.g() && uVar.h(i17) == 1 && uVar.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i13 = i20;
            i14 = i21;
            i10 = h12;
            i11 = i16;
            i12 = i22;
        } else {
            uVar.r(32);
            int h17 = uVar.h(2);
            String str2 = h17 == 3 ? null : "audio/ac3";
            int b4 = b(h17, uVar.h(6));
            uVar.r(8);
            int h18 = uVar.h(3);
            if ((h18 & 1) != 0 && h18 != 1) {
                uVar.r(2);
            }
            if ((h18 & 4) != 0) {
                uVar.r(2);
            }
            if (h18 == 2) {
                uVar.r(2);
            }
            int[] iArr = f54367b;
            str = str2;
            i10 = b4;
            i11 = h17 < iArr.length ? iArr[h17] : -1;
            i12 = f54369d[h18] + (uVar.g() ? 1 : 0);
            i13 = -1;
            i14 = 1536;
        }
        return new C0838b(str, i13, i12, i11, i10, i14);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        return b((bArr[4] & 192) >> 6, bArr[4] & Utf8.REPLACEMENT_BYTE);
    }

    public static Format g(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        parsableByteArray.Q(2);
        int i10 = f54367b[(parsableByteArray.D() & 192) >> 6];
        int D = parsableByteArray.D();
        int i11 = f54369d[(D & 14) >> 1];
        if ((D & 1) != 0) {
            i11++;
        }
        if (((parsableByteArray.D() & 30) >> 1) > 0 && (2 & parsableByteArray.D()) != 0) {
            i11 += 2;
        }
        return new Format.b().S(str).e0((parsableByteArray.a() <= 0 || (parsableByteArray.D() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc").H(i11).f0(i10).L(drmInitData).V(str2).E();
    }

    public static int h(ByteBuffer byteBuffer, int i10) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i10) + ((byteBuffer.get((byteBuffer.position() + i10) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int i(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            return 40 << ((bArr[(bArr[7] & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
        }
        return 0;
    }
}
