package f4;

import androidx.annotation.Nullable;
import com.danlan.android.cognition.collector.listener.DeviceIdCreateListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class a {
    public static void a(DeviceIdCreateListener deviceIdCreateListener, int i10, int i11, @Nullable String str) {
    }

    public static void b(DeviceIdCreateListener deviceIdCreateListener, int i10, int i11, @Nullable String str, @Nullable String str2) {
        deviceIdCreateListener.onInitializeDeviceId(i10, i11, str);
    }
}
