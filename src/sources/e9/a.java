package e9;

import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.net.Response;

/* compiled from: outline */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static Response a(String str, String str2, String str3, int i10, String str4) {
        HiLog.e(str, str2, str3);
        return new Response(i10, str4);
    }

    public static StringBuilder b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static void c(String str, CardEventInfo cardEventInfo, e eVar, String str2) {
        eVar.i(str2, str + ((Object) cardEventInfo));
    }

    public static void d(StringBuilder sb2, String str, e eVar, String str2) {
        sb2.append(str);
        eVar.i(str2, sb2.toString());
    }

    public static void e(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        HiLog.sw(str2, sb2.toString());
    }
}
