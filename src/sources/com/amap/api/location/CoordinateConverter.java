package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CoordinateConverter {

    /* renamed from: b, reason: collision with root package name */
    private static int f8128b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f8129c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static int f8130d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static int f8131e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static int f8132f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static int f8133g = 16;

    /* renamed from: h, reason: collision with root package name */
    private static int f8134h = 32;

    /* renamed from: i, reason: collision with root package name */
    private static int f8135i = 64;

    /* renamed from: j, reason: collision with root package name */
    private Context f8137j;

    /* renamed from: k, reason: collision with root package name */
    private CoordType f8138k = null;

    /* renamed from: l, reason: collision with root package name */
    private DPoint f8139l = null;

    /* renamed from: a, reason: collision with root package name */
    public DPoint f8136a = null;

    /* renamed from: com.amap.api.location.CoordinateConverter$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8140a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f8140a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8140a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8140a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8140a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8140a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8140a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8140a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.f8137j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return j.a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d10, double d11) {
        return b.a(d10, d11);
    }

    public synchronized DPoint convert() throws Exception {
        if (this.f8138k != null) {
            DPoint dPoint = this.f8139l;
            if (dPoint == null) {
                throw new IllegalArgumentException("转换坐标源不能为空");
            }
            if (dPoint.getLongitude() > 180.0d || this.f8139l.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (this.f8139l.getLatitude() <= 90.0d && this.f8139l.getLatitude() >= -90.0d) {
                boolean z10 = false;
                String str = null;
                switch (AnonymousClass1.f8140a[this.f8138k.ordinal()]) {
                    case 1:
                        this.f8136a = e.a(this.f8139l);
                        int i10 = f8128b;
                        int i11 = f8129c;
                        if ((i10 & i11) == 0) {
                            str = "baidu";
                            f8128b = i10 | i11;
                            z10 = true;
                            break;
                        }
                        break;
                    case 2:
                        this.f8136a = e.b(this.f8137j, this.f8139l);
                        int i12 = f8128b;
                        int i13 = f8130d;
                        if ((i12 & i13) == 0) {
                            str = "mapbar";
                            f8128b = i12 | i13;
                            z10 = true;
                            break;
                        }
                        break;
                    case 3:
                        int i14 = f8128b;
                        int i15 = f8131e;
                        if ((i14 & i15) == 0) {
                            str = "mapabc";
                            f8128b = i14 | i15;
                            z10 = true;
                        }
                        this.f8136a = this.f8139l;
                        break;
                    case 4:
                        int i16 = f8128b;
                        int i17 = f8132f;
                        if ((i16 & i17) == 0) {
                            str = "sosomap";
                            f8128b = i16 | i17;
                            z10 = true;
                        }
                        this.f8136a = this.f8139l;
                        break;
                    case 5:
                        int i18 = f8128b;
                        int i19 = f8133g;
                        if ((i18 & i19) == 0) {
                            str = "aliyun";
                            f8128b = i18 | i19;
                            z10 = true;
                        }
                        this.f8136a = this.f8139l;
                        break;
                    case 6:
                        int i20 = f8128b;
                        int i21 = f8134h;
                        if ((i20 & i21) == 0) {
                            str = "google";
                            f8128b = i20 | i21;
                            z10 = true;
                        }
                        this.f8136a = this.f8139l;
                        break;
                    case 7:
                        int i22 = f8128b;
                        int i23 = f8135i;
                        if ((i22 & i23) == 0) {
                            str = GeocodeSearch.GPS;
                            f8128b = i22 | i23;
                            z10 = true;
                        }
                        this.f8136a = e.a(this.f8137j, this.f8139l);
                        break;
                }
                if (z10) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("amap_loc_coordinate", str);
                    }
                    h.a(this.f8137j, "O021", jSONObject);
                }
            } else {
                throw new IllegalArgumentException("请传入合理纬度");
            }
        } else {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        }
        return this.f8136a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        try {
            if (dPoint == null) {
                throw new IllegalArgumentException("传入经纬度对象为空");
            }
            if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d) {
                this.f8139l = dPoint;
            } else {
                throw new IllegalArgumentException("请传入合理纬度");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f8138k = coordType;
        return this;
    }
}
