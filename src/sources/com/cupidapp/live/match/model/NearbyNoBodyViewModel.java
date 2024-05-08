package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyNoBodyViewModel {

    @Nullable
    private final String message;

    public NearbyNoBodyViewModel(@Nullable String str) {
        this.message = str;
    }

    public static /* synthetic */ NearbyNoBodyViewModel copy$default(NearbyNoBodyViewModel nearbyNoBodyViewModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nearbyNoBodyViewModel.message;
        }
        return nearbyNoBodyViewModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final NearbyNoBodyViewModel copy(@Nullable String str) {
        return new NearbyNoBodyViewModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NearbyNoBodyViewModel) && s.d(this.message, ((NearbyNoBodyViewModel) obj).message);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.message;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearbyNoBodyViewModel(message=" + this.message + ")";
    }
}
