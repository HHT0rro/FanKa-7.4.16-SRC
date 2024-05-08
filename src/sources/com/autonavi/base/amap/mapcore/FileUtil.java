package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.dy;
import com.amap.api.col.p0003l.dz;
import com.amap.api.col.p0003l.gy;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ZipCompressProgressListener {
        void onFinishProgress(long j10);
    }

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(String str, String str2) {
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes(str2));
                    gZIPOutputStream2.close();
                    safelyCloseFile(gZIPOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.getMessage();
                    safelyCloseFile(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safelyCloseFile(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0L, null);
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j10, long j11, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i10 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                    bufferedOutputStream.close();
                    return i10;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i10 += read;
                if (j11 > 0 && zipCompressProgressListener != null) {
                    long j12 = ((i10 + j10) * 100) / j11;
                    if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                        zipCompressProgressListener.onFinishProgress(j12);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i10;
            }
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i10 = 0; i10 < listFiles.length; i10++) {
                if (listFiles[i10].isFile()) {
                    if (!listFiles[i10].delete()) {
                        return false;
                    }
                } else {
                    if (!deleteFile(listFiles[i10])) {
                        return false;
                    }
                    listFiles[i10].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        fileProber(parentFile);
        parentFile.mkdir();
    }

    public static String getExternalStroragePath(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDir("").getAbsolutePath() + File.separatorChar;
    }

    public static String getMapBaseStorage(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        String str2 = MapsInitializer.sdcardDir;
        if (str2 != null && str2.trim().length() > 0) {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        } else {
            String string = sharedPreferences.getString("map_base_path_v44", "");
            String externalStroragePath = getExternalStroragePath(context);
            if (string == null || string.contains(externalStroragePath)) {
                str = string;
            }
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str3 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        String str4 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("map_base_path_v44", str4);
                edit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        String str5 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file4 = new File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            file4.isDirectory();
        }
        return str5;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (isGzip(bArr)) {
            return new GZIPInputStream(byteArrayInputStream);
        }
        return new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains(FILE_PATH_ENTRY_SEPARATOR1) || str.contains(FILE_PATH_ENTRY_SEPARATOR2)) ? false : true;
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (IOException e2) {
                    throw e2;
                }
            } finally {
                safelyCloseFile(byteArrayOutputStream);
            }
        }
    }

    public static byte[] readFileContents(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                safelyCloseFile((OutputStream) null);
                safelyCloseFile((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            gy.b(th, "FileUtil", "readFileContents");
                            dx.a(th);
                            dz.b(dy.f5400f, "read file from disk failed " + th.getMessage());
                            return null;
                        } finally {
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] readFileContentsFromAssets(Context context, String str) {
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        ?? r12 = 0;
        try {
            try {
                inputStream = assets.open(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            } catch (OutOfMemoryError e10) {
                e = e10;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                safelyCloseFile((InputStream) r12);
                throw th;
            }
            try {
                int available = inputStream.available();
                if (available == 0) {
                    safelyCloseFile(inputStream);
                    return null;
                }
                byte[] bArr = new byte[available];
                for (int i10 = 0; i10 < available; i10 += inputStream.read(bArr, i10, available - i10)) {
                }
                safelyCloseFile(inputStream);
                return bArr;
            } catch (IOException e11) {
                e = e11;
                dz.b(dy.f5400f, "read file from assets failed " + e.getMessage());
                safelyCloseFile(inputStream);
                return null;
            } catch (OutOfMemoryError e12) {
                e = e12;
                dz.b(dy.f5400f, "read file from assets failed " + e.getMessage());
                safelyCloseFile(inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            r12 = assets;
            safelyCloseFile((InputStream) r12);
            throw th;
        }
    }

    public static byte[] readFileContentsFromAssetsByPreName(Context context, String str, String str2) {
        if (context != null && str != null && str2 != null) {
            try {
                String[] list = context.getAssets().list(str);
                if (list == null) {
                    return null;
                }
                for (String str3 : list) {
                    if (str3 != null && str3.contains(str2)) {
                        return readFileContentsFromAssets(context, str + "/" + str3);
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void saveFileContents(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            safelyCloseFile(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                gy.b(th, "FileUtil", "saveFileContents");
                dx.a(th);
                dz.b(dy.f5400f, "save file from disk failed " + th.getMessage());
            } finally {
                safelyCloseFile(fileOutputStream2);
            }
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        InputStream inputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.getMessage();
                        return null;
                    } finally {
                        safelyCloseFile(inputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        return null;
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream inputStream;
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            if (inputStream instanceof ZipInputStream) {
                str = ((ZipInputStream) inputStream).getNextEntry().getName();
                if (!isSafeEntryName(str)) {
                    "gzip name contains ../ ".concat(String.valueOf(str));
                    return null;
                }
            } else {
                str = "";
            }
            if (inputStream != null) {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = inputStream.read(bArr2);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        return new Pair<>(str, byteArrayOutputStream.toByteArray());
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.getMessage();
                return null;
            } finally {
                safelyCloseFile(inputStream);
            }
        }
        return null;
    }

    public static byte[] uncompressToByteArray(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                dx.a(th);
                th.printStackTrace();
                return null;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
    }

    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] bArr, String[] strArr) {
        InputStream zipInputStream;
        HashMap hashMap = new HashMap();
        if (bArr == null || bArr.length == 0) {
            return hashMap;
        }
        InputStream inputStream = null;
        try {
            zipInputStream = getZipInputStream(bArr);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (zipInputStream instanceof ZipInputStream) {
                ZipInputStream zipInputStream2 = (ZipInputStream) zipInputStream;
                while (true) {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        try {
                            String name = nextEntry.getName();
                            if (!isSafeEntryName(name)) {
                                "gzip name contains ../ ".concat(String.valueOf(name));
                                safelyCloseFile(zipInputStream);
                                return null;
                            }
                            if (strArr == null) {
                                byte[] readByteByStream = readByteByStream(zipInputStream2);
                                if (readByteByStream != null) {
                                    hashMap.put(name, readByteByStream);
                                }
                            } else {
                                int length = strArr.length;
                                int i10 = 0;
                                while (true) {
                                    if (i10 < length) {
                                        String str = strArr[i10];
                                        if (name.equals(str)) {
                                            byte[] readByteByStream2 = readByteByStream(zipInputStream2);
                                            if (readByteByStream2 != null) {
                                                hashMap.put(str, readByteByStream2);
                                            }
                                        } else {
                                            i10++;
                                        }
                                    }
                                }
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    zipInputStream2.closeEntry();
                }
            }
            safelyCloseFile(zipInputStream);
        } catch (Throwable th2) {
            th = th2;
            inputStream = zipInputStream;
            try {
                th.getMessage();
                return hashMap;
            } finally {
                safelyCloseFile(inputStream);
            }
        }
        return hashMap;
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                try {
                    if (bArr.length != 0) {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream2);
                            return;
                        } catch (Exception e2) {
                            fileOutputStream = fileOutputStream2;
                            e = e2;
                            e.printStackTrace();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            return;
                        } catch (Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
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
        writeLock.unlock();
        safelyCloseFile((OutputStream) null);
    }

    private static void decompress(InputStream inputStream, String str, long j10, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j10, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static String uncompressToString(byte[] bArr, String str) {
        InputStream inputStream;
        ?? r02 = 0;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                inputStream = getZipInputStream(bArr);
                if (inputStream != null) {
                    try {
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = inputStream.read(bArr2);
                            if (read >= 0) {
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } else {
                                String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                                safelyCloseFile(inputStream);
                                return byteArrayOutputStream2;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.getMessage();
                        safelyCloseFile(inputStream);
                        return null;
                    }
                }
            } catch (IOException e10) {
                e = e10;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                safelyCloseFile((InputStream) r02);
                throw th;
            }
            safelyCloseFile(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            r02 = bArr;
            safelyCloseFile((InputStream) r02);
            throw th;
        }
    }

    private static void safelyCloseFile(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j10, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                zipInputStream.closeEntry();
                return;
            }
            String name = nextEntry.getName();
            if (TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                break;
            }
            File file3 = new File(file2.getPath() + File.separator + name);
            fileProber(file3);
            if (nextEntry.isDirectory()) {
                file3.mkdirs();
            } else {
                i10 += decompressFile(file3, zipInputStream, i10, j10, zipCompressProgressListener, unZipFileBrake);
            }
            zipInputStream.closeEntry();
        }
        z10 = true;
        if (!z10 || file == null) {
            return;
        }
        try {
            file.delete();
        } catch (Exception unused) {
        }
    }

    public static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.close();
                    safelyCloseFile(gZIPOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream = gZIPOutputStream2;
                    e.getMessage();
                    safelyCloseFile(gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safelyCloseFile(gZIPOutputStream);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
