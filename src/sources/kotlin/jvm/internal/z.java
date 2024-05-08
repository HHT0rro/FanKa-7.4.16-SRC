package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: TypeIntrinsics.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class z {
    public static Collection a(Object obj) {
        if ((obj instanceof zd.a) && !(obj instanceof zd.b)) {
            o(obj, "kotlin.collections.MutableCollection");
        }
        return f(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof zd.a) && !(obj instanceof zd.c)) {
            o(obj, "kotlin.collections.MutableIterable");
        }
        return g(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof zd.a) && !(obj instanceof zd.d)) {
            o(obj, "kotlin.collections.MutableList");
        }
        return h(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof zd.a) && !(obj instanceof zd.e)) {
            o(obj, "kotlin.collections.MutableMap");
        }
        return i(obj);
    }

    public static Object e(Object obj, int i10) {
        if (obj != null && !k(obj, i10)) {
            o(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection f(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw n(e2);
        }
    }

    public static Iterable g(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw n(e2);
        }
    }

    public static List h(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw n(e2);
        }
    }

    public static Map i(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw n(e2);
        }
    }

    public static int j(Object obj) {
        if (obj instanceof q) {
            return ((q) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof yd.n) {
            return 4;
        }
        if (obj instanceof yd.o) {
            return 5;
        }
        if (obj instanceof yd.p) {
            return 6;
        }
        if (obj instanceof yd.q) {
            return 7;
        }
        if (obj instanceof yd.r) {
            return 8;
        }
        if (obj instanceof yd.s) {
            return 9;
        }
        if (obj instanceof yd.a) {
            return 10;
        }
        if (obj instanceof yd.b) {
            return 11;
        }
        if (obj instanceof yd.c) {
            return 12;
        }
        if (obj instanceof yd.d) {
            return 13;
        }
        if (obj instanceof yd.e) {
            return 14;
        }
        if (obj instanceof yd.f) {
            return 15;
        }
        if (obj instanceof yd.g) {
            return 16;
        }
        if (obj instanceof yd.h) {
            return 17;
        }
        if (obj instanceof yd.i) {
            return 18;
        }
        if (obj instanceof yd.j) {
            return 19;
        }
        if (obj instanceof yd.k) {
            return 20;
        }
        if (obj instanceof yd.l) {
            return 21;
        }
        return obj instanceof yd.m ? 22 : -1;
    }

    public static boolean k(Object obj, int i10) {
        return (obj instanceof kotlin.b) && j(obj) == i10;
    }

    public static boolean l(Object obj) {
        return (obj instanceof List) && (!(obj instanceof zd.a) || (obj instanceof zd.d));
    }

    public static <T extends Throwable> T m(T t2) {
        return (T) s.q(t2, z.class.getName());
    }

    public static ClassCastException n(ClassCastException classCastException) {
        throw ((ClassCastException) m(classCastException));
    }

    public static void o(Object obj, String str) {
        p((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void p(String str) {
        throw n(new ClassCastException(str));
    }
}
