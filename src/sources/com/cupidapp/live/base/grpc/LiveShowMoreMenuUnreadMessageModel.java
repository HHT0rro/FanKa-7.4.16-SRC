package com.cupidapp.live.base.grpc;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowMoreMenuUnreadMessageModel {

    @Nullable
    private final List<String> list;

    @Nullable
    private final String tips;

    public LiveShowMoreMenuUnreadMessageModel(@Nullable List<String> list, @Nullable String str) {
        this.list = list;
        this.tips = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveShowMoreMenuUnreadMessageModel copy$default(LiveShowMoreMenuUnreadMessageModel liveShowMoreMenuUnreadMessageModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveShowMoreMenuUnreadMessageModel.list;
        }
        if ((i10 & 2) != 0) {
            str = liveShowMoreMenuUnreadMessageModel.tips;
        }
        return liveShowMoreMenuUnreadMessageModel.copy(list, str);
    }

    @Nullable
    public final List<String> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.tips;
    }

    @NotNull
    public final LiveShowMoreMenuUnreadMessageModel copy(@Nullable List<String> list, @Nullable String str) {
        return new LiveShowMoreMenuUnreadMessageModel(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowMoreMenuUnreadMessageModel)) {
            return false;
        }
        LiveShowMoreMenuUnreadMessageModel liveShowMoreMenuUnreadMessageModel = (LiveShowMoreMenuUnreadMessageModel) obj;
        return kotlin.jvm.internal.s.d(this.list, liveShowMoreMenuUnreadMessageModel.list) && kotlin.jvm.internal.s.d(this.tips, liveShowMoreMenuUnreadMessageModel.tips);
    }

    @Nullable
    public final List<String> getList() {
        return this.list;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        List<String> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.tips;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<String> list = this.list;
        return "LiveShowMoreMenuUnreadMessageModel(list=" + ((Object) list) + ", tips=" + this.tips + ")";
    }
}
