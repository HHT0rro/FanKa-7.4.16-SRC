package com.bef.effectsdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bk;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class EffectSDKUtils {
    private static Set<File> localFiles = new HashSet();
    private static List<String> assetFiles = ModelsList.list;
    private static Set<File> needRemoveFiles = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static void copyAssets(Context context, String str, String[] strArr, boolean z10) throws Throwable {
        boolean z11;
        if (!needRemoveFiles.isEmpty()) {
            needRemoveFiles.clear();
        }
        needRemoveFiles.addAll(localFiles);
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        for (String str2 : assetFiles) {
            final String fileName = getFileName(str2);
            File takeFirstMatchingOrNull = takeFirstMatchingOrNull(needRemoveFiles, new FileFilter() { // from class: com.bef.effectsdk.EffectSDKUtils.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().contains(String.this);
                }
            });
            boolean z12 = false;
            if (takeFirstMatchingOrNull == null || !new File(str, getAssetRelativePath(str2)).exists()) {
                z11 = true;
            } else {
                needRemoveFiles.remove(takeFirstMatchingOrNull);
                z11 = false;
            }
            if (z11) {
                if (strArr != null && !TextUtils.isEmpty(fileName)) {
                    int length = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        if (fileName.equals(strArr[i10])) {
                            z12 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (z12 && z10) {
                    copyFile(context, str2, str);
                }
                if (!z12 && !z10) {
                    copyFile(context, str2, str);
                }
            }
        }
    }

    private static void copyFile(Context context, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream open;
        FileOutputStream fileOutputStream2;
        InputStream inputStream = null;
        try {
            open = context.getAssets().open(str);
            try {
                String str3 = str2 + str.substring(str.indexOf(bk.f9900i) + 6, str.lastIndexOf("/"));
                File file = new File(str3);
                if (!file.exists() && !file.mkdirs()) {
                    throw new IOException("Can not mkdirs " + file.getPath());
                }
                fileOutputStream2 = new FileOutputStream(new File(str3 + "/" + getFileName(str)));
            } catch (Throwable th) {
                th = th;
                inputStream = open;
                fileOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream2.write(bArr, 0, read);
                } else {
                    try {
                        closeQuietly(open);
                        return;
                    } finally {
                        closeQuietly(fileOutputStream2);
                    }
                }
            }
        } catch (Throwable th3) {
            inputStream = open;
            fileOutputStream = fileOutputStream2;
            th = th3;
            try {
                closeQuietly(inputStream);
                throw th;
            } finally {
                closeQuietly(fileOutputStream);
            }
        }
    }

    private static void deleteNoUseModel() {
        for (File file : localFiles) {
            if (needRemoveFiles.contains(file) && file.exists()) {
                file.delete();
            }
        }
    }

    public static void flushAlgorithmModelFiles(Context context, String str) throws Throwable {
        if (!localFiles.isEmpty()) {
            localFiles.clear();
        }
        scanRecursive(str, localFiles);
        copyAssets(context, str, null, false);
        deleteNoUseModel();
        localFiles.clear();
    }

    private static String getAssetRelativePath(String str) {
        int indexOf = str.indexOf("model/");
        return indexOf >= 0 ? str.substring(indexOf + 6, str.length()) : str;
    }

    private static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1, str.length()) : "";
    }

    public static String getSdkVersion() {
        return nativeGetSdkVersion();
    }

    private static native String nativeGetSdkVersion();

    public static boolean needUpdate(final Context context, String str) {
        if (!localFiles.isEmpty()) {
            localFiles.clear();
        }
        scanRecursive(str, localFiles);
        try {
            if (assetFiles.size() > localFiles.size()) {
                return true;
            }
            for (final String str2 : assetFiles) {
                if (takeFirstMatchingOrNull(localFiles, new FileFilter() { // from class: com.bef.effectsdk.EffectSDKUtils.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        if (String.this.contains(file.getName())) {
                            InputStream inputStream = null;
                            try {
                                inputStream = context.getAssets().open(String.this);
                                return file.length() == ((long) inputStream.available());
                            } catch (IOException unused) {
                            } finally {
                                EffectSDKUtils.closeQuietly(inputStream);
                            }
                        }
                        return false;
                    }
                }) == null) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private static void scanRecursive(String str, Set<File> set) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    scanRecursive(file2.getAbsolutePath(), set);
                } else {
                    set.add(file2);
                }
            }
        }
    }

    private static File takeFirstMatchingOrNull(Set<File> set, FileFilter fileFilter) {
        for (File file : set) {
            if (fileFilter.accept(file)) {
                return file;
            }
        }
        return null;
    }

    public static void flushAlgorithmModelFiles(Context context, String str, String[] strArr, boolean z10) throws Throwable {
        if (!localFiles.isEmpty()) {
            localFiles.clear();
        }
        scanRecursive(str, localFiles);
        copyAssets(context, str, strArr, z10);
        deleteNoUseModel();
        localFiles.clear();
    }
}
