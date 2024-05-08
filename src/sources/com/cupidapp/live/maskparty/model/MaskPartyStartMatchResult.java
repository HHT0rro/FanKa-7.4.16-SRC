package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyStartMatchResult {

    @Nullable
    private final Integer confineMatchSeconds;

    public MaskPartyStartMatchResult(@Nullable Integer num) {
        this.confineMatchSeconds = num;
    }

    public static /* synthetic */ MaskPartyStartMatchResult copy$default(MaskPartyStartMatchResult maskPartyStartMatchResult, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = maskPartyStartMatchResult.confineMatchSeconds;
        }
        return maskPartyStartMatchResult.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.confineMatchSeconds;
    }

    @NotNull
    public final MaskPartyStartMatchResult copy(@Nullable Integer num) {
        return new MaskPartyStartMatchResult(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MaskPartyStartMatchResult) && s.d(this.confineMatchSeconds, ((MaskPartyStartMatchResult) obj).confineMatchSeconds);
    }

    @Nullable
    public final Integer getConfineMatchSeconds() {
        return this.confineMatchSeconds;
    }

    public int hashCode() {
        Integer num = this.confineMatchSeconds;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyStartMatchResult(confineMatchSeconds=" + ((Object) this.confineMatchSeconds) + ")";
    }
}
