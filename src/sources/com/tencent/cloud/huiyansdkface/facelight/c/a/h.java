package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.d> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40609a = "h";

    /* renamed from: b, reason: collision with root package name */
    private CamcorderProfile f40610b;

    /* renamed from: c, reason: collision with root package name */
    private int f40611c;

    /* renamed from: d, reason: collision with root package name */
    private int f40612d;

    private Camera.Size a(List<Camera.Size> list, int i10, int i11) {
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        int max = Math.max(i10, i11);
        int min = Math.min(i10, i11);
        double d10 = max / min;
        double d11 = Double.MAX_VALUE;
        double d12 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d10) <= 0.001d && Math.abs(size2.height - min) < d12) {
                d12 = Math.abs(size2.height - min);
                size = size2;
            }
        }
        if (size == null) {
            WLogger.i(f40609a, "No preview size match the aspect ratio");
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - min) < d11) {
                    size = size3;
                    d11 = Math.abs(size3.height - min);
                }
            }
        }
        return size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00d8, code lost:
    
        if (r9 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x013a, code lost:
    
        com.tencent.cloud.huiyansdkface.normal.tools.WLogger.i(com.tencent.cloud.huiyansdkface.facelight.c.a.h.f40609a, "do not find proper preview size, use default");
        r8.f40611c = 640;
        r8.f40612d = 480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0131, code lost:
    
        r8.f40611c = r9.width;
        r8.f40612d = r9.height;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x012f, code lost:
    
        if (r9 != null) goto L41;
     */
    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.cloud.huiyansdkface.a.a.a.d b(java.util.List<com.tencent.cloud.huiyansdkface.a.a.a.d> r9, com.tencent.cloud.huiyansdkface.a.c.d r10) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.c.a.h.b(java.util.List, com.tencent.cloud.huiyansdkface.a.c.d):com.tencent.cloud.huiyansdkface.a.a.a.d");
    }
}
