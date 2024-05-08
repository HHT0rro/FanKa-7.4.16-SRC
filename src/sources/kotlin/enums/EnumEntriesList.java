package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.b;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnumEntries.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EnumEntriesList<T extends Enum<T>> extends b<T> implements a<T>, Serializable {

    @Nullable
    private volatile T[] _entries;

    @NotNull
    private final Function0<T[]> entriesProvider;

    public EnumEntriesList(@NotNull Function0<T[]> entriesProvider) {
        s.i(entriesProvider, "entriesProvider");
        this.entriesProvider = entriesProvider;
    }

    private final T[] getEntries() {
        T[] tArr = this._entries;
        if (tArr != null) {
            return tArr;
        }
        T[] invoke = this.entriesProvider.invoke();
        this._entries = invoke;
        return invoke;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(getEntries());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((EnumEntriesList<T>) obj);
        }
        return false;
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int getSize() {
        return getEntries().length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((EnumEntriesList<T>) obj);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((EnumEntriesList<T>) obj);
        }
        return -1;
    }

    public boolean contains(@NotNull T element) {
        s.i(element, "element");
        return ((Enum) m.B(getEntries(), element.ordinal())) == element;
    }

    @Override // kotlin.collections.b, java.util.List
    @NotNull
    public T get(int i10) {
        T[] entries = getEntries();
        b.Companion.a(i10, entries.length);
        return entries[i10];
    }

    public int indexOf(@NotNull T element) {
        s.i(element, "element");
        int ordinal = element.ordinal();
        if (((Enum) m.B(getEntries(), ordinal)) == element) {
            return ordinal;
        }
        return -1;
    }

    public int lastIndexOf(@NotNull T element) {
        s.i(element, "element");
        return indexOf((Object) element);
    }
}
