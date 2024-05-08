package com.android.framework.protobuf.nano;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class MessageNanoPrinter {
    private static final String INDENT = "  ";
    private static final int MAX_STRING_LEN = 200;

    private MessageNanoPrinter() {
    }

    public static <T extends MessageNano> String print(T message) {
        if (message == null) {
            return "";
        }
        StringBuffer buf = new StringBuffer();
        try {
            print(null, message, new StringBuffer(), buf);
            return buf.toString();
        } catch (IllegalAccessException e2) {
            return "Error printing proto: " + e2.getMessage();
        } catch (InvocationTargetException e10) {
            return "Error printing proto: " + e10.getMessage();
        }
    }

    private static void print(String identifier, Object object, StringBuffer indentBuf, StringBuffer buf) throws IllegalAccessException, InvocationTargetException {
        Method[] methodArr;
        Field[] fieldArr;
        int i10;
        if (object != null) {
            if (object instanceof MessageNano) {
                int origIndentBufLength = indentBuf.length();
                if (identifier != null) {
                    buf.append(indentBuf).append(deCamelCaseify(identifier)).append(" <\n");
                    indentBuf.append(INDENT);
                }
                Class<?> clazz = object.getClass();
                Field[] fields = clazz.getFields();
                int length = fields.length;
                int i11 = 0;
                while (i11 < length) {
                    Field field = fields[i11];
                    int modifiers = field.getModifiers();
                    String fieldName = field.getName();
                    if ("cachedSize".equals(fieldName)) {
                        fieldArr = fields;
                        i10 = length;
                    } else if ((modifiers & 1) != 1 || (modifiers & 8) == 8) {
                        fieldArr = fields;
                        i10 = length;
                    } else if (fieldName.startsWith("_")) {
                        fieldArr = fields;
                        i10 = length;
                    } else if (fieldName.endsWith("_")) {
                        fieldArr = fields;
                        i10 = length;
                    } else {
                        Class<?> fieldType = field.getType();
                        Object value = field.get(object);
                        if (fieldType.isArray()) {
                            Class<?> arrayType = fieldType.getComponentType();
                            if (arrayType == Byte.TYPE) {
                                print(fieldName, value, indentBuf, buf);
                                fieldArr = fields;
                                i10 = length;
                            } else {
                                int len = value == null ? 0 : Array.getLength(value);
                                fieldArr = fields;
                                int i12 = 0;
                                while (i12 < len) {
                                    int i13 = length;
                                    Object elem = Array.get(value, i12);
                                    print(fieldName, elem, indentBuf, buf);
                                    i12++;
                                    length = i13;
                                }
                                i10 = length;
                            }
                        } else {
                            fieldArr = fields;
                            i10 = length;
                            print(fieldName, value, indentBuf, buf);
                        }
                    }
                    i11++;
                    length = i10;
                    fields = fieldArr;
                }
                Method[] methods = clazz.getMethods();
                int length2 = methods.length;
                int i14 = 0;
                while (i14 < length2) {
                    Method method = methods[i14];
                    String name = method.getName();
                    if (!name.startsWith("set")) {
                        methodArr = methods;
                    } else {
                        String subfieldName = name.substring(3);
                        try {
                            try {
                                Method hazzer = clazz.getMethod("has" + subfieldName, new Class[0]);
                                if (!((Boolean) hazzer.invoke(object, new Object[0])).booleanValue()) {
                                    methodArr = methods;
                                } else {
                                    try {
                                        methodArr = methods;
                                        try {
                                            Method getter = clazz.getMethod(MonitorConstants.CONNECT_TYPE_GET + subfieldName, new Class[0]);
                                            print(subfieldName, getter.invoke(object, new Object[0]), indentBuf, buf);
                                        } catch (NoSuchMethodException e2) {
                                        }
                                    } catch (NoSuchMethodException e10) {
                                        methodArr = methods;
                                    }
                                }
                            } catch (NoSuchMethodException e11) {
                                methodArr = methods;
                            }
                        } catch (NoSuchMethodException e12) {
                            methodArr = methods;
                        }
                    }
                    i14++;
                    methods = methodArr;
                }
                if (identifier != null) {
                    indentBuf.setLength(origIndentBufLength);
                    buf.append(indentBuf).append(">\n");
                }
            } else {
                if (object instanceof Map) {
                    Map<?, ?> map = (Map) object;
                    String identifier2 = deCamelCaseify(identifier);
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        buf.append(indentBuf).append(identifier2).append(" <\n");
                        int origIndentBufLength2 = indentBuf.length();
                        indentBuf.append(INDENT);
                        print("key", entry.getKey(), indentBuf, buf);
                        print("value", entry.getValue(), indentBuf, buf);
                        indentBuf.setLength(origIndentBufLength2);
                        buf.append(indentBuf).append(">\n");
                    }
                    return;
                }
                buf.append(indentBuf).append(deCamelCaseify(identifier)).append(": ");
                if (!(object instanceof String)) {
                    if (object instanceof byte[]) {
                        appendQuotedBytes((byte[]) object, buf);
                    } else {
                        buf.append(object);
                    }
                } else {
                    String stringMessage = sanitizeString((String) object);
                    buf.append("\"").append(stringMessage).append("\"");
                }
                buf.append("\n");
            }
        }
    }

    private static String deCamelCaseify(String identifier) {
        StringBuffer out = new StringBuffer();
        for (int i10 = 0; i10 < identifier.length(); i10++) {
            char currentChar = identifier.charAt(i10);
            if (i10 == 0) {
                out.append(Character.toLowerCase(currentChar));
            } else if (Character.isUpperCase(currentChar)) {
                out.append('_').append(Character.toLowerCase(currentChar));
            } else {
                out.append(currentChar);
            }
        }
        return out.toString();
    }

    private static String sanitizeString(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = str.substring(0, 200) + "[...]";
        }
        return escapeString(str);
    }

    private static String escapeString(String str) {
        int strLen = str.length();
        StringBuilder b4 = new StringBuilder(strLen);
        for (int i10 = 0; i10 < strLen; i10++) {
            char original = str.charAt(i10);
            if (original >= ' ' && original <= '~' && original != '\"' && original != '\'') {
                b4.append(original);
            } else {
                b4.append(String.format("\\u%04x", Integer.valueOf(original)));
            }
        }
        return b4.toString();
    }

    private static void appendQuotedBytes(byte[] bytes, StringBuffer builder) {
        if (bytes == null) {
            builder.append("\"\"");
            return;
        }
        builder.append('\"');
        for (byte b4 : bytes) {
            int ch = b4 & 255;
            if (ch == 92 || ch == 34) {
                builder.append(IOUtils.DIR_SEPARATOR_WINDOWS).append((char) ch);
            } else if (ch >= 32 && ch < 127) {
                builder.append((char) ch);
            } else {
                builder.append(String.format("\\%03o", Integer.valueOf(ch)));
            }
        }
        builder.append('\"');
    }
}
