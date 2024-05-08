package com.inno.innosdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: EmulatorDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35591a = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35592b = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f35593c = {"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f35594d = {"fstab.andy", "ueventd.andy.rc"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f35595e = {"fstab.nox", "init.nox.rc", "ueventd.nox.rc"};

    /* renamed from: f, reason: collision with root package name */
    public static final l[] f35596f = {new l("init.svc.qemud", null), new l("init.svc.qemu-props", null), new l("qemu.hw.mainkeys", null), new l("qemu.sf.fake_camera", null), new l("qemu.sf.lcd_density", null), new l("ro.bootloader", "unknown"), new l("ro.bootmode", "unknown"), new l("ro.hardware", "goldfish"), new l("ro.kernel.android.qemud", null), new l("ro.kernel.qemu.gles", null), new l("ro.kernel.qemu", "1"), new l("ro.product.device", "generic"), new l("ro.product.model", "sdk"), new l("ro.product.name", "sdk"), new l("ro.serialno", null)};

    /* renamed from: g, reason: collision with root package name */
    public static g f35597g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f35598h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f35599i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35600j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f35601k = true;

    /* renamed from: l, reason: collision with root package name */
    public List<String> f35602l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public String f35603m;

    public g(Context context) {
        this.f35598h = context;
        this.f35602l.addAll(Arrays.asList(com.inno.innosdk.b.a.w().split(",")));
    }

    public static g a(Context context) {
        if (context != null) {
            if (f35597g == null) {
                f35597g = new g(context);
            }
            return f35597g;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    private String a(Context context, String str) {
        return null;
    }

    private void a(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b() {
        /*
            r9 = this;
            android.content.Context r0 = r9.f35598h
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r0 = com.inno.innosdk.utils.q.a(r0, r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lc1
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r0 < r3) goto L13
            return r1
        L13:
            java.lang.String r0 = "/system/bin/netcfg"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 0
            java.lang.ProcessBuilder r5 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L52
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L52
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L52
            java.lang.String r6 = "/system/bin/"
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L52
            r5.directory(r0)     // Catch: java.lang.Throwable -> L52
            r5.redirectErrorStream(r2)     // Catch: java.lang.Throwable -> L52
            java.lang.Process r0 = r5.start()     // Catch: java.lang.Throwable -> L52
            java.io.InputStream r4 = r0.getInputStream()     // Catch: java.lang.Throwable -> L4d
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L4d
        L3d:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L4d
            r7 = -1
            if (r6 == r7) goto L5a
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L4d
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L4d
            r3.append(r6)     // Catch: java.lang.Throwable -> L4d
            goto L3d
        L4d:
            r5 = move-exception
            r8 = r4
            r4 = r0
            r0 = r8
            goto L54
        L52:
            r5 = move-exception
            r0 = r4
        L54:
            com.inno.innosdk.utils.u.a.a(r5)     // Catch: java.lang.Throwable -> Lb9
            r8 = r4
            r4 = r0
            r0 = r8
        L5a:
            com.inno.innosdk.utils.t.a.a(r4)
            com.inno.innosdk.utils.t.a.a(r0)
            java.lang.String r0 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "netcfg data -> "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r9.a(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto Lc1
            java.lang.String r3 = "\n"
            java.lang.String[] r0 = r0.split(r3)
            int r3 = r0.length
            r4 = 0
        L86:
            if (r4 >= r3) goto Lc1
            r5 = r0[r4]
            java.lang.String r6 = "wlan0"
            boolean r6 = r5.contains(r6)
            if (r6 != 0) goto La2
            java.lang.String r6 = "tunl0"
            boolean r6 = r5.contains(r6)
            if (r6 != 0) goto La2
            java.lang.String r6 = "eth0"
            boolean r6 = r5.contains(r6)
            if (r6 == 0) goto Lac
        La2:
            java.lang.String r6 = "10.0.2.15"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto Lac
            r5 = 1
            goto Lad
        Lac:
            r5 = 0
        Lad:
            if (r5 == 0) goto Lb6
            java.lang.String r0 = "Check IP is detected"
            r9.a(r0)
            r1 = 1
            goto Lc1
        Lb6:
            int r4 = r4 + 1
            goto L86
        Lb9:
            r1 = move-exception
            com.inno.innosdk.utils.t.a.a(r0)
            com.inno.innosdk.utils.t.a.a(r4)
            throw r1
        Lc1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.g.b():boolean");
    }

    private boolean d() {
        int i10 = 0;
        for (l lVar : f35596f) {
            String a10 = a(this.f35598h, lVar.f35613a);
            if (a10 != null) {
                String str = lVar.f35614b;
                if (str == null) {
                    i10++;
                }
                if (str != null && a10.contains(str)) {
                    i10++;
                }
            }
        }
        if (i10 < 5) {
            return false;
        }
        a("Check QEmuProps is detected");
        return true;
    }

    public static String f() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\nBuild.MANUFACTURER: " + Build.MANUFACTURER + "\nBuild.BRAND: " + Build.BRAND + "\nBuild.DEVICE: " + Build.DEVICE + "\nBuild.MODEL: " + Build.MODEL + "\nBuild.HARDWARE: " + Build.HARDWARE + "\nBuild.FINGERPRINT: " + Build.FINGERPRINT;
    }

    public boolean c() {
        try {
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (this.f35601k && !this.f35602l.isEmpty()) {
            if (!TextUtils.isEmpty(this.f35603m)) {
                return true;
            }
            PackageManager packageManager = this.f35598h.getPackageManager();
            for (String str : this.f35602l) {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null && !packageManager.queryIntentActivities(launchIntentForPackage, 65536).isEmpty()) {
                    this.f35603m = str;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean e() {
        a(f());
        boolean a10 = com.inno.innosdk.utils.w.a.o().a(this.f35598h, null);
        if (a10) {
            return a10;
        }
        boolean a11 = a();
        a("Check Advanced " + a11);
        return a11;
    }

    public String g() {
        return (TextUtils.isEmpty(this.f35603m) && c()) ? this.f35603m : "";
    }

    public boolean a() {
        try {
            if (!a(f35591a, "Geny") && !a(f35594d, "Andy") && !a(f35595e, "Nox") && !a(f35592b, "Pipes") && !b()) {
                if (!d()) {
                    return false;
                }
                if (!a(f35593c, "X86")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    private boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (new File(str2).exists()) {
                a("Check " + str + " is detected");
                return true;
            }
        }
        return false;
    }
}
