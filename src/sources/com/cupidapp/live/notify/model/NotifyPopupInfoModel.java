package com.cupidapp.live.notify.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyPopupInfoModel {

    @Nullable
    private final String actName;

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;

    public NotifyPopupInfoModel(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.title = str;
        this.subTitle = str2;
        this.actName = str3;
    }

    public static /* synthetic */ NotifyPopupInfoModel copy$default(NotifyPopupInfoModel notifyPopupInfoModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = notifyPopupInfoModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = notifyPopupInfoModel.subTitle;
        }
        if ((i10 & 4) != 0) {
            str3 = notifyPopupInfoModel.actName;
        }
        return notifyPopupInfoModel.copy(str, str2, str3);
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
        return this.actName;
    }

    @NotNull
    public final NotifyPopupInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new NotifyPopupInfoModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyPopupInfoModel)) {
            return false;
        }
        NotifyPopupInfoModel notifyPopupInfoModel = (NotifyPopupInfoModel) obj;
        return s.d(this.title, notifyPopupInfoModel.title) && s.d(this.subTitle, notifyPopupInfoModel.subTitle) && s.d(this.actName, notifyPopupInfoModel.actName);
    }

    @Nullable
    public final String getActName() {
        return this.actName;
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
        String str3 = this.actName;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NotifyPopupInfoModel(title=" + this.title + ", subTitle=" + this.subTitle + ", actName=" + this.actName + ")";
    }
}
