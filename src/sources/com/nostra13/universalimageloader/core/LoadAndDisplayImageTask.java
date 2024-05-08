package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import pb.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class LoadAndDisplayImageTask implements Runnable, c.a {

    /* renamed from: b, reason: collision with root package name */
    public final f f37711b;

    /* renamed from: c, reason: collision with root package name */
    public final g f37712c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f37713d;

    /* renamed from: e, reason: collision with root package name */
    public final e f37714e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageDownloader f37715f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageDownloader f37716g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageDownloader f37717h;

    /* renamed from: i, reason: collision with root package name */
    public final kb.b f37718i;

    /* renamed from: j, reason: collision with root package name */
    public final String f37719j;

    /* renamed from: k, reason: collision with root package name */
    public final String f37720k;

    /* renamed from: l, reason: collision with root package name */
    public final mb.a f37721l;

    /* renamed from: m, reason: collision with root package name */
    public final jb.c f37722m;

    /* renamed from: n, reason: collision with root package name */
    public final com.nostra13.universalimageloader.core.c f37723n;

    /* renamed from: o, reason: collision with root package name */
    public final nb.a f37724o;

    /* renamed from: p, reason: collision with root package name */
    public final nb.b f37725p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f37726q;

    /* renamed from: r, reason: collision with root package name */
    public LoadedFrom f37727r = LoadedFrom.NETWORK;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class TaskCancelledException extends Exception {
        public TaskCancelledException() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f37728b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f37729c;

        public a(int i10, int i11) {
            this.f37728b = i10;
            this.f37729c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.f37725p.onProgressUpdate(loadAndDisplayImageTask.f37719j, loadAndDisplayImageTask.f37721l.getWrappedView(), this.f37728b, this.f37729c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FailReason.FailType f37731b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f37732c;

        public b(FailReason.FailType failType, Throwable th) {
            this.f37731b = failType;
            this.f37732c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LoadAndDisplayImageTask.this.f37723n.O()) {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.f37721l.setImageDrawable(loadAndDisplayImageTask.f37723n.A(loadAndDisplayImageTask.f37714e.f37807a));
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask2.f37724o.a(loadAndDisplayImageTask2.f37719j, loadAndDisplayImageTask2.f37721l.getWrappedView(), new FailReason(this.f37731b, this.f37732c));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.f37724o.onLoadingCancelled(loadAndDisplayImageTask.f37719j, loadAndDisplayImageTask.f37721l.getWrappedView());
        }
    }

    public LoadAndDisplayImageTask(f fVar, g gVar, Handler handler) {
        this.f37711b = fVar;
        this.f37712c = gVar;
        this.f37713d = handler;
        e eVar = fVar.f37855a;
        this.f37714e = eVar;
        this.f37715f = eVar.f37822p;
        this.f37716g = eVar.f37825s;
        this.f37717h = eVar.f37826t;
        this.f37718i = eVar.f37823q;
        this.f37719j = gVar.f37867a;
        this.f37720k = gVar.f37868b;
        this.f37721l = gVar.f37869c;
        this.f37722m = gVar.f37870d;
        com.nostra13.universalimageloader.core.c cVar = gVar.f37871e;
        this.f37723n = cVar;
        this.f37724o = gVar.f37872f;
        this.f37725p = gVar.f37873g;
        this.f37726q = cVar.J();
    }

    public static void s(Runnable runnable, boolean z10, Handler handler, f fVar) {
        if (z10) {
            runnable.run();
        } else if (handler == null) {
            fVar.f(runnable);
        } else {
            handler.post(runnable);
        }
    }

    public final void b() throws TaskCancelledException {
        if (n()) {
            throw new TaskCancelledException();
        }
    }

    public final void c() throws TaskCancelledException {
        d();
        e();
    }

    public final void d() throws TaskCancelledException {
        if (p()) {
            throw new TaskCancelledException();
        }
    }

    public final void e() throws TaskCancelledException {
        if (q()) {
            throw new TaskCancelledException();
        }
    }

    public final Bitmap f(String str) throws IOException {
        return this.f37718i.a(new kb.c(this.f37720k, str, this.f37719j, this.f37722m, this.f37721l.getScaleType(), l(), this.f37723n));
    }

    public final boolean g() {
        if (!this.f37723n.K()) {
            return false;
        }
        pb.d.a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.f37723n.v()), this.f37720k);
        try {
            Thread.sleep(this.f37723n.v());
            return o();
        } catch (InterruptedException unused) {
            pb.d.b("Task was interrupted [%s]", this.f37720k);
            return true;
        }
    }

    public final boolean h() throws IOException {
        InputStream stream = l().getStream(this.f37719j, this.f37723n.x());
        if (stream == null) {
            pb.d.b(BaseImageDecoder.ERROR_NO_IMAGE_STREAM, this.f37720k);
            return false;
        }
        try {
            return this.f37714e.f37821o.a(this.f37719j, stream, this);
        } finally {
            pb.c.a(stream);
        }
    }

    public final void i() {
        if (this.f37726q || n()) {
            return;
        }
        s(new c(), false, this.f37713d, this.f37711b);
    }

    public final void j(FailReason.FailType failType, Throwable th) {
        if (this.f37726q || n() || o()) {
            return;
        }
        s(new b(failType, th), false, this.f37713d, this.f37711b);
    }

    public final boolean k(int i10, int i11) {
        if (n() || o()) {
            return false;
        }
        if (this.f37725p == null) {
            return true;
        }
        s(new a(i10, i11), false, this.f37713d, this.f37711b);
        return true;
    }

    public final ImageDownloader l() {
        if (this.f37711b.l()) {
            return this.f37716g;
        }
        if (this.f37711b.m()) {
            return this.f37717h;
        }
        return this.f37715f;
    }

    public String m() {
        return this.f37719j;
    }

    public final boolean n() {
        if (!Thread.interrupted()) {
            return false;
        }
        pb.d.a("Task was interrupted [%s]", this.f37720k);
        return true;
    }

    public final boolean o() {
        return p() || q();
    }

    @Override // pb.c.a
    public boolean onBytesCopied(int i10, int i11) {
        return this.f37726q || k(i10, i11);
    }

    public final boolean p() {
        if (!this.f37721l.isCollected()) {
            return false;
        }
        pb.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f37720k);
        return true;
    }

    public final boolean q() {
        if (!(!this.f37720k.equals(this.f37711b.g(this.f37721l)))) {
            return false;
        }
        pb.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f37720k);
        return true;
    }

    public final boolean r(int i10, int i11) throws IOException {
        File file = this.f37714e.f37821o.get(this.f37719j);
        if (file == null || !file.exists()) {
            return false;
        }
        Bitmap a10 = this.f37718i.a(new kb.c(this.f37720k, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.f37719j, new jb.c(i10, i11), ViewScaleType.FIT_INSIDE, l(), new c.b().w(this.f37723n).x(ImageScaleType.IN_SAMPLE_INT).t()));
        if (a10 != null && this.f37714e.f37812f != null) {
            pb.d.a("Process image before cache on disk [%s]", this.f37720k);
            a10 = this.f37714e.f37812f.process(a10);
            if (a10 == null) {
                pb.d.b("Bitmap processor for disk cache returned null [%s]", this.f37720k);
            }
        }
        if (a10 == null) {
            return false;
        }
        boolean save = this.f37714e.f37821o.save(this.f37719j, a10);
        a10.recycle();
        return save;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d2 A[Catch: all -> 0x00fb, TaskCancelledException -> 0x00fd, Merged into TryCatch #1 {all -> 0x00fb, TaskCancelledException -> 0x00fd, blocks: (B:13:0x0033, B:15:0x0042, B:18:0x0049, B:20:0x00b3, B:22:0x00bb, B:24:0x00d2, B:25:0x00dd, B:29:0x0059, B:33:0x0063, B:35:0x0071, B:37:0x0088, B:39:0x0095, B:41:0x009d, B:42:0x00fd), top: B:12:0x0033 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }

    public final boolean t() throws TaskCancelledException {
        pb.d.a("Cache image on disk [%s]", this.f37720k);
        try {
            boolean h10 = h();
            if (h10) {
                e eVar = this.f37714e;
                int i10 = eVar.f37810d;
                int i11 = eVar.f37811e;
                if (i10 > 0 || i11 > 0) {
                    pb.d.a("Resize image in disk cache [%s]", this.f37720k);
                    r(i10, i11);
                }
            }
            return h10;
        } catch (IOException e2) {
            pb.d.c(e2);
            return false;
        }
    }

    public final Bitmap u() throws TaskCancelledException {
        Bitmap bitmap;
        File file;
        Bitmap bitmap2 = null;
        try {
            try {
                File file2 = this.f37714e.f37821o.get(this.f37719j);
                if (file2 == null || !file2.exists() || file2.length() <= 0) {
                    bitmap = null;
                } else {
                    pb.d.a("Load image from disk cache [%s]", this.f37720k);
                    this.f37727r = LoadedFrom.DISC_CACHE;
                    c();
                    bitmap = f(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            return bitmap;
                        }
                    } catch (IOException e2) {
                        Bitmap bitmap3 = bitmap;
                        e = e2;
                        bitmap2 = bitmap3;
                        pb.d.c(e);
                        j(FailReason.FailType.IO_ERROR, e);
                        return bitmap2;
                    } catch (IllegalStateException unused) {
                        j(FailReason.FailType.NETWORK_DENIED, null);
                        return bitmap;
                    } catch (OutOfMemoryError e10) {
                        Bitmap bitmap4 = bitmap;
                        e = e10;
                        bitmap2 = bitmap4;
                        pb.d.c(e);
                        j(FailReason.FailType.OUT_OF_MEMORY, e);
                        return bitmap2;
                    } catch (Throwable th) {
                        Bitmap bitmap5 = bitmap;
                        th = th;
                        bitmap2 = bitmap5;
                        pb.d.c(th);
                        j(FailReason.FailType.UNKNOWN, th);
                        return bitmap2;
                    }
                }
                pb.d.a("Load image from network [%s]", this.f37720k);
                this.f37727r = LoadedFrom.NETWORK;
                String str = this.f37719j;
                if (this.f37723n.G() && t() && (file = this.f37714e.f37821o.get(this.f37719j)) != null) {
                    str = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                }
                c();
                bitmap = f(str);
                if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    return bitmap;
                }
                j(FailReason.FailType.DECODING_ERROR, null);
                return bitmap;
            } catch (IOException e11) {
                e = e11;
            } catch (IllegalStateException unused2) {
                bitmap = null;
            } catch (OutOfMemoryError e12) {
                e = e12;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (TaskCancelledException e13) {
            throw e13;
        }
    }

    public final boolean v() {
        AtomicBoolean i10 = this.f37711b.i();
        if (i10.get()) {
            synchronized (this.f37711b.j()) {
                if (i10.get()) {
                    pb.d.a("ImageLoader is paused. Waiting...  [%s]", this.f37720k);
                    try {
                        this.f37711b.j().wait();
                        pb.d.a(".. Resume loading [%s]", this.f37720k);
                    } catch (InterruptedException unused) {
                        pb.d.b("Task was interrupted [%s]", this.f37720k);
                        return true;
                    }
                }
            }
        }
        return o();
    }
}
