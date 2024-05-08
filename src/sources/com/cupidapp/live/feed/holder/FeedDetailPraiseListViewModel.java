package com.cupidapp.live.feed.holder;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedDetailPraiseListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailPraiseListViewModel {

    @NotNull
    private final List<User> list;

    public FeedDetailPraiseListViewModel(@NotNull List<User> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedDetailPraiseListViewModel copy$default(FeedDetailPraiseListViewModel feedDetailPraiseListViewModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedDetailPraiseListViewModel.list;
        }
        return feedDetailPraiseListViewModel.copy(list);
    }

    @NotNull
    public final List<User> component1() {
        return this.list;
    }

    @NotNull
    public final FeedDetailPraiseListViewModel copy(@NotNull List<User> list) {
        s.i(list, "list");
        return new FeedDetailPraiseListViewModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedDetailPraiseListViewModel) && s.d(this.list, ((FeedDetailPraiseListViewModel) obj).list);
    }

    @NotNull
    public final List<User> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedDetailPraiseListViewModel(list=" + ((Object) this.list) + ")";
    }
}
