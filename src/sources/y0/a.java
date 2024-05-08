package y0;

import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventBusHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54658a = new a();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        aVar.a(obj, function1);
    }

    public final void a(@NotNull Object subscriber, @Nullable Function1<? super Boolean, p> function1) {
        s.i(subscriber, "subscriber");
        if (EventBus.c().j(subscriber)) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        } else {
            EventBus.c().q(subscriber);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        }
    }

    public final void c(@NotNull Object subscriber) {
        s.i(subscriber, "subscriber");
        if (EventBus.c().j(subscriber)) {
            EventBus.c().t(subscriber);
        }
    }
}
