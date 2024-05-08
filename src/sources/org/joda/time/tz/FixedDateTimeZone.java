package org.joda.time.tz;

import com.google.android.material.badge.BadgeDrawable;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;
import org.joda.time.DateTimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FixedDateTimeZone extends DateTimeZone {
    private static final long serialVersionUID = -3513011772763289092L;
    private final String iNameKey;
    private final int iStandardOffset;
    private final int iWallOffset;

    public FixedDateTimeZone(String str, String str2, int i10, int i11) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i10;
        this.iStandardOffset = i11;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDateTimeZone)) {
            return false;
        }
        FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
        return getID().equals(fixedDateTimeZone.getID()) && this.iStandardOffset == fixedDateTimeZone.iStandardOffset && this.iWallOffset == fixedDateTimeZone.iWallOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public String getNameKey(long j10) {
        return this.iNameKey;
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffset(long j10) {
        return this.iWallOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffsetFromLocal(long j10) {
        return this.iWallOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public int getStandardOffset(long j10) {
        return this.iStandardOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return getID().hashCode() + (this.iStandardOffset * 37) + (this.iWallOffset * 31);
    }

    @Override // org.joda.time.DateTimeZone
    public boolean isFixed() {
        return true;
    }

    @Override // org.joda.time.DateTimeZone
    public long nextTransition(long j10) {
        return j10;
    }

    @Override // org.joda.time.DateTimeZone
    public long previousTransition(long j10) {
        return j10;
    }

    @Override // org.joda.time.DateTimeZone
    public TimeZone toTimeZone() {
        String id2 = getID();
        if (id2.length() == 6 && (id2.startsWith(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) || id2.startsWith("-"))) {
            return TimeZone.getTimeZone(TimeZones.GMT_ID + getID());
        }
        return new SimpleTimeZone(this.iWallOffset, getID());
    }
}
