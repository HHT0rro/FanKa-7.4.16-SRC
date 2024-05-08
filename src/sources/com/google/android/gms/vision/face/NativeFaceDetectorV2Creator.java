package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.vision.j8;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
@DynamiteApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class NativeFaceDetectorV2Creator extends ChimeraNativeBaseFaceDetectorCreator {
    @Override // com.google.android.gms.vision.face.ChimeraNativeBaseFaceDetectorCreator
    public final zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzfVar) {
        if (j8.a(context2, "face", "libface_detector_v2_jni.so")) {
            return new NativeFaceDetectorV2Impl(context, context2, dynamiteClearcutLogger, zzfVar, new FaceDetectorV2Jni());
        }
        return null;
    }
}
