package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ExposureEntranceModel {

    @Nullable
    private final String travelH5Url;

    @Nullable
    private final String travelboostMarketingMsg;

    public ExposureEntranceModel(@Nullable String str, @Nullable String str2) {
        this.travelboostMarketingMsg = str;
        this.travelH5Url = str2;
    }

    public static /* synthetic */ ExposureEntranceModel copy$default(ExposureEntranceModel exposureEntranceModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = exposureEntranceModel.travelboostMarketingMsg;
        }
        if ((i10 & 2) != 0) {
            str2 = exposureEntranceModel.travelH5Url;
        }
        return exposureEntranceModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.travelboostMarketingMsg;
    }

    @Nullable
    public final String component2() {
        return this.travelH5Url;
    }

    @NotNull
    public final ExposureEntranceModel copy(@Nullable String str, @Nullable String str2) {
        return new ExposureEntranceModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExposureEntranceModel)) {
            return false;
        }
        ExposureEntranceModel exposureEntranceModel = (ExposureEntranceModel) obj;
        return s.d(this.travelboostMarketingMsg, exposureEntranceModel.travelboostMarketingMsg) && s.d(this.travelH5Url, exposureEntranceModel.travelH5Url);
    }

    @Nullable
    public final String getTravelH5Url() {
        return this.travelH5Url;
    }

    @Nullable
    public final String getTravelboostMarketingMsg() {
        return this.travelboostMarketingMsg;
    }

    public int hashCode() {
        String str = this.travelboostMarketingMsg;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.travelH5Url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ExposureEntranceModel(travelboostMarketingMsg=" + this.travelboostMarketingMsg + ", travelH5Url=" + this.travelH5Url + ")";
    }
}
