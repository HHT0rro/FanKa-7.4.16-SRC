package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* compiled from: DisplayBitmapTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f37752b;

    /* renamed from: c, reason: collision with root package name */
    public final String f37753c;

    /* renamed from: d, reason: collision with root package name */
    public final mb.a f37754d;

    /* renamed from: e, reason: collision with root package name */
    public final String f37755e;

    /* renamed from: f, reason: collision with root package name */
    public final lb.a f37756f;

    /* renamed from: g, reason: collision with root package name */
    public final nb.a f37757g;

    /* renamed from: h, reason: collision with root package name */
    public final f f37758h;

    /* renamed from: i, reason: collision with root package name */
    public final LoadedFrom f37759i;

    public b(Bitmap bitmap, g gVar, f fVar, LoadedFrom loadedFrom) {
        this.f37752b = bitmap;
        this.f37753c = gVar.f37867a;
        this.f37754d = gVar.f37869c;
        this.f37755e = gVar.f37868b;
        this.f37756f = gVar.f37871e.w();
        this.f37757g = gVar.f37872f;
        this.f37758h = fVar;
        this.f37759i = loadedFrom;
    }

    public final boolean a() {
        return !this.f37755e.equals(this.f37758h.g(this.f37754d));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f37754d.isCollected()) {
            pb.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f37755e);
            this.f37757g.onLoadingCancelled(this.f37753c, this.f37754d.getWrappedView());
        } else if (a()) {
            pb.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f37755e);
            this.f37757g.onLoadingCancelled(this.f37753c, this.f37754d.getWrappedView());
        } else {
            pb.d.a("Display image in ImageAware (loaded from %1$s) [%2$s]", this.f37759i, this.f37755e);
            this.f37756f.a(this.f37752b, this.f37754d, this.f37759i);
            this.f37758h.d(this.f37754d);
            this.f37757g.onLoadingComplete(this.f37753c, this.f37754d.getWrappedView(), this.f37752b);
        }
    }
}
