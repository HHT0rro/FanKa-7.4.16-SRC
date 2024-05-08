package o8;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.mlkit_vision_face.u9;
import com.google.android.gms.internal.mlkit_vision_face.v9;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f52388a;

    /* renamed from: b, reason: collision with root package name */
    public final PointF f52389b;

    public e(int i10, @NonNull PointF pointF) {
        this.f52388a = i10;
        this.f52389b = pointF;
    }

    @RecentlyNonNull
    public String toString() {
        u9 a10 = v9.a("FaceLandmark");
        a10.d("type", this.f52388a);
        a10.a("position", this.f52389b);
        return a10.toString();
    }
}
