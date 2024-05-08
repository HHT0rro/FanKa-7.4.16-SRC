package com.cupidapp.live.chat2.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseChatGrpcModel implements Serializable {

    @Nullable
    private final String sessionId;

    public BaseChatGrpcModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseChatGrpcModel(@Nullable String str) {
        this.sessionId = str;
    }

    @Nullable
    public final String getSessionId() {
        return this.sessionId;
    }

    public /* synthetic */ BaseChatGrpcModel(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str);
    }
}
