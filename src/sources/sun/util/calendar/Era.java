package sun.util.calendar;

import java.util.Locale;
import java.util.TimeZone;
import sun.util.calendar.BaseCalendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Era {
    private final String abbr;
    private int hash = 0;
    private final boolean localTime;
    private final String name;
    private final long since;
    private final CalendarDate sinceDate;

    public Era(String name, String abbr, long since, boolean localTime) {
        this.name = name;
        this.abbr = abbr;
        this.since = since;
        this.localTime = localTime;
        Gregorian gcal = CalendarSystem.getGregorianCalendar();
        BaseCalendar.Date d10 = gcal.newCalendarDate((TimeZone) null);
        gcal.getCalendarDate(since, (CalendarDate) d10);
        this.sinceDate = new ImmutableGregorianDate(d10);
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName(Locale locale) {
        return this.name;
    }

    public String getAbbreviation() {
        return this.abbr;
    }

    public String getDiaplayAbbreviation(Locale locale) {
        return this.abbr;
    }

    public long getSince(TimeZone zone) {
        if (zone == null || !this.localTime) {
            return this.since;
        }
        int offset = zone.getOffset(this.since);
        return this.since - offset;
    }

    public CalendarDate getSinceDate() {
        return this.sinceDate;
    }

    public boolean isLocalTime() {
        return this.localTime;
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof Era)) {
            return false;
        }
        Era that = (Era) o10;
        return this.name.equals(that.name) && this.abbr.equals(that.abbr) && this.since == that.since && this.localTime == that.localTime;
    }

    public int hashCode() {
        if (this.hash == 0) {
            int hashCode = this.name.hashCode() ^ this.abbr.hashCode();
            long j10 = this.since;
            this.hash = ((hashCode ^ ((int) j10)) ^ ((int) (j10 >> 32))) ^ (this.localTime ? 1 : 0);
        }
        return this.hash;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(getName()).append(" (");
        sb2.append(getAbbreviation()).append(')');
        sb2.append(" since ").append((Object) getSinceDate());
        if (this.localTime) {
            sb2.setLength(sb2.length() - 1);
            sb2.append(" local time");
        }
        sb2.append(']');
        return sb2.toString();
    }
}
