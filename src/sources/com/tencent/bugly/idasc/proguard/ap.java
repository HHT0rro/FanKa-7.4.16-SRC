package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.huawei.openalliance.ad.constant.bg;
import com.tencent.bugly.idasc.crashreport.common.info.PlugInBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f39602a;

    public static Context a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static BufferedReader a(File file) {
        if (file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                al.a(th);
            }
        }
        return null;
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            return creator.createFromParcel(obtain);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                obtain.recycle();
                return null;
            } finally {
                obtain.recycle();
            }
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(int i10, String str) {
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        Process process = null;
        StringBuilder sb2 = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
                sb2.append("\n");
                if (i10 > 0 && sb2.length() > i10) {
                    sb2.delete(0, sb2.length() - i10);
                }
            }
            String sb3 = sb2.toString();
            try {
                process.getOutputStream().close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                process.getInputStream().close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                process.getErrorStream().close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return sb3;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                sb2.append("\n[error:");
                sb2.append(th.toString());
                sb2.append("]");
                return sb2.toString();
            } finally {
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
            }
        }
    }

    public static String a(long j10) {
        try {
            return new SimpleDateFormat(TimeUtils.STARD_FROMAT, Locale.US).format(new Date(j10));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(File file, int i10, boolean z10) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                    sb2.append("\n");
                    if (i10 > 0 && sb2.length() > i10) {
                        if (z10) {
                            sb2.delete(i10, sb2.length());
                            break;
                        }
                        sb2.delete(0, sb2.length() - i10);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        al.a(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                al.a(e2);
                            }
                        }
                    }
                }
            }
            String sb3 = sb2.toString();
            try {
                bufferedReader.close();
            } catch (Exception e10) {
                al.a(e10);
            }
            return sb3;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static String a(String str) {
        if (str.trim().equals("")) {
            return "";
        }
        try {
            if (f39602a == null) {
                f39602a = new HashMap();
            }
            if (f39602a.containsKey(str)) {
                return f39602a.get(str);
            }
            String systemProperty = NativeCrashHandler.getInstance().getSystemProperty(str);
            if (!TextUtils.isEmpty(systemProperty) && !systemProperty.equals(bg.b.S)) {
                f39602a.put(str, systemProperty);
            }
            return systemProperty;
        } catch (Throwable th) {
            al.b(th);
            return bg.b.S;
        }
    }

    public static String a(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb2.append(stackTraceElement.toString());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (al.a(th2)) {
                return bg.b.S;
            }
            th2.printStackTrace();
            return bg.b.S;
        }
    }

    public static String a(Date date) {
        try {
            return new SimpleDateFormat(TimeUtils.STARD_FROMAT, Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            al.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    private static Map<String, String> a(int i10) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        Thread.currentThread().getId();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            int i11 = 0;
            sb2.setLength(0);
            if (entry.getValue() != null && entry.getValue().length != 0) {
                StackTraceElement[] value = entry.getValue();
                int length = value.length;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = value[i11];
                    if (i10 > 0 && sb2.length() >= i10) {
                        sb2.append("\n[Stack over limit size :" + i10 + " , has been cut!]");
                        break;
                    }
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                    i11++;
                }
                hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb2.toString());
            }
        }
        return hashMap;
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i10 = 0; i10 < intValue; i10++) {
            arrayList.add(readBundle.getString("pluginKey".concat(String.valueOf(i10))));
        }
        for (int i11 = 0; i11 < intValue; i11++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i11 + "plugInId"), readBundle.getString("pluginVal" + i11 + "plugInVersion"), readBundle.getString("pluginVal" + i11 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                hashMap.put(arrayList.get(i12), PlugInBean.class.cast(arrayList2.get(i12)));
            }
        } else {
            al.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static Map<String, String> a(boolean z10, int i10) {
        if (z10) {
            Map<String, String> a10 = a(i10);
            return a10 == null ? new HashMap() : a10;
        }
        al.c("get all thread stack not enable", new Object[0]);
        return new HashMap();
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            bundle.putString("pluginKey".concat(String.valueOf(i10)), (String) arrayList.get(i10));
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            bundle.putString("pluginVal" + i11 + "plugInId", ((PlugInBean) arrayList2.get(i11)).f39382a);
            bundle.putString("pluginVal" + i11 + "plugInUUID", ((PlugInBean) arrayList2.get(i11)).f39384c);
            bundle.putString("pluginVal" + i11 + "plugInVersion", ((PlugInBean) arrayList2.get(i11)).f39383b);
        }
        parcel.writeBundle(bundle);
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static boolean a(Context context, String str) {
        al.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(((Object) context.getFilesDir()) + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < 10000) {
                    return false;
                }
                al.c("[Util] Lock file (%s) is expired, unlock it.", str);
                b(context, str);
            }
            if (file.createNewFile()) {
                al.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            al.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    public static boolean a(File file, File file2) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        al.c("rqdp{  ZF start}", new Object[0]);
        if (!b(file, file2)) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            } catch (Throwable th) {
                th = th;
                zipOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            byte[] bArr = new byte[Math.max(5000, 1000)];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.flush();
            zipOutputStream.closeEntry();
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                zipOutputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            al.c("rqdp{  ZF end}", new Object[0]);
            return true;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                al.c("rqdp{  ZF end}", new Object[0]);
                return false;
            } catch (Throwable th4) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                al.c("rqdp{  ZF end}", new Object[0]);
                throw th4;
            }
        }
    }

    public static boolean a(Runnable runnable) {
        ak a10 = ak.a();
        if (a10 != null) {
            return a10.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static byte[] a(String str, String str2) {
        ZipOutputStream zipOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (str == null || str.length() == 0) {
            return null;
        }
        al.c("rqdp{  ZF start}", new Object[0]);
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                zipOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            al.c("rqdp{  ZF end}", new Object[0]);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                al.c("rqdp{  ZF end}", new Object[0]);
                return null;
            } catch (Throwable th3) {
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                al.c("rqdp{  ZF end}", new Object[0]);
                throw th3;
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        al.c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return bh.a().a(bArr);
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset();
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static BufferedReader b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return a(file);
            }
            return null;
        } catch (NullPointerException e2) {
            al.a(e2);
            return null;
        }
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            al.e("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                hashMap.put(stringArrayList.get(i10), stringArrayList2.get(i10));
            }
        }
        return hashMap;
    }

    public static void b(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        Bundle bundle;
        if (map == null || map.size() <= 0) {
            bundle = null;
        } else {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
        }
        parcel.writeBundle(bundle);
    }

    public static boolean b(Context context, String str) {
        al.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(((Object) context.getFilesDir()) + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            al.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static boolean b(File file, File file2) {
        if (file == null || file2 == null || file.equals(file2)) {
            al.d("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        }
        if (!file.exists() || !file.canRead()) {
            al.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        try {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return file2.exists() && file2.canWrite();
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        al.c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return bh.a().b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                al.d(th.getMessage(), new Object[0]);
                return null;
            }
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                String hexString = Integer.toHexString(b4 & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static void c(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static void c(String str, String str2) {
        if (aa.b() == null || aa.b().O == null) {
            return;
        }
        aa.b().O.edit().putString(str, str2).apply();
    }

    public static byte[] c(long j10) {
        try {
            return String.valueOf(j10).getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static long d(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String d(String str, String str2) {
        return (aa.b() == null || aa.b().O == null) ? "" : aa.b().O.getString(str, str2);
    }

    public static boolean d(String str) {
        if (b(str)) {
            return false;
        }
        if (str.length() > 255) {
            al.a("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        al.a("URL(%s) is not start with \"http\".", str);
        return false;
    }
}
