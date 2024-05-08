package okhttp3.internal.concurrent;

import kotlin.d;
import kotlin.jvm.functions.Function0;

/* compiled from: TaskQueue.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TaskQueue$execute$1 extends Task {
    public final /* synthetic */ Function0 $block;
    public final /* synthetic */ boolean $cancelable;
    public final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(Function0 function0, String str, boolean z10, String str2, boolean z11) {
        super(str2, z11);
        this.$block = function0;
        this.$name = str;
        this.$cancelable = z10;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.$block.invoke();
        return -1L;
    }
}
