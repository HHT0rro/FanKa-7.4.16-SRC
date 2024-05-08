package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class o implements q {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29458a = "DecompressedLdStrategy";

    /* renamed from: b, reason: collision with root package name */
    private static final String f29459b = "loader";

    /* renamed from: c, reason: collision with root package name */
    private static final String f29460c = "com.huawei.hms.kit.type";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29461d = "armeabi_type";

    private static t a(File file, String str) {
        String[] list = file.list();
        t tVar = new t();
        if (list == null || list.length == 0) {
            aa.c(f29458a, "No version in module path.");
            return tVar;
        }
        int i10 = 0;
        for (String str2 : list) {
            if (Integer.parseInt(str2) > i10) {
                i10 = Integer.parseInt(str2);
            }
        }
        if (i10 == 0) {
            aa.c(f29458a, "Cannot get module version path.");
            return tVar;
        }
        r.a(i10, file.getAbsolutePath(), list, f29458a);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getAbsolutePath());
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(i10);
        sb2.append(str3);
        sb2.append(str);
        sb2.append(".apk");
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            aa.c(f29458a, "Cannot find module apk int local path.");
            return tVar;
        }
        String absolutePath = file2.getAbsolutePath();
        tVar.f29482a = str;
        tVar.f29483b = absolutePath;
        tVar.f29485d = i10;
        aa.b(f29458a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i10);
        return tVar;
    }

    private static String a(Context context, String str, Bundle bundle) {
        String str2;
        ApplicationInfo applicationInfo;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 128);
        String str3 = null;
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            str2 = "The packageInfo is null.";
        } else {
            Bundle bundle2 = applicationInfo.metaData;
            if (bundle2 == null) {
                str2 = "Get meta-data failed.";
            } else {
                for (String str4 : bundle2.keySet()) {
                    if (str4.startsWith(f29460c)) {
                        str3 = bundle2.getString(str4);
                    }
                    if (str4.startsWith(f29461d)) {
                        int i10 = bundle2.getInt(str4);
                        aa.b(f29458a, "The module defined the armeabiType:".concat(String.valueOf(i10)));
                        bundle.putInt("armeabiType", i10);
                    }
                }
                str2 = "The moduleType is:".concat(String.valueOf(str3));
            }
        }
        aa.c(f29458a, str2);
        return str3;
    }

    private static Context b(Context context, t tVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, tVar.f29486e));
        if (asInterface == null) {
            aa.c(f29458a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", tVar.f29482a);
        bundle.putString("loader_path", tVar.f29486e);
        bundle.putInt("module_version", tVar.f29485d);
        bundle.putString("loader_version_type", tVar.f29487f);
        return r.a(context, tVar.f29482a, bundle, asInterface);
    }

    public static t b(Context context, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(y.a(context));
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("dynamic_modules");
        sb2.append(str2);
        sb2.append(str);
        File file = new File(sb2.toString());
        return file.exists() ? a(file, str) : new t();
    }

    private static t c(Context context, String str) {
        t tVar = new t();
        if (context == null || TextUtils.isEmpty(str)) {
            aa.c(f29458a, "The context or moduleName is null.");
            return tVar;
        }
        try {
            tVar = b(context, str);
            if (tVar.f29485d > 0) {
                aa.b(f29458a, "Successfully get module info from decompressed asset path.");
                p.a(context, str, tVar.f29485d);
                return tVar;
            }
        } catch (Exception e2) {
            aa.b(f29458a, "getDataModuleInfo failed." + e2.getClass().getSimpleName());
        }
        return tVar;
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final Context a(Context context, t tVar) {
        String str;
        if (tVar == null) {
            str = "moduleInfo is null.";
        } else {
            String str2 = tVar.f29483b;
            if (TextUtils.isEmpty(str2)) {
                str = "modulePath is invalid.";
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", str2);
                bundle.putString("loader_version_type", tVar.f29487f);
                bundle.putString("module_name", tVar.f29482a);
                aa.b(f29458a, "loaderVersionType is : " + tVar.f29487f);
                try {
                    if (!TextUtils.equals(a(context, str2, bundle), f29459b)) {
                        com.huawei.hms.ads.dynamicloader.h.a(context);
                        return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
                    }
                    aa.b(f29458a, "The module is a loader, use it to load first.");
                    tVar.f29486e = str2;
                    IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(r.a(context, str2));
                    if (asInterface == null) {
                        aa.c(f29458a, "Get iDynamicLoader failed: null.");
                        return null;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("module_name", tVar.f29482a);
                    bundle2.putString("loader_path", tVar.f29486e);
                    bundle2.putInt("module_version", tVar.f29485d);
                    bundle2.putString("loader_version_type", tVar.f29487f);
                    return r.a(context, tVar.f29482a, bundle2, asInterface);
                } catch (Exception e2) {
                    str = "Get local assets module context failed, " + e2.getClass().getSimpleName();
                }
            }
        }
        aa.c(f29458a, str);
        return null;
    }

    @Override // com.huawei.hms.ads.uiengineloader.q
    public final t a(Context context, String str) {
        return c(context, str);
    }
}
