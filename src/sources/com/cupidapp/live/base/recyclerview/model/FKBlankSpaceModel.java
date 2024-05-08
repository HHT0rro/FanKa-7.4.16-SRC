package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEmptyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKBlankSpaceModel {

    @Nullable
    private final Integer height;

    public FKBlankSpaceModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public FKBlankSpaceModel(@Nullable Integer num) {
        this.height = num;
    }

    public static /* synthetic */ FKBlankSpaceModel copy$default(FKBlankSpaceModel fKBlankSpaceModel, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = fKBlankSpaceModel.height;
        }
        return fKBlankSpaceModel.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.height;
    }

    @NotNull
    public final FKBlankSpaceModel copy(@Nullable Integer num) {
        return new FKBlankSpaceModel(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKBlankSpaceModel) && s.d(this.height, ((FKBlankSpaceModel) obj).height);
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    public int hashCode() {
        Integer num = this.height;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKBlankSpaceModel(height=" + ((Object) this.height) + ")";
    }

    public /* synthetic */ FKBlankSpaceModel(Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num);
    }
}
