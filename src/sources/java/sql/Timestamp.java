package java.sql;

import com.huawei.appgallery.agd.api.AgdConstant;
import com.huawei.openalliance.ad.constant.u;
import okhttp3.internal.http2.Http2Connection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Timestamp extends java.util.Date {
    static final long serialVersionUID = 2745179027874758501L;
    private int nanos;

    @Deprecated
    public Timestamp(int year, int month, int date, int hour, int minute, int second, int nano) {
        super(year, month, date, hour, minute, second);
        if (nano > 999999999 || nano < 0) {
            throw new IllegalArgumentException("nanos > 999999999 or < 0");
        }
        this.nanos = nano;
    }

    public Timestamp(long time) {
        super((time / 1000) * 1000);
        int i10 = (int) ((time % 1000) * 1000000);
        this.nanos = i10;
        if (i10 < 0) {
            this.nanos = i10 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            super.setTime(((time / 1000) - 1) * 1000);
        }
    }

    @Override // java.util.Date
    public void setTime(long time) {
        super.setTime((time / 1000) * 1000);
        int i10 = (int) ((time % 1000) * 1000000);
        this.nanos = i10;
        if (i10 < 0) {
            this.nanos = i10 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            super.setTime(((time / 1000) - 1) * 1000);
        }
    }

    @Override // java.util.Date
    public long getTime() {
        long time = super.getTime();
        return (this.nanos / 1000000) + time;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.sql.Timestamp valueOf(java.lang.String r38) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.sql.Timestamp.valueOf(java.lang.String):java.sql.Timestamp");
    }

    @Override // java.util.Date
    public String toString() {
        String yearString;
        String monthString;
        String dayString;
        String hourString;
        String minuteString;
        String secondString;
        String nanosString;
        int year = super.getYear() + 1900;
        int month = super.getMonth() + 1;
        int day = super.getDate();
        int hour = super.getHours();
        int minute = super.getMinutes();
        int second = super.getSeconds();
        if (year < 1000) {
            String yearString2 = "" + year;
            yearString = AgdConstant.INSTALL_TYPE_DEFAULT.substring(0, 4 - yearString2.length()) + yearString2;
        } else {
            yearString = "" + year;
        }
        if (month < 10) {
            monthString = "0" + month;
        } else {
            monthString = Integer.toString(month);
        }
        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = Integer.toString(day);
        }
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = Integer.toString(hour);
        }
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = Integer.toString(minute);
        }
        if (second < 10) {
            secondString = "0" + second;
        } else {
            secondString = Integer.toString(second);
        }
        int i10 = this.nanos;
        if (i10 == 0) {
            nanosString = "0";
        } else {
            String nanosString2 = Integer.toString(i10);
            String nanosString3 = "000000000".substring(0, 9 - nanosString2.length()) + nanosString2;
            char[] nanosChar = new char[nanosString3.length()];
            nanosString3.getChars(0, nanosString3.length(), nanosChar, 0);
            int truncIndex = 8;
            while (true) {
                String nanosString4 = nanosString3;
                if (nanosChar[truncIndex] != '0') {
                    break;
                }
                truncIndex--;
                nanosString3 = nanosString4;
            }
            nanosString = new String(nanosChar, 0, truncIndex + 1);
        }
        StringBuffer timestampBuf = new StringBuffer(nanosString.length() + 20);
        timestampBuf.append(yearString);
        timestampBuf.append("-");
        timestampBuf.append(monthString);
        timestampBuf.append("-");
        timestampBuf.append(dayString);
        timestampBuf.append(" ");
        timestampBuf.append(hourString);
        timestampBuf.append(u.bD);
        timestampBuf.append(minuteString);
        timestampBuf.append(u.bD);
        timestampBuf.append(secondString);
        timestampBuf.append(".");
        timestampBuf.append(nanosString);
        return timestampBuf.toString();
    }

    public int getNanos() {
        return this.nanos;
    }

    public void setNanos(int n10) {
        if (n10 > 999999999 || n10 < 0) {
            throw new IllegalArgumentException("nanos > 999999999 or < 0");
        }
        this.nanos = n10;
    }

    public boolean equals(Timestamp ts) {
        return super.equals((Object) ts) && this.nanos == ts.nanos;
    }

    @Override // java.util.Date
    public boolean equals(Object ts) {
        if (ts instanceof Timestamp) {
            return equals((Timestamp) ts);
        }
        return false;
    }

    public boolean before(Timestamp ts) {
        return compareTo(ts) < 0;
    }

    public boolean after(Timestamp ts) {
        return compareTo(ts) > 0;
    }

    public int compareTo(Timestamp ts) {
        long thisTime = getTime();
        long anotherTime = ts.getTime();
        int i10 = thisTime < anotherTime ? -1 : thisTime == anotherTime ? 0 : 1;
        if (i10 == 0) {
            int i11 = this.nanos;
            int i12 = ts.nanos;
            if (i11 > i12) {
                return 1;
            }
            if (i11 < i12) {
                return -1;
            }
        }
        return i10;
    }

    @Override // java.util.Date, java.lang.Comparable
    public int compareTo(java.util.Date o10) {
        if (o10 instanceof Timestamp) {
            return compareTo((Timestamp) o10);
        }
        Timestamp ts = new Timestamp(o10.getTime());
        return compareTo(ts);
    }

    @Override // java.util.Date
    public int hashCode() {
        return super.hashCode();
    }
}
