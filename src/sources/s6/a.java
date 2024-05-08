package s6;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static int f53623b = 31;

    /* renamed from: a, reason: collision with root package name */
    public int f53624a = 1;

    @RecentlyNonNull
    public a a(@Nullable Object obj) {
        this.f53624a = (f53623b * this.f53624a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @RecentlyNonNull
    public int b() {
        return this.f53624a;
    }

    @RecentlyNonNull
    public final a c(@RecentlyNonNull boolean z10) {
        this.f53624a = (f53623b * this.f53624a) + (z10 ? 1 : 0);
        return this;
    }
}
