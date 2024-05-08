package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AddressBookDoCoMoResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f30775b = Pattern.compile("(?:MECARD:)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f30776c = new String[0];

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.spelling = str2;
        int indexOf = str.indexOf(",");
        if (indexOf < 0) {
            peopleName.fullName = str;
            String[] split = str.split(" ");
            if (split.length > 0) {
                peopleName.givenName = split[0];
            }
            if (split.length > 1) {
                peopleName.familyName = split[1];
            }
        } else {
            peopleName.familyName = str.substring(0, indexOf);
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(",", i10);
            if (indexOf2 < 0) {
                peopleName.givenName = str.substring(i10);
            } else {
                peopleName.givenName = str.substring(i10, indexOf2);
            }
            peopleName.fullName = peopleName.givenName + " " + peopleName.familyName;
        }
        return peopleName;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            telPhoneNumberArr[i10] = new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, strArr[i10]);
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f30775b.matcher(a10);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a11 = a(split, "N:");
        if (a11.length() == 0) {
            return null;
        }
        String[] b4 = b(split, "TEL:");
        String[] b10 = b(split, "EMAIL:");
        String[] b11 = b(split, "ADR:");
        String[] b12 = b(split, "URL:");
        String a12 = a(split, "SOUND:");
        HmsScan.ContactDetail contactDetail = new HmsScan.ContactDetail(a(a11, a12), "", a(split, "ORG:"), c(b4), b(b10), a(b11), b12, a(split, "NOTE:"));
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), contactDetail.peopleName.fullName, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(contactDetail));
    }

    private static HmsScan.AddressInfo[] a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            addressInfoArr[i10] = new HmsScan.AddressInfo(new String[]{strArr[i10]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
        }
        return addressInfoArr;
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.EmailContent[] b(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            emailContentArr[i10] = new HmsScan.EmailContent(strArr[i10], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
        }
        return emailContentArr;
    }

    private static String[] b(String[] strArr, String str) {
        ArrayList arrayList = new ArrayList(5);
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                arrayList.add(t6.b(str2.substring(str.length())));
            }
        }
        return (String[]) arrayList.toArray(f30776c);
    }
}
