package com.cupidapp.live.hashtag.model.ui;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagClassifyModel {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f14731id;

    @NotNull
    private final String name;

    public HashTagClassifyModel(@NotNull String id2, @NotNull String name) {
        s.i(id2, "id");
        s.i(name, "name");
        this.f14731id = id2;
        this.name = name;
    }

    public static /* synthetic */ HashTagClassifyModel copy$default(HashTagClassifyModel hashTagClassifyModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hashTagClassifyModel.f14731id;
        }
        if ((i10 & 2) != 0) {
            str2 = hashTagClassifyModel.name;
        }
        return hashTagClassifyModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f14731id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final HashTagClassifyModel copy(@NotNull String id2, @NotNull String name) {
        s.i(id2, "id");
        s.i(name, "name");
        return new HashTagClassifyModel(id2, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTagClassifyModel)) {
            return false;
        }
        HashTagClassifyModel hashTagClassifyModel = (HashTagClassifyModel) obj;
        return s.d(this.f14731id, hashTagClassifyModel.f14731id) && s.d(this.name, hashTagClassifyModel.name);
    }

    @NotNull
    public final String getId() {
        return this.f14731id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.f14731id.hashCode() * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "HashTagClassifyModel(id=" + this.f14731id + ", name=" + this.name + ")";
    }
}
