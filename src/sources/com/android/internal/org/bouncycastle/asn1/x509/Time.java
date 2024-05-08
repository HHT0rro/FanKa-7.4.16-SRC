package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Choice;
import com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.ASN1UTCTime;
import com.android.internal.org.bouncycastle.asn1.DERGeneralizedTime;
import com.android.internal.org.bouncycastle.asn1.DERUTCTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Time extends ASN1Object implements ASN1Choice {
    ASN1Primitive time;

    public static Time getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(obj.getObject());
    }

    public Time(ASN1Primitive time) {
        if (!(time instanceof ASN1UTCTime) && !(time instanceof ASN1GeneralizedTime)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.time = time;
    }

    public Time(Date time) {
        SimpleTimeZone tz = new SimpleTimeZone(0, "Z");
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        dateF.setTimeZone(tz);
        String d10 = dateF.format(time) + "Z";
        int year = Integer.parseInt(d10.substring(0, 4));
        if (year < 1950 || year > 2049) {
            this.time = new DERGeneralizedTime(d10);
        } else {
            this.time = new DERUTCTime(d10.substring(2));
        }
    }

    public Time(Date time, Locale locale) {
        SimpleTimeZone tz = new SimpleTimeZone(0, "Z");
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        dateF.setCalendar(Calendar.getInstance(locale));
        dateF.setTimeZone(tz);
        String d10 = dateF.format(time) + "Z";
        int year = Integer.parseInt(d10.substring(0, 4));
        if (year < 1950 || year > 2049) {
            this.time = new DERGeneralizedTime(d10);
        } else {
            this.time = new DERUTCTime(d10.substring(2));
        }
    }

    public static Time getInstance(Object obj) {
        if (obj == null || (obj instanceof Time)) {
            return (Time) obj;
        }
        if (obj instanceof ASN1UTCTime) {
            return new Time((ASN1UTCTime) obj);
        }
        if (obj instanceof ASN1GeneralizedTime) {
            return new Time((ASN1GeneralizedTime) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public String getTime() {
        ASN1Primitive aSN1Primitive = this.time;
        if (aSN1Primitive instanceof ASN1UTCTime) {
            return ((ASN1UTCTime) aSN1Primitive).getAdjustedTime();
        }
        return ((ASN1GeneralizedTime) aSN1Primitive).getTime();
    }

    public Date getDate() {
        try {
            ASN1Primitive aSN1Primitive = this.time;
            if (aSN1Primitive instanceof ASN1UTCTime) {
                return ((ASN1UTCTime) aSN1Primitive).getAdjustedDate();
            }
            return ((ASN1GeneralizedTime) aSN1Primitive).getDate();
        } catch (ParseException e2) {
            throw new IllegalStateException("invalid date string: " + e2.getMessage());
        }
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }

    public String toString() {
        return getTime();
    }
}
