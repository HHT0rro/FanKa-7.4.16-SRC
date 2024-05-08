package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DailyLikeGuideModel implements Serializable {

    @Nullable
    private final String describe;

    @Nullable
    private final Integer popType;

    @Nullable
    private final List<ImageModel> viewList;

    public DailyLikeGuideModel(@Nullable Integer num, @Nullable String str, @Nullable List<ImageModel> list) {
        this.popType = num;
        this.describe = str;
        this.viewList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DailyLikeGuideModel copy$default(DailyLikeGuideModel dailyLikeGuideModel, Integer num, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = dailyLikeGuideModel.popType;
        }
        if ((i10 & 2) != 0) {
            str = dailyLikeGuideModel.describe;
        }
        if ((i10 & 4) != 0) {
            list = dailyLikeGuideModel.viewList;
        }
        return dailyLikeGuideModel.copy(num, str, list);
    }

    @Nullable
    public final Integer component1() {
        return this.popType;
    }

    @Nullable
    public final String component2() {
        return this.describe;
    }

    @Nullable
    public final List<ImageModel> component3() {
        return this.viewList;
    }

    @NotNull
    public final DailyLikeGuideModel copy(@Nullable Integer num, @Nullable String str, @Nullable List<ImageModel> list) {
        return new DailyLikeGuideModel(num, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyLikeGuideModel)) {
            return false;
        }
        DailyLikeGuideModel dailyLikeGuideModel = (DailyLikeGuideModel) obj;
        return s.d(this.popType, dailyLikeGuideModel.popType) && s.d(this.describe, dailyLikeGuideModel.describe) && s.d(this.viewList, dailyLikeGuideModel.viewList);
    }

    @Nullable
    public final String getDescribe() {
        return this.describe;
    }

    @Nullable
    public final Integer getPopType() {
        return this.popType;
    }

    @Nullable
    public final List<ImageModel> getViewList() {
        return this.viewList;
    }

    public int hashCode() {
        Integer num = this.popType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.describe;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<ImageModel> list = this.viewList;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.popType;
        return "DailyLikeGuideModel(popType=" + ((Object) num) + ", describe=" + this.describe + ", viewList=" + ((Object) this.viewList) + ")";
    }

    public /* synthetic */ DailyLikeGuideModel(Integer num, String str, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, (i10 & 4) != 0 ? null : list);
    }
}
