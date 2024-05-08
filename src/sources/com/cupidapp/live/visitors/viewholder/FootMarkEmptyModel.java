package com.cupidapp.live.visitors.viewholder;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FootMarkEmptyViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootMarkEmptyModel {

    @Nullable
    private final Integer btnRes;

    @Nullable
    private final Integer emptyDesRes;

    @Nullable
    private final Integer emptyImage;

    @Nullable
    private final Integer emptyTitleRes;

    public FootMarkEmptyModel() {
        this(null, null, null, null, 15, null);
    }

    public FootMarkEmptyModel(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        this.emptyImage = num;
        this.emptyTitleRes = num2;
        this.emptyDesRes = num3;
        this.btnRes = num4;
    }

    public static /* synthetic */ FootMarkEmptyModel copy$default(FootMarkEmptyModel footMarkEmptyModel, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = footMarkEmptyModel.emptyImage;
        }
        if ((i10 & 2) != 0) {
            num2 = footMarkEmptyModel.emptyTitleRes;
        }
        if ((i10 & 4) != 0) {
            num3 = footMarkEmptyModel.emptyDesRes;
        }
        if ((i10 & 8) != 0) {
            num4 = footMarkEmptyModel.btnRes;
        }
        return footMarkEmptyModel.copy(num, num2, num3, num4);
    }

    @Nullable
    public final Integer component1() {
        return this.emptyImage;
    }

    @Nullable
    public final Integer component2() {
        return this.emptyTitleRes;
    }

    @Nullable
    public final Integer component3() {
        return this.emptyDesRes;
    }

    @Nullable
    public final Integer component4() {
        return this.btnRes;
    }

    @NotNull
    public final FootMarkEmptyModel copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        return new FootMarkEmptyModel(num, num2, num3, num4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FootMarkEmptyModel)) {
            return false;
        }
        FootMarkEmptyModel footMarkEmptyModel = (FootMarkEmptyModel) obj;
        return s.d(this.emptyImage, footMarkEmptyModel.emptyImage) && s.d(this.emptyTitleRes, footMarkEmptyModel.emptyTitleRes) && s.d(this.emptyDesRes, footMarkEmptyModel.emptyDesRes) && s.d(this.btnRes, footMarkEmptyModel.btnRes);
    }

    @Nullable
    public final Integer getBtnRes() {
        return this.btnRes;
    }

    @Nullable
    public final Integer getEmptyDesRes() {
        return this.emptyDesRes;
    }

    @Nullable
    public final Integer getEmptyImage() {
        return this.emptyImage;
    }

    @Nullable
    public final Integer getEmptyTitleRes() {
        return this.emptyTitleRes;
    }

    public int hashCode() {
        Integer num = this.emptyImage;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.emptyTitleRes;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.emptyDesRes;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.btnRes;
        return hashCode3 + (num4 != null ? num4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FootMarkEmptyModel(emptyImage=" + ((Object) this.emptyImage) + ", emptyTitleRes=" + ((Object) this.emptyTitleRes) + ", emptyDesRes=" + ((Object) this.emptyDesRes) + ", btnRes=" + ((Object) this.btnRes) + ")";
    }

    public /* synthetic */ FootMarkEmptyModel(Integer num, Integer num2, Integer num3, Integer num4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : num4);
    }
}
