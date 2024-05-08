package com.cupidapp.live.liveshow.pk.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkScoreUpdateModel {

    @NotNull
    private final List<MultiPkRankModel> anchors;
    private final boolean showBorder;

    public MultiPkScoreUpdateModel(@NotNull List<MultiPkRankModel> anchors, boolean z10) {
        s.i(anchors, "anchors");
        this.anchors = anchors;
        this.showBorder = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiPkScoreUpdateModel copy$default(MultiPkScoreUpdateModel multiPkScoreUpdateModel, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = multiPkScoreUpdateModel.anchors;
        }
        if ((i10 & 2) != 0) {
            z10 = multiPkScoreUpdateModel.showBorder;
        }
        return multiPkScoreUpdateModel.copy(list, z10);
    }

    @NotNull
    public final List<MultiPkRankModel> component1() {
        return this.anchors;
    }

    public final boolean component2() {
        return this.showBorder;
    }

    @NotNull
    public final MultiPkScoreUpdateModel copy(@NotNull List<MultiPkRankModel> anchors, boolean z10) {
        s.i(anchors, "anchors");
        return new MultiPkScoreUpdateModel(anchors, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkScoreUpdateModel)) {
            return false;
        }
        MultiPkScoreUpdateModel multiPkScoreUpdateModel = (MultiPkScoreUpdateModel) obj;
        return s.d(this.anchors, multiPkScoreUpdateModel.anchors) && this.showBorder == multiPkScoreUpdateModel.showBorder;
    }

    @NotNull
    public final List<MultiPkRankModel> getAnchors() {
        return this.anchors;
    }

    public final boolean getShowBorder() {
        return this.showBorder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.anchors.hashCode() * 31;
        boolean z10 = this.showBorder;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        List<MultiPkRankModel> list = this.anchors;
        return "MultiPkScoreUpdateModel(anchors=" + ((Object) list) + ", showBorder=" + this.showBorder + ")";
    }
}
