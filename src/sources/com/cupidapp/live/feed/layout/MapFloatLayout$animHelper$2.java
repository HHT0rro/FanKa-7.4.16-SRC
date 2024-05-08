package com.cupidapp.live.feed.layout;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.match.helper.FloatAvatarHelper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: MapFloatLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MapFloatLayout$animHelper$2 extends Lambda implements Function0<FloatAvatarHelper<ImageModel>> {
    public static final MapFloatLayout$animHelper$2 INSTANCE = new MapFloatLayout$animHelper$2();

    public MapFloatLayout$animHelper$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final FloatAvatarHelper<ImageModel> invoke() {
        return new FloatAvatarHelper<>();
    }
}
