package com.huawei.quickcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.background.IBorderRadiusDrawable;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.border.BorderRadius;
import com.huawei.quickcard.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k extends Drawable implements IBorderRadiusDrawable {

    /* renamed from: i, reason: collision with root package name */
    private static final float f34076i = 0.5f;

    /* renamed from: a, reason: collision with root package name */
    private final Context f34077a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f34078b;

    /* renamed from: c, reason: collision with root package name */
    private o f34079c;

    /* renamed from: d, reason: collision with root package name */
    private j f34080d;

    /* renamed from: e, reason: collision with root package name */
    private p f34081e;

    /* renamed from: f, reason: collision with root package name */
    private BorderRadius f34082f;

    /* renamed from: g, reason: collision with root package name */
    private Border f34083g;

    /* renamed from: h, reason: collision with root package name */
    private int f34084h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34085a;

        static {
            int[] iArr = new int[o.a.values().length];
            f34085a = iArr;
            try {
                iArr[o.a.DASHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34085a[o.a.DOTTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public k(Context context) {
        this(context, new Border());
    }

    private float b() {
        p pVar = this.f34081e;
        if (pVar == null) {
            return 0.0f;
        }
        if (pVar.a()) {
            return this.f34081e.d();
        }
        return this.f34081e.b();
    }

    private void c() {
        this.f34081e = this.f34083g.getBorderWidth();
        this.f34080d = this.f34083g.getBorderColor();
        this.f34082f = this.f34083g.getBorderRadius();
        this.f34079c = this.f34083g.getBorderStyle();
    }

    private void d(Canvas canvas, Path path, Rect rect) {
        String f10 = this.f34080d.f();
        if (f10 == null) {
            f10 = this.f34080d.b();
        }
        float f11 = this.f34081e.f();
        if (f11 < 0.0f) {
            f11 = this.f34081e.b();
        }
        o oVar = this.f34079c;
        PathEffect a10 = oVar != null ? a(oVar.f(), f11) : null;
        if (f11 <= 0.0f || f10 == null) {
            return;
        }
        this.f34078b.setColor(ResourceUtils.getColor(f10, 0));
        this.f34078b.setStrokeWidth(f11);
        this.f34078b.setPathEffect(a10);
        path.reset();
        float max = rect.top + Math.max(f11 / 2.0f, 1.0f);
        path.moveTo(rect.left, max);
        path.lineTo(rect.left + rect.width(), max);
        canvas.drawPath(path, this.f34078b);
    }

    public void a(@NonNull Border border) {
        this.f34083g = border;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        c();
        if (this.f34082f != null) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return getAlpha() > 0 ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f34084h != i10) {
            this.f34084h = i10;
            invalidateSelf();
        }
    }

    @Override // com.huawei.quickcard.framework.background.IBorderRadiusDrawable
    public void setBorder(Border border) {
        if (border != this.f34083g) {
            this.f34083g = border;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f34078b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public k(Context context, @NonNull Border border) {
        this.f34078b = new Paint(1);
        this.f34084h = 255;
        this.f34077a = context;
        this.f34083g = border;
    }

    private void a(Canvas canvas) {
        canvas.save();
        float b4 = b();
        if (b4 <= 0.0f) {
            return;
        }
        int a10 = a();
        PathEffect a11 = a(b4);
        RectF rectF = new RectF(getBounds());
        float f10 = b4 / 2.0f;
        rectF.inset(f10, f10);
        float[] a12 = m.a(this.f34077a, this.f34082f, getBounds(), b4);
        this.f34078b.reset();
        this.f34078b.setAntiAlias(true);
        this.f34078b.setStyle(Paint.Style.STROKE);
        this.f34078b.setPathEffect(a11);
        this.f34078b.setColor(a10);
        this.f34078b.setStrokeWidth(b4 + 0.5f);
        this.f34078b.setAlpha(this.f34084h);
        Path path = new Path();
        path.reset();
        path.addRoundRect(rectF, a12, Path.Direction.CW);
        canvas.drawPath(path, this.f34078b);
        this.f34078b.reset();
        canvas.restore();
    }

    private void b(Canvas canvas) {
        if (this.f34081e == null) {
            return;
        }
        if (this.f34080d == null) {
            this.f34080d = new j();
        }
        canvas.save();
        Rect bounds = getBounds();
        Path path = new Path();
        this.f34078b.reset();
        this.f34078b.setAntiAlias(true);
        this.f34078b.setAlpha(this.f34084h);
        this.f34078b.setStyle(Paint.Style.STROKE);
        b(canvas, path, bounds);
        d(canvas, path, bounds);
        c(canvas, path, bounds);
        a(canvas, path, bounds);
        this.f34078b.reset();
        canvas.restore();
    }

    private void c(Canvas canvas, Path path, Rect rect) {
        String e2 = this.f34080d.e();
        if (e2 == null) {
            e2 = this.f34080d.b();
        }
        float e10 = this.f34081e.e();
        if (e10 < 0.0f) {
            e10 = this.f34081e.b();
        }
        o oVar = this.f34079c;
        PathEffect a10 = oVar != null ? a(oVar.e(), e10) : null;
        if (e10 <= 0.0f || e2 == null) {
            return;
        }
        this.f34078b.setColor(ResourceUtils.getColor(e2, 0));
        this.f34078b.setStrokeWidth(e10);
        this.f34078b.setPathEffect(a10);
        path.reset();
        float width = (float) ((rect.left + rect.width()) - Math.max(e10 / 2.0d, 1.0d));
        path.moveTo(width, rect.top);
        path.lineTo(width, rect.top + rect.height());
        canvas.drawPath(path, this.f34078b);
    }

    private void b(Canvas canvas, Path path, Rect rect) {
        String d10 = this.f34080d.d();
        if (d10 == null) {
            d10 = this.f34080d.b();
        }
        float d11 = this.f34081e.d();
        if (d11 < 0.0f) {
            d11 = this.f34081e.b();
        }
        o oVar = this.f34079c;
        PathEffect a10 = oVar != null ? a(oVar.d(), d11) : null;
        if (d11 <= 0.0f || d10 == null) {
            return;
        }
        this.f34078b.setColor(ResourceUtils.getColor(d10, 0));
        this.f34078b.setStrokeWidth(d11);
        this.f34078b.setPathEffect(a10);
        path.reset();
        float max = rect.left + Math.max(d11 / 2.0f, 1.0f);
        path.moveTo(max, rect.top);
        path.lineTo(max, rect.top + rect.height());
        canvas.drawPath(path, this.f34078b);
    }

    private PathEffect a(float f10) {
        o oVar = this.f34079c;
        if (oVar == null) {
            return null;
        }
        if (oVar.b() != null) {
            return a(this.f34079c.b(), f10);
        }
        if (this.f34079c.a()) {
            return a(this.f34079c.d(), f10);
        }
        return null;
    }

    private int a() {
        j jVar = this.f34080d;
        if (jVar == null) {
            return -16777216;
        }
        if (jVar.a()) {
            return ResourceUtils.getColor(this.f34080d.d(), -16777216);
        }
        return ResourceUtils.getColor(this.f34080d.b(), -16777216);
    }

    public PathEffect a(o.a aVar, float f10) {
        if (aVar == null && (aVar = this.f34079c.b()) == null) {
            return null;
        }
        int i10 = a.f34085a[aVar.ordinal()];
        if (i10 == 1) {
            float f11 = f10 * 3.0f;
            return new DashPathEffect(new float[]{f11, f11, f11, f11}, 0.0f);
        }
        if (i10 != 2) {
            return null;
        }
        if (f10 < 2.0f && f10 > 0.0f) {
            f10 = 2.0f;
        }
        return new DashPathEffect(new float[]{f10, f10, f10, f10}, 0.0f);
    }

    private void a(Canvas canvas, Path path, Rect rect) {
        String c4 = this.f34080d.c();
        if (c4 == null) {
            c4 = this.f34080d.b();
        }
        float c10 = this.f34081e.c();
        if (c10 < 0.0f) {
            c10 = this.f34081e.b();
        }
        o oVar = this.f34079c;
        PathEffect a10 = oVar != null ? a(oVar.c(), c10) : null;
        if (c10 <= 0.0f || c4 == null) {
            return;
        }
        this.f34078b.setColor(ResourceUtils.getColor(c4, 0));
        this.f34078b.setStrokeWidth(c10);
        this.f34078b.setPathEffect(a10);
        path.reset();
        float height = (rect.top + rect.height()) - Math.max(c10 / 2.0f, 1.0f);
        path.moveTo(rect.left, height);
        path.lineTo(rect.left + rect.width(), height);
        canvas.drawPath(path, this.f34078b);
    }
}
