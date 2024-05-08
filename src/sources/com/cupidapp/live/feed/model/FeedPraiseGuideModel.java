package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedPraiseGuideModel {
    private boolean isClickPraiseButton;
    private boolean isFirstDisplay;
    private int showPosition;

    public FeedPraiseGuideModel() {
        this(false, 0, false, 7, null);
    }

    public FeedPraiseGuideModel(boolean z10, int i10, boolean z11) {
        this.isFirstDisplay = z10;
        this.showPosition = i10;
        this.isClickPraiseButton = z11;
    }

    public static /* synthetic */ FeedPraiseGuideModel copy$default(FeedPraiseGuideModel feedPraiseGuideModel, boolean z10, int i10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = feedPraiseGuideModel.isFirstDisplay;
        }
        if ((i11 & 2) != 0) {
            i10 = feedPraiseGuideModel.showPosition;
        }
        if ((i11 & 4) != 0) {
            z11 = feedPraiseGuideModel.isClickPraiseButton;
        }
        return feedPraiseGuideModel.copy(z10, i10, z11);
    }

    public final boolean component1() {
        return this.isFirstDisplay;
    }

    public final int component2() {
        return this.showPosition;
    }

    public final boolean component3() {
        return this.isClickPraiseButton;
    }

    public final void configFeedPraiseGuideNotShow() {
        g gVar = g.f52734a;
        FeedPraiseGuideModel A = gVar.A();
        if (A != null && A.isFirstDisplay) {
            A.isFirstDisplay = false;
            gVar.k2(A);
        }
    }

    @NotNull
    public final FeedPraiseGuideModel copy(boolean z10, int i10, boolean z11) {
        return new FeedPraiseGuideModel(z10, i10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedPraiseGuideModel)) {
            return false;
        }
        FeedPraiseGuideModel feedPraiseGuideModel = (FeedPraiseGuideModel) obj;
        return this.isFirstDisplay == feedPraiseGuideModel.isFirstDisplay && this.showPosition == feedPraiseGuideModel.showPosition && this.isClickPraiseButton == feedPraiseGuideModel.isClickPraiseButton;
    }

    public final int getShowPosition() {
        return this.showPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.isFirstDisplay;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = ((r02 * 31) + this.showPosition) * 31;
        boolean z11 = this.isClickPraiseButton;
        return i10 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isClickPraiseButton() {
        return this.isClickPraiseButton;
    }

    public final boolean isFirstDisplay() {
        return this.isFirstDisplay;
    }

    public final void praiseButtonWasClicked(int i10) {
        g gVar = g.f52734a;
        FeedPraiseGuideModel A = gVar.A();
        boolean z10 = false;
        if (A != null && A.isFirstDisplay) {
            z10 = true;
        }
        if (z10) {
            A.showPosition = i10 + 2;
            A.isClickPraiseButton = true;
            gVar.k2(A);
        }
    }

    public final void setClickPraiseButton(boolean z10) {
        this.isClickPraiseButton = z10;
    }

    public final void setFirstDisplay(boolean z10) {
        this.isFirstDisplay = z10;
    }

    public final void setShowPosition(int i10) {
        this.showPosition = i10;
    }

    @NotNull
    public String toString() {
        return "FeedPraiseGuideModel(isFirstDisplay=" + this.isFirstDisplay + ", showPosition=" + this.showPosition + ", isClickPraiseButton=" + this.isClickPraiseButton + ")";
    }

    public /* synthetic */ FeedPraiseGuideModel(boolean z10, int i10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? false : z11);
    }
}
