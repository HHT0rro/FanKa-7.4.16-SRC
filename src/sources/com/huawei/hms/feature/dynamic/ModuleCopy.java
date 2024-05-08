package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ModuleCopy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29840a = "ModuleCopy";

    /* renamed from: b, reason: collision with root package name */
    public static final int f29841b = 2048;

    /* renamed from: c, reason: collision with root package name */
    public static final int f29842c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f29843d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final String f29844e = "module_uri_path";

    /* renamed from: f, reason: collision with root package name */
    public static final String f29845f = "loader_uri_path";

    /* renamed from: g, reason: collision with root package name */
    public static final String f29846g = "dynamic_modules";

    /* renamed from: h, reason: collision with root package name */
    public static final String f29847h = ".apk";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29848a;

        public a(String str) {
            this.f29848a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ModuleCopy.c(this.f29848a);
            } catch (SecurityException unused) {
                Logger.w(ModuleCopy.f29840a, "Delete file failed: SecurityException.");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f29849a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29850b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f29851c;

        public b(String[] strArr, int i10, String str) {
            this.f29849a = strArr;
            this.f29850b = i10;
            this.f29851c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f29849a) {
                if (Integer.parseInt(str) < this.f29850b) {
                    Logger.i(ModuleCopy.f29840a, "Delete low version:" + this.f29850b + " in modulePath.");
                    ModuleCopy.c(this.f29851c + File.separator + str);
                }
            }
        }
    }

    public static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            Logger.i(f29840a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i10 = 0;
        for (String str : strArr) {
            i10 = Math.max(Integer.parseInt(str), i10);
        }
        return i10;
    }

    public static String a(Context context, Bundle bundle, int i10, Uri uri) {
        String str;
        String string;
        String valueOf;
        StringBuilder sb2;
        String[] list;
        int a10;
        if (i10 == 0) {
            str = "module_name";
            string = bundle.getString("module_name");
            valueOf = String.valueOf(bundle.getInt("module_version"));
            sb2 = new StringBuilder();
        } else {
            str = "loader_name";
            string = bundle.getString("loader_name");
            valueOf = String.valueOf(bundle.getInt("loader_version"));
            sb2 = new StringBuilder();
        }
        sb2.append(bundle.getString(str));
        sb2.append(".apk");
        String sb3 = sb2.toString();
        try {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(getProtectedPath(context));
            String str2 = File.separator;
            sb4.append(str2);
            sb4.append("dynamic_modules");
            sb4.append(str2);
            sb4.append(string);
            String sb5 = sb4.toString();
            String str3 = sb5 + str2 + valueOf;
            String str4 = str3 + str2 + sb3;
            if (new File(sb5).exists() && (a10 = a((list = new File(sb5).list()))) >= Integer.parseInt(valueOf)) {
                clearLowVersionModule(a10, sb5, list, f29840a);
                return sb5 + str2 + a10 + str2 + sb3;
            }
            return a(context, str3, uri, str4);
        } catch (IOException e2) {
            Logger.w(f29840a, "request modulePath error: " + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, String str, Uri uri, String str2) {
        if (!makeDirectory(str)) {
            Logger.e(f29840a, "makeDirectory return false");
            return null;
        }
        a(context, uri, str2);
        if (com.huawei.hms.feature.dynamic.f.d.b(context, str2)) {
            return str2;
        }
        Logger.w(f29840a, "The coped module apk is invalid.");
        b(str2);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void a(Context context, Uri uri, String str) {
        IOException e2;
        FileNotFoundException e10;
        StringBuilder sb2;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                context = context.getContentResolver().openInputStream(uri);
                try {
                    if (context == 0) {
                        Logger.w(f29840a, "Get input stream failed: null.");
                        closeQuietly(context);
                        closeQuietly(null);
                        return;
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = context.read(bArr);
                            if (read == -1) {
                                closeQuietly(context);
                                closeQuietly(bufferedOutputStream2);
                                return;
                            }
                            bufferedOutputStream2.write(bArr, 0, read);
                        }
                    } catch (FileNotFoundException e11) {
                        bufferedOutputStream = bufferedOutputStream2;
                        e10 = e11;
                        sb2 = new StringBuilder();
                        sb2.append("FileNotFoundException:");
                        sb2.append(e10.getMessage());
                        context = context;
                        Logger.e(f29840a, sb2.toString());
                        closeQuietly(context);
                        closeQuietly(bufferedOutputStream);
                    } catch (IOException e12) {
                        bufferedOutputStream = bufferedOutputStream2;
                        e2 = e12;
                        sb2 = new StringBuilder();
                        sb2.append("IOException ");
                        sb2.append(e2.getMessage());
                        context = context;
                        Logger.e(f29840a, sb2.toString());
                        closeQuietly(context);
                        closeQuietly(bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        closeQuietly(context);
                        closeQuietly(bufferedOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e13) {
                    e10 = e13;
                } catch (IOException e14) {
                    e2 = e14;
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    closeQuietly(context);
                    closeQuietly(bufferedOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e15) {
                e10 = e15;
                context = 0;
            } catch (IOException e16) {
                e2 = e16;
                context = 0;
            } catch (Throwable th3) {
                th = th3;
                context = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void a(Context context, Bundle bundle, int i10) {
        String string = bundle.getString(i10 == 0 ? "module_uri_path" : f29845f);
        Logger.i(f29840a, "path:" + string);
        String a10 = a(context, bundle, i10, Uri.parse(string));
        if (TextUtils.isEmpty(a10)) {
            Logger.w(f29840a, "checkModulePath failed: null.");
        } else {
            bundle.putString(i10 == 0 ? "module_path" : "loader_path", a10);
        }
    }

    public static boolean a(Bundle bundle) {
        return TextUtils.equals(bundle.getString("module_path"), bundle.getString("loader_path"));
    }

    public static void b(String str) {
        c.a(1, "DeleteFile").execute(new a(str));
    }

    public static boolean c(String str) {
        boolean z10;
        File file = new File(str);
        if (!file.isDirectory() || file.list() == null) {
            z10 = true;
        } else {
            z10 = true;
            for (String str2 : file.list()) {
                if (z10) {
                    if (c(str + File.separator + str2)) {
                        z10 = true;
                    }
                }
                z10 = false;
            }
        }
        return z10 && file.delete();
    }

    public static void clearLowVersionModule(int i10, String str, String[] strArr, String str2) {
        c.a(1, str2).execute(new b(strArr, i10, str));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.e(f29840a, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void copyModule(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            Logger.e(f29840a, "The context or module info bundle is null.");
            return;
        }
        boolean a10 = a(bundle);
        a(context, bundle, 0);
        if (a10) {
            bundle.putString("loader_path", bundle.getString("module_path"));
        } else {
            a(context, bundle, 1);
        }
    }

    public static String getProtectedPath(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getDataDir().getCanonicalPath();
        }
        String canonicalPath = context.getFilesDir().getCanonicalPath();
        int lastIndexOf = canonicalPath.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? canonicalPath : canonicalPath.substring(0, lastIndexOf);
    }

    public static boolean isLocalModuleFile(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f29840a, "context or filePath is null.");
            return false;
        }
        try {
            return new File(str).getCanonicalPath().startsWith(getProtectedPath(context) + File.separator + "dynamic_modules");
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean makeDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e2) {
            Logger.e(f29840a, "makeDirectory Exception: " + e2.getMessage());
            return false;
        }
    }

    public static String trimLastSection(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }
}
