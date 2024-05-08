package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.h0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharDirectionality.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);

    private final int value;

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate = kotlin.c.b(new Function0<Map<Integer, ? extends CharDirectionality>>() { // from class: kotlin.text.CharDirectionality$Companion$directionalityMap$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Map<Integer, ? extends CharDirectionality> invoke() {
            CharDirectionality[] values = CharDirectionality.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(ce.n.b(h0.c(values.length), 16));
            for (CharDirectionality charDirectionality : values) {
                linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
            }
            return linkedHashMap;
        }
    });

    /* compiled from: CharDirectionality.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    CharDirectionality(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
