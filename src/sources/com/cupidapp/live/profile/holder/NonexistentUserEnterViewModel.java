package com.cupidapp.live.profile.holder;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: NonexistentUserEnterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NonexistentUserEnterViewModel {

    @NotNull
    private final RelationType relationType;

    public NonexistentUserEnterViewModel(@NotNull RelationType relationType) {
        s.i(relationType, "relationType");
        this.relationType = relationType;
    }

    @NotNull
    public final RelationType getRelationType() {
        return this.relationType;
    }
}
