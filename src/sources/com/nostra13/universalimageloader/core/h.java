package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* compiled from: ProcessAndDisplayImageTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final f f37875b;

    /* renamed from: c, reason: collision with root package name */
    public final Bitmap f37876c;

    /* renamed from: d, reason: collision with root package name */
    public final g f37877d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f37878e;

    public h(f fVar, Bitmap bitmap, g gVar, Handler handler) {
        this.f37875b = fVar;
        this.f37876c = bitmap;
        this.f37877d = gVar;
        this.f37878e = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        pb.d.a("PostProcess image before displaying [%s]", this.f37877d.f37868b);
        LoadAndDisplayImageTask.s(new b(this.f37877d.f37871e.D().process(this.f37876c), this.f37877d, this.f37875b, LoadedFrom.MEMORY_CACHE), this.f37877d.f37871e.J(), this.f37878e, this.f37875b);
    }
}
