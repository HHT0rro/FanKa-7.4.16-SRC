package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveAudienceListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveSeatItemModel {

    @Nullable
    private final ImageModel borderImage;

    @Nullable
    private final String consumption;

    @Nullable
    private final ImageModel userAvatar;

    @NotNull
    private final String userId;

    public LiveSeatItemModel(@NotNull String userId, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2) {
        s.i(userId, "userId");
        this.userId = userId;
        this.userAvatar = imageModel;
        this.consumption = str;
        this.borderImage = imageModel2;
    }

    public static /* synthetic */ LiveSeatItemModel copy$default(LiveSeatItemModel liveSeatItemModel, String str, ImageModel imageModel, String str2, ImageModel imageModel2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveSeatItemModel.userId;
        }
        if ((i10 & 2) != 0) {
            imageModel = liveSeatItemModel.userAvatar;
        }
        if ((i10 & 4) != 0) {
            str2 = liveSeatItemModel.consumption;
        }
        if ((i10 & 8) != 0) {
            imageModel2 = liveSeatItemModel.borderImage;
        }
        return liveSeatItemModel.copy(str, imageModel, str2, imageModel2);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final ImageModel component2() {
        return this.userAvatar;
    }

    @Nullable
    public final String component3() {
        return this.consumption;
    }

    @Nullable
    public final ImageModel component4() {
        return this.borderImage;
    }

    @NotNull
    public final LiveSeatItemModel copy(@NotNull String userId, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2) {
        s.i(userId, "userId");
        return new LiveSeatItemModel(userId, imageModel, str, imageModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveSeatItemModel)) {
            return false;
        }
        LiveSeatItemModel liveSeatItemModel = (LiveSeatItemModel) obj;
        return s.d(this.userId, liveSeatItemModel.userId) && s.d(this.userAvatar, liveSeatItemModel.userAvatar) && s.d(this.consumption, liveSeatItemModel.consumption) && s.d(this.borderImage, liveSeatItemModel.borderImage);
    }

    @Nullable
    public final ImageModel getBorderImage() {
        return this.borderImage;
    }

    @Nullable
    public final String getConsumption() {
        return this.consumption;
    }

    @Nullable
    public final ImageModel getUserAvatar() {
        return this.userAvatar;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        ImageModel imageModel = this.userAvatar;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.consumption;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel2 = this.borderImage;
        return hashCode3 + (imageModel2 != null ? imageModel2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        ImageModel imageModel = this.userAvatar;
        return "LiveSeatItemModel(userId=" + str + ", userAvatar=" + ((Object) imageModel) + ", consumption=" + this.consumption + ", borderImage=" + ((Object) this.borderImage) + ")";
    }
}
