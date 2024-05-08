package com.tencent.turingface.sdk.mfa;

import android.os.Process;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class wmqhz {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f45985a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f45986b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f45987c;

    static {
        HashSet hashSet = new HashSet();
        f45985a = hashSet;
        f45986b = new String[0];
        hashSet.add(kC0XR.a(kC0XR.M));
        hashSet.add(kC0XR.a(kC0XR.N));
        hashSet.add(kC0XR.a(kC0XR.O));
        hashSet.add(kC0XR.a(kC0XR.P));
        hashSet.add(kC0XR.a(kC0XR.Q));
        hashSet.add(kC0XR.a(kC0XR.R));
        hashSet.add(kC0XR.a(kC0XR.S));
        hashSet.add(kC0XR.a(kC0XR.T));
        hashSet.add(kC0XR.a(kC0XR.U));
        hashSet.add(kC0XR.a(kC0XR.V));
        hashSet.add(kC0XR.a(kC0XR.W));
        hashSet.add(kC0XR.a(kC0XR.X));
        HashSet hashSet2 = new HashSet();
        f45987c = hashSet2;
        hashSet2.add(kC0XR.a(kC0XR.L));
    }

    public static List<Bwfl9> a() {
        boolean z10;
        boolean z11;
        bUA8L b4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (b4 = com.tencent.turingcam.oqKCa.b(Integer.parseInt(str))) != null) {
                            arrayList2.add(b4);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int myPid = Process.myPid();
        Iterator iterator2 = arrayList2.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            bUA8L bua8l = (bUA8L) iterator2.next();
            if (myPid == bua8l.f45748a) {
                i10 = bua8l.f45752e;
            }
        }
        if (i10 != 0 && myPid != i10) {
            Iterator iterator22 = arrayList2.iterator2();
            String str2 = "";
            while (iterator22.hasNext()) {
                bUA8L bua8l2 = (bUA8L) iterator22.next();
                if (i10 == bua8l2.f45748a) {
                    str2 = bua8l2.f45751d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Bwfl9 bwfl9 = new Bwfl9();
                bwfl9.f45535a = uAnWx.f45959a + uAnWx.f45963e;
                bwfl9.f45536b = str2;
                arrayList3.add(bwfl9);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator iterator23 = arrayList2.iterator2();
        while (iterator23.hasNext()) {
            bUA8L bua8l3 = (bUA8L) iterator23.next();
            Iterator<String> iterator24 = f45985a.iterator2();
            while (iterator24.hasNext()) {
                if (bua8l3.f45751d.contains(iterator24.next())) {
                    sb2.append(bua8l3.f45751d);
                    sb2.append("_");
                }
            }
        }
        String sb3 = sb2.toString();
        if (!TextUtils.isEmpty(sb3)) {
            Bwfl9 bwfl92 = new Bwfl9();
            bwfl92.f45535a = uAnWx.f45959a + uAnWx.f45961c;
            bwfl92.f45536b = sb3.substring(0, sb3.length() - 1);
            arrayList4.add(bwfl92);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb4 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator iterator25 = arrayList2.iterator2();
        int i11 = 0;
        while (iterator25.hasNext()) {
            bUA8L bua8l4 = (bUA8L) iterator25.next();
            if (bua8l4.f45750c == 0 && bua8l4.f45751d.startsWith("/") && !bua8l4.f45751d.startsWith("/system") && !bua8l4.f45751d.startsWith("/dev") && !bua8l4.f45751d.startsWith("/sbin") && !bua8l4.f45751d.startsWith("/init") && !bua8l4.f45751d.startsWith("/vendor") && !bua8l4.f45751d.startsWith("/bin") && !bua8l4.f45751d.startsWith("/usr") && !bua8l4.f45751d.contains("kinguser") && !bua8l4.f45751d.endsWith("so")) {
                Iterator<String> iterator26 = f45985a.iterator2();
                while (true) {
                    if (!iterator26.hasNext()) {
                        z10 = false;
                        break;
                    }
                    if (bua8l4.f45751d.contains(iterator26.next())) {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    continue;
                } else {
                    Iterator<String> iterator27 = f45987c.iterator2();
                    while (true) {
                        if (!iterator27.hasNext()) {
                            z11 = false;
                            break;
                        }
                        if (bua8l4.f45751d.contains(iterator27.next())) {
                            z11 = true;
                            break;
                        }
                    }
                    if (z11) {
                        continue;
                    } else {
                        hashSet.add(bua8l4.f45751d);
                        int i12 = i11 + 1;
                        if (i11 >= 8) {
                            break;
                        }
                        i11 = i12;
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            Iterator iterator28 = hashSet.iterator2();
            while (iterator28.hasNext()) {
                sb4.append((String) iterator28.next());
                sb4.append("%3B");
            }
            String sb5 = sb4.toString();
            Bwfl9 bwfl93 = new Bwfl9();
            bwfl93.f45535a = uAnWx.f45959a + uAnWx.f45962d;
            bwfl93.f45536b = sb5.substring(0, sb5.length() - 1);
            arrayList5.add(bwfl93);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String a10 = a(kC0XR.a(kC0XR.f45860o0), kC0XR.a(kC0XR.C0), "v4");
        if (!TextUtils.isEmpty(a10)) {
            stringBuffer.append(a10);
        }
        String a11 = a(kC0XR.a(kC0XR.f45862p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
        if (!TextUtils.isEmpty(a11)) {
            if (!TextUtils.isEmpty(a10)) {
                stringBuffer.append("_");
            }
            stringBuffer.append(a11);
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3) {
        String[] strArr;
        String[] split;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String str4 = new String(com.tencent.turingcam.oqKCa.d(str));
            if (TextUtils.isEmpty(str4)) {
                strArr = f45986b;
            } else {
                strArr = str4.split("\n");
                if (strArr == null || strArr.length == 0) {
                    strArr = f45986b;
                }
            }
        } catch (Throwable unused) {
            strArr = null;
        }
        if (strArr == null) {
            stringBuffer.append(str3 + ";-1");
            return stringBuffer.toString();
        }
        stringBuffer.append(str3 + ";0");
        new HashMap();
        HashMap hashMap = new HashMap();
        Pattern compile = Pattern.compile(str2);
        for (String str5 : strArr) {
            Matcher matcher = compile.matcher(str5);
            if (matcher.find()) {
                String trim = matcher.group(4).trim();
                if ("0A".equals(matcher.group(3)) && (split = matcher.group(1).split(u.bD)) != null && split.length >= 2) {
                    hashMap.put(split[1], trim);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            stringBuffer.append(";");
            Iterator iterator2 = hashMap.h().iterator2();
            while (iterator2.hasNext()) {
                String str6 = (String) iterator2.next();
                stringBuffer.append((String) hashMap.get(str6));
                stringBuffer.append(u.bD);
                stringBuffer.append(str6);
                if (iterator2.hasNext()) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }
}
