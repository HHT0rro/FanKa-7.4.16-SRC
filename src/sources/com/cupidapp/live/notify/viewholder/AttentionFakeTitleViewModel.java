package com.cupidapp.live.notify.viewholder;

import com.cupidapp.live.notify.model.NotifyPopupInfoModel;
import j1.h;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: AttentionFakeTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionFakeTitleViewModel {

    @Nullable
    private final String btnAction;

    @Nullable
    private final String btnText;

    @Nullable
    private final NotifyPopupInfoModel popupInfo;

    @Nullable
    private String text;

    public AttentionFakeTitleViewModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable NotifyPopupInfoModel notifyPopupInfoModel) {
        this.text = str;
        this.btnText = str2;
        this.btnAction = str3;
        this.popupInfo = notifyPopupInfoModel;
        h.f50235a.a(str);
    }

    @Nullable
    public final String getBtnAction() {
        return this.btnAction;
    }

    @Nullable
    public final String getBtnText() {
        return this.btnText;
    }

    @Nullable
    public final NotifyPopupInfoModel getPopupInfo() {
        return this.popupInfo;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public /* synthetic */ AttentionFakeTitleViewModel(String str, String str2, String str3, NotifyPopupInfoModel notifyPopupInfoModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : notifyPopupInfoModel);
    }
}
