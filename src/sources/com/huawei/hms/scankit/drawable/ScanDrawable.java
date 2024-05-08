package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.scankit.R;
import com.huawei.hms.scankit.p.b1;
import com.huawei.hms.scankit.p.b6;
import com.huawei.hms.scankit.p.n6;
import com.huawei.hms.scankit.p.y5;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ScanDrawable extends Drawable implements Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator f30605a;

    /* renamed from: b, reason: collision with root package name */
    private final ValueAnimator f30606b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f30607c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f30608d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f30609e;

    /* renamed from: f, reason: collision with root package name */
    private final ColorMatrix f30610f;

    /* renamed from: g, reason: collision with root package name */
    private final Matrix f30611g;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f30612h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f30613i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f30614j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f30615k;

    /* renamed from: l, reason: collision with root package name */
    private int f30616l;

    /* renamed from: m, reason: collision with root package name */
    private int f30617m;

    /* renamed from: n, reason: collision with root package name */
    private float f30618n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f30619o;

    /* renamed from: p, reason: collision with root package name */
    private float f30620p;

    /* renamed from: q, reason: collision with root package name */
    private int f30621q;

    /* renamed from: r, reason: collision with root package name */
    private y5 f30622r;

    /* renamed from: s, reason: collision with root package name */
    private float f30623s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f30624t;

    /* renamed from: u, reason: collision with root package name */
    private Bitmap f30625u;

    /* renamed from: v, reason: collision with root package name */
    private Bitmap f30626v;

    /* renamed from: w, reason: collision with root package name */
    private AnimatorSet f30627w;

    /* renamed from: x, reason: collision with root package name */
    private static final int[] f30602x = {13625597, 357325};

    /* renamed from: y, reason: collision with root package name */
    private static final Interpolator f30603y = new b1(0.4f, 0.0f, 0.4f, 1.0f);

    /* renamed from: z, reason: collision with root package name */
    private static final Interpolator f30604z = new b1(0.4f, 0.0f, 0.7f, 1.0f);
    private static final Interpolator A = new b1(0.25f, 0.0f, 0.4f, 1.0f);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) ScanDrawable.this.f30606b.getAnimatedValue()).floatValue();
            ScanDrawable scanDrawable = ScanDrawable.this;
            scanDrawable.f30621q = scanDrawable.f30615k.top + ((int) (ScanDrawable.this.f30615k.height() * ScanDrawable.f30603y.getInterpolation(floatValue)));
            if (floatValue < 0.389f) {
                ScanDrawable.this.f30620p = ScanDrawable.f30604z.getInterpolation(floatValue / 0.389f);
            } else {
                ScanDrawable.this.f30620p = 1.0f - ScanDrawable.A.getInterpolation((floatValue - 0.389f) / 0.611f);
            }
            ScanDrawable.this.invalidateSelf();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            ScanDrawable.this.f30619o = !r2.f30619o;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            float abs = Math.abs(((Float) ScanDrawable.this.f30606b.getAnimatedValue()).floatValue() - 0.5f);
            ScanDrawable.this.f30624t = !r1.f30624t;
            if (ScanDrawable.this.f30624t) {
                if (abs > 0.35f) {
                    ScanDrawable.this.f30618n = 0.0f;
                } else {
                    ScanDrawable.this.f30618n = n6.a(0.5f);
                }
            }
        }
    }

    public ScanDrawable() {
        this.f30605a = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f30606b = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f30607c = new Matrix();
        this.f30608d = new Paint();
        this.f30609e = new Paint();
        this.f30610f = new ColorMatrix();
        this.f30611g = new Matrix();
        this.f30612h = new Rect();
        this.f30613i = new Rect();
        this.f30614j = new Rect();
        this.f30615k = new Rect();
        this.f30618n = 0.5f;
        this.f30619o = false;
        this.f30620p = 0.0f;
        this.f30624t = true;
        this.f30627w = new AnimatorSet();
        d();
    }

    private void e() {
        this.f30605a.setInterpolator(new LinearInterpolator());
        this.f30605a.setRepeatMode(2);
        this.f30605a.setRepeatCount(-1);
        this.f30605a.setDuration(500L);
        this.f30605a.setStartDelay(200L);
        this.f30605a.addListener(new c());
    }

    private void f() {
        this.f30606b.setDuration(2000L);
        this.f30606b.setInterpolator(new LinearInterpolator());
        this.f30606b.setRepeatCount(-1);
        this.f30606b.setRepeatMode(2);
        this.f30606b.addUpdateListener(new a());
        this.f30606b.addListener(new b());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!isRunning() || canvas == null) {
            return;
        }
        if (!this.f30619o) {
            int i10 = this.f30621q;
            this.f30613i.set(0, i10, getBounds().right, i10 - ((int) ((this.f30617m * this.f30620p) * 0.5f)));
            int i11 = this.f30621q;
            this.f30614j.set(0, i11, getBounds().right, i11 - ((int) (this.f30617m * this.f30620p)));
        } else {
            int i12 = this.f30621q;
            this.f30613i.set(0, i12, getBounds().right, ((int) (this.f30617m * this.f30620p * 0.5f)) + i12);
            int i13 = this.f30621q;
            this.f30614j.set(0, i13, getBounds().right, ((int) (this.f30617m * this.f30620p)) + i13);
        }
        a(canvas, this.f30614j);
        b(canvas);
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        if (resources == null || xmlPullParser == null || attributeSet == null) {
            return;
        }
        a(resources);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f30627w.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.f30619o = false;
        this.f30624t = true;
        a(getBounds());
        this.f30627w.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.f30627w.end();
            this.f30622r = null;
        }
    }

    private void d() {
        f();
        e();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f30627w = animatorSet;
        animatorSet.playTogether(this.f30606b, this.f30605a);
    }

    private void b(Canvas canvas) {
        y5 y5Var = this.f30622r;
        if (y5Var == null) {
            return;
        }
        y5Var.a(canvas, this.f30613i);
    }

    private void a(Resources resources) {
        if (resources == null) {
            return;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_light);
        this.f30626v = Bitmap.createBitmap(decodeResource.getWidth() * 2, decodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(this.f30626v);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        paint.setShader(new BitmapShader(decodeResource, tileMode, tileMode));
        canvas.drawRect(0.0f, 0.0f, decodeResource.getWidth() * 2, decodeResource.getHeight() * 2, paint);
        this.f30625u = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_tail);
        this.f30623s = resources.getDisplayMetrics().density;
    }

    private void a(Rect rect) {
        if (rect.height() == 0) {
            return;
        }
        this.f30615k.set(rect);
        this.f30615k.inset(0, (int) (rect.height() * 0.1f));
        this.f30616l = (int) (rect.height() * 0.18f);
        this.f30617m = (int) (rect.height() * 0.36f);
        Rect rect2 = new Rect(rect);
        rect2.inset((int) (rect.width() * 0.2f), 0);
        float f10 = this.f30623s;
        int width = (int) ((f10 != 0.0f ? 0.001f / (f10 * f10) : 0.001f) * rect2.width() * rect2.height());
        this.f30622r = new y5(new b6(width, 500L).b(0.33f, 1.0f).a(0, -1, 0L, 100L, new LinearInterpolator()).a(-1, 0, 400L, 500L, new LinearInterpolator()), rect2, width, this.f30623s * 2.0f, f30602x);
    }

    public ScanDrawable(Resources resources) {
        this();
        a(resources);
    }

    private void a(Canvas canvas, Rect rect) {
        Bitmap bitmap = this.f30625u;
        if (bitmap == null || bitmap.getWidth() == 0 || this.f30625u.getHeight() == 0) {
            return;
        }
        this.f30607c.setScale(rect.width() / this.f30625u.getWidth(), rect.height() / this.f30625u.getHeight());
        this.f30607c.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.f30625u, this.f30607c, this.f30608d);
        this.f30607c.reset();
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.f30626v;
        if (bitmap == null || bitmap.getWidth() == 0 || this.f30626v.getHeight() == 0) {
            return;
        }
        float floatValue = (this.f30620p * 0.5f) + (((Float) this.f30605a.getAnimatedValue()).floatValue() * this.f30618n);
        float f10 = (1.5f - floatValue) * 0.05f;
        float f11 = f10 + 1.0f;
        this.f30610f.set(new float[]{1.0f, f10, f10, f10, 0.0f, f10, f11, f10, f10, 0.0f, f10, f10, f11, f10, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.f30609e.setColorFilter(new ColorMatrixColorFilter(this.f30610f));
        int i10 = (int) (this.f30616l * ((floatValue * 0.2f) + 0.4f));
        if (this.f30619o) {
            int i11 = this.f30621q;
            this.f30612h.set(0, i11 + i10, getBounds().right, i11 - i10);
        } else {
            int i12 = this.f30621q;
            this.f30612h.set(0, i12 - i10, getBounds().right, i12 + i10);
        }
        this.f30611g.setScale(this.f30612h.width() / this.f30626v.getWidth(), this.f30612h.height() / this.f30626v.getHeight());
        Matrix matrix = this.f30611g;
        Rect rect = this.f30612h;
        matrix.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.f30626v, this.f30611g, this.f30609e);
        this.f30611g.reset();
    }
}
