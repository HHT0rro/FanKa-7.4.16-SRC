package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.TrackOutput;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TrackEncryptionBox {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20122a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f20123b;

    /* renamed from: c, reason: collision with root package name */
    public final TrackOutput.CryptoData f20124c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20125d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final byte[] f20126e;

    public TrackEncryptionBox(boolean z10, @Nullable String str, int i10, byte[] bArr, int i11, int i12, @Nullable byte[] bArr2) {
        com.google.android.exoplayer2.util.a.a((bArr2 == null) ^ (i10 == 0));
        this.f20122a = z10;
        this.f20123b = str;
        this.f20125d = i10;
        this.f20126e = bArr2;
        this.f20124c = new TrackOutput.CryptoData(a(str), bArr, i11, i12);
    }

    public static int a(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
                return 2;
            default:
                StringBuilder sb2 = new StringBuilder(str.length() + 68);
                sb2.append("Unsupported protection scheme type '");
                sb2.append(str);
                sb2.append("'. Assuming AES-CTR crypto mode.");
                com.google.android.exoplayer2.util.m.h("TrackEncryptionBox", sb2.toString());
            case 2:
            case 3:
                return 1;
        }
    }
}
