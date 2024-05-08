package kotlinx.coroutines.channels;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ClosedReceiveChannelException extends NoSuchElementException {
    public ClosedReceiveChannelException(@Nullable String str) {
        super(str);
    }
}
