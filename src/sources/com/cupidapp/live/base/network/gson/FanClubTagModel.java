package com.cupidapp.live.base.network.gson;

import com.cupidapp.live.profile.model.FansClubMedalModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveShowTagJsonDeserializer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FanClubTagModel extends BaseLiveShowTagModel {

    @NotNull
    private final FansClubMedalModel label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FanClubTagModel(int i10, @NotNull FansClubMedalModel label) {
        super(i10);
        s.i(label, "label");
        this.label = label;
    }

    @NotNull
    public final FansClubMedalModel getLabel() {
        return this.label;
    }
}
