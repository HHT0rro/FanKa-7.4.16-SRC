package com.cupidapp.live.chat.model;

import java.io.Serializable;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageModels.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SerializableContext implements Serializable {

    @NotNull
    private final Map<String, Object> map;

    public SerializableContext(@NotNull Map<String, ? extends Object> map) {
        s.i(map, "map");
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SerializableContext copy$default(SerializableContext serializableContext, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = serializableContext.map;
        }
        return serializableContext.copy(map);
    }

    @NotNull
    public final Map<String, Object> component1() {
        return this.map;
    }

    @NotNull
    public final SerializableContext copy(@NotNull Map<String, ? extends Object> map) {
        s.i(map, "map");
        return new SerializableContext(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SerializableContext) && s.d(this.map, ((SerializableContext) obj).map);
    }

    @NotNull
    public final Map<String, Object> getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    @NotNull
    public String toString() {
        return "SerializableContext(map=" + ((Object) this.map) + ")";
    }
}
