package d7;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f48652b = new b();

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public a f48653a = null;

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        return f48652b.b(context);
    }

    public final synchronized a b(Context context) {
        if (this.f48653a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f48653a = new a(context);
        }
        return this.f48653a;
    }
}
