package com.cupidapp.live.profile.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileSpecListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompatResult {

    @Nullable
    private final Integer error;

    @Nullable
    private final String errorMessage;

    public CompatResult(@Nullable String str, @Nullable Integer num) {
        this.errorMessage = str;
        this.error = num;
    }

    public static /* synthetic */ CompatResult copy$default(CompatResult compatResult, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = compatResult.errorMessage;
        }
        if ((i10 & 2) != 0) {
            num = compatResult.error;
        }
        return compatResult.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.errorMessage;
    }

    @Nullable
    public final Integer component2() {
        return this.error;
    }

    @NotNull
    public final CompatResult copy(@Nullable String str, @Nullable Integer num) {
        return new CompatResult(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompatResult)) {
            return false;
        }
        CompatResult compatResult = (CompatResult) obj;
        return s.d(this.errorMessage, compatResult.errorMessage) && s.d(this.error, compatResult.error);
    }

    @Nullable
    public final Integer getError() {
        return this.error;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        String str = this.errorMessage;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.error;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompatResult(errorMessage=" + this.errorMessage + ", error=" + ((Object) this.error) + ")";
    }
}
