package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

/* compiled from: Track.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f20228a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20229b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20230c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20231d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20232e;

    /* renamed from: f, reason: collision with root package name */
    public final Format f20233f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20234g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final long[] f20235h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final long[] f20236i;

    /* renamed from: j, reason: collision with root package name */
    public final int f20237j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final TrackEncryptionBox[] f20238k;

    public n(int i10, int i11, long j10, long j11, long j12, Format format, int i12, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i13, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f20228a = i10;
        this.f20229b = i11;
        this.f20230c = j10;
        this.f20231d = j11;
        this.f20232e = j12;
        this.f20233f = format;
        this.f20234g = i12;
        this.f20238k = trackEncryptionBoxArr;
        this.f20237j = i13;
        this.f20235h = jArr;
        this.f20236i = jArr2;
    }

    @Nullable
    public TrackEncryptionBox a(int i10) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.f20238k;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i10];
    }
}
