package z3;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.irisdt.client.visitor.VisitorProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: GroupVisitorLog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f54838a = new f();

    public final void a(@NotNull SensorPosition position) {
        s.i(position, "position");
        c.f54829a.F(VisitorProtos.Event.VISITOR_MODE_CLICK, position.getValue());
    }

    public final void b(@NotNull SensorPosition position) {
        s.i(position, "position");
        c.f54829a.F(VisitorProtos.Event.VISITOR_MODE_SHOW, position.getValue());
    }
}
