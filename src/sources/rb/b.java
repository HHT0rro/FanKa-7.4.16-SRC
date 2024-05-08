package rb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.os.Build;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.e;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.h;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import rb.a;
import yd.n;

/* compiled from: SVGACanvasDrawer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends rb.a {

    /* renamed from: d, reason: collision with root package name */
    public final C0813b f53335d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<String, Bitmap> f53336e;

    /* renamed from: f, reason: collision with root package name */
    public final a f53337f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean[] f53338g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean[] f53339h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f53340i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final e f53341j;

    /* compiled from: SVGACanvasDrawer.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f53342a;

        /* renamed from: b, reason: collision with root package name */
        public int f53343b;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap<SVGAVideoShapeEntity, Path> f53344c = new HashMap<>();

        @NotNull
        public final Path a(@NotNull SVGAVideoShapeEntity shape) {
            s.j(shape, "shape");
            if (!this.f53344c.containsKey(shape)) {
                Path path = new Path();
                path.set(shape.f());
                this.f53344c.put(shape, path);
            }
            Path path2 = this.f53344c.get(shape);
            if (path2 == null) {
                s.u();
            }
            return path2;
        }

        public final void b(@NotNull Canvas canvas) {
            s.j(canvas, "canvas");
            if (this.f53342a != canvas.getWidth() || this.f53343b != canvas.getHeight()) {
                this.f53344c.clear();
            }
            this.f53342a = canvas.getWidth();
            this.f53343b = canvas.getHeight();
        }
    }

    /* compiled from: SVGACanvasDrawer.kt */
    @d
    /* renamed from: rb.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0813b {

        /* renamed from: a, reason: collision with root package name */
        public final Paint f53345a = new Paint();

        /* renamed from: b, reason: collision with root package name */
        public final Path f53346b = new Path();

        /* renamed from: c, reason: collision with root package name */
        public final Path f53347c = new Path();

        /* renamed from: d, reason: collision with root package name */
        public final Matrix f53348d = new Matrix();

        /* renamed from: e, reason: collision with root package name */
        public final Matrix f53349e = new Matrix();

        /* renamed from: f, reason: collision with root package name */
        public final Paint f53350f = new Paint();

        /* renamed from: g, reason: collision with root package name */
        public Canvas f53351g;

        /* renamed from: h, reason: collision with root package name */
        public Bitmap f53352h;

        @NotNull
        public final Canvas a(int i10, int i11) {
            if (this.f53351g == null) {
                this.f53352h = Bitmap.createBitmap(i10, i11, Bitmap.Config.ALPHA_8);
            }
            return new Canvas(this.f53352h);
        }

        @NotNull
        public final Paint b() {
            this.f53350f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return this.f53350f;
        }

        @NotNull
        public final Matrix c() {
            this.f53348d.reset();
            return this.f53348d;
        }

        @NotNull
        public final Matrix d() {
            this.f53349e.reset();
            return this.f53349e;
        }

        @NotNull
        public final Bitmap e() {
            Bitmap bitmap = this.f53352h;
            if (bitmap != null) {
                return bitmap;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
        }

        @NotNull
        public final Paint f() {
            this.f53345a.reset();
            return this.f53345a;
        }

        @NotNull
        public final Path g() {
            this.f53346b.reset();
            return this.f53346b;
        }

        @NotNull
        public final Path h() {
            this.f53347c.reset();
            return this.f53347c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull SVGAVideoEntity videoItem, @NotNull e dynamicItem) {
        super(videoItem);
        s.j(videoItem, "videoItem");
        s.j(dynamicItem, "dynamicItem");
        this.f53341j = dynamicItem;
        this.f53335d = new C0813b();
        this.f53336e = new HashMap<>();
        this.f53337f = new a();
        this.f53340i = new float[16];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rb.a
    public void a(@NotNull Canvas canvas, int i10, @NotNull ImageView.ScaleType scaleType) {
        a.C0812a c0812a;
        int i11;
        int i12;
        a.C0812a c0812a2;
        s.j(canvas, "canvas");
        s.j(scaleType, "scaleType");
        super.a(canvas, i10, scaleType);
        n(i10);
        this.f53337f.b(canvas);
        List<a.C0812a> e2 = e(i10);
        if (e2.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = null;
        this.f53338g = null;
        this.f53339h = null;
        boolean z10 = false;
        String b4 = e2.get(0).b();
        int i13 = 2;
        boolean q10 = b4 != null ? p.q(b4, ".matte", false, 2, null) : false;
        int i14 = -1;
        int i15 = 0;
        for (a.C0812a c0812a3 : e2) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                kotlin.collections.s.s();
            }
            a.C0812a c0812a4 = c0812a3;
            String b10 = c0812a4.b();
            if (b10 != null) {
                if (q10) {
                    if (p.q(b10, ".matte", z10, i13, obj)) {
                        linkedHashMap.put(b10, c0812a4);
                    }
                } else {
                    i(c0812a4, canvas, i10);
                }
                i15 = i16;
                obj = null;
                z10 = false;
                i13 = 2;
            }
            if (k(i15, e2)) {
                c0812a = c0812a4;
                i11 = i15;
                i12 = -1;
                i14 = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
            } else {
                c0812a = c0812a4;
                i11 = i15;
                i12 = -1;
            }
            i(c0812a, canvas, i10);
            if (l(i11, e2) && (c0812a2 = (a.C0812a) linkedHashMap.get(c0812a.c())) != null) {
                i(c0812a2, this.f53335d.a(canvas.getWidth(), canvas.getHeight()), i10);
                canvas.drawBitmap(this.f53335d.e(), 0.0f, 0.0f, this.f53335d.b());
                if (i14 != i12) {
                    canvas.restoreToCount(i14);
                } else {
                    canvas.restore();
                }
            }
            i15 = i16;
            obj = null;
            z10 = false;
            i13 = 2;
        }
        d(e2);
    }

    public final void f(a.C0812a c0812a, Canvas canvas, int i10) {
        String b4 = c0812a.b();
        if (b4 != null) {
            Function2<Canvas, Integer, Boolean> function2 = this.f53341j.b().get(b4);
            if (function2 != null) {
                Matrix o10 = o(c0812a.a().e());
                canvas.save();
                canvas.concat(o10);
                function2.mo1743invoke(canvas, Integer.valueOf(i10));
                canvas.restore();
            }
            n<Canvas, Integer, Integer, Integer, Boolean> nVar = this.f53341j.c().get(b4);
            if (nVar != null) {
                Matrix o11 = o(c0812a.a().e());
                canvas.save();
                canvas.concat(o11);
                nVar.invoke(canvas, Integer.valueOf(i10), Integer.valueOf((int) c0812a.a().b().b()), Integer.valueOf((int) c0812a.a().b().a()));
                canvas.restore();
            }
        }
    }

    public final void g(a.C0812a c0812a, Canvas canvas) {
        String str;
        String b4 = c0812a.b();
        if (b4 == null || s.d(this.f53341j.d().get(b4), Boolean.TRUE)) {
            return;
        }
        if (p.q(b4, ".matte", false, 2, null)) {
            str = b4.substring(0, b4.length() - 6);
            s.e(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            str = b4;
        }
        Bitmap bitmap = this.f53341j.f().get(str);
        if (bitmap == null) {
            bitmap = c().o().get(str);
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            Matrix o10 = o(c0812a.a().e());
            Paint f10 = this.f53335d.f();
            f10.setAntiAlias(c().k());
            f10.setFilterBitmap(c().k());
            f10.setAlpha((int) (c0812a.a().a() * 255));
            if (c0812a.a().c() != null) {
                sb.b c4 = c0812a.a().c();
                if (c4 == null) {
                    return;
                }
                canvas.save();
                Path g3 = this.f53335d.g();
                c4.a(g3);
                g3.transform(o10);
                canvas.clipPath(g3);
                o10.preScale((float) (c0812a.a().b().b() / bitmap2.getWidth()), (float) (c0812a.a().b().a() / bitmap2.getHeight()));
                if (!bitmap2.isRecycled()) {
                    canvas.drawBitmap(bitmap2, o10, f10);
                }
                canvas.restore();
            } else {
                o10.preScale((float) (c0812a.a().b().b() / bitmap2.getWidth()), (float) (c0812a.a().b().a() / bitmap2.getHeight()));
                if (!bitmap2.isRecycled()) {
                    canvas.drawBitmap(bitmap2, o10, f10);
                }
            }
            com.opensource.svgaplayer.a aVar = this.f53341j.e().get(b4);
            if (aVar != null) {
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                o10.getValues(fArr);
                aVar.a(b4, (int) fArr[2], (int) fArr[5], (int) ((bitmap2.getWidth() * fArr[0]) + fArr[2]), (int) ((bitmap2.getHeight() * fArr[4]) + fArr[5]));
            }
            j(canvas, bitmap2, c0812a, o10);
        }
    }

    public final void h(a.C0812a c0812a, Canvas canvas) {
        float[] c4;
        String d10;
        String b4;
        int a10;
        Matrix o10 = o(c0812a.a().e());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0812a.a().d()) {
            sVGAVideoShapeEntity.a();
            if (sVGAVideoShapeEntity.f() != null) {
                Paint f10 = this.f53335d.f();
                f10.reset();
                f10.setAntiAlias(c().k());
                double d11 = 255;
                f10.setAlpha((int) (c0812a.a().a() * d11));
                Path g3 = this.f53335d.g();
                g3.reset();
                g3.addPath(this.f53337f.a(sVGAVideoShapeEntity));
                Matrix d12 = this.f53335d.d();
                d12.reset();
                Matrix h10 = sVGAVideoShapeEntity.h();
                if (h10 != null) {
                    d12.postConcat(h10);
                }
                d12.postConcat(o10);
                g3.transform(d12);
                SVGAVideoShapeEntity.a g10 = sVGAVideoShapeEntity.g();
                if (g10 != null && (a10 = g10.a()) != 0) {
                    f10.setStyle(Paint.Style.FILL);
                    f10.setColor(a10);
                    int min = Math.min(255, Math.max(0, (int) (c0812a.a().a() * d11)));
                    if (min != 255) {
                        f10.setAlpha(min);
                    }
                    if (c0812a.a().c() != null) {
                        canvas.save();
                    }
                    sb.b c10 = c0812a.a().c();
                    if (c10 != null) {
                        Path h11 = this.f53335d.h();
                        c10.a(h11);
                        h11.transform(o10);
                        canvas.clipPath(h11);
                    }
                    canvas.drawPath(g3, f10);
                    if (c0812a.a().c() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a g11 = sVGAVideoShapeEntity.g();
                if (g11 != null) {
                    float f11 = 0;
                    if (g11.g() > f11) {
                        f10.setAlpha((int) (c0812a.a().a() * d11));
                        f10.setStyle(Paint.Style.STROKE);
                        SVGAVideoShapeEntity.a g12 = sVGAVideoShapeEntity.g();
                        if (g12 != null) {
                            f10.setColor(g12.f());
                            int min2 = Math.min(255, Math.max(0, (int) (c0812a.a().a() * d11)));
                            if (min2 != 255) {
                                f10.setAlpha(min2);
                            }
                        }
                        float m10 = m(o10);
                        SVGAVideoShapeEntity.a g13 = sVGAVideoShapeEntity.g();
                        if (g13 != null) {
                            f10.setStrokeWidth(g13.g() * m10);
                        }
                        SVGAVideoShapeEntity.a g14 = sVGAVideoShapeEntity.g();
                        if (g14 != null && (b4 = g14.b()) != null) {
                            if (p.r(b4, "butt", true)) {
                                f10.setStrokeCap(Paint.Cap.BUTT);
                            } else if (p.r(b4, "round", true)) {
                                f10.setStrokeCap(Paint.Cap.ROUND);
                            } else if (p.r(b4, "square", true)) {
                                f10.setStrokeCap(Paint.Cap.SQUARE);
                            }
                        }
                        SVGAVideoShapeEntity.a g15 = sVGAVideoShapeEntity.g();
                        if (g15 != null && (d10 = g15.d()) != null) {
                            if (p.r(d10, "miter", true)) {
                                f10.setStrokeJoin(Paint.Join.MITER);
                            } else if (p.r(d10, "round", true)) {
                                f10.setStrokeJoin(Paint.Join.ROUND);
                            } else if (p.r(d10, "bevel", true)) {
                                f10.setStrokeJoin(Paint.Join.BEVEL);
                            }
                        }
                        if (sVGAVideoShapeEntity.g() != null) {
                            f10.setStrokeMiter(r6.e() * m10);
                        }
                        SVGAVideoShapeEntity.a g16 = sVGAVideoShapeEntity.g();
                        if (g16 != null && (c4 = g16.c()) != null && c4.length == 3 && (c4[0] > f11 || c4[1] > f11)) {
                            float[] fArr = new float[2];
                            fArr[0] = (c4[0] >= 1.0f ? c4[0] : 1.0f) * m10;
                            fArr[1] = (c4[1] >= 0.1f ? c4[1] : 0.1f) * m10;
                            f10.setPathEffect(new DashPathEffect(fArr, c4[2] * m10));
                        }
                        if (c0812a.a().c() != null) {
                            canvas.save();
                        }
                        sb.b c11 = c0812a.a().c();
                        if (c11 != null) {
                            Path h12 = this.f53335d.h();
                            c11.a(h12);
                            h12.transform(o10);
                            canvas.clipPath(h12);
                        }
                        canvas.drawPath(g3, f10);
                        if (c0812a.a().c() != null) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    public final void i(a.C0812a c0812a, Canvas canvas, int i10) {
        g(c0812a, canvas);
        h(c0812a, canvas);
        f(c0812a, canvas, i10);
    }

    public final void j(Canvas canvas, Bitmap bitmap, a.C0812a c0812a, Matrix matrix) {
        int i10;
        StaticLayout layout;
        TextPaint drawingTextPaint;
        if (this.f53341j.k()) {
            this.f53336e.clear();
            this.f53341j.o(false);
        }
        String b4 = c0812a.b();
        if (b4 != null) {
            Bitmap bitmap2 = null;
            String str = this.f53341j.h().get(b4);
            if (str != null && (drawingTextPaint = this.f53341j.i().get(b4)) != null && (bitmap2 = this.f53336e.get(b4)) == null) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                Canvas canvas2 = new Canvas(bitmap2);
                s.e(drawingTextPaint, "drawingTextPaint");
                drawingTextPaint.setAntiAlias(true);
                Paint.FontMetrics fontMetrics = drawingTextPaint.getFontMetrics();
                float f10 = 2;
                canvas2.drawText(str, rect.centerX(), (rect.centerY() - (fontMetrics.top / f10)) - (fontMetrics.bottom / f10), drawingTextPaint);
                HashMap<String, Bitmap> hashMap = this.f53336e;
                if (bitmap2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap.put(b4, bitmap2);
            }
            BoringLayout it = this.f53341j.a().get(b4);
            if (it != null && (bitmap2 = this.f53336e.get(b4)) == null) {
                s.e(it, "it");
                TextPaint paint = it.getPaint();
                s.e(paint, "it.paint");
                paint.setAntiAlias(true);
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(bitmap2);
                canvas3.translate(0.0f, (bitmap.getHeight() - it.getHeight()) / 2);
                it.draw(canvas3);
                HashMap<String, Bitmap> hashMap2 = this.f53336e;
                if (bitmap2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap2.put(b4, bitmap2);
            }
            StaticLayout it2 = this.f53341j.g().get(b4);
            if (it2 != null && (bitmap2 = this.f53336e.get(b4)) == null) {
                s.e(it2, "it");
                TextPaint paint2 = it2.getPaint();
                s.e(paint2, "it.paint");
                paint2.setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        Field field = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                        s.e(field, "field");
                        field.setAccessible(true);
                        i10 = field.getInt(it2);
                    } catch (Exception unused) {
                        i10 = Integer.MAX_VALUE;
                    }
                    layout = StaticLayout.Builder.obtain(it2.getText(), 0, it2.getText().length(), it2.getPaint(), bitmap.getWidth()).setAlignment(it2.getAlignment()).setMaxLines(i10).setEllipsize(TextUtils.TruncateAt.END).build();
                } else {
                    layout = new StaticLayout(it2.getText(), 0, it2.getText().length(), it2.getPaint(), bitmap.getWidth(), it2.getAlignment(), it2.getSpacingMultiplier(), it2.getSpacingAdd(), false);
                }
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas4 = new Canvas(bitmap2);
                int height = bitmap.getHeight();
                s.e(layout, "layout");
                canvas4.translate(0.0f, (height - layout.getHeight()) / 2);
                layout.draw(canvas4);
                HashMap<String, Bitmap> hashMap3 = this.f53336e;
                if (bitmap2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap3.put(b4, bitmap2);
            }
            if (bitmap2 != null) {
                Paint f11 = this.f53335d.f();
                f11.setAntiAlias(c().k());
                f11.setAlpha((int) (c0812a.a().a() * 255));
                if (c0812a.a().c() != null) {
                    sb.b c4 = c0812a.a().c();
                    if (c4 != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        f11.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                        Path g3 = this.f53335d.g();
                        c4.a(g3);
                        canvas.drawPath(g3, f11);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                f11.setFilterBitmap(c().k());
                canvas.drawBitmap(bitmap2, matrix, f11);
            }
        }
    }

    public final boolean k(int i10, List<a.C0812a> list) {
        Boolean bool;
        String c4;
        a.C0812a c0812a;
        if (this.f53338g == null) {
            int size = list.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i11 = 0; i11 < size; i11++) {
                boolArr[i11] = Boolean.FALSE;
            }
            int i12 = 0;
            for (a.C0812a c0812a2 : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.s.s();
                }
                a.C0812a c0812a3 = c0812a2;
                String b4 = c0812a3.b();
                if ((b4 == null || !p.q(b4, ".matte", false, 2, null)) && (c4 = c0812a3.c()) != null && c4.length() > 0 && (c0812a = list.get(i12 - 1)) != null) {
                    String c10 = c0812a.c();
                    if (c10 == null || c10.length() == 0) {
                        boolArr[i12] = Boolean.TRUE;
                    } else if (!s.d(c0812a.c(), c0812a3.c())) {
                        boolArr[i12] = Boolean.TRUE;
                    }
                }
                i12 = i13;
            }
            this.f53338g = boolArr;
        }
        Boolean[] boolArr2 = this.f53338g;
        if (boolArr2 == null || (bool = boolArr2[i10]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean l(int i10, List<a.C0812a> list) {
        Boolean bool;
        String c4;
        if (this.f53339h == null) {
            int size = list.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i11 = 0; i11 < size; i11++) {
                boolArr[i11] = Boolean.FALSE;
            }
            int i12 = 0;
            for (a.C0812a c0812a : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.s.s();
                }
                a.C0812a c0812a2 = c0812a;
                String b4 = c0812a2.b();
                if ((b4 == null || !p.q(b4, ".matte", false, 2, null)) && (c4 = c0812a2.c()) != null && c4.length() > 0) {
                    if (i12 == list.size() - 1) {
                        boolArr[i12] = Boolean.TRUE;
                    } else {
                        a.C0812a c0812a3 = list.get(i13);
                        if (c0812a3 != null) {
                            String c10 = c0812a3.c();
                            if (c10 == null || c10.length() == 0) {
                                boolArr[i12] = Boolean.TRUE;
                            } else if (!s.d(c0812a3.c(), c0812a2.c())) {
                                boolArr[i12] = Boolean.TRUE;
                            }
                        }
                    }
                }
                i12 = i13;
            }
            this.f53339h = boolArr;
        }
        Boolean[] boolArr2 = this.f53339h;
        if (boolArr2 == null || (bool = boolArr2[i10]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final float m(Matrix matrix) {
        matrix.getValues(this.f53340i);
        float[] fArr = this.f53340i;
        if (fArr[0] == 0.0f) {
            return 0.0f;
        }
        double d10 = fArr[0];
        double d11 = fArr[3];
        double d12 = fArr[1];
        double d13 = fArr[4];
        if (d10 * d13 == d11 * d12) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d10 * d10) + (d11 * d11));
        double d14 = d10 / sqrt;
        double d15 = d11 / sqrt;
        double d16 = (d14 * d12) + (d15 * d13);
        double d17 = d12 - (d14 * d16);
        double d18 = d13 - (d16 * d15);
        double sqrt2 = Math.sqrt((d17 * d17) + (d18 * d18));
        if (d14 * (d18 / sqrt2) < d15 * (d17 / sqrt2)) {
            sqrt = -sqrt;
        }
        return Math.abs(b().a() ? (float) sqrt : (float) sqrt2);
    }

    public final void n(int i10) {
        Integer c4;
        for (sb.a aVar : c().l()) {
            if (aVar.d() == i10) {
                h hVar = h.f38009e;
                if (hVar.b()) {
                    Integer c10 = aVar.c();
                    if (c10 != null) {
                        aVar.e(Integer.valueOf(hVar.d(c10.intValue())));
                    }
                } else {
                    SoundPool p10 = c().p();
                    if (p10 != null && (c4 = aVar.c()) != null) {
                        aVar.e(Integer.valueOf(p10.play(c4.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                    }
                }
            }
            if (aVar.a() <= i10) {
                Integer b4 = aVar.b();
                if (b4 != null) {
                    int intValue = b4.intValue();
                    h hVar2 = h.f38009e;
                    if (hVar2.b()) {
                        hVar2.e(intValue);
                    } else {
                        SoundPool p11 = c().p();
                        if (p11 != null) {
                            p11.stop(intValue);
                        }
                    }
                }
                aVar.e(null);
            }
        }
    }

    public final Matrix o(Matrix matrix) {
        Matrix c4 = this.f53335d.c();
        c4.postScale(b().b(), b().c());
        c4.postTranslate(b().d(), b().e());
        c4.preConcat(matrix);
        return c4;
    }
}
