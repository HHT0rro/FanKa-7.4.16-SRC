package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TrafficStatsCompat {

    @RequiresApi(24)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.tagDatagramSocket(datagramSocket);
        }

        @DoNotInline
        public static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.untagDatagramSocket(datagramSocket);
        }
    }

    private TrafficStatsCompat() {
    }

    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void incrementOperationCount(int i10) {
        TrafficStats.incrementOperationCount(i10);
    }

    @Deprecated
    public static void setThreadStatsTag(int i10) {
        TrafficStats.setThreadStatsTag(i10);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.tagDatagramSocket(datagramSocket);
            return;
        }
        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.tagSocket(new DatagramSocketWrapper(datagramSocket, fromDatagramSocket.getFileDescriptor()));
        fromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.untagDatagramSocket(datagramSocket);
            return;
        }
        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.untagSocket(new DatagramSocketWrapper(datagramSocket, fromDatagramSocket.getFileDescriptor()));
        fromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }

    @Deprecated
    public static void incrementOperationCount(int i10, int i11) {
        TrafficStats.incrementOperationCount(i10, i11);
    }
}