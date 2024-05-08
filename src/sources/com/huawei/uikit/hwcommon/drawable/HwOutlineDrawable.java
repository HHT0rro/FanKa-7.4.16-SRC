package com.huawei.uikit.hwcommon.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.agdpro.R$color;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwOutlineDrawable extends DrawableWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34939a = "HwOutlineDrawable";

    /* renamed from: b, reason: collision with root package name */
    public static final int f34940b = -16744961;

    /* renamed from: c, reason: collision with root package name */
    public static final int f34941c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final int f34942d = 255;

    /* renamed from: e, reason: collision with root package name */
    public static final int f34943e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final float f34944f = 2.0f;

    /* renamed from: g, reason: collision with root package name */
    public static final float f34945g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    public static final float f34946h = Float.NEGATIVE_INFINITY;

    /* renamed from: i, reason: collision with root package name */
    public int f34947i;

    /* renamed from: j, reason: collision with root package name */
    public int f34948j;

    /* renamed from: k, reason: collision with root package name */
    public int f34949k;

    /* renamed from: l, reason: collision with root package name */
    public int f34950l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f34951m;

    /* renamed from: n, reason: collision with root package name */
    public float f34952n;

    /* renamed from: o, reason: collision with root package name */
    public float f34953o;

    /* renamed from: p, reason: collision with root package name */
    public float f34954p;

    /* renamed from: q, reason: collision with root package name */
    public Rect f34955q;

    /* renamed from: r, reason: collision with root package name */
    public Rect f34956r;

    /* renamed from: s, reason: collision with root package name */
    public View f34957s;

    /* renamed from: t, reason: collision with root package name */
    public Paint f34958t;

    /* renamed from: u, reason: collision with root package name */
    public Path f34959u;

    public HwOutlineDrawable(@NonNull Context context, @Nullable Drawable drawable, @NonNull View view, boolean z10) {
        super(drawable instanceof HwDrawableWrapper ? ((HwDrawableWrapper) drawable).getDrawable() : drawable);
        this.f34947i = f34940b;
        this.f34950l = 0;
        this.f34952n = Float.NEGATIVE_INFINITY;
        this.f34953o = Float.NEGATIVE_INFINITY;
        this.f34955q = new Rect(0, 0, 0, 0);
        this.f34956r = new Rect(0, 0, 0, 0);
        this.f34958t = new Paint();
        this.f34959u = new Path();
        if (context != null) {
            Resources resources = context.getResources();
            this.f34954p = resources.getDisplayMetrics().density;
            this.f34947i = resources.getColor(R$color.emui_accent, null);
        }
        this.f34957s = view;
        this.f34951m = z10;
        this.f34949k = z10 ? (int) ((this.f34954p * 4.0f) + 0.5f) : 0;
        this.f34948j = (int) ((this.f34954p * 4.0f) + 0.5f);
        this.f34958t.setStrokeJoin(Paint.Join.ROUND);
        this.f34958t.setStrokeCap(Paint.Cap.ROUND);
        this.f34958t.setAntiAlias(true);
        this.f34958t.setStyle(Paint.Style.STROKE);
        this.f34958t.setColor(this.f34947i);
        this.f34958t.setShader(null);
        this.f34958t.setStrokeWidth(this.f34948j);
        this.f34958t.setAlpha(255);
    }

    private void a(ViewOutlineProvider viewOutlineProvider, View view, int i10, Rect rect, Path path) {
        if (viewOutlineProvider == null || view == null || path == null || rect == null) {
            return;
        }
        Outline outline = new Outline();
        viewOutlineProvider.getOutline(view, outline);
        float radius = outline.getRadius();
        if (!Float.isInfinite(this.f34952n)) {
            radius = this.f34952n;
        }
        Rect rect2 = new Rect();
        outline.getRect(rect2);
        int i11 = rect2.left;
        Rect rect3 = this.f34955q;
        rect2.left = i11 + rect3.left;
        rect2.top += rect3.top;
        rect2.right += rect3.right;
        rect2.bottom += rect3.bottom;
        Rect rect4 = new Rect(rect2.left - i10, rect2.top - i10, rect2.right + i10, rect2.bottom + i10);
        if (rect4.equals(rect) && i10 == this.f34950l && radius == this.f34953o) {
            return;
        }
        RectF rectF = new RectF(rect4.left, rect4.top, rect4.right, rect4.bottom);
        float f10 = Float.compare(radius, 0.0f) == 0 ? radius : i10 + radius;
        path.reset();
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        rect.left = rect4.left;
        rect.top = rect4.top;
        rect.right = rect4.right;
        rect.bottom = rect4.bottom;
        this.f34950l = i10;
        this.f34953o = radius;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f34957s == null || this.f34947i == 0 || !isDrawOutline()) {
            return;
        }
        a(canvas);
    }

    public boolean isDrawOutline() {
        return true;
    }

    public void setOffsetRect(@NonNull Rect rect) {
        if (rect == null) {
            return;
        }
        Rect rect2 = this.f34955q;
        rect2.left = rect.left;
        rect2.right = rect.right;
        rect2.top = rect.top;
        rect2.bottom = rect.bottom;
    }

    public void setOutlineColor(int i10) {
        this.f34947i = i10;
    }

    public void setOutlineDistance(int i10) {
        this.f34949k = i10;
    }

    public void setOutlineRadius(float f10) {
        this.f34952n = f10;
    }

    public void setOutlineWidth(int i10) {
        this.f34948j = i10;
    }

    private void a(Canvas canvas) {
        int i10 = (int) ((this.f34948j / 2.0f) + this.f34949k + 0.5f);
        a(this.f34957s.getOutlineProvider(), this.f34957s, this.f34951m ? i10 : -i10, this.f34956r, this.f34959u);
        canvas.translate(this.f34957s.getScrollX(), this.f34957s.getScrollY());
        Rect rect = this.f34956r;
        int saveLayerAlpha = canvas.saveLayerAlpha(rect.left - i10, rect.top - i10, rect.right + i10, rect.bottom + i10, 255);
        this.f34958t.setColor(this.f34947i);
        this.f34958t.setStrokeWidth(this.f34948j);
        canvas.drawPath(this.f34959u, this.f34958t);
        canvas.restoreToCount(saveLayerAlpha);
        canvas.translate(-this.f34957s.getScrollX(), -this.f34957s.getScrollY());
    }
}
