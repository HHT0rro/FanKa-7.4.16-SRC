package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.idasc.crashreport.biz.UserInfoBean;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ae {
    public static bq a(Context context, int i10, byte[] bArr) {
        String str;
        aa b4 = aa.b();
        StrategyBean c4 = ac.a().c();
        if (b4 == null || c4 == null) {
            al.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            bq bqVar = new bq();
            synchronized (b4) {
                bqVar.f39801a = b4.f39472b;
                bqVar.f39802b = b4.e();
                bqVar.f39803c = b4.f39473c;
                bqVar.f39804d = b4.f39485o;
                bqVar.f39805e = b4.f39489s;
                bqVar.f39806f = b4.f39478h;
                bqVar.f39807g = i10;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                bqVar.f39808h = bArr;
                bqVar.f39809i = b4.h();
                bqVar.f39810j = b4.f39481k;
                bqVar.f39811k = new HashMap();
                bqVar.f39812l = b4.d();
                bqVar.f39813m = c4.f39399o;
                bqVar.f39815o = b4.g();
                bqVar.f39816p = ab.c(context);
                bqVar.f39817q = System.currentTimeMillis();
                bqVar.f39819s = b4.i();
                bqVar.f39822v = b4.g();
                bqVar.f39823w = bqVar.f39816p;
                bqVar.f39814n = "com.tencent.bugly.idasc";
                bqVar.f39811k.put("A26", b4.s());
                Map<String, String> map = bqVar.f39811k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aa.C());
                map.put("A62", sb2.toString());
                Map<String, String> map2 = bqVar.f39811k;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(aa.D());
                map2.put("A63", sb3.toString());
                Map<String, String> map3 = bqVar.f39811k;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(b4.J);
                map3.put("F11", sb4.toString());
                Map<String, String> map4 = bqVar.f39811k;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(b4.I);
                map4.put("F12", sb5.toString());
                bqVar.f39811k.put("D3", b4.f39487q);
                List<o> list = p.f39907b;
                if (list != null) {
                    for (o oVar : list) {
                        String str2 = oVar.versionKey;
                        if (str2 != null && (str = oVar.version) != null) {
                            bqVar.f39811k.put(str2, str);
                        }
                    }
                }
                bqVar.f39811k.put("G15", ap.d("G15", ""));
                bqVar.f39811k.put("G10", ap.d("G10", ""));
                bqVar.f39811k.put("D4", ap.d("D4", "0"));
            }
            Map<String, String> x10 = b4.x();
            if (x10 != null) {
                for (Map.Entry<String, String> entry : x10.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getValue())) {
                        bqVar.f39811k.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return bqVar;
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static br a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object b4 = eVar.b("detail", new br());
                if (br.class.isInstance(b4)) {
                    return (br) br.class.cast(b4);
                }
                return null;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bu a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.f39853a = userInfoBean.f39367e;
        buVar.f39857e = userInfoBean.f39372j;
        buVar.f39856d = userInfoBean.f39365c;
        buVar.f39855c = userInfoBean.f39366d;
        buVar.f39860h = userInfoBean.f39377o == 1;
        int i10 = userInfoBean.f39364b;
        if (i10 != 1) {
            byte b4 = 4;
            if (i10 != 2) {
                if (i10 == 3) {
                    buVar.f39854b = (byte) 2;
                } else if (i10 != 4) {
                    b4 = 8;
                    if (i10 != 8) {
                        if (i10 < 10 || i10 >= 20) {
                            al.e("unknown uinfo type %d ", Integer.valueOf(i10));
                            return null;
                        }
                        buVar.f39854b = (byte) i10;
                    }
                } else {
                    buVar.f39854b = (byte) 3;
                }
            }
            buVar.f39854b = b4;
        } else {
            buVar.f39854b = (byte) 1;
        }
        HashMap hashMap = new HashMap();
        buVar.f39858f = hashMap;
        if (userInfoBean.f39378p >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f39378p);
            hashMap.put("C01", sb2.toString());
        }
        if (userInfoBean.f39379q >= 0) {
            Map<String, String> map = buVar.f39858f;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(userInfoBean.f39379q);
            map.put("C02", sb3.toString());
        }
        Map<String, String> map2 = userInfoBean.f39380r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f39380r.entrySet()) {
                buVar.f39858f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = userInfoBean.f39381s;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f39381s.entrySet()) {
                buVar.f39858f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map4 = buVar.f39858f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(!userInfoBean.f39374l);
        map4.put("A36", sb4.toString());
        Map<String, String> map5 = buVar.f39858f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f39369g);
        map5.put("F02", sb5.toString());
        Map<String, String> map6 = buVar.f39858f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f39370h);
        map6.put("F03", sb6.toString());
        buVar.f39858f.put("F04", userInfoBean.f39372j);
        Map<String, String> map7 = buVar.f39858f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f39371i);
        map7.put("F05", sb7.toString());
        buVar.f39858f.put("F06", userInfoBean.f39375m);
        Map<String, String> map8 = buVar.f39858f;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(userInfoBean.f39373k);
        map8.put("F10", sb8.toString());
        al.c("summary type %d vm:%d", Byte.valueOf(buVar.f39854b), Integer.valueOf(buVar.f39858f.size()));
        return buVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                newInstance.a(kVar);
                return newInstance;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.f39901a.position()];
            System.arraycopy((Object) lVar.f39901a.array(), 0, (Object) bArr, 0, lVar.f39901a.position());
            return bArr;
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", (String) obj);
            return eVar.a();
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
