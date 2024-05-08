package com.huawei.hms.common.util;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.feature.dynamic.ModuleCopy;
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
import java.util.zip.ZipFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ExtractNativeUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29754a = "ExtractNativeUtils";

    /* renamed from: b, reason: collision with root package name */
    public static final int f29755b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f29756c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f29757d = 50;

    /* renamed from: e, reason: collision with root package name */
    public static final int f29758e = 52428800;

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f29759f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f29760a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f29761b;

        /* renamed from: c, reason: collision with root package name */
        public String f29762c;

        public b(ZipEntry zipEntry, String str, String str2) {
            this.f29761b = zipEntry;
            this.f29760a = str;
            this.f29762c = str2;
        }
    }

    public static int a(File file, String str) {
        Logger.i(f29754a, "begin extractNativeLibrary");
        int i10 = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        HashMap hashMap = new HashMap();
                        int a10 = a(entries, (HashMap<String, HashSet<b>>) hashMap, 0);
                        if (a10 == -1) {
                            Logger.e(f29754a, "Unsafe zip name!");
                            try {
                                zipFile2.close();
                            } catch (IOException e2) {
                                Logger.e(f29754a, "IOException:", e2);
                            }
                            return -1;
                        }
                        if (a10 > 50) {
                            Logger.e(f29754a, "the total number is larger than the max");
                            try {
                                zipFile2.close();
                            } catch (IOException e10) {
                                Logger.e(f29754a, "IOException:", e10);
                            }
                            return -1;
                        }
                        Iterator iterator2 = hashMap.h().iterator2();
                        int i11 = 0;
                        while (iterator2.hasNext()) {
                            try {
                                Set<b> set = (Set) hashMap.get((String) iterator2.next());
                                if (set == null) {
                                    Logger.e(f29754a, "Get nativeZipEntries failed.");
                                    try {
                                        zipFile2.close();
                                    } catch (IOException e11) {
                                        Logger.e(f29754a, "IOException:", e11);
                                    }
                                    return -1;
                                }
                                for (b bVar : set) {
                                    String str2 = str + File.separator + bVar.f29762c;
                                    ModuleCopy.makeDirectory(str2);
                                    new File(str2).setExecutable(true, false);
                                    i11 = a(zipFile2, bVar, str2);
                                    if (i11 != 0) {
                                        try {
                                            zipFile2.close();
                                        } catch (IOException e12) {
                                            Logger.e(f29754a, "IOException:", e12);
                                        }
                                        return i11;
                                    }
                                    new File(str2, bVar.f29760a).setReadable(true, false);
                                }
                            } catch (IOException e13) {
                                e = e13;
                                i10 = i11;
                                zipFile = zipFile2;
                                Logger.e(f29754a, "catch IOException ", e);
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (IOException e14) {
                                        e = e14;
                                        i11 = i10;
                                        Logger.e(f29754a, "IOException:", e);
                                        return i11;
                                    }
                                }
                                return i10;
                            }
                        }
                        try {
                            zipFile2.close();
                            return i11;
                        } catch (IOException e15) {
                            e = e15;
                            Logger.e(f29754a, "IOException:", e);
                            return i11;
                        }
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e16) {
                                Logger.e(f29754a, "IOException:", e16);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (IOException e18) {
                e = e18;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int a(Enumeration enumeration, HashMap<String, HashSet<b>> hashMap, int i10) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    Logger.e(f29754a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f29759f.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet<b> hashSet = hashMap.get(group);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        hashMap.put(group, hashSet);
                    }
                    hashSet.add(new b(zipEntry, group2, group));
                    i10++;
                }
            }
        }
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        com.huawei.hms.common.util.Logger.e(com.huawei.hms.common.util.ExtractNativeUtils.f29754a, "so file too big , " + r10.f29762c + " , " + r10.f29760a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        if (r9 == 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        if (r9 == 0) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.util.zip.ZipFile r9, com.huawei.hms.common.util.ExtractNativeUtils.b r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.a(java.util.zip.ZipFile, com.huawei.hms.common.util.ExtractNativeUtils$b, java.lang.String):int");
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            Logger.i(f29754a, "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                Logger.i(f29754a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.i(f29754a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.w(f29754a, "Get package name failed: name not found.");
            return true;
        }
    }
}
