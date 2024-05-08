package md;

import com.tanx.exposer.achieve.AdMonitorType;
import java.util.Map;
import rc.d;
import rc.f;

/* compiled from: UtConstants.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f51991a = 9004;

    public static void a(f fVar, AdMonitorType adMonitorType, String str) {
        String str2;
        if (adMonitorType == AdMonitorType.CLICK) {
            str2 = "tanx_click_invoke_error";
        } else {
            str2 = adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_invoke_error" : "tanx_interact_invoke_error";
        }
        if (fVar == null) {
            rc.b.a(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = d.f(fVar);
        f10.put("errorMsg", str);
        ld.b.b(str2, f10, true);
    }

    public static void b(f fVar, AdMonitorType adMonitorType, String str, String str2) {
        String str3;
        if (adMonitorType == AdMonitorType.CLICK) {
            str3 = "tanx_click_request";
        } else {
            str3 = adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_request" : "tanx_interact_request";
        }
        if (fVar == null) {
            rc.b.a(str3, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = d.f(fVar);
        f10.put("host", str);
        f10.put("url_hash", str2);
        ld.b.b(str3, f10, true);
    }

    public static void c(f fVar, AdMonitorType adMonitorType, String str) {
        String str2;
        if (adMonitorType == AdMonitorType.CLICK) {
            str2 = "tanx_click_invalid_url";
        } else {
            str2 = adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_invalid_url" : "tanx_interact_invalid_url";
        }
        if (fVar == null) {
            rc.b.a(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> f10 = d.f(fVar);
        f10.put("errorMsg", str);
        ld.b.b(str2, f10, true);
    }
}
