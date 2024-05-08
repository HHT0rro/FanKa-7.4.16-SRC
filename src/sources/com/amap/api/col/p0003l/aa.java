package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.ImageOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.AMapAppResourceItem;
import com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: GlOverlayLayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aa implements IGlOverlayLayer, AMapNativeGlOverlayLayer.NativeFunCallListener {

    /* renamed from: a, reason: collision with root package name */
    public IAMapDelegate f4866a;

    /* renamed from: d, reason: collision with root package name */
    private Context f4869d;

    /* renamed from: i, reason: collision with root package name */
    private cm f4874i;

    /* renamed from: e, reason: collision with root package name */
    private int f4870e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final Object f4871f = new Object();

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, BaseOverlay> f4873h = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private BitmapDescriptor f4875j = null;

    /* renamed from: k, reason: collision with root package name */
    private BitmapDescriptor f4876k = null;

    /* renamed from: l, reason: collision with root package name */
    private BitmapDescriptor f4877l = null;

    /* renamed from: m, reason: collision with root package name */
    private BitmapDescriptor f4878m = null;

    /* renamed from: n, reason: collision with root package name */
    private BitmapDescriptor f4879n = null;

    /* renamed from: o, reason: collision with root package name */
    private BitmapDescriptor f4880o = null;

    /* renamed from: p, reason: collision with root package name */
    private BitmapDescriptor f4881p = null;

    /* renamed from: q, reason: collision with root package name */
    private BitmapDescriptor f4882q = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4867b = false;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f4868c = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private AMapNativeGlOverlayLayer f4872g = new AMapNativeGlOverlayLayer();

    public aa(IAMapDelegate iAMapDelegate, Context context) {
        this.f4866a = iAMapDelegate;
        this.f4869d = context;
        this.f4874i = new cm(iAMapDelegate);
    }

    private void a(String str, BaseOptions baseOptions) {
        try {
            this.f4872g.createOverlay(str, baseOptions);
        } catch (Throwable th) {
            gy.b(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            new StringBuilder("GlOverlayLayer addOverlay error:").append(th.getMessage());
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        if (latLng != null && circleOptions != null) {
            try {
                synchronized (circleOptions) {
                    List<BaseHoleOptions> holeOptions = circleOptions.getHoleOptions();
                    if (holeOptions != null && holeOptions.size() > 0) {
                        Iterator<BaseHoleOptions> iterator2 = holeOptions.iterator2();
                        while (iterator2.hasNext()) {
                            if (dx.a(iterator2.next(), latLng)) {
                                return false;
                            }
                        }
                    }
                    return circleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleOptions.getCenter(), latLng));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        try {
            List<BaseHoleOptions> holeOptions = polygonOptions.getHoleOptions();
            if (holeOptions != null && holeOptions.size() > 0) {
                Iterator<BaseHoleOptions> iterator2 = holeOptions.iterator2();
                while (iterator2.hasNext()) {
                    if (dx.a(iterator2.next(), latLng)) {
                        return false;
                    }
                }
            }
            return dx.a(latLng, polygonOptions.getPoints());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        a(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void changeOverlayIndex() {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean checkInBounds(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "checkInBounds", new Object[]{str});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return true;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void clear(String... strArr) {
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
            if (aMapNativeGlOverlayLayer != null && strArr != null) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.f4873h) {
                if (strArr != null) {
                    Iterator<Map.Entry<String, BaseOverlay>> iterator2 = this.f4873h.entrySet().iterator2();
                    while (iterator2.hasNext()) {
                        Map.Entry<String, BaseOverlay> next = iterator2.next();
                        int length = strArr.length;
                        boolean z10 = false;
                        int i10 = 0;
                        while (true) {
                            if (i10 < length) {
                                String str = strArr[i10];
                                if (str != null && str.equals(next.getKey())) {
                                    z10 = true;
                                    break;
                                }
                                i10++;
                            } else {
                                break;
                            }
                        }
                        if (!z10) {
                            iterator2.remove();
                        }
                    }
                } else {
                    this.f4873h.clear();
                }
            }
        } catch (Throwable th) {
            gy.b(th, "GlOverlayLayer", "clear");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearOverlayByType(String str) {
        synchronized (this.f4873h) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, BaseOverlay>> iterator2 = this.f4873h.entrySet().iterator2();
            while (iterator2.hasNext()) {
                String key = iterator2.next().getKey();
                if (key.contains(str)) {
                    iterator2.remove();
                    arrayList.add(key);
                }
            }
            Iterator<E> iterator22 = arrayList.iterator2();
            while (iterator22.hasNext()) {
                removeOverlay((String) iterator22.next());
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearTileCache() {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final String createId(String str) {
        String str2;
        synchronized (this.f4871f) {
            this.f4870e++;
            str2 = str + this.f4870e;
        }
        return str2;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void destroy() {
        try {
            if (this.f4872g == null) {
                return;
            }
            synchronized (this.f4873h) {
                this.f4873h.clear();
            }
            this.f4872g.clear("");
            this.f4872g.destroy();
            this.f4872g = null;
        } catch (Throwable th) {
            gy.b(th, "GlOverlayLayer", LandingPageUtHelper.XAD_UT_LP_DESTROY);
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized boolean draw(int i10, int i11, boolean z10) {
        boolean z11 = false;
        try {
            cm cmVar = this.f4874i;
            if (cmVar != null) {
                cmVar.a();
            }
        } finally {
            return z11;
        }
        if (this.f4866a.getMapConfig() == null) {
            return false;
        }
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.render(i10, i11, z10);
        }
        z11 = true;
        return z11;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void getAMapResource(final AMapAppRequestParam aMapAppRequestParam) {
        dv.a().a(new je() { // from class: com.amap.api.col.3l.aa.1
            @Override // com.amap.api.col.p0003l.je
            public final void runTask() {
                try {
                    byte[] makeHttpRequestWithInterrupted = new AMap3DModelTileProvider.AMap3DModelRequest(aMapAppRequestParam.getUrl()).makeHttpRequestWithInterrupted();
                    AMapAppResourceItem aMapAppResourceItem = new AMapAppResourceItem();
                    aMapAppResourceItem.setData(makeHttpRequestWithInterrupted);
                    aMapAppResourceItem.setSize(makeHttpRequestWithInterrupted.length);
                    aMapAppResourceItem.setResourceType(aMapAppRequestParam.getResourceType());
                    aMapAppRequestParam.getCallback().callSuccess(aMapAppResourceItem);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    aMapAppRequestParam.getCallback().callFailed(e2.getMessage());
                }
            }
        });
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getBuildInImageData(int i10) {
        try {
            switch (i10) {
                case 0:
                    BitmapDescriptor bitmapDescriptor = this.f4875j;
                    if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                        this.f4875j = BitmapDescriptorFactory.fromBitmap(dx.a(this.f4869d, "amap_sdk_lineTexture.png"));
                    }
                    return this.f4875j;
                case 1:
                    BitmapDescriptor bitmapDescriptor2 = this.f4878m;
                    if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                        this.f4878m = BitmapDescriptorFactory.fromBitmap(dx.a(this.f4869d, "amap_sdk_lineTexture.png"));
                    }
                    return this.f4878m;
                case 2:
                    BitmapDescriptor bitmapDescriptor3 = this.f4877l;
                    if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                        this.f4877l = BitmapDescriptorFactory.fromBitmap(dx.a(this.f4869d, "amap_sdk_lineDashTexture_circle.png"));
                    }
                    return this.f4877l;
                case 3:
                    BitmapDescriptor bitmapDescriptor4 = this.f4876k;
                    if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                        this.f4876k = BitmapDescriptorFactory.fromBitmap(dx.a(this.f4869d, "amap_sdk_lineDashTexture_square.png"));
                    }
                    return this.f4876k;
                case 4:
                    BitmapDescriptor bitmapDescriptor5 = this.f4879n;
                    if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                        this.f4879n = BitmapDescriptorFactory.defaultMarker();
                    }
                    return this.f4879n;
                case 5:
                    BitmapDescriptor bitmapDescriptor6 = this.f4880o;
                    if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                        this.f4880o = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                    }
                    return this.f4880o;
                case 6:
                    BitmapDescriptor bitmapDescriptor7 = this.f4881p;
                    if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                        this.f4881p = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                    }
                    return this.f4881p;
                case 7:
                    BitmapDescriptor bitmapDescriptor8 = this.f4882q;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.f4882q = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.f4882q;
                default:
                    return this.f4875j;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final int getCurrentParticleNum(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getCustomImageData(ImageOptions imageOptions) {
        if (imageOptions == null) {
            return null;
        }
        if (imageOptions.type == ImageOptions.ShapeType.CIRCLE.value()) {
            if (imageOptions.radius == ShadowDrawableWrapper.COS_45) {
                return null;
            }
            float a10 = dr.a(this.f4869d, (int) r3);
            int i10 = ((int) a10) * 2;
            Bitmap createBitmap = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(createBitmap);
            Path path = new Path();
            path.addCircle(a10, a10, a10, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawColor(imageOptions.color);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
            return BitmapDescriptorFactory.fromBitmap(createBitmap);
        }
        if (imageOptions.type == ImageOptions.ShapeType.TEXT.value()) {
            String str = imageOptions.content;
            int i11 = imageOptions.fontSize;
            if (str.isEmpty()) {
                return null;
            }
            float a11 = dr.a(this.f4869d, i11);
            Paint paint2 = new Paint();
            paint2.setTextSize(a11);
            paint2.setFakeBoldText(true);
            paint2.setColor(imageOptions.color);
            float measureText = paint2.measureText(str);
            Rect rect = new Rect();
            paint2.getTextBounds(str, 0, str.length(), rect);
            Bitmap createBitmap2 = Bitmap.createBitmap((int) measureText, rect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.save();
            canvas2.drawColor(0);
            canvas2.drawText(str, 0.0f, -rect.top, paint2);
            canvas2.restore();
            return BitmapDescriptorFactory.fromBitmap(createBitmap2);
        }
        if (imageOptions.type != ImageOptions.ShapeType.DEFAULT.value()) {
            return null;
        }
        if (imageOptions.radius == ShadowDrawableWrapper.COS_45) {
            return null;
        }
        float a12 = dr.a(this.f4869d, (int) r3);
        int i12 = (int) a12;
        Bitmap createBitmap3 = Bitmap.createBitmap(i12, i12, Bitmap.Config.ARGB_8888);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        Canvas canvas3 = new Canvas(createBitmap3);
        Path path2 = new Path();
        path2.addRect(0.0f, 0.0f, a12, a12, Path.Direction.CW);
        canvas3.clipPath(path2);
        double[] dArr = imageOptions.rgba;
        canvas3.drawColor(Color.argb((float) dArr[3], (float) dArr[0], (float) dArr[1], (float) dArr[2]));
        canvas3.drawBitmap(createBitmap3, 0.0f, 0.0f, paint3);
        return BitmapDescriptorFactory.fromBitmap(createBitmap3);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized BaseOverlay getHitBaseOverlay(LatLng latLng, int i10) {
        BaseOverlay baseOverlay;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer == null) {
            return null;
        }
        String contain = aMapNativeGlOverlayLayer.contain(latLng, i10);
        if (TextUtils.isEmpty(contain)) {
            return null;
        }
        synchronized (this.f4873h) {
            baseOverlay = this.f4873h.get(contain);
        }
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized Polyline getHitOverlay(LatLng latLng, int i10) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            String contain = aMapNativeGlOverlayLayer.contain(latLng, i10);
            if (TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.f4873h) {
                BaseOverlay baseOverlay = this.f4873h.get(contain);
                r1 = baseOverlay instanceof Polyline ? (Polyline) baseOverlay : null;
            }
        }
        return r1;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoContents(String str) {
        av infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f4866a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f4873h.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.b((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindow(String str) {
        av infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f4866a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f4873h.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.a((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindowClick(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final long getInfoWindowUpdateOffsetTime(String str) {
        av infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f4866a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0L;
        }
        BaseOverlay baseOverlay = this.f4873h.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return infoWindowDelegate.c((BasePointOverlay) baseOverlay);
        }
        return 0L;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final IAMapDelegate getMap() {
        return this.f4866a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final List<Marker> getMapScreenMarkers() {
        if (this.f4872g == null) {
            return null;
        }
        this.f4868c.clear();
        this.f4872g.getNativeProperties("", "getMapScreenOverlays", new Object[]{this.f4868c});
        if (this.f4868c.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4868c) {
            if (str != null && str.contains("MARKER")) {
                arrayList.add((Marker) this.f4873h.get(str));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getMarkerInfoWindowOffset(String str, FPoint fPoint) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "getMarkerInfoWindowOffset", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final MultiPointItem getMultiPointItem(LatLng latLng) {
        List<MultiPointItem> items;
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
            if (aMapNativeGlOverlayLayer == null) {
                return null;
            }
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new LatLng[]{latLng});
            if (!(nativeProperties instanceof MultiPointItemHitTest)) {
                return null;
            }
            MultiPointItemHitTest multiPointItemHitTest = (MultiPointItemHitTest) nativeProperties;
            if (multiPointItemHitTest.index == -1) {
                return null;
            }
            BaseOverlay baseOverlay = this.f4873h.get(multiPointItemHitTest.overlayName);
            if (!(baseOverlay instanceof MultiPointOverlay) || (items = ((MultiPointOverlay) baseOverlay).getItems()) == null) {
                return null;
            }
            int size = items.size();
            int i10 = multiPointItemHitTest.index;
            if (size > i10) {
                return items.get(i10);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final Object getNativeProperties(String str, String str2, Object[] objArr) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        List<LatLng> points;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            float f10 = 0.0f;
            int i10 = 0;
            for (int i11 = 0; i11 < points.size(); i11++) {
                try {
                    if (i11 == 0) {
                        f10 = AMapUtils.calculateLineDistance(latLng, points.get(i11));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i11));
                        if (f10 > calculateLineDistance) {
                            i10 = i11;
                            f10 = calculateLineDistance;
                        }
                    }
                } catch (Throwable th) {
                    gy.b(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i10);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f4873h.get(str) instanceof BasePointOverlay) {
            Object nativeProperties = this.f4872g.getNativeProperties(str, "getMarkerScreenPos", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindow(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindowClick(String str) {
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void hideInfoWindow(String str) {
        if (this.f4872g != null) {
            this.f4866a.hideInfoWindow();
            this.f4872g.getNativeProperties(str, "setInfoWindowShown", new Object[]{Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean isGLTFAnimated() {
        boolean z10;
        synchronized (this.f4873h) {
            Iterator<Map.Entry<String, BaseOverlay>> iterator2 = this.f4873h.entrySet().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    z10 = false;
                    break;
                }
                Map.Entry<String, BaseOverlay> next = iterator2.next();
                String key = next.getKey();
                BaseOverlay value = next.getValue();
                if (key.contains("GLTFOVERLAY") && ((GLTFOverlay) value).isAnimated()) {
                    z10 = true;
                    break;
                }
            }
        }
        return z10;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void onCreateAMapInstance() {
        if (this.f4872g == null) {
            this.f4872g = new AMapNativeGlOverlayLayer();
        }
        this.f4872g.setEngineId(this.f4866a.getNativeEngineID());
        this.f4872g.createNative(this.f4866a.getGLMapEngine().getNativeInstance());
        this.f4872g.setNativeFunCallListener(this);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onRedrawInfowindow() {
        IAMapDelegate iAMapDelegate = this.f4866a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onSetRunLowFrame(boolean z10) {
        setRunLowFrame(z10);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str) {
        boolean z10;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z10 = true;
        } else {
            z10 = false;
        }
        synchronized (this.f4873h) {
            this.f4873h.remove(str);
        }
        return z10;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str, boolean z10) {
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void set2Top(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setFlingState(boolean z10) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f4872g;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new Object[]{Boolean.valueOf(z10)});
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setRunLowFrame(boolean z10) {
        IAMapDelegate iAMapDelegate = this.f4866a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z10);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void showInfoWindow(String str) {
        Map<String, BaseOverlay> map;
        if (this.f4872g == null || (map = this.f4873h) == null) {
            return;
        }
        try {
            this.f4866a.showInfoWindow(map.get(str));
            setRunLowFrame(false);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void updateOption(String str, BaseOptions baseOptions) {
        try {
            if (this.f4872g == null) {
                return;
            }
            setRunLowFrame(false);
            this.f4872g.updateOptions(str, baseOptions);
        } catch (Throwable th) {
            gy.b(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }

    private BitmapDescriptor a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f4869d != null) {
            LinearLayout linearLayout = new LinearLayout(this.f4869d);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return BitmapDescriptorFactory.fromBitmap(dx.a(view));
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i10) {
        if (this.f4866a == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f4866a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
        obtain.recycle();
        return getHitBaseOverlay(latLng, i10);
    }

    private void a(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        a(str, baseOptions);
        synchronized (this.f4873h) {
            this.f4873h.put(str, baseOverlay);
        }
    }
}
