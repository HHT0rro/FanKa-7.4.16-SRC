package com.cupidapp.live.base.router;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRouter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface h {

    /* compiled from: FKRouter.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        @NotNull
        public static SensorPosition a(@NotNull h hVar, @Nullable String str) {
            SensorPosition sensorPosition = SensorPosition.DynPosition;
            if (str == null) {
                str = SensorPosition.Web.getValue();
            }
            sensorPosition.setValue(str);
            return sensorPosition;
        }

        @Nullable
        public static SensorScene b(@NotNull h hVar, @Nullable String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            SensorScene sensorScene = SensorScene.DynScene;
            sensorScene.setValue(str);
            return sensorScene;
        }
    }

    void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str);
}
