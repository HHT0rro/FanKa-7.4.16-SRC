package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ab;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.fm;
import com.amap.api.col.p0003l.fr;
import com.amap.api.col.p0003l.hw;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    private static boolean closeTileOverlay = false;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isContourLineEnable = false;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = true;
    private static int mProtocol = 1;
    private static String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static String mWorldVectorOfflineMapStyleFilePath = "";
    public static String sdcardDir = "";

    public static void disableCachedMapDataUpdate(boolean z10) {
    }

    public static String getDeviceId(Context context) {
        return fm.q(context);
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static String getVersion() {
        return "9.8.3";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            ab.f4885a = context.getApplicationContext();
        }
    }

    public static boolean isContourLineEnable() {
        return isContourLineEnable;
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldVectorMap(boolean z10) {
        isloadWorldVectorMap = z10;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        fk.a(ab.f4885a, str);
    }

    public static void setBuildingHeight(int i10) {
    }

    public static void setContourLIneEnable(boolean z10) {
        isContourLineEnable = z10;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z10) {
        isNeedDownloadCoordinateConvertLibrary = z10;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            hw.f6309a = -1;
            hw.f6310b = "";
        } else {
            hw.f6309a = 1;
            hw.f6310b = str;
        }
    }

    public static void setNetWorkEnable(boolean z10) {
        isNetWorkEnable = z10;
    }

    public static void setPolyline2Enable(boolean z10) {
    }

    public static void setProtocol(int i10) {
        mProtocol = i10;
    }

    public static void setSupportRecycleView(boolean z10) {
        isSupportRecycleView = z10;
    }

    public static void setTerrainEnable(boolean z10) {
        isTerrainEnable = z10;
    }

    public static void setTextureDestroyedRender(boolean z10) {
        isTextureDestroyedRender = z10;
    }

    public static void setTextureSizeChangedInvoked(boolean z10) {
        isTextureSizeChangedInvoked = z10;
    }

    public static void setTextureViewDestorySync(boolean z10) {
        isTextureViewDestorySync = z10;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z10) {
        synchronized (MapsInitializer.class) {
            fr.a(context, z10, dx.a());
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z10, boolean z11) {
        synchronized (MapsInitializer.class) {
            fr.a(context, z10, z11, dx.a());
        }
    }
}
