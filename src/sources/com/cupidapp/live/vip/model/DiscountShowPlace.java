package com.cupidapp.live.vip.model;

import com.kwad.components.offline.api.explore.model.ExploreConstants;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: VipDiscountPromptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum DiscountShowPlace {
    Feed(ExploreConstants.SCENE_FEED),
    Session("Session");


    @NotNull
    private final String place;

    DiscountShowPlace(String str) {
        this.place = str;
    }

    @NotNull
    public final String getPlace() {
        return this.place;
    }
}
