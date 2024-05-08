package j1;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.irisdt.client.advertisement.AdvertisementProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogAd.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f50227a = new b();

    public final void a(@NotNull SensorPosition sensorPos, int i10, @Nullable String str) {
        s.i(sensorPos, "sensorPos");
        z3.c.f54829a.p(AdvertisementProtos.Event.MSG_AD_CLICK, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : str, (r62 & 1024) != 0 ? null : sensorPos.getValue(), (r62 & 2048) != 0 ? null : Integer.valueOf(i10), (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }

    public final void b(@NotNull SensorPosition sensorPos, int i10, @Nullable String str, @Nullable String str2) {
        s.i(sensorPos, "sensorPos");
        z3.c.f54829a.p(AdvertisementProtos.Event.MSG_AD_CLOSE, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : str2, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : str, (r62 & 1024) != 0 ? null : sensorPos.getValue(), (r62 & 2048) != 0 ? null : Integer.valueOf(i10), (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }

    public final void c(@Nullable String str, @NotNull SensorPosition sensorPos, int i10, @Nullable String str2, boolean z10, @Nullable Integer num, @Nullable String str3, @Nullable String str4, int i11) {
        s.i(sensorPos, "sensorPos");
        z3.c cVar = z3.c.f54829a;
        AdvertisementProtos.Event event = AdvertisementProtos.Event.MSG_AD_SHOW;
        String value = sensorPos.getValue();
        cVar.p(event, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : str, (r62 & 8) != 0 ? null : Boolean.valueOf(z10), (r62 & 16) != 0 ? null : String.valueOf(num), (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : str3, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : str2, (r62 & 1024) != 0 ? null : value, (r62 & 2048) != 0 ? null : Integer.valueOf(i10), (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : str4, (r62 & 16384) != 0 ? null : Integer.valueOf(i11), (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }
}
