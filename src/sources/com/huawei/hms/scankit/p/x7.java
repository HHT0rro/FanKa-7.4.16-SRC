package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: VCardResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class x7 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31732b = Pattern.compile("\r?\n[ \t]");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f31733c = Pattern.compile("=");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f31734d = Pattern.compile(";");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f31735e = Pattern.compile("(?<!\\\\);+");

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f31736f = new String[0];

    public static int a(char c4) {
        if (c4 >= '0' && c4 <= '9') {
            return c4 - '0';
        }
        char c10 = 'a';
        if (c4 < 'a' || c4 > 'f') {
            c10 = 'A';
            if (c4 < 'A' || c4 > 'F') {
                return -1;
            }
        }
        return (c4 - c10) + 10;
    }

    public static int a(int i10, String str, boolean z10) {
        int indexOf;
        while (true) {
            indexOf = str.indexOf(10, i10);
            if (indexOf >= 0) {
                if (indexOf < str.length() - 1) {
                    int i11 = indexOf + 1;
                    if (str.charAt(i11) == ' ' || str.charAt(i11) == '\t') {
                        i10 = indexOf + 2;
                    }
                }
                if (!z10 || (!a(indexOf, 1, str) && !a(indexOf, 2, str))) {
                    break;
                }
                i10 = indexOf + 1;
            } else {
                break;
            }
        }
        return indexOf;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            int i11 = HmsScan.TelPhoneNumber.OTHER_USE_TYPE;
            HmsScan.TelPhoneNumber telPhoneNumber = new HmsScan.TelPhoneNumber(i11, strArr2[i10]);
            if (strArr[i10] != null) {
                if (strArr[i10].equals("WORK")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.OFFICE_USE_TYPE;
                } else if (strArr[i10].equals("HOME")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                } else if (strArr[i10].equals("CELL")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE;
                } else if (strArr[i10].equals("FAX")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.FAX_USE_TYPE;
                } else {
                    telPhoneNumber.useType = i11;
                }
            }
            telPhoneNumberArr[i10] = telPhoneNumber;
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (!a10.startsWith("BEGIN:VCARD")) {
            return null;
        }
        String str = a10 + "\n";
        String a11 = a("N", str, true, false);
        if (a11 == null || a11.isEmpty() || a11.split(";").length == 0) {
            return null;
        }
        String a12 = a("FN", str, true, false);
        if (a12 == null || a12.isEmpty()) {
            a12 = c(a11);
        }
        String str2 = a12;
        List<List<String>> b4 = b("TEL", str, true, false);
        List<List<String>> b10 = b("EMAIL", str, true, false);
        List<List<String>> b11 = b("ADR", str, true, true);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str2, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.ContactDetail(a(a11, str2), a("TITLE", str, true, false), a("ORG", str, true, true), c(b(b4), a(b4)), b(b(b10), a(b10)), a(b(b11), a(b11)), a(b("URL", str, true, false)), null)));
    }

    public static void a(String str, boolean z10, boolean z11, String str2, boolean z12, List<String> list, List<List<String>> list2) {
        String replaceAll;
        if (z10) {
            str = str.trim();
        }
        if (z11) {
            replaceAll = a((CharSequence) str, str2);
            if (z12) {
                replaceAll = f31735e.matcher(replaceAll).replaceAll(" ").trim();
            }
        } else {
            if (z12) {
                str = f31735e.matcher(str).replaceAll(" ").trim();
            }
            replaceAll = f31732b.matcher(str).replaceAll("");
        }
        if (list == null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(replaceAll);
            list2.add(arrayList);
        } else {
            list.add(0, replaceAll);
            list2.add(list);
        }
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 < length) {
            char charAt2 = charSequence.charAt(i10);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb2);
                    sb2.append(charAt2);
                } else if (i10 < length - 2 && (charAt = charSequence.charAt(i10 + 1)) != '\r' && charAt != '\n') {
                    i10 += 2;
                    char charAt3 = charSequence.charAt(i10);
                    int a10 = a(charAt);
                    int a11 = a(charAt3);
                    if (a10 >= 0 && a11 >= 0) {
                        byteArrayOutputStream.write((a10 << 4) + a11);
                    }
                }
            }
            i10++;
        }
        a(byteArrayOutputStream, str, sb2);
        return sb2.toString();
    }

    private static String c(String str) {
        int indexOf;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArr = new String[5];
        int i10 = 0;
        int i11 = 0;
        while (i10 < 4 && (indexOf = str.indexOf(59, i11)) >= 0) {
            strArr[i10] = str.substring(i11, indexOf);
            i10++;
            i11 = indexOf + 1;
        }
        strArr[i10] = str.substring(i11);
        StringBuilder sb2 = new StringBuilder(100);
        a(strArr, 3, sb2);
        a(strArr, 1, sb2);
        a(strArr, 2, sb2);
        a(strArr, 0, sb2);
        a(strArr, 4, sb2);
        return sb2.toString().trim();
    }

    public static List<List<String>> b(CharSequence charSequence, String str, boolean z10, boolean z11) {
        boolean z12;
        String str2;
        ArrayList arrayList;
        int length = str.length();
        Pattern compile = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:\n(?![ |\t])]*))?:");
        int i10 = 0;
        ArrayList arrayList2 = null;
        while (i10 < length) {
            Matcher matcher = compile.matcher(str);
            if (i10 > 0) {
                i10--;
            }
            if (!matcher.find(i10)) {
                break;
            }
            int end = matcher.end(0);
            String group = matcher.group(1);
            if (group != null) {
                z12 = false;
                ArrayList arrayList3 = null;
                String str3 = null;
                for (String str4 : f31734d.split(group)) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList(1);
                    }
                    arrayList3.add(str4);
                    String[] split = f31733c.split(str4, 2);
                    if (split.length > 1) {
                        if ("ENCODING".equalsIgnoreCase(split[0]) && "QUOTED-PRINTABLE".equalsIgnoreCase(split[1])) {
                            z12 = true;
                        } else if ("CHARSET".equalsIgnoreCase(split[0])) {
                            str3 = split[1];
                        }
                    }
                }
                arrayList = arrayList3;
                str2 = str3;
            } else {
                z12 = false;
                str2 = null;
                arrayList = null;
            }
            int a10 = a(end, str, z12);
            if (a10 < 0) {
                a10 = length;
            } else if (a10 > end) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (a10 >= 1 && str.charAt(a10 - 1) == '\r') {
                    a10--;
                }
                a(str.substring(end, a10), z10, z12, str2, z11, arrayList, arrayList2);
            }
            i10 = a10 + 1;
        }
        return arrayList2;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb2) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb2.append(str2);
        }
    }

    private static String a(CharSequence charSequence, String str, boolean z10, boolean z11) {
        List<List<String>> b4 = b(charSequence, str, z10, z11);
        String str2 = "";
        if (b4 != null && !b4.isEmpty()) {
            for (List<String> list : b4) {
                if (list.get(0) != null && !list.get(0).isEmpty()) {
                    str2 = list.get(0);
                }
            }
        }
        return str2;
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            String str = iterator2.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(f31736f);
    }

    private static String[] b(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                String str2 = null;
                int i10 = 1;
                while (true) {
                    if (i10 >= list.size()) {
                        break;
                    }
                    String str3 = list.get(i10);
                    int indexOf = str3.indexOf(61);
                    if (indexOf < 0) {
                        str2 = str3;
                        break;
                    }
                    if ("TYPE".equals(str3.substring(0, indexOf))) {
                        str2 = str3.substring(indexOf + 1);
                        break;
                    }
                    i10++;
                }
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(f31736f);
    }

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        if (str != null) {
            String[] split = str.split(";");
            if (split.length > 0) {
                peopleName.familyName = split[0];
            }
            if (split.length > 1) {
                peopleName.givenName = split[1];
            }
            if (split.length > 2) {
                peopleName.middleName = split[2];
            }
            if (split.length > 3) {
                peopleName.namePrefix = split[3];
            }
            if (split.length > 4) {
                peopleName.nameSuffix = split[4];
            }
        }
        if (str2 != null) {
            peopleName.fullName = str2;
        }
        return peopleName;
    }

    private static HmsScan.EmailContent[] b(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            HmsScan.EmailContent emailContent = new HmsScan.EmailContent(strArr2[i10], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            if (strArr[i10] != null) {
                if (strArr[i10].equals("WORK")) {
                    emailContent.addressType = HmsScan.EmailContent.OFFICE_USE_TYPE;
                } else if (strArr[i10].equals("HOME")) {
                    emailContent.addressType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                }
            }
            emailContentArr[i10] = emailContent;
        }
        return emailContentArr;
    }

    private static HmsScan.AddressInfo[] a(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            HmsScan.AddressInfo addressInfo = new HmsScan.AddressInfo(new String[]{strArr2[i10]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            if (strArr[i10] != null) {
                if (strArr[i10].equals("WORK")) {
                    addressInfo.addressType = HmsScan.AddressInfo.OFFICE_TYPE;
                } else if (strArr[i10].equals("HOME")) {
                    addressInfo.addressType = HmsScan.AddressInfo.RESIDENTIAL_USE_TYPE;
                }
            }
            addressInfoArr[i10] = addressInfo;
        }
        return addressInfoArr;
    }

    private static void a(String[] strArr, int i10, StringBuilder sb2) {
        if (strArr[i10] == null || strArr[i10].isEmpty()) {
            return;
        }
        if (sb2.length() > 0) {
            sb2.append(' ');
        }
        sb2.append(strArr[i10]);
    }

    private static boolean a(int i10, int i11, String str) {
        return i10 >= i11 && str.charAt(i10 - i11) == '=';
    }
}
