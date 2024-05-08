package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i10, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    BitmapDescriptor getDefaultTerrainImage();

    List<BitmapDescriptor> getSkyBoxImages();

    InitStorageParam getStorageInitParam();

    TileProviderInner getTerrainTileProvider();

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    void onMapBlandClick(double d10, double d11);

    void onMapPOIClick(MapPoi mapPoi);

    void onMapRender(int i10, int i11);

    void reloadMapResource(int i10, String str, int i11);

    byte[] requireCharBitmap(int i10, int i11, int i12);

    byte[] requireCharsWidths(int i10, int[] iArr, int i11, int i12);

    int requireMapDataAsyn(int i10, byte[] bArr);

    void requireMapRender(int i10, int i11, int i12);

    byte[] requireMapResource(int i10, String str);
}
