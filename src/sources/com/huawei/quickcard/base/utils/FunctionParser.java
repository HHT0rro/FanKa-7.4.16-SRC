package com.huawei.quickcard.base.utils;

import androidx.annotation.NonNull;
import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FunctionParser<K, V> {

    /* renamed from: c, reason: collision with root package name */
    private static final char f33387c = ' ';

    /* renamed from: a, reason: collision with root package name */
    private final Mapper<K, V> f33388a;

    /* renamed from: b, reason: collision with root package name */
    private final c f33389b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Mapper<K, V> {
        Map<K, V> map(String str, List<String> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends RuntimeException {
        private b(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c {

        /* renamed from: e, reason: collision with root package name */
        private static final String f33390e = "(";

        /* renamed from: f, reason: collision with root package name */
        private static final String f33391f = ")";

        /* renamed from: g, reason: collision with root package name */
        private static final String f33392g = ",";

        /* renamed from: h, reason: collision with root package name */
        private static final char f33393h = 'A';

        /* renamed from: i, reason: collision with root package name */
        private static final char f33394i = 'Z';

        /* renamed from: j, reason: collision with root package name */
        private static final char f33395j = 'a';

        /* renamed from: k, reason: collision with root package name */
        private static final char f33396k = 'z';

        /* renamed from: l, reason: collision with root package name */
        private static final char f33397l = '0';

        /* renamed from: m, reason: collision with root package name */
        private static final char f33398m = '9';

        /* renamed from: n, reason: collision with root package name */
        private static final char f33399n = '.';

        /* renamed from: o, reason: collision with root package name */
        private static final char f33400o = '-';

        /* renamed from: p, reason: collision with root package name */
        private static final char f33401p = '+';

        /* renamed from: q, reason: collision with root package name */
        private static final char f33402q = '%';

        /* renamed from: a, reason: collision with root package name */
        private final String f33403a;

        /* renamed from: b, reason: collision with root package name */
        private d f33404b;

        /* renamed from: c, reason: collision with root package name */
        private String f33405c;

        /* renamed from: d, reason: collision with root package name */
        private int f33406d;

        private boolean a(char c4) {
            return ('a' <= c4 && c4 <= 'z') || ('A' <= c4 && c4 <= 'Z') || c4 == '-';
        }

        private boolean b(char c4) {
            return ('0' <= c4 && c4 <= '9') || ('a' <= c4 && c4 <= 'z') || ('A' <= c4 && c4 <= 'Z');
        }

        private c(String str) {
            this.f33406d = 0;
            this.f33403a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public d a() {
            return this.f33404b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f33405c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0052, code lost:
        
            r2 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean c() {
            /*
                r7 = this;
                int r0 = r7.f33406d
                r1 = 0
                r2 = 0
            L4:
                int r3 = r7.f33406d
                java.lang.String r4 = r7.f33403a
                int r4 = r4.length()
                r5 = 1
                if (r3 >= r4) goto L5e
                java.lang.String r3 = r7.f33403a
                int r4 = r7.f33406d
                char r3 = r3.charAt(r4)
                r4 = 32
                r6 = 34
                if (r3 == r4) goto L50
                r4 = 123(0x7b, float:1.72E-43)
                if (r3 == r4) goto L50
                if (r3 != r6) goto L26
                if (r2 != 0) goto L26
                goto L50
            L26:
                boolean r4 = r7.b(r3)
                if (r4 != 0) goto L3f
                r4 = 46
                if (r3 == r4) goto L3f
                r4 = 37
                if (r3 == r4) goto L3f
                r4 = 45
                if (r3 == r4) goto L3f
                r4 = 43
                if (r3 != r4) goto L3d
                goto L3f
            L3d:
                r3 = 0
                goto L40
            L3f:
                r3 = 1
            L40:
                if (r3 == 0) goto L48
                int r3 = r7.f33406d
                int r3 = r3 + r5
                r7.f33406d = r3
                goto L4
            L48:
                int r2 = r7.f33406d
                if (r0 != r2) goto L5e
                int r2 = r2 + r5
                r7.f33406d = r2
                goto L5e
            L50:
                if (r3 != r6) goto L53
                r2 = 1
            L53:
                int r3 = r7.f33406d
                int r4 = r3 + 1
                r7.f33406d = r4
                if (r0 != r3) goto L5e
                int r0 = r0 + 1
                goto L4
            L5e:
                int r2 = r7.f33406d
                if (r0 == r2) goto L6c
                java.lang.String r1 = r7.f33403a
                java.lang.String r0 = r1.substring(r0, r2)
                r7.a(r0)
                return r5
            L6c:
                r0 = 0
                r7.f33404b = r0
                r7.f33405c = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.base.utils.FunctionParser.c.c():boolean");
        }

        private void a(String str) {
            if (f33390e.equals(str)) {
                this.f33404b = d.LEFT_PARENT;
                this.f33405c = f33390e;
                return;
            }
            if (f33391f.equals(str)) {
                this.f33404b = d.RIGHT_PARENT;
                this.f33405c = f33391f;
                return;
            }
            if (",".equals(str)) {
                this.f33404b = d.COMMA;
                this.f33405c = ",";
                return;
            }
            if (u.bD.equals(str)) {
                this.f33404b = d.LEFT_PARENT;
                this.f33405c = f33390e;
            } else if (i.f4738d.equals(str)) {
                this.f33404b = d.RIGHT_PARENT;
                this.f33405c = f33391f;
            } else if (a((CharSequence) str)) {
                this.f33404b = d.FUNC_NAME;
                this.f33405c = str;
            } else {
                this.f33404b = d.PARAM_VALUE;
                this.f33405c = str;
            }
        }

        private boolean a(CharSequence charSequence) {
            for (int i10 = 0; i10 < charSequence.length(); i10++) {
                if (!a(charSequence.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum d {
        FUNC_NAME,
        PARAM_VALUE,
        LEFT_PARENT,
        RIGHT_PARENT,
        COMMA
    }

    public FunctionParser(@NonNull String str, @NonNull Mapper<K, V> mapper) {
        this.f33389b = new c(str);
        this.f33388a = mapper;
    }

    private LinkedHashMap<K, V> a() {
        LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<>();
        do {
            linkedHashMap.putAll(b());
        } while (this.f33389b.a() == d.FUNC_NAME);
        return linkedHashMap;
    }

    private Map<K, V> b() {
        LinkedList linkedList = new LinkedList();
        String str = "";
        try {
            str = a(d.FUNC_NAME);
            a(d.LEFT_PARENT);
            linkedList.add(a(d.PARAM_VALUE));
            while (true) {
                d a10 = this.f33389b.a();
                d dVar = d.COMMA;
                if (a10 != dVar) {
                    break;
                }
                a(dVar);
                linkedList.add(a(d.PARAM_VALUE));
            }
            a(d.RIGHT_PARENT);
        } catch (b e2) {
            CardLogUtils.e("FunctionParser", "function parse error", e2);
        }
        return this.f33388a.map(str, linkedList);
    }

    public LinkedHashMap<K, V> parse() {
        this.f33389b.c();
        return a();
    }

    private String a(d dVar) {
        if (dVar == this.f33389b.a()) {
            String b4 = this.f33389b.b();
            this.f33389b.c();
            return b4;
        }
        throw new b("Token doesn't match");
    }
}
