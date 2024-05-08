package com.alibaba.security.common.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import com.huawei.openalliance.ad.constant.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FileUtils {
    private static final String RPSDK_PARENT_FILE_DIR = "/realidentity";
    private static final String TAG = "FileUtils";

    public static boolean copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                        return true;
                    } catch (Exception unused3) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException unused7) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused8) {
                    fileOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                }
            }
        } catch (Exception unused9) {
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        return false;
    }

    public static boolean copyAssetData(Context context, String str, String str2) {
        byte[] assetsData = getAssetsData(context, str);
        if (assetsData == null) {
            return false;
        }
        return save(str2, assetsData);
    }

    public static void copyAssetResource2File(Context context, String str, File file) throws IOException {
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                file.setReadable(true);
                return;
            }
        }
    }

    public static boolean create(String str) throws Exception {
        return new File(str).createNewFile();
    }

    public static void delete(String str) {
        try {
            new File(str).delete();
        } catch (Exception unused) {
        }
    }

    private static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x000f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0014, code lost:
    
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getAssetsData(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L13
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L13
            byte[] r0 = input2byte(r1)     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L17
        Lf:
            r1.close()     // Catch: java.io.IOException -> L17
            goto L17
        L13:
            r1 = r0
        L14:
            if (r1 == 0) goto L17
            goto Lf
        L17:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.utils.FileUtils.getAssetsData(android.content.Context, java.lang.String):byte[]");
    }

    public static String getCacheDir(Context context, String str, String str2) {
        StringBuilder sb2;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            sb2 = new StringBuilder();
            sb2.append(externalCacheDir.getAbsolutePath());
            sb2.append(File.separator);
        } else {
            sb2 = null;
        }
        if (TextUtils.isEmpty(str) || sb2 == null) {
            return null;
        }
        sb2.append(str);
        sb2.append(File.separator);
        sb2.append(str2);
        return sb2.toString();
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        String[] strArr2 = {"_data"};
        try {
            cursor = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (cursor == null) {
                return null;
            }
            try {
                if (cursor.moveToFirst()) {
                    return cursor.getString(cursor.getColumnIndexOrThrow(strArr2[0]));
                }
                return null;
            } catch (Exception unused) {
                if (cursor == null) {
                    return null;
                }
                cursor.close();
                return null;
            }
        } catch (Exception unused2) {
            cursor = null;
        }
    }

    public static long getFileSize(String str) {
        try {
            return getFileSize(new File(str));
        } catch (Exception e2) {
            RPLogging.e("FileUtils", e2.getLocalizedMessage());
            return 0L;
        }
    }

    public static String getRealPathFromUri(Context context, Uri uri) {
        return getRealPathFromUriAboveApi19(context, uri);
    }

    private static String getRealPathFromUriAboveApi19(Context context, Uri uri) {
        String dataColumn;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (isMediaDocument(uri)) {
                dataColumn = getDataColumn(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(u.bD)[1]});
            } else {
                if (!isDownloadsDocument(uri)) {
                    return null;
                }
                dataColumn = getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
            }
            return dataColumn;
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static String getRealPathFromUriBelowAPI19(Context context, Uri uri) {
        return getDataColumn(context, uri, null, null);
    }

    public static String getSaveDir(Context context) {
        return context.getFilesDir().getAbsolutePath() + RPSDK_PARENT_FILE_DIR;
    }

    public static byte[] input2byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 100);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExist(String str) {
        return new File(str).exists();
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readStrFromFile(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            r1 = 0
            if (r11 == 0) goto L33
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            r11.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            java.io.InputStream r9 = r9.open(r10)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
        L1f:
            java.lang.String r0 = r10.readLine()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r0 == 0) goto L29
            r11.append(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            goto L1f
        L29:
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            goto L59
        L2e:
            r10 = move-exception
            goto L70
        L30:
            r10 = r9
            r9 = r1
            goto L7f
        L33:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L7d
            java.nio.channels.FileChannel r2 = r9.getChannel()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            r4 = 0
            long r6 = r2.size()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.MappedByteBuffer r10 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r11 = "utf-8"
            java.nio.charset.Charset r11 = java.nio.charset.Charset.forName(r11)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.CharBuffer r10 = r11.decode(r10)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            r8 = r1
            r1 = r9
            r9 = r8
        L59:
            if (r1 == 0) goto L60
            r1.close()     // Catch: java.io.IOException -> L5f
            goto L60
        L5f:
        L60:
            if (r9 == 0) goto L65
            r9.close()     // Catch: java.io.IOException -> L65
        L65:
            r1 = r10
            goto L8b
        L67:
            r10 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
            goto L70
        L6c:
            r10 = r1
            goto L7f
        L6e:
            r10 = move-exception
            r9 = r1
        L70:
            if (r1 == 0) goto L77
            r1.close()     // Catch: java.io.IOException -> L76
            goto L77
        L76:
        L77:
            if (r9 == 0) goto L7c
            r9.close()     // Catch: java.io.IOException -> L7c
        L7c:
            throw r10
        L7d:
            r9 = r1
            r10 = r9
        L7f:
            if (r9 == 0) goto L86
            r9.close()     // Catch: java.io.IOException -> L85
            goto L86
        L85:
        L86:
            if (r10 == 0) goto L8b
            r10.close()     // Catch: java.io.IOException -> L8b
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.utils.FileUtils.readStrFromFile(android.content.Context, java.lang.String, boolean):java.lang.String");
    }

    public static synchronized boolean save(String str, byte[] bArr) {
        boolean save;
        synchronized (FileUtils.class) {
            save = save(new File(str), bArr);
        }
        return save;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0048 -> B:24:0x007d). Please report as a decompilation issue!!! */
    public static boolean saveBytes2File(String str, byte[] bArr, String str2) {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream = null;
        boolean z10 = false;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str2);
                if (file2.exists()) {
                    file2.delete();
                }
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream2.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr2, 0, read);
                    }
                    fileOutputStream.flush();
                    z10 = true;
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        RPLogging.e("FileUtils", "saveBytes2File got error " + th.getMessage(), th);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return z10;
                    } finally {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return z10;
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return deleteDir(file);
        }
        return deleteFile(file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
    
        if (r3 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean save(java.io.File r4, byte[] r5) {
        /*
            java.lang.Class<com.alibaba.security.common.utils.FileUtils> r0 = com.alibaba.security.common.utils.FileUtils.class
            monitor-enter(r0)
            r1 = 0
            if (r4 == 0) goto L4b
            if (r5 == 0) goto L4b
            r4.mkdirs()     // Catch: java.lang.Throwable -> L48
            boolean r2 = r4.exists()     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L15
            r4.delete()     // Catch: java.lang.Throwable -> L48
            goto L22
        L15:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L19
            goto L22
        L19:
            r2 = move-exception
            java.lang.String r3 = "FileUtils"
            com.alibaba.security.common.log.RPLogging.e(r3, r2)     // Catch: java.lang.Throwable -> L48
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L48
        L22:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3d
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L3e
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3e
            r4.write(r5)     // Catch: java.lang.Throwable -> L3b
            r4.flush()     // Catch: java.lang.Throwable -> L3b
            r1 = 1
            r4.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L48
        L37:
            r3.close()     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b
            goto L4b
        L3b:
            r2 = r4
            goto L3e
        L3d:
            r3 = r2
        L3e:
            if (r2 == 0) goto L45
            r2.close()     // Catch: java.io.IOException -> L44 java.lang.Throwable -> L48
            goto L45
        L44:
        L45:
            if (r3 == 0) goto L4b
            goto L37
        L48:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L4b:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.utils.FileUtils.save(java.io.File, byte[]):boolean");
    }

    public static long getFileSize(File file) {
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        long available = fileInputStream2.available();
                        try {
                            fileInputStream2.close();
                            return available;
                        } catch (IOException e2) {
                            RPLogging.e("FileUtils", e2);
                            return available;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        RPLogging.e("FileUtils", e.getLocalizedMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                RPLogging.e("FileUtils", e11);
                            }
                        }
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e12) {
                                RPLogging.e("FileUtils", e12);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return 0L;
    }
}
