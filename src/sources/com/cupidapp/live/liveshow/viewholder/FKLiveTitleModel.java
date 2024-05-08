package com.cupidapp.live.liveshow.viewholder;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveTitleModel {

    @Nullable
    private final Integer icon;

    @Nullable
    private final String title;

    public FKLiveTitleModel(@Nullable String str, @Nullable Integer num) {
        this.title = str;
        this.icon = num;
    }

    public static /* synthetic */ FKLiveTitleModel copy$default(FKLiveTitleModel fKLiveTitleModel, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKLiveTitleModel.title;
        }
        if ((i10 & 2) != 0) {
            num = fKLiveTitleModel.icon;
        }
        return fKLiveTitleModel.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Integer component2() {
        return this.icon;
    }

    @NotNull
    public final FKLiveTitleModel copy(@Nullable String str, @Nullable Integer num) {
        return new FKLiveTitleModel(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveTitleModel)) {
            return false;
        }
        FKLiveTitleModel fKLiveTitleModel = (FKLiveTitleModel) obj;
        return s.d(this.title, fKLiveTitleModel.title) && s.d(this.icon, fKLiveTitleModel.icon);
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.icon;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FKLiveTitleModel(title=" + this.title + ", icon=" + ((Object) this.icon) + ")";
    }

    public /* synthetic */ FKLiveTitleModel(String str, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : num);
    }
}
