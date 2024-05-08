package com.cupidapp.live.feed.helper;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.feed.model.FeedModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileFeedListCache.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14335a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final FKEmptyViewModel f14336b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<FeedModel> f14337c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14338d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f14339e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14340f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final Function1<String, Observable<Result<ListResult<FeedModel>>>> f14341g;

    /* JADX WARN: Multi-variable type inference failed */
    public i(boolean z10, @Nullable FKEmptyViewModel fKEmptyViewModel, @NotNull List<FeedModel> feedList, int i10, @Nullable String str, boolean z11, @Nullable Function1<? super String, ? extends Observable<Result<ListResult<FeedModel>>>> function1) {
        s.i(feedList, "feedList");
        this.f14335a = z10;
        this.f14336b = fKEmptyViewModel;
        this.f14337c = feedList;
        this.f14338d = i10;
        this.f14339e = str;
        this.f14340f = z11;
        this.f14341g = function1;
    }

    @Nullable
    public final FKEmptyViewModel a() {
        return this.f14336b;
    }

    @NotNull
    public final List<FeedModel> b() {
        return this.f14337c;
    }

    @Nullable
    public final String c() {
        return this.f14339e;
    }

    @Nullable
    public final Function1<String, Observable<Result<ListResult<FeedModel>>>> d() {
        return this.f14341g;
    }

    public final boolean e() {
        return this.f14335a;
    }

    public final boolean f() {
        return this.f14340f;
    }

    public final int g() {
        return this.f14338d;
    }
}
