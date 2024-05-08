package com.amap.api.col.p0003l;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AMapOnLocationChangedListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class p implements LocationSource.OnLocationChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public Location f6895a;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f6896b;

    public p(IAMapDelegate iAMapDelegate) {
        this.f6896b = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.f6895a = location;
        try {
            if (this.f6896b.isMyLocationEnabled()) {
                this.f6896b.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            gy.b(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
