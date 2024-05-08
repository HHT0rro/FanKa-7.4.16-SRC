package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.ml.scan.HmsScanFrameOptions;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.c5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ScanUtil {
    public static final int CAMERA_INIT_ERROR = -1000;
    public static final String CONTEXT_METHOD = "initializeModule";
    public static final String CONTEXT_PATH = "com.huawei.hms.feature.DynamicModuleInitializer";
    public static final String CREATOR_PATH = "com.huawei.hms.scankit.Creator";
    public static final int ERROR_ABNORMAL_RESTART = 3;
    public static final int ERROR_INVALID_PARAM = 4;
    public static final int ERROR_NO_CAMERA_PERMISSION = 1;
    public static final int ERROR_NO_READ_PERMISSION = 2;
    private static final int LITE_VERSION = 10320300;
    private static final int MAX_BITMAP_SIZE = 52428800;
    public static final String MODULE_SCANKIT = "huawei_module_scankit";
    public static final String MODULE_SCANKIT_LOCAL = "huawei_module_scankit_local";
    private static final int NEW_VERSION = 21002300;
    public static final String RESULT = "SCAN_RESULT";
    public static final String RESULT_CODE = "SCAN_RESULT_CODE";
    public static final int SCAN_NO_DETECTED = 4096;
    public static final int SUCCESS = 0;
    private static final int WR_VERSION = 20100300;

    public static Bitmap buildBitmap(String str, int i10, int i11, int i12, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        return new c5().a(str, i10, i11, i12, hmsBuildBitmapOption);
    }

    private static HmsScanResult checkHmsScan(HmsScan[] hmsScanArr, HmsScanFrameOptions hmsScanFrameOptions) {
        if (hmsScanArr.length == 0) {
            return new HmsScanResult(4096, null);
        }
        if (hmsScanArr[0].getOriginalValue() == "" && hmsScanArr[0].getZoomValue() > 1.0d) {
            return new HmsScanResult(4098, hmsScanArr);
        }
        if (hmsScanArr[0].getOriginalValue() != "") {
            return new HmsScanResult(0, hmsScanArr);
        }
        return new HmsScanResult(4096, hmsScanArr);
    }

    private static boolean checkVersion(int i10, int i11) {
        if (i10 == LITE_VERSION && (i11 < NEW_VERSION || i11 == WR_VERSION)) {
            return true;
        }
        if (i10 != LITE_VERSION) {
            return i10 < NEW_VERSION || i10 == WR_VERSION || i11 < NEW_VERSION;
        }
        return false;
    }

    public static Bitmap compressBitmap(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        dealBitmapFactoryOption(context, options);
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x008e: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:42:0x008e */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[Catch: Exception -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0078, blocks: (B:25:0x005c, B:23:0x0068, B:14:0x0074), top: B:3:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap compressBitmapForAndroid29(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "_id"
            java.lang.String r1 = "Exception"
            java.lang.String r2 = "exception"
            r3 = 1
            r4 = 0
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            java.lang.String r8 = "_data=?"
            java.lang.String[] r9 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            r10 = 0
            r9[r10] = r12     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            r10 = 0
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.NullPointerException -> L6c
            if (r5 == 0) goto L3a
            boolean r6 = r5.moveToFirst()     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            if (r6 == 0) goto L3a
            int r12 = r5.getColumnIndex(r0)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            int r12 = r5.getInt(r12)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            android.net.Uri r12 = android.net.Uri.withAppendedPath(r0, r12)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
        L38:
            r4 = r12
            goto L5a
        L3a:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            r0.<init>(r12)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            boolean r0 = r0.exists()     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            if (r0 == 0) goto L5a
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            r0.<init>()     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            java.lang.String r6 = "_data"
            r0.put(r6, r12)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            android.content.ContentResolver r12 = r11.getContentResolver()     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            android.net.Uri r12 = r12.insert(r6, r0)     // Catch: java.lang.Exception -> L63 java.lang.NullPointerException -> L6d java.lang.Throwable -> L8d
            goto L38
        L5a:
            if (r5 == 0) goto L7b
            r5.close()     // Catch: java.lang.Exception -> L78
            goto L7b
        L60:
            r11 = move-exception
            goto L8f
        L62:
            r5 = r4
        L63:
            com.huawei.hms.scankit.p.o4.b(r2, r1)     // Catch: java.lang.Throwable -> L8d
            if (r5 == 0) goto L7b
            r5.close()     // Catch: java.lang.Exception -> L78
            goto L7b
        L6c:
            r5 = r4
        L6d:
            java.lang.String r12 = "NullPointerException"
            com.huawei.hms.scankit.p.o4.b(r2, r12)     // Catch: java.lang.Throwable -> L8d
            if (r5 == 0) goto L7b
            r5.close()     // Catch: java.lang.Exception -> L78
            goto L7b
        L78:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
        L7b:
            android.graphics.BitmapFactory$Options r12 = new android.graphics.BitmapFactory$Options
            r12.<init>()
            r12.inJustDecodeBounds = r3
            getBitmapFromUri(r11, r4, r12)
            dealBitmapFactoryOption(r11, r12)
            android.graphics.Bitmap r11 = getBitmapFromUri(r11, r4, r12)
            return r11
        L8d:
            r11 = move-exception
            r4 = r5
        L8f:
            if (r4 == 0) goto L98
            r4.close()     // Catch: java.lang.Exception -> L95
            goto L98
        L95:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
        L98:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.compressBitmapForAndroid29(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void dealBitmapFactoryOption(android.content.Context r10, android.graphics.BitmapFactory.Options r11) {
        /*
            java.lang.String r0 = "exception"
            int r1 = r11.outWidth
            int r2 = r11.outHeight
            if (r1 == 0) goto L65
            if (r2 != 0) goto Lb
            goto L65
        Lb:
            if (r1 <= r2) goto Le
            r1 = r2
        Le:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L46
            java.lang.String r2 = "activity"
            java.lang.Object r10 = r10.getSystemService(r2)     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            android.app.ActivityManager r10 = (android.app.ActivityManager) r10     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            r2.<init>()     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            r10.getMemoryInfo(r2)     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            r6 = 4652218415073722368(0x4090000000000000, double:1024.0)
            r8 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r6 = java.lang.Math.pow(r6, r8)     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            long r2 = r2.totalMem     // Catch: java.lang.Exception -> L3b java.lang.NullPointerException -> L41
            double r2 = (double) r2
            double r2 = r2 / r6
            r6 = 4617878467915022336(0x4016000000000000, double:5.5)
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 >= 0) goto L39
            goto L46
        L39:
            r10 = 0
            goto L47
        L3b:
            java.lang.String r10 = "Exception"
            com.huawei.hms.scankit.p.o4.b(r0, r10)
            goto L46
        L41:
            java.lang.String r10 = "NullPointerException"
            com.huawei.hms.scankit.p.o4.b(r0, r10)
        L46:
            r10 = 1
        L47:
            if (r10 == 0) goto L4c
            r10 = 1200(0x4b0, float:1.682E-42)
            goto L4e
        L4c:
            r10 = 3000(0xbb8, float:4.204E-42)
        L4e:
            if (r1 <= r10) goto L58
            float r0 = (float) r1
            float r10 = (float) r10
            float r0 = r0 / r10
            int r10 = java.lang.Math.round(r0)
            goto L59
        L58:
            r10 = 1
        L59:
            r11.inSampleSize = r10
            r11.inJustDecodeBounds = r4
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            r11.inPreferredConfig = r10
            r11.inPurgeable = r5
            r11.inInputShareable = r5
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.dealBitmapFactoryOption(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }

    public static HmsScanResult decode(Context context, HmsScanFrame hmsScanFrame, HmsScanFrameOptions hmsScanFrameOptions) {
        HmsScanAnalyzerOptions create;
        if (hmsScanFrame != null && (hmsScanFrame.getYuvImage() != null || hmsScanFrame.getBitmap() != null)) {
            o4.d("Scankit", "frame height " + hmsScanFrame.getHeight() + " width " + hmsScanFrame.getWidth());
            if (hmsScanFrame.getHeight() * hmsScanFrame.getHeight() <= 52428800 && hmsScanFrame.getHeight() * hmsScanFrame.getHeight() != 0) {
                try {
                    if (g.f30319d == Integer.MIN_VALUE) {
                        g.f30319d = g.a(context);
                    }
                    if (g.f30320e == Integer.MIN_VALUE) {
                        g.f30320e = DynamicModule.getRemoteVersion(context.getApplicationContext(), MODULE_SCANKIT);
                    }
                } catch (Exception unused) {
                    o4.b("Scankit", "get remote version failed");
                }
                if (hmsScanFrameOptions != null && hmsScanFrameOptions.isMultiMode()) {
                    HmsScan[] a10 = b.a(context, hmsScanFrame, new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(hmsScanFrameOptions.getType(), new int[0]).setPhotoMode(hmsScanFrameOptions.isPhotoMode()).setParseResult(hmsScanFrameOptions.isParseResult()).create());
                    if (a10.length == 0) {
                        return new HmsScanResult(4096, a10);
                    }
                    if (a10.length == 1 && a10[0].getZoomValue() > 1.0d && TextUtils.isEmpty(a10[0].getOriginalValue())) {
                        return new HmsScanResult(4098, a10);
                    }
                    if (a10.length >= 1 && !TextUtils.isEmpty(a10[0].getOriginalValue())) {
                        return new HmsScanResult(0, a10);
                    }
                    return new HmsScanResult(4096, a10);
                }
                if (hmsScanFrameOptions == null) {
                    create = new HmsScanAnalyzerOptions.Creator().create();
                } else {
                    create = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(hmsScanFrameOptions.getType(), new int[0]).setPhotoMode(hmsScanFrameOptions.isPhotoMode()).setParseResult(hmsScanFrameOptions.isParseResult()).create();
                }
                if (hmsScanFrame.getBitmap() != null) {
                    return checkHmsScan(f.a(context, hmsScanFrame.getBitmap(), create), hmsScanFrameOptions);
                }
                if (hmsScanFrame.getYuvImage() != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("local version ");
                    sb2.append(g.f30319d);
                    sb2.append(" remote version");
                    sb2.append(g.f30320e);
                    if (checkVersion(g.f30319d, g.f30320e)) {
                        return f.a(context, hmsScanFrame, create);
                    }
                    return f.a(context, hmsScanFrame.getYuvImage().getYuvData(), hmsScanFrame.getYuvImage().getWidth(), hmsScanFrame.getYuvImage().getHeight(), create);
                }
                return new HmsScanResult(4, new HmsScan[0]);
            }
            o4.e("ScanUtil", "input image is invalid:" + hmsScanFrame.getWidth() + " " + hmsScanFrame.getHeight());
            return new HmsScanResult(4, new HmsScan[0]);
        }
        return new HmsScanResult(4, new HmsScan[0]);
    }

    public static HmsScan[] decodeWithBitmap(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        if (bitmap != null && bitmap.getWidth() * bitmap.getHeight() <= 52428800) {
            return f.a(context, bitmap, hmsScanAnalyzerOptions);
        }
        if (bitmap != null) {
            o4.e("ScanUtil", "input image is too large:" + bitmap.getWidth());
        }
        return new HmsScan[0];
    }

    public static HmsScan[] detectForHmsDector(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return b.a(context, mLFrame, hmsScanAnalyzerOptions);
    }

    private static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            o4.a("ScanBitmap", "uri == null");
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, t.f36226k);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (FileNotFoundException unused) {
            o4.b("exception", "FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            o4.b("exception", "IOException");
            return null;
        } catch (Exception unused3) {
            o4.b("exception", "Exception");
            return null;
        }
    }

    public static boolean isScanAvailable(Context context) {
        return true;
    }

    public static boolean selfPermissionGranted(Context context, int i10, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (i10 >= 23) {
            if (w7.a(str) == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
        } else if (w7.a(context, str) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int startScan(android.app.Activity r5, int r6, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r7) {
        /*
            java.lang.String r0 = "exception"
            java.lang.String r1 = "ScanUtil"
            java.lang.String r2 = "startScan before"
            com.huawei.hms.scankit.p.o4.d(r1, r2)
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            java.lang.String r3 = r5.getPackageName()     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            r4 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r4)     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            int r0 = r2.targetSdkVersion     // Catch: java.lang.RuntimeException -> L1c android.content.pm.PackageManager.NameNotFoundException -> L22
            goto L29
        L1c:
            java.lang.String r2 = "RuntimeException"
            com.huawei.hms.scankit.p.o4.b(r0, r2)
            goto L27
        L22:
            java.lang.String r2 = "NameNotFoundException"
            com.huawei.hms.scankit.p.o4.b(r0, r2)
        L27:
            r0 = 28
        L29:
            java.lang.String r2 = "android.permission.CAMERA"
            boolean r0 = selfPermissionGranted(r5, r0, r2)
            boolean r2 = com.huawei.hms.scankit.p.w7.f31710c
            if (r2 != 0) goto L3a
            java.lang.String r5 = "startScan failed"
            com.huawei.hms.scankit.p.o4.d(r1, r5)
            r5 = 3
            return r5
        L3a:
            if (r0 != 0) goto L45
            if (r7 == 0) goto L43
            boolean r0 = r7.showGuide
            if (r0 == 0) goto L43
            goto L45
        L43:
            r5 = 1
            return r5
        L45:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.huawei.hms.hmsscankit.ScanKitActivity> r2 = com.huawei.hms.hmsscankit.ScanKitActivity.class
            r0.<init>(r5, r2)
            if (r7 == 0) goto L6a
            int r2 = r7.mode
            java.lang.String r3 = "ScanFormatValue"
            r0.putExtra(r3, r2)
            int r2 = r7.viewType
            java.lang.String r3 = "ScanViewValue"
            r0.putExtra(r3, r2)
            boolean r2 = r7.errorCheck
            java.lang.String r3 = "ScanErrorCheck"
            r0.putExtra(r3, r2)
            boolean r7 = r7.showGuide
            java.lang.String r2 = "ScanGuide"
            r0.putExtra(r2, r7)
        L6a:
            java.lang.String r7 = "startScan success"
            com.huawei.hms.scankit.p.o4.d(r1, r7)
            r7 = 0
            com.huawei.hms.scankit.p.w7.f31710c = r7
            r5.startActivityForResult(r0, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.startScan(android.app.Activity, int, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions):int");
    }
}
