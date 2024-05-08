package com.android.framework.protobuf;

import com.alipay.sdk.util.i;
import com.android.framework.protobuf.GeneratedMessageLite;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] cArr = new char[80];
        INDENT_BUFFER = cArr;
        Arrays.fill(cArr, ' ');
    }

    private MessageLiteToString() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(MessageLite messageLite, String commentString) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("# ").append(commentString);
        reflectivePrintWithIndent(messageLite, buffer, 0);
        return buffer.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder buffer, int indent) {
        int i10;
        Set<String> setters;
        boolean hasValue;
        Method mapMethod;
        Method listMethod;
        Set<String> setters2 = new HashSet<>();
        Map<String, Method> hazzers = new HashMap<>();
        Map<String, Method> getters = new TreeMap<>();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i11 = 0;
        while (true) {
            i10 = 3;
            if (i11 >= length) {
                break;
            }
            Method method = declaredMethods[i11];
            if (!Modifier.isStatic(method.getModifiers()) && method.getName().length() >= 3) {
                if (method.getName().startsWith("set")) {
                    setters2.add(method.getName());
                } else if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0) {
                    if (method.getName().startsWith("has")) {
                        hazzers.put(method.getName(), method);
                    } else if (method.getName().startsWith(MonitorConstants.CONNECT_TYPE_GET)) {
                        getters.put(method.getName(), method);
                    }
                }
            }
            i11++;
        }
        for (Map.Entry<String, Method> getter : getters.entrySet()) {
            String suffix = getter.getKey().substring(i10);
            if (suffix.endsWith(LIST_SUFFIX) && !suffix.endsWith(BUILDER_LIST_SUFFIX) && !suffix.equals(LIST_SUFFIX) && (listMethod = getter.getValue()) != null && listMethod.getReturnType().equals(List.class)) {
                printField(buffer, indent, suffix.substring(0, suffix.length() - LIST_SUFFIX.length()), GeneratedMessageLite.invokeOrDie(listMethod, messageLite, new Object[0]));
                i10 = 3;
            } else if (suffix.endsWith(MAP_SUFFIX) && !suffix.equals(MAP_SUFFIX) && (mapMethod = getter.getValue()) != null && mapMethod.getReturnType().equals(Map.class) && !mapMethod.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(mapMethod.getModifiers())) {
                printField(buffer, indent, suffix.substring(0, suffix.length() - MAP_SUFFIX.length()), GeneratedMessageLite.invokeOrDie(mapMethod, messageLite, new Object[0]));
                i10 = 3;
            } else if (!setters2.contains("set" + suffix)) {
                i10 = 3;
            } else if (suffix.endsWith(BYTES_SUFFIX) && getters.containsKey(MonitorConstants.CONNECT_TYPE_GET + suffix.substring(0, suffix.length() - BYTES_SUFFIX.length()))) {
                i10 = 3;
            } else {
                Method getMethod = getter.getValue();
                Method hasMethod = hazzers.get("has" + suffix);
                if (getMethod != null) {
                    Object value = GeneratedMessageLite.invokeOrDie(getMethod, messageLite, new Object[0]);
                    if (hasMethod == null) {
                        if (isDefaultValue(value)) {
                            setters = setters2;
                            hasValue = false;
                        } else {
                            setters = setters2;
                            hasValue = true;
                        }
                    } else {
                        setters = setters2;
                        hasValue = ((Boolean) GeneratedMessageLite.invokeOrDie(hasMethod, messageLite, new Object[0])).booleanValue();
                    }
                    if (!hasValue) {
                        setters2 = setters;
                        i10 = 3;
                    } else {
                        printField(buffer, indent, suffix, value);
                        setters2 = setters;
                        i10 = 3;
                    }
                } else {
                    i10 = 3;
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (iter.hasNext()) {
                Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> entry = iter.next();
                printField(buffer, indent, "[" + entry.getKey().getNumber() + "]", entry.getValue());
            }
        }
        if (((GeneratedMessageLite) messageLite).unknownFields != null) {
            ((GeneratedMessageLite) messageLite).unknownFields.printWithIndent(buffer, indent);
        }
    }

    private static boolean isDefaultValue(Object o10) {
        if (o10 instanceof Boolean) {
            return !((Boolean) o10).booleanValue();
        }
        if (o10 instanceof Integer) {
            return ((Integer) o10).intValue() == 0;
        }
        if (o10 instanceof Float) {
            return Float.floatToRawIntBits(((Float) o10).floatValue()) == 0;
        }
        if (o10 instanceof Double) {
            return Double.doubleToRawLongBits(((Double) o10).doubleValue()) == 0;
        }
        if (o10 instanceof String) {
            return o10.equals("");
        }
        if (o10 instanceof ByteString) {
            return o10.equals(ByteString.EMPTY);
        }
        return o10 instanceof MessageLite ? o10 == ((MessageLite) o10).getDefaultInstanceForType() : (o10 instanceof Enum) && ((Enum) o10).ordinal() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void printField(StringBuilder buffer, int indent, String name, Object object) {
        if (object instanceof List) {
            List<?> list = (List) object;
            Iterator<?> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                printField(buffer, indent, name, iterator2.next());
            }
            return;
        }
        if (object instanceof Map) {
            Map<?, ?> map = (Map) object;
            Iterator<Map.Entry<?, ?>> iterator22 = map.entrySet().iterator2();
            while (iterator22.hasNext()) {
                printField(buffer, indent, name, iterator22.next());
            }
            return;
        }
        buffer.append('\n');
        indent(indent, buffer);
        buffer.append(pascalCaseToSnakeCase(name));
        if (object instanceof String) {
            buffer.append(": \"").append(TextFormatEscaper.escapeText((String) object)).append('\"');
            return;
        }
        if (object instanceof ByteString) {
            buffer.append(": \"").append(TextFormatEscaper.escapeBytes((ByteString) object)).append('\"');
            return;
        }
        if (object instanceof GeneratedMessageLite) {
            buffer.append(" {");
            reflectivePrintWithIndent((GeneratedMessageLite) object, buffer, indent + 2);
            buffer.append("\n");
            indent(indent, buffer);
            buffer.append(i.f4738d);
            return;
        }
        if (object instanceof Map.Entry) {
            buffer.append(" {");
            Map.Entry<?, ?> entry = (Map.Entry) object;
            printField(buffer, indent + 2, "key", entry.getKey());
            printField(buffer, indent + 2, "value", entry.getValue());
            buffer.append("\n");
            indent(indent, buffer);
            buffer.append(i.f4738d);
            return;
        }
        buffer.append(": ").append(object);
    }

    private static void indent(int indent, StringBuilder buffer) {
        while (indent > 0) {
            int partialIndent = indent;
            char[] cArr = INDENT_BUFFER;
            if (partialIndent > cArr.length) {
                partialIndent = cArr.length;
            }
            buffer.append(cArr, 0, partialIndent);
            indent -= partialIndent;
        }
    }

    private static String pascalCaseToSnakeCase(String pascalCase) {
        if (pascalCase.isEmpty()) {
            return pascalCase;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toLowerCase(pascalCase.charAt(0)));
        for (int i10 = 1; i10 < pascalCase.length(); i10++) {
            char ch = pascalCase.charAt(i10);
            if (Character.isUpperCase(ch)) {
                builder.append("_");
            }
            builder.append(Character.toLowerCase(ch));
        }
        return builder.toString();
    }
}
