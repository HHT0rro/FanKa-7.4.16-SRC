package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationChangedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationChangedModel {

    @Nullable
    private final String leftButtonName;

    @Nullable
    private final String leftButtonUrl;

    @Nullable
    private final String rightButtonName;

    @Nullable
    private final String rightButtonUrl;

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;

    public LocationChangedModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.title = str;
        this.subTitle = str2;
        this.leftButtonName = str3;
        this.leftButtonUrl = str4;
        this.rightButtonName = str5;
        this.rightButtonUrl = str6;
    }

    public static /* synthetic */ LocationChangedModel copy$default(LocationChangedModel locationChangedModel, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = locationChangedModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = locationChangedModel.subTitle;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = locationChangedModel.leftButtonName;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = locationChangedModel.leftButtonUrl;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = locationChangedModel.rightButtonName;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = locationChangedModel.rightButtonUrl;
        }
        return locationChangedModel.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subTitle;
    }

    @Nullable
    public final String component3() {
        return this.leftButtonName;
    }

    @Nullable
    public final String component4() {
        return this.leftButtonUrl;
    }

    @Nullable
    public final String component5() {
        return this.rightButtonName;
    }

    @Nullable
    public final String component6() {
        return this.rightButtonUrl;
    }

    @NotNull
    public final LocationChangedModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new LocationChangedModel(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationChangedModel)) {
            return false;
        }
        LocationChangedModel locationChangedModel = (LocationChangedModel) obj;
        return s.d(this.title, locationChangedModel.title) && s.d(this.subTitle, locationChangedModel.subTitle) && s.d(this.leftButtonName, locationChangedModel.leftButtonName) && s.d(this.leftButtonUrl, locationChangedModel.leftButtonUrl) && s.d(this.rightButtonName, locationChangedModel.rightButtonName) && s.d(this.rightButtonUrl, locationChangedModel.rightButtonUrl);
    }

    @Nullable
    public final String getLeftButtonName() {
        return this.leftButtonName;
    }

    @Nullable
    public final String getLeftButtonUrl() {
        return this.leftButtonUrl;
    }

    @Nullable
    public final String getRightButtonName() {
        return this.rightButtonName;
    }

    @Nullable
    public final String getRightButtonUrl() {
        return this.rightButtonUrl;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.leftButtonName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.leftButtonUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rightButtonName;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.rightButtonUrl;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LocationChangedModel(title=" + this.title + ", subTitle=" + this.subTitle + ", leftButtonName=" + this.leftButtonName + ", leftButtonUrl=" + this.leftButtonUrl + ", rightButtonName=" + this.rightButtonName + ", rightButtonUrl=" + this.rightButtonUrl + ")";
    }
}
