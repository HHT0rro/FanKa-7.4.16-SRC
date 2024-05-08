package com.tencent.liteav.audio.route;

import com.tencent.liteav.audio.route.AudioRouteManager;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager.AnonymousClass2 f42705a;

    /* renamed from: b, reason: collision with root package name */
    private final List f42706b;

    private o(AudioRouteManager.AnonymousClass2 anonymousClass2, List list) {
        this.f42705a = anonymousClass2;
        this.f42706b = list;
    }

    public static Runnable a(AudioRouteManager.AnonymousClass2 anonymousClass2, List list) {
        return new o(anonymousClass2, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRouteManager.this.handleRecordingConfigChanged(this.f42706b);
    }
}
