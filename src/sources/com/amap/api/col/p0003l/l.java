package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.col.p0003l.cu;
import com.amap.api.col.p0003l.ef;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.k;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: AMapDelegateImp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class l implements cu.a, k.a, IAMapDelegate, IAMapListener {
    private boolean A;
    private final IGLSurfaceView B;
    private ei C;
    private final IGlOverlayLayer D;
    private boolean E;
    private int F;
    private AtomicBoolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private cl K;
    private LocationSource L;
    private boolean M;
    private boolean N;
    private Marker O;
    private GLTFOverlay P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;
    private boolean W;
    private Rect X;
    private int Y;
    private MyTrafficStyle Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6730a;
    private Lock aA;
    private int aB;
    private int aC;
    private int aD;
    private b aE;
    private cq aF;
    private AMap.OnMultiPointClickListener aG;
    private k aH;
    private long aI;
    private a aJ;
    private a aK;
    private a aL;
    private a aM;
    private a aN;
    private a aO;
    private a aP;
    private a aQ;
    private a aR;
    private a aS;
    private a aT;
    private a aU;
    private a aV;
    private Runnable aW;
    private a aX;
    private com.autonavi.extra.b aY;
    private String aZ;

    /* renamed from: aa, reason: collision with root package name */
    private Thread f6731aa;

    /* renamed from: ab, reason: collision with root package name */
    private Thread f6732ab;

    /* renamed from: ac, reason: collision with root package name */
    private v f6733ac;

    /* renamed from: ad, reason: collision with root package name */
    private boolean f6734ad;

    /* renamed from: ae, reason: collision with root package name */
    private boolean f6735ae;
    private int af;
    private CustomRenderer ag;
    private int ah;
    private int ai;
    private List<ac> aj;
    private cs ak;
    private cu al;
    private long am;
    private GLMapRender an;
    private z ao;
    private boolean ap;
    private float aq;

    /* renamed from: ar, reason: collision with root package name */
    private float f6736ar;
    private float as;
    private boolean at;
    private boolean au;
    private boolean av;
    private volatile boolean aw;
    private volatile boolean ax;
    private boolean ay;
    private boolean az;

    /* renamed from: b, reason: collision with root package name */
    public MapConfig f6737b;

    /* renamed from: ba, reason: collision with root package name */
    private String f6738ba;

    /* renamed from: bb, reason: collision with root package name */
    private boolean f6739bb;

    /* renamed from: bc, reason: collision with root package name */
    private boolean f6740bc;

    /* renamed from: bd, reason: collision with root package name */
    private int f6741bd;

    /* renamed from: be, reason: collision with root package name */
    private EAMapPlatformGestureInfo f6742be;
    private long bf;
    private au bg;
    private IPoint[] bh;

    /* renamed from: c, reason: collision with root package name */
    public au f6743c;

    /* renamed from: d, reason: collision with root package name */
    public Cdo f6744d;

    /* renamed from: e, reason: collision with root package name */
    public Context f6745e;

    /* renamed from: f, reason: collision with root package name */
    public GLMapEngine f6746f;

    /* renamed from: g, reason: collision with root package name */
    public int f6747g;

    /* renamed from: h, reason: collision with root package name */
    public int f6748h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6749i;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f6750j;

    /* renamed from: k, reason: collision with root package name */
    public Point f6751k;

    /* renamed from: l, reason: collision with root package name */
    public String f6752l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f6753m;

    /* renamed from: n, reason: collision with root package name */
    public float[] f6754n;

    /* renamed from: o, reason: collision with root package name */
    public float[] f6755o;

    /* renamed from: p, reason: collision with root package name */
    public float[] f6756p;

    /* renamed from: q, reason: collision with root package name */
    public String f6757q;

    /* renamed from: r, reason: collision with root package name */
    public String f6758r;

    /* renamed from: s, reason: collision with root package name */
    public int f6759s;

    /* renamed from: t, reason: collision with root package name */
    private p f6760t;

    /* renamed from: u, reason: collision with root package name */
    private q f6761u;

    /* renamed from: v, reason: collision with root package name */
    private AMapGestureListener f6762v;

    /* renamed from: w, reason: collision with root package name */
    private av f6763w;

    /* renamed from: x, reason: collision with root package name */
    private UiSettings f6764x;

    /* renamed from: y, reason: collision with root package name */
    private IProjectionDelegate f6765y;

    /* renamed from: z, reason: collision with root package name */
    private final ag f6766z;

    /* compiled from: AMapDelegateImp.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b {
        public b() {
        }

        public final void a(au auVar) {
            List a10;
            List a11;
            au auVar2;
            au auVar3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = l.this.f6737b;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            final ef e2 = l.this.C.e();
            if (auVar == null) {
                try {
                    List a12 = l.this.f6761u.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a12 != null && a12.size() > 0) {
                        synchronized (a12) {
                            for (int i10 = 0; i10 < a12.size(); i10++) {
                                ((AMap.OnIndoorBuildingActiveListener) a12.get(i10)).OnIndoorBuilding(auVar);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                au auVar4 = l.this.f6743c;
                if (auVar4 != null) {
                    auVar4.f5011g = null;
                }
                if (e2.b()) {
                    l.this.f6750j.post(new Runnable() { // from class: com.amap.api.col.3l.l.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            e2.a(false);
                        }
                    });
                }
                MapConfig mapConfig2 = l.this.f6737b;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? l.this.f6737b.getMaxZoomLevel() : 20.0f;
                try {
                    if (!l.this.f6766z.isZoomControlsEnabled() || (a10 = l.this.f6761u.a(AMapWidgetListener.class.hashCode())) == null || a10.size() <= 0) {
                        return;
                    }
                    synchronized (a10) {
                        for (int i11 = 0; i11 < a10.size(); i11++) {
                            ((AMapWidgetListener) a10.get(i11)).invalidateZoomController(l.this.f6737b.getSZ());
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (auVar != null && (iArr = auVar.floor_indexs) != null && (strArr = auVar.floor_names) != null && iArr.length == strArr.length) {
                int i12 = 0;
                while (true) {
                    int[] iArr2 = auVar.floor_indexs;
                    if (i12 >= iArr2.length) {
                        break;
                    }
                    if (auVar.activeFloorIndex == iArr2[i12]) {
                        auVar.activeFloorName = auVar.floor_names[i12];
                        break;
                    }
                    i12++;
                }
            }
            if (auVar == null || (auVar3 = l.this.f6743c) == null || auVar3.activeFloorIndex == auVar.activeFloorIndex || !e2.b()) {
                if (auVar != null && ((auVar2 = l.this.f6743c) == null || !auVar2.poiid.equals(auVar.poiid) || l.this.f6743c.f5011g == null)) {
                    l lVar = l.this;
                    lVar.f6743c = auVar;
                    if (lVar.f6737b != null) {
                        if (auVar.f5011g == null) {
                            auVar.f5011g = new Point();
                        }
                        DPoint mapGeoCenter = l.this.f6737b.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = l.this.f6743c.f5011g;
                            point.x = (int) mapGeoCenter.f9303x;
                            point.y = (int) mapGeoCenter.f9304y;
                        }
                    }
                }
                try {
                    List a13 = l.this.f6761u.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a13 != null && a13.size() > 0) {
                        synchronized (a13) {
                            for (int i13 = 0; i13 < a13.size(); i13++) {
                                ((AMap.OnIndoorBuildingActiveListener) a13.get(i13)).OnIndoorBuilding(auVar);
                            }
                        }
                    }
                    MapConfig mapConfig3 = l.this.f6737b;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? l.this.f6737b.getMaxZoomLevel() : 20.0f;
                    if (l.this.f6766z.isZoomControlsEnabled() && (a11 = l.this.f6761u.a(AMapWidgetListener.class.hashCode())) != null && a11.size() > 0) {
                        synchronized (a11) {
                            for (int i14 = 0; i14 < a11.size(); i14++) {
                                ((AMapWidgetListener) a11.get(i14)).invalidateZoomController(l.this.f6737b.getSZ());
                            }
                        }
                    }
                    if (l.this.f6766z.isIndoorSwitchEnabled()) {
                        if (!e2.b()) {
                            l.this.f6766z.setIndoorSwitchEnabled(true);
                        }
                        l.this.f6750j.post(new Runnable() { // from class: com.amap.api.col.3l.l.b.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    e2.a(l.this.f6743c.floor_names);
                                    e2.a(l.this.f6743c.activeFloorName);
                                    if (e2.b()) {
                                        return;
                                    }
                                    e2.a(true);
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                }
                            }
                        });
                    } else {
                        if (l.this.f6766z.isIndoorSwitchEnabled() || !e2.b()) {
                            return;
                        }
                        l.this.f6766z.setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class c implements ef.a {
        private c() {
        }

        @Override // com.amap.api.col.3l.ef.a
        public final void a(int i10) {
            l lVar = l.this;
            au auVar = lVar.f6743c;
            if (auVar != null) {
                auVar.activeFloorIndex = auVar.floor_indexs[i10];
                auVar.activeFloorName = auVar.floor_names[i10];
                try {
                    lVar.setIndoorBuildingInfo(auVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public /* synthetic */ c(l lVar, byte b4) {
            this();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private Context f6862b;

        /* renamed from: c, reason: collision with root package name */
        private AMap.OnCacheRemoveListener f6863c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f6862b = context;
            this.f6863c = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
        
            if (com.amap.api.col.p0003l.dx.e(r2) != false) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #2 {all -> 0x0062, blocks: (B:3:0x0002, B:5:0x001b, B:11:0x003e, B:13:0x0046), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0036 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #1 {all -> 0x0030, blocks: (B:61:0x0023, B:9:0x0036), top: B:60:0x0023 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r6.f6862b     // Catch: java.lang.Throwable -> L62
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L62
                java.lang.String r3 = com.amap.api.col.p0003l.dx.c(r2)     // Catch: java.lang.Throwable -> L62
                java.lang.String r4 = com.amap.api.col.p0003l.dx.a(r2)     // Catch: java.lang.Throwable -> L62
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L62
                r5.<init>(r3)     // Catch: java.lang.Throwable -> L62
                boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L62
                if (r3 == 0) goto L20
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L62
                goto L21
            L20:
                r3 = 1
            L21:
                if (r3 == 0) goto L33
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L30
                r5.<init>(r4)     // Catch: java.lang.Throwable -> L30
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L30
                if (r3 == 0) goto L33
                r3 = 1
                goto L34
            L30:
                r2 = move-exception
                r1 = r3
                goto L63
            L33:
                r3 = 0
            L34:
                if (r3 == 0) goto L3d
                boolean r2 = com.amap.api.col.p0003l.dx.e(r2)     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L3d
                goto L3e
            L3d:
                r1 = 0
            L3e:
                com.amap.api.col.3l.l r2 = com.amap.api.col.p0003l.l.this     // Catch: java.lang.Throwable -> L62
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.l.g(r2)     // Catch: java.lang.Throwable -> L62
                if (r2 == 0) goto L4f
                com.amap.api.col.3l.l r2 = com.amap.api.col.p0003l.l.this     // Catch: java.lang.Throwable -> L62
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.l.g(r2)     // Catch: java.lang.Throwable -> L62
                r2.clearTileCache()     // Catch: java.lang.Throwable -> L62
            L4f:
                com.amap.api.col.3l.l r0 = com.amap.api.col.p0003l.l.this     // Catch: java.lang.Throwable -> L5d
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.f6746f     // Catch: java.lang.Throwable -> L5d
                if (r0 == 0) goto L5c
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f6863c     // Catch: java.lang.Throwable -> L5d
                if (r0 == 0) goto L5c
                r0.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L5d
            L5c:
                return
            L5d:
                r0 = move-exception
                r0.printStackTrace()
                return
            L62:
                r2 = move-exception
            L63:
                com.amap.api.col.p0003l.dx.a(r2)     // Catch: java.lang.Throwable -> L80
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.col.p0003l.gy.b(r2, r3, r4)     // Catch: java.lang.Throwable -> L80
                com.amap.api.col.3l.l r1 = com.amap.api.col.p0003l.l.this     // Catch: java.lang.Throwable -> L7b
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.f6746f     // Catch: java.lang.Throwable -> L7b
                if (r1 == 0) goto L7a
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f6863c     // Catch: java.lang.Throwable -> L7b
                if (r1 == 0) goto L7a
                r1.onRemoveCacheFinish(r0)     // Catch: java.lang.Throwable -> L7b
            L7a:
                return
            L7b:
                r0 = move-exception
                r0.printStackTrace()
                return
            L80:
                r0 = move-exception
                com.amap.api.col.3l.l r2 = com.amap.api.col.p0003l.l.this     // Catch: java.lang.Throwable -> L8f
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.f6746f     // Catch: java.lang.Throwable -> L8f
                if (r2 == 0) goto L93
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f6863c     // Catch: java.lang.Throwable -> L8f
                if (r2 == 0) goto L93
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L8f
                goto L93
            L8f:
                r1 = move-exception
                r1.printStackTrace()
            L93:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.l.d.run():void");
        }
    }

    public l(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    public static /* synthetic */ boolean f(l lVar) {
        lVar.av = false;
        return false;
    }

    public static /* synthetic */ boolean i(l lVar) {
        lVar.T = false;
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void accelerateNetworkInChinese(boolean z10) {
        com.autonavi.extra.b bVar = this.aY;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.D.createId("AMAP3DMODELTILE");
            AMap3DModelTileOverlay aMap3DModelTileOverlay = new AMap3DModelTileOverlay(this.D, aMap3DModelTileOverlayOptions, createId);
            this.D.addOverlayObject(createId, aMap3DModelTileOverlay, aMap3DModelTileOverlayOptions);
            return aMap3DModelTileOverlay;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), (Integer) aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions m1959clone = arcOptions.m1959clone();
            String createId = this.D.createId("ARC");
            Arc arc = new Arc(this.D, m1959clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(createId, arc, m1959clone) : arc;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final BuildingOverlay addBuildingOverlay() {
        try {
            du.h(this.f6745e);
            String createId = this.D.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.D, createId);
            Field declaredField = BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            dx.a(e2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions m1961clone = circleOptions.m1961clone();
            String createId = this.D.createId("CIRCLE");
            Circle circle = new Circle(this.D, m1961clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(createId, circle, m1961clone) : circle;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ep addContourLineOverlay(eo eoVar) {
        try {
            String createId = this.D.createId("CONTOURLINE");
            ep epVar = new ep(this.D, eoVar, createId);
            this.D.addOverlayObject(createId, epVar, eoVar);
            return epVar;
        } catch (Exception e2) {
            dx.a(e2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        final CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.F, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.36
            @Override // java.lang.Runnable
            public final void run() {
                GLOverlayBundle overlayBundle;
                l lVar = l.this;
                GLMapEngine gLMapEngine = lVar.f6746f;
                if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(lVar.F)) == null) {
                    return;
                }
                overlayBundle.addOverlay(crossVectorOverlay);
            }
        });
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.D.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.D, gL3DModelOptions, createId);
        this.D.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) throws RemoteException {
        try {
            if (x.a().b() && !x.a().a("feature_gltf")) {
                dx.a(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
                return null;
            }
            resetRenderTime();
            GLTFOverlayOptions m1962clone = gLTFOverlayOptions.m1962clone();
            String createId = this.D.createId("GLTFOVERLAY");
            GLTFOverlay gLTFOverlay = new GLTFOverlay(this.D, m1962clone, createId);
            this.D.addOverlayObject(createId, gLTFOverlay, m1962clone);
            return gLTFOverlay;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addGestureMapMessage(int i10, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.aw || this.f6746f == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.I;
            abstractGestureMapMessage.anchorX = this.f6737b.getAnchorX();
            abstractGestureMapMessage.anchorY = this.f6737b.getAnchorY();
            this.f6746f.addGestureMessage(i10, abstractGestureMapMessage, this.f6766z.isGestureScaleByMapCenter(), this.f6737b.getAnchorX(), this.f6737b.getAnchorY());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions m1963clone = groundOverlayOptions.m1963clone();
            String createId = this.D.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.D, m1963clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, m1963clone) : groundOverlay;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapGridLayerOptions == null) {
                return null;
            }
            String createId = this.D.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.D.addOverlayObject(createId, new HeatMapGridLayer(this.D, heatMapGridLayerOptions, createId), heatMapGridLayerOptions);
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String createId = this.D.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.D.addOverlayObject(createId, new HeatMapLayer(this.D, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        try {
            if (x.a().b() && !x.a().a("feature_mvt")) {
                dx.a(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
                return null;
            }
            String createId = this.D.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.D, mVTTileOverlayOptions, createId);
            this.D.addOverlayObject(createId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions m1965clone = markerOptions.m1965clone();
            String createId = this.D.createId("MARKER");
            Marker marker = new Marker(this.D, m1965clone, createId);
            this.D.addOverlayObject(createId, marker, m1965clone);
            return marker;
        } catch (Throwable th) {
            dx.a(th);
            dz.a(dy.f5398d, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z10) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            final LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                MarkerOptions markerOptions = arrayList.get(i10);
                if (arrayList.get(i10) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z10 && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new Runnable() { // from class: com.amap.api.col.3l.l.19
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.moveCamera(al.a(builder.build(), 50));
                        } catch (Throwable unused) {
                        }
                    }
                }, 50L);
            }
            return arrayList2;
        } catch (Throwable th) {
            dx.a(th);
            dz.a(dy.f5398d, "addMarkers failed " + th.getMessage(), arrayList);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions m1966clone = multiPointOverlayOptions.m1966clone();
            String createId = this.D.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.D, m1966clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, m1966clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions m1967clone = navigateArrowOptions.m1967clone();
            String createId = this.D.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.D, m1967clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, m1967clone) : navigateArrow;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), (Integer) onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), (Integer) onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), (Integer) onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), (Integer) onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), (Integer) onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), (Integer) onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), (Integer) onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), (Integer) onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), (Integer) onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), (Integer) onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), (Integer) onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), (Integer) onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addOverlayTexture(int i10, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.f6746f;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i10)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.f6746f.addOverlayTexture(i10, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            du.c(this.f6745e);
            String createId = this.D.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.D.addOverlayObject(createId, new ParticleOverlay(this.D, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th) {
            dx.a(th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions m1968clone = polygonOptions.m1968clone();
            String createId = this.D.createId("POLYGON");
            Polygon polygon = new Polygon(this.D, m1968clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, m1968clone) : polygon;
        } catch (Throwable th) {
            dx.a(th);
            dz.a(dy.f5398d, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String createId = this.D.createId("POLYLINE");
            return (Polyline) this.D.addOverlayObject(createId, new Polyline(this.D, polylineOptions, createId), polylineOptions);
        } catch (Throwable th) {
            dx.a(th);
            dz.a(dy.f5398d, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.D.createId("TEXT");
            TextOptions m1969clone = textOptions.m1969clone();
            MarkerOptions a10 = co.a(m1969clone);
            Marker marker = new Marker(this.D, a10, createId);
            marker.setObject(m1969clone.getObject());
            this.D.addOverlayObject(createId, marker, a10);
            return new Text(marker, m1969clone);
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                du.a(this.f6745e);
            }
            String createId = this.D.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.D, tileOverlayOptions, createId);
            this.D.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i10, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f6746f;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i10) || this.f6746f.isInMapAnimation(i10)))) {
            int i11 = this.ai;
            if (i11 != -1) {
                this.an.setRenderFps(i11);
            } else {
                this.an.setRenderFps(15.0f);
            }
            if (this.aq != mapZoomer) {
                this.aq = mapZoomer;
            }
        }
        if (this.az) {
            return;
        }
        this.az = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i10, GLMapState gLMapState) {
        j();
        com.autonavi.extra.b bVar = this.aY;
        if (bVar != null) {
            bVar.e();
        }
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f6741bd = this.D.draw(1, this.af, this.f6749i) ? this.f6741bd : this.f6741bd + 1;
        GLMapEngine gLMapEngine2 = this.f6746f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterRendererOver(int i10, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.D.draw(2, this.af, this.f6749i);
        GLMapEngine gLMapEngine2 = this.f6746f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.ag;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j10, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j10, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i10, GLMapState gLMapState) {
        j();
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f6741bd = this.D.draw(0, this.af, this.f6749i) ? this.f6741bd : this.f6741bd + 1;
        GLMapEngine gLMapEngine2 = this.f6746f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i10, int i11, int i12, int i13, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i10 == i11 && i11 == i12 && i12 == i13 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng != null && latLng2 != null && this.aw && !this.G.get()) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            GLMapState gLMapState = new GLMapState(this.F, this.f6746f.getNativeInstance());
            Pair<Float, IPoint> a10 = dx.a(mapConfig, i10, i11, i12, i13, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            if (a10 == null) {
                return null;
            }
            DPoint obtain = DPoint.obtain();
            Object obj = a10.second;
            GLMapState.geo2LonLat(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y, obtain);
            Pair<Float, LatLng> pair = new Pair<>(a10.first, new LatLng(obtain.f9304y, obtain.f9303x));
            obtain.recycle();
            return pair;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain2.f9304y, obtain2.f9303x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean canShowIndoorSwitch() {
        au auVar;
        if (getZoomLevel() < 17.0f || (auVar = this.f6743c) == null || auVar.f5011g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        Point point = this.f6743c.f5011g;
        a(point.x, point.y, obtain);
        return this.X.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine == null) {
            return true;
        }
        gLMapEngine.canStopMapRender(this.F);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeGLOverlayIndex() {
        this.D.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeLogoIconStyle(String str, boolean z10, int i10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.a(str, Boolean.valueOf(z10), Integer.valueOf(i10));
        }
        ag agVar = this.f6766z;
        if (agVar != null) {
            agVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeMapLogo(int i10, boolean z10) {
        if (this.G.get()) {
            return;
        }
        try {
            List a10 = this.f6761u.a(AMapWidgetListener.class.hashCode());
            if (a10 == null || a10.size() <= 0) {
                return;
            }
            this.C.g(Boolean.valueOf(!z10));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSize(int i10, int i11) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            this.f6747g = i10;
            this.f6748h = i11;
            mapConfig.setMapWidth(i10);
            this.f6737b.setMapHeight(i11);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSurface(int i10, GL10 gl10, int i11, int i12) {
        WindowManager windowManager;
        dz.a(dy.f5397c, "changeSurface " + i11 + " " + i12);
        this.az = false;
        if (!this.aw) {
            createSurface(i10, gl10, null);
        }
        z zVar = this.ao;
        if (zVar != null && this.f6745e != null && ((this.f6747g != zVar.b() || this.f6748h != this.ao.c()) && (windowManager = (WindowManager) this.f6745e.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.ao.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.f6747g = i11;
        this.f6748h = i12;
        this.X = new Rect(0, 0, i11, i12);
        this.F = a(i10, new Rect(0, 0, this.f6747g, this.f6748h), this.f6747g, this.f6748h);
        dz.a(dy.f5397c, "create engine with frame complete");
        if (!this.ax) {
            MapConfig mapConfig = this.f6737b;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.f6736ar);
                this.f6737b.setMapWidth(i11);
                this.f6737b.setMapHeight(i12);
            }
            this.f6746f.setIndoorEnable(this.F, false);
            this.f6746f.setSimple3DEnable(this.F, false);
            this.f6746f.setStyleChangeGradualEnable(this.F, false);
            this.f6746f.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.f6745e, initParam);
            this.f6746f.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.ax = true;
        }
        if (!this.I) {
            this.f6737b.setAnchorX(i11 >> 1);
            this.f6737b.setAnchorY(i12 >> 1);
        } else {
            this.f6737b.setAnchorX(Math.max(1, Math.min(this.aC, i11 - 1)));
            this.f6737b.setAnchorY(Math.max(1, Math.min(this.aD, i12 - 1)));
        }
        this.f6746f.setProjectionCenter(this.F, this.f6737b.getAnchorX(), this.f6737b.getAnchorY());
        this.f6730a = true;
        a aVar = this.aU;
        if (aVar.f6846b) {
            aVar.run();
        }
        a aVar2 = this.aL;
        if (aVar2.f6846b) {
            aVar2.run();
        }
        a aVar3 = this.aM;
        if (aVar3.f6846b) {
            aVar3.run();
        }
        a aVar4 = this.aJ;
        if (aVar4.f6846b) {
            aVar4.run();
        }
        a aVar5 = this.aN;
        if (aVar5.f6846b) {
            aVar5.run();
        }
        a aVar6 = this.aX;
        if (aVar6.f6846b) {
            aVar6.run();
        }
        a aVar7 = this.aO;
        if (aVar7.f6846b) {
            aVar7.run();
        }
        a aVar8 = this.aP;
        if (aVar8.f6846b) {
            aVar8.run();
        }
        a aVar9 = this.aQ;
        if (aVar9.f6846b) {
            aVar9.run();
        }
        a aVar10 = this.aV;
        if (aVar10.f6846b) {
            aVar10.run();
        }
        a aVar11 = this.aK;
        if (aVar11.f6846b) {
            aVar11.run();
        }
        a aVar12 = this.aR;
        if (aVar12.f6846b) {
            aVar12.run();
        }
        a aVar13 = this.aS;
        if (aVar13 != null) {
            aVar13.run();
        }
        a aVar14 = this.aT;
        if (aVar14 != null) {
            aVar14.run();
        }
        CustomRenderer customRenderer = this.ag;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i11, i12);
        }
        com.autonavi.extra.b bVar = this.aY;
        if (bVar != null) {
            bVar.d();
        }
        Handler handler = this.f6750j;
        if (handler != null) {
            handler.post(this.aW);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(IGLMapState iGLMapState) {
        if (this.f6737b == null || this.G.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.f6737b.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds != null) {
                IPoint[] limitIPoints = this.f6737b.getLimitIPoints();
                if (limitIPoints == null) {
                    IPoint obtain = IPoint.obtain();
                    LatLng latLng = limitLatLngBounds.northeast;
                    GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                    IPoint obtain2 = IPoint.obtain();
                    LatLng latLng2 = limitLatLngBounds.southwest;
                    GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                    IPoint[] iPointArr = {obtain, obtain2};
                    this.f6737b.setLimitIPoints(iPointArr);
                    limitIPoints = iPointArr;
                }
                float a10 = dx.a(this.f6737b, ((Point) limitIPoints[0]).x, ((Point) limitIPoints[0]).y, ((Point) limitIPoints[1]).x, ((Point) limitIPoints[1]).y, getMapWidth(), getMapHeight());
                float mapZoomer = iGLMapState.getMapZoomer();
                if (this.f6737b.isSetLimitZoomLevel()) {
                    float maxZoomLevel = this.f6737b.getMaxZoomLevel();
                    float minZoomLevel = this.f6737b.getMinZoomLevel();
                    float max = Math.max(a10, Math.min(mapZoomer, maxZoomLevel));
                    if (a10 <= maxZoomLevel) {
                        maxZoomLevel = max;
                    }
                    a10 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
                } else if (a10 <= 0.0f || mapZoomer >= a10) {
                    a10 = mapZoomer;
                }
                iGLMapState.setMapZoomer(a10);
                IPoint obtain3 = IPoint.obtain();
                iGLMapState.getMapGeoCenter(obtain3);
                int[] a11 = dx.a(((Point) limitIPoints[0]).x, ((Point) limitIPoints[0]).y, ((Point) limitIPoints[1]).x, ((Point) limitIPoints[1]).y, this.f6737b, iGLMapState, ((Point) obtain3).x, ((Point) obtain3).y);
                iGLMapState.setMapGeoCenter(a11[0], a11[1]);
                obtain3.recycle();
                return;
            }
            if (this.f6737b.isSetLimitZoomLevel()) {
                iGLMapState.setMapZoomer(Math.max(this.f6737b.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.f6737b.getMaxZoomLevel())));
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float checkZoomLevel(float f10) throws RemoteException {
        return dx.a(this.f6737b, f10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "clear");
            dx.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void clearTileCache() {
        this.D.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i10) {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.F, i10);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int createOverlayTexture(int i10, Bitmap bitmap) {
        try {
            GLMapEngine gLMapEngine = this.f6746f;
            if (gLMapEngine == null || bitmap == null) {
                return -1;
            }
            return gLMapEngine.createOverlayTexture(i10, bitmap);
        } catch (Throwable th) {
            dx.a(th);
        }
        return -1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:2|3|(16:8|9|10|11|(1:13)|14|15|(1:17)|18|(1:22)|23|(1:25)|26|(1:28)|29|30)|37|9|10|11|(0)|14|15|(0)|18|(2:20|22)|23|(0)|26|(0)|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        com.amap.api.col.p0003l.dx.a(r4);
        com.amap.api.col.p0003l.gy.b(r4, "AMapDElegateImp", "createSurface");
        com.amap.api.col.p0003l.dz.b(com.amap.api.col.p0003l.dy.f5397c, "createSurface failed " + r4.getMessage());
        com.amap.api.col.p0003l.du.b(r3.f6745e, "init failed:" + r4.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007f A[Catch: all -> 0x008e, TryCatch #1 {all -> 0x008e, blocks: (B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:10:0x0043, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d7 A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0017, B:9:0x002e, B:15:0x00c7, B:17:0x00d7, B:18:0x00da, B:20:0x00e0, B:22:0x00e4, B:23:0x00f2, B:25:0x00f6, B:26:0x00f9, B:28:0x00fd, B:29:0x0100, B:36:0x008f, B:37:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6 A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0017, B:9:0x002e, B:15:0x00c7, B:17:0x00d7, B:18:0x00da, B:20:0x00e0, B:22:0x00e4, B:23:0x00f2, B:25:0x00f6, B:26:0x00f9, B:28:0x00fd, B:29:0x0100, B:36:0x008f, B:37:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fd A[Catch: all -> 0x0107, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0017, B:9:0x002e, B:15:0x00c7, B:17:0x00d7, B:18:0x00da, B:20:0x00e0, B:22:0x00e4, B:23:0x00f2, B:25:0x00f6, B:26:0x00f9, B:28:0x00fd, B:29:0x0100, B:36:0x008f, B:37:0x0023, B:11:0x0043, B:13:0x007f, B:14:0x0082), top: B:2:0x0001, inners: #1 }] */
    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void createSurface(int r4, javax.microedition.khronos.opengles.GL10 r5, javax.microedition.khronos.egl.EGLConfig r6) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.l.createSurface(int, javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.G.set(true);
        dz.a(dy.f5397c, "destroy map");
        try {
            LocationSource locationSource = this.L;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.L = null;
            this.aE = null;
            GLMapRender gLMapRender = this.an;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            h();
            Thread thread = this.f6731aa;
            if (thread != null) {
                thread.interrupt();
                this.f6731aa = null;
            }
            Thread thread2 = this.f6732ab;
            if (thread2 != null) {
                thread2.interrupt();
                this.f6732ab = null;
            }
            v vVar = this.f6733ac;
            if (vVar != null) {
                vVar.a();
                this.f6733ac = null;
            }
            cs csVar = this.ak;
            if (csVar != null) {
                csVar.a();
                this.ak = null;
            }
            cu cuVar = this.al;
            if (cuVar != null) {
                cuVar.a((cu.a) null);
                this.al.a();
                this.al = null;
            }
            dl.b();
            GLMapEngine gLMapEngine = this.f6746f;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                this.f6746f.releaseNetworkState();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.35
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l lVar = l.this;
                            lVar.destroySurface(lVar.F);
                            if (l.this.D != null) {
                                l.this.D.destroy();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dx.a(th);
                        }
                    }
                });
                int i10 = 0;
                while (this.f6746f != null) {
                    int i11 = i10 + 1;
                    if (i10 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e2) {
                        dx.a(e2);
                    }
                    i10 = i11;
                }
            }
            IGLSurfaceView iGLSurfaceView = this.B;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    dx.a(e10);
                }
            }
            ei eiVar = this.C;
            if (eiVar != null) {
                eiVar.g();
                this.C = null;
            }
            cl clVar = this.K;
            if (clVar != null) {
                clVar.c();
                this.K = null;
            }
            this.L = null;
            this.f6760t = null;
            q();
            this.Z = null;
            dz.a();
            gy.b();
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", LandingPageUtHelper.XAD_UT_LP_DESTROY);
            dx.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i10) {
        this.aA.lock();
        try {
            if (this.aw) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                r();
                GLMapEngine gLMapEngine = this.f6746f;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.F) != null) {
                        this.f6746f.getOverlayBundle(this.F).removeAll(true);
                    }
                    this.f6746f.destroyAMapEngine();
                    this.f6746f = null;
                    int i11 = this.f6741bd;
                    if (i11 > 0) {
                        du.a(this.f6745e, i11);
                    }
                    dz.a(dy.f5397c, "destroy engine complete");
                }
                com.autonavi.extra.b bVar = this.aY;
                if (bVar != null) {
                    bVar.f();
                }
            }
            this.aw = false;
            this.ax = false;
            this.az = false;
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(GL10 gl10) {
        if (this.G.get() || this.f6746f == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        a(this.F);
        this.f6746f.renderAMap();
        this.f6746f.pushRendererState();
        k kVar = this.aH;
        if (kVar != null) {
            kVar.a();
        }
        i();
        k();
        if (!this.ay) {
            this.ay = true;
        }
        this.f6746f.popRendererState();
        if (Cdo.a()) {
            try {
                if (this.B instanceof o) {
                    if (this.f6744d == null) {
                        this.f6744d = new Cdo();
                    }
                    this.f6744d.e();
                    if (!this.f6744d.f() || this.f6744d.d()) {
                        return;
                    }
                    if (this.f6744d.a(((o) this.B).getBitmap())) {
                        if (Cdo.b()) {
                            removecache();
                        }
                        if (Cdo.c()) {
                            Cdo.g();
                        }
                        dz.b(dy.f5401g, "pure screen: found pure check");
                    }
                }
            } catch (Throwable th) {
                gy.b(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Latlng(int i10, int i11, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i10, i11, 20);
        dPoint.f9303x = pixelsToLatLong.f9303x;
        dPoint.f9304y = pixelsToLatLong.f9304y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Map(int i10, int i11, FPoint fPoint) {
        ((PointF) fPoint).x = (int) (i10 - this.f6737b.getSX());
        ((PointF) fPoint).y = (int) (i11 - this.f6737b.getSY());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.aY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f6765y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.f6764x == null) {
            this.f6764x = new UiSettings(this.f6766z);
        }
        return this.f6764x;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        return getCameraDegree(this.F);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getCameraDegree(int i10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.I);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final CameraPosition getCameraPositionPrj(boolean z10) {
        LatLng g3;
        try {
            if (this.f6737b == null) {
                return null;
            }
            if (this.aw && !this.H && this.f6746f != null) {
                if (z10) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng(this.f6737b.getAnchorX(), this.f6737b.getAnchorY(), obtain);
                    g3 = new LatLng(obtain.f9304y, obtain.f9303x, false);
                    obtain.recycle();
                } else {
                    g3 = g();
                }
                return CameraPosition.builder().target(g3).bearing(this.f6737b.getSR()).tilt(this.f6737b.getSC()).zoom(this.f6737b.getSZ()).build();
            }
            DPoint obtain2 = DPoint.obtain();
            geo2Latlng((int) this.f6737b.getSX(), (int) this.f6737b.getSY(), obtain2);
            LatLng latLng = new LatLng(obtain2.f9304y, obtain2.f9303x);
            obtain2.recycle();
            return CameraPosition.builder().target(latLng).bearing(this.f6737b.getSR()).tilt(this.f6737b.getSC()).zoom(this.f6737b.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Context getContext() {
        return this.f6745e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.aY;
            if (bVar == null) {
                return "";
            }
            Object j10 = bVar.j();
            return j10 instanceof String ? (String) j10 : "";
        } catch (Throwable th) {
            dx.a(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final k getCustomStyleManager() {
        return this.aH;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return this.F;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.getMvpMatrix();
        }
        return this.f6753m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapEngine getGLMapEngine() {
        return this.f6746f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final View getGLMapView() {
        Object obj = this.B;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getGeoCenter(int i10, IPoint iPoint) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.f6737b.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.D;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.F);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final av getInfoWindowDelegate() {
        return this.f6763w;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Map(double d10, double d11, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d10, d11, obtain);
        geo2Map(((Point) obtain).x, ((Point) obtain).y, fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Pixel(double d10, double d11, IPoint iPoint) {
        if (this.G.get() || !this.aw || this.f6746f == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d10, d11, 20);
            FPoint obtain = FPoint.obtain();
            a(latLongToPixels.x, latLongToPixels.y, obtain);
            if (((PointF) obtain).x == -10000.0f && ((PointF) obtain).y == -10000.0f) {
                GLMapState gLMapState = (GLMapState) this.f6746f.getNewMapState(this.F);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                gLMapState.recycle();
            }
            ((Point) iPoint).x = (int) ((PointF) obtain).x;
            ((Point) iPoint).y = (int) ((PointF) obtain).y;
            obtain.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.f6737b.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i10 = 0; i10 < 4; i10++) {
                    GLMapState.geo2LonLat(((Point) clipRect[i10]).x, ((Point) clipRect[i10]).y, dPointArr[i10]);
                }
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getLogoMarginRate(int i10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            return eiVar.a(i10);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getLogoPosition() {
        try {
            return this.f6766z.getLogoPosition();
        } catch (RemoteException e2) {
            gy.b(e2, "AMapDelegateImp", "getLogoPosition");
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.f6750j;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapAngle(int i10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final LatLngBounds getMapBounds(LatLng latLng, float f10, float f11, float f12) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.G.get()) {
            return null;
        }
        float a10 = dx.a(this.f6737b, f10);
        GLMapState gLMapState = new GLMapState(this.F, this.f6746f.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f12);
            gLMapState.setMapAngle(f11);
            gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
            gLMapState.setMapZoomer(a10);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.f9304y, obtain2.f9303x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.f9304y, obtain2.f9303x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final MapConfig getMapConfig() {
        return this.f6737b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        du.d(this.f6745e);
        String a10 = dn.a(this.f6745e, "approval_number", "mc", "");
        return !TextUtils.isEmpty(a10) ? a10 : "GS(2021)5875号 | GS(2020)2189号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.f6748h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f6761u.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), (Integer) onmapprintscreenlistener);
            this.U = 20;
            this.V = true;
            resetRenderTime();
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.F);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!dx.a(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        if (this.G.get()) {
            return new ArrayList();
        }
        return this.D.getMapScreenMarkers();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z10) {
        try {
            this.f6761u.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), (Integer) onMapScreenShotListener);
            this.U = 20;
            this.V = z10;
            resetRenderTime();
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws RemoteException {
        return this.af;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.Y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.f6747g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapZoomScale() {
        return this.f6736ar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getMaskLayerType() {
        return this.ah;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.f6737b;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            dx.a(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.f6737b;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            dx.a(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        if (this.L != null) {
            return this.f6760t.f6895a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        cl clVar = this.K;
        if (clVar != null) {
            return clVar.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getNativeEngineID() {
        return this.F;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.F);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List a10 = this.f6761u.a(AMap.OnCameraChangeListener.class.hashCode());
            if (a10 == null && a10.size() != 0) {
                return (AMap.OnCameraChangeListener) a10.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2Geo(int i10, int i11, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.G.get() || !this.aw || (gLMapEngine = this.f6746f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        mapState.screenToP20Point(i10, i11, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2LatLng(int i10, int i11, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.G.get() || !this.aw || (gLMapEngine = this.f6746f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i10, i11, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) obtain).x, ((Point) obtain).y, 20);
        dPoint.f9303x = pixelsToLatLong.f9303x;
        dPoint.f9304y = pixelsToLatLong.f9304y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getPreciseLevel(int i10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.f6765y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.getProjectionMatrix();
        }
        return this.f6755o;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Rect getRect() {
        return this.X;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.B.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSX() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSY() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getSatelliteImageApprovalNumber() {
        du.e(this.f6745e);
        String a10 = dn.a(this.f6745e, "approval_number", "si", "");
        return !TextUtils.isEmpty(a10) ? a10 : "GS(2021)1328号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "getScalePerPixel");
            dx.a(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.f6737b.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getTerrainApprovalNumber() {
        du.f(this.f6745e);
        String a10 = dn.a(this.f6745e, "approval_number", "te", "");
        return !TextUtils.isEmpty(a10) ? a10 : "GS(2021)6352号";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IUiSettingsDelegate getUiSettings() {
        return this.f6766z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getUnitLengthByZoom(int i10) {
        GLMapState gLMapState = new GLMapState(this.F, this.f6746f.getNativeInstance());
        gLMapState.setMapZoomer(i10);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final View getView() throws RemoteException {
        ei eiVar = this.C;
        if (eiVar != null) {
            return eiVar.j();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.getViewMatrix();
        }
        return this.f6754n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Point getWaterMarkerPositon() {
        ei eiVar = this.C;
        if (eiVar != null) {
            return eiVar.a();
        }
        return new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapLanguage() {
        return this.aZ;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapStyle() {
        return this.f6738ba;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getZoomLevel() {
        return c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng != null && latLng2 != null && this.aw && !this.G.get()) {
                Pair<Float, IPoint> a10 = dx.a(mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), getMapWidth(), getMapHeight());
                if (a10 != null) {
                    return ((Float) a10.first).floatValue();
                }
                GLMapState gLMapState = new GLMapState(this.F, this.f6746f.getNativeInstance());
                float mapZoomer = gLMapState.getMapZoomer();
                gLMapState.recycle();
                return mapZoomer;
            }
            return mapConfig.getSZ();
        } catch (Throwable th) {
            dx.a(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int hideBuildings(final List<LatLng> list) {
        if (this.f6746f == null) {
            return -1;
        }
        FutureTask futureTask = new FutureTask(new Callable<Integer>() { // from class: com.amap.api.col.3l.l.38
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer call() throws Exception {
                return Integer.valueOf(l.this.f6746f.hideBuildings(list));
            }
        });
        queueEvent(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return -1;
        } catch (ExecutionException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void hideInfoWindow() {
        av avVar = this.f6763w;
        if (avVar != null) {
            avVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws RemoteException {
        return this.f6737b.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapAngle(int i10) {
        return g(i10);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapCameraDegree(int i10) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.J;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.E;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return this.f6737b.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isUseAnchor() {
        return this.I;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void latlon2Geo(double d10, double d11, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d10, d11, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void loadWorldVectorMap(boolean z10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z10);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void map2Geo(float f10, float f11, IPoint iPoint) {
        ((Point) iPoint).x = (int) (f10 + this.f6737b.getSX());
        ((Point) iPoint).y = (int) (f11 + this.f6737b.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        q qVar = this.f6761u;
        if (qVar == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : qVar.a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.H = true;
        c(this.F);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.H = false;
        d(this.F);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        Message obtainMessage = this.f6750j.obtainMessage();
        obtainMessage.what = 11;
        this.f6750j.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onDoubleTap(int i10, MotionEvent motionEvent) {
        if (!this.aw) {
            return false;
        }
        a((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.T = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i10, byte[] bArr) {
        au auVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    auVar = new au();
                    byte b4 = bArr[0];
                    auVar.f5005a = new String(bArr, 1, b4, "utf-8");
                    int i11 = b4 + 1;
                    int i12 = i11 + 1;
                    byte b10 = bArr[i11];
                    auVar.f5006b = new String(bArr, i12, b10, "utf-8");
                    int i13 = i12 + b10;
                    int i14 = i13 + 1;
                    byte b11 = bArr[i13];
                    auVar.activeFloorName = new String(bArr, i14, b11, "utf-8");
                    int i15 = i14 + b11;
                    auVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i15);
                    int i16 = i15 + 4;
                    int i17 = i16 + 1;
                    byte b12 = bArr[i16];
                    auVar.poiid = new String(bArr, i17, b12, "utf-8");
                    int i18 = i17 + b12;
                    int i19 = i18 + 1;
                    byte b13 = bArr[i18];
                    auVar.f5012h = new String(bArr, i19, b13, "utf-8");
                    int i20 = i19 + b13;
                    int i21 = GLConvertUtil.getInt(bArr, i20);
                    auVar.f5007c = i21;
                    int i22 = i20 + 4;
                    auVar.floor_indexs = new int[i21];
                    auVar.floor_names = new String[i21];
                    auVar.f5008d = new String[i21];
                    for (int i23 = 0; i23 < auVar.f5007c; i23++) {
                        auVar.floor_indexs[i23] = GLConvertUtil.getInt(bArr, i22);
                        int i24 = i22 + 4;
                        int i25 = i24 + 1;
                        byte b14 = bArr[i24];
                        if (b14 > 0) {
                            auVar.floor_names[i23] = new String(bArr, i25, b14, "utf-8");
                            i25 += b14;
                        }
                        i22 = i25 + 1;
                        byte b15 = bArr[i25];
                        if (b15 > 0) {
                            auVar.f5008d[i23] = new String(bArr, i22, b15, "utf-8");
                            i22 += b15;
                        }
                    }
                    int i26 = GLConvertUtil.getInt(bArr, i22);
                    auVar.f5009e = i26;
                    int i27 = i22 + 4;
                    if (i26 > 0) {
                        auVar.f5010f = new int[i26];
                        for (int i28 = 0; i28 < auVar.f5009e; i28++) {
                            auVar.f5010f[i28] = GLConvertUtil.getInt(bArr, i27);
                            i27 += 4;
                        }
                    }
                    this.bg = auVar;
                    post(new Runnable() { // from class: com.amap.api.col.3l.l.34
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (l.this.aE != null) {
                                l.this.aE.a(l.this.bg);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                dx.a(th);
                th.printStackTrace();
                return;
            }
        }
        auVar = null;
        this.bg = auVar;
        post(new Runnable() { // from class: com.amap.api.col.3l.l.34
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.aE != null) {
                    l.this.aE.a(l.this.bg);
                }
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onLongPress(int i10, MotionEvent motionEvent) {
        int i11 = 0;
        try {
            this.Q = false;
            b(i10);
            BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.O = (Marker) hitBaseOverlay;
            }
            BaseOverlay hitBaseOverlay2 = this.D.getHitBaseOverlay(motionEvent, 3);
            if (hitBaseOverlay2 instanceof GLTFOverlay) {
                this.P = (GLTFOverlay) hitBaseOverlay2;
            }
            Marker marker = this.O;
            if (marker != null && marker.isDraggable()) {
                LatLng position = this.O.getPosition();
                if (position != null) {
                    IPoint obtain = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain);
                    ((Point) obtain).y -= 60;
                    DPoint obtain2 = DPoint.obtain();
                    getPixel2LatLng(((Point) obtain).x, ((Point) obtain).y, obtain2);
                    this.O.setPosition(new LatLng(obtain2.f9304y, obtain2.f9303x));
                    this.D.set2Top(this.O.getId());
                    try {
                        List a10 = this.f6761u.a(AMap.OnMarkerDragListener.class.hashCode());
                        if (a10 != null && a10.size() > 0) {
                            synchronized (a10) {
                                while (i11 < a10.size()) {
                                    ((AMap.OnMarkerDragListener) a10.get(i11)).onMarkerDragStart(this.O);
                                    i11++;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        gy.b(th, "AMapDelegateImp", "onMarkerDragStart");
                        th.printStackTrace();
                    }
                    this.M = true;
                    obtain.recycle();
                    obtain2.recycle();
                }
                this.an.resetTickCount(30);
            }
            GLTFOverlay gLTFOverlay = this.P;
            if (gLTFOverlay != null && gLTFOverlay.isDraggable()) {
                LatLng latlng = this.P.getLatlng();
                if (latlng != null) {
                    IPoint obtain3 = IPoint.obtain();
                    getLatLng2Pixel(latlng.latitude, latlng.longitude, obtain3);
                    ((Point) obtain3).y -= 60;
                    DPoint obtain4 = DPoint.obtain();
                    getPixel2LatLng(((Point) obtain3).x, ((Point) obtain3).y, obtain4);
                    this.P.setLatLng(new LatLng(obtain4.f9304y, obtain4.f9303x));
                    this.D.set2Top(this.P.getId());
                    this.N = true;
                    obtain3.recycle();
                    obtain4.recycle();
                }
            } else {
                List a11 = this.f6761u.a(AMap.OnMapLongClickListener.class.hashCode());
                if (a11 != null && a11.size() > 0) {
                    DPoint obtain5 = DPoint.obtain();
                    getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain5);
                    synchronized (a11) {
                        while (i11 < a11.size()) {
                            ((AMap.OnMapLongClickListener) a11.get(i11)).onMapLongClick(new LatLng(obtain5.f9304y, obtain5.f9303x));
                            i11++;
                        }
                    }
                    this.R = true;
                    obtain5.recycle();
                }
            }
            this.an.resetTickCount(30);
        } catch (Throwable th2) {
            gy.b(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapBlankClick(double d10, double d11) {
        a(d10, d11);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapPOIClick(MapPoi mapPoi) {
        List a10;
        MapConfig mapConfig = this.f6737b;
        if (mapConfig == null || !mapConfig.isTouchPoiEnable() || (a10 = this.f6761u.a(AMap.OnPOIClickListener.class.hashCode())) == null || a10.size() <= 0 || mapPoi == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
        this.f6750j.sendMessage(obtain);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onPause() {
        f();
        IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onResume() {
        try {
            this.an.setRenderFps(15.0f);
            this.B.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.D;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            cl clVar = this.K;
            if (clVar != null) {
                clVar.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onSingleTapConfirmed(int i10, MotionEvent motionEvent) {
        if (!this.aw) {
            return false;
        }
        try {
            b(i10);
            if (h(motionEvent) || e(motionEvent) || g(motionEvent)) {
                return true;
            }
            d(motionEvent);
            if (f(motionEvent)) {
                return true;
            }
            c(motionEvent);
            return true;
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.H || !this.aw || !this.at) {
            return false;
        }
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6742be;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        getEngineIDWithGestureInfo(this.f6742be);
        l();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            m();
            d();
        } else if (action == 1) {
            e();
        }
        if (motionEvent.getAction() == 2 && this.M) {
            try {
                a(motionEvent);
            } catch (Throwable th) {
                gy.b(th, "AMapDelegateImp", "onDragMarker");
                th.printStackTrace();
            }
            return true;
        }
        if (motionEvent.getAction() == 2 && this.N) {
            try {
                b(motionEvent);
            } catch (Throwable th2) {
                gy.b(th2, "AMapDelegateImp", "onDragGLTF");
                th2.printStackTrace();
            }
            return true;
        }
        if (this.ap) {
            try {
                this.ao.a(motionEvent);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        try {
            List a10 = this.f6761u.a(AMap.OnMapTouchListener.class.hashCode());
            if (a10 != null && a10.size() > 0) {
                this.f6750j.removeMessages(14);
                Message obtainMessage = this.f6750j.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void pixel2Map(int i10, int i11, PointF pointF) {
        if (!this.aw || this.H || this.f6746f == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        getPixel2Geo(i10, i11, obtain);
        pointF.x = ((Point) obtain).x - ((float) this.f6737b.getSX());
        pointF.y = ((Point) obtain).y - ((float) this.f6737b.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.B;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(Runnable runnable) {
        long j10;
        try {
            try {
                j10 = Thread.currentThread().getId();
            } catch (Throwable th) {
                dx.a(th);
                gy.b(th, "AMapdelegateImp", "queueEvent");
                j10 = -1;
            }
            if (j10 != -1 && j10 == this.am) {
                runnable.run();
            } else if (this.f6746f != null) {
                this.B.queueEvent(runnable);
            }
        } catch (Throwable th2) {
            dx.a(th2);
            gy.b(th2, "AMapdelegateImp", "queueEvent");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void redrawInfoWindow() {
        if (!this.G.get() && this.aw) {
            this.f6750j.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void refreshLogo() {
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void reloadMapCustomStyle() {
        k kVar = this.aH;
        if (kVar != null) {
            kVar.b();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void removeEngineGLOverlay(final BaseMapOverlay baseMapOverlay) {
        if (this.f6746f != null) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.37
                @Override // java.lang.Runnable
                public final void run() {
                    l lVar = l.this;
                    lVar.f6746f.getOverlayBundle(lVar.F).removeOverlay(baseMapOverlay);
                }
            });
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLModel(String str) {
        try {
            this.D.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.D.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void requestRender() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.B.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetMinMaxZoomPreference() {
        List a10;
        this.f6737b.resetMinMaxZoomPreference();
        try {
            if (!this.f6766z.isZoomControlsEnabled() || !this.f6737b.isNeedUpdateZoomControllerState() || (a10 = this.f6761u.a(AMapWidgetListener.class.hashCode())) == null || a10.size() <= 0) {
                return;
            }
            synchronized (a10) {
                for (int i10 = 0; i10 < a10.size(); i10++) {
                    ((AMapWidgetListener) a10.get(i10)).invalidateZoomController(this.f6737b.getSZ());
                }
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z10) throws RemoteException {
        try {
            c(this.F);
            a(this.F, z10);
            d(this.F);
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        z zVar = this.ao;
        if (zVar != null) {
            this.f6762v = aMapGestureListener;
            zVar.a(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i10, int i11) throws RemoteException {
        this.I = true;
        this.aC = i10;
        this.aD = i11;
        if (this.ax && this.aw) {
            if (this.f6737b.getAnchorX() == this.aC && this.f6737b.getAnchorY() == this.aD) {
                return;
            }
            this.f6737b.setAnchorX(this.aC);
            this.f6737b.setAnchorY(this.aD);
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.31
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l lVar = l.this;
                        lVar.f6737b.setAnchorX(Math.max(0, Math.min(lVar.aC, l.this.f6747g)));
                        l lVar2 = l.this;
                        lVar2.f6737b.setAnchorY(Math.max(0, Math.min(lVar2.aD, l.this.f6748h)));
                        l lVar3 = l.this;
                        lVar3.f6746f.setProjectionCenter(lVar3.F, l.this.f6737b.getAnchorX(), l.this.f6737b.getAnchorY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setConstructingRoadEnable(final boolean z10) {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.28
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f6746f.setMapOpenLayerEnable(z10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.aR;
                aVar.f6847c = z10;
                aVar.f6846b = true;
                aVar.f6850f = this.F;
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (a(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null || customMapStyleOptions.getStyleResDataPath() != null || customMapStyleOptions.getStyleResData() != null)) {
                    o();
                }
                this.aH.c();
                this.aH.a(customMapStyleOptions);
                com.autonavi.extra.b bVar = this.aY;
                if (bVar != null) {
                    bVar.i();
                }
            } catch (Throwable th) {
                dx.a(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f6737b.getCustomStyleID())) {
            return;
        }
        this.f6737b.setCustomStyleID(str);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f6737b.getCustomStylePath())) {
            return;
        }
        this.f6737b.setCustomStylePath(str);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.ag = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6737b.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setGestureStatus(int i10, int i11) {
        if (this.aB == 0 || i11 != 5) {
            this.aB = i11;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setHideLogoEnble(boolean z10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z10);
            if (this.f6737b.isCustomStyleEnable()) {
                this.f6766z.setLogoEnable(!z10);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.G.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f6743c = (au) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.33
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = l.this;
                GLMapEngine gLMapEngine = lVar.f6746f;
                if (gLMapEngine != null) {
                    int i10 = lVar.F;
                    au auVar = l.this.f6743c;
                    gLMapEngine.setIndoorBuildingToBeActive(i10, auVar.activeFloorName, auVar.activeFloorIndex, auVar.poiid);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(final boolean z10) throws RemoteException {
        List a10;
        try {
            if (this.aw && !this.G.get()) {
                this.f6737b.setIndoorEnable(z10);
                resetRenderTime();
                if (z10) {
                    GLMapEngine gLMapEngine = this.f6746f;
                    if (gLMapEngine != null) {
                        gLMapEngine.setIndoorEnable(this.F, true);
                    }
                } else {
                    GLMapEngine gLMapEngine2 = this.f6746f;
                    if (gLMapEngine2 != null) {
                        gLMapEngine2.setIndoorEnable(this.F, false);
                    }
                    MapConfig mapConfig = this.f6737b;
                    mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.f6737b.getMaxZoomLevel() : 20.0f;
                    try {
                        if (this.f6766z.isZoomControlsEnabled() && (a10 = this.f6761u.a(AMapWidgetListener.class.hashCode())) != null && a10.size() > 0) {
                            synchronized (a10) {
                                for (int i10 = 0; i10 < a10.size(); i10++) {
                                    ((AMapWidgetListener) a10.get(i10)).invalidateZoomController(this.f6737b.getSZ());
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                du.c(this.f6745e, z10);
                if (this.f6766z.isIndoorSwitchEnabled()) {
                    this.f6750j.post(new Runnable() { // from class: com.amap.api.col.3l.l.23
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!z10) {
                                if (l.this.C != null) {
                                    l.this.C.i(Boolean.FALSE);
                                    return;
                                }
                                return;
                            }
                            l.this.showIndoorSwitchControlsEnabled(true);
                        }
                    });
                    return;
                }
                return;
            }
            a aVar = this.aV;
            aVar.f6847c = z10;
            aVar.f6846b = true;
            aVar.f6850f = this.F;
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        av avVar;
        if (this.G.get() || (avVar = this.f6763w) == null) {
            return;
        }
        avVar.a(infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(final boolean z10) throws RemoteException {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.24
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = l.this;
                GLMapEngine gLMapEngine = lVar.f6746f;
                if (gLMapEngine != null) {
                    gLMapEngine.setOfflineDataEnable(lVar.F, z10);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.G.get()) {
                return;
            }
            LocationSource locationSource2 = this.L;
            if (locationSource2 != null && (locationSource2 instanceof aw)) {
                locationSource2.deactivate();
            }
            this.L = locationSource;
            if (locationSource != null) {
                this.C.h(Boolean.TRUE);
            } else {
                this.C.h(Boolean.FALSE);
            }
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoBottomMargin(int i10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.c(Integer.valueOf(i10));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoLeftMargin(int i10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.d(Integer.valueOf(i10));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoMarginRate(int i10, float f10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.a(Integer.valueOf(i10), Float.valueOf(f10));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoPosition(int i10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            eiVar.b(Integer.valueOf(i10));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapCustomEnable(boolean z10, boolean z11) {
        cs csVar;
        if (this.aw && !this.G.get()) {
            boolean z12 = z11 ? z11 : false;
            if (TextUtils.isEmpty(this.f6737b.getCustomStylePath()) && TextUtils.isEmpty(this.f6737b.getCustomStyleID())) {
                return;
            }
            if (z10) {
                try {
                    if (this.f6737b.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f6737b.getCustomStyleID()) && (csVar = this.ak) != null) {
                        csVar.a(this.f6737b.getCustomStyleID());
                        this.ak.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    dx.a(th);
                    return;
                }
            }
            if (z11 || this.A || (this.f6737b.isCustomStyleEnable() ^ z10)) {
                a(z10, (byte[]) null, z12);
            }
            this.A = false;
            return;
        }
        a aVar = this.aM;
        aVar.f6846b = true;
        aVar.f6847c = z10;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapEnable(boolean z10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z10);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.f6737b) == null || mapConfig.isCustomStyleEnable() || this.f6737b.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals("en")) {
            this.f6737b.setMapLanguage("zh_cn");
            this.af = 0;
        } else {
            if (this.Y != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th) {
                    dx.a(th);
                    th.printStackTrace();
                }
            }
            this.f6737b.setMapLanguage("en");
            this.af = -10000;
        }
        try {
            b(getCameraPosition());
        } catch (Throwable th2) {
            dx.a(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.f6737b.setLimitLatLngBounds(latLngBounds);
            p();
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(final boolean z10) throws RemoteException {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.25
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l lVar = l.this;
                            lVar.f6746f.setLabelEnable(lVar.F, z10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.aO;
                aVar.f6847c = z10;
                aVar.f6846b = true;
                aVar.f6850f = this.F;
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i10) throws RemoteException {
        this.af = i10;
        this.f6749i = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i10) throws RemoteException {
        MapConfig mapConfig;
        if (i10 != this.Y || ((mapConfig = this.f6737b) != null && mapConfig.isCustomStyleEnable())) {
            this.Y = i10;
            h(i10);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            q qVar = this.f6761u;
            if (qVar != null) {
                qVar.a(AMapWidgetListener.class.hashCode(), (int) aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i10, int i11, int i12, int i13, int i14, long j10) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f10) {
        this.f6737b.setMaxZoomLevel(f10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f10) {
        this.f6737b.setMinZoomLevel(f10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z10) throws RemoteException {
        if (this.G.get()) {
            return;
        }
        try {
            ei eiVar = this.C;
            if (eiVar != null) {
                LocationSource locationSource = this.L;
                if (locationSource == null) {
                    eiVar.h(Boolean.FALSE);
                } else if (z10) {
                    locationSource.activate(this.f6760t);
                    this.C.h(Boolean.TRUE);
                    if (this.K == null) {
                        this.K = new cl(this, this.f6745e);
                    }
                } else {
                    cl clVar = this.K;
                    if (clVar != null) {
                        clVar.c();
                        this.K = null;
                    }
                    this.L.deactivate();
                }
            }
            if (!z10) {
                this.f6766z.setMyLocationButtonEnabled(z10);
            }
            this.E = z10;
            resetRenderTime();
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f10) throws RemoteException {
        try {
            cl clVar = this.K;
            if (clVar != null) {
                clVar.a(f10);
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.G.get()) {
            return;
        }
        try {
            if (this.K == null) {
                this.K = new cl(this, this.f6745e);
            }
            if (this.K != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                LocationSource locationSource = this.L;
                if (locationSource != null && (locationSource instanceof aw)) {
                    ((aw) locationSource).a(myLocationStyle.getInterval());
                    ((aw) this.L).a(myLocationStyle.getMyLocationType());
                }
                this.K.a(myLocationStyle);
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i10) throws RemoteException {
        try {
            cl clVar = this.K;
            if (clVar == null || clVar.a() == null) {
                return;
            }
            this.K.a().myLocationType(i10);
            setMyLocationStyle(this.K.a());
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setNaviLabelEnable(final boolean z10, final int i10, final int i11) throws RemoteException {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.27
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l lVar = l.this;
                            lVar.f6746f.setNaviLabelEnable(lVar.F, z10, i10, i11);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            a aVar = this.aQ;
            aVar.f6847c = z10;
            aVar.f6851g = i10;
            aVar.f6852h = i11;
            aVar.f6846b = true;
            aVar.f6850f = this.F;
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnCameraChangeListener.class.hashCode(), (int) onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnIndoorBuildingActiveListener.class.hashCode(), (int) onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnInfoWindowClickListener.class.hashCode(), (int) onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMapClickListener.class.hashCode(), (int) onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMapLongClickListener.class.hashCode(), (int) onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMapTouchListener.class.hashCode(), (int) onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMapLoadedListener.class.hashCode(), (int) onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMarkerClickListener.class.hashCode(), (int) onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMarkerDragListener.class.hashCode(), (int) onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.aG = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnMyLocationChangeListener.class.hashCode(), (int) onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnPOIClickListener.class.hashCode(), (int) onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a(AMap.OnPolylineClickListener.class.hashCode(), (int) onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i10) {
        try {
            if (i10 == -1) {
                this.ai = i10;
            } else {
                this.ai = Math.max(10, Math.min(i10, 40));
            }
            du.g(this.f6745e);
        } catch (Throwable th) {
            dx.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i10) {
        try {
            IGLSurfaceView iGLSurfaceView = this.B;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i10);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRoadArrowEnable(final boolean z10) throws RemoteException {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.26
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l lVar = l.this;
                            lVar.f6746f.setRoadArrowEnable(lVar.F, z10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.aP;
                aVar.f6847c = z10;
                aVar.f6846b = true;
                aVar.f6850f = this.F;
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z10) {
        if (z10) {
            return;
        }
        try {
            if (this.ai == -1) {
                m();
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setTerrainAuth(boolean z10) {
        GLMapEngine gLMapEngine;
        if (this.G.get() || (gLMapEngine = this.f6746f) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTouchPoiEnable(boolean z10) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z10);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(final boolean z10) throws RemoteException {
        try {
            if (this.aw && !this.G.get()) {
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.22
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (l.this.f6737b.isTrafficEnabled() != z10) {
                                l.this.f6737b.setTrafficEnabled(z10);
                                l.this.an.setTrafficMode(z10);
                                l lVar = l.this;
                                lVar.f6746f.setTrafficEnable(lVar.F, z10);
                                l.this.resetRenderTime();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dx.a(th);
                        }
                    }
                });
                return;
            }
            a aVar = this.aJ;
            aVar.f6847c = z10;
            aVar.f6846b = true;
            aVar.f6850f = this.F;
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTexture(final byte[] bArr, final MyTrafficStyle myTrafficStyle) {
        if (this.G.get()) {
            return;
        }
        try {
            if (this.aw && this.ax && bArr != null && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.29
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l lVar = l.this;
                            lVar.f6746f.setTrafficStyleWithTexture(lVar.F, bArr, myTrafficStyle);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            a aVar = this.aT;
            aVar.f6853i = bArr;
            aVar.f6854j = myTrafficStyle;
            aVar.f6846b = true;
            aVar.f6850f = this.F;
        } catch (Exception e2) {
            dx.a(e2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTextureData(final byte[] bArr) {
        if (this.G.get()) {
            return;
        }
        try {
            if (this.aw && this.ax && bArr != null) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.30
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l lVar = l.this;
                            lVar.f6746f.setTrafficStyleWithTextureData(lVar.F, bArr);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.aS;
                aVar.f6853i = bArr;
                aVar.f6846b = true;
                aVar.f6850f = this.F;
            }
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i10) {
        IGLSurfaceView iGLSurfaceView = this.B;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i10);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setWorldVectorMapStyle(String str) {
        if (a(false, true) || TextUtils.isEmpty(str) || this.f6737b == null || this.f6738ba.equals(str)) {
            return;
        }
        this.f6738ba = str;
        com.autonavi.extra.b bVar = this.aY;
        if (bVar != null) {
            bVar.i();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z10) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setZoomPosition(int i10) {
        ei eiVar;
        if (this.G.get() || (eiVar = this.C) == null) {
            return;
        }
        eiVar.a(Integer.valueOf(i10));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f10) {
        this.f6736ar = f10;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showCompassEnabled(boolean z10) {
        ei eiVar;
        if (this.G.get() || (eiVar = this.C) == null) {
            return;
        }
        eiVar.d(Boolean.valueOf(z10));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void showHideBuildings(final int i10) {
        if (this.f6746f == null) {
            return;
        }
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.39
            @Override // java.lang.Runnable
            public final void run() {
                l.this.f6746f.showHideBuildings(i10);
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showIndoorSwitchControlsEnabled(boolean z10) {
        ei eiVar;
        if (this.G.get() || (eiVar = this.C) == null) {
            return;
        }
        eiVar.a(Boolean.valueOf(z10));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        av avVar;
        if (baseOverlayImp == null || (avVar = this.f6763w) == null) {
            return;
        }
        try {
            avVar.a(baseOverlayImp);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showLogoEnabled(boolean z10) {
        if (this.G.get()) {
            return;
        }
        this.C.f(Boolean.valueOf(z10));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationButtonEnabled(boolean z10) {
        ei eiVar;
        if (this.G.get() || (eiVar = this.C) == null) {
            return;
        }
        eiVar.c(Boolean.valueOf(z10));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.E && this.L != null) {
                if (this.K == null) {
                    this.K = new cl(this, this.f6745e);
                }
                if (location.getLongitude() != ShadowDrawableWrapper.COS_45 && location.getLatitude() != ShadowDrawableWrapper.COS_45) {
                    this.K.a(location);
                }
                List a10 = this.f6761u.a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (a10 != null && a10.size() > 0) {
                    synchronized (a10) {
                        for (int i10 = 0; i10 < a10.size(); i10++) {
                            ((AMap.OnMyLocationChangeListener) a10.get(i10)).onMyLocationChange(location);
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            cl clVar = this.K;
            if (clVar != null) {
                clVar.c();
            }
            this.K = null;
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showScaleEnabled(boolean z10) {
        ei eiVar;
        if (this.G.get() || (eiVar = this.C) == null) {
            return;
        }
        eiVar.e(Boolean.valueOf(z10));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showZoomControlsEnabled(boolean z10) {
        ei eiVar;
        if (this.G.get() || (eiVar = this.C) == null) {
            return;
        }
        eiVar.b(Boolean.valueOf(z10));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.f6746f;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float toMapLenWithWin(int i10) {
        GLMapEngine gLMapEngine;
        if (!this.aw || this.H || (gLMapEngine = this.f6746f) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.F).getGLUnitWithWin(i10);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void zoomOut(int i10) {
        if (this.aw && ((int) c()) > this.f6737b.getMinZoomLevel()) {
            try {
                animateCamera(al.b());
            } catch (Throwable th) {
                gy.b(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public l(IGLSurfaceView iGLSurfaceView, Context context, boolean z10) {
        this.f6760t = null;
        this.f6761u = new q();
        byte b4 = 0;
        this.f6730a = false;
        this.A = false;
        this.E = false;
        this.G = new AtomicBoolean(false);
        this.H = false;
        this.f6737b = new MapConfig(true);
        this.I = false;
        this.J = false;
        this.M = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = 0;
        this.V = true;
        this.W = true;
        this.X = new Rect();
        this.Y = 1;
        this.Z = null;
        this.f6734ad = false;
        this.f6735ae = false;
        this.af = 0;
        this.ah = -1;
        this.ai = -1;
        this.aj = new ArrayList();
        this.f6744d = null;
        this.am = -1L;
        this.ap = false;
        this.aq = 0.0f;
        this.f6736ar = 1.0f;
        this.as = 1.0f;
        this.at = true;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = new ReentrantLock();
        this.aB = 0;
        this.f6749i = true;
        this.f6750j = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.col.3l.l.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i10;
                el f10;
                if (message == null || l.this.G.get()) {
                    return;
                }
                try {
                    i10 = message.what;
                } catch (Throwable th) {
                    gy.b(th, "AMapDelegateImp", "handleMessage");
                    th.printStackTrace();
                    return;
                }
                if (i10 != 2) {
                    int i11 = 0;
                    switch (i10) {
                        case 10:
                            CameraPosition cameraPosition = (CameraPosition) message.obj;
                            try {
                                List a10 = l.this.f6761u.a(AMap.OnCameraChangeListener.class.hashCode());
                                if (cameraPosition != null && a10 != null && a10.size() > 0) {
                                    synchronized (a10) {
                                        Iterator iterator2 = a10.iterator2();
                                        while (iterator2.hasNext()) {
                                            ((AMap.OnCameraChangeListener) iterator2.next()).onCameraChange(cameraPosition);
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                dx.a(th2);
                            }
                            l.this.f6737b.addChangedCounter();
                            return;
                        case 11:
                            try {
                                CameraPosition cameraPosition2 = l.this.getCameraPosition();
                                if (cameraPosition2 != null && l.this.C != null) {
                                    l.this.C.a(cameraPosition2);
                                }
                                l.this.b(cameraPosition2);
                                if (l.this.av) {
                                    l.f(l.this);
                                    if (l.this.D != null) {
                                        l.this.D.setFlingState(false);
                                    }
                                    l.this.b();
                                }
                                if (l.this.T) {
                                    l.this.redrawInfoWindow();
                                    l.i(l.this);
                                }
                                l.this.a(cameraPosition2);
                                return;
                            } catch (Throwable th3) {
                                gy.b(th3, "AMapDelegateImp", "CameraUpdateFinish");
                                dx.a(th3);
                                return;
                            }
                        case 12:
                            if (l.this.C != null) {
                                l.this.C.a(Float.valueOf(l.this.getZoomLevel()));
                                return;
                            }
                            return;
                        case 13:
                            if (l.this.C != null) {
                                l.this.C.h();
                                return;
                            }
                            return;
                        case 14:
                            try {
                                List a11 = l.this.f6761u.a(AMap.OnMapTouchListener.class.hashCode());
                                if (a11 == null || a11.size() <= 0) {
                                    return;
                                }
                                synchronized (a11) {
                                    Iterator iterator22 = a11.iterator2();
                                    while (iterator22.hasNext()) {
                                        ((AMap.OnMapTouchListener) iterator22.next()).onTouch((MotionEvent) message.obj);
                                    }
                                }
                                return;
                            } catch (Throwable th4) {
                                gy.b(th4, "AMapDelegateImp", "onTouchHandler");
                                th4.printStackTrace();
                                return;
                            }
                        case 15:
                            Bitmap bitmap = (Bitmap) message.obj;
                            int i12 = message.arg1;
                            if (bitmap == null || l.this.C == null) {
                                try {
                                    List a12 = l.this.f6761u.a(AMap.onMapPrintScreenListener.class.hashCode());
                                    ArrayList arrayList = a12 != null ? new ArrayList(a12) : null;
                                    List a13 = l.this.f6761u.a(AMap.OnMapScreenShotListener.class.hashCode());
                                    ArrayList arrayList2 = a13 != null ? new ArrayList(a13) : null;
                                    l.this.f6761u.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                    l.this.f6761u.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                    if (arrayList != null && arrayList.size() > 0) {
                                        synchronized (arrayList) {
                                            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                                                ((AMap.onMapPrintScreenListener) arrayList.get(i13)).onMapPrint(null);
                                            }
                                        }
                                    }
                                    if (arrayList2 == null || arrayList2.size() <= 0) {
                                        return;
                                    }
                                    synchronized (arrayList2) {
                                        while (i11 < arrayList2.size()) {
                                            ((AMap.OnMapScreenShotListener) arrayList2.get(i11)).onMapScreenShot(null);
                                            ((AMap.OnMapScreenShotListener) arrayList2.get(i11)).onMapScreenShot(null, i12);
                                            i11++;
                                        }
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                    return;
                                }
                            }
                            Canvas canvas = new Canvas(bitmap);
                            if (l.this.V && (f10 = l.this.C.f()) != null) {
                                f10.onDraw(canvas);
                            }
                            l.this.C.a(canvas);
                            try {
                                List a14 = l.this.f6761u.a(AMap.onMapPrintScreenListener.class.hashCode());
                                ArrayList arrayList3 = a14 != null ? new ArrayList(a14) : null;
                                List a15 = l.this.f6761u.a(AMap.OnMapScreenShotListener.class.hashCode());
                                ArrayList arrayList4 = a15 != null ? new ArrayList(a15) : null;
                                l.this.f6761u.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                l.this.f6761u.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                if (arrayList3 != null && arrayList3.size() > 0) {
                                    synchronized (arrayList3) {
                                        for (int i14 = 0; i14 < arrayList3.size(); i14++) {
                                            ((AMap.onMapPrintScreenListener) arrayList3.get(i14)).onMapPrint(new BitmapDrawable(l.this.f6745e.getResources(), bitmap));
                                        }
                                    }
                                }
                                if (arrayList4 == null || arrayList4.size() <= 0) {
                                    return;
                                }
                                synchronized (arrayList4) {
                                    while (i11 < arrayList4.size()) {
                                        ((AMap.OnMapScreenShotListener) arrayList4.get(i11)).onMapScreenShot(bitmap);
                                        ((AMap.OnMapScreenShotListener) arrayList4.get(i11)).onMapScreenShot(bitmap, i12);
                                        i11++;
                                    }
                                }
                                return;
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                                return;
                            }
                        case 16:
                            try {
                                List a16 = l.this.f6761u.a(AMap.OnMapLoadedListener.class.hashCode());
                                if (a16 != null) {
                                    synchronized (a16) {
                                        while (i11 < a16.size()) {
                                            ((AMap.OnMapLoadedListener) a16.get(i11)).onMapLoaded();
                                            i11++;
                                        }
                                    }
                                }
                            } catch (Throwable th7) {
                                gy.b(th7, "AMapDelegateImp", "onMapLoaded");
                                th7.printStackTrace();
                                dx.a(th7);
                            }
                            if (l.this.C != null) {
                                l.this.C.i();
                                return;
                            }
                            return;
                        case 17:
                            l lVar = l.this;
                            if (!lVar.f6746f.isInMapAnimation(lVar.F) || l.this.D == null) {
                                return;
                            }
                            l.this.D.setFlingState(false);
                            return;
                        case 18:
                            if (l.this.f6763w != null) {
                                l.this.f6763w.b();
                                return;
                            }
                            return;
                        case 19:
                            List a17 = l.this.f6761u.a(AMap.OnMapClickListener.class.hashCode());
                            if (a17 != null) {
                                DPoint obtain = DPoint.obtain();
                                l.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                try {
                                    synchronized (a17) {
                                        Iterator iterator23 = a17.iterator2();
                                        while (iterator23.hasNext()) {
                                            ((AMap.OnMapClickListener) iterator23.next()).onMapClick(new LatLng(obtain.f9304y, obtain.f9303x));
                                        }
                                    }
                                    obtain.recycle();
                                    return;
                                } catch (Throwable th8) {
                                    gy.b(th8, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                                    th8.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        case 20:
                            try {
                                List a18 = l.this.f6761u.a(AMap.OnPOIClickListener.class.hashCode());
                                if (a18 == null || a18.size() <= 0) {
                                    return;
                                }
                                synchronized (a18) {
                                    while (i11 < a18.size()) {
                                        ((AMap.OnPOIClickListener) a18.get(i11)).onPOIClick((Poi) message.obj);
                                        i11++;
                                    }
                                }
                                return;
                            } catch (Throwable th9) {
                                gy.b(th9, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                                th9.printStackTrace();
                                return;
                            }
                        default:
                            return;
                    }
                    gy.b(th, "AMapDelegateImp", "handleMessage");
                    th.printStackTrace();
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Key验证失败：[");
                Object obj = message.obj;
                if (obj != null) {
                    sb2.append(obj);
                } else {
                    sb2.append(fk.f5772b);
                }
                sb2.append("]");
            }
        };
        this.aJ = new a() { // from class: com.amap.api.col.3l.l.11
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setTrafficEnabled(this.f6847c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aK = new a() { // from class: com.amap.api.col.3l.l.21
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l lVar = l.this;
                    lVar.setCenterToPixel(lVar.aC, l.this.aD);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aL = new a() { // from class: com.amap.api.col.3l.l.32
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.a(this.f6850f, this.f6848d, this.f6849e);
            }
        };
        this.aM = new a() { // from class: com.amap.api.col.3l.l.40
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.setMapCustomEnable(this.f6847c);
            }
        };
        this.aN = new a() { // from class: com.amap.api.col.3l.l.41
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.a(this.f6850f, this.f6847c);
            }
        };
        this.aO = new a() { // from class: com.amap.api.col.3l.l.42
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setMapTextEnable(this.f6847c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aP = new a() { // from class: com.amap.api.col.3l.l.43
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setRoadArrowEnable(this.f6847c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aQ = new a() { // from class: com.amap.api.col.3l.l.44
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setNaviLabelEnable(this.f6847c, this.f6851g, this.f6852h);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aR = new a() { // from class: com.amap.api.col.3l.l.2
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setConstructingRoadEnable(this.f6847c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aS = new a() { // from class: com.amap.api.col.3l.l.3
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setTrafficStyleWithTextureData(this.f6853i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aT = new a() { // from class: com.amap.api.col.3l.l.4
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setTrafficStyleWithTexture(this.f6853i, this.f6854j);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        this.aU = new a() { // from class: com.amap.api.col.3l.l.5
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.b(this.f6850f, this.f6847c);
            }
        };
        this.aV = new a() { // from class: com.amap.api.col.3l.l.6
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setIndoorEnabled(this.f6847c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aW = new Runnable() { // from class: com.amap.api.col.3l.l.7
            @Override // java.lang.Runnable
            public final void run() {
                el f10;
                if (l.this.C == null || (f10 = l.this.C.f()) == null) {
                    return;
                }
                f10.c();
            }
        };
        this.aX = new a() { // from class: com.amap.api.col.3l.l.8
            @Override // com.amap.api.col.3l.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.c(this.f6850f, this.f6847c);
            }
        };
        this.aZ = "";
        this.f6738ba = "";
        this.f6739bb = false;
        this.f6740bc = false;
        this.f6741bd = 0;
        this.f6742be = new EAMapPlatformGestureInfo();
        this.f6751k = new Point();
        this.bf = 0L;
        this.f6752l = null;
        this.bg = null;
        this.f6753m = new float[16];
        this.f6754n = new float[16];
        this.f6755o = new float[16];
        this.bh = null;
        this.f6756p = new float[12];
        this.f6757q = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.f6758r = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.f6759s = -1;
        this.f6745e = context;
        fs a10 = fr.a(context, dx.a());
        fr.c cVar = a10.f5947a;
        fr.c cVar2 = fr.c.SuccessCode;
        if (cVar == cVar2) {
            dz.a(context);
            dz.a(dy.f5397c, "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.aY = bVar;
        bVar.a();
        this.aY.b();
        gy.a(this.f6745e);
        dl.a().a(this.f6745e);
        w.f6963b = fj.c(context);
        dc.a(this.f6745e);
        this.ao = new z(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.an = gLMapRender;
        this.B = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        aa aaVar = new aa(this, this.f6745e);
        this.D = aaVar;
        this.f6746f = new GLMapEngine(this.f6745e, this);
        this.C = new eh(this.f6745e, this, aaVar);
        this.f6766z = new ag(this);
        this.C.a(new c(this, b4));
        this.aE = new b();
        iGLSurfaceView.setRenderMode(0);
        this.an.setRenderFps(15.0f);
        this.f6746f.setMapListener(this);
        this.f6765y = new ad(this);
        this.f6760t = new p(this);
        av avVar = new av(this.f6745e);
        this.f6763w = avVar;
        avVar.a(this.C);
        this.f6763w.b(new cn(aaVar, context));
        this.f6731aa = new t(this.f6745e, this);
        this.L = new aw(this.f6745e);
        this.ak = new cs(this.f6745e, this);
        cu cuVar = new cu(this.f6745e);
        this.al = cuVar;
        cuVar.a(this);
        a(z10);
        MapConfig mapConfig = this.f6737b;
        k kVar = new k(this, this.f6745e, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.aH = kVar;
        kVar.a(this);
        if (a10.f5947a != cVar2) {
            this.f6737b.setMapEnable(false);
        }
        this.F = this.f6746f.getEngineIDWithType(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CameraPosition cameraPosition) {
        if (this.f6737b.getMapLanguage().equals("en")) {
            boolean c4 = c(cameraPosition);
            if (c4 != this.W) {
                this.W = c4;
                b(this.F, c4);
                return;
            }
            return;
        }
        if (this.W) {
            return;
        }
        this.W = true;
        b(this.F, true);
    }

    private boolean c(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        if (this.f6737b == null) {
            return false;
        }
        try {
            return !dq.a(r4.getGeoRectangle().getClipRect());
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
            return false;
        }
    }

    private void d() {
        if (this.aw) {
            this.ao.a();
            this.ap = true;
            this.au = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
        }
    }

    private void e() {
        this.ap = true;
        this.au = false;
        if (this.R) {
            this.R = false;
        }
        if (this.Q) {
            this.Q = false;
        }
        if (this.S) {
            this.S = false;
        }
        try {
            if (this.M) {
                List a10 = this.f6761u.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a10 != null && a10.size() > 0 && this.O != null) {
                    synchronized (a10) {
                        for (int i10 = 0; i10 < a10.size(); i10++) {
                            ((AMap.OnMarkerDragListener) a10.get(i10)).onMarkerDragEnd(this.O);
                        }
                    }
                    this.O = null;
                }
                this.M = false;
            }
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        if (this.N) {
            if (this.P != null) {
                this.P = null;
            }
            this.N = false;
        }
    }

    private void f() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine == null || (gLMapState = (GLMapState) gLMapEngine.getNewMapState(this.F)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(obtain);
        this.f6737b.setSX(((Point) obtain).x);
        this.f6737b.setSY(((Point) obtain).y);
        this.f6737b.setSZ(gLMapState.getMapZoomer());
        this.f6737b.setSC(gLMapState.getCameraDegree());
        this.f6737b.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        obtain.recycle();
    }

    private LatLng g() {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig == null) {
            return null;
        }
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.f6737b.getSY(), 20);
        LatLng latLng = new LatLng(pixelsToLatLong.f9304y, pixelsToLatLong.f9303x, false);
        pixelsToLatLong.recycle();
        return latLng;
    }

    private synchronized void h() {
        synchronized (this.aj) {
            int size = this.aj.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.aj.get(i10).a().recycle();
            }
            this.aj.clear();
        }
    }

    private void i() {
        if (this.U > 0) {
            boolean canStopMapRender = this.f6746f.canStopMapRender(this.F);
            if (!canStopMapRender) {
                int i10 = this.U - 1;
                this.U = i10;
                if (i10 > 0) {
                    this.f6746f.renderAMap();
                    return;
                }
            }
            this.U = 0;
            Message obtainMessage = this.f6750j.obtainMessage(15, this.f6746f.getScreenShot(this.F, 0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011d, code lost:
    
        r1 = r10.f6761u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012d, code lost:
    
        if (r1.size() <= 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012f, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0130, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0135, code lost:
    
        if (r2 >= r1.size()) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0137, code lost:
    
        ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r1.get(r2)).invalidateCompassView();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0143, code lost:
    
        monitor-exit(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j() {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.l.j():void");
    }

    private void k() {
        if (!this.J) {
            this.f6750j.sendEmptyMessage(16);
            this.J = true;
            b();
        }
        long j10 = this.bf;
        if (j10 < 2) {
            this.bf = j10 + 1;
            return;
        }
        final ed d10 = this.C.d();
        if (d10 == null || d10.getVisibility() == 8) {
            return;
        }
        du.a(this.f6745e, System.currentTimeMillis() - this.aI);
        this.f6750j.post(new Runnable() { // from class: com.amap.api.col.3l.l.12
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.H) {
                    return;
                }
                try {
                    l lVar = l.this;
                    au auVar = lVar.f6743c;
                    if (auVar != null) {
                        lVar.setIndoorBuildingInfo(auVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                d10.a();
            }
        });
        this.f6746f.setStyleChangeGradualEnable(this.F, true);
    }

    private void l() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void m() {
        GLMapRender gLMapRender;
        if (!this.aw || (gLMapRender = this.an) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    private void n() {
        if (this.f6734ad) {
            return;
        }
        try {
            this.f6731aa.setName("AuthThread");
            this.f6731aa.start();
            this.f6734ad = true;
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    private void o() {
        if (this.f6735ae) {
            return;
        }
        try {
            if (this.f6732ab == null) {
                this.f6732ab = new r(this.f6745e, this);
            }
            this.f6732ab.setName("AuthProThread");
            this.f6732ab.start();
            this.f6735ae = true;
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    private void p() {
        try {
            LatLngBounds limitLatLngBounds = this.f6737b.getLimitLatLngBounds();
            if (this.f6746f != null && a(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(this.F, this.f6746f.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.f6737b.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f6737b.setLimitIPoints(null);
    }

    private void q() {
        q qVar = this.f6761u;
        if (qVar != null) {
            qVar.a();
        }
    }

    private void r() {
        cq cqVar = this.aF;
        if (cqVar != null) {
            cqVar.a();
            this.aF = null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j10, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.G.get() || this.f6746f == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j10;
        if (!this.H && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.f6746f.interruptAnimation();
                resetRenderTime();
                a(abstractCameraUpdateMessage);
                this.f6746f.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th) {
                dx.a(th);
                th.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            dx.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.f6750j == null || this.f6746f == null) {
            return;
        }
        try {
            d dVar = new d(this.f6745e, onCacheRemoveListener);
            this.f6750j.removeCallbacks(dVar);
            this.f6750j.post(dVar);
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            dx.a(th);
        }
    }

    private void a(boolean z10) {
        com.autonavi.extra.b bVar = this.aY;
        if (bVar != null) {
            Object j10 = bVar.j();
            if (j10 != null && (j10 instanceof Boolean)) {
                MapConfig mapConfig = this.f6737b;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z10 && ((Boolean) j10).booleanValue());
                }
                if (z10 && ((Boolean) j10).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object j11 = this.aY.j();
            if (j11 != null && (j11 instanceof Boolean)) {
                this.C.a(((Boolean) j11).booleanValue());
            }
            Object j12 = this.aY.j();
            if (j11 == null || !(j11 instanceof Integer)) {
                return;
            }
            this.af = ((Integer) j12).intValue();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.f6746f == null || this.G.get()) {
            return;
        }
        try {
            if (this.H && this.f6746f.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage c4 = al.c();
                c4.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                c4.geoPoint = new DPoint(this.f6737b.getSX(), this.f6737b.getSY());
                c4.zoom = this.f6737b.getSZ();
                c4.bearing = this.f6737b.getSR();
                c4.tilt = this.f6737b.getSC();
                this.f6746f.addMessage(abstractCameraUpdateMessage, false);
                while (this.f6746f.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.f6746f.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(c4);
                    }
                }
                abstractCameraUpdateMessage = c4;
            }
        } catch (Throwable th) {
            dx.a(th);
        }
        resetRenderTime();
        this.f6746f.clearAnimations(this.F, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        a(abstractCameraUpdateMessage);
        this.f6746f.addMessage(abstractCameraUpdateMessage, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        av avVar;
        if (this.G.get() || (avVar = this.f6763w) == null) {
            return;
        }
        avVar.a(commonInfoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        av avVar;
        if (baseOverlay == null || (avVar = this.f6763w) == null) {
            return;
        }
        try {
            avVar.a(baseOverlay);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* compiled from: AMapDelegateImp.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public boolean f6846b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6847c;

        /* renamed from: d, reason: collision with root package name */
        public int f6848d;

        /* renamed from: e, reason: collision with root package name */
        public int f6849e;

        /* renamed from: f, reason: collision with root package name */
        public int f6850f;

        /* renamed from: g, reason: collision with root package name */
        public int f6851g;

        /* renamed from: h, reason: collision with root package name */
        public int f6852h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f6853i;

        /* renamed from: j, reason: collision with root package name */
        public MyTrafficStyle f6854j;

        private a() {
            this.f6846b = false;
            this.f6847c = false;
            this.f6851g = 0;
            this.f6852h = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6846b = false;
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear(boolean z10) throws RemoteException {
        try {
            hideInfoWindow();
            String str = null;
            String str2 = "";
            cl clVar = this.K;
            if (clVar != null) {
                if (z10) {
                    str = clVar.d();
                    str2 = this.K.e();
                } else {
                    clVar.f();
                }
            }
            this.D.clear(str, str2);
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.20
                @Override // java.lang.Runnable
                public final void run() {
                    l lVar = l.this;
                    if (lVar.f6746f == null || lVar.G.get()) {
                        return;
                    }
                    l lVar2 = l.this;
                    lVar2.f6746f.removeNativeAllOverlay(lVar2.F);
                }
            });
            resetRenderTime();
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "clear");
            dx.a(th);
            th.printStackTrace();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        if (this.D != null && this.aG != null) {
            DPoint obtain = DPoint.obtain();
            if (this.f6746f != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                MultiPointItem multiPointItem = this.D.getMultiPointItem(new LatLng(obtain.f9304y, obtain.f9303x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.aG.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    private boolean d(MotionEvent motionEvent) {
        try {
            List a10 = this.f6761u.a(AMap.OnPolylineClickListener.class.hashCode());
            if (a10 != null && a10.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
                obtain.recycle();
                Polyline hitOverlay = this.D.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (a10) {
                        Iterator iterator2 = a10.iterator2();
                        while (iterator2.hasNext()) {
                            ((AMap.OnPolylineClickListener) iterator2.next()).onPolylineClick(hitOverlay);
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean h(MotionEvent motionEvent) throws RemoteException {
        try {
            List a10 = this.f6761u.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay a11 = this.f6763w.a(motionEvent);
            if (a11 != null && (a11 instanceof Marker)) {
                synchronized (a10) {
                    for (int i10 = 0; i10 < a10.size(); i10++) {
                        ((AMap.OnInfoWindowClickListener) a10.get(i10)).onInfoWindowClick((Marker) a11);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private float c() {
        if (this.f6737b != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private void b(MotionEvent motionEvent) {
        if (!this.N || this.P == null) {
            return;
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) (motionEvent.getY() - 60.0f);
        if (this.P.getLatlng() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x10, y10, obtain);
            LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
            obtain.recycle();
            this.P.setLatLng(latLng);
        }
    }

    private void c(final MotionEvent motionEvent) {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l.this.f6746f.addGestureSingleTapMessage(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void c(int i10) {
        if (this.au) {
            this.au = false;
        }
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        f(i10);
    }

    private boolean f(MotionEvent motionEvent) {
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
        obtain.recycle();
        BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(latLng, 3);
        if (!(hitBaseOverlay instanceof GLTFOverlay)) {
            return false;
        }
        GLTFOverlay gLTFOverlay = (GLTFOverlay) hitBaseOverlay;
        if (!gLTFOverlay.isClickable()) {
            return false;
        }
        try {
            this.D.set2Top(gLTFOverlay.getId());
            gLTFOverlay.tapClick();
            return true;
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "onGLTFTap");
            th.printStackTrace();
            return false;
        }
    }

    private boolean g(int i10) {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i10, 7);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[Catch: all -> 0x0075, TryCatch #0 {all -> 0x0075, blocks: (B:5:0x0027, B:7:0x0039, B:9:0x003d, B:11:0x0043, B:12:0x0053, B:13:0x0071, B:20:0x0049, B:21:0x0059, B:23:0x0067, B:24:0x006c, B:40:0x0024), top: B:39:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0039 A[Catch: all -> 0x0075, TryCatch #0 {all -> 0x0075, blocks: (B:5:0x0027, B:7:0x0039, B:9:0x003d, B:11:0x0043, B:12:0x0053, B:13:0x0071, B:20:0x0049, B:21:0x0059, B:23:0x0067, B:24:0x006c, B:40:0x0024), top: B:39:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(int r6) {
        /*
            r5 = this;
            r5.Y = r6
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            if (r6 != r2) goto Lb
        L8:
            r6 = 0
        L9:
            r0 = 0
            goto L27
        Lb:
            if (r6 != r1) goto L10
            r6 = 0
            r0 = 1
            goto L27
        L10:
            if (r6 != r0) goto L14
            r6 = 1
            goto L9
        L14:
            r4 = 4
            if (r6 != r4) goto L1a
            r6 = 0
        L18:
            r0 = 2
            goto L27
        L1a:
            r4 = 6
            if (r6 != r4) goto L1f
            r6 = 1
            goto L18
        L1f:
            r1 = 5
            if (r6 != r1) goto L24
            r6 = 0
            goto L27
        L24:
            r5.Y = r2     // Catch: java.lang.Throwable -> L75
            goto L8
        L27:
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f6737b     // Catch: java.lang.Throwable -> L75
            r1.setMapStyleMode(r0)     // Catch: java.lang.Throwable -> L75
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f6737b     // Catch: java.lang.Throwable -> L75
            r1.setMapStyleTime(r6)     // Catch: java.lang.Throwable -> L75
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f6737b     // Catch: java.lang.Throwable -> L75
            boolean r1 = r1.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L59
            com.amap.api.col.3l.k r1 = r5.aH     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L49
            boolean r1 = r1.d()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L49
            com.amap.api.col.3l.k r6 = r5.aH     // Catch: java.lang.Throwable -> L75
            r6.e()     // Catch: java.lang.Throwable -> L75
            goto L53
        L49:
            int r1 = r5.F     // Catch: java.lang.Throwable -> L75
            r5.a(r1, r0, r6)     // Catch: java.lang.Throwable -> L75
            com.autonavi.base.amap.mapcore.MapConfig r6 = r5.f6737b     // Catch: java.lang.Throwable -> L75
            r6.setCustomStyleEnable(r3)     // Catch: java.lang.Throwable -> L75
        L53:
            com.amap.api.col.3l.ag r6 = r5.f6766z     // Catch: java.lang.Throwable -> L75
            r6.setLogoEnable(r2)     // Catch: java.lang.Throwable -> L75
            goto L71
        L59:
            com.autonavi.base.amap.mapcore.MapConfig r1 = r5.f6737b     // Catch: java.lang.Throwable -> L75
            java.lang.String r1 = r1.getMapLanguage()     // Catch: java.lang.Throwable -> L75
            java.lang.String r2 = "en"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L6c
            java.lang.String r1 = "zh_cn"
            r5.setMapLanguage(r1)     // Catch: java.lang.Throwable -> L75
        L6c:
            int r1 = r5.F     // Catch: java.lang.Throwable -> L75
            r5.a(r1, r0, r6)     // Catch: java.lang.Throwable -> L75
        L71:
            r5.resetRenderTime()     // Catch: java.lang.Throwable -> L75
            return
        L75:
            r6 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.col.p0003l.gy.b(r6, r0, r1)
            r6.printStackTrace()
            com.amap.api.col.p0003l.dx.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.l.h(int):void");
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setCustomMapStyle(boolean z10, byte[] bArr) {
        a(z10, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z10) {
        if (z10) {
            o();
        }
        setMapCustomEnable(z10, false);
    }

    private boolean a(int i10, int i11) {
        AbstractCameraUpdateMessage a10;
        if (!this.aw || ((int) c()) >= this.f6737b.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (!this.I && !this.f6766z.isZoomInByScreenCenter()) {
                Point point = this.f6751k;
                point.x = i10;
                point.y = i11;
                a10 = al.a(1.0f, point);
            } else {
                a10 = al.a(1.0f, (Point) null);
            }
            animateCamera(a10);
        } catch (Throwable th) {
            gy.b(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    public final void c(final int i10, final boolean z10) {
        if (this.aw && this.ax) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.18
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (z10) {
                            l.this.f6746f.setBuildingTextureEnable(i10, true);
                        } else {
                            l.this.f6746f.setBuildingTextureEnable(i10, false);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } else {
            a aVar = this.aX;
            aVar.f6847c = z10;
            aVar.f6846b = true;
            aVar.f6850f = i10;
        }
    }

    private void d(int i10) {
        f(i10);
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    private void b(boolean z10) {
        this.at = z10;
    }

    public final void b() {
        this.f6750j.obtainMessage(17, 1, 0).sendToTarget();
    }

    private void b(final int i10) {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.13
            @Override // java.lang.Runnable
            public final void run() {
                GLMapEngine gLMapEngine;
                if (!l.this.aw || (gLMapEngine = l.this.f6746f) == null) {
                    return;
                }
                gLMapEngine.setHighlightSubwayEnable(i10, false);
            }
        });
    }

    public final void b(final int i10, final boolean z10) {
        if (this.aw && this.ax) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.17
                @Override // java.lang.Runnable
                public final void run() {
                    GLMapEngine gLMapEngine = l.this.f6746f;
                    if (gLMapEngine != null) {
                        if (z10) {
                            gLMapEngine.setAllContentEnable(i10, true);
                        } else {
                            gLMapEngine.setAllContentEnable(i10, false);
                        }
                        l.this.f6746f.setSimple3DEnable(i10, false);
                    }
                }
            });
        } else {
            a aVar = this.aU;
            aVar.f6847c = z10;
            aVar.f6846b = true;
            aVar.f6850f = i10;
        }
    }

    private boolean e(MotionEvent motionEvent) throws RemoteException {
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
        obtain.recycle();
        boolean z10 = true;
        BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.D.set2Top(marker.getId());
                List a10 = this.f6761u.a(AMap.OnMarkerClickListener.class.hashCode());
                if (a10 != null && a10.size() > 0) {
                    synchronized (a10) {
                        if (a10.size() == 1) {
                            boolean onMarkerClick = ((AMap.OnMarkerClickListener) a10.get(0)).onMarkerClick(marker);
                            if (onMarkerClick) {
                                return true;
                            }
                            z10 = onMarkerClick;
                        } else {
                            Iterator iterator2 = a10.iterator2();
                            boolean z11 = false;
                            while (iterator2.hasNext()) {
                                z11 |= ((AMap.OnMarkerClickListener) iterator2.next()).onMarkerClick(marker);
                            }
                            if (z11) {
                                return true;
                            }
                            z10 = z11;
                        }
                    }
                }
                this.D.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint obtain2 = IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(al.a(obtain2));
                }
                return z10;
            } catch (Throwable th) {
                gy.b(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    private void f(final int i10) {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.15
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l.this.f6746f.clearAllMessages(i10);
                    l.this.f6746f.clearAnimations(i10, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void a(MotionEvent motionEvent) throws RemoteException {
        if (!this.M || this.O == null) {
            return;
        }
        int x10 = (int) motionEvent.getX();
        int y10 = (int) (motionEvent.getY() - 60.0f);
        if (this.O.getPosition() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x10, y10, obtain);
            LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
            obtain.recycle();
            this.O.setPosition(latLng);
            try {
                List a10 = this.f6761u.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a10 == null || a10.size() <= 0) {
                    return;
                }
                synchronized (a10) {
                    for (int i10 = 0; i10 < a10.size(); i10++) {
                        ((AMap.OnMarkerDragListener) a10.get(i10)).onMarkerDrag(this.O);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void b(Size size) {
        a(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        this.C.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        b(true);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.am = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            dx.a(th2);
        }
    }

    private void a(GLMapState gLMapState, int i10, int i11, DPoint dPoint) {
        if (!this.aw || this.f6746f == null) {
            return;
        }
        gLMapState.screenToP20Point(i10, i11, new Point());
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(r0.x, r0.y, 20);
        dPoint.f9303x = pixelsToLatLong.f9303x;
        dPoint.f9304y = pixelsToLatLong.f9304y;
        pixelsToLatLong.recycle();
    }

    private void a(int i10, int i11, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.G.get() || !this.aw || (gLMapEngine = this.f6746f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i10, i11, fPoint);
    }

    private void e(int i10) {
        ei eiVar = this.C;
        if (eiVar != null) {
            if (i10 == 0) {
                if (eiVar.b()) {
                    this.C.g(Boolean.FALSE);
                    this.C.c();
                    return;
                }
                return;
            }
            if (eiVar.b()) {
                return;
            }
            this.C.g(Boolean.TRUE);
            this.C.c();
        }
    }

    private void a(final double d10, final double d11) {
        this.f6750j.post(new Runnable() { // from class: com.amap.api.col.3l.l.10
            @Override // java.lang.Runnable
            public final void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) d10;
                obtain.arg2 = (int) d11;
                l.this.f6750j.sendMessage(obtain);
            }
        });
    }

    private void a(int i10) {
        int i11 = this.ai;
        if (i11 != -1) {
            this.an.setRenderFps(i11);
            resetRenderTime();
        } else if (!this.f6746f.isInMapAction(i10) && !this.au) {
            if (this.f6746f.isInMapAnimation(i10)) {
                this.an.setRenderFps(30.0f);
                this.an.resetTickCount(15);
            } else if (this.D.isGLTFAnimated()) {
                this.an.setRenderFps(30.0f);
                this.an.resetTickCount(15);
            } else {
                this.an.setRenderFps(15.0f);
            }
        } else {
            this.an.setRenderFps(40.0f);
        }
        if (this.f6737b.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            b();
            this.f6737b.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    public final synchronized void a(int i10, int i11, int i12) {
        a(i10, i11, i12, false, null);
    }

    private synchronized void a(final int i10, final int i11, final int i12, final boolean z10, final StyleItem[] styleItemArr) {
        if (this.ax && this.aw && this.f6730a) {
            e(i12);
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.14
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l.this.f6746f.setMapModeAndStyle(i10, i11, i12, z10, styleItemArr);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        a aVar = this.aL;
        aVar.f6850f = i10;
        aVar.f6848d = i11;
        aVar.f6849e = i12;
        aVar.f6846b = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(GL10 gl10, int i10, int i11) {
        try {
            changeSurface(1, gl10, i10, i11);
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
        }
    }

    public final void a(final int i10, final boolean z10) {
        if (this.aw && this.ax) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.col.3l.l.16
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l.this.f6746f.setBuildingEnable(i10, z10);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } else {
            a aVar = this.aN;
            aVar.f6847c = z10;
            aVar.f6846b = true;
            aVar.f6850f = i10;
        }
    }

    private int a(int i10, Rect rect, int i11, int i12) {
        int i13;
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine == null || i10 < 0) {
            i13 = 0;
        } else {
            i13 = gLMapEngine.getEngineIDWithType(i10);
            if (!this.f6746f.isEngineCreated(i13)) {
                int i14 = this.f6745e.getResources().getDisplayMetrics().densityDpi;
                float f10 = this.f6745e.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f10);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = i13;
                mapViewInitParam.f9678x = rect.left;
                mapViewInitParam.f9679y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i11;
                mapViewInitParam.screenHeight = i12;
                mapViewInitParam.screenScale = f10;
                mapViewInitParam.textScale = this.as * f10;
                mapViewInitParam.mapZoomScale = this.f6736ar;
                mapViewInitParam.taskThreadCount = 3;
                this.f6746f.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.f6746f.getMapState(i13);
                mapState.setMapZoomer(this.f6737b.getSZ());
                mapState.setCameraDegree(this.f6737b.getSC());
                mapState.setMapAngle(this.f6737b.getSR());
                mapState.setMapGeoCenter(this.f6737b.getSX(), this.f6737b.getSY());
                this.f6746f.setMapState(i13, mapState);
                this.f6736ar = mapState.calMapZoomScalefactor(i11, i12, i14);
                this.f6746f.setOvelayBundle(i13, new GLOverlayBundle<>(i13, this));
            } else {
                a(i13, rect.left, rect.top, rect.width(), rect.height(), i11, i12);
            }
        }
        this.G.set(false);
        return i13;
    }

    private void a(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        GLMapEngine gLMapEngine = this.f6746f;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i10, i11, i12, i13, i14, i15, i16);
        }
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z10 = this.I;
        abstractCameraUpdateMessage.isUseAnchor = z10;
        if (z10) {
            abstractCameraUpdateMessage.anchorX = this.f6737b.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.f6737b.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.f6737b;
    }

    private static boolean a(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    public final void a(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.f6737b;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.au && this.f6746f.getAnimateionsCount() == 0 && this.f6746f.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.f6762v;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.B.isEnabled()) {
                    try {
                        List a10 = this.f6761u.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (a10 != null && a10.size() != 0) {
                            if (cameraPosition == null) {
                                try {
                                    cameraPosition = getCameraPosition();
                                } catch (Throwable th) {
                                    gy.b(th, "AMapDelegateImp", "cameraChangeFinish");
                                    th.printStackTrace();
                                }
                            }
                            synchronized (a10) {
                                Iterator iterator2 = a10.iterator2();
                                while (iterator2.hasNext()) {
                                    ((AMap.OnCameraChangeListener) iterator2.next()).onCameraChangeFinish(cameraPosition);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    this.f6737b.resetChangedCounter();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            dx.a(th2);
        }
    }

    @Override // com.amap.api.col.3l.k.a
    public final void a() {
        com.autonavi.extra.b bVar = this.aY;
        if (bVar != null) {
            bVar.i();
        }
    }

    private void a(boolean z10, byte[] bArr, boolean z11) {
        da daVar;
        try {
            this.f6737b.setCustomStyleEnable(z10);
            boolean z12 = false;
            if (this.f6737b.isHideLogoEnable()) {
                this.f6766z.setLogoEnable(!z10);
            }
            if (z10) {
                c(this.F, true);
                cz czVar = new cz();
                MyTrafficStyle myTrafficStyle = this.Z;
                if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                    czVar.a(this.Z.getTrafficRoadBackgroundColor());
                }
                if (this.f6737b.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f6737b.getCustomTextureResourcePath())) {
                    z12 = true;
                }
                StyleItem[] styleItemArr = null;
                if (bArr != null) {
                    daVar = czVar.a(bArr, z12);
                    if (daVar != null && (styleItemArr = daVar.c()) != null) {
                        this.f6737b.setUseProFunction(true);
                    }
                } else {
                    daVar = null;
                }
                if (styleItemArr == null && (daVar = czVar.a(this.f6737b.getCustomStylePath(), z12)) != null) {
                    styleItemArr = daVar.c();
                }
                if (czVar.a() != 0) {
                    this.f6737b.setCustomBackgroundColor(czVar.a());
                }
                if (daVar != null && daVar.d() != null) {
                    if (this.al != null) {
                        this.al.a((String) daVar.d());
                        this.al.a(daVar);
                        this.al.b();
                        return;
                    }
                    return;
                }
                a(styleItemArr, z11);
                return;
            }
            c(this.F, false);
            a(this.F, this.f6737b.getMapStyleMode(), this.f6737b.getMapStyleTime());
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // com.amap.api.col.3l.cu.a
    public final void a(String str, da daVar) {
        setCustomTextureResourcePath(str);
        if (!this.f6737b.isCustomStyleEnable() || daVar == null) {
            return;
        }
        a(daVar.c(), false);
    }

    private void a(StyleItem[] styleItemArr, boolean z10) {
        if (z10 || (styleItemArr != null && styleItemArr.length > 0)) {
            a(this.F, 0, 0, true, styleItemArr);
            du.a(this.f6745e, true);
        } else {
            du.a(this.f6745e, false);
        }
    }

    public final Size a(Size size) {
        Size size2 = new Size(getMapWidth(), getMapHeight());
        a(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        this.C.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        b(false);
        return size2;
    }

    private boolean a(boolean z10, boolean z11) {
        if (z10) {
            if (this.f6740bc) {
                dd.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.f6739bb = true;
        }
        if (!z11) {
            return false;
        }
        if (this.f6739bb) {
            dd.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
            return true;
        }
        this.f6740bc = true;
        return false;
    }
}
