package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class GnssStatusCompat {
    public static final int CONSTELLATION_BEIDOU = 5;
    public static final int CONSTELLATION_GALILEO = 6;
    public static final int CONSTELLATION_GLONASS = 3;
    public static final int CONSTELLATION_GPS = 1;
    public static final int CONSTELLATION_IRNSS = 7;
    public static final int CONSTELLATION_QZSS = 4;
    public static final int CONSTELLATION_SBAS = 2;
    public static final int CONSTELLATION_UNKNOWN = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class Callback {
        public void onFirstFix(@IntRange(from = 0) int i10) {
        }

        public void onSatelliteStatusChanged(@NonNull GnssStatusCompat gnssStatusCompat) {
        }

        public void onStarted() {
        }

        public void onStopped() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public @interface ConstellationType {
    }

    @NonNull
    @RequiresApi(24)
    public static GnssStatusCompat wrap(@NonNull GnssStatus gnssStatus) {
        return new GnssStatusWrapper(gnssStatus);
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = VirtualEarthProjection.MAX_LONGITUDE)
    public abstract float getAzimuthDegrees(@IntRange(from = 0) int i10);

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 63.0d)
    public abstract float getBasebandCn0DbHz(@IntRange(from = 0) int i10);

    @FloatRange(from = ShadowDrawableWrapper.COS_45)
    public abstract float getCarrierFrequencyHz(@IntRange(from = 0) int i10);

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 63.0d)
    public abstract float getCn0DbHz(@IntRange(from = 0) int i10);

    public abstract int getConstellationType(@IntRange(from = 0) int i10);

    @FloatRange(from = -90.0d, to = 90.0d)
    public abstract float getElevationDegrees(@IntRange(from = 0) int i10);

    @IntRange(from = 0)
    public abstract int getSatelliteCount();

    @IntRange(from = 1, to = com.huawei.uikit.hwdotspageindicator.widget.u.f35220x)
    public abstract int getSvid(@IntRange(from = 0) int i10);

    public abstract boolean hasAlmanacData(@IntRange(from = 0) int i10);

    public abstract boolean hasBasebandCn0DbHz(@IntRange(from = 0) int i10);

    public abstract boolean hasCarrierFrequencyHz(@IntRange(from = 0) int i10);

    public abstract boolean hasEphemerisData(@IntRange(from = 0) int i10);

    public abstract boolean usedInFix(@IntRange(from = 0) int i10);

    @NonNull
    public static GnssStatusCompat wrap(@NonNull GpsStatus gpsStatus) {
        return new GpsStatusWrapper(gpsStatus);
    }
}
