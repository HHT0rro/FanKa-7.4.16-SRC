package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: StateResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class StateResult<T> {

    @Nullable
    private final T data;

    @Nullable
    private final Boolean isLoadMore;

    @Nullable
    private final String message;

    /* compiled from: StateResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a<T> extends StateResult<T> {
        public /* synthetic */ a(String str, Object obj, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : obj, (i10 & 4) != 0 ? null : bool);
        }

        public a(@Nullable String str, @Nullable T t2, @Nullable Boolean bool) {
            super(t2, str, bool, null);
        }
    }

    /* compiled from: StateResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b<T> extends StateResult<T> {
        public b(@Nullable T t2, @Nullable Boolean bool) {
            super(t2, null, bool, 2, null);
        }

        public /* synthetic */ b(Object obj, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? null : bool);
        }
    }

    /* compiled from: StateResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c<T> extends StateResult<T> {
        public c(@Nullable T t2, @Nullable Boolean bool) {
            super(t2, null, bool, 2, null);
        }

        public /* synthetic */ c(Object obj, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? null : bool);
        }
    }

    private StateResult(T t2, String str, Boolean bool) {
        this.data = t2;
        this.message = str;
        this.isLoadMore = bool;
    }

    public /* synthetic */ StateResult(Object obj, String str, Boolean bool, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, bool);
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean isLoadMore() {
        return this.isLoadMore;
    }

    public /* synthetic */ StateResult(Object obj, String str, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : obj, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : bool, null);
    }
}
