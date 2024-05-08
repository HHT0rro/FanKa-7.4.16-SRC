package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final int f29520a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final String f29521b = "ExtractNativeUtils";

    /* renamed from: c, reason: collision with root package name */
    private static final int f29522c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f29523d = 128;

    /* renamed from: e, reason: collision with root package name */
    private static final int f29524e = 50;

    /* renamed from: f, reason: collision with root package name */
    private static final int f29525f = 52428800;

    /* renamed from: g, reason: collision with root package name */
    private static Pattern f29526g = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f29527a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f29528b;

        /* renamed from: c, reason: collision with root package name */
        public String f29529c;

        private a(ZipEntry zipEntry, String str, String str2) {
            this.f29528b = zipEntry;
            this.f29527a = str;
            this.f29529c = str2;
        }

        public /* synthetic */ a(ZipEntry zipEntry, String str, String str2, byte b4) {
            this(zipEntry, str, str2);
        }
    }

    public static int a(File file, String str) {
        ZipFile zipFile;
        aa.b("ExtractNativeUtils", "begin extractNativeLibrary");
        int i10 = 0;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    HashMap hashMap = new HashMap();
                    int a10 = a(entries, (HashMap<String, HashSet<a>>) hashMap, 0);
                    if (a10 == -1) {
                        aa.d("ExtractNativeUtils", "Unsafe zip name!");
                        ae.a(zipFile);
                        return -1;
                    }
                    if (a10 > 50) {
                        aa.d("ExtractNativeUtils", "the total number is larger than the max");
                        ae.a(zipFile);
                        return -1;
                    }
                    Iterator iterator2 = hashMap.h().iterator2();
                    int i11 = 0;
                    while (iterator2.hasNext()) {
                        try {
                            Set<a> set = (Set) hashMap.get((String) iterator2.next());
                            if (set == null) {
                                aa.d("ExtractNativeUtils", "Get nativeZipEntries failed.");
                                ae.a(zipFile);
                                return -1;
                            }
                            for (a aVar : set) {
                                String str2 = str + File.separator + aVar.f29529c;
                                y.a(str2);
                                new File(str2).setExecutable(true, false);
                                i11 = a(zipFile, aVar, str2);
                                if (i11 != 0) {
                                    ae.a(zipFile);
                                    return i11;
                                }
                                new File(str2, aVar.f29527a).setReadable(true, false);
                            }
                        } catch (IOException unused) {
                            zipFile2 = zipFile;
                            i10 = i11;
                            aa.d("ExtractNativeUtils", "catch IOException");
                            ae.a(zipFile2);
                            return i10;
                        }
                    }
                    ae.a(zipFile);
                    return i11;
                } catch (IOException unused2) {
                    zipFile2 = zipFile;
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                ae.a(zipFile2);
                throw th;
            }
        } catch (IOException unused3) {
        }
    }

    private static int a(Enumeration enumeration, HashMap<String, HashSet<a>> hashMap, int i10) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    aa.d("ExtractNativeUtils", "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f29526g.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet<a> hashSet = hashMap.get(group);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        hashMap.put(group, hashSet);
                    }
                    hashSet.add(new a(zipEntry, group2, group, (byte) 0));
                    i10++;
                }
            }
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        com.huawei.hms.ads.uiengineloader.aa.d("ExtractNativeUtils", "so file too big , " + r9.f29529c + " , " + r9.f29527a);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable, java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.util.zip.ZipFile r8, com.huawei.hms.ads.uiengineloader.x.a r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "ExtractNativeUtils"
            r1 = 4096(0x1000, float:5.74E-42)
            r2 = 0
            r3 = -1
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L62
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L62
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L62
            java.lang.String r6 = r9.f29527a     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L62
            r5.<init>(r10, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L62
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5e java.io.FileNotFoundException -> L62
            java.util.zip.ZipEntry r10 = r9.f29528b     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.io.InputStream r2 = r8.getInputStream(r10)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            r8 = 0
            r10 = 0
        L1c:
            int r5 = r2.read(r1)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            if (r5 <= 0) goto L49
            int r10 = r10 + r5
            r6 = 52428800(0x3200000, float:4.7019774E-37)
            if (r10 <= r6) goto L45
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r10 = "so file too big , "
            r8.<init>(r10)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r10 = r9.f29529c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            r8.append(r10)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r10 = " , "
            r8.append(r10)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r9 = r9.f29527a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            r8.append(r9)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            com.huawei.hms.ads.uiengineloader.aa.d(r0, r8)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            goto L4a
        L45:
            r4.write(r1, r8, r5)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L55 java.io.FileNotFoundException -> L58
            goto L1c
        L49:
            r3 = 0
        L4a:
            com.huawei.hms.ads.uiengineloader.ae.a(r4)
            com.huawei.hms.ads.uiengineloader.ae.a(r2)
            goto L6e
        L51:
            r8 = move-exception
            r9 = r2
            r2 = r4
            goto L73
        L55:
            r8 = r2
            r2 = r4
            goto L5f
        L58:
            r8 = r2
            r2 = r4
            goto L63
        L5b:
            r8 = move-exception
            r9 = r2
            goto L73
        L5e:
            r8 = r2
        L5f:
            java.lang.String r9 = "IOException"
            goto L65
        L62:
            r8 = r2
        L63:
            java.lang.String r9 = "FileNotFoundException"
        L65:
            com.huawei.hms.ads.uiengineloader.aa.d(r0, r9)     // Catch: java.lang.Throwable -> L6f
            com.huawei.hms.ads.uiengineloader.ae.a(r2)
            com.huawei.hms.ads.uiengineloader.ae.a(r8)
        L6e:
            return r3
        L6f:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L73:
            com.huawei.hms.ads.uiengineloader.ae.a(r2)
            com.huawei.hms.ads.uiengineloader.ae.a(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.uiengineloader.x.a(java.util.zip.ZipFile, com.huawei.hms.ads.uiengineloader.x$a, java.lang.String):int");
    }

    public static int a(ZipFile zipFile, Set<a> set, String str) {
        aa.b("ExtractNativeUtils", "begin extractNativeLibrary ");
        int i10 = 0;
        for (a aVar : set) {
            File file = new File(str);
            if (!file.exists()) {
                y.a(str);
            }
            file.setExecutable(true, false);
            int a10 = a(zipFile, aVar, str);
            if (a10 != 0) {
                return a10;
            }
            File file2 = new File(str, aVar.f29527a);
            if (Build.VERSION.SDK_INT < 23 && file2.getAbsolutePath().length() > 128) {
                aa.c("ExtractNativeUtils", file2.getName() + "  too long,  length > 128");
                return -1;
            }
            file2.setReadable(true, false);
            i10 = a10;
        }
        return i10;
    }

    public static void a(Enumeration enumeration, Set<a> set, String str) throws ZipException {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    throw new ZipException("Unsafe zip name!");
                }
                Matcher matcher = f29526g.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (group.equals(str)) {
                        set.add(new a(zipEntry, group2, group, (byte) 0));
                    }
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            aa.b("ExtractNativeUtils", "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                aa.b("ExtractNativeUtils", "The extract-native-flag has set, need to extract.");
                return true;
            }
            aa.b("ExtractNativeUtils", "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            aa.c("ExtractNativeUtils", "Get package name failed: name not found.");
            return true;
        }
    }
}
