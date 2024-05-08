package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MusicTag implements Serializable {

    @Nullable
    private final String name;

    public MusicTag(@Nullable String str) {
        this.name = str;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }
}
