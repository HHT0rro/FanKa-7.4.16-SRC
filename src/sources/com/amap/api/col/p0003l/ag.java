package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UiSettingsDelegateImp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ag implements IUiSettingsDelegate {

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f4914b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4915c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4916d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4917e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4918f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4919g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4920h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4921i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4922j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4923k = true;

    /* renamed from: l, reason: collision with root package name */
    private int f4924l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f4925m = 1;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4926n = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4927o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4928p = false;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f4913a = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.col.3l.ag.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null || ag.this.f4914b == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                        ag.this.f4914b.showZoomControlsEnabled(ag.this.f4920h);
                        return;
                    case 1:
                        ag.this.f4914b.showScaleEnabled(ag.this.f4922j);
                        return;
                    case 2:
                        ag.this.f4914b.showCompassEnabled(ag.this.f4921i);
                        return;
                    case 3:
                        ag.this.f4914b.showMyLocationButtonEnabled(ag.this.f4918f);
                        return;
                    case 4:
                        ag.this.f4914b.showIndoorSwitchControlsEnabled(ag.this.f4926n);
                        return;
                    case 5:
                        ag.this.f4914b.showLogoEnabled(ag.this.f4923k);
                        return;
                    case 6:
                        ag.this.f4914b.refreshLogo();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                gy.b(th, "UiSettingsDelegateImp", "handleMessage");
            }
        }
    };

    public ag(IAMapDelegate iAMapDelegate) {
        this.f4914b = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final float getLogoMarginRate(int i10) {
        return this.f4914b.getLogoMarginRate(i10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getLogoPosition() throws RemoteException {
        return this.f4924l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final int getZoomPosition() throws RemoteException {
        return this.f4925m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isCompassEnabled() throws RemoteException {
        return this.f4921i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.f4928p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.f4926n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isLogoEnable() {
        return this.f4923k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f4918f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.f4915c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.f4922j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.f4916d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.f4917e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.f4920h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.f4919g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final boolean isZoomInByScreenCenter() {
        return this.f4927o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void requestRefreshLogo() {
        this.f4913a.obtainMessage(6).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setAllGesturesEnabled(boolean z10) throws RemoteException {
        setRotateGesturesEnabled(z10);
        setTiltGesturesEnabled(z10);
        setZoomGesturesEnabled(z10);
        setScrollGesturesEnabled(z10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setCompassEnabled(boolean z10) throws RemoteException {
        this.f4921i = z10;
        this.f4913a.obtainMessage(2).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setGestureScaleByMapCenter(boolean z10) throws RemoteException {
        this.f4928p = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setIndoorSwitchEnabled(boolean z10) throws RemoteException {
        this.f4926n = z10;
        this.f4913a.obtainMessage(4).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoBottomMargin(int i10) {
        this.f4914b.setLogoBottomMargin(i10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoEnable(boolean z10) {
        this.f4923k = z10;
        this.f4913a.obtainMessage(5).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoLeftMargin(int i10) {
        this.f4914b.setLogoLeftMargin(i10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoMarginRate(int i10, float f10) {
        this.f4914b.setLogoMarginRate(i10, f10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setLogoPosition(int i10) throws RemoteException {
        this.f4924l = i10;
        this.f4914b.setLogoPosition(i10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setMyLocationButtonEnabled(boolean z10) throws RemoteException {
        this.f4918f = z10;
        this.f4913a.obtainMessage(3).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setRotateGesturesEnabled(boolean z10) throws RemoteException {
        this.f4915c = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScaleControlsEnabled(boolean z10) throws RemoteException {
        this.f4922j = z10;
        this.f4913a.obtainMessage(1).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setScrollGesturesEnabled(boolean z10) throws RemoteException {
        this.f4916d = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setTiltGesturesEnabled(boolean z10) throws RemoteException {
        this.f4917e = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomControlsEnabled(boolean z10) throws RemoteException {
        this.f4920h = z10;
        this.f4913a.obtainMessage(0).sendToTarget();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomGesturesEnabled(boolean z10) throws RemoteException {
        this.f4919g = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomInByScreenCenter(boolean z10) {
        this.f4927o = z10;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IUiSettings
    public final void setZoomPosition(int i10) throws RemoteException {
        this.f4925m = i10;
        this.f4914b.setZoomPosition(i10);
    }
}
