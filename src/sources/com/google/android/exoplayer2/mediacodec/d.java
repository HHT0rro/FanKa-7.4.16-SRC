package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* compiled from: MediaCodecSelector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f20843a = new d() { // from class: m5.j
        @Override // com.google.android.exoplayer2.mediacodec.d
        public final List a(String str, boolean z10, boolean z11) {
            return MediaCodecUtil.r(str, z10, z11);
        }
    };

    List<c> a(String str, boolean z10, boolean z11) throws MediaCodecUtil.DecoderQueryException;
}
