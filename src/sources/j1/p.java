package j1;

import com.cupidapp.live.base.sensorslog.LoadType;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogWeb.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class p {

    /* renamed from: a */
    @NotNull
    public static final p f50243a = new p();

    public final void a(@NotNull String trackId, @Nullable String str, @Nullable String str2, @NotNull LoadType operationType, @Nullable String str3, @Nullable Long l10) {
        s.i(trackId, "trackId");
        s.i(operationType, "operationType");
        GroupOthersLog.f18702a.u(str, operationType.name(), str2, str3, l10);
    }
}
