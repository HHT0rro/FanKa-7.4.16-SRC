package com.tencent.liteav.videoproducer.preprocessor;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44854a;

    /* renamed from: b, reason: collision with root package name */
    private final List f44855b;

    private t(VideoPreprocessor videoPreprocessor, List list) {
        this.f44854a = videoPreprocessor;
        this.f44855b = list;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, List list) {
        return new t(videoPreprocessor, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setWatermarkList$11(this.f44854a, this.f44855b);
    }
}
