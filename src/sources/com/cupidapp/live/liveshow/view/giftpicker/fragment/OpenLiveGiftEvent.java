package com.cupidapp.live.liveshow.view.giftpicker.fragment;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftPickerFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenLiveGiftEvent {

    @Nullable
    private final String entrance;

    @Nullable
    private final String fenceId;

    @Nullable
    private final String giftId;

    public OpenLiveGiftEvent() {
        this(null, null, null, 7, null);
    }

    public OpenLiveGiftEvent(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.giftId = str;
        this.fenceId = str2;
        this.entrance = str3;
    }

    public static /* synthetic */ OpenLiveGiftEvent copy$default(OpenLiveGiftEvent openLiveGiftEvent, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = openLiveGiftEvent.giftId;
        }
        if ((i10 & 2) != 0) {
            str2 = openLiveGiftEvent.fenceId;
        }
        if ((i10 & 4) != 0) {
            str3 = openLiveGiftEvent.entrance;
        }
        return openLiveGiftEvent.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.giftId;
    }

    @Nullable
    public final String component2() {
        return this.fenceId;
    }

    @Nullable
    public final String component3() {
        return this.entrance;
    }

    @NotNull
    public final OpenLiveGiftEvent copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new OpenLiveGiftEvent(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenLiveGiftEvent)) {
            return false;
        }
        OpenLiveGiftEvent openLiveGiftEvent = (OpenLiveGiftEvent) obj;
        return s.d(this.giftId, openLiveGiftEvent.giftId) && s.d(this.fenceId, openLiveGiftEvent.fenceId) && s.d(this.entrance, openLiveGiftEvent.entrance);
    }

    @Nullable
    public final String getEntrance() {
        return this.entrance;
    }

    @Nullable
    public final String getFenceId() {
        return this.fenceId;
    }

    @Nullable
    public final String getGiftId() {
        return this.giftId;
    }

    public int hashCode() {
        String str = this.giftId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fenceId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.entrance;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OpenLiveGiftEvent(giftId=" + this.giftId + ", fenceId=" + this.fenceId + ", entrance=" + this.entrance + ")";
    }

    public /* synthetic */ OpenLiveGiftEvent(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
