package com.amap.api.col.p0003l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.baidu.mobads.sdk.internal.a.c;

/* compiled from: MapFragmentDelegateImp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ab implements IMapFragmentDelegate {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Context f4885a;

    /* renamed from: f, reason: collision with root package name */
    private static String f4886f;

    /* renamed from: b, reason: collision with root package name */
    public int f4887b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4888c = true;

    /* renamed from: d, reason: collision with root package name */
    private IAMap f4889d;

    /* renamed from: e, reason: collision with root package name */
    private int f4890e;

    /* renamed from: g, reason: collision with root package name */
    private AMapOptions f4891g;

    public ab(int i10) {
        this.f4890e = 0;
        this.f4890e = i10 % 3;
        b();
    }

    private static void a(Context context) {
        if (context != null) {
            f4885a = context.getApplicationContext();
        }
    }

    private static void b() {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < 80; i10++) {
                sb2.append("=");
            }
            f4886f = sb2.toString();
        } catch (Throwable unused) {
        }
    }

    private static void c() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final IAMap getMap() throws RemoteException {
        if (this.f4889d == null) {
            if (f4885a == null) {
                return null;
            }
            int i10 = f4885a.getResources().getDisplayMetrics().densityDpi;
            if (i10 <= 120) {
                w.f6962a = 0.5f;
            } else if (i10 <= 160) {
                w.f6962a = 0.8f;
            } else if (i10 <= 240) {
                w.f6962a = 0.87f;
            } else if (i10 <= 320) {
                w.f6962a = 1.0f;
            } else if (i10 <= 480) {
                w.f6962a = 1.5f;
            } else if (i10 <= 640) {
                w.f6962a = 1.8f;
            } else {
                w.f6962a = 0.9f;
            }
            int i11 = this.f4890e;
            if (i11 == 0) {
                this.f4889d = new n(f4885a, this.f4888c).a();
            } else if (i11 == 1) {
                this.f4889d = new o(f4885a, this.f4888c).a();
            } else {
                this.f4889d = new m(f4885a).a();
            }
        }
        return this.f4889d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void loadWorldVectorMap(boolean z10) {
        this.f4888c = z10;
        IAMap iAMap = this.f4889d;
        if (iAMap != null) {
            iAMap.loadWorldVectorMap(z10);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onCreate(Bundle bundle) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        if (f4885a == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            IAMap map = getMap();
            this.f4889d = map;
            map.setVisibilityEx(this.f4887b);
            if (this.f4891g == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f4891g = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            a(this.f4891g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f4889d.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroy() throws RemoteException {
        a();
        IAMap iAMap = this.f4889d;
        if (iAMap != null) {
            iAMap.clear();
            this.f4889d.destroy();
            this.f4889d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onDestroyView() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.f4891g = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onLowMemory() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onPause() throws RemoteException {
        IAMap iAMap = this.f4889d;
        if (iAMap != null) {
            iAMap.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onResume() throws RemoteException {
        IAMap iAMap = this.f4889d;
        if (iAMap != null) {
            iAMap.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.f4889d != null) {
            if (this.f4891g == null) {
                this.f4891g = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                AMapOptions camera = this.f4891g.camera(getMap().getCameraPosition());
                this.f4891g = camera;
                camera.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setContext(Context context) {
        a(context);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setOptions(AMapOptions aMapOptions) {
        this.f4891g = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public final void setVisibility(int i10) {
        this.f4887b = i10;
        IAMap iAMap = this.f4889d;
        if (iAMap != null) {
            iAMap.setVisibilityEx(i10);
        }
    }

    private void a(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f4889d == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f4889d.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f4889d.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f4889d.setMapType(aMapOptions.getMapType());
        this.f4889d.setZOrderOnTop(aMapOptions.getZOrderOnTop());
    }

    private static void a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            for (int i10 = 0; i10 < stackTrace.length; i10++) {
                if (stackTrace[i10].getClassName() != null && stackTrace[i10].getClassName().endsWith("TextureMapView")) {
                    z11 = true;
                }
                if (stackTrace[i10].getClassName() != null && stackTrace[i10].getClassName().endsWith(c.f9724e)) {
                    z10 = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i10].getMethodName())) {
                    z12 = true;
                }
            }
            if (z10 && z11 && !z12) {
                c();
            }
        } catch (Throwable unused) {
        }
    }
}
