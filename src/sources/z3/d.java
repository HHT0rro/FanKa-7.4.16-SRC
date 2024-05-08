package z3;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.track.group.SensorIconType;
import com.cupidapp.live.track.group.SensorVipType;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.visitors.model.DiscountReason;
import com.irisdt.client.increment.IncrementProtos;
import java.util.Locale;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GroupIncrementLog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f54832a = new d();

    /* compiled from: GroupIncrementLog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54833a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f54834b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f54835c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f54836d;

        static {
            int[] iArr = new int[SensorVipType.values().length];
            try {
                iArr[SensorVipType.A_PLUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorVipType.DIO_A_PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorVipType.A_PLUS_REPURCHASE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SensorVipType.MIXTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SensorVipType.RAINBOW_A_PLUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SensorVipType.DIO_RAINBOW_MIXTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SensorVipType.A_DIO_RAINBOW_MIXTURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SensorVipType.VISITOR_RAINBOW_MIXTURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SensorVipType.VISITOR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f54833a = iArr;
            int[] iArr2 = new int[VipType.values().length];
            try {
                iArr2[VipType.RAINBOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[VipType.SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[VipType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            f54834b = iArr2;
            int[] iArr3 = new int[PayType.values().length];
            try {
                iArr3[PayType.AliPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[PayType.WeChatPay.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[PayType.AliPayHuaBei.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            f54835c = iArr3;
            int[] iArr4 = new int[SensorIconType.values().length];
            try {
                iArr4[SensorIconType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[SensorIconType.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            f54836d = iArr4;
        }
    }

    public static /* synthetic */ void A(d dVar, Double d10, Double d11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        dVar.z(d10, d11, z10);
    }

    public final void B() {
        c.f54829a.t(IncrementProtos.Event.FIND_SOMEONE_ON_MAP_REPLACE_BTN_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void C() {
        c.f54829a.t(IncrementProtos.Event.FIND_SOMEONE_ON_MAP_BAR_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void D(@Nullable Double d10, @Nullable Double d11, @Nullable String str, boolean z10) {
        c.f54829a.t(IncrementProtos.Event.SEARCH_RESULT_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : Boolean.valueOf(z10), (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : d10, (r69 & 512) != 0 ? null : d11, (r69 & 1024) != 0 ? null : str, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void E(@Nullable SensorPosition sensorPosition) {
        c.f54829a.t(IncrementProtos.Event.FIND_SOMEONE_ON_MAP_PAGE_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : sensorPosition != null ? sensorPosition.getValue() : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void F() {
        c.f54829a.t(IncrementProtos.Event.NEARBY_MATCH_PAGE_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void G(@Nullable String str, @Nullable String str2) {
        c.f54829a.t(IncrementProtos.Event.SHOW_MY_VISITORS, (r69 & 2) != 0 ? null : str2, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void H(@NotNull String type) {
        s.i(type, "type");
        c.f54829a.t(IncrementProtos.Event.USE_SUPER_EXPOSURE_SUCCESS, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : type, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void I(@Nullable String str, @Nullable SensorVipType sensorVipType, @Nullable String str2, @Nullable SensorVipType sensorVipType2, @Nullable SensorVipType sensorVipType3) {
        c.f54829a.t(IncrementProtos.Event.VAS_POPUP_BTN_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : w(sensorVipType), (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : str2, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : w(sensorVipType2), (r69 & 268435456) != 0 ? null : w(sensorVipType3), (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void a(@Nullable String str) {
        c.f54829a.t(IncrementProtos.Event.AI_UPLOAD_PIC, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : str, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void b(int i10, @NotNull String type) {
        s.i(type, "type");
        c.f54829a.t(IncrementProtos.Event.SUPER_EXPOSURE_USE_CHECK_POPUP_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : type, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : Integer.valueOf(i10), (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void c(@Nullable SensorPosition sensorPosition) {
        c.f54829a.t(IncrementProtos.Event.BUY_SUPER_LIKE_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : sensorPosition != null ? sensorPosition.getValue() : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void d(@Nullable SensorPosition sensorPosition) {
        c.f54829a.t(IncrementProtos.Event.BUY_SUPER_LIKE_POPUP_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : sensorPosition != null ? sensorPosition.getValue() : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void e(@Nullable SensorPosition sensorPosition, @Nullable String str) {
        c.f54829a.t(IncrementProtos.Event.BUY_SUPER_LIKE_SUCCESS, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : str, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : sensorPosition != null ? sensorPosition.getValue() : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void f(@Nullable String str, @Nullable String str2) {
        c.f54829a.t(IncrementProtos.Event.BUY_SUPER_EXPOSURE_POPUP_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : str2, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void g(@Nullable String str, @NotNull String type) {
        s.i(type, "type");
        c.f54829a.t(IncrementProtos.Event.BUY_SUPER_EXPOSURE_POPUP_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : type, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void h(@Nullable String str, @NotNull String level, @NotNull PayType payType, @NotNull String price) {
        s.i(level, "level");
        s.i(payType, "payType");
        s.i(price, "price");
        c.f54829a.t(IncrementProtos.Event.BUY_SUPER_EXPOSURE_SUCCESS, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : level, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : x(payType), (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : price, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void i(@Nullable String str, @Nullable SensorVipType sensorVipType, @NotNull PayType payType, @NotNull VipType vipType, @Nullable String str2, @Nullable SensorVipType sensorVipType2, @Nullable SensorVipType sensorVipType3) {
        s.i(payType, "payType");
        s.i(vipType, "vipType");
        c.f54829a.t(IncrementProtos.Event.BUY_VIP_BUY_BTN_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : w(sensorVipType), (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : x(payType), (r69 & 524288) != 0 ? null : v(vipType), (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : str2, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : w(sensorVipType2), (r69 & 268435456) != 0 ? null : w(sensorVipType3), (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void j(@NotNull String from) {
        s.i(from, "from");
        c.f54829a.t(IncrementProtos.Event.BUY_VIP_BUY_VIP_ENTRANCE_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : from, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void k(@Nullable String str, @Nullable SensorVipType sensorVipType, @Nullable String str2, @Nullable SensorVipType sensorVipType2, @Nullable SensorVipType sensorVipType3) {
        c.f54829a.t(IncrementProtos.Event.BUY_VIP_POPUP_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : w(sensorVipType), (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : str2, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : w(sensorVipType2), (r69 & 268435456) != 0 ? null : w(sensorVipType3), (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void l(@Nullable String str, @Nullable String str2) {
        c.f54829a.t(IncrementProtos.Event.DISCOUNT_BUY_VISITOR_BTN_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : u(str2), (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void m(@Nullable String str, @Nullable String str2) {
        c.f54829a.t(IncrementProtos.Event.DISCOUNT_BUY_VISITOR_POPUP_SHOW, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : u(str2), (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void n(@Nullable String str, @NotNull String level, @Nullable String str2, @Nullable String str3) {
        s.i(level, "level");
        c.f54829a.t(IncrementProtos.Event.DISCOUNT_BUY_VISITOR_SUCCESS, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : level, (r69 & 16) != 0 ? null : u(str3), (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : str2, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void o(@Nullable String str) {
        c.f54829a.t(IncrementProtos.Event.BUY_VISITOR_ENTRANCE_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void p(@Nullable String str, @NotNull String level) {
        s.i(level, "level");
        c.f54829a.t(IncrementProtos.Event.BUY_VISITOR_SUCCESS, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : level, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void q() {
        c.f54829a.t(IncrementProtos.Event.RETURN_CURRENT_BTN_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void r(boolean z10, @Nullable String str, @Nullable String str2) {
        c.f54829a.t(IncrementProtos.Event.CLICK_MY_VISITORS, (r69 & 2) != 0 ? null : str2, (r69 & 4) != 0 ? null : str, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : Boolean.valueOf(z10), (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? null : null);
    }

    public final void s(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable SensorPosition sensorPosition, @Nullable Boolean bool, @Nullable String str8, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5) {
        c.f54829a.t(IncrementProtos.Event.FILTER_CONDITION_CHANGE, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : bool, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : sensorPosition != null ? sensorPosition.getValue() : null, (r69 & 256) != 0 ? null : null, (r69 & 512) != 0 ? null : null, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : str, (r69 & 4096) != 0 ? null : str2, (r69 & 8192) != 0 ? null : str3, (r69 & 16384) != 0 ? null : str4, (r69 & 32768) != 0 ? null : str8, (r69 & 65536) != 0 ? null : str6, (r69 & 131072) != 0 ? null : str7, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : str5, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : bool2, (r69 & 1073741824) != 0 ? null : bool3, (r69 & Integer.MIN_VALUE) != 0 ? null : bool4, (r70 & 1) != 0 ? null : null, (r70 & 2) == 0 ? bool5 : null);
    }

    public final String u(String str) {
        String str2;
        if (str != null) {
            Locale US = Locale.US;
            s.h(US, "US");
            str2 = str.toLowerCase(US);
            s.h(str2, "this as java.lang.String).toLowerCase(locale)");
        } else {
            str2 = null;
        }
        String value = DiscountReason.ReBuy.getValue();
        Locale US2 = Locale.US;
        s.h(US2, "US");
        String lowerCase = value.toLowerCase(US2);
        s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (s.d(str2, lowerCase)) {
            return "REBUY";
        }
        String value2 = DiscountReason.FirstTime.getValue();
        s.h(US2, "US");
        String lowerCase2 = value2.toLowerCase(US2);
        s.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        if (s.d(str2, lowerCase2)) {
            return "FIRST_TIME";
        }
        return null;
    }

    public final IncrementProtos.Buy_type v(VipType vipType) {
        int i10 = vipType == null ? -1 : a.f54834b[vipType.ordinal()];
        if (i10 == 1) {
            com.cupidapp.live.profile.logic.c cVar = com.cupidapp.live.profile.logic.c.f17839a;
            return !cVar.f() ? IncrementProtos.Buy_type.NON_MEMBER_BUY : cVar.b() ? IncrementProtos.Buy_type.NO_CHANGE : IncrementProtos.Buy_type.UPGRADE;
        }
        if (i10 == 2) {
            com.cupidapp.live.profile.logic.c cVar2 = com.cupidapp.live.profile.logic.c.f17839a;
            return !cVar2.f() ? IncrementProtos.Buy_type.NON_MEMBER_BUY : cVar2.c() ? IncrementProtos.Buy_type.NO_CHANGE : IncrementProtos.Buy_type.UPGRADE;
        }
        if (i10 != 3) {
            return null;
        }
        com.cupidapp.live.profile.logic.c cVar3 = com.cupidapp.live.profile.logic.c.f17839a;
        return cVar3.c() ? IncrementProtos.Buy_type.DEGRADE : cVar3.e() ? IncrementProtos.Buy_type.NO_CHANGE : IncrementProtos.Buy_type.NON_MEMBER_BUY;
    }

    public final IncrementProtos.Enum_type w(SensorVipType sensorVipType) {
        switch (sensorVipType == null ? -1 : a.f54833a[sensorVipType.ordinal()]) {
            case 1:
                return IncrementProtos.Enum_type.A_PLUS;
            case 2:
                return IncrementProtos.Enum_type.DIO_A_PLUS;
            case 3:
                return IncrementProtos.Enum_type.A_PLUS_REPURCHASE;
            case 4:
                return IncrementProtos.Enum_type.MIXTURE;
            case 5:
                return IncrementProtos.Enum_type.RAINBOW_A_PLUS;
            case 6:
                return IncrementProtos.Enum_type.DIO_RAINBOW_MIXTURE;
            case 7:
                return IncrementProtos.Enum_type.A_DIO_RAINBOW_MIXTURE;
            case 8:
                return IncrementProtos.Enum_type.VISITOR_RAINBOW_MIXTURE;
            case 9:
                return IncrementProtos.Enum_type.VISITOR;
            default:
                return null;
        }
    }

    public final IncrementProtos.Sub_type x(PayType payType) {
        int i10 = payType == null ? -1 : a.f54835c[payType.ordinal()];
        if (i10 == 1) {
            return IncrementProtos.Sub_type.ALI_PAY;
        }
        if (i10 == 2) {
            return IncrementProtos.Sub_type.WECHAT;
        }
        if (i10 != 3) {
            return null;
        }
        return IncrementProtos.Sub_type.ANT_CHECK_LATER;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y(@org.jetbrains.annotations.Nullable com.cupidapp.live.track.group.SensorIconType r42, @org.jetbrains.annotations.Nullable com.cupidapp.live.base.sensorslog.SensorPosition r43) {
        /*
            r41 = this;
            if (r42 != 0) goto L4
            r0 = -1
            goto Lc
        L4:
            int[] r0 = z3.d.a.f54836d
            int r1 = r42.ordinal()
            r0 = r0[r1]
        Lc:
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L18
            r1 = 2
            if (r0 == r1) goto L15
            r10 = r2
            goto L1b
        L15:
            com.irisdt.client.increment.IncrementProtos$Enum_type r0 = com.irisdt.client.increment.IncrementProtos.Enum_type.ICON
            goto L1a
        L18:
            com.irisdt.client.increment.IncrementProtos$Enum_type r0 = com.irisdt.client.increment.IncrementProtos.Enum_type.FILTER
        L1a:
            r10 = r0
        L1b:
            z3.c r3 = z3.c.f54829a
            com.irisdt.client.increment.IncrementProtos$Event r4 = com.irisdt.client.increment.IncrementProtos.Event.FIND_SOMEONE_ON_MAP_BTN_CLICK
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            if (r43 == 0) goto L2a
            java.lang.String r2 = r43.getValue()
        L2a:
            r11 = r2
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = -194(0xffffffffffffff3e, float:NaN)
            r39 = 3
            r40 = 0
            z3.c.u(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.d.y(com.cupidapp.live.track.group.SensorIconType, com.cupidapp.live.base.sensorslog.SensorPosition):void");
    }

    public final void z(@Nullable Double d10, @Nullable Double d11, boolean z10) {
        c.f54829a.t(IncrementProtos.Event.GO_NOW_BTN_CLICK, (r69 & 2) != 0 ? null : null, (r69 & 4) != 0 ? null : null, (r69 & 8) != 0 ? null : null, (r69 & 16) != 0 ? null : null, (r69 & 32) != 0 ? null : null, (r69 & 64) != 0 ? null : null, (r69 & 128) != 0 ? null : null, (r69 & 256) != 0 ? null : d10, (r69 & 512) != 0 ? null : d11, (r69 & 1024) != 0 ? null : null, (r69 & 2048) != 0 ? null : null, (r69 & 4096) != 0 ? null : null, (r69 & 8192) != 0 ? null : null, (r69 & 16384) != 0 ? null : null, (r69 & 32768) != 0 ? null : null, (r69 & 65536) != 0 ? null : null, (r69 & 131072) != 0 ? null : null, (r69 & 262144) != 0 ? null : null, (r69 & 524288) != 0 ? null : null, (r69 & 1048576) != 0 ? null : null, (r69 & 2097152) != 0 ? null : null, (r69 & 4194304) != 0 ? null : null, (r69 & 8388608) != 0 ? null : null, (r69 & 16777216) != 0 ? null : null, (r69 & 33554432) != 0 ? null : null, (r69 & 67108864) != 0 ? null : null, (r69 & 134217728) != 0 ? null : null, (r69 & 268435456) != 0 ? null : null, (r69 & 536870912) != 0 ? null : null, (r69 & 1073741824) != 0 ? null : null, (r69 & Integer.MIN_VALUE) != 0 ? null : null, (r70 & 1) != 0 ? null : Boolean.valueOf(z10), (r70 & 2) == 0 ? null : null);
    }
}
