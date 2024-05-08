package com.android.internal.content;

import android.content.ContentResolver;
import android.os.Environment;
import android.os.incremental.IncrementalManager;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class F2fsUtils {
    private static final String COMPRESSION_FEATURE = "compression";
    private static final boolean DEBUG_F2FS = false;
    private static final String TAG = "F2fsUtils";
    private static final File sKernelFeatures = new File("/sys/fs/f2fs/features");
    private static final File sUserDataFeatures = new File("/dev/sys/fs/by-name/userdata/features");
    private static final File sDataDirectory = Environment.getDataDirectory();
    private static final boolean sKernelCompressionAvailable = isCompressionEnabledInKernel();
    private static final boolean sUserDataCompressionAvailable = isCompressionEnabledOnUserData();

    private static native long nativeReleaseCompressedBlocks(String str);

    public static void releaseCompressedBlocks(ContentResolver resolver, File file) {
        File[] files;
        if (!sKernelCompressionAvailable || !sUserDataCompressionAvailable) {
            return;
        }
        boolean releaseCompressBlocks = Settings.Secure.getInt(resolver, "release_compress_blocks_on_install", 1) != 0;
        if (!releaseCompressBlocks || !isCompressionAllowed(file) || (files = getFilesToRelease(file)) == null || files.length == 0) {
            return;
        }
        for (int i10 = files.length - 1; i10 >= 0; i10--) {
            nativeReleaseCompressedBlocks(files[i10].getAbsolutePath());
        }
    }

    private static boolean isCompressionAllowed(File file) {
        try {
            String filePath = file.getCanonicalPath();
            if (IncrementalManager.isIncrementalPath(filePath) || !isChild(sDataDirectory, filePath)) {
                return false;
            }
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    private static boolean isChild(File base, String childPath) {
        try {
            File base2 = base.getCanonicalFile();
            for (File parentFile = new File(childPath).getCanonicalFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
                if (base2.equals(parentFile)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    private static boolean isCompressionEnabledInKernel() {
        File[] features = sKernelFeatures.listFiles();
        if (features == null || features.length == 0) {
            return false;
        }
        for (int i10 = features.length - 1; i10 >= 0; i10--) {
            File file = features[i10];
            if (COMPRESSION_FEATURE.equals(features[i10].getName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCompressionEnabledOnUserData() {
        File file = sUserDataFeatures;
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            return false;
        }
        try {
            List<String> configLines = Files.readAllLines(file.toPath());
            if (configLines == null || configLines.size() > 1 || TextUtils.isEmpty(configLines.get(0))) {
                return false;
            }
            String[] features = configLines.get(0).split(",");
            for (int i10 = features.length - 1; i10 >= 0; i10--) {
                if (COMPRESSION_FEATURE.equals(features[i10].trim())) {
                    return true;
                }
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    private static List<File> getFilesRecursive(File path) {
        File[] allFiles = path.listFiles();
        if (allFiles == null) {
            return null;
        }
        ArrayList<File> files = new ArrayList<>();
        for (File f10 : allFiles) {
            if (f10.isDirectory()) {
                files.addAll(getFilesRecursive(f10));
            } else if (f10.isFile()) {
                files.add(f10);
            }
        }
        return files;
    }

    private static File[] getFilesToRelease(File codePath) {
        List<File> files = getFilesRecursive(codePath);
        if (files == null) {
            if (!codePath.isFile()) {
                return null;
            }
            return new File[]{codePath};
        }
        if (files.size() == 0) {
            return null;
        }
        return (File[]) files.toArray(new File[files.size()]);
    }
}
