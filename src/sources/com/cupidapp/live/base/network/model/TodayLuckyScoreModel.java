package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TodayLuckyScoreModel {

    @Nullable
    private final String description;

    @Nullable
    private final ImageModel icon;

    @NotNull
    private final String title;

    @Nullable
    private final String trackName;

    @Nullable
    private final String url;

    public TodayLuckyScoreModel(@NotNull String title, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable String str3) {
        s.i(title, "title");
        this.title = title;
        this.description = str;
        this.url = str2;
        this.icon = imageModel;
        this.trackName = str3;
    }

    public static /* synthetic */ TodayLuckyScoreModel copy$default(TodayLuckyScoreModel todayLuckyScoreModel, String str, String str2, String str3, ImageModel imageModel, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = todayLuckyScoreModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = todayLuckyScoreModel.description;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = todayLuckyScoreModel.url;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            imageModel = todayLuckyScoreModel.icon;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 16) != 0) {
            str4 = todayLuckyScoreModel.trackName;
        }
        return todayLuckyScoreModel.copy(str, str5, str6, imageModel2, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final ImageModel component4() {
        return this.icon;
    }

    @Nullable
    public final String component5() {
        return this.trackName;
    }

    @NotNull
    public final TodayLuckyScoreModel copy(@NotNull String title, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable String str3) {
        s.i(title, "title");
        return new TodayLuckyScoreModel(title, str, str2, imageModel, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TodayLuckyScoreModel)) {
            return false;
        }
        TodayLuckyScoreModel todayLuckyScoreModel = (TodayLuckyScoreModel) obj;
        return s.d(this.title, todayLuckyScoreModel.title) && s.d(this.description, todayLuckyScoreModel.description) && s.d(this.url, todayLuckyScoreModel.url) && s.d(this.icon, todayLuckyScoreModel.icon) && s.d(this.trackName, todayLuckyScoreModel.trackName);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.icon;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str3 = this.trackName;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.url;
        ImageModel imageModel = this.icon;
        return "TodayLuckyScoreModel(title=" + str + ", description=" + str2 + ", url=" + str3 + ", icon=" + ((Object) imageModel) + ", trackName=" + this.trackName + ")";
    }

    public /* synthetic */ TodayLuckyScoreModel(String str, String str2, String str3, ImageModel imageModel, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i10 & 8) != 0 ? null : imageModel, str4);
    }
}
