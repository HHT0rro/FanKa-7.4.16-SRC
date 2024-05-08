package com.cupidapp.live.chat.service;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SuperBoostEntranceModel {

    @Nullable
    private final String content;

    @Nullable
    private final String url;

    public SuperBoostEntranceModel(@Nullable String str, @Nullable String str2) {
        this.content = str;
        this.url = str2;
    }

    public static /* synthetic */ SuperBoostEntranceModel copy$default(SuperBoostEntranceModel superBoostEntranceModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = superBoostEntranceModel.content;
        }
        if ((i10 & 2) != 0) {
            str2 = superBoostEntranceModel.url;
        }
        return superBoostEntranceModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.content;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final SuperBoostEntranceModel copy(@Nullable String str, @Nullable String str2) {
        return new SuperBoostEntranceModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperBoostEntranceModel)) {
            return false;
        }
        SuperBoostEntranceModel superBoostEntranceModel = (SuperBoostEntranceModel) obj;
        return s.d(this.content, superBoostEntranceModel.content) && s.d(this.url, superBoostEntranceModel.url);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SuperBoostEntranceModel(content=" + this.content + ", url=" + this.url + ")";
    }
}
