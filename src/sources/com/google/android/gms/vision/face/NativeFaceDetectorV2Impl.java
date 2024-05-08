package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.c2;
import com.google.android.gms.internal.vision.d2;
import com.google.android.gms.internal.vision.h2;
import com.google.android.gms.internal.vision.i2;
import com.google.android.gms.internal.vision.i8;
import com.google.android.gms.internal.vision.x;
import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.zzbw;
import com.google.android.gms.internal.vision.zzcc;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzck;
import com.google.android.gms.internal.vision.zzcp;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzmt;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class NativeFaceDetectorV2Impl extends zzg {
    private static final e zza = new e("NativeFaceDetectorV2Imp", "");
    private final long zzb;
    private final DynamiteClearcutLogger zzc;
    private final zzci.c zzd;
    private final FaceDetectorV2Jni zze;

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* renamed from: com.google.android.gms.vision.face.NativeFaceDetectorV2Impl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25890a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25891b;

        static {
            int[] iArr = new int[zzci.zzb.zzc.values().length];
            f25891b = iArr;
            try {
                iArr[zzci.zzb.zzc.FACE_OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25891b[zzci.zzb.zzc.LEFT_EYEBROW_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25891b[zzci.zzb.zzc.LEFT_EYEBROW_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25891b[zzci.zzb.zzc.RIGHT_EYEBROW_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25891b[zzci.zzb.zzc.RIGHT_EYEBROW_BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25891b[zzci.zzb.zzc.LEFT_EYE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25891b[zzci.zzb.zzc.RIGHT_EYE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25891b[zzci.zzb.zzc.UPPER_LIP_TOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25891b[zzci.zzb.zzc.UPPER_LIP_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25891b[zzci.zzb.zzc.LOWER_LIP_TOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25891b[zzci.zzb.zzc.LOWER_LIP_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f25891b[zzci.zzb.zzc.NOSE_BRIDGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f25891b[zzci.zzb.zzc.NOSE_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f25891b[zzci.zzb.zzc.LEFT_CHEEK_CENTER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f25891b[zzci.zzb.zzc.RIGHT_CHEEK_CENTER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr2 = new int[zzmt.zze.zzb.values().length];
            f25890a = iArr2;
            try {
                iArr2[zzmt.zze.zzb.LEFT_EYE.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f25890a[zzmt.zze.zzb.RIGHT_EYE.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f25890a[zzmt.zze.zzb.NOSE_TIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f25890a[zzmt.zze.zzb.LOWER_LIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f25890a[zzmt.zze.zzb.MOUTH_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f25890a[zzmt.zze.zzb.MOUTH_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f25890a[zzmt.zze.zzb.LEFT_EAR_TRAGION.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f25890a[zzmt.zze.zzb.RIGHT_EAR_TRAGION.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f25890a[zzmt.zze.zzb.LEFT_CHEEK_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f25890a[zzmt.zze.zzb.RIGHT_CHEEK_CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f25890a[zzmt.zze.zzb.LEFT_EAR_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f25890a[zzmt.zze.zzb.RIGHT_EAR_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public NativeFaceDetectorV2Impl(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzfVar, FaceDetectorV2Jni faceDetectorV2Jni) {
        zzci.f fVar = (zzci.f) ((x4) zzci.f.x().l("models").zzf());
        zzci.c.a u10 = zzci.c.R().n(zzci.d.x().l(fVar).m(fVar).n(fVar)).m(zzci.a.x().l(fVar).m(fVar)).o(zzci.e.x().l(fVar).m(fVar).n(fVar).o(fVar)).s(zzfVar.f25916e).t(zzfVar.f25917f).l(zzfVar.f25918g).u(true);
        int i10 = zzfVar.f25913b;
        if (i10 == 0) {
            u10.r(zzct.FAST);
        } else if (i10 == 1) {
            u10.r(zzct.ACCURATE);
        } else if (i10 == 2) {
            u10.r(zzct.SELFIE);
        }
        int i11 = zzfVar.f25914c;
        if (i11 == 0) {
            u10.q(zzcp.NO_LANDMARK);
        } else if (i11 == 1) {
            u10.q(zzcp.ALL_LANDMARKS);
        } else if (i11 == 2) {
            u10.q(zzcp.CONTOUR_LANDMARKS);
        }
        int i12 = zzfVar.f25915d;
        if (i12 == 0) {
            u10.p(zzck.NO_CLASSIFICATION);
        } else if (i12 == 1) {
            u10.p(zzck.ALL_CLASSIFICATIONS);
        }
        zzci.c cVar = (zzci.c) ((x4) u10.zzf());
        this.zzd = cVar;
        this.zzb = faceDetectorV2Jni.a(cVar, context2.getAssets());
        this.zzc = dynamiteClearcutLogger;
        this.zze = faceDetectorV2Jni;
    }

    private static zzcc zzb(int i10) {
        if (i10 == 0) {
            return zzcc.ROTATION_0;
        }
        if (i10 == 1) {
            return zzcc.ROTATION_270;
        }
        if (i10 == 2) {
            return zzcc.ROTATION_180;
        }
        if (i10 == 3) {
            return zzcc.ROTATION_90;
        }
        throw new IllegalArgumentException("Unsupported rotation degree.");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zza() throws RemoteException {
        this.zze.f(this.zzb);
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zza(int i10) throws RemoteException {
        return true;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        zzci.b d10;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            x.a n10 = x.x().l(zzsVar.f25778b).p(zzsVar.f25779c).o(zzb(zzsVar.f25782f)).n(zzbw.NV21);
            long j10 = zzsVar.f25781e;
            if (j10 > 0) {
                n10.m(j10 * 1000);
            }
            x xVar = (x) ((x4) n10.zzf());
            if (byteBuffer.isDirect()) {
                d10 = this.zze.b(this.zzb, byteBuffer, xVar);
            } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
                d10 = this.zze.d(this.zzb, byteBuffer.array(), xVar);
            } else {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                d10 = this.zze.d(this.zzb, bArr, xVar);
            }
            FaceParcel[] zza2 = zza(d10, this.zzd.O(), this.zzd.x());
            zza(this.zzc, zzsVar, zza2, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            return zza2;
        } catch (Exception e2) {
            zza.d("NativeFaceDetectorV2Imp", "Native face detection v2 failed", e2);
            return new FaceParcel[0];
        }
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i10, int i11, int i12, int i13, int i14, int i15, zzs zzsVar) {
        zzci.b e2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper);
            ByteBuffer byteBuffer2 = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper2);
            ByteBuffer byteBuffer3 = (ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper3);
            x.a o10 = x.x().l(zzsVar.f25778b).p(zzsVar.f25779c).o(zzb(zzsVar.f25782f));
            long j10 = zzsVar.f25781e;
            if (j10 > 0) {
                o10.m(j10 * 1000);
            }
            x xVar = (x) ((x4) o10.zzf());
            if (byteBuffer.isDirect()) {
                e2 = this.zze.c(this.zzb, byteBuffer, byteBuffer2, byteBuffer3, i10, i11, i12, i13, i14, i15, xVar);
            } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
                byte[] bArr = null;
                byte[] array = (byteBuffer2 != null && byteBuffer2.hasArray() && byteBuffer2.arrayOffset() == 0) ? byteBuffer2.array() : null;
                if (byteBuffer3 != null && byteBuffer3.hasArray() && byteBuffer3.arrayOffset() == 0) {
                    bArr = byteBuffer3.array();
                }
                e2 = this.zze.e(this.zzb, byteBuffer.array(), array, bArr, i10, i11, i12, i13, i14, i15, xVar);
            } else {
                byte[] bArr2 = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr2);
                byte[] bArr3 = new byte[byteBuffer2.remaining()];
                byteBuffer.get(bArr2);
                byte[] bArr4 = new byte[byteBuffer3.remaining()];
                byteBuffer.get(bArr2);
                e2 = this.zze.e(this.zzb, bArr2, bArr3, bArr4, i10, i11, i12, i13, i14, i15, xVar);
            }
            FaceParcel[] zza2 = zza(e2, this.zzd.O(), this.zzd.x());
            zza(this.zzc, zzsVar, zza2, null, SystemClock.elapsedRealtime() - elapsedRealtime);
            return zza2;
        } catch (Exception e10) {
            zza.d("NativeFaceDetectorV2Imp", "Native face detection v2 failed", e10);
            return new FaceParcel[0];
        }
    }

    private static FaceParcel[] zza(zzci.b bVar, zzck zzckVar, zzcp zzcpVar) {
        float f10;
        float f11;
        float f12;
        i8 i8Var;
        LandmarkParcel[] landmarkParcelArr;
        zza[] zzaVarArr;
        int i10;
        i8 i8Var2;
        List<zzmt.zze> list;
        int i11;
        zzcp zzcpVar2 = zzcpVar;
        i8 y10 = bVar.y();
        FaceParcel[] faceParcelArr = new FaceParcel[y10.z()];
        int i12 = 0;
        while (i12 < y10.z()) {
            zzmt x10 = y10.x(i12);
            zzmt.a z10 = x10.z();
            float x11 = z10.x() + ((z10.z() - z10.x()) / 2.0f);
            float y11 = z10.y() + ((z10.A() - z10.y()) / 2.0f);
            float z11 = z10.z() - z10.x();
            float A = z10.A() - z10.y();
            if (zzckVar == zzck.ALL_CLASSIFICATIONS) {
                float f13 = -1.0f;
                float f14 = -1.0f;
                float f15 = -1.0f;
                for (zzmt.zza zzaVar : x10.G()) {
                    if (zzaVar.x().equals("joy")) {
                        f15 = zzaVar.y();
                    } else if (zzaVar.x().equals("left_eye_closed")) {
                        f13 = 1.0f - zzaVar.y();
                    } else if (zzaVar.x().equals("right_eye_closed")) {
                        f14 = 1.0f - zzaVar.y();
                    }
                }
                f10 = f13;
                f11 = f14;
                f12 = f15;
            } else {
                f10 = -1.0f;
                f11 = -1.0f;
                f12 = -1.0f;
            }
            float C = x10.B() ? x10.C() : -1.0f;
            if (zzcpVar2 == zzcp.ALL_LANDMARKS) {
                List<zzmt.zze> A2 = x10.A();
                ArrayList arrayList = new ArrayList();
                int i13 = 0;
                while (i13 < A2.size()) {
                    zzmt.zze zzeVar = A2.get(i13);
                    zzmt.zze.zzb z12 = zzeVar.z();
                    switch (AnonymousClass1.f25890a[z12.ordinal()]) {
                        case 1:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 4;
                            break;
                        case 2:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 10;
                            break;
                        case 3:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 6;
                            break;
                        case 4:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 0;
                            break;
                        case 5:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 5;
                            break;
                        case 6:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 11;
                            break;
                        case 7:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 3;
                            break;
                        case 8:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 9;
                            break;
                        case 9:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 1;
                            break;
                        case 10:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 7;
                            break;
                        case 11:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 2;
                            break;
                        case 12:
                            i8Var2 = y10;
                            list = A2;
                            i11 = 8;
                            break;
                        default:
                            e eVar = zza;
                            String valueOf = String.valueOf(z12);
                            i8Var2 = y10;
                            list = A2;
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                            sb2.append("Unknown landmark type: ");
                            sb2.append(valueOf);
                            eVar.b("NativeFaceDetectorV2Imp", sb2.toString());
                            i11 = -1;
                            break;
                    }
                    if (i11 >= 0) {
                        arrayList.add(new LandmarkParcel(-1, zzeVar.x(), zzeVar.y(), i11));
                    }
                    i13++;
                    A2 = list;
                    y10 = i8Var2;
                }
                i8Var = y10;
                landmarkParcelArr = (LandmarkParcel[]) arrayList.toArray(new LandmarkParcel[0]);
            } else {
                i8Var = y10;
                landmarkParcelArr = new LandmarkParcel[0];
            }
            if (zzcpVar2 == zzcp.CONTOUR_LANDMARKS) {
                List list2 = (List) x10.y(zzci.f25742a);
                zza[] zzaVarArr2 = new zza[list2.size()];
                int i14 = 0;
                while (i14 < list2.size()) {
                    zzci.zzb zzbVar = (zzci.zzb) list2.get(i14);
                    PointF[] pointFArr = new PointF[zzbVar.z()];
                    int i15 = 0;
                    while (i15 < zzbVar.z()) {
                        zzci.zzb.b bVar2 = zzbVar.y().get(i15);
                        pointFArr[i15] = new PointF(bVar2.x(), bVar2.y());
                        i15++;
                        list2 = list2;
                    }
                    List list3 = list2;
                    zzci.zzb.zzc x12 = zzbVar.x();
                    switch (AnonymousClass1.f25891b[x12.ordinal()]) {
                        case 1:
                            i10 = 1;
                            break;
                        case 2:
                            i10 = 2;
                            break;
                        case 3:
                            i10 = 3;
                            break;
                        case 4:
                            i10 = 4;
                            break;
                        case 5:
                            i10 = 5;
                            break;
                        case 6:
                            i10 = 6;
                            break;
                        case 7:
                            i10 = 7;
                            break;
                        case 8:
                            i10 = 8;
                            break;
                        case 9:
                            i10 = 9;
                            break;
                        case 10:
                            i10 = 10;
                            break;
                        case 11:
                            i10 = 11;
                            break;
                        case 12:
                            i10 = 12;
                            break;
                        case 13:
                            i10 = 13;
                            break;
                        case 14:
                            i10 = 14;
                            break;
                        case 15:
                            i10 = 15;
                            break;
                        default:
                            e eVar2 = zza;
                            int zza2 = x12.zza();
                            StringBuilder sb3 = new StringBuilder(33);
                            sb3.append("Unknown contour type: ");
                            sb3.append(zza2);
                            eVar2.c("NativeFaceDetectorV2Imp", sb3.toString());
                            i10 = -1;
                            break;
                    }
                    zzaVarArr2[i14] = new zza(pointFArr, i10);
                    i14++;
                    list2 = list3;
                }
                zzaVarArr = zzaVarArr2;
            } else {
                zzaVarArr = new zza[0];
            }
            faceParcelArr[i12] = new FaceParcel(3, (int) x10.H(), x11, y11, z11, A, x10.E(), -x10.D(), x10.F(), landmarkParcelArr, f10, f11, f12, zzaVarArr, C);
            i12++;
            zzcpVar2 = zzcpVar;
            y10 = i8Var;
        }
        return faceParcelArr;
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, zzs zzsVar, FaceParcel[] faceParcelArr, @Nullable String str, long j10) {
        if (zzsVar.f25780d <= 2 || faceParcelArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (FaceParcel faceParcel : faceParcelArr) {
                h2 h2Var = (h2) ((x4) h2.x().l((int) (faceParcel.f25894d - (faceParcel.f25896f / 2.0f))).m((int) (faceParcel.f25895e - (faceParcel.f25897g / 2.0f))).zzf());
                h2 h2Var2 = (h2) ((x4) h2.x().l((int) (faceParcel.f25894d + (faceParcel.f25896f / 2.0f))).m((int) (faceParcel.f25895e - (faceParcel.f25897g / 2.0f))).zzf());
                h2 h2Var3 = (h2) ((x4) h2.x().l((int) (faceParcel.f25894d + (faceParcel.f25896f / 2.0f))).m((int) (faceParcel.f25895e + (faceParcel.f25897g / 2.0f))).zzf());
                arrayList.add((i2) ((x4) i2.x().m(c2.x().m(h2Var).m(h2Var2).m(h2Var3).m((h2) ((x4) h2.x().l((int) (faceParcel.f25894d - (faceParcel.f25896f / 2.0f))).m((int) (faceParcel.f25895e + (faceParcel.f25897g / 2.0f))).zzf()))).l(faceParcel.f25893c).o((d2) ((x4) d2.x().o(faceParcel.f25898h).p(faceParcel.f25899i).q(faceParcel.f25900j).l(faceParcel.f25902l).m(faceParcel.f25903m).n(faceParcel.f25904n).zzf())).zzf()));
            }
            dynamiteClearcutLogger.zza(3, LogUtils.zza(j10, faceParcelArr.length, null, "face", arrayList, zzsVar));
        }
    }
}
