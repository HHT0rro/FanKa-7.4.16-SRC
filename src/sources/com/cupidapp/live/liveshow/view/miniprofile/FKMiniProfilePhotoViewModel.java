package com.cupidapp.live.liveshow.view.miniprofile;

import com.cupidapp.live.liveshow.model.MiniProfilePopularFeedModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfilePhotoFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMiniProfilePhotoViewModel implements Serializable {

    @Nullable
    private final List<MiniProfilePopularFeedModel> popularFeedList;

    @Nullable
    private final User user;

    public FKMiniProfilePhotoViewModel(@Nullable List<MiniProfilePopularFeedModel> list, @Nullable User user) {
        this.popularFeedList = list;
        this.user = user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKMiniProfilePhotoViewModel copy$default(FKMiniProfilePhotoViewModel fKMiniProfilePhotoViewModel, List list, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = fKMiniProfilePhotoViewModel.popularFeedList;
        }
        if ((i10 & 2) != 0) {
            user = fKMiniProfilePhotoViewModel.user;
        }
        return fKMiniProfilePhotoViewModel.copy(list, user);
    }

    @Nullable
    public final List<MiniProfilePopularFeedModel> component1() {
        return this.popularFeedList;
    }

    @Nullable
    public final User component2() {
        return this.user;
    }

    @NotNull
    public final FKMiniProfilePhotoViewModel copy(@Nullable List<MiniProfilePopularFeedModel> list, @Nullable User user) {
        return new FKMiniProfilePhotoViewModel(list, user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKMiniProfilePhotoViewModel)) {
            return false;
        }
        FKMiniProfilePhotoViewModel fKMiniProfilePhotoViewModel = (FKMiniProfilePhotoViewModel) obj;
        return s.d(this.popularFeedList, fKMiniProfilePhotoViewModel.popularFeedList) && s.d(this.user, fKMiniProfilePhotoViewModel.user);
    }

    @Nullable
    public final List<MiniProfilePopularFeedModel> getPopularFeedList() {
        return this.popularFeedList;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        List<MiniProfilePopularFeedModel> list = this.popularFeedList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        User user = this.user;
        return hashCode + (user != null ? user.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FKMiniProfilePhotoViewModel(popularFeedList=" + ((Object) this.popularFeedList) + ", user=" + ((Object) this.user) + ")";
    }
}
