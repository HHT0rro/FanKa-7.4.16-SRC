package com.inno.innosdk.utils.t;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.inno.innosdk.a.f;
import com.inno.innosdk.utils.q;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Long> f35658a;

    /* compiled from: FileUtils.java */
    /* renamed from: com.inno.innosdk.utils.t.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class RunnableC0349a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f35659a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f35660b;

        public RunnableC0349a(File file, byte[] bArr) {
            this.f35659a = file;
            this.f35660b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            Throwable th;
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f35659a, false);
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                a.a(fileOutputStream2);
                throw th;
            }
            try {
                fileOutputStream.write(this.f35660b);
                a.a(fileOutputStream);
            } catch (IOException e10) {
                e = e10;
                fileOutputStream2 = fileOutputStream;
                try {
                    com.inno.innosdk.utils.u.a.a((Throwable) e);
                    a.a(fileOutputStream2);
                } catch (Throwable th3) {
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                    FileOutputStream fileOutputStream3 = fileOutputStream;
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    a.a(fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                FileOutputStream fileOutputStream32 = fileOutputStream;
                th = th;
                fileOutputStream2 = fileOutputStream32;
                a.a(fileOutputStream2);
                throw th;
            }
        }
    }

    /* compiled from: FileUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f35661a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f35662b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f35663c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f35664d;

        public b(Context context, String str, String[] strArr, String str2) {
            this.f35661a = context;
            this.f35662b = str;
            this.f35663c = strArr;
            this.f35664d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.a(this.f35661a, this.f35662b, this.f35663c, this.f35664d);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    /* compiled from: FileUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f35665a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f35666b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f35667c;

        public c(String str, Context context, String str2) {
            this.f35665a = str;
            this.f35666b = context;
            this.f35667c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35665a.equals("ncuid")) {
                if (q.b(this.f35666b, "inno_cuidSour", "").equals(this.f35667c)) {
                    return;
                }
                q.d(this.f35666b, "inno_cuidSour", this.f35667c);
            } else {
                if (!this.f35665a.equals("acid") || q.b(this.f35666b, "inno_acidSour", "").equals(this.f35667c)) {
                    return;
                }
                q.d(this.f35666b, "inno_acidSour", this.f35667c);
            }
        }
    }

    public static void a(Context context, String[] strArr, String str, String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr[0]);
            sb2.append(str2);
            q.c(context, sb2.toString(), str);
            for (String str3 : strArr) {
                try {
                    com.inno.innosdk.utils.t.b.a(str3, "." + str3 + "." + str2, str);
                } catch (Exception e2) {
                    com.inno.innosdk.utils.u.a.a((Throwable) e2);
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static boolean b(String str) {
        int length;
        if (TextUtils.isEmpty(str) || (length = str.length()) > 100 || length < 10 || str.contains("UUUUUUUUUUUUUUUUUU")) {
            return false;
        }
        int i10 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= length) {
                return true;
            }
            char charAt = str.charAt(i10);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && charAt != '-' && charAt != '_'))) {
                z10 = false;
            }
            if (!z10) {
                return false;
            }
            i10++;
        }
    }

    public static boolean c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return e(str);
        }
        return d(str);
    }

    public static boolean d(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        boolean z10 = true;
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                z10 = e(file2.getAbsolutePath());
                if (!z10) {
                    break;
                }
            } else {
                if (file2.isDirectory() && !(z10 = d(file2.getAbsolutePath()))) {
                    break;
                }
            }
        }
        if (z10) {
            return file.delete();
        }
        return false;
    }

    public static boolean e(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static void f(String str) {
        for (File file : new File(str).listFiles()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                String g3 = g(file.getName());
                com.inno.innosdk.utils.u.a.a((Object) ("FOLDER is " + ((Object) file) + " prefix is " + g3));
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isFile() && file2.getName().startsWith(g3)) {
                            e(file2.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    public static String g(String str) {
        return "." + q.b(str).substring(0, 5);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    public static void a(Process process) {
        if (process != null) {
            try {
                process.exitValue();
            } catch (IllegalThreadStateException unused) {
                process.destroy();
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[100];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 != read) {
                            byteArrayOutputStream2.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            a(byteArrayOutputStream2);
                            return byteArray;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(File file) {
        if (file == null || !file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    String str = new String(a((InputStream) fileInputStream2), "utf-8");
                    a((Closeable) fileInputStream2);
                    return str;
                } catch (Exception e2) {
                    e = e2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        a((Closeable) fileInputStream);
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return;
        }
        f.f35500a.execute(new RunnableC0349a(file, bArr));
    }

    public static void a(File file, String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            a(file, str.getBytes("utf-8"));
            return;
        }
        throw new IOException("file or bytes empty");
    }

    public static void a(String str, String str2) {
        Exception e2;
        Throwable th;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            byte[] bytes = str2.getBytes("utf-8");
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str), false);
                try {
                    fileOutputStream2.write(bytes);
                    a(fileOutputStream2);
                } catch (Exception e10) {
                    e2 = e10;
                    fileOutputStream = fileOutputStream2;
                    try {
                        com.inno.innosdk.utils.u.a.a((Throwable) e2);
                        a(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e2 = e11;
            } catch (Throwable th4) {
                th = th4;
                a(fileOutputStream);
                throw th;
            }
        } else {
            throw new IOException("file or bytes empty");
        }
    }

    public static void a(String str, Context context, String str2, String[] strArr, String str3) {
        f.f35500a.execute(new b(context, str2, strArr, str3));
    }

    public static void a(Context context, String str, String[] strArr, String str2) {
        Map<String, Long> map;
        try {
            try {
                a(context, strArr, str, str2);
                com.inno.innosdk.utils.t.b.b(str, str2);
                if (f35658a == null) {
                    f35658a = new HashMap(16);
                }
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
                map = f35658a;
                if (map == null) {
                    return;
                }
            }
            if (f35658a.get(str2) != null && System.currentTimeMillis() - f35658a.get(str2).longValue() < 30000) {
                Map<String, Long> map2 = f35658a;
                if (map2 != null) {
                    map2.remove(str2);
                    return;
                }
                return;
            }
            f35658a.put(str2, Long.valueOf(System.currentTimeMillis()));
            map = f35658a;
            if (map == null) {
                return;
            }
            map.remove(str2);
        } catch (Throwable th) {
            Map<String, Long> map3 = f35658a;
            if (map3 != null) {
                map3.remove(str2);
            }
            throw th;
        }
    }

    public static String a(String str, Context context, String[] strArr, String str2, String str3) {
        int i10;
        String str4 = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr[0]);
            sb2.append(str2);
            str4 = q.a(context, sb2.toString(), "");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (b(str4)) {
            a(context, str, "-1");
            return str4;
        }
        if (com.inno.innosdk.utils.t.b.f35668a) {
            for (String str5 : strArr) {
                try {
                    str4 = com.inno.innosdk.utils.t.b.a(str5, "." + str5 + "." + str2);
                } catch (Exception e2) {
                    com.inno.innosdk.utils.u.a.a((Throwable) e2);
                }
                if (b(str4)) {
                    a(context, str, "-2");
                    return str4;
                }
                continue;
            }
            File[] listFiles = Environment.getExternalStorageDirectory().listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        try {
                            str4 = a(new File(file.getAbsolutePath(), com.inno.innosdk.utils.t.b.a(file, str2)));
                            if (b(str4)) {
                                a(context, str, "-3");
                                return str4;
                            }
                            continue;
                        } catch (Exception e10) {
                            com.inno.innosdk.utils.u.a.a((Throwable) e10);
                        }
                    }
                }
            }
        }
        str4 = q.a(context, str3, "");
        if (b(str4)) {
            a(context, str, "-4");
            return str4;
        }
        if (com.inno.innosdk.utils.t.b.f35668a) {
            str4 = a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + str3, str3));
            if (b(str4)) {
                a(context, str, "-5");
                return str4;
            }
        }
        return str4;
    }

    public static void a(Context context, String str, String str2) {
        f.f35500a.execute(new c(str, context, str2));
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        if (length == 24) {
            return str.startsWith("R");
        }
        if (length == 32) {
            return str.startsWith(ExifInterface.GPS_DIRECTION_TRUE);
        }
        if (length != 34) {
            return false;
        }
        return str.startsWith("a");
    }

    public static void a(Context context) {
        try {
            if (com.inno.innosdk.utils.t.b.f35668a) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                f(absolutePath);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                String str = File.separator;
                sb2.append(str);
                sb2.append("com.jifen.ac");
                c(sb2.toString());
                c(absolutePath + str + "com.jifen.op");
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(context.getFilesDir().getAbsolutePath());
            String str2 = File.separator;
            sb3.append(str2);
            sb3.append("inno");
            c(sb3.toString());
            c(context.getFilesDir().getParent() + str2 + "shared_prefs");
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
        }
    }
}
