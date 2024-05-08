package com.cupidapp.live.visitors.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorMarketingInfoModel {

    @Nullable
    private final String actionName;

    @Nullable
    private final String marketingType;
    private final int number;

    @Nullable
    private final String secondTitle;

    @Nullable
    private final String title;

    public VisitorMarketingInfoModel() {
        this(null, null, null, 0, null, 31, null);
    }

    public VisitorMarketingInfoModel(@Nullable String str, @Nullable String str2, @Nullable String str3, int i10, @Nullable String str4) {
        this.actionName = str;
        this.marketingType = str2;
        this.title = str3;
        this.number = i10;
        this.secondTitle = str4;
    }

    public static /* synthetic */ VisitorMarketingInfoModel copy$default(VisitorMarketingInfoModel visitorMarketingInfoModel, String str, String str2, String str3, int i10, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = visitorMarketingInfoModel.actionName;
        }
        if ((i11 & 2) != 0) {
            str2 = visitorMarketingInfoModel.marketingType;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = visitorMarketingInfoModel.title;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            i10 = visitorMarketingInfoModel.number;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            str4 = visitorMarketingInfoModel.secondTitle;
        }
        return visitorMarketingInfoModel.copy(str, str5, str6, i12, str4);
    }

    @Nullable
    public final String component1() {
        return this.actionName;
    }

    @Nullable
    public final String component2() {
        return this.marketingType;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.number;
    }

    @Nullable
    public final String component5() {
        return this.secondTitle;
    }

    @NotNull
    public final VisitorMarketingInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, int i10, @Nullable String str4) {
        return new VisitorMarketingInfoModel(str, str2, str3, i10, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorMarketingInfoModel)) {
            return false;
        }
        VisitorMarketingInfoModel visitorMarketingInfoModel = (VisitorMarketingInfoModel) obj;
        return s.d(this.actionName, visitorMarketingInfoModel.actionName) && s.d(this.marketingType, visitorMarketingInfoModel.marketingType) && s.d(this.title, visitorMarketingInfoModel.title) && this.number == visitorMarketingInfoModel.number && s.d(this.secondTitle, visitorMarketingInfoModel.secondTitle);
    }

    @Nullable
    public final String getActionName() {
        return this.actionName;
    }

    @Nullable
    public final String getMarketingType() {
        return this.marketingType;
    }

    public final int getNumber() {
        return this.number;
    }

    @Nullable
    public final String getSecondTitle() {
        return this.secondTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.actionName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.marketingType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.number) * 31;
        String str4 = this.secondTitle;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VisitorMarketingInfoModel(actionName=" + this.actionName + ", marketingType=" + this.marketingType + ", title=" + this.title + ", number=" + this.number + ", secondTitle=" + this.secondTitle + ")";
    }

    public /* synthetic */ VisitorMarketingInfoModel(String str, String str2, String str3, int i10, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : str4);
    }
}
