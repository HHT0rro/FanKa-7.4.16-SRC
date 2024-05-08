package com.cupidapp.live.feed.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdTipModel implements Serializable {

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final Integer duration;

    @Nullable
    private final String foregroundColor;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String title;

    public AdTipModel(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.title = str;
        this.duration = num;
        this.jumpUrl = str2;
        this.foregroundColor = str3;
        this.backgroundColor = str4;
    }

    public static /* synthetic */ AdTipModel copy$default(AdTipModel adTipModel, String str, Integer num, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = adTipModel.title;
        }
        if ((i10 & 2) != 0) {
            num = adTipModel.duration;
        }
        Integer num2 = num;
        if ((i10 & 4) != 0) {
            str2 = adTipModel.jumpUrl;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            str3 = adTipModel.foregroundColor;
        }
        String str6 = str3;
        if ((i10 & 16) != 0) {
            str4 = adTipModel.backgroundColor;
        }
        return adTipModel.copy(str, num2, str5, str6, str4);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Integer component2() {
        return this.duration;
    }

    @Nullable
    public final String component3() {
        return this.jumpUrl;
    }

    @Nullable
    public final String component4() {
        return this.foregroundColor;
    }

    @Nullable
    public final String component5() {
        return this.backgroundColor;
    }

    @NotNull
    public final AdTipModel copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new AdTipModel(str, num, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdTipModel)) {
            return false;
        }
        AdTipModel adTipModel = (AdTipModel) obj;
        return s.d(this.title, adTipModel.title) && s.d(this.duration, adTipModel.duration) && s.d(this.jumpUrl, adTipModel.jumpUrl) && s.d(this.foregroundColor, adTipModel.foregroundColor) && s.d(this.backgroundColor, adTipModel.backgroundColor);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.duration;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.jumpUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.foregroundColor;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.backgroundColor;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        Integer num = this.duration;
        return "AdTipModel(title=" + str + ", duration=" + ((Object) num) + ", jumpUrl=" + this.jumpUrl + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ")";
    }
}
