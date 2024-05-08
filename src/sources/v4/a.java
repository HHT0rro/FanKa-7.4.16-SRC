package v4;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;

/* compiled from: PriorityMapping.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<Priority> f54030a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static EnumMap<Priority, Integer> f54031b;

    static {
        EnumMap<Priority, Integer> enumMap = new EnumMap<>((Class<Priority>) Priority.class);
        f54031b = enumMap;
        enumMap.put((EnumMap<Priority, Integer>) Priority.DEFAULT, (Priority) 0);
        f54031b.put((EnumMap<Priority, Integer>) Priority.VERY_LOW, (Priority) 1);
        f54031b.put((EnumMap<Priority, Integer>) Priority.HIGHEST, (Priority) 2);
        for (Priority priority : f54031b.h()) {
            f54030a.append(f54031b.get(priority).intValue(), priority);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f54031b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + ((Object) priority));
    }

    @NonNull
    public static Priority b(int i10) {
        Priority priority = f54030a.get(i10);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
