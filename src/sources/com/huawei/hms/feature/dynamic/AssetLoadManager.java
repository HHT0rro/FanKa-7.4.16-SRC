package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AssetLoadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29784a = "AssetLoadManager";

    /* renamed from: b, reason: collision with root package name */
    public static final String f29785b = "dynamic_modules";

    /* renamed from: c, reason: collision with root package name */
    public static final String f29786c = ".apk";

    /* renamed from: d, reason: collision with root package name */
    public static final String f29787d = "com.huawei.hms.feature.dynamic.descriptors.";

    /* renamed from: e, reason: collision with root package name */
    public static final String f29788e = ".AssetModuleDescriptor";

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f29784a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            return context.getClassLoader().loadClass(f29787d + str + f29788e).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f29784a, "Cannot get the class of module descriptor for " + str);
            return 0;
        } catch (Exception e2) {
            Logger.w(f29784a, "Get local asset module info failed.", e2);
            return 0;
        }
    }

    public static Bundle a(Context context, File file, String str) {
        String[] list = file.list();
        if (list == null || list.length == 0) {
            Logger.w(f29784a, "No version in module path.");
            return new Bundle();
        }
        int i10 = 0;
        for (String str2 : list) {
            i10 = Math.max(Integer.parseInt(str2), i10);
        }
        if (i10 == 0) {
            Logger.w(f29784a, "Cannot get module version path.");
            return new Bundle();
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            ModuleCopy.clearLowVersionModule(i10, canonicalPath, list, f29784a);
            if (a(context, str) > i10) {
                Logger.i(f29784a, "There is a higher loader version in assets.");
                return new Bundle();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(canonicalPath);
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(i10);
            sb2.append(str3);
            sb2.append(str);
            sb2.append(".apk");
            String sb3 = sb2.toString();
            if (!new File(sb3).exists()) {
                Logger.w(f29784a, "Cannot find module apk in asset decompressed path.");
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            bundle.putString("module_path", sb3);
            bundle.putInt(b.f29872m, i10);
            Logger.i(f29784a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i10 + ", ModulePath:" + sb3);
            return bundle;
        } catch (IOException e2) {
            Logger.w(f29784a, "request modulePath error: " + e2.getMessage());
            return new Bundle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.Closeable, java.io.InputStream] */
    public static String a(Context context, String str, int i10, String str2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        String str3;
        String str4;
        Closeable closeable2 = null;
        try {
            try {
                AssetManager assets = context.getAssets();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dynamic_modules");
                str3 = File.separator;
                sb2.append(str3);
                sb2.append(str);
                sb2.append(str3);
                sb2.append((String) str2);
                str2 = assets.open(sb2.toString());
            } catch (Exception e2) {
                e = e2;
                str2 = 0;
            } catch (Throwable th) {
                th = th;
                str2 = 0;
            }
            try {
                bufferedInputStream = new BufferedInputStream(str2);
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = null;
                bufferedInputStream = null;
                Logger.w(f29784a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                closeable = str2;
                ModuleCopy.closeQuietly(closeable);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(closeable2);
                ModuleCopy.closeQuietly(str2);
                throw th;
            }
            try {
                str4 = ModuleCopy.getProtectedPath(context) + str3 + "dynamic_modules" + str3 + str + str3 + ((int) i10);
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(closeable2);
                ModuleCopy.closeQuietly(str2);
                throw th;
            }
            if (!new File(str4).exists() && !new File(str4).mkdirs()) {
                Logger.w(f29784a, "mkdirs local loaderPath failed.");
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(null);
                closeable = str2;
                ModuleCopy.closeQuietly(closeable);
                return null;
            }
            String str5 = str4 + str3 + str + ".apk";
            fileOutputStream = new FileOutputStream(str5);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        Logger.i(f29784a, "Decompress module:" + str + " from assets success.");
                        ModuleCopy.closeQuietly(bufferedInputStream);
                        ModuleCopy.closeQuietly(fileOutputStream);
                        ModuleCopy.closeQuietly(str2);
                        return str5;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e12) {
                e = e12;
                Logger.w(f29784a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                closeable = str2;
                ModuleCopy.closeQuietly(closeable);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable2 = i10;
        }
    }

    public static Bundle b(Context context, String str) {
        try {
            String[] list = context.getAssets().list("dynamic_modules" + File.separator + str);
            if (list != null && list.length != 0) {
                String str2 = list[0];
                int a10 = a(context, str);
                String a11 = a(context, str, a10, str2);
                if (!TextUtils.isEmpty(a11) && new File(a11).exists()) {
                    if (ExtractNativeUtils.a(context, a11) && ExtractNativeUtils.a(new File(a11), ModuleCopy.trimLastSection(a11)) != 0) {
                        Logger.w(f29784a, "Extract native to current dir failed.");
                        return new Bundle();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("module_name", str);
                    bundle.putString("module_path", a11);
                    bundle.putInt(b.f29872m, a10);
                    Logger.i(f29784a, "Get dynamic module info from asset success: ModuleName:" + str + ", ModuleVersion:" + a10 + ", ModulePath:" + a11);
                    return bundle;
                }
                Logger.w(f29784a, "Decompress module from assets failed.");
                return new Bundle();
            }
            Logger.w(f29784a, "No module apk in asset path.");
            return new Bundle();
        } catch (Exception e2) {
            Logger.i(f29784a, "getModuleFromAsset failed.", e2);
            return new Bundle();
        }
    }

    public static Bundle getAssetModuleInfo(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f29784a, "The context or moduleName is null.");
            return new Bundle();
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ModuleCopy.getProtectedPath(context));
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("dynamic_modules");
            sb2.append(str2);
            sb2.append(str);
            File file = new File(sb2.toString());
            if (file.exists()) {
                Bundle a10 = a(context, file, str);
                if (a10.getInt(b.f29872m) > 0) {
                    Logger.i(f29784a, "Successfully get module info from decompressed asset path.");
                    return a10;
                }
            }
            Bundle b4 = b(context, str);
            if (b4.getInt(b.f29872m) > 0) {
                Logger.i(f29784a, "Successfully get module info from asset.");
                return b4;
            }
        } catch (Exception e2) {
            Logger.i(f29784a, "getDataModuleInfo failed.", e2);
        }
        return new Bundle();
    }
}
