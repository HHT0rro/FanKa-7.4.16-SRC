package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class r {

    /* renamed from: c, reason: collision with root package name */
    private static r f36184c;

    /* renamed from: d, reason: collision with root package name */
    private static Application f36185d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f36189a;

    /* renamed from: e, reason: collision with root package name */
    private String f36190e;

    /* renamed from: f, reason: collision with root package name */
    private static Random f36186f = new Random();

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, s> f36187g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private static Map<String, s> f36188h = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static List<Integer> f36183b = new ArrayList();

    private r() {
    }

    public static r a(Context context, boolean z10) {
        try {
            if (f36184c == null) {
                f36185d = (Application) context.getApplicationContext();
                f36184c = new r();
            }
        } catch (Throwable unused) {
        }
        return f36184c;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str) {
        s sVar = f36188h.get(str);
        if (sVar == null) {
            return false;
        }
        f36187g.remove(sVar.f36195e);
        f36188h.remove(str);
        dn.c(sVar.f36203m);
        Application application = f36185d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.f36193c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return f36187g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return f36188h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r a() {
        return f36184c;
    }

    public boolean a(s sVar, boolean z10) {
        this.f36189a = z10;
        this.f36190e = sVar.f36194d;
        return a(sVar);
    }

    public Map<String, s> b() {
        return f36188h;
    }

    private synchronized boolean a(s sVar) {
        boolean z10;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.f36195e)) {
                s sVar2 = f36187g.get(sVar.f36195e);
                if (sVar2 != null) {
                    if (sVar2.f36194d.equals(sVar.f36194d)) {
                        return true;
                    }
                    a(sVar2.f36195e);
                }
                try {
                    sVar.f36196f = f36185d;
                    if (sVar.f36206p == 1) {
                        try {
                            try {
                                if (!TextUtils.isEmpty(sVar.f36193c) && !TextUtils.isEmpty(sVar.f36195e)) {
                                    sVar.f36203m = f36185d.getFilesDir().getCanonicalPath() + bi.f35840j + sVar.f36191a;
                                    String str = sVar.f36203m + "/dex";
                                    String str2 = sVar.f36203m + "/lib/" + this.f36190e;
                                    dn.c(sVar.f36203m + "/lib");
                                    String str3 = str2 + "/" + f36186f.nextInt();
                                    e(str);
                                    dn.a(str, Boolean.FALSE);
                                    e(str3);
                                    a(sVar, str3, str, false);
                                    f36188h.put(sVar.f36193c, sVar);
                                    f36187g.put(sVar.f36195e, sVar);
                                } else {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.f36195e);
                            z10 = true;
                        }
                    }
                    z10 = false;
                    if (sVar.f36206p != 1 || z10) {
                        PackageInfo packageInfo = sVar.f36208r;
                        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                            packageInfo = f36185d.getPackageManager().getPackageArchiveInfo(sVar.f36195e, 1);
                        }
                        if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            if (sVar.f36206p != 1 && sVar.f36192b != 1 && !((Boolean) a(sVar.f36200j, sVar.f36195e).first).booleanValue()) {
                                return false;
                            }
                            sVar.f36193c = packageInfo.packageName;
                            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                            sVar.f36205o = applicationInfo.className;
                            sVar.f36194d = packageInfo.versionName;
                            sVar.f36202l = packageInfo.activities;
                            sVar.f36207q = applicationInfo.theme;
                            sVar.f36203m = f36185d.getFilesDir().getCanonicalPath() + bi.f35840j + sVar.f36191a;
                            String str4 = sVar.f36203m + "/dex";
                            String str5 = sVar.f36203m + "/lib/" + this.f36190e;
                            dn.c(sVar.f36203m + "/lib");
                            String str6 = str5 + "/" + f36186f.nextInt();
                            e(str4);
                            dn.a(str4, Boolean.FALSE);
                            e(str6);
                            a(sVar, str6, str4, true);
                            f36188h.put(sVar.f36193c, sVar);
                            f36187g.put(sVar.f36195e, sVar);
                            f36183b.add(Integer.valueOf(sVar.f36191a));
                        } else {
                            throw new Exception("weapon package name check failed");
                        }
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.f36195e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!dn.a(file)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            String a10 = f.a(file);
            if (TextUtils.isEmpty(a10)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            if (!a10.equalsIgnoreCase(str)) {
                return new Pair<>(Boolean.FALSE, a10);
            }
            return new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public boolean a(String str) {
        s sVar = f36187g.get(str);
        if (sVar == null) {
            return false;
        }
        f36187g.remove(str);
        f36188h.remove(sVar.f36193c);
        dn.c(sVar.f36203m);
        Application application = f36185d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.f36193c).getAbsolutePath());
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:27|(1:205)(9:31|32|33|34|(1:201)(5:36|(2:38|(1:40)(1:199))(1:200)|41|(1:198)(3:43|44|(2:46|(1:51))(1:197))|88)|52|(3:53|54|(1:56)(1:57))|58|59)|60|61|(1:97)(8:66|67|68|69|70|(3:72|73|(4:75|76|77|79)(1:89))|90|91)|86|87|88|24|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:(4:(2:5|(25:9|10|(1:12)|13|(1:15)|16|17|18|19|21|22|23|(10:27|(1:205)(9:31|32|33|34|(1:201)(5:36|(2:38|(1:40)(1:199))(1:200)|41|(1:198)(3:43|44|(2:46|(1:51))(1:197))|88)|52|(3:53|54|(1:56)(1:57))|58|59)|60|61|(1:97)(8:66|67|68|69|70|(3:72|73|(4:75|76|77|79)(1:89))|90|91)|86|87|88|24|25)|207|208|(1:210)|(1:212)|111|(6:113|114|115|(3:117|118|(1:120)(1:157))|159|(0)(0))(4:161|162|163|(1:165))|121|(1:127)|132|133|134|(2:136|(3:142|38d|147)(1:140))(1:154)))|133|134|(0)(0))|18|19|21|22|23|(2:24|25)|207|208|(0)|(0)|111|(0)(0)|121|(3:123|125|127)|132) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x023b, code lost:
    
        if (r14 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0258, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0256, code lost:
    
        if (r14 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0220, code lost:
    
        if (r14 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x01e2, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x01e4, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x01e0, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x01da, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x01db, code lost:
    
        r13 = r2;
        r5 = null;
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a7, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0375 A[Catch: all -> 0x03f8, TryCatch #13 {all -> 0x03f8, blocks: (B:134:0x0354, B:136:0x0375, B:138:0x037f, B:142:0x0389, B:143:0x038d, B:151:0x03f7, B:146:0x03d1, B:152:0x03d3, B:153:0x03f4, B:145:0x038e), top: B:133:0x0354, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03f8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[Catch: all -> 0x01c9, IOException -> 0x01cd, EOFException -> 0x01d1, FileNotFoundException | ZipException -> 0x01d5, TryCatch #17 {FileNotFoundException | ZipException -> 0x01d5, blocks: (B:25:0x005c, B:27:0x0062, B:29:0x0074, B:31:0x007a, B:34:0x0081, B:34:0x0081, B:36:0x0087, B:36:0x0087, B:38:0x008d, B:38:0x008d, B:41:0x0098, B:41:0x0098, B:44:0x00a0, B:44:0x00a0, B:46:0x00a8, B:46:0x00a8, B:49:0x00ae, B:49:0x00ae, B:52:0x00b6, B:52:0x00b6, B:83:0x01ab, B:83:0x01ab, B:85:0x01b1, B:85:0x01b1), top: B:24:0x005c }] */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.util.zip.ZipFile] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r20, java.lang.String r21, java.lang.String r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb2, boolean z10) {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.f36195e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)))))) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str);
                            sb3.append(name.substring(3).replace(".so", str2 + ".so"));
                            String sb4 = sb3.toString();
                            String substring = sb4.substring(0, sb4.lastIndexOf(47));
                            hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                            e(substring);
                            File file2 = new File(sb4);
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(sb4);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, read);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    zipInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream2.close();
                            dn.a(sb4, Boolean.TRUE);
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z10) {
                            String str5 = sVar.f36203m;
                            e(str5);
                            file = new File(str5, sVar.f36191a + "-" + sVar.f36194d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int read2 = zipInputStream.read(bArr);
                                        if (read2 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream3.write(bArr, 0, read2);
                                        }
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        zipInputStream.closeEntry();
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb2.length() > 0) {
                                    sb2.setLength(0);
                                }
                                sb2.append(file.getAbsolutePath());
                                dn.a(sb2.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
