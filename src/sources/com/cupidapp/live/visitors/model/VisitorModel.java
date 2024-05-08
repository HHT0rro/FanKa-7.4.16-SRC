package com.cupidapp.live.visitors.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorModel {

    @Nullable
    private final Boolean marketingBtnBold;

    @Nullable
    private final String marketingBtnName;

    @Nullable
    private final String marketingName;

    @Nullable
    private final String source;

    @Nullable
    private final String summaryInfo;

    @Nullable
    private final Boolean useLocalTime;

    @Nullable
    private final User user;

    @Nullable
    private final Boolean visitMeOften;

    @Nullable
    private final Long visitorTimeMillis;

    @Nullable
    private final String visitorTimeStr;

    public VisitorModel(@Nullable User user, @Nullable String str, @Nullable Long l10, @Nullable Boolean bool, @Nullable String str2, @Nullable Boolean bool2, @Nullable String str3, @Nullable Boolean bool3, @Nullable String str4, @Nullable String str5) {
        this.user = user;
        this.source = str;
        this.visitorTimeMillis = l10;
        this.useLocalTime = bool;
        this.visitorTimeStr = str2;
        this.visitMeOften = bool2;
        this.marketingName = str3;
        this.marketingBtnBold = bool3;
        this.marketingBtnName = str4;
        this.summaryInfo = str5;
    }

    @Nullable
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component10() {
        return this.summaryInfo;
    }

    @Nullable
    public final String component2() {
        return this.source;
    }

    @Nullable
    public final Long component3() {
        return this.visitorTimeMillis;
    }

    @Nullable
    public final Boolean component4() {
        return this.useLocalTime;
    }

    @Nullable
    public final String component5() {
        return this.visitorTimeStr;
    }

    @Nullable
    public final Boolean component6() {
        return this.visitMeOften;
    }

    @Nullable
    public final String component7() {
        return this.marketingName;
    }

    @Nullable
    public final Boolean component8() {
        return this.marketingBtnBold;
    }

    @Nullable
    public final String component9() {
        return this.marketingBtnName;
    }

    @NotNull
    public final VisitorModel copy(@Nullable User user, @Nullable String str, @Nullable Long l10, @Nullable Boolean bool, @Nullable String str2, @Nullable Boolean bool2, @Nullable String str3, @Nullable Boolean bool3, @Nullable String str4, @Nullable String str5) {
        return new VisitorModel(user, str, l10, bool, str2, bool2, str3, bool3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorModel)) {
            return false;
        }
        VisitorModel visitorModel = (VisitorModel) obj;
        return s.d(this.user, visitorModel.user) && s.d(this.source, visitorModel.source) && s.d(this.visitorTimeMillis, visitorModel.visitorTimeMillis) && s.d(this.useLocalTime, visitorModel.useLocalTime) && s.d(this.visitorTimeStr, visitorModel.visitorTimeStr) && s.d(this.visitMeOften, visitorModel.visitMeOften) && s.d(this.marketingName, visitorModel.marketingName) && s.d(this.marketingBtnBold, visitorModel.marketingBtnBold) && s.d(this.marketingBtnName, visitorModel.marketingBtnName) && s.d(this.summaryInfo, visitorModel.summaryInfo);
    }

    @Nullable
    public final Boolean getMarketingBtnBold() {
        return this.marketingBtnBold;
    }

    @Nullable
    public final String getMarketingBtnName() {
        return this.marketingBtnName;
    }

    @Nullable
    public final String getMarketingName() {
        return this.marketingName;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    @Nullable
    public final Boolean getUseLocalTime() {
        return this.useLocalTime;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final Boolean getVisitMeOften() {
        return this.visitMeOften;
    }

    @Nullable
    public final Long getVisitorTimeMillis() {
        return this.visitorTimeMillis;
    }

    @Nullable
    public final String getVisitorTimeStr() {
        return this.visitorTimeStr;
    }

    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        String str = this.source;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.visitorTimeMillis;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Boolean bool = this.useLocalTime;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.visitorTimeStr;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool2 = this.visitMeOften;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.marketingName;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool3 = this.marketingBtnBold;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str4 = this.marketingBtnName;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.summaryInfo;
        return hashCode9 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        String str = this.source;
        Long l10 = this.visitorTimeMillis;
        Boolean bool = this.useLocalTime;
        String str2 = this.visitorTimeStr;
        Boolean bool2 = this.visitMeOften;
        String str3 = this.marketingName;
        Boolean bool3 = this.marketingBtnBold;
        return "VisitorModel(user=" + ((Object) user) + ", source=" + str + ", visitorTimeMillis=" + ((Object) l10) + ", useLocalTime=" + ((Object) bool) + ", visitorTimeStr=" + str2 + ", visitMeOften=" + ((Object) bool2) + ", marketingName=" + str3 + ", marketingBtnBold=" + ((Object) bool3) + ", marketingBtnName=" + this.marketingBtnName + ", summaryInfo=" + this.summaryInfo + ")";
    }

    public /* synthetic */ VisitorModel(User user, String str, Long l10, Boolean bool, String str2, Boolean bool2, String str3, Boolean bool3, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, l10, (i10 & 8) != 0 ? Boolean.FALSE : bool, str2, (i10 & 32) != 0 ? Boolean.FALSE : bool2, str3, bool3, str4, str5);
    }
}
