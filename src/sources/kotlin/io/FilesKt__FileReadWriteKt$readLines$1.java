package kotlin.io;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileReadWrite.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class FilesKt__FileReadWriteKt$readLines$1 extends Lambda implements Function1<String, p> {
    public final /* synthetic */ ArrayList<String> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesKt__FileReadWriteKt$readLines$1(ArrayList<String> arrayList) {
        super(1);
        this.$result = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(String str) {
        invoke2(str);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String it) {
        s.i(it, "it");
        this.$result.add(it);
    }
}
