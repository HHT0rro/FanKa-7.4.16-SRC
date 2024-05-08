package com.cupidapp.live.chat2.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatUserInfoModel {

    @NotNull
    private final User sender;

    @Nullable
    private final String topTips;

    public SurveyChatUserInfoModel(@NotNull User sender, @Nullable String str) {
        s.i(sender, "sender");
        this.sender = sender;
        this.topTips = str;
    }

    public static /* synthetic */ SurveyChatUserInfoModel copy$default(SurveyChatUserInfoModel surveyChatUserInfoModel, User user, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = surveyChatUserInfoModel.sender;
        }
        if ((i10 & 2) != 0) {
            str = surveyChatUserInfoModel.topTips;
        }
        return surveyChatUserInfoModel.copy(user, str);
    }

    @NotNull
    public final User component1() {
        return this.sender;
    }

    @Nullable
    public final String component2() {
        return this.topTips;
    }

    @NotNull
    public final SurveyChatUserInfoModel copy(@NotNull User sender, @Nullable String str) {
        s.i(sender, "sender");
        return new SurveyChatUserInfoModel(sender, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveyChatUserInfoModel)) {
            return false;
        }
        SurveyChatUserInfoModel surveyChatUserInfoModel = (SurveyChatUserInfoModel) obj;
        return s.d(this.sender, surveyChatUserInfoModel.sender) && s.d(this.topTips, surveyChatUserInfoModel.topTips);
    }

    @NotNull
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    public final String getTopTips() {
        return this.topTips;
    }

    public int hashCode() {
        int hashCode = this.sender.hashCode() * 31;
        String str = this.topTips;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        User user = this.sender;
        return "SurveyChatUserInfoModel(sender=" + ((Object) user) + ", topTips=" + this.topTips + ")";
    }
}
