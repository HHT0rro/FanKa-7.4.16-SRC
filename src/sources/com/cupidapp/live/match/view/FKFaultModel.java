package com.cupidapp.live.match.view;

import com.cupidapp.live.match.model.MatchSettingResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardFaultPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKFaultModel {
    private final boolean emptyList;

    @Nullable
    private final Integer errorCode;

    @Nullable
    private final String errorMessage;

    @Nullable
    private final MatchSettingResult filter;

    public FKFaultModel() {
        this(null, null, false, null, 15, null);
    }

    public FKFaultModel(@Nullable Integer num, @Nullable String str, boolean z10, @Nullable MatchSettingResult matchSettingResult) {
        this.errorCode = num;
        this.errorMessage = str;
        this.emptyList = z10;
        this.filter = matchSettingResult;
    }

    public static /* synthetic */ FKFaultModel copy$default(FKFaultModel fKFaultModel, Integer num, String str, boolean z10, MatchSettingResult matchSettingResult, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = fKFaultModel.errorCode;
        }
        if ((i10 & 2) != 0) {
            str = fKFaultModel.errorMessage;
        }
        if ((i10 & 4) != 0) {
            z10 = fKFaultModel.emptyList;
        }
        if ((i10 & 8) != 0) {
            matchSettingResult = fKFaultModel.filter;
        }
        return fKFaultModel.copy(num, str, z10, matchSettingResult);
    }

    @Nullable
    public final Integer component1() {
        return this.errorCode;
    }

    @Nullable
    public final String component2() {
        return this.errorMessage;
    }

    public final boolean component3() {
        return this.emptyList;
    }

    @Nullable
    public final MatchSettingResult component4() {
        return this.filter;
    }

    @NotNull
    public final FKFaultModel copy(@Nullable Integer num, @Nullable String str, boolean z10, @Nullable MatchSettingResult matchSettingResult) {
        return new FKFaultModel(num, str, z10, matchSettingResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFaultModel)) {
            return false;
        }
        FKFaultModel fKFaultModel = (FKFaultModel) obj;
        return kotlin.jvm.internal.s.d(this.errorCode, fKFaultModel.errorCode) && kotlin.jvm.internal.s.d(this.errorMessage, fKFaultModel.errorMessage) && this.emptyList == fKFaultModel.emptyList && kotlin.jvm.internal.s.d(this.filter, fKFaultModel.filter);
    }

    public final boolean getEmptyList() {
        return this.emptyList;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final MatchSettingResult getFilter() {
        return this.filter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.errorCode;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.errorMessage;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.emptyList;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        MatchSettingResult matchSettingResult = this.filter;
        return i11 + (matchSettingResult != null ? matchSettingResult.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.errorCode;
        return "FKFaultModel(errorCode=" + ((Object) num) + ", errorMessage=" + this.errorMessage + ", emptyList=" + this.emptyList + ", filter=" + ((Object) this.filter) + ")";
    }

    public /* synthetic */ FKFaultModel(Integer num, String str, boolean z10, MatchSettingResult matchSettingResult, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : matchSettingResult);
    }
}
