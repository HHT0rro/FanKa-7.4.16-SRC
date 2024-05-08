package com.android.internal.os;

import android.net.LocalSocket;
import java.io.FileDescriptor;
import java.lang.ref.Reference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ZygoteCommandBuffer implements AutoCloseable {
    private long mNativeBuffer;
    private final int mNativeSocket;
    private final LocalSocket mSocket;

    private static native void freeNativeBuffer(long j10);

    private static native long getNativeBuffer(int i10);

    private static native void insert(long j10, String str);

    private static native boolean nativeForkRepeatedly(long j10, int i10, int i11, int i12, String str);

    private static native int nativeGetCount(long j10);

    private static native String nativeNextArg(long j10);

    private static native void nativeReadFullyAndReset(long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZygoteCommandBuffer(LocalSocket socket) {
        this.mSocket = socket;
        if (socket == null) {
            this.mNativeSocket = -1;
        } else {
            this.mNativeSocket = socket.getFileDescriptor().getInt$();
        }
        this.mNativeBuffer = getNativeBuffer(this.mNativeSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZygoteCommandBuffer(String[] args) {
        this((LocalSocket) null);
        setCommand(args);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        freeNativeBuffer(this.mNativeBuffer);
        this.mNativeBuffer = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        try {
            return nativeGetCount(this.mNativeBuffer);
        } finally {
            Reference.reachabilityFence(this.mSocket);
        }
    }

    private void setCommand(String[] command) {
        int nArgs = command.length;
        insert(this.mNativeBuffer, Integer.toString(nArgs));
        for (String s2 : command) {
            insert(this.mNativeBuffer, s2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String nextArg() {
        try {
            return nativeNextArg(this.mNativeBuffer);
        } finally {
            Reference.reachabilityFence(this.mSocket);
        }
    }

    void readFullyAndReset() {
        try {
            nativeReadFullyAndReset(this.mNativeBuffer);
        } finally {
            Reference.reachabilityFence(this.mSocket);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean forkRepeatedly(FileDescriptor zygoteSocket, int expectedUid, int minUid, String firstNiceName) {
        try {
            return nativeForkRepeatedly(this.mNativeBuffer, zygoteSocket.getInt$(), expectedUid, minUid, firstNiceName);
        } finally {
            Reference.reachabilityFence(this.mSocket);
            Reference.reachabilityFence(zygoteSocket);
        }
    }
}
