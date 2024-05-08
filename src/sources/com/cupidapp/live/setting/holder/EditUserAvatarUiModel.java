package com.cupidapp.live.setting.holder;

import com.cupidapp.live.setting.model.AvatarProfileModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditUserAvatarViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserAvatarUiModel {

    @NotNull
    private final AvatarProfileModel avatarModel;
    private boolean canDel;
    private final boolean isVideoAvatarValid;
    private final boolean onlyDefaultAvatar;

    public EditUserAvatarUiModel(@NotNull AvatarProfileModel avatarModel, boolean z10, boolean z11, boolean z12) {
        s.i(avatarModel, "avatarModel");
        this.avatarModel = avatarModel;
        this.canDel = z10;
        this.isVideoAvatarValid = z11;
        this.onlyDefaultAvatar = z12;
    }

    public static /* synthetic */ EditUserAvatarUiModel copy$default(EditUserAvatarUiModel editUserAvatarUiModel, AvatarProfileModel avatarProfileModel, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            avatarProfileModel = editUserAvatarUiModel.avatarModel;
        }
        if ((i10 & 2) != 0) {
            z10 = editUserAvatarUiModel.canDel;
        }
        if ((i10 & 4) != 0) {
            z11 = editUserAvatarUiModel.isVideoAvatarValid;
        }
        if ((i10 & 8) != 0) {
            z12 = editUserAvatarUiModel.onlyDefaultAvatar;
        }
        return editUserAvatarUiModel.copy(avatarProfileModel, z10, z11, z12);
    }

    @NotNull
    public final AvatarProfileModel component1() {
        return this.avatarModel;
    }

    public final boolean component2() {
        return this.canDel;
    }

    public final boolean component3() {
        return this.isVideoAvatarValid;
    }

    public final boolean component4() {
        return this.onlyDefaultAvatar;
    }

    @NotNull
    public final EditUserAvatarUiModel copy(@NotNull AvatarProfileModel avatarModel, boolean z10, boolean z11, boolean z12) {
        s.i(avatarModel, "avatarModel");
        return new EditUserAvatarUiModel(avatarModel, z10, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EditUserAvatarUiModel)) {
            return false;
        }
        EditUserAvatarUiModel editUserAvatarUiModel = (EditUserAvatarUiModel) obj;
        return s.d(this.avatarModel, editUserAvatarUiModel.avatarModel) && this.canDel == editUserAvatarUiModel.canDel && this.isVideoAvatarValid == editUserAvatarUiModel.isVideoAvatarValid && this.onlyDefaultAvatar == editUserAvatarUiModel.onlyDefaultAvatar;
    }

    @NotNull
    public final AvatarProfileModel getAvatarModel() {
        return this.avatarModel;
    }

    public final boolean getCanDel() {
        return this.canDel;
    }

    public final boolean getOnlyDefaultAvatar() {
        return this.onlyDefaultAvatar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.avatarModel.hashCode() * 31;
        boolean z10 = this.canDel;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.isVideoAvatarValid;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.onlyDefaultAvatar;
        return i13 + (z12 ? 1 : z12 ? 1 : 0);
    }

    public final boolean isVideoAvatarValid() {
        return this.isVideoAvatarValid;
    }

    public final void setCanDel(boolean z10) {
        this.canDel = z10;
    }

    @NotNull
    public String toString() {
        AvatarProfileModel avatarProfileModel = this.avatarModel;
        return "EditUserAvatarUiModel(avatarModel=" + ((Object) avatarProfileModel) + ", canDel=" + this.canDel + ", isVideoAvatarValid=" + this.isVideoAvatarValid + ", onlyDefaultAvatar=" + this.onlyDefaultAvatar + ")";
    }

    public /* synthetic */ EditUserAvatarUiModel(AvatarProfileModel avatarProfileModel, boolean z10, boolean z11, boolean z12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(avatarProfileModel, z10, z11, (i10 & 8) != 0 ? false : z12);
    }
}
