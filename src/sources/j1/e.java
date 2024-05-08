package j1;

import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.post.PostAndSocialProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogChat.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f50230a = new e();

    public static /* synthetic */ void c(e eVar, String str, Boolean bool, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        eVar.b(str, bool, str2, str3);
    }

    public static /* synthetic */ void e(e eVar, String str, Boolean bool, boolean z10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        eVar.d(str, bool, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3);
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        GroupOthersLog.f18702a.N(str3, str, str2);
    }

    public final void b(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3) {
        z3.c.f54829a.B(PostAndSocialProtos.Event.SESSION_CLICK, (r137 & 2) != 0 ? null : str, (r137 & 4) != 0 ? null : null, (r137 & 8) != 0 ? null : str3, (r137 & 16) != 0 ? null : bool, (r137 & 32) != 0 ? null : null, (r137 & 64) != 0 ? null : null, (r137 & 128) != 0 ? null : null, (r137 & 256) != 0 ? null : null, (r137 & 512) != 0 ? null : null, (r137 & 1024) != 0 ? null : null, (r137 & 2048) != 0 ? null : null, (r137 & 4096) != 0 ? null : str2, (r137 & 8192) != 0 ? null : null, (r137 & 16384) != 0 ? null : null, (r137 & 32768) != 0 ? null : null, (r137 & 65536) != 0 ? null : null, (r137 & 131072) != 0 ? null : null, (r137 & 262144) != 0 ? null : null, (r137 & 524288) != 0 ? null : null, (r137 & 1048576) != 0 ? null : null, (r137 & 2097152) != 0 ? null : null, (r137 & 4194304) != 0 ? null : null, (r137 & 8388608) != 0 ? null : null, (r137 & 16777216) != 0 ? null : null, (r137 & 33554432) != 0 ? null : null, (r137 & 67108864) != 0 ? null : null, (r137 & 134217728) != 0 ? null : null, (r137 & 268435456) != 0 ? null : null, (r137 & 536870912) != 0 ? null : null, (r137 & 1073741824) != 0 ? null : null, (r137 & Integer.MIN_VALUE) != 0 ? null : null, (r138 & 1) != 0 ? null : null, (r138 & 2) != 0 ? null : null, (r138 & 4) != 0 ? null : null, (r138 & 8) != 0 ? null : null, (r138 & 16) != 0 ? null : null, (r138 & 32) != 0 ? null : null, (r138 & 64) != 0 ? null : null, (r138 & 128) != 0 ? false : false, (r138 & 256) != 0 ? null : null, (r138 & 512) != 0 ? null : null, (r138 & 1024) != 0 ? null : null, (r138 & 2048) != 0 ? null : null, (r138 & 4096) != 0 ? null : null, (r138 & 8192) != 0 ? null : null, (r138 & 16384) != 0 ? null : null, (r138 & 32768) != 0 ? null : null, (r138 & 65536) != 0 ? null : null, (r138 & 131072) != 0 ? null : null, (r138 & 262144) != 0 ? null : null, (r138 & 524288) != 0 ? null : null, (r138 & 1048576) != 0 ? null : null, (r138 & 2097152) != 0 ? null : null, (r138 & 4194304) != 0 ? null : null, (r138 & 8388608) != 0 ? null : null, (r138 & 16777216) != 0 ? null : null, (r138 & 33554432) != 0 ? null : null, (r138 & 67108864) != 0 ? null : null, (r138 & 134217728) != 0 ? null : null, (r138 & 268435456) != 0 ? null : null, (r138 & 536870912) != 0 ? null : null, (r138 & 1073741824) != 0 ? null : null, (r138 & Integer.MIN_VALUE) != 0 ? null : null, (r139 & 1) != 0 ? null : null, (r139 & 2) != 0 ? null : null, (r139 & 4) != 0 ? null : null, (r139 & 8) != 0 ? null : null, (r139 & 16) != 0 ? null : null);
    }

    public final void d(@NotNull String type, @Nullable Boolean bool, boolean z10, @Nullable String str, @Nullable String str2) {
        s.i(type, "type");
        z3.c.f54829a.B(PostAndSocialProtos.Event.SESSION_SHOW, (r137 & 2) != 0 ? null : type, (r137 & 4) != 0 ? null : null, (r137 & 8) != 0 ? null : str, (r137 & 16) != 0 ? null : bool, (r137 & 32) != 0 ? null : null, (r137 & 64) != 0 ? null : null, (r137 & 128) != 0 ? null : null, (r137 & 256) != 0 ? null : null, (r137 & 512) != 0 ? null : null, (r137 & 1024) != 0 ? null : null, (r137 & 2048) != 0 ? null : null, (r137 & 4096) != 0 ? null : str2, (r137 & 8192) != 0 ? null : null, (r137 & 16384) != 0 ? null : null, (r137 & 32768) != 0 ? null : null, (r137 & 65536) != 0 ? null : null, (r137 & 131072) != 0 ? null : null, (r137 & 262144) != 0 ? null : null, (r137 & 524288) != 0 ? null : null, (r137 & 1048576) != 0 ? null : null, (r137 & 2097152) != 0 ? null : null, (r137 & 4194304) != 0 ? null : null, (r137 & 8388608) != 0 ? null : null, (r137 & 16777216) != 0 ? null : null, (r137 & 33554432) != 0 ? null : null, (r137 & 67108864) != 0 ? null : null, (r137 & 134217728) != 0 ? null : null, (r137 & 268435456) != 0 ? null : null, (r137 & 536870912) != 0 ? null : null, (r137 & 1073741824) != 0 ? null : null, (r137 & Integer.MIN_VALUE) != 0 ? null : null, (r138 & 1) != 0 ? null : null, (r138 & 2) != 0 ? null : null, (r138 & 4) != 0 ? null : null, (r138 & 8) != 0 ? null : null, (r138 & 16) != 0 ? null : null, (r138 & 32) != 0 ? null : null, (r138 & 64) != 0 ? null : null, (r138 & 128) != 0 ? false : false, (r138 & 256) != 0 ? null : null, (r138 & 512) != 0 ? null : null, (r138 & 1024) != 0 ? null : null, (r138 & 2048) != 0 ? null : null, (r138 & 4096) != 0 ? null : null, (r138 & 8192) != 0 ? null : Boolean.valueOf(z10), (r138 & 16384) != 0 ? null : null, (r138 & 32768) != 0 ? null : null, (r138 & 65536) != 0 ? null : null, (r138 & 131072) != 0 ? null : null, (r138 & 262144) != 0 ? null : null, (r138 & 524288) != 0 ? null : null, (r138 & 1048576) != 0 ? null : null, (r138 & 2097152) != 0 ? null : null, (r138 & 4194304) != 0 ? null : null, (r138 & 8388608) != 0 ? null : null, (r138 & 16777216) != 0 ? null : null, (r138 & 33554432) != 0 ? null : null, (r138 & 67108864) != 0 ? null : null, (r138 & 134217728) != 0 ? null : null, (r138 & 268435456) != 0 ? null : null, (r138 & 536870912) != 0 ? null : null, (r138 & 1073741824) != 0 ? null : null, (r138 & Integer.MIN_VALUE) != 0 ? null : null, (r139 & 1) != 0 ? null : null, (r139 & 2) != 0 ? null : null, (r139 & 4) != 0 ? null : null, (r139 & 8) != 0 ? null : null, (r139 & 16) != 0 ? null : null);
    }
}
