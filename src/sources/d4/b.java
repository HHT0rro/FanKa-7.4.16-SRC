package d4;

import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IVoiceEngine.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f48611a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static IVoiceEngine f48612b;

    /* compiled from: IVoiceEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final IVoiceEngine a() {
            if (b.f48612b == null) {
                b.f48612b = new d4.a();
            }
            return b.f48612b;
        }
    }
}
