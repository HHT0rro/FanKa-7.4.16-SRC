package o8;

import android.graphics.PointF;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.mlkit_vision_face.u9;
import com.google.android.gms.internal.mlkit_vision_face.v9;
import java.util.List;
import sun.security.x509.CRLDistributionPointsExtension;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f52372a;

    /* renamed from: b, reason: collision with root package name */
    public final List<PointF> f52373b;

    public b(int i10, @RecentlyNonNull List<PointF> list) {
        this.f52372a = i10;
        this.f52373b = list;
    }

    @RecentlyNonNull
    public String toString() {
        u9 a10 = v9.a("FaceContour");
        a10.d("type", this.f52372a);
        a10.a(CRLDistributionPointsExtension.POINTS, this.f52373b.toArray());
        return a10.toString();
    }
}
