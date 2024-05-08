package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Strings;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ASN1UTCTime extends ASN1Primitive {
    private byte[] time;

    public static ASN1UTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UTCTime)) {
            return (ASN1UTCTime) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1UTCTime) fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject obj, boolean explicit) {
        ASN1Object o10 = obj.getObject();
        if (explicit || (o10 instanceof ASN1UTCTime)) {
            return getInstance(o10);
        }
        return new ASN1UTCTime(ASN1OctetString.getInstance(o10).getOctets());
    }

    public ASN1UTCTime(String time) {
        this.time = Strings.toByteArray(time);
        try {
            getDate();
        } catch (ParseException e2) {
            throw new IllegalArgumentException("invalid date string: " + e2.getMessage());
        }
    }

    public ASN1UTCTime(Date time) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'", Locale.US);
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(dateF.format(time));
    }

    public ASN1UTCTime(Date time, Locale locale) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'", Locale.US);
        dateF.setCalendar(Calendar.getInstance(locale));
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(dateF.format(time));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1UTCTime(byte[] time) {
        if (time.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.time = time;
        if (!isDigit(0) || !isDigit(1)) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz", Locale.US);
        return DateUtil.epochAdjust(dateF.parse(getTime()));
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz", Locale.US);
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        return DateUtil.epochAdjust(dateF.parse(getAdjustedTime()));
    }

    public String getTime() {
        String stime = Strings.fromByteArray(this.time);
        if (stime.indexOf(45) < 0 && stime.indexOf(43) < 0) {
            if (stime.length() == 11) {
                return stime.substring(0, 10) + "00GMT+00:00";
            }
            return stime.substring(0, 12) + "GMT+00:00";
        }
        int index = stime.indexOf(45);
        if (index < 0) {
            index = stime.indexOf(43);
        }
        String d10 = stime;
        if (index == stime.length() - 3) {
            d10 = d10 + "00";
        }
        return index == 10 ? d10.substring(0, 10) + "00GMT" + d10.substring(10, 13) + u.bD + d10.substring(13, 15) : d10.substring(0, 12) + TimeZones.GMT_ID + d10.substring(12, 15) + u.bD + d10.substring(15, 17);
    }

    public String getAdjustedTime() {
        String d10 = getTime();
        if (d10.charAt(0) < '5') {
            return "20" + d10;
        }
        return Constants.VIA_ACT_TYPE_NINETEEN + d10;
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
        out.writeEncoded(withTag, 23, this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive o10) {
        if (!(o10 instanceof ASN1UTCTime)) {
            return false;
        }
        return Arrays.areEqual(this.time, ((ASN1UTCTime) o10).time);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public String toString() {
        return Strings.fromByteArray(this.time);
    }
}
