package com.cupidapp.live.mentionuser.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AtUserModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ReplaceAtModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f17486id;

    @Nullable
    private final Integer index;

    @Nullable
    private final String name;

    public ReplaceAtModel(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.f17486id = str;
        this.name = str2;
        this.index = num;
    }

    public static /* synthetic */ ReplaceAtModel copy$default(ReplaceAtModel replaceAtModel, String str, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = replaceAtModel.f17486id;
        }
        if ((i10 & 2) != 0) {
            str2 = replaceAtModel.name;
        }
        if ((i10 & 4) != 0) {
            num = replaceAtModel.index;
        }
        return replaceAtModel.copy(str, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.f17486id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final Integer component3() {
        return this.index;
    }

    @NotNull
    public final ReplaceAtModel copy(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        return new ReplaceAtModel(str, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplaceAtModel)) {
            return false;
        }
        ReplaceAtModel replaceAtModel = (ReplaceAtModel) obj;
        return s.d(this.f17486id, replaceAtModel.f17486id) && s.d(this.name, replaceAtModel.name) && s.d(this.index, replaceAtModel.index);
    }

    @Nullable
    public final String getId() {
        return this.f17486id;
    }

    @Nullable
    public final Integer getIndex() {
        return this.index;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.f17486id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.index;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ReplaceAtModel(id=" + this.f17486id + ", name=" + this.name + ", index=" + ((Object) this.index) + ")";
    }
}
