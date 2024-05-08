package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.security.realidentity.build.cg;
import com.alibaba.wireless.security.framework.utils.C0049;
import com.alibaba.wireless.security.framework.utils.C0050;
import com.alibaba.wireless.security.framework.utils.C0051;
import com.alibaba.wireless.security.framework.utils.C0055;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.C0085;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.huawei.openalliance.ad.constant.u;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.alibaba.wireless.security.framework.г, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0059 implements ISGPluginManager {

    /* renamed from: у, reason: contains not printable characters */
    private static Boolean f91 = null;

    /* renamed from: ф, reason: contains not printable characters */
    private static String[] f92 = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};

    /* renamed from: х, reason: contains not printable characters */
    private static String f93 = null;

    /* renamed from: ц, reason: contains not printable characters */
    private static volatile boolean f94 = true;

    /* renamed from: б, reason: contains not printable characters */
    private List<Runnable> f96;

    /* renamed from: в, reason: contains not printable characters */
    private Context f97;

    /* renamed from: а, reason: contains not printable characters */
    private HandlerThread f95 = null;

    /* renamed from: г, reason: contains not printable characters */
    private final ConcurrentHashMap<String, C0058> f98 = new ConcurrentHashMap<>();

    /* renamed from: д, reason: contains not printable characters */
    private final ConcurrentHashMap<Class, Object> f99 = new ConcurrentHashMap<>();

    /* renamed from: е, reason: contains not printable characters */
    private IRouterComponent f100 = null;

    /* renamed from: ё, reason: contains not printable characters */
    public C0051 f114 = null;

    /* renamed from: ж, reason: contains not printable characters */
    private boolean f101 = true;

    /* renamed from: з, reason: contains not printable characters */
    private String f102 = null;

    /* renamed from: и, reason: contains not printable characters */
    private String f103 = null;

    /* renamed from: й, reason: contains not printable characters */
    private C0057 f104 = null;

    /* renamed from: к, reason: contains not printable characters */
    private boolean f105 = false;

    /* renamed from: л, reason: contains not printable characters */
    private boolean f106 = false;

    /* renamed from: м, reason: contains not printable characters */
    private boolean f107 = false;

    /* renamed from: н, reason: contains not printable characters */
    private boolean f108 = false;

    /* renamed from: о, reason: contains not printable characters */
    private boolean f109 = false;

    /* renamed from: п, reason: contains not printable characters */
    private boolean f110 = false;

    /* renamed from: р, reason: contains not printable characters */
    private File f111 = null;

    /* renamed from: с, reason: contains not printable characters */
    private File f112 = null;

    /* renamed from: т, reason: contains not printable characters */
    private File f113 = null;

    /* renamed from: com.alibaba.wireless.security.framework.г$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0060 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ File f115;

        public RunnableC0060(File file) {
            this.f115 = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0059.this.m1875(100179, 4, this.f115.getAbsolutePath(), "", "", "", "");
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$б, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0061 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ File f117;

        public RunnableC0061(File file) {
            this.f117 = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0059.this.m1875(100179, 2, this.f117.getAbsolutePath(), "", "", "", "");
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$в, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0062 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ File f119;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f120;

        public RunnableC0062(File file, String str) {
            this.f119 = file;
            this.f120 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File filesDir;
            File[] listFiles;
            File[] listFiles2;
            try {
                File file = this.f119;
                if (file != null && file.isDirectory() && (listFiles2 = this.f119.listFiles()) != null && listFiles2.length > 0) {
                    for (File file2 : listFiles2) {
                        if (file2.isDirectory() && file2.getName().startsWith("app_") && !file2.getName().equals(this.f120)) {
                            C0059.this.m1879(file2);
                        } else if (file2.getName().startsWith("libsg")) {
                            file2.delete();
                        }
                    }
                }
                if (C0059.this.f97 == null || (filesDir = C0059.this.f97.getFilesDir()) == null || !filesDir.isDirectory() || (listFiles = filesDir.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                for (File file3 : listFiles) {
                    if (file3.getName().startsWith("libsecuritysdk")) {
                        file3.delete();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$г, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0063 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ String f122;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f123;

        public RunnableC0063(String str, String str2) {
            this.f122 = str;
            this.f123 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0059.this.m1905(this.f122, this.f123, true);
            } catch (SecException e2) {
                C0049.m1822("load weak dependency notDelay", e2);
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$д, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0064 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ String f125;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f126;

        public RunnableC0064(String str, String str2) {
            this.f125 = str;
            this.f126 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0059.this.m1905(this.f125, this.f126, true);
            } catch (SecException e2) {
                C0049.m1822("load weak dependency", e2);
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$е, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0065 implements Runnable {
        public RunnableC0065() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0059.this.m1908();
            C0059.this.m1895();
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$ж, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0066 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ String f129;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f130;

        public RunnableC0066(String str, String str2) {
            this.f129 = str;
            this.f130 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0059.this.m1905(this.f129, this.f130, true);
            } catch (SecException e2) {
                C0049.m1822("load weak dependency", e2);
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$з, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0067 implements Runnable {
        public RunnableC0067() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0059.this.m1908();
            C0059.this.m1895();
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$и, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0068 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ String f133;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ int f134;

        public RunnableC0068(String str, int i10) {
            this.f133 = str;
            this.f134 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0059.this.m1875(100048, 140, "Dynamic update rejected", "Arch=" + this.f133, "DeployVersion=" + this.f134, "", "");
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$й, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0069 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ String f136;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ File f137;

        /* renamed from: в, reason: contains not printable characters */
        public final /* synthetic */ File f138;

        public RunnableC0069(String str, File file, File file2) {
            this.f136 = str;
            this.f137 = file;
            this.f138 = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0059.this.m1875(100179, 4, "updInfo=" + this.f136, this.f137.getAbsolutePath(), this.f138.getAbsolutePath(), "", "");
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$к, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class C0070 {

        /* renamed from: а, reason: contains not printable characters */
        public File f140;

        /* renamed from: б, reason: contains not printable characters */
        public File f141;

        /* renamed from: в, reason: contains not printable characters */
        public File f142;

        /* renamed from: г, reason: contains not printable characters */
        public boolean f143;

        public C0070(File file, File file2, File file3, boolean z10) {
            this.f140 = file;
            this.f141 = file2;
            this.f142 = file3;
            this.f143 = z10;
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.г$ё, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0071 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ String f144;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f145;

        public RunnableC0071(String str, String str2) {
            this.f144 = str;
            this.f145 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0059.this.m1905(this.f144, this.f145, true);
            } catch (SecException e2) {
                C0049.m1822("load weak dependency notDelay", e2);
            }
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private PackageInfo m1866(String str, C0070 c0070, String str2) throws SecException {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f97.getPackageManager().getPackageArchiveInfo(c0070.f140.getAbsolutePath(), 133);
        } catch (Throwable th) {
            String str3 = "" + th;
            String m1900 = m1900(c0070.f140.getAbsolutePath() + "");
            File file = c0070.f142;
            m1875(100043, 133, "getPackageArchiveInfo failed", str3, m1900, file != null ? m1900(file.getAbsolutePath()) : "", str2);
            if (c0070.f140.exists() && !m1904(c0070.f140)) {
                c0070.f140.delete();
            }
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo;
        }
        String str4 = str + "[" + str2 + "]";
        String m19002 = m1900(c0070.f140.getAbsolutePath());
        File file2 = c0070.f142;
        m1875(100043, 134, "packageInfo == null", str4, m19002, file2 != null ? m1900(file2.getAbsolutePath()) : "", m1909());
        throw new SecException(134);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0199 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01b7 A[Catch: all -> 0x0183, TryCatch #15 {all -> 0x0183, blocks: (B:258:0x0171, B:260:0x017b, B:15:0x019b, B:17:0x01a5, B:21:0x01b4, B:23:0x01b7, B:27:0x01c5, B:30:0x01cb, B:43:0x0264, B:46:0x027e, B:48:0x0282, B:49:0x0294, B:50:0x02ab, B:51:0x02c0, B:64:0x0298, B:65:0x026b), top: B:257:0x0171 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x023e A[Catch: all -> 0x0788, TRY_ENTER, TryCatch #18 {all -> 0x0788, blocks: (B:10:0x016c, B:12:0x0187, B:31:0x01d5, B:34:0x01fc, B:39:0x0251, B:67:0x02c1, B:69:0x02c6, B:253:0x023e), top: B:9:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0167  */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23, types: [com.alibaba.wireless.security.framework.г$к] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r1v110, types: [int] */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.alibaba.wireless.security.framework.SGApmMonitorManager] */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r44v0, types: [com.alibaba.wireless.security.framework.ISGPluginManager, com.alibaba.wireless.security.framework.г] */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.C0058 m1867(java.lang.String r45, com.alibaba.wireless.security.framework.C0059.C0070 r46, android.content.Context r47, java.lang.String r48) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 1949
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1867(java.lang.String, com.alibaba.wireless.security.framework.г$к, android.content.Context, java.lang.String):com.alibaba.wireless.security.framework.в");
    }

    /* renamed from: а, reason: contains not printable characters */
    private File m1868(Context context) throws SecException {
        if (context == null) {
            m1875(100038, 116, "", "", "", "", "");
            throw new SecException(116);
        }
        String str = null;
        try {
            String str2 = context.getApplicationInfo().sourceDir;
            if (str2 != null) {
                File file = new File(str2);
                if (file.exists()) {
                    str = (file.lastModified() / 1000) + "";
                }
            }
            if (str == null) {
                throw new SecException(115);
            }
            File dir = context.getDir("SGLib", 0);
            this.f112 = dir;
            if (dir == null || !dir.exists()) {
                m1875(100038, 109, "", "" + ((Object) this.f112), "", "", "");
                throw new SecException(109);
            }
            File file2 = new File(this.f112.getAbsolutePath(), "app_" + str);
            if (!file2.exists()) {
                file2.mkdirs();
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (f94 && file2.exists()) {
                f94 = false;
                m1880(this.f112, "app_" + str);
            }
            if (file2.exists()) {
                return file2;
            }
            m1875(100038, 114, "", "", "", "", "");
            throw new SecException(114);
        } catch (Throwable th) {
            m1875(100038, 115, "", "" + ((Object) th), "", "", "");
            throw new SecException(th, 115);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006a, code lost:
    
        if (m1882(r6, r7.m1860()) == false) goto L15;
     */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File m1869(android.content.Context r6, com.alibaba.wireless.security.framework.C0057 r7) {
        /*
            r5 = this;
            boolean r6 = com.alibaba.wireless.security.framework.utils.C0055.m1851(r6)
            r0 = 0
            if (r6 != 0) goto Lbd
            if (r7 == 0) goto Lbd
            int r6 = r7.m1860()
            if (r6 == 0) goto Lbd
            java.lang.String r6 = r7.m1861()
            if (r6 == 0) goto Lbd
            java.lang.String r6 = r7.m1861()
            int r6 = r6.length()
            if (r6 <= 0) goto Lbd
            boolean r6 = r5.m1907()
            java.lang.String r1 = "libs"
            if (r6 == 0) goto L6c
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r5.f112
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            java.lang.String r4 = "upds"
            r2.append(r4)
            r2.append(r3)
            r2.append(r1)
            r2.append(r3)
            int r4 = r7.m1860()
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = r7.m1861()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.<init>(r2)
            int r2 = r7.m1860()
            boolean r2 = r5.m1882(r6, r2)
            if (r2 != 0) goto L6d
        L6c:
            r6 = r0
        L6d:
            if (r6 == 0) goto L75
            boolean r2 = r6.isDirectory()
            if (r2 != 0) goto Lb3
        L75:
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r5.f111
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r1)
            r2.append(r3)
            int r1 = r7.m1860()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r7.m1861()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r6.<init>(r1)
            int r7 = r7.m1860()
            boolean r7 = r5.m1882(r6, r7)
            if (r7 != 0) goto Lb3
            r6 = r0
        Lb3:
            if (r6 == 0) goto Lbc
            boolean r7 = r6.exists()
            if (r7 != 0) goto Lbc
            goto Lbd
        Lbc:
            r0 = r6
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1869(android.content.Context, com.alibaba.wireless.security.framework.б):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File m1870(java.lang.String r13, java.io.File r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = r12.f97     // Catch: java.lang.Throwable -> La
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()     // Catch: java.lang.Throwable -> La
            java.lang.String r1 = r1.sourceDir     // Catch: java.lang.Throwable -> La
            goto Lb
        La:
            r1 = r0
        Lb:
            if (r1 != 0) goto Le
            return r0
        Le:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "libsg"
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = ".so"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
            com.alibaba.wireless.security.framework.utils.C0049.m1824(r3)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            java.lang.String[] r4 = com.alibaba.wireless.security.framework.C0059.f92     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            int r5 = r4.length     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r6 = 0
        L32:
            if (r6 >= r5) goto L62
            r7 = r4[r6]     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.<init>()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.String r9 = "lib"
            r8.append(r9)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.String r9 = java.io.File.separator     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r9)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r7)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r9)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r2)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.String r8 = r8.toString()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.util.zip.ZipEntry r9 = r3.getEntry(r8)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            if (r9 == 0) goto L5f
            com.alibaba.wireless.security.framework.C0059.f93 = r7     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.io.File r0 = r12.m1872(r13, r14, r3, r8)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            goto L62
        L5f:
            int r6 = r6 + 1
            goto L32
        L62:
            r3.close()     // Catch: java.lang.Throwable -> L65
        L65:
            return r0
        L66:
            r14 = move-exception
            goto L6c
        L68:
            r13 = move-exception
            goto L8e
        L6a:
            r14 = move-exception
            r3 = r0
        L6c:
            java.lang.String r2 = "getPluginFile throws exception"
            com.alibaba.wireless.security.framework.utils.C0049.m1822(r2, r14)     // Catch: java.lang.Throwable -> L8c
            r5 = 100047(0x186cf, float:1.40196E-40)
            r6 = 3
            java.lang.String r7 = r14.toString()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r9 = r12.m1900(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            r4 = r12
            r8 = r13
            r4.m1875(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L8c
            if (r3 == 0) goto L8b
            r3.close()     // Catch: java.lang.Throwable -> L8b
        L8b:
            return r0
        L8c:
            r13 = move-exception
            r0 = r3
        L8e:
            if (r0 == 0) goto L93
            r0.close()     // Catch: java.lang.Throwable -> L93
        L93:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1870(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r1 == null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File m1871(java.lang.String r11, java.io.File r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            r0 = 0
            if (r13 == 0) goto L44
            if (r14 != 0) goto L6
            goto L44
        L6:
            java.lang.String r1 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
            com.alibaba.wireless.security.framework.utils.C0049.m1824(r1)     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            java.io.File r0 = r10.m1872(r11, r12, r1, r14)     // Catch: java.io.IOException -> L18 java.lang.Throwable -> L3c
        L14:
            r1.close()     // Catch: java.lang.Throwable -> L3b
            goto L3b
        L18:
            r12 = move-exception
            goto L1e
        L1a:
            r11 = move-exception
            goto L3e
        L1c:
            r12 = move-exception
            r1 = r0
        L1e:
            java.lang.String r14 = "getPluginFile throws exception"
            com.alibaba.wireless.security.framework.utils.C0049.m1822(r14, r12)     // Catch: java.lang.Throwable -> L3c
            r3 = 100047(0x186cf, float:1.40196E-40)
            r4 = 3
            java.lang.String r5 = r12.toString()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = r10.m1900(r13)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            r2 = r10
            r6 = r11
            r2.m1875(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L3b
            goto L14
        L3b:
            return r0
        L3c:
            r11 = move-exception
            r0 = r1
        L3e:
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.lang.Throwable -> L43
        L43:
            throw r11
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1871(java.lang.String, java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    /* renamed from: а, reason: contains not printable characters */
    private File m1872(String str, File file, ZipFile zipFile, String str2) throws IOException {
        ZipEntry entry;
        if (zipFile != null && str2 != null && (entry = zipFile.getEntry(str2)) != null && C0050.m1828(entry.getName())) {
            File file2 = new File(file, "libsg" + str + "_inner" + entry.getTime() + ".zip");
            if ((file2.exists() && file2.length() == entry.getSize()) || C0055.m1849(zipFile, entry, file2)) {
                C0049.m1824("Extract success");
                return file2;
            }
            C0049.m1824("Extract failed!!");
        }
        return null;
    }

    /* renamed from: а, reason: contains not printable characters */
    private Class<?> m1873(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            m1875(100042, 132, "Class.forName failed", "" + th, str, classLoader.toString(), "");
            cls = null;
        }
        C0049.m1824("    loadClassFromClassLoader( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return cls;
    }

    /* renamed from: а, reason: contains not printable characters */
    private ClassLoader m1874(String str, String str2, boolean z10) {
        if (!z10) {
            try {
                this.f114.m1830();
            } finally {
                if (!z10) {
                    this.f114.m1831();
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f97.getApplicationInfo().nativeLibraryDir);
        String str3 = File.pathSeparator;
        sb2.append(str3);
        sb2.append(str2);
        String sb3 = sb2.toString();
        if (this.f102 != null) {
            sb3 = sb3 + str3 + this.f102;
            C0049.m1824("add path to native classloader " + sb3);
        }
        if (f93 != null) {
            sb3 = sb3 + str3 + this.f97.getApplicationInfo().sourceDir + "!/lib/" + f93;
        }
        return !"6.0.1".equalsIgnoreCase(Build.VERSION.RELEASE) ? new PathClassLoader(str, sb3, C0059.class.getClassLoader()) : new DexClassLoader(str, str2, sb3, C0059.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public void m1875(int i10, int i11, String str, String str2, String str3, String str4, String str5) {
        UserTrackMethodJniBridge.addUtRecord("" + i10, i11, 0, C0085.m1953(), 0L, str, str2, str3, str4, str5);
    }

    /* renamed from: а, reason: contains not printable characters */
    private void m1876(C0070 c0070, String str, String str2) {
        if (m1897(c0070.f142)) {
            int m1860 = this.f104.m1860();
            String str3 = "PluginName=" + str;
            String str4 = "PluginVersion=" + str2;
            String str5 = "LibDeployVersion=" + m1860;
            m1875(100048, 135, "Write dyInit.config", str3, str4, str5, "write success=" + C0050.m1827(new File(this.f111, "dyInit.config"), Integer.toString(m1860)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public void m1879(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                m1879(new File(file, str));
            }
        }
        file.delete();
    }

    /* renamed from: а, reason: contains not printable characters */
    private void m1880(File file, String str) {
        new Thread(new RunnableC0062(file, str), "SGCleanFile").start();
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m1882(File file, int i10) {
        return new File(file, ".finish").isFile();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m1883(java.io.File r20, java.io.File r21) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1883(java.io.File, java.io.File):boolean");
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m1884(String str, String str2) throws SecException {
        for (Map.Entry<String, C0058> entry : this.f98.entrySet()) {
            String key = entry.getKey();
            C0058 value = entry.getValue();
            String m1864 = value.m1864("reversedependencies");
            if (m1864 != null) {
                String[] split = m1864.split(";");
                for (int i10 = 0; i10 < split.length; i10++) {
                    String trim = split[i10].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(u.bD);
                        if (split2.length != 2) {
                            m1875(100041, 131, "nameVersionPair.length != 2", str + "(" + str2 + ")", key + "(" + value.getVersion() + ")", m1900(value.getPluginPath()), m1864);
                            throw new SecException(131);
                        }
                        if (split2[0].equalsIgnoreCase(str) && m1886(str2, split2[1]) < 0) {
                            String str3 = "plugin " + str + "(" + str2 + ") is not meet the reverse dependency of " + key + "(" + value.getVersion() + "): " + split2[0] + "(" + split2[1] + ")";
                            m1875(100041, 117, str3, C0059.class.getClassLoader().toString(), m1900(value.getPluginPath()), m1864, "" + i10);
                            throw new SecException(str3, 117);
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0125, code lost:
    
        if (r21 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x016b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0165, code lost:
    
        r16.f114.m1831();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0163, code lost:
    
        if (r21 != false) goto L89;
     */
    /* renamed from: а, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean m1885(java.lang.String r17, java.lang.String r18, java.io.File r19, java.lang.String r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1885(java.lang.String, java.lang.String, java.io.File, java.lang.String, boolean):boolean");
    }

    /* renamed from: б, reason: contains not printable characters */
    private int m1886(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i10 = 0; i10 < length; i10++) {
            int parseInt = Integer.parseInt(split[i10]);
            int parseInt2 = Integer.parseInt(split2[i10]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:69:0x0056, B:17:0x0067, B:19:0x006d, B:21:0x0073, B:23:0x0081, B:27:0x00ab, B:25:0x00b2, B:30:0x00b7, B:33:0x00bf, B:41:0x00cf, B:43:0x00d9, B:47:0x00e1, B:49:0x00e7, B:50:0x00ee, B:52:0x0117, B:54:0x011d, B:56:0x0123, B:57:0x0129, B:59:0x0132, B:60:0x0138, B:62:0x0161, B:64:0x0173, B:65:0x016d), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:69:0x0056, B:17:0x0067, B:19:0x006d, B:21:0x0073, B:23:0x0081, B:27:0x00ab, B:25:0x00b2, B:30:0x00b7, B:33:0x00bf, B:41:0x00cf, B:43:0x00d9, B:47:0x00e1, B:49:0x00e7, B:50:0x00ee, B:52:0x0117, B:54:0x011d, B:56:0x0123, B:57:0x0129, B:59:0x0132, B:60:0x0138, B:62:0x0161, B:64:0x0173, B:65:0x016d), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5 A[EDGE_INSN: B:28:0x00b5->B:29:0x00b5 BREAK  A[LOOP:0: B:22:0x007f->B:25:0x00b2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:69:0x0056, B:17:0x0067, B:19:0x006d, B:21:0x0073, B:23:0x0081, B:27:0x00ab, B:25:0x00b2, B:30:0x00b7, B:33:0x00bf, B:41:0x00cf, B:43:0x00d9, B:47:0x00e1, B:49:0x00e7, B:50:0x00ee, B:52:0x0117, B:54:0x011d, B:56:0x0123, B:57:0x0129, B:59:0x0132, B:60:0x0138, B:62:0x0161, B:64:0x0173, B:65:0x016d), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /* renamed from: б, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.C0059.C0070 m1887(java.lang.String r17, java.lang.String r18, boolean r19) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1887(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.г$к");
    }

    /* renamed from: б, reason: contains not printable characters */
    private File m1888(File file) {
        if (!file.exists() || !file.isDirectory() || !this.f105) {
            return file;
        }
        File file2 = new File(file, "main");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.exists() ? file2 : file;
    }

    /* renamed from: б, reason: contains not printable characters */
    private File m1889(String str) {
        if (this.f102 != null) {
            return null;
        }
        String m1845 = C0055.m1845(C0059.class.getClassLoader(), "sg" + str);
        if (m1845 == null || m1845.length() <= 0) {
            return null;
        }
        return new File(m1845);
    }

    /* renamed from: б, reason: contains not printable characters */
    private boolean m1891(File file, File file2) {
        try {
            Class.forName("android.system.Os").getDeclaredMethod(cg.J, String.class, String.class).invoke(null, file.getAbsolutePath(), file2.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            C0049.m1822("create symbolic link( " + file2.getAbsolutePath() + " -> " + file.getAbsolutePath() + " ) failed", th);
            m1875(100047, 1, th.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "" + Build.VERSION.SDK_INT, "");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01d4, code lost:
    
        r11 = "plugin " + r9 + " not existed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ee, code lost:
    
        if (r10.length() == 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f0, code lost:
    
        r11 = r11 + ", depended by " + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0204, code lost:
    
        m1875(100044, 110, "", r9, r10, "", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x021c, code lost:
    
        throw new com.alibaba.wireless.security.open.SecException(r11, 110);
     */
    /* renamed from: в, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized com.alibaba.wireless.security.framework.ISGPluginInfo m1892(java.lang.String r9, java.lang.String r10, boolean r11) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1892(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.ISGPluginInfo");
    }

    /* renamed from: в, reason: contains not printable characters */
    private File m1893(String str) {
        String str2 = this.f102;
        if (str2 == null) {
            try {
                str2 = this.f97.getApplicationInfo().nativeLibraryDir;
            } catch (Throwable unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            File file = new File(str2 + File.separator + "libsg" + str + ".so");
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    /* renamed from: в, reason: contains not printable characters */
    private String m1894(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        if (interfacePluginInfo == null) {
            return null;
        }
        return interfacePluginInfo.pluginName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: в, reason: contains not printable characters */
    public void m1895() {
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener");
            Method method = cls.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                String str = (String) method.invoke(cls, "securityguard_orange_namespace", "130", "0");
                try {
                    File file = new File(m1868(this.f97), ".giw");
                    boolean exists = file.exists();
                    if (str == null) {
                        if (exists) {
                            file.delete();
                        }
                    } else if (!TextUtils.equals(C0050.m1826(file), str)) {
                        C0050.m1827(file, str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable th) {
            C0049.m1820("checkGetInterfaceLockSwitch : " + th.getMessage());
        }
    }

    /* renamed from: в, reason: contains not printable characters */
    private boolean m1897(File file) {
        String str;
        if (file == null || file.getParentFile() == null || this.f113 == null) {
            return false;
        }
        String str2 = null;
        try {
            str = file.getParentFile().getCanonicalPath();
            try {
                str2 = this.f113.getCanonicalPath();
            } catch (IOException e2) {
                e = e2;
                C0049.m1822("", e);
                return str == null ? false : false;
            }
        } catch (IOException e10) {
            e = e10;
            str = null;
        }
        if (str == null && TextUtils.equals(str, str2)) {
            return true;
        }
    }

    /* renamed from: в, reason: contains not printable characters */
    private boolean m1898(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Throwable th) {
            C0049.m1822("", th);
            m1875(100046, 0, th.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d2, code lost:
    
        r15 = "plugin " + r13 + " not existed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ec, code lost:
    
        if (r14.length() == 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ee, code lost:
    
        r15 = r15 + ", depended by " + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0202, code lost:
    
        m1875(100044, 110, "", r13, r14, "", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x021a, code lost:
    
        throw new com.alibaba.wireless.security.open.SecException(r15, 110);
     */
    /* renamed from: г, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.ISGPluginInfo m1899(java.lang.String r13, java.lang.String r14, boolean r15) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C0059.m1899(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.ISGPluginInfo");
    }

    /* renamed from: г, reason: contains not printable characters */
    private String m1900(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (m1904(file)) {
            sb2.append("->");
            try {
                sb2.append(file.getCanonicalPath());
            } catch (Throwable unused) {
            }
        }
        sb2.append('[');
        sb2.append("exists:" + file.exists() + ",");
        sb2.append("size:" + file.length() + ",");
        sb2.append("canRead:" + file.canRead() + ",");
        sb2.append("canWrite:" + file.canWrite() + ",");
        sb2.append("totalSpace:" + file.getTotalSpace() + ",");
        sb2.append("freeSpace:" + file.getFreeSpace() + ",");
        sb2.append(']');
        return sb2.toString();
    }

    /* renamed from: г, reason: contains not printable characters */
    private boolean m1901() {
        C0057 m1857;
        File file = new File(m1916(), "upds");
        File file2 = new File(file, "update.config");
        File file3 = new File(m1911(), "update.config");
        if (!file2.isFile() || (m1857 = C0057.m1857(file2)) == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) file);
        String str = File.separator;
        sb2.append(str);
        sb2.append("libs");
        sb2.append(str);
        sb2.append(m1857.m1860());
        File file4 = new File(sb2.toString(), "FBD");
        HashMap<String, String> m1862 = m1857.m1862();
        HashMap<String, String> m1906 = m1906();
        if (!file4.exists() && m1862 != null && m1862.equals(m1906)) {
            try {
                this.f114.m1830();
                file3.delete();
                String m1826 = C0050.m1826(file2);
                if (m1826 != null && C0050.m1827(file3, m1826)) {
                    this.f114.m1831();
                    return true;
                }
                this.f96.add(new RunnableC0069(m1826, file3, file2));
            } finally {
                this.f114.m1831();
            }
        }
        return false;
    }

    /* renamed from: г, reason: contains not printable characters */
    private boolean m1902(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null && absolutePath.length() > 0) {
                    if (!C0055.m1851(this.f97)) {
                        if (absolutePath.startsWith("/system/")) {
                        }
                    }
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: д, reason: contains not printable characters */
    private C0057 m1903() {
        C0057 m1857;
        C0057 c0057;
        String m1826;
        File file = new File(this.f111, "update.config");
        File file2 = new File(this.f111, "init.config");
        if (this.f105) {
            if (!file2.isFile() && m1907()) {
                m1901();
            }
            m1857 = C0057.m1857(file);
            if (m1857 == null) {
                c0057 = C0057.m1857(file2);
                if (c0057 != null || (m1826 = C0050.m1826(new File(this.f111, "dyInit.config"))) == null || !m1826.equals(Integer.toString(c0057.m1860()))) {
                    return c0057;
                }
                this.f96.add(new RunnableC0068(c0057.m1861(), c0057.m1860()));
                return null;
            }
            try {
                this.f114.m1830();
                file2.delete();
                file.renameTo(file2);
            } finally {
            }
        } else {
            try {
                this.f114.m1830();
                m1857 = C0057.m1857(file2);
            } finally {
            }
        }
        this.f114.m1831();
        c0057 = m1857;
        return c0057 != null ? c0057 : c0057;
    }

    /* renamed from: д, reason: contains not printable characters */
    private boolean m1904(File file) {
        try {
            File canonicalFile = file.getCanonicalFile();
            if (canonicalFile != null) {
                File parentFile = file.getParentFile();
                File parentFile2 = canonicalFile.getParentFile();
                if (parentFile == null || parentFile2 == null || parentFile.getCanonicalPath().equals(parentFile2.getCanonicalPath())) {
                    if (!file.getName().equals(canonicalFile.getName())) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            C0049.m1822("", th);
            m1875(100047, 0, th.toString(), file.getAbsolutePath(), "", "", "");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: д, reason: contains not printable characters */
    public boolean m1905(String str, String str2, boolean z10) throws SecException {
        if (str != null && str.trim().length() != 0) {
            String[] split = str.split(";");
            char c4 = 0;
            for (int i10 = 0; i10 < split.length; i10++) {
                String trim = split[i10].trim();
                if (trim.length() != 0) {
                    String[] split2 = trim.split(u.bD);
                    if (split2.length != 2) {
                        m1875(100040, 128, "nameVersionPair.length != 2", trim, str2, "" + z10, "" + i10);
                        throw new SecException(128);
                    }
                    int indexOf = str2.indexOf(split2[c4]);
                    if (indexOf >= 0) {
                        int indexOf2 = str2.indexOf("(", indexOf);
                        int indexOf3 = str2.indexOf(")", indexOf);
                        if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                            m1875(100040, 129, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", "" + indexOf2, "" + indexOf3, "", "" + i10);
                            throw new SecException(129);
                        }
                        String substring = str2.substring(indexOf2 + 1, indexOf3);
                        if (m1886(substring, split2[1]) < 0) {
                            String str3 = "version " + substring + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str3 = str3 + ", depended by: " + str2;
                            }
                            String str4 = str3;
                            if (!z10) {
                                m1875(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, split2[0], split2[1], "" + i10);
                            }
                            throw new SecException(str4, 113);
                        }
                    } else {
                        C0058 c0058 = this.f98.get(split2[0]);
                        if (c0058 == null) {
                            try {
                                c0058 = this.f110 ? m1899(split2[0], str2, !z10) : m1892(split2[0], str2, !z10);
                                th = null;
                            } catch (Throwable th) {
                                th = th;
                            }
                            if (c0058 == null) {
                                if (!z10) {
                                    if (th instanceof SecException) {
                                        throw th;
                                    }
                                    m1875(100040, 130, "throwable in loadPluginInner", "" + ((Object) th), str, str2, "" + i10);
                                    throw new SecException(str2, 130);
                                }
                            }
                        }
                        if (m1886(c0058.getVersion(), split2[1]) < 0) {
                            String str5 = "version " + c0058.getVersion() + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str5 = str5 + ", depended by: " + str2;
                            }
                            if (!z10) {
                                m1875(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", c0058.getVersion(), split2[0], split2[1], "" + i10);
                            }
                            throw new SecException(str5, 113);
                        }
                    }
                    c4 = 0;
                }
            }
        }
        return true;
    }

    /* renamed from: е, reason: contains not printable characters */
    private HashMap<String, String> m1906() {
        String str;
        if (this.f97.getApplicationInfo() == null || (str = this.f97.getApplicationInfo().nativeLibraryDir) == null) {
            return null;
        }
        String[] strArr = {"libsgmain", "libsgsecuritybody", "libsgmiddletier"};
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i10 = 0; i10 < 3; i10++) {
            String str2 = strArr[i10];
            File file = new File(str, str2 + "so.version.so");
            if (file.isFile()) {
                hashMap.put(str2, C0050.m1826(file));
            }
        }
        return hashMap;
    }

    /* renamed from: ж, reason: contains not printable characters */
    private boolean m1907() {
        if (f91 == null) {
            f91 = Boolean.valueOf(new File(m1916(), ".sgdynkp").isFile());
        }
        return f91.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: з, reason: contains not printable characters */
    public void m1908() {
        List<Runnable> list = this.f96;
        if (list != null) {
            try {
                Iterator<Runnable> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().run();
                }
            } catch (Exception unused) {
            }
            this.f96.clear();
        }
    }

    /* renamed from: и, reason: contains not printable characters */
    private String m1909() {
        StringBuilder sb2 = new StringBuilder();
        File file = this.f111;
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                sb2.append("[");
                File[] listFiles = file.listFiles();
                for (int i10 = 0; listFiles != null && i10 < listFiles.length; i10++) {
                    File file2 = listFiles[i10];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith(SplashAdCacheManager.SPLASH_AD_ZIP_PATH) || file2.getName().endsWith(".so"))) {
                        sb2.append(file2.getName());
                        sb2.append("(");
                        sb2.append(m1904(file2) + " , ");
                        sb2.append(file2.length());
                        sb2.append(") , ");
                    }
                }
                sb2.append("]");
            } catch (Throwable unused) {
            }
        } else {
            sb2.append("not exists!");
        }
        return sb2.toString();
    }

    /* renamed from: ё, reason: contains not printable characters */
    private void m1910() throws SecException {
        File m1868 = m1868(this.f97);
        this.f111 = m1868;
        if (m1868 != null) {
            this.f114 = new C0051(this.f97, ((Object) this.f111) + File.separator + "lock.lock");
            C0057 m1903 = m1903();
            this.f104 = m1903;
            this.f113 = m1869(this.f97, m1903);
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public <T> T getInterface(Class<T> cls) throws SecException {
        return this.f110 ? (T) m1912(cls) : (T) m1917(cls);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public String getMainPluginName() {
        return "main";
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public ISGPluginInfo getPluginInfo(String str) throws SecException {
        C0049.m1824("MockTaobaoChannel - getPluginInfo: " + str);
        return this.f110 ? m1899(str, "", true) : m1892(str, "", true);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public IRouterComponent getRouter() {
        return this.f100;
    }

    /* renamed from: а, reason: contains not printable characters */
    public File m1911() {
        return this.f111;
    }

    /* renamed from: а, reason: contains not printable characters */
    public <T> T m1912(Class<T> cls) throws SecException {
        String str;
        Object obj = this.f99.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        C0057 c0057 = this.f104;
        if (c0057 != null) {
            str = c0057.m1863();
            if (str == null || str.length() == 0) {
                str = this.f104.m1858(cls.getName());
            }
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            str = m1894((Class<?>) cls);
        }
        if (str == null || str.length() == 0) {
            throw new SecException(150);
        }
        ISGPluginInfo pluginInfo = getPluginInfo(str);
        if (pluginInfo == null) {
            if (this.f106 && getMainPluginName().equals(str)) {
                throw new SecException(110);
            }
            return null;
        }
        Object obj2 = pluginInfo.getSGPluginEntry().getInterface(cls);
        if (obj2 != null) {
            this.f99.put(cls, obj2);
            return cls.cast(obj2);
        }
        m1875(100045, 112, "", cls.getName(), str + "(" + pluginInfo.getVersion() + ")", m1900(pluginInfo.getPluginPath()), "");
        throw new SecException(112);
    }

    /* renamed from: а, reason: contains not printable characters */
    public void m1913(Context context, String str, String str2, boolean z10, Object... objArr) {
        String str3 = "0";
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f97 = context;
        this.f103 = str;
        this.f105 = C0055.m1850(context);
        this.f101 = z10;
        this.f96 = new ArrayList();
        UserTrackMethodJniBridge.init(this.f97);
        if (str2 != null && !str2.isEmpty()) {
            this.f102 = str2;
        }
        boolean z11 = false;
        try {
            m1910();
            String m1826 = C0050.m1826(new File(m1868(this.f97), ".giw"));
            if (m1826 != null) {
                this.f110 = new Random().nextDouble() < Double.parseDouble(m1826);
            }
        } catch (SecException | Exception unused) {
        }
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener");
            Method method = cls.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                str3 = (String) method.invoke(cls, "securityguard_orange_namespace", "113", "0");
            }
        } catch (Throwable th) {
            C0049.m1820("getKeepAliveOrangeSwitch : " + th.getMessage());
        }
        this.f108 |= "1".equals(str3);
        try {
            Class<?> cls2 = Class.forName("com.taobao.adaemon.ADaemon");
            Method method2 = cls2.getMethod("isChannelMemOptimizeEnable", Context.class);
            if (method2 != null) {
                z11 = ((Boolean) method2.invoke(cls2, this.f97)).booleanValue();
            }
        } catch (Throwable th2) {
            C0049.m1820("ADaemon.isChannelMemOptimizeEnable: " + th2.getMessage());
        }
        boolean z12 = this.f108 | z11;
        this.f108 = z12;
        this.f109 = z12;
    }

    /* renamed from: а, reason: contains not printable characters */
    public void m1914(String str) {
        if (!m1907() || str == null) {
            return;
        }
        File file = new File(m1916(), "upds/libs/" + str);
        if (!file.isDirectory()) {
            this.f96.add(new RunnableC0061(file));
            return;
        }
        File file2 = new File(file, "FBD");
        if (C0050.m1827(file2, "1")) {
            return;
        }
        this.f96.add(new RunnableC0060(file2));
    }

    /* renamed from: а, reason: contains not printable characters */
    public void m1915(boolean z10) {
        boolean z11;
        if (z10) {
            z11 = true;
            this.f108 = true;
        } else {
            this.f108 = this.f109;
            z11 = this.f107;
        }
        this.f106 = z11;
    }

    /* renamed from: б, reason: contains not printable characters */
    public File m1916() {
        return this.f112;
    }

    /* renamed from: б, reason: contains not printable characters */
    public synchronized <T> T m1917(Class<T> cls) throws SecException {
        return (T) m1912(cls);
    }
}
