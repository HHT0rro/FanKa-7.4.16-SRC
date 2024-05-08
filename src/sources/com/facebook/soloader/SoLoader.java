package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SoLoader {
    public static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final String TAG = "SoLoader";
    private static int sFlags;
    public static SoFileLoader sSoFileLoader;
    private static SoSource[] sSoSources;
    private static final Set<String> sLoadedLibraries = new HashSet();
    private static StrictMode.ThreadPolicy sOldPolicy = null;
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;
    private static String SO_STORE_NAME_MAIN = "lib-main";
    public static final boolean SYSTRACE_LIBRARY_LOADING = true;

    @DoNotOptimize
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e2);
                }
            }
            throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class WrongAbiError extends UnsatisfiedLinkError {
        public WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            initCause(th);
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        SoSource[] soSourceArr = sSoSources;
        if (soSourceArr == null) {
            return false;
        }
        String[] supportedAbis = SysUtil.getSupportedAbis();
        for (SoSource soSource : soSourceArr) {
            for (String str : soSource.getSoSourceAbis()) {
                boolean z10 = false;
                for (int i10 = 0; i10 < supportedAbis.length && !z10; i10++) {
                    z10 = str.equals(supportedAbis[i10]);
                }
                if (!z10) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void assertInitialized() {
        if (sSoSources == null) {
            throw new RuntimeException("SoLoader.init() not yet called");
        }
    }

    public static void deinitForTest() {
        sSoSources = null;
    }

    public static Set<String> getLoadedLibrariesNames() {
        return sLoadedLibraries;
    }

    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    public static void init(Context context, int i10) throws IOException {
        init(context, i10, null);
    }

    private static synchronized void initImpl(Context context, int i10, SoFileLoader soFileLoader) throws IOException {
        synchronized (SoLoader.class) {
            if (sSoSources == null) {
                sFlags = i10;
                initSoLoader(soFileLoader);
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(u.bD)) {
                    arrayList.add(new DirectorySoSource(new File(str2), 2));
                }
                if (context != null) {
                    int i11 = 1;
                    if ((i10 & 1) != 0) {
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        int i12 = applicationInfo.flags;
                        if ((i12 & 1) != 0 && (i12 & 128) == 0) {
                            i11 = 0;
                        } else {
                            arrayList.add(0, new DirectorySoSource(new File(applicationInfo.nativeLibraryDir), 0));
                        }
                        arrayList.add(0, new ApkSoSource(context, SO_STORE_NAME_MAIN, i11));
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i13 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    soSourceArr[i13].prepare(makePrepareFlags);
                    length = i13;
                }
                sSoSources = soSourceArr;
            }
        }
    }

    private static synchronized void initSoLoader(SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z10 = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z10 ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() { // from class: com.facebook.soloader.SoLoader.1
                @Override // com.facebook.soloader.SoFileLoader
                public void load(String str, int i10) {
                    if (z10) {
                        String str2 = (i10 & 4) == 4 ? classLoaderLdLoadLibrary : makeNonZipPath;
                        try {
                            synchronized (runtime) {
                                nativeLoadRuntimeMethod.invoke(runtime, str, SoLoader.class.getClassLoader(), str2);
                            }
                            return;
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                            throw new RuntimeException("Error: Cannot load " + str, e2);
                        }
                    }
                    System.load(str);
                }
            };
        }
    }

    public static void loadLibrary(String str) {
        loadLibrary(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public static synchronized void loadLibraryBySoName(String str, int i10) throws IOException {
        boolean z10;
        synchronized (SoLoader.class) {
            ?? contains = sLoadedLibraries.contains(str);
            if (contains == 0) {
                int i11 = 0;
                if (sOldPolicy == null) {
                    sOldPolicy = StrictMode.allowThreadDiskReads();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[" + str + "]");
                }
                while (true) {
                    if (contains != 0) {
                        break;
                    }
                    try {
                        SoSource[] soSourceArr = sSoSources;
                        if (i11 >= soSourceArr.length) {
                            break;
                        }
                        contains = soSourceArr[i11].loadLibrary(str, i10);
                        i11++;
                    } finally {
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Api18TraceUtils.endSection();
                        }
                        if (z10) {
                            StrictMode.setThreadPolicy(sOldPolicy);
                            sOldPolicy = null;
                        }
                    }
                }
            }
            if (contains == 0) {
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            }
            if (contains == 1) {
                sLoadedLibraries.add(str);
            }
        }
    }

    public static synchronized String makeLdLibraryPath() {
        String join;
        synchronized (SoLoader.class) {
            assertInitialized();
            ArrayList arrayList = new ArrayList();
            for (SoSource soSource : sSoSources) {
                soSource.addToLdLibraryPath(arrayList);
            }
            join = TextUtils.join(u.bD, arrayList);
        }
        return join;
    }

    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(u.bD);
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(u.bD, arrayList);
    }

    private static int makePrepareFlags() {
        return (sFlags & 2) != 0 ? 1 : 0;
    }

    public static synchronized void prependSoSource(SoSource soSource) throws IOException {
        synchronized (SoLoader.class) {
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = sSoSources;
            SoSource[] soSourceArr2 = new SoSource[soSourceArr.length + 1];
            soSourceArr2[0] = soSource;
            System.arraycopy(soSourceArr, 0, soSourceArr2, 1, soSourceArr.length);
            sSoSources = soSourceArr2;
        }
    }

    public static void setInTestMode() {
        sSoSources = new SoSource[]{new NoopSoSource()};
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static File unpackLibraryBySoName(String str) throws IOException {
        int i10 = 0;
        while (true) {
            SoSource[] soSourceArr = sSoSources;
            if (i10 < soSourceArr.length) {
                File unpackLibrary = soSourceArr[i10].unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
                i10++;
            } else {
                throw new FileNotFoundException(str);
            }
        }
    }

    public static void init(Context context, int i10, SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            initImpl(context, i10, soFileLoader);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static synchronized void loadLibrary(String str, int i10) throws UnsatisfiedLinkError {
        synchronized (SoLoader.class) {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                    if (systemLoadLibraryWrapper != null) {
                        systemLoadLibraryWrapper.loadLibrary(str);
                    } else {
                        System.loadLibrary(str);
                    }
                    return;
                }
            }
            String mapLibName = MergedSoMapping.mapLibName(str);
            try {
                loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), i10);
                if (mapLibName != null) {
                    MergedSoMapping.invokeJniOnload(str);
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (UnsatisfiedLinkError e10) {
                String message = e10.getMessage();
                if (message != null && message.contains("unexpected e_machine:")) {
                    throw new WrongAbiError(e10);
                }
                throw e10;
            }
        }
    }

    public static void init(Context context, boolean z10) {
        try {
            init(context, z10 ? 1 : 0);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
