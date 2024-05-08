package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveActivityModel implements Serializable {

    @Nullable
    private final String badge;

    @Nullable
    private final String badgeBgColor;

    @Nullable
    private final String badgeColor;
    private final int iconHeight;

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private final String text;

    @Nullable
    private final String textColor;

    @Nullable
    private final String url;

    @Nullable
    private final String webUrl;

    public LiveActivityModel(@Nullable String str, @Nullable String str2, @Nullable String str3, int i10, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel, @Nullable String str7) {
        this.url = str;
        this.text = str2;
        this.badge = str3;
        this.iconHeight = i10;
        this.textColor = str4;
        this.badgeColor = str5;
        this.badgeBgColor = str6;
        this.iconImage = imageModel;
        this.webUrl = str7;
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.text;
    }

    @Nullable
    public final String component3() {
        return this.badge;
    }

    public final int component4() {
        return this.iconHeight;
    }

    @Nullable
    public final String component5() {
        return this.textColor;
    }

    @Nullable
    public final String component6() {
        return this.badgeColor;
    }

    @Nullable
    public final String component7() {
        return this.badgeBgColor;
    }

    @Nullable
    public final ImageModel component8() {
        return this.iconImage;
    }

    @Nullable
    public final String component9() {
        return this.webUrl;
    }

    @NotNull
    public final LiveActivityModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, int i10, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel, @Nullable String str7) {
        return new LiveActivityModel(str, str2, str3, i10, str4, str5, str6, imageModel, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveActivityModel)) {
            return false;
        }
        LiveActivityModel liveActivityModel = (LiveActivityModel) obj;
        return s.d(this.url, liveActivityModel.url) && s.d(this.text, liveActivityModel.text) && s.d(this.badge, liveActivityModel.badge) && this.iconHeight == liveActivityModel.iconHeight && s.d(this.textColor, liveActivityModel.textColor) && s.d(this.badgeColor, liveActivityModel.badgeColor) && s.d(this.badgeBgColor, liveActivityModel.badgeBgColor) && s.d(this.iconImage, liveActivityModel.iconImage) && s.d(this.webUrl, liveActivityModel.webUrl);
    }

    @Nullable
    public final String getBadge() {
        return this.badge;
    }

    @Nullable
    public final String getBadgeBgColor() {
        return this.badgeBgColor;
    }

    @Nullable
    public final String getBadgeColor() {
        return this.badgeColor;
    }

    public final int getIconHeight() {
        return this.iconHeight;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTextColor() {
        return this.textColor;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getWebUrl() {
        return this.webUrl;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.badge;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.iconHeight) * 31;
        String str4 = this.textColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.badgeColor;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.badgeBgColor;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageModel imageModel = this.iconImage;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str7 = this.webUrl;
        return hashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.text;
        String str3 = this.badge;
        int i10 = this.iconHeight;
        String str4 = this.textColor;
        String str5 = this.badgeColor;
        String str6 = this.badgeBgColor;
        ImageModel imageModel = this.iconImage;
        return "LiveActivityModel(url=" + str + ", text=" + str2 + ", badge=" + str3 + ", iconHeight=" + i10 + ", textColor=" + str4 + ", badgeColor=" + str5 + ", badgeBgColor=" + str6 + ", iconImage=" + ((Object) imageModel) + ", webUrl=" + this.webUrl + ")";
    }

    public /* synthetic */ LiveActivityModel(String str, String str2, String str3, int i10, String str4, String str5, String str6, ImageModel imageModel, String str7, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i10, (i11 & 16) != 0 ? "#ffffff" : str4, (i11 & 32) != 0 ? "#ffffff" : str5, (i11 & 64) != 0 ? "#ffffff" : str6, imageModel, str7);
    }
}
