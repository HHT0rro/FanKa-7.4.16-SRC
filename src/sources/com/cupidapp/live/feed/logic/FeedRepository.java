package com.cupidapp.live.feed.logic;

import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.feed.model.FeedTopResultModel;
import f2.a;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedRepository.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRepository {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Lazy f14609a = c.b(new Function0<a>() { // from class: com.cupidapp.live.feed.logic.FeedRepository$feedService$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final a invoke() {
            return NetworkClient.f11868a.l();
        }
    });

    @NotNull
    public final Observable<Result<Object>> a(@NotNull String feedId) {
        s.i(feedId, "feedId");
        return c().g(feedId);
    }

    @NotNull
    public final Observable<Result<FeedTopResultModel>> b(@NotNull String feedId, boolean z10) {
        s.i(feedId, "feedId");
        return NetworkClient.f11868a.l().E(feedId, z10);
    }

    @NotNull
    public final a c() {
        return (a) this.f14609a.getValue();
    }

    @NotNull
    public final Observable<Result<Object>> d(@NotNull String feedId) {
        s.i(feedId, "feedId");
        return NetworkClient.f11868a.l().b(feedId);
    }

    @NotNull
    public final Observable<Result<Object>> e(@NotNull String feedId, boolean z10) {
        s.i(feedId, "feedId");
        return NetworkClient.f11868a.l().S(feedId, z10);
    }

    @NotNull
    public final Observable<Result<Object>> f(@NotNull String feedId) {
        s.i(feedId, "feedId");
        return NetworkClient.f11868a.l().R(feedId);
    }
}
