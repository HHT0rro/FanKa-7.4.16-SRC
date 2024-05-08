package com.cupidapp.live.feed.helper;

import android.content.Context;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JumpEventHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f14350a = new k();

    /* compiled from: JumpEventHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14351a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.Feed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.FeedDetail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorPosition.Focus.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SensorPosition.ChatStatus.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14351a = iArr;
        }
    }

    public final void a(@NotNull FeedModel model, boolean z10, @Nullable FeedSensorContext feedSensorContext, boolean z11, boolean z12, @Nullable Map<String, ? extends Object> map, @Nullable Context context, @Nullable String str) {
        SensorPosition sensorPosition;
        s.i(model, "model");
        SensorPosition sensorPosition2 = SensorPosition.FeedDetail;
        if (feedSensorContext == null || (sensorPosition = feedSensorContext.getPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        FeedDetailActivity.a.b(FeedDetailActivity.Q, context, model, z10, new FeedSensorContext(sensorPosition2, sensorPosition, feedSensorContext != null ? feedSensorContext.getSource() : null, feedSensorContext != null ? feedSensorContext.getScene() : null), z11, z12, null, map, str, null, 512, null);
    }

    public final void b(@Nullable Context context, @NotNull User user, @Nullable String str, @Nullable FeedSensorContext feedSensorContext, boolean z10, @Nullable Map<String, ? extends Object> map) {
        String value;
        SensorPosition sensorPosition;
        s.i(user, "user");
        SensorPosition position = feedSensorContext != null ? feedSensorContext.getPosition() : null;
        int i10 = position == null ? -1 : a.f14351a[position.ordinal()];
        if (i10 == 1) {
            value = ViewProfilePrefer.FeedToProfile.getValue();
        } else if (i10 == 2) {
            value = ViewProfilePrefer.FeedDetailToProfile.getValue();
        } else if (i10 == 3) {
            value = ViewProfilePrefer.FocusToProfile.getValue();
        } else if (i10 != 4) {
            value = ViewProfilePrefer.FeedToProfile.getValue();
        } else {
            value = ViewProfilePrefer.ChatStatusToProfile.getValue();
        }
        String str2 = value;
        boolean me2 = user.getMe();
        if (feedSensorContext == null || (sensorPosition = feedSensorContext.getPosition()) == null) {
            sensorPosition = SensorPosition.Unknown;
        }
        UserProfileActivity.a.b(UserProfileActivity.G, context, user, new ProfileSensorContext(str2, str, me2, sensorPosition, feedSensorContext != null ? feedSensorContext.getSource() : null, feedSensorContext != null ? feedSensorContext.getScene() : null), z10, map, null, null, false, 224, null);
    }
}
