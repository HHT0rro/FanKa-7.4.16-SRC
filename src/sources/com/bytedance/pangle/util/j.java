package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ArrayList<String> f10998a;

    /* renamed from: b, reason: collision with root package name */
    private static String f10999b;

    public static List<String> a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e2);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static String b(AssetManager assetManager) {
        List<String> a10 = a(assetManager);
        StringBuilder sb2 = new StringBuilder("[");
        if (a10.size() > 0) {
            Iterator<String> iterator2 = a10.iterator2();
            while (iterator2.hasNext()) {
                sb2.append(iterator2.next());
                sb2.append(" , ");
            }
            sb2.delete(sb2.lastIndexOf(" , "), sb2.length());
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i10 = 0; i10 < intValue; i10++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i10 + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static synchronized List<String> b() {
        ArrayList<String> arrayList;
        synchronized (j.class) {
            if (f10998a == null) {
                synchronized (j.class) {
                    if (f10998a == null) {
                        f10998a = new ArrayList<>();
                        boolean z10 = false;
                        if (i.c()) {
                            try {
                                Resources resources = Zeus.getAppApplication().getResources();
                                f10998a.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", Attributes.TextOverflow.STRING, "android")), 0).getApplicationInfo().sourceDir);
                            } catch (Exception e2) {
                                ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e2);
                            }
                        } else if (i.h()) {
                            try {
                                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                                int i10 = Build.VERSION.SDK_INT;
                                if (i10 >= 29 || (i10 == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                                    z10 = true;
                                }
                                if (z10) {
                                    Collections.addAll(f10998a, a(((Context) invokeStaticMethod).getApplicationInfo()));
                                } else {
                                    f10998a.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                }
                            } catch (Exception e10) {
                                ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e10);
                            }
                        }
                    }
                }
            }
            arrayList = f10998a;
        }
        return arrayList;
    }

    public static boolean a(AssetManager assetManager, String str) {
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i10 = 0;
                while (i10 < intValue) {
                    i10++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i10)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    @RequiresApi(api = 21)
    private static String[] a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.b.b.a.a((Class<?>) ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i10 = 0; i10 < 3; i10++) {
            String[] strArr3 = strArr2[i10];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
