package com.cupidapp.live.base.view;

import androidx.annotation.StringRes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKToastView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ToastMessageEvent {

    @NotNull
    private final ToastIconType iconType;

    @Nullable
    private final CharSequence text;

    @Nullable
    private final Integer textResId;

    public ToastMessageEvent(@StringRes @Nullable Integer num, @Nullable CharSequence charSequence, @NotNull ToastIconType iconType) {
        kotlin.jvm.internal.s.i(iconType, "iconType");
        this.textResId = num;
        this.text = charSequence;
        this.iconType = iconType;
    }

    public static /* synthetic */ ToastMessageEvent copy$default(ToastMessageEvent toastMessageEvent, Integer num, CharSequence charSequence, ToastIconType toastIconType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = toastMessageEvent.textResId;
        }
        if ((i10 & 2) != 0) {
            charSequence = toastMessageEvent.text;
        }
        if ((i10 & 4) != 0) {
            toastIconType = toastMessageEvent.iconType;
        }
        return toastMessageEvent.copy(num, charSequence, toastIconType);
    }

    @Nullable
    public final Integer component1() {
        return this.textResId;
    }

    @Nullable
    public final CharSequence component2() {
        return this.text;
    }

    @NotNull
    public final ToastIconType component3() {
        return this.iconType;
    }

    @NotNull
    public final ToastMessageEvent copy(@StringRes @Nullable Integer num, @Nullable CharSequence charSequence, @NotNull ToastIconType iconType) {
        kotlin.jvm.internal.s.i(iconType, "iconType");
        return new ToastMessageEvent(num, charSequence, iconType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToastMessageEvent)) {
            return false;
        }
        ToastMessageEvent toastMessageEvent = (ToastMessageEvent) obj;
        return kotlin.jvm.internal.s.d(this.textResId, toastMessageEvent.textResId) && kotlin.jvm.internal.s.d(this.text, toastMessageEvent.text) && this.iconType == toastMessageEvent.iconType;
    }

    @NotNull
    public final ToastIconType getIconType() {
        return this.iconType;
    }

    @Nullable
    public final CharSequence getText() {
        return this.text;
    }

    @Nullable
    public final Integer getTextResId() {
        return this.textResId;
    }

    public int hashCode() {
        Integer num = this.textResId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        CharSequence charSequence = this.text;
        return ((hashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.iconType.hashCode();
    }

    @NotNull
    public String toString() {
        return "ToastMessageEvent(textResId=" + ((Object) this.textResId) + ", text=" + ((Object) this.text) + ", iconType=" + ((Object) this.iconType) + ")";
    }
}
