package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveSeatResult {

    @Nullable
    private final String consumption;

    @Nullable
    private final ImageModel iconImage;

    @NotNull
    private final User user;

    public LiveSeatResult(@NotNull User user, @Nullable String str, @Nullable ImageModel imageModel) {
        s.i(user, "user");
        this.user = user;
        this.consumption = str;
        this.iconImage = imageModel;
    }

    public static /* synthetic */ LiveSeatResult copy$default(LiveSeatResult liveSeatResult, User user, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = liveSeatResult.user;
        }
        if ((i10 & 2) != 0) {
            str = liveSeatResult.consumption;
        }
        if ((i10 & 4) != 0) {
            imageModel = liveSeatResult.iconImage;
        }
        return liveSeatResult.copy(user, str, imageModel);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.consumption;
    }

    @Nullable
    public final ImageModel component3() {
        return this.iconImage;
    }

    @NotNull
    public final LiveSeatResult copy(@NotNull User user, @Nullable String str, @Nullable ImageModel imageModel) {
        s.i(user, "user");
        return new LiveSeatResult(user, str, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveSeatResult)) {
            return false;
        }
        LiveSeatResult liveSeatResult = (LiveSeatResult) obj;
        return s.d(this.user, liveSeatResult.user) && s.d(this.consumption, liveSeatResult.consumption) && s.d(this.iconImage, liveSeatResult.iconImage);
    }

    @Nullable
    public final String getConsumption() {
        return this.consumption;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        String str = this.consumption;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel = this.iconImage;
        return hashCode2 + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "LiveSeatResult(user=" + ((Object) user) + ", consumption=" + this.consumption + ", iconImage=" + ((Object) this.iconImage) + ")";
    }
}
