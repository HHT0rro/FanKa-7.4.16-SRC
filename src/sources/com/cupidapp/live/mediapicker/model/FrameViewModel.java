package com.cupidapp.live.mediapicker.model;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FrameViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FrameViewModel {
    private final int frameIconRes;
    private final int frameNameRes;

    @NotNull
    private final FrameAspectRatio frameType;
    private boolean itemSelected;

    public FrameViewModel(int i10, int i11, boolean z10, @NotNull FrameAspectRatio frameType) {
        s.i(frameType, "frameType");
        this.frameNameRes = i10;
        this.frameIconRes = i11;
        this.itemSelected = z10;
        this.frameType = frameType;
    }

    public static /* synthetic */ FrameViewModel copy$default(FrameViewModel frameViewModel, int i10, int i11, boolean z10, FrameAspectRatio frameAspectRatio, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = frameViewModel.frameNameRes;
        }
        if ((i12 & 2) != 0) {
            i11 = frameViewModel.frameIconRes;
        }
        if ((i12 & 4) != 0) {
            z10 = frameViewModel.itemSelected;
        }
        if ((i12 & 8) != 0) {
            frameAspectRatio = frameViewModel.frameType;
        }
        return frameViewModel.copy(i10, i11, z10, frameAspectRatio);
    }

    public final int component1() {
        return this.frameNameRes;
    }

    public final int component2() {
        return this.frameIconRes;
    }

    public final boolean component3() {
        return this.itemSelected;
    }

    @NotNull
    public final FrameAspectRatio component4() {
        return this.frameType;
    }

    @NotNull
    public final FrameViewModel copy(int i10, int i11, boolean z10, @NotNull FrameAspectRatio frameType) {
        s.i(frameType, "frameType");
        return new FrameViewModel(i10, i11, z10, frameType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrameViewModel)) {
            return false;
        }
        FrameViewModel frameViewModel = (FrameViewModel) obj;
        return this.frameNameRes == frameViewModel.frameNameRes && this.frameIconRes == frameViewModel.frameIconRes && this.itemSelected == frameViewModel.itemSelected && this.frameType == frameViewModel.frameType;
    }

    public final int getFrameIconRes() {
        return this.frameIconRes;
    }

    public final int getFrameNameRes() {
        return this.frameNameRes;
    }

    @NotNull
    public final FrameAspectRatio getFrameType() {
        return this.frameType;
    }

    public final boolean getItemSelected() {
        return this.itemSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i10 = ((this.frameNameRes * 31) + this.frameIconRes) * 31;
        boolean z10 = this.itemSelected;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        return ((i10 + i11) * 31) + this.frameType.hashCode();
    }

    public final void setItemSelected(boolean z10) {
        this.itemSelected = z10;
    }

    @NotNull
    public String toString() {
        return "FrameViewModel(frameNameRes=" + this.frameNameRes + ", frameIconRes=" + this.frameIconRes + ", itemSelected=" + this.itemSelected + ", frameType=" + ((Object) this.frameType) + ")";
    }
}
