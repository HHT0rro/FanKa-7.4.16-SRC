package com.cupidapp.live.base.network.gson;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveShowTagJsonDeserializer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowTagModel extends BaseLiveShowTagModel {

    @NotNull
    private final ImageModel label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagModel(int i10, @NotNull ImageModel label) {
        super(i10);
        s.i(label, "label");
        this.label = label;
    }

    @NotNull
    public final ImageModel getLabel() {
        return this.label;
    }
}
