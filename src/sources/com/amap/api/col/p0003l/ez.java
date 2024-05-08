package com.amap.api.col.p0003l;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: ServiceUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ez {

    /* renamed from: b, reason: collision with root package name */
    private static AssetManager f5676b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Resources f5677c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Resources f5678d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f5679e = true;

    /* renamed from: f, reason: collision with root package name */
    private static Context f5680f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f5681g = "amap_resource";

    /* renamed from: h, reason: collision with root package name */
    private static String f5682h = "1_0_0";

    /* renamed from: j, reason: collision with root package name */
    private static String f5684j = ".jar";

    /* renamed from: k, reason: collision with root package name */
    private static String f5685k = f5681g + f5682h + f5684j;

    /* renamed from: i, reason: collision with root package name */
    private static String f5683i = ".png";

    /* renamed from: l, reason: collision with root package name */
    private static String f5686l = f5681g + f5682h + f5683i;

    /* renamed from: m, reason: collision with root package name */
    private static String f5687m = "";

    /* renamed from: n, reason: collision with root package name */
    private static String f5688n = f5687m + f5685k;

    /* renamed from: o, reason: collision with root package name */
    private static Resources.Theme f5689o = null;

    /* renamed from: p, reason: collision with root package name */
    private static Resources.Theme f5690p = null;

    /* renamed from: q, reason: collision with root package name */
    private static Field f5691q = null;

    /* renamed from: r, reason: collision with root package name */
    private static Field f5692r = null;

    /* renamed from: s, reason: collision with root package name */
    private static Activity f5693s = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f5675a = -1;

    /* compiled from: ServiceUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ez.f5682h);
            sb2.append(ez.f5684j);
            return str.startsWith(ez.f5681g) && !str.endsWith(sb2.toString());
        }
    }

    public static boolean a(Context context) {
        try {
            f5680f = context;
            File b4 = b(context);
            if (b4 != null) {
                f5687m = b4.getAbsolutePath() + "/";
            }
            f5688n = f5687m + f5685k;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!f5679e) {
            return true;
        }
        if (!c(context)) {
            return false;
        }
        AssetManager a10 = a(f5688n);
        f5676b = a10;
        f5677c = a(context, a10);
        return true;
    }

    private static void e() {
        File[] listFiles = new File(f5687m).listFiles(new a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }

    private static File b(Context context) {
        File filesDir;
        try {
            if (context == null) {
                if (context != null) {
                    context.getFilesDir();
                }
                return null;
            }
            try {
                if (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) {
                    filesDir = context.getExternalFilesDir("LBS");
                } else {
                    filesDir = context.getFilesDir();
                }
                if (filesDir == null) {
                    context.getFilesDir();
                }
                return filesDir;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 == 0) {
                    return context.getFilesDir();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    private static boolean c(Context context) {
        d(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(f5686l);
            if (b(inputStream)) {
                return true;
            }
            e();
            OutputStream a10 = a(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    gy.b(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            a10.close();
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                gy.b(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStream == null) {
                    return false;
                }
                try {
                    inputStream.close();
                    return false;
                } catch (IOException e10) {
                    e10.printStackTrace();
                    gy.b(e10, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    return false;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        gy.b(e11, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
            }
        }
    }

    private static void d(Context context) {
        f5687m = context.getFilesDir().getAbsolutePath();
        f5688n = f5687m + "/" + f5685k;
    }

    public static Resources a() {
        Resources resources = f5677c;
        return resources == null ? f5680f.getResources() : resources;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    private static boolean b(InputStream inputStream) throws IOException {
        File file = new File(f5688n);
        long length = file.length();
        int available = inputStream.available();
        if (!file.exists() || length != available) {
            return false;
        }
        inputStream.close();
        return true;
    }

    private static AssetManager a(String str) {
        Class<?> cls;
        AssetManager assetManager;
        AssetManager assetManager2 = null;
        try {
            cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Throwable th2) {
            th = th2;
            assetManager2 = assetManager;
            gy.b(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager2;
        }
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(f5687m, f5685k));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static View a(Context context, int i10) {
        XmlResourceParser xml = a().getXml(i10);
        View view = null;
        if (!f5679e) {
            return LayoutInflater.from(context).inflate(xml, (ViewGroup) null);
        }
        try {
            int i11 = f5675a;
            if (i11 == -1) {
                i11 = 0;
            }
            view = LayoutInflater.from(new ey(context, i11, ez.class.getClassLoader())).inflate(xml, (ViewGroup) null);
        } finally {
            try {
                return view;
            } finally {
            }
        }
        return view;
    }
}
