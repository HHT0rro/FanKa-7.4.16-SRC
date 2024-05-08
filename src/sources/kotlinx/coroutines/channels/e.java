package kotlinx.coroutines.channels;

import android.view.accessibility.AccessibilityNodeInfo;
import kotlinx.coroutines.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Channel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface e<E> extends r<E>, ReceiveChannel<E> {

    @NotNull
    public static final a D0 = a.f51171a;

    /* compiled from: Channel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f51171a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f51172b = g0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, AccessibilityNodeInfo.ROOT_ITEM_ID);

        public final int a() {
            return f51172b;
        }
    }
}
