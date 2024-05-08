package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.quickcard.base.Attributes;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sun.security.x509.PolicyMappingsExtension;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static Proxy f39993e;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, HashMap<String, byte[]>> f39994a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public String f39995b;

    /* renamed from: c, reason: collision with root package name */
    public i f39996c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Object> f39997d;

    public a() {
        new HashMap();
        this.f39997d = new HashMap<>();
        this.f39995b = "GBK";
        this.f39996c = new i();
    }

    public static void a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            f39993e = null;
        } else {
            f39993e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i10));
        }
    }

    public static Proxy b() {
        return f39993e;
    }

    public static an b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b4 = dVar.b("detail", new an());
                if (an.class.isInstance(b4)) {
                    return (an) an.class.cast(b4);
                }
                return null;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void a(InetAddress inetAddress, int i10) {
        if (inetAddress == null) {
            f39993e = null;
        } else {
            f39993e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i10));
        }
    }

    public void a(String str) {
        this.f39995b = str;
    }

    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.f40103a = userInfoBean.f39041e;
        aqVar.f40107e = userInfoBean.f39046j;
        aqVar.f40106d = userInfoBean.f39039c;
        aqVar.f40105c = userInfoBean.f39040d;
        aqVar.f40109g = userInfoBean.f39051o == 1;
        int i10 = userInfoBean.f39038b;
        if (i10 == 1) {
            aqVar.f40104b = (byte) 1;
        } else if (i10 == 2) {
            aqVar.f40104b = (byte) 4;
        } else if (i10 == 3) {
            aqVar.f40104b = (byte) 2;
        } else if (i10 != 4) {
            if (i10 < 10 || i10 >= 20) {
                x.e("unknown uinfo type %d ", Integer.valueOf(i10));
                return null;
            }
            aqVar.f40104b = (byte) i10;
        } else {
            aqVar.f40104b = (byte) 3;
        }
        HashMap hashMap = new HashMap();
        aqVar.f40108f = hashMap;
        if (userInfoBean.f39052p >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f39052p);
            hashMap.put("C01", sb2.toString());
        }
        if (userInfoBean.f39053q >= 0) {
            Map<String, String> map = aqVar.f40108f;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(userInfoBean.f39053q);
            map.put("C02", sb3.toString());
        }
        Map<String, String> map2 = userInfoBean.f39054r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f39054r.entrySet()) {
                aqVar.f40108f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = userInfoBean.f39055s;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f39055s.entrySet()) {
                aqVar.f40108f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map4 = aqVar.f40108f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(!userInfoBean.f39048l);
        map4.put("A36", sb4.toString());
        Map<String, String> map5 = aqVar.f40108f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f39043g);
        map5.put("F02", sb5.toString());
        Map<String, String> map6 = aqVar.f40108f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f39044h);
        map6.put("F03", sb6.toString());
        aqVar.f40108f.put("F04", userInfoBean.f39046j);
        Map<String, String> map7 = aqVar.f40108f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f39045i);
        map7.put("F05", sb7.toString());
        aqVar.f40108f.put("F06", userInfoBean.f39049m);
        Map<String, String> map8 = aqVar.f40108f;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(userInfoBean.f39047k);
        map8.put("F10", sb8.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.f40104b), Integer.valueOf(aqVar.f40108f.size()));
        return aqVar;
    }

    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i10 = 0;
        while (true) {
            int size = arrayList.size();
            String str = PolicyMappingsExtension.MAP;
            if (i10 < size) {
                String str2 = arrayList.get(i10);
                if (str2.equals("java.lang.Integer") || str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else {
                    if (str2.equals("java.lang.Character")) {
                        throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                    if (str2.equals("java.lang.String")) {
                        str = Attributes.TextOverflow.STRING;
                    } else if (str2.equals("java.util.List")) {
                        str = "list";
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                }
                arrayList.set(i10, str);
                i10++;
            } else {
                Collections.reverse(arrayList);
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    String str3 = arrayList.get(i11);
                    if (str3.equals("list")) {
                        int i12 = i11 - 1;
                        arrayList.set(i12, "<" + arrayList.get(i12));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals(PolicyMappingsExtension.MAP)) {
                        int i13 = i11 - 1;
                        arrayList.set(i13, "<" + arrayList.get(i13) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        int i14 = i11 - 1;
                        arrayList.set(i14, "<" + arrayList.get(i14));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    stringBuffer.append(iterator2.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void a(String str, T t2) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t2 != null) {
            if (!(t2 instanceof Set)) {
                j jVar = new j();
                jVar.a(this.f39995b);
                jVar.a(t2, 0);
                byte[] a10 = l.a(jVar.a());
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList<String> arrayList = new ArrayList<>(1);
                a(arrayList, t2);
                hashMap.put(a(arrayList), a10);
                this.f39997d.remove(str);
                this.f39994a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public static ar a(List<UserInfoBean> list, int i10) {
        com.tencent.bugly.crashreport.common.info.a b4;
        if (list == null || list.size() == 0 || (b4 = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b4.p();
        ar arVar = new ar();
        arVar.f40114b = b4.f39096d;
        arVar.f40115c = b4.h();
        ArrayList<aq> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            aq a10 = a(iterator2.next());
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        arVar.f40116d = arrayList;
        HashMap hashMap = new HashMap();
        arVar.f40117e = hashMap;
        hashMap.put("A7", b4.f39099g);
        arVar.f40117e.put("A6", b4.o());
        arVar.f40117e.put("A5", b4.n());
        Map<String, String> map = arVar.f40117e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b4.l());
        map.put("A2", sb2.toString());
        Map<String, String> map2 = arVar.f40117e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b4.l());
        map2.put("A1", sb3.toString());
        arVar.f40117e.put("A24", b4.f39100h);
        Map<String, String> map3 = arVar.f40117e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b4.m());
        map3.put("A17", sb4.toString());
        arVar.f40117e.put("A15", b4.r());
        Map<String, String> map4 = arVar.f40117e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) b4.s());
        map4.put("A13", sb5.toString());
        arVar.f40117e.put("F08", b4.f39114v);
        arVar.f40117e.put("F09", b4.f39115w);
        Map<String, String> z10 = b4.z();
        if (z10 != null && z10.size() > 0) {
            for (Map.Entry<String, String> entry : z10.entrySet()) {
                arVar.f40117e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                x.e("unknown up type %d ", Integer.valueOf(i10));
                return null;
            }
            arVar.f40113a = (byte) 2;
        } else {
            arVar.f40113a = (byte) 1;
        }
        return arVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                i iVar = new i(bArr);
                iVar.a("utf-8");
                newInstance.a(iVar);
                return newInstance;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static am a(Context context, int i10, byte[] bArr) {
        String str;
        com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c4 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b4 != null && c4 != null) {
            try {
                am amVar = new am();
                synchronized (b4) {
                    amVar.f40051a = 1;
                    amVar.f40052b = b4.f();
                    amVar.f40053c = b4.f39095c;
                    amVar.f40054d = b4.f39102j;
                    amVar.f40055e = b4.f39104l;
                    amVar.f40056f = b4.f39098f;
                    amVar.f40057g = i10;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    amVar.f40058h = bArr;
                    amVar.f40059i = b4.i();
                    amVar.f40060j = b4.f39100h;
                    amVar.f40061k = new HashMap();
                    amVar.f40062l = b4.e();
                    amVar.f40063m = c4.f39135n;
                    amVar.f40065o = b4.h();
                    amVar.f40066p = com.tencent.bugly.crashreport.common.info.b.b(context);
                    amVar.f40067q = System.currentTimeMillis();
                    amVar.f40068r = b4.j();
                    amVar.f40069s = b4.h();
                    amVar.f40070t = amVar.f40066p;
                    amVar.f40064n = "com.tencent.bugly";
                    amVar.f40061k.put("A26", b4.t());
                    Map<String, String> map = amVar.f40061k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(b4.E());
                    map.put("A62", sb2.toString());
                    Map<String, String> map2 = amVar.f40061k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b4.F());
                    map2.put("A63", sb3.toString());
                    Map<String, String> map3 = amVar.f40061k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b4.A);
                    map3.put("F11", sb4.toString());
                    Map<String, String> map4 = amVar.f40061k;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(b4.f39118z);
                    map4.put("F12", sb5.toString());
                    amVar.f40061k.put("D3", b4.f39103k);
                    List<com.tencent.bugly.a> list = com.tencent.bugly.b.f39030b;
                    if (list != null) {
                        for (com.tencent.bugly.a aVar : list) {
                            String str2 = aVar.versionKey;
                            if (str2 != null && (str = aVar.version) != null) {
                                amVar.f40061k.put(str2, str);
                            }
                        }
                    }
                    amVar.f40061k.put("G15", z.c("G15", ""));
                    amVar.f40061k.put("G10", z.c("G10", ""));
                    amVar.f40061k.put("D4", z.c("D4", "0"));
                }
                Map<String, String> y10 = b4.y();
                if (y10 != null) {
                    for (Map.Entry<String, String> entry : y10.entrySet()) {
                        amVar.f40061k.put(entry.getKey(), entry.getValue());
                    }
                }
                return amVar;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add("Array");
                    arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.h().iterator2().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                arrayList.add(SymbolValues.QUESTION_EN_SYMBOL);
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.f39995b);
        jVar.a((Map) this.f39994a, 0);
        return l.a(jVar.a());
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void a(byte[] bArr) {
        this.f39996c.a(bArr);
        this.f39996c.a(this.f39995b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f39994a = this.f39996c.a((Map) hashMap, 0, false);
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
