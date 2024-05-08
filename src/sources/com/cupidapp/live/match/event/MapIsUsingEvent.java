package com.cupidapp.live.match.event;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapIsUsingEvent {
    private final boolean isUsing;

    public MapIsUsingEvent(boolean z10) {
        this.isUsing = z10;
    }

    public static /* synthetic */ MapIsUsingEvent copy$default(MapIsUsingEvent mapIsUsingEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = mapIsUsingEvent.isUsing;
        }
        return mapIsUsingEvent.copy(z10);
    }

    public final boolean component1() {
        return this.isUsing;
    }

    @NotNull
    public final MapIsUsingEvent copy(boolean z10) {
        return new MapIsUsingEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MapIsUsingEvent) && this.isUsing == ((MapIsUsingEvent) obj).isUsing;
    }

    public int hashCode() {
        boolean z10 = this.isUsing;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    public final boolean isUsing() {
        return this.isUsing;
    }

    @NotNull
    public String toString() {
        return "MapIsUsingEvent(isUsing=" + this.isUsing + ")";
    }
}
