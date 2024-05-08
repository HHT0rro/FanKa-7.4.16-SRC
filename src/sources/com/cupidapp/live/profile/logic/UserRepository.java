package com.cupidapp.live.profile.logic;

import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.FocusUserListModel;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserRepository.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserRepository {

    /* renamed from: a */
    @NotNull
    public final Lazy f17838a = kotlin.c.b(new Function0<x2.a>() { // from class: com.cupidapp.live.profile.logic.UserRepository$userService$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final x2.a invoke() {
            return NetworkClient.f11868a.N();
        }
    });

    public static /* synthetic */ Observable f(UserRepository userRepository, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return userRepository.e(str, z10, str2);
    }

    @NotNull
    public final Observable<Result<Object>> a(@NotNull String userId) {
        s.i(userId, "userId");
        return NetworkClient.f11868a.N().h(userId);
    }

    @NotNull
    public final Observable<Result<Object>> b(@NotNull String userId, boolean z10) {
        s.i(userId, "userId");
        return h().O0(userId, z10);
    }

    @NotNull
    public final Observable<Result<SwipeCardUserLikeResult>> c(@NotNull String userId, @Nullable String str, @Nullable String str2) {
        s.i(userId, "userId");
        return h().D0(userId, str, str2);
    }

    @NotNull
    public final Observable<Result<Object>> d(@NotNull String userId) {
        s.i(userId, "userId");
        return h().P(userId);
    }

    @NotNull
    public final Observable<Result<FocusResultModel>> e(@NotNull String userId, boolean z10, @Nullable String str) {
        s.i(userId, "userId");
        return h().b0(userId, z10, str);
    }

    @NotNull
    public final Observable<Result<FocusUserListModel>> g() {
        return NetworkClient.f11868a.N().p();
    }

    @NotNull
    public final x2.a h() {
        return (x2.a) this.f17838a.getValue();
    }

    @NotNull
    public final Observable<Result<Object>> i(@NotNull String userId) {
        s.i(userId, "userId");
        return h().O(userId);
    }

    @NotNull
    public final Observable<Result<Object>> j(@NotNull String userId) {
        s.i(userId, "userId");
        return NetworkClient.f11868a.N().H0(userId);
    }
}
