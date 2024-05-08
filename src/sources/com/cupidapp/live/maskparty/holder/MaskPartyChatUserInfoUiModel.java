package com.cupidapp.live.maskparty.holder;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatUserInfoViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatUserInfoUiModel {
    private boolean isMask;

    @NotNull
    private final User user;

    public MaskPartyChatUserInfoUiModel(@NotNull User user, boolean z10) {
        s.i(user, "user");
        this.user = user;
        this.isMask = z10;
    }

    public static /* synthetic */ MaskPartyChatUserInfoUiModel copy$default(MaskPartyChatUserInfoUiModel maskPartyChatUserInfoUiModel, User user, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = maskPartyChatUserInfoUiModel.user;
        }
        if ((i10 & 2) != 0) {
            z10 = maskPartyChatUserInfoUiModel.isMask;
        }
        return maskPartyChatUserInfoUiModel.copy(user, z10);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    public final boolean component2() {
        return this.isMask;
    }

    @NotNull
    public final MaskPartyChatUserInfoUiModel copy(@NotNull User user, boolean z10) {
        s.i(user, "user");
        return new MaskPartyChatUserInfoUiModel(user, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyChatUserInfoUiModel)) {
            return false;
        }
        MaskPartyChatUserInfoUiModel maskPartyChatUserInfoUiModel = (MaskPartyChatUserInfoUiModel) obj;
        return s.d(this.user, maskPartyChatUserInfoUiModel.user) && this.isMask == maskPartyChatUserInfoUiModel.isMask;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        boolean z10 = this.isMask;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isMask() {
        return this.isMask;
    }

    public final void setMask(boolean z10) {
        this.isMask = z10;
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "MaskPartyChatUserInfoUiModel(user=" + ((Object) user) + ", isMask=" + this.isMask + ")";
    }
}
