package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FollowLiveStatusModel implements Serializable {

    @Nullable
    private final String colorRange;

    @Nullable
    private final Integer countDownSecs;

    @Nullable
    private final ImageModel levelIcon;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public FollowLiveStatusModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
        this.title = str;
        this.levelIcon = imageModel;
        this.url = str2;
        this.colorRange = str3;
        this.countDownSecs = num;
    }

    public static /* synthetic */ FollowLiveStatusModel copy$default(FollowLiveStatusModel followLiveStatusModel, String str, ImageModel imageModel, String str2, String str3, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = followLiveStatusModel.title;
        }
        if ((i10 & 2) != 0) {
            imageModel = followLiveStatusModel.levelIcon;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 4) != 0) {
            str2 = followLiveStatusModel.url;
        }
        String str4 = str2;
        if ((i10 & 8) != 0) {
            str3 = followLiveStatusModel.colorRange;
        }
        String str5 = str3;
        if ((i10 & 16) != 0) {
            num = followLiveStatusModel.countDownSecs;
        }
        return followLiveStatusModel.copy(str, imageModel2, str4, str5, num);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final ImageModel component2() {
        return this.levelIcon;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final String component4() {
        return this.colorRange;
    }

    @Nullable
    public final Integer component5() {
        return this.countDownSecs;
    }

    @NotNull
    public final FollowLiveStatusModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
        return new FollowLiveStatusModel(str, imageModel, str2, str3, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowLiveStatusModel)) {
            return false;
        }
        FollowLiveStatusModel followLiveStatusModel = (FollowLiveStatusModel) obj;
        return s.d(this.title, followLiveStatusModel.title) && s.d(this.levelIcon, followLiveStatusModel.levelIcon) && s.d(this.url, followLiveStatusModel.url) && s.d(this.colorRange, followLiveStatusModel.colorRange) && s.d(this.countDownSecs, followLiveStatusModel.countDownSecs);
    }

    @Nullable
    public final String getColorRange() {
        return this.colorRange;
    }

    @Nullable
    public final Integer getCountDownSecs() {
        return this.countDownSecs;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.levelIcon;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.colorRange;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.countDownSecs;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        ImageModel imageModel = this.levelIcon;
        return "FollowLiveStatusModel(title=" + str + ", levelIcon=" + ((Object) imageModel) + ", url=" + this.url + ", colorRange=" + this.colorRange + ", countDownSecs=" + ((Object) this.countDownSecs) + ")";
    }
}
