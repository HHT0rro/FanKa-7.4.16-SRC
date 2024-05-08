package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ABTestResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ABTestModel {

    @Nullable
    private final String name;

    @Nullable
    private final String result;

    @Nullable
    private final Integer type;

    public ABTestModel(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        this.name = str;
        this.type = num;
        this.result = str2;
    }

    public static /* synthetic */ ABTestModel copy$default(ABTestModel aBTestModel, String str, Integer num, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = aBTestModel.name;
        }
        if ((i10 & 2) != 0) {
            num = aBTestModel.type;
        }
        if ((i10 & 4) != 0) {
            str2 = aBTestModel.result;
        }
        return aBTestModel.copy(str, num, str2);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final Integer component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.result;
    }

    @NotNull
    public final ABTestModel copy(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        return new ABTestModel(str, num, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ABTestModel)) {
            return false;
        }
        ABTestModel aBTestModel = (ABTestModel) obj;
        return s.d(this.name, aBTestModel.name) && s.d(this.type, aBTestModel.type) && s.d(this.result, aBTestModel.result);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getResult() {
        return this.result;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.result;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.name;
        Integer num = this.type;
        return "ABTestModel(name=" + str + ", type=" + ((Object) num) + ", result=" + this.result + ")";
    }
}
