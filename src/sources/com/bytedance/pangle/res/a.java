package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import com.huawei.quickcard.base.Attributes;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f10893a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, Integer> f10894b;

    static {
        List<String> a10 = j.a();
        if (a10 == null || a10.size() <= 0) {
            return;
        }
        Iterator<String> iterator2 = a10.iterator2();
        while (iterator2.hasNext()) {
            f10893a.put(iterator2.next(), 0);
        }
    }

    public a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.f10894b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private static AssetManager b(AssetManager assetManager, String str, boolean z10) {
        int intValue;
        String str2 = "addAssetPath";
        String str3 = z10 ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 >= 30 || (i10 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) && !z10 && str.startsWith("/product/overlay/")) {
            str3 = "addOverlayPath";
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
        if (accessibleMethod == null && z10) {
            accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", String.class);
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
        } else {
            str2 = str3;
        }
        if (accessibleMethod != null) {
            int i11 = 3;
            while (true) {
                int i12 = i11 - 1;
                if (i11 < 0) {
                    break;
                }
                try {
                    intValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                } catch (Exception e2) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z10 + ", methodName = " + str2, e2);
                }
                if (intValue != 0) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                    break;
                }
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + intValue + " " + str);
                i11 = i12;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z10 + " methodName:" + str2);
        }
        return assetManager;
    }

    private static AssetManager c(AssetManager assetManager, String str, boolean z10) {
        int i10;
        int i11;
        int i12 = 3;
        Throwable th = null;
        int i13 = 3;
        loop0: while (true) {
            int i14 = i13 - 1;
            if (i13 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    int i15 = 0;
                    i10 = 0;
                    while (true) {
                        i11 = 1;
                        if (i15 >= i12) {
                            break loop0;
                        }
                        try {
                            if (i.c()) {
                                i10 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else {
                                int i16 = Build.VERSION.SDK_INT;
                                if (i16 >= 24 && i16 <= 25) {
                                    i10 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z10)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                            }
                            if (i10 != 0) {
                                break loop0;
                            }
                            i15++;
                        } finally {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i13 = i14;
                i12 = 3;
            }
        }
        if (i10 == 0) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i10 + " " + str);
        } else {
            Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
            int length = readField != null ? Array.getLength(readField) : 0;
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
            int i17 = 0;
            while (i17 < intValue) {
                if (i17 < length) {
                    Array.set(newInstance, i17, Array.get(readField, i17));
                } else {
                    Object[] objArr = new Object[i11];
                    objArr[0] = Integer.valueOf(i17);
                    Class[] clsArr = new Class[i11];
                    clsArr[0] = Integer.TYPE;
                    Array.set(newInstance, i17, MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", objArr, clsArr)).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                }
                i17++;
                i11 = 1;
            }
            FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z10) {
        AssetManager a10;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (i.a()) {
            if (i.e()) {
                a10 = c(assetManager, str, z10);
                if (!j.a(a10, str)) {
                    a10 = b(assetManager, str, z10);
                }
            } else {
                a10 = b(assetManager, str, z10);
            }
        } else {
            a10 = a(assetManager, str);
        }
        synchronized (this.f10894b) {
            this.f10894b.put(str, 0);
        }
        return a10;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> a10 = j.a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : a10) {
            if (!f10893a.containsKey(str2) && !this.f10894b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.f10894b) {
                for (Map.Entry<String, Integer> entry : this.f10894b.entrySet()) {
                    if (!f10893a.containsKey(entry.getKey())) {
                        sb2.append(entry.getKey());
                        b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb2.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + f10893a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb2.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb2.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            if (i.d() && !sb2.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", Attributes.TextOverflow.STRING, "android")), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e2);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e10) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e10);
            b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e11) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e11);
        }
        return assetManager;
    }
}
