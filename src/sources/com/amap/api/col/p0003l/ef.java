package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndoorFloorSwitchView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ef extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5448a = ef.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public int f5449b;

    /* renamed from: c, reason: collision with root package name */
    private Context f5450c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f5451d;

    /* renamed from: e, reason: collision with root package name */
    private int f5452e;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f5453f;

    /* renamed from: g, reason: collision with root package name */
    private int f5454g;

    /* renamed from: h, reason: collision with root package name */
    private int f5455h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f5456i;

    /* renamed from: j, reason: collision with root package name */
    private int f5457j;

    /* renamed from: k, reason: collision with root package name */
    private int f5458k;

    /* renamed from: l, reason: collision with root package name */
    private int f5459l;

    /* renamed from: m, reason: collision with root package name */
    private int f5460m;

    /* renamed from: n, reason: collision with root package name */
    private int f5461n;

    /* renamed from: o, reason: collision with root package name */
    private int f5462o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f5463p;

    /* renamed from: q, reason: collision with root package name */
    private int f5464q;

    /* renamed from: r, reason: collision with root package name */
    private a f5465r;

    /* compiled from: IndoorFloorSwitchView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(int i10);
    }

    public ef(Context context) {
        super(context);
        this.f5452e = 0;
        this.f5454g = -1;
        this.f5456i = null;
        this.f5457j = Color.parseColor("#eeffffff");
        this.f5458k = Color.parseColor("#44383838");
        this.f5459l = 4;
        this.f5460m = 1;
        this.f5449b = 1;
        this.f5464q = 50;
        a(context);
    }

    @Override // android.widget.ScrollView
    public void fling(int i10) {
        super.fling(i10 / 3);
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        a(i11);
        if (i11 > i13) {
            this.f5454g = 1;
        } else {
            this.f5454g = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f5455h = i10;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            c();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f5457j = i10;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f5455h == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f5450c.getSystemService("window");
                if (windowManager != null) {
                    this.f5455h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() { // from class: com.amap.api.col.3l.ef.2
            private void a(Canvas canvas) {
                canvas.drawColor(ef.this.f5457j);
            }

            private void b(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = ef.this.f5456i.getWidth() + 0;
                rect.bottom = ef.this.f5456i.getHeight() + 0;
                rect2.left = 0;
                rect2.top = ef.this.e()[0];
                rect2.right = ef.this.f5455h + 0;
                rect2.bottom = ef.this.e()[1];
                canvas.drawBitmap(ef.this.f5456i, rect, rect2, paint);
            }

            private void c(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(ef.this.f5458k);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(ef.this.f5459l);
                canvas.drawRect(clipBounds, paint);
            }

            @Override // android.graphics.drawable.Drawable
            public final void draw(Canvas canvas) {
                try {
                    a(canvas);
                    b(canvas);
                    c(canvas);
                } catch (Throwable unused) {
                }
            }

            @Override // android.graphics.drawable.Drawable
            public final int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public final void setAlpha(int i10) {
            }

            @Override // android.graphics.drawable.Drawable
            public final void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }

    private TextView b(String str) {
        TextView textView = new TextView(this.f5450c);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a10 = a(this.f5450c, 8.0f);
        int a11 = a(this.f5450c, 6.0f);
        textView.setPadding(a10, a11, a10, a11);
        if (this.f5452e == 0) {
            this.f5452e = a(textView);
            this.f5451d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f5452e * this.f5461n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f5452e * this.f5461n));
        }
        return textView;
    }

    private void c() {
        this.f5462o = getScrollY();
        postDelayed(this.f5463p, this.f5464q);
    }

    private void d() {
        List<String> list = this.f5453f;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f5451d.removeAllViews();
        this.f5461n = (this.f5460m * 2) + 1;
        for (int size = this.f5453f.size() - 1; size >= 0; size--) {
            this.f5451d.addView(b(this.f5453f.get(size)));
        }
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] e() {
        int i10 = this.f5452e;
        int i11 = this.f5460m;
        return new int[]{i10 * i11, i10 * (i11 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        a aVar = this.f5465r;
        if (aVar != null) {
            try {
                aVar.a(g());
            } catch (Throwable unused) {
            }
        }
    }

    private int g() {
        List<String> list = this.f5453f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f5453f.size() - (this.f5460m * 2), Math.max(0, ((this.f5453f.size() - 1) - this.f5449b) - this.f5460m));
    }

    private void a(Context context) {
        this.f5450c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f5456i == null) {
                InputStream open = dr.a(context).open("map_indoor_select.png");
                this.f5456i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f5451d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f5451d);
        this.f5463p = new Runnable() { // from class: com.amap.api.col.3l.ef.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ef.this.f5462o - ef.this.getScrollY() == 0) {
                    if (ef.this.f5452e == 0) {
                        return;
                    }
                    final int i10 = ef.this.f5462o % ef.this.f5452e;
                    final int i11 = ef.this.f5462o / ef.this.f5452e;
                    if (i10 != 0) {
                        if (i10 > ef.this.f5452e / 2) {
                            ef.this.post(new Runnable() { // from class: com.amap.api.col.3l.ef.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ef efVar = ef.this;
                                    efVar.smoothScrollTo(0, (efVar.f5462o - i10) + ef.this.f5452e);
                                    ef efVar2 = ef.this;
                                    efVar2.f5449b = i11 + efVar2.f5460m + 1;
                                    ef.this.f();
                                }
                            });
                            return;
                        } else {
                            ef.this.post(new Runnable() { // from class: com.amap.api.col.3l.ef.1.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ef efVar = ef.this;
                                    efVar.smoothScrollTo(0, efVar.f5462o - i10);
                                    ef efVar2 = ef.this;
                                    efVar2.f5449b = i11 + efVar2.f5460m;
                                    ef.this.f();
                                }
                            });
                            return;
                        }
                    }
                    ef efVar = ef.this;
                    efVar.f5449b = i11 + efVar.f5460m;
                    ef.this.f();
                    return;
                }
                ef efVar2 = ef.this;
                efVar2.f5462o = efVar2.getScrollY();
                ef efVar3 = ef.this;
                efVar3.postDelayed(efVar3.f5463p, ef.this.f5464q);
            }
        };
    }

    private void a(int i10) {
        int i11 = this.f5452e;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f5460m;
        int i13 = (i10 / i11) + i12;
        int i14 = i10 % i11;
        int i15 = i10 / i11;
        if (i14 == 0) {
            i13 = i15 + i12;
        } else if (i14 > i11 / 2) {
            i13 = i15 + i12 + 1;
        }
        int childCount = this.f5451d.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            TextView textView = (TextView) this.f5451d.getChildAt(i16);
            if (textView == null) {
                return;
            }
            if (i13 == i16) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    private static void b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public final boolean b() {
        return getVisibility() == 0;
    }

    public final void a(String[] strArr) {
        if (this.f5453f == null) {
            this.f5453f = new ArrayList();
        }
        this.f5453f.clear();
        for (String str : strArr) {
            this.f5453f.add(str);
        }
        for (int i10 = 0; i10 < this.f5460m; i10++) {
            this.f5453f.add(0, "");
            this.f5453f.add("");
        }
        d();
    }

    public final void a() {
        Bitmap bitmap = this.f5456i;
        if (bitmap != null && !bitmap.isRecycled()) {
            dx.a(this.f5456i);
            this.f5456i = null;
        }
        if (this.f5465r != null) {
            this.f5465r = null;
        }
    }

    public final void a(String str) {
        List<String> list = this.f5453f;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f5453f.indexOf(str);
        int size = this.f5453f.size();
        final int i10 = ((size - r1) - 1) - indexOf;
        this.f5449b = this.f5460m + i10;
        post(new Runnable() { // from class: com.amap.api.col.3l.ef.3
            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, i10 * efVar.f5452e);
            }
        });
    }

    public final void a(a aVar) {
        this.f5465r = aVar;
    }

    private static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int a(View view) {
        b(view);
        return view.getMeasuredHeight();
    }

    public final void a(boolean z10) {
        setVisibility(z10 ? 0 : 8);
    }
}
