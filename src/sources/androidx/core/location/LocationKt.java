package androidx.core.location;

import android.location.Location;
import org.jetbrains.annotations.NotNull;

/* compiled from: Location.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LocationKt {
    public static final double component1(@NotNull Location location) {
        kotlin.jvm.internal.s.i(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(@NotNull Location location) {
        kotlin.jvm.internal.s.i(location, "<this>");
        return location.getLongitude();
    }
}
