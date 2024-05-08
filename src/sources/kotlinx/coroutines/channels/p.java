package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: RendezvousChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p<E> extends AbstractChannel<E> {
    public p(@Nullable Function1<? super E, kotlin.p> function1) {
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

    @Override // kotlinx.coroutines.channels.b
    public final boolean v() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.b
    public final boolean w() {
        return true;
    }
}
