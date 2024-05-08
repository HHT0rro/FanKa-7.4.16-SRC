package com.cupidapp.live.base.fragment;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMenuFragmentItemModel implements Serializable {

    @NotNull
    private final String content;

    @NotNull
    private final Function0<p> event;
    private final boolean isSelectItem;

    public FKMenuFragmentItemModel(@NotNull String content, boolean z10, @NotNull Function0<p> event) {
        s.i(content, "content");
        s.i(event, "event");
        this.content = content;
        this.isSelectItem = z10;
        this.event = event;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final Function0<p> getEvent() {
        return this.event;
    }

    public final boolean isSelectItem() {
        return this.isSelectItem;
    }

    public /* synthetic */ FKMenuFragmentItemModel(String str, boolean z10, Function0 function0, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10, function0);
    }
}
