package com.cupidapp.live.maskparty.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class MaskPartyChatConnectorMessageModel implements Serializable {

    @Nullable
    private final String roomId;

    public MaskPartyChatConnectorMessageModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MaskPartyChatConnectorMessageModel(@Nullable String str) {
        this.roomId = str;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    public /* synthetic */ MaskPartyChatConnectorMessageModel(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str);
    }
}
