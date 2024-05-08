package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IProjection {
    float calculateMapZoomer(LatLng latLng, int i10);

    TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i10, int i11) throws RemoteException;

    LatLng fromScreenLocation(Point point) throws RemoteException;

    AMapCameraInfo getCameraInfo();

    LatLngBounds getMapBounds(LatLng latLng, float f10) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    float toMapLenWithWin(int i10) throws RemoteException;

    PointF toMapLocation(LatLng latLng) throws RemoteException;

    Point toScreenLocation(LatLng latLng) throws RemoteException;
}
