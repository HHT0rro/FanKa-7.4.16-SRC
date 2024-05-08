package com.cupidapp.live.feed.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SponsorModel implements Serializable {

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final List<String> clickTrackUrlList;

    @Nullable
    private final String foregroundColor;

    @Nullable
    private final String label;

    @Nullable
    private final List<String> showTrackUrlList;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public SponsorModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable List<String> list, @Nullable List<String> list2) {
        this.title = str;
        this.label = str2;
        this.url = str3;
        this.foregroundColor = str4;
        this.backgroundColor = str5;
        this.showTrackUrlList = list;
        this.clickTrackUrlList = list2;
    }

    public static /* synthetic */ SponsorModel copy$default(SponsorModel sponsorModel, String str, String str2, String str3, String str4, String str5, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sponsorModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = sponsorModel.label;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = sponsorModel.url;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = sponsorModel.foregroundColor;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = sponsorModel.backgroundColor;
        }
        String str9 = str5;
        if ((i10 & 32) != 0) {
            list = sponsorModel.showTrackUrlList;
        }
        List list3 = list;
        if ((i10 & 64) != 0) {
            list2 = sponsorModel.clickTrackUrlList;
        }
        return sponsorModel.copy(str, str6, str7, str8, str9, list3, list2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.label;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final String component4() {
        return this.foregroundColor;
    }

    @Nullable
    public final String component5() {
        return this.backgroundColor;
    }

    @Nullable
    public final List<String> component6() {
        return this.showTrackUrlList;
    }

    @Nullable
    public final List<String> component7() {
        return this.clickTrackUrlList;
    }

    @NotNull
    public final SponsorModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable List<String> list, @Nullable List<String> list2) {
        return new SponsorModel(str, str2, str3, str4, str5, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SponsorModel)) {
            return false;
        }
        SponsorModel sponsorModel = (SponsorModel) obj;
        return s.d(this.title, sponsorModel.title) && s.d(this.label, sponsorModel.label) && s.d(this.url, sponsorModel.url) && s.d(this.foregroundColor, sponsorModel.foregroundColor) && s.d(this.backgroundColor, sponsorModel.backgroundColor) && s.d(this.showTrackUrlList, sponsorModel.showTrackUrlList) && s.d(this.clickTrackUrlList, sponsorModel.clickTrackUrlList);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final List<String> getClickTrackUrlList() {
        return this.clickTrackUrlList;
    }

    @Nullable
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final List<String> getShowTrackUrlList() {
        return this.showTrackUrlList;
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
        String str2 = this.label;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.foregroundColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.backgroundColor;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.showTrackUrlList;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.clickTrackUrlList;
        return hashCode6 + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SponsorModel(title=" + this.title + ", label=" + this.label + ", url=" + this.url + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", showTrackUrlList=" + ((Object) this.showTrackUrlList) + ", clickTrackUrlList=" + ((Object) this.clickTrackUrlList) + ")";
    }
}
