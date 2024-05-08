package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AndroidUpdateVersionModel {
    private boolean hasUpdateVersion;

    @NotNull
    private String updateDetails;

    @Nullable
    private final String urlAndroidAPK;

    public AndroidUpdateVersionModel(boolean z10, @NotNull String updateDetails, @Nullable String str) {
        s.i(updateDetails, "updateDetails");
        this.hasUpdateVersion = z10;
        this.updateDetails = updateDetails;
        this.urlAndroidAPK = str;
    }

    public static /* synthetic */ AndroidUpdateVersionModel copy$default(AndroidUpdateVersionModel androidUpdateVersionModel, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = androidUpdateVersionModel.hasUpdateVersion;
        }
        if ((i10 & 2) != 0) {
            str = androidUpdateVersionModel.updateDetails;
        }
        if ((i10 & 4) != 0) {
            str2 = androidUpdateVersionModel.urlAndroidAPK;
        }
        return androidUpdateVersionModel.copy(z10, str, str2);
    }

    public final boolean component1() {
        return this.hasUpdateVersion;
    }

    @NotNull
    public final String component2() {
        return this.updateDetails;
    }

    @Nullable
    public final String component3() {
        return this.urlAndroidAPK;
    }

    @NotNull
    public final AndroidUpdateVersionModel copy(boolean z10, @NotNull String updateDetails, @Nullable String str) {
        s.i(updateDetails, "updateDetails");
        return new AndroidUpdateVersionModel(z10, updateDetails, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidUpdateVersionModel)) {
            return false;
        }
        AndroidUpdateVersionModel androidUpdateVersionModel = (AndroidUpdateVersionModel) obj;
        return this.hasUpdateVersion == androidUpdateVersionModel.hasUpdateVersion && s.d(this.updateDetails, androidUpdateVersionModel.updateDetails) && s.d(this.urlAndroidAPK, androidUpdateVersionModel.urlAndroidAPK);
    }

    public final boolean getHasUpdateVersion() {
        return this.hasUpdateVersion;
    }

    @NotNull
    public final String getUpdateDetails() {
        return this.updateDetails;
    }

    @Nullable
    public final String getUrlAndroidAPK() {
        return this.urlAndroidAPK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.hasUpdateVersion;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int hashCode = ((r02 * 31) + this.updateDetails.hashCode()) * 31;
        String str = this.urlAndroidAPK;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setHasUpdateVersion(boolean z10) {
        this.hasUpdateVersion = z10;
    }

    public final void setUpdateDetails(@NotNull String str) {
        s.i(str, "<set-?>");
        this.updateDetails = str;
    }

    @NotNull
    public String toString() {
        return "AndroidUpdateVersionModel(hasUpdateVersion=" + this.hasUpdateVersion + ", updateDetails=" + this.updateDetails + ", urlAndroidAPK=" + this.urlAndroidAPK + ")";
    }

    public /* synthetic */ AndroidUpdateVersionModel(boolean z10, String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? "" : str, str2);
    }
}
