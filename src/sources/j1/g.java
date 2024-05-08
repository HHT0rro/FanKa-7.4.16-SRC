package j1;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.others.OthersProtos;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogMediaPicker.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f50233a = new g();

    /* compiled from: SensorsLogMediaPicker.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50234a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f50234a = iArr;
        }
    }

    public static /* synthetic */ void b(g gVar, String str, SensorPosition sensorPosition, int i10, String str2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        gVar.a(str, sensorPosition, i10, str2);
    }

    public final void a(@Nullable String str, @Nullable SensorPosition sensorPosition, int i10, @Nullable String str2) {
        OthersProtos.Enum_type enum_type;
        if (str == null || sensorPosition == null) {
            return;
        }
        if (s.d(str, "图片")) {
            enum_type = OthersProtos.Enum_type.PICTURE;
        } else if (s.d(str, "视频")) {
            enum_type = OthersProtos.Enum_type.VIDEO;
        } else if (MimeType.Companion.b(str)) {
            enum_type = OthersProtos.Enum_type.VIDEO;
        } else {
            enum_type = OthersProtos.Enum_type.PICTURE;
        }
        GroupOthersLog.f18702a.d0(i10, enum_type, sensorPosition, str2);
    }

    public final void c(@Nullable MediaType mediaType, @Nullable SensorPosition sensorPosition, @Nullable String str) {
        OthersProtos.Enum_type enum_type;
        if (mediaType == null) {
            return;
        }
        int i10 = a.f50234a[mediaType.ordinal()];
        if (i10 == 1) {
            enum_type = OthersProtos.Enum_type.PICTURE;
        } else if (i10 == 2) {
            enum_type = OthersProtos.Enum_type.VIDEO;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            enum_type = OthersProtos.Enum_type.PICTURE_AND_VIDEO;
        }
        GroupOthersLog.f18702a.U(sensorPosition, enum_type, str);
    }
}
