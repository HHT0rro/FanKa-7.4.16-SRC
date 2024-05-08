package com.cupidapp.live.base.network.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveShowTagJsonDeserializer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowTagJsonDeserializer implements JsonDeserializer<Object> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12003a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Map<Integer, Class<? extends BaseLiveShowTagModel>> f12004b = i0.g(f.a(1, LiveShowTagModel.class), f.a(2, FanClubTagModel.class));

    /* compiled from: LiveShowTagJsonDeserializer.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Object deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @Nullable JsonDeserializationContext jsonDeserializationContext) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        Class<? extends BaseLiveShowTagModel> cls = f12004b.get(Integer.valueOf(jsonElement.getAsJsonObject().get("type").getAsInt()));
        if (jsonDeserializationContext != null) {
            return jsonDeserializationContext.deserialize(jsonElement, cls);
        }
        return null;
    }
}
