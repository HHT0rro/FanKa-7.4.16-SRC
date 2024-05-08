package com.cupidapp.live.liveshow.model;

import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveHornLinkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveHornLinkModel {

    @NotNull
    private final String jump;

    @Nullable
    private final Map<String, String> linkDict;

    public FKLiveHornLinkModel(@Nullable Map<String, String> map, @NotNull String jump) {
        s.i(jump, "jump");
        this.linkDict = map;
        this.jump = jump;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKLiveHornLinkModel copy$default(FKLiveHornLinkModel fKLiveHornLinkModel, Map map, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = fKLiveHornLinkModel.linkDict;
        }
        if ((i10 & 2) != 0) {
            str = fKLiveHornLinkModel.jump;
        }
        return fKLiveHornLinkModel.copy(map, str);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.linkDict;
    }

    @NotNull
    public final String component2() {
        return this.jump;
    }

    @NotNull
    public final FKLiveHornLinkModel copy(@Nullable Map<String, String> map, @NotNull String jump) {
        s.i(jump, "jump");
        return new FKLiveHornLinkModel(map, jump);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveHornLinkModel)) {
            return false;
        }
        FKLiveHornLinkModel fKLiveHornLinkModel = (FKLiveHornLinkModel) obj;
        return s.d(this.linkDict, fKLiveHornLinkModel.linkDict) && s.d(this.jump, fKLiveHornLinkModel.jump);
    }

    @NotNull
    public final String getJump() {
        return this.jump;
    }

    @Nullable
    public final Map<String, String> getLinkDict() {
        return this.linkDict;
    }

    public int hashCode() {
        Map<String, String> map = this.linkDict;
        return ((map == null ? 0 : map.hashCode()) * 31) + this.jump.hashCode();
    }

    @NotNull
    public String toString() {
        Map<String, String> map = this.linkDict;
        return "FKLiveHornLinkModel(linkDict=" + ((Object) map) + ", jump=" + this.jump + ")";
    }

    public /* synthetic */ FKLiveHornLinkModel(Map map, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : map, str);
    }
}
