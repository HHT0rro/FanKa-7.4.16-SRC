package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.c2;
import com.google.android.gms.internal.vision.d2;
import com.google.android.gms.internal.vision.h2;
import com.google.android.gms.internal.vision.i2;
import com.google.android.gms.internal.vision.j2;
import com.google.android.gms.internal.vision.m8;
import com.google.android.gms.internal.vision.x;
import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.zzbw;
import com.google.android.gms.internal.vision.zzcc;
import com.google.android.gms.internal.vision.zzci;
import com.google.android.gms.internal.vision.zzck;
import com.google.android.gms.internal.vision.zzcp;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzfz;
import com.google.android.gms.internal.vision.zzgb;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.internal.vision.zzgf;
import com.google.android.gms.internal.vision.zzgg;
import com.google.android.gms.internal.vision.zzgn;
import com.google.android.gms.internal.vision.zzmt;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class zzb extends zzgg {
    private static final e zza = new e("FaceDetector", "");
    private final Context zzb;
    private final zzci.c zzc;
    private final FaceDetectorV2Jni zzd;
    private final DynamiteClearcutLogger zze;
    private long zzf = -1;

    public zzb(Context context, zzgd zzgdVar, FaceDetectorV2Jni faceDetectorV2Jni, DynamiteClearcutLogger dynamiteClearcutLogger) {
        this.zzb = context;
        boolean z10 = false;
        boolean z11 = zzgdVar.f() == 2;
        zzci.f fVar = (zzci.f) ((x4) zzci.f.x().l("models").zzf());
        zzci.c.a s2 = zzci.c.R().n(zzci.d.x().l(fVar).m(fVar).n(fVar)).m(zzci.a.x().l(fVar).m(fVar)).o(zzci.e.x().l(fVar).m(fVar).n(fVar).o(fVar)).s(z11);
        if (!z11 && zzgdVar.zze()) {
            z10 = true;
        }
        zzci.c.a u10 = s2.t(z10).l(zzgdVar.g()).u(true);
        if (z11) {
            u10.r(zzct.SELFIE).q(zzcp.CONTOUR_LANDMARKS);
        } else {
            int zza2 = zzgdVar.zza();
            if (zza2 == 1) {
                u10.r(zzct.FAST);
            } else if (zza2 == 2) {
                u10.r(zzct.ACCURATE);
            }
            int zzb = zzgdVar.zzb();
            if (zzb == 1) {
                u10.q(zzcp.NO_LANDMARK);
            } else if (zzb == 2) {
                u10.q(zzcp.ALL_LANDMARKS);
            }
            int zzc = zzgdVar.zzc();
            if (zzc == 1) {
                u10.p(zzck.NO_CLASSIFICATION);
            } else if (zzc == 2) {
                u10.p(zzck.ALL_CLASSIFICATIONS);
            }
        }
        this.zzc = (zzci.c) ((x4) u10.zzf());
        this.zzd = faceDetectorV2Jni;
        this.zze = dynamiteClearcutLogger;
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zza() {
        this.zzf = this.zzd.a(this.zzc, this.zzb.getAssets());
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zzb() {
        long j10 = this.zzf;
        if (j10 > 0) {
            this.zzd.f(j10);
            this.zzf = -1L;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final List<zzgf> zza(IObjectWrapper iObjectWrapper, zzfz zzfzVar) throws RemoteException {
        List<zzgf> zza2;
        zzci.b e2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int zza3 = zzfzVar.zza();
        if (zza3 == -1) {
            zza2 = zza(m8.a((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzfzVar, zzbw.NV21);
        } else if (zza3 == 17) {
            zza2 = zza((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzfzVar, zzbw.NV21);
        } else if (zza3 == 35) {
            Image.Plane[] planes = ((Image) ObjectWrapper.unwrap(iObjectWrapper)).getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            ByteBuffer buffer2 = planes[1].getBuffer();
            ByteBuffer buffer3 = planes[2].getBuffer();
            x.a o10 = x.x().l(zzfzVar.zzb()).p(zzfzVar.zzc()).o(zza(zzfzVar.f()));
            if (zzfzVar.g() > 0) {
                o10.m(zzfzVar.g() * 1000);
            }
            x xVar = (x) ((x4) o10.zzf());
            if (buffer.isDirect()) {
                e2 = this.zzd.c(this.zzf, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), xVar);
            } else if (buffer.hasArray() && buffer.arrayOffset() == 0) {
                e2 = this.zzd.e(this.zzf, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), xVar);
            } else {
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                byte[] bArr2 = new byte[buffer2.remaining()];
                buffer.get(bArr);
                byte[] bArr3 = new byte[buffer3.remaining()];
                buffer.get(bArr);
                e2 = this.zzd.e(this.zzf, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), xVar);
            }
            zza2 = e2 != null ? zza(e2) : new ArrayList<>();
        } else if (zza3 == 842094169) {
            zza2 = zza((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzfzVar, zzbw.YV12);
        } else {
            int zza4 = zzfzVar.zza();
            int i10 = Build.VERSION.SDK_INT;
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("Unsupported image format ");
            sb2.append(zza4);
            sb2.append(" at API ");
            sb2.append(i10);
            throw t7.a.a(sb2.toString());
        }
        DynamiteClearcutLogger dynamiteClearcutLogger = this.zze;
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        ArrayList arrayList = new ArrayList();
        for (zzgf zzgfVar : zza2) {
            Rect f10 = zzgfVar.f();
            arrayList.add((i2) ((x4) i2.x().l(zzgfVar.zza()).n((c2) ((x4) c2.x().l(h2.x().l(f10.left).m(f10.top)).l(h2.x().l(f10.right).m(f10.top)).l(h2.x().l(f10.right).m(f10.bottom)).l(h2.x().l(f10.left).m(f10.bottom)).zzf())).o((d2) ((x4) d2.x().q(zzgfVar.j()).o(zzgfVar.i()).p(-zzgfVar.g()).l(zzgfVar.k()).m(zzgfVar.l()).n(zzgfVar.m()).zzf())).zzf()));
        }
        dynamiteClearcutLogger.zza(3, (j2) ((x4) LogUtils.zza(elapsedRealtime2, zza2.size(), null, "face", arrayList, new zzs(zzfzVar.zzb(), zzfzVar.zzc(), 0, zzfzVar.g(), zzfzVar.f())).u().n(true).zzf()));
        return zza2;
    }

    private final List<zzgf> zza(ByteBuffer byteBuffer, zzfz zzfzVar, zzbw zzbwVar) throws RemoteException {
        zzci.b d10;
        x.a n10 = x.x().l(zzfzVar.zzb()).p(zzfzVar.zzc()).o(zza(zzfzVar.f())).n(zzbwVar);
        if (zzfzVar.g() > 0) {
            n10.m(zzfzVar.g() * 1000);
        }
        x xVar = (x) ((x4) n10.zzf());
        if (byteBuffer.isDirect()) {
            d10 = this.zzd.b(this.zzf, byteBuffer, xVar);
        } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            d10 = this.zzd.d(this.zzf, byteBuffer.array(), xVar);
        } else {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            d10 = this.zzd.d(this.zzf, bArr, xVar);
        }
        return d10 != null ? zza(d10) : new ArrayList();
    }

    private static zzcc zza(int i10) {
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
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Unsupported rotation degree: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    private final List<zzgf> zza(zzci.b bVar) {
        float f10;
        float f11;
        float f12;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i10;
        int i11;
        char c4;
        ArrayList arrayList3 = new ArrayList();
        for (zzmt zzmtVar : bVar.y().y()) {
            int i12 = -1;
            if (this.zzc.O() == zzck.ALL_CLASSIFICATIONS) {
                float f13 = -1.0f;
                float f14 = -1.0f;
                float f15 = -1.0f;
                for (zzmt.zza zzaVar : zzmtVar.G()) {
                    String x10 = zzaVar.x();
                    x10.hashCode();
                    switch (x10.hashCode()) {
                        case -1940789646:
                            if (x10.equals("left_eye_closed")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -1837755075:
                            if (x10.equals("right_eye_closed")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 105428:
                            if (x10.equals("joy")) {
                                c4 = 2;
                                break;
                            }
                            break;
                    }
                    c4 = 65535;
                    switch (c4) {
                        case 0:
                            f13 = 1.0f - zzaVar.y();
                            break;
                        case 1:
                            f14 = 1.0f - zzaVar.y();
                            break;
                        case 2:
                            f15 = zzaVar.y();
                            break;
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
            if (this.zzc.x() == zzcp.ALL_LANDMARKS) {
                List<zzmt.zze> A = zzmtVar.A();
                ArrayList arrayList4 = new ArrayList();
                for (zzmt.zze zzeVar : A) {
                    zzmt.zze.zzb z10 = zzeVar.z();
                    switch (a.f25919a[z10.ordinal()]) {
                        case 1:
                            i11 = 4;
                            break;
                        case 2:
                            i11 = 10;
                            break;
                        case 3:
                            i11 = 6;
                            break;
                        case 4:
                            i11 = 0;
                            break;
                        case 5:
                            i11 = 5;
                            break;
                        case 6:
                            i11 = 11;
                            break;
                        case 7:
                            i11 = 2;
                            break;
                        case 8:
                            i11 = 3;
                            break;
                        case 9:
                            i11 = 8;
                            break;
                        case 10:
                            i11 = 9;
                            break;
                        case 11:
                            i11 = 1;
                            break;
                        case 12:
                            i11 = 7;
                            break;
                        default:
                            e eVar = zza;
                            String valueOf = String.valueOf(z10);
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                            sb2.append("Unknown landmark type: ");
                            sb2.append(valueOf);
                            eVar.b("FaceDetector", sb2.toString());
                            i11 = -1;
                            break;
                    }
                    if (i11 >= 0) {
                        arrayList4.add(new zzgn(i11, new PointF(zzeVar.x(), zzeVar.y())));
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = new ArrayList();
            }
            if (this.zzc.x() == zzcp.CONTOUR_LANDMARKS) {
                List<zzci.zzb> list = (List) zzmtVar.y(zzci.f25742a);
                ArrayList arrayList5 = new ArrayList();
                for (zzci.zzb zzbVar : list) {
                    zzci.zzb.zzc x11 = zzbVar.x();
                    switch (a.f25920b[x11.ordinal()]) {
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
                            int zza2 = x11.zza();
                            StringBuilder sb3 = new StringBuilder(33);
                            sb3.append("Unknown contour type: ");
                            sb3.append(zza2);
                            eVar2.b("FaceDetector", sb3.toString());
                            i10 = -1;
                            break;
                    }
                    if (i10 != i12) {
                        ArrayList arrayList6 = new ArrayList();
                        for (zzci.zzb.b bVar2 : zzbVar.y()) {
                            arrayList6.add(new PointF(bVar2.x(), bVar2.y()));
                        }
                        arrayList5.add(new zzgb(i10, arrayList6));
                        i12 = -1;
                    }
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = new ArrayList();
            }
            zzmt.a z11 = zzmtVar.z();
            arrayList3.add(new zzgf((int) zzmtVar.H(), new Rect((int) z11.x(), (int) z11.y(), (int) z11.z(), (int) z11.A()), zzmtVar.D(), zzmtVar.E(), zzmtVar.F(), f10, f11, f12, zzmtVar.B() ? zzmtVar.C() : -1.0f, arrayList, arrayList2));
        }
        return arrayList3;
    }
}
