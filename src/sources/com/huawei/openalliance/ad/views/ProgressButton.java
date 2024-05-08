package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.ay;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ProgressButton extends View implements View.OnClickListener {
    public String Code;
    public int I;
    public int V;

    /* renamed from: a, reason: collision with root package name */
    private Rect f32971a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f32972b;

    /* renamed from: c, reason: collision with root package name */
    private int f32973c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f32974d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32975e;

    /* renamed from: f, reason: collision with root package name */
    private int f32976f;

    /* renamed from: g, reason: collision with root package name */
    private int f32977g;

    /* renamed from: h, reason: collision with root package name */
    private int f32978h;

    /* renamed from: i, reason: collision with root package name */
    private float f32979i;

    /* renamed from: j, reason: collision with root package name */
    private int f32980j;

    /* renamed from: k, reason: collision with root package name */
    private int f32981k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f32982l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f32983m;

    /* renamed from: n, reason: collision with root package name */
    private long f32984n;

    /* renamed from: o, reason: collision with root package name */
    private final byte[] f32985o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f32986p;

    public ProgressButton(Context context) {
        this(context, null);
        Code();
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
        Code(context, attributeSet);
        Code();
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        Code(context, attributeSet);
        Code();
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.f32971a = new Rect();
        this.f32975e = false;
        this.f32978h = -1;
        this.f32979i = 12.0f;
        this.Code = null;
        this.V = -1;
        this.I = -1;
        this.f32980j = 0;
        this.f32981k = 100;
        this.f32985o = new byte[0];
        setOnClickListener(this);
        Code(context, attributeSet);
        Code();
    }

    private CharSequence Code(CharSequence charSequence, int i10, int i11) {
        int length = getText().length();
        int ceil = (int) Math.ceil(((i10 - i11) / getPromptRect().width()) * length);
        int ceil2 = (int) Math.ceil((this.f32973c * length) / getPromptRect().width());
        int i12 = length - ceil;
        if (i12 - ceil2 <= 0) {
            return i12 > 0 ? charSequence.toString().substring(0, i12) : charSequence;
        }
        return charSequence.toString().substring(0, length - (ceil + ceil2)) + "...";
    }

    private void Code() {
        Paint paint = new Paint();
        this.f32972b = paint;
        paint.setAntiAlias(true);
        this.f32972b.setTextSize(this.f32979i);
        this.f32972b.setColor(this.f32978h);
        int i10 = this.I;
        if (i10 != -1) {
            this.Code = null;
        }
        Code(this.Code, this.V, i10);
        setClickable(true);
        Paint paint2 = new Paint();
        paint2.setTextSize(this.f32979i);
        Rect rect = new Rect();
        paint2.getTextBounds("...", 0, 3, rect);
        this.f32973c = rect.width();
        this.f32986p = ay.C();
    }

    private void Code(int i10) {
        synchronized (this.f32985o) {
            int i11 = this.f32981k;
            float f10 = i11 > 0 ? i10 / i11 : 0.0f;
            Drawable drawable = this.f32983m;
            if (drawable != null) {
                drawable.setLevel((int) (f10 * 10000.0f));
            } else {
                invalidate();
            }
        }
    }

    private void Code(int i10, int i11) {
        synchronized (this.f32985o) {
            Drawable drawable = this.f32982l;
            if (drawable != null) {
                drawable.setBounds(0, 0, i10, i11);
            }
        }
    }

    private void Code(Context context, AttributeSet attributeSet) {
        synchronized (this.f32985o) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.hiad_progress_button);
                try {
                    try {
                        try {
                            this.f32975e = obtainStyledAttributes.getBoolean(R.styleable.hiad_progress_button_hiad_fixedWidth, false);
                            this.f32976f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.hiad_progress_button_hiad_maxWidth, 0);
                            this.f32977g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.hiad_progress_button_hiad_minWidth, 0);
                            this.f32979i = obtainStyledAttributes.getDimension(R.styleable.hiad_progress_button_hiad_textSize, 0.0f);
                            this.f32978h = obtainStyledAttributes.getColor(R.styleable.hiad_progress_button_hiad_textColor, -1);
                            this.Code = obtainStyledAttributes.getString(R.styleable.hiad_progress_button_hiad_fontFamily);
                            this.I = obtainStyledAttributes.getInt(R.styleable.hiad_progress_button_hiad_styleIndex, -1);
                            this.V = obtainStyledAttributes.getInt(R.styleable.hiad_progress_button_hiad_typefaceIndex, -1);
                        } catch (UnsupportedOperationException unused) {
                            gl.I("ProgressButton", "initButtonAttr UnsupportedOperationException");
                        } catch (Exception unused2) {
                            gl.I("ProgressButton", "initButtonAttr error");
                        }
                    } catch (RuntimeException unused3) {
                        gl.I("ProgressButton", "initButtonAttr RuntimeException");
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    private void Code(Canvas canvas) {
        synchronized (this.f32985o) {
            CharSequence charSequence = this.f32974d;
            if (charSequence != null && charSequence.length() > 0) {
                String intern = this.f32974d.toString().intern();
                canvas.drawText((CharSequence) intern, 0, intern.length(), (getWidth() / 2) - this.f32971a.centerX(), (getHeight() / 2) - this.f32971a.centerY(), this.f32972b);
            }
        }
    }

    private void Code(String str, int i10, int i11) {
        Typeface typeface;
        gl.Code("ProgressButton", "setTypefaceFromAttrs");
        if (str != null) {
            typeface = Typeface.create(str, i11);
            if (typeface != null) {
                gl.Code("ProgressButton", "setTypeface");
                setPaintTypeface(typeface);
                this.f32972b.setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (i10 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i10 == 2) {
            typeface = Typeface.SERIF;
        } else if (i10 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        Code(typeface, i11);
    }

    private boolean Code(Drawable drawable) {
        Drawable findDrawableByLayerId;
        if (drawable == null || !(drawable instanceof LayerDrawable) || (findDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(16908301)) == null) {
            return false;
        }
        if ((findDrawableByLayerId instanceof f) || (findDrawableByLayerId instanceof g)) {
            return this.f32986p;
        }
        return false;
    }

    private void I() {
        synchronized (this.f32985o) {
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f32982l;
            if (drawable != null && drawable.isStateful()) {
                this.f32982l.setState(drawableState);
            }
        }
    }

    private void V() {
        Paint paint = new Paint();
        paint.setTextSize(this.f32979i);
        Rect rect = new Rect();
        paint.getTextBounds("...", 0, 3, rect);
        this.f32973c = rect.width();
    }

    private void V(int i10, boolean z10) {
        synchronized (this.f32985o) {
            Code(i10);
        }
    }

    private CharSequence getText() {
        CharSequence charSequence;
        synchronized (this.f32985o) {
            charSequence = this.f32974d;
        }
        return charSequence;
    }

    public void C() {
        ViewGroup.LayoutParams layoutParams;
        synchronized (this.f32985o) {
            CharSequence charSequence = this.f32974d;
            if (charSequence != null && charSequence.length() > 0) {
                this.f32972b.getTextBounds(this.f32974d.toString(), 0, this.f32974d.length(), this.f32971a);
                int paddingStart = getPaddingStart();
                if (paddingStart <= 0) {
                    paddingStart = getPaddingLeft();
                }
                int paddingEnd = getPaddingEnd();
                if (paddingEnd <= 0) {
                    paddingEnd = getPaddingRight();
                }
                int width = this.f32971a.width() + paddingStart + paddingEnd;
                if (this.f32975e) {
                    layoutParams = getLayoutParams();
                    int width2 = getWidth();
                    if (width2 <= 0) {
                        width2 = layoutParams.width;
                    }
                    if (width > width2) {
                        CharSequence Code = Code(this.f32974d, width, width2);
                        this.f32974d = Code;
                        this.f32972b.getTextBounds(Code.toString(), 0, this.f32974d.length(), this.f32971a);
                    }
                    if (layoutParams.height <= 0) {
                        layoutParams.height = ((int) this.f32979i) + getPaddingTop() + getPaddingBottom();
                        setLayoutParams(layoutParams);
                    }
                } else {
                    layoutParams = getLayoutParams();
                    if (layoutParams == null) {
                        return;
                    }
                    if (width != layoutParams.width) {
                        int i10 = this.f32976f;
                        if (width <= i10 || i10 <= 0) {
                            int i11 = this.f32977g;
                            if (width < i11) {
                                width = i11;
                            }
                        } else {
                            CharSequence Code2 = Code(this.f32974d, width, i10);
                            this.f32974d = Code2;
                            this.f32972b.getTextBounds(Code2.toString(), 0, this.f32974d.length(), this.f32971a);
                            width = this.f32976f;
                        }
                        layoutParams.width = width;
                        if (layoutParams.height <= 0) {
                            layoutParams.height = ((int) this.f32979i) + getPaddingTop() + getPaddingBottom();
                        }
                        setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    void Code(int i10, boolean z10) {
        synchronized (this.f32985o) {
            if (i10 < 0) {
                i10 = 0;
            }
            int i11 = this.f32981k;
            if (i10 > i11) {
                i10 = i11;
            }
            if (i10 != this.f32980j) {
                this.f32980j = i10;
                V(i10, z10);
            }
        }
    }

    public void Code(Typeface typeface, int i10) {
        if (i10 <= 0) {
            this.f32972b.setFakeBoldText(false);
            this.f32972b.setTextSkewX(0.0f);
            setPaintTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setPaintTypeface(defaultFromStyle);
            int i11 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i10;
            this.f32972b.setFakeBoldText((i11 & 1) != 0);
            this.f32972b.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void Code(Drawable drawable, int i10) {
        boolean z10;
        synchronized (this.f32985o) {
            Drawable drawable2 = this.f32982l;
            if (drawable2 == null || drawable == drawable2) {
                z10 = false;
            } else {
                drawable2.setCallback(null);
                z10 = true;
            }
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.f32982l = drawable;
            this.f32983m = drawable;
            if (z10) {
                Code(getWidth(), getHeight());
                if (i10 < 0) {
                    i10 = 0;
                }
                int i11 = this.f32981k;
                if (i10 > i11) {
                    i10 = i11;
                }
                this.f32980j = i10;
                Code(i10);
            } else {
                setProgress(i10);
            }
        }
    }

    public boolean S() {
        if (System.currentTimeMillis() - this.f32984n < 500) {
            return true;
        }
        this.f32984n = System.currentTimeMillis();
        return false;
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        I();
    }

    public Rect getPromptRect() {
        Rect rect;
        synchronized (this.f32985o) {
            rect = this.f32971a;
        }
        return rect;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        synchronized (this.f32985o) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.f32982l;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.f32985o) {
            super.onDraw(canvas);
            Drawable drawable = this.f32983m;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            if (Code(drawable)) {
                canvas.scale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            }
            Code(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        Code(i10, i11);
    }

    public void setFixedWidth(boolean z10) {
        this.f32975e = z10;
    }

    public void setFontFamily(String str) {
        this.Code = str;
        Code(str, this.V, this.I);
    }

    public void setMaxWidth(int i10) {
        synchronized (this.f32985o) {
            this.f32976f = i10;
        }
    }

    public void setMinWidth(int i10) {
        synchronized (this.f32985o) {
            this.f32977g = i10;
        }
    }

    public void setPaintTypeface(Typeface typeface) {
        synchronized (this.f32985o) {
            this.f32972b.setTypeface(typeface);
        }
    }

    public void setProgress(int i10) {
        synchronized (this.f32985o) {
            Code(i10, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        Code(drawable, 0);
    }

    public void setText(CharSequence charSequence) {
        gl.Code("ProgressButton", "setText:" + ((Object) charSequence));
        synchronized (this.f32985o) {
            this.f32974d = String.valueOf(charSequence).toUpperCase(Locale.getDefault());
            C();
            invalidate();
        }
    }

    public void setTextColor(int i10) {
        this.f32978h = i10;
        Paint paint = this.f32972b;
        if (paint != null) {
            paint.setColor(i10);
        }
    }

    public void setTextSize(float f10) {
        this.f32979i = f10;
        Paint paint = this.f32972b;
        if (paint != null) {
            paint.setAntiAlias(true);
            this.f32972b.setTextSize(this.f32979i);
        }
        V();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        boolean z10;
        synchronized (this.f32985o) {
            z10 = drawable == this.f32982l || super.verifyDrawable(drawable);
        }
        return z10;
    }
}
