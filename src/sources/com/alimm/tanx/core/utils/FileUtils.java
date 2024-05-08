package com.alimm.tanx.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.android.internal.logging.nano.MetricsProto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileUtils implements NotConfused {
    public static final int COPY_BUFFER_SIZE = 4096;
    public static final int DIR_TYPE_CACHE = 1;
    public static final int DIR_TYPE_FILE = 0;
    public static final String TAG = "FileUtils";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface FileKeepRule {
        boolean needKept(String str);
    }

    public static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean copyFile(InputStream inputStream, FileOutputStream fileOutputStream) {
        boolean z10 = false;
        try {
            try {
                byte[] bArr = new byte[MetricsProto.MetricsEvent.FIELD_IO_OPERATION_COUNT];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                z10 = true;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                inputStream.close();
            } catch (Exception e10) {
                e10.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return z10;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static boolean copyTo(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            closeIO(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    LogUtils.d(TAG, "copyTo exception: output = " + ((Object) file), e);
                    closeIO(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeIO(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
    }

    public static boolean decompress(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(new File(str)));
                boolean z10 = true;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry != null) {
                            if (!TextUtils.isEmpty(nextEntry.getName()) && nextEntry.getName().contains("../")) {
                                LogUtils.e("decompress", "发现不安全的zip文件解压路径！");
                                closeIO(zipInputStream2);
                                return false;
                            }
                            String joinPath = joinPath(str2, nextEntry.getName());
                            if (nextEntry.isDirectory()) {
                                mkdir(joinPath);
                            } else {
                                z10 &= copyTo(new File(joinPath), zipInputStream2);
                            }
                        } else {
                            closeIO(zipInputStream2);
                            return z10;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        zipInputStream = zipInputStream2;
                        LogUtils.d(TAG, "decompress exception: inputFilePath = " + str + ", outputDirPath = " + str2, e);
                        closeIO(zipInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream2;
                        closeIO(zipInputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            deleteFile(new File(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void deleteExpiredFile(File file, int i10, FileKeepRule fileKeepRule) {
        if (file != null) {
            try {
                if (!file.exists() || System.currentTimeMillis() - file.lastModified() <= TimeUnit.DAYS.toMillis(i10)) {
                    return;
                }
                if (fileKeepRule == null || !fileKeepRule.needKept(file.getName())) {
                    LogUtils.d(TAG, "deleteExpiredFile: file = " + ((Object) file));
                    deleteFile(file);
                }
            } catch (Exception e2) {
                LogUtils.e(e2);
            }
        }
    }

    public static void deleteExpiredFiles(String str, int i10, FileKeepRule fileKeepRule) {
        try {
            List<File> files = getFiles(str);
            LogUtils.d(TAG, "deleteExpiredFiles: expireDays = " + i10);
            if (files == null || files.size() <= 0) {
                return;
            }
            Iterator<File> iterator2 = files.iterator2();
            while (iterator2.hasNext()) {
                deleteExpiredFile(iterator2.next(), i10, fileKeepRule);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "deleteExpiredFiles: exception.", e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteExpiredFiles: exception." + LogUtils.getStackTraceMessage(e2), "");
        }
    }

    public static synchronized boolean deleteFile(File file) {
        File[] listFiles;
        synchronized (FileUtils.class) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                return false;
            }
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
    }

    public static boolean ensureFileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (IOException | SecurityException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean exists(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (SecurityException e2) {
            LogUtils.d(TAG, "call exists failed.", e2);
            return false;
        }
    }

    public static File getExternalDir(Context context, int i10) {
        File externalCacheDir;
        File file = null;
        try {
            if (i10 == 0) {
                externalCacheDir = context.getExternalFilesDir(null);
            } else {
                if (i10 != 1) {
                    return null;
                }
                externalCacheDir = context.getExternalCacheDir();
            }
            file = externalCacheDir;
            return file;
        } catch (Throwable unused) {
            LogUtils.d(TAG, "getExternalDir exception: type = " + i10);
            return file;
        }
    }

    public static List<File> getFiles(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                }
                list.add(file2);
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static synchronized String getStrFromFile(String str) {
        synchronized (FileUtils.class) {
            String str2 = "";
            ?? r22 = 0;
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                }
                if (!new File(str).exists()) {
                    closeIO(null);
                    return null;
                }
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        byte[] bArr = new byte[fileInputStream2.available()];
                        fileInputStream2.read(bArr);
                        String str3 = new String(bArr, StandardCharsets.UTF_8);
                        try {
                            fileInputStream2.close();
                            closeIO(fileInputStream2);
                            r22 = str3;
                        } catch (Exception e10) {
                            e = e10;
                            str2 = str3;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            closeIO(fileInputStream);
                            r22 = str2;
                            return r22;
                        }
                    } catch (Exception e11) {
                        e = e11;
                    }
                    return r22;
                } catch (Throwable th) {
                    th = th;
                    r22 = fileInputStream2;
                    closeIO(r22);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String joinPath(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        if (strArr != null) {
            for (int i10 = 0; i10 < strArr.length && !TextUtils.isEmpty(strArr[i10]); i10++) {
                if (i10 > 0) {
                    sb2.append(File.separator);
                }
                sb2.append(strArr[i10]);
            }
        }
        return sb2.toString();
    }

    public static File mkdir(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.mkdirs();
            return file;
        } catch (Exception e2) {
            LogUtils.d(TAG, "mkdir exception: folderPath = " + str, e2);
            return file;
        }
    }

    public static String readAssetFile(Context context, String str) {
        if (context == null || str == null) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(context).open(str)));
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb2.append(readLine);
                        } else {
                            String sb3 = sb2.toString();
                            closeIO(bufferedReader2);
                            return sb3;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    closeIO(bufferedReader);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    closeIO(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static List<String> readLines(String str) {
        BufferedReader bufferedReader;
        LinkedList linkedList = new LinkedList();
        if (exists(str)) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            linkedList.add(readLine);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            bufferedReader = bufferedReader2;
                            closeIO(bufferedReader);
                            return linkedList;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            closeIO(bufferedReader2);
                            throw th;
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                }
                closeIO(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return linkedList;
    }

    public static synchronized boolean saveStr2File(File file, String str) {
        FileOutputStream fileOutputStream;
        synchronized (FileUtils.class) {
            boolean z10 = false;
            if (file == null) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(str.getBytes());
                        fileOutputStream.close();
                        z10 = true;
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        LogUtils.e(TAG, "saveStrToFile ", e);
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                        e.printStackTrace();
                        fileOutputStream = fileOutputStream2;
                        closeIO(fileOutputStream);
                        return z10;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        closeIO(fileOutputStream2);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
                closeIO(fileOutputStream);
                return z10;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean unZipFolder(String str, String str2) throws Exception {
        if (!new File(str).exists()) {
            return false;
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else {
                    File file = new File(str2 + File.separator + name);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            } else {
                zipInputStream.close();
                return true;
            }
        }
    }

    public static InputStream upZip(String str, String str2) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        return zipFile.getInputStream(zipFile.getEntry(str2));
    }

    public static void writeLine(String str, boolean z10, String str2) {
        if (!ensureFileExists(str)) {
            return;
        }
        PrintWriter printWriter = null;
        try {
            try {
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(str, z10)));
                try {
                    printWriter2.println(str2);
                    closeIO(printWriter2);
                } catch (IOException e2) {
                    e = e2;
                    printWriter = printWriter2;
                    e.printStackTrace();
                    closeIO(printWriter);
                } catch (Throwable th) {
                    th = th;
                    printWriter = printWriter2;
                    closeIO(printWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
    }

    public static void deleteExpiredFile(String str, int i10, FileKeepRule fileKeepRule) {
        File[] listFiles;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    deleteExpiredFile(file2, i10, fileKeepRule);
                }
            }
            deleteExpiredFile(new File(str), i10, fileKeepRule);
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
    }

    public static List<File> getFiles(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            getFiles(str, arrayList);
        }
        return arrayList;
    }

    public static synchronized boolean saveStr2File(String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        synchronized (FileUtils.class) {
            boolean z10 = false;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(str);
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str2.getBytes());
                    fileOutputStream.close();
                    z10 = true;
                } catch (Exception e2) {
                    fileOutputStream2 = fileOutputStream;
                    e = e2;
                    try {
                        LogUtils.e(TAG, "saveStrToFile ", e);
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "saveStrToFile " + LogUtils.getStackTraceMessage(e), "");
                        e.printStackTrace();
                        fileOutputStream = fileOutputStream2;
                        closeIO(fileOutputStream);
                        return z10;
                    } catch (Throwable th2) {
                        th = th2;
                        closeIO(fileOutputStream2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    closeIO(fileOutputStream2);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
            } catch (Throwable th4) {
                th = th4;
            }
            closeIO(fileOutputStream);
            return z10;
        }
    }

    public static synchronized String getStrFromFile(File file) {
        synchronized (FileUtils.class) {
            StringBuilder sb2 = new StringBuilder();
            FileInputStream fileInputStream = null;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (!file.exists()) {
                closeIO(null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream2, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                }
                bufferedReader.close();
                inputStreamReader.close();
                closeIO(fileInputStream2);
            } catch (Exception e10) {
                e = e10;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                closeIO(fileInputStream);
                return sb2.toString();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                closeIO(fileInputStream);
                throw th;
            }
            return sb2.toString();
        }
    }
}
