package java.time.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.UnaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class TemporalAdjusters {
    private TemporalAdjusters() {
    }

    public static TemporalAdjuster ofDateAdjuster(final UnaryOperator<LocalDate> dateBasedAdjuster) {
        Objects.requireNonNull(dateBasedAdjuster, "dateBasedAdjuster");
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda7
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$ofDateAdjuster$0(UnaryOperator.this, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Temporal lambda$ofDateAdjuster$0(UnaryOperator dateBasedAdjuster, Temporal temporal) {
        LocalDate input = LocalDate.from((TemporalAccessor) temporal);
        LocalDate output = (LocalDate) dateBasedAdjuster.apply(input);
        return temporal.with(output);
    }

    public static TemporalAdjuster firstDayOfMonth() {
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda2
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_MONTH, 1L);
                return with;
            }
        };
    }

    public static TemporalAdjuster lastDayOfMonth() {
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda12
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_MONTH, temporal.range(ChronoField.DAY_OF_MONTH).getMaximum());
                return with;
            }
        };
    }

    public static TemporalAdjuster firstDayOfNextMonth() {
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda8
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal plus;
                plus = temporal.with(ChronoField.DAY_OF_MONTH, 1L).plus(1L, ChronoUnit.MONTHS);
                return plus;
            }
        };
    }

    public static TemporalAdjuster firstDayOfYear() {
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda4
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_YEAR, 1L);
                return with;
            }
        };
    }

    public static TemporalAdjuster lastDayOfYear() {
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda0
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal with;
                with = temporal.with(ChronoField.DAY_OF_YEAR, temporal.range(ChronoField.DAY_OF_YEAR).getMaximum());
                return with;
            }
        };
    }

    public static TemporalAdjuster firstDayOfNextYear() {
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda6
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                Temporal plus;
                plus = temporal.with(ChronoField.DAY_OF_YEAR, 1L).plus(1L, ChronoUnit.YEARS);
                return plus;
            }
        };
    }

    public static TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek) {
        return dayOfWeekInMonth(1, dayOfWeek);
    }

    public static TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek) {
        return dayOfWeekInMonth(-1, dayOfWeek);
    }

    public static TemporalAdjuster dayOfWeekInMonth(final int ordinal, DayOfWeek dayOfWeek) {
        Objects.requireNonNull(dayOfWeek, "dayOfWeek");
        final int dowValue = dayOfWeek.getValue();
        if (ordinal >= 0) {
            return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda9
                @Override // java.time.temporal.TemporalAdjuster
                public final Temporal adjustInto(Temporal temporal) {
                    return TemporalAdjusters.lambda$dayOfWeekInMonth$7(dowValue, ordinal, temporal);
                }
            };
        }
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda10
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$dayOfWeekInMonth$8(dowValue, ordinal, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$dayOfWeekInMonth$7(int dowValue, int ordinal, Temporal temporal) {
        Temporal temp = temporal.with(ChronoField.DAY_OF_MONTH, 1L);
        int curDow = temp.get(ChronoField.DAY_OF_WEEK);
        int dowDiff = ((dowValue - curDow) + 7) % 7;
        return temp.plus((int) (dowDiff + ((ordinal - 1) * 7)), ChronoUnit.DAYS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$dayOfWeekInMonth$8(int dowValue, int ordinal, Temporal temporal) {
        Temporal temp = temporal.with(ChronoField.DAY_OF_MONTH, temporal.range(ChronoField.DAY_OF_MONTH).getMaximum());
        int curDow = temp.get(ChronoField.DAY_OF_WEEK);
        int daysDiff = dowValue - curDow;
        return temp.plus((int) ((daysDiff == 0 ? 0 : daysDiff > 0 ? daysDiff - 7 : daysDiff) - (((-ordinal) - 1) * 7)), ChronoUnit.DAYS);
    }

    public static TemporalAdjuster next(DayOfWeek dayOfWeek) {
        final int dowValue = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda1
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$next$9(dowValue, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$next$9(int dowValue, Temporal temporal) {
        int calDow = temporal.get(ChronoField.DAY_OF_WEEK);
        int daysDiff = calDow - dowValue;
        return temporal.plus(daysDiff >= 0 ? 7 - daysDiff : -daysDiff, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        final int dowValue = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda11
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$nextOrSame$10(dowValue, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$nextOrSame$10(int dowValue, Temporal temporal) {
        int calDow = temporal.get(ChronoField.DAY_OF_WEEK);
        if (calDow == dowValue) {
            return temporal;
        }
        int daysDiff = calDow - dowValue;
        return temporal.plus(daysDiff >= 0 ? 7 - daysDiff : -daysDiff, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster previous(DayOfWeek dayOfWeek) {
        final int dowValue = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda5
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$previous$11(dowValue, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$previous$11(int dowValue, Temporal temporal) {
        int calDow = temporal.get(ChronoField.DAY_OF_WEEK);
        int daysDiff = dowValue - calDow;
        return temporal.minus(daysDiff >= 0 ? 7 - daysDiff : -daysDiff, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) {
        final int dowValue = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: java.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda3
            @Override // java.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$previousOrSame$12(dowValue, temporal);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$previousOrSame$12(int dowValue, Temporal temporal) {
        int calDow = temporal.get(ChronoField.DAY_OF_WEEK);
        if (calDow == dowValue) {
            return temporal;
        }
        int daysDiff = dowValue - calDow;
        return temporal.minus(daysDiff >= 0 ? 7 - daysDiff : -daysDiff, ChronoUnit.DAYS);
    }
}
