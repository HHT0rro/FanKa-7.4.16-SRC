package p8;

import androidx.annotation.NonNull;
import com.google.mlkit.vision.face.internal.FaceDetectorImpl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f52946a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.d f52947b;

    public d(e eVar, com.google.mlkit.common.sdkinternal.d dVar) {
        this.f52946a = eVar;
        this.f52947b = dVar;
    }

    @NonNull
    public final FaceDetectorImpl a(@NonNull o8.d dVar) {
        com.google.android.gms.common.internal.h.i(dVar, "You must provide a valid FaceDetectorOptions.");
        return new FaceDetectorImpl(this.f52946a.b(dVar), this.f52947b, dVar, null);
    }
}
