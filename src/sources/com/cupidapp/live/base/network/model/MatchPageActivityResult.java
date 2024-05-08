package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MatchPageActivityResult {

    @Nullable
    private final MatchPageActivityModel activityView;

    public MatchPageActivityResult(@Nullable MatchPageActivityModel matchPageActivityModel) {
        this.activityView = matchPageActivityModel;
    }

    public static /* synthetic */ MatchPageActivityResult copy$default(MatchPageActivityResult matchPageActivityResult, MatchPageActivityModel matchPageActivityModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matchPageActivityModel = matchPageActivityResult.activityView;
        }
        return matchPageActivityResult.copy(matchPageActivityModel);
    }

    @Nullable
    public final MatchPageActivityModel component1() {
        return this.activityView;
    }

    @NotNull
    public final MatchPageActivityResult copy(@Nullable MatchPageActivityModel matchPageActivityModel) {
        return new MatchPageActivityResult(matchPageActivityModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MatchPageActivityResult) && s.d(this.activityView, ((MatchPageActivityResult) obj).activityView);
    }

    @Nullable
    public final MatchPageActivityModel getActivityView() {
        return this.activityView;
    }

    public int hashCode() {
        MatchPageActivityModel matchPageActivityModel = this.activityView;
        if (matchPageActivityModel == null) {
            return 0;
        }
        return matchPageActivityModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchPageActivityResult(activityView=" + ((Object) this.activityView) + ")";
    }
}
