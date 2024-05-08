package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyRecommendModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyRecommendModel {

    @NotNull
    private final List<String> candidateTab;

    @NotNull
    private final String matchUserId;
    private final int type;

    public MaskPartyRecommendModel(int i10, @NotNull String matchUserId, @NotNull List<String> candidateTab) {
        s.i(matchUserId, "matchUserId");
        s.i(candidateTab, "candidateTab");
        this.type = i10;
        this.matchUserId = matchUserId;
        this.candidateTab = candidateTab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaskPartyRecommendModel copy$default(MaskPartyRecommendModel maskPartyRecommendModel, int i10, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = maskPartyRecommendModel.type;
        }
        if ((i11 & 2) != 0) {
            str = maskPartyRecommendModel.matchUserId;
        }
        if ((i11 & 4) != 0) {
            list = maskPartyRecommendModel.candidateTab;
        }
        return maskPartyRecommendModel.copy(i10, str, list);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.matchUserId;
    }

    @NotNull
    public final List<String> component3() {
        return this.candidateTab;
    }

    @NotNull
    public final MaskPartyRecommendModel copy(int i10, @NotNull String matchUserId, @NotNull List<String> candidateTab) {
        s.i(matchUserId, "matchUserId");
        s.i(candidateTab, "candidateTab");
        return new MaskPartyRecommendModel(i10, matchUserId, candidateTab);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyRecommendModel)) {
            return false;
        }
        MaskPartyRecommendModel maskPartyRecommendModel = (MaskPartyRecommendModel) obj;
        return this.type == maskPartyRecommendModel.type && s.d(this.matchUserId, maskPartyRecommendModel.matchUserId) && s.d(this.candidateTab, maskPartyRecommendModel.candidateTab);
    }

    @NotNull
    public final List<String> getCandidateTab() {
        return this.candidateTab;
    }

    @NotNull
    public final String getMatchUserId() {
        return this.matchUserId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type * 31) + this.matchUserId.hashCode()) * 31) + this.candidateTab.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyRecommendModel(type=" + this.type + ", matchUserId=" + this.matchUserId + ", candidateTab=" + ((Object) this.candidateTab) + ")";
    }
}
