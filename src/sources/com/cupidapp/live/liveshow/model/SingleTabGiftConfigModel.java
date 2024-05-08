package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SingleTabGiftConfigModel implements Serializable {

    @Nullable
    private final Integer emptyText;

    @NotNull
    private final List<GiftItemModel> list;

    @NotNull
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleTabGiftConfigModel(@NotNull List<? extends GiftItemModel> list, @NotNull String title, @Nullable Integer num) {
        s.i(list, "list");
        s.i(title, "title");
        this.list = list;
        this.title = title;
        this.emptyText = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleTabGiftConfigModel copy$default(SingleTabGiftConfigModel singleTabGiftConfigModel, List list, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = singleTabGiftConfigModel.list;
        }
        if ((i10 & 2) != 0) {
            str = singleTabGiftConfigModel.title;
        }
        if ((i10 & 4) != 0) {
            num = singleTabGiftConfigModel.emptyText;
        }
        return singleTabGiftConfigModel.copy(list, str, num);
    }

    @NotNull
    public final List<GiftItemModel> component1() {
        return this.list;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Integer component3() {
        return this.emptyText;
    }

    @NotNull
    public final SingleTabGiftConfigModel copy(@NotNull List<? extends GiftItemModel> list, @NotNull String title, @Nullable Integer num) {
        s.i(list, "list");
        s.i(title, "title");
        return new SingleTabGiftConfigModel(list, title, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleTabGiftConfigModel)) {
            return false;
        }
        SingleTabGiftConfigModel singleTabGiftConfigModel = (SingleTabGiftConfigModel) obj;
        return s.d(this.list, singleTabGiftConfigModel.list) && s.d(this.title, singleTabGiftConfigModel.title) && s.d(this.emptyText, singleTabGiftConfigModel.emptyText);
    }

    @Nullable
    public final Integer getEmptyText() {
        return this.emptyText;
    }

    @NotNull
    public final List<GiftItemModel> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.list.hashCode() * 31) + this.title.hashCode()) * 31;
        Integer num = this.emptyText;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    @NotNull
    public String toString() {
        List<GiftItemModel> list = this.list;
        return "SingleTabGiftConfigModel(list=" + ((Object) list) + ", title=" + this.title + ", emptyText=" + ((Object) this.emptyText) + ")";
    }

    public /* synthetic */ SingleTabGiftConfigModel(List list, String str, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i10 & 4) != 0 ? null : num);
    }
}
