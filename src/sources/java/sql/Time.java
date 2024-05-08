package java.sql;

import com.huawei.openalliance.ad.constant.u;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Time extends java.util.Date {
    static final long serialVersionUID = 8397324403548013681L;

    @Deprecated
    public Time(int hour, int minute, int second) {
        super(70, 0, 1, hour, minute, second);
    }

    public Time(long time) {
        super(time);
    }

    @Override // java.util.Date
    public void setTime(long time) {
        super.setTime(time);
    }

    public static Time valueOf(String s2) {
        if (s2 == null) {
            throw new IllegalArgumentException();
        }
        int firstColon = s2.indexOf(58);
        int secondColon = s2.indexOf(58, firstColon + 1);
        if ((secondColon < s2.length() - 1) & (firstColon > 0) & (secondColon > 0)) {
            int hour = Integer.parseInt(s2.substring(0, firstColon));
            int minute = Integer.parseInt(s2.substring(firstColon + 1, secondColon));
            int second = Integer.parseInt(s2.substring(secondColon + 1));
            return new Time(hour, minute, second);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    public String toString() {
        String hourString;
        String minuteString;
        String secondString;
        int hour = super.getHours();
        int minute = super.getMinutes();
        int second = super.getSeconds();
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
        return hourString + u.bD + minuteString + u.bD + secondString;
    }

    @Override // java.util.Date
    @Deprecated
    public int getYear() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public int getMonth() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public int getDay() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public int getDate() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public void setYear(int i10) {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public void setMonth(int i10) {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public void setDate(int i10) {
        throw new IllegalArgumentException();
    }
}
