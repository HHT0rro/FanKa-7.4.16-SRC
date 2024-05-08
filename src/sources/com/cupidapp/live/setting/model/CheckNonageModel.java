package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckNonageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CheckNonageModel {

    @Nullable
    private final Boolean bindMobile;

    @Nullable
    private final Boolean hasPassword;

    @Nullable
    private final String jumpUrl;

    public CheckNonageModel(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        this.jumpUrl = str;
        this.hasPassword = bool;
        this.bindMobile = bool2;
    }

    public static /* synthetic */ CheckNonageModel copy$default(CheckNonageModel checkNonageModel, String str, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = checkNonageModel.jumpUrl;
        }
        if ((i10 & 2) != 0) {
            bool = checkNonageModel.hasPassword;
        }
        if ((i10 & 4) != 0) {
            bool2 = checkNonageModel.bindMobile;
        }
        return checkNonageModel.copy(str, bool, bool2);
    }

    @Nullable
    public final String component1() {
        return this.jumpUrl;
    }

    @Nullable
    public final Boolean component2() {
        return this.hasPassword;
    }

    @Nullable
    public final Boolean component3() {
        return this.bindMobile;
    }

    @NotNull
    public final CheckNonageModel copy(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2) {
        return new CheckNonageModel(str, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckNonageModel)) {
            return false;
        }
        CheckNonageModel checkNonageModel = (CheckNonageModel) obj;
        return s.d(this.jumpUrl, checkNonageModel.jumpUrl) && s.d(this.hasPassword, checkNonageModel.hasPassword) && s.d(this.bindMobile, checkNonageModel.bindMobile);
    }

    @Nullable
    public final Boolean getBindMobile() {
        return this.bindMobile;
    }

    @Nullable
    public final Boolean getHasPassword() {
        return this.hasPassword;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        String str = this.jumpUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.hasPassword;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.bindMobile;
        return hashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CheckNonageModel(jumpUrl=" + this.jumpUrl + ", hasPassword=" + ((Object) this.hasPassword) + ", bindMobile=" + ((Object) this.bindMobile) + ")";
    }
}
