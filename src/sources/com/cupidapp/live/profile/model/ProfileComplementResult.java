package com.cupidapp.live.profile.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileSpecListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileComplementResult {

    @Nullable
    private final ProfileSpecListModel birthday;

    @Nullable
    private final ProfileSpecListModel height;

    @Nullable
    private final ProfileSpecListModel role;

    @Nullable
    private final ProfileSpecListModel weight;

    public ProfileComplementResult(@Nullable ProfileSpecListModel profileSpecListModel, @Nullable ProfileSpecListModel profileSpecListModel2, @Nullable ProfileSpecListModel profileSpecListModel3, @Nullable ProfileSpecListModel profileSpecListModel4) {
        this.birthday = profileSpecListModel;
        this.height = profileSpecListModel2;
        this.weight = profileSpecListModel3;
        this.role = profileSpecListModel4;
    }

    public static /* synthetic */ ProfileComplementResult copy$default(ProfileComplementResult profileComplementResult, ProfileSpecListModel profileSpecListModel, ProfileSpecListModel profileSpecListModel2, ProfileSpecListModel profileSpecListModel3, ProfileSpecListModel profileSpecListModel4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            profileSpecListModel = profileComplementResult.birthday;
        }
        if ((i10 & 2) != 0) {
            profileSpecListModel2 = profileComplementResult.height;
        }
        if ((i10 & 4) != 0) {
            profileSpecListModel3 = profileComplementResult.weight;
        }
        if ((i10 & 8) != 0) {
            profileSpecListModel4 = profileComplementResult.role;
        }
        return profileComplementResult.copy(profileSpecListModel, profileSpecListModel2, profileSpecListModel3, profileSpecListModel4);
    }

    @Nullable
    public final ProfileSpecListModel component1() {
        return this.birthday;
    }

    @Nullable
    public final ProfileSpecListModel component2() {
        return this.height;
    }

    @Nullable
    public final ProfileSpecListModel component3() {
        return this.weight;
    }

    @Nullable
    public final ProfileSpecListModel component4() {
        return this.role;
    }

    @NotNull
    public final ProfileComplementResult copy(@Nullable ProfileSpecListModel profileSpecListModel, @Nullable ProfileSpecListModel profileSpecListModel2, @Nullable ProfileSpecListModel profileSpecListModel3, @Nullable ProfileSpecListModel profileSpecListModel4) {
        return new ProfileComplementResult(profileSpecListModel, profileSpecListModel2, profileSpecListModel3, profileSpecListModel4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileComplementResult)) {
            return false;
        }
        ProfileComplementResult profileComplementResult = (ProfileComplementResult) obj;
        return s.d(this.birthday, profileComplementResult.birthday) && s.d(this.height, profileComplementResult.height) && s.d(this.weight, profileComplementResult.weight) && s.d(this.role, profileComplementResult.role);
    }

    @Nullable
    public final ProfileSpecListModel getBirthday() {
        return this.birthday;
    }

    @Nullable
    public final ProfileSpecListModel getHeight() {
        return this.height;
    }

    @Nullable
    public final ProfileSpecListModel getRole() {
        return this.role;
    }

    @Nullable
    public final ProfileSpecListModel getWeight() {
        return this.weight;
    }

    public int hashCode() {
        ProfileSpecListModel profileSpecListModel = this.birthday;
        int hashCode = (profileSpecListModel == null ? 0 : profileSpecListModel.hashCode()) * 31;
        ProfileSpecListModel profileSpecListModel2 = this.height;
        int hashCode2 = (hashCode + (profileSpecListModel2 == null ? 0 : profileSpecListModel2.hashCode())) * 31;
        ProfileSpecListModel profileSpecListModel3 = this.weight;
        int hashCode3 = (hashCode2 + (profileSpecListModel3 == null ? 0 : profileSpecListModel3.hashCode())) * 31;
        ProfileSpecListModel profileSpecListModel4 = this.role;
        return hashCode3 + (profileSpecListModel4 != null ? profileSpecListModel4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProfileComplementResult(birthday=" + ((Object) this.birthday) + ", height=" + ((Object) this.height) + ", weight=" + ((Object) this.weight) + ", role=" + ((Object) this.role) + ")";
    }
}
