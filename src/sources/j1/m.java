package j1;

import com.cupidapp.live.base.sensorslog.NoAdReason;
import com.cupidapp.live.performance.time.LoadAdResult;
import com.cupidapp.live.startup.model.EventTrackAdEndType;
import com.cupidapp.live.startup.model.EventTrackAdType;
import com.cupidapp.live.startup.model.EventTrackClickType;
import com.cupidapp.live.startup.model.EventTrackRequestType;
import com.irisdt.client.advertisement.AdvertisementProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogStartup.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f50240a = new m();

    public final void a(@Nullable String str, @NotNull String adId, @NotNull String adSource, @Nullable String str2, @NotNull EventTrackAdType adType, @NotNull EventTrackRequestType requestType, int i10, @NotNull EventTrackClickType content, boolean z10) {
        s.i(adId, "adId");
        s.i(adSource, "adSource");
        s.i(adType, "adType");
        s.i(requestType, "requestType");
        s.i(content, "content");
        z3.c.f54829a.p(AdvertisementProtos.Event.AD_CLICK, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : content.name(), (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : str, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : adId, (r62 & 262144) != 0 ? null : adSource, (r62 & 524288) != 0 ? null : str2, (r62 & 1048576) != 0 ? null : adType.name(), (r62 & 2097152) != 0 ? null : requestType.name(), (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : Integer.valueOf(i10), (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? Boolean.valueOf(z10) : null);
    }

    public final void b(@Nullable String str, @NotNull String adId, @NotNull String adSource, @Nullable String str2, @NotNull EventTrackAdType adType, @NotNull EventTrackRequestType requestType, long j10, @NotNull EventTrackClickType content, int i10, @NotNull EventTrackAdEndType endType, boolean z10) {
        s.i(adId, "adId");
        s.i(adSource, "adSource");
        s.i(adType, "adType");
        s.i(requestType, "requestType");
        s.i(content, "content");
        s.i(endType, "endType");
        z3.c cVar = z3.c.f54829a;
        AdvertisementProtos.Event event = AdvertisementProtos.Event.AD_END;
        String name = adType.name();
        String name2 = requestType.name();
        cVar.p(event, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : content.name(), (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : str, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : adId, (r62 & 262144) != 0 ? null : adSource, (r62 & 524288) != 0 ? null : str2, (r62 & 1048576) != 0 ? null : name, (r62 & 2097152) != 0 ? null : name2, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : Integer.valueOf(i10), (r62 & 134217728) != 0 ? null : Long.valueOf(j10), (r62 & 268435456) != 0 ? null : endType.name(), (r62 & 536870912) == 0 ? Boolean.valueOf(z10) : null);
    }

    public final void c(@Nullable String str, int i10, @NotNull String adId, @NotNull String adSource, @Nullable String str2, @NotNull EventTrackAdType adType, @NotNull EventTrackRequestType requestType, boolean z10) {
        s.i(adId, "adId");
        s.i(adSource, "adSource");
        s.i(adType, "adType");
        s.i(requestType, "requestType");
        z3.c.f54829a.p(AdvertisementProtos.Event.AD_REQUEST, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : str, (r62 & 65536) != 0 ? null : Integer.valueOf(i10), (r62 & 131072) != 0 ? null : adId, (r62 & 262144) != 0 ? null : adSource, (r62 & 524288) != 0 ? null : str2, (r62 & 1048576) != 0 ? null : adType.name(), (r62 & 2097152) != 0 ? null : requestType.name(), (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? Boolean.valueOf(z10) : null);
    }

    public final void d(@Nullable String str, int i10, @NotNull String adId, @NotNull String adSource, @Nullable String str2, @NotNull EventTrackAdType adType, @NotNull EventTrackRequestType requestType, long j10, boolean z10, @Nullable String str3, boolean z11) {
        s.i(adId, "adId");
        s.i(adSource, "adSource");
        s.i(adType, "adType");
        s.i(requestType, "requestType");
        z3.c.f54829a.p(AdvertisementProtos.Event.AD_RETURN, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : str3, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : str, (r62 & 65536) != 0 ? null : Integer.valueOf(i10), (r62 & 131072) != 0 ? null : adId, (r62 & 262144) != 0 ? null : adSource, (r62 & 524288) != 0 ? null : str2, (r62 & 1048576) != 0 ? null : adType.name(), (r62 & 2097152) != 0 ? null : requestType.name(), (r62 & 4194304) != 0 ? null : Boolean.valueOf(z10), (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : Long.valueOf(j10), (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? Boolean.valueOf(z11) : null);
    }

    public final void e(@Nullable String str, @NotNull String adId, @NotNull String adSource, @Nullable String str2, @NotNull EventTrackAdType adType, @NotNull EventTrackRequestType requestType, boolean z10, long j10, @NotNull EventTrackClickType content, int i10, @Nullable String str3, boolean z11) {
        s.i(adId, "adId");
        s.i(adSource, "adSource");
        s.i(adType, "adType");
        s.i(requestType, "requestType");
        s.i(content, "content");
        if (z10) {
            i3.a.f49713a.e(LoadAdResult.LOAD_SUCCEED);
        } else {
            i3.a.f49713a.e(LoadAdResult.LOAD_FAILED);
        }
        z3.c.f54829a.p(AdvertisementProtos.Event.AD_SHOW, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : str3, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : content.name(), (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : str, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : adId, (r62 & 262144) != 0 ? null : adSource, (r62 & 524288) != 0 ? null : str2, (r62 & 1048576) != 0 ? null : adType.name(), (r62 & 2097152) != 0 ? null : requestType.name(), (r62 & 4194304) != 0 ? null : Boolean.valueOf(z10), (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : Long.valueOf(j10), (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : Integer.valueOf(i10), (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? Boolean.valueOf(z11) : null);
    }

    public final void f(@NotNull NoAdReason reason) {
        s.i(reason, "reason");
        if (reason != NoAdReason.AD_REQUEST_SUCCESS_BUT_SHOW_TIMEOUT) {
            i3.a.f49713a.e(LoadAdResult.NOT_LOAD);
        } else {
            i3.a.f49713a.e(LoadAdResult.LOAD_FAILED);
        }
        com.cupidapp.live.startup.helper.b.f18418a.a(reason.getValue());
        z3.c.f54829a.p(AdvertisementProtos.Event.OPEN_APP_NO_AD, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : reason.getValue(), (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }
}
