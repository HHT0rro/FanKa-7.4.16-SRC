package com.huawei.hms.scankit.p;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class w7 {

    /* renamed from: a, reason: collision with root package name */
    private static String f31708a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f31709b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f31710c = true;

    public static boolean a(int[][] iArr, int i10) {
        return i10 >= 0 && i10 < iArr.length;
    }

    public static int b(int i10) {
        if (i10 == 8191) {
            return HmsScanBase.ALL_SCAN_TYPE;
        }
        if (i10 == HmsScanBase.QRCODE_SCAN_TYPE) {
            return 256;
        }
        if (i10 == HmsScanBase.AZTEC_SCAN_TYPE) {
            return 4096;
        }
        if (i10 == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
            return 16;
        }
        if (i10 == HmsScanBase.PDF417_SCAN_TYPE) {
            return 2048;
        }
        if (i10 == HmsScanBase.CODE39_SCAN_TYPE) {
            return 2;
        }
        if (i10 == HmsScanBase.CODE93_SCAN_TYPE) {
            return 4;
        }
        if (i10 == HmsScanBase.CODE128_SCAN_TYPE) {
            return 1;
        }
        if (i10 == HmsScanBase.EAN13_SCAN_TYPE) {
            return 32;
        }
        if (i10 == HmsScanBase.EAN8_SCAN_TYPE) {
            return 64;
        }
        if (i10 == HmsScanBase.ITF14_SCAN_TYPE) {
            return 128;
        }
        if (i10 == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
            return 512;
        }
        if (i10 == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return 1024;
        }
        if (i10 == HmsScanBase.CODABAR_SCAN_TYPE) {
            return 8;
        }
        if (i10 == HmsScanBase.WX_SCAN_TYPE) {
            return 16384;
        }
        if (i10 == HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE) {
            return 8192;
        }
        return i10;
    }

    public static boolean c(Context context) {
        if (b(context) && TextUtils.isEmpty(f31709b)) {
            f31709b = context.getSharedPreferences("scanExt", 0).getString("scanExt", "unSet");
        }
        return "forbid".equals(f31709b);
    }

    public static int d(Context context) {
        int identifier;
        if (context.getResources() == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean e() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, "sys.hw_multiwin_for_camera", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean g(Context context) {
        try {
            return "CN".equalsIgnoreCase(SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, com.huawei.openalliance.ad.utils.j.Code, "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 5.5d;
    }

    public static boolean i(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 8.0d && ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels) > 1.3f;
    }

    public static boolean j(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
    }

    public static boolean k(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), a(), 0) == 0;
    }

    public static boolean a(int[] iArr, int i10) {
        return i10 >= 0 && i10 < iArr.length;
    }

    public static boolean f() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals("samsung");
    }

    public static boolean a(byte[] bArr, int i10) {
        return i10 >= 0 && i10 < bArr.length;
    }

    public static boolean e(Context context) {
        String configuration = context.getResources().getConfiguration().toString();
        return configuration.contains("hwMultiwindow-magic") || configuration.contains("hw-magic-windows");
    }

    public static boolean a(byte[][] bArr, int i10) {
        return i10 >= 0 && i10 < bArr.length;
    }

    public static boolean d() {
        return "ar".equals(Locale.getDefault().getLanguage()) || com.huawei.openalliance.ad.constant.u.cF.equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()) || "fa".equals(Locale.getDefault().getLanguage());
    }

    public static boolean a(String[] strArr, int i10) {
        return i10 >= 0 && i10 < strArr.length;
    }

    public static boolean c(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public static boolean a(float[] fArr, int i10) {
        return i10 >= 0 && i10 < fArr.length;
    }

    public static boolean c() {
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("honor");
    }

    public static HmsScan[] a(HmsScan[] hmsScanArr) {
        if (hmsScanArr != null && hmsScanArr.length != 0) {
            for (int i10 = 0; i10 < hmsScanArr.length; i10++) {
                if (hmsScanArr[i10] != null) {
                    hmsScanArr[i10].scanType = b(hmsScanArr[i10].scanType);
                }
            }
        }
        return hmsScanArr;
    }

    public static int a(int i10) {
        if (i10 <= 0) {
            return HmsScanBase.ALL_SCAN_TYPE;
        }
        if (((i10 - 1) & i10) == 0) {
            return i10;
        }
        int i11 = HmsScanBase.AZTEC_SCAN_TYPE;
        int b4 = (i10 & i11) != 0 ? 0 | b(i11) : 0;
        int i12 = HmsScanBase.CODABAR_SCAN_TYPE;
        if ((i10 & i12) != 0) {
            b4 |= b(i12);
        }
        int i13 = HmsScanBase.CODE39_SCAN_TYPE;
        if ((i10 & i13) != 0) {
            b4 |= b(i13);
        }
        int i14 = HmsScanBase.CODE93_SCAN_TYPE;
        if ((i10 & i14) != 0) {
            b4 |= b(i14);
        }
        int i15 = HmsScanBase.CODE128_SCAN_TYPE;
        if ((i10 & i15) != 0) {
            b4 |= b(i15);
        }
        int i16 = HmsScanBase.DATAMATRIX_SCAN_TYPE;
        if ((i10 & i16) != 0) {
            b4 |= b(i16);
        }
        int i17 = HmsScanBase.EAN8_SCAN_TYPE;
        if ((i10 & i17) != 0) {
            b4 |= b(i17);
        }
        int i18 = HmsScanBase.EAN13_SCAN_TYPE;
        if ((i10 & i18) != 0) {
            b4 |= b(i18);
        }
        int i19 = HmsScanBase.QRCODE_SCAN_TYPE;
        if ((i10 & i19) != 0) {
            b4 |= b(i19);
        }
        int i20 = HmsScanBase.ITF14_SCAN_TYPE;
        if ((i10 & i20) != 0) {
            b4 |= b(i20);
        }
        int i21 = HmsScanBase.PDF417_SCAN_TYPE;
        if ((i10 & i21) != 0) {
            b4 |= b(i21);
        }
        int i22 = HmsScanBase.UPCCODE_A_SCAN_TYPE;
        if ((i10 & i22) != 0) {
            b4 |= b(i22);
        }
        int i23 = HmsScanBase.UPCCODE_E_SCAN_TYPE;
        if ((i10 & i23) != 0) {
            b4 |= b(i23);
        }
        int i24 = HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE;
        if ((i10 & i24) != 0) {
            b4 |= b(i24);
        }
        int i25 = HmsScanBase.WX_SCAN_TYPE;
        return (i10 & i25) != 0 ? b4 | b(i25) : b4;
    }

    public static boolean b() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, "sys.multiwin_for_camera", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean b(Activity activity) {
        return a(activity) == 102;
    }

    public static boolean b(Context context) {
        if (TextUtils.isEmpty(f31708a)) {
            try {
                f31708a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("scanExt", "unSet");
            } catch (PackageManager.NameNotFoundException | Exception unused) {
            }
        }
        return "readUri".equals(f31708a);
    }

    private static String b(Context context, Intent intent) {
        Uri data = new Intent(intent).getData();
        if (DocumentsContract.isDocumentUri(context, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(com.huawei.openalliance.ad.constant.u.bD)[1]);
            }
            if (!"com.android.providers.downloads.documents".equals(data.getAuthority())) {
                return null;
            }
            try {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), (String) null);
            } catch (NumberFormatException unused) {
                o4.b("ScankitUtils", "NumberFormatException in withAppendedId");
                return null;
            } catch (Exception unused2) {
                o4.b("ScankitUtils", "Exception in withAppendedId");
                return null;
            }
        }
        if ("content".equalsIgnoreCase(data.getScheme())) {
            return a(context, data, (String) null);
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        return a(bitmap, i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
    }

    public static Bitmap a(Bitmap bitmap, float f10, float f11) {
        if (f10 <= 0.0f || f11 <= 0.0f) {
            return null;
        }
        float f12 = 1.0f / f10;
        float f13 = 1.0f / f11;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = (int) (width * f10);
        int i11 = (int) (height * f11);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i10 * i11];
        for (int i12 = 0; i12 < i11; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                iArr2[(i12 * i10) + i13] = iArr[(((int) (i12 * f13)) * width) + ((int) (i13 * f12))];
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dstPixels:");
        sb2.append(i10);
        sb2.append(" x ");
        sb2.append(i11);
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, i10, 0, 0, i10, i11);
        return createBitmap;
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == -1 ? -1 : 0;
    }

    public static String a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    private static String a() {
        String str = Build.BRAND;
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) ? "navigationbar_is_min" : str.equalsIgnoreCase("XIAOMI") ? "force_fsg_nav_bar" : (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase("OPPO")) ? "navigation_gesture_on" : "navigationbar_is_min";
    }

    public static ResolveInfo a(Intent intent, String str, Activity activity) {
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.isEmpty()) {
            return null;
        }
        return queryIntentActivities.get(0);
    }

    public static boolean a(String str, Activity activity) {
        PackageInfo packageInfo;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            o4.d("Utils", "NameNotFoundException Exception");
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        int i10 = packageInfo.applicationInfo.flags;
        return ((i10 & 1) == 1) || ((i10 & 128) == 1);
    }

    public static int a(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActivityManagerEx");
            Method declaredMethod = cls.getDeclaredMethod("getActivityWindowMode", Activity.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, activity);
            if (invoke == null) {
                return -1;
            }
            return Integer.valueOf(String.valueOf(invoke)).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NumberFormatException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f10) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f10, width / 2, height / 2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!createBitmap.equals(bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i10) {
        if (i10 == 0) {
            return a(bitmap, 90.0f);
        }
        if (i10 != 2) {
            return i10 != 3 ? bitmap : a(bitmap, 180.0f);
        }
        return a(bitmap, 270.0f);
    }

    public static Bitmap a(Context context, Intent intent) {
        Bitmap a10;
        Bitmap compressBitmap;
        if (!b(context)) {
            String b4 = b(context, intent);
            if (TextUtils.isEmpty(b4)) {
                return null;
            }
            if (Build.VERSION.SDK_INT > 28 && context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion > 28) {
                o4.a("ScanBitmap", "compressBitmap above android 29");
                compressBitmap = ScanUtil.compressBitmapForAndroid29(context, b4);
            } else {
                o4.a("ScanBitmap", "compressBitmap below android 29");
                compressBitmap = ScanUtil.compressBitmap(context, b4);
            }
            if (compressBitmap != null) {
                return compressBitmap;
            }
            o4.a("ScanBitmap", "compressBitmap above android 29");
            return ScanUtil.compressBitmapForAndroid29(context, b4);
        }
        Uri data = intent.getData();
        if (data == null || (a10 = a(context, data)) == null) {
            return null;
        }
        return a10;
    }

    private static String a(Context context, Uri uri, String str) {
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, null, null);
            if (query != null) {
                r8 = query.moveToFirst() ? query.getString(query.getColumnIndex("_data")) : null;
                query.close();
            }
            return r8;
        } catch (IllegalStateException unused) {
            o4.b("ScankitUtils", "IllegalStateException in getImagePath");
            return null;
        } catch (Exception unused2) {
            o4.b("ScankitUtils", "Exception in getImagePath");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "IOException in getImagePath"
            java.lang.String r1 = "ScankitUtils"
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3 = 1
            r2.inJustDecodeBounds = r3
            android.content.Context r3 = r7.getApplicationContext()
            android.content.ContentResolver r3 = r3.getContentResolver()
            r4 = 0
            java.io.InputStream r8 = r3.openInputStream(r8)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            if (r8 == 0) goto L37
            byte[] r3 = a(r8)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L40
            int r5 = r3.length     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L40
            r6 = 0
            android.graphics.BitmapFactory.decodeByteArray(r3, r6, r5, r2)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L40
            a(r7, r2)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L40
            int r7 = r3.length     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L40
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r3, r6, r7, r2)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L40
            r8.close()     // Catch: java.io.IOException -> L30
            goto L33
        L30:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L33:
            return r7
        L34:
            r7 = move-exception
            r4 = r8
            goto L4f
        L37:
            if (r8 == 0) goto L4e
            r8.close()     // Catch: java.io.IOException -> L4b
            goto L4e
        L3d:
            r7 = move-exception
            goto L4f
        L3f:
            r8 = r4
        L40:
            java.lang.String r7 = "compressBitmapFromUri IOException"
            com.huawei.hms.scankit.p.o4.b(r1, r7)     // Catch: java.lang.Throwable -> L34
            if (r8 == 0) goto L4e
            r8.close()     // Catch: java.io.IOException -> L4b
            goto L4e
        L4b:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L4e:
            return r4
        L4f:
            if (r4 == 0) goto L58
            r4.close()     // Catch: java.io.IOException -> L55
            goto L58
        L55:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L58:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.content.Context, android.net.Uri):android.graphics.Bitmap");
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r10, android.graphics.BitmapFactory.Options r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }

    public static boolean a(Context context) {
        return b(context) || context.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0;
    }
}
