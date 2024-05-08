package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSystemMessageViewModel implements FKLiveMessageViewModel {

    @Nullable
    private final List<BaseLiveShowTagModel> labelList;

    @NotNull
    private final String systemMessage;

    @Nullable
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public FKLiveSystemMessageViewModel(@NotNull String systemMessage, @Nullable User user, @Nullable List<? extends BaseLiveShowTagModel> list) {
        s.i(systemMessage, "systemMessage");
        this.systemMessage = systemMessage;
        this.user = user;
        this.labelList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKLiveSystemMessageViewModel copy$default(FKLiveSystemMessageViewModel fKLiveSystemMessageViewModel, String str, User user, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKLiveSystemMessageViewModel.systemMessage;
        }
        if ((i10 & 2) != 0) {
            user = fKLiveSystemMessageViewModel.user;
        }
        if ((i10 & 4) != 0) {
            list = fKLiveSystemMessageViewModel.labelList;
        }
        return fKLiveSystemMessageViewModel.copy(str, user, list);
    }

    @NotNull
    public final String component1() {
        return this.systemMessage;
    }

    @Nullable
    public final User component2() {
        return this.user;
    }

    @Nullable
    public final List<BaseLiveShowTagModel> component3() {
        return this.labelList;
    }

    @NotNull
    public final FKLiveSystemMessageViewModel copy(@NotNull String systemMessage, @Nullable User user, @Nullable List<? extends BaseLiveShowTagModel> list) {
        s.i(systemMessage, "systemMessage");
        return new FKLiveSystemMessageViewModel(systemMessage, user, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveSystemMessageViewModel)) {
            return false;
        }
        FKLiveSystemMessageViewModel fKLiveSystemMessageViewModel = (FKLiveSystemMessageViewModel) obj;
        return s.d(this.systemMessage, fKLiveSystemMessageViewModel.systemMessage) && s.d(this.user, fKLiveSystemMessageViewModel.user) && s.d(this.labelList, fKLiveSystemMessageViewModel.labelList);
    }

    @Nullable
    public final List<BaseLiveShowTagModel> getLabelList() {
        return this.labelList;
    }

    @NotNull
    public final String getSystemMessage() {
        return this.systemMessage;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.systemMessage.hashCode() * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        List<BaseLiveShowTagModel> list = this.labelList;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FKLiveSystemMessageViewModel(systemMessage=" + this.systemMessage + ", user=" + ((Object) this.user) + ", labelList=" + ((Object) this.labelList) + ")";
    }
}
