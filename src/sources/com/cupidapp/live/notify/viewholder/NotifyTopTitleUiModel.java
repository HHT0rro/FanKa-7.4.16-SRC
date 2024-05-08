package com.cupidapp.live.notify.viewholder;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyTopTitleViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyTopTitleUiModel {

    @NotNull
    private final String value;

    public NotifyTopTitleUiModel(@NotNull String value) {
        s.i(value, "value");
        this.value = value;
    }

    public static /* synthetic */ NotifyTopTitleUiModel copy$default(NotifyTopTitleUiModel notifyTopTitleUiModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = notifyTopTitleUiModel.value;
        }
        return notifyTopTitleUiModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.value;
    }

    @NotNull
    public final NotifyTopTitleUiModel copy(@NotNull String value) {
        s.i(value, "value");
        return new NotifyTopTitleUiModel(value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NotifyTopTitleUiModel) && s.d(this.value, ((NotifyTopTitleUiModel) obj).value);
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @NotNull
    public String toString() {
        return "NotifyTopTitleUiModel(value=" + this.value + ")";
    }
}
