package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Reflect;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class q {
    private static Map<String, Resources> aiH = new HashMap();
    private static final Object aiI = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.a(resources.getClass()).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
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
                    return a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.cg("android.content.res.HwResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
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
                    return a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.cg("android.content.res.MiuiResourcesImpl").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
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
                    return a.a(resources, assetManager);
                }
            } catch (Exception unused2) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }

        private static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.cg("android.content.res.MiuiResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
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
                    return a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.cg("android.content.res.NubiaResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
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
                    return a.a(resources, assetManager);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        private static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.cg("android.content.res.VivoResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).get();
            if (resources2 != null) {
                try {
                    Reflect.h(resources2).a("init", new Class[]{String.class}, context.getPackageName());
                } catch (Reflect.ReflectException e2) {
                    e2.printStackTrace();
                }
                try {
                    Reflect.h(resources2).b("mThemeValues", Reflect.h(resources).get("mThemeValues"));
                } catch (Reflect.ReflectException e10) {
                    e10.printStackTrace();
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
                Reflect.h(assetManager).a("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
            } else {
                Reflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
            }
        } catch (Throwable unused) {
            Reflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
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
        AssetManager assetManager = (AssetManager) Reflect.a((Class<?>) AssetManager.class).Ak().get();
        Reflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            Object obj = Reflect.h(applicationInfo).get("resourceDirs");
            if (obj != null && obj.getClass().isArray()) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    for (Object obj2 : objArr) {
                        if (obj2 instanceof String) {
                            a(assetManager, (String) obj2);
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
            Reflect.h(assetManager).a("addOverlayPath", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            Reflect.h(assetManager).a("addAssetPath", new Class[]{String.class}, str);
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
            return a.a(resources, assetManager);
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
