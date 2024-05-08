package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.kuaishou.weapon.p0.jni.Engine;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.connect.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    private Context f35974a;

    public co(Context context) {
        this.f35974a = context;
    }

    public String a(String str) {
        JSONObject a10;
        JSONObject a11;
        try {
            cm cmVar = new cm(str, ck.f35942l);
            String a12 = dl.a(cu.f35992a);
            String b4 = b(a12);
            if (TextUtils.isEmpty(b4) || (a10 = cmVar.a(this.f35974a)) == null) {
                return null;
            }
            String str2 = cu.f35999h + SymbolValues.QUESTION_EN_SYMBOL + cv.a(this.f35974a);
            if (cu.a() && cu.f35992a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", b4);
            jSONObject.put("host", a12);
            jSONObject.put("path", str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put("head", a10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb2.toString());
            if (str.equals(ck.f35938h) && (a11 = a()) != null) {
                jSONObject.put("sjd", a11);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dl.a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(".")) {
                        return hostAddress;
                    }
                }
                return "";
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a10 = h.a(this.f35974a, "re_po_rt");
            a10.e("a1_p_s_p_s");
            a10.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f35974a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_AIO, ajVar.e());
            int i10 = 1;
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f35974a) ? 1 : 0);
            JSONObject a11 = ai.a(this.f35974a);
            if (a11 != null) {
                jSONObject.put("4", a11);
            }
            a10.b(df.f36054ac, 0);
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a12 = acVar.a(this.f35974a);
            jSONObject.put("8", a12 ? 1 : 0);
            if (a12) {
                jSONObject.put("61", acVar.b(this.f35974a));
            }
            jSONObject.put("10", acVar.e(this.f35974a));
            jSONObject.put("11", acVar.c(this.f35974a));
            ae aeVar = new ae();
            jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_VIDEO, aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b4 = aoVar.b();
            jSONObject.put("66", b4 ? 1 : 0);
            if (b4) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put(PPSLauncherActivity.Code, aoVar.e());
            jSONObject.put(ADEvent.PRICE_LOW, aoVar.c() ? 1 : 0);
            jSONObject.put(ADEvent.BLACKLIST_FILTER, aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bv.a(this.f35974a));
            jSONObject2.put("03014", bh.g(this.f35974a));
            jSONObject2.put("03020", bv.b(this.f35974a));
            jSONObject2.put("03030", bg.d(this.f35974a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put("107", new an().d());
            if (!ab.b(this.f35974a)) {
                i10 = 0;
            }
            jSONObject.put("60", i10);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                jSONObject.put(WbFaceError.WBFaceErrorCodeDataSerilizerError, Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
