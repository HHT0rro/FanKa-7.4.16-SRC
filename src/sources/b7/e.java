package b7;

import android.content.Context;
import android.os.DropBoxManager;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1401a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static DropBoxManager f1402b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1403c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f1404d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static int f1405e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static int f1406f = 0;

    @RecentlyNonNull
    public static boolean a(@RecentlyNonNull Context context, @RecentlyNonNull Throwable th) {
        return b(context, th, 536870912);
    }

    public static boolean b(Context context, Throwable th, int i10) {
        try {
            com.google.android.gms.common.internal.h.h(context);
            com.google.android.gms.common.internal.h.h(th);
        } catch (Exception unused) {
        }
        return false;
    }
}
