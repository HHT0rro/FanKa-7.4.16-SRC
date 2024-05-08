package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.feed.model.SponsorModel;
import com.cupidapp.live.hashtag.model.HashTag;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserVideoListModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedItemModel implements Serializable {
    private int commentCount;

    @Nullable
    private final String description;

    @Nullable
    private final ImageModel firstFrameImage;

    @Nullable
    private final HashTag hashtag;

    @NotNull
    private final ImageModel image;
    private int likeCount;
    private boolean liked;

    @NotNull
    private final String postId;
    private int shareCount;

    @Nullable
    private final SponsorModel sponsor;

    @Nullable
    private final VideoModel video;

    public FeedItemModel(@NotNull String postId, int i10, int i11, int i12, @NotNull ImageModel image, @Nullable ImageModel imageModel, @Nullable VideoModel videoModel, boolean z10, @Nullable String str, @Nullable HashTag hashTag, @Nullable SponsorModel sponsorModel) {
        s.i(postId, "postId");
        s.i(image, "image");
        this.postId = postId;
        this.likeCount = i10;
        this.commentCount = i11;
        this.shareCount = i12;
        this.image = image;
        this.firstFrameImage = imageModel;
        this.video = videoModel;
        this.liked = z10;
        this.description = str;
        this.hashtag = hashTag;
        this.sponsor = sponsorModel;
    }

    @NotNull
    public final String component1() {
        return this.postId;
    }

    @Nullable
    public final HashTag component10() {
        return this.hashtag;
    }

    @Nullable
    public final SponsorModel component11() {
        return this.sponsor;
    }

    public final int component2() {
        return this.likeCount;
    }

    public final int component3() {
        return this.commentCount;
    }

    public final int component4() {
        return this.shareCount;
    }

    @NotNull
    public final ImageModel component5() {
        return this.image;
    }

    @Nullable
    public final ImageModel component6() {
        return this.firstFrameImage;
    }

    @Nullable
    public final VideoModel component7() {
        return this.video;
    }

    public final boolean component8() {
        return this.liked;
    }

    @Nullable
    public final String component9() {
        return this.description;
    }

    @NotNull
    public final FeedItemModel copy(@NotNull String postId, int i10, int i11, int i12, @NotNull ImageModel image, @Nullable ImageModel imageModel, @Nullable VideoModel videoModel, boolean z10, @Nullable String str, @Nullable HashTag hashTag, @Nullable SponsorModel sponsorModel) {
        s.i(postId, "postId");
        s.i(image, "image");
        return new FeedItemModel(postId, i10, i11, i12, image, imageModel, videoModel, z10, str, hashTag, sponsorModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedItemModel)) {
            return false;
        }
        FeedItemModel feedItemModel = (FeedItemModel) obj;
        return s.d(this.postId, feedItemModel.postId) && this.likeCount == feedItemModel.likeCount && this.commentCount == feedItemModel.commentCount && this.shareCount == feedItemModel.shareCount && s.d(this.image, feedItemModel.image) && s.d(this.firstFrameImage, feedItemModel.firstFrameImage) && s.d(this.video, feedItemModel.video) && this.liked == feedItemModel.liked && s.d(this.description, feedItemModel.description) && s.d(this.hashtag, feedItemModel.hashtag) && s.d(this.sponsor, feedItemModel.sponsor);
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ImageModel getFirstFrameImage() {
        return this.firstFrameImage;
    }

    @Nullable
    public final HashTag getHashtag() {
        return this.hashtag;
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    @Nullable
    public final SponsorModel getSponsor() {
        return this.sponsor;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.postId.hashCode() * 31) + this.likeCount) * 31) + this.commentCount) * 31) + this.shareCount) * 31) + this.image.hashCode()) * 31;
        ImageModel imageModel = this.firstFrameImage;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        VideoModel videoModel = this.video;
        int hashCode3 = (hashCode2 + (videoModel == null ? 0 : videoModel.hashCode())) * 31;
        boolean z10 = this.liked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        String str = this.description;
        int hashCode4 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        HashTag hashTag = this.hashtag;
        int hashCode5 = (hashCode4 + (hashTag == null ? 0 : hashTag.hashCode())) * 31;
        SponsorModel sponsorModel = this.sponsor;
        return hashCode5 + (sponsorModel != null ? sponsorModel.hashCode() : 0);
    }

    public final void setCommentCount(int i10) {
        this.commentCount = i10;
    }

    public final void setLikeCount(int i10) {
        this.likeCount = i10;
    }

    public final void setLiked(boolean z10) {
        this.liked = z10;
    }

    public final void setShareCount(int i10) {
        this.shareCount = i10;
    }

    @NotNull
    public String toString() {
        String str = this.postId;
        int i10 = this.likeCount;
        int i11 = this.commentCount;
        int i12 = this.shareCount;
        ImageModel imageModel = this.image;
        ImageModel imageModel2 = this.firstFrameImage;
        VideoModel videoModel = this.video;
        return "FeedItemModel(postId=" + str + ", likeCount=" + i10 + ", commentCount=" + i11 + ", shareCount=" + i12 + ", image=" + ((Object) imageModel) + ", firstFrameImage=" + ((Object) imageModel2) + ", video=" + ((Object) videoModel) + ", liked=" + this.liked + ", description=" + this.description + ", hashtag=" + ((Object) this.hashtag) + ", sponsor=" + ((Object) this.sponsor) + ")";
    }

    public /* synthetic */ FeedItemModel(String str, int i10, int i11, int i12, ImageModel imageModel, ImageModel imageModel2, VideoModel videoModel, boolean z10, String str2, HashTag hashTag, SponsorModel sponsorModel, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i10, i11, i12, imageModel, imageModel2, videoModel, (i13 & 128) != 0 ? false : z10, str2, hashTag, sponsorModel);
    }
}
