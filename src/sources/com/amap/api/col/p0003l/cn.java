package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* compiled from: NativePopupOverlay.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cn implements IInfoWindowManager, IInfoWindowAction {

    /* renamed from: a, reason: collision with root package name */
    public av f5218a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f5219b;

    /* renamed from: c, reason: collision with root package name */
    private final IGlOverlayLayer f5220c;

    /* renamed from: d, reason: collision with root package name */
    private final String f5221d = "PopupOverlay";

    public cn(IGlOverlayLayer iGlOverlayLayer, Context context) {
        this.f5219b = context;
        this.f5220c = iGlOverlayLayer;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void hideInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f5220c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "hideInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        IGlOverlayLayer iGlOverlayLayer = this.f5220c;
        if (iGlOverlayLayer != null && motionEvent != null) {
            Object nativeProperties = iGlOverlayLayer.getNativeProperties("PopupOverlay", "onInfoWindowTap", new Object[]{Double.valueOf(motionEvent.getX()), Double.valueOf(motionEvent.getY())});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        IGlOverlayLayer iGlOverlayLayer = this.f5220c;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.getNativeProperties("PopupOverlay", "redrawInfoWindow", null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(av avVar) {
        synchronized (this) {
            this.f5218a = avVar;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowAppearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackColor(int i10) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackEnable(boolean z10) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowBackScale(float f10, float f11) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowDisappearAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(BasePointOverlay basePointOverlay) throws RemoteException {
        IGlOverlayLayer iGlOverlayLayer = this.f5220c;
        if (iGlOverlayLayer != null && basePointOverlay != null) {
            iGlOverlayLayer.getNativeProperties(basePointOverlay.getId(), "showInfoWindow", new Object[]{basePointOverlay.getId()});
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public final void startAnimation() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
    }
}
