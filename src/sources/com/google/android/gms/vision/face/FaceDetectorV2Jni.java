package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import android.os.RemoteException;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.vision.l4;
import com.google.android.gms.internal.vision.x;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzjk;
import java.nio.ByteBuffer;
import q7.a;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceDetectorV2Jni {

    /* renamed from: a, reason: collision with root package name */
    public final l4 f25889a;

    public FaceDetectorV2Jni() {
        l4 a10 = l4.a();
        this.f25889a = a10;
        a10.c(zzci.f25742a);
    }

    @Keep
    private native void closeDetectorJni(long j10);

    @Keep
    private native byte[] detectFacesImageByteArrayJni(long j10, byte[] bArr, byte[] bArr2);

    @Keep
    private native byte[] detectFacesImageByteArrayMultiPlanesJni(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, int i11, int i12, int i13, int i14, int i15, byte[] bArr4);

    @Keep
    private native byte[] detectFacesImageByteBufferJni(long j10, ByteBuffer byteBuffer, byte[] bArr);

    @Keep
    private native byte[] detectFacesImageByteBufferMultiPlanesJni(long j10, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10, int i11, int i12, int i13, int i14, int i15, byte[] bArr);

    @Keep
    private native long initDetectorJni(byte[] bArr, AssetManager assetManager);

    public final long a(zzci.c cVar, AssetManager assetManager) {
        a.d("%s initialize.start()", "FaceDetectorV2Jni");
        long initDetectorJni = initDetectorJni(cVar.d(), assetManager);
        a.d("%s initialize.end()", "FaceDetectorV2Jni");
        return initDetectorJni;
    }

    @Nullable
    public final zzci.b b(long j10, ByteBuffer byteBuffer, x xVar) throws RemoteException {
        a.d("%s detectFacesImageByteBuffer.start()", "FaceDetectorV2Jni");
        zzci.b bVar = null;
        try {
            byte[] detectFacesImageByteBufferJni = detectFacesImageByteBufferJni(j10, byteBuffer, xVar.d());
            if (detectFacesImageByteBufferJni != null && detectFacesImageByteBufferJni.length > 0) {
                bVar = zzci.b.x(detectFacesImageByteBufferJni, this.f25889a);
            }
        } catch (zzjk e2) {
            a.a("%s detectFacesImageByteBuffer failed to parse result: %s", "FaceDetectorV2Jni", e2.getMessage());
        }
        a.d("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
        return bVar;
    }

    @Nullable
    public final zzci.b c(long j10, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10, int i11, int i12, int i13, int i14, int i15, x xVar) {
        byte[] detectFacesImageByteBufferMultiPlanesJni;
        a.d("%s detectFacesImageByteBufferMultiPlanes.start()", "FaceDetectorV2Jni");
        zzci.b bVar = null;
        try {
            detectFacesImageByteBufferMultiPlanesJni = detectFacesImageByteBufferMultiPlanesJni(j10, byteBuffer, byteBuffer2, byteBuffer3, i10, i11, i12, i13, i14, i15, xVar.d());
        } catch (zzjk e2) {
            e = e2;
        }
        if (detectFacesImageByteBufferMultiPlanesJni != null) {
            if (detectFacesImageByteBufferMultiPlanesJni.length > 0) {
                try {
                    bVar = zzci.b.x(detectFacesImageByteBufferMultiPlanesJni, this.f25889a);
                } catch (zzjk e10) {
                    e = e10;
                    a.a("%s detectFacesImageByteBufferMultiPlanes failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
                    a.d("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
                    return bVar;
                }
                a.d("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
                return bVar;
            }
        }
        a.d("%s detectFacesImageByteBuffer.end()", "FaceDetectorV2Jni");
        return bVar;
    }

    @Nullable
    public final zzci.b d(long j10, byte[] bArr, x xVar) throws RemoteException {
        a.d("%s detectFacesImageByteArray.start()", "FaceDetectorV2Jni");
        zzci.b bVar = null;
        try {
            byte[] detectFacesImageByteArrayJni = detectFacesImageByteArrayJni(j10, bArr, xVar.d());
            if (detectFacesImageByteArrayJni != null && detectFacesImageByteArrayJni.length > 0) {
                bVar = zzci.b.x(detectFacesImageByteArrayJni, this.f25889a);
            }
        } catch (zzjk e2) {
            a.a("%s detectFacesImageByteArray failed to parse result: %s", "FaceDetectorV2Jni", e2.getMessage());
        }
        a.d("%s detectFacesImageByteArray.end()", "FaceDetectorV2Jni");
        return bVar;
    }

    @Nullable
    public final zzci.b e(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, int i11, int i12, int i13, int i14, int i15, x xVar) {
        byte[] detectFacesImageByteArrayMultiPlanesJni;
        a.d("%s detectFacesImageByteArrayMultiPlanes.start()", "FaceDetectorV2Jni");
        zzci.b bVar = null;
        try {
            detectFacesImageByteArrayMultiPlanesJni = detectFacesImageByteArrayMultiPlanesJni(j10, bArr, bArr2, bArr3, i10, i11, i12, i13, i14, i15, xVar.d());
        } catch (zzjk e2) {
            e = e2;
        }
        if (detectFacesImageByteArrayMultiPlanesJni != null) {
            if (detectFacesImageByteArrayMultiPlanesJni.length > 0) {
                try {
                    bVar = zzci.b.x(detectFacesImageByteArrayMultiPlanesJni, this.f25889a);
                } catch (zzjk e10) {
                    e = e10;
                    a.a("%s detectFacesImageByteArrayMultiPlanes failed to parse result: %s", "FaceDetectorV2Jni", e.getMessage());
                    a.d("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
                    return bVar;
                }
                a.d("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
                return bVar;
            }
        }
        a.d("%s detectFacesImageByteArrayMultiPlanes.end()", "FaceDetectorV2Jni");
        return bVar;
    }

    public final void f(long j10) {
        a.d("%s closeDetector.start()", "FaceDetectorV2Jni");
        closeDetectorJni(j10);
        a.d("%s closeDetector.end()", "FaceDetectorV2Jni");
    }
}
