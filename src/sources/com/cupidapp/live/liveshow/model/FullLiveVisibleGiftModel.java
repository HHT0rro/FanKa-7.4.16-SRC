package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FullLiveVisibleGiftModel {

    @Nullable
    private final ImageModel anchorAvatar;

    @Nullable
    private final String anchorId;

    @Nullable
    private final String animationKey;

    @NotNull
    private String animationPath;

    @Nullable
    private final Integer animationSize;

    @Nullable
    private final String avatarBorderColor;

    @Nullable
    private final String description;

    @Nullable
    private final String giftId;

    @Nullable
    private final String launchPathwayType;

    @Nullable
    private final String liveShowId;

    @Nullable
    private final ImageModel viewerAvatar;

    public FullLiveVisibleGiftModel(@Nullable String str, @NotNull String animationPath, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        s.i(animationPath, "animationPath");
        this.animationKey = str;
        this.animationPath = animationPath;
        this.description = str2;
        this.viewerAvatar = imageModel;
        this.anchorAvatar = imageModel2;
        this.animationSize = num;
        this.avatarBorderColor = str3;
        this.liveShowId = str4;
        this.anchorId = str5;
        this.giftId = str6;
        this.launchPathwayType = str7;
    }

    @Nullable
    public final String component1() {
        return this.animationKey;
    }

    @Nullable
    public final String component10() {
        return this.giftId;
    }

    @Nullable
    public final String component11() {
        return this.launchPathwayType;
    }

    @NotNull
    public final String component2() {
        return this.animationPath;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final ImageModel component4() {
        return this.viewerAvatar;
    }

    @Nullable
    public final ImageModel component5() {
        return this.anchorAvatar;
    }

    @Nullable
    public final Integer component6() {
        return this.animationSize;
    }

    @Nullable
    public final String component7() {
        return this.avatarBorderColor;
    }

    @Nullable
    public final String component8() {
        return this.liveShowId;
    }

    @Nullable
    public final String component9() {
        return this.anchorId;
    }

    @NotNull
    public final FullLiveVisibleGiftModel copy(@Nullable String str, @NotNull String animationPath, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        s.i(animationPath, "animationPath");
        return new FullLiveVisibleGiftModel(str, animationPath, str2, imageModel, imageModel2, num, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FullLiveVisibleGiftModel)) {
            return false;
        }
        FullLiveVisibleGiftModel fullLiveVisibleGiftModel = (FullLiveVisibleGiftModel) obj;
        return s.d(this.animationKey, fullLiveVisibleGiftModel.animationKey) && s.d(this.animationPath, fullLiveVisibleGiftModel.animationPath) && s.d(this.description, fullLiveVisibleGiftModel.description) && s.d(this.viewerAvatar, fullLiveVisibleGiftModel.viewerAvatar) && s.d(this.anchorAvatar, fullLiveVisibleGiftModel.anchorAvatar) && s.d(this.animationSize, fullLiveVisibleGiftModel.animationSize) && s.d(this.avatarBorderColor, fullLiveVisibleGiftModel.avatarBorderColor) && s.d(this.liveShowId, fullLiveVisibleGiftModel.liveShowId) && s.d(this.anchorId, fullLiveVisibleGiftModel.anchorId) && s.d(this.giftId, fullLiveVisibleGiftModel.giftId) && s.d(this.launchPathwayType, fullLiveVisibleGiftModel.launchPathwayType);
    }

    @Nullable
    public final ImageModel getAnchorAvatar() {
        return this.anchorAvatar;
    }

    @Nullable
    public final String getAnchorId() {
        return this.anchorId;
    }

    @Nullable
    public final String getAnimationKey() {
        return this.animationKey;
    }

    @NotNull
    public final String getAnimationPath() {
        return this.animationPath;
    }

    @Nullable
    public final Integer getAnimationSize() {
        return this.animationSize;
    }

    @Nullable
    public final String getAvatarBorderColor() {
        return this.avatarBorderColor;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getGiftId() {
        return this.giftId;
    }

    @Nullable
    public final String getLaunchPathwayType() {
        return this.launchPathwayType;
    }

    @Nullable
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final ImageModel getViewerAvatar() {
        return this.viewerAvatar;
    }

    public int hashCode() {
        String str = this.animationKey;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.animationPath.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.viewerAvatar;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.anchorAvatar;
        int hashCode4 = (hashCode3 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        Integer num = this.animationSize;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.avatarBorderColor;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.liveShowId;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.anchorId;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.giftId;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.launchPathwayType;
        return hashCode9 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setAnimationPath(@NotNull String str) {
        s.i(str, "<set-?>");
        this.animationPath = str;
    }

    @NotNull
    public String toString() {
        String str = this.animationKey;
        String str2 = this.animationPath;
        String str3 = this.description;
        ImageModel imageModel = this.viewerAvatar;
        ImageModel imageModel2 = this.anchorAvatar;
        Integer num = this.animationSize;
        return "FullLiveVisibleGiftModel(animationKey=" + str + ", animationPath=" + str2 + ", description=" + str3 + ", viewerAvatar=" + ((Object) imageModel) + ", anchorAvatar=" + ((Object) imageModel2) + ", animationSize=" + ((Object) num) + ", avatarBorderColor=" + this.avatarBorderColor + ", liveShowId=" + this.liveShowId + ", anchorId=" + this.anchorId + ", giftId=" + this.giftId + ", launchPathwayType=" + this.launchPathwayType + ")";
    }
}
