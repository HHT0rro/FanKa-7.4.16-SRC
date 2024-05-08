package okhttp3.internal.concurrent;

import kotlin.d;
import kotlin.jvm.functions.Function0;

/* compiled from: TaskQueue.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TaskQueue$schedule$2 extends Task {
    public final /* synthetic */ Function0 $block;
    public final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(Function0 function0, String str, String str2) {
        super(str2, false, 2, null);
        this.$block = function0;
        this.$name = str;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return ((Number) this.$block.invoke()).longValue();
    }
}
