package com.cupidapp.live.hashtag.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagTowardNewResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagTowardNewResult {

    @Nullable
    private final Boolean towardNew;

    public HashTagTowardNewResult(@Nullable Boolean bool) {
        this.towardNew = bool;
    }

    public static /* synthetic */ HashTagTowardNewResult copy$default(HashTagTowardNewResult hashTagTowardNewResult, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = hashTagTowardNewResult.towardNew;
        }
        return hashTagTowardNewResult.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.towardNew;
    }

    @NotNull
    public final HashTagTowardNewResult copy(@Nullable Boolean bool) {
        return new HashTagTowardNewResult(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HashTagTowardNewResult) && s.d(this.towardNew, ((HashTagTowardNewResult) obj).towardNew);
    }

    @Nullable
    public final Boolean getTowardNew() {
        return this.towardNew;
    }

    public int hashCode() {
        Boolean bool = this.towardNew;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        return "HashTagTowardNewResult(towardNew=" + ((Object) this.towardNew) + ")";
    }
}
