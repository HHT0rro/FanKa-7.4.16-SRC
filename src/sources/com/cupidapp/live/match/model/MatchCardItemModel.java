package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchCardItemModel implements Serializable {

    @Nullable
    private final ImageModel avatar;

    @Nullable
    private final List<String> commonhobby;

    @Nullable
    private final List<MatchCardUserPostModel> post;

    @Nullable
    private final List<MatchCardUserSpecInfoModel> profile;

    @Nullable
    private final String summary;

    @Nullable
    private final FKStoryLabelItemModel userStoryLabel;

    @Nullable
    private final VideoModel video;

    public MatchCardItemModel(@Nullable ImageModel imageModel, @Nullable VideoModel videoModel, @Nullable String str, @Nullable List<String> list, @Nullable List<MatchCardUserSpecInfoModel> list2, @Nullable List<MatchCardUserPostModel> list3, @Nullable FKStoryLabelItemModel fKStoryLabelItemModel) {
        this.avatar = imageModel;
        this.video = videoModel;
        this.summary = str;
        this.commonhobby = list;
        this.profile = list2;
        this.post = list3;
        this.userStoryLabel = fKStoryLabelItemModel;
    }

    public static /* synthetic */ MatchCardItemModel copy$default(MatchCardItemModel matchCardItemModel, ImageModel imageModel, VideoModel videoModel, String str, List list, List list2, List list3, FKStoryLabelItemModel fKStoryLabelItemModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = matchCardItemModel.avatar;
        }
        if ((i10 & 2) != 0) {
            videoModel = matchCardItemModel.video;
        }
        VideoModel videoModel2 = videoModel;
        if ((i10 & 4) != 0) {
            str = matchCardItemModel.summary;
        }
        String str2 = str;
        if ((i10 & 8) != 0) {
            list = matchCardItemModel.commonhobby;
        }
        List list4 = list;
        if ((i10 & 16) != 0) {
            list2 = matchCardItemModel.profile;
        }
        List list5 = list2;
        if ((i10 & 32) != 0) {
            list3 = matchCardItemModel.post;
        }
        List list6 = list3;
        if ((i10 & 64) != 0) {
            fKStoryLabelItemModel = matchCardItemModel.userStoryLabel;
        }
        return matchCardItemModel.copy(imageModel, videoModel2, str2, list4, list5, list6, fKStoryLabelItemModel);
    }

    @Nullable
    public final ImageModel component1() {
        return this.avatar;
    }

    @Nullable
    public final VideoModel component2() {
        return this.video;
    }

    @Nullable
    public final String component3() {
        return this.summary;
    }

    @Nullable
    public final List<String> component4() {
        return this.commonhobby;
    }

    @Nullable
    public final List<MatchCardUserSpecInfoModel> component5() {
        return this.profile;
    }

    @Nullable
    public final List<MatchCardUserPostModel> component6() {
        return this.post;
    }

    @Nullable
    public final FKStoryLabelItemModel component7() {
        return this.userStoryLabel;
    }

    @NotNull
    public final MatchCardItemModel copy(@Nullable ImageModel imageModel, @Nullable VideoModel videoModel, @Nullable String str, @Nullable List<String> list, @Nullable List<MatchCardUserSpecInfoModel> list2, @Nullable List<MatchCardUserPostModel> list3, @Nullable FKStoryLabelItemModel fKStoryLabelItemModel) {
        return new MatchCardItemModel(imageModel, videoModel, str, list, list2, list3, fKStoryLabelItemModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchCardItemModel)) {
            return false;
        }
        MatchCardItemModel matchCardItemModel = (MatchCardItemModel) obj;
        return s.d(this.avatar, matchCardItemModel.avatar) && s.d(this.video, matchCardItemModel.video) && s.d(this.summary, matchCardItemModel.summary) && s.d(this.commonhobby, matchCardItemModel.commonhobby) && s.d(this.profile, matchCardItemModel.profile) && s.d(this.post, matchCardItemModel.post) && s.d(this.userStoryLabel, matchCardItemModel.userStoryLabel);
    }

    @Nullable
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final List<String> getCommonhobby() {
        return this.commonhobby;
    }

    @Nullable
    public final List<MatchCardUserPostModel> getPost() {
        return this.post;
    }

    @Nullable
    public final List<MatchCardUserSpecInfoModel> getProfile() {
        return this.profile;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final FKStoryLabelItemModel getUserStoryLabel() {
        return this.userStoryLabel;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    public int hashCode() {
        ImageModel imageModel = this.avatar;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        VideoModel videoModel = this.video;
        int hashCode2 = (hashCode + (videoModel == null ? 0 : videoModel.hashCode())) * 31;
        String str = this.summary;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.commonhobby;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<MatchCardUserSpecInfoModel> list2 = this.profile;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MatchCardUserPostModel> list3 = this.post;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        FKStoryLabelItemModel fKStoryLabelItemModel = this.userStoryLabel;
        return hashCode6 + (fKStoryLabelItemModel != null ? fKStoryLabelItemModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.avatar;
        VideoModel videoModel = this.video;
        return "MatchCardItemModel(avatar=" + ((Object) imageModel) + ", video=" + ((Object) videoModel) + ", summary=" + this.summary + ", commonhobby=" + ((Object) this.commonhobby) + ", profile=" + ((Object) this.profile) + ", post=" + ((Object) this.post) + ", userStoryLabel=" + ((Object) this.userStoryLabel) + ")";
    }

    public /* synthetic */ MatchCardItemModel(ImageModel imageModel, VideoModel videoModel, String str, List list, List list2, List list3, FKStoryLabelItemModel fKStoryLabelItemModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageModel, videoModel, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : list, (i10 & 16) != 0 ? null : list2, (i10 & 32) != 0 ? null : list3, (i10 & 64) != 0 ? null : fKStoryLabelItemModel);
    }
}
