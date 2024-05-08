package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.b;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LinkedListChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k<E> extends AbstractChannel<E> {
    public k(@Nullable Function1<? super E, kotlin.p> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean P() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean Q() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void U(@NotNull Object obj, @NotNull i<?> iVar) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                q qVar = (q) obj;
                if (qVar instanceof b.a) {
                    Function1<E, kotlin.p> function1 = this.f51161b;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.c(function1, ((b.a) qVar).f51163e, null);
                    }
                } else {
                    qVar.R(iVar);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                UndeliveredElementException undeliveredElementException2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    q qVar2 = (q) arrayList.get(size);
                    if (qVar2 instanceof b.a) {
                        Function1<E, kotlin.p> function12 = this.f51161b;
                        undeliveredElementException2 = function12 != null ? OnUndeliveredElementKt.c(function12, ((b.a) qVar2).f51163e, undeliveredElementException2) : null;
                    } else {
                        qVar2.R(iVar);
                    }
                }
                undeliveredElementException = undeliveredElementException2;
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean v() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean w() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    @NotNull
    public Object y(E e2) {
        o<?> B;
        do {
            Object y10 = super.y(e2);
            f0 f0Var = a.f51155b;
            if (y10 == f0Var) {
                return f0Var;
            }
            if (y10 == a.f51156c) {
                B = B(e2);
                if (B == null) {
                    return f0Var;
                }
            } else {
                if (y10 instanceof i) {
                    return y10;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + y10).toString());
            }
        } while (!(B instanceof i));
        return B;
    }
}
