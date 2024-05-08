package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.club.model.ClubMedalModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserClubModel implements Serializable {

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final ImageModel medal;

    @Nullable
    private final String medalJumpUrl;

    @NotNull
    private final List<ClubMedalModel> medalList;

    public UserClubModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @NotNull List<ClubMedalModel> medalList) {
        s.i(medalList, "medalList");
        this.medal = imageModel;
        this.medalJumpUrl = str;
        this.icon = imageModel2;
        this.medalList = medalList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserClubModel copy$default(UserClubModel userClubModel, ImageModel imageModel, String str, ImageModel imageModel2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = userClubModel.medal;
        }
        if ((i10 & 2) != 0) {
            str = userClubModel.medalJumpUrl;
        }
        if ((i10 & 4) != 0) {
            imageModel2 = userClubModel.icon;
        }
        if ((i10 & 8) != 0) {
            list = userClubModel.medalList;
        }
        return userClubModel.copy(imageModel, str, imageModel2, list);
    }

    @Nullable
    public final ImageModel component1() {
        return this.medal;
    }

    @Nullable
    public final String component2() {
        return this.medalJumpUrl;
    }

    @Nullable
    public final ImageModel component3() {
        return this.icon;
    }

    @NotNull
    public final List<ClubMedalModel> component4() {
        return this.medalList;
    }

    @NotNull
    public final UserClubModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @NotNull List<ClubMedalModel> medalList) {
        s.i(medalList, "medalList");
        return new UserClubModel(imageModel, str, imageModel2, medalList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserClubModel)) {
            return false;
        }
        UserClubModel userClubModel = (UserClubModel) obj;
        return s.d(this.medal, userClubModel.medal) && s.d(this.medalJumpUrl, userClubModel.medalJumpUrl) && s.d(this.icon, userClubModel.icon) && s.d(this.medalList, userClubModel.medalList);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final ImageModel getMedal() {
        return this.medal;
    }

    @Nullable
    public final String getMedalJumpUrl() {
        return this.medalJumpUrl;
    }

    @NotNull
    public final List<ClubMedalModel> getMedalList() {
        return this.medalList;
    }

    public int hashCode() {
        ImageModel imageModel = this.medal;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.medalJumpUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel2 = this.icon;
        return ((hashCode2 + (imageModel2 != null ? imageModel2.hashCode() : 0)) * 31) + this.medalList.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.medal;
        return "UserClubModel(medal=" + ((Object) imageModel) + ", medalJumpUrl=" + this.medalJumpUrl + ", icon=" + ((Object) this.icon) + ", medalList=" + ((Object) this.medalList) + ")";
    }
}
