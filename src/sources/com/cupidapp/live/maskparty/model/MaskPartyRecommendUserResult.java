package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyRecommendModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyRecommendUserResult {

    @Nullable
    private final MaskPartyRecommendUserModel info;

    public MaskPartyRecommendUserResult(@Nullable MaskPartyRecommendUserModel maskPartyRecommendUserModel) {
        this.info = maskPartyRecommendUserModel;
    }

    public static /* synthetic */ MaskPartyRecommendUserResult copy$default(MaskPartyRecommendUserResult maskPartyRecommendUserResult, MaskPartyRecommendUserModel maskPartyRecommendUserModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            maskPartyRecommendUserModel = maskPartyRecommendUserResult.info;
        }
        return maskPartyRecommendUserResult.copy(maskPartyRecommendUserModel);
    }

    @Nullable
    public final MaskPartyRecommendUserModel component1() {
        return this.info;
    }

    @NotNull
    public final MaskPartyRecommendUserResult copy(@Nullable MaskPartyRecommendUserModel maskPartyRecommendUserModel) {
        return new MaskPartyRecommendUserResult(maskPartyRecommendUserModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MaskPartyRecommendUserResult) && s.d(this.info, ((MaskPartyRecommendUserResult) obj).info);
    }

    @Nullable
    public final MaskPartyRecommendUserModel getInfo() {
        return this.info;
    }

    public int hashCode() {
        MaskPartyRecommendUserModel maskPartyRecommendUserModel = this.info;
        if (maskPartyRecommendUserModel == null) {
            return 0;
        }
        return maskPartyRecommendUserModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyRecommendUserResult(info=" + ((Object) this.info) + ")";
    }
}
