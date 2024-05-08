package com.cupidapp.live.match.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchCardUserSpecInfoModel implements Serializable {
    private final int type;

    @NotNull
    private final String value;

    public MatchCardUserSpecInfoModel(int i10, @NotNull String value) {
        s.i(value, "value");
        this.type = i10;
        this.value = value;
    }

    public static /* synthetic */ MatchCardUserSpecInfoModel copy$default(MatchCardUserSpecInfoModel matchCardUserSpecInfoModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = matchCardUserSpecInfoModel.type;
        }
        if ((i11 & 2) != 0) {
            str = matchCardUserSpecInfoModel.value;
        }
        return matchCardUserSpecInfoModel.copy(i10, str);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final MatchCardUserSpecInfoModel copy(int i10, @NotNull String value) {
        s.i(value, "value");
        return new MatchCardUserSpecInfoModel(i10, value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchCardUserSpecInfoModel)) {
            return false;
        }
        MatchCardUserSpecInfoModel matchCardUserSpecInfoModel = (MatchCardUserSpecInfoModel) obj;
        return this.type == matchCardUserSpecInfoModel.type && s.d(this.value, matchCardUserSpecInfoModel.value);
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.type * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchCardUserSpecInfoModel(type=" + this.type + ", value=" + this.value + ")";
    }
}
