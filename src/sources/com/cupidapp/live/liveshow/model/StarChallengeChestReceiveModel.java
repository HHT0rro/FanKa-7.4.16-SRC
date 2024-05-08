package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeChestReceiveModel {

    @Nullable
    private final String message;

    public StarChallengeChestReceiveModel(@Nullable String str) {
        this.message = str;
    }

    public static /* synthetic */ StarChallengeChestReceiveModel copy$default(StarChallengeChestReceiveModel starChallengeChestReceiveModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = starChallengeChestReceiveModel.message;
        }
        return starChallengeChestReceiveModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final StarChallengeChestReceiveModel copy(@Nullable String str) {
        return new StarChallengeChestReceiveModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StarChallengeChestReceiveModel) && s.d(this.message, ((StarChallengeChestReceiveModel) obj).message);
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
        return "StarChallengeChestReceiveModel(message=" + this.message + ")";
    }
}
