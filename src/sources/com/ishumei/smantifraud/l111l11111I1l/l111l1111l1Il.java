package com.ishumei.smantifraud.l111l11111I1l;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111l1Il {
    private static final int l1111l111111Il = -1;
    private static final FileFilter l111l11111lIl = new FileFilter() { // from class: com.ishumei.smantifraud.l111l11111I1l.l111l1111l1Il.1
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String name = file.getName();
            try {
                if (name.startsWith(IAdInterListener.AdProdType.PRODUCT_CPU)) {
                    for (int i10 = 3; i10 < name.length(); i10++) {
                        if (!Character.isDigit(name.charAt(i10))) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class l1111l111111Il {
        public String l1111l111111Il = "";
        public String l111l11111lIl = "";
    }

    private static int l1111l111111Il(String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        int i10 = -1;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.matches("0-[\\d]+$")) {
                i10 = Integer.parseInt(readLine.substring(2)) + 1;
            }
            com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) bufferedReader);
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) bufferedReader2);
            com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream);
            return i10;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) bufferedReader2);
            com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream);
            throw th;
        }
        com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream);
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x005f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int l1111l111111Il(java.lang.String r10, java.io.FileInputStream r11) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]
            r2 = -1
            int r11 = r11.read(r1)     // Catch: java.lang.Throwable -> L62
            r3 = 0
            r4 = 0
        Lb:
            if (r4 >= r11) goto L62
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L62
            r6 = 10
            if (r5 == r6) goto L15
            if (r4 != 0) goto L5f
        L15:
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L62
            if (r5 != r6) goto L1b
            int r4 = r4 + 1
        L1b:
            r5 = r4
        L1c:
            if (r5 >= r11) goto L5f
            int r7 = r5 - r4
            r8 = r1[r5]     // Catch: java.lang.Throwable -> L62
            char r9 = r10.charAt(r7)     // Catch: java.lang.Throwable -> L62
            if (r8 != r9) goto L5f
            int r8 = r10.length()     // Catch: java.lang.Throwable -> L62
            int r8 = r8 + (-1)
            if (r7 != r8) goto L5c
        L30:
            if (r5 >= r0) goto L5b
            r10 = r1[r5]     // Catch: java.lang.Throwable -> L62
            if (r10 == r6) goto L5b
            r10 = r1[r5]     // Catch: java.lang.Throwable -> L62
            boolean r10 = java.lang.Character.isDigit(r10)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L58
            int r10 = r5 + 1
        L40:
            if (r10 >= r0) goto L4d
            r11 = r1[r10]     // Catch: java.lang.Throwable -> L62
            boolean r11 = java.lang.Character.isDigit(r11)     // Catch: java.lang.Throwable -> L62
            if (r11 == 0) goto L4d
            int r10 = r10 + 1
            goto L40
        L4d:
            java.lang.String r11 = new java.lang.String     // Catch: java.lang.Throwable -> L62
            int r10 = r10 - r5
            r11.<init>(r1, r3, r5, r10)     // Catch: java.lang.Throwable -> L62
            int r10 = java.lang.Integer.parseInt(r11)     // Catch: java.lang.Throwable -> L62
            return r10
        L58:
            int r5 = r5 + 1
            goto L30
        L5b:
            return r2
        L5c:
            int r5 = r5 + 1
            goto L1c
        L5f:
            int r4 = r4 + 1
            goto Lb
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l11111I1l.l111l1111l1Il.l1111l111111Il(java.lang.String, java.io.FileInputStream):int");
    }

    private static int l1111l111111Il(byte[] bArr, int i10) {
        while (i10 < 1024 && bArr[i10] != 10) {
            if (Character.isDigit(bArr[i10])) {
                int i11 = i10 + 1;
                while (i11 < 1024 && Character.isDigit(bArr[i11])) {
                    i11++;
                }
                return Integer.parseInt(new String(bArr, 0, i10, i11 - i10));
            }
            i10++;
        }
        return -1;
    }

    public static l1111l111111Il l1111l111111Il() {
        l1111l111111Il l1111l111111il = new l1111l111111Il();
        try {
            Iterator<String> iterator2 = com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l11111Il("/proc/cpuinfo").iterator2();
            while (iterator2.hasNext()) {
                String[] split = iterator2.next().split(u.bD);
                if (2 == split.length) {
                    String trim = split[0].trim();
                    String trim2 = split[1].trim();
                    if ("Hardware".equals(trim)) {
                        l1111l111111il.l111l11111lIl = trim2;
                    }
                    if (TextUtils.equals("Processor", trim) || TextUtils.equals("model name", trim)) {
                        l1111l111111il.l1111l111111Il = trim2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return l1111l111111il;
    }

    public static int l111l11111I1l() {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            int l111l11111lIl2 = l111l11111lIl();
            int i10 = -1;
            for (int i11 = 0; i11 < l111l11111lIl2; i11++) {
                File file = new File("/sys/devices/system/cpu/cpu" + i11 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileInputStream2.read(bArr);
                        int i12 = 0;
                        while (i12 < 128 && Character.isDigit(bArr[i12])) {
                            i12++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i12)));
                        if (valueOf.intValue() > i10) {
                            i10 = valueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th2) {
                        com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream2);
                        throw th2;
                    }
                    com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream2);
                }
            }
            if (i10 == -1) {
                try {
                    fileInputStream = new FileInputStream("/proc/cpuinfo");
                    try {
                        int l1111l111111Il2 = l1111l111111Il("cpu MHz", fileInputStream) * 1000;
                        if (l1111l111111Il2 > i10) {
                            i10 = l1111l111111Il2;
                        }
                        com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il((Closeable) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    fileInputStream = null;
                    th = th4;
                }
            }
            return i10;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static long l111l11111Il() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int l111l11111lIl() {
        try {
            int l1111l111111Il2 = l1111l111111Il("/sys/devices/system/cpu/possible");
            if (l1111l111111Il2 == -1) {
                l1111l111111Il2 = l1111l111111Il("/sys/devices/system/cpu/present");
            }
            return l1111l111111Il2 == -1 ? l111l1111l1Il() : l1111l111111Il2;
        } catch (SecurityException | Exception unused) {
            return -1;
        }
    }

    private static int l111l11111lIl(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.parseInt(str.substring(2)) + 1;
    }

    private static int l111l1111l1Il() {
        try {
            return new File("/sys/devices/system/cpu/possible").listFiles(l111l11111lIl).length;
        } catch (Exception unused) {
            return 0;
        }
    }
}
