package com.cupidapp.live.main.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PassportModel {
    private final boolean bind;

    @Nullable
    private final String name;

    public PassportModel(boolean z10, @Nullable String str) {
        this.bind = z10;
        this.name = str;
    }

    public static /* synthetic */ PassportModel copy$default(PassportModel passportModel, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = passportModel.bind;
        }
        if ((i10 & 2) != 0) {
            str = passportModel.name;
        }
        return passportModel.copy(z10, str);
    }

    public final boolean component1() {
        return this.bind;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final PassportModel copy(boolean z10, @Nullable String str) {
        return new PassportModel(z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportModel)) {
            return false;
        }
        PassportModel passportModel = (PassportModel) obj;
        return this.bind == passportModel.bind && s.d(this.name, passportModel.name);
    }

    public final boolean getBind() {
        return this.bind;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.bind;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.name;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "PassportModel(bind=" + this.bind + ", name=" + this.name + ")";
    }

    public /* synthetic */ PassportModel(boolean z10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, str);
    }
}
