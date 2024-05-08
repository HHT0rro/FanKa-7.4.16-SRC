package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MatchFilterSettingType {
    NO_FILTER(0),
    COMMON_FILTER(1),
    RAINBOW_FILTER(2);


    @NotNull
    public static final a Companion = new a(null);
    private final int value;

    /* compiled from: MatchSetttingModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable Integer num) {
            int value = MatchFilterSettingType.COMMON_FILTER.getValue();
            if (num == null || num.intValue() != value) {
                int value2 = MatchFilterSettingType.RAINBOW_FILTER.getValue();
                if (num == null || num.intValue() != value2) {
                    return false;
                }
            }
            return true;
        }
    }

    MatchFilterSettingType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
