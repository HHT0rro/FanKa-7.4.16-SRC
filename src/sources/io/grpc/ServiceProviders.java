package io.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServiceProviders {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface PriorityAccessor<T> {
        int getPriority(T t2);

        boolean isAvailable(T t2);
    }

    private ServiceProviders() {
    }

    private static <T> T createForHardCoded(Class<T> cls, Class<?> cls2) {
        try {
            return (T) cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            Object createForHardCoded = createForHardCoded(cls, iterator2.next());
            if (createForHardCoded != null) {
                arrayList.add(createForHardCoded);
            }
        }
        return arrayList;
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        return !load.iterator2().hasNext() ? ServiceLoader.load(cls) : load;
    }

    public static boolean isAndroid(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> T load(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        List loadAll = loadAll(cls, iterable, classLoader, priorityAccessor);
        if (loadAll.isEmpty()) {
            return null;
        }
        return (T) loadAll.get(0);
    }

    public static <T> List<T> loadAll(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, final PriorityAccessor<T> priorityAccessor) {
        Iterable candidatesViaServiceLoader;
        if (isAndroid(classLoader)) {
            candidatesViaServiceLoader = getCandidatesViaHardCoded(cls, iterable);
        } else {
            candidatesViaServiceLoader = getCandidatesViaServiceLoader(cls, classLoader);
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : candidatesViaServiceLoader) {
            if (priorityAccessor.isAvailable(t2)) {
                arrayList.add(t2);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<T>() { // from class: io.grpc.ServiceProviders.1
            @Override // java.util.Comparator
            public int compare(T t10, T t11) {
                int priority = PriorityAccessor.this.getPriority(t10) - PriorityAccessor.this.getPriority(t11);
                return priority != 0 ? priority : t10.getClass().getName().compareTo(t11.getClass().getName());
            }
        }));
        return Collections.unmodifiableList(arrayList);
    }
}
