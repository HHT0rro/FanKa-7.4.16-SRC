package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b.AnonymousClass4 f43771a;

    private z(b.AnonymousClass4 anonymousClass4) {
        this.f43771a = anonymousClass4;
    }

    public static Runnable a(b.AnonymousClass4 anonymousClass4) {
        return new z(anonymousClass4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.AnonymousClass4 anonymousClass4 = this.f43771a;
        LiteavLog.i(b.this.f43692a, "on request key frame");
        b.this.f43694c.notifyEvent(h.b.EVT_VIDEO_EVENT_REQUEST_KEY_FRAME, (Object) null, "request key frame");
    }
}
