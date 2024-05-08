package com.tencent.liteav.videoproducer.encoder;

import android.view.Surface;
import com.tencent.liteav.videoproducer.encoder.bq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44557a;

    /* renamed from: b, reason: collision with root package name */
    private final bq.a f44558b;

    /* renamed from: c, reason: collision with root package name */
    private final Surface[] f44559c;

    /* renamed from: d, reason: collision with root package name */
    private final VideoEncodeParams f44560d;

    private ar(am amVar, bq.a aVar, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams) {
        this.f44557a = amVar;
        this.f44558b = aVar;
        this.f44559c = surfaceArr;
        this.f44560d = videoEncodeParams;
    }

    public static Runnable a(am amVar, bq.a aVar, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams) {
        return new ar(amVar, aVar, surfaceArr, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        am amVar = this.f44557a;
        bq.a aVar = this.f44558b;
        Surface[] surfaceArr = this.f44559c;
        VideoEncodeParams videoEncodeParams = this.f44560d;
        amVar.f44529e = aVar;
        surfaceArr[0] = amVar.a(videoEncodeParams);
    }
}
