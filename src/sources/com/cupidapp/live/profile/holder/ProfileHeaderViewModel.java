package com.cupidapp.live.profile.holder;

import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.profile.model.SuperLikeGuideResult;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileHeaderViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileHeaderViewModel {

    @Nullable
    private final SuperLikeGuideResult guide;

    @NotNull
    private final ProfileSensorContext sensorContext;

    @NotNull
    private final User user;

    public ProfileHeaderViewModel(@NotNull User user, @Nullable SuperLikeGuideResult superLikeGuideResult, @NotNull ProfileSensorContext sensorContext) {
        s.i(user, "user");
        s.i(sensorContext, "sensorContext");
        this.user = user;
        this.guide = superLikeGuideResult;
        this.sensorContext = sensorContext;
    }

    @Nullable
    public final SuperLikeGuideResult getGuide() {
        return this.guide;
    }

    @NotNull
    public final ProfileSensorContext getSensorContext() {
        return this.sensorContext;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public /* synthetic */ ProfileHeaderViewModel(User user, SuperLikeGuideResult superLikeGuideResult, ProfileSensorContext profileSensorContext, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i10 & 2) != 0 ? null : superLikeGuideResult, profileSensorContext);
    }
}
