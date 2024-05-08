package p1;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocalStoreManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f52847a = new j();

    public final void a(@NotNull Context context) {
        s.i(context, "context");
        MMKV.initialize(context);
    }
}
