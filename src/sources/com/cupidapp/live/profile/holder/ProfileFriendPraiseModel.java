package com.cupidapp.live.profile.holder;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileFriendPraiseViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileFriendPraiseModel implements Serializable {

    @Nullable
    private final String content;
    private final int count;

    /* renamed from: me, reason: collision with root package name */
    private final boolean f17820me;

    public ProfileFriendPraiseModel(boolean z10, @Nullable String str, int i10) {
        this.f17820me = z10;
        this.content = str;
        this.count = i10;
    }

    public static /* synthetic */ ProfileFriendPraiseModel copy$default(ProfileFriendPraiseModel profileFriendPraiseModel, boolean z10, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = profileFriendPraiseModel.f17820me;
        }
        if ((i11 & 2) != 0) {
            str = profileFriendPraiseModel.content;
        }
        if ((i11 & 4) != 0) {
            i10 = profileFriendPraiseModel.count;
        }
        return profileFriendPraiseModel.copy(z10, str, i10);
    }

    public final boolean component1() {
        return this.f17820me;
    }

    @Nullable
    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.count;
    }

    @NotNull
    public final ProfileFriendPraiseModel copy(boolean z10, @Nullable String str, int i10) {
        return new ProfileFriendPraiseModel(z10, str, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileFriendPraiseModel)) {
            return false;
        }
        ProfileFriendPraiseModel profileFriendPraiseModel = (ProfileFriendPraiseModel) obj;
        return this.f17820me == profileFriendPraiseModel.f17820me && s.d(this.content, profileFriendPraiseModel.content) && this.count == profileFriendPraiseModel.count;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getMe() {
        return this.f17820me;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.f17820me;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.content;
        return ((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "ProfileFriendPraiseModel(me=" + this.f17820me + ", content=" + this.content + ", count=" + this.count + ")";
    }

    public /* synthetic */ ProfileFriendPraiseModel(boolean z10, String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, str, (i11 & 4) != 0 ? 0 : i10);
    }
}
