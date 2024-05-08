package com.cupidapp.live.match.model;

import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class MatchRecommendModel {

    @Nullable
    private final Map<String, Object> recommendContext;

    @NotNull
    private final String type;

    public MatchRecommendModel(@NotNull String type, @Nullable Map<String, ? extends Object> map) {
        s.i(type, "type");
        this.type = type;
        this.recommendContext = map;
    }

    @Nullable
    public final Map<String, Object> getRecommendContext() {
        return this.recommendContext;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public /* synthetic */ MatchRecommendModel(String str, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : map);
    }
}
