package com.cupidapp.live.superboost.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DirectSuperBoostFilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DirectSuperBoostFilterModel {

    @Nullable
    private final List<FilterOptionModel> ages;

    @Nullable
    private final List<FilterOptionModel> cities;

    @Nullable
    private final List<FilterOptionModel> isLimitFake;

    @Nullable
    private final List<FilterOptionModel> roles;

    public DirectSuperBoostFilterModel(@Nullable List<FilterOptionModel> list, @Nullable List<FilterOptionModel> list2, @Nullable List<FilterOptionModel> list3, @Nullable List<FilterOptionModel> list4) {
        this.ages = list;
        this.cities = list2;
        this.roles = list3;
        this.isLimitFake = list4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirectSuperBoostFilterModel copy$default(DirectSuperBoostFilterModel directSuperBoostFilterModel, List list, List list2, List list3, List list4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = directSuperBoostFilterModel.ages;
        }
        if ((i10 & 2) != 0) {
            list2 = directSuperBoostFilterModel.cities;
        }
        if ((i10 & 4) != 0) {
            list3 = directSuperBoostFilterModel.roles;
        }
        if ((i10 & 8) != 0) {
            list4 = directSuperBoostFilterModel.isLimitFake;
        }
        return directSuperBoostFilterModel.copy(list, list2, list3, list4);
    }

    @Nullable
    public final List<FilterOptionModel> component1() {
        return this.ages;
    }

    @Nullable
    public final List<FilterOptionModel> component2() {
        return this.cities;
    }

    @Nullable
    public final List<FilterOptionModel> component3() {
        return this.roles;
    }

    @Nullable
    public final List<FilterOptionModel> component4() {
        return this.isLimitFake;
    }

    @NotNull
    public final DirectSuperBoostFilterModel copy(@Nullable List<FilterOptionModel> list, @Nullable List<FilterOptionModel> list2, @Nullable List<FilterOptionModel> list3, @Nullable List<FilterOptionModel> list4) {
        return new DirectSuperBoostFilterModel(list, list2, list3, list4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DirectSuperBoostFilterModel)) {
            return false;
        }
        DirectSuperBoostFilterModel directSuperBoostFilterModel = (DirectSuperBoostFilterModel) obj;
        return s.d(this.ages, directSuperBoostFilterModel.ages) && s.d(this.cities, directSuperBoostFilterModel.cities) && s.d(this.roles, directSuperBoostFilterModel.roles) && s.d(this.isLimitFake, directSuperBoostFilterModel.isLimitFake);
    }

    @Nullable
    public final List<FilterOptionModel> getAges() {
        return this.ages;
    }

    @Nullable
    public final List<FilterOptionModel> getCities() {
        return this.cities;
    }

    @Nullable
    public final List<FilterOptionModel> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        List<FilterOptionModel> list = this.ages;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<FilterOptionModel> list2 = this.cities;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<FilterOptionModel> list3 = this.roles;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<FilterOptionModel> list4 = this.isLimitFake;
        return hashCode3 + (list4 != null ? list4.hashCode() : 0);
    }

    @Nullable
    public final List<FilterOptionModel> isLimitFake() {
        return this.isLimitFake;
    }

    @NotNull
    public String toString() {
        return "DirectSuperBoostFilterModel(ages=" + ((Object) this.ages) + ", cities=" + ((Object) this.cities) + ", roles=" + ((Object) this.roles) + ", isLimitFake=" + ((Object) this.isLimitFake) + ")";
    }
}
