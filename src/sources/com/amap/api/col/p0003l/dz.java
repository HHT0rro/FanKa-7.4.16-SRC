package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.huawei.quickcard.base.Attributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: LinkLogManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dz {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, ea> f5402a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static String f5403b = "";

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            b();
            gf.a(dx.a()).a(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    private static void b() {
        try {
            f5402a.put("overlay", new ec());
            f5402a.put("normal", new eb());
        } catch (Throwable unused) {
        }
    }

    private static void c(String str, String str2) {
        a(1, "overlay", f5403b, str, str2);
    }

    public static void a(String str, String str2) {
        a(0, "normal", f5403b, str, str2);
    }

    public static void b(String str, String str2) {
        a(1, "normal", f5403b, str, str2);
    }

    private static void a(int i10, String str, String str2, String str3, String str4) {
        Map<String, ea> map;
        ea eaVar;
        try {
            String str5 = str3 + str4;
            if (dy.f5396b) {
                a(i10, str2, str5);
            }
            if (!dy.f5395a || (map = f5402a) == null || (eaVar = map.get(str)) == null) {
                return;
            }
            eaVar.a(i10, str2, str5);
        } catch (Throwable unused) {
        }
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a10 = fk.a(jSONObject.optString("able", ""), false);
            boolean a11 = fk.a(jSONObject.optString("mobile", ""), false);
            boolean a12 = fk.a(jSONObject.optString("debugupload", ""), false);
            boolean a13 = fk.a(jSONObject.optString("debugwrite", ""), false);
            boolean a14 = fk.a(jSONObject.optString("forcedUpload", ""), false);
            dy.f5395a = a10;
            boolean a15 = fk.a(jSONObject.optString("di", ""), false);
            String optString = jSONObject.optString("dis", "");
            if (!a15 || fv.e(optString)) {
                gf.a(dx.a()).a(a10, a11, a13, a12, Arrays.asList(jSONObject.optString(Attributes.Style.FILTER, "").split("&")));
                if (a14) {
                    gf.a(dx.a()).a(a14);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            if (dy.f5395a) {
                Iterator<Map.Entry<String, ea>> iterator2 = f5402a.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().getValue().a();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(int i10, String str, String str2) {
        if (i10 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(" ");
        sb3.append(str2);
    }

    public static void a(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions != null) {
            c(str, str2 + " " + ((Object) markerOptions.getPosition()) + " " + ((Object) markerOptions.getIcons()));
            return;
        }
        c(str, str2);
    }

    public static void a(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            Iterator<MarkerOptions> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                a(str, str2, iterator2.next());
            }
        }
    }

    public static void a(String str, String str2, PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            StringBuilder sb2 = new StringBuilder();
            List<LatLng> points = polylineOptions.getPoints();
            if (points != null) {
                sb2.append("points size =");
                sb2.append(points.size());
            }
            sb2.append(";width=");
            sb2.append(polylineOptions.getWidth());
            sb2.append(";color=");
            sb2.append(polylineOptions.getColor());
            sb2.append(";visible=");
            sb2.append(polylineOptions.isVisible());
            c(str, str2 + " " + sb2.toString());
            return;
        }
        c(str, str2);
    }

    public static void a(String str, String str2, PolygonOptions polygonOptions) {
        if (polygonOptions != null) {
            StringBuilder sb2 = new StringBuilder();
            List<LatLng> points = polygonOptions.getPoints();
            if (points != null) {
                sb2.append("points size =");
                sb2.append(points.size());
            }
            sb2.append(";width=");
            sb2.append(polygonOptions.getStrokeWidth());
            sb2.append(";fillColor=");
            sb2.append(polygonOptions.getFillColor());
            sb2.append(";strokeColor=");
            sb2.append(polygonOptions.getStrokeColor());
            sb2.append(";visible=");
            sb2.append(polygonOptions.isVisible());
            c(str, str2 + " " + sb2.toString());
            return;
        }
        c(str, str2);
    }
}
