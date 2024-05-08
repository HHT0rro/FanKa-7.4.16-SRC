package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserTypeModel {

    @NotNull
    private final String name;

    @Nullable
    private final List<FilterOption> options;
    private final int productType;

    public UserTypeModel(@NotNull String name, int i10, @Nullable List<FilterOption> list) {
        s.i(name, "name");
        this.name = name;
        this.productType = i10;
        this.options = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserTypeModel copy$default(UserTypeModel userTypeModel, String str, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = userTypeModel.name;
        }
        if ((i11 & 2) != 0) {
            i10 = userTypeModel.productType;
        }
        if ((i11 & 4) != 0) {
            list = userTypeModel.options;
        }
        return userTypeModel.copy(str, i10, list);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.productType;
    }

    @Nullable
    public final List<FilterOption> component3() {
        return this.options;
    }

    @NotNull
    public final UserTypeModel copy(@NotNull String name, int i10, @Nullable List<FilterOption> list) {
        s.i(name, "name");
        return new UserTypeModel(name, i10, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTypeModel)) {
            return false;
        }
        UserTypeModel userTypeModel = (UserTypeModel) obj;
        return s.d(this.name, userTypeModel.name) && this.productType == userTypeModel.productType && s.d(this.options, userTypeModel.options);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<FilterOption> getOptions() {
        return this.options;
    }

    public final int getProductType() {
        return this.productType;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.productType) * 31;
        List<FilterOption> list = this.options;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "UserTypeModel(name=" + this.name + ", productType=" + this.productType + ", options=" + ((Object) this.options) + ")";
    }
}
