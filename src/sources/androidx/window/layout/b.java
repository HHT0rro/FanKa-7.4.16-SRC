package androidx.window.layout;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.window.layout.WindowInfoTracker;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowInfoTracker.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final /* synthetic */ class b {
    static {
        WindowInfoTracker.Companion companion = WindowInfoTracker.Companion;
    }

    @NotNull
    public static WindowInfoTracker a(@NotNull Context context) {
        return WindowInfoTracker.Companion.getOrCreate(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void b(@NotNull WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void c() {
        WindowInfoTracker.Companion.reset();
    }
}
