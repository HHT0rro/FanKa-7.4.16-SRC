package o8;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.h;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.vision.face.FaceDetector;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {
    @NonNull
    public static FaceDetector a(@RecentlyNonNull d dVar) {
        h.i(dVar, "You must provide a valid FaceDetectorOptions.");
        return ((p8.d) i.c().a(p8.d.class)).a(dVar);
    }
}
