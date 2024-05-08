package com.cupidapp.live.consult.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultListModel {

    @Nullable
    private final List<ConsultBannerModel> banners;

    @Nullable
    private final String category;

    @Nullable
    private final ImageModel categoryIcon;

    @Nullable
    private final Boolean chating;

    @Nullable
    private final ImageModel cover;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f13827id;

    @Nullable
    private final String title;

    @NotNull
    private final String type;

    @Nullable
    private final User user;

    @Nullable
    private final Integer viewerCount;

    public ConsultListModel(@Nullable String str, @Nullable User user, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable Boolean bool, @Nullable Integer num, @NotNull String type, @Nullable List<ConsultBannerModel> list) {
        s.i(type, "type");
        this.f13827id = str;
        this.user = user;
        this.category = str2;
        this.categoryIcon = imageModel;
        this.cover = imageModel2;
        this.title = str3;
        this.chating = bool;
        this.viewerCount = num;
        this.type = type;
        this.banners = list;
    }

    @Nullable
    public final String component1() {
        return this.f13827id;
    }

    @Nullable
    public final List<ConsultBannerModel> component10() {
        return this.banners;
    }

    @Nullable
    public final User component2() {
        return this.user;
    }

    @Nullable
    public final String component3() {
        return this.category;
    }

    @Nullable
    public final ImageModel component4() {
        return this.categoryIcon;
    }

    @Nullable
    public final ImageModel component5() {
        return this.cover;
    }

    @Nullable
    public final String component6() {
        return this.title;
    }

    @Nullable
    public final Boolean component7() {
        return this.chating;
    }

    @Nullable
    public final Integer component8() {
        return this.viewerCount;
    }

    @NotNull
    public final String component9() {
        return this.type;
    }

    @NotNull
    public final ConsultListModel copy(@Nullable String str, @Nullable User user, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable Boolean bool, @Nullable Integer num, @NotNull String type, @Nullable List<ConsultBannerModel> list) {
        s.i(type, "type");
        return new ConsultListModel(str, user, str2, imageModel, imageModel2, str3, bool, num, type, list);
    }

    @Nullable
    public final ConsultViewerActivity.Config createConfig(@NotNull String source) {
        s.i(source, "source");
        String str = this.f13827id;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = this.category;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return new ConsultViewerActivity.Config(this.f13827id, this.category, SensorPosition.ConsultList.getValue(), source, null, 16, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultListModel)) {
            return false;
        }
        ConsultListModel consultListModel = (ConsultListModel) obj;
        return s.d(this.f13827id, consultListModel.f13827id) && s.d(this.user, consultListModel.user) && s.d(this.category, consultListModel.category) && s.d(this.categoryIcon, consultListModel.categoryIcon) && s.d(this.cover, consultListModel.cover) && s.d(this.title, consultListModel.title) && s.d(this.chating, consultListModel.chating) && s.d(this.viewerCount, consultListModel.viewerCount) && s.d(this.type, consultListModel.type) && s.d(this.banners, consultListModel.banners);
    }

    @Nullable
    public final List<ConsultBannerModel> getBanners() {
        return this.banners;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final ImageModel getCategoryIcon() {
        return this.categoryIcon;
    }

    @Nullable
    public final Boolean getChating() {
        return this.chating;
    }

    @Nullable
    public final ImageModel getCover() {
        return this.cover;
    }

    @Nullable
    public final String getId() {
        return this.f13827id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final Integer getViewerCount() {
        return this.viewerCount;
    }

    public int hashCode() {
        String str = this.f13827id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        String str2 = this.category;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.categoryIcon;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.cover;
        int hashCode5 = (hashCode4 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.chating;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.viewerCount;
        int hashCode8 = (((hashCode7 + (num == null ? 0 : num.hashCode())) * 31) + this.type.hashCode()) * 31;
        List<ConsultBannerModel> list = this.banners;
        return hashCode8 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.f13827id;
        User user = this.user;
        String str2 = this.category;
        ImageModel imageModel = this.categoryIcon;
        ImageModel imageModel2 = this.cover;
        String str3 = this.title;
        Boolean bool = this.chating;
        Integer num = this.viewerCount;
        return "ConsultListModel(id=" + str + ", user=" + ((Object) user) + ", category=" + str2 + ", categoryIcon=" + ((Object) imageModel) + ", cover=" + ((Object) imageModel2) + ", title=" + str3 + ", chating=" + ((Object) bool) + ", viewerCount=" + ((Object) num) + ", type=" + this.type + ", banners=" + ((Object) this.banners) + ")";
    }
}
