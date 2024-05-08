package p8;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.vision.dynamite.face.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_face.zzld;
import com.google.android.gms.internal.mlkit_vision_face.zzlh;
import com.google.android.gms.internal.mlkit_vision_face.zzlj;
import com.google.android.gms.internal.mlkit_vision_face.zzll;
import com.google.android.gms.internal.mlkit_vision_face.zzln;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52940a;

    /* renamed from: b, reason: collision with root package name */
    public final o8.d f52941b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f52942c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f52943d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public zzll f52944e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public zzll f52945f;

    public a(Context context, o8.d dVar) {
        this.f52940a = context;
        this.f52941b = dVar;
    }

    public static boolean b(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > 0;
    }

    public static List<o8.a> f(zzll zzllVar, m8.a aVar) throws MlKitException {
        try {
            List<zzlj> zzf = zzllVar.zzf(n8.d.b().a(aVar), new zzld(aVar.d(), aVar.i(), aVar.e(), n8.b.a(aVar.h()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            Iterator<zzlj> iterator2 = zzf.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(new o8.a(iterator2.next()));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to run face detector.", 13, e2);
        }
    }

    @Override // p8.b
    @WorkerThread
    public final Pair<List<o8.a>, List<o8.a>> a(m8.a aVar) throws MlKitException {
        List<o8.a> list;
        zza();
        zzll zzllVar = this.f52945f;
        if (zzllVar == null && this.f52944e == null) {
            throw new MlKitException("Waiting for the face detection module to be downloaded. Please wait.", 14);
        }
        List<o8.a> list2 = null;
        if (zzllVar != null) {
            list = f(zzllVar, aVar);
            if (!this.f52941b.e()) {
                h.j(list);
            }
        } else {
            list = null;
        }
        zzll zzllVar2 = this.f52944e;
        if (zzllVar2 != null) {
            list2 = f(zzllVar2, aVar);
            h.j(list2);
        }
        return new Pair<>(list, list2);
    }

    @VisibleForTesting
    public final zzll c(DynamiteModule.a aVar, String str, String str2, zzlh zzlhVar) throws DynamiteModule.LoadingException, RemoteException {
        return zzln.zza(DynamiteModule.c(this.f52940a, aVar, str).b("com.google.android.gms.vision.face.mlkit.FaceDetectorCreator")).zzd(ObjectWrapper.wrap(this.f52940a), zzlhVar);
    }

    public final void d() throws DynamiteModule.LoadingException, RemoteException {
        if (this.f52941b.b() != 2) {
            if (this.f52945f == null) {
                zzll e2 = e(new zzlh(this.f52941b.d(), this.f52941b.a(), this.f52941b.c(), 1, this.f52941b.e(), this.f52941b.f()));
                this.f52945f = e2;
                e2.zzd();
                return;
            }
            return;
        }
        if (this.f52944e == null) {
            zzll e10 = e(new zzlh(this.f52941b.d(), 1, 1, 2, false, this.f52941b.f()));
            this.f52944e = e10;
            e10.zzd();
        }
        if ((this.f52941b.a() == 2 || this.f52941b.c() == 2 || this.f52941b.d() == 2) && this.f52945f == null) {
            zzll e11 = e(new zzlh(this.f52941b.d(), this.f52941b.a(), this.f52941b.c(), 1, this.f52941b.e(), this.f52941b.f()));
            this.f52945f = e11;
            e11.zzd();
        }
    }

    public final zzll e(zzlh zzlhVar) throws DynamiteModule.LoadingException, RemoteException {
        if (this.f52942c) {
            return c(DynamiteModule.f23772j, ModuleDescriptor.MODULE_ID, "com.google.android.gms.vision.face.mlkit.FaceDetectorCreator", zzlhVar);
        }
        return c(DynamiteModule.f23771i, "com.google.android.gms.vision.face", "com.google.android.gms.vision.face.mlkit.FaceDetectorCreator", zzlhVar);
    }

    @Override // p8.b
    @WorkerThread
    public final boolean zza() throws MlKitException {
        if (this.f52945f == null && this.f52944e == null) {
            if (DynamiteModule.a(this.f52940a, ModuleDescriptor.MODULE_ID) > 0) {
                this.f52942c = true;
                try {
                    d();
                } catch (RemoteException e2) {
                    throw new MlKitException("Failed to init thick face detector.", 13, e2);
                } catch (DynamiteModule.LoadingException e10) {
                    throw new MlKitException("Failed to load the bundled face module.", 14, e10);
                }
            } else {
                this.f52942c = false;
                try {
                    d();
                } catch (RemoteException e11) {
                    throw new MlKitException("Failed to init thin face detector.", 13, e11);
                } catch (DynamiteModule.LoadingException unused) {
                    if (!this.f52943d) {
                        com.google.mlkit.common.sdkinternal.l.a(this.f52940a, "face");
                        this.f52943d = true;
                    }
                }
            }
            return this.f52942c;
        }
        return this.f52942c;
    }

    @Override // p8.b
    @WorkerThread
    public final void zzc() {
        try {
            zzll zzllVar = this.f52945f;
            if (zzllVar != null) {
                zzllVar.zze();
                this.f52945f = null;
            }
            zzll zzllVar2 = this.f52944e;
            if (zzllVar2 != null) {
                zzllVar2.zze();
                this.f52944e = null;
            }
        } catch (RemoteException unused) {
        }
    }
}
