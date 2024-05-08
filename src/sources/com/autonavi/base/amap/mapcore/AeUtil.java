package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.col.p0003l.du;
import com.amap.api.col.p0003l.dv;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.dy;
import com.amap.api.col.p0003l.dz;
import com.amap.api.col.p0003l.fu;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.ha;
import com.amap.api.col.p0003l.je;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.config.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AeUtil {
    private static final String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    private static final String AMAP_INTERSECTION_ASSETS_DIR = "VM3DRes";
    public static final String AMAP_RESZIP_TARGET_DIR_NAME = "res920";
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    private static String global_db_path;

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.getName().contains(AMAP_GLOBAL_DB_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String formatFileSeparator(String str) {
        return str != null ? str.replace("//", "/") : str;
    }

    private static String getAssetsGlobalDbMd5(Context context) {
        return new String(FileUtil.readFileContentsFromAssets(context, AMAP_ASSETS_DB_CK_PATH));
    }

    public static String getGlobalDbPath() {
        return global_db_path;
    }

    public static void initCrashHandle(Context context) {
        fu a10;
        try {
            if (!ha.a(dx.a()).a(context) || (a10 = dx.a()) == null) {
                return;
            }
            MsgProcessor.nativeInitInfo(context, ha.a(a10).b(context), a10.a(), a10.b(), a10.c(), a10.f());
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    public static void initIntersectionRes(final Context context, final GLMapEngine.InitParam initParam) {
        String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/VM3DRes/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        initParam.mIntersectionResPath = str;
        initParam.mIntersectionResPath = formatFileSeparator(str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                dv.a().a(new je() { // from class: com.autonavi.base.amap.mapcore.AeUtil.2
                    @Override // com.amap.api.col.p0003l.je
                    public void runTask() {
                        AeUtil.loadAndSaveIntersectionRes("map_assets/VM3DRes", GLMapEngine.InitParam.this.mIntersectionResPath, context);
                    }
                });
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/data_v6/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                dv.a().a(new je() { // from class: com.autonavi.base.amap.mapcore.AeUtil.1
                    @Override // com.amap.api.col.p0003l.je
                    public void runTask() {
                        AeUtil.loadEngineRes(String.this, context);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                String str2 = new String(readFileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str2;
                if (!str2.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                du.c(context, "initConfig error:" + th.getMessage());
            }
        }
        String str3 = str + "/map/";
        initParam.mOfflineDataPath = str3;
        initParam.mP3dCrossPath = str;
        initParam.mOfflineDataPath = formatFileSeparator(str3);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadAndSaveIntersectionRes(String str, String str2, Context context) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                readAssetsFileAndSave(str + "/" + str3, new File(str2, str3).getAbsolutePath(), context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(1:53)(1:5)|6|(6:8|(1:10)|(1:13)|14|15|(6:23|24|(1:26)|27|29|(2:19|20)(1:22))(2:17|(0)(0)))|50|(0)|14|15|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r8.equals(r10) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ba, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ba -> B:26:0x00da). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void loadEngineRes(java.lang.String r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "loadEngineRes error:"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "res920"
            r1.<init>(r10, r2)
            boolean r10 = r1.exists()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r10 == 0) goto L18
            boolean r10 = r1.isDirectory()
            if (r10 != 0) goto L24
        L18:
            boolean r10 = r1.mkdirs()
            if (r10 == 0) goto L24
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            r5 = 1
            goto L26
        L24:
            r10 = r4
            r5 = 0
        L26:
            java.lang.String r6 = "amap_res_global_db_md5"
            java.lang.String r7 = "amap_res_global_db"
            if (r5 != 0) goto L43
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            java.lang.String r8 = ""
            java.lang.String r8 = com.amap.api.col.p0003l.dn.a(r11, r7, r6, r8)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L44
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L43
            goto L44
        L43:
            r2 = r5
        L44:
            if (r2 == 0) goto L47
            goto L4b
        L47:
            boolean r3 = checkEngineRes(r1)
        L4b:
            java.lang.String r5 = "/global.db"
            if (r3 != 0) goto Lc9
            android.content.res.AssetManager r3 = r11.getAssets()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.String r8 = "ae/res.zip"
            java.io.InputStream r4 = r3.open(r8)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.String r3 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            com.autonavi.base.amap.mapcore.FileUtil.decompress(r4, r3)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            r3.append(r1)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            r3.append(r5)     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r1     // Catch: java.lang.Throwable -> L77 java.lang.OutOfMemoryError -> L79 java.lang.Exception -> L99
            if (r4 == 0) goto Lda
            r4.close()     // Catch: java.io.IOException -> Lb9
            goto Lda
        L77:
            r10 = move-exception
            goto Lbe
        L79:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.dx.a(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.du.c(r11, r0)     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto Lda
            r4.close()     // Catch: java.io.IOException -> Lb9
            goto Lda
        L99:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.dx.a(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L77
            r3.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L77
            com.amap.api.col.p0003l.du.c(r11, r0)     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto Lda
            r4.close()     // Catch: java.io.IOException -> Lb9
            goto Lda
        Lb9:
            r0 = move-exception
            r0.printStackTrace()
            goto Lda
        Lbe:
            if (r4 == 0) goto Lc8
            r4.close()     // Catch: java.io.IOException -> Lc4
            goto Lc8
        Lc4:
            r11 = move-exception
            r11.printStackTrace()
        Lc8:
            throw r10
        Lc9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r0
        Lda:
            if (r2 == 0) goto Ldf
            com.amap.api.col.p0003l.dn.a(r11, r7, r6, r10)
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.loadEngineRes(java.lang.String, android.content.Context):void");
    }

    public static boolean loadLib(Context context) {
        try {
            if (!a.f9686b) {
                System.loadLibrary(a.f9685a);
                a.f9686b = true;
            }
            return true;
        } catch (Throwable th) {
            gy.b(th, "AeUtil", "loadLib");
            dx.a(th);
            dz.b(dy.f5397c, "load so failed " + th.getMessage());
            return false;
        }
    }

    public static void readAssetsFileAndSave(String str, String str2, Context context) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fileOutputStream2 = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                inputStream = open;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr, 0, 1024);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                open.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable th2) {
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }
}
