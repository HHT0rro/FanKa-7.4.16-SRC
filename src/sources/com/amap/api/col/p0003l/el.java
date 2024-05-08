package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.File;
import java.io.InputStream;

/* compiled from: WaterMarkerView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class el extends View {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f5532a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f5533b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f5534c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f5535d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f5536e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f5537f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f5538g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f5539h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5540i;

    /* renamed from: j, reason: collision with root package name */
    private int f5541j;

    /* renamed from: k, reason: collision with root package name */
    private int f5542k;

    /* renamed from: l, reason: collision with root package name */
    private int f5543l;

    /* renamed from: m, reason: collision with root package name */
    private int f5544m;

    /* renamed from: n, reason: collision with root package name */
    private int f5545n;

    /* renamed from: o, reason: collision with root package name */
    private int f5546o;

    /* renamed from: p, reason: collision with root package name */
    private int f5547p;

    /* renamed from: q, reason: collision with root package name */
    private int f5548q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5549r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5550s;

    /* renamed from: t, reason: collision with root package name */
    private Context f5551t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f5552u;

    /* renamed from: v, reason: collision with root package name */
    private float f5553v;

    /* renamed from: w, reason: collision with root package name */
    private float f5554w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5555x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5556y;

    public el(Context context) {
        super(context);
        InputStream inputStream;
        this.f5539h = new Paint();
        this.f5540i = false;
        this.f5541j = 0;
        this.f5542k = 0;
        this.f5543l = 0;
        this.f5544m = 10;
        this.f5545n = 0;
        this.f5546o = 0;
        this.f5547p = 10;
        this.f5548q = 8;
        this.f5549r = false;
        this.f5550s = false;
        this.f5552u = true;
        this.f5553v = 0.0f;
        this.f5554w = 0.0f;
        this.f5555x = true;
        this.f5556y = false;
        InputStream inputStream2 = null;
        try {
            this.f5551t = context.getApplicationContext();
            InputStream open = dr.a(context).open("ap.data");
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                this.f5537f = decodeStream;
                this.f5532a = dx.a(decodeStream, w.f6962a);
                open.close();
                inputStream2 = dr.a(context).open("ap1.data");
                Bitmap decodeStream2 = BitmapFactory.decodeStream(inputStream2);
                this.f5538g = decodeStream2;
                this.f5533b = dx.a(decodeStream2, w.f6962a);
                inputStream2.close();
                this.f5542k = this.f5533b.getWidth();
                this.f5541j = this.f5533b.getHeight();
                this.f5539h.setAntiAlias(true);
                this.f5539h.setColor(-16777216);
                this.f5539h.setStyle(Paint.Style.STROKE);
                AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = ((Object) context.getFilesDir()) + "/icon_web_day.data";
                AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = ((Object) context.getFilesDir()) + "/icon_web_night.data";
                dv.a().a(new je() { // from class: com.amap.api.col.3l.el.1
                    @Override // com.amap.api.col.p0003l.je
                    public final void runTask() {
                        el.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
                        el.this.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
                        if ("".equals(dn.a(el.this.f5551t, "amap_web_logo", "md5_day", ""))) {
                            if (el.this.f5534c == null || el.this.f5535d == null) {
                                dn.a(el.this.f5551t, "amap_web_logo", "md5_day", (Object) "0b718b5f291b09d2b62be725dfb977b3");
                                dn.a(el.this.f5551t, "amap_web_logo", "md5_night", (Object) "4b1405462a5c910de0e0723ffd96c018");
                                return;
                            }
                            dn.a(el.this.f5551t, "amap_web_logo", "md5_day", (Object) fq.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                            String a10 = fq.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                            if (!"".equals(a10)) {
                                dn.a(el.this.f5551t, "amap_web_logo", "md5_night", (Object) a10);
                            }
                            el.this.d(true);
                        }
                    }
                });
                try {
                    open.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    inputStream2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
                inputStream2 = open;
                try {
                    gy.b(th, "WaterMarkerView", "create");
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }

    private Bitmap e() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        return (!this.f5556y || (bitmap3 = this.f5536e) == null) ? this.f5540i ? (!this.f5550s || (bitmap2 = this.f5535d) == null) ? this.f5533b : bitmap2 : (!this.f5550s || (bitmap = this.f5534c) == null) ? this.f5532a : bitmap : bitmap3;
    }

    private void f() {
        int i10 = this.f5546o;
        if (i10 == 0) {
            h();
        } else if (i10 == 2) {
            g();
        }
        this.f5544m = this.f5547p;
        int height = (getHeight() - this.f5548q) - this.f5541j;
        this.f5545n = height;
        if (this.f5544m < 0) {
            this.f5544m = 0;
        }
        if (height < 0) {
            this.f5545n = 0;
        }
    }

    private void g() {
        if (this.f5555x) {
            this.f5547p = (int) (getWidth() * this.f5553v);
        } else {
            this.f5547p = (int) ((getWidth() * this.f5553v) - this.f5542k);
        }
        this.f5548q = (int) (getHeight() * this.f5554w);
    }

    private void h() {
        int i10 = this.f5543l;
        if (i10 == 1) {
            this.f5547p = (getWidth() - this.f5542k) / 2;
        } else if (i10 == 2) {
            this.f5547p = (getWidth() - this.f5542k) - 10;
        } else {
            this.f5547p = 10;
        }
        this.f5548q = 8;
    }

    public final float d(int i10) {
        float f10;
        if (!this.f5552u) {
            return 0.0f;
        }
        if (i10 == 0) {
            return this.f5553v;
        }
        if (i10 == 1) {
            f10 = this.f5553v;
        } else {
            if (i10 != 2) {
                return 0.0f;
            }
            f10 = this.f5554w;
        }
        return 1.0f - f10;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (!this.f5552u || getWidth() == 0 || getHeight() == 0 || this.f5533b == null) {
                return;
            }
            if (!this.f5549r) {
                f();
                this.f5549r = true;
            }
            canvas.drawBitmap(e(), this.f5544m, this.f5545n, this.f5539h);
        } catch (Throwable th) {
            gy.b(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            Bitmap bitmap = this.f5532a;
            if (bitmap != null) {
                dx.a(bitmap);
                this.f5532a = null;
            }
            Bitmap bitmap2 = this.f5533b;
            if (bitmap2 != null) {
                dx.a(bitmap2);
                this.f5533b = null;
            }
            this.f5532a = null;
            this.f5533b = null;
            Bitmap bitmap3 = this.f5537f;
            if (bitmap3 != null) {
                dx.a(bitmap3);
                this.f5537f = null;
            }
            Bitmap bitmap4 = this.f5538g;
            if (bitmap4 != null) {
                dx.a(bitmap4);
                this.f5538g = null;
            }
            Bitmap bitmap5 = this.f5534c;
            if (bitmap5 != null) {
                dx.a(bitmap5);
            }
            this.f5534c = null;
            Bitmap bitmap6 = this.f5535d;
            if (bitmap6 != null) {
                dx.a(bitmap6);
            }
            this.f5535d = null;
            Bitmap bitmap7 = this.f5536e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.f5539h = null;
        } catch (Throwable th) {
            gy.b(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final Point b() {
        return new Point(this.f5544m, this.f5545n - 2);
    }

    public final void c(int i10) {
        this.f5546o = 1;
        this.f5547p = i10;
        c();
    }

    public final void b(int i10) {
        this.f5546o = 1;
        this.f5548q = i10;
        c();
    }

    public final void c() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        f();
        postInvalidate();
    }

    public final void d(boolean z10) {
        if (this.f5552u && this.f5550s != z10) {
            this.f5550s = z10;
            if (z10) {
                if (this.f5540i) {
                    Bitmap bitmap = this.f5535d;
                    if (bitmap != null) {
                        this.f5542k = bitmap.getWidth();
                        this.f5541j = this.f5535d.getHeight();
                        return;
                    }
                    return;
                }
                Bitmap bitmap2 = this.f5534c;
                if (bitmap2 != null) {
                    this.f5542k = bitmap2.getWidth();
                    this.f5541j = this.f5534c.getHeight();
                    return;
                }
                return;
            }
            this.f5542k = this.f5532a.getWidth();
            this.f5541j = this.f5532a.getHeight();
        }
    }

    public final void b(boolean z10) {
        if (this.f5552u) {
            this.f5556y = z10;
            if (z10) {
                Bitmap bitmap = this.f5536e;
                if (bitmap != null) {
                    this.f5542k = bitmap.getWidth();
                    this.f5541j = this.f5536e.getHeight();
                    return;
                }
                return;
            }
            this.f5542k = this.f5532a.getWidth();
            this.f5541j = this.f5532a.getHeight();
        }
    }

    public final void c(boolean z10) {
        this.f5552u = z10;
    }

    public final boolean d() {
        return this.f5540i;
    }

    public final void a(boolean z10) {
        if (this.f5552u) {
            try {
                this.f5540i = z10;
                if (z10) {
                    this.f5539h.setColor(-1);
                } else {
                    this.f5539h.setColor(-16777216);
                }
            } catch (Throwable th) {
                gy.b(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final void a(int i10) {
        this.f5546o = 0;
        this.f5543l = i10;
        c();
    }

    public final void a(int i10, float f10) {
        if (this.f5552u) {
            this.f5546o = 2;
            float max = Math.max(0.0f, Math.min(f10, 1.0f));
            if (i10 == 0) {
                this.f5553v = max;
                this.f5555x = true;
            } else if (i10 == 1) {
                this.f5553v = 1.0f - max;
                this.f5555x = false;
            } else if (i10 == 2) {
                this.f5554w = 1.0f - max;
            }
            c();
        }
    }

    public final void a(String str, int i10) {
        try {
            if (this.f5552u && new File(str).exists()) {
                if (i10 == 0) {
                    Bitmap bitmap = this.f5534c;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    this.f5537f = decodeFile;
                    this.f5534c = dx.a(decodeFile, w.f6962a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    dx.a(bitmap);
                    return;
                }
                if (i10 == 1) {
                    Bitmap bitmap2 = this.f5535d;
                    Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                    this.f5537f = decodeFile2;
                    this.f5535d = dx.a(decodeFile2, w.f6962a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    dx.a(bitmap2);
                }
            }
        } catch (Throwable th) {
            gy.b(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }
}
