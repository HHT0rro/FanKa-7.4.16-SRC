package com.cupidapp.live.liveshow.model;

import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeChestModel implements Serializable {
    private final int countDownSeconds;

    @Nullable
    private final ImageModel icon;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f15105id;
    private final long startTimeMs;
    private final int waitSeconds;

    public StarChallengeChestModel(@NotNull String id2, @Nullable ImageModel imageModel, long j10, int i10, int i11) {
        s.i(id2, "id");
        this.f15105id = id2;
        this.icon = imageModel;
        this.startTimeMs = j10;
        this.countDownSeconds = i10;
        this.waitSeconds = i11;
    }

    public static /* synthetic */ StarChallengeChestModel copy$default(StarChallengeChestModel starChallengeChestModel, String str, ImageModel imageModel, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = starChallengeChestModel.f15105id;
        }
        if ((i12 & 2) != 0) {
            imageModel = starChallengeChestModel.icon;
        }
        ImageModel imageModel2 = imageModel;
        if ((i12 & 4) != 0) {
            j10 = starChallengeChestModel.startTimeMs;
        }
        long j11 = j10;
        if ((i12 & 8) != 0) {
            i10 = starChallengeChestModel.countDownSeconds;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = starChallengeChestModel.waitSeconds;
        }
        return starChallengeChestModel.copy(str, imageModel2, j11, i13, i11);
    }

    @NotNull
    public final String component1() {
        return this.f15105id;
    }

    @Nullable
    public final ImageModel component2() {
        return this.icon;
    }

    public final long component3() {
        return this.startTimeMs;
    }

    public final int component4() {
        return this.countDownSeconds;
    }

    public final int component5() {
        return this.waitSeconds;
    }

    @NotNull
    public final StarChallengeChestModel copy(@NotNull String id2, @Nullable ImageModel imageModel, long j10, int i10, int i11) {
        s.i(id2, "id");
        return new StarChallengeChestModel(id2, imageModel, j10, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StarChallengeChestModel)) {
            return false;
        }
        StarChallengeChestModel starChallengeChestModel = (StarChallengeChestModel) obj;
        return s.d(this.f15105id, starChallengeChestModel.f15105id) && s.d(this.icon, starChallengeChestModel.icon) && this.startTimeMs == starChallengeChestModel.startTimeMs && this.countDownSeconds == starChallengeChestModel.countDownSeconds && this.waitSeconds == starChallengeChestModel.waitSeconds;
    }

    public final int getCountDownSeconds() {
        return this.countDownSeconds;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.f15105id;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final int getWaitSeconds() {
        return this.waitSeconds;
    }

    public int hashCode() {
        int hashCode = this.f15105id.hashCode() * 31;
        ImageModel imageModel = this.icon;
        return ((((((hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + a.a(this.startTimeMs)) * 31) + this.countDownSeconds) * 31) + this.waitSeconds;
    }

    @NotNull
    public String toString() {
        String str = this.f15105id;
        ImageModel imageModel = this.icon;
        return "StarChallengeChestModel(id=" + str + ", icon=" + ((Object) imageModel) + ", startTimeMs=" + this.startTimeMs + ", countDownSeconds=" + this.countDownSeconds + ", waitSeconds=" + this.waitSeconds + ")";
    }
}
