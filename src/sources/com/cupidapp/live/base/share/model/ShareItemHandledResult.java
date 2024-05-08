package com.cupidapp.live.base.share.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareItemHandledResult {

    @Nullable
    private final Object data;

    @NotNull
    private final State state;

    @NotNull
    private final ShareBaseType type;

    public ShareItemHandledResult(@NotNull State state, @NotNull ShareBaseType type, @Nullable Object obj) {
        s.i(state, "state");
        s.i(type, "type");
        this.state = state;
        this.type = type;
        this.data = obj;
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final State getState() {
        return this.state;
    }

    @NotNull
    public final ShareBaseType getType() {
        return this.type;
    }

    public /* synthetic */ ShareItemHandledResult(State state, ShareBaseType shareBaseType, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, shareBaseType, (i10 & 4) != 0 ? null : obj);
    }
}
