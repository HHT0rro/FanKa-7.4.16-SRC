package com.irisdt.util;

import android.util.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Logger {
    private String mTAG;

    /* renamed from: com.irisdt.util.Logger$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$irisdt$util$Logger$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$com$irisdt$util$Logger$TYPE = iArr;
            try {
                iArr[TYPE.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$irisdt$util$Logger$TYPE[TYPE.Info.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$irisdt$util$Logger$TYPE[TYPE.Debug.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$irisdt$util$Logger$TYPE[TYPE.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$irisdt$util$Logger$TYPE[TYPE.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum TYPE {
        Verbose,
        Info,
        Debug,
        Warn,
        Error
    }

    public Logger(String str) {
        this.mTAG = str;
    }

    private static String getMessage(Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            if (obj == null) {
                sb2.append("null");
            } else if (obj instanceof Throwable) {
                sb2.append(Log.getStackTraceString((Throwable) obj));
                sb2.append("\n");
            } else {
                sb2.append(obj.toString());
            }
        }
        return sb2.toString();
    }

    private void printLog(TYPE type, Object... objArr) {
        String message = getMessage(objArr);
        int length = message.length();
        if (length > 4000) {
            int i10 = (length / 2000) + (length % 2000 == 0 ? 0 : 1);
            int i11 = 0;
            int i12 = 1;
            while (i11 < length) {
                int i13 = i11 + 2000;
                if (i13 >= length) {
                    i13 = length;
                }
                printLog(type, String.format("[%d/%d] %s", Integer.valueOf(i12), Integer.valueOf(i10), message.substring(i11, i13)));
                i12++;
                i11 = i13;
            }
            return;
        }
        printLog(type, message);
    }

    public void d(Object... objArr) {
        printLog(TYPE.Debug, objArr);
    }

    public void e(Object... objArr) {
        printLog(TYPE.Error, objArr);
    }

    public void i(Object... objArr) {
        printLog(TYPE.Info, objArr);
    }

    public void v(Object... objArr) {
        printLog(TYPE.Verbose, objArr);
    }

    public void w(Object... objArr) {
        printLog(TYPE.Warn, objArr);
    }

    private void printLog(TYPE type, String str) {
        int i10 = AnonymousClass1.$SwitchMap$com$irisdt$util$Logger$TYPE[type.ordinal()];
    }
}
