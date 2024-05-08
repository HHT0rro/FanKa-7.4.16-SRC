package java.text;

import com.huawei.openalliance.ad.constant.u;
import java.util.StringJoiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CalendarBuilder {
    private static final int COMPUTED = 1;
    public static final int ISO_DAY_OF_WEEK = 1000;
    private static final int MAX_FIELD = 18;
    private static final int MINIMUM_USER_STAMP = 2;
    private static final int UNSET = 0;
    public static final int WEEK_YEAR = 17;
    private final int[] field = new int[36];
    private int nextStamp = 2;
    private int maxFieldIndex = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarBuilder set(int index, int value) {
        if (index == 1000) {
            index = 7;
            value = toCalendarDayOfWeek(value);
        }
        int[] iArr = this.field;
        int i10 = this.nextStamp;
        this.nextStamp = i10 + 1;
        iArr[index] = i10;
        iArr[index + 18] = value;
        if (index > this.maxFieldIndex && index < 17) {
            this.maxFieldIndex = index;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarBuilder addYear(int value) {
        int[] iArr = this.field;
        iArr[19] = iArr[19] + value;
        iArr[35] = iArr[35] + value;
        return this;
    }

    boolean isSet(int index) {
        if (index == 1000) {
            index = 7;
        }
        return this.field[index] > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarBuilder clear(int index) {
        if (index == 1000) {
            index = 7;
        }
        int[] iArr = this.field;
        iArr[index] = 0;
        iArr[index + 18] = 0;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Calendar establish(java.util.Calendar r8) {
        /*
            r7 = this;
            r0 = 17
            boolean r1 = r7.isSet(r0)
            r2 = 1
            if (r1 == 0) goto L13
            int[] r1 = r7.field
            r0 = r1[r0]
            r1 = r1[r2]
            if (r0 <= r1) goto L13
            r0 = r2
            goto L14
        L13:
            r0 = 0
        L14:
            r1 = 35
            if (r0 == 0) goto L2c
            boolean r3 = r8.isWeekDateSupported()
            if (r3 != 0) goto L2c
            boolean r3 = r7.isSet(r2)
            if (r3 != 0) goto L2b
            int[] r3 = r7.field
            r3 = r3[r1]
            r7.set(r2, r3)
        L2b:
            r0 = 0
        L2c:
            r8.clear()
            r3 = 2
        L30:
            int r4 = r7.nextStamp
            if (r3 >= r4) goto L4d
            r4 = 0
        L35:
            int r5 = r7.maxFieldIndex
            if (r4 > r5) goto L4a
            int[] r5 = r7.field
            r6 = r5[r4]
            if (r6 != r3) goto L47
            int r6 = r4 + 18
            r5 = r5[r6]
            r8.set(r4, r5)
            goto L4a
        L47:
            int r4 = r4 + 1
            goto L35
        L4a:
            int r3 = r3 + 1
            goto L30
        L4d:
            if (r0 == 0) goto L9c
            r3 = 3
            boolean r3 = r7.isSet(r3)
            if (r3 == 0) goto L5d
            int[] r3 = r7.field
            r4 = 21
            r3 = r3[r4]
            goto L5e
        L5d:
            r3 = r2
        L5e:
            r4 = 7
            boolean r4 = r7.isSet(r4)
            if (r4 == 0) goto L6c
            int[] r4 = r7.field
            r5 = 25
            r4 = r4[r5]
            goto L70
        L6c:
            int r4 = r8.getFirstDayOfWeek()
        L70:
            boolean r5 = isValidDayOfWeek(r4)
            if (r5 != 0) goto L95
            boolean r5 = r8.isLenient()
            if (r5 == 0) goto L95
            r5 = 8
            if (r4 < r5) goto L89
            int r4 = r4 + (-1)
            int r5 = r4 / 7
            int r3 = r3 + r5
            int r5 = r4 % 7
            int r5 = r5 + r2
            goto L91
        L89:
            if (r4 > 0) goto L90
            int r4 = r4 + 7
            int r3 = r3 + (-1)
            goto L89
        L90:
            r5 = r4
        L91:
            int r4 = toCalendarDayOfWeek(r5)
        L95:
            int[] r2 = r7.field
            r1 = r2[r1]
            r8.setWeekDate(r1, r3, r4)
        L9c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.CalendarBuilder.establish(java.util.Calendar):java.util.Calendar");
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(",", "CalendarBuilder:[", "]");
        for (int i10 = 0; i10 < 18; i10++) {
            if (isSet(i10)) {
                sj.add(i10 + "=" + this.field[i10] + u.bD + this.field[i10 + 18]);
            }
        }
        return sj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toISODayOfWeek(int calendarDayOfWeek) {
        if (calendarDayOfWeek == 1) {
            return 7;
        }
        return calendarDayOfWeek - 1;
    }

    static int toCalendarDayOfWeek(int isoDayOfWeek) {
        if (!isValidDayOfWeek(isoDayOfWeek)) {
            return isoDayOfWeek;
        }
        if (isoDayOfWeek == 7) {
            return 1;
        }
        return isoDayOfWeek + 1;
    }

    static boolean isValidDayOfWeek(int dayOfWeek) {
        return dayOfWeek > 0 && dayOfWeek <= 7;
    }
}
