package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r {
    private static boolean aPa;
    private static com.kwad.sdk.utils.c.a aPb = new com.kwad.sdk.utils.c.a();

    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
            if (lastKnownLocation == null) {
                aPa = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            aPa = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return null;
        }
    }

    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36122h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                aPa = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            aPa = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return null;
        }
    }

    @Nullable
    public static com.kwad.sdk.utils.c.a bV(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (au.Mh() && au.Mi() != null) {
            aVar2.aSm = au.Mi();
            aVar2.type = 1;
            return aVar2;
        }
        if (!aPa && (((aVar = aPb) == null || aVar.aSm == null) && context != null)) {
            if (!au.Mh() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(64L)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
                        aPb.aSm = a(context, locationManager);
                    }
                    if (aPb == null && locationManager.isProviderEnabled("network")) {
                        aPb.aSm = b(context, locationManager);
                    }
                    if (aPb == null && locationManager.isProviderEnabled("passive")) {
                        aPb.aSm = c(context, locationManager);
                    }
                    com.kwad.sdk.utils.c.a aVar3 = aPb;
                    aVar3.type = 0;
                    return aVar3;
                } catch (Exception e2) {
                    aPa = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            }
            return null;
        }
        return aPb;
    }

    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36122h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                aPa = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            aPa = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return null;
        }
    }
}
