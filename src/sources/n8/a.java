package n8;

import android.os.SystemClock;
import androidx.annotation.RecentlyNonNull;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.internal.e f52164c = new com.google.android.gms.common.internal.e("StreamingFormatChecker", "");

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<Long> f52165a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    public long f52166b = -1;

    public void a(@RecentlyNonNull m8.a aVar) {
        if (aVar.d() != -1) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f52165a.add(Long.valueOf(elapsedRealtime));
        if (this.f52165a.size() > 5) {
            this.f52165a.removeFirst();
        }
        if (this.f52165a.size() != 5 || elapsedRealtime - ((Long) com.google.android.gms.common.internal.h.h(this.f52165a.peekFirst())).longValue() >= 5000) {
            return;
        }
        long j10 = this.f52166b;
        if (j10 == -1 || elapsedRealtime - j10 >= TimeUnit.SECONDS.toMillis(5L)) {
            this.f52166b = elapsedRealtime;
            f52164c.f("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
        }
    }
}
