package com.huawei.ok3httpservice;

import androidx.annotation.NonNull;
import com.huawei.serverrequest.api.service.HttpException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLProtocolException;

/* compiled from: ErrorUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    public static boolean a(@NonNull HttpException httpException) {
        if (!(httpException.getCause() instanceof IOException)) {
            return false;
        }
        IOException iOException = (IOException) httpException.getCause();
        if ((iOException instanceof SSLProtocolException) || a(iOException)) {
            return true;
        }
        String message = iOException.getMessage();
        if (message == null) {
            return false;
        }
        return message.contains("unexpected end of stream") || message.contains("Read error") || message.contains("Connection reset") || message.contains("Software caused connection abort");
    }

    private static boolean a(Exception exc) {
        return (exc instanceof SocketTimeoutException) || (exc.getCause() instanceof SocketTimeoutException);
    }
}
