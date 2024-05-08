package com.alibaba.security.common.utils;

import android.content.Context;
import android.os.Build;
import com.alibaba.security.common.log.RPLogging;
import com.android.internal.content.NativeLibraryHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SoLoaderUtils {
    private static final String BASE_SO_ARM64_LIB = "arm64-v8a";
    private static final String BASE_SO_ARM_LIB = "armeabi-v7a";
    private static final String TAG = "SoLoaderUtils";
    private static SoLoaderUtils _instance;
    private final Context mContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class DelFileFilter implements FileFilter {
        public String condition;

        public DelFileFilter(String str) {
            this.condition = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().startsWith(this.condition);
        }
    }

    private SoLoaderUtils(Context context) {
        this.mContext = context;
    }

    private boolean copySo2DataLib(String str, String str2, String str3) {
        String str4;
        String str5 = Build.CPU_ABI;
        String str6 = NativeLibraryHelper.LIB_DIR_NAME + str3 + ".so";
        if ("x86".equals(str5)) {
            str4 = "lib/armeabi-v7a/" + str6;
        } else if (str5.startsWith("armeabi")) {
            str4 = "lib/armeabi-v7a/" + str6;
        } else {
            if (!str5.startsWith("arm64")) {
                return false;
            }
            str4 = "lib/arm64-v8a/" + str6;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            String str7 = File.separator;
            sb2.append(str7);
            sb2.append(str2);
            File file = new File(sb2.toString());
            File file2 = new File(file.toString() + str7 + str6);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(NativeLibraryHelper.LIB_DIR_NAME);
            sb3.append(str3);
            deleteSoFiles(file, sb3.toString());
            file.mkdirs();
            return copylib2ApkData(str, str4, str6, file2);
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean copylib2ApkData(String str, String str2, String str3, File file) {
        InputStream resourceAsStream = SoLoaderUtils.class.getClassLoader().getResourceAsStream(str2);
        if (resourceAsStream == null) {
            return false;
        }
        boolean saveFile = saveFile(resourceAsStream, file);
        try {
            resourceAsStream.close();
            return saveFile;
        } catch (IOException unused) {
            return saveFile;
        }
    }

    private void deleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                }
                file.delete();
                return;
            }
            return;
        }
        RPLogging.d(TAG, "File to be delete is not found");
    }

    private void deleteSoFiles(File file, String str) {
        try {
            for (File file2 : file.listFiles(new DelFileFilter(str))) {
                deleteFile(file2);
            }
        } catch (Exception e2) {
            RPLogging.e(TAG, e2.toString());
        }
    }

    public static synchronized SoLoaderUtils getInstance(Context context) {
        SoLoaderUtils soLoaderUtils;
        synchronized (SoLoaderUtils.class) {
            if (_instance == null) {
                _instance = new SoLoaderUtils(context);
            }
            soLoaderUtils = _instance;
        }
        return soLoaderUtils;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.BufferedOutputStream] */
    private boolean saveFile(InputStream inputStream, File file) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream((File) file);
                        try {
                            file = new BufferedOutputStream(fileOutputStream2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read != -1) {
                                        file.write(bArr, 0, read);
                                    } else {
                                        file.flush();
                                        fileOutputStream2.flush();
                                        fileOutputStream2.close();
                                        bufferedInputStream.close();
                                        file.close();
                                        return true;
                                    }
                                }
                            } catch (FileNotFoundException e2) {
                                fileOutputStream = fileOutputStream2;
                                e = e2;
                                file = file;
                                RPLogging.e(TAG, e.toString());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                return false;
                            } catch (IOException e10) {
                                fileOutputStream = fileOutputStream2;
                                e = e10;
                                file = file;
                                RPLogging.e(TAG, e.toString());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e11) {
                                        RPLogging.e(TAG, e11.toString());
                                        throw th;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e12) {
                            fileOutputStream = fileOutputStream2;
                            e = e12;
                            file = 0;
                        } catch (IOException e13) {
                            fileOutputStream = fileOutputStream2;
                            e = e13;
                            file = 0;
                        } catch (Throwable th2) {
                            fileOutputStream = fileOutputStream2;
                            th = th2;
                            file = 0;
                        }
                    } catch (FileNotFoundException e14) {
                        e = e14;
                        file = 0;
                    } catch (IOException e15) {
                        e = e15;
                        file = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        file = 0;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    file = 0;
                    bufferedInputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    file = 0;
                    bufferedInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    file = 0;
                    bufferedInputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e18) {
            RPLogging.e(TAG, e18.toString());
            return false;
        }
    }

    public boolean loadSo(String str) {
        String str2 = str + "_bak";
        File filesDir = this.mContext.getFilesDir();
        boolean z10 = true;
        if (copySo2DataLib(filesDir.toString(), str2, str)) {
            String str3 = NativeLibraryHelper.LIB_DIR_NAME + str + ".so";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            String str4 = File.separator;
            sb2.append(str4);
            sb2.append(str3);
            File file = new File(filesDir.toString() + str4 + sb2.toString());
            if (file.exists()) {
                try {
                    System.load(file.toString());
                } catch (UnsatisfiedLinkError e2) {
                    RPLogging.e(TAG, e2.toString());
                }
                return z10;
            }
            RPLogging.d(TAG, String.format(Locale.ENGLISH, "error can't find %1$s lib in plugins_lib", str));
            z10 = false;
            return z10;
        }
        String.format(Locale.ENGLISH, "error copy %1$s lib fail", str);
        return false;
    }
}
