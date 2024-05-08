package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LinkDictModel implements Serializable {

    @NotNull
    private final String content;

    @Nullable
    private final Map<String, String> linkDict;
    private final int version;

    public LinkDictModel(int i10, @NotNull String content, @Nullable Map<String, String> map) {
        s.i(content, "content");
        this.version = i10;
        this.content = content;
        this.linkDict = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinkDictModel copy$default(LinkDictModel linkDictModel, int i10, String str, Map map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = linkDictModel.version;
        }
        if ((i11 & 2) != 0) {
            str = linkDictModel.content;
        }
        if ((i11 & 4) != 0) {
            map = linkDictModel.linkDict;
        }
        return linkDictModel.copy(i10, str, map);
    }

    public final int component1() {
        return this.version;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.linkDict;
    }

    @NotNull
    public final LinkDictModel copy(int i10, @NotNull String content, @Nullable Map<String, String> map) {
        s.i(content, "content");
        return new LinkDictModel(i10, content, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkDictModel)) {
            return false;
        }
        LinkDictModel linkDictModel = (LinkDictModel) obj;
        return this.version == linkDictModel.version && s.d(this.content, linkDictModel.content) && s.d(this.linkDict, linkDictModel.linkDict);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Map<String, String> getLinkDict() {
        return this.linkDict;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((this.version * 31) + this.content.hashCode()) * 31;
        Map<String, String> map = this.linkDict;
        return hashCode + (map == null ? 0 : map.hashCode());
    }

    @NotNull
    public String toString() {
        return "LinkDictModel(version=" + this.version + ", content=" + this.content + ", linkDict=" + ((Object) this.linkDict) + ")";
    }
}
