package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.f2;
import com.google.android.gms.internal.vision.j2;
import com.google.android.gms.internal.vision.j8;
import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.zzfi$zzg;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.internal.vision.zzgh;
import com.google.android.gms.internal.vision.zzgl;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
@DynamiteApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceDetectorCreator extends zzgl {
    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context context, zzgd zzgdVar, @Nullable String str, long j10) {
        zzfi$zzg.zzd zzdVar;
        zzfi$zzg.zzc zzcVar;
        zzfi$zzg.zzb zzbVar;
        zzfi$zzg.a x10 = zzfi$zzg.x();
        if (zzgdVar.f() == 2) {
            x10.o(zzfi$zzg.zzd.MODE_SELFIE).n(zzfi$zzg.zzc.LANDMARK_CONTOUR).p(true);
        } else {
            if (zzgdVar.zza() == 2) {
                zzdVar = zzfi$zzg.zzd.MODE_ACCURATE;
            } else {
                zzdVar = zzfi$zzg.zzd.MODE_FAST;
            }
            zzfi$zzg.a o10 = x10.o(zzdVar);
            if (zzgdVar.zzb() == 2) {
                zzcVar = zzfi$zzg.zzc.LANDMARK_ALL;
            } else {
                zzcVar = zzfi$zzg.zzc.LANDMARK_NONE;
            }
            o10.n(zzcVar).p(false);
        }
        if (zzgdVar.zzc() == 2) {
            zzbVar = zzfi$zzg.zzb.CLASSIFICATION_ALL;
        } else {
            zzbVar = zzfi$zzg.zzb.CLASSIFICATION_NONE;
        }
        x10.m(zzbVar).q(zzgdVar.zze()).l(zzgdVar.g());
        f2.a m10 = f2.x().o("face").l(j10).n(x10).m(LogUtils.zza(context));
        if (str != null) {
            m10.p(str);
        }
        dynamiteClearcutLogger.zza(2, (j2) ((x4) j2.x().m(m10).n(true).zzf()));
    }

    @Override // com.google.android.gms.internal.vision.zzgi
    public zzgh newFaceDetector(IObjectWrapper iObjectWrapper, zzgd zzgdVar) throws RemoteException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        DynamiteClearcutLogger dynamiteClearcutLogger = new DynamiteClearcutLogger(context);
        if (j8.a(context, "face", "libface_detector_v2_jni.so")) {
            zza(dynamiteClearcutLogger, context, zzgdVar, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            return new zzb(context, zzgdVar, new FaceDetectorV2Jni(), dynamiteClearcutLogger);
        }
        zza(dynamiteClearcutLogger, context, zzgdVar, "Failed to load library libface_detector_v2_jni.so", SystemClock.elapsedRealtime() - elapsedRealtime);
        throw t7.a.a("Failed to load library libface_detector_v2_jni.so");
    }
}
