package com.amap.api.maps;

import android.location.Location;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface LocationSource {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
