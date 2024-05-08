package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.mobads.sdk.internal.bk;
import com.baidu.mobads.sdk.internal.by;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.service.module.PushChannelRegion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class v1 {

    /* renamed from: j, reason: collision with root package name */
    public static Context f48422j;

    /* renamed from: k, reason: collision with root package name */
    public static v1 f48423k;

    /* renamed from: l, reason: collision with root package name */
    public static a f48424l;

    /* renamed from: m, reason: collision with root package name */
    public static String f48425m;

    /* renamed from: n, reason: collision with root package name */
    public static String f48426n;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, s1> f48428a;

    /* renamed from: b, reason: collision with root package name */
    public u1 f48429b;

    /* renamed from: c, reason: collision with root package name */
    public b f48430c;

    /* renamed from: d, reason: collision with root package name */
    public String f48431d;

    /* renamed from: e, reason: collision with root package name */
    public long f48432e;

    /* renamed from: f, reason: collision with root package name */
    public final long f48433f;

    /* renamed from: g, reason: collision with root package name */
    public long f48434g;

    /* renamed from: h, reason: collision with root package name */
    public String f48435h;

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, r1> f48421i = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    public static boolean f48427o = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        v1 a(Context context, u1 u1Var, b bVar, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface b {
        String a(String str);
    }

    public v1(Context context, u1 u1Var, b bVar, String str) {
        this(context, u1Var, bVar, str, null, null);
    }

    public v1(Context context, u1 u1Var, b bVar, String str, String str2, String str3) {
        this.f48428a = new HashMap();
        this.f48431d = "0";
        this.f48432e = 0L;
        this.f48433f = 15L;
        this.f48434g = 0L;
        this.f48435h = "isp_prov_city_country_ip";
        this.f48430c = bVar;
        this.f48429b = u1Var == null ? new w1(this) : u1Var;
        this.f48431d = str;
        f48425m = str2 == null ? context.getPackageName() : str2;
        f48426n = str3 == null ? A() : str3;
    }

    public static synchronized v1 c() {
        v1 v1Var;
        synchronized (v1.class) {
            v1Var = f48423k;
            if (v1Var == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return v1Var;
    }

    public static String d() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Context context = f48422j;
        if (context == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable unused) {
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() != 1) {
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        }
        WifiManager wifiManager = (WifiManager) f48422j.getSystemService("wifi");
        if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
            return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
        }
        return "unknown";
    }

    public static String e(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i10 = 0; i10 < bytes.length; i10++) {
                byte b4 = bytes[i10];
                int i11 = b4 & 240;
                if (i11 != 240) {
                    bytes[i10] = (byte) (((b4 & 15) ^ ((byte) (((b4 >> 4) + length) & 15))) | i11);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static synchronized void j(Context context, u1 u1Var, b bVar, String str, String str2, String str3) {
        synchronized (v1.class) {
            Context applicationContext = context.getApplicationContext();
            f48422j = applicationContext;
            if (applicationContext == null) {
                f48422j = context;
            }
            if (f48423k == null) {
                a aVar = f48424l;
                if (aVar == null) {
                    f48423k = new v1(context, u1Var, bVar, str, str2, str3);
                } else {
                    f48423k = aVar.a(context, u1Var, bVar, str);
                }
            }
        }
    }

    public static synchronized void k(a aVar) {
        synchronized (v1.class) {
            f48424l = aVar;
            f48423k = null;
        }
    }

    public static void n(String str, String str2) {
        r1 r1Var = f48421i.get(str);
        synchronized (f48421i) {
            if (r1Var == null) {
                r1 r1Var2 = new r1(str);
                r1Var2.h(bk.f9895d);
                r1Var2.j(str2);
                f48421i.put(str, r1Var2);
            } else {
                r1Var.j(str2);
            }
        }
    }

    public final String A() {
        try {
            PackageInfo packageInfo = f48422j.getPackageManager().getPackageInfo(f48422j.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public r1 a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return b(new URL(str).getHost(), true);
    }

    public r1 b(String str, boolean z10) {
        r1 w3;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (!this.f48429b.a(str)) {
            return null;
        }
        r1 t2 = t(str);
        return (t2 == null || !t2.u()) ? (z10 && j0.p(f48422j) && (w3 = w(str)) != null) ? w3 : new x1(this, str, t2) : t2;
    }

    public String f(ArrayList<String> arrayList, String str, String str2, boolean z10) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<i0> arrayList3 = new ArrayList();
        arrayList3.add(new f0("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new f0("conpt", e(j0.g(f48422j))));
        }
        if (z10) {
            arrayList3.add(new f0("reserved", "1"));
        }
        arrayList3.add(new f0(Constant.MAP_KEY_UUID, str2));
        arrayList3.add(new f0("list", p0.d(arrayList, ",")));
        arrayList3.add(new f0("countrycode", kc.a.c(f48422j).f()));
        r1 t2 = t(q());
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", q());
        if (t2 == null) {
            arrayList2.add(format);
            synchronized (f48421i) {
                r1 r1Var = f48421i.get("resolver.msg.xiaomi.net");
                if (r1Var != null) {
                    Iterator<String> iterator2 = r1Var.e(true).iterator2();
                    while (iterator2.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", iterator2.next()));
                    }
                }
            }
        } else {
            arrayList2 = t2.d(format);
        }
        Iterator<String> iterator22 = arrayList2.iterator2();
        IOException e2 = null;
        while (iterator22.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(iterator22.next()).buildUpon();
            for (i0 i0Var : arrayList3) {
                buildUpon.appendQueryParameter(i0Var.a(), i0Var.b());
            }
            try {
                b bVar = this.f48430c;
                return bVar == null ? j0.h(f48422j, new URL(buildUpon.toString())) : bVar.a(buildUpon.toString());
            } catch (IOException e10) {
                e2 = e10;
            }
        }
        if (e2 == null) {
            return null;
        }
        fc.c.i("network exception: " + e2.getMessage());
        throw e2;
    }

    public final ArrayList<r1> g(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        y();
        synchronized (this.f48428a) {
            o();
            for (String str : this.f48428a.h()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = f48421i.isEmpty();
        synchronized (f48421i) {
            for (Object obj : f48421i.values().toArray()) {
                r1 r1Var = (r1) obj;
                if (!r1Var.u()) {
                    f48421i.remove(r1Var.f48116d);
                    isEmpty = true;
                }
            }
        }
        if (!arrayList.contains(q())) {
            arrayList.add(q());
        }
        ArrayList<r1> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList2.add(null);
        }
        try {
            String str2 = j0.r(f48422j) ? "wifi" : "wap";
            String f10 = f(arrayList, str2, this.f48431d, isEmpty);
            if (!TextUtils.isEmpty(f10)) {
                JSONObject jSONObject3 = new JSONObject(f10);
                fc.c.l(f10);
                if (by.f9988k.equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                    String string2 = jSONObject4.getString(DistrictSearchQuery.KEYWORDS_CITY);
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    fc.c.m("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i11 = 0;
                    while (i11 < arrayList.size()) {
                        String str3 = arrayList.get(i11);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            fc.c.i("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            r1 r1Var2 = new r1(str3);
                            int i12 = 0;
                            while (i12 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i12);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    r1Var2.i(new a2(string6, optJSONArray.length() - i12));
                                }
                                i12++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i11, r1Var2);
                            r1Var2.f48121i = string5;
                            r1Var2.f48117e = string;
                            r1Var2.f48119g = string3;
                            r1Var2.f48120h = string4;
                            r1Var2.f48118f = string2;
                            if (jSONObject4.has("stat-percent")) {
                                r1Var2.g(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                r1Var2.r(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                r1Var2.h(jSONObject4.getInt(RemoteMessageConst.TTL) * 1000);
                            }
                            l(r1Var2.b());
                        }
                        i11++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j10 = bk.f9895d;
                        if (jSONObject4.has("reserved-ttl")) {
                            j10 = jSONObject4.getInt("reserved-ttl") * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                fc.c.i("no bucket found for " + next);
                            } else {
                                r1 r1Var3 = new r1(next);
                                r1Var3.h(j10);
                                for (int i13 = 0; i13 < optJSONArray2.length(); i13++) {
                                    String string7 = optJSONArray2.getString(i13);
                                    if (!TextUtils.isEmpty(string7)) {
                                        r1Var3.i(new a2(string7, optJSONArray2.length() - i13));
                                    }
                                }
                                synchronized (f48421i) {
                                    if (this.f48429b.a(next)) {
                                        f48421i.put(next, r1Var3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            fc.c.i("failed to get bucket " + e2.getMessage());
        }
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            r1 r1Var4 = arrayList2.get(i14);
            if (r1Var4 != null) {
                m(arrayList.get(i14), r1Var4);
            }
        }
        v();
        return arrayList2;
    }

    public JSONObject h() {
        JSONObject jSONObject;
        synchronized (this.f48428a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<s1> iterator2 = this.f48428a.values().iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(iterator2.next().e());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<r1> iterator22 = f48421i.values().iterator2();
            while (iterator22.hasNext()) {
                jSONArray2.put(iterator22.next().f());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    public void i() {
        synchronized (this.f48428a) {
            this.f48428a.clear();
        }
    }

    public void l(String str) {
        this.f48435h = str;
    }

    public void m(String str, r1 r1Var) {
        if (TextUtils.isEmpty(str) || r1Var == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + ((Object) r1Var));
        }
        if (this.f48429b.a(str)) {
            synchronized (this.f48428a) {
                o();
                if (this.f48428a.containsKey(str)) {
                    this.f48428a.get(str).f(r1Var);
                } else {
                    s1 s1Var = new s1(str);
                    s1Var.f(r1Var);
                    this.f48428a.put(str, s1Var);
                }
            }
        }
    }

    public boolean o() {
        synchronized (this.f48428a) {
            if (f48427o) {
                return true;
            }
            f48427o = true;
            this.f48428a.clear();
            try {
                String x10 = x();
                if (!TextUtils.isEmpty(x10)) {
                    s(x10);
                    fc.c.l("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                fc.c.i("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public r1 p(String str) {
        return b(str, true);
    }

    public String q() {
        String a10 = kc.a.c(f48422j).a();
        return (TextUtils.isEmpty(a10) || PushChannelRegion.China.name().equals(a10)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    public void r() {
        ArrayList<String> arrayList;
        synchronized (this.f48428a) {
            o();
            arrayList = new ArrayList<>(this.f48428a.h());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                s1 s1Var = this.f48428a.get(arrayList.get(size));
                if (s1Var != null && s1Var.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<r1> g3 = g(arrayList);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (g3.get(i10) != null) {
                m(arrayList.get(i10), g3.get(i10));
            }
        }
    }

    public void s(String str) {
        synchronized (this.f48428a) {
            this.f48428a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                s1 b4 = new s1().b(optJSONArray.getJSONObject(i10));
                this.f48428a.put(b4.c(), b4);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                r1 a10 = new r1("").a(optJSONArray2.getJSONObject(i11));
                f48421i.put(a10.f48116d, a10);
            }
        }
    }

    public r1 t(String str) {
        s1 s1Var;
        r1 a10;
        synchronized (this.f48428a) {
            o();
            s1Var = this.f48428a.get(str);
        }
        if (s1Var == null || (a10 = s1Var.a()) == null) {
            return null;
        }
        return a10;
    }

    public String u() {
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.f48428a) {
            for (Map.Entry<String, s1> entry : this.f48428a.entrySet()) {
                sb2.append(entry.getKey());
                sb2.append(":\n");
                sb2.append(entry.getValue().toString());
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public void v() {
        synchronized (this.f48428a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f48422j.openFileOutput(z(), 0)));
                String jSONObject = h().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e2) {
                fc.c.i("persist bucket failure: " + e2.getMessage());
            }
        }
    }

    public r1 w(String str) {
        if (System.currentTimeMillis() - this.f48434g <= this.f48432e * 60 * 1000) {
            return null;
        }
        this.f48434g = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        r1 r1Var = g(arrayList).get(0);
        if (r1Var != null) {
            this.f48432e = 0L;
            return r1Var;
        }
        long j10 = this.f48432e;
        if (j10 >= 15) {
            return null;
        }
        this.f48432e = j10 + 1;
        return null;
    }

    public String x() {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(f48422j.getFilesDir(), z());
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            s7.b(null);
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb2.toString();
                }
                sb2.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                fc.c.i("load host exception " + th.getMessage());
                return null;
            } finally {
                s7.b(bufferedReader);
            }
        }
    }

    public void y() {
        String next;
        synchronized (this.f48428a) {
            Iterator<s1> iterator2 = this.f48428a.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().g(true);
            }
            while (true) {
                for (boolean z10 = false; !z10; z10 = true) {
                    Iterator<String> iterator22 = this.f48428a.h().iterator2();
                    while (iterator22.hasNext()) {
                        next = iterator22.next();
                        if (this.f48428a.get(next).d().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f48428a.remove(next);
            }
        }
    }

    public String z() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f48422j.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "com.xiaomi";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return "com.xiaomi";
    }
}
