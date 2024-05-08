package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IUiSettings {
    float getLogoMarginRate(int i10) throws RemoteException;

    int getLogoPosition() throws RemoteException;

    int getZoomPosition() throws RemoteException;

    boolean isCompassEnabled() throws RemoteException;

    boolean isGestureScaleByMapCenter() throws RemoteException;

    boolean isIndoorSwitchEnabled() throws RemoteException;

    boolean isLogoEnable();

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScaleControlsEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    boolean isZoomInByScreenCenter() throws RemoteException;

    void requestRefreshLogo();

    void setAllGesturesEnabled(boolean z10) throws RemoteException;

    void setCompassEnabled(boolean z10) throws RemoteException;

    void setGestureScaleByMapCenter(boolean z10) throws RemoteException;

    void setIndoorSwitchEnabled(boolean z10) throws RemoteException;

    void setLogoBottomMargin(int i10) throws RemoteException;

    void setLogoEnable(boolean z10);

    void setLogoLeftMargin(int i10) throws RemoteException;

    void setLogoMarginRate(int i10, float f10) throws RemoteException;

    void setLogoPosition(int i10) throws RemoteException;

    void setMyLocationButtonEnabled(boolean z10) throws RemoteException;

    void setRotateGesturesEnabled(boolean z10) throws RemoteException;

    void setScaleControlsEnabled(boolean z10) throws RemoteException;

    void setScrollGesturesEnabled(boolean z10) throws RemoteException;

    void setTiltGesturesEnabled(boolean z10) throws RemoteException;

    void setZoomControlsEnabled(boolean z10) throws RemoteException;

    void setZoomGesturesEnabled(boolean z10) throws RemoteException;

    void setZoomInByScreenCenter(boolean z10) throws RemoteException;

    void setZoomPosition(int i10) throws RemoteException;
}
