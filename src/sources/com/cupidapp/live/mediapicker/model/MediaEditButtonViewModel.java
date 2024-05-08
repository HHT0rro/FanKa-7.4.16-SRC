package com.cupidapp.live.mediapicker.model;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FrameViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MediaEditButtonViewModel {
    private int buttonIconRes;
    private final int buttonNameRes;

    @NotNull
    private final EditButtonEnum buttonType;

    /* compiled from: FrameViewModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum EditButtonEnum {
        Frame,
        Trim,
        Cover
    }

    public MediaEditButtonViewModel(int i10, int i11, @NotNull EditButtonEnum buttonType) {
        s.i(buttonType, "buttonType");
        this.buttonNameRes = i10;
        this.buttonIconRes = i11;
        this.buttonType = buttonType;
    }

    public static /* synthetic */ MediaEditButtonViewModel copy$default(MediaEditButtonViewModel mediaEditButtonViewModel, int i10, int i11, EditButtonEnum editButtonEnum, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = mediaEditButtonViewModel.buttonNameRes;
        }
        if ((i12 & 2) != 0) {
            i11 = mediaEditButtonViewModel.buttonIconRes;
        }
        if ((i12 & 4) != 0) {
            editButtonEnum = mediaEditButtonViewModel.buttonType;
        }
        return mediaEditButtonViewModel.copy(i10, i11, editButtonEnum);
    }

    public final int component1() {
        return this.buttonNameRes;
    }

    public final int component2() {
        return this.buttonIconRes;
    }

    @NotNull
    public final EditButtonEnum component3() {
        return this.buttonType;
    }

    @NotNull
    public final MediaEditButtonViewModel copy(int i10, int i11, @NotNull EditButtonEnum buttonType) {
        s.i(buttonType, "buttonType");
        return new MediaEditButtonViewModel(i10, i11, buttonType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaEditButtonViewModel)) {
            return false;
        }
        MediaEditButtonViewModel mediaEditButtonViewModel = (MediaEditButtonViewModel) obj;
        return this.buttonNameRes == mediaEditButtonViewModel.buttonNameRes && this.buttonIconRes == mediaEditButtonViewModel.buttonIconRes && this.buttonType == mediaEditButtonViewModel.buttonType;
    }

    public final int getButtonIconRes() {
        return this.buttonIconRes;
    }

    public final int getButtonNameRes() {
        return this.buttonNameRes;
    }

    @NotNull
    public final EditButtonEnum getButtonType() {
        return this.buttonType;
    }

    public int hashCode() {
        return (((this.buttonNameRes * 31) + this.buttonIconRes) * 31) + this.buttonType.hashCode();
    }

    public final void setButtonIconRes(int i10) {
        this.buttonIconRes = i10;
    }

    @NotNull
    public String toString() {
        return "MediaEditButtonViewModel(buttonNameRes=" + this.buttonNameRes + ", buttonIconRes=" + this.buttonIconRes + ", buttonType=" + ((Object) this.buttonType) + ")";
    }
}
