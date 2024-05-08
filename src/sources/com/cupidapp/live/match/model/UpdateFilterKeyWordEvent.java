package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UpdateFilterKeyWordEvent {

    @NotNull
    private final String word;

    public UpdateFilterKeyWordEvent(@NotNull String word) {
        s.i(word, "word");
        this.word = word;
    }

    public static /* synthetic */ UpdateFilterKeyWordEvent copy$default(UpdateFilterKeyWordEvent updateFilterKeyWordEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = updateFilterKeyWordEvent.word;
        }
        return updateFilterKeyWordEvent.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.word;
    }

    @NotNull
    public final UpdateFilterKeyWordEvent copy(@NotNull String word) {
        s.i(word, "word");
        return new UpdateFilterKeyWordEvent(word);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateFilterKeyWordEvent) && s.d(this.word, ((UpdateFilterKeyWordEvent) obj).word);
    }

    @NotNull
    public final String getWord() {
        return this.word;
    }

    public int hashCode() {
        return this.word.hashCode();
    }

    @NotNull
    public String toString() {
        return "UpdateFilterKeyWordEvent(word=" + this.word + ")";
    }
}
