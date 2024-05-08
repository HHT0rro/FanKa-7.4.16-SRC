package com.cupidapp.live.base.network.model;

import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LinkDictTipsModel {

    @NotNull
    private final String content;

    @Nullable
    private final Map<String, String> linkDict;

    public LinkDictTipsModel(@NotNull String content, @Nullable Map<String, String> map) {
        s.i(content, "content");
        this.content = content;
        this.linkDict = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinkDictTipsModel copy$default(LinkDictTipsModel linkDictTipsModel, String str, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = linkDictTipsModel.content;
        }
        if ((i10 & 2) != 0) {
            map = linkDictTipsModel.linkDict;
        }
        return linkDictTipsModel.copy(str, map);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    @Nullable
    public final Map<String, String> component2() {
        return this.linkDict;
    }

    @NotNull
    public final LinkDictTipsModel copy(@NotNull String content, @Nullable Map<String, String> map) {
        s.i(content, "content");
        return new LinkDictTipsModel(content, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkDictTipsModel)) {
            return false;
        }
        LinkDictTipsModel linkDictTipsModel = (LinkDictTipsModel) obj;
        return s.d(this.content, linkDictTipsModel.content) && s.d(this.linkDict, linkDictTipsModel.linkDict);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Map<String, String> getLinkDict() {
        return this.linkDict;
    }

    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        Map<String, String> map = this.linkDict;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "LinkDictTipsModel(content=" + this.content + ", linkDict=" + ((Object) this.linkDict) + ")";
    }
}
