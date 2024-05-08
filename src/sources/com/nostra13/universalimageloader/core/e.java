package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: ImageLoaderConfiguration.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f37807a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37808b;

    /* renamed from: c, reason: collision with root package name */
    public final int f37809c;

    /* renamed from: d, reason: collision with root package name */
    public final int f37810d;

    /* renamed from: e, reason: collision with root package name */
    public final int f37811e;

    /* renamed from: f, reason: collision with root package name */
    public final ob.a f37812f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f37813g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f37814h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f37815i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f37816j;

    /* renamed from: k, reason: collision with root package name */
    public final int f37817k;

    /* renamed from: l, reason: collision with root package name */
    public final int f37818l;

    /* renamed from: m, reason: collision with root package name */
    public final QueueProcessingType f37819m;

    /* renamed from: n, reason: collision with root package name */
    public final hb.a f37820n;

    /* renamed from: o, reason: collision with root package name */
    public final db.a f37821o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageDownloader f37822p;

    /* renamed from: q, reason: collision with root package name */
    public final kb.b f37823q;

    /* renamed from: r, reason: collision with root package name */
    public final com.nostra13.universalimageloader.core.c f37824r;

    /* renamed from: s, reason: collision with root package name */
    public final ImageDownloader f37825s;

    /* renamed from: t, reason: collision with root package name */
    public final ImageDownloader f37826t;

    /* compiled from: ImageLoaderConfiguration.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37827a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f37827a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37827a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: ImageLoaderConfiguration.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: y, reason: collision with root package name */
        public static final QueueProcessingType f37828y = QueueProcessingType.FIFO;

        /* renamed from: a, reason: collision with root package name */
        public Context f37829a;

        /* renamed from: v, reason: collision with root package name */
        public kb.b f37850v;

        /* renamed from: b, reason: collision with root package name */
        public int f37830b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f37831c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f37832d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f37833e = 0;

        /* renamed from: f, reason: collision with root package name */
        public ob.a f37834f = null;

        /* renamed from: g, reason: collision with root package name */
        public Executor f37835g = null;

        /* renamed from: h, reason: collision with root package name */
        public Executor f37836h = null;

        /* renamed from: i, reason: collision with root package name */
        public boolean f37837i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f37838j = false;

        /* renamed from: k, reason: collision with root package name */
        public int f37839k = 3;

        /* renamed from: l, reason: collision with root package name */
        public int f37840l = 3;

        /* renamed from: m, reason: collision with root package name */
        public boolean f37841m = false;

        /* renamed from: n, reason: collision with root package name */
        public QueueProcessingType f37842n = f37828y;

        /* renamed from: o, reason: collision with root package name */
        public int f37843o = 0;

        /* renamed from: p, reason: collision with root package name */
        public long f37844p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f37845q = 0;

        /* renamed from: r, reason: collision with root package name */
        public hb.a f37846r = null;

        /* renamed from: s, reason: collision with root package name */
        public db.a f37847s = null;

        /* renamed from: t, reason: collision with root package name */
        public gb.a f37848t = null;

        /* renamed from: u, reason: collision with root package name */
        public ImageDownloader f37849u = null;

        /* renamed from: w, reason: collision with root package name */
        public com.nostra13.universalimageloader.core.c f37851w = null;

        /* renamed from: x, reason: collision with root package name */
        public boolean f37852x = false;

        public b(Context context) {
            this.f37829a = context.getApplicationContext();
        }

        public b A(int i10) {
            if (i10 > 0) {
                if (this.f37846r != null) {
                    pb.d.f("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
                }
                this.f37843o = i10;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public e t() {
            y();
            return new e(this, null);
        }

        public b u(com.nostra13.universalimageloader.core.c cVar) {
            this.f37851w = cVar;
            return this;
        }

        public b v(int i10) {
            if (i10 > 0) {
                if (this.f37847s != null) {
                    pb.d.f("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.f37845q = i10;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public b w(int i10) {
            if (i10 > 0) {
                if (this.f37847s != null) {
                    pb.d.f("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.f37844p = i10;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public b x(ImageDownloader imageDownloader) {
            this.f37849u = imageDownloader;
            return this;
        }

        public final void y() {
            if (this.f37835g == null) {
                this.f37835g = com.nostra13.universalimageloader.core.a.c(this.f37839k, this.f37840l, this.f37842n);
            } else {
                this.f37837i = true;
            }
            if (this.f37836h == null) {
                this.f37836h = com.nostra13.universalimageloader.core.a.c(this.f37839k, this.f37840l, this.f37842n);
            } else {
                this.f37838j = true;
            }
            if (this.f37847s == null) {
                if (this.f37848t == null) {
                    this.f37848t = com.nostra13.universalimageloader.core.a.d();
                }
                this.f37847s = com.nostra13.universalimageloader.core.a.b(this.f37829a, this.f37848t, this.f37844p, this.f37845q);
            }
            if (this.f37846r == null) {
                this.f37846r = com.nostra13.universalimageloader.core.a.g(this.f37829a, this.f37843o);
            }
            if (this.f37841m) {
                this.f37846r = new ib.a(this.f37846r, pb.e.a());
            }
            if (this.f37849u == null) {
                this.f37849u = com.nostra13.universalimageloader.core.a.f(this.f37829a);
            }
            if (this.f37850v == null) {
                this.f37850v = com.nostra13.universalimageloader.core.a.e(this.f37852x);
            }
            if (this.f37851w == null) {
                this.f37851w = com.nostra13.universalimageloader.core.c.t();
            }
        }

        public b z(hb.a aVar) {
            if (this.f37843o != 0) {
                pb.d.f("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.f37846r = aVar;
            return this;
        }
    }

    /* compiled from: ImageLoaderConfiguration.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c implements ImageDownloader {

        /* renamed from: a, reason: collision with root package name */
        public final ImageDownloader f37853a;

        public c(ImageDownloader imageDownloader) {
            this.f37853a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            int i10 = a.f37827a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i10 != 1 && i10 != 2) {
                return this.f37853a.getStream(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: ImageLoaderConfiguration.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d implements ImageDownloader {

        /* renamed from: a, reason: collision with root package name */
        public final ImageDownloader f37854a;

        public d(ImageDownloader imageDownloader) {
            this.f37854a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            InputStream stream = this.f37854a.getStream(str, obj);
            int i10 = a.f37827a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            return (i10 == 1 || i10 == 2) ? new jb.b(stream) : stream;
        }
    }

    public /* synthetic */ e(b bVar, a aVar) {
        this(bVar);
    }

    public jb.c a() {
        DisplayMetrics displayMetrics = this.f37807a.getDisplayMetrics();
        int i10 = this.f37808b;
        if (i10 <= 0) {
            i10 = displayMetrics.widthPixels;
        }
        int i11 = this.f37809c;
        if (i11 <= 0) {
            i11 = displayMetrics.heightPixels;
        }
        return new jb.c(i10, i11);
    }

    public e(b bVar) {
        this.f37807a = bVar.f37829a.getResources();
        this.f37808b = bVar.f37830b;
        this.f37809c = bVar.f37831c;
        this.f37810d = bVar.f37832d;
        this.f37811e = bVar.f37833e;
        this.f37812f = bVar.f37834f;
        this.f37813g = bVar.f37835g;
        this.f37814h = bVar.f37836h;
        this.f37817k = bVar.f37839k;
        this.f37818l = bVar.f37840l;
        this.f37819m = bVar.f37842n;
        this.f37821o = bVar.f37847s;
        this.f37820n = bVar.f37846r;
        this.f37824r = bVar.f37851w;
        ImageDownloader imageDownloader = bVar.f37849u;
        this.f37822p = imageDownloader;
        this.f37823q = bVar.f37850v;
        this.f37815i = bVar.f37837i;
        this.f37816j = bVar.f37838j;
        this.f37825s = new c(imageDownloader);
        this.f37826t = new d(imageDownloader);
        pb.d.g(bVar.f37852x);
    }
}
