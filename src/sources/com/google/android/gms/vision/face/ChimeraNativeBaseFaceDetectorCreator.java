package com.google.android.gms.vision.face;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.f2;
import com.google.android.gms.internal.vision.j2;
import com.google.android.gms.internal.vision.m;
import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.zzfi$zzg;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzl;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
@DynamiteApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class ChimeraNativeBaseFaceDetectorCreator extends zzl {
    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context context, zzf zzfVar, @Nullable String str, long j10) {
        zzfi$zzg.a x10 = zzfi$zzg.x();
        int i10 = zzfVar.f25913b;
        if (i10 == 1) {
            x10.o(zzfi$zzg.zzd.MODE_ACCURATE);
        } else if (i10 == 0) {
            x10.o(zzfi$zzg.zzd.MODE_FAST);
        } else if (i10 == 2) {
            x10.o(zzfi$zzg.zzd.MODE_SELFIE);
        }
        int i11 = zzfVar.f25914c;
        if (i11 == 1) {
            x10.n(zzfi$zzg.zzc.LANDMARK_ALL);
        } else if (i11 == 0) {
            x10.n(zzfi$zzg.zzc.LANDMARK_NONE);
        } else if (i11 == 2) {
            x10.n(zzfi$zzg.zzc.LANDMARK_CONTOUR);
        }
        int i12 = zzfVar.f25915d;
        if (i12 == 1) {
            x10.m(zzfi$zzg.zzb.CLASSIFICATION_ALL);
        } else if (i12 == 0) {
            x10.m(zzfi$zzg.zzb.CLASSIFICATION_NONE);
        }
        x10.p(zzfVar.f25916e).q(zzfVar.f25917f).l(zzfVar.f25918g);
        f2.a n10 = f2.x().o("face").l(j10).n(x10);
        if (str != null) {
            n10.p(str);
        }
        n10.m(LogUtils.zza(context));
        dynamiteClearcutLogger.zza(2, (j2) ((x4) j2.x().m(n10).zzf()));
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzi
    public zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf zzfVar) throws RemoteException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        m.b(context);
        DynamiteClearcutLogger dynamiteClearcutLogger = new DynamiteClearcutLogger(context);
        try {
            try {
                zzh zza = zza(context, context, dynamiteClearcutLogger, zzfVar);
                if (zza != null) {
                    zza(dynamiteClearcutLogger, context, zzfVar, null, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                return zza;
            } catch (RemoteException e2) {
                e2.getMessage();
                throw e2;
            }
        } finally {
        }
    }

    public abstract zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzfVar) throws RemoteException;
}
