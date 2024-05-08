package org.apache.commons.lang3.time;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class GmtTimeZone extends TimeZone {
    private static final int HOURS_PER_DAY = 24;
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    public static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    public GmtTimeZone(boolean z10, int i10, int i11) {
        if (i10 >= 24) {
            throw new IllegalArgumentException(i10 + " hours out of range");
        }
        if (i11 < 60) {
            int i12 = ((i10 * 60) + i11) * 60000;
            this.offset = z10 ? -i12 : i12;
            StringBuilder sb2 = new StringBuilder(9);
            sb2.append(TimeZones.GMT_ID);
            sb2.append(z10 ? '-' : '+');
            StringBuilder twoDigits = twoDigits(sb2, i10);
            twoDigits.append(ShortcutConstants.SERVICES_SEPARATOR);
            this.zoneId = twoDigits(twoDigits, i11).toString();
            return;
        }
        throw new IllegalArgumentException(i11 + " minutes out of range");
    }

    private static StringBuilder twoDigits(StringBuilder sb2, int i10) {
        sb2.append((char) ((i10 / 10) + 48));
        sb2.append((char) ((i10 % 10) + 48));
        return sb2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GmtTimeZone) && this.zoneId == ((GmtTimeZone) obj).zoneId;
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i10, int i11, int i12, int i13, int i14, int i15) {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i10) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + ']';
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }
}
