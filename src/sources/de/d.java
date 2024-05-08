package de;

import kotlin.jvm.internal.s;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {
    public static final long a(long j10, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        s.i(sourceUnit, "sourceUnit");
        s.i(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j10, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
}
