package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperFilterOptionModel {

    @NotNull
    private final String key;

    @Nullable
    private final List<FilterOption> options;
    private final int productType;

    @NotNull
    private final String title;

    public SuperFilterOptionModel(@NotNull String title, @NotNull String key, int i10, @Nullable List<FilterOption> list) {
        s.i(title, "title");
        s.i(key, "key");
        this.title = title;
        this.key = key;
        this.productType = i10;
        this.options = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuperFilterOptionModel copy$default(SuperFilterOptionModel superFilterOptionModel, String str, String str2, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = superFilterOptionModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = superFilterOptionModel.key;
        }
        if ((i11 & 4) != 0) {
            i10 = superFilterOptionModel.productType;
        }
        if ((i11 & 8) != 0) {
            list = superFilterOptionModel.options;
        }
        return superFilterOptionModel.copy(str, str2, i10, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    public final int component3() {
        return this.productType;
    }

    @Nullable
    public final List<FilterOption> component4() {
        return this.options;
    }

    @NotNull
    public final SuperFilterOptionModel copy(@NotNull String title, @NotNull String key, int i10, @Nullable List<FilterOption> list) {
        s.i(title, "title");
        s.i(key, "key");
        return new SuperFilterOptionModel(title, key, i10, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperFilterOptionModel)) {
            return false;
        }
        SuperFilterOptionModel superFilterOptionModel = (SuperFilterOptionModel) obj;
        return s.d(this.title, superFilterOptionModel.title) && s.d(this.key, superFilterOptionModel.key) && this.productType == superFilterOptionModel.productType && s.d(this.options, superFilterOptionModel.options);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final List<FilterOption> getOptions() {
        return this.options;
    }

    public final int getProductType() {
        return this.productType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.key.hashCode()) * 31) + this.productType) * 31;
        List<FilterOption> list = this.options;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "SuperFilterOptionModel(title=" + this.title + ", key=" + this.key + ", productType=" + this.productType + ", options=" + ((Object) this.options) + ")";
    }
}
