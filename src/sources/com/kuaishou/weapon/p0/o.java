package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        p b4 = b(jSONObject);
        if (b4 == null) {
            return null;
        }
        int a10 = b4.a();
        String l10 = b4.l();
        String j10 = b4.j();
        boolean z10 = b4.d() == 1;
        boolean z11 = b4.h() == 1;
        int e2 = b4.e();
        String c4 = b4.c();
        String f10 = b4.f();
        String b10 = b4.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f10;
            packageInfo.versionName = l10;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f10) && !TextUtils.isEmpty(b10) && b10.startsWith(".")) {
                applicationInfo.name = f10 + b10;
                applicationInfo.className = f10 + b10;
            }
            applicationInfo.theme = b4.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m10 = b4.m();
            if (m10 != null && m10.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < m10.size(); i10++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m10.get(i10).c();
                    activityInfo.theme = m10.get(i10).b();
                    activityInfo.labelRes = m10.get(i10).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        s sVar = new s(packageInfo, a10, f10, l10, j10, c4);
        sVar.f36212v = z10;
        sVar.f36214x = e2;
        int a11 = b4.k() == null ? 0 : b4.k().a();
        int b11 = b4.k() == null ? -1 : b4.k().b();
        sVar.f36210t = a11;
        sVar.f36211u = b11;
        sVar.f36209s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z11) {
            z11 = b4.g() == 1;
        }
        sVar.f36215y = z11;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString(bi.f35847q));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                aVar.a(jSONObject2.optInt(t.f36226k));
                aVar.b(jSONObject2.optInt("t"));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            bVar.a(jSONObject3.optInt("duration"));
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
