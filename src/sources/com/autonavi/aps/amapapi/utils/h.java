package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.col.p0003l.fi;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.ij;
import com.amap.api.col.p0003l.ik;
import com.amap.api.col.p0003l.il;
import com.amap.api.col.p0003l.im;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.huawei.quickcard.base.Attributes;
import com.tencent.rtmp.TXLiveConstants;
import com.wangmai.okhttp.cookie.SerializableCookie;
import com.wangmai.okhttp.db.DBHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<Long> f9667a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public int f9668b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f9669c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String[] f9670d = {"ol", "cl", "gl", "ha", "bs", "ds"};

    /* renamed from: e, reason: collision with root package name */
    public int f9671e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f9672f = -1;

    /* renamed from: i, reason: collision with root package name */
    private static List<il> f9665i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private static JSONArray f9666j = null;

    /* renamed from: g, reason: collision with root package name */
    public static AMapLocation f9663g = null;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f9664h = false;

    /* compiled from: ReportUtil.java */
    /* renamed from: com.autonavi.aps.amapapi.utils.h$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9673a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f9673a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9673a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9673a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String a(int i10) {
        if (i10 == 2011) {
            return "ContextIsNull";
        }
        if (i10 == 2031) {
            return "CreateApsReqException";
        }
        if (i10 == 2041) {
            return "ResponseResultIsNull";
        }
        if (i10 == 2081) {
            return "LocalLocException";
        }
        if (i10 == 2091) {
            return "InitException";
        }
        if (i10 == 2111) {
            return "ErrorCgiInfo";
        }
        if (i10 == 2121) {
            return "NotLocPermission";
        }
        if (i10 == 2141) {
            return "NoEnoughStatellites";
        }
        if (i10 == 2021) {
            return "OnlyMainWifi";
        }
        if (i10 == 2022) {
            return "OnlyOneWifiButNotMain";
        }
        if (i10 == 2061) {
            return "ServerRetypeError";
        }
        if (i10 == 2062) {
            return "ServerLocFail";
        }
        switch (i10) {
            case 2051:
                return "NeedLoginNetWork\t";
            case 2052:
                return "MaybeIntercepted";
            case 2053:
                return "DecryptResponseException";
            case 2054:
                return "ParserDataException";
            default:
                switch (i10) {
                    case 2101:
                        return "BindAPSServiceException";
                    case 2102:
                        return "AuthClientScodeFail";
                    case TXLiveConstants.PLAY_WARNING_RECONNECT /* 2103 */:
                        return "NotConfigAPSService";
                    default:
                        switch (i10) {
                            case 2131:
                                return "NoCgiOAndWifiInfo";
                            case 2132:
                                return "AirPlaneModeAndWifiOff";
                            case 2133:
                                return "NoCgiAndWifiOff";
                            default:
                                switch (i10) {
                                    case 2151:
                                        return "MaybeMockNetLoc";
                                    case 2152:
                                        return "MaybeMockGPSLoc";
                                    case 2153:
                                        return "UNSUPPORT_COARSE_LBSLOC";
                                    case 2154:
                                        return "UNSUPPORT_CONTINUE_LOC";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    private static boolean a(AMapLocation aMapLocation) {
        return j.a(aMapLocation) ? !b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(b.f9634c);
    }

    public static void b(Context context, long j10, boolean z10) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j10, z10, "O024");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void f(Context context) {
        try {
            JSONArray jSONArray = f9666j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            ik.a(new ij(context, b.c(), f9666j.toString()), context);
            f9666j = null;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final int c(Context context) {
        try {
            long a10 = i.a(context, "pref1", this.f9670d[2], 0L);
            long a11 = i.a(context, "pref1", this.f9670d[0], 0L);
            long a12 = i.a(context, "pref1", this.f9670d[1], 0L);
            if (a10 == 0 && a11 == 0 && a12 == 0) {
                return -1;
            }
            long j10 = a11 - a10;
            long j11 = a12 - a10;
            return a10 > j10 ? a10 > j11 ? 2 : 1 : j10 > j11 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long a10 = i.a(context, "pref1", this.f9670d[3], 0L);
            long a11 = i.a(context, "pref1", this.f9670d[4], 0L);
            long a12 = i.a(context, "pref1", this.f9670d[5], 0L);
            if (a10 == 0 && a11 == 0 && a12 == 0) {
                return -1;
            }
            return a10 > a11 ? a10 > a12 ? 3 : 5 : a11 > a12 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        try {
            SharedPreferences.Editor a10 = i.a(context, "pref1");
            int i10 = 0;
            while (true) {
                String[] strArr = this.f9670d;
                if (i10 < strArr.length) {
                    i.a(a10, strArr[i10], 0L);
                    i10++;
                } else {
                    i.a(a10);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        int i10;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                String str = a(aMapLocation) ? "abroad" : "domestic";
                int errorCode = aMapLocation.getErrorCode();
                String str2 = DBHelper.TABLE_CACHE;
                if (errorCode != 0) {
                    int errorCode2 = aMapLocation.getErrorCode();
                    if (errorCode2 == 4 || errorCode2 == 5 || errorCode2 == 6 || errorCode2 == 11) {
                        str2 = "net";
                    }
                    i10 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str2 = "net";
                    }
                    i10 = 1;
                }
                a(context, "O016", str2, str, i10, aMapLocation.getErrorCode(), aVar);
            }
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportBatting");
        }
    }

    public final void b(Context context) {
        try {
            long b4 = j.b() - this.f9669c;
            int i10 = this.f9668b;
            if (i10 != -1) {
                this.f9667a.append(this.f9668b, Long.valueOf(b4 + this.f9667a.get(i10, 0L).longValue()));
            }
            long b10 = j.b() - this.f9672f;
            int i11 = this.f9671e;
            if (i11 != -1) {
                this.f9667a.append(this.f9671e, Long.valueOf(b10 + this.f9667a.get(i11, 0L).longValue()));
            }
            SharedPreferences.Editor a10 = i.a(context, "pref1");
            for (int i12 = 0; i12 < this.f9670d.length; i12++) {
                long longValue = this.f9667a.get(i12, 0L).longValue();
                if (longValue > 0 && longValue > i.a(context, "pref1", this.f9670d[i12], 0L)) {
                    i.a(a10, this.f9670d[i12], longValue);
                }
            }
            i.a(a10);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public static void a(Context context, long j10, boolean z10) {
        if (context != null) {
            try {
                if (a.a()) {
                    a(context, j10, z10, "O015");
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(Context context, long j10, boolean z10, String str) {
        a(context, str, !z10 ? "abroad" : "domestic", Long.valueOf(j10).intValue());
    }

    private static void a(Context context, String str, String str2, String str3, int i10, int i11, com.autonavi.aps.amapapi.a aVar) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i10 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i10);
                    }
                    if (i11 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i11);
                    }
                    if (aVar != null) {
                        if (!TextUtils.isEmpty(aVar.d())) {
                            jSONObject.put("dns", aVar.d());
                        }
                        if (!TextUtils.isEmpty(aVar.e())) {
                            jSONObject.put(SerializableCookie.DOMAIN, aVar.e());
                        }
                        if (!TextUtils.isEmpty(aVar.f())) {
                            jSONObject.put("type", aVar.f());
                        }
                        if (!TextUtils.isEmpty(aVar.g())) {
                            jSONObject.put("reason", aVar.g());
                        }
                        if (!TextUtils.isEmpty(aVar.c())) {
                            jSONObject.put("ip", aVar.c());
                        }
                        if (!TextUtils.isEmpty(aVar.b())) {
                            jSONObject.put(Attributes.Component.STACK, aVar.b());
                        }
                        if (aVar.h() > 0) {
                            jSONObject.put("ctime", String.valueOf(aVar.h()));
                        }
                        if (aVar.a() > 0) {
                            jSONObject.put("ntime", String.valueOf(aVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, int i10) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (Object) null);
                    }
                    if (i10 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i10);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(Context context, String str, JSONObject jSONObject) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        il ilVar = new il(context, "loc", "6.4.1", str);
                        if (jSONObject != null) {
                            ilVar.a(jSONObject.toString());
                        }
                        f9665i.add(ilVar);
                        if (f9665i.size() >= 30) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f9665i);
                            im.b(arrayList, context);
                            f9665i.clear();
                        }
                    }
                } catch (Throwable th) {
                    b.a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (h.class) {
            if (context != null) {
                try {
                    if (a.a()) {
                        List<il> list = f9665i;
                        if (list != null && list.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(f9665i);
                            im.b(arrayList, context);
                            f9665i.clear();
                        }
                        f(context);
                    }
                } catch (Throwable th) {
                    b.a(th, "ReportUtil", LandingPageUtHelper.XAD_UT_LP_DESTROY);
                }
            }
        }
    }

    public static void a(String str, String str2) {
        try {
            gy.b(b.c(), str2, str);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportLog");
        }
    }

    public final void a(Context context, int i10) {
        try {
            int i11 = this.f9668b;
            if (i11 == i10) {
                return;
            }
            if (i11 != -1 && i11 != i10) {
                this.f9667a.append(this.f9668b, Long.valueOf((j.b() - this.f9669c) + this.f9667a.get(this.f9668b, 0L).longValue()));
            }
            this.f9669c = j.b() - i.a(context, "pref1", this.f9670d[i10], 0L);
            this.f9668b = i10;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        try {
            int i10 = AnonymousClass1.f9673a[aMapLocationClientOption.getLocationMode().ordinal()];
            int i11 = 3;
            if (i10 == 1) {
                i11 = 4;
            } else if (i10 == 2) {
                i11 = 5;
            } else if (i10 != 3) {
                i11 = -1;
            }
            int i12 = this.f9671e;
            if (i12 == i11) {
                return;
            }
            if (i12 != -1 && i12 != i11) {
                this.f9667a.append(this.f9671e, Long.valueOf((j.b() - this.f9672f) + this.f9667a.get(this.f9671e, 0L).longValue()));
            }
            this.f9672f = j.b() - i.a(context, "pref1", this.f9670d[i11], 0L);
            this.f9671e = i11;
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public static void a(Context context, int i10, int i11, long j10, long j11) {
        if (i10 == -1 || i11 == -1) {
            return;
        }
        try {
            a(context, "O012", i10, i11, j10, j11);
        } catch (Throwable th) {
            b.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    private static void a(Context context, String str, int i10, int i11, long j10, long j11) {
        if (context != null) {
            try {
                if (a.a()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i10);
                    jSONObject.put("param_int_second", i11);
                    jSONObject.put("param_long_first", j10);
                    jSONObject.put("param_long_second", j11);
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                b.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034 A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x0003, B:9:0x000b, B:21:0x0034, B:31:0x0047, B:33:0x004b, B:34:0x0052, B:36:0x008b, B:38:0x0098, B:39:0x00d9, B:41:0x00eb, B:43:0x0091), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(android.content.Context r8, com.amap.api.location.AMapLocation r9) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.h.a(android.content.Context, com.amap.api.location.AMapLocation):void");
    }

    public static void a(String str, int i10) {
        a(str, String.valueOf(i10), a(i10));
    }

    public static void a(String str, String str2, String str3) {
        try {
            gy.a(b.c(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof fi) {
                gy.a(b.c(), str, (fi) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (f9663g == null) {
                if (!j.a(aMapLocation)) {
                    f9663g = aMapLocation2;
                    return;
                }
                f9663g = aMapLocation.m1956clone();
            }
            if (j.a(f9663g) && j.a(aMapLocation2)) {
                AMapLocation m1956clone = aMapLocation2.m1956clone();
                if (f9663g.getLocationType() != 1 && f9663g.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(f9663g.getProvider()) && f9663g.getLocationType() != 7 && m1956clone.getLocationType() != 1 && m1956clone.getLocationType() != 9 && !GeocodeSearch.GPS.equalsIgnoreCase(m1956clone.getProvider()) && m1956clone.getLocationType() != 7) {
                    long abs = Math.abs(m1956clone.getTime() - f9663g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800) {
                        float a10 = j.a(f9663g, m1956clone);
                        float f10 = a10 / ((float) abs);
                        if (a10 > 30000.0f && f10 > 1000.0f) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(f9663g.getLatitude());
                            sb2.append(",");
                            sb2.append(f9663g.getLongitude());
                            sb2.append(",");
                            sb2.append(f9663g.getAccuracy());
                            sb2.append(",");
                            sb2.append(f9663g.getLocationType());
                            sb2.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb2.append(j.a(f9663g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb2.append(f9663g.getTime());
                            }
                            sb2.append("#");
                            sb2.append(m1956clone.getLatitude());
                            sb2.append(",");
                            sb2.append(m1956clone.getLongitude());
                            sb2.append(",");
                            sb2.append(m1956clone.getAccuracy());
                            sb2.append(",");
                            sb2.append(m1956clone.getLocationType());
                            sb2.append(",");
                            if (m1956clone.getTime() != 0) {
                                sb2.append(j.a(m1956clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb2.append(m1956clone.getTime());
                            }
                            a("bigshiftstatistics", sb2.toString());
                            sb2.delete(0, sb2.length());
                        }
                    }
                }
                f9663g = m1956clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(long j10, long j11) {
        try {
            if (f9664h) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(j.a(j10, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(j.a(j11, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long u10 = a.u();
            String a10 = 0 != u10 ? j.a(u10, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(a10);
            a("checkgpstime", stringBuffer.toString());
            if (0 != u10 && Math.abs(j10 - u10) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            f9664h = true;
        } catch (Throwable unused) {
        }
    }
}
