package jdk.internal.util;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Preconditions {
    private static RuntimeException outOfBounds(BiFunction<String, List<Number>, ? extends RuntimeException> oobef, String checkKind, Number... args) {
        List<Number> largs = List.of((Object[]) args);
        RuntimeException e2 = oobef == null ? null : oobef.apply(checkKind, largs);
        return e2 == null ? new IndexOutOfBoundsException(outOfBoundsMessage(checkKind, largs)) : e2;
    }

    private static RuntimeException outOfBoundsCheckIndex(BiFunction<String, List<Number>, ? extends RuntimeException> oobe, int index, int length) {
        return outOfBounds(oobe, "checkIndex", Integer.valueOf(index), Integer.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckFromToIndex(BiFunction<String, List<Number>, ? extends RuntimeException> oobe, int fromIndex, int toIndex, int length) {
        return outOfBounds(oobe, "checkFromToIndex", Integer.valueOf(fromIndex), Integer.valueOf(toIndex), Integer.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckFromIndexSize(BiFunction<String, List<Number>, ? extends RuntimeException> oobe, int fromIndex, int size, int length) {
        return outOfBounds(oobe, "checkFromIndexSize", Integer.valueOf(fromIndex), Integer.valueOf(size), Integer.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckIndex(BiFunction<String, List<Number>, ? extends RuntimeException> oobe, long index, long length) {
        return outOfBounds(oobe, "checkIndex", Long.valueOf(index), Long.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckFromToIndex(BiFunction<String, List<Number>, ? extends RuntimeException> oobe, long fromIndex, long toIndex, long length) {
        return outOfBounds(oobe, "checkFromToIndex", Long.valueOf(fromIndex), Long.valueOf(toIndex), Long.valueOf(length));
    }

    private static RuntimeException outOfBoundsCheckFromIndexSize(BiFunction<String, List<Number>, ? extends RuntimeException> oobe, long fromIndex, long size, long length) {
        return outOfBounds(oobe, "checkFromIndexSize", Long.valueOf(fromIndex), Long.valueOf(size), Long.valueOf(length));
    }

    public static <X extends RuntimeException> BiFunction<String, List<Number>, X> outOfBoundsExceptionFormatter(final Function<String, X> function) {
        return (BiFunction<String, List<Number>, X>) new BiFunction<String, List<Number>, X>() { // from class: jdk.internal.util.Preconditions.1
            @Override // java.util.function.BiFunction
            public /* bridge */ /* synthetic */ Object apply(String str, List<Number> list) {
                return apply2(str, (List) list);
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;Ljava/util/List<Ljava/lang/Number;>;)TX; */
            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public RuntimeException apply2(String checkKind, List list) {
                return (RuntimeException) Function.this.apply(Preconditions.outOfBoundsMessage(checkKind, list));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String outOfBoundsMessage(String checkKind, List<? extends Number> args) {
        boolean z10;
        if (checkKind == null && args == null) {
            return String.format("Range check failed", new Object[0]);
        }
        if (checkKind == null) {
            return String.format("Range check failed: %s", args);
        }
        if (args == null) {
            return String.format("Range check failed: %s", checkKind);
        }
        int argSize = 0;
        char c4 = 65535;
        switch (checkKind.hashCode()) {
            case -538822486:
                if (checkKind.equals("checkIndex")) {
                    z10 = false;
                    break;
                }
                z10 = -1;
                break;
            case 1844394469:
                if (checkKind.equals("checkFromToIndex")) {
                    z10 = true;
                    break;
                }
                z10 = -1;
                break;
            case 1848935233:
                if (checkKind.equals("checkFromIndexSize")) {
                    z10 = 2;
                    break;
                }
                z10 = -1;
                break;
            default:
                z10 = -1;
                break;
        }
        switch (z10) {
            case false:
                argSize = 2;
                break;
            case true:
            case true:
                argSize = 3;
                break;
        }
        String str = args.size() != argSize ? "" : checkKind;
        switch (str.hashCode()) {
            case -538822486:
                if (str.equals("checkIndex")) {
                    c4 = 0;
                    break;
                }
                break;
            case 1844394469:
                if (str.equals("checkFromToIndex")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1848935233:
                if (str.equals("checkFromIndexSize")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return String.format("Index %s out of bounds for length %s", args.get(0), args.get(1));
            case 1:
                return String.format("Range [%s, %s) out of bounds for length %s", args.get(0), args.get(1), args.get(2));
            case 2:
                return String.format("Range [%s, %<s + %s) out of bounds for length %s", args.get(0), args.get(1), args.get(2));
            default:
                return String.format("Range check failed: %s %s", checkKind, args);
        }
    }

    public static <X extends RuntimeException> int checkIndex(int index, int length, BiFunction<String, List<Number>, X> oobef) {
        if (index < 0 || index >= length) {
            throw outOfBoundsCheckIndex((BiFunction<String, List<Number>, ? extends RuntimeException>) oobef, index, length);
        }
        return index;
    }

    public static <X extends RuntimeException> int checkFromToIndex(int fromIndex, int toIndex, int length, BiFunction<String, List<Number>, X> oobef) {
        if (fromIndex < 0 || fromIndex > toIndex || toIndex > length) {
            throw outOfBoundsCheckFromToIndex((BiFunction<String, List<Number>, ? extends RuntimeException>) oobef, fromIndex, toIndex, length);
        }
        return fromIndex;
    }

    public static <X extends RuntimeException> int checkFromIndexSize(int fromIndex, int size, int length, BiFunction<String, List<Number>, X> oobef) {
        if ((length | fromIndex | size) < 0 || size > length - fromIndex) {
            throw outOfBoundsCheckFromIndexSize((BiFunction<String, List<Number>, ? extends RuntimeException>) oobef, fromIndex, size, length);
        }
        return fromIndex;
    }

    public static <X extends RuntimeException> long checkIndex(long index, long length, BiFunction<String, List<Number>, X> oobef) {
        if (index < 0 || index >= length) {
            throw outOfBoundsCheckIndex((BiFunction<String, List<Number>, ? extends RuntimeException>) oobef, index, length);
        }
        return index;
    }

    public static <X extends RuntimeException> long checkFromToIndex(long fromIndex, long toIndex, long length, BiFunction<String, List<Number>, X> oobef) {
        if (fromIndex < 0 || fromIndex > toIndex || toIndex > length) {
            throw outOfBoundsCheckFromToIndex((BiFunction<String, List<Number>, ? extends RuntimeException>) oobef, fromIndex, toIndex, length);
        }
        return fromIndex;
    }

    public static <X extends RuntimeException> long checkFromIndexSize(long fromIndex, long size, long length, BiFunction<String, List<Number>, X> oobef) {
        if ((length | fromIndex | size) < 0 || size > length - fromIndex) {
            throw outOfBoundsCheckFromIndexSize((BiFunction<String, List<Number>, ? extends RuntimeException>) oobef, fromIndex, size, length);
        }
        return fromIndex;
    }
}
