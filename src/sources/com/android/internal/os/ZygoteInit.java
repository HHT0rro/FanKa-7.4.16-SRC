package com.android.internal.os;

import android.app.ApplicationLoaders;
import android.content.pm.SharedLibraryInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Environment;
import android.os.IInstalld;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.ZygoteProcess;
import android.security.keystore2.AndroidKeyStoreProvider;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructCapUserData;
import android.system.StructCapUserHeader;
import android.text.Hyphenator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.TimingsTraceLog;
import android.view.WindowManager;
import android.webkit.WebViewFactory;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.os.RuntimeInit;
import com.android.internal.util.Preconditions;
import com.huawei.openalliance.ad.constant.u;
import dalvik.system.VMRuntime;
import dalvik.system.ZygoteHooks;
import java.io.EOFException;
import java.io.File;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ZygoteInit {
    private static final String ABI_LIST_ARG = "--abi-list=";
    private static final int LOG_BOOT_PROGRESS_PRELOAD_END = 3030;
    private static final int LOG_BOOT_PROGRESS_PRELOAD_START = 3020;
    private static final String PRELOADED_CLASSES = "/system/etc/preloaded-classes";
    private static final boolean PRELOAD_RESOURCES = true;
    private static final String PROPERTY_DISABLE_GRAPHICS_DRIVER_PRELOADING = "ro.zygote.disable_gl_preload";
    private static final int ROOT_GID = 0;
    private static final int ROOT_UID = 0;
    private static final String SOCKET_NAME_ARG = "--socket-name=";
    private static final int UNPRIVILEGED_GID = 9999;
    private static final int UNPRIVILEGED_UID = 9999;
    private static Resources mResources;
    private static boolean sPreloadComplete;
    private static final String TAG = "Zygote";
    private static final boolean LOGGING_DEBUG = Log.isLoggable(TAG, 3);
    private static ClassLoader sCachedSystemServerClassLoader = null;

    private static native void nativePreloadAppProcessHALs();

    static native void nativePreloadGraphicsDriver();

    private static native void nativeZygoteInit();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void preload(TimingsTraceLog bootTimingsTraceLog) {
        Log.d(TAG, "begin preload");
        bootTimingsTraceLog.traceBegin("BeginPreload");
        beginPreload();
        bootTimingsTraceLog.traceEnd();
        bootTimingsTraceLog.traceBegin("PreloadClasses");
        preloadClasses();
        bootTimingsTraceLog.traceEnd();
        bootTimingsTraceLog.traceBegin("CacheNonBootClasspathClassLoaders");
        cacheNonBootClasspathClassLoaders();
        bootTimingsTraceLog.traceEnd();
        bootTimingsTraceLog.traceBegin("PreloadResources");
        preloadResources();
        bootTimingsTraceLog.traceEnd();
        Trace.traceBegin(16384L, "PreloadAppProcessHALs");
        nativePreloadAppProcessHALs();
        Trace.traceEnd(16384L);
        Trace.traceBegin(16384L, "PreloadGraphicsDriver");
        maybePreloadGraphicsDriver();
        Trace.traceEnd(16384L);
        preloadSharedLibraries();
        preloadTextResources();
        WebViewFactory.prepareWebViewInZygote();
        endPreload();
        warmUpJcaProviders();
        Log.d(TAG, "end preload");
        sPreloadComplete = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void lazyPreload() {
        Preconditions.checkState(!sPreloadComplete);
        Log.i(TAG, "Lazily preloading resources.");
        preload(new TimingsTraceLog("ZygoteInitTiming_lazy", 16384L));
    }

    private static void beginPreload() {
        Log.i(TAG, "Calling ZygoteHooks.beginPreload()");
        ZygoteHooks.onBeginPreload();
    }

    private static void endPreload() {
        ZygoteHooks.onEndPreload();
        Log.i(TAG, "Called ZygoteHooks.endPreload()");
    }

    private static void preloadSharedLibraries() {
        Log.i(TAG, "Preloading shared libraries...");
        System.loadLibrary("android");
        System.loadLibrary("jnigraphics");
        if (!SystemProperties.getBoolean("config.disable_renderscript", false)) {
            System.loadLibrary("compiler_rt");
        }
        if (Build.isQcomPlatform()) {
            try {
                System.loadLibrary("qti_performance");
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "Couldn't load qti_performance");
            }
        }
    }

    private static void maybePreloadGraphicsDriver() {
        if (!SystemProperties.getBoolean(PROPERTY_DISABLE_GRAPHICS_DRIVER_PRELOADING, false)) {
            nativePreloadGraphicsDriver();
        }
    }

    private static void preloadTextResources() {
        Hyphenator.init();
        TextView.preloadFontCache();
    }

    private static void warmUpJcaProviders() {
        long startTime = SystemClock.uptimeMillis();
        Trace.traceBegin(16384L, "Starting installation of AndroidKeyStoreProvider");
        AndroidKeyStoreProvider.install();
        Log.i(TAG, "Installed AndroidKeyStoreProvider in " + (SystemClock.uptimeMillis() - startTime) + "ms.");
        Trace.traceEnd(16384L);
        long startTime2 = SystemClock.uptimeMillis();
        Trace.traceBegin(16384L, "Starting warm up of JCA providers");
        for (Provider p10 : Security.getProviders()) {
            p10.warmUpServiceProvision();
        }
        Log.i(TAG, "Warmed up JCA providers in " + (SystemClock.uptimeMillis() - startTime2) + "ms.");
        Trace.traceEnd(16384L);
    }

    private static boolean isExperimentEnabled(String experiment) {
        boolean defaultValue = SystemProperties.getBoolean(ZygoteConfig.PROPERTY_PREFIX_SYSTEM + experiment, false);
        return SystemProperties.getBoolean("persist.device_config.runtime_native_boot." + experiment, defaultValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldProfileSystemServer() {
        return isExperimentEnabled("profilesystemserver");
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void preloadClasses() {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteInit.preloadClasses():void");
    }

    private static void cacheNonBootClasspathClassLoaders() {
        List<SharedLibraryInfo> libs = new ArrayList<>();
        libs.add(new SharedLibraryInfo("/system/framework/android.hidl.base-V1.0-java.jar", null, null, null, 0L, 0, null, null, null, false));
        libs.add(new SharedLibraryInfo("/system/framework/android.hidl.manager-V1.0-java.jar", null, null, null, 0L, 0, null, null, null, false));
        libs.add(new SharedLibraryInfo("/system/framework/android.test.base.jar", null, null, null, 0L, 0, null, null, null, false));
        if (WindowManager.hasWindowExtensionsEnabled()) {
            String systemExtFrameworkPath = new File(Environment.getSystemExtDirectory(), "framework").getPath();
            libs.add(new SharedLibraryInfo(systemExtFrameworkPath + "/androidx.window.extensions.jar", "androidx.window.extensions", null, "androidx.window.extensions", -1L, 0, null, null, null, false));
            libs.add(new SharedLibraryInfo(systemExtFrameworkPath + "/androidx.window.sidecar.jar", "androidx.window.sidecar", null, "androidx.window.sidecar", -1L, 0, null, null, null, false));
        }
        ApplicationLoaders.getDefault().createAndCacheNonBootclasspathSystemClassLoaders(libs);
    }

    private static void preloadResources() {
        try {
            Resources system = Resources.getSystem();
            mResources = system;
            system.startPreloading();
            Log.i(TAG, "Preloading resources...");
            ((IZygoteInitExt) ExtLoader.type(IZygoteInitExt.class).create()).hookPreloadResources(mResources, TAG);
            long startTime = SystemClock.uptimeMillis();
            TypedArray ar2 = mResources.obtainTypedArray(R.array.preloaded_drawables);
            int N = preloadDrawables(ar2);
            ar2.recycle();
            Log.i(TAG, "...preloaded " + N + " resources in " + (SystemClock.uptimeMillis() - startTime) + "ms.");
            ((IZygoteInitExt) ExtLoader.type(IZygoteInitExt.class).create()).addBootEvent("Zygote:Preload " + N + " obtain resources in " + (SystemClock.uptimeMillis() - startTime) + "ms");
            long startTime2 = SystemClock.uptimeMillis();
            TypedArray ar3 = mResources.obtainTypedArray(R.array.preloaded_color_state_lists);
            int N2 = preloadColorStateLists(ar3);
            ar3.recycle();
            Log.i(TAG, "...preloaded " + N2 + " resources in " + (SystemClock.uptimeMillis() - startTime2) + "ms.");
            if (mResources.getBoolean(R.bool.config_freeformWindowManagement)) {
                startTime2 = SystemClock.uptimeMillis();
                TypedArray ar4 = mResources.obtainTypedArray(R.array.preloaded_freeform_multi_window_drawables);
                N2 = preloadDrawables(ar4);
                ar4.recycle();
                Log.i(TAG, "...preloaded " + N2 + " resource in " + (SystemClock.uptimeMillis() - startTime2) + "ms.");
            }
            ((IZygoteInitExt) ExtLoader.type(IZygoteInitExt.class).create()).addBootEvent("Zygote:Preload " + N2 + " resources in " + (SystemClock.uptimeMillis() - startTime2) + "ms");
            mResources.finishPreloading();
        } catch (RuntimeException e2) {
            Log.w(TAG, "Failure preloading resources", e2);
        }
    }

    private static int preloadColorStateLists(TypedArray ar2) {
        int N = ar2.length();
        for (int i10 = 0; i10 < N; i10++) {
            int id2 = ar2.getResourceId(i10, 0);
            if (id2 != 0 && mResources.getColorStateList(id2, null) == null) {
                throw new IllegalArgumentException("Unable to find preloaded color resource #0x" + Integer.toHexString(id2) + " (" + ar2.getString(i10) + ")");
            }
        }
        return N;
    }

    private static int preloadDrawables(TypedArray ar2) {
        int N = ar2.length();
        for (int i10 = 0; i10 < N; i10++) {
            int id2 = ar2.getResourceId(i10, 0);
            if (id2 != 0 && mResources.getDrawable(id2, null) == null) {
                throw new IllegalArgumentException("Unable to find preloaded drawable resource #0x" + Integer.toHexString(id2) + " (" + ar2.getString(i10) + ")");
            }
        }
        return N;
    }

    private static void gcAndFinalize() {
        ZygoteHooks.gcAndFinalize();
    }

    private static Runnable handleSystemServerProcess(ZygoteArguments parsedArgs) {
        String systemServerPaths;
        Log.d(TAG, "increase system server priority to -15");
        Process.setThreadPriority(-15);
        Os.umask(OsConstants.S_IRWXG | OsConstants.S_IRWXO);
        if (parsedArgs.mNiceName != null) {
            Process.setArgV0(parsedArgs.mNiceName);
        }
        String systemServerClasspath = Os.getenv("SYSTEMSERVERCLASSPATH");
        if (systemServerClasspath != null && shouldProfileSystemServer() && (Build.IS_USERDEBUG || Build.IS_ENG)) {
            try {
                Log.d(TAG, "Preparing system server profile");
                String standaloneSystemServerJars = Os.getenv("STANDALONE_SYSTEMSERVER_JARS");
                if (standaloneSystemServerJars != null) {
                    systemServerPaths = String.join(u.bD, systemServerClasspath, standaloneSystemServerJars);
                } else {
                    systemServerPaths = systemServerClasspath;
                }
                prepareSystemServerProfile(systemServerPaths);
            } catch (Exception e2) {
                Log.wtf(TAG, "Failed to set up system server profile", e2);
            }
        }
        if (parsedArgs.mInvokeWith != null) {
            String[] args = parsedArgs.mRemainingArgs;
            if (systemServerClasspath != null) {
                String[] amendedArgs = new String[args.length + 2];
                amendedArgs[0] = "-cp";
                amendedArgs[1] = systemServerClasspath;
                System.arraycopy(args, 0, amendedArgs, 2, args.length);
                args = amendedArgs;
            }
            WrapperInit.execApplication(parsedArgs.mInvokeWith, parsedArgs.mNiceName, parsedArgs.mTargetSdkVersion, VMRuntime.getCurrentInstructionSet(), null, args);
            throw new IllegalStateException("Unexpected return from WrapperInit.execApplication");
        }
        ClassLoader cl = getOrCreateSystemServerClassLoader();
        if (cl != null) {
            Thread.currentThread().setContextClassLoader(cl);
        }
        return zygoteInit(parsedArgs.mTargetSdkVersion, parsedArgs.mDisabledCompatChanges, parsedArgs.mRemainingArgs, cl);
    }

    private static ClassLoader getOrCreateSystemServerClassLoader() {
        String systemServerClasspath;
        if (sCachedSystemServerClassLoader == null && (systemServerClasspath = Os.getenv("SYSTEMSERVERCLASSPATH")) != null) {
            sCachedSystemServerClassLoader = createPathClassLoader(systemServerClasspath, 10000);
        }
        return sCachedSystemServerClassLoader;
    }

    private static void prefetchStandaloneSystemServerJars() {
        if (shouldProfileSystemServer()) {
            return;
        }
        String envStr = Os.getenv("STANDALONE_SYSTEMSERVER_JARS");
        if (TextUtils.isEmpty(envStr)) {
            return;
        }
        for (String jar : envStr.split(u.bD)) {
            try {
                SystemServerClassLoaderFactory.createClassLoader(jar, getOrCreateSystemServerClassLoader());
            } catch (Error e2) {
                Log.e(TAG, String.format("Failed to prefetch standalone system server jar \"%s\": %s", jar, e2.toString()));
            }
        }
    }

    private static void prepareSystemServerProfile(String systemServerPaths) throws RemoteException {
        if (systemServerPaths.isEmpty()) {
            return;
        }
        String[] codePaths = systemServerPaths.split(u.bD);
        IInstalld installd = IInstalld.Stub.asInterface(ServiceManager.getService("installd"));
        installd.prepareAppProfile("android", 0, UserHandle.getAppId(1000), "primary.prof", codePaths[0], (String) null);
        File curProfileDir = Environment.getDataProfilesDePackageDirectory(0, "android");
        String curProfilePath = new File(curProfileDir, "primary.prof").getAbsolutePath();
        File refProfileDir = Environment.getDataProfilesDePackageDirectory(0, "android");
        String refProfilePath = new File(refProfileDir, "primary.prof").getAbsolutePath();
        VMRuntime.registerAppInfo("android", curProfilePath, refProfilePath, codePaths, 1);
    }

    public static void setApiDenylistExemptions(String[] exemptions) {
        VMRuntime.getRuntime().setHiddenApiExemptions(exemptions);
    }

    public static void setHiddenApiAccessLogSampleRate(int percent) {
        VMRuntime.getRuntime().setHiddenApiAccessLogSamplingRate(percent);
    }

    public static void setHiddenApiUsageLogger(VMRuntime.HiddenApiUsageLogger logger) {
        VMRuntime.getRuntime();
        VMRuntime.setHiddenApiUsageLogger(logger);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader createPathClassLoader(String classPath, int targetSdkVersion) {
        String libraryPath = System.getProperty("java.library.path");
        ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
        return ClassLoaderFactory.createClassLoader(classPath, libraryPath, libraryPath, parent, targetSdkVersion, true, null);
    }

    private static Runnable forkSystemServer(String abiList, String socketName, ZygoteServer zygoteServer) {
        long capabilities = posixCapabilitiesAsBits(OsConstants.CAP_IPC_LOCK, OsConstants.CAP_KILL, OsConstants.CAP_NET_ADMIN, OsConstants.CAP_NET_BIND_SERVICE, OsConstants.CAP_NET_BROADCAST, OsConstants.CAP_NET_RAW, OsConstants.CAP_SYS_MODULE, OsConstants.CAP_SYS_NICE, OsConstants.CAP_SYS_PTRACE, OsConstants.CAP_SYS_TIME, OsConstants.CAP_SYS_TTY_CONFIG, OsConstants.CAP_WAKE_ALARM, OsConstants.CAP_BLOCK_SUSPEND);
        StructCapUserHeader header = new StructCapUserHeader(OsConstants._LINUX_CAPABILITY_VERSION_3, 0);
        try {
            StructCapUserData[] data = Os.capget(header);
            long capabilities2 = ((Integer.toUnsignedLong(data[1].effective) << 32) | Integer.toUnsignedLong(data[0].effective)) & capabilities;
            String[] args = {"--setuid=1000", "--setgid=1000", "--setgroups=1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1018,1021,1023,1024,1032,1065,3001,3002,3003,3005,3006,3007,3009,3010,3011,3012", "--capabilities=" + capabilities2 + "," + capabilities2, "--nice-name=system_server", "--runtime-args", "--target-sdk-version=10000", "com.android.server.SystemServer"};
            try {
                ZygoteCommandBuffer commandBuffer = new ZygoteCommandBuffer(args);
                try {
                    ZygoteArguments parsedArgs = ZygoteArguments.getInstance(commandBuffer);
                    commandBuffer.close();
                    Zygote.applyDebuggerSystemProperty(parsedArgs);
                    Zygote.applyInvokeWithSystemProperty(parsedArgs);
                    if (Zygote.nativeSupportsMemoryTagging()) {
                        String mode = SystemProperties.get("arm64.memtag.process.system_server", "");
                        if (mode.isEmpty()) {
                            mode = SystemProperties.get("persist.arm64.memtag.default", "async");
                        }
                        if (mode.equals("async")) {
                            parsedArgs.mRuntimeFlags |= 1048576;
                        } else if (mode.equals("sync")) {
                            parsedArgs.mRuntimeFlags |= 1572864;
                        } else if (!mode.equals("off")) {
                            parsedArgs.mRuntimeFlags |= Zygote.nativeCurrentTaggingLevel();
                            Slog.e(TAG, "Unknown memory tag level for the system server: \"" + mode + "\"");
                        }
                    } else if (Zygote.nativeSupportsTaggedPointers()) {
                        parsedArgs.mRuntimeFlags |= 524288;
                    }
                    parsedArgs.mRuntimeFlags |= 2097152;
                    if (shouldProfileSystemServer()) {
                        parsedArgs.mRuntimeFlags |= 16384;
                    }
                    int pid = Zygote.forkSystemServer(parsedArgs.mUid, parsedArgs.mGid, parsedArgs.mGids, parsedArgs.mRuntimeFlags, null, parsedArgs.mPermittedCapabilities, parsedArgs.mEffectiveCapabilities);
                    if (pid == 0) {
                        if (hasSecondZygote(abiList)) {
                            waitForSecondaryZygote(socketName);
                        }
                        zygoteServer.closeServerSocket();
                        return handleSystemServerProcess(parsedArgs);
                    }
                    return null;
                } catch (EOFException e2) {
                    throw new AssertionError("Unexpected argument error for forking system server", e2);
                }
            } catch (IllegalArgumentException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ErrnoException ex2) {
            throw new RuntimeException("Failed to capget()", ex2);
        }
    }

    private static long posixCapabilitiesAsBits(int... capabilities) {
        long result = 0;
        for (int capability : capabilities) {
            if (capability < 0 || capability > OsConstants.CAP_LAST_CAP) {
                throw new IllegalArgumentException(String.valueOf(capability));
            }
            result |= 1 << capability;
        }
        return result;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        r0 = r12.equals(com.android.internal.os.Zygote.PRIMARY_SOCKET_NAME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b8, code lost:
    
        if (r7 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bc, code lost:
    
        if (r0 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
    
        com.android.internal.util.FrameworkStatsLog.write(240, 17, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cb, code lost:
    
        if (r12.equals(com.android.internal.os.Zygote.SECONDARY_SOCKET_NAME) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cd, code lost:
    
        com.android.internal.util.FrameworkStatsLog.write(240, 18, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
    
        if (r13 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d4, code lost:
    
        if (r14 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d6, code lost:
    
        r9.traceBegin("ZygotePreload");
        android.util.EventLog.writeEvent(com.android.internal.os.ZygoteInit.LOG_BOOT_PROGRESS_PRELOAD_START, android.os.SystemClock.uptimeMillis());
        ((com.android.internal.os.IZygoteInitExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteInitExt.class).create()).addBootEvent("Zygote:Preload Start");
        ((com.android.internal.os.IZygoteInitExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteInitExt.class).create()).beginHookPreload();
        preload(r9);
        ((com.android.internal.os.IZygoteInitExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteInitExt.class).create()).endHookPreload();
        android.util.EventLog.writeEvent(com.android.internal.os.ZygoteInit.LOG_BOOT_PROGRESS_PRELOAD_END, android.os.SystemClock.uptimeMillis());
        r9.traceEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0124, code lost:
    
        r9.traceBegin("PostZygoteInitGC");
        ((com.android.internal.os.IZygoteInitExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteInitExt.class).create()).beginHookGcAndFinalize(r14);
        gcAndFinalize();
        ((com.android.internal.os.IZygoteInitExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteInitExt.class).create()).endHookGcAndFinalize(r14);
        r9.traceEnd();
        r9.traceEnd();
        ((com.android.internal.os.IZygoteInitExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteInitExt.class).create()).addBootEvent("Zygote:Preload End");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0171, code lost:
    
        r4 = ((com.android.internal.os.IZygoteConfigSocExt) system.ext.loader.core.ExtLoader.type(com.android.internal.os.IZygoteConfigSocExt.class).create()).createTertiaryZygote(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0172, code lost:
    
        if (r4 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0180, code lost:
    
        if (r10 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0182, code lost:
    
        r1 = forkSystemServer(r13, r12, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0186, code lost:
    
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0188, code lost:
    
        r1.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0190, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0191, code lost:
    
        android.util.Log.i(com.android.internal.os.ZygoteInit.TAG, "Accepting command socket connections");
        r1 = r4.runSelectLoop(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x019b, code lost:
    
        if (r4 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x019d, code lost:
    
        r4.closeServerSocket();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a0, code lost:
    
        if (r1 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a2, code lost:
    
        r1.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01a5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0174, code lost:
    
        com.android.internal.os.Zygote.initNativeState(r0);
        dalvik.system.ZygoteHooks.stopZygoteNoThreadCreation();
        r4 = new com.android.internal.os.ZygoteServer(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b5, code lost:
    
        android.util.Log.e(com.android.internal.os.ZygoteInit.TAG, "System zygote died with fatal exception", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01bb, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01bd, code lost:
    
        if (r4 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01bf, code lost:
    
        r4.closeServerSocket();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c2, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ad, code lost:
    
        throw new java.lang.RuntimeException("No ABI list supplied.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r18) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteInit.main(java.lang.String[]):void");
    }

    private static boolean hasSecondZygote(String abiList) {
        return !SystemProperties.get("ro.product.cpu.abilist").equals(abiList);
    }

    private static void waitForSecondaryZygote(String socketName) {
        String otherZygoteName = Zygote.PRIMARY_SOCKET_NAME;
        if (Zygote.PRIMARY_SOCKET_NAME.equals(socketName)) {
            otherZygoteName = Zygote.SECONDARY_SOCKET_NAME;
        }
        ZygoteProcess.waitForConnectionToZygote(otherZygoteName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isPreloadComplete() {
        return sPreloadComplete;
    }

    private ZygoteInit() {
    }

    public static Runnable zygoteInit(int targetSdkVersion, long[] disabledCompatChanges, String[] argv, ClassLoader classLoader) {
        Trace.traceBegin(64L, "ZygoteInit");
        RuntimeInit.redirectLogStreams();
        RuntimeInit.commonInit();
        nativeZygoteInit();
        return RuntimeInit.applicationInit(targetSdkVersion, disabledCompatChanges, argv, classLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable childZygoteInit(String[] argv) {
        RuntimeInit.Arguments args = new RuntimeInit.Arguments(argv);
        return RuntimeInit.findStaticMain(args.startClass, args.startArgs, null);
    }
}
