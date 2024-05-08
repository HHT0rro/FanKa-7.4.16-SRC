package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.p0003l.ap;
import com.amap.api.col.p0003l.aq;
import com.amap.api.col.p0003l.as;
import com.amap.api.col.p0003l.at;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: GlMapGestureDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public IAMapDelegate f7028a;

    /* renamed from: b, reason: collision with root package name */
    public Context f7029b;

    /* renamed from: c, reason: collision with root package name */
    public GestureDetector f7030c;

    /* renamed from: d, reason: collision with root package name */
    public AMapGestureListener f7031d;

    /* renamed from: e, reason: collision with root package name */
    private as f7032e;

    /* renamed from: f, reason: collision with root package name */
    private aq f7033f;

    /* renamed from: g, reason: collision with root package name */
    private ap f7034g;

    /* renamed from: h, reason: collision with root package name */
    private at f7035h;

    /* renamed from: r, reason: collision with root package name */
    private int f7045r;

    /* renamed from: s, reason: collision with root package name */
    private int f7046s;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7036i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f7037j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f7038k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f7039l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f7040m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f7041n = 0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7042o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7043p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7044q = true;

    /* renamed from: t, reason: collision with root package name */
    private Handler f7047t = new Handler(Looper.getMainLooper());

    public z(IAMapDelegate iAMapDelegate) {
        byte b4 = 0;
        this.f7029b = iAMapDelegate.getContext();
        this.f7028a = iAMapDelegate;
        a aVar = new a(this, b4);
        GestureDetector gestureDetector = new GestureDetector(this.f7029b, aVar, this.f7047t);
        this.f7030c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.f7032e = new as(this.f7029b, new d(this, b4));
        this.f7033f = new aq(this.f7029b, new c(this, b4));
        this.f7034g = new ap(this.f7029b, new b(this, b4));
        this.f7035h = new at(this.f7029b, new e(this, b4));
    }

    public static /* synthetic */ int g(z zVar) {
        int i10 = zVar.f7038k;
        zVar.f7038k = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int h(z zVar) {
        int i10 = zVar.f7039l;
        zVar.f7039l = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int l(z zVar) {
        int i10 = zVar.f7037j;
        zVar.f7037j = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int m(z zVar) {
        int i10 = zVar.f7040m;
        zVar.f7040m = i10 + 1;
        return i10;
    }

    public static /* synthetic */ boolean n(z zVar) {
        zVar.f7044q = true;
        return true;
    }

    /* compiled from: GlMapGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b implements ap.a {

        /* renamed from: b, reason: collision with root package name */
        private EAMapPlatformGestureInfo f7054b;

        private b() {
            this.f7054b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.ap.a
        public final boolean a(ap apVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7054b;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z10 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
            try {
                if (!z.this.f7028a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7054b);
                if (z.this.f7028a.isLockMapCameraDegree(engineIDWithGestureInfo) || z.this.f7039l > 3) {
                    return false;
                }
                float f10 = apVar.d().x;
                float f11 = apVar.d().y;
                if (!z.this.f7036i) {
                    PointF a10 = apVar.a(0);
                    PointF a11 = apVar.a(1);
                    float f12 = a10.y;
                    if ((f12 > 10.0f && a11.y > 10.0f) || (f12 < -10.0f && a11.y < -10.0f)) {
                        z10 = true;
                    }
                    if (z10 && Math.abs(f11) > 10.0f && Math.abs(f10) < 10.0f) {
                        z.this.f7036i = true;
                    }
                }
                if (z.this.f7036i) {
                    z.this.f7036i = true;
                    float f13 = f11 / 6.0f;
                    if (Math.abs(f13) > 1.0f) {
                        z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f13));
                        z.m(z.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.ap.a
        public final boolean b(ap apVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7054b;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
            try {
                if (!z.this.f7028a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7054b);
                if (z.this.f7028a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                IAMapDelegate iAMapDelegate = z.this.f7028a;
                iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.ap.a
        public final void c(ap apVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7054b;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
            try {
                if (z.this.f7028a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7054b);
                    if (z.this.f7028a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (z.this.f7028a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && z.this.f7040m > 0) {
                        z.this.f7028a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    z.this.f7036i = false;
                    IAMapDelegate iAMapDelegate = z.this.f7028a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }

        public /* synthetic */ b(z zVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class c implements aq.a {

        /* renamed from: b, reason: collision with root package name */
        private EAMapPlatformGestureInfo f7056b;

        private c() {
            this.f7056b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.aq.a
        public final boolean a(aq aqVar) {
            if (z.this.f7036i) {
                return true;
            }
            try {
                if (z.this.f7028a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!z.this.f7043p) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7056b;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{aqVar.c().getX(), aqVar.c().getY()};
                        int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7056b);
                        PointF d10 = aqVar.d();
                        float f10 = z.this.f7037j == 0 ? 4.0f : 1.0f;
                        if (Math.abs(d10.x) <= f10 && Math.abs(d10.y) <= f10) {
                            return false;
                        }
                        if (z.this.f7037j == 0) {
                            z.this.f7028a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d10.x, d10.y, aqVar.c().getX(), aqVar.c().getY()));
                        z.l(z.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.aq.a
        public final boolean b(aq aqVar) {
            try {
                if (!z.this.f7028a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7056b;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{aqVar.c().getX(), aqVar.c().getY()};
                z.this.f7028a.addGestureMapMessage(z.this.f7028a.getEngineIDWithGestureInfo(this.f7056b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, aqVar.c().getX(), aqVar.c().getY()));
                return true;
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.aq.a
        public final void c(aq aqVar) {
            try {
                if (z.this.f7028a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7056b;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{aqVar.c().getX(), aqVar.c().getY()};
                    int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7056b);
                    if (z.this.f7037j > 0) {
                        z.this.f7028a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, aqVar.c().getX(), aqVar.c().getY()));
                }
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }

        public /* synthetic */ c(z zVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class e extends at.b {

        /* renamed from: a, reason: collision with root package name */
        public EAMapPlatformGestureInfo f7067a;

        private e() {
            this.f7067a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.at.b, com.amap.api.col.3l.at.a
        public final void a(at atVar) {
            try {
                if (z.this.f7028a.getUiSettings().isZoomGesturesEnabled() && Math.abs(atVar.d()) <= 10.0f && Math.abs(atVar.e()) <= 10.0f && atVar.b() < 200) {
                    z.n(z.this);
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7067a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{atVar.c().getX(), atVar.c().getY()};
                    int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7067a);
                    z.this.f7028a.setGestureStatus(engineIDWithGestureInfo, 4);
                    z.this.f7028a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }

        public /* synthetic */ e(z zVar, byte b4) {
            this();
        }
    }

    public final int c() {
        return this.f7046s;
    }

    public final void a(AMapGestureListener aMapGestureListener) {
        this.f7031d = aMapGestureListener;
    }

    public final int b() {
        return this.f7045r;
    }

    public final void a() {
        this.f7037j = 0;
        this.f7039l = 0;
        this.f7038k = 0;
        this.f7040m = 0;
        this.f7041n = 0;
    }

    /* compiled from: GlMapGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public float f7048a;

        /* renamed from: b, reason: collision with root package name */
        public long f7049b;

        /* renamed from: d, reason: collision with root package name */
        private int f7051d;

        /* renamed from: e, reason: collision with root package name */
        private EAMapPlatformGestureInfo f7052e;

        private a() {
            this.f7051d = 0;
            this.f7048a = 0.0f;
            this.f7052e = new EAMapPlatformGestureInfo();
            this.f7049b = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            z.this.f7030c.setIsLongpressEnabled(false);
            this.f7051d = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = z.this.f7031d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.f7051d < motionEvent.getPointerCount()) {
                this.f7051d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f7051d != 1) {
                return false;
            }
            try {
                if (!z.this.f7028a.getUiSettings().isZoomGesturesEnabled()) {
                    z.this.f7030c.setIsLongpressEnabled(true);
                    return false;
                }
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7052e;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 9;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e);
                this.f7048a = motionEvent.getY();
                z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.f7049b = SystemClock.uptimeMillis();
                return true;
            }
            if (action == 2) {
                z.this.f7042o = true;
                float y10 = this.f7048a - motionEvent.getY();
                if (Math.abs(y10) < 20.0f) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f7052e;
                eAMapPlatformGestureInfo2.mGestureState = 2;
                eAMapPlatformGestureInfo2.mGestureType = 9;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                z.this.f7028a.addGestureMapMessage(z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e), ScaleGestureMapMessage.obtain(101, (y10 * 4.0f) / z.this.f7028a.getMapHeight(), 0, 0));
                this.f7048a = motionEvent.getY();
                return true;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f7052e;
            eAMapPlatformGestureInfo3.mGestureState = 3;
            eAMapPlatformGestureInfo3.mGestureType = 9;
            eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo2 = z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e);
            z.this.f7030c.setIsLongpressEnabled(true);
            z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (action != 1) {
                z.this.f7042o = false;
                return true;
            }
            z.this.f7028a.setGestureStatus(engineIDWithGestureInfo2, 3);
            long uptimeMillis = SystemClock.uptimeMillis() - this.f7049b;
            if (z.this.f7042o && uptimeMillis >= 200) {
                z.this.f7042o = false;
                return true;
            }
            return z.this.f7028a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            z.this.f7042o = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            AMapGestureListener aMapGestureListener = z.this.f7031d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f10, f11);
            }
            try {
                if (z.this.f7028a.getUiSettings().isScrollGesturesEnabled() && z.this.f7040m <= 0 && z.this.f7038k <= 0 && z.this.f7039l == 0 && !z.this.f7044q) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7052e;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e);
                    z.this.f7028a.onFling();
                    z.this.f7028a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f10, f11);
                }
                return true;
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (z.this.f7041n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7052e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                z.this.f7028a.onLongPress(z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e), motionEvent);
                AMapGestureListener aMapGestureListener = z.this.f7031d;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            AMapGestureListener aMapGestureListener = z.this.f7031d;
            if (aMapGestureListener == null) {
                return false;
            }
            aMapGestureListener.onScroll(f10, f11);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7052e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                z.this.f7028a.getGLMapEngine().clearAnimations(z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (z.this.f7041n != 1) {
                return false;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7052e;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7052e);
            AMapGestureListener aMapGestureListener = z.this.f7031d;
            if (aMapGestureListener != null) {
                try {
                    aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return z.this.f7028a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public /* synthetic */ a(z zVar, byte b4) {
            this();
        }
    }

    public final void a(int i10, int i11) {
        this.f7045r = i10;
        this.f7046s = i11;
        as asVar = this.f7032e;
        if (asVar != null) {
            asVar.a(i10, i11);
        }
        aq aqVar = this.f7033f;
        if (aqVar != null) {
            aqVar.a(i10, i11);
        }
        ap apVar = this.f7034g;
        if (apVar != null) {
            apVar.a(i10, i11);
        }
        at atVar = this.f7035h;
        if (atVar != null) {
            atVar.a(i10, i11);
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class d extends as.a {

        /* renamed from: b, reason: collision with root package name */
        private boolean f7058b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7059c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7060d;

        /* renamed from: e, reason: collision with root package name */
        private Point f7061e;

        /* renamed from: f, reason: collision with root package name */
        private float[] f7062f;

        /* renamed from: g, reason: collision with root package name */
        private float f7063g;

        /* renamed from: h, reason: collision with root package name */
        private float[] f7064h;

        /* renamed from: i, reason: collision with root package name */
        private float f7065i;

        /* renamed from: j, reason: collision with root package name */
        private EAMapPlatformGestureInfo f7066j;

        private d() {
            this.f7058b = false;
            this.f7059c = false;
            this.f7060d = false;
            this.f7061e = new Point();
            this.f7062f = new float[10];
            this.f7063g = 0.0f;
            this.f7064h = new float[10];
            this.f7065i = 0.0f;
            this.f7066j = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00f3 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:28:0x00cb, B:30:0x00f3, B:70:0x00fc, B:74:0x00b6), top: B:73:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0124 A[Catch: all -> 0x019c, TryCatch #2 {all -> 0x019c, blocks: (B:32:0x0116, B:34:0x0124, B:36:0x012e, B:38:0x0132, B:40:0x013c, B:42:0x0144, B:43:0x0146, B:45:0x014a, B:53:0x016b, B:63:0x015c), top: B:31:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x016b A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #2 {all -> 0x019c, blocks: (B:32:0x0116, B:34:0x0124, B:36:0x012e, B:38:0x0132, B:40:0x013c, B:42:0x0144, B:43:0x0146, B:45:0x014a, B:53:0x016b, B:63:0x015c), top: B:31:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00fc A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:28:0x00cb, B:30:0x00f3, B:70:0x00fc, B:74:0x00b6), top: B:73:0x00b6 }] */
        @Override // com.amap.api.col.3l.as.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a(com.amap.api.col.p0003l.as r18) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.z.d.a(com.amap.api.col.3l.as):boolean");
        }

        @Override // com.amap.api.col.3l.as.a
        public final boolean b(as asVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7066j;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{asVar.a().getX(), asVar.a().getY()};
            int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7066j);
            int b4 = (int) asVar.b();
            int c4 = (int) asVar.c();
            this.f7060d = false;
            Point point = this.f7061e;
            point.x = b4;
            point.y = c4;
            this.f7058b = false;
            this.f7059c = false;
            z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, b4, c4));
            try {
                if (z.this.f7028a.getUiSettings().isRotateGesturesEnabled() && !z.this.f7028a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = z.this.f7028a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), b4, c4));
                }
            } catch (Throwable th) {
                gy.b(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.3l.as.a
        public final void c(as asVar) {
            float f10;
            float f11;
            float f12;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7066j;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{asVar.a().getX(), asVar.a().getY()};
            int engineIDWithGestureInfo = z.this.f7028a.getEngineIDWithGestureInfo(this.f7066j);
            this.f7060d = false;
            z.this.f7028a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (z.this.f7038k > 0) {
                int i10 = z.this.f7038k > 10 ? 10 : z.this.f7038k;
                float f13 = 0.0f;
                for (int i11 = 0; i11 < 10; i11++) {
                    float[] fArr = this.f7062f;
                    f13 += fArr[i11];
                    fArr[i11] = 0.0f;
                }
                float f14 = f13 / i10;
                if (0.004f <= f14) {
                    float f15 = f14 * 300.0f;
                    if (f15 >= 1.5f) {
                        f15 = 1.5f;
                    }
                    if (this.f7063g < 0.0f) {
                        f15 = -f15;
                    }
                    f12 = z.this.f7028a.getPreciseLevel(engineIDWithGestureInfo) + f15;
                } else {
                    f12 = -9999.0f;
                }
                this.f7063g = 0.0f;
                f10 = f12;
            } else {
                f10 = -9999.0f;
            }
            if (z.this.f7028a.isLockMapAngle(engineIDWithGestureInfo)) {
                f11 = -9999.0f;
            } else {
                try {
                    if (z.this.f7028a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = z.this.f7028a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    gy.b(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (z.this.f7039l > 0) {
                    z.this.f7028a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i12 = z.this.f7039l > 10 ? 10 : z.this.f7039l;
                    float f16 = 0.0f;
                    for (int i13 = 0; i13 < 10; i13++) {
                        float[] fArr2 = this.f7064h;
                        f16 += fArr2[i13];
                        fArr2[i13] = 0.0f;
                    }
                    float f17 = f16 / i12;
                    if (0.1f <= f17) {
                        float f18 = f17 * 200.0f;
                        int mapAngle = ((int) z.this.f7028a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f18 >= 60.0f) {
                            f18 = 60.0f;
                        }
                        if (this.f7065i < 0.0f) {
                            f18 = -f18;
                        }
                        f11 = ((int) (mapAngle + f18)) % 360;
                        this.f7063g = 0.0f;
                    }
                }
                f11 = -9999.0f;
                this.f7063g = 0.0f;
            }
            if ((f10 == -9999.0f && f11 == -9999.0f) ? false : true) {
                z.this.f7028a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f7061e, f10, (int) f11, 500);
            }
        }

        public /* synthetic */ d(z zVar, byte b4) {
            this();
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.f7041n < motionEvent.getPointerCount()) {
            this.f7041n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f7043p = false;
            this.f7044q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f7043p = true;
        }
        if (this.f7042o && this.f7041n >= 2) {
            this.f7042o = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f7028a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.f7028a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f7031d != null) {
                if (motionEvent.getAction() == 0) {
                    this.f7031d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f7031d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f7030c.onTouchEvent(motionEvent);
            this.f7034g.b(motionEvent, iArr[0], iArr[1]);
            if (!this.f7036i || this.f7040m <= 0) {
                this.f7035h.b(motionEvent, iArr[0], iArr[1]);
                if (!this.f7042o) {
                    this.f7032e.a(motionEvent);
                    this.f7033f.b(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
