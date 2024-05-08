package com.huawei.qcardsupport.qcard.cardmanager.impl;

import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLProtocolException;

/* compiled from: ErrorUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    public static int a(Exception exc) {
        if (exc instanceof IOException) {
            return a((IOException) exc);
        }
        return 111;
    }

    public static boolean a(int i10) {
        if (i10 == 112 || i10 == 1130 || i10 == 1139) {
            return true;
        }
        switch (i10) {
            case 1132:
            case 1133:
            case 1134:
                return true;
            default:
                return false;
        }
    }

    private static boolean b(Exception exc) {
        if (!(exc instanceof IOException) || exc.getMessage() == null) {
            return false;
        }
        return exc.getMessage().contains("Trust anchor for certification path not found");
    }

    private static boolean c(Exception exc) {
        return (exc instanceof SocketTimeoutException) || (exc.getCause() instanceof SocketTimeoutException);
    }

    public static int a(IOException iOException) {
        if (iOException == null) {
            return 113;
        }
        if (iOException instanceof SSLProtocolException) {
            return 1139;
        }
        if (c(iOException)) {
            return 112;
        }
        if (b(iOException)) {
            return b.f33214o;
        }
        String message = iOException.getMessage();
        if (message == null) {
            return 113;
        }
        if (message.contains("unexpected end of stream")) {
            return 1130;
        }
        if (message.contains("Unable to resolve host")) {
            return 1131;
        }
        if (message.contains("Read error")) {
            return 1132;
        }
        if (message.contains("Connection reset")) {
            return 1133;
        }
        if (message.contains("Software caused connection abort")) {
            return 1134;
        }
        if (message.contains("failed to connect to")) {
            return 1135;
        }
        if (message.contains("No route to host ")) {
            return 1136;
        }
        if (message.contains("Network is unreachable")) {
            return 1137;
        }
        return message.contains("Connection refused") ? 1138 : 113;
    }
}
