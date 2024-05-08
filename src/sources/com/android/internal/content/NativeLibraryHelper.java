package com.android.internal.content;

import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.PackageLite;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.Build;
import android.os.IBinder;
import android.os.SELinux;
import android.os.ServiceManager;
import android.os.incremental.IIncrementalService;
import android.os.incremental.IncrementalManager;
import android.os.incremental.IncrementalStorage;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Slog;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import dalvik.system.CloseGuard;
import dalvik.system.VMRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class NativeLibraryHelper {
    private static final int BITCODE_PRESENT = 1;
    public static final String CLEAR_ABI_OVERRIDE = "-";
    private static final boolean DEBUG_NATIVE = false;
    public static final String LIB64_DIR_NAME = "lib64";
    public static final String LIB_DIR_NAME = "lib";
    private static final String TAG = "NativeHelper";

    private static native int hasRenderscriptBitcode(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClose(long j10);

    private static native int nativeCopyNativeBinaries(long j10, String str, String str2, boolean z10, boolean z11);

    private static native int nativeFindSupportedAbi(long j10, String[] strArr, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeOpenApk(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeOpenApkFd(FileDescriptor fileDescriptor, String str);

    private static native long nativeSumNativeBinaries(long j10, String str, boolean z10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Handle implements Closeable {
        final long[] apkHandles;
        final String[] apkPaths;
        final boolean debuggable;
        final boolean extractNativeLibs;
        private volatile boolean mClosed;
        private final CloseGuard mGuard;
        final boolean multiArch;

        public static Handle create(File packageFile) throws IOException {
            ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
            ParseResult<PackageLite> ret = ApkLiteParseUtils.parsePackageLite(input.reset(), packageFile, 0);
            if (ret.isError()) {
                throw new IOException("Failed to parse package: " + ((Object) packageFile), ret.getException());
            }
            return create((PackageLite) ret.getResult());
        }

        public static Handle create(PackageLite lite) throws IOException {
            return create(lite.getAllApkPaths(), lite.isMultiArch(), lite.isExtractNativeLibs(), lite.isDebuggable());
        }

        public static Handle create(List<String> codePaths, boolean multiArch, boolean extractNativeLibs, boolean debuggable) throws IOException {
            int size = codePaths.size();
            String[] apkPaths = new String[size];
            long[] apkHandles = new long[size];
            for (int i10 = 0; i10 < size; i10++) {
                String path = codePaths.get(i10);
                apkPaths[i10] = path;
                apkHandles[i10] = NativeLibraryHelper.nativeOpenApk(path);
                if (apkHandles[i10] == 0) {
                    for (int j10 = 0; j10 < i10; j10++) {
                        NativeLibraryHelper.nativeClose(apkHandles[j10]);
                    }
                    throw new IOException("Unable to open APK: " + path);
                }
            }
            return new Handle(apkPaths, apkHandles, multiArch, extractNativeLibs, debuggable);
        }

        public static Handle createFd(PackageLite lite, FileDescriptor fd2) throws IOException {
            String path = lite.getBaseApkPath();
            long[] apkHandles = {NativeLibraryHelper.nativeOpenApkFd(fd2, path)};
            if (apkHandles[0] == 0) {
                throw new IOException("Unable to open APK " + path + " from fd " + ((Object) fd2));
            }
            return new Handle(new String[]{path}, apkHandles, lite.isMultiArch(), lite.isExtractNativeLibs(), lite.isDebuggable());
        }

        Handle(String[] apkPaths, long[] apkHandles, boolean multiArch, boolean extractNativeLibs, boolean debuggable) {
            CloseGuard closeGuard = CloseGuard.get();
            this.mGuard = closeGuard;
            this.apkPaths = apkPaths;
            this.apkHandles = apkHandles;
            this.multiArch = multiArch;
            this.extractNativeLibs = extractNativeLibs;
            this.debuggable = debuggable;
            closeGuard.open("close");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (long apkHandle : this.apkHandles) {
                NativeLibraryHelper.nativeClose(apkHandle);
            }
            this.mGuard.close();
            this.mClosed = true;
        }

        protected void finalize() throws Throwable {
            CloseGuard closeGuard = this.mGuard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
            try {
                if (!this.mClosed) {
                    close();
                }
            } finally {
                super.finalize();
            }
        }
    }

    private static long sumNativeBinaries(Handle handle, String abi) {
        long sum = 0;
        for (long apkHandle : handle.apkHandles) {
            sum += nativeSumNativeBinaries(apkHandle, abi, handle.debuggable);
        }
        return sum;
    }

    public static int copyNativeBinaries(Handle handle, File sharedLibraryDir, String abi) {
        for (long apkHandle : handle.apkHandles) {
            int res = nativeCopyNativeBinaries(apkHandle, sharedLibraryDir.getPath(), abi, handle.extractNativeLibs, handle.debuggable);
            if (res != 1) {
                return res;
            }
        }
        return 1;
    }

    public static int findSupportedAbi(Handle handle, String[] supportedAbis) {
        int finalRes = EffectsSDKEffectConstants.EffectsSDKResultCode.BEF_RESULT_INVALID_LICENSE;
        for (long apkHandle : handle.apkHandles) {
            int res = nativeFindSupportedAbi(apkHandle, supportedAbis, handle.debuggable);
            if (res != -114) {
                if (res == -113) {
                    if (finalRes < 0) {
                        finalRes = -113;
                    }
                } else if (res >= 0) {
                    if (finalRes < 0 || res < finalRes) {
                        finalRes = res;
                    }
                } else {
                    return res;
                }
            }
        }
        return finalRes;
    }

    public static void removeNativeBinariesLI(String nativeLibraryPath) {
        if (nativeLibraryPath == null) {
            return;
        }
        removeNativeBinariesFromDirLI(new File(nativeLibraryPath), false);
    }

    public static void removeNativeBinariesFromDirLI(File nativeLibraryRoot, boolean deleteRootDir) {
        if (nativeLibraryRoot.exists()) {
            File[] files = nativeLibraryRoot.listFiles();
            if (files != null) {
                for (int nn = 0; nn < files.length; nn++) {
                    if (files[nn].isDirectory()) {
                        removeNativeBinariesFromDirLI(files[nn], true);
                    } else if (!files[nn].delete()) {
                        Slog.w(TAG, "Could not delete native binary: " + files[nn].getPath());
                    }
                }
            }
            if (deleteRootDir && !nativeLibraryRoot.delete()) {
                Slog.w(TAG, "Could not delete native binary directory: " + nativeLibraryRoot.getPath());
            }
        }
    }

    public static void createNativeLibrarySubdir(File path) throws IOException {
        if (!path.isDirectory()) {
            path.delete();
            if (!path.mkdir()) {
                throw new IOException("Cannot create " + path.getPath());
            }
            try {
                Os.chmod(path.getPath(), OsConstants.S_IRWXU | OsConstants.S_IRGRP | OsConstants.S_IXGRP | OsConstants.S_IROTH | OsConstants.S_IXOTH);
                return;
            } catch (ErrnoException e2) {
                throw new IOException("Cannot chmod native library directory " + path.getPath(), e2);
            }
        }
        if (!SELinux.restorecon(path)) {
            throw new IOException("Cannot set SELinux context for " + path.getPath());
        }
    }

    private static long sumNativeBinariesForSupportedAbi(Handle handle, String[] abiList) {
        int abi = findSupportedAbi(handle, abiList);
        if (abi >= 0) {
            return sumNativeBinaries(handle, abiList[abi]);
        }
        return 0L;
    }

    public static int copyNativeBinariesForSupportedAbi(Handle handle, File libraryRoot, String[] abiList, boolean useIsaSubdir, boolean isIncremental) throws IOException {
        File subDir;
        int abi = findSupportedAbi(handle, abiList);
        if (abi < 0) {
            return abi;
        }
        String supportedAbi = abiList[abi];
        String instructionSet = VMRuntime.getInstructionSet(supportedAbi);
        if (useIsaSubdir) {
            subDir = new File(libraryRoot, instructionSet);
        } else {
            subDir = libraryRoot;
        }
        if (isIncremental) {
            int res = incrementalConfigureNativeBinariesForSupportedAbi(handle, subDir, supportedAbi);
            if (res != 1) {
                return res;
            }
            return abi;
        }
        createNativeLibrarySubdir(libraryRoot);
        if (subDir != libraryRoot) {
            createNativeLibrarySubdir(subDir);
        }
        int copyRet = copyNativeBinaries(handle, subDir, supportedAbi);
        if (copyRet != 1) {
            return copyRet;
        }
        return abi;
    }

    public static int copyNativeBinariesWithOverride(Handle handle, File libraryRoot, String abiOverride, boolean isIncremental) {
        int copyRet;
        int copyRet2;
        try {
            if (handle.multiArch) {
                if (abiOverride != null && !"-".equals(abiOverride)) {
                    Slog.w(TAG, "Ignoring abiOverride for multi arch application.");
                }
                if (Build.SUPPORTED_32_BIT_ABIS.length > 0) {
                    int copyRet3 = copyNativeBinariesForSupportedAbi(handle, libraryRoot, Build.SUPPORTED_32_BIT_ABIS, true, isIncremental);
                    if (copyRet3 < 0 && copyRet3 != -114 && copyRet3 != -113) {
                        Slog.w(TAG, "Failure copying 32 bit native libraries; copyRet=" + copyRet3);
                        return copyRet3;
                    }
                } else if (Build.MTK_HBT_ON_64BIT_ONLY_CHIP && Build.MTK_HBT_SUPPORTED_32_BIT_ABIS.length > 0) {
                    int copyRet4 = copyNativeBinariesForSupportedAbi(handle, libraryRoot, Build.MTK_HBT_SUPPORTED_32_BIT_ABIS, true, isIncremental);
                    if (copyRet4 < 0 && copyRet4 != -114 && copyRet4 != -113) {
                        Slog.w(TAG, "Failure copying 32 bit native libraries; copyRet=" + copyRet4);
                        return copyRet4;
                    }
                } else if (Build.QCOM_TANGO_ON_64BIT_ONLY_CHIP && Build.QCOM_TANGO_SUPPORTED_32_BIT_ABIS.length > 0 && (copyRet = copyNativeBinariesForSupportedAbi(handle, libraryRoot, Build.QCOM_TANGO_SUPPORTED_32_BIT_ABIS, true, isIncremental)) < 0 && copyRet != -114 && copyRet != -113) {
                    Slog.w(TAG, "Failure copying 32 bit native libraries; copyRet=" + copyRet);
                    return copyRet;
                }
                if (Build.SUPPORTED_64_BIT_ABIS.length > 0 && (copyRet2 = copyNativeBinariesForSupportedAbi(handle, libraryRoot, Build.SUPPORTED_64_BIT_ABIS, true, isIncremental)) < 0 && copyRet2 != -114 && copyRet2 != -113) {
                    Slog.w(TAG, "Failure copying 64 bit native libraries; copyRet=" + copyRet2);
                    return copyRet2;
                }
            } else {
                String cpuAbiOverride = null;
                if ("-".equals(abiOverride)) {
                    cpuAbiOverride = null;
                } else if (abiOverride != null) {
                    cpuAbiOverride = abiOverride;
                }
                String[] abiList = cpuAbiOverride != null ? new String[]{cpuAbiOverride} : Build.SUPPORTED_ABIS;
                if (cpuAbiOverride == null && Build.MTK_HBT_ON_64BIT_ONLY_CHIP) {
                    abiList = Build.MTK_HBT_SUPPORTED_ABIS;
                } else if (cpuAbiOverride == null && Build.QCOM_TANGO_ON_64BIT_ONLY_CHIP) {
                    abiList = Build.QCOM_TANGO_SUPPORTED_ABIS;
                }
                if (Build.SUPPORTED_64_BIT_ABIS.length > 0 && cpuAbiOverride == null && hasRenderscriptBitcode(handle)) {
                    abiList = Build.SUPPORTED_32_BIT_ABIS;
                    if (Build.MTK_HBT_ON_64BIT_ONLY_CHIP) {
                        abiList = Build.MTK_HBT_SUPPORTED_32_BIT_ABIS;
                    } else if (Build.QCOM_TANGO_ON_64BIT_ONLY_CHIP) {
                        abiList = Build.QCOM_TANGO_SUPPORTED_32_BIT_ABIS;
                    }
                }
                int copyRet5 = copyNativeBinariesForSupportedAbi(handle, libraryRoot, abiList, true, isIncremental);
                if (copyRet5 < 0 && copyRet5 != -114) {
                    Slog.w(TAG, "Failure copying native libraries [errorCode=" + copyRet5 + "]");
                    return copyRet5;
                }
            }
            return 1;
        } catch (IOException e2) {
            Slog.e(TAG, "Copying native libraries failed", e2);
            return -110;
        }
    }

    public static long sumNativeBinariesWithOverride(Handle handle, String abiOverride) throws IOException {
        long sum = 0;
        if (handle.multiArch) {
            if (abiOverride != null && !"-".equals(abiOverride)) {
                Slog.w(TAG, "Ignoring abiOverride for multi arch application.");
            }
            if (Build.SUPPORTED_32_BIT_ABIS.length > 0) {
                sum = 0 + sumNativeBinariesForSupportedAbi(handle, Build.SUPPORTED_32_BIT_ABIS);
            } else if (Build.MTK_HBT_ON_64BIT_ONLY_CHIP && Build.MTK_HBT_SUPPORTED_32_BIT_ABIS.length > 0) {
                sum = 0 + sumNativeBinariesForSupportedAbi(handle, Build.MTK_HBT_SUPPORTED_32_BIT_ABIS);
            } else if (Build.QCOM_TANGO_ON_64BIT_ONLY_CHIP && Build.QCOM_TANGO_SUPPORTED_32_BIT_ABIS.length > 0) {
                sum = 0 + sumNativeBinariesForSupportedAbi(handle, Build.QCOM_TANGO_SUPPORTED_32_BIT_ABIS);
            }
            if (Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                return sum + sumNativeBinariesForSupportedAbi(handle, Build.SUPPORTED_64_BIT_ABIS);
            }
            return sum;
        }
        String cpuAbiOverride = null;
        if ("-".equals(abiOverride)) {
            cpuAbiOverride = null;
        } else if (abiOverride != null) {
            cpuAbiOverride = abiOverride;
        }
        String[] abiList = cpuAbiOverride != null ? new String[]{cpuAbiOverride} : Build.SUPPORTED_ABIS;
        if (cpuAbiOverride == null && Build.MTK_HBT_ON_64BIT_ONLY_CHIP) {
            abiList = Build.MTK_HBT_SUPPORTED_ABIS;
        } else if (cpuAbiOverride == null && Build.QCOM_TANGO_ON_64BIT_ONLY_CHIP) {
            abiList = Build.QCOM_TANGO_SUPPORTED_ABIS;
        }
        if (Build.SUPPORTED_64_BIT_ABIS.length > 0 && cpuAbiOverride == null && hasRenderscriptBitcode(handle)) {
            abiList = Build.SUPPORTED_32_BIT_ABIS;
            if (Build.MTK_HBT_ON_64BIT_ONLY_CHIP) {
                abiList = Build.MTK_HBT_SUPPORTED_32_BIT_ABIS;
            } else if (Build.QCOM_TANGO_ON_64BIT_ONLY_CHIP) {
                abiList = Build.QCOM_TANGO_SUPPORTED_32_BIT_ABIS;
            }
        }
        return 0 + sumNativeBinariesForSupportedAbi(handle, abiList);
    }

    private static int incrementalConfigureNativeBinariesForSupportedAbi(Handle handle, File libSubDir, String abi) {
        String[] apkPaths = handle.apkPaths;
        if (apkPaths == null || apkPaths.length == 0) {
            Slog.e(TAG, "No apks to extract native libraries from.");
            return -110;
        }
        IBinder incrementalService = ServiceManager.getService("incremental");
        if (incrementalService == null) {
            return -110;
        }
        IncrementalManager incrementalManager = new IncrementalManager(IIncrementalService.Stub.asInterface(incrementalService));
        File apkParent = new File(apkPaths[0]).getParentFile();
        IncrementalStorage incrementalStorage = incrementalManager.openStorage(apkParent.getAbsolutePath());
        if (incrementalStorage == null) {
            Slog.e(TAG, "Failed to find incremental storage");
            return -110;
        }
        String libRelativeDir = getRelativePath(apkParent, libSubDir);
        if (libRelativeDir == null) {
            return -110;
        }
        for (String str : apkPaths) {
            if (!incrementalStorage.configureNativeBinaries(str, libRelativeDir, abi, handle.extractNativeLibs)) {
                return -110;
            }
        }
        return 1;
    }

    private static String getRelativePath(File base, File target) {
        try {
            Path basePath = base.toPath();
            Path targetPath = target.toPath();
            Path relativePath = basePath.relativize(targetPath);
            if (relativePath.toString().isEmpty()) {
                return "";
            }
            return relativePath.toString();
        } catch (IllegalArgumentException e2) {
            Slog.e(TAG, "Failed to find relative path between: " + base.getAbsolutePath() + " and: " + target.getAbsolutePath());
            return null;
        }
    }

    public static boolean hasRenderscriptBitcode(Handle handle) throws IOException {
        for (long apkHandle : handle.apkHandles) {
            int res = hasRenderscriptBitcode(apkHandle);
            if (res < 0) {
                throw new IOException("Error scanning APK, code: " + res);
            }
            if (res == 1) {
                return true;
            }
        }
        return false;
    }
}
