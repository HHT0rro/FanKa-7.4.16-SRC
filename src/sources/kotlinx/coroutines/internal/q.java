package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: LockFreeLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Object f51406a = new f0("CONDITION_FALSE");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Object f51407b = new f0("LIST_EMPTY");

    @NotNull
    public static final Object a() {
        return f51406a;
    }

    @NotNull
    public static final Object b() {
        return f51407b;
    }

    @NotNull
    public static final LockFreeLinkedListNode c(@NotNull Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        z zVar = obj instanceof z ? (z) obj : null;
        return (zVar == null || (lockFreeLinkedListNode = zVar.f51425a) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
