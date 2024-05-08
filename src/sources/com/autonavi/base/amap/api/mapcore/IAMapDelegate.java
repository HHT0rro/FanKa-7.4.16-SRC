package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.p0003l.av;
import com.amap.api.col.p0003l.k;
import com.amap.api.maps.AMap;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.extra.b;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IAMapDelegate extends IAMap {
    void addGestureMapMessage(int i10, AbstractGestureMapMessage abstractGestureMapMessage);

    void addOverlayTexture(int i10, GLTextureProperty gLTextureProperty);

    void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j10, AMap.CancelableCallback cancelableCallback);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(String str, boolean z10, int i10);

    void changeMapLogo(int i10, boolean z10);

    void changeSize(int i10, int i11);

    void changeSurface(int i10, GL10 gl10, int i11, int i12);

    float checkZoomLevel(float f10) throws RemoteException;

    void clearTileCache();

    String createId(String str);

    int createOverlayTexture(int i10, Bitmap bitmap);

    void createSurface(int i10, GL10 gl10, EGLConfig eGLConfig);

    void geo2Latlng(int i10, int i11, DPoint dPoint);

    void geo2Map(int i10, int i11, FPoint fPoint);

    b getAMapExtraInterfaceManager();

    float getCameraDegree(int i10);

    CameraPosition getCameraPositionPrj(boolean z10);

    Context getContext();

    k getCustomStyleManager();

    int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    float[] getFinalMatrix();

    GLMapEngine getGLMapEngine();

    View getGLMapView();

    void getGeoCenter(int i10, IPoint iPoint);

    IGlOverlayLayer getGlOverlayLayer();

    av getInfoWindowDelegate();

    void getLatLng2Map(double d10, double d11, FPoint fPoint);

    void getLatLng2Pixel(double d10, double d11, IPoint iPoint);

    float getLogoMarginRate(int i10);

    int getLogoPosition();

    float getMapAngle(int i10);

    LatLngBounds getMapBounds(LatLng latLng, float f10, float f11, float f12);

    MapConfig getMapConfig();

    GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    void getPixel2Geo(int i10, int i11, IPoint iPoint);

    void getPixel2LatLng(int i10, int i11, DPoint dPoint);

    float getPreciseLevel(int i10);

    IProjectionDelegate getProjection() throws RemoteException;

    Rect getRect();

    IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int i10);

    Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int i10);

    boolean isLockMapCameraDegree(int i10);

    boolean isUseAnchor();

    void latlon2Geo(double d10, double d11, IPoint iPoint);

    void map2Geo(float f10, float f11, IPoint iPoint);

    void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    boolean onDoubleTap(int i10, MotionEvent motionEvent);

    void onLongPress(int i10, MotionEvent motionEvent);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int i10, MotionEvent motionEvent);

    void pixel2Map(int i10, int i11, PointF pointF);

    void post(Runnable runnable);

    void redrawInfoWindow();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay);

    boolean removeGLModel(String str);

    boolean removeGLOverlay(String str) throws RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean z10, byte[] bArr);

    void setGestureStatus(int i10, int i11);

    void setHideLogoEnble(boolean z10);

    void setLogoBottomMargin(int i10);

    void setLogoLeftMargin(int i10);

    void setLogoMarginRate(int i10, float f10);

    void setLogoPosition(int i10);

    void setMapCustomEnable(boolean z10, boolean z11);

    void setMapEnable(boolean z10);

    void setMapWidgetListener(AMapWidgetListener aMapWidgetListener);

    void setTerrainAuth(boolean z10);

    void setZoomPosition(int i10);

    void showCompassEnabled(boolean z10);

    void showIndoorSwitchControlsEnabled(boolean z10);

    void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;

    void showLogoEnabled(boolean z10);

    void showMyLocationButtonEnabled(boolean z10);

    void showMyLocationOverlay(Location location) throws RemoteException;

    void showScaleEnabled(boolean z10);

    void showZoomControlsEnabled(boolean z10);

    float toMapLenWithWin(int i10);

    void zoomOut(int i10);
}
