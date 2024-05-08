package com.inno.innosdk.utils.w;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* compiled from: SimulatorDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f35681a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f35682b;

    /* renamed from: c, reason: collision with root package name */
    public String f35683c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f35684d;

    /* compiled from: SimulatorDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        INSTANCE;


        /* renamed from: c, reason: collision with root package name */
        public a f35687c = new a();

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a() {
            return this.f35687c;
        }
    }

    private c b() {
        String str = Build.BOARD;
        if (!TextUtils.isEmpty(str) && !str.contains("android")) {
            String lowerCase = str.toLowerCase();
            return new c((lowerCase.contains("goldfish") || lowerCase.contains("nox") || "unknown".equals(str)) ? 1 : 2, "board = " + str);
        }
        return new c(0, "get null from ro.product.board");
    }

    private c c() {
        String str = Build.BOOTLOADER;
        if (TextUtils.isEmpty(str)) {
            return new c(0, "get null from ro.bootloader");
        }
        return new c(str.toLowerCase().contains("nox") ? 1 : 2, "bootloader = " + str);
    }

    private c d() {
        return new c(2, com.inno.innosdk.utils.s.a.a("cat /proc/self/cgroup"));
    }

    private c e() {
        String str = Build.FINGERPRINT;
        if (TextUtils.isEmpty(str)) {
            return new c(0, "get null from fingerprint");
        }
        return new c(str.startsWith("generic") ? 1 : 2, "fingerprint = " + str);
    }

    private c f() {
        String b4 = com.inno.innosdk.utils.s.a.b("ro.build.flavor");
        if (TextUtils.isEmpty(b4)) {
            return new c(0, "get null from ro.build.flavor");
        }
        String lowerCase = b4.toLowerCase();
        return new c((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, "flavor = " + b4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
    
        if (r1.equals("cancro") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.inno.innosdk.utils.w.c g() {
        /*
            r8 = this;
            java.lang.String r0 = android.os.Build.HARDWARE
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L11
            com.inno.innosdk.utils.w.c r0 = new com.inno.innosdk.utils.w.c
            java.lang.String r1 = "get null from ro.hardware"
            r0.<init>(r2, r1)
            return r0
        L11:
            java.lang.String r1 = r0.toLowerCase()
            r1.hashCode()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 2
            java.lang.String r6 = "nox"
            r7 = 1
            switch(r4) {
                case -1367724016: goto L71;
                case -822798509: goto L66;
                case 109271: goto L5d;
                case 3570999: goto L52;
                case 3613077: goto L47;
                case 100361430: goto L3c;
                case 937844646: goto L31;
                case 2036942520: goto L26;
                default: goto L24;
            }
        L24:
            r2 = -1
            goto L7a
        L26:
            java.lang.String r2 = "goldfish"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L2f
            goto L24
        L2f:
            r2 = 7
            goto L7a
        L31:
            java.lang.String r2 = "android_x86"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L3a
            goto L24
        L3a:
            r2 = 6
            goto L7a
        L3c:
            java.lang.String r2 = "intel"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L45
            goto L24
        L45:
            r2 = 5
            goto L7a
        L47:
            java.lang.String r2 = "vbox"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L50
            goto L24
        L50:
            r2 = 4
            goto L7a
        L52:
            java.lang.String r2 = "ttvm"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L5b
            goto L24
        L5b:
            r2 = 3
            goto L7a
        L5d:
            boolean r2 = r1.equals(r6)
            if (r2 != 0) goto L64
            goto L24
        L64:
            r2 = 2
            goto L7a
        L66:
            java.lang.String r2 = "vbox86"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L6f
            goto L24
        L6f:
            r2 = 1
            goto L7a
        L71:
            java.lang.String r4 = "cancro"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L7a
            goto L24
        L7a:
            switch(r2) {
                case 0: goto L7e;
                case 1: goto L7e;
                case 2: goto L7e;
                case 3: goto L7e;
                case 4: goto L7e;
                case 5: goto L7e;
                case 6: goto L7e;
                case 7: goto L7e;
                default: goto L7d;
            }
        L7d:
            goto L7f
        L7e:
            r5 = 1
        L7f:
            boolean r1 = r1.contains(r6)
            if (r1 == 0) goto L86
            goto L87
        L86:
            r7 = r5
        L87:
            com.inno.innosdk.utils.w.c r1 = new com.inno.innosdk.utils.w.c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "hardware = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r7, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.w.a.g():com.inno.innosdk.utils.w.c");
    }

    private c h() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return new c(0, "get null from ro.product.manufacturer");
        }
        String lowerCase = str.toLowerCase();
        return new c((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, "manufacturer = " + str);
    }

    private c i() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return new c(0, "get null from ro.product.model");
        }
        String lowerCase = str.toLowerCase();
        return new c((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86") || lowerCase.contains("droid4x") || "sdk".equals(str)) ? 1 : 2, "model = " + str);
    }

    private c j() {
        String str = Build.BRAND;
        String str2 = Build.DEVICE;
        if (TextUtils.isEmpty(str)) {
            return new c(0, "get null from ro.product.brand");
        }
        if (TextUtils.isEmpty(str2)) {
            return new c(0, "get null from ro.product.device");
        }
        return new c((str.startsWith("generic") && str2.startsWith("generic")) ? 1 : 2, "brand:" + str + " device:" + str2);
    }

    private c k() {
        String b4 = com.inno.innosdk.utils.s.a.b("ro.board.platform");
        if (TextUtils.isEmpty(b4)) {
            return new c(0, "get null from ro.board.platform");
        }
        return new c(b4.toLowerCase().contains("android") ? 0 : 2, "platform = " + b4);
    }

    private c l() {
        String str = Build.PRODUCT;
        if (TextUtils.isEmpty(str)) {
            return new c(0, "get null from ro.product.name");
        }
        String lowerCase = str.toLowerCase();
        return new c((TextUtils.equals(lowerCase, "sdk") || TextUtils.equals(lowerCase, "google_sdk") || TextUtils.equals(lowerCase, "sdk_x86") || TextUtils.equals(lowerCase, "vbox86p") || lowerCase.contains("nox")) ? 1 : 2, "product = " + str);
    }

    public static a o() {
        return b.INSTANCE.a();
    }

    public boolean a(Context context, com.inno.innosdk.utils.w.b bVar) {
        if (context != null) {
            this.f35681a = 0;
            this.f35682b = new StringBuilder();
            c g3 = g();
            int a10 = g3.a();
            if (a10 == 0) {
                this.f35681a++;
                StringBuilder sb2 = this.f35682b;
                sb2.append(1);
                sb2.append(",");
            } else if (a10 == 1) {
                if (bVar != null) {
                    bVar.a(g3.b());
                }
                this.f35683c = g3.b();
                return true;
            }
            c f10 = f();
            int a11 = f10.a();
            if (a11 == 0) {
                this.f35681a++;
                StringBuilder sb3 = this.f35682b;
                sb3.append(2);
                sb3.append(",");
            } else if (a11 == 1) {
                if (bVar != null) {
                    bVar.a(f10.b());
                }
                this.f35683c = f10.b();
                return true;
            }
            c i10 = i();
            int a12 = i10.a();
            if (a12 == 0) {
                this.f35681a++;
                StringBuilder sb4 = this.f35682b;
                sb4.append(3);
                sb4.append(",");
            } else if (a12 == 1) {
                if (bVar != null) {
                    bVar.a(i10.b());
                }
                this.f35683c = i10.b();
                return true;
            }
            c h10 = h();
            int a13 = h10.a();
            if (a13 == 0) {
                this.f35681a++;
                StringBuilder sb5 = this.f35682b;
                sb5.append(4);
                sb5.append(",");
            } else if (a13 == 1) {
                if (bVar != null) {
                    bVar.a(h10.b());
                }
                this.f35683c = h10.b();
                return true;
            }
            c b4 = b();
            int a14 = b4.a();
            if (a14 == 0) {
                this.f35681a++;
                StringBuilder sb6 = this.f35682b;
                sb6.append(5);
                sb6.append(",");
            } else if (a14 == 1) {
                if (bVar != null) {
                    bVar.a(b4.b());
                }
                this.f35683c = b4.b();
                return true;
            }
            c k10 = k();
            int a15 = k10.a();
            if (a15 == 0) {
                this.f35681a++;
                StringBuilder sb7 = this.f35682b;
                sb7.append(6);
                sb7.append(",");
            } else if (a15 == 1) {
                if (bVar != null) {
                    bVar.a(k10.b());
                }
                this.f35683c = k10.b();
                return true;
            }
            c a16 = a();
            int a17 = a16.a();
            if (a17 == 0) {
                this.f35681a++;
                StringBuilder sb8 = this.f35682b;
                sb8.append(7);
                sb8.append(",");
            } else if (a17 == 1) {
                if (bVar != null) {
                    bVar.a(a16.b());
                }
                this.f35683c = a16.b();
                return true;
            }
            c l10 = l();
            int a18 = l10.a();
            if (a18 == 0) {
                this.f35681a++;
                StringBuilder sb9 = this.f35682b;
                sb9.append(8);
                sb9.append(",");
            } else if (a18 == 1) {
                if (bVar != null) {
                    bVar.a(l10.b());
                }
                this.f35683c = l10.b();
                return true;
            }
            c c4 = c();
            int a19 = c4.a();
            if (a19 == 0) {
                this.f35681a++;
                StringBuilder sb10 = this.f35682b;
                sb10.append(9);
                sb10.append(",");
            } else if (a19 == 1) {
                if (bVar != null) {
                    bVar.a(c4.b());
                }
                this.f35683c = c4.b();
                return true;
            }
            c e2 = e();
            int a20 = e2.a();
            if (a20 == 0) {
                this.f35681a++;
                StringBuilder sb11 = this.f35682b;
                sb11.append(10);
                sb11.append(",");
            } else if (a20 == 1) {
                if (bVar != null) {
                    bVar.a(e2.b());
                }
                this.f35683c = e2.b();
                return true;
            }
            c j10 = j();
            int a21 = j10.a();
            if (a21 == 0) {
                this.f35681a++;
                StringBuilder sb12 = this.f35682b;
                sb12.append(11);
                sb12.append(",");
            } else if (a21 == 1) {
                if (bVar != null) {
                    bVar.a(j10.b());
                }
                this.f35683c = j10.b();
                return true;
            }
            if (!c(context)) {
                this.f35681a++;
                StringBuilder sb13 = this.f35682b;
                sb13.append(14);
                sb13.append(",");
            }
            if (!b(context)) {
                this.f35681a++;
                StringBuilder sb14 = this.f35682b;
                sb14.append(15);
                sb14.append(",");
            }
            if (!a(context)) {
                this.f35681a++;
                StringBuilder sb15 = this.f35682b;
                sb15.append(16);
                sb15.append(",");
            }
            if (d().a() == 0) {
                this.f35681a++;
                StringBuilder sb16 = this.f35682b;
                sb16.append(18);
                sb16.append(",");
            }
            if (bVar != null) {
                if (this.f35682b.length() > 0) {
                    if (this.f35682b.charAt(this.f35682b.length() - 1) == ',') {
                        StringBuilder sb17 = this.f35682b;
                        sb17.deleteCharAt(sb17.length() - 1);
                    }
                }
                bVar.a(this.f35682b.toString());
            }
            return false;
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public String m() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f35684d) {
            if (new File(str).exists()) {
                sb2.append(str);
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public String n() {
        return this.f35683c;
    }

    public int p() {
        return this.f35681a;
    }

    public String q() {
        if (this.f35682b.length() > 0) {
            if (',' == this.f35682b.charAt(this.f35682b.length() - 1)) {
                this.f35682b.deleteCharAt(r0.length() - 1);
            }
        }
        return this.f35682b.toString();
    }

    public a() {
        this.f35684d = new String[]{"/sys/qemu_trace", "/data/youwave_id", "/mnt/prebundledapps/propfiles/ics.bluestacks.prop.note", "/mnt/prebundledapps/propfiles/ics.bluestacks.prop.s2", "/mnt/prebundledapps/propfiles/ics.bluestacks.prop.s3", "/mnt/sdcard/bstfolder/InputMapper/com.bluestacks.appmart.cfg", "/mnt/sdcard/buildroid-gapps-ics-20120317-signed.tgz", "/mnt/sdcard/windows/InputMapper/com.bluestacks.appmart.cfg", "/proc/irq/9/vboxguest", "/sys/bus/platform/drivers/qemu_trace", "/sys/class/bdi/vboxsf-c", "/sys/class/misc/vboxguest", "/sys/class/misc/vboxuser", "/sys/devices/virtual/bdi/vboxsf-c", "/sys/module/vboxvideo", "/system/app/bluestacksHome.apk", "/system/bin/androVM-vbox-sf", "/system/bin/androVM_setprop", "/system/bin/get_androVM_host", "/system/bin/mount.vboxsf", "/system/etc/init.androVM.sh", "/system/etc/init.buildroid.sh", "/system/lib/hw/audio.primary.vbox86.so", "/system/lib/hw/camera.vbox86.so", "/system/lib/hw/gps.vbox86.so", "/system/lib/hw/gralloc.vbox86.so", "/system/lib/hw/sensors.vbox86.so", "/system/lib/modules/3.0.8-android-x86+/extra/vboxguest", "/system/lib/modules/3.0.8-android-x86+/extra/vboxguest/vboxguest.ko", "/system/lib/modules/3.0.8-android-x86+/extra/vboxsf", "/system/lib/modules/3.0.8-android-x86+/extra/vboxsf/vboxsf.ko", "/system/lib/vboxvideo.ko", "/system/usr/idc/androVM_Virtual_Input.idc", "/system/usr/keylayout/androVM_Virtual_Input.kl", "/system/xbin/mount.vboxsf", "/ueventd.android_x86.rc", "/ueventd.vbox86.rc", "/fstab.vbox86", "/init.vbox86.rc", "/sys/module/goldfish_audio", "/sys/module/goldfish_sync", "/data/data/com.microvirt.download", "/data/data/com.microvirt.guide", "/data/data/com.microvirt.installer", "/data/data/com.microvirt.memuime", "/data/data/com.mumu.launcher", "/data/data/com.mumu.store", "/data/data/com.netease.mumu.cloner"};
    }

    private boolean c(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    private c a() {
        String b4 = com.inno.innosdk.utils.s.a.b("gsm.version.baseband");
        if (TextUtils.isEmpty(b4)) {
            return new c(0, "get null from gsm.version.baseband");
        }
        return new c(b4.contains("1.0.0.0") ? 0 : 2, "baseBand = " + b4);
    }

    private boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }
}
