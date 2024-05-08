package org.apache.commons.collections4;

import com.alipay.sdk.util.i;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.FixedSizeSortedMap;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.collections4.map.LazySortedMap;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.collections4.map.PredicatedSortedMap;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MapUtils {
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap());
    private static final String INDENT_STRING = "    ";

    private MapUtils() {
    }

    public static void debugPrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), true);
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map == null ? Collections.emptyMap() : map;
    }

    public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> map) {
        return FixedSizeMap.fixedSizeMap(map);
    }

    public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        return FixedSizeSortedMap.fixedSizeSortedMap(sortedMap);
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k10) {
        Object obj;
        if (map == null || (obj = map.get(k10)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj);
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k10) {
        return Boolean.TRUE.equals(getBoolean(map, k10));
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k10) {
        Number number = getNumber(map, k10);
        if (number == null) {
            return null;
        }
        if (number instanceof Byte) {
            return (Byte) number;
        }
        return Byte.valueOf(number.byteValue());
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k10) {
        Byte b4 = getByte(map, k10);
        if (b4 == null) {
            return (byte) 0;
        }
        return b4.byteValue();
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k10) {
        Number number = getNumber(map, k10);
        if (number == null) {
            return null;
        }
        if (number instanceof Double) {
            return (Double) number;
        }
        return Double.valueOf(number.doubleValue());
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k10) {
        Double d10 = getDouble(map, k10);
        return d10 == null ? ShadowDrawableWrapper.COS_45 : d10.doubleValue();
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k10) {
        Number number = getNumber(map, k10);
        if (number == null) {
            return null;
        }
        if (number instanceof Float) {
            return (Float) number;
        }
        return Float.valueOf(number.floatValue());
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k10) {
        Float f10 = getFloat(map, k10);
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k10) {
        Integer integer = getInteger(map, k10);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k10) {
        Number number = getNumber(map, k10);
        if (number == null) {
            return null;
        }
        if (number instanceof Integer) {
            return (Integer) number;
        }
        return Integer.valueOf(number.intValue());
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k10) {
        Number number = getNumber(map, k10);
        if (number == null) {
            return null;
        }
        if (number instanceof Long) {
            return (Long) number;
        }
        return Long.valueOf(number.longValue());
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k10) {
        Long l10 = getLong(map, k10);
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k10) {
        Object obj;
        if (map == null || (obj = map.get(k10)) == null || !(obj instanceof Map)) {
            return null;
        }
        return (Map) obj;
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k10) {
        Object obj;
        if (map == null || (obj = map.get(k10)) == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static <K, V> V getObject(Map<? super K, V> map, K k10) {
        if (map != null) {
            return map.get(k10);
        }
        return null;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k10) {
        Number number = getNumber(map, k10);
        if (number == null) {
            return null;
        }
        if (number instanceof Short) {
            return (Short) number;
        }
        return Short.valueOf(number.shortValue());
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k10) {
        Short sh = getShort(map, k10);
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k10) {
        Object obj;
        if (map == null || (obj = map.get(k10)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> map) {
        Objects.requireNonNull(map, "Map must not be null");
        return map instanceof IterableMap ? (IterableMap) map : new AbstractMapDecorator<K, V>(map) { // from class: org.apache.commons.collections4.MapUtils.1
        };
    }

    public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> sortedMap) {
        Objects.requireNonNull(sortedMap, "Map must not be null");
        return sortedMap instanceof IterableSortedMap ? (IterableSortedMap) sortedMap : new AbstractSortedMapDecorator<K, V>(sortedMap) { // from class: org.apache.commons.collections4.MapUtils.2
        };
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return LazyMap.lazyMap(map, factory);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        return LazySortedMap.lazySortedMap(sortedMap, factory);
    }

    @Deprecated
    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return MultiValueMap.multiValueMap(map);
    }

    public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> map) {
        return ListOrderedMap.listOrderedMap(map);
    }

    public static <K, V> void populateMap(Map<K, V> map, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap(map, iterable, transformer, TransformerUtils.nopTransformer());
    }

    public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedMap.predicatedMap(map, predicate, predicate2);
    }

    public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedSortedMap.predicatedSortedMap(sortedMap, predicate, predicate2);
    }

    private static void printIndent(PrintStream printStream, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            printStream.print(INDENT_STRING);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> putAll(Map<K, V> map, Object[] objArr) {
        Objects.requireNonNull(map, "The map must not be null");
        if (objArr != null && objArr.length != 0) {
            int i10 = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                int length = objArr.length;
                while (i10 < length) {
                    Map.Entry entry = (Map.Entry) objArr[i10];
                    map.put(entry.getKey(), entry.getValue());
                    i10++;
                }
            } else if (obj instanceof KeyValue) {
                int length2 = objArr.length;
                while (i10 < length2) {
                    KeyValue keyValue = (KeyValue) objArr[i10];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i10++;
                }
            } else if (obj instanceof Object[]) {
                for (int i11 = 0; i11 < objArr.length; i11++) {
                    Object[] objArr2 = (Object[]) objArr[i11];
                    if (objArr2 != null && objArr2.length >= 2) {
                        map.put(objArr2[0], objArr2[1]);
                    } else {
                        throw new IllegalArgumentException("Invalid array element: " + i11);
                    }
                }
            } else {
                while (i10 < objArr.length - 1) {
                    int i12 = i10 + 1;
                    map.put(objArr[i10], objArr[i12]);
                    i10 = i12 + 1;
                }
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> void safeAddToMap(Map<? super K, Object> map, K k10, Object obj) throws NullPointerException {
        if (obj == null) {
            obj = "";
        }
        map.put(k10, obj);
    }

    public static int size(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return Collections.synchronizedMap(map);
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static Map<String, Object> toMap(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap hashMap = new HashMap();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            hashMap.put(nextElement, resourceBundle.getObject(nextElement));
        }
        return hashMap;
    }

    public static <K, V> Properties toProperties(Map<K, V> map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMap.transformingMap(map, transformer, transformer2);
    }

    public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedSortedMap.transformingSortedMap(sortedMap, transformer, transformer2);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return UnmodifiableMap.unmodifiableMap(map);
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), false);
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map<?, ?> map, Deque<Map<?, ?>> deque, boolean z10) {
        printIndent(printStream, deque.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println("null");
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, deque.size());
        printStream.println("{");
        deque.addLast(map);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((value instanceof Map) && !deque.contains(value)) {
                if (key == null) {
                    key = "null";
                }
                verbosePrintInternal(printStream, key, (Map) value, deque, z10);
            } else {
                printIndent(printStream, deque.size());
                printStream.print(key);
                printStream.print(" = ");
                int indexOf = IterableUtils.indexOf(deque, PredicateUtils.equalPredicate(value));
                if (indexOf == -1) {
                    printStream.print(value);
                } else if (deque.size() - 1 == indexOf) {
                    printStream.print("(this Map)");
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("(ancestor[");
                    sb2.append(((deque.size() - 1) - indexOf) - 1);
                    sb2.append("] Map)");
                    printStream.print(sb2.toString());
                }
                if (z10 && value != null) {
                    printStream.print(' ');
                    printStream.println(value.getClass().getName());
                } else {
                    printStream.println();
                }
            }
        }
        deque.removeLast();
        printIndent(printStream, deque.size());
        printStream.println(z10 ? "} " + map.getClass().getName() : i.f4738d);
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k10, boolean z10) {
        Boolean bool = getBoolean(map, k10);
        return bool == null ? z10 : bool.booleanValue();
    }

    public static <K, V> V getObject(Map<K, V> map, K k10, V v2) {
        V v10;
        return (map == null || (v10 = map.get(k10)) == null) ? v2 : v10;
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return LazyMap.lazyMap(map, transformer);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        return LazySortedMap.lazySortedMap(sortedMap, transformer);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Class<C> cls) {
        return MultiValueMap.multiValueMap(map, cls);
    }

    public static <K, V, E> void populateMap(Map<K, V> map, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e2 : iterable) {
            map.put(transformer.transform(e2), transformer2.transform(e2));
        }
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k10, byte b4) {
        Byte b10 = getByte(map, k10);
        return b10 == null ? b4 : b10.byteValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k10, double d10) {
        Double d11 = getDouble(map, k10);
        return d11 == null ? d10 : d11.doubleValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k10, float f10) {
        Float f11 = getFloat(map, k10);
        return f11 == null ? f10 : f11.floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k10, int i10) {
        Integer integer = getInteger(map, k10);
        return integer == null ? i10 : integer.intValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k10, long j10) {
        Long l10 = getLong(map, k10);
        return l10 == null ? j10 : l10.longValue();
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k10, short s2) {
        Short sh = getShort(map, k10);
        return sh == null ? s2 : sh.shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k10, String str) {
        String string = getString(map, k10);
        return string == null ? str : string;
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Factory<C> factory) {
        return MultiValueMap.multiValueMap(map, factory);
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k10, Map<?, ?> map2) {
        Map<?, ?> map3 = getMap(map, k10);
        return map3 == null ? map2 : map3;
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k10, Byte b4) {
        Byte b10 = getByte(map, k10);
        return b10 == null ? b4 : b10;
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k10, Double d10) {
        Double d11 = getDouble(map, k10);
        return d11 == null ? d10 : d11;
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k10, Float f10) {
        Float f11 = getFloat(map, k10);
        return f11 == null ? f10 : f11;
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k10, Integer num) {
        Integer integer = getInteger(map, k10);
        return integer == null ? num : integer;
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k10, Long l10) {
        Long l11 = getLong(map, k10);
        return l11 == null ? l10 : l11;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k10, Short sh) {
        Short sh2 = getShort(map, k10);
        return sh2 == null ? sh : sh2;
    }

    public static <K, V> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap((MultiMap) multiMap, (Iterable) iterable, (Transformer) transformer, TransformerUtils.nopTransformer());
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k10, Number number) {
        Number number2 = getNumber(map, k10);
        return number2 == null ? number : number2;
    }

    public static <K, V, E> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e2 : iterable) {
            multiMap.put(transformer.transform(e2), transformer2.transform(e2));
        }
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k10, Boolean bool) {
        Boolean bool2 = getBoolean(map, k10);
        return bool2 == null ? bool : bool2;
    }
}
