package com.cupidapp.live.search.holder;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchFilterRcmdViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterKeyClickEvent {
    private final int productType;

    @NotNull
    private final String word;

    public MatchFilterKeyClickEvent(@NotNull String word, int i10) {
        s.i(word, "word");
        this.word = word;
        this.productType = i10;
    }

    public static /* synthetic */ MatchFilterKeyClickEvent copy$default(MatchFilterKeyClickEvent matchFilterKeyClickEvent, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = matchFilterKeyClickEvent.word;
        }
        if ((i11 & 2) != 0) {
            i10 = matchFilterKeyClickEvent.productType;
        }
        return matchFilterKeyClickEvent.copy(str, i10);
    }

    @NotNull
    public final String component1() {
        return this.word;
    }

    public final int component2() {
        return this.productType;
    }

    @NotNull
    public final MatchFilterKeyClickEvent copy(@NotNull String word, int i10) {
        s.i(word, "word");
        return new MatchFilterKeyClickEvent(word, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchFilterKeyClickEvent)) {
            return false;
        }
        MatchFilterKeyClickEvent matchFilterKeyClickEvent = (MatchFilterKeyClickEvent) obj;
        return s.d(this.word, matchFilterKeyClickEvent.word) && this.productType == matchFilterKeyClickEvent.productType;
    }

    public final int getProductType() {
        return this.productType;
    }

    @NotNull
    public final String getWord() {
        return this.word;
    }

    public int hashCode() {
        return (this.word.hashCode() * 31) + this.productType;
    }

    @NotNull
    public String toString() {
        return "MatchFilterKeyClickEvent(word=" + this.word + ", productType=" + this.productType + ")";
    }
}
