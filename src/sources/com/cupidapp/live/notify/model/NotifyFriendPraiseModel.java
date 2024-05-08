package com.cupidapp.live.notify.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostNotifyModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyFriendPraiseModel implements Serializable {

    @Nullable
    private final String content;

    @Nullable
    private Boolean homePageDisplay;

    @Nullable
    private final ImageModel praiseIcon;

    @Nullable
    private final String praiseId;

    public NotifyFriendPraiseModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable Boolean bool, @Nullable String str2) {
        this.praiseId = str;
        this.praiseIcon = imageModel;
        this.homePageDisplay = bool;
        this.content = str2;
    }

    public static /* synthetic */ NotifyFriendPraiseModel copy$default(NotifyFriendPraiseModel notifyFriendPraiseModel, String str, ImageModel imageModel, Boolean bool, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = notifyFriendPraiseModel.praiseId;
        }
        if ((i10 & 2) != 0) {
            imageModel = notifyFriendPraiseModel.praiseIcon;
        }
        if ((i10 & 4) != 0) {
            bool = notifyFriendPraiseModel.homePageDisplay;
        }
        if ((i10 & 8) != 0) {
            str2 = notifyFriendPraiseModel.content;
        }
        return notifyFriendPraiseModel.copy(str, imageModel, bool, str2);
    }

    @Nullable
    public final String component1() {
        return this.praiseId;
    }

    @Nullable
    public final ImageModel component2() {
        return this.praiseIcon;
    }

    @Nullable
    public final Boolean component3() {
        return this.homePageDisplay;
    }

    @Nullable
    public final String component4() {
        return this.content;
    }

    @NotNull
    public final NotifyFriendPraiseModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable Boolean bool, @Nullable String str2) {
        return new NotifyFriendPraiseModel(str, imageModel, bool, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyFriendPraiseModel)) {
            return false;
        }
        NotifyFriendPraiseModel notifyFriendPraiseModel = (NotifyFriendPraiseModel) obj;
        return s.d(this.praiseId, notifyFriendPraiseModel.praiseId) && s.d(this.praiseIcon, notifyFriendPraiseModel.praiseIcon) && s.d(this.homePageDisplay, notifyFriendPraiseModel.homePageDisplay) && s.d(this.content, notifyFriendPraiseModel.content);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Boolean getHomePageDisplay() {
        return this.homePageDisplay;
    }

    @Nullable
    public final ImageModel getPraiseIcon() {
        return this.praiseIcon;
    }

    @Nullable
    public final String getPraiseId() {
        return this.praiseId;
    }

    public int hashCode() {
        String str = this.praiseId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.praiseIcon;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        Boolean bool = this.homePageDisplay;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.content;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setHomePageDisplay(@Nullable Boolean bool) {
        this.homePageDisplay = bool;
    }

    @NotNull
    public String toString() {
        String str = this.praiseId;
        ImageModel imageModel = this.praiseIcon;
        Boolean bool = this.homePageDisplay;
        return "NotifyFriendPraiseModel(praiseId=" + str + ", praiseIcon=" + ((Object) imageModel) + ", homePageDisplay=" + ((Object) bool) + ", content=" + this.content + ")";
    }
}
