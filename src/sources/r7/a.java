package r7;

import com.google.android.gms.internal.vision.j2;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.VisionClearcutLogger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f53295b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j2 f53296c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DynamiteClearcutLogger f53297d;

    public a(DynamiteClearcutLogger dynamiteClearcutLogger, int i10, j2 j2Var) {
        this.f53297d = dynamiteClearcutLogger;
        this.f53295b = i10;
        this.f53296c = j2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VisionClearcutLogger visionClearcutLogger;
        visionClearcutLogger = this.f53297d.zzc;
        visionClearcutLogger.zza(this.f53295b, this.f53296c);
    }
}
