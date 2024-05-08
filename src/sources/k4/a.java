package k4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.d;
import ar.com.hjg.pngj.q;
import com.github.sahasbhop.flog.FLog;
import com.nostra13.universalimageloader.core.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import l4.e;
import l4.f;
import l4.g;
import org.apache.commons.io.FileUtils;

/* compiled from: ApngDrawable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends Drawable implements Animatable, Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final Uri f50626b;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f50628d;

    /* renamed from: e, reason: collision with root package name */
    public c f50629e;

    /* renamed from: f, reason: collision with root package name */
    public g f50630f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f50631g;

    /* renamed from: h, reason: collision with root package name */
    public String f50632h;

    /* renamed from: k, reason: collision with root package name */
    public int f50635k;

    /* renamed from: l, reason: collision with root package name */
    public int f50636l;

    /* renamed from: o, reason: collision with root package name */
    public int f50639o;

    /* renamed from: p, reason: collision with root package name */
    public int f50640p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f50641q;

    /* renamed from: s, reason: collision with root package name */
    public File f50643s;

    /* renamed from: t, reason: collision with root package name */
    public e f50644t;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<d> f50627c = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public boolean f50633i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f50634j = false;

    /* renamed from: m, reason: collision with root package name */
    public int f50637m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f50638n = 0;

    /* renamed from: r, reason: collision with root package name */
    public float f50642r = 0.0f;

    public a(Context context, Bitmap bitmap, Uri uri) {
        Paint paint = new Paint();
        this.f50631g = paint;
        paint.setAntiAlias(true);
        this.f50629e = new c.b().u(false).v(true).t();
        this.f50632h = f.f(context).getPath();
        this.f50626b = uri;
        this.f50630f = g.l();
        this.f50628d = bitmap;
        this.f50635k = bitmap.getWidth();
        this.f50636l = bitmap.getHeight();
        if (b.f50646g) {
            FLog.a("Uri: %s", uri);
        }
        if (b.f50646g) {
            FLog.a("Bitmap size: %dx%d", Integer.valueOf(this.f50635k), Integer.valueOf(this.f50636l));
        }
    }

    public static a g(View view) {
        Drawable drawable;
        if (view == null || !(view instanceof ImageView) || (drawable = ((ImageView) view).getDrawable()) == null || !(drawable instanceof a)) {
            return null;
        }
        return (a) drawable;
    }

    public final void a(int i10, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        g gVar = this.f50630f;
        hb.a f10 = gVar == null ? null : gVar.f();
        if (f10 == null) {
            return;
        }
        f10.a(f(i10), bitmap);
    }

    public final Bitmap b(int i10) {
        if (b.f50645f) {
            FLog.g("ENTER", new Object[0]);
        }
        d dVar = i10 > 0 ? this.f50627c.get(i10 - 1) : null;
        Bitmap j10 = dVar != null ? j(i10, this.f50643s, dVar) : null;
        Bitmap j11 = this.f50630f.j(Uri.fromFile(new File(new File(this.f50632h, l4.a.a(this.f50643s, i10)).getPath())).toString(), this.f50629e);
        d dVar2 = this.f50627c.get(i10);
        Bitmap i11 = i(dVar2.m(), dVar2.n(), dVar2.h(), j11, j10);
        if (b.f50645f) {
            FLog.g("EXIT", new Object[0]);
        }
        return i11;
    }

    public final void c(Canvas canvas, int i10) {
        Bitmap e2 = e(i10);
        if (e2 == null) {
            e2 = b(i10);
            a(i10, e2);
        }
        if (e2 == null) {
            return;
        }
        canvas.drawBitmap(e2, (Rect) null, new RectF(0.0f, 0.0f, this.f50642r * e2.getWidth(), this.f50642r * e2.getHeight()), this.f50631g);
    }

    public final void d(Canvas canvas) {
        if (this.f50642r == 0.0f) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            if (b.f50645f) {
                FLog.g("Canvas: %dx%d", Integer.valueOf(width), Integer.valueOf(height));
            }
            float width2 = canvas.getWidth() / this.f50635k;
            if (b.f50645f) {
                FLog.g("scalingByWidth: %.2f", Float.valueOf(width2));
            }
            float height2 = canvas.getHeight() / this.f50636l;
            if (b.f50645f) {
                FLog.g("scalingByHeight: %.2f", Float.valueOf(height2));
            }
            if (width2 > height2) {
                width2 = height2;
            }
            this.f50642r = width2;
            if (b.f50645f) {
                FLog.g("mScaling: %.2f", Float.valueOf(width2));
            }
        }
        float f10 = this.f50642r;
        canvas.drawBitmap(this.f50628d, (Rect) null, new RectF(0.0f, 0.0f, this.f50635k * f10, f10 * this.f50636l), this.f50631g);
        a(0, this.f50628d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10;
        if (b.f50645f) {
            FLog.g("Current frame: %d", Integer.valueOf(this.f50637m));
        }
        int i11 = this.f50637m;
        if (i11 <= 0) {
            d(canvas);
        } else {
            c(canvas, i11);
        }
        if (!this.f50641q && (i10 = this.f50640p) > 0 && this.f50638n >= i10) {
            stop();
        }
        if (this.f50640p > 0 && this.f50637m == this.f50639o - 1) {
            this.f50638n++;
            e eVar = this.f50644t;
            if (eVar != null) {
                eVar.b(this);
            }
            if (b.f50645f) {
                FLog.g("Loop count: %d/%d", Integer.valueOf(this.f50638n), Integer.valueOf(this.f50640p));
            }
        }
        this.f50637m++;
    }

    public final Bitmap e(int i10) {
        g gVar = this.f50630f;
        hb.a f10 = gVar == null ? null : gVar.f();
        if (f10 == null) {
            return null;
        }
        return f10.get(f(i10));
    }

    public final String f(int i10) {
        return String.format("%s-%s", this.f50626b.toString(), Integer.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final String h() {
        Uri uri = this.f50626b;
        if (uri == null) {
            return null;
        }
        try {
            File file = new File(this.f50632h, uri.getLastPathSegment());
            if (!file.exists()) {
                if (b.f50645f) {
                    FLog.g("Copy file from %s to %s", this.f50626b.getPath(), file.getPath());
                }
                FileUtils.copyFile(new File(this.f50626b.getPath()), file);
            }
            return file.getPath();
        } catch (Exception e2) {
            FLog.b("Error: %s", e2.toString());
            return null;
        }
    }

    public final Bitmap i(int i10, int i11, byte b4, Bitmap bitmap, Bitmap bitmap2) {
        if (b.f50645f) {
            FLog.g("Create a new bitmap", new Object[0]);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.f50635k, this.f50636l, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            if (b4 == 0) {
                canvas.clipRect(i10, i11, bitmap.getWidth() + i10, bitmap.getHeight() + i11);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.clipRect(0, 0, this.f50635k, this.f50636l);
            }
        }
        canvas.drawBitmap(bitmap, i10, i11, (Paint) null);
        return createBitmap;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f50634j;
    }

    public final Bitmap j(int i10, File file, d dVar) {
        Bitmap createBitmap;
        byte k10 = dVar.k();
        int m10 = dVar.m();
        int n10 = dVar.n();
        if (k10 == 0) {
            if (i10 > 0) {
                return e(i10 - 1);
            }
            return null;
        }
        if (k10 != 1) {
            if (k10 != 2 || i10 <= 1) {
                return null;
            }
            for (int i11 = i10 - 2; i11 >= 0; i11--) {
                d dVar2 = this.f50627c.get(i11);
                byte k11 = dVar2.k();
                int m11 = dVar2.m();
                int n11 = dVar2.n();
                Bitmap j10 = this.f50630f.j(Uri.fromFile(new File(new File(this.f50632h, l4.a.a(file, i11)).getPath())).toString(), this.f50629e);
                if (k11 != 2) {
                    if (k11 == 0) {
                        Bitmap e2 = e(i11);
                        if (e2 != null) {
                            return e2;
                        }
                        FLog.h("Can't retrieve previous APNG_DISPOSE_OP_NONE frame: please try to increase memory cache size!", new Object[0]);
                        return e2;
                    }
                    if (k11 != 1) {
                        return null;
                    }
                    if (b.f50645f) {
                        FLog.g("Create a new bitmap", new Object[0]);
                    }
                    createBitmap = Bitmap.createBitmap(this.f50635k, this.f50636l, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(e(i11), 0.0f, 0.0f, (Paint) null);
                    canvas.clipRect(m11, n11, j10.getWidth() + m11, j10.getHeight() + n11);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    canvas.clipRect(0, 0, this.f50635k, this.f50636l);
                }
            }
            return null;
        }
        Bitmap e10 = i10 > 0 ? e(i10 - 1) : null;
        if (e10 == null) {
            return e10;
        }
        Bitmap j11 = this.f50630f.j(Uri.fromFile(new File(new File(this.f50632h, l4.a.a(file, i10 - 1)).getPath())).toString(), this.f50629e);
        if (b.f50645f) {
            FLog.g("Create a new bitmap", new Object[0]);
        }
        createBitmap = Bitmap.createBitmap(this.f50635k, this.f50636l, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        canvas2.drawBitmap(e10, 0.0f, 0.0f, (Paint) null);
        canvas2.clipRect(m10, n10, j11.getWidth() + m10, j11.getHeight() + n10);
        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas2.clipRect(0, 0, this.f50635k, this.f50636l);
        return createBitmap;
    }

    public final void k() {
        String h10 = h();
        if (h10 == null) {
            return;
        }
        File file = new File(h10);
        this.f50643s = file;
        if (file.exists()) {
            if (b.f50646g) {
                FLog.a("Extracting PNGs..", new Object[0]);
            }
            l4.a.b(this.f50643s);
            if (b.f50646g) {
                FLog.a("Extracting complete", new Object[0]);
            }
            if (b.f50646g) {
                FLog.a("Read APNG information..", new Object[0]);
            }
            l(this.f50643s);
            this.f50633i = true;
        }
    }

    public final void l(File file) {
        q qVar = new q(file);
        qVar.d();
        List<PngChunk> f10 = qVar.e().f();
        for (int i10 = 0; i10 < f10.size(); i10++) {
            PngChunk pngChunk = f10.get(i10);
            if (pngChunk instanceof ar.com.hjg.pngj.chunks.a) {
                ar.com.hjg.pngj.chunks.a aVar = (ar.com.hjg.pngj.chunks.a) pngChunk;
                int h10 = aVar.h();
                this.f50639o = h10;
                if (b.f50646g) {
                    FLog.a("numFrames: %d", Integer.valueOf(h10));
                }
                int i11 = this.f50640p;
                if (i11 > 0) {
                    if (b.f50646g) {
                        FLog.a("numPlays: %d (user defined)", Integer.valueOf(i11));
                    }
                } else {
                    int i12 = aVar.i();
                    this.f50640p = i12;
                    if (b.f50646g) {
                        FLog.a("numPlays: %d (media info)", Integer.valueOf(i12));
                    }
                }
            } else if (pngChunk instanceof d) {
                this.f50627c.add((d) pngChunk);
            }
        }
    }

    public void m(e eVar) {
        this.f50644t = eVar;
    }

    public void n(int i10) {
        this.f50640p = i10;
    }

    public void o(boolean z10) {
        this.f50641q = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        if (this.f50641q && (i10 = this.f50640p) > 0 && this.f50638n >= i10) {
            stop();
            return;
        }
        int i11 = this.f50637m;
        if (i11 < 0) {
            this.f50637m = 0;
        } else if (i11 > this.f50627c.size() - 1) {
            this.f50637m = 0;
        }
        d dVar = this.f50627c.get(this.f50637m);
        scheduleSelf(this, SystemClock.uptimeMillis() + Math.round((dVar.j() * 1000.0f) / dVar.i()));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f50631g.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f50631g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.f50634j = true;
        this.f50637m = 0;
        if (!this.f50633i) {
            if (b.f50645f) {
                FLog.g("Prepare", new Object[0]);
            }
            k();
        }
        if (this.f50633i) {
            if (b.f50645f) {
                FLog.g("Run", new Object[0]);
            }
            run();
            e eVar = this.f50644t;
            if (eVar != null) {
                eVar.c(this);
                return;
            }
            return;
        }
        stop();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.f50638n = 0;
            unscheduleSelf(this);
            this.f50634j = false;
            e eVar = this.f50644t;
            if (eVar != null) {
                eVar.a(this);
            }
        }
    }
}
