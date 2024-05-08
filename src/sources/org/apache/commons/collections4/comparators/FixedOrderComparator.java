package org.apache.commons.collections4.comparators;

import com.android.internal.logging.nano.MetricsProto;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FixedOrderComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 82794675842863201L;
    private final Map<T, Integer> map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;

    /* renamed from: org.apache.commons.collections4.comparators.FixedOrderComparator$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior;

        static {
            int[] iArr = new int[UnknownObjectBehavior.values().length];
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior = iArr;
            try {
                iArr[UnknownObjectBehavior.BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public FixedOrderComparator() {
    }

    public boolean add(T t2) {
        checkLocked();
        Map<T, Integer> map = this.map;
        int i10 = this.counter;
        this.counter = i10 + 1;
        return map.put(t2, Integer.valueOf(i10)) == null;
    }

    public boolean addAsEqual(T t2, T t10) {
        checkLocked();
        Integer num = this.map.get(t2);
        if (num != null) {
            return this.map.put(t10, num) == null;
        }
        throw new IllegalArgumentException(((Object) t2) + " not known to " + ((Object) this));
    }

    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    @Override // java.util.Comparator
    public int compare(T t2, T t10) {
        this.isLocked = true;
        Integer num = this.map.get(t2);
        Integer num2 = this.map.get(t10);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int i10 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[this.unknownObjectBehavior.ordinal()];
        if (i10 == 1) {
            if (num == null) {
                return num2 == null ? 0 : -1;
            }
            return 1;
        }
        if (i10 == 2) {
            if (num == null) {
                return num2 == null ? 0 : 1;
            }
            return -1;
        }
        if (i10 == 3) {
            if (num != null) {
                t2 = t10;
            }
            throw new IllegalArgumentException("Attempting to compare unknown object " + ((Object) t2));
        }
        throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + ((Object) this.unknownObjectBehavior));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
        Map<T, Integer> map = this.map;
        if (map != null ? map.equals(fixedOrderComparator.map) : fixedOrderComparator.map == null) {
            UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
            if (unknownObjectBehavior != null) {
                UnknownObjectBehavior unknownObjectBehavior2 = fixedOrderComparator.unknownObjectBehavior;
                if (unknownObjectBehavior == unknownObjectBehavior2 && this.counter == fixedOrderComparator.counter && this.isLocked == fixedOrderComparator.isLocked && unknownObjectBehavior == unknownObjectBehavior2) {
                    return true;
                }
            } else if (fixedOrderComparator.unknownObjectBehavior == null) {
                return true;
            }
        }
        return false;
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public int hashCode() {
        int hashCode = (MetricsProto.MetricsEvent.TEXT_LONGPRESS + this.map.hashCode()) * 37;
        UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
        return ((((hashCode + (unknownObjectBehavior == null ? 0 : unknownObjectBehavior.hashCode())) * 37) + this.counter) * 37) + (!this.isLocked ? 1 : 0);
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        Objects.requireNonNull(unknownObjectBehavior, "Unknown object behavior must not be null");
        this.unknownObjectBehavior = unknownObjectBehavior;
    }

    public FixedOrderComparator(T... tArr) {
        Objects.requireNonNull(tArr, "The list of items must not be null");
        for (T t2 : tArr) {
            add(t2);
        }
    }

    public FixedOrderComparator(List<T> list) {
        Objects.requireNonNull(list, "The list of items must not be null");
        Iterator<T> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            add(iterator2.next());
        }
    }
}
