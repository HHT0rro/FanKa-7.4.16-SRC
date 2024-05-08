package sun.util.calendar;

import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import sun.util.calendar.BaseCalendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LocalGregorianCalendar extends BaseCalendar {
    private Era[] eras;
    private String name;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Date extends BaseCalendar.Date {
        private int gregorianYear;

        protected Date() {
            this.gregorianYear = Integer.MIN_VALUE;
        }

        protected Date(TimeZone zone) {
            super(zone);
            this.gregorianYear = Integer.MIN_VALUE;
        }

        @Override // sun.util.calendar.CalendarDate
        public Date setEra(Era era) {
            if (getEra() != era) {
                super.setEra(era);
                this.gregorianYear = Integer.MIN_VALUE;
            }
            return this;
        }

        @Override // sun.util.calendar.CalendarDate
        public Date addYear(int localYear) {
            super.addYear(localYear);
            this.gregorianYear += localYear;
            return this;
        }

        @Override // sun.util.calendar.CalendarDate
        public Date setYear(int localYear) {
            if (getYear() != localYear) {
                super.setYear(localYear);
                this.gregorianYear = Integer.MIN_VALUE;
            }
            return this;
        }

        @Override // sun.util.calendar.BaseCalendar.Date
        public int getNormalizedYear() {
            return this.gregorianYear;
        }

        @Override // sun.util.calendar.BaseCalendar.Date
        public void setNormalizedYear(int normalizedYear) {
            this.gregorianYear = normalizedYear;
        }

        void setLocalEra(Era era) {
            super.setEra(era);
        }

        void setLocalYear(int year) {
            super.setYear(year);
        }

        @Override // sun.util.calendar.CalendarDate
        public String toString() {
            String abbr;
            String time = super.toString();
            String time2 = time.substring(time.indexOf(84));
            StringBuffer sb2 = new StringBuffer();
            Era era = getEra();
            if (era != null && (abbr = era.getAbbreviation()) != null) {
                sb2.append(abbr);
            }
            sb2.append(getYear()).append('.');
            CalendarUtils.sprintf0d(sb2, getMonth(), 2).append('.');
            CalendarUtils.sprintf0d(sb2, getDayOfMonth(), 2);
            sb2.append(time2);
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalGregorianCalendar getLocalGregorianCalendar(String name) {
        try {
            Properties calendarProps = CalendarSystem.getCalendarProperties();
            String props = calendarProps.getProperty("calendar." + name + ".eras");
            LocalGregorianCalendar localGregorianCalendar = null;
            if (props == null) {
                return null;
            }
            List<Era> eras = new ArrayList<>();
            StringTokenizer eraTokens = new StringTokenizer(props, ";");
            while (eraTokens.hasMoreTokens()) {
                String items = eraTokens.nextToken().trim();
                StringTokenizer itemTokens = new StringTokenizer(items, ",");
                String eraName = null;
                boolean localTime = true;
                long since = 0;
                String abbr = null;
                while (itemTokens.hasMoreTokens()) {
                    String item = itemTokens.nextToken();
                    int index = item.indexOf(61);
                    if (index == -1) {
                        return localGregorianCalendar;
                    }
                    String key = item.substring(0, index);
                    String value = item.substring(index + 1);
                    Properties calendarProps2 = calendarProps;
                    if ("name".equals(key)) {
                        eraName = value;
                    } else if ("since".equals(key)) {
                        if (value.endsWith(t.f36224i)) {
                            since = Long.parseLong(value.substring(0, value.length() - 1));
                            localTime = false;
                        } else {
                            since = Long.parseLong(value);
                        }
                    } else if ("abbr".equals(key)) {
                        abbr = value;
                    } else {
                        throw new RuntimeException("Unknown key word: " + key);
                    }
                    calendarProps = calendarProps2;
                    localGregorianCalendar = null;
                }
                Properties calendarProps3 = calendarProps;
                Era era = new Era(eraName, abbr, since, localTime);
                eras.add(era);
                calendarProps = calendarProps3;
                localGregorianCalendar = null;
            }
            if (eras.isEmpty()) {
                throw new RuntimeException("No eras for " + name);
            }
            Era[] eraArray = new Era[eras.size()];
            eras.toArray(eraArray);
            return new LocalGregorianCalendar(name, eraArray);
        } catch (IOException | IllegalArgumentException e2) {
            throw new InternalError(e2);
        }
    }

    private LocalGregorianCalendar(String name, Era[] eras) {
        this.name = name;
        this.eras = eras;
        setEras(eras);
    }

    @Override // sun.util.calendar.CalendarSystem
    public String getName() {
        return this.name;
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate() {
        return getCalendarDate(System.currentTimeMillis(), (CalendarDate) newCalendarDate());
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate(long millis) {
        return getCalendarDate(millis, (CalendarDate) newCalendarDate());
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate(long millis, TimeZone zone) {
        return getCalendarDate(millis, (CalendarDate) newCalendarDate(zone));
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate(long millis, CalendarDate date) {
        Date ldate = (Date) super.getCalendarDate(millis, date);
        return adjustYear(ldate, millis, ldate.getZoneOffset());
    }

    private Date adjustYear(Date ldate, long millis, int zoneOffset) {
        int i10 = this.eras.length - 1;
        while (true) {
            if (i10 < 0) {
                break;
            }
            Era era = this.eras[i10];
            long since = era.getSince(null);
            if (era.isLocalTime()) {
                since -= zoneOffset;
            }
            if (millis < since) {
                i10--;
            } else {
                ldate.setLocalEra(era);
                int y10 = (ldate.getNormalizedYear() - era.getSinceDate().getYear()) + 1;
                ldate.setLocalYear(y10);
                break;
            }
        }
        if (i10 < 0) {
            ldate.setLocalEra(null);
            ldate.setLocalYear(ldate.getNormalizedYear());
        }
        ldate.setNormalized(true);
        return ldate;
    }

    @Override // sun.util.calendar.CalendarSystem
    public Date newCalendarDate() {
        return new Date();
    }

    @Override // sun.util.calendar.CalendarSystem
    public Date newCalendarDate(TimeZone zone) {
        return new Date(zone);
    }

    @Override // sun.util.calendar.BaseCalendar, sun.util.calendar.CalendarSystem
    public boolean validate(CalendarDate date) {
        Date ldate = (Date) date;
        Era era = ldate.getEra();
        if (era == null) {
            if (date.getYear() >= this.eras[0].getSinceDate().getYear()) {
                return false;
            }
            ldate.setNormalizedYear(ldate.getYear());
        } else {
            if (!validateEra(era)) {
                return false;
            }
            ldate.setNormalizedYear((era.getSinceDate().getYear() + ldate.getYear()) - 1);
            Date tmp = newCalendarDate(date.getZone());
            tmp.setEra(era).setDate(date.getYear(), date.getMonth(), date.getDayOfMonth());
            normalize(tmp);
            if (tmp.getEra() != era) {
                return false;
            }
        }
        return super.validate(ldate);
    }

    private boolean validateEra(Era era) {
        int i10 = 0;
        while (true) {
            Era[] eraArr = this.eras;
            if (i10 < eraArr.length) {
                if (era != eraArr[i10]) {
                    i10++;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    @Override // sun.util.calendar.BaseCalendar, sun.util.calendar.CalendarSystem
    public boolean normalize(CalendarDate date) {
        if (date.isNormalized()) {
            return true;
        }
        normalizeYear(date);
        Date ldate = (Date) date;
        super.normalize(ldate);
        boolean hasMillis = false;
        long millis = 0;
        int year = ldate.getNormalizedYear();
        Era era = null;
        int i10 = this.eras.length - 1;
        while (true) {
            if (i10 < 0) {
                break;
            }
            era = this.eras[i10];
            if (era.isLocalTime()) {
                CalendarDate sinceDate = era.getSinceDate();
                int sinceYear = sinceDate.getYear();
                if (year > sinceYear) {
                    break;
                }
                if (year == sinceYear) {
                    int month = ldate.getMonth();
                    int sinceMonth = sinceDate.getMonth();
                    if (month > sinceMonth) {
                        break;
                    }
                    if (month == sinceMonth) {
                        int day = ldate.getDayOfMonth();
                        int sinceDay = sinceDate.getDayOfMonth();
                        if (day > sinceDay) {
                            break;
                        }
                        if (day == sinceDay) {
                            long timeOfDay = ldate.getTimeOfDay();
                            long sinceTimeOfDay = sinceDate.getTimeOfDay();
                            if (timeOfDay < sinceTimeOfDay) {
                                i10--;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
                i10--;
            } else {
                if (!hasMillis) {
                    millis = super.getTime(date);
                    hasMillis = true;
                }
                long since = era.getSince(date.getZone());
                if (millis >= since) {
                    break;
                }
                i10--;
            }
        }
        if (i10 >= 0) {
            ldate.setLocalEra(era);
            int y10 = (ldate.getNormalizedYear() - era.getSinceDate().getYear()) + 1;
            ldate.setLocalYear(y10);
        } else {
            ldate.setEra((Era) null);
            ldate.setLocalYear(year);
            ldate.setNormalizedYear(year);
        }
        ldate.setNormalized(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.util.calendar.BaseCalendar
    public void normalizeMonth(CalendarDate date) {
        normalizeYear(date);
        super.normalizeMonth(date);
    }

    void normalizeYear(CalendarDate date) {
        Date ldate = (Date) date;
        Era era = ldate.getEra();
        if (era == null || !validateEra(era)) {
            ldate.setNormalizedYear(ldate.getYear());
        } else {
            ldate.setNormalizedYear((era.getSinceDate().getYear() + ldate.getYear()) - 1);
        }
    }

    @Override // sun.util.calendar.BaseCalendar
    public boolean isLeapYear(int gregorianYear) {
        return CalendarUtils.isGregorianLeapYear(gregorianYear);
    }

    public boolean isLeapYear(Era era, int year) {
        if (era == null) {
            return isLeapYear(year);
        }
        int gyear = (era.getSinceDate().getYear() + year) - 1;
        return isLeapYear(gyear);
    }

    @Override // sun.util.calendar.BaseCalendar, sun.util.calendar.AbstractCalendar
    public void getCalendarDateFromFixedDate(CalendarDate date, long fixedDate) {
        Date ldate = (Date) date;
        super.getCalendarDateFromFixedDate(ldate, fixedDate);
        adjustYear(ldate, (fixedDate - 719163) * 86400000, 0);
    }
}
