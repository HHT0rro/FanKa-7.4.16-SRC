package com.ishumei.smantifraud.l111l11111I1l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111Il1l {
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[Catch: Exception -> 0x005b, TRY_LEAVE, TryCatch #0 {Exception -> 0x005b, blocks: (B:3:0x0001, B:5:0x000d, B:8:0x001d, B:9:0x0021, B:11:0x0031, B:15:0x0039, B:17:0x003f, B:19:0x004a, B:25:0x0052), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String l1111l111111Il() {
        /*
            r0 = 0
            java.lang.String r1 = "cat /proc/self/cgroup"
            java.lang.String r1 = l1111l111111Il(r1)     // Catch: java.lang.Exception -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L5b
            if (r2 != 0) goto L5c
            java.lang.String r2 = "uid"
            int r2 = r1.lastIndexOf(r2)     // Catch: java.lang.Exception -> L5b
            java.lang.String r3 = "/pid"
            int r3 = r1.lastIndexOf(r3)     // Catch: java.lang.Exception -> L5b
            if (r2 < 0) goto L5c
            if (r3 > 0) goto L21
            int r3 = r1.length()     // Catch: java.lang.Exception -> L5b
        L21:
            int r2 = r2 + 4
            java.lang.String r1 = r1.substring(r2, r3)     // Catch: java.lang.Exception -> L5b
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)     // Catch: java.lang.Exception -> L5b
            if (r1 == 0) goto L4f
            int r2 = r1.length()     // Catch: java.lang.Exception -> L5b
            if (r2 != 0) goto L38
            goto L4f
        L38:
            r2 = 0
        L39:
            int r3 = r1.length()     // Catch: java.lang.Exception -> L5b
            if (r2 >= r3) goto L4d
            char r3 = r1.charAt(r2)     // Catch: java.lang.Exception -> L5b
            boolean r3 = java.lang.Character.isDigit(r3)     // Catch: java.lang.Exception -> L5b
            if (r3 != 0) goto L4a
            goto L4f
        L4a:
            int r2 = r2 + 1
            goto L39
        L4d:
            r2 = 1
            goto L50
        L4f:
            r2 = 0
        L50:
            if (r2 == 0) goto L5c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L5b
            int r0 = r1.intValue()     // Catch: java.lang.Exception -> L5b
            goto L5c
        L5b:
        L5c:
            if (r0 != 0) goto L6a
            android.content.Context r1 = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il     // Catch: java.lang.Exception -> L69
            if (r1 == 0) goto L6a
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()     // Catch: java.lang.Exception -> L69
            int r0 = r1.uid     // Catch: java.lang.Exception -> L69
            goto L6a
        L69:
        L6a:
            if (r0 != 0) goto L6e
            r0 = 0
            return r0
        L6e:
            java.lang.String r0 = l1111l111111Il(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l11111I1l.l11l1111Il1l.l1111l111111Il():java.lang.String");
    }

    private static String l1111l111111Il(int i10) {
        Method method;
        if (Build.VERSION.SDK_INT > 27) {
            return String.format(Locale.US, "u0_a%d", Integer.valueOf(i10 - 10000));
        }
        try {
            Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(null);
            if (obj != null && (method = obj.getClass().getMethod("getpwuid", Integer.TYPE)) != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                Object invoke = method.invoke(obj, Integer.valueOf(i10));
                if (invoke != null) {
                    Field declaredField2 = invoke.getClass().getDeclaredField("pw_name");
                    if (!declaredField2.isAccessible()) {
                        declaredField2.setAccessible(true);
                    }
                    return (String) declaredField2.get(invoke);
                }
            }
            return null;
        } catch (Exception unused) {
            return String.format(Locale.US, "u0_a%d", Integer.valueOf(i10 - 10000));
        }
    }

    private static String l1111l111111Il(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[512];
        StringBuilder sb2 = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb2.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return sb2.toString();
    }

    private static String l1111l111111Il(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec(str);
            try {
                bufferedInputStream = new BufferedInputStream(process.getInputStream());
            } catch (Exception unused) {
                bufferedInputStream = null;
            } catch (Throwable th2) {
                bufferedInputStream = null;
                th = th2;
            }
        } catch (Exception unused2) {
            process = null;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            process = null;
        }
        try {
            process.waitFor();
            String l1111l111111Il = l1111l111111Il(bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException unused3) {
            }
            process.destroy();
            return l1111l111111Il;
        } catch (Exception unused4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused5) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused6) {
                }
            }
            if (process == null) {
                throw th;
            }
            process.destroy();
            throw th;
        }
    }

    public static void l1111l111111Il(com.ishumei.smantifraud.l1111l111111Il.l111l11111I1l l111l11111i1l) {
        try {
            String l1111l111111Il = l1111l111111Il();
            if (TextUtils.isEmpty(l1111l111111Il)) {
                return;
            }
            String l1111l111111Il2 = l1111l111111Il("ps");
            if (!TextUtils.isEmpty(l1111l111111Il2) && l1111l111111Il2.split("\n").length > 0) {
                l111l11111i1l.l111l111I1l(l1111l111111Il);
            }
        } catch (Exception unused) {
        }
    }

    private static void l111l11111lIl(com.ishumei.smantifraud.l1111l111111Il.l111l11111I1l l111l11111i1l) {
        try {
            String l1111l111111Il = l1111l111111Il();
            if (TextUtils.isEmpty(l1111l111111Il)) {
                return;
            }
            String l1111l111111Il2 = l1111l111111Il("ps");
            if (!TextUtils.isEmpty(l1111l111111Il2) && l1111l111111Il2.split("\n").length > 0) {
                l111l11111i1l.l111l111I1l(l1111l111111Il);
            }
        } catch (Exception unused) {
        }
    }

    private static boolean l111l11111lIl(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }
}
