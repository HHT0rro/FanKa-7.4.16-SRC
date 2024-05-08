package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BuildingOverlayOptions extends BaseOptions {
    private int[] buildingLatlngsPoints;
    private float zindex;
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private int buildingTopColor = -7829368;
    private int buildingSideColor = -7829368;
    private boolean isVisible = true;
    private List<LatLng> buildingLatlngs = new ArrayList();

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public synchronized int[] getPoints() {
        List<LatLng> list = this.buildingLatlngs;
        if (list == null || list.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[this.buildingLatlngs.size() * 2];
        int i10 = 0;
        for (int i11 = 0; i11 < this.buildingLatlngs.size(); i11++) {
            LatLng latLng = this.buildingLatlngs.get(i11);
            if (latLng != null) {
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i12 = i10 + 1;
                iArr[i10] = latLongToPixels.x;
                i10 = i12 + 1;
                iArr[i12] = latLongToPixels.y;
            }
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i10) {
        this.buildingHeight = i10;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i10) {
        this.buildingHeightScale = i10;
        return this;
    }

    public synchronized BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[list.size() * 2];
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                LatLng latLng = list.get(i11);
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int[] iArr = this.buildingLatlngsPoints;
                int i12 = i10 + 1;
                iArr[i10] = latLongToPixels.x;
                i10 = i12 + 1;
                iArr[i12] = latLongToPixels.y;
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i10) {
        this.buildingSideColor = i10;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i10) {
        this.buildingTopColor = i10;
        return this;
    }

    public void setVisible(boolean z10) {
        this.isVisible = z10;
    }

    public void setZIndex(float f10) {
        this.zindex = f10;
    }
}
