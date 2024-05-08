package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ak {
    private static final String A = "b3JnLnNhbmRyb3Byb3h5LmRyb255";
    private static final String B = "aW8ueHVkd29mdGVuY2VudG1t";
    private static final String C = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";
    private static final String D = "Y29tLnR4eS5hbnl3aGVyZQ==";
    private static final String E = "Y29tLmRpbmd3ZWkueHVuaWpp";
    private static final String F = "bWUud2Vpc2h1LmV4cA==";
    private static final String G = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";
    private static final String H = "ZXUuZmFpcmNvZGUueGx1YQ==";
    private static final String I = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";
    private static final String J = "Y29tLndpbmQuY290dGVy";
    private static final String K = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";

    /* renamed from: a, reason: collision with root package name */
    private static final String f35768a = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35769b = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35770c = "b3JnLmF1dG9qcy5hdXRvanM=";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35771d = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35772e = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";

    /* renamed from: f, reason: collision with root package name */
    private static final String f35773f = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";

    /* renamed from: g, reason: collision with root package name */
    private static final String f35774g = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";

    /* renamed from: h, reason: collision with root package name */
    private static final String f35775h = "Y29tLm13ci5keg==";

    /* renamed from: i, reason: collision with root package name */
    private static final String f35776i = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";

    /* renamed from: j, reason: collision with root package name */
    private static final String f35777j = "Y29tLng4enMuc2FuZGJveA==";

    /* renamed from: k, reason: collision with root package name */
    private static final String f35778k = "Y29tLmYxcGxheWVy";

    /* renamed from: l, reason: collision with root package name */
    private static final String f35779l = "Y29tLmNvZmZhY2UuaXZhZGVy";

    /* renamed from: m, reason: collision with root package name */
    private static final String f35780m = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";

    /* renamed from: n, reason: collision with root package name */
    private static final String f35781n = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";

    /* renamed from: o, reason: collision with root package name */
    private static final String f35782o = "bmV0LmdkaS5tb2R1bGUuYXBweA==";

    /* renamed from: p, reason: collision with root package name */
    private static final String f35783p = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";

    /* renamed from: q, reason: collision with root package name */
    private static final String f35784q = "Y29tLm1pbmkubGl2ZS5saXZl";

    /* renamed from: r, reason: collision with root package name */
    private static final String f35785r = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";

    /* renamed from: s, reason: collision with root package name */
    private static final String f35786s = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";

    /* renamed from: t, reason: collision with root package name */
    private static final String f35787t = "dG9wLm5pdW5haWp1bi5ibGFja2RleGEzMg==";

    /* renamed from: u, reason: collision with root package name */
    private static final String f35788u = "dG9wLm5pdW5haWp1bi5ibGFja2RleGE2NA==";

    /* renamed from: v, reason: collision with root package name */
    private static final String f35789v = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";

    /* renamed from: w, reason: collision with root package name */
    private static final String f35790w = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";

    /* renamed from: x, reason: collision with root package name */
    private static final String f35791x = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";

    /* renamed from: y, reason: collision with root package name */
    private static final String f35792y = "Y29tLnNrLnNwcm9tb3Rlcg==";

    /* renamed from: z, reason: collision with root package name */
    private static final String f35793z = "Y29tLnNlc2FtZS5wcm94eQ==";

    private JSONObject n(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35773f)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35774g)) {
                jSONObject.put("1", 1);
            }
            if (a(context, f35775h)) {
                jSONObject.put("2", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject o(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35768a)) {
                jSONObject.put("0", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject p(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35777j)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35778k)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject q(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35779l)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35780m)) {
                jSONObject.put("1", 1);
            }
            if (a(context, f35781n)) {
                jSONObject.put("2", 1);
            }
            if (a(context, f35782o)) {
                jSONObject.put("3", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject r(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, f35783p)) {
                jSONObject.put("0", 1);
            }
            if (a(context, f35784q)) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = 1;
            jSONObject.put("0", a(context, f35768a) ? 1 : 0);
            jSONObject.put("1", a(context, f35769b) ? 1 : 0);
            jSONObject.put("2", a(context, f35770c) ? 1 : 0);
            jSONObject.put("3", a(context, f35771d) ? 1 : 0);
            if (!a(context, f35772e)) {
                i10 = 0;
            }
            jSONObject.put("4", i10);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b(Context context) {
        return a(context, f35776i) ? 1 : 0;
    }

    public JSONObject c(Context context) {
        try {
            JSONObject o10 = o(context);
            if (o10 == null) {
                return null;
            }
            if (o10.length() > 0) {
                return o10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        try {
            JSONObject n10 = n(context);
            if (n10 == null) {
                return null;
            }
            if (n10.length() > 0) {
                return n10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e(Context context) {
        try {
            JSONObject p10 = p(context);
            if (p10 == null) {
                return null;
            }
            if (p10.length() > 0) {
                return p10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f(Context context) {
        try {
            JSONObject q10 = q(context);
            if (q10 == null) {
                return null;
            }
            if (q10.length() > 0) {
                return q10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject g(Context context) {
        try {
            JSONObject r10 = r(context);
            if (r10 == null) {
                return null;
            }
            if (r10.length() > 0) {
                return r10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject h(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35785r);
            arrayList.add(f35786s);
            JSONObject a10 = a(context, arrayList);
            if (a10 == null) {
                return null;
            }
            if (a10.length() > 0) {
                return a10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject i(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35789v);
            arrayList.add(f35790w);
            arrayList.add(J);
            arrayList.add(K);
            JSONObject a10 = a(context, arrayList);
            if (a10 == null) {
                return null;
            }
            if (a10.length() > 0) {
                return a10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject j(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35791x);
            arrayList.add(f35792y);
            arrayList.add(G);
            arrayList.add(H);
            arrayList.add(I);
            JSONObject a10 = a(context, arrayList);
            if (a10 == null) {
                return null;
            }
            if (a10.length() > 0) {
                return a10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject k(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35793z);
            arrayList.add(A);
            JSONObject a10 = a(context, arrayList);
            if (a10 == null) {
                return null;
            }
            if (a10.length() > 0) {
                return a10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject l(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(B);
            arrayList.add(C);
            arrayList.add(D);
            arrayList.add(E);
            arrayList.add(F);
            JSONObject a10 = a(context, arrayList);
            if (a10 == null) {
                return null;
            }
            if (a10.length() > 0) {
                return a10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject m(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f35787t);
            arrayList.add(f35788u);
            JSONObject a10 = a(context, arrayList);
            if (a10 == null) {
                return null;
            }
            if (a10.length() > 0) {
                return a10;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.contains(".")) {
                str = new String(c.a(str.getBytes(), 2));
            }
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private JSONObject a(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (a(context, list.get(i10))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i10);
                    jSONObject.put(sb2.toString(), 1);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        try {
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
            for (int i10 = 0; i10 < 20; i10++) {
                if (new File(strArr[i10]).exists()) {
                    sb2.append("1");
                } else {
                    sb2.append("0");
                }
            }
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
