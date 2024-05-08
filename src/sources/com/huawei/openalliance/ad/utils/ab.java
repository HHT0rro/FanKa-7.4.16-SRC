package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.ads.gl;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ab {
    private static final long B = 5000;
    private static final String I = "LocationUtils";
    private static final long Z = 30000;
    private FusedLocationProviderClient C;
    public LocationCallback Code;
    private volatile boolean F = false;
    private a S;
    public LocationRequest V;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code();

        void Code(Location location);
    }

    public ab(Context context, final a aVar) {
        if (context == null || aVar == null) {
            return;
        }
        this.S = aVar;
        this.C = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequest = new LocationRequest();
        this.V = locationRequest;
        locationRequest.setPriority(100);
        this.V.setNumUpdates(1);
        this.V.setInterval(5000L);
        this.Code = new LocationCallback() { // from class: com.huawei.openalliance.ad.utils.ab.1
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (locationAvailability != null) {
                    gl.Code("LocationUtils", "loc_tag onLocationResult onLocationAvailability isLocationAvailable: %s", Boolean.valueOf(locationAvailability.isLocationAvailable()));
                }
            }

            public void onLocationResult(LocationResult locationResult) {
                String str;
                gl.Code("LocationUtils", "loc_tag getLocationByKit onLocationResult-callback");
                if (locationResult == null) {
                    str = "loc_tag getLocationByKit onLocationResult-callback is null";
                } else if (aa.Code(locationResult.getLocations())) {
                    str = "loc_tag getLocationByKit onLocationResult-callback getLocations() is wrong";
                } else {
                    Location location = (Location) locationResult.getLocations().get(0);
                    if (location != null) {
                        gl.Code("LocationUtils", "loc_tag getLocationByKit onLocationResult-callback lat = " + bc.Code(String.valueOf(location.getLatitude())) + ", lon = " + bc.Code(String.valueOf(location.getLongitude())));
                        aVar.Code(location);
                        ab.this.F = true;
                    }
                    str = "loc_tag getLocationByKit onLocationResult-callback location is null";
                }
                gl.I("LocationUtils", str);
                aVar.Code();
                ab.this.F = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.F) {
            return;
        }
        try {
            this.C.removeLocationUpdates(this.Code).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.huawei.openalliance.ad.utils.ab.6
                @Override // com.huawei.hmf.tasks.OnSuccessListener
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r22) {
                    gl.Code("LocationUtils", "loc_tag removeLocationUpdates onSuccess");
                    ab.this.F = true;
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.openalliance.ad.utils.ab.5
                @Override // com.huawei.hmf.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    gl.Code("LocationUtils", "loc_tag removeLocationUpdates onFailure:%s", exc.getClass().getSimpleName());
                    ab.this.F = false;
                }
            });
        } catch (Throwable th) {
            gl.I("LocationUtils", "loc_tag removeLocationUpdates encounter exception:" + th.getClass().getSimpleName());
        }
    }

    public void Code() {
        if (this.C == null) {
            return;
        }
        this.F = false;
        this.C.requestLocationUpdates(this.V, this.Code, Looper.getMainLooper()).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.huawei.openalliance.ad.utils.ab.3
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r22) {
                gl.V("LocationUtils", "loc_tag requestLocationUpdates onSuccess");
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.openalliance.ad.utils.ab.2
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                gl.Z("LocationUtils", "loc_tag requestLocationUpdates onFailure");
                ab.this.S.Code();
                ab.this.F = true;
            }
        });
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ab.4
            @Override // java.lang.Runnable
            public void run() {
                if (ab.this.F) {
                    return;
                }
                ab.this.V();
            }
        }, Z);
    }
}
