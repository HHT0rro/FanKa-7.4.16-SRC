package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveContainerFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveTabConfigResult implements Serializable {

    @Nullable
    private final List<LiveTabConfigModel> tabList;

    public LiveTabConfigResult(@Nullable List<LiveTabConfigModel> list) {
        this.tabList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveTabConfigResult copy$default(LiveTabConfigResult liveTabConfigResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveTabConfigResult.tabList;
        }
        return liveTabConfigResult.copy(list);
    }

    @Nullable
    public final List<LiveTabConfigModel> component1() {
        return this.tabList;
    }

    @NotNull
    public final LiveTabConfigResult copy(@Nullable List<LiveTabConfigModel> list) {
        return new LiveTabConfigResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveTabConfigResult) && s.d(this.tabList, ((LiveTabConfigResult) obj).tabList);
    }

    @Nullable
    public final List<LiveTabConfigModel> getTabList() {
        return this.tabList;
    }

    public int hashCode() {
        List<LiveTabConfigModel> list = this.tabList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveTabConfigResult(tabList=" + ((Object) this.tabList) + ")";
    }
}
