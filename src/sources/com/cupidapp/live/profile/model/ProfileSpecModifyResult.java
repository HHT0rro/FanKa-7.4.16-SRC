package com.cupidapp.live.profile.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileSpecListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileSpecModifyResult {
    private int error;

    @NotNull
    private final List<ProfileSpecListModel> list;

    public ProfileSpecModifyResult(@NotNull List<ProfileSpecListModel> list, int i10) {
        s.i(list, "list");
        this.list = list;
        this.error = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileSpecModifyResult copy$default(ProfileSpecModifyResult profileSpecModifyResult, List list, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = profileSpecModifyResult.list;
        }
        if ((i11 & 2) != 0) {
            i10 = profileSpecModifyResult.error;
        }
        return profileSpecModifyResult.copy(list, i10);
    }

    @NotNull
    public final List<ProfileSpecListModel> component1() {
        return this.list;
    }

    public final int component2() {
        return this.error;
    }

    @NotNull
    public final ProfileSpecModifyResult copy(@NotNull List<ProfileSpecListModel> list, int i10) {
        s.i(list, "list");
        return new ProfileSpecModifyResult(list, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileSpecModifyResult)) {
            return false;
        }
        ProfileSpecModifyResult profileSpecModifyResult = (ProfileSpecModifyResult) obj;
        return s.d(this.list, profileSpecModifyResult.list) && this.error == profileSpecModifyResult.error;
    }

    public final int getError() {
        return this.error;
    }

    @NotNull
    public final List<ProfileSpecListModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + this.error;
    }

    public final void setError(int i10) {
        this.error = i10;
    }

    @NotNull
    public String toString() {
        List<ProfileSpecListModel> list = this.list;
        return "ProfileSpecModifyResult(list=" + ((Object) list) + ", error=" + this.error + ")";
    }

    public /* synthetic */ ProfileSpecModifyResult(List list, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i11 & 2) != 0 ? 0 : i10);
    }
}
