package com.amap.api.col.p0003l;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectionDelegateImp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ad implements IProjectionDelegate {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4893a;

    public ad(IAMapDelegate iAMapDelegate) {
        this.f4893a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float calculateMapZoomer(LatLng latLng, int i10) {
        IAMapDelegate iAMapDelegate = this.f4893a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        MapConfig mapConfig = this.f4893a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        return dx.a(mapProjection, (int) mapConfig.getSX(), (int) mapConfig.getSY(), latLng.latitude, latLng.longitude, i10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i10, int i11) throws RemoteException {
        if (latLngBounds == null || i10 < 0 || i10 > 20 || i11 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.f4893a;
        LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IAMapDelegate iAMapDelegate2 = this.f4893a;
        LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        int i12 = ((Point) obtain).x;
        int i13 = 20 - i10;
        int i14 = (i12 >> i13) / i11;
        int i15 = (((Point) obtain).y >> i13) / i11;
        int i16 = (((Point) obtain2).x >> i13) / i11;
        int i17 = ((Point) obtain2).y;
        int i18 = (i17 >> i13) / i11;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection((i12 - ((i14 << i13) * i11)) >> i13, (i17 - ((i18 << i13) * i11)) >> i13, i14, i16, i18, i15);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f4893a.getPixel2LatLng(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.f9304y, obtain.f9303x);
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final AMapCameraInfo getCameraInfo() {
        return this.f4893a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final LatLngBounds getMapBounds(LatLng latLng, float f10) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.f4893a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f10, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.f4893a.getMapWidth();
        int mapHeight = this.f4893a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float toMapLenWithWin(int i10) {
        if (i10 <= 0) {
            return 0.0f;
        }
        return this.f4893a.toMapLenWithWin(i10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.f4893a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(((PointF) obtain).x, ((PointF) obtain).y);
        obtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.f4893a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(((Point) obtain).x, ((Point) obtain).y);
        obtain.recycle();
        return point;
    }
}
