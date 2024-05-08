package com.cupidapp.live.hashtag.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagSimpleModel implements Serializable {

    @NotNull
    private final String itemId;

    @NotNull
    private final String name;

    public HashTagSimpleModel(@NotNull String itemId, @NotNull String name) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        this.itemId = itemId;
        this.name = name;
    }

    public static /* synthetic */ HashTagSimpleModel copy$default(HashTagSimpleModel hashTagSimpleModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hashTagSimpleModel.itemId;
        }
        if ((i10 & 2) != 0) {
            str2 = hashTagSimpleModel.name;
        }
        return hashTagSimpleModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final HashTagSimpleModel copy(@NotNull String itemId, @NotNull String name) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        return new HashTagSimpleModel(itemId, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTagSimpleModel)) {
            return false;
        }
        HashTagSimpleModel hashTagSimpleModel = (HashTagSimpleModel) obj;
        return s.d(this.itemId, hashTagSimpleModel.itemId) && s.d(this.name, hashTagSimpleModel.name);
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.itemId.hashCode() * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "HashTagSimpleModel(itemId=" + this.itemId + ", name=" + this.name + ")";
    }
}
