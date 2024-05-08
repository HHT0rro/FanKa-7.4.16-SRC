package zc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.wangmai.appsdkdex.WMAdSdk;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.utils.ContextContainer;
import com.wangmai.common.utils.DebugLog;
import com.wangmai.common.utils.WMResources;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: AdLoaderFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static IAdLoader f55050b;

    /* renamed from: a, reason: collision with root package name */
    public static final String f55049a = b.a("BeMpbefsGbdupsz");

    /* renamed from: c, reason: collision with root package name */
    public static CountDownLatch f55051c = new CountDownLatch(1);

    public static IAdLoader a(Context context) {
        try {
            if (f55050b == null) {
                if (!WMAdSdk.p()) {
                    String str = f55049a;
                    DebugLog.release_e(str, b.a("tel!Jojujbmj{joh-qmfbtf!bxbju///"));
                    long currentTimeMillis = System.currentTimeMillis();
                    f55051c.await(3L, TimeUnit.SECONDS);
                    DebugLog.release_e(str, b.a(")dptu!") + (System.currentTimeMillis() - currentTimeMillis) + b.a("!nt*"));
                    if (!WMAdSdk.p()) {
                        throw new Throwable(b.a("xn!tel!joju!gbjmfe-Qmfbtf!difdl!XNBeTel/joju)*!gvodujpo!Xifuifs!ps!opu!up!kpjo\""));
                    }
                }
                DebugLog.release_d(f55049a, b.a("tubsu!mpbe!beMpbefs"));
                synchronized (IAdLoader.class) {
                    if (f55050b == null) {
                        f55050b = d(context);
                    }
                }
            }
            if (f55050b == null) {
                DebugLog.release_e(f55049a, b.a("be!mpbefs!gbjmfe"));
            } else {
                DebugLog.D(f55049a, b.a("be!mpbefs!tvddftt"));
                ContextContainer.init(context);
            }
        } catch (Throwable th) {
            DebugLog.release_e(f55049a, th.getMessage());
        }
        return f55050b;
    }

    public static void b() {
        f55050b = null;
        DebugLog.D(f55049a, b.a("dmfbsTjohmfJotubodf"));
    }

    public static String c(Context context) {
        File file = new File(ad.a.b(context), b.a("xnefwdbm`7/7/1"));
        PackageInfo a10 = ad.a.a(context, file.getAbsolutePath());
        File file2 = new File(ad.a.b(context), b.a("xnefw`7/7/1"));
        PackageInfo a11 = file2.exists() ? ad.a.a(context, file2.getAbsolutePath()) : null;
        if (a11 == null) {
            return file.getAbsolutePath();
        }
        if (TextUtils.equals(ad.a.c(a10.versionName, a11.versionName), a10.versionName)) {
            return file.getAbsolutePath();
        }
        return file2.getAbsolutePath();
    }

    public static IAdLoader d(Context context) {
        try {
            String c4 = c(context);
            if (TextUtils.isEmpty(c4)) {
                DebugLog.release_e(f55049a, b.a("gjmfQbui!jt!fnquz"));
                WMAdSdk.u(context);
                c4 = c(context);
            }
            File file = new File(c4);
            if (!file.exists()) {
                DebugLog.release_e(f55049a, b.a("gjmf!opu!fyjtut"));
                WMAdSdk.u(context);
                file = new File(c4);
            }
            DebugLog.release_d(f55049a, b.a("Jbe!") + file.exists());
            if (file.exists()) {
                try {
                    DexClassLoader dexClassLoader = new DexClassLoader(file.getAbsolutePath(), context.getDir(b.a("efy"), 0).getAbsolutePath(), context.getApplicationInfo().nativeLibraryDir, context.getClassLoader());
                    WMResources.dexClassLoader = dexClassLoader;
                    try {
                        f55050b = (IAdLoader) dexClassLoader.loadClass(b.a("dpn/xbohnbj/be/efy/bmmnpevmft/BeMpbefs")).getConstructor(Context.class).newInstance(context);
                    } catch (Throwable th) {
                        DebugLog.release_e(f55049a, b.a("Jbe!jotubodf!fssps;") + th.toString());
                    }
                    try {
                        AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                        assetManager.getClass().getMethod(b.a("beeBttfuQbui"), String.class).invoke(assetManager, file.getAbsolutePath());
                        WMResources.resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
                    } catch (Throwable th2) {
                        DebugLog.release_e(f55049a, b.a("Jbe!sft!fssps;") + th2.toString());
                    }
                } catch (Throwable th3) {
                    DebugLog.release_e(f55049a, b.a("Jbe!mpbe!fssps;") + th3.toString());
                }
            }
        } catch (Throwable th4) {
            DebugLog.release_e(f55049a, b.a("Jbe!fssps!;") + th4.toString());
        }
        return f55050b;
    }
}
