package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedZoomGuideModel {
    private int bottomPosition;
    private boolean isFirstDisplay;
    private int topPosition;

    public FeedZoomGuideModel() {
        this(false, 0, 0, 7, null);
    }

    public FeedZoomGuideModel(boolean z10, int i10, int i11) {
        this.isFirstDisplay = z10;
        this.topPosition = i10;
        this.bottomPosition = i11;
    }

    public static /* synthetic */ FeedZoomGuideModel copy$default(FeedZoomGuideModel feedZoomGuideModel, boolean z10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            z10 = feedZoomGuideModel.isFirstDisplay;
        }
        if ((i12 & 2) != 0) {
            i10 = feedZoomGuideModel.topPosition;
        }
        if ((i12 & 4) != 0) {
            i11 = feedZoomGuideModel.bottomPosition;
        }
        return feedZoomGuideModel.copy(z10, i10, i11);
    }

    public final boolean component1() {
        return this.isFirstDisplay;
    }

    public final int component2() {
        return this.topPosition;
    }

    public final int component3() {
        return this.bottomPosition;
    }

    @NotNull
    public final FeedZoomGuideModel copy(boolean z10, int i10, int i11) {
        return new FeedZoomGuideModel(z10, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedZoomGuideModel)) {
            return false;
        }
        FeedZoomGuideModel feedZoomGuideModel = (FeedZoomGuideModel) obj;
        return this.isFirstDisplay == feedZoomGuideModel.isFirstDisplay && this.topPosition == feedZoomGuideModel.topPosition && this.bottomPosition == feedZoomGuideModel.bottomPosition;
    }

    public final int getBottomPosition() {
        return this.bottomPosition;
    }

    public final int getTopPosition() {
        return this.topPosition;
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
        return (((r02 * 31) + this.topPosition) * 31) + this.bottomPosition;
    }

    public final void initFeedZoomGuideShowPosition(int i10) {
        g gVar = g.f52734a;
        FeedZoomGuideModel D = gVar.D();
        if (D != null && D.isFirstDisplay) {
            D.topPosition = i10 - 10;
            D.bottomPosition = i10 + 10;
            gVar.n2(D);
        }
    }

    public final boolean isFirstDisplay() {
        return this.isFirstDisplay;
    }

    public final void setBottomPosition(int i10) {
        this.bottomPosition = i10;
    }

    public final void setFirstDisplay(boolean z10) {
        this.isFirstDisplay = z10;
    }

    public final void setTopPosition(int i10) {
        this.topPosition = i10;
    }

    @NotNull
    public String toString() {
        return "FeedZoomGuideModel(isFirstDisplay=" + this.isFirstDisplay + ", topPosition=" + this.topPosition + ", bottomPosition=" + this.bottomPosition + ")";
    }

    public /* synthetic */ FeedZoomGuideModel(boolean z10, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? true : z10, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }
}
