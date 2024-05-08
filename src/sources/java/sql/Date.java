package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Date extends java.util.Date {
    static final long serialVersionUID = 1511598038487230103L;

    @Deprecated
    public Date(int year, int month, int day) {
        super(year, month, day);
    }

    public Date(long date) {
        super(date);
    }

    @Override // java.util.Date
    public void setTime(long date) {
        super.setTime(date);
    }

    public static Date valueOf(String s2) {
        Date d10 = null;
        if (s2 != null) {
            int firstDash = s2.indexOf(45);
            int secondDash = s2.indexOf(45, firstDash + 1);
            if (firstDash > 0 && secondDash > 0 && secondDash < s2.length() - 1) {
                String yyyy = s2.substring(0, firstDash);
                String mm = s2.substring(firstDash + 1, secondDash);
                String dd2 = s2.substring(secondDash + 1);
                if (yyyy.length() == 4) {
                    if (mm.length() >= 1 && mm.length() <= 2) {
                        if (dd2.length() >= 1 && dd2.length() <= 2) {
                            int year = Integer.parseInt(yyyy);
                            int month = Integer.parseInt(mm);
                            int day = Integer.parseInt(dd2);
                            if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                                int YEAR_LENGTH = month - 1;
                                d10 = new Date(year - 1900, YEAR_LENGTH, day);
                            }
                        }
                    }
                }
            }
            if (d10 == null) {
                throw new IllegalArgumentException();
            }
            return d10;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    public String toString() {
        int year = super.getYear() + 1900;
        int month = super.getMonth() + 1;
        int day = super.getDate();
        char[] buf = "2000-00-00".toCharArray();
        buf[0] = Character.forDigit(year / 1000, 10);
        buf[1] = Character.forDigit((year / 100) % 10, 10);
        buf[2] = Character.forDigit((year / 10) % 10, 10);
        buf[3] = Character.forDigit(year % 10, 10);
        buf[5] = Character.forDigit(month / 10, 10);
        buf[6] = Character.forDigit(month % 10, 10);
        buf[8] = Character.forDigit(day / 10, 10);
        buf[9] = Character.forDigit(day % 10, 10);
        return new String(buf);
    }

    @Override // java.util.Date
    @Deprecated
    public int getHours() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public int getMinutes() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public int getSeconds() {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public void setHours(int i10) {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public void setMinutes(int i10) {
        throw new IllegalArgumentException();
    }

    @Override // java.util.Date
    @Deprecated
    public void setSeconds(int i10) {
        throw new IllegalArgumentException();
    }
}
