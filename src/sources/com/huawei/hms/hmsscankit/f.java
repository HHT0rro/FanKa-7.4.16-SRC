package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.material.datepicker.UtcDates;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.s6;
import com.huawei.hms.scankit.p.u6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y3;
import com.huawei.hms.scankit.p.y6;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: RemoteDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile x3 f30312a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile IRemoteDecoderDelegate f30313b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile w3 f30314c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile IRemoteFrameDecoderDelegate f30315d;

    /* compiled from: RemoteDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends SimpleDateFormat {
        public a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        }
    }

    public static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return a(context, bitmap, hmsScanAnalyzerOptions, hmsScanAnalyzerOptions.mode);
    }

    public static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions, int i10) {
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f30313b == null) {
            IRemoteCreator c4 = g.c(context);
            if (c4 == null) {
                return hmsScanArr;
            }
            try {
                f30313b = c4.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("ScankitRemoteDecoder", "RemoteException");
            }
        }
        if (f30313b == null) {
            return hmsScanArr;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, i10);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
            bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f30318c);
            bundle.putBoolean(DetailRect.USE_APK, g.f30316a);
            bundle.putAll(y3.a(context));
            HmsScan[] decodeWithBitmap = f30313b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            a(decodeWithBitmap);
            if (g.a()) {
                o4.d("ScankitRemoteDecoder", "iRemoteDecoderDelegate decodeWithBitmap rollback");
                IRemoteCreator c10 = g.c(context);
                if (c10 == null) {
                    return hmsScanArr;
                }
                try {
                    f30313b = c10.newRemoteDecoderDelegate();
                } catch (RemoteException unused2) {
                    o4.b("ScankitRemoteDecoder", "RemoteException");
                }
                decodeWithBitmap = f30313b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            }
            return decodeWithBitmap != null ? decodeWithBitmap : hmsScanArr;
        } catch (RemoteException unused3) {
            o4.b("ScankitRemoteDecoder", "RemoteException");
            return hmsScanArr;
        }
    }

    public static void a(HmsScan[] hmsScanArr) {
        if (hmsScanArr.length == 1 && a(hmsScanArr[0].getCornerPoints())) {
            g.f30317b = true;
        } else {
            g.f30317b = false;
        }
    }

    public static void a(s6[] s6VarArr) {
        if (s6VarArr.length == 1 && a(s6VarArr[0].j())) {
            g.f30317b = true;
        } else {
            g.f30317b = false;
        }
    }

    private static boolean a(Point[] pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            return false;
        }
        for (Point point : pointArr) {
            if (point.x != -2 && point.y != -2) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(u6[] u6VarArr) {
        if (u6VarArr == null || u6VarArr.length == 0) {
            return false;
        }
        for (u6 u6Var : u6VarArr) {
            if (u6Var.b() - (-2.0f) > 1.0E-4d && u6Var.c() - (-2.0f) > 1.0E-4d) {
                return false;
            }
        }
        return true;
    }

    public static HmsScanResult a(Context context, byte[] bArr, int i10, int i11, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScanResult hmsScanResult = new HmsScanResult(4096, new HmsScan[0]);
        if (f30313b == null) {
            IRemoteCreator c4 = g.c(context);
            if (c4 == null) {
                return hmsScanResult;
            }
            try {
                f30313b = c4.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("ScankitRemoteDecoder", "RemoteException");
            }
        }
        if (f30313b == null) {
            return hmsScanResult;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
            }
            bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f30318c);
            bundle.putBoolean(DetailRect.USE_APK, g.f30316a);
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
            bundle.putAll(y3.a(context));
            HmsScanResult decodeWithBuffer = f30313b.decodeWithBuffer(bArr, i10, i11, ObjectWrapper.wrap(bundle));
            if (decodeWithBuffer.getHmsScans() != null) {
                a(decodeWithBuffer.getHmsScans());
                if (g.a()) {
                    o4.d("ScankitRemoteDecoder", "iRemoteDecoderDelegate decodeWithBuffer rollback");
                    IRemoteCreator c10 = g.c(context);
                    if (c10 == null) {
                        return hmsScanResult;
                    }
                    try {
                        f30313b = c10.newRemoteDecoderDelegate();
                    } catch (RemoteException unused2) {
                        o4.b("ScankitRemoteDecoder", "RemoteException");
                    }
                    decodeWithBuffer = f30313b.decodeWithBuffer(bArr, i10, i11, ObjectWrapper.wrap(bundle));
                }
            }
            return decodeWithBuffer != null ? decodeWithBuffer : hmsScanResult;
        } catch (RemoteException unused3) {
            o4.b("ScankitRemoteDecoder", "RemoteException");
            return hmsScanResult;
        }
    }

    public static HmsScanResult a(Context context, HmsScanFrame hmsScanFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        new HmsScanResult(4096, new HmsScan[0]);
        if (f30315d == null) {
            a(context);
        }
        if (f30315d != null) {
            try {
                Bundle bundle = new Bundle();
                w3.c cVar = null;
                bundle.putParcelable("Screen", new Point(hmsScanFrame.getWidth(), hmsScanFrame.getHeight()));
                bundle.putParcelable("Rect", new Rect(0, 0, hmsScanFrame.getWidth(), hmsScanFrame.getHeight()));
                bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f30318c);
                bundle.putBoolean(DetailRect.USE_APK, g.f30316a);
                if (f30314c == null) {
                    try {
                        try {
                            f30314c = new w3(bundle, DetailRect.PHOTO_MODE);
                            f30314c.a("single");
                            cVar = f30314c.a(false, hmsScanFrame.getHeight() * hmsScanFrame.getWidth());
                        } catch (Exception unused) {
                            o4.b("ScankitRemoteDecoder", "Exception");
                        }
                    } catch (RuntimeException unused2) {
                        o4.b("ScankitRemoteDecoder", "RuntimeException");
                    }
                }
                int i10 = HmsScanBase.ALL_SCAN_TYPE;
                if (hmsScanAnalyzerOptions != null) {
                    i10 = w7.b(hmsScanAnalyzerOptions.mode);
                }
                s6[] decode = f30315d.decode(hmsScanFrame.getYuvImage().getYuvData(), hmsScanFrame.getWidth(), hmsScanFrame.getHeight(), 0, i10, ObjectWrapper.wrap(bundle));
                a(decode);
                if (g.a()) {
                    o4.b("ScankitRemoteDecoder", "iRemoteFrameDecoderDelegate decode rollback");
                    a(context);
                    decode = f30315d.decode(hmsScanFrame.getYuvImage().getYuvData(), hmsScanFrame.getWidth(), hmsScanFrame.getHeight(), 0, i10, ObjectWrapper.wrap(bundle));
                }
                HmsScan[] a10 = y6.a(decode);
                if (f30314c != null) {
                    f30314c.a(a10, cVar);
                }
                if (a10.length == 0) {
                    return new HmsScanResult(4096, a10);
                }
                return new HmsScanResult(0, a10);
            } catch (RemoteException unused3) {
            }
        }
        return new HmsScanResult(4096, new HmsScan[0]);
    }

    private static void a(Bundle bundle) {
        if (DynamicModuleInitializer.getContext() == null) {
            try {
                g.b(z8.c.c().b());
            } catch (ClassNotFoundException unused) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog IllegalAccessException");
            } catch (NoClassDefFoundError unused3) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog NoClassDefFoundError");
                return;
            } catch (NoSuchMethodException unused4) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog NoSuchMethodException");
            } catch (InvocationTargetException unused5) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog InvocationTargetException");
            } catch (Exception unused6) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog Exception");
            }
        }
        if (f30312a == null) {
            try {
                f30312a = new x3();
                f30312a.c(bundle);
            } catch (RuntimeException unused7) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog RuntimeException");
            } catch (Exception unused8) {
                o4.b("ScankitRemoteDecoder", "buildBitmapLog Exception");
            }
        }
    }

    public static Bundle a(String str, int i10, int i11, int i12, HmsBuildBitmapOption hmsBuildBitmapOption) {
        Bundle bundle = new Bundle();
        bundle.putInt("contentLength", str == null ? -1 : str.length());
        bundle.putInt("scanType", i10);
        bundle.putInt("reqWidth", i11);
        bundle.putInt("reqHeight", i12);
        bundle.putString("buildBitmapOption", hmsBuildBitmapOption == null ? "null" : hmsBuildBitmapOption.toString());
        bundle.putString("apiName", "BuildBitmap");
        bundle.putLong("callTime", System.currentTimeMillis());
        bundle.putString("transId", UUID.randomUUID().toString());
        return bundle;
    }

    public static void a(int i10, Bitmap bitmap, Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("result", i10);
            bundle.putInt("outputWidth", bitmap == null ? -1 : bitmap.getWidth());
            bundle.putInt("outputHeight", bitmap != null ? bitmap.getHeight() : -1);
            long j10 = bundle.getLong("callTime");
            bundle.putLong("costTime", System.currentTimeMillis() - j10);
            bundle.putString("callTime", new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(j10)));
            a(bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r3) {
        /*
            java.lang.String r0 = "ScankitRemoteDecoder"
            android.content.Context r3 = com.huawei.hms.hmsscankit.g.e(r3)     // Catch: java.lang.Throwable -> L6 java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
        L6:
            java.lang.ClassLoader r1 = r3.getClassLoader()     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.String r2 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.String r2 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r3.loadClass(r2)     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            java.lang.Object r3 = r1.newInstance()     // Catch: java.lang.InstantiationException -> L1e java.lang.ClassNotFoundException -> L24 java.lang.IllegalAccessException -> L2a
            goto L30
        L1e:
            java.lang.String r3 = "InstantiationException"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
            goto L2f
        L24:
            java.lang.String r3 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
            goto L2f
        L2a:
            java.lang.String r3 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
        L2f:
            r3 = 0
        L30:
            boolean r1 = r3 instanceof android.os.IBinder
            if (r1 == 0) goto L46
            android.os.IBinder r3 = (android.os.IBinder) r3
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r3 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r3)
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r3 = r3.newRemoteFrameDecoderDelegate()     // Catch: java.lang.Exception -> L41
            com.huawei.hms.hmsscankit.f.f30315d = r3     // Catch: java.lang.Exception -> L41
            goto L46
        L41:
            java.lang.String r3 = "remoteception"
            com.huawei.hms.scankit.p.o4.a(r0, r3)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.f.a(android.content.Context):void");
    }
}
