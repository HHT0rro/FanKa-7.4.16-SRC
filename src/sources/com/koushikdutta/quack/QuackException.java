package com.koushikdutta.quack;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class QuackException extends RuntimeException {
    private static final String STACK_TRACE_CLASS_NAME = "JavaScript";
    private static final Pattern STACK_TRACE_PATTERN = Pattern.compile("\\s*at (\\[?)(.*?)]? \\((.*?):?(\\d+)?\\).*$");
    private static final long serialVersionUID = 1538523787401076917L;

    public QuackException(String str) {
        super(getErrorMessage(str));
        addJSStack(this, str);
    }

    public static void addJSStack(Throwable th, String str) {
        String[] split = str.split("\n", -1);
        if (split.length <= 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[0];
        StackTraceElement stackTraceElement2 = stackTrace[1];
        StackTraceElement stackTraceElement3 = stackTrace[2];
        boolean z10 = false;
        for (StackTraceElement stackTraceElement4 : th.getStackTrace()) {
            if (!z10 && (stackTraceElement4.equals(stackTraceElement) || stackTraceElement4.equals(stackTraceElement2) || stackTraceElement4.equals(stackTraceElement3))) {
                for (int i10 = 1; i10 < split.length; i10++) {
                    StackTraceElement stackTraceElement5 = toStackTraceElement(split[i10]);
                    if (stackTraceElement5 != null) {
                        arrayList.add(stackTraceElement5);
                    }
                }
                z10 = true;
            }
            arrayList.add(stackTraceElement4);
        }
        th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
    }

    public static String addJavaStack(String str, Throwable th) {
        String[] split = str.split("\n", 2);
        String str2 = split[1];
        StringBuilder sb2 = new StringBuilder(split[0]);
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[0];
        StackTraceElement stackTraceElement2 = stackTrace[1];
        StackTraceElement stackTraceElement3 = stackTrace[2];
        boolean z10 = false;
        for (StackTraceElement stackTraceElement4 : th.getStackTrace()) {
            if (!z10 && (stackTraceElement4.equals(stackTraceElement) || stackTraceElement4.equals(stackTraceElement2) || stackTraceElement4.equals(stackTraceElement3))) {
                sb2.append(str2);
                z10 = true;
            }
            sb2.append(String.format("\n    at [%s.%s] (%s:%s)", stackTraceElement4.getClassName(), stackTraceElement4.getMethodName(), stackTraceElement4.getFileName(), Integer.valueOf(stackTraceElement4.getLineNumber())));
        }
        return sb2.toString();
    }

    private static String getErrorMessage(String str) {
        int indexOf = str.indexOf(10);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    private static StackTraceElement toStackTraceElement(String str) {
        Matcher matcher = STACK_TRACE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return new StackTraceElement(matcher.group(1) == null ? STACK_TRACE_CLASS_NAME : "<javascript>", matcher.group(2), matcher.group(3), matcher.group(4) != null ? Integer.parseInt(matcher.group(4)) : 1);
    }
}
