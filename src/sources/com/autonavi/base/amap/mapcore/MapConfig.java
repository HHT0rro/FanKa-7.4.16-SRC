package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.concurrent.atomic.AtomicInteger;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MapConfig implements IMapConfig, Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private String customTextureResourcePath;
    private boolean isSetLimitZoomLevel;
    public MapConfig lastMapconfig;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;

    @JBindingInclude
    private int mapHeight;

    @JBindingInclude
    private float mapPerPixelUnitLength;

    @JBindingInclude
    private int mapWidth;
    private float skyHeight;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    private FPoint[] mapRect = null;

    @JBindingInclude
    private Rectangle geoRectangle = new Rectangle();
    private boolean isIndoorEnable = false;
    private boolean isBuildingEnable = true;
    private boolean isMapTextEnable = true;
    private boolean isTrafficEnabled = false;
    private boolean isCustomStyleEnabled = false;

    @JBindingInclude
    private double sX = 2.21010267E8d;

    @JBindingInclude
    private double sY = 1.01697799E8d;
    private DPoint mapGeoCenter = new DPoint(this.sX, this.sY);

    @JBindingInclude
    private float sZ = 10.0f;

    @JBindingInclude
    private float sC = 0.0f;

    @JBindingInclude
    private float sR = 0.0f;
    private boolean isCenterChanged = false;
    private boolean isZoomChanged = false;
    private boolean isTiltChanged = false;
    private boolean isBearingChanged = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private int mMapStyleMode = 0;
    private int mMapStyleTime = 0;
    private int anchorX = 0;
    private String mMapLanguage = "zh_cn";
    private boolean isHideLogoEnable = false;
    private boolean isWorldMapEnable = false;
    private boolean isTouchPoiEnable = true;
    private int abroadState = 1;
    private boolean isAbroadEnable = false;
    private boolean isTerrainEnable = false;

    @JBindingInclude
    public float[] viewMatrix = new float[16];

    @JBindingInclude
    public float[] projectionMatrix = new float[16];

    @JBindingInclude
    public float[] mvpMatrix = new float[16];

    @JBindingInclude
    private int[] tilsIDs = new int[100];
    private boolean mapEnable = true;
    private int anchorY = 0;
    private boolean isProFunctionAuthEnable = true;
    private boolean isUseProFunction = false;
    private int customBackgroundColor = -1;
    private float mapZoomScale = 1.0f;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private volatile double changeRatio = 1.0d;
    private volatile double changeGridRatio = 1.0d;
    private int gridX = 0;
    private int gridY = 0;

    public MapConfig(boolean z10) {
        this.lastMapconfig = null;
        if (z10) {
            MapConfig mapConfig = new MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(ShadowDrawableWrapper.COS_45);
            this.lastMapconfig.setSY(ShadowDrawableWrapper.COS_45);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc2 = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.sX - sx) + Math.abs(this.sY - sy);
        this.changeRatio = this.changeRatio == ShadowDrawableWrapper.COS_45 ? 1.0d : this.changeRatio * 2.0d;
        this.changeRatio = this.changeRatio * (sz == this.sZ ? 1.0d : Math.abs(sz - r11));
        float f10 = this.sC;
        float abs = sc2 == f10 ? 1.0f : Math.abs(sc2 - f10);
        float f11 = this.sR;
        float abs2 = sr != f11 ? Math.abs(sr - f11) : 1.0f;
        double d10 = abs;
        this.changeRatio *= d10;
        double d11 = abs2;
        this.changeRatio *= d11;
        this.changeGridRatio = Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY);
        this.changeGridRatio = this.changeGridRatio != ShadowDrawableWrapper.COS_45 ? this.changeGridRatio * 2.0d : 1.0d;
        this.changeGridRatio *= d10;
        this.changeGridRatio *= d11;
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAbroadState() {
        return this.abroadState;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorX() {
        return this.anchorX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    public int getGridX() {
        return this.gridX;
    }

    public int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public int getMapWidth() {
        return this.mapWidth;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSX() {
        return this.sX;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public double getSY() {
        return this.sY;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapStateChange() {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig == null) {
            return false;
        }
        double sx = mapConfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc2 = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        double d10 = this.sX;
        boolean z10 = true;
        boolean z11 = sx != d10;
        this.isCenterChanged = z11;
        double d11 = this.sY;
        if (sy != d11) {
            z11 = true;
        }
        this.isCenterChanged = z11;
        float f10 = this.sZ;
        boolean z12 = sz != f10;
        this.isZoomChanged = z12;
        if (z12) {
            float f11 = this.minZoomLevel;
            if (sz > f11 && f10 > f11) {
                float f12 = this.maxZoomLevel;
                if (sz < f12 && f10 < f12) {
                    this.isNeedUpdateZoomControllerState = false;
                }
            }
            this.isNeedUpdateZoomControllerState = true;
        }
        boolean z13 = sc2 != this.sC;
        this.isTiltChanged = z13;
        boolean z14 = sr != this.sR;
        this.isBearingChanged = z14;
        if (!z11 && !z12 && !z13 && !z14 && !this.isNeedUpdateMapRectNextFrame) {
            z10 = false;
        }
        if (z10) {
            this.isNeedUpdateMapRectNextFrame = false;
            int i10 = (20 - ((int) f10)) + 8;
            setGridXY(((int) d10) >> i10, ((int) d11) >> i10);
            changeRatio();
        }
        return z10;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadEnable(boolean z10) {
        this.isAbroadEnable = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setAbroadState(int i10) {
        this.abroadState = i10;
    }

    public void setAnchorX(int i10) {
        this.anchorX = i10;
    }

    public void setAnchorY(int i10) {
        this.anchorY = i10;
    }

    public void setBuildingEnable(boolean z10) {
        this.isBuildingEnable = z10;
    }

    public void setCustomBackgroundColor(int i10) {
        this.customBackgroundColor = i10;
    }

    public void setCustomStyleEnable(boolean z10) {
        this.isCustomStyleEnabled = z10;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    public void setGridXY(int i10, int i11) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i10;
        this.gridY = i11;
    }

    public void setHideLogoEnble(boolean z10) {
        this.isHideLogoEnable = z10;
    }

    public void setIndoorEnable(boolean z10) {
        this.isIndoorEnable = z10;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapEnable(boolean z10) {
        this.mapEnable = z10;
    }

    public void setMapHeight(int i10) {
        this.mapHeight = i10;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapStyleMode(int i10) {
        this.mMapStyleMode = i10;
    }

    public void setMapStyleTime(int i10) {
        this.mMapStyleTime = i10;
    }

    public void setMapTextEnable(boolean z10) {
        this.isMapTextEnable = z10;
    }

    public void setMapWidth(int i10) {
        this.mapWidth = i10;
    }

    public void setMapZoomScale(float f10) {
        this.mapZoomScale = f10;
    }

    public void setMaxZoomLevel(float f10) {
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        if (f10 < 3.0f) {
            f10 = 3.0f;
        }
        if (f10 < getMinZoomLevel()) {
            f10 = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f10;
    }

    public void setMinZoomLevel(float f10) {
        if (f10 < 3.0f) {
            f10 = 3.0f;
        }
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        if (f10 > getMaxZoomLevel()) {
            f10 = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f10;
    }

    public void setProFunctionAuthEnable(boolean z10) {
        this.isProFunctionAuthEnable = z10;
    }

    public void setSC(float f10) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f10;
    }

    public void setSR(float f10) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f10;
    }

    public void setSX(double d10) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = d10;
        this.mapGeoCenter.f9303x = d10;
    }

    public void setSY(double d10) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = d10;
        this.mapGeoCenter.f9303x = d10;
    }

    public void setSZ(float f10) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f10;
    }

    public void setSkyHeight(float f10) {
        this.skyHeight = f10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapConfig
    public void setTerrainEnable(boolean z10) {
        this.isTerrainEnable = z10;
    }

    public void setTouchPoiEnable(boolean z10) {
        this.isTouchPoiEnable = z10;
    }

    public void setTrafficEnabled(boolean z10) {
        this.isTrafficEnabled = z10;
    }

    public void setUseProFunction(boolean z10) {
        this.isUseProFunction = z10;
    }

    public void setWorldMapEnable(boolean z10) {
        this.isWorldMapEnable = z10;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z10) {
        this.isNeedUpdateMapRectNextFrame = z10;
    }
}
