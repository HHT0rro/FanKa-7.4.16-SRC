package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: ScaleGestureDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4972a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4973b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4974c;

    /* renamed from: d, reason: collision with root package name */
    private MotionEvent f4975d;

    /* renamed from: e, reason: collision with root package name */
    private MotionEvent f4976e;

    /* renamed from: f, reason: collision with root package name */
    private float f4977f;

    /* renamed from: g, reason: collision with root package name */
    private float f4978g;

    /* renamed from: h, reason: collision with root package name */
    private float f4979h;

    /* renamed from: i, reason: collision with root package name */
    private float f4980i;

    /* renamed from: j, reason: collision with root package name */
    private float f4981j;

    /* renamed from: k, reason: collision with root package name */
    private float f4982k;

    /* renamed from: l, reason: collision with root package name */
    private float f4983l;

    /* renamed from: m, reason: collision with root package name */
    private float f4984m;

    /* renamed from: n, reason: collision with root package name */
    private float f4985n;

    /* renamed from: o, reason: collision with root package name */
    private float f4986o;

    /* renamed from: p, reason: collision with root package name */
    private float f4987p;

    /* renamed from: q, reason: collision with root package name */
    private long f4988q;

    /* renamed from: r, reason: collision with root package name */
    private final float f4989r;

    /* renamed from: s, reason: collision with root package name */
    private float f4990s;

    /* renamed from: t, reason: collision with root package name */
    private float f4991t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4992u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4993v;

    /* renamed from: w, reason: collision with root package name */
    private int f4994w;

    /* renamed from: x, reason: collision with root package name */
    private int f4995x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f4996y;

    /* renamed from: z, reason: collision with root package name */
    private int f4997z = 0;
    private int A = 0;

    /* compiled from: ScaleGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        boolean a(ar arVar);

        boolean b(ar arVar);

        void c(ar arVar);
    }

    public ar(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4972a = context;
        this.f4973b = aVar;
        this.f4989r = viewConfiguration.getScaledEdgeSlop();
    }

    private static float b(MotionEvent motionEvent, int i10) {
        if (i10 < 0) {
            return Float.MIN_VALUE;
        }
        if (i10 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i10) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void j() {
        MotionEvent motionEvent = this.f4975d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f4975d = null;
        }
        MotionEvent motionEvent2 = this.f4976e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f4976e = null;
        }
        this.f4992u = false;
        this.f4974c = false;
        this.f4994w = -1;
        this.f4995x = -1;
        this.f4993v = false;
    }

    private float k() {
        if (this.f4983l == -1.0f) {
            float f10 = this.f4981j;
            float f11 = this.f4982k;
            this.f4983l = (float) Math.sqrt((f10 * f10) + (f11 * f11));
        }
        return this.f4983l;
    }

    private float l() {
        if (this.f4984m == -1.0f) {
            float f10 = this.f4979h;
            float f11 = this.f4980i;
            this.f4984m = (float) Math.sqrt((f10 * f10) + (f11 * f11));
        }
        return this.f4984m;
    }

    public final MotionEvent a() {
        return this.f4976e;
    }

    public final float c() {
        return this.f4978g;
    }

    public final float d() {
        return this.f4981j;
    }

    public final float e() {
        return this.f4982k;
    }

    public final float f() {
        return this.f4979h;
    }

    public final float g() {
        return this.f4980i;
    }

    public final float h() {
        if (this.f4985n == -1.0f) {
            this.f4985n = k() / l();
        }
        return this.f4985n;
    }

    public final long i() {
        return this.f4988q;
    }

    public final void a(int i10, int i11) {
        this.f4997z = i10;
        this.A = i11;
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f4976e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f4976e = MotionEvent.obtain(motionEvent);
        this.f4983l = -1.0f;
        this.f4984m = -1.0f;
        this.f4985n = -1.0f;
        MotionEvent motionEvent3 = this.f4975d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.f4994w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.f4995x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f4994w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f4995x);
        if (findPointerIndex >= 0 && findPointerIndex2 >= 0 && findPointerIndex3 >= 0 && findPointerIndex4 >= 0) {
            float x10 = motionEvent3.getX(findPointerIndex);
            float y10 = motionEvent3.getY(findPointerIndex);
            float x11 = motionEvent3.getX(findPointerIndex2);
            float y11 = motionEvent3.getY(findPointerIndex2);
            float x12 = motionEvent.getX(findPointerIndex3);
            float y12 = motionEvent.getY(findPointerIndex3);
            float x13 = motionEvent.getX(findPointerIndex4) - x12;
            float y13 = motionEvent.getY(findPointerIndex4) - y12;
            this.f4979h = x11 - x10;
            this.f4980i = y11 - y10;
            this.f4981j = x13;
            this.f4982k = y13;
            this.f4977f = x12 + (x13 * 0.5f);
            this.f4978g = y12 + (y13 * 0.5f);
            this.f4988q = motionEvent.getEventTime() - motionEvent3.getEventTime();
            this.f4986o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
            this.f4987p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
            return;
        }
        this.f4993v = true;
        if (this.f4974c) {
            this.f4973b.c(this);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        int a10;
        int a11;
        int i10;
        int a12;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            j();
        }
        boolean z10 = false;
        if (this.f4993v) {
            return false;
        }
        if (this.f4974c) {
            if (action == 1) {
                j();
            } else if (action == 2) {
                b(motionEvent);
                if (this.f4986o / this.f4987p > 0.67f && this.f4973b.a(this)) {
                    this.f4975d.recycle();
                    this.f4975d = MotionEvent.obtain(motionEvent);
                }
            } else if (action == 3) {
                this.f4973b.c(this);
                j();
            } else if (action == 5) {
                this.f4973b.c(this);
                int i11 = this.f4994w;
                int i12 = this.f4995x;
                j();
                this.f4975d = MotionEvent.obtain(motionEvent);
                if (!this.f4996y) {
                    i11 = i12;
                }
                this.f4994w = i11;
                this.f4995x = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f4996y = false;
                int findPointerIndex = motionEvent.findPointerIndex(this.f4994w);
                if (findPointerIndex < 0 || this.f4994w == this.f4995x) {
                    int i13 = this.f4994w;
                    int i14 = this.f4995x;
                    this.f4994w = motionEvent.getPointerId(a(motionEvent, i13 != i14 ? i14 : -1, findPointerIndex));
                }
                b(motionEvent);
                this.f4974c = this.f4973b.b(this);
            } else if (action == 6) {
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (pointerCount > 2) {
                    int i15 = this.f4994w;
                    if (pointerId == i15) {
                        int a13 = a(motionEvent, this.f4995x, actionIndex);
                        if (a13 >= 0) {
                            this.f4973b.c(this);
                            this.f4994w = motionEvent.getPointerId(a13);
                            this.f4996y = true;
                            this.f4975d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                            this.f4974c = this.f4973b.b(this);
                            this.f4975d.recycle();
                            this.f4975d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        }
                        z10 = true;
                        this.f4975d.recycle();
                        this.f4975d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    } else {
                        if (pointerId == this.f4995x) {
                            int a14 = a(motionEvent, i15, actionIndex);
                            if (a14 >= 0) {
                                this.f4973b.c(this);
                                this.f4995x = motionEvent.getPointerId(a14);
                                this.f4996y = false;
                                this.f4975d = MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                                this.f4974c = this.f4973b.b(this);
                            }
                            z10 = true;
                        }
                        this.f4975d.recycle();
                        this.f4975d = MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    }
                } else {
                    z10 = true;
                }
                if (z10) {
                    b(motionEvent);
                    int i16 = this.f4994w;
                    if (pointerId == i16) {
                        i16 = this.f4995x;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(i16);
                    this.f4977f = motionEvent.getX(findPointerIndex2);
                    this.f4978g = motionEvent.getY(findPointerIndex2);
                    this.f4973b.c(this);
                    j();
                    this.f4994w = i16;
                    this.f4996y = true;
                }
            }
        } else if (action == 0) {
            this.f4994w = motionEvent.getPointerId(0);
            this.f4996y = true;
        } else if (action == 1) {
            j();
        } else if (action != 2) {
            if (action != 5) {
                if (action == 6 && this.f4992u) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    if (pointerCount2 > 2) {
                        int i17 = this.f4994w;
                        if (pointerId2 == i17) {
                            int a15 = a(motionEvent, this.f4995x, actionIndex2);
                            if (a15 >= 0) {
                                this.f4994w = motionEvent.getPointerId(a15);
                            }
                        } else if (pointerId2 == this.f4995x && (a12 = a(motionEvent, i17, actionIndex2)) >= 0) {
                            this.f4995x = motionEvent.getPointerId(a12);
                        }
                    } else {
                        int i18 = this.f4994w;
                        if (pointerId2 == i18) {
                            i18 = this.f4995x;
                        }
                        int findPointerIndex3 = motionEvent.findPointerIndex(i18);
                        if (findPointerIndex3 < 0) {
                            this.f4993v = true;
                            if (this.f4974c) {
                                this.f4973b.c(this);
                            }
                            return false;
                        }
                        this.f4994w = motionEvent.getPointerId(findPointerIndex3);
                        this.f4996y = true;
                        this.f4995x = -1;
                        this.f4977f = motionEvent.getX(findPointerIndex3);
                        this.f4978g = motionEvent.getY(findPointerIndex3);
                    }
                }
            } else {
                int i19 = this.f4997z;
                if (i19 != 0 && (i10 = this.A) != 0) {
                    float f10 = this.f4989r;
                    this.f4990s = i19 - f10;
                    this.f4991t = i10 - f10;
                } else {
                    float f11 = this.f4972a.getResources().getDisplayMetrics().widthPixels;
                    float f12 = this.f4989r;
                    this.f4990s = f11 - f12;
                    this.f4991t = r0.heightPixels - f12;
                }
                MotionEvent motionEvent2 = this.f4975d;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f4975d = MotionEvent.obtain(motionEvent);
                this.f4988q = 0L;
                int actionIndex3 = motionEvent.getActionIndex();
                int findPointerIndex4 = motionEvent.findPointerIndex(this.f4994w);
                int pointerId3 = motionEvent.getPointerId(actionIndex3);
                this.f4995x = pointerId3;
                if (findPointerIndex4 < 0 || findPointerIndex4 == actionIndex3) {
                    findPointerIndex4 = a(motionEvent, findPointerIndex4 != actionIndex3 ? pointerId3 : -1, findPointerIndex4);
                    this.f4994w = motionEvent.getPointerId(findPointerIndex4);
                }
                this.f4996y = false;
                b(motionEvent);
                float f13 = this.f4989r;
                float f14 = this.f4990s;
                float f15 = this.f4991t;
                float a16 = a(motionEvent, findPointerIndex4);
                float b4 = b(motionEvent, findPointerIndex4);
                float a17 = a(motionEvent, actionIndex3);
                float b10 = b(motionEvent, actionIndex3);
                boolean z11 = a16 < f13 || b4 < f13 || a16 > f14 || b4 > f15;
                boolean z12 = a17 < f13 || b10 < f13 || a17 > f14 || b10 > f15;
                if (z11 && z12) {
                    this.f4977f = -1.0f;
                    this.f4978g = -1.0f;
                    this.f4992u = true;
                } else if (z11) {
                    this.f4977f = motionEvent.getX(actionIndex3);
                    this.f4978g = motionEvent.getY(actionIndex3);
                    this.f4992u = true;
                } else if (z12) {
                    this.f4977f = motionEvent.getX(findPointerIndex4);
                    this.f4978g = motionEvent.getY(findPointerIndex4);
                    this.f4992u = true;
                } else {
                    this.f4992u = false;
                    this.f4974c = this.f4973b.b(this);
                }
            }
        } else if (this.f4992u) {
            float f16 = this.f4989r;
            float f17 = this.f4990s;
            float f18 = this.f4991t;
            int findPointerIndex5 = motionEvent.findPointerIndex(this.f4994w);
            int findPointerIndex6 = motionEvent.findPointerIndex(this.f4995x);
            float a18 = a(motionEvent, findPointerIndex5);
            float b11 = b(motionEvent, findPointerIndex5);
            float a19 = a(motionEvent, findPointerIndex6);
            float b12 = b(motionEvent, findPointerIndex6);
            boolean z13 = a18 < f16 || b11 < f16 || a18 > f17 || b11 > f18;
            boolean z14 = a19 < f16 || b12 < f16 || a19 > f17 || b12 > f18;
            if (z13 && (a11 = a(motionEvent, this.f4995x, findPointerIndex5)) >= 0) {
                this.f4994w = motionEvent.getPointerId(a11);
                a(motionEvent, a11);
                b(motionEvent, a11);
                findPointerIndex5 = a11;
                z13 = false;
            }
            if (z14 && (a10 = a(motionEvent, this.f4994w, findPointerIndex6)) >= 0) {
                this.f4995x = motionEvent.getPointerId(a10);
                a(motionEvent, a10);
                b(motionEvent, a10);
                findPointerIndex6 = a10;
                z14 = false;
            }
            if (z13 && z14) {
                this.f4977f = -1.0f;
                this.f4978g = -1.0f;
            } else if (z13) {
                this.f4977f = motionEvent.getX(findPointerIndex6);
                this.f4978g = motionEvent.getY(findPointerIndex6);
            } else if (z14) {
                this.f4977f = motionEvent.getX(findPointerIndex5);
                this.f4978g = motionEvent.getY(findPointerIndex5);
            } else {
                this.f4992u = false;
                this.f4974c = this.f4973b.b(this);
            }
        }
        return true;
    }

    public final float b() {
        return this.f4977f;
    }

    private int a(MotionEvent motionEvent, int i10, int i11) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        for (int i12 = 0; i12 < pointerCount; i12++) {
            if (i12 != i11 && i12 != findPointerIndex) {
                float f10 = this.f4989r;
                float f11 = this.f4990s;
                float f12 = this.f4991t;
                float a10 = a(motionEvent, i12);
                float b4 = b(motionEvent, i12);
                if (a10 >= f10 && b4 >= f10 && a10 <= f11 && b4 <= f12) {
                    return i12;
                }
            }
        }
        return -1;
    }

    private static float a(MotionEvent motionEvent, int i10) {
        if (i10 < 0) {
            return Float.MIN_VALUE;
        }
        if (i10 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i10) + (motionEvent.getRawX() - motionEvent.getX());
    }
}
