package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnimLoadedEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AnimLoadedEvent {

    @Nullable
    private final Integer animType;

    public AnimLoadedEvent(@Nullable Integer num) {
        this.animType = num;
    }

    public static /* synthetic */ AnimLoadedEvent copy$default(AnimLoadedEvent animLoadedEvent, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = animLoadedEvent.animType;
        }
        return animLoadedEvent.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.animType;
    }

    @NotNull
    public final AnimLoadedEvent copy(@Nullable Integer num) {
        return new AnimLoadedEvent(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AnimLoadedEvent) && s.d(this.animType, ((AnimLoadedEvent) obj).animType);
    }

    @Nullable
    public final Integer getAnimType() {
        return this.animType;
    }

    public int hashCode() {
        Integer num = this.animType;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnimLoadedEvent(animType=" + ((Object) this.animType) + ")";
    }
}
