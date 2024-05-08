package p8;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import com.google.android.gms.internal.mlkit_vision_face.zzl;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzp;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class l implements b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f52966a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f52967b;

    /* renamed from: c, reason: collision with root package name */
    public final o8.d f52968c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52969d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public zzj f52970e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public zzj f52971f;

    public l(Context context, o8.d dVar) {
        this.f52967b = context;
        this.f52968c = dVar;
        this.f52969d = com.google.android.gms.common.b.f().a(context);
    }

    public static int b(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("Invalid landmark type: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int c(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Invalid classification type: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int d(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("Invalid mode type: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // p8.b
    @WorkerThread
    public final Pair<List<o8.a>, List<o8.a>> a(m8.a aVar) throws MlKitException {
        List<o8.a> list;
        if (this.f52970e == null && this.f52971f == null) {
            zza();
        }
        zzj zzjVar = this.f52970e;
        if (zzjVar == null && this.f52971f == null) {
            throw new MlKitException("Waiting for the face detection module to be downloaded. Please wait.", 14);
        }
        List<o8.a> list2 = null;
        if (zzjVar != null) {
            list = e(zzjVar, aVar);
            if (!this.f52968c.e()) {
                h.j(list);
            }
        } else {
            list = null;
        }
        zzj zzjVar2 = this.f52971f;
        if (zzjVar2 != null) {
            list2 = e(zzjVar2, aVar);
            h.j(list2);
        }
        return new Pair<>(list, list2);
    }

    public final List<o8.a> e(zzj zzjVar, m8.a aVar) throws MlKitException {
        zzf[] zzd;
        try {
            zzp zzpVar = new zzp(aVar.i(), aVar.e(), 0, SystemClock.elapsedRealtime(), n8.b.a(aVar.h()));
            if (aVar.d() == 35 && this.f52969d >= 201500000) {
                Image.Plane[] planeArr = (Image.Plane[]) com.google.android.gms.common.internal.h.h(aVar.g());
                zzd = zzjVar.zze(ObjectWrapper.wrap(planeArr[0].getBuffer()), ObjectWrapper.wrap(planeArr[1].getBuffer()), ObjectWrapper.wrap(planeArr[2].getBuffer()), planeArr[0].getPixelStride(), planeArr[1].getPixelStride(), planeArr[2].getPixelStride(), planeArr[0].getRowStride(), planeArr[1].getRowStride(), planeArr[2].getRowStride(), zzpVar);
            } else {
                zzd = zzjVar.zzd(ObjectWrapper.wrap(n8.c.b().a(aVar, false)), zzpVar);
            }
            ArrayList arrayList = new ArrayList();
            for (zzf zzfVar : zzd) {
                arrayList.add(new o8.a(zzfVar));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to detect with legacy face detector", 13, e2);
        }
    }

    @Override // p8.b
    @WorkerThread
    public final boolean zza() throws MlKitException {
        if (this.f52970e != null || this.f52971f != null) {
            return false;
        }
        try {
            zzm zza = zzl.zza(DynamiteModule.c(this.f52967b, DynamiteModule.f23771i, "com.google.android.gms.vision.dynamite").b("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
            IObjectWrapper wrap = ObjectWrapper.wrap(this.f52967b);
            if (this.f52968c.b() == 2) {
                if (this.f52971f == null) {
                    this.f52971f = zza.zzd(wrap, new zzh(2, 2, 0, true, false, this.f52968c.f()));
                }
                if ((this.f52968c.a() == 2 || this.f52968c.c() == 2 || this.f52968c.d() == 2) && this.f52970e == null) {
                    this.f52970e = zza.zzd(wrap, new zzh(d(this.f52968c.d()), b(this.f52968c.a()), c(this.f52968c.c()), false, this.f52968c.e(), this.f52968c.f()));
                }
            } else if (this.f52970e == null) {
                this.f52970e = zza.zzd(wrap, new zzh(d(this.f52968c.d()), b(this.f52968c.a()), c(this.f52968c.c()), false, this.f52968c.e(), this.f52968c.f()));
            }
            if (this.f52970e == null && this.f52971f == null && !this.f52966a) {
                com.google.mlkit.common.sdkinternal.l.a(this.f52967b, "barcode");
                this.f52966a = true;
            }
            return false;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to create legacy face detector.", 13, e2);
        } catch (DynamiteModule.LoadingException e10) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e10);
        }
    }

    @Override // p8.b
    @WorkerThread
    public final void zzc() {
        zzj zzjVar = this.f52970e;
        if (zzjVar != null) {
            try {
                zzjVar.zzf();
            } catch (RemoteException unused) {
            }
            this.f52970e = null;
        }
        zzj zzjVar2 = this.f52971f;
        if (zzjVar2 != null) {
            try {
                zzjVar2.zzf();
            } catch (RemoteException unused2) {
            }
            this.f52971f = null;
        }
    }
}
