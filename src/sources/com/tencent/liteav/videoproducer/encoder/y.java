package com.tencent.liteav.videoproducer.encoder;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f44732a;

    /* renamed from: h, reason: collision with root package name */
    public a f44739h;

    /* renamed from: b, reason: collision with root package name */
    public double f44733b = ShadowDrawableWrapper.COS_45;

    /* renamed from: c, reason: collision with root package name */
    public long f44734c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f44735d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f44736e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f44737f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f44738g = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f44740i = Math.max(1000, 1000);

    /* renamed from: j, reason: collision with root package name */
    public int f44741j = Math.max(1000, 1000);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(double d10);

        void a(long j10);
    }

    public y(a aVar, VideoProducerDef.StreamType streamType) {
        this.f44739h = aVar;
        this.f44732a = "RealFpsAndBitrateCaculate_" + ((Object) streamType) + "_" + hashCode();
    }
}
