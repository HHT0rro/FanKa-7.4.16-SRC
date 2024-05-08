package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kuaishou.weapon.p0.bq;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class EQsUZ {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
            android.content.Context r5 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> L15
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L15
            if (r5 == 0) goto L15
            android.content.pm.PackageInfo r5 = r5.getPackageArchiveInfo(r6, r1)     // Catch: java.lang.Throwable -> L15
            if (r5 == 0) goto L15
            java.lang.String r5 = r5.packageName     // Catch: java.lang.Throwable -> L15
            goto L16
        L15:
            r5 = r0
        L16:
            if (r5 == 0) goto L19
            return r5
        L19:
            java.lang.String r2 = "AndroidManifest.xml"
            r3 = 19
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L62
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L62
            java.util.zip.ZipEntry r6 = r4.getEntry(r2)     // Catch: java.lang.Throwable -> L63
            java.io.InputStream r6 = r4.getInputStream(r6)     // Catch: java.lang.Throwable -> L63
            com.tencent.turingface.sdk.mfa.d9yDk r0 = new com.tencent.turingface.sdk.mfa.d9yDk     // Catch: java.lang.Throwable -> L60
            r0.<init>()     // Catch: java.lang.Throwable -> L60
            org.w3c.dom.Document r0 = r0.a(r6)     // Catch: java.lang.Throwable -> L60
            org.w3c.dom.NodeList r0 = r0.getChildNodes()     // Catch: java.lang.Throwable -> L60
            org.w3c.dom.Node r0 = r0.item(r1)     // Catch: java.lang.Throwable -> L60
            org.w3c.dom.NamedNodeMap r0 = r0.getAttributes()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "package"
            org.w3c.dom.Node r0 = r0.getNamedItem(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r0.getNodeValue()     // Catch: java.lang.Throwable -> L60
            com.tencent.turingcam.oqKCa.b(r6)
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r6 = com.tencent.turingface.sdk.mfa.CFgXs.f45537a     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch: java.lang.Throwable -> L55
            int r1 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L55
            goto L56
        L55:
        L56:
            if (r1 < r3) goto L5c
            com.tencent.turingcam.oqKCa.b(r4)     // Catch: java.lang.Throwable -> L79
            goto L79
        L5c:
            r4.close()     // Catch: java.lang.Throwable -> L79
            goto L79
        L60:
            r0 = r6
            goto L63
        L62:
            r4 = r0
        L63:
            com.tencent.turingcam.oqKCa.b(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r6 = com.tencent.turingface.sdk.mfa.CFgXs.f45537a     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch: java.lang.Throwable -> L6f
            int r1 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L6f
            goto L70
        L6f:
        L70:
            if (r1 < r3) goto L76
            com.tencent.turingcam.oqKCa.b(r4)     // Catch: java.lang.Throwable -> L79
            goto L79
        L76:
            r4.close()     // Catch: java.lang.Throwable -> L79
        L79:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.EQsUZ.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        byte[] bArr2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(new String(com.tencent.turingcam.oqKCa.c("4D4435")));
            messageDigest.update(bArr);
            bArr2 = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArr2 = null;
        }
        return com.tencent.turingcam.oqKCa.a(bArr2);
    }

    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            Iterator iterator2 = Collections.list(networkInterfaces).iterator2();
            while (iterator2.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) iterator2.next();
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && networkInterface.getName().matches("tun\\d+")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            if (TextUtils.isEmpty(System.getProperty("http.proxyHost"))) {
                return false;
            }
            return !TextUtils.equals(System.getProperty("http.proxyPort"), "-1");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Gc2mM a(int i10, byte[] bArr) {
        Context context;
        vneRm a10;
        KKOXW kkoxw;
        HashMap hashMap;
        Context context2;
        int i11;
        OF1Jz oF1Jz = OF1Jz.f45648b;
        oF1Jz.getClass();
        fa2Ik fa2ik = new fa2Ik();
        fa2ik.f45781g = System.currentTimeMillis();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Integer.valueOf(i10), bArr);
        fa2ik.f45782h = hashMap2;
        fa2ik.f45783i = 0;
        ShGzN shGzN = new ShGzN();
        shGzN.f45708a = 77;
        shGzN.f45709b = "77";
        shGzN.f45710c = "7A239E5DD15748A2";
        StringBuilder b4 = com.tencent.turingcam.oqKCa.b("");
        b4.append(com.tencent.turingcam.oqKCa.f45455a);
        shGzN.f45711d = b4.toString();
        shGzN.f45712e = 2;
        fa2ik.f45784j = shGzN;
        if (oF1Jz.f45650d == null) {
            oF1Jz.f45650d = new DX7Nf();
            synchronized (i3cNc.class) {
                context2 = i3cNc.f45809a;
            }
            DX7Nf dX7Nf = oF1Jz.f45650d;
            String packageName = context2.getPackageName();
            if (packageName == null) {
                packageName = "";
            }
            dX7Nf.f45574b = packageName;
            String packageName2 = context2.getPackageName();
            String str = bq.f35867e;
            try {
                PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(packageName2, 64);
                str = packageInfo.versionName;
                i11 = packageInfo.versionCode;
            } catch (Throwable unused) {
                i11 = 0;
            }
            oF1Jz.f45650d.f45573a = String.format("%s,%d", str, Integer.valueOf(i11));
        }
        fa2ik.f45785k = oF1Jz.f45650d;
        y8N3A y8n3a = new y8N3A();
        y8n3a.f45998h = oF1Jz.f45649c.b();
        oF1Jz.f45649c.getClass();
        byte[] bArr2 = null;
        y8n3a.f45992b = null;
        CvowV cvowV = oF1Jz.f45649c;
        y8n3a.f45993c = cvowV.f45549k;
        y8n3a.f45994d = 0;
        y8n3a.f45995e = cvowV.f45550l;
        y8n3a.f45996f = cvowV.f45551m;
        fa2ik.f45786l = y8n3a;
        HashMap hashMap3 = new HashMap();
        synchronized (i3cNc.class) {
            context = i3cNc.f45809a;
        }
        int a11 = HDnuc.a();
        if (a11 != 0) {
            a10 = vneRm.a(a11);
        } else {
            a10 = rBDKv.f45926a.a(context, true, 1);
        }
        String str2 = a10.f45965a;
        if (str2 == null) {
            str2 = "";
        }
        hashMap3.put(1, str2);
        CvowV cvowV2 = oF1Jz.f45649c;
        String str3 = TextUtils.isEmpty(cvowV2.f45545g) ? "" : cvowV2.f45545g;
        if (str3 == null) {
            str3 = "";
        }
        hashMap3.put(6, str3);
        hashMap3.put(4, "");
        String str4 = a10.f45970f;
        if (str4 == null) {
            str4 = "";
        }
        hashMap3.put(3, str4);
        fa2ik.f45787m = hashMap3;
        HashMap hashMap4 = new HashMap();
        Context context3 = oF1Jz.f45649c.f45543e;
        String str5 = fenkF.f45789a;
        HashMap hashMap5 = new HashMap();
        HashSet hashSet = new HashSet();
        String b10 = fenkF.b(context3, "701");
        if (!TextUtils.isEmpty(b10)) {
            hashSet.addAll(Arrays.asList(b10.split("_")));
        }
        Iterator iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            String str6 = (String) iterator2.next();
            hashMap5.put(str6, fenkF.b(context3, "TSS_" + str6));
        }
        for (String str7 : hashMap5.h()) {
            try {
                int parseInt = Integer.parseInt(str7);
                String str8 = (String) hashMap5.get(str7);
                if (str8 != null) {
                    hashMap4.put(Integer.valueOf(parseInt), str8);
                }
            } catch (Throwable unused2) {
            }
        }
        hashMap4.put(2, fenkF.b(oF1Jz.f45649c.f45543e, "602"));
        hashMap4.put(3, fenkF.b(oF1Jz.f45649c.f45543e, "702"));
        hashMap4.put(4, fenkF.b(oF1Jz.f45649c.f45543e, "703"));
        fa2ik.f45788n = hashMap4;
        String str9 = OF1Jz.f45647a;
        try {
            kkoxw = new KKOXW();
            hashMap = new HashMap();
            new HashMap();
            kkoxw.f45615d = (short) 3;
            kkoxw.f45618g = 3;
            kkoxw.f45619h = str9;
            kkoxw.f45620i = str9;
        } catch (Exception unused3) {
        }
        if (!(fa2ik instanceof Set)) {
            d5HOq d5hoq = new d5HOq(128);
            d5hoq.f45756b = "UTF-8";
            d5hoq.a((Object) fa2ik, 0);
            hashMap.put(HiAnalyticsConstant.Direction.REQUEST, fi6GY.a(d5hoq.f45755a));
            if (kkoxw.f45619h == null) {
                kkoxw.f45619h = "";
            }
            if (kkoxw.f45620i == null) {
                kkoxw.f45620i = "";
            }
            d5HOq d5hoq2 = new d5HOq(0);
            d5hoq2.f45756b = "UTF-8";
            d5hoq2.a((Map) hashMap, 0);
            kkoxw.f45621j = fi6GY.a(d5hoq2.f45755a);
            d5HOq d5hoq3 = new d5HOq(0);
            d5hoq3.f45756b = "UTF-8";
            kkoxw.a(d5hoq3);
            byte[] a12 = fi6GY.a(d5hoq3.f45755a);
            int length = a12.length + 4;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.putInt(length).put(a12).flip();
            byte[] c4 = com.tencent.turingcam.oqKCa.c(allocate.array());
            if (c4 != null) {
                bArr2 = com.tencent.turingcam.oqKCa.b(c4, com.tencent.turingcam.oqKCa.b());
                return new c9YSQ(new FLlEM(bArr2));
            }
            throw new RuntimeException("compress data fail");
        }
        throw new IllegalArgumentException("wup put err");
    }
}
