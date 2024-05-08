package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.scankit.util.OpencvJNI;

/* compiled from: IRemoteFrameDecoderDelegateImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h4 extends IRemoteFrameDecoderDelegate.Stub {

    /* renamed from: d, reason: collision with root package name */
    private static volatile h4 f31056d = new h4();

    /* renamed from: a, reason: collision with root package name */
    public Point f31057a;

    /* renamed from: b, reason: collision with root package name */
    public int f31058b = 0;

    /* renamed from: c, reason: collision with root package name */
    public Rect f31059c;

    private h4() {
    }

    public static h4 a() {
        return f31056d;
    }

    public synchronized Rect b(int i10, int i11) {
        Rect rect = new Rect(a(i10, i11));
        Point point = new Point(i10, i11);
        Point point2 = this.f31057a;
        if (point2 == null) {
            return null;
        }
        int i12 = point2.x;
        int i13 = point2.y;
        if (i12 < i13) {
            int i14 = rect.left;
            int i15 = point.y;
            rect.left = (i14 * i15) / i12;
            rect.right = (rect.right * i15) / i12;
            int i16 = rect.top;
            int i17 = point.x;
            rect.top = (i16 * i17) / i13;
            rect.bottom = (rect.bottom * i17) / i13;
        } else {
            int i18 = rect.top;
            int i19 = point.y;
            rect.top = (i18 * i19) / i13;
            rect.bottom = (rect.bottom * i19) / i13;
            int i20 = rect.left;
            int i21 = point.x;
            rect.left = (i20 * i21) / i12;
            rect.right = (rect.right * i21) / i12;
        }
        return rect;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate
    public s6[] decode(byte[] bArr, int i10, int i11, int i12, int i13, IObjectWrapper iObjectWrapper) throws RemoteException {
        boolean z10;
        boolean z11;
        boolean z12;
        if (!r3.A) {
            OpencvJNI.init();
        }
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            z10 = true;
            z11 = false;
            z12 = false;
        } else {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            this.f31057a = (Point) bundle.getParcelable("Screen");
            this.f31059c = (Rect) bundle.getParcelable("Rect");
            z11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.USE_APK, false);
            z12 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
            z10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.PARSE_RESULT, true);
        }
        r3.f31451f = z10;
        if (z12 && !r3.f31446a && z11) {
            return new s6[]{r6.c()};
        }
        if (this.f31059c == null) {
            this.f31059c = new Rect(-1, -1, -1, -1);
        }
        if (this.f31057a == null) {
            this.f31057a = new Point(1080, 1920);
        }
        e6 a10 = a(bArr, i10, i11, i12);
        byte[] b4 = a10.b();
        x6 x6Var = new x6(a10.c(), a10.a(), i13);
        int i14 = this.f31058b;
        this.f31058b = i14 + 1;
        return m1.c(b4, x6Var.a(i14));
    }

    private e6 a(byte[] bArr, int i10, int i11, int i12) {
        if (i12 == 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i13 = 0; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i10; i14++) {
                    bArr2[(((i14 * i11) + i11) - i13) - 1] = bArr[(i13 * i10) + i14];
                }
            }
            return a(bArr2, i11, i10);
        }
        if (i12 == 2) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i15 = 0; i15 < i11; i15++) {
                for (int i16 = 0; i16 < i10; i16++) {
                    bArr3[(((i10 - 1) - i16) * i11) + i15] = bArr[(i15 * i10) + i16];
                }
            }
            return a(bArr3, i11, i10);
        }
        if (i12 != 3) {
            return a(bArr, i10, i11);
        }
        byte[] bArr4 = new byte[bArr.length];
        for (int i17 = 0; i17 < i11; i17++) {
            for (int i18 = 0; i18 < i10; i18++) {
                bArr4[(((((i11 - 1) - i17) * i10) + i10) - 1) - i18] = bArr[(i17 * i10) + i18];
            }
        }
        return a(bArr4, i10, i11);
    }

    public synchronized Rect a(int i10, int i11) {
        int min;
        int i12;
        int i13;
        min = Math.min(i10, i11);
        i12 = (i10 - min) / 2;
        i13 = (i11 - min) / 2;
        return new Rect(i12, i13, i12 + min, min + i13);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.e6 a(byte[] r14, int r15, int r16) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h4.a(byte[], int, int):com.huawei.hms.scankit.p.e6");
    }
}
