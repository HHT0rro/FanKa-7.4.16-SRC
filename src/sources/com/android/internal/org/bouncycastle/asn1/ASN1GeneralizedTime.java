package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Strings;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ASN1GeneralizedTime extends ASN1Primitive {
    protected byte[] time;

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1GeneralizedTime)) {
            return (ASN1GeneralizedTime) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1GeneralizedTime) fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject obj, boolean explicit) {
        ASN1Primitive o10 = obj.getObject();
        if (explicit || (o10 instanceof ASN1GeneralizedTime)) {
            return getInstance(o10);
        }
        return new ASN1GeneralizedTime(ASN1OctetString.getInstance(o10).getOctets());
    }

    public ASN1GeneralizedTime(String time) {
        this.time = Strings.toByteArray(time);
        try {
            getDate();
        } catch (ParseException e2) {
            throw new IllegalArgumentException("invalid date string: " + e2.getMessage());
        }
    }

    public ASN1GeneralizedTime(Date time) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'", Locale.US);
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(dateF.format(time));
    }

    public ASN1GeneralizedTime(Date time, Locale locale) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'", Locale.US);
        dateF.setCalendar(Calendar.getInstance(Locale.US));
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(dateF.format(time));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1GeneralizedTime(byte[] bytes) {
        if (bytes.length < 4) {
            throw new IllegalArgumentException("GeneralizedTime string too short");
        }
        this.time = bytes;
        if (!isDigit(0) || !isDigit(1) || !isDigit(2) || !isDigit(3)) {
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.time);
    }

    public String getTime() {
        String stime = Strings.fromByteArray(this.time);
        if (stime.charAt(stime.length() - 1) == 'Z') {
            return stime.substring(0, stime.length() - 1) + "GMT+00:00";
        }
        int signPos = stime.length() - 6;
        char sign = stime.charAt(signPos);
        if ((sign == '-' || sign == '+') && stime.indexOf(TimeZones.GMT_ID) == signPos - 3) {
            return stime;
        }
        int signPos2 = stime.length() - 5;
        char sign2 = stime.charAt(signPos2);
        if (sign2 == '-' || sign2 == '+') {
            return stime.substring(0, signPos2) + TimeZones.GMT_ID + stime.substring(signPos2, signPos2 + 3) + u.bD + stime.substring(signPos2 + 3);
        }
        int signPos3 = stime.length() - 3;
        char sign3 = stime.charAt(signPos3);
        if (sign3 == '-' || sign3 == '+') {
            return stime.substring(0, signPos3) + TimeZones.GMT_ID + stime.substring(signPos3) + ":00";
        }
        return stime + calculateGMTOffset(stime);
    }

    private String calculateGMTOffset(String stime) {
        String sign = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getRawOffset();
        if (offset < 0) {
            sign = "-";
            offset = -offset;
        }
        int hours = offset / 3600000;
        int minutes = (offset - (((hours * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime()) {
                if (hasFractionalSeconds()) {
                    stime = pruneFractionalSeconds(stime);
                }
                SimpleDateFormat dateF = calculateGMTDateFormat();
                if (timeZone.inDaylightTime(dateF.parse(stime + TimeZones.GMT_ID + sign + convert(hours) + u.bD + convert(minutes)))) {
                    hours += sign.equals(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) ? 1 : -1;
                }
            }
        } catch (ParseException e2) {
        }
        return TimeZones.GMT_ID + sign + convert(hours) + u.bD + convert(minutes);
    }

    private SimpleDateFormat calculateGMTDateFormat() {
        SimpleDateFormat dateF;
        if (hasFractionalSeconds()) {
            dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
        } else if (hasSeconds()) {
            dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        } else if (hasMinutes()) {
            dateF = new SimpleDateFormat("yyyyMMddHHmmz");
        } else {
            dateF = new SimpleDateFormat("yyyyMMddHHz");
        }
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        return dateF;
    }

    private String pruneFractionalSeconds(String origTime) {
        char ch;
        String frac = origTime.substring(14);
        int index = 1;
        while (index < frac.length() && '0' <= (ch = frac.charAt(index)) && ch <= '9') {
            index++;
        }
        if (index - 1 > 3) {
            return origTime.substring(0, 14) + (frac.substring(0, 4) + frac.substring(index));
        }
        if (index - 1 == 1) {
            return origTime.substring(0, 14) + (frac.substring(0, index) + "00" + frac.substring(index));
        }
        if (index - 1 == 2) {
            return origTime.substring(0, 14) + (frac.substring(0, index) + "0" + frac.substring(index));
        }
        return origTime;
    }

    private String convert(int time) {
        if (time < 10) {
            return "0" + time;
        }
        return Integer.toString(time);
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat dateF;
        String stime = Strings.fromByteArray(this.time);
        String d10 = stime;
        if (stime.endsWith("Z")) {
            if (hasFractionalSeconds()) {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'", Locale.US);
            } else if (hasSeconds()) {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'", Locale.US);
            } else if (hasMinutes()) {
                dateF = new SimpleDateFormat("yyyyMMddHHmm'Z'", Locale.US);
            } else {
                dateF = new SimpleDateFormat("yyyyMMddHH'Z'", Locale.US);
            }
            dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (stime.indexOf(45) > 0 || stime.indexOf(43) > 0) {
            d10 = getTime();
            dateF = calculateGMTDateFormat();
        } else {
            if (hasFractionalSeconds()) {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.US);
            } else if (hasSeconds()) {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            } else if (hasMinutes()) {
                dateF = new SimpleDateFormat("yyyyMMddHHmm", Locale.US);
            } else {
                dateF = new SimpleDateFormat("yyyyMMddHH", Locale.US);
            }
            dateF.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (hasFractionalSeconds()) {
            d10 = pruneFractionalSeconds(d10);
        }
        return DateUtil.epochAdjust(dateF.parse(d10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasFractionalSeconds() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.time;
            if (i10 != bArr.length) {
                if (bArr[i10] != 46 || i10 != 14) {
                    i10++;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasSeconds() {
        return isDigit(12) && isDigit(13);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasMinutes() {
        return isDigit(10) && isDigit(11);
    }

    private boolean isDigit(int pos) {
        byte b4;
        byte[] bArr = this.time;
        return bArr.length > pos && (b4 = bArr[pos]) >= 48 && b4 <= 57;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        out.writeEncoded(withTag, 24, this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DERGeneralizedTime(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive o10) {
        if (!(o10 instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return Arrays.areEqual(this.time, ((ASN1GeneralizedTime) o10).time);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }
}
