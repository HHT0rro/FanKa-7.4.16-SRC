package com.cupidapp.live.match.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperFilterModel implements Serializable {

    @NotNull
    private final String key;

    @NotNull
    private final String name;

    @NotNull
    private final List<FilterOption> options;

    public SuperFilterModel(@NotNull String name, @NotNull String key, @NotNull List<FilterOption> options) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(options, "options");
        this.name = name;
        this.key = key;
        this.options = options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuperFilterModel copy$default(SuperFilterModel superFilterModel, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = superFilterModel.name;
        }
        if ((i10 & 2) != 0) {
            str2 = superFilterModel.key;
        }
        if ((i10 & 4) != 0) {
            list = superFilterModel.options;
        }
        return superFilterModel.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    @NotNull
    public final List<FilterOption> component3() {
        return this.options;
    }

    @NotNull
    public final SuperFilterModel copy(@NotNull String name, @NotNull String key, @NotNull List<FilterOption> options) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(options, "options");
        return new SuperFilterModel(name, key, options);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperFilterModel)) {
            return false;
        }
        SuperFilterModel superFilterModel = (SuperFilterModel) obj;
        return s.d(this.name, superFilterModel.name) && s.d(this.key, superFilterModel.key) && s.d(this.options, superFilterModel.options);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<FilterOption> getOptions() {
        return this.options;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.key.hashCode()) * 31) + this.options.hashCode();
    }

    @NotNull
    public String toString() {
        return "SuperFilterModel(name=" + this.name + ", key=" + this.key + ", options=" + ((Object) this.options) + ")";
    }
}
