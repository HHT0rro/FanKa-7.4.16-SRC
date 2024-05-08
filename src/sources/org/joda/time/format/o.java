package org.joda.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;

/* compiled from: PeriodFormatterBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o {

    /* renamed from: j, reason: collision with root package name */
    public static final ConcurrentMap<String, Pattern> f52650j = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f52651a;

    /* renamed from: b, reason: collision with root package name */
    public int f52652b;

    /* renamed from: c, reason: collision with root package name */
    public int f52653c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f52654d;

    /* renamed from: e, reason: collision with root package name */
    public f f52655e;

    /* renamed from: f, reason: collision with root package name */
    public List<Object> f52656f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f52657g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f52658h;

    /* renamed from: i, reason: collision with root package name */
    public c[] f52659i;

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements q, p {

        /* renamed from: a, reason: collision with root package name */
        public final q[] f52660a;

        /* renamed from: b, reason: collision with root package name */
        public final p[] f52661b;

        public a(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            f(list, arrayList, arrayList2);
            if (arrayList.size() <= 0) {
                this.f52660a = null;
            } else {
                this.f52660a = (q[]) arrayList.toArray(new q[arrayList.size()]);
            }
            if (arrayList2.size() <= 0) {
                this.f52661b = null;
            } else {
                this.f52661b = (p[]) arrayList2.toArray(new p[arrayList2.size()]);
            }
        }

        @Override // org.joda.time.format.q
        public int a(org.joda.time.l lVar, int i10, Locale locale) {
            q[] qVarArr = this.f52660a;
            int length = qVarArr.length;
            int i11 = 0;
            while (i11 < i10) {
                length--;
                if (length < 0) {
                    break;
                }
                i11 += qVarArr[length].a(lVar, Integer.MAX_VALUE, locale);
            }
            return i11;
        }

        @Override // org.joda.time.format.q
        public void b(StringBuffer stringBuffer, org.joda.time.l lVar, Locale locale) {
            for (q qVar : this.f52660a) {
                qVar.b(stringBuffer, lVar, locale);
            }
        }

        @Override // org.joda.time.format.p
        public int c(org.joda.time.f fVar, String str, int i10, Locale locale) {
            p[] pVarArr = this.f52661b;
            if (pVarArr != null) {
                int length = pVarArr.length;
                for (int i11 = 0; i11 < length && i10 >= 0; i11++) {
                    i10 = pVarArr[i11].c(fVar, str, i10, locale);
                }
                return i10;
            }
            throw new UnsupportedOperationException();
        }

        @Override // org.joda.time.format.q
        public int d(org.joda.time.l lVar, Locale locale) {
            q[] qVarArr = this.f52660a;
            int length = qVarArr.length;
            int i10 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i10;
                }
                i10 += qVarArr[length].d(lVar, locale);
            }
        }

        public final void e(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }

        public final void f(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10 += 2) {
                Object obj = list.get(i10);
                if (obj instanceof q) {
                    if (obj instanceof a) {
                        e(list2, ((a) obj).f52660a);
                    } else {
                        list2.add(obj);
                    }
                }
                Object obj2 = list.get(i10 + 1);
                if (obj2 instanceof p) {
                    if (obj2 instanceof a) {
                        e(list3, ((a) obj2).f52661b);
                    } else {
                        list3.add(obj2);
                    }
                }
            }
        }
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b extends d {

        /* renamed from: b, reason: collision with root package name */
        public final f f52662b;

        /* renamed from: c, reason: collision with root package name */
        public final f f52663c;

        /* renamed from: d, reason: collision with root package name */
        public final String[] f52664d;

        public b(f fVar, f fVar2) {
            this.f52662b = fVar;
            this.f52663c = fVar2;
            HashSet hashSet = new HashSet();
            for (String str : fVar.e()) {
                for (String str2 : this.f52663c.e()) {
                    hashSet.add(str + str2);
                }
            }
            this.f52664d = (String[]) hashSet.toArray(new String[hashSet.size()]);
        }

        @Override // org.joda.time.format.o.f
        public int a(String str, int i10) {
            int a10;
            int a11 = this.f52662b.a(str, i10);
            return (a11 < 0 || ((a10 = this.f52663c.a(str, this.f52662b.b(str, a11))) >= 0 && g(this.f52663c.b(str, a10) - a11, str, i10))) ? ~i10 : a11 > 0 ? a11 : a10;
        }

        @Override // org.joda.time.format.o.f
        public int b(String str, int i10) {
            int b4 = this.f52662b.b(str, i10);
            return (b4 < 0 || (b4 = this.f52663c.b(str, b4)) < 0 || !g(b(str, b4) - b4, str, i10)) ? b4 : ~i10;
        }

        @Override // org.joda.time.format.o.f
        public void c(StringBuffer stringBuffer, int i10) {
            this.f52662b.c(stringBuffer, i10);
            this.f52663c.c(stringBuffer, i10);
        }

        @Override // org.joda.time.format.o.f
        public int d(int i10) {
            return this.f52662b.d(i10) + this.f52663c.d(i10);
        }

        @Override // org.joda.time.format.o.f
        public String[] e() {
            return (String[]) this.f52664d.clone();
        }
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class d implements f {

        /* renamed from: a, reason: collision with root package name */
        public volatile String[] f52673a;

        @Override // org.joda.time.format.o.f
        public void f(Set<f> set) {
            if (this.f52673a == null) {
                int i10 = Integer.MAX_VALUE;
                String str = null;
                for (String str2 : e()) {
                    if (str2.length() < i10) {
                        i10 = str2.length();
                        str = str2;
                    }
                }
                HashSet hashSet = new HashSet();
                for (f fVar : set) {
                    if (fVar != null) {
                        for (String str3 : fVar.e()) {
                            if (str3.length() > i10 || (str3.equalsIgnoreCase(str) && !str3.equals(str))) {
                                hashSet.add(str3);
                            }
                        }
                    }
                }
                this.f52673a = (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }

        public boolean g(int i10, String str, int i11) {
            if (this.f52673a != null) {
                for (String str2 : this.f52673a) {
                    int length = str2.length();
                    if (i10 < length && str.regionMatches(true, i11, str2, 0, length)) {
                        return true;
                    }
                    if (i10 == length && str.regionMatches(false, i11, str2, 0, length)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class e implements q, p {

        /* renamed from: b, reason: collision with root package name */
        public static final e f52674b = new e("");

        /* renamed from: a, reason: collision with root package name */
        public final String f52675a;

        public e(String str) {
            this.f52675a = str;
        }

        @Override // org.joda.time.format.q
        public int a(org.joda.time.l lVar, int i10, Locale locale) {
            return 0;
        }

        @Override // org.joda.time.format.q
        public void b(StringBuffer stringBuffer, org.joda.time.l lVar, Locale locale) {
            stringBuffer.append(this.f52675a);
        }

        @Override // org.joda.time.format.p
        public int c(org.joda.time.f fVar, String str, int i10, Locale locale) {
            String str2 = this.f52675a;
            return str.regionMatches(true, i10, str2, 0, str2.length()) ? i10 + this.f52675a.length() : ~i10;
        }

        @Override // org.joda.time.format.q
        public int d(org.joda.time.l lVar, Locale locale) {
            return this.f52675a.length();
        }
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface f {
        int a(String str, int i10);

        int b(String str, int i10);

        void c(StringBuffer stringBuffer, int i10);

        int d(int i10);

        String[] e();

        void f(Set<f> set);
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class g implements q, p {

        /* renamed from: a, reason: collision with root package name */
        public final String f52676a;

        /* renamed from: b, reason: collision with root package name */
        public final String f52677b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f52678c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f52679d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52680e;

        /* renamed from: f, reason: collision with root package name */
        public final q f52681f;

        /* renamed from: g, reason: collision with root package name */
        public volatile q f52682g;

        /* renamed from: h, reason: collision with root package name */
        public final p f52683h;

        /* renamed from: i, reason: collision with root package name */
        public volatile p f52684i;

        public g(String str, String str2, String[] strArr, q qVar, p pVar, boolean z10, boolean z11) {
            this.f52676a = str;
            this.f52677b = str2;
            if ((str2 != null && !str.equals(str2)) || (strArr != null && strArr.length != 0)) {
                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                treeSet.add(str);
                treeSet.add(str2);
                if (strArr != null) {
                    int length = strArr.length;
                    while (true) {
                        length--;
                        if (length < 0) {
                            break;
                        } else {
                            treeSet.add(strArr[length]);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList(treeSet);
                Collections.reverse(arrayList);
                this.f52678c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            } else {
                this.f52678c = new String[]{str};
            }
            this.f52681f = qVar;
            this.f52683h = pVar;
            this.f52679d = z10;
            this.f52680e = z11;
        }

        @Override // org.joda.time.format.q
        public int a(org.joda.time.l lVar, int i10, Locale locale) {
            int a10 = this.f52681f.a(lVar, i10, locale);
            return a10 < i10 ? a10 + this.f52682g.a(lVar, i10, locale) : a10;
        }

        @Override // org.joda.time.format.q
        public void b(StringBuffer stringBuffer, org.joda.time.l lVar, Locale locale) {
            q qVar = this.f52681f;
            q qVar2 = this.f52682g;
            qVar.b(stringBuffer, lVar, locale);
            if (this.f52679d) {
                if (qVar.a(lVar, 1, locale) > 0) {
                    if (this.f52680e) {
                        int a10 = qVar2.a(lVar, 2, locale);
                        if (a10 > 0) {
                            stringBuffer.append(a10 > 1 ? this.f52676a : this.f52677b);
                        }
                    } else {
                        stringBuffer.append(this.f52676a);
                    }
                }
            } else if (this.f52680e && qVar2.a(lVar, 1, locale) > 0) {
                stringBuffer.append(this.f52676a);
            }
            qVar2.b(stringBuffer, lVar, locale);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        
            r11 = 0;
         */
        @Override // org.joda.time.format.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int c(org.joda.time.f r18, java.lang.String r19, int r20, java.util.Locale r21) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r8 = r19
                r2 = r20
                r9 = r21
                org.joda.time.format.p r3 = r0.f52683h
                int r10 = r3.c(r1, r8, r2, r9)
                if (r10 >= 0) goto L13
                return r10
            L13:
                r11 = -1
                r12 = 0
                if (r10 <= r2) goto L47
                java.lang.String[] r13 = r0.f52678c
                int r14 = r13.length
                r15 = 0
            L1b:
                if (r15 >= r14) goto L47
                r16 = r13[r15]
                if (r16 == 0) goto L3c
                int r2 = r16.length()
                if (r2 == 0) goto L3c
                r3 = 1
                r6 = 0
                int r7 = r16.length()
                r2 = r19
                r4 = r10
                r5 = r16
                boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L39
                goto L3c
            L39:
                int r15 = r15 + 1
                goto L1b
            L3c:
                if (r16 != 0) goto L40
                r11 = 0
                goto L45
            L40:
                int r2 = r16.length()
                r11 = r2
            L45:
                int r10 = r10 + r11
                r12 = 1
            L47:
                org.joda.time.format.p r2 = r0.f52684i
                int r1 = r2.c(r1, r8, r10, r9)
                if (r1 >= 0) goto L50
                return r1
            L50:
                if (r12 == 0) goto L58
                if (r1 != r10) goto L58
                if (r11 <= 0) goto L58
                int r1 = ~r10
                return r1
            L58:
                if (r1 <= r10) goto L61
                if (r12 != 0) goto L61
                boolean r2 = r0.f52679d
                if (r2 != 0) goto L61
                int r1 = ~r10
            L61:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.o.g.c(org.joda.time.f, java.lang.String, int, java.util.Locale):int");
        }

        @Override // org.joda.time.format.q
        public int d(org.joda.time.l lVar, Locale locale) {
            int length;
            q qVar = this.f52681f;
            q qVar2 = this.f52682g;
            int d10 = qVar.d(lVar, locale) + qVar2.d(lVar, locale);
            if (this.f52679d) {
                if (qVar.a(lVar, 1, locale) <= 0) {
                    return d10;
                }
                if (this.f52680e) {
                    int a10 = qVar2.a(lVar, 2, locale);
                    if (a10 <= 0) {
                        return d10;
                    }
                    length = (a10 > 1 ? this.f52676a : this.f52677b).length();
                } else {
                    length = this.f52676a.length();
                }
            } else {
                if (!this.f52680e || qVar2.a(lVar, 1, locale) <= 0) {
                    return d10;
                }
                length = this.f52676a.length();
            }
            return d10 + length;
        }

        public g g(q qVar, p pVar) {
            this.f52682g = qVar;
            this.f52684i = pVar;
            return this;
        }
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class h extends d {

        /* renamed from: b, reason: collision with root package name */
        public final String f52685b;

        public h(String str) {
            this.f52685b = str;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0024. Please report as an issue. */
        @Override // org.joda.time.format.o.f
        public int a(String str, int i10) {
            String str2 = this.f52685b;
            int length = str2.length();
            int length2 = str.length();
            for (int i11 = i10; i11 < length2; i11++) {
                if (str.regionMatches(true, i11, str2, 0, length) && !g(length, str, i11)) {
                    return i11;
                }
                switch (str.charAt(i11)) {
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '/':
                    default:
                        return ~i10;
                }
            }
            return ~i10;
        }

        @Override // org.joda.time.format.o.f
        public int b(String str, int i10) {
            String str2 = this.f52685b;
            int length = str2.length();
            return (!str.regionMatches(true, i10, str2, 0, length) || g(length, str, i10)) ? ~i10 : i10 + length;
        }

        @Override // org.joda.time.format.o.f
        public void c(StringBuffer stringBuffer, int i10) {
            stringBuffer.append(this.f52685b);
        }

        @Override // org.joda.time.format.o.f
        public int d(int i10) {
            return this.f52685b.length();
        }

        @Override // org.joda.time.format.o.f
        public String[] e() {
            return new String[]{this.f52685b};
        }
    }

    public o() {
        p();
    }

    public static Object[] r(List<Object> list) {
        int size = list.size();
        if (size == 0) {
            e eVar = e.f52674b;
            return new Object[]{eVar, eVar};
        }
        if (size == 1) {
            return new Object[]{list.get(0), list.get(1)};
        }
        a aVar = new a(list);
        return new Object[]{aVar, aVar};
    }

    public static n t(List<Object> list, boolean z10, boolean z11) {
        if (z10 && z11) {
            throw new IllegalStateException("Builder has created neither a printer nor a parser");
        }
        int size = list.size();
        if (size >= 2 && (list.get(0) instanceof g)) {
            g gVar = (g) list.get(0);
            if (gVar.f52684i == null && gVar.f52682g == null) {
                n t2 = t(list.subList(2, size), z10, z11);
                g g3 = gVar.g(t2.e(), t2.d());
                return new n(g3, g3);
            }
        }
        Object[] r10 = r(list);
        if (z10) {
            return new n(null, (p) r10[1]);
        }
        if (z11) {
            return new n((q) r10[0], null);
        }
        return new n((q) r10[0], (p) r10[1]);
    }

    public final o a(q qVar, p pVar) {
        this.f52656f.add(qVar);
        this.f52656f.add(pVar);
        this.f52657g = (qVar == null) | this.f52657g;
        this.f52658h |= pVar == null;
        return this;
    }

    public o b() {
        c(3);
        return this;
    }

    public final void c(int i10) {
        d(i10, this.f52651a);
    }

    public final void d(int i10, int i11) {
        c cVar = new c(i11, this.f52652b, this.f52653c, this.f52654d, i10, this.f52659i, this.f52655e, null);
        a(cVar, cVar);
        this.f52659i[i10] = cVar;
        this.f52655e = null;
    }

    public o e() {
        c(4);
        return this;
    }

    public o f(String str) {
        if (str != null) {
            q();
            e eVar = new e(str);
            a(eVar, eVar);
            return this;
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public o g() {
        c(5);
        return this;
    }

    public o h() {
        c(1);
        return this;
    }

    public o i() {
        c(9);
        return this;
    }

    public final o j(String str, String str2, String[] strArr, boolean z10, boolean z11) {
        if (str != null && str2 != null) {
            q();
            List<Object> list = this.f52656f;
            if (list.size() == 0) {
                if (z11 && !z10) {
                    e eVar = e.f52674b;
                    g gVar = new g(str, str2, strArr, eVar, eVar, z10, z11);
                    a(gVar, gVar);
                }
                return this;
            }
            g gVar2 = null;
            int size = list.size();
            while (true) {
                int i10 = size - 1;
                if (i10 < 0) {
                    break;
                }
                if (list.get(i10) instanceof g) {
                    gVar2 = (g) list.get(i10);
                    list = list.subList(i10 + 1, list.size());
                    break;
                }
                size = i10 - 1;
            }
            List<Object> list2 = list;
            if (gVar2 != null && list2.size() == 0) {
                throw new IllegalStateException("Cannot have two adjacent separators");
            }
            Object[] r10 = r(list2);
            list2.clear();
            g gVar3 = new g(str, str2, strArr, (q) r10[0], (p) r10[1], z10, z11);
            list2.add(gVar3);
            list2.add(gVar3);
            return this;
        }
        throw new IllegalArgumentException();
    }

    public o k(String str) {
        return j(str, str, null, false, true);
    }

    public o l(String str) {
        if (str != null) {
            return m(new h(str));
        }
        throw new IllegalArgumentException();
    }

    public final o m(f fVar) {
        Object obj;
        Object obj2 = null;
        if (this.f52656f.size() > 0) {
            obj2 = this.f52656f.get(r0.size() - 2);
            obj = this.f52656f.get(r0.size() - 1);
        } else {
            obj = null;
        }
        if (obj2 != null && obj != null && obj2 == obj && (obj2 instanceof c)) {
            q();
            c cVar = new c((c) obj2, fVar);
            this.f52656f.set(r4.size() - 2, cVar);
            this.f52656f.set(r4.size() - 1, cVar);
            this.f52659i[cVar.f()] = cVar;
            return this;
        }
        throw new IllegalStateException("No field to apply suffix to");
    }

    public o n() {
        c(2);
        return this;
    }

    public o o() {
        c(0);
        return this;
    }

    public void p() {
        this.f52651a = 1;
        this.f52652b = 2;
        this.f52653c = 10;
        this.f52654d = false;
        this.f52655e = null;
        List<Object> list = this.f52656f;
        if (list == null) {
            this.f52656f = new ArrayList();
        } else {
            list.clear();
        }
        this.f52657g = false;
        this.f52658h = false;
        this.f52659i = new c[10];
    }

    public final void q() throws IllegalStateException {
        if (this.f52655e == null) {
            this.f52655e = null;
            return;
        }
        throw new IllegalStateException("Prefix not followed by field");
    }

    public n s() {
        n t2 = t(this.f52656f, this.f52657g, this.f52658h);
        for (c cVar : this.f52659i) {
            if (cVar != null) {
                cVar.e(this.f52659i);
            }
        }
        this.f52659i = (c[]) this.f52659i.clone();
        return t2;
    }

    /* compiled from: PeriodFormatterBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class c implements q, p {

        /* renamed from: a, reason: collision with root package name */
        public final int f52665a;

        /* renamed from: b, reason: collision with root package name */
        public final int f52666b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52667c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f52668d;

        /* renamed from: e, reason: collision with root package name */
        public final int f52669e;

        /* renamed from: f, reason: collision with root package name */
        public final c[] f52670f;

        /* renamed from: g, reason: collision with root package name */
        public final f f52671g;

        /* renamed from: h, reason: collision with root package name */
        public final f f52672h;

        public c(int i10, int i11, int i12, boolean z10, int i13, c[] cVarArr, f fVar, f fVar2) {
            this.f52665a = i10;
            this.f52666b = i11;
            this.f52667c = i12;
            this.f52668d = z10;
            this.f52669e = i13;
            this.f52670f = cVarArr;
            this.f52671g = fVar;
            this.f52672h = fVar2;
        }

        @Override // org.joda.time.format.q
        public int a(org.joda.time.l lVar, int i10, Locale locale) {
            if (i10 <= 0) {
                return 0;
            }
            return (this.f52666b == 4 || g(lVar) != Long.MAX_VALUE) ? 1 : 0;
        }

        @Override // org.joda.time.format.q
        public void b(StringBuffer stringBuffer, org.joda.time.l lVar, Locale locale) {
            long g3 = g(lVar);
            if (g3 == Long.MAX_VALUE) {
                return;
            }
            int i10 = (int) g3;
            if (this.f52669e >= 8) {
                i10 = (int) (g3 / 1000);
            }
            f fVar = this.f52671g;
            if (fVar != null) {
                fVar.c(stringBuffer, i10);
            }
            int length = stringBuffer.length();
            int i11 = this.f52665a;
            if (i11 <= 1) {
                org.joda.time.format.h.e(stringBuffer, i10);
            } else {
                org.joda.time.format.h.b(stringBuffer, i10, i11);
            }
            if (this.f52669e >= 8) {
                int abs = (int) (Math.abs(g3) % 1000);
                if (this.f52669e == 8 || abs > 0) {
                    if (g3 < 0 && g3 > -1000) {
                        stringBuffer.insert(length, '-');
                    }
                    stringBuffer.append('.');
                    org.joda.time.format.h.b(stringBuffer, abs, 3);
                }
            }
            f fVar2 = this.f52672h;
            if (fVar2 != null) {
                fVar2.c(stringBuffer, i10);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
        
            if (r15 > '9') goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d9, code lost:
        
            return ~r3;
         */
        @Override // org.joda.time.format.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int c(org.joda.time.f r17, java.lang.String r18, int r19, java.util.Locale r20) {
            /*
                Method dump skipped, instructions count: 319
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.o.c.c(org.joda.time.f, java.lang.String, int, java.util.Locale):int");
        }

        @Override // org.joda.time.format.q
        public int d(org.joda.time.l lVar, Locale locale) {
            long g3 = g(lVar);
            if (g3 == Long.MAX_VALUE) {
                return 0;
            }
            int max = Math.max(org.joda.time.format.h.g(g3), this.f52665a);
            if (this.f52669e >= 8) {
                max = Math.max(max, g3 < 0 ? 5 : 4) + 1;
                if (this.f52669e == 9 && Math.abs(g3) % 1000 == 0) {
                    max -= 4;
                }
                g3 /= 1000;
            }
            int i10 = (int) g3;
            f fVar = this.f52671g;
            if (fVar != null) {
                max += fVar.d(i10);
            }
            f fVar2 = this.f52672h;
            return fVar2 != null ? max + fVar2.d(i10) : max;
        }

        public void e(c[] cVarArr) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (c cVar : cVarArr) {
                if (cVar != null && !equals(cVar)) {
                    hashSet.add(cVar.f52671g);
                    hashSet2.add(cVar.f52672h);
                }
            }
            f fVar = this.f52671g;
            if (fVar != null) {
                fVar.f(hashSet);
            }
            f fVar2 = this.f52672h;
            if (fVar2 != null) {
                fVar2.f(hashSet2);
            }
        }

        public int f() {
            return this.f52669e;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:11:0x001d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long g(org.joda.time.l r10) {
            /*
                r9 = this;
                int r0 = r9.f52666b
                r1 = 4
                if (r0 != r1) goto L7
                r0 = 0
                goto Lb
            L7:
                org.joda.time.PeriodType r0 = r10.getPeriodType()
            Lb:
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                if (r0 == 0) goto L1b
                int r3 = r9.f52669e
                boolean r3 = r9.h(r0, r3)
                if (r3 != 0) goto L1b
                return r1
            L1b:
                int r3 = r9.f52669e
                switch(r3) {
                    case 0: goto L78;
                    case 1: goto L6f;
                    case 2: goto L66;
                    case 3: goto L5d;
                    case 4: goto L54;
                    case 5: goto L4b;
                    case 6: goto L42;
                    case 7: goto L39;
                    case 8: goto L21;
                    case 9: goto L21;
                    default: goto L20;
                }
            L20:
                return r1
            L21:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.seconds()
                int r3 = r10.get(r3)
                org.joda.time.DurationFieldType r4 = org.joda.time.DurationFieldType.millis()
                int r4 = r10.get(r4)
                long r5 = (long) r3
                r7 = 1000(0x3e8, double:4.94E-321)
                long r5 = r5 * r7
                long r3 = (long) r4
                long r5 = r5 + r3
                goto L81
            L39:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.millis()
                int r3 = r10.get(r3)
                goto L80
            L42:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.seconds()
                int r3 = r10.get(r3)
                goto L80
            L4b:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.minutes()
                int r3 = r10.get(r3)
                goto L80
            L54:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.hours()
                int r3 = r10.get(r3)
                goto L80
            L5d:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.days()
                int r3 = r10.get(r3)
                goto L80
            L66:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.weeks()
                int r3 = r10.get(r3)
                goto L80
            L6f:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.months()
                int r3 = r10.get(r3)
                goto L80
            L78:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.years()
                int r3 = r10.get(r3)
            L80:
                long r5 = (long) r3
            L81:
                r3 = 0
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 != 0) goto Ldf
                int r3 = r9.f52666b
                r4 = 9
                r7 = 1
                if (r3 == r7) goto Lb8
                r8 = 2
                if (r3 == r8) goto L96
                r10 = 5
                if (r3 == r10) goto L95
                goto Ldf
            L95:
                return r1
            L96:
                boolean r10 = r9.i(r10)
                if (r10 == 0) goto Lb7
                org.joda.time.format.o$c[] r10 = r9.f52670f
                int r3 = r9.f52669e
                r10 = r10[r3]
                if (r10 != r9) goto Lb7
                int r3 = r3 + r7
            La5:
                if (r3 > r4) goto Ldf
                boolean r10 = r9.h(r0, r3)
                if (r10 == 0) goto Lb4
                org.joda.time.format.o$c[] r10 = r9.f52670f
                r10 = r10[r3]
                if (r10 == 0) goto Lb4
                return r1
            Lb4:
                int r3 = r3 + 1
                goto La5
            Lb7:
                return r1
            Lb8:
                boolean r10 = r9.i(r10)
                if (r10 == 0) goto Lde
                org.joda.time.format.o$c[] r10 = r9.f52670f
                int r3 = r9.f52669e
                r10 = r10[r3]
                if (r10 != r9) goto Lde
                r10 = 8
                int r10 = java.lang.Math.min(r3, r10)
            Lcc:
                int r10 = r10 + (-1)
                if (r10 < 0) goto Ldf
                if (r10 > r4) goto Ldf
                boolean r3 = r9.h(r0, r10)
                if (r3 == 0) goto Lcc
                org.joda.time.format.o$c[] r3 = r9.f52670f
                r3 = r3[r10]
                if (r3 == 0) goto Lcc
            Lde:
                return r1
            Ldf:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.o.c.g(org.joda.time.l):long");
        }

        public boolean h(PeriodType periodType, int i10) {
            switch (i10) {
                case 0:
                    return periodType.isSupported(DurationFieldType.years());
                case 1:
                    return periodType.isSupported(DurationFieldType.months());
                case 2:
                    return periodType.isSupported(DurationFieldType.weeks());
                case 3:
                    return periodType.isSupported(DurationFieldType.days());
                case 4:
                    return periodType.isSupported(DurationFieldType.hours());
                case 5:
                    return periodType.isSupported(DurationFieldType.minutes());
                case 6:
                    return periodType.isSupported(DurationFieldType.seconds());
                case 7:
                    return periodType.isSupported(DurationFieldType.millis());
                case 8:
                case 9:
                    return periodType.isSupported(DurationFieldType.seconds()) || periodType.isSupported(DurationFieldType.millis());
                default:
                    return false;
            }
        }

        public boolean i(org.joda.time.l lVar) {
            int size = lVar.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (lVar.getValue(i10) != 0) {
                    return false;
                }
            }
            return true;
        }

        public final int j(String str, int i10, int i11) {
            if (i11 >= 10) {
                return Integer.parseInt(str.substring(i10, i11 + i10));
            }
            boolean z10 = false;
            if (i11 <= 0) {
                return 0;
            }
            int i12 = i10 + 1;
            char charAt = str.charAt(i10);
            int i13 = i11 - 1;
            if (charAt == '-') {
                i13--;
                if (i13 < 0) {
                    return 0;
                }
                char charAt2 = str.charAt(i12);
                i12++;
                charAt = charAt2;
                z10 = true;
            }
            int i14 = charAt - '0';
            while (true) {
                int i15 = i13 - 1;
                if (i13 <= 0) {
                    break;
                }
                int charAt3 = (((i14 << 3) + (i14 << 1)) + str.charAt(i12)) - 48;
                i12++;
                i14 = charAt3;
                i13 = i15;
            }
            return z10 ? -i14 : i14;
        }

        public void k(org.joda.time.f fVar, int i10, int i11) {
            switch (i10) {
                case 0:
                    fVar.setYears(i11);
                    return;
                case 1:
                    fVar.setMonths(i11);
                    return;
                case 2:
                    fVar.setWeeks(i11);
                    return;
                case 3:
                    fVar.setDays(i11);
                    return;
                case 4:
                    fVar.setHours(i11);
                    return;
                case 5:
                    fVar.setMinutes(i11);
                    return;
                case 6:
                    fVar.setSeconds(i11);
                    return;
                case 7:
                    fVar.setMillis(i11);
                    return;
                default:
                    return;
            }
        }

        public c(c cVar, f fVar) {
            this.f52665a = cVar.f52665a;
            this.f52666b = cVar.f52666b;
            this.f52667c = cVar.f52667c;
            this.f52668d = cVar.f52668d;
            this.f52669e = cVar.f52669e;
            this.f52670f = cVar.f52670f;
            this.f52671g = cVar.f52671g;
            f fVar2 = cVar.f52672h;
            this.f52672h = fVar2 != null ? new b(fVar2, fVar) : fVar;
        }
    }
}
