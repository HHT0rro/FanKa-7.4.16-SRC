package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public UiSettings(IUiSettings iUiSettings) {
        this.uiSettingsDelegate = iUiSettings;
    }

    public final float getLogoMarginRate(int i10) {
        try {
            return this.uiSettingsDelegate.getLogoMarginRate(i10);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int getLogoPosition() {
        try {
            return this.uiSettingsDelegate.getLogoPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getZoomPosition() {
        try {
            return this.uiSettingsDelegate.getZoomPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    public final boolean isCompassEnabled() {
        try {
            return this.uiSettingsDelegate.isCompassEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.isGestureScaleByMapCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isIndoorSwitchEnabled() {
        try {
            return this.uiSettingsDelegate.isIndoorSwitchEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isLogoEnable() {
        try {
            return this.uiSettingsDelegate.isLogoEnable();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.uiSettingsDelegate.isMyLocationButtonEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isRotateGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isScaleControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isScaleControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isScrollGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isTiltGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final void setAllGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setAllGesturesEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCompassEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setCompassEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setGestureScaleByMapCenter(boolean z10) {
        try {
            this.uiSettingsDelegate.setGestureScaleByMapCenter(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setIndoorSwitchEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setIndoorSwitchEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i10) {
        try {
            this.uiSettingsDelegate.setLogoBottomMargin(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoCenter(int i10, int i11) {
    }

    public final void setLogoEnable(boolean z10) {
        try {
            this.uiSettingsDelegate.setLogoEnable(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i10) {
        try {
            this.uiSettingsDelegate.setLogoLeftMargin(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i10, float f10) {
        try {
            this.uiSettingsDelegate.setLogoMarginRate(i10, f10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoPosition(int i10) {
        try {
            this.uiSettingsDelegate.setLogoPosition(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationButtonEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setMyLocationButtonEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setRotateGesturesEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScaleControlsEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setScaleControlsEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScrollGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setScrollGesturesEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTiltGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setTiltGesturesEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomControlsEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setZoomControlsEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.setZoomGesturesEnabled(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomInByScreenCenter(boolean z10) {
        try {
            this.uiSettingsDelegate.setZoomInByScreenCenter(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomPosition(int i10) {
        try {
            this.uiSettingsDelegate.setZoomPosition(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
