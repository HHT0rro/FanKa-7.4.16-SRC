package com.cupidapp.live.consult.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorTaskModel implements Serializable {

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final List<ConsultAnchorTaskItemModel> list;

    public ConsultAnchorTaskModel(@NotNull List<ConsultAnchorTaskItemModel> list, @NotNull String jumpUrl) {
        s.i(list, "list");
        s.i(jumpUrl, "jumpUrl");
        this.list = list;
        this.jumpUrl = jumpUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultAnchorTaskModel copy$default(ConsultAnchorTaskModel consultAnchorTaskModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = consultAnchorTaskModel.list;
        }
        if ((i10 & 2) != 0) {
            str = consultAnchorTaskModel.jumpUrl;
        }
        return consultAnchorTaskModel.copy(list, str);
    }

    @NotNull
    public final List<ConsultAnchorTaskItemModel> component1() {
        return this.list;
    }

    @NotNull
    public final String component2() {
        return this.jumpUrl;
    }

    @NotNull
    public final ConsultAnchorTaskModel copy(@NotNull List<ConsultAnchorTaskItemModel> list, @NotNull String jumpUrl) {
        s.i(list, "list");
        s.i(jumpUrl, "jumpUrl");
        return new ConsultAnchorTaskModel(list, jumpUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultAnchorTaskModel)) {
            return false;
        }
        ConsultAnchorTaskModel consultAnchorTaskModel = (ConsultAnchorTaskModel) obj;
        return s.d(this.list, consultAnchorTaskModel.list) && s.d(this.jumpUrl, consultAnchorTaskModel.jumpUrl);
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final List<ConsultAnchorTaskItemModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        List<ConsultAnchorTaskItemModel> list = this.list;
        return "ConsultAnchorTaskModel(list=" + ((Object) list) + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
