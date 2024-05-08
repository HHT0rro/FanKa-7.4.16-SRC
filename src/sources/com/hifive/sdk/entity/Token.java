package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Token {

    @NotNull
    private final String accessToken;

    public Token(@NotNull String accessToken) {
        s.j(accessToken, "accessToken");
        this.accessToken = accessToken;
    }

    public static /* synthetic */ Token copy$default(Token token, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = token.accessToken;
        }
        return token.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @NotNull
    public final Token copy(@NotNull String accessToken) {
        s.j(accessToken, "accessToken");
        return new Token(accessToken);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof Token) && s.d(this.accessToken, ((Token) obj).accessToken);
        }
        return true;
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    public int hashCode() {
        String str = this.accessToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "Token(accessToken=" + this.accessToken + ")";
    }
}
