package n8;

import com.google.mlkit.vision.common.internal.MobileVisionBase;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final /* synthetic */ class f implements p7.c {

    /* renamed from: a, reason: collision with root package name */
    public static final p7.c f52171a = new f();

    @Override // p7.c
    public final void onFailure(Exception exc) {
        MobileVisionBase.f27084f.d("MobileVisionBase", "Error preloading model resource", exc);
    }
}
