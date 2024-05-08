package kotlin.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReadWrite.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k {
    public static final void a(@NotNull Reader reader, @NotNull Function1<? super String, p> action) {
        s.i(reader, "<this>");
        s.i(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = b(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            p pVar = p.f51048a;
            b.a(bufferedReader, null);
        } finally {
        }
    }

    @NotNull
    public static final kotlin.sequences.g<String> b(@NotNull BufferedReader bufferedReader) {
        s.i(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.d(new j(bufferedReader));
    }
}
