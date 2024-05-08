package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByTopTipModel {

    @Nullable
    private final String buttonName;

    @Nullable
    private final String buttonUrl;

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String subtitle;

    @Nullable
    private final String title;

    @Nullable
    private final String trackName;

    public NearByTopTipModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.icon = imageModel;
        this.title = str;
        this.subtitle = str2;
        this.buttonName = str3;
        this.buttonUrl = str4;
        this.trackName = str5;
    }

    public static /* synthetic */ NearByTopTipModel copy$default(NearByTopTipModel nearByTopTipModel, ImageModel imageModel, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = nearByTopTipModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = nearByTopTipModel.title;
        }
        String str6 = str;
        if ((i10 & 4) != 0) {
            str2 = nearByTopTipModel.subtitle;
        }
        String str7 = str2;
        if ((i10 & 8) != 0) {
            str3 = nearByTopTipModel.buttonName;
        }
        String str8 = str3;
        if ((i10 & 16) != 0) {
            str4 = nearByTopTipModel.buttonUrl;
        }
        String str9 = str4;
        if ((i10 & 32) != 0) {
            str5 = nearByTopTipModel.trackName;
        }
        return nearByTopTipModel.copy(imageModel, str6, str7, str8, str9, str5);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final String component4() {
        return this.buttonName;
    }

    @Nullable
    public final String component5() {
        return this.buttonUrl;
    }

    @Nullable
    public final String component6() {
        return this.trackName;
    }

    @NotNull
    public final NearByTopTipModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return new NearByTopTipModel(imageModel, str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearByTopTipModel)) {
            return false;
        }
        NearByTopTipModel nearByTopTipModel = (NearByTopTipModel) obj;
        return s.d(this.icon, nearByTopTipModel.icon) && s.d(this.title, nearByTopTipModel.title) && s.d(this.subtitle, nearByTopTipModel.subtitle) && s.d(this.buttonName, nearByTopTipModel.buttonName) && s.d(this.buttonUrl, nearByTopTipModel.buttonUrl) && s.d(this.trackName, nearByTopTipModel.trackName);
    }

    @Nullable
    public final String getButtonName() {
        return this.buttonName;
    }

    @Nullable
    public final String getButtonUrl() {
        return this.buttonUrl;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subtitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buttonName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buttonUrl;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.trackName;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "NearByTopTipModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", subtitle=" + this.subtitle + ", buttonName=" + this.buttonName + ", buttonUrl=" + this.buttonUrl + ", trackName=" + this.trackName + ")";
    }
}
