package com.amap.api.maps;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class InfoWindowParams {
    public static final int INFOWINDOW_TYPE_IMAGE = 1;
    public static final int INFOWINDOW_TYPE_VIEW = 2;
    private View infoContent;
    private View infoWindow;
    private int infoWindowType = 2;
    private int mInfoWindowUpdateTime;

    public View getInfoContents() {
        return this.infoContent;
    }

    public View getInfoWindow() {
        return this.infoWindow;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }

    public long getInfoWindowUpdateTime() {
        return this.mInfoWindowUpdateTime;
    }

    public void setInfoContent(View view) {
        this.infoContent = view;
    }

    public void setInfoWindow(View view) {
        this.infoWindow = view;
    }

    public void setInfoWindowType(int i10) {
        this.infoWindowType = i10;
    }

    public void setInfoWindowUpdateTime(int i10) {
        this.mInfoWindowUpdateTime = i10;
    }
}
