package com.cupidapp.live.maskparty.holder;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScriptPublicProfileViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PublicProfileModel {

    @NotNull
    private final String content;

    /* renamed from: public, reason: not valid java name */
    private boolean f201public;

    public PublicProfileModel(@NotNull String content, boolean z10) {
        s.i(content, "content");
        this.content = content;
        this.f201public = z10;
    }

    public static /* synthetic */ PublicProfileModel copy$default(PublicProfileModel publicProfileModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = publicProfileModel.content;
        }
        if ((i10 & 2) != 0) {
            z10 = publicProfileModel.f201public;
        }
        return publicProfileModel.copy(str, z10);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    public final boolean component2() {
        return this.f201public;
    }

    @NotNull
    public final PublicProfileModel copy(@NotNull String content, boolean z10) {
        s.i(content, "content");
        return new PublicProfileModel(content, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicProfileModel)) {
            return false;
        }
        PublicProfileModel publicProfileModel = (PublicProfileModel) obj;
        return s.d(this.content, publicProfileModel.content) && this.f201public == publicProfileModel.f201public;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final boolean getPublic() {
        return this.f201public;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        boolean z10 = this.f201public;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setPublic(boolean z10) {
        this.f201public = z10;
    }

    @NotNull
    public String toString() {
        return "PublicProfileModel(content=" + this.content + ", public=" + this.f201public + ")";
    }

    public /* synthetic */ PublicProfileModel(String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}
