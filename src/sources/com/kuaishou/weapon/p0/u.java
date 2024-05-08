package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36243a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f36244b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f36245c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final int f36246d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f36247e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final int f36248f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f36249g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f36250h = 4;

    /* renamed from: o, reason: collision with root package name */
    private static long f36251o;

    /* renamed from: j, reason: collision with root package name */
    private Context f36253j;

    /* renamed from: k, reason: collision with root package name */
    private q f36254k;

    /* renamed from: l, reason: collision with root package name */
    private t f36255l;

    /* renamed from: m, reason: collision with root package name */
    private File f36256m;

    /* renamed from: n, reason: collision with root package name */
    private dp f36257n;

    /* renamed from: p, reason: collision with root package name */
    private int f36258p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f36260r;

    /* renamed from: q, reason: collision with root package name */
    private int f36259q = 0;

    /* renamed from: i, reason: collision with root package name */
    public List<Integer> f36252i = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    private Map<Integer, a> f36261s = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f36262a;

        public a(int i10) {
            this.f36262a = i10;
        }
    }

    public u(Context context, int i10, boolean z10) {
        this.f36258p = 0;
        this.f36260r = false;
        this.f36253j = context;
        this.f36254k = q.a(context);
        this.f36255l = t.a(context);
        this.f36257n = dp.a(context);
        this.f36256m = new File(context.getFilesDir(), ".tmp");
        this.f36258p = i10;
        this.f36260r = z10;
    }

    public JSONObject a() {
        try {
            String str = cu.f35992a + cu.f35998g;
            String a10 = cv.a(this.f36253j);
            if (!TextUtils.isEmpty(a10)) {
                str = str + SymbolValues.QUESTION_EN_SYMBOL + a10;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c4 = cv.c(this.f36253j);
            if (c4 != null) {
                jSONObject.put("data", new bn(this.f36253j).c(c4.toString()));
            }
            l a11 = l.a(this.f36253j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a11.a(mVar));
            int optInt = jSONObject2.optInt("result", 0);
            if (optInt != 1) {
                if (optInt != -7) {
                    return null;
                }
                dp.a(this.f36253j).a(dp.f36096a, 1, false);
                return null;
            }
            String a12 = new bn(this.f36253j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a12)) {
                if (this.f36259q == 0) {
                    this.f36259q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a12);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            dp dpVar = this.f36257n;
            if (dpVar == null) {
                return null;
            }
            dpVar.a(dp.f36097b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z10;
        try {
            synchronized (u.class) {
                try {
                    int i10 = this.f36258p;
                    if (i10 == 1 || i10 == 2 || i10 == 4 || this.f36260r || System.currentTimeMillis() - f36251o >= com.huawei.openalliance.ad.constant.u.as) {
                        this.f36255l.d();
                        f36251o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.f36257n.a(dp.f36097b)) - (this.f36257n.a(dp.f36098c, 6) * 3600000) > 0) {
                            List<s> a10 = this.f36255l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject a11 = a();
                            if (a11 != null) {
                                boolean z11 = false;
                                try {
                                    boolean b4 = dm.b(this.f36253j);
                                    Iterator<String> keys = a11.keys();
                                    HashSet hashSet = new HashSet();
                                    boolean z12 = false;
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (b4 && next.endsWith("64")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                                z12 = true;
                                            } else {
                                                z12 = true;
                                            }
                                        } else if (!b4 && next.endsWith("32")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                                z12 = true;
                                            } else {
                                                z12 = true;
                                            }
                                        } else {
                                            if (b4 && next.endsWith("v8")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                    z12 = true;
                                                }
                                            } else if (!b4 && next.endsWith("v7")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                                }
                                            }
                                            z12 = true;
                                        }
                                    }
                                    if (z12) {
                                        Iterator<E> iterator2 = hashSet.iterator2();
                                        while (iterator2.hasNext()) {
                                            a11.remove((String) iterator2.next());
                                        }
                                    }
                                    z11 = z12;
                                } catch (Throwable unused) {
                                }
                                Iterator<String> keys2 = a11.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    s a12 = o.a(a11.optJSONObject(next2));
                                    if (a12 != null) {
                                        if (z11 && !a12.f36215y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                            a12.f36215y = true;
                                        }
                                        if (a12.f36212v) {
                                            arrayList4.add(next2);
                                        }
                                        if (!a12.f36215y) {
                                            arrayList3.add(a12);
                                        }
                                        int indexOf = a10.indexOf(a12);
                                        if (indexOf >= 0 && a12.f36215y) {
                                            s sVar = a10.get(indexOf);
                                            if (dn.b(a12.f36194d, sVar.f36194d)) {
                                                int i11 = a12.f36214x;
                                                if (i11 != sVar.f36214x) {
                                                    this.f36255l.c(a12.f36191a, i11);
                                                }
                                                if (!this.f36255l.d(a12.f36191a)) {
                                                    arrayList2.add(a12);
                                                }
                                                it = keys2;
                                                jSONObject = a11;
                                                z10 = z11;
                                            } else {
                                                jSONObject = a11;
                                                z10 = z11;
                                                it = keys2;
                                                this.f36257n.a(dp.f36097b, System.currentTimeMillis(), true);
                                                int i12 = a12.f36214x;
                                                if (i12 != sVar.f36214x) {
                                                    this.f36255l.c(a12.f36191a, i12);
                                                }
                                                arrayList.add(a12);
                                            }
                                            a10.remove(indexOf);
                                        } else {
                                            it = keys2;
                                            jSONObject = a11;
                                            z10 = z11;
                                            if (a12.f36215y) {
                                                arrayList2.add(a12);
                                            }
                                        }
                                        a11 = jSONObject;
                                        z11 = z10;
                                        keys2 = it;
                                    }
                                }
                                for (s sVar2 : a10) {
                                    if (!arrayList4.contains(sVar2.f36193c)) {
                                        List<Integer> list = this.f36252i;
                                        if (list != null) {
                                            list.add(Integer.valueOf(sVar2.f36191a));
                                        }
                                        this.f36254k.a(sVar2.f36193c);
                                    }
                                }
                                for (s sVar3 : arrayList3) {
                                    if (!arrayList4.contains(sVar3.f36193c)) {
                                        List<Integer> list2 = this.f36252i;
                                        if (list2 != null) {
                                            list2.add(Integer.valueOf(sVar3.f36191a));
                                        }
                                        this.f36254k.a(sVar3.f36193c);
                                    }
                                }
                                ArrayList<s> arrayList5 = new ArrayList();
                                if (arrayList2.size() != 0) {
                                    arrayList5.addAll(arrayList2);
                                }
                                if (arrayList.size() != 0) {
                                    arrayList5.addAll(arrayList);
                                }
                                for (s sVar4 : arrayList5) {
                                    if (sVar4 != null) {
                                        if (arrayList.contains(sVar4)) {
                                            this.f36254k.a(sVar4.f36191a, sVar4.f36194d, (PackageInfo) null);
                                        } else if (arrayList2.contains(sVar4)) {
                                            a(sVar4);
                                        }
                                    }
                                }
                            } else {
                                throw new Exception("pluginJsonObject is null ");
                            }
                        } else {
                            this.f36254k.c();
                            this.f36255l.b();
                        }
                    }
                } finally {
                    WeaponHI.iD();
                }
            }
        } catch (Throwable unused2) {
            this.f36254k.c();
            this.f36255l.b();
        }
    }

    private void a(s sVar) {
        try {
            if (!TextUtils.isEmpty(sVar.f36200j) && sVar.f36200j.length() >= 10) {
                if (!this.f36256m.exists()) {
                    this.f36256m.mkdir();
                }
                File file = new File(this.f36256m, sVar.f36191a + "-" + sVar.f36194d + ".tmp");
                File file2 = new File(this.f36256m, sVar.f36191a + "-" + sVar.f36194d + ".zip");
                boolean a10 = l.a(this.f36253j).a(sVar.f36199i, file);
                if (!a10) {
                    a10 = l.a(this.f36253j).a(sVar.f36199i, file);
                }
                if (a10) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    int c4 = b.c(file.getAbsolutePath(), file2.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c4 != 0) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        a10 = false;
                    }
                    if (c4 == 0 && file.exists()) {
                        file.delete();
                    }
                } else {
                    this.f36261s.put(Integer.valueOf(sVar.f36191a), new a(3));
                }
                String a11 = f.a(file2);
                if (a10 && sVar.f36200j.equals(a11)) {
                    dn.a(file2.getAbsolutePath(), Boolean.TRUE);
                    sVar.f36195e = file2.getAbsolutePath();
                    if (this.f36254k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.f36261s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f36191a))) {
                            this.f36261s.put(Integer.valueOf(sVar.f36191a), new a(1));
                        }
                        this.f36257n.a(dp.f36097b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.f36261s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f36191a))) {
                        this.f36261s.put(Integer.valueOf(sVar.f36191a), new a(4));
                    }
                    this.f36254k.a(sVar.f36191a, sVar.f36194d, (PackageInfo) null);
                    return;
                }
                if (file.exists()) {
                    file.length();
                    file.delete();
                }
                this.f36254k.a(sVar.f36191a, sVar.f36194d, (PackageInfo) null);
                return;
            }
            this.f36254k.a(sVar.f36191a, sVar.f36194d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.f36254k.a(sVar.f36191a, sVar.f36194d, (PackageInfo) null);
        }
    }
}
