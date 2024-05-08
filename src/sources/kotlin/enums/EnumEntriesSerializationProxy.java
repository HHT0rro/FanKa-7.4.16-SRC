package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: EnumEntriesSerializationProxy.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    @NotNull
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Class<E> f50945c;

    /* compiled from: EnumEntriesSerializationProxy.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EnumEntriesSerializationProxy(@NotNull E[] entries) {
        s.i(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        s.f(cls);
        this.f50945c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f50945c.getEnumConstants();
        s.h(enumConstants, "c.enumConstants");
        return EnumEntriesKt.a(enumConstants);
    }
}
