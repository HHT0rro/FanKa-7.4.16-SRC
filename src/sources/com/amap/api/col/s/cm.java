package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: AAIDKeyFactorUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cm {
    public static String a(Context context) {
        try {
            String a10 = cj.a(context);
            try {
                if (!TextUtils.isEmpty(a10)) {
                    return a10;
                }
                a10 = UUID.randomUUID().toString();
                cj.a(context, a10);
                return a10;
            } catch (Throwable unused) {
                return a10;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String b() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date a10 = a(split[0]);
                String trim = split[1] != null ? split[1].split("\\+")[0].trim() : "";
                if (!TextUtils.isEmpty(trim)) {
                    str = (a10.getTime() / 1000) + "." + c(trim);
                } else {
                    str = String.valueOf(a10.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String c() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date a10 = a(split[0]);
                String trim = split[1] != null ? split[1].split("\\+")[0].trim() : "";
                if (!TextUtils.isEmpty(trim)) {
                    str = (a10.getTime() / 1000) + "." + c(trim);
                } else {
                    str = String.valueOf(a10.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String d() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date a10 = a(split[0]);
                String trim = split[1] != null ? split[1].split("\\+")[0].trim() : "";
                if (!TextUtils.isEmpty(trim)) {
                    str = (a10.getTime() / 1000) + "." + c(trim);
                } else {
                    str = String.valueOf(a10.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String e() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date a10 = a(split[0]);
                String trim = split[1] != null ? split[1].split("\\+")[0].trim() : "";
                if (!TextUtils.isEmpty(trim)) {
                    str = (a10.getTime() / 1000) + "." + c(trim);
                } else {
                    str = String.valueOf(a10.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String f() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String g() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String h() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : b(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    private static Date a(String str) {
        try {
            return new SimpleDateFormat(TimeUtils.STARD_FROMAT).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] ^ bArr2[i10 % bArr2.length]) ^ (i10 & 255));
            }
        }
        return bArr;
    }

    private static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                stringBuffer.append(Integer.toHexString(b4 & 255));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
