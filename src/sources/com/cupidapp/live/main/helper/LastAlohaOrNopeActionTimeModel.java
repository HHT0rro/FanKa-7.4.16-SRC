package com.cupidapp.live.main.helper;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchRedDotHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LastAlohaOrNopeActionTimeModel implements Serializable {

    @NotNull
    private final Map<String, Long> map;

    public LastAlohaOrNopeActionTimeModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LastAlohaOrNopeActionTimeModel(@NotNull Map<String, Long> map) {
        s.i(map, "map");
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LastAlohaOrNopeActionTimeModel copy$default(LastAlohaOrNopeActionTimeModel lastAlohaOrNopeActionTimeModel, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = lastAlohaOrNopeActionTimeModel.map;
        }
        return lastAlohaOrNopeActionTimeModel.copy(map);
    }

    @NotNull
    public final Map<String, Long> component1() {
        return this.map;
    }

    @NotNull
    public final LastAlohaOrNopeActionTimeModel copy(@NotNull Map<String, Long> map) {
        s.i(map, "map");
        return new LastAlohaOrNopeActionTimeModel(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LastAlohaOrNopeActionTimeModel) && s.d(this.map, ((LastAlohaOrNopeActionTimeModel) obj).map);
    }

    @NotNull
    public final Map<String, Long> getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    @NotNull
    public String toString() {
        return "LastAlohaOrNopeActionTimeModel(map=" + ((Object) this.map) + ")";
    }

    public /* synthetic */ LastAlohaOrNopeActionTimeModel(Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map);
    }
}
