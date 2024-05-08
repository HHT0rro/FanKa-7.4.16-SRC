package com.zego.zegoavkit2.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SoLoadUtil {
    private static final int BUFFER_SIZE = 65536;
    private static final String VERSION_FILE_NAME_TEMPLATE = "cur_ver_%d.txt";

    private static boolean copyFile(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, false));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[65536];
            int i10 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 65536);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    i10++;
                    if (i10 % 10 == 0) {
                        bufferedOutputStream.flush();
                    }
                } else {
                    bufferedOutputStream.flush();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    private static File getCustomizeLibDir(Context context, String str) {
        return new File(context.getDir("libs", 0), str);
    }

    private static String[] getSupportABIs() {
        return Build.SUPPORTED_ABIS;
    }

    private static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean loadSoFile(String str, Context context) {
        File customizeLibDir = getCustomizeLibDir(context, "apk");
        File file = new File(customizeLibDir, versionFileName(getVersionCode(context)));
        File file2 = new File(customizeLibDir, str);
        int unzipSo = (file.exists() && file2.exists()) ? 0 : unzipSo(context, str, file2, file);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("unzip ");
        sb2.append(str);
        sb2.append(" from apk, errorCode: ");
        sb2.append(unzipSo);
        System.load(file2.getPath());
        return true;
    }

    public static boolean loadSpecialLibrary(String str, Context context) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            System.load(str);
        } catch (UnsatisfiedLinkError unused) {
            File file2 = new File(getCustomizeLibDir(context, "ext"), file.getName());
            if (!file2.exists() || file2.length() != file.length()) {
                try {
                    copyFile(file, file2);
                } catch (Exception unused2) {
                    String.format("copyFile from %s to %s failed", file, file2);
                }
            }
            System.load(file2.getAbsolutePath());
        }
        return true;
    }

    private static int unzipSo(Context context, String str, File file, File file2) {
        String packageCodePath = context.getPackageCodePath();
        for (String str2 : getSupportABIs()) {
            try {
                if (unzipSpecialABISo(packageCodePath, str, str2, file)) {
                    return file2.createNewFile() ? 0 : -1;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2;
            }
        }
        return -3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean unzipSpecialABISo(String str, String str2, String str3, File file) throws IOException {
        ZipInputStream zipInputStream;
        boolean z10;
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            z10 = false;
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            if (name.startsWith("lib/") && name.startsWith(str3, 4) && name.endsWith(str2)) {
                                z10 = true;
                                break;
                            }
                        } else {
                            throw new SecurityException("unsecurity zip file!");
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zipInputStream2 = zipInputStream;
                        e.printStackTrace();
                        if (zipInputStream2 != null) {
                            zipInputStream2.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream2 = zipInputStream;
                        if (zipInputStream2 != null) {
                            zipInputStream2.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
        if (z10) {
            byte[] bArr = new byte[65536];
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 65536);
                while (true) {
                    try {
                        int read = zipInputStream.read(bArr, 0, 65536);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            zipInputStream.close();
                            return true;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream2 = bufferedOutputStream;
                        if (zipInputStream2 != null) {
                            zipInputStream2.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            zipInputStream.close();
            return false;
        }
    }

    private static String versionFileName(int i10) {
        return String.format(VERSION_FILE_NAME_TEMPLATE, Integer.valueOf(i10));
    }
}
