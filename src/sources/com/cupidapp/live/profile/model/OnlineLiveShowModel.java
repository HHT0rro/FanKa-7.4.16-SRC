package com.cupidapp.live.profile.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnlineLiveShowModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OnlineLiveShowModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f17842id;

    @Nullable
    private final String recommendId;

    public OnlineLiveShowModel(@Nullable String str, @Nullable String str2) {
        this.f17842id = str;
        this.recommendId = str2;
    }

    public static /* synthetic */ OnlineLiveShowModel copy$default(OnlineLiveShowModel onlineLiveShowModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = onlineLiveShowModel.f17842id;
        }
        if ((i10 & 2) != 0) {
            str2 = onlineLiveShowModel.recommendId;
        }
        return onlineLiveShowModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.f17842id;
    }

    @Nullable
    public final String component2() {
        return this.recommendId;
    }

    @NotNull
    public final OnlineLiveShowModel copy(@Nullable String str, @Nullable String str2) {
        return new OnlineLiveShowModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineLiveShowModel)) {
            return false;
        }
        OnlineLiveShowModel onlineLiveShowModel = (OnlineLiveShowModel) obj;
        return s.d(this.f17842id, onlineLiveShowModel.f17842id) && s.d(this.recommendId, onlineLiveShowModel.recommendId);
    }

    @Nullable
    public final String getId() {
        return this.f17842id;
    }

    @Nullable
    public final String getRecommendId() {
        return this.recommendId;
    }

    public int hashCode() {
        String str = this.f17842id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.recommendId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OnlineLiveShowModel(id=" + this.f17842id + ", recommendId=" + this.recommendId + ")";
    }

    public /* synthetic */ OnlineLiveShowModel(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}
