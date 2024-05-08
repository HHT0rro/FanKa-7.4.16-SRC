package com.cupidapp.live.smartrefresh.layout.constant;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: RefreshState.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum RefreshState {
    None(0, false, false, false, false, false),
    PullDownToRefresh(1, true, false, false, false, false),
    PullDownCanceled(1, false, false, false, false, false),
    ReleaseToRefresh(1, true, false, false, false, true),
    ReleaseToTwoLevel(1, true, false, false, true, true),
    TwoLevelReleased(1, false, false, false, true, false),
    TwoLevel(1, false, true, false, true, false),
    TwoLevelFinish(1, false, false, true, true, false);

    private final boolean isDragging;
    private final boolean isFinishing;
    private final boolean isHeader;
    private final boolean isOpening;
    private final boolean isReleaseToOpening;
    private final boolean isTwoLevel;

    RefreshState(int i10, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.isHeader = i10 == 1;
        this.isTwoLevel = z13;
        this.isDragging = z10;
        this.isOpening = z11;
        this.isFinishing = z12;
        this.isReleaseToOpening = z14;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final boolean isFinishing() {
        return this.isFinishing;
    }

    public final boolean isHeader() {
        return this.isHeader;
    }

    public final boolean isOpening() {
        return this.isOpening;
    }

    public final boolean isReleaseToOpening() {
        return this.isReleaseToOpening;
    }

    public final boolean isTwoLevel() {
        return this.isTwoLevel;
    }

    @NotNull
    public final RefreshState toFooter() {
        return (!this.isHeader || this.isTwoLevel) ? this : values()[ordinal() + 1];
    }

    @NotNull
    public final RefreshState toHeader() {
        return !this.isTwoLevel ? values()[ordinal() - 1] : this;
    }
}
