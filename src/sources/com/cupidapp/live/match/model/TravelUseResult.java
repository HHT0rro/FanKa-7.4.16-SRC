package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelMapModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelUseResult {

    @Nullable
    private final String url;

    public TravelUseResult(@Nullable String str) {
        this.url = str;
    }

    public static /* synthetic */ TravelUseResult copy$default(TravelUseResult travelUseResult, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = travelUseResult.url;
        }
        return travelUseResult.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final TravelUseResult copy(@Nullable String str) {
        return new TravelUseResult(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TravelUseResult) && s.d(this.url, ((TravelUseResult) obj).url);
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "TravelUseResult(url=" + this.url + ")";
    }
}
