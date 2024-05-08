package com.tencent.liteav.videoproducer.encoder;

import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bp implements w.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f44626a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public IVideoReporter f44627b;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.liteav.base.util.w f44631f;

    /* renamed from: g, reason: collision with root package name */
    private final VideoProducerDef.StreamType f44632g;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public Map<Long, Long> f44628c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public long f44629d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f44630e = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f44633h = 0;

    public bp(@NonNull IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.f44627b = iVideoReporter;
        this.f44632g = streamType;
        this.f44626a = "VECStatistics_" + ((Object) streamType) + "_" + hashCode();
    }

    @Override // com.tencent.liteav.base.util.w.a
    public final void onTimeout() {
        long j10 = this.f44630e;
        if (j10 > 0) {
            this.f44627b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_AVERAGE_ENCODE_COST, Long.valueOf(this.f44629d / j10));
        }
    }
}
