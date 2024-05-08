package x0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShadowDrawable.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a extends Drawable {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final C0834a f54353h = new C0834a(null);

    /* renamed from: a, reason: collision with root package name */
    public final float f54354a;

    /* renamed from: b, reason: collision with root package name */
    public final float f54355b;

    /* renamed from: c, reason: collision with root package name */
    public float f54356c;

    /* renamed from: d, reason: collision with root package name */
    public float f54357d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Paint f54358e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Paint f54359f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final RectF f54360g;

    /* compiled from: ShadowDrawable.kt */
    @d
    /* renamed from: x0.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0834a {
        public C0834a() {
        }

        public /* synthetic */ C0834a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull View view, int i10, float f10, int i11, float f11, float f12, float f13) {
            s.i(view, "view");
            view.setLayerType(1, null);
            a aVar = new a(i10, f10, i11, f11);
            aVar.a(f12);
            aVar.b(f13);
            view.setBackground(aVar);
        }
    }

    public a(int i10, float f10, int i11, float f11) {
        this.f54354a = f10;
        this.f54355b = f11;
        Paint paint = new Paint();
        this.f54358e = paint;
        Paint paint2 = new Paint();
        this.f54359f = paint2;
        this.f54360g = new RectF();
        paint.setAntiAlias(true);
        paint.setColor(0);
        paint.setShadowLayer(f11, this.f54356c, this.f54357d, i11);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        paint2.setAntiAlias(true);
        paint2.setColor(i10);
    }

    public final void a(float f10) {
        this.f54356c = f10;
    }

    public final void b(float f10) {
        this.f54357d = f10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        s.i(canvas, "canvas");
        RectF rectF = this.f54360g;
        float f10 = this.f54354a;
        canvas.drawRoundRect(rectF, f10, f10, this.f54358e);
        RectF rectF2 = this.f54360g;
        float f11 = this.f54354a;
        canvas.drawRoundRect(rectF2, f11, f11, this.f54359f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f54358e.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        RectF rectF = this.f54360g;
        float f10 = this.f54355b;
        float f11 = this.f54356c;
        float f12 = this.f54357d;
        rectF.set((i10 + f10) - f11, (i11 + f10) - f12, (i12 - f10) - f11, (i13 - f10) - f12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f54358e.setColorFilter(colorFilter);
    }
}
