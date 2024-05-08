package com.alibaba.security.realidentity.oss.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.alibaba.security.realidentity.build.cb;
import com.alibaba.security.realidentity.build.cc;
import com.alibaba.security.realidentity.build.cd;
import com.alibaba.security.realidentity.build.cg;
import com.alibaba.security.realidentity.build.ch;
import com.alibaba.security.realidentity.build.cj;
import com.alibaba.security.realidentity.build.ck;
import com.alibaba.security.realidentity.build.cl;
import com.alibaba.security.realidentity.build.cm;
import com.alibaba.security.realidentity.build.cn;
import com.alibaba.security.realidentity.build.co;
import com.alibaba.security.realidentity.build.cr;
import com.alibaba.security.realidentity.build.cs;
import com.alibaba.security.realidentity.build.ct;
import com.alibaba.security.realidentity.build.dj;
import com.alibaba.security.realidentity.build.dw;
import com.alibaba.security.realidentity.build.dy;
import com.alibaba.security.realidentity.build.ea;
import com.alibaba.security.realidentity.build.ec;
import com.alibaba.security.realidentity.build.ee;
import com.alibaba.security.realidentity.build.eg;
import com.alibaba.security.realidentity.build.el;
import com.alibaba.security.realidentity.build.en;
import com.alibaba.security.realidentity.build.ep;
import com.alibaba.security.realidentity.build.er;
import com.alibaba.security.realidentity.build.et;
import com.alibaba.security.realidentity.build.fh;
import com.alibaba.security.realidentity.build.fj;
import com.alibaba.security.realidentity.build.fl;
import com.alibaba.security.realidentity.build.fu;
import com.alibaba.security.realidentity.build.fv;
import com.alibaba.security.realidentity.build.fx;
import com.alibaba.security.realidentity.build.fz;
import com.alibaba.security.realidentity.build.gb;
import com.alibaba.security.realidentity.oss.exception.InconsistentException;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.openalliance.ad.constant.u;
import com.mobile.auth.gatewayauth.Constant;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class OSSUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4047a = "\n";

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f4048b = Arrays.asList(cg.f3311a, cg.f3312b, cg.f3318h, "location", cg.f3320j, cg.f3315e, cg.f3316f, cg.f3313c, cg.f3317g, "delete", cg.f3321k, cg.f3328r, cg.f3329s, cg.A, "position", cg.F, cg.G, cg.H, cg.D, cg.C, cg.E, cg.I, cg.f3322l, cg.J, cg.K);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum MetadataDirective {
        COPY("COPY"),
        REPLACE("REPLACE");

        private final String directiveAsString;

        MetadataDirective(String str) {
            this.directiveAsString = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.directiveAsString;
        }
    }

    public static void a(dw dwVar, Map<String, String> map) {
        map.put(cc.f3288q, "/" + dwVar.f3522a + "/" + ct.a(dwVar.f3523b, "utf-8"));
        a(map, cc.f3293v, dwVar.f3531j);
        a(map, cc.f3292u, dwVar.f3530i);
        a(map, cc.f3290s, dwVar.f3528g);
        a(map, cc.f3291t, dwVar.f3529h);
        String str = dwVar.f3526e;
        if (str != null) {
            map.put(cc.f3279h, str);
        }
        fu fuVar = dwVar.f3527f;
        if (fuVar != null) {
            map.put(cc.f3294w, MetadataDirective.REPLACE.toString());
            a(map, fuVar);
        }
        if (map.containsKey("Content-Length")) {
            map.remove("Content-Length");
        }
    }

    public static boolean a(long j10, boolean z10, long j11) {
        return z10 ? 0 <= j10 && j10 <= j11 : 0 < j10 && j10 <= j11;
    }

    private static void b(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            map.remove(str);
        }
    }

    public static boolean c(String str) {
        for (String str2 : cb.f3270p) {
            if (str.toLowerCase().endsWith(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str) throws Exception {
        if (str != null) {
            return str.equals(InetAddress.getByName(str).getHostAddress());
        }
        throw new Exception("host is null");
    }

    private static boolean e(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-z0-9][a-z0-9_\\-]{2,62}$");
    }

    private static void f(String str) {
        if (!(str == null ? false : str.matches("^[a-z0-9][a-z0-9_\\-]{2,62}$"))) {
            throw new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        }
    }

    private static boolean g(String str) {
        if (str != null && str.length() > 0 && str.length() <= 1023) {
            try {
                str.getBytes("utf-8");
                char[] charArray = str.toCharArray();
                char c4 = charArray[0];
                if (c4 != '/' && c4 != '\\') {
                    for (char c10 : charArray) {
                        if (c10 != '\t' && c10 < ' ') {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return false;
    }

    private static void h(String str) {
        if (!g(str)) {
            throw new IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        }
    }

    private static String b(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String str : list) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(str);
            z10 = false;
        }
        return sb2.toString();
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : cb.f3271q) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(OSSRequest oSSRequest) {
        return !(oSSRequest instanceof fh);
    }

    public static void b(dj djVar) throws Exception {
        String a10;
        cd.b("signRequest start");
        if (djVar.f3469f) {
            cj cjVar = djVar.f3472i;
            if (cjVar != null) {
                cm cmVar = null;
                boolean z10 = cjVar instanceof cl;
                if (z10) {
                    cmVar = ((cl) cjVar).b();
                    if (cmVar != null) {
                        djVar.a().put(cc.G, cmVar.f3347c);
                    } else {
                        cd.d("Can't get a federation token");
                        throw new IOException("Can't get a federation token");
                    }
                } else if (cjVar instanceof co) {
                    cmVar = cjVar.a();
                    djVar.a().put(cc.G, cmVar.f3347c);
                }
                String a11 = a(djVar);
                cd.b("get contentToSign");
                if (!z10 && !(cjVar instanceof co)) {
                    if (cjVar instanceof cn) {
                        cn cnVar = (cn) cjVar;
                        a10 = a(cnVar.f3349a, cnVar.f3350b, a11);
                    } else {
                        a10 = cjVar instanceof ck ? ((ck) cjVar).b() : "---initValue---";
                    }
                } else {
                    a10 = a(cmVar.f3345a, cmVar.f3346b, a11);
                }
                cd.c("signed content: " + a11 + "   \n ---------   signature: " + a10);
                cd.b("get signature");
                djVar.a().put(cs.K, a10);
                return;
            }
            throw new IllegalStateException("当前CredentialProvider为空！！！\n1. 请检查您是否在初始化OSSService时设置CredentialProvider;\n2. 如果您bucket为公共权限，请确认获取到Bucket后已经调用Bucket中接口声明ACL;");
        }
    }

    public static String a(List<fv> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<CompleteMultipartUpload>\n");
        for (fv fvVar : list) {
            sb2.append("<Part>\n");
            sb2.append("<PartNumber>" + fvVar.f3703a + "</PartNumber>\n");
            sb2.append("<ETag>" + fvVar.f3704b + "</ETag>\n");
            sb2.append("</Part>\n");
        }
        sb2.append("</CompleteMultipartUpload>\n");
        return sb2.toString();
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static void a(Map<String, String> map, String str, Date date) {
        if (date != null) {
            map.put(str, cr.a(date));
        }
    }

    private static void a(Map<String, String> map, String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        map.put(str, b(list));
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String a(dj djVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(djVar.f3468e.toString() + "\n");
        Map a10 = djVar.a();
        TreeMap treeMap = new TreeMap();
        if (a10 != null) {
            for (Map.Entry entry : a10.entrySet()) {
                if (entry.getKey() != null) {
                    String lowerCase = ((String) entry.getKey()).toLowerCase();
                    if (lowerCase.equals("Content-Type".toLowerCase()) || lowerCase.equals(cs.P.toLowerCase()) || lowerCase.equals("Date".toLowerCase()) || lowerCase.startsWith(cc.f3272a)) {
                        treeMap.put(lowerCase, ((String) entry.getValue()).trim());
                    }
                }
            }
        }
        if (!treeMap.containsKey("Content-Type".toLowerCase())) {
            treeMap.put("Content-Type".toLowerCase(), "");
        }
        if (!treeMap.containsKey(cs.P.toLowerCase())) {
            treeMap.put(cs.P.toLowerCase(), "");
        }
        for (Map.Entry entry2 : treeMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (str.startsWith(cc.f3272a)) {
                sb2.append(str);
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                sb2.append(value);
            } else {
                sb2.append(value);
            }
            sb2.append("\n");
        }
        String str2 = djVar.f3466c;
        String str3 = djVar.f3467d;
        Map<String, String> map = djVar.f3470g;
        sb2.append(a((str2 == null && str3 == null) ? "/" : str3 == null ? "/" + str2 + "/" : "/" + str2 + "/" + str3, map));
        return sb2.toString();
    }

    private static String b(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        return simOperator != null ? (simOperator.equals("46000") || simOperator.equals("46002")) ? Constant.CMCC : simOperator.equals("46001") ? Constant.CUCC : simOperator.equals("46003") ? Constant.CTCC : simOperator : "";
    }

    public static String b(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("x-oss-process=");
        if (str3.startsWith("image/")) {
            sb2.append(str3);
        } else {
            sb2.append("image/");
            sb2.append(str3);
        }
        sb2.append("|sys/");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            String encodeToString2 = Base64.encodeToString(str2.getBytes(), 2);
            sb2.append("saveas,o_");
            sb2.append(encodeToString2);
            sb2.append(",b_");
            sb2.append(encodeToString);
        }
        String sb3 = sb2.toString();
        cd.b("ImagePersistent body : ".concat(String.valueOf(sb3)));
        return sb3;
    }

    private static String a(String str, String str2, Map<String, String> map) {
        String str3 = "/";
        if (str != null || str2 != null) {
            if (str2 == null) {
                str3 = "/" + str + "/";
            } else {
                str3 = "/" + str + "/" + str2;
            }
        }
        return a(str3, map);
    }

    private static String a(String str, Map<String, String> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (map != null) {
            String[] strArr = (String[]) map.h().toArray(new String[map.size()]);
            Arrays.sort(strArr);
            char c4 = '?';
            for (String str2 : strArr) {
                if (f4048b.contains(str2)) {
                    sb2.append(c4);
                    sb2.append(str2);
                    String str3 = map.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        sb2.append("=");
                        sb2.append(str3);
                    }
                    c4 = SymbolValues.CHAR_AND_SYMBOL;
                }
            }
        }
        return sb2.toString();
    }

    public static String a(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!z10) {
                sb2.append("&");
            }
            sb2.append(ct.a(key, str));
            if (!TextUtils.isEmpty(value)) {
                sb2.append("=");
                sb2.append(ct.a(value, str));
            }
            z10 = false;
        }
        return sb2.toString();
    }

    public static String a(Map<String, String> map) {
        return Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2);
    }

    public static String a(String str, String str2, String str3) {
        try {
            new ch();
            return "OSS " + str + u.bD + ch.a(str2, str3).trim();
        } catch (Exception e2) {
            throw new IllegalStateException("Compute signature failed!", e2);
        }
    }

    public static boolean a(String str, List<String> list) {
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.endsWith(iterator2.next().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void a(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    private static boolean a(OSSRequest oSSRequest) {
        boolean z10;
        boolean z11;
        return ((oSSRequest instanceof fl) || (oSSRequest instanceof fh) || (oSSRequest instanceof dy) || (oSSRequest instanceof ee) || (oSSRequest instanceof en) || (oSSRequest instanceof el) || (oSSRequest instanceof eg) || (oSSRequest instanceof fj) || (oSSRequest instanceof et) || (oSSRequest instanceof gb) || ((z10 = oSSRequest instanceof fz)) || ((z11 = oSSRequest instanceof er)) || z10 || z11 || (oSSRequest instanceof ec) || (oSSRequest instanceof fx) || (oSSRequest instanceof ep) || (oSSRequest instanceof ea)) ? false : true;
    }

    public static String a(String str, String str2) {
        String mimeTypeFromExtension;
        String mimeTypeFromExtension2;
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        return (str == null || (mimeTypeFromExtension2 = singleton.getMimeTypeFromExtension(str.substring(str.lastIndexOf(46) + 1))) == null) ? (str2 == null || (mimeTypeFromExtension = singleton.getMimeTypeFromExtension(str2.substring(str2.lastIndexOf(46) + 1))) == null) ? "application/octet-stream" : mimeTypeFromExtension : mimeTypeFromExtension2;
    }

    public static String a(Context context) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("=====[device info]=====\n");
        sb2.append("[INFO]: android_version：" + Build.VERSION.RELEASE + "\n");
        sb2.append("[INFO]: mobile_model：" + Build.MODEL + "\n");
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null) {
            simOperator = "";
        } else if (simOperator.equals("46000") || simOperator.equals("46002")) {
            simOperator = Constant.CMCC;
        } else if (simOperator.equals("46001")) {
            simOperator = Constant.CUCC;
        } else if (simOperator.equals("46003")) {
            simOperator = Constant.CTCC;
        }
        if (!TextUtils.isEmpty(simOperator)) {
            sb2.append("[INFO]: operator_name：" + simOperator + "\n");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            str = "unconnected";
            str2 = "unknown";
        } else {
            str2 = activeNetworkInfo.getTypeName() + " ";
            str = u.bf;
        }
        sb2.append("[INFO]: network_state：" + str + "\n");
        sb2.append("[INFO]: network_type：".concat(String.valueOf(str2)));
        return sb2.toString();
    }

    public static void a(Long l10, Long l11, String str) throws InconsistentException {
        if (l10 != null && l11 != null && !l10.equals(l11)) {
            throw new InconsistentException(l10, l11, str);
        }
    }

    public static String a(Map<String, String> map, Map<String, String> map2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("x-oss-process=trigger/callback,callback_");
        if (map != null && map.size() > 0) {
            sb2.append(Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2));
        }
        sb2.append(",callback-var_");
        if (map2 != null && map2.size() > 0) {
            sb2.append(Base64.encodeToString(new JSONObject(map2).toString().getBytes(), 2));
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Map<String, String> map, fu fuVar) {
        if (fuVar == null) {
            return;
        }
        Map unmodifiableMap = Collections.unmodifiableMap(fuVar.f3702c);
        if (unmodifiableMap != null) {
            for (Map.Entry entry : unmodifiableMap.entrySet()) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        Map<String, String> map2 = fuVar.f3701b;
        if (map2 != null) {
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                String key = entry2.getKey();
                String value = entry2.getValue();
                if (key != null) {
                    key = key.trim();
                }
                if (value != null) {
                    value = value.trim();
                }
                map.put(key, value);
            }
        }
    }

    public static void a(fh fhVar, Map<String, String> map) {
        String str = fhVar.f3606a;
        if (str != null) {
            map.put(cg.f3323m, str);
        }
        String str2 = fhVar.f3607b;
        if (str2 != null) {
            map.put(cg.f3325o, str2);
        }
        Integer num = fhVar.f3608c;
        if (num != null) {
            map.put(cg.f3326p, Integer.toString(num.intValue()));
        }
    }

    public static void a(fl flVar, Map<String, String> map) {
        String str = flVar.f3637b;
        if (str != null) {
            map.put(cg.f3323m, str);
        }
        String str2 = flVar.f3638c;
        if (str2 != null) {
            map.put(cg.f3325o, str2);
        }
        String str3 = flVar.f3640e;
        if (str3 != null) {
            map.put(cg.f3324n, str3);
        }
        Integer num = flVar.f3639d;
        if (num != null) {
            map.put(cg.f3326p, Integer.toString(num.intValue()));
        }
        String str4 = flVar.f3641f;
        if (str4 != null) {
            map.put(cg.f3327q, str4);
        }
    }

    public static void a(fj fjVar, Map<String, String> map) {
        String str = fjVar.f3618b;
        if (str != null) {
            map.put(cg.f3324n, str);
        }
        Integer num = fjVar.f3620d;
        if (num != null) {
            map.put(cg.f3330t, Integer.toString(num.intValue()));
        }
        String str2 = fjVar.f3621e;
        if (str2 != null) {
            map.put(cg.f3332v, str2);
        }
        String str3 = fjVar.f3619c;
        if (str3 != null) {
            map.put(cg.f3323m, str3);
        }
        String str4 = fjVar.f3622f;
        if (str4 != null) {
            map.put(cg.f3331u, str4);
        }
        String str5 = fjVar.f3623g;
        if (str5 != null) {
            map.put(cg.f3327q, str5);
        }
    }

    public static void a(OSSRequest oSSRequest, dj djVar) {
        boolean z10;
        boolean z11;
        boolean z12 = oSSRequest instanceof fh;
        boolean z13 = false;
        if (!z12) {
            String str = djVar.f3466c;
            if (!(str == null ? false : str.matches("^[a-z0-9][a-z0-9_\\-]{2,62}$"))) {
                throw new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
            }
        }
        if (!(oSSRequest instanceof fl) && !z12 && !(oSSRequest instanceof dy) && !(oSSRequest instanceof ee) && !(oSSRequest instanceof en) && !(oSSRequest instanceof el) && !(oSSRequest instanceof eg) && !(oSSRequest instanceof fj) && !(oSSRequest instanceof et) && !(oSSRequest instanceof gb) && !((z10 = oSSRequest instanceof fz)) && !((z11 = oSSRequest instanceof er)) && !z10 && !z11 && !(oSSRequest instanceof ec) && !(oSSRequest instanceof fx) && !(oSSRequest instanceof ep) && !(oSSRequest instanceof ea)) {
            z13 = true;
        }
        if (z13) {
            h(djVar.f3467d);
        }
        if (oSSRequest instanceof dw) {
            h(((dw) oSSRequest).f3525d);
        }
    }
}
