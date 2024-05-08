package com.kwad.library.b.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static Map<String, Resources> aiH = new HashMap();
    private static final Object aiI = new Object();

    /* renamed from: com.kwad.library.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0504a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) s.a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0504a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.h("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0504a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.h("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return g(resources, assetManager);
                } catch (Exception unused) {
                    return C0504a.a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.h("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0504a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.h("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class f {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    return C0504a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.h("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                try {
                    s.f(resources2, "init", context.getPackageName());
                } catch (Exception e2) {
                    com.kwad.library.solder.lib.a.e("ResourcesManager", "createVivoResources init failed", e2);
                }
                try {
                    s.b(resources2, "mThemeValues", s.f(resources, "mThemeValues"));
                } catch (Exception e10) {
                    com.kwad.library.solder.lib.a.e("ResourcesManager", "createVivoResources set mThemeValues failed", e10);
                }
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (aiI) {
            resources2 = aiH.get(str);
            if (resources2 == null) {
                resources2 = b(context, resources, str);
                if (resources2 != null) {
                    aiH.put(str, resources);
                } else {
                    throw new RuntimeException("Can not createResources for " + str);
                }
            }
        }
        return resources2;
    }

    private static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                s.f(assetManager, "addAssetPathAsSharedLibrary", str);
            } else {
                s.f(assetManager, "addAssetPath", str);
            }
        } catch (Throwable unused) {
            s.f(assetManager, "addAssetPath", str);
        }
        return 0;
    }

    private static boolean c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    private static boolean d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    private static boolean e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    private static boolean f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }

    private static Resources b(Context context, Resources resources, String str) {
        AssetManager assetManager = (AssetManager) s.i(AssetManager.class);
        s.f(assetManager, "addAssetPath", str);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            Object field = s.getField(applicationInfo, "resourceDirs");
            if (field != null && field.getClass().isArray()) {
                Object[] objArr = (Object[]) field;
                if (objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (obj instanceof String) {
                            a(assetManager, (String) obj);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            String[] strArr = applicationInfo.sharedLibraryFiles;
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str2 != null && str2.endsWith(".apk")) {
                        b(assetManager, str2);
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private static void a(AssetManager assetManager, String str) {
        try {
            s.f(assetManager, "addOverlayPath", str);
        } catch (Throwable unused) {
            s.f(assetManager, "addAssetPath", str);
        }
    }

    private static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        if (a(resources)) {
            return d.a(resources, assetManager);
        }
        if (b(resources)) {
            return c.a(resources, assetManager);
        }
        if (e(resources)) {
            return b.a(resources, assetManager);
        }
        if (c(resources)) {
            return f.a(context, resources, assetManager);
        }
        if (d(resources)) {
            return e.a(resources, assetManager);
        }
        if (f(resources)) {
            return C0504a.a(resources, assetManager);
        }
        return new Resources(assetManager, displayMetrics, configuration);
    }

    private static boolean b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }

    private static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }
}
