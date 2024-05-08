package com.android.internal.os;

import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.ProxyFileDescriptorCallback;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class FuseAppLoop implements Handler.Callback {
    private static final int ARGS_POOL_SIZE = 50;
    private static final int FUSE_FSYNC = 20;
    private static final int FUSE_GETATTR = 3;
    private static final int FUSE_LOOKUP = 1;
    private static final int FUSE_MAX_WRITE = 131072;
    private static final int FUSE_OK = 0;
    private static final int FUSE_OPEN = 14;
    private static final int FUSE_READ = 15;
    private static final int FUSE_RELEASE = 18;
    private static final int FUSE_WRITE = 16;
    private static final int MIN_INODE = 2;
    public static final int ROOT_INODE = 1;
    private long mInstance;
    private final int mMountPointId;
    private final Thread mThread;
    private static final String TAG = "FuseAppLoop";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final ThreadFactory sDefaultThreadFactory = new ThreadFactory() { // from class: com.android.internal.os.FuseAppLoop.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new Thread(r10, FuseAppLoop.TAG);
        }
    };
    private final Object mLock = new Object();
    private final SparseArray<CallbackEntry> mCallbackMap = new SparseArray<>();
    private final BytesMap mBytesMap = new BytesMap();
    private final LinkedList<Args> mArgsPool = new LinkedList<>();
    private int mNextInode = 2;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class UnmountedException extends Exception {
    }

    native void native_delete(long j10);

    native long native_new(int i10);

    native void native_replyGetAttr(long j10, long j11, long j12, long j13);

    native void native_replyLookup(long j10, long j11, long j12, long j13);

    native void native_replyOpen(long j10, long j11, long j12);

    native void native_replyRead(long j10, long j11, int i10, byte[] bArr);

    native void native_replySimple(long j10, long j11, int i10);

    native void native_replyWrite(long j10, long j11, int i10);

    native void native_start(long j10);

    public FuseAppLoop(int mountPointId, ParcelFileDescriptor fd2, ThreadFactory factory) {
        this.mMountPointId = mountPointId;
        factory = factory == null ? sDefaultThreadFactory : factory;
        this.mInstance = native_new(fd2.detachFd());
        Thread newThread = factory.newThread(new Runnable() { // from class: com.android.internal.os.FuseAppLoop$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FuseAppLoop.this.lambda$new$0();
            }
        });
        this.mThread = newThread;
        newThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        native_start(this.mInstance);
        synchronized (this.mLock) {
            native_delete(this.mInstance);
            this.mInstance = 0L;
            this.mBytesMap.clear();
        }
    }

    public int registerCallback(ProxyFileDescriptorCallback callback, Handler handler) throws FuseUnavailableMountException {
        int id2;
        synchronized (this.mLock) {
            Objects.requireNonNull(callback);
            Objects.requireNonNull(handler);
            Preconditions.checkState(this.mCallbackMap.size() < 2147483645, "Too many opened files.");
            Preconditions.checkArgument(Thread.currentThread().getId() != handler.getLooper().getThread().getId(), "Handler must be different from the current thread");
            if (this.mInstance == 0) {
                throw new FuseUnavailableMountException(this.mMountPointId);
            }
            do {
                id2 = this.mNextInode;
                int i10 = id2 + 1;
                this.mNextInode = i10;
                if (i10 < 0) {
                    this.mNextInode = 2;
                }
            } while (this.mCallbackMap.get(id2) != null);
            this.mCallbackMap.put(id2, new CallbackEntry(callback, new Handler(handler.getLooper(), this)));
        }
        return id2;
    }

    public void unregisterCallback(int id2) {
        synchronized (this.mLock) {
            this.mCallbackMap.remove(id2);
        }
    }

    public int getMountPointId() {
        return this.mMountPointId;
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException
        */
    /* JADX WARN: Failed to apply debug info
    java.lang.NullPointerException
     */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x00ba: MOVE (r14 I:??[long, double] A[D('inode' long)]) = (r19 I:??[long, double] A[D('offset' long)]), block:B:192:0x00b1 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message r26) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.FuseAppLoop.handleMessage(android.os.Message):boolean");
    }

    private void onCommand(int command, long unique, long inode, long offset, int size, byte[] data) {
        Args args;
        synchronized (this.mLock) {
            try {
                if (this.mArgsPool.size() == 0) {
                    args = new Args();
                } else {
                    args = this.mArgsPool.pop();
                }
                args.unique = unique;
                args.inode = inode;
                args.offset = offset;
                args.size = size;
                args.data = data;
                args.entry = getCallbackEntryOrThrowLocked(inode);
            } catch (Exception error) {
                replySimpleLocked(unique, getError(error));
            }
            if (!args.entry.handler.sendMessage(Message.obtain(args.entry.handler, command, 0, 0, args))) {
                throw new ErrnoException("onCommand", OsConstants.EBADF);
            }
        }
    }

    private byte[] onOpen(long unique, long inode) {
        CallbackEntry entry;
        synchronized (this.mLock) {
            try {
                entry = getCallbackEntryOrThrowLocked(inode);
            } catch (ErrnoException error) {
                replySimpleLocked(unique, getError(error));
            }
            if (entry.opened) {
                throw new ErrnoException("onOpen", OsConstants.EMFILE);
            }
            long j10 = this.mInstance;
            if (j10 != 0) {
                native_replyOpen(j10, unique, inode);
                entry.opened = true;
                return this.mBytesMap.startUsing(inode);
            }
            return null;
        }
    }

    private static int getError(Exception error) {
        int errno;
        if ((error instanceof ErrnoException) && (errno = ((ErrnoException) error).errno) != OsConstants.ENOSYS) {
            return -errno;
        }
        return -OsConstants.EBADF;
    }

    private CallbackEntry getCallbackEntryOrThrowLocked(long inode) throws ErrnoException {
        CallbackEntry entry = this.mCallbackMap.get(checkInode(inode));
        if (entry == null) {
            throw new ErrnoException("getCallbackEntryOrThrowLocked", OsConstants.ENOENT);
        }
        return entry;
    }

    private void recycleLocked(Args args) {
        if (this.mArgsPool.size() < 50) {
            this.mArgsPool.add(args);
        }
    }

    private void replySimpleLocked(long unique, int result) {
        long j10 = this.mInstance;
        if (j10 != 0) {
            native_replySimple(j10, unique, result);
        }
    }

    private static int checkInode(long inode) {
        Preconditions.checkArgumentInRange(inode, 2L, ZipUtils.UPPER_UNIXTIME_BOUND, "checkInode");
        return (int) inode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CallbackEntry {
        final ProxyFileDescriptorCallback callback;
        final Handler handler;
        boolean opened;

        CallbackEntry(ProxyFileDescriptorCallback callback, Handler handler) {
            this.callback = (ProxyFileDescriptorCallback) Objects.requireNonNull(callback);
            this.handler = (Handler) Objects.requireNonNull(handler);
        }

        long getThreadId() {
            return this.handler.getLooper().getThread().getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class BytesMapEntry {
        byte[] bytes;
        int counter;

        private BytesMapEntry() {
            this.counter = 0;
            this.bytes = new byte[131072];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class BytesMap {
        final Map<Long, BytesMapEntry> mEntries;

        private BytesMap() {
            this.mEntries = new HashMap();
        }

        byte[] startUsing(long inode) {
            BytesMapEntry entry = this.mEntries.get(Long.valueOf(inode));
            if (entry == null) {
                entry = new BytesMapEntry();
                this.mEntries.put(Long.valueOf(inode), entry);
            }
            entry.counter++;
            return entry.bytes;
        }

        void stopUsing(long inode) {
            BytesMapEntry entry = this.mEntries.get(Long.valueOf(inode));
            Objects.requireNonNull(entry);
            entry.counter--;
            if (entry.counter <= 0) {
                this.mEntries.remove(Long.valueOf(inode));
            }
        }

        void clear() {
            this.mEntries.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class Args {
        byte[] data;
        CallbackEntry entry;
        long inode;
        long offset;
        int size;
        long unique;

        private Args() {
        }
    }
}
