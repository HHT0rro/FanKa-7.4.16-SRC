package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.w3;
import java.nio.ByteBuffer;

/* compiled from: RemoteDecoderWork.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r6 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile r6 f31473a;

    public static r6 a() {
        if (f31473a == null) {
            synchronized (r6.class) {
                if (f31473a == null) {
                    f31473a = new r6();
                }
            }
        }
        return f31473a;
    }

    public static s6 c() {
        return new s6("", null, new u6[]{new u6(-2.0f, -2.0f), new u6(-2.0f, -2.0f), new u6(-2.0f, -2.0f), new u6(-2.0f, -2.0f)}, BarcodeFormat.NONE);
    }

    public HmsScan[] b(Bitmap bitmap, int i10, boolean z10, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("single");
            cVar = w3Var.a(z10, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        s6[] b4 = m1.b(bitmap, new x6(i10, z10));
        o4.d("Scankit", "start totalParseResult");
        HmsScan[] a10 = y6.a(b4);
        if (w3Var != null) {
            w3Var.a(a10, cVar);
        }
        return a10;
    }

    public HmsScanResult a(byte[] bArr, int i10, int i11, int i12, boolean z10, boolean z11, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("single");
            cVar = w3Var.a(z10, i11 * i10);
            if (i11 < 30 || i10 < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        w3.c cVar2 = cVar;
        o4.d("Scankit", "start decodeSingleCode");
        s6[] c4 = m1.c(bArr, new x6(i10, i11, i12, true, z10));
        o4.d("Scankit", "start totalParseResult");
        HmsScan[] a10 = y6.a(c4);
        o4.d("Scankit", "end totalParseResult");
        if (w3Var != null) {
            w3Var.a(a10, cVar2);
        }
        if (!z11) {
            o4.d("Scankit", "start hmsResultTrans");
            a10 = w7.a(a10);
            o4.d("Scankit", "end hmsResultTrans");
        }
        int i13 = i12 == 0 ? HmsScanBase.ALL_SCAN_TYPE : i12;
        if (r3.f31449d) {
            return new HmsScanResult(4099, a10);
        }
        if (r3.f31450e) {
            return new HmsScanResult(HmsScanResult.SCAN_UNDEREXPOSED, a10);
        }
        if (r3.f31453h && a10.length == 0) {
            int i14 = HmsScanBase.QRCODE_SCAN_TYPE;
            if ((i13 & i14) == i14) {
                return new HmsScanResult(4097, a10);
            }
        }
        if (a10.length == 0) {
            return new HmsScanResult(4096, a10);
        }
        if (a10.length > 0 && !TextUtils.isEmpty(a10[0].getOriginalValue())) {
            return new HmsScanResult(0, a10);
        }
        if (a10.length > 0 && a10[0].getZoomValue() > 1.0d) {
            return new HmsScanResult(4098, a10);
        }
        return new HmsScanResult(4096, new HmsScan[0]);
    }

    public static HmsScan b() {
        return new HmsScan("", HmsScanBase.FORMAT_UNKNOWN, "", HmsScan.PURE_TEXT_FORM, null, new Point[]{new Point(-2, -2), new Point(-2, -2), new Point(-2, -2), new Point(-2, -2)}, null, null).setZoomValue(1.0d);
    }

    public HmsScan[] a(Bitmap bitmap, int i10, boolean z10, w3 w3Var) {
        w3.c cVar;
        o4.d("Scankit", "start decodeWithBitmapWorkMulti");
        if (w3Var != null) {
            w3Var.a("multi");
            cVar = w3Var.a(z10, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        o4.d("Scankit", "end decodeWithBitmapWorkMulti");
        s6[] a10 = m1.a(bitmap, new x6(i10, z10));
        o4.d("Scankit", "start totalParseResult");
        HmsScan[] a11 = y6.a(a10);
        o4.d("Scankit", "end totalParseResult");
        if (w3Var != null) {
            w3Var.a(a11, cVar);
        }
        return a11;
    }

    public HmsScan[] a(ByteBuffer byteBuffer, int i10, int i11, int i12, boolean z10, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("multi");
            int i13 = i11 * i10;
            cVar = w3Var.a(z10, i13);
            if (i10 >= 30 && i11 >= 30) {
                if (byteBuffer.array().length < i13) {
                    cVar.a(-1008);
                }
            } else {
                cVar.a(-1007);
            }
        } else {
            cVar = null;
        }
        HmsScan[] a10 = y6.a(m1.a(byteBuffer, new x6(i10, i11, i12, true, z10)));
        if (w3Var != null) {
            w3Var.a(a10, cVar);
        }
        return a10;
    }
}
