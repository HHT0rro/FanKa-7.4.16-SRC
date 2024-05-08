package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.p0003l.am;
import com.amap.api.col.p0003l.dq;
import com.amap.api.col.p0003l.du;
import com.amap.api.col.p0003l.gy;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    /* renamed from: com.amap.api.maps.CoordinateConverter$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8187a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f8187a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8187a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8187a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8187a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8187a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8187a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8187a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d10, double d11) {
        return dq.a(d10, d11);
    }

    public LatLng convert() {
        CoordType coordType = this.coordType;
        LatLng latLng = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            String str = "";
            switch (AnonymousClass1.f8187a[coordType.ordinal()]) {
                case 1:
                    latLng = am.a(this.sourceLatLng);
                    str = "baidu";
                    break;
                case 2:
                    latLng = am.b(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLng = this.sourceLatLng;
                    break;
                case 4:
                    str = "sosomap";
                    latLng = this.sourceLatLng;
                    break;
                case 5:
                    str = "aliyun";
                    latLng = this.sourceLatLng;
                    break;
                case 6:
                    str = "google";
                    latLng = this.sourceLatLng;
                    break;
                case 7:
                    str = GeocodeSearch.GPS;
                    latLng = am.a(this.ctx, this.sourceLatLng);
                    break;
            }
            du.a(this.ctx, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            gy.b(th, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.coordType = coordType;
        return this;
    }
}
