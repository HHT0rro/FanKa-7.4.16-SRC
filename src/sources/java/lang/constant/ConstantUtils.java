package java.lang.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConstantUtils {
    private static final char JVM_SIGNATURE_ARRAY = '[';
    private static final char JVM_SIGNATURE_BOOLEAN = 'Z';
    private static final char JVM_SIGNATURE_BYTE = 'B';
    private static final char JVM_SIGNATURE_CHAR = 'C';
    private static final char JVM_SIGNATURE_CLASS = 'L';
    private static final char JVM_SIGNATURE_DOUBLE = 'D';
    private static final char JVM_SIGNATURE_ENDCLASS = ';';
    private static final char JVM_SIGNATURE_ENDFUNC = ')';
    private static final char JVM_SIGNATURE_ENUM = 'E';
    private static final char JVM_SIGNATURE_FLOAT = 'F';
    private static final char JVM_SIGNATURE_FUNC = '(';
    private static final char JVM_SIGNATURE_INT = 'I';
    private static final char JVM_SIGNATURE_LONG = 'J';
    private static final char JVM_SIGNATURE_SHORT = 'S';
    private static final char JVM_SIGNATURE_VOID = 'V';
    static final int MAX_ARRAY_TYPE_DESC_DIMENSIONS = 255;
    public static final ConstantDesc[] EMPTY_CONSTANTDESC = new ConstantDesc[0];
    static final Constable[] EMPTY_CONSTABLE = new Constable[0];
    private static final Set<String> pointyNames = Set.of("<init>", "<clinit>");

    ConstantUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String validateBinaryClassName(String name) {
        for (int i10 = 0; i10 < name.length(); i10++) {
            char ch = name.charAt(i10);
            if (ch == ';' || ch == '[' || ch == '/') {
                throw new IllegalArgumentException("Invalid class name: " + name);
            }
        }
        return name;
    }

    public static String validateMemberName(String name, boolean method) {
        Objects.requireNonNull(name);
        if (name.length() == 0) {
            throw new IllegalArgumentException("zero-length member name");
        }
        for (int i10 = 0; i10 < name.length(); i10++) {
            char ch = name.charAt(i10);
            if (ch == '.' || ch == ';' || ch == '[' || ch == '/') {
                throw new IllegalArgumentException("Invalid member name: " + name);
            }
            if (method && ((ch == '<' || ch == '>') && !pointyNames.contains(name))) {
                throw new IllegalArgumentException("Invalid member name: " + name);
            }
        }
        return name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateClassOrInterface(ClassDesc classDesc) {
        if (!classDesc.isClassOrInterface()) {
            throw new IllegalArgumentException("not a class or interface type: " + ((Object) classDesc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int arrayDepth(String descriptorString) {
        int depth = 0;
        while (descriptorString.charAt(depth) == '[') {
            depth++;
        }
        return depth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String binaryToInternal(String name) {
        return name.replace('.', IOUtils.DIR_SEPARATOR_UNIX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String internalToBinary(String name) {
        return name.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String dropLastChar(String s2) {
        return s2.substring(0, s2.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String dropFirstAndLastChar(String s2) {
        return s2.substring(1, s2.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> parseMethodDescriptor(String descriptor) {
        int end = descriptor.length();
        ArrayList<String> ptypes = new ArrayList<>();
        if (0 < end && descriptor.charAt(0) == '(') {
            int cur = 0 + 1;
            while (cur < end && descriptor.charAt(cur) != ')') {
                int len = skipOverFieldSignature(descriptor, cur, end, false);
                if (len == 0) {
                    throw new IllegalArgumentException("Bad method descriptor: " + descriptor);
                }
                ptypes.add(descriptor.substring(cur, cur + len));
                cur += len;
            }
            if (cur >= end) {
                throw new IllegalArgumentException("Bad method descriptor: " + descriptor);
            }
            int cur2 = cur + 1;
            int rLen = skipOverFieldSignature(descriptor, cur2, end, true);
            if (rLen != 0 && cur2 + rLen == end) {
                ptypes.add(0, descriptor.substring(cur2, cur2 + rLen));
                return ptypes;
            }
            throw new IllegalArgumentException("Bad method descriptor: " + descriptor);
        }
        throw new IllegalArgumentException("Bad method descriptor: " + descriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public static int skipOverFieldSignature(String descriptor, int start, int end, boolean voidOK) {
        int arrayDim = 0;
        int index = start;
        while (index < end) {
            switch (descriptor.charAt(index)) {
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'Z':
                    return (index - start) + 1;
                case 'L':
                    int index2 = index + 1;
                    int indexOfSemi = descriptor.indexOf(59, index2);
                    if (indexOfSemi == -1) {
                        return 0;
                    }
                    String unqualifiedName = descriptor.substring(index2, indexOfSemi);
                    boolean legal = verifyUnqualifiedClassName(unqualifiedName);
                    if (!legal) {
                        return 0;
                    }
                    return (index2 - start) + unqualifiedName.length() + 1;
                case 'V':
                    if (!voidOK) {
                        return index;
                    }
                    return (index - start) + 1;
                case '[':
                    arrayDim++;
                    if (arrayDim > 255) {
                        throw new IllegalArgumentException(String.format("Cannot create an array type descriptor with more than %d dimensions", 255));
                    }
                    index++;
                    voidOK = false;
                default:
                    return 0;
            }
        }
        return 0;
    }

    static boolean verifyUnqualifiedClassName(String name) {
        int index = 0;
        while (index < name.length()) {
            char ch = name.charAt(index);
            if (ch < 128) {
                if (ch == '.' || ch == ';' || ch == '[') {
                    return false;
                }
                if (ch == '/' && (index == 0 || index + 1 >= name.length() || name.charAt(index + 1) == '/')) {
                    return false;
                }
            } else {
                index++;
            }
            index++;
        }
        return true;
    }
}
