package b7;

import android.os.SystemClock;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1407a = new f();

    @RecentlyNonNull
    public static d c() {
        return f1407a;
    }

    @Override // b7.d
    @RecentlyNonNull
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // b7.d
    @RecentlyNonNull
    public long b() {
        return System.currentTimeMillis();
    }
}
