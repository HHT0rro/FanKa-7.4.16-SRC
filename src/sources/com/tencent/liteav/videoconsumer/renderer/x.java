package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44158a;

    /* renamed from: b, reason: collision with root package name */
    private final RenderViewHelperInterface f44159b;

    /* renamed from: c, reason: collision with root package name */
    private final ByteBuffer f44160c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44161d;

    /* renamed from: e, reason: collision with root package name */
    private final int f44162e;

    /* renamed from: f, reason: collision with root package name */
    private final TakeSnapshotListener f44163f;

    private x(t tVar, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i10, int i11, TakeSnapshotListener takeSnapshotListener) {
        this.f44158a = tVar;
        this.f44159b = renderViewHelperInterface;
        this.f44160c = byteBuffer;
        this.f44161d = i10;
        this.f44162e = i11;
        this.f44163f = takeSnapshotListener;
    }

    public static Runnable a(t tVar, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i10, int i11, TakeSnapshotListener takeSnapshotListener) {
        return new x(tVar, renderViewHelperInterface, byteBuffer, i10, i11, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44158a, this.f44159b, this.f44160c, this.f44161d, this.f44162e, this.f44163f);
    }
}
