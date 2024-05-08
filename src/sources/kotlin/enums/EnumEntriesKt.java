package kotlin.enums;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: EnumEntries.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class EnumEntriesKt {
    @NotNull
    public static final <E extends Enum<E>> a<E> a(@NotNull final E[] entries) {
        s.i(entries, "entries");
        EnumEntriesList enumEntriesList = new EnumEntriesList(new Function0<E[]>() { // from class: kotlin.enums.EnumEntriesKt$enumEntries$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: ([TE;)V */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()[TE; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Enum[] invoke() {
                return entries;
            }
        });
        enumEntriesList.size();
        return enumEntriesList;
    }
}
