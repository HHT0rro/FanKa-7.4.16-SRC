package j1;

import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.sensorslog.TrackAppErrorType;
import com.irisdt.client.others.OthersProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogCommon.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f50231a = new f();

    /* compiled from: SensorsLogCommon.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50232a;

        static {
            int[] iArr = new int[TrackAppErrorType.values().length];
            try {
                iArr[TrackAppErrorType.GRPC_DISCONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackAppErrorType.TICKET_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f50232a = iArr;
        }
    }

    public final void a(@NotNull TrackAppErrorType type, @NotNull String reason) {
        OthersProtos.Enum_type enum_type;
        s.i(type, "type");
        s.i(reason, "reason");
        int i10 = a.f50232a[type.ordinal()];
        if (i10 != 1) {
            enum_type = i10 != 2 ? null : OthersProtos.Enum_type.TICKET_INVALID;
        } else {
            enum_type = OthersProtos.Enum_type.GRPC_DISCONNECTION;
        }
        z3.c.f54829a.z(OthersProtos.Event.APP_ERROR_REPORT, (r85 & 2) != 0 ? null : null, (r85 & 4) != 0 ? null : null, (r85 & 8) != 0 ? null : type.name(), (r85 & 16) != 0 ? null : null, (r85 & 32) != 0 ? null : null, (r85 & 64) != 0 ? null : null, (r85 & 128) != 0 ? null : null, (r85 & 256) != 0 ? null : null, (r85 & 512) != 0 ? null : null, (r85 & 1024) != 0 ? null : null, (r85 & 2048) != 0 ? null : null, (r85 & 4096) != 0 ? null : null, (r85 & 8192) != 0 ? null : null, (r85 & 16384) != 0 ? null : null, (r85 & 32768) != 0 ? null : null, (r85 & 65536) != 0 ? null : null, (r85 & 131072) != 0 ? null : null, (r85 & 262144) != 0 ? null : z0.h.g(AppApplication.f11612d.c()).name(), (r85 & 524288) != 0 ? null : reason, (r85 & 1048576) != 0 ? null : null, (r85 & 2097152) != 0 ? null : null, (r85 & 4194304) != 0 ? null : null, (r85 & 8388608) != 0 ? null : null, (r85 & 16777216) != 0 ? null : enum_type, (r85 & 33554432) != 0 ? null : null, (r85 & 67108864) != 0 ? null : null, (r85 & 134217728) != 0 ? null : null, (r85 & 268435456) != 0 ? null : null, (r85 & 536870912) != 0 ? null : null, (r85 & 1073741824) != 0 ? null : null, (r85 & Integer.MIN_VALUE) != 0 ? null : null, (r86 & 1) != 0 ? null : null, (r86 & 2) != 0 ? null : null, (r86 & 4) != 0 ? null : null, (r86 & 8) != 0 ? null : null, (r86 & 16) != 0 ? null : null, (r86 & 32) != 0 ? null : null, (r86 & 64) != 0 ? null : null, (r86 & 128) != 0 ? null : null, (r86 & 256) != 0 ? null : null, (r86 & 512) != 0 ? null : null, (r86 & 1024) != 0 ? null : null);
    }
}
