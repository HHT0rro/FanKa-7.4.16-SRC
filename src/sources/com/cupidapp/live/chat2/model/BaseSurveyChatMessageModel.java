package com.cupidapp.live.chat2.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseSurveyChatMessageModel {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f13408id;

    @NotNull
    private final User sender;

    public BaseSurveyChatMessageModel(@NotNull String id2, @NotNull User sender) {
        s.i(id2, "id");
        s.i(sender, "sender");
        this.f13408id = id2;
        this.sender = sender;
    }

    @NotNull
    public final String getId() {
        return this.f13408id;
    }

    @NotNull
    public final User getSender() {
        return this.sender;
    }
}
