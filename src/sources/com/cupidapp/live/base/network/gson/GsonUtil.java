package com.cupidapp.live.base.network.gson;

import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.match.model.MatchRecommendModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: GsonUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GsonUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GsonUtil f12000a = new GsonUtil();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Lazy f12001b = c.b(new Function0<Gson>() { // from class: com.cupidapp.live.base.network.gson.GsonUtil$pureGson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Gson invoke() {
            return new GsonBuilder().registerTypeAdapter(BaseLiveShowTagModel.class, new LiveShowTagJsonDeserializer()).create();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f12002c = c.b(new Function0<Gson>() { // from class: com.cupidapp.live.base.network.gson.GsonUtil$customGson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Gson invoke() {
            return new GsonBuilder().registerTypeAdapter(AppDialogModel.class, new AppDialogJsonDeserializer()).registerTypeAdapter(BaseLiveShowTagModel.class, new LiveShowTagJsonDeserializer()).registerTypeAdapter(MatchRecommendModel.class, new SwipeCardJsonDeserializer()).create();
        }
    });

    @NotNull
    public final Gson a() {
        Object value = f12002c.getValue();
        s.h(value, "<get-customGson>(...)");
        return (Gson) value;
    }

    @NotNull
    public final Gson b() {
        Object value = f12001b.getValue();
        s.h(value, "<get-pureGson>(...)");
        return (Gson) value;
    }
}
