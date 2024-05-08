package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ChannelResult<T> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Failed failed = new Failed();

    @Nullable
    private final Object holder;

    /* compiled from: Channel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <E> Object a(@Nullable Throwable th) {
            return ChannelResult.m3578constructorimpl(new a(th));
        }

        @NotNull
        public final <E> Object b() {
            return ChannelResult.m3578constructorimpl(ChannelResult.failed);
        }

        @NotNull
        public final <E> Object c(E e2) {
            return ChannelResult.m3578constructorimpl(e2);
        }
    }

    /* compiled from: Channel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Failed {
        @NotNull
        public String toString() {
            return "Failed";
        }
    }

    /* compiled from: Channel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends Failed {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Throwable f51152a;

        public a(@Nullable Throwable th) {
            this.f51152a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.s.d(this.f51152a, ((a) obj).f51152a);
        }

        public int hashCode() {
            Throwable th = this.f51152a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        @NotNull
        public String toString() {
            return "Closed(" + ((Object) this.f51152a) + ')';
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ChannelResult m3577boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m3578constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3579equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && kotlin.jvm.internal.s.d(obj, ((ChannelResult) obj2).m3589unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3580equalsimpl0(Object obj, Object obj2) {
        return kotlin.jvm.internal.s.d(obj, obj2);
    }

    @Nullable
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m3581exceptionOrNullimpl(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f51152a;
        }
        return null;
    }

    public static /* synthetic */ void getHolder$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* renamed from: getOrNull-impl, reason: not valid java name */
    public static final T m3582getOrNullimpl(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrThrow-impl, reason: not valid java name */
    public static final T m3583getOrThrowimpl(Object obj) {
        Throwable th;
        if (!(obj instanceof Failed)) {
            return obj;
        }
        if ((obj instanceof a) && (th = ((a) obj).f51152a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3584hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m3585isClosedimpl(Object obj) {
        return obj instanceof a;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m3586isFailureimpl(Object obj) {
        return obj instanceof Failed;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m3587isSuccessimpl(Object obj) {
        return !(obj instanceof Failed);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3588toStringimpl(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m3579equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m3584hashCodeimpl(this.holder);
    }

    @NotNull
    public String toString() {
        return m3588toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m3589unboximpl() {
        return this.holder;
    }
}
