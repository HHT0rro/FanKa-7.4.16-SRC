package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatNotifyMessageModel extends MaskPartyChatConnectorMessageModel {

    @Nullable
    private final String actionCompleteContent;

    @Nullable
    private final String buttonText;

    @Nullable
    private final Integer buttonType;

    @Nullable
    private final String cancelMessage;

    @Nullable
    private final String content;

    @Nullable
    private final List<String> highLight;

    public MaskPartyChatNotifyMessageModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ MaskPartyChatNotifyMessageModel(String str, String str2, Integer num, String str3, String str4, List list, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : list, (i10 & 64) != 0 ? null : str5);
    }

    @Nullable
    public final String getActionCompleteContent() {
        return this.actionCompleteContent;
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    public final Integer getButtonType() {
        return this.buttonType;
    }

    @Nullable
    public final String getCancelMessage() {
        return this.cancelMessage;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final List<String> getHighLight() {
        return this.highLight;
    }

    public MaskPartyChatNotifyMessageModel(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable List<String> list, @Nullable String str5) {
        super(str);
        this.content = str2;
        this.buttonType = num;
        this.buttonText = str3;
        this.actionCompleteContent = str4;
        this.highLight = list;
        this.cancelMessage = str5;
    }
}
