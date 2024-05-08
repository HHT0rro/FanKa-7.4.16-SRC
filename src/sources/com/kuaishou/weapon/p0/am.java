package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35794a = "tun";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35795b = "ppp";

    /* renamed from: c, reason: collision with root package name */
    private static int f35796c;

    public static boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                if (networkCapabilities.hasTransport(4)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String b(Context context) {
        JSONArray a10;
        try {
            a10 = a();
        } catch (Throwable unused) {
        }
        if (a10 != null) {
            return a10.toString();
        }
        return a(context) ? "[\"con\"]" : "";
    }

    public static int c() {
        return f35796c;
    }

    public static String d() {
        StringBuilder sb2 = new StringBuilder();
        try {
            f35796c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    f35796c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains("proxy") || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb2.append(x509Certificate.getIssuerDN().getName());
                        sb2.append("|");
                    }
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }

    public static String b() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        if (r2 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray a() {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = "cat /proc/net/route"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L6b
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L6b
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L6b
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6b
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L68
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L68
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L68
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L68
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
        L28:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L4f
            java.lang.String r4 = com.kuaishou.weapon.p0.bo.a(r4)     // Catch: java.lang.Throwable -> L69
            java.lang.String r5 = "tun"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L69
            if (r5 != 0) goto L42
            java.lang.String r5 = "ppp"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L69
            if (r5 == 0) goto L28
        L42:
            java.lang.String r5 = "\t"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L69
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L69
            r1.add(r4)     // Catch: java.lang.Throwable -> L69
            goto L28
        L4f:
            java.util.Iterator r1 = r1.iterator2()     // Catch: java.lang.Throwable -> L69
        L53:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L61
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L69
            r0.put(r4)     // Catch: java.lang.Throwable -> L69
            goto L53
        L61:
            r3.close()     // Catch: java.io.IOException -> L64
        L64:
            r2.close()     // Catch: java.io.IOException -> L76
            goto L76
        L68:
            r2 = r1
        L69:
            r1 = r3
            goto L6c
        L6b:
            r2 = r1
        L6c:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L72
            goto L73
        L72:
        L73:
            if (r2 == 0) goto L76
            goto L64
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.am.a():org.json.JSONArray");
    }
}
