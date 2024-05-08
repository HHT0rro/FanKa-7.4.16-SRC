package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendGiftCountModel implements Serializable {
    private final int count;

    @NotNull
    private final String description;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f15104id;

    public SendGiftCountModel(@NotNull String id2, int i10, @NotNull String description) {
        s.i(id2, "id");
        s.i(description, "description");
        this.f15104id = id2;
        this.count = i10;
        this.description = description;
    }

    public static /* synthetic */ SendGiftCountModel copy$default(SendGiftCountModel sendGiftCountModel, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sendGiftCountModel.f15104id;
        }
        if ((i11 & 2) != 0) {
            i10 = sendGiftCountModel.count;
        }
        if ((i11 & 4) != 0) {
            str2 = sendGiftCountModel.description;
        }
        return sendGiftCountModel.copy(str, i10, str2);
    }

    @NotNull
    public final String component1() {
        return this.f15104id;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final SendGiftCountModel copy(@NotNull String id2, int i10, @NotNull String description) {
        s.i(id2, "id");
        s.i(description, "description");
        return new SendGiftCountModel(id2, i10, description);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendGiftCountModel)) {
            return false;
        }
        SendGiftCountModel sendGiftCountModel = (SendGiftCountModel) obj;
        return s.d(this.f15104id, sendGiftCountModel.f15104id) && this.count == sendGiftCountModel.count && s.d(this.description, sendGiftCountModel.description);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.f15104id;
    }

    public int hashCode() {
        return (((this.f15104id.hashCode() * 31) + this.count) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        return "SendGiftCountModel(id=" + this.f15104id + ", count=" + this.count + ", description=" + this.description + ")";
    }
}
