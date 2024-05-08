package na;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oa.c;
import pa.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f52176a;

    /* renamed from: b, reason: collision with root package name */
    public String f52177b;

    /* renamed from: c, reason: collision with root package name */
    public String f52178c;

    /* renamed from: d, reason: collision with root package name */
    public String f52179d;

    /* renamed from: e, reason: collision with root package name */
    public String f52180e;

    /* renamed from: h, reason: collision with root package name */
    public int f52183h;

    /* renamed from: l, reason: collision with root package name */
    public String f52187l;

    /* renamed from: m, reason: collision with root package name */
    public String f52188m;

    /* renamed from: n, reason: collision with root package name */
    public Intent f52189n;

    /* renamed from: o, reason: collision with root package name */
    public ServiceVerifyKit.Builder.ComponentType f52190o;

    /* renamed from: t, reason: collision with root package name */
    public Context f52195t;

    /* renamed from: u, reason: collision with root package name */
    public String f52196u;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String[]> f52181f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public Map<String, Integer> f52182g = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public List<String> f52184i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public List<ServiceVerifyKit.b> f52185j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f52186k = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f52191p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f52192q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f52193r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f52194s = 0;

    public a(Context context) {
        this.f52195t = context;
    }

    public static String f(@NonNull String str) {
        b bVar;
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (ClassNotFoundException unused) {
            bVar = b.f52973b;
            str2 = "getSystemProperties ClassNotFoundException";
            bVar.a("MatchAppFinder", str2);
            return "";
        } catch (Exception unused2) {
            bVar = b.f52973b;
            str2 = "getSystemProperties Exception while getting system property";
            bVar.a("MatchAppFinder", str2);
            return "";
        }
    }

    public final int a(Bundle bundle, int i10) {
        if (!bundle.containsKey("ag.application.base_priority")) {
            return i10 + 1000;
        }
        try {
            return i10 + bundle.getInt("ag.application.base_priority");
        } catch (Exception unused) {
            b.f52973b.a("MatchAppFinder", "skip package " + bundle.getString("ag.application.base_priority") + " is not number");
            return i10 + 1000;
        }
    }

    public final int b(Bundle bundle, int i10, List<ServiceVerifyKit.b> list) {
        int i11 = 0;
        for (ServiceVerifyKit.b bVar : list) {
            if (i10 == 1) {
                if (!bundle.containsKey(bVar.a()) || !bundle.get(bVar.a()).toString().equals(bVar.b())) {
                    return 0;
                }
                i11 = 1;
            } else if (i10 != 2) {
                b.f52973b.a("MatchAppFinder", "error input preferred package name");
            } else if (bundle.containsKey(bVar.a()) && bundle.get(bVar.a()).toString().equals(bVar.b())) {
                i11++;
            }
        }
        return i11;
    }

    public final int c(Bundle bundle, String str) {
        if (bundle.containsKey(this.f52187l)) {
            return bundle.getString(this.f52187l).equalsIgnoreCase(str) ? 1 : -1;
        }
        return 0;
    }

    public final int d(String str, List<String> list) {
        Iterator<String> iterator2 = list.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            if (iterator2.next().equals(str)) {
                i10 = 1;
            }
        }
        return i10;
    }

    public final String e(ResolveInfo resolveInfo) {
        ServiceVerifyKit.Builder.ComponentType componentType = this.f52190o;
        return ((componentType == ServiceVerifyKit.Builder.ComponentType.ACTIVITY || componentType == ServiceVerifyKit.Builder.ComponentType.BROADCAST) ? resolveInfo.activityInfo.applicationInfo : resolveInfo.serviceInfo.applicationInfo).packageName;
    }

    public List<la.a> g() {
        PackageManager packageManager = this.f52195t.getPackageManager();
        List<ResolveInfo> h10 = h(packageManager);
        if (h10.size() == 0) {
            return null;
        }
        this.f52196u = TextUtils.isEmpty(this.f52188m) ? Build.MANUFACTURER : f(this.f52188m);
        return i(h10, packageManager, this.f52183h | 128 | 64);
    }

    public final List<ResolveInfo> h(PackageManager packageManager) {
        Intent intent;
        ServiceVerifyKit.Builder.ComponentType componentType = this.f52190o;
        if (componentType == null) {
            intent = new Intent(this.f52176a);
        } else {
            if (componentType == ServiceVerifyKit.Builder.ComponentType.ACTIVITY) {
                return packageManager.queryIntentActivities(this.f52189n, this.f52183h);
            }
            if (componentType == ServiceVerifyKit.Builder.ComponentType.BROADCAST) {
                return packageManager.queryBroadcastReceivers(this.f52189n, this.f52183h);
            }
            intent = this.f52189n;
        }
        return packageManager.queryIntentServices(intent, this.f52183h);
    }

    public final List<la.a> i(List<ResolveInfo> list, PackageManager packageManager, int i10) {
        b bVar;
        StringBuilder sb2;
        String str;
        PackageInfo packageInfo;
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            String e2 = e(resolveInfo);
            try {
                packageInfo = packageManager.getPackageInfo(e2, i10);
            } catch (PackageManager.NameNotFoundException unused) {
                bVar = b.f52973b;
                sb2 = new StringBuilder();
                sb2.append("skip package ");
                sb2.append(e2);
                str = " for PackageInfo is null";
            }
            if (packageInfo.applicationInfo == null) {
                bVar = b.f52973b;
                sb2 = new StringBuilder();
                sb2.append("skip package ");
                sb2.append(e2);
                str = " for ApplicationInfo is null";
            } else {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    bVar = b.f52973b;
                    sb2 = new StringBuilder();
                    sb2.append("skip package ");
                    sb2.append(e2);
                    str = " for no sign";
                } else {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    if (byteArray.length == 0) {
                        bVar = b.f52973b;
                        sb2 = new StringBuilder();
                        sb2.append("skip package ");
                        sb2.append(e2);
                        str = " for sign is empty";
                    } else {
                        try {
                            la.a j10 = j(packageInfo, oa.b.c(MessageDigest.getInstance("SHA-256").digest(byteArray), true), e2, resolveInfo.priority);
                            if (j10 != null) {
                                arrayList.add(j10);
                            }
                        } catch (NoSuchAlgorithmException unused2) {
                            bVar = b.f52973b;
                            sb2 = new StringBuilder();
                            sb2.append("skip package ");
                            sb2.append(e2);
                            str = " for AlgorithmException";
                        }
                    }
                }
            }
            sb2.append(str);
            bVar.a("MatchAppFinder", sb2.toString());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final la.a j(android.content.pm.PackageInfo r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r10 = this;
            android.content.pm.ApplicationInfo r11 = r11.applicationInfo
            android.os.Bundle r11 = r11.metaData
            r0 = 0
            java.lang.String r1 = "MatchAppFinder"
            if (r11 != 0) goto L25
            pa.b r11 = pa.b.f52973b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "skip package "
            r12.append(r14)
            r12.append(r13)
            java.lang.String r13 = " for metadata is null"
        L1a:
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.a(r1, r12)
            return r0
        L25:
            java.lang.String r2 = r10.f52196u
            int r7 = r10.c(r11, r2)
            java.lang.String r2 = r10.f52179d
            boolean r2 = r11.containsKey(r2)
            if (r2 != 0) goto L61
            java.lang.String r2 = r10.f52180e
            boolean r2 = r11.containsKey(r2)
            if (r2 == 0) goto L3c
            goto L61
        L3c:
            boolean r12 = r10.m(r13, r12)
            if (r12 == 0) goto L54
            r12 = 1
            r10.f52192q = r12
            java.util.Map<java.lang.String, java.lang.Integer> r12 = r10.f52182g
            java.lang.Object r12 = r12.get(r13)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r10.f52191p = r12
            goto L76
        L54:
            pa.b r11 = pa.b.f52973b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "Legacy is false, packageName is "
        L5d:
            r12.append(r14)
            goto L1a
        L61:
            boolean r12 = r10.l(r11, r13, r12)
            if (r12 != 0) goto L71
            pa.b r11 = pa.b.f52973b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "checkSinger failed, packageName is "
            goto L5d
        L71:
            r12 = 0
            r10.f52192q = r12
            r10.f52191p = r14
        L76:
            java.util.List<java.lang.String> r12 = r10.f52184i
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L86
            java.util.List<java.lang.String> r12 = r10.f52184i
            int r12 = r10.d(r13, r12)
            r10.f52193r = r12
        L86:
            java.util.List<com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$b> r12 = r10.f52185j
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L98
            int r12 = r10.f52186k
            java.util.List<com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$b> r14 = r10.f52185j
            int r12 = r10.b(r11, r12, r14)
            r10.f52194s = r12
        L98:
            int r12 = r10.f52191p
            int r5 = r10.a(r11, r12)
            la.a r11 = new la.a
            int r6 = r10.f52192q
            int r8 = r10.f52193r
            int r9 = r10.f52194s
            r3 = r11
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: na.a.j(android.content.pm.PackageInfo, java.lang.String, java.lang.String, int):la.a");
    }

    public void k(String str, String str2, String str3, String str4, String str5, Map<String, String[]> map, Map<String, Integer> map2, int i10, List<String> list, List<ServiceVerifyKit.b> list2, int i11, String str6, String str7, Intent intent, ServiceVerifyKit.Builder.ComponentType componentType) {
        this.f52176a = str;
        this.f52177b = str2;
        this.f52178c = str3;
        this.f52179d = str4;
        this.f52180e = str5;
        this.f52181f = map;
        this.f52182g = map2;
        this.f52183h = i10;
        this.f52184i = list;
        this.f52185j = list2;
        this.f52186k = i11;
        this.f52187l = str6;
        this.f52188m = str7;
        this.f52189n = intent;
        this.f52190o = componentType;
    }

    public final boolean l(Bundle bundle, String str, String str2) {
        b bVar;
        String str3;
        if (bundle.containsKey(this.f52179d) && bundle.containsKey(this.f52180e)) {
            if (n(str + "&" + str2, bundle.getString(this.f52179d), bundle.getString(this.f52180e))) {
                return true;
            }
            bVar = b.f52973b;
            str3 = "checkSinger failed";
        } else {
            bVar = b.f52973b;
            str3 = "skip package " + str + " for no signer or no certChain";
        }
        bVar.a("MatchAppFinder", str3);
        return false;
    }

    public final boolean m(String str, String str2) {
        String[] strArr;
        if (this.f52181f.containsKey(str) && (strArr = this.f52181f.get(str)) != null) {
            for (String str3 : strArr) {
                if (str2.equals(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean n(String str, String str2, String str3) {
        b bVar;
        String str4;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            bVar = b.f52973b;
            str4 = "args is invalid";
        } else {
            List<X509Certificate> k10 = c.k(str3);
            if (k10.size() == 0) {
                bVar = b.f52973b;
                str4 = "certChain is empty";
            } else if (c.h(c.b(this.f52195t), k10)) {
                X509Certificate x509Certificate = k10.get(0);
                if (!c.f(x509Certificate, this.f52177b)) {
                    bVar = b.f52973b;
                    str4 = "CN is invalid";
                } else if (c.m(x509Certificate, this.f52178c)) {
                    byte[] bArr = null;
                    try {
                        bArr = str.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        b.f52973b.b("MatchAppFinder", "checkCertChain UnsupportedEncodingException:", e2);
                    }
                    if (c.i(x509Certificate, bArr, oa.a.a(str2))) {
                        return true;
                    }
                    bVar = b.f52973b;
                    str4 = "signature is invalid";
                } else {
                    bVar = b.f52973b;
                    str4 = "OU is invalid";
                }
            } else {
                bVar = b.f52973b;
                str4 = "failed to verify cert chain";
            }
        }
        bVar.a("MatchAppFinder", str4);
        return false;
    }
}
