package org.joda.time.format;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipUtils;
import okhttp3.internal.connection.RealConnection;
import okio.Utf8;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.field.MillisDurationField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DateTimeFormatterBuilder {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<Object> f52546a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public Object f52547b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum TimeZoneId implements org.joda.time.format.m, org.joda.time.format.k {
        INSTANCE;

        private static final List<String> ALL_IDS;
        private static final List<String> BASE_GROUPED_IDS = new ArrayList();
        private static final Map<String, List<String>> GROUPED_IDS;
        public static final int MAX_LENGTH;
        public static final int MAX_PREFIX_LENGTH;

        static {
            ArrayList<String> arrayList = new ArrayList(DateTimeZone.getAvailableIDs());
            ALL_IDS = arrayList;
            Collections.sort(arrayList);
            GROUPED_IDS = new HashMap();
            int i10 = 0;
            int i11 = 0;
            for (String str : arrayList) {
                int indexOf = str.indexOf(47);
                if (indexOf >= 0) {
                    indexOf = indexOf < str.length() ? indexOf + 1 : indexOf;
                    i11 = Math.max(i11, indexOf);
                    String substring = str.substring(0, indexOf + 1);
                    String substring2 = str.substring(indexOf);
                    Map<String, List<String>> map = GROUPED_IDS;
                    if (!map.containsKey(substring)) {
                        map.put(substring, new ArrayList());
                    }
                    map.get(substring).add(substring2);
                } else {
                    BASE_GROUPED_IDS.add(str);
                }
                i10 = Math.max(i10, str.length());
            }
            MAX_LENGTH = i10;
            MAX_PREFIX_LENGTH = i11;
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            String str;
            int i11;
            List<String> list = BASE_GROUPED_IDS;
            int length = charSequence.length();
            int min = Math.min(length, MAX_PREFIX_LENGTH + i10);
            int i12 = i10;
            while (true) {
                if (i12 >= min) {
                    str = "";
                    i11 = i10;
                    break;
                }
                if (charSequence.charAt(i12) == '/') {
                    int i13 = i12 + 1;
                    str = charSequence.subSequence(i10, i13).toString();
                    i11 = str.length() + i10;
                    list = GROUPED_IDS.get(i12 < length ? str + charSequence.charAt(i13) : str);
                    if (list == null) {
                        return ~i10;
                    }
                } else {
                    i12++;
                }
            }
            String str2 = null;
            for (int i14 = 0; i14 < list.size(); i14++) {
                String str3 = list.get(i14);
                if (DateTimeFormatterBuilder.Y(charSequence, i11, str3) && (str2 == null || str3.length() > str2.length())) {
                    str2 = str3;
                }
            }
            if (str2 == null) {
                return ~i10;
            }
            dVar.z(DateTimeZone.forID(str + str2));
            return i11 + str2.length();
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(dateTimeZone != null ? dateTimeZone.getID() : "");
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final char f52548b;

        public a(char c4) {
            this.f52548b = c4;
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return 1;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return 1;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            char upperCase;
            char upperCase2;
            if (i10 >= charSequence.length()) {
                return ~i10;
            }
            char charAt = charSequence.charAt(i10);
            char c4 = this.f52548b;
            return (charAt == c4 || (upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(c4)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) ? i10 + 1 : ~i10;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.f52548b);
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            appendable.append(this.f52548b);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class c extends g {
        public c(DateTimeFieldType dateTimeFieldType, int i10, boolean z10) {
            super(dateTimeFieldType, i10, z10, i10);
        }

        @Override // org.joda.time.format.DateTimeFormatterBuilder.f, org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            int i11;
            char charAt;
            int parseInto = super.parseInto(dVar, charSequence, i10);
            if (parseInto < 0 || parseInto == (i11 = this.f52559c + i10)) {
                return parseInto;
            }
            if (this.f52560d && ((charAt = charSequence.charAt(i10)) == '-' || charAt == '+')) {
                i11++;
            }
            return parseInto > i11 ? ~(i11 + 1) : parseInto < i11 ? ~parseInto : parseInto;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class d implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final DateTimeFieldType f52553b;

        /* renamed from: c, reason: collision with root package name */
        public int f52554c;

        /* renamed from: d, reason: collision with root package name */
        public int f52555d;

        public d(DateTimeFieldType dateTimeFieldType, int i10, int i11) {
            this.f52553b = dateTimeFieldType;
            i11 = i11 > 18 ? 18 : i11;
            this.f52554c = i10;
            this.f52555d = i11;
        }

        public final long[] a(long j10, org.joda.time.b bVar) {
            long j11;
            long unitMillis = bVar.getDurationField().getUnitMillis();
            int i10 = this.f52555d;
            while (true) {
                switch (i10) {
                    case 1:
                        j11 = 10;
                        break;
                    case 2:
                        j11 = 100;
                        break;
                    case 3:
                        j11 = 1000;
                        break;
                    case 4:
                        j11 = 10000;
                        break;
                    case 5:
                        j11 = 100000;
                        break;
                    case 6:
                        j11 = 1000000;
                        break;
                    case 7:
                        j11 = 10000000;
                        break;
                    case 8:
                        j11 = 100000000;
                        break;
                    case 9:
                        j11 = 1000000000;
                        break;
                    case 10:
                        j11 = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
                        break;
                    case 11:
                        j11 = 100000000000L;
                        break;
                    case 12:
                        j11 = 1000000000000L;
                        break;
                    case 13:
                        j11 = 10000000000000L;
                        break;
                    case 14:
                        j11 = 100000000000000L;
                        break;
                    case 15:
                        j11 = 1000000000000000L;
                        break;
                    case 16:
                        j11 = 10000000000000000L;
                        break;
                    case 17:
                        j11 = 100000000000000000L;
                        break;
                    case 18:
                        j11 = 1000000000000000000L;
                        break;
                    default:
                        j11 = 1;
                        break;
                }
                if ((unitMillis * j11) / j11 == unitMillis) {
                    return new long[]{(j10 * j11) / unitMillis, i10};
                }
                i10--;
            }
        }

        public void b(Appendable appendable, long j10, org.joda.time.a aVar) throws IOException {
            String l10;
            org.joda.time.b field = this.f52553b.getField(aVar);
            int i10 = this.f52554c;
            try {
                long remainder = field.remainder(j10);
                if (remainder != 0) {
                    long[] a10 = a(remainder, field);
                    long j11 = a10[0];
                    int i11 = (int) a10[1];
                    if ((ZipUtils.UPPER_UNIXTIME_BOUND & j11) == j11) {
                        l10 = Integer.toString((int) j11);
                    } else {
                        l10 = Long.toString(j11);
                    }
                    int length = l10.length();
                    while (length < i11) {
                        appendable.append('0');
                        i10--;
                        i11--;
                    }
                    if (i10 < i11) {
                        while (i10 < i11 && length > 1 && l10.charAt(length - 1) == '0') {
                            i11--;
                            length--;
                        }
                        if (length < l10.length()) {
                            for (int i12 = 0; i12 < length; i12++) {
                                appendable.append(l10.charAt(i12));
                            }
                            return;
                        }
                    }
                    appendable.append(l10);
                    return;
                }
                while (true) {
                    i10--;
                    if (i10 < 0) {
                        return;
                    } else {
                        appendable.append('0');
                    }
                }
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.Q(appendable, i10);
            }
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52555d;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52555d;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            org.joda.time.b field = this.f52553b.getField(dVar.n());
            int min = Math.min(this.f52555d, charSequence.length() - i10);
            long unitMillis = field.getDurationField().getUnitMillis() * 10;
            long j10 = 0;
            int i11 = 0;
            while (i11 < min) {
                char charAt = charSequence.charAt(i10 + i11);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i11++;
                unitMillis /= 10;
                j10 += (charAt - '0') * unitMillis;
            }
            long j11 = j10 / 10;
            if (i11 != 0 && j11 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                dVar.u(new org.joda.time.field.g(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, field.getDurationField()), (int) j11);
                return i10 + i11;
            }
            return ~i10;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            b(appendable, j10, aVar);
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            b(appendable, kVar.getChronology().set(kVar, 0L), kVar.getChronology());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class e implements org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final org.joda.time.format.k[] f52556b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52557c;

        public e(org.joda.time.format.k[] kVarArr) {
            int estimateParsedLength;
            this.f52556b = kVarArr;
            int length = kVarArr.length;
            int i10 = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    org.joda.time.format.k kVar = kVarArr[length];
                    if (kVar != null && (estimateParsedLength = kVar.estimateParsedLength()) > i10) {
                        i10 = estimateParsedLength;
                    }
                } else {
                    this.f52557c = i10;
                    return;
                }
            }
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52557c;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            int i11;
            int i12;
            org.joda.time.format.k[] kVarArr = this.f52556b;
            int length = kVarArr.length;
            Object x10 = dVar.x();
            boolean z10 = false;
            Object obj = null;
            int i13 = i10;
            int i14 = i13;
            int i15 = 0;
            while (true) {
                if (i15 >= length) {
                    break;
                }
                org.joda.time.format.k kVar = kVarArr[i15];
                if (kVar != null) {
                    int parseInto = kVar.parseInto(dVar, charSequence, i10);
                    if (parseInto >= i10) {
                        if (parseInto <= i13) {
                            continue;
                        } else {
                            if (parseInto >= charSequence.length() || (i12 = i15 + 1) >= length || kVarArr[i12] == null) {
                                break;
                            }
                            obj = dVar.x();
                            i13 = parseInto;
                        }
                    } else if (parseInto < 0 && (i11 = ~parseInto) > i14) {
                        i14 = i11;
                    }
                    dVar.t(x10);
                    i15++;
                } else {
                    if (i13 <= i10) {
                        return i10;
                    }
                    z10 = true;
                }
            }
            if (i13 <= i10 && (i13 != i10 || !z10)) {
                return ~i14;
            }
            if (obj != null) {
                dVar.t(obj);
            }
            return i13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class f implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final DateTimeFieldType f52558b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52559c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f52560d;

        public f(DateTimeFieldType dateTimeFieldType, int i10, boolean z10) {
            this.f52558b = dateTimeFieldType;
            this.f52559c = i10;
            this.f52560d = z10;
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52559c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x005e, code lost:
        
            if (r10 <= '9') goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0061, code lost:
        
            r5 = r5 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parseInto(org.joda.time.format.d r17, java.lang.CharSequence r18, int r19) {
            /*
                Method dump skipped, instructions count: 194
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.f.parseInto(org.joda.time.format.d, java.lang.CharSequence, int):int");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class h implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final String f52562b;

        public h(String str) {
            this.f52562b = str;
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52562b.length();
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52562b.length();
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            return DateTimeFormatterBuilder.Z(charSequence, i10, this.f52562b) ? i10 + this.f52562b.length() : ~i10;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.f52562b);
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            appendable.append(this.f52562b);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class j implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, DateTimeZone> f52566b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52567c;

        public j(int i10, Map<String, DateTimeZone> map) {
            this.f52567c = i10;
            this.f52566b = map;
        }

        public final String a(long j10, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone == null) {
                return "";
            }
            int i10 = this.f52567c;
            if (i10 != 0) {
                return i10 != 1 ? "" : dateTimeZone.getShortName(j10, locale);
            }
            return dateTimeZone.getName(j10, locale);
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52567c == 1 ? 4 : 20;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52567c == 1 ? 4 : 20;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            Map<String, DateTimeZone> map = this.f52566b;
            if (map == null) {
                map = org.joda.time.c.e();
            }
            String str = null;
            for (String str2 : map.h()) {
                if (DateTimeFormatterBuilder.Y(charSequence, i10, str2) && (str == null || str2.length() > str.length())) {
                    str = str2;
                }
            }
            if (str == null) {
                return ~i10;
            }
            dVar.z(map.get(str));
            return i10 + str.length();
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(a(j10 - i10, dateTimeZone, locale));
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class k implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final String f52568b;

        /* renamed from: c, reason: collision with root package name */
        public final String f52569c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f52570d;

        /* renamed from: e, reason: collision with root package name */
        public final int f52571e;

        /* renamed from: f, reason: collision with root package name */
        public final int f52572f;

        public k(String str, String str2, boolean z10, int i10, int i11) {
            this.f52568b = str;
            this.f52569c = str2;
            this.f52570d = z10;
            if (i10 > 0 && i11 >= i10) {
                if (i10 > 4) {
                    i10 = 4;
                    i11 = 4;
                }
                this.f52571e = i10;
                this.f52572f = i11;
                return;
            }
            throw new IllegalArgumentException();
        }

        public final int a(CharSequence charSequence, int i10, int i11) {
            int i12 = 0;
            for (int min = Math.min(charSequence.length() - i10, i11); min > 0; min--) {
                char charAt = charSequence.charAt(i10 + i12);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i12++;
            }
            return i12;
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            int i10 = this.f52571e;
            int i11 = (i10 + 1) << 1;
            if (this.f52570d) {
                i11 += i10 - 1;
            }
            String str = this.f52568b;
            return (str == null || str.length() <= i11) ? i11 : this.f52568b.length();
        }

        /* JADX WARN: Code restructure failed: missing block: B:84:0x0080, code lost:
        
            if (r6 <= '9') goto L43;
         */
        @Override // org.joda.time.format.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parseInto(org.joda.time.format.d r12, java.lang.CharSequence r13, int r14) {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.k.parseInto(org.joda.time.format.d, java.lang.CharSequence, int):int");
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            String str;
            if (dateTimeZone == null) {
                return;
            }
            if (i10 == 0 && (str = this.f52568b) != null) {
                appendable.append(str);
                return;
            }
            if (i10 >= 0) {
                appendable.append('+');
            } else {
                appendable.append('-');
                i10 = -i10;
            }
            int i11 = i10 / 3600000;
            org.joda.time.format.h.a(appendable, i11, 2);
            if (this.f52572f == 1) {
                return;
            }
            int i12 = i10 - (i11 * 3600000);
            if (i12 != 0 || this.f52571e > 1) {
                int i13 = i12 / 60000;
                if (this.f52570d) {
                    appendable.append(ShortcutConstants.SERVICES_SEPARATOR);
                }
                org.joda.time.format.h.a(appendable, i13, 2);
                if (this.f52572f == 2) {
                    return;
                }
                int i14 = i12 - (i13 * 60000);
                if (i14 != 0 || this.f52571e > 2) {
                    int i15 = i14 / 1000;
                    if (this.f52570d) {
                        appendable.append(ShortcutConstants.SERVICES_SEPARATOR);
                    }
                    org.joda.time.format.h.a(appendable, i15, 2);
                    if (this.f52572f == 3) {
                        return;
                    }
                    int i16 = i14 - (i15 * 1000);
                    if (i16 != 0 || this.f52571e > 3) {
                        if (this.f52570d) {
                            appendable.append('.');
                        }
                        org.joda.time.format.h.a(appendable, i16, 3);
                    }
                }
            }
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
        }
    }

    public static void Q(Appendable appendable, int i10) throws IOException {
        while (true) {
            i10--;
            if (i10 < 0) {
                return;
            } else {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }
    }

    public static boolean Y(CharSequence charSequence, int i10, String str) {
        int length = str.length();
        if (charSequence.length() - i10 < length) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (charSequence.charAt(i10 + i11) != str.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean Z(CharSequence charSequence, int i10, String str) {
        char upperCase;
        char upperCase2;
        int length = str.length();
        if (charSequence.length() - i10 < length) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = charSequence.charAt(i10 + i11);
            char charAt2 = str.charAt(i11);
            if (charAt != charAt2 && (upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
        }
        return true;
    }

    public DateTimeFormatterBuilder A(int i10) {
        return n(DateTimeFieldType.minuteOfHour(), i10, 2);
    }

    public DateTimeFormatterBuilder B(int i10) {
        return n(DateTimeFieldType.monthOfYear(), i10, 2);
    }

    public DateTimeFormatterBuilder C() {
        return G(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder D() {
        return I(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder E(org.joda.time.format.c cVar) {
        W(cVar);
        return e(null, new e(new org.joda.time.format.k[]{org.joda.time.format.e.b(cVar), null}));
    }

    public DateTimeFormatterBuilder F(int i10) {
        return n(DateTimeFieldType.secondOfMinute(), i10, 2);
    }

    public DateTimeFormatterBuilder G(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return d(new i(dateTimeFieldType, true));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder H(DateTimeFieldType dateTimeFieldType, int i10, int i11) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i11 < i10) {
            i11 = i10;
        }
        if (i10 < 0 || i11 <= 0) {
            throw new IllegalArgumentException();
        }
        if (i10 <= 1) {
            return d(new m(dateTimeFieldType, i11, true));
        }
        return d(new g(dateTimeFieldType, i11, true, i10));
    }

    public DateTimeFormatterBuilder I(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return d(new i(dateTimeFieldType, false));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder J() {
        TimeZoneId timeZoneId = TimeZoneId.INSTANCE;
        return e(timeZoneId, timeZoneId);
    }

    public DateTimeFormatterBuilder K() {
        return e(new j(0, null), null);
    }

    public DateTimeFormatterBuilder L(String str, String str2, boolean z10, int i10, int i11) {
        return d(new k(str, str2, z10, i10, i11));
    }

    public DateTimeFormatterBuilder M(String str, boolean z10, int i10, int i11) {
        return d(new k(str, str, z10, i10, i11));
    }

    public DateTimeFormatterBuilder N(Map<String, DateTimeZone> map) {
        j jVar = new j(1, map);
        return e(jVar, jVar);
    }

    public DateTimeFormatterBuilder O(int i10, boolean z10) {
        return d(new l(DateTimeFieldType.weekyear(), i10, z10));
    }

    public DateTimeFormatterBuilder P(int i10, boolean z10) {
        return d(new l(DateTimeFieldType.year(), i10, z10));
    }

    public DateTimeFormatterBuilder R(int i10) {
        return n(DateTimeFieldType.weekOfWeekyear(), i10, 2);
    }

    public DateTimeFormatterBuilder S(int i10, int i11) {
        return H(DateTimeFieldType.weekyear(), i10, i11);
    }

    public DateTimeFormatterBuilder T(int i10, int i11) {
        return H(DateTimeFieldType.year(), i10, i11);
    }

    public DateTimeFormatterBuilder U(int i10, int i11) {
        return n(DateTimeFieldType.yearOfEra(), i10, i11);
    }

    public boolean V() {
        return b0(a0());
    }

    public final void W(org.joda.time.format.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    public final void X(org.joda.time.format.f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    public DateTimeFormatterBuilder a(org.joda.time.format.b bVar) {
        if (bVar != null) {
            return e(bVar.d(), bVar.c());
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public final Object a0() {
        Object obj = this.f52547b;
        if (obj == null) {
            if (this.f52546a.size() == 2) {
                Object obj2 = this.f52546a.get(0);
                Object obj3 = this.f52546a.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new b(this.f52546a);
            }
            this.f52547b = obj;
        }
        return obj;
    }

    public DateTimeFormatterBuilder b(org.joda.time.format.c cVar) {
        W(cVar);
        return e(null, org.joda.time.format.e.b(cVar));
    }

    public final boolean b0(Object obj) {
        return d0(obj) || c0(obj);
    }

    public DateTimeFormatterBuilder c(org.joda.time.format.f fVar, org.joda.time.format.c[] cVarArr) {
        if (fVar != null) {
            X(fVar);
        }
        if (cVarArr != null) {
            int length = cVarArr.length;
            int i10 = 0;
            if (length == 1) {
                if (cVarArr[0] != null) {
                    return e(org.joda.time.format.g.a(fVar), org.joda.time.format.e.b(cVarArr[0]));
                }
                throw new IllegalArgumentException("No parser supplied");
            }
            org.joda.time.format.k[] kVarArr = new org.joda.time.format.k[length];
            while (i10 < length - 1) {
                org.joda.time.format.k b4 = org.joda.time.format.e.b(cVarArr[i10]);
                kVarArr[i10] = b4;
                if (b4 == null) {
                    throw new IllegalArgumentException("Incomplete parser array");
                }
                i10++;
            }
            kVarArr[i10] = org.joda.time.format.e.b(cVarArr[i10]);
            return e(org.joda.time.format.g.a(fVar), new e(kVarArr));
        }
        throw new IllegalArgumentException("No parsers supplied");
    }

    public final boolean c0(Object obj) {
        if (!(obj instanceof org.joda.time.format.k)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).c();
        }
        return true;
    }

    public final DateTimeFormatterBuilder d(Object obj) {
        this.f52547b = null;
        this.f52546a.add(obj);
        this.f52546a.add(obj);
        return this;
    }

    public final boolean d0(Object obj) {
        if (!(obj instanceof org.joda.time.format.m)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).d();
        }
        return true;
    }

    public final DateTimeFormatterBuilder e(org.joda.time.format.m mVar, org.joda.time.format.k kVar) {
        this.f52547b = null;
        this.f52546a.add(mVar);
        this.f52546a.add(kVar);
        return this;
    }

    public org.joda.time.format.b e0() {
        Object a02 = a0();
        org.joda.time.format.m mVar = d0(a02) ? (org.joda.time.format.m) a02 : null;
        org.joda.time.format.k kVar = c0(a02) ? (org.joda.time.format.k) a02 : null;
        if (mVar == null && kVar == null) {
            throw new UnsupportedOperationException("Both printing and parsing not supported");
        }
        return new org.joda.time.format.b(mVar, kVar);
    }

    public DateTimeFormatterBuilder f(int i10, int i11) {
        return H(DateTimeFieldType.centuryOfEra(), i10, i11);
    }

    public org.joda.time.format.c f0() {
        Object a02 = a0();
        if (c0(a02)) {
            return org.joda.time.format.l.b((org.joda.time.format.k) a02);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public DateTimeFormatterBuilder g(int i10) {
        return n(DateTimeFieldType.clockhourOfDay(), i10, 2);
    }

    public DateTimeFormatterBuilder h(int i10) {
        return n(DateTimeFieldType.clockhourOfHalfday(), i10, 2);
    }

    public DateTimeFormatterBuilder i(int i10) {
        return n(DateTimeFieldType.dayOfMonth(), i10, 2);
    }

    public DateTimeFormatterBuilder j(int i10) {
        return n(DateTimeFieldType.dayOfWeek(), i10, 1);
    }

    public DateTimeFormatterBuilder k() {
        return G(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder l() {
        return I(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder m(int i10) {
        return n(DateTimeFieldType.dayOfYear(), i10, 3);
    }

    public DateTimeFormatterBuilder n(DateTimeFieldType dateTimeFieldType, int i10, int i11) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i11 < i10) {
            i11 = i10;
        }
        if (i10 < 0 || i11 <= 0) {
            throw new IllegalArgumentException();
        }
        if (i10 <= 1) {
            return d(new m(dateTimeFieldType, i11, false));
        }
        return d(new g(dateTimeFieldType, i11, false, i10));
    }

    public DateTimeFormatterBuilder o() {
        return I(DateTimeFieldType.era());
    }

    public DateTimeFormatterBuilder p(DateTimeFieldType dateTimeFieldType, int i10) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i10 > 0) {
            return d(new c(dateTimeFieldType, i10, false));
        }
        throw new IllegalArgumentException("Illegal number of digits: " + i10);
    }

    public DateTimeFormatterBuilder q(DateTimeFieldType dateTimeFieldType, int i10, int i11) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i11 < i10) {
            i11 = i10;
        }
        if (i10 >= 0 && i11 > 0) {
            return d(new d(dateTimeFieldType, i10, i11));
        }
        throw new IllegalArgumentException();
    }

    public DateTimeFormatterBuilder r(int i10, int i11) {
        return q(DateTimeFieldType.hourOfDay(), i10, i11);
    }

    public DateTimeFormatterBuilder s(int i10, int i11) {
        return q(DateTimeFieldType.minuteOfDay(), i10, i11);
    }

    public DateTimeFormatterBuilder t(int i10, int i11) {
        return q(DateTimeFieldType.secondOfDay(), i10, i11);
    }

    public DateTimeFormatterBuilder u() {
        return I(DateTimeFieldType.halfdayOfDay());
    }

    public DateTimeFormatterBuilder v(int i10) {
        return n(DateTimeFieldType.hourOfDay(), i10, 2);
    }

    public DateTimeFormatterBuilder w(int i10) {
        return n(DateTimeFieldType.hourOfHalfday(), i10, 2);
    }

    public DateTimeFormatterBuilder x(char c4) {
        return d(new a(c4));
    }

    public DateTimeFormatterBuilder y(String str) {
        if (str != null) {
            int length = str.length();
            if (length == 0) {
                return this;
            }
            if (length != 1) {
                return d(new h(str));
            }
            return d(new a(str.charAt(0)));
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public DateTimeFormatterBuilder z(int i10) {
        return n(DateTimeFieldType.millisOfSecond(), i10, 3);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class i implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: d, reason: collision with root package name */
        public static Map<Locale, Map<DateTimeFieldType, Object[]>> f52563d = new ConcurrentHashMap();

        /* renamed from: b, reason: collision with root package name */
        public final DateTimeFieldType f52564b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f52565c;

        public i(DateTimeFieldType dateTimeFieldType, boolean z10) {
            this.f52564b = dateTimeFieldType;
            this.f52565c = z10;
        }

        public final String a(long j10, org.joda.time.a aVar, Locale locale) {
            org.joda.time.b field = this.f52564b.getField(aVar);
            if (this.f52565c) {
                return field.getAsShortText(j10, locale);
            }
            return field.getAsText(j10, locale);
        }

        public final String b(org.joda.time.k kVar, Locale locale) {
            if (!kVar.isSupported(this.f52564b)) {
                return "�";
            }
            org.joda.time.b field = this.f52564b.getField(kVar.getChronology());
            if (this.f52565c) {
                return field.getAsShortText(kVar, locale);
            }
            return field.getAsText(kVar, locale);
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52565c ? 6 : 20;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            int intValue;
            Map map;
            Locale o10 = dVar.o();
            Map<DateTimeFieldType, Object[]> map2 = f52563d.get(o10);
            if (map2 == null) {
                map2 = new ConcurrentHashMap<>();
                f52563d.put(o10, map2);
            }
            Object[] objArr = map2.get(this.f52564b);
            if (objArr == null) {
                map = new ConcurrentHashMap(32);
                MutableDateTime.Property property = new MutableDateTime(0L, DateTimeZone.UTC).property(this.f52564b);
                int minimumValueOverall = property.getMinimumValueOverall();
                int maximumValueOverall = property.getMaximumValueOverall();
                if (maximumValueOverall - minimumValueOverall > 32) {
                    return ~i10;
                }
                intValue = property.getMaximumTextLength(o10);
                while (minimumValueOverall <= maximumValueOverall) {
                    property.set(minimumValueOverall);
                    String asShortText = property.getAsShortText(o10);
                    Boolean bool = Boolean.TRUE;
                    map.put(asShortText, bool);
                    map.put(property.getAsShortText(o10).toLowerCase(o10), bool);
                    map.put(property.getAsShortText(o10).toUpperCase(o10), bool);
                    map.put(property.getAsText(o10), bool);
                    map.put(property.getAsText(o10).toLowerCase(o10), bool);
                    map.put(property.getAsText(o10).toUpperCase(o10), bool);
                    minimumValueOverall++;
                }
                if ("en".equals(o10.getLanguage()) && this.f52564b == DateTimeFieldType.era()) {
                    Boolean bool2 = Boolean.TRUE;
                    map.put("BCE", bool2);
                    map.put("bce", bool2);
                    map.put("CE", bool2);
                    map.put("ce", bool2);
                    intValue = 3;
                }
                map2.put(this.f52564b, new Object[]{map, Integer.valueOf(intValue)});
            } else {
                Map map3 = (Map) objArr[0];
                intValue = ((Integer) objArr[1]).intValue();
                map = map3;
            }
            for (int min = Math.min(charSequence.length(), intValue + i10); min > i10; min--) {
                String charSequence2 = charSequence.subSequence(i10, min).toString();
                if (map.containsKey(charSequence2)) {
                    dVar.w(this.f52564b, charSequence2, o10);
                    return min;
                }
            }
            return ~i10;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                appendable.append(a(j10, aVar, locale));
            } catch (RuntimeException unused) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            try {
                appendable.append(b(kVar, locale));
            } catch (RuntimeException unused) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class g extends f {

        /* renamed from: e, reason: collision with root package name */
        public final int f52561e;

        public g(DateTimeFieldType dateTimeFieldType, int i10, boolean z10, int i11) {
            super(dateTimeFieldType, i10, z10);
            this.f52561e = i11;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52559c;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                org.joda.time.format.h.a(appendable, this.f52558b.getField(aVar).get(j10), this.f52561e);
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.Q(appendable, this.f52561e);
            }
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            if (kVar.isSupported(this.f52558b)) {
                try {
                    org.joda.time.format.h.a(appendable, kVar.get(this.f52558b), this.f52561e);
                    return;
                } catch (RuntimeException unused) {
                    DateTimeFormatterBuilder.Q(appendable, this.f52561e);
                    return;
                }
            }
            DateTimeFormatterBuilder.Q(appendable, this.f52561e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class m extends f {
        public m(DateTimeFieldType dateTimeFieldType, int i10, boolean z10) {
            super(dateTimeFieldType, i10, z10);
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52559c;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                org.joda.time.format.h.c(appendable, this.f52558b.getField(aVar).get(j10));
            } catch (RuntimeException unused) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            }
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            if (kVar.isSupported(this.f52558b)) {
                try {
                    org.joda.time.format.h.c(appendable, kVar.get(this.f52558b));
                    return;
                } catch (RuntimeException unused) {
                    appendable.append(Utf8.REPLACEMENT_CHARACTER);
                    return;
                }
            }
            appendable.append(Utf8.REPLACEMENT_CHARACTER);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class l implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final DateTimeFieldType f52573b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52574c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f52575d;

        public l(DateTimeFieldType dateTimeFieldType, int i10, boolean z10) {
            this.f52573b = dateTimeFieldType;
            this.f52574c = i10;
            this.f52575d = z10;
        }

        public final int a(long j10, org.joda.time.a aVar) {
            try {
                int i10 = this.f52573b.getField(aVar).get(j10);
                if (i10 < 0) {
                    i10 = -i10;
                }
                return i10 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public final int b(org.joda.time.k kVar) {
            if (!kVar.isSupported(this.f52573b)) {
                return -1;
            }
            try {
                int i10 = kVar.get(this.f52573b);
                if (i10 < 0) {
                    i10 = -i10;
                }
                return i10 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52575d ? 4 : 2;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return 2;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            int i11;
            int i12;
            int i13;
            int length = charSequence.length() - i10;
            if (this.f52575d) {
                int i14 = 0;
                boolean z10 = false;
                boolean z11 = false;
                while (i14 < length) {
                    char charAt = charSequence.charAt(i10 + i14);
                    if (i14 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i14++;
                    } else {
                        z11 = charAt == '-';
                        if (z11) {
                            i14++;
                        } else {
                            i10++;
                            length--;
                        }
                        z10 = true;
                    }
                }
                if (i14 == 0) {
                    return ~i10;
                }
                if (z10 || i14 != 2) {
                    if (i14 >= 9) {
                        i11 = i14 + i10;
                        i12 = Integer.parseInt(charSequence.subSequence(i10, i11).toString());
                    } else {
                        int i15 = z11 ? i10 + 1 : i10;
                        int i16 = i15 + 1;
                        try {
                            int charAt2 = charSequence.charAt(i15) - '0';
                            i11 = i14 + i10;
                            while (i16 < i11) {
                                int charAt3 = (((charAt2 << 3) + (charAt2 << 1)) + charSequence.charAt(i16)) - 48;
                                i16++;
                                charAt2 = charAt3;
                            }
                            i12 = z11 ? -charAt2 : charAt2;
                        } catch (StringIndexOutOfBoundsException unused) {
                            return ~i10;
                        }
                    }
                    dVar.v(this.f52573b, i12);
                    return i11;
                }
            } else if (Math.min(2, length) < 2) {
                return ~i10;
            }
            char charAt4 = charSequence.charAt(i10);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i10;
            }
            int i17 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i10 + 1);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i10;
            }
            int i18 = (((i17 << 3) + (i17 << 1)) + charAt5) - 48;
            int i19 = this.f52574c;
            if (dVar.q() != null) {
                i19 = dVar.q().intValue();
            }
            int i20 = i19 - 50;
            if (i20 >= 0) {
                i13 = i20 % 100;
            } else {
                i13 = ((i20 + 1) % 100) + 99;
            }
            dVar.v(this.f52573b, i18 + ((i20 + (i18 < i13 ? 100 : 0)) - i13));
            return i10 + 2;
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int a10 = a(j10, aVar);
            if (a10 < 0) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            } else {
                org.joda.time.format.h.a(appendable, a10, 2);
            }
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            int b4 = b(kVar);
            if (b4 < 0) {
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
                appendable.append(Utf8.REPLACEMENT_CHARACTER);
            } else {
                org.joda.time.format.h.a(appendable, b4, 2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b implements org.joda.time.format.m, org.joda.time.format.k {

        /* renamed from: b, reason: collision with root package name */
        public final org.joda.time.format.m[] f52549b;

        /* renamed from: c, reason: collision with root package name */
        public final org.joda.time.format.k[] f52550c;

        /* renamed from: d, reason: collision with root package name */
        public final int f52551d;

        /* renamed from: e, reason: collision with root package name */
        public final int f52552e;

        public b(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            b(list, arrayList, arrayList2);
            if (!arrayList.contains(null) && !arrayList.isEmpty()) {
                int size = arrayList.size();
                this.f52549b = new org.joda.time.format.m[size];
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    org.joda.time.format.m mVar = (org.joda.time.format.m) arrayList.get(i11);
                    i10 += mVar.estimatePrintedLength();
                    this.f52549b[i11] = mVar;
                }
                this.f52551d = i10;
            } else {
                this.f52549b = null;
                this.f52551d = 0;
            }
            if (!arrayList2.contains(null) && !arrayList2.isEmpty()) {
                int size2 = arrayList2.size();
                this.f52550c = new org.joda.time.format.k[size2];
                int i12 = 0;
                for (int i13 = 0; i13 < size2; i13++) {
                    org.joda.time.format.k kVar = (org.joda.time.format.k) arrayList2.get(i13);
                    i12 += kVar.estimateParsedLength();
                    this.f52550c[i13] = kVar;
                }
                this.f52552e = i12;
                return;
            }
            this.f52550c = null;
            this.f52552e = 0;
        }

        public final void a(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }

        public final void b(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10 += 2) {
                Object obj = list.get(i10);
                if (obj instanceof b) {
                    a(list2, ((b) obj).f52549b);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i10 + 1);
                if (obj2 instanceof b) {
                    a(list3, ((b) obj2).f52550c);
                } else {
                    list3.add(obj2);
                }
            }
        }

        public boolean c() {
            return this.f52550c != null;
        }

        public boolean d() {
            return this.f52549b != null;
        }

        @Override // org.joda.time.format.k
        public int estimateParsedLength() {
            return this.f52552e;
        }

        @Override // org.joda.time.format.m
        public int estimatePrintedLength() {
            return this.f52551d;
        }

        @Override // org.joda.time.format.k
        public int parseInto(org.joda.time.format.d dVar, CharSequence charSequence, int i10) {
            org.joda.time.format.k[] kVarArr = this.f52550c;
            if (kVarArr != null) {
                int length = kVarArr.length;
                for (int i11 = 0; i11 < length && i10 >= 0; i11++) {
                    i10 = kVarArr[i11].parseInto(dVar, charSequence, i10);
                }
                return i10;
            }
            throw new UnsupportedOperationException();
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            org.joda.time.format.m[] mVarArr = this.f52549b;
            if (mVarArr != null) {
                Locale locale2 = locale == null ? Locale.getDefault() : locale;
                for (org.joda.time.format.m mVar : mVarArr) {
                    mVar.printTo(appendable, j10, aVar, i10, dateTimeZone, locale2);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }

        @Override // org.joda.time.format.m
        public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
            org.joda.time.format.m[] mVarArr = this.f52549b;
            if (mVarArr != null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                for (org.joda.time.format.m mVar : mVarArr) {
                    mVar.printTo(appendable, kVar, locale);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }
    }
}
