package com.amap.api.maps;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.Size;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.col.p0003l.eo;
import com.amap.api.col.p0003l.ep;
import com.amap.api.col.p0003l.l;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BasePointOverlay;
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
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapState;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AMap {
    public static final String CHINESE = "zh_cn";
    private static final String CLASSNAME = "AMap";
    public static final String CUSTOM = "custom";
    public static final String ENGLISH = "en";
    public static final String LOCAL = "local";
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_BUS = 5;
    public static final int MAP_TYPE_NAVI = 4;
    public static final int MAP_TYPE_NAVI_NIGHT = 6;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MASK_LAYER_NONE = -1;
    public static final int MASK_LAYER_UNDER_LINE = 1;
    public static final int MASK_LAYER_UNDER_MARKER = 0;
    public static final String STYLE_CHINESE = "style_zh_cn";
    private final IAMap mapDelegate;
    private MyTrafficStyle myTrafficStyle;
    private Projection projection;
    private UiSettings uiSettings;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface AMapAppResourceRequestListener {
        void onRequest(AMapAppRequestParam aMapAppRequestParam);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface CommonInfoWindowAdapter {
        InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ImageInfoWindowAdapter extends InfoWindowAdapter {
        long getInfoWindowUpdateTime();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface MultiPositionInfoWindowAdapter extends InfoWindowAdapter {
        View getInfoWindowClick(Marker marker);

        View getOverturnInfoWindow(Marker marker);

        View getOverturnInfoWindowClick(Marker marker);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnIndoorBuildingActiveListener {
        void OnIndoorBuilding(IndoorBuildingInfo indoorBuildingInfo);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);

        void onMapScreenShot(Bitmap bitmap, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMapSnapshotListener {
        void onFinish();

        void onMapTile(Rect rect, Bitmap bitmap, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMultiPointClickListener {
        boolean onPointClick(MultiPointItem multiPointItem);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnPOIClickListener {
        void onPOIClick(Poi poi);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private Size f8169b;

        /* renamed from: c, reason: collision with root package name */
        private CameraPosition f8170c;

        /* renamed from: d, reason: collision with root package name */
        private int f8171d;

        private a() {
        }

        public final void a(Size size) {
            this.f8171d = AMap.this.getUiSettings().getLogoPosition();
            AMap.this.getUiSettings().setLogoPosition(2);
            this.f8170c = CameraPosition.builder(AMap.this.getCameraPosition()).build();
            if (AMap.this.mapDelegate instanceof l) {
                this.f8169b = ((l) AMap.this.mapDelegate).a(size);
            }
        }

        public /* synthetic */ a(AMap aMap, byte b4) {
            this();
        }

        public final void a() {
            if (AMap.this.mapDelegate instanceof l) {
                ((l) AMap.this.mapDelegate).b(this.f8169b);
            }
            AMap.this.animateCamera(CameraUpdateFactory.newCameraPosition(this.f8170c));
            AMap.this.getUiSettings().setLogoPosition(this.f8171d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface onMapPrintScreenListener {
        void onMapPrint(Drawable drawable);
    }

    public AMap(IAMap iAMap) {
        this.mapDelegate = iAMap;
    }

    @Deprecated
    public static String getVersion() {
        return "9.8.3";
    }

    public final void accelerateNetworkInChinese(boolean z10) {
        try {
            IAMap iAMap = this.mapDelegate;
            if (iAMap != null) {
                iAMap.accelerateNetworkInChinese(z10);
            }
        } catch (Throwable unused) {
        }
    }

    public final AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) {
        try {
            return this.mapDelegate.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void addAMapAppResourceListener(AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        try {
            this.mapDelegate.addAMapAppResourceListener(aMapAppResourceRequestListener);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final Arc addArc(ArcOptions arcOptions) {
        try {
            return this.mapDelegate.addArc(arcOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final BuildingOverlay addBuildingOverlay() {
        try {
            return this.mapDelegate.addBuildingOverlay();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return this.mapDelegate.addCircle(circleOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ep addContourLineOverlay(eo eoVar) {
        try {
            return this.mapDelegate.addContourLineOverlay(eoVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final CrossOverlay addCrossOverlay(CrossOverlayOptions crossOverlayOptions) {
        try {
            return this.mapDelegate.addCrossVector(crossOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final GL3DModel addGL3DModel(GL3DModelOptions gL3DModelOptions) {
        try {
            return this.mapDelegate.addGLModel(gL3DModelOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) {
        try {
            return this.mapDelegate.addGLTFOverlay(gLTFOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return this.mapDelegate.addGroundOverlay(groundOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapGridLayer(heatMapGridLayerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapLayer(heatMapLayerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) {
        try {
            return this.mapDelegate.addMVTTileOverlay(mVTTileOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return this.mapDelegate.addMarker(markerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z10) {
        try {
            return this.mapDelegate.addMarkers(arrayList, z10);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) {
        try {
            return this.mapDelegate.addMultiPointOverlay(multiPointOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) {
        try {
            return this.mapDelegate.addNavigateArrow(navigateArrowOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.addOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.addOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.addOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.addOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.addOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.addOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.addOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.addOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.addOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.addOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.addOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.addOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            return this.mapDelegate.addParticleOverlay(particleOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return this.mapDelegate.addPolygon(polygonOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return this.mapDelegate.addPolyline(polylineOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final RouteOverlay addRouteOverlay() {
        return this.mapDelegate.addNaviRouteOverlay();
    }

    public final Text addText(TextOptions textOptions) {
        try {
            return this.mapDelegate.addText(textOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return this.mapDelegate.addTileOverlay(tileOverlayOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.animateCamera(cameraUpdate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i10, int i11, int i12, int i13, LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.calculateZoomToSpanLevel(i10, i11, i12, i13, latLng, latLng2);
    }

    public final void clear() {
        try {
            this.mapDelegate.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.mapDelegate.getCameraPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String getCurrentStyle() {
        try {
            IAMap iAMap = this.mapDelegate;
            return iAMap != null ? iAMap.getCurrentWorldVectorMapStyle() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return this.mapDelegate.getInfoWindowAnimationManager();
    }

    public final String getMapContentApprovalNumber() {
        try {
            return this.mapDelegate.getMapContentApprovalNumber();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void getMapPrintScreen(onMapPrintScreenListener onmapprintscreenlistener) {
        this.mapDelegate.getMapPrintScreen(onmapprintscreenlistener);
    }

    public final void getMapRegionSnapshot(LatLng latLng, LatLng latLng2, Size size, final OnMapSnapshotListener onMapSnapshotListener) {
        IAMap iAMap = this.mapDelegate;
        if ((iAMap instanceof l) && ((l) iAMap).getMapConfig().isTerrainEnable()) {
            onMapSnapshotListener.onFinish();
            return;
        }
        b bVar = new b(latLng, latLng2, size);
        final a aVar = new a(this, (byte) 0);
        aVar.a(bVar.c());
        a(bVar, onMapSnapshotListener, new Runnable() { // from class: com.amap.api.maps.AMap.1
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a();
                onMapSnapshotListener.onFinish();
            }
        });
    }

    public final List<Marker> getMapScreenMarkers() {
        try {
            List<Marker> mapScreenMarkers = this.mapDelegate.getMapScreenMarkers();
            return mapScreenMarkers == null ? new ArrayList() : mapScreenMarkers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        this.mapDelegate.getMapScreenShot(onMapScreenShotListener, true);
    }

    public final int getMapTextZIndex() {
        try {
            return this.mapDelegate.getMapTextZIndex();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getMapType() {
        try {
            return this.mapDelegate.getMapType();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    public final float getMaxZoomLevel() {
        return this.mapDelegate.getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return this.mapDelegate.getMinZoomLevel();
    }

    public final Location getMyLocation() {
        try {
            return this.mapDelegate.getMyLocation();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MyLocationStyle getMyLocationStyle() {
        try {
            return this.mapDelegate.getMyLocationStyle();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MyTrafficStyle getMyTrafficStyle() {
        return this.myTrafficStyle;
    }

    public final long getNativeMapController() {
        try {
            return this.mapDelegate.getNativeMapController();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public final int getNativeMapEngineID() {
        try {
            return this.mapDelegate.getNativeEngineID();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final void getP20MapCenter(IPoint iPoint) {
        if (iPoint == null) {
            try {
                iPoint = new IPoint();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        ((Point) iPoint).x = this.mapDelegate.getSX();
        ((Point) iPoint).y = this.mapDelegate.getSY();
    }

    public final Projection getProjection() {
        try {
            if (this.projection == null) {
                this.projection = this.mapDelegate.getAMapProjection();
            }
            return this.projection;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float[] getProjectionMatrix() {
        return this.mapDelegate.getProjectionMatrix();
    }

    public final String getSatelliteImageApprovalNumber() {
        try {
            return this.mapDelegate.getSatelliteImageApprovalNumber();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getScalePerPixel() {
        try {
            return this.mapDelegate.getScalePerPixel();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final String getTerrainApprovalNumber() {
        try {
            return this.mapDelegate.getTerrainApprovalNumber();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.uiSettings == null) {
                this.uiSettings = this.mapDelegate.getAMapUiSettings();
            }
            return this.uiSettings;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float[] getViewMatrix() {
        return this.mapDelegate.getViewMatrix();
    }

    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.getZoomToSpanLevel(latLng, latLng2);
    }

    public final int hideBuildings(List<LatLng> list) {
        try {
            return this.mapDelegate.hideBuildings(list);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.mapDelegate.isMyLocationEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isTouchPoiEnable() {
        try {
            return this.mapDelegate.isTouchPoiEnable();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.mapDelegate.isTrafficEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.moveCamera(cameraUpdate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void reloadMap() {
        this.mapDelegate.reloadMap();
    }

    public final void removeAMapAppResourceListener(AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        try {
            this.mapDelegate.removeAMapAppResourceListener(aMapAppResourceRequestListener);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.removeOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.removeOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.removeOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.removeOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.removeOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.removeOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.removeOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.removeOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.removeOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.removeOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.removeOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.removeOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removecache() {
        try {
            this.mapDelegate.removecache();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void resetMinMaxZoomPreference() {
        this.mapDelegate.resetMinMaxZoomPreference();
    }

    public final void runOnDrawFrame() {
        this.mapDelegate.setRunLowFrame(false);
    }

    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        this.mapDelegate.setAMapGestureListener(aMapGestureListener);
    }

    public final void setCommonInfoWindowAdapter(CommonInfoWindowAdapter commonInfoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(commonInfoWindowAdapter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setConstructingRoadEnable(boolean z10) {
        try {
            this.mapDelegate.setConstructingRoadEnable(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        this.mapDelegate.setCustomMapStyle(customMapStyleOptions);
    }

    public final void setCustomMapStyleID(String str) {
    }

    public final void setCustomMapStylePath(String str) {
    }

    public final void setCustomRenderer(CustomRenderer customRenderer) {
        try {
            this.mapDelegate.setCustomRenderer(customRenderer);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomTextureResourcePath(String str) {
    }

    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) {
        try {
            this.mapDelegate.setIndoorBuildingInfo(indoorBuildingInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(infoWindowAdapter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLoadOfflineData(boolean z10) {
        try {
            this.mapDelegate.setLoadOfflineData(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            this.mapDelegate.setLocationSource(locationSource);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapCustomEnable(boolean z10) {
    }

    public final void setMapLanguage(String str) {
        try {
            this.mapDelegate.setMapLanguage(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.mapDelegate.setMapStatusLimits(latLngBounds);
            moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapTextZIndex(int i10) {
        try {
            this.mapDelegate.setMapTextZIndex(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapType(int i10) {
        try {
            this.mapDelegate.setMapType(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMaskLayerParams(int i10, int i11, int i12, int i13, int i14, long j10) {
        this.mapDelegate.setMaskLayerParams(i10, i11, i12, i13, i14, j10);
    }

    public final void setMaxZoomLevel(float f10) {
        this.mapDelegate.setMaxZoomLevel(f10);
    }

    public final void setMinZoomLevel(float f10) {
        this.mapDelegate.setMinZoomLevel(f10);
    }

    public final void setMyLocationEnabled(boolean z10) {
        try {
            this.mapDelegate.setMyLocationEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationRotateAngle(float f10) {
        try {
            this.mapDelegate.setMyLocationRotateAngle(f10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            this.mapDelegate.setMyLocationStyle(myLocationStyle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationType(int i10) {
        try {
            this.mapDelegate.setMyLocationType(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) {
        try {
            this.myTrafficStyle = myTrafficStyle;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setNaviLabelEnable(boolean z10, int i10, int i11) {
        try {
            this.mapDelegate.setNaviLabelEnable(z10, i10, i11);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.setOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.setOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.setOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.setOnMapClickListener(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.setOnMaploadedListener(onMapLoadedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.setOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.setOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.setOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.setOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        try {
            this.mapDelegate.setOnMultiPointClickListener(onMultiPointClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.setOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.setOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.setOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPointToCenter(int i10, int i11) {
        try {
            this.mapDelegate.setCenterToPixel(i10, i11);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRenderFps(int i10) {
        this.mapDelegate.setRenderFps(i10);
    }

    public final void setRenderMode(int i10) {
        this.mapDelegate.setRenderMode(i10);
    }

    public final void setRoadArrowEnable(boolean z10) {
        try {
            this.mapDelegate.setRoadArrowEnable(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTouchPoiEnable(boolean z10) {
        try {
            this.mapDelegate.setTouchPoiEnable(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficEnabled(boolean z10) {
        try {
            this.mapDelegate.setTrafficEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (bArr == null || myTrafficStyle == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTexture(bArr, myTrafficStyle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTextureData(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setWorldVectorMapStyle(String str) {
        try {
            this.mapDelegate.setWorldVectorMapStyle(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showBuildings(boolean z10) {
        try {
            this.mapDelegate.set3DBuildingEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showHideBuildings(int i10) {
        try {
            this.mapDelegate.showHideBuildings(i10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void showIndoorMap(boolean z10) {
        try {
            this.mapDelegate.setIndoorEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showMapText(boolean z10) {
        try {
            this.mapDelegate.setMapTextEnable(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void stopAnimation() {
        try {
            this.mapDelegate.stopAnimation();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, OnMapSnapshotListener onMapSnapshotListener, final Runnable runnable) {
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(onMapSnapshotListener, bVar, runnable);
        animateCamera(bVar.a(), new CancelableCallback() { // from class: com.amap.api.maps.AMap.3
            @Override // com.amap.api.maps.AMap.CancelableCallback
            public final void onCancel() {
                runnable.run();
            }

            @Override // com.amap.api.maps.AMap.CancelableCallback
            public final void onFinish() {
                anonymousClass2.run();
            }
        });
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.mapDelegate.animateCameraWithCallback(cameraUpdate, cancelableCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void clear(boolean z10) {
        try {
            this.mapDelegate.clear(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removecache(OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.mapDelegate.removecache(onCacheRemoveListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b {

        /* renamed from: b, reason: collision with root package name */
        private SizeF f8173b;

        /* renamed from: c, reason: collision with root package name */
        private RectF f8174c;

        /* renamed from: d, reason: collision with root package name */
        private double f8175d;

        /* renamed from: e, reason: collision with root package name */
        private LatLng f8176e;

        /* renamed from: f, reason: collision with root package name */
        private LatLng f8177f;

        /* renamed from: i, reason: collision with root package name */
        private IPoint f8180i;

        /* renamed from: j, reason: collision with root package name */
        private int f8181j;

        /* renamed from: k, reason: collision with root package name */
        private int f8182k;

        /* renamed from: g, reason: collision with root package name */
        private IPoint f8178g = new IPoint();

        /* renamed from: h, reason: collision with root package name */
        private IPoint f8179h = new IPoint();

        /* renamed from: l, reason: collision with root package name */
        private int f8183l = 0;

        public b(LatLng latLng, LatLng latLng2, Size size) {
            this.f8181j = 0;
            this.f8182k = 0;
            this.f8173b = new SizeF(size.getWidth(), size.getHeight());
            this.f8176e = latLng;
            this.f8177f = latLng2;
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.f8178g);
            GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, this.f8179h);
            this.f8180i = a(ShadowDrawableWrapper.COS_45, this.f8173b.getHeight());
            this.f8181j = ((int) this.f8173b.getWidth()) / 4096;
            if (this.f8173b.getWidth() % 4096.0f > 0.0f) {
                this.f8181j++;
            }
            this.f8182k = ((int) this.f8173b.getHeight()) / 4096;
            if (this.f8173b.getHeight() % 4096.0f > 0.0f) {
                this.f8182k++;
            }
            this.f8174c = new RectF(0.0f, 0.0f, this.f8173b.getWidth() / this.f8181j, this.f8173b.getHeight() / this.f8182k);
            int i10 = ((Point) this.f8179h).y;
            IPoint iPoint = this.f8178g;
            this.f8175d = Math.atan((i10 - ((Point) iPoint).y) / (((Point) r3).x - ((Point) iPoint).x));
        }

        private IPoint a(double d10, double d11) {
            double sin = Math.sin(this.f8175d);
            double cos = Math.cos(this.f8175d);
            double distance = this.f8178g.distance(this.f8179h) / this.f8173b.getWidth();
            double d12 = ((d10 * cos) - (d11 * sin)) * distance;
            IPoint iPoint = this.f8178g;
            return new IPoint((int) (d12 + ((Point) iPoint).x), (int) ((distance * ((cos * d11) + (sin * d10))) + ((Point) iPoint).y));
        }

        private LatLng b(double d10, double d11) {
            IPoint a10 = a(d10, d11);
            DPoint dPoint = new DPoint();
            GLMapState.geo2LonLat(((Point) a10).x, ((Point) a10).y, dPoint);
            return new LatLng(dPoint.f9304y, dPoint.f9303x);
        }

        public final Size c() {
            return new Size((int) this.f8174c.width(), (int) this.f8174c.height());
        }

        public final boolean d() {
            RectF rectF = this.f8174c;
            if (rectF.right + rectF.width() <= this.f8173b.getWidth()) {
                RectF rectF2 = this.f8174c;
                rectF2.offset(rectF2.width(), 0.0f);
            } else {
                RectF rectF3 = this.f8174c;
                if (rectF3.bottom + rectF3.height() > this.f8173b.getHeight()) {
                    return false;
                }
                RectF rectF4 = this.f8174c;
                rectF4.offset(-rectF4.left, rectF4.height());
            }
            this.f8183l++;
            return true;
        }

        public final boolean e() {
            return this.f8183l == (this.f8181j * this.f8182k) - 1;
        }

        private static LatLng a(long j10, long j11) {
            DPoint dPoint = new DPoint();
            GLMapState.geo2LonLat(j10, j11, dPoint);
            return new LatLng(dPoint.f9304y, dPoint.f9303x);
        }

        public final Rect b() {
            RectF rectF = this.f8174c;
            return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }

        public final CameraUpdate a() {
            int i10 = this.f8183l;
            if (i10 == 0) {
                return CameraUpdateFactory.newCameraPosition(new CameraPosition(b(this.f8174c.centerX(), this.f8174c.centerY()), AMap.this.getZoomToSpanLevel(a(0L, ((long) this.f8178g.distance(this.f8179h)) / this.f8181j), a(((long) this.f8180i.distance(this.f8178g)) / this.f8182k, 0L)), 0.0f, (float) ((this.f8175d * 180.0d) / 3.141592653589793d)));
            }
            int i11 = this.f8181j;
            if ((i10 - 1) / i11 < i10 / i11) {
                return CameraUpdateFactory.scrollBy((-this.f8174c.width()) * (this.f8181j - 1), this.f8174c.height());
            }
            return CameraUpdateFactory.scrollBy(this.f8174c.width(), 0.0f);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j10, CancelableCallback cancelableCallback) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        try {
            this.mapDelegate.animateCameraWithDurationAndCallback(cameraUpdate, j10, cancelableCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: com.amap.api.maps.AMap$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnMapSnapshotListener f8153a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f8154b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f8155c;

        public AnonymousClass2(OnMapSnapshotListener onMapSnapshotListener, b bVar, Runnable runnable) {
            this.f8153a = onMapSnapshotListener;
            this.f8154b = bVar;
            this.f8155c = runnable;
        }

        private ViewGroup a() {
            if (!(AMap.this.mapDelegate instanceof l)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) ((l) AMap.this.mapDelegate).getGLMapView().getParent();
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setBackgroundColor(-1);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            int width = viewGroup.getWidth() / 20;
            frameLayout.setPadding(width, width, width, width);
            viewGroup.addView(frameLayout);
            return frameLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final ViewGroup a10 = a();
            a(a10, new Runnable() { // from class: com.amap.api.maps.AMap.2.3
                @Override // java.lang.Runnable
                public final void run() {
                    AMap.this.mapDelegate.getMapScreenShot(new OnMapScreenShotListener() { // from class: com.amap.api.maps.AMap.2.3.1
                        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap) {
                        }

                        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
                        public final void onMapScreenShot(Bitmap bitmap, int i10) {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            AnonymousClass2.this.a(a10, bitmap);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            anonymousClass2.f8153a.onMapTile(anonymousClass2.f8154b.b(), bitmap, i10);
                            if (AnonymousClass2.this.f8154b.d()) {
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                AMap.this.a(anonymousClass22.f8154b, anonymousClass22.f8153a, anonymousClass22.f8155c);
                            } else {
                                AnonymousClass2.this.f8155c.run();
                            }
                        }
                    }, AnonymousClass2.this.f8154b.e());
                }
            });
        }

        private void a(ViewGroup viewGroup, final Runnable runnable) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) (viewGroup2.getWidth() * 0.05d), 0.0f, (float) (viewGroup2.getHeight() * 0.75d));
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setDuration(600L);
            animationSet.setFillAfter(true);
            animationSet.setInterpolator(new DecelerateInterpolator());
            viewGroup.startAnimation(animationSet);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.amap.api.maps.AMap.2.1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    runnable.run();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }
            });
        }

        public final void a(final ViewGroup viewGroup, Bitmap bitmap) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 0.2f, 0.2f, 0.2f);
            TranslateAnimation translateAnimation = new TranslateAnimation((float) (viewGroup.getWidth() * 0.05d), -((float) (viewGroup.getWidth() * 0.5d)), (float) (viewGroup.getHeight() * 0.75d), (float) (viewGroup.getHeight() * 0.75d));
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setStartOffset(1500L);
            animationSet.setDuration(200L);
            animationSet.setFillBefore(true);
            animationSet.setFillAfter(true);
            animationSet.setInterpolator(new AccelerateInterpolator());
            viewGroup.startAnimation(animationSet);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.amap.api.maps.AMap.2.2
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amap.api.maps.AMap.2.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }
            });
        }
    }
}
