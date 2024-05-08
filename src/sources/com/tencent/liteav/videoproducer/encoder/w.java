package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.videoproducer.encoder.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final s.AnonymousClass1 f44722a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaFormat f44723b;

    private w(s.AnonymousClass1 anonymousClass1, MediaFormat mediaFormat) {
        this.f44722a = anonymousClass1;
        this.f44723b = mediaFormat;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1, MediaFormat mediaFormat) {
        return new w(anonymousClass1, mediaFormat);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1.a(this.f44722a, this.f44723b);
    }
}
