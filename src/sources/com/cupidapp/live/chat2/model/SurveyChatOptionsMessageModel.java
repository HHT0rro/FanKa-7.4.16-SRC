package com.cupidapp.live.chat2.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatOptionsMessageModel extends BaseSurveyChatMessageModel {

    @NotNull
    private final String content;

    @NotNull
    private final List<SurveyChatOptionsModel> options;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatOptionsMessageModel(@NotNull String id2, @NotNull User sender, @NotNull String content, @NotNull List<SurveyChatOptionsModel> options) {
        super(id2, sender);
        s.i(id2, "id");
        s.i(sender, "sender");
        s.i(content, "content");
        s.i(options, "options");
        this.content = content;
        this.options = options;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<SurveyChatOptionsModel> getOptions() {
        return this.options;
    }
}
