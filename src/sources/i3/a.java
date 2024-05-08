package i3;

import android.os.SystemClock;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.performance.time.LoadAdResult;
import com.irisdt.client.advertisement.AdvertisementProtos;
import com.irisdt.client.others.OthersProtos;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.c;

/* compiled from: LaunchTimer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static long f49714b;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static LoadAdResult f49716d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f49717e;

    /* renamed from: f, reason: collision with root package name */
    public static long f49718f;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f49713a = new a();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static ArrayList<SensorPosition> f49715c = new ArrayList<>();

    public final void a(@NotNull SensorPosition position) {
        s.i(position, "position");
        if (!f49715c.contains(position) && !f49715c.contains(SensorPosition.DynPosition) && f49714b != 0 && !f49717e) {
            long uptimeMillis = SystemClock.uptimeMillis() - f49714b;
            f49715c.add(position);
            c cVar = c.f54829a;
            OthersProtos.Event event = OthersProtos.Event.APP_LAUNCH_RESULT;
            String value = position.getValue();
            Integer valueOf = Integer.valueOf((int) uptimeMillis);
            LoadAdResult loadAdResult = f49716d;
            cVar.z(event, (r85 & 2) != 0 ? null : null, (r85 & 4) != 0 ? null : null, (r85 & 8) != 0 ? null : null, (r85 & 16) != 0 ? null : null, (r85 & 32) != 0 ? null : null, (r85 & 64) != 0 ? null : null, (r85 & 128) != 0 ? null : null, (r85 & 256) != 0 ? null : null, (r85 & 512) != 0 ? null : null, (r85 & 1024) != 0 ? null : null, (r85 & 2048) != 0 ? null : null, (r85 & 4096) != 0 ? null : null, (r85 & 8192) != 0 ? null : null, (r85 & 16384) != 0 ? null : value, (r85 & 32768) != 0 ? null : null, (r85 & 65536) != 0 ? null : null, (r85 & 131072) != 0 ? null : null, (r85 & 262144) != 0 ? null : null, (r85 & 524288) != 0 ? null : null, (r85 & 1048576) != 0 ? null : null, (r85 & 2097152) != 0 ? null : null, (r85 & 4194304) != 0 ? null : null, (r85 & 8388608) != 0 ? null : valueOf, (r85 & 16777216) != 0 ? null : null, (r85 & 33554432) != 0 ? null : null, (r85 & 67108864) != 0 ? null : null, (r85 & 134217728) != 0 ? null : null, (r85 & 268435456) != 0 ? null : null, (r85 & 536870912) != 0 ? null : null, (r85 & 1073741824) != 0 ? null : null, (r85 & Integer.MIN_VALUE) != 0 ? null : loadAdResult != null ? loadAdResult.getValue() : null, (r86 & 1) != 0 ? null : null, (r86 & 2) != 0 ? null : null, (r86 & 4) != 0 ? null : null, (r86 & 8) != 0 ? null : null, (r86 & 16) != 0 ? null : null, (r86 & 32) != 0 ? null : null, (r86 & 64) != 0 ? null : null, (r86 & 128) != 0 ? null : null, (r86 & 256) != 0 ? null : null, (r86 & 512) != 0 ? null : null, (r86 & 1024) != 0 ? null : null);
            return;
        }
        f49717e = true;
    }

    public final boolean b() {
        return f49717e;
    }

    public final void c() {
        f49717e = true;
    }

    public final void d(boolean z10, @Nullable String str, @NotNull LoadAdResult result) {
        s.i(result, "result");
        if (z10) {
            long j10 = f49718f;
            if (j10 <= 0 || j10 <= f49714b) {
                return;
            }
            c.f54829a.p(AdvertisementProtos.Event.AD_TIME_SPENT_MONITOR, (r62 & 2) != 0 ? null : result.getValue(), (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : str, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : Long.valueOf(SystemClock.uptimeMillis() - f49718f), (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
        }
    }

    public final void e(@Nullable LoadAdResult loadAdResult) {
        f49716d = loadAdResult;
    }

    public final void f(long j10) {
        f49718f = j10;
    }

    public final void g() {
        f49714b = SystemClock.uptimeMillis();
    }
}
