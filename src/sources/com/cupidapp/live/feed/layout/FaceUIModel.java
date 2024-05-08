package com.cupidapp.live.feed.layout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostSendMsgLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceUIModel {
    private final int icon;
    private final int msgContent;
    private final int name;

    public FaceUIModel(int i10, int i11, int i12) {
        this.icon = i10;
        this.name = i11;
        this.msgContent = i12;
    }

    public static /* synthetic */ FaceUIModel copy$default(FaceUIModel faceUIModel, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = faceUIModel.icon;
        }
        if ((i13 & 2) != 0) {
            i11 = faceUIModel.name;
        }
        if ((i13 & 4) != 0) {
            i12 = faceUIModel.msgContent;
        }
        return faceUIModel.copy(i10, i11, i12);
    }

    public final int component1() {
        return this.icon;
    }

    public final int component2() {
        return this.name;
    }

    public final int component3() {
        return this.msgContent;
    }

    @NotNull
    public final FaceUIModel copy(int i10, int i11, int i12) {
        return new FaceUIModel(i10, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FaceUIModel)) {
            return false;
        }
        FaceUIModel faceUIModel = (FaceUIModel) obj;
        return this.icon == faceUIModel.icon && this.name == faceUIModel.name && this.msgContent == faceUIModel.msgContent;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getMsgContent() {
        return this.msgContent;
    }

    public final int getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.icon * 31) + this.name) * 31) + this.msgContent;
    }

    @NotNull
    public String toString() {
        return "FaceUIModel(icon=" + this.icon + ", name=" + this.name + ", msgContent=" + this.msgContent + ")";
    }
}
