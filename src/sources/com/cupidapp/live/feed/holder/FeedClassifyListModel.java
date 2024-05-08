package com.cupidapp.live.feed.holder;

import com.cupidapp.live.feed.adapter.FeedClassifyModel;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyListModel {

    @NotNull
    private final List<FeedClassifyModel> list;

    public FeedClassifyListModel(@NotNull List<FeedClassifyModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedClassifyListModel copy$default(FeedClassifyListModel feedClassifyListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedClassifyListModel.list;
        }
        return feedClassifyListModel.copy(list);
    }

    @NotNull
    public final List<FeedClassifyModel> component1() {
        return this.list;
    }

    @NotNull
    public final FeedClassifyListModel copy(@NotNull List<FeedClassifyModel> list) {
        s.i(list, "list");
        return new FeedClassifyListModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedClassifyListModel) && s.d(this.list, ((FeedClassifyListModel) obj).list);
    }

    @NotNull
    public final List<FeedClassifyModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedClassifyListModel(list=" + ((Object) this.list) + ")";
    }
}
