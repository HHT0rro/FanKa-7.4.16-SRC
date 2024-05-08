package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;

/* compiled from: ImageLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    public static final String f37798d = "d";

    /* renamed from: a, reason: collision with root package name */
    public e f37799a;

    /* renamed from: b, reason: collision with root package name */
    public f f37800b;

    /* renamed from: c, reason: collision with root package name */
    public nb.a f37801c = new nb.c();

    /* compiled from: ImageLoader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends nb.c {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f37802a;

        public b() {
        }

        public Bitmap b() {
            return this.f37802a;
        }

        @Override // nb.c, nb.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.f37802a = bitmap;
        }
    }

    public static Handler b(c cVar) {
        Handler y10 = cVar.y();
        if (cVar.J()) {
            return null;
        }
        return (y10 == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : y10;
    }

    public final void a() {
        if (this.f37799a == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public void c(String str, ImageView imageView, nb.a aVar) {
        d(str, new mb.b(imageView), null, aVar, null);
    }

    public void d(String str, mb.a aVar, c cVar, nb.a aVar2, nb.b bVar) {
        a();
        if (aVar != null) {
            if (aVar2 == null) {
                aVar2 = this.f37801c;
            }
            nb.a aVar3 = aVar2;
            if (cVar == null) {
                cVar = this.f37799a.f37824r;
            }
            if (TextUtils.isEmpty(str)) {
                this.f37800b.d(aVar);
                aVar3.onLoadingStarted(str, aVar.getWrappedView());
                if (cVar.N()) {
                    aVar.setImageDrawable(cVar.z(this.f37799a.f37807a));
                } else {
                    aVar.setImageDrawable(null);
                }
                aVar3.onLoadingComplete(str, aVar.getWrappedView(), null);
                return;
            }
            jb.c e2 = pb.b.e(aVar, this.f37799a.a());
            String b4 = pb.e.b(str, e2);
            this.f37800b.n(aVar, b4);
            aVar3.onLoadingStarted(str, aVar.getWrappedView());
            Bitmap bitmap = this.f37799a.f37820n.get(b4);
            if (bitmap != null && !bitmap.isRecycled()) {
                pb.d.a(ImageLoader.LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, b4);
                if (cVar.L()) {
                    h hVar = new h(this.f37800b, bitmap, new g(str, aVar, e2, b4, cVar, aVar3, bVar, this.f37800b.h(str)), b(cVar));
                    if (cVar.J()) {
                        hVar.run();
                        return;
                    } else {
                        this.f37800b.p(hVar);
                        return;
                    }
                }
                cVar.w().a(bitmap, aVar, LoadedFrom.MEMORY_CACHE);
                aVar3.onLoadingComplete(str, aVar.getWrappedView(), bitmap);
                return;
            }
            if (cVar.P()) {
                aVar.setImageDrawable(cVar.B(this.f37799a.f37807a));
            } else if (cVar.I()) {
                aVar.setImageDrawable(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.f37800b, new g(str, aVar, e2, b4, cVar, aVar3, bVar, this.f37800b.h(str)), b(cVar));
            if (cVar.J()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.f37800b.o(loadAndDisplayImageTask);
                return;
            }
        }
        throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    }

    public db.a e() {
        a();
        return this.f37799a.f37821o;
    }

    public hb.a f() {
        a();
        return this.f37799a.f37820n;
    }

    public synchronized void g(e eVar) {
        if (eVar != null) {
            if (this.f37799a == null) {
                pb.d.a(ImageLoader.LOG_INIT_CONFIG, new Object[0]);
                this.f37800b = new f(eVar);
                this.f37799a = eVar;
            } else {
                pb.d.f("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
            }
        } else {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        }
    }

    public void h(String str, jb.c cVar, c cVar2, nb.a aVar) {
        i(str, cVar, cVar2, aVar, null);
    }

    public void i(String str, jb.c cVar, c cVar2, nb.a aVar, nb.b bVar) {
        a();
        if (cVar == null) {
            cVar = this.f37799a.a();
        }
        if (cVar2 == null) {
            cVar2 = this.f37799a.f37824r;
        }
        d(str, new mb.c(str, cVar, ViewScaleType.CROP), cVar2, aVar, bVar);
    }

    public Bitmap j(String str, c cVar) {
        return k(str, null, cVar);
    }

    public Bitmap k(String str, jb.c cVar, c cVar2) {
        if (cVar2 == null) {
            cVar2 = this.f37799a.f37824r;
        }
        c t2 = new c.b().w(cVar2).y(true).t();
        b bVar = new b();
        h(str, cVar, t2, bVar);
        return bVar.b();
    }
}
