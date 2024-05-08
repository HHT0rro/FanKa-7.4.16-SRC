package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44050a;

    /* renamed from: b, reason: collision with root package name */
    private final ByteBuffer f44051b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44052c;

    /* renamed from: d, reason: collision with root package name */
    private final int f44053d;

    /* renamed from: e, reason: collision with root package name */
    private final Matrix f44054e;

    /* renamed from: f, reason: collision with root package name */
    private final TakeSnapshotListener f44055f;

    private ab(t tVar, ByteBuffer byteBuffer, int i10, int i11, Matrix matrix, TakeSnapshotListener takeSnapshotListener) {
        this.f44050a = tVar;
        this.f44051b = byteBuffer;
        this.f44052c = i10;
        this.f44053d = i11;
        this.f44054e = matrix;
        this.f44055f = takeSnapshotListener;
    }

    public static Runnable a(t tVar, ByteBuffer byteBuffer, int i10, int i11, Matrix matrix, TakeSnapshotListener takeSnapshotListener) {
        return new ab(tVar, byteBuffer, i10, i11, matrix, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44050a, this.f44051b, this.f44052c, this.f44053d, this.f44054e, this.f44055f);
    }
}
