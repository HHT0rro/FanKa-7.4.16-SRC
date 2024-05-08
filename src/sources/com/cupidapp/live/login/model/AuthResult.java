package com.cupidapp.live.login.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignInModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AuthResult {

    @Nullable
    private final String account;

    @Nullable
    private final String accountSign;

    @Nullable
    private final Integer accountType;

    @Nullable
    private final Boolean hasPhoneNumber;

    @Nullable
    private final Boolean isRegist;
    private final boolean isTeenager;

    @Nullable
    private final String loginType;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final String f16197t;

    @NotNull
    private final User user;

    public AuthResult(@NotNull String t2, @NotNull User user, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, boolean z10, @Nullable Boolean bool2) {
        s.i(t2, "t");
        s.i(user, "user");
        this.f16197t = t2;
        this.user = user;
        this.accountType = num;
        this.account = str;
        this.accountSign = str2;
        this.loginType = str3;
        this.hasPhoneNumber = bool;
        this.isTeenager = z10;
        this.isRegist = bool2;
    }

    @NotNull
    public final String component1() {
        return this.f16197t;
    }

    @NotNull
    public final User component2() {
        return this.user;
    }

    @Nullable
    public final Integer component3() {
        return this.accountType;
    }

    @Nullable
    public final String component4() {
        return this.account;
    }

    @Nullable
    public final String component5() {
        return this.accountSign;
    }

    @Nullable
    public final String component6() {
        return this.loginType;
    }

    @Nullable
    public final Boolean component7() {
        return this.hasPhoneNumber;
    }

    public final boolean component8() {
        return this.isTeenager;
    }

    @Nullable
    public final Boolean component9() {
        return this.isRegist;
    }

    @NotNull
    public final AuthResult copy(@NotNull String t2, @NotNull User user, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, boolean z10, @Nullable Boolean bool2) {
        s.i(t2, "t");
        s.i(user, "user");
        return new AuthResult(t2, user, num, str, str2, str3, bool, z10, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthResult)) {
            return false;
        }
        AuthResult authResult = (AuthResult) obj;
        return s.d(this.f16197t, authResult.f16197t) && s.d(this.user, authResult.user) && s.d(this.accountType, authResult.accountType) && s.d(this.account, authResult.account) && s.d(this.accountSign, authResult.accountSign) && s.d(this.loginType, authResult.loginType) && s.d(this.hasPhoneNumber, authResult.hasPhoneNumber) && this.isTeenager == authResult.isTeenager && s.d(this.isRegist, authResult.isRegist);
    }

    @Nullable
    public final String getAccount() {
        return this.account;
    }

    @Nullable
    public final String getAccountSign() {
        return this.accountSign;
    }

    @Nullable
    public final Integer getAccountType() {
        return this.accountType;
    }

    @Nullable
    public final Boolean getHasPhoneNumber() {
        return this.hasPhoneNumber;
    }

    @Nullable
    public final String getLoginType() {
        return this.loginType;
    }

    @NotNull
    public final String getT() {
        return this.f16197t;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f16197t.hashCode() * 31) + this.user.hashCode()) * 31;
        Integer num = this.accountType;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.account;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accountSign;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.loginType;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.hasPhoneNumber;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z10 = this.isTeenager;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode6 + i10) * 31;
        Boolean bool2 = this.isRegist;
        return i11 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isRegist() {
        return this.isRegist;
    }

    public final boolean isTeenager() {
        return this.isTeenager;
    }

    @NotNull
    public String toString() {
        String str = this.f16197t;
        User user = this.user;
        Integer num = this.accountType;
        String str2 = this.account;
        String str3 = this.accountSign;
        String str4 = this.loginType;
        Boolean bool = this.hasPhoneNumber;
        return "AuthResult(t=" + str + ", user=" + ((Object) user) + ", accountType=" + ((Object) num) + ", account=" + str2 + ", accountSign=" + str3 + ", loginType=" + str4 + ", hasPhoneNumber=" + ((Object) bool) + ", isTeenager=" + this.isTeenager + ", isRegist=" + ((Object) this.isRegist) + ")";
    }
}
