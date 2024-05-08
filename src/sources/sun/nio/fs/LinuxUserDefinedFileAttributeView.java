package sun.nio.fs;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class LinuxUserDefinedFileAttributeView extends AbstractUserDefinedFileAttributeView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String USER_NAMESPACE = "user.";
    private static final int XATTR_NAME_MAX = 255;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private final UnixPath file;
    private final boolean followLinks;

    private byte[] nameAsBytes(UnixPath file, String name) throws IOException {
        if (name == null) {
            throw new NullPointerException("'name' is null");
        }
        String name2 = USER_NAMESPACE + name;
        byte[] bytes = Util.toBytes(name2);
        if (bytes.length > 255) {
            throw new FileSystemException(file.getPathForExceptionMessage(), null, "'" + name2 + "' is too big");
        }
        return bytes;
    }

    private List<String> asList(long address, int size) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int pos = 0; pos < size; pos++) {
            if (unsafe.getByte(pos + address) == 0) {
                int len = pos - start;
                byte[] value = new byte[len];
                for (int i10 = 0; i10 < len; i10++) {
                    value[i10] = unsafe.getByte(start + address + i10);
                }
                String s2 = Util.toString(value);
                if (s2.startsWith(USER_NAMESPACE)) {
                    list.add(s2.substring(USER_NAMESPACE.length()));
                }
                start = pos + 1;
            }
        }
        return list;
    }

    LinuxUserDefinedFileAttributeView(UnixPath file, boolean followLinks) {
        this.file = file;
        this.followLinks = followLinks;
    }

    @Override // java.nio.file.attribute.UserDefinedFileAttributeView
    public List<String> list() throws IOException {
        if (System.getSecurityManager() != null) {
            checkAccess(this.file.getPathForPermissionCheck(), true, false);
        }
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        NativeBuffer buffer = null;
        int size = 1024;
        try {
            buffer = NativeBuffers.getNativeBuffer(1024);
            while (true) {
                try {
                    int n10 = LinuxNativeDispatcher.flistxattr(fd2, buffer.address(), size);
                    List<String> list = asList(buffer.address(), n10);
                    return Collections.unmodifiableList(list);
                } catch (UnixException x10) {
                    if (x10.errno() == UnixConstants.ERANGE && size < 32768) {
                        buffer.release();
                        size *= 2;
                        buffer = NativeBuffers.getNativeBuffer(size);
                    } else {
                        throw new FileSystemException(this.file.getPathForExceptionMessage(), null, "Unable to get list of extended attributes: " + x10.getMessage());
                    }
                }
            }
            throw new FileSystemException(this.file.getPathForExceptionMessage(), null, "Unable to get list of extended attributes: " + x10.getMessage());
        } finally {
            if (buffer != null) {
                buffer.release();
            }
            LinuxNativeDispatcher.close(fd2);
        }
    }

    @Override // java.nio.file.attribute.UserDefinedFileAttributeView
    public int size(String name) throws IOException {
        if (System.getSecurityManager() != null) {
            checkAccess(this.file.getPathForPermissionCheck(), true, false);
        }
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        try {
            try {
                return LinuxNativeDispatcher.fgetxattr(fd2, nameAsBytes(this.file, name), 0L, 0);
            } catch (UnixException x10) {
                throw new FileSystemException(this.file.getPathForExceptionMessage(), null, "Unable to get size of extended attribute '" + name + "': " + x10.getMessage());
            }
        } finally {
            LinuxNativeDispatcher.close(fd2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.file.attribute.UserDefinedFileAttributeView
    public int read(String name, ByteBuffer byteBuffer) throws IOException {
        NativeBuffer nb2;
        long address;
        if (System.getSecurityManager() != null) {
            checkAccess(this.file.getPathForPermissionCheck(), true, false);
        }
        if (byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
        int pos = byteBuffer.position();
        int lim = byteBuffer.limit();
        int rem = pos <= lim ? lim - pos : 0;
        if (byteBuffer instanceof DirectBuffer) {
            nb2 = null;
            address = ((DirectBuffer) byteBuffer).address() + pos;
        } else {
            nb2 = NativeBuffers.getNativeBuffer(rem);
            address = nb2.address();
        }
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        try {
            try {
                try {
                    int n10 = LinuxNativeDispatcher.fgetxattr(fd2, nameAsBytes(this.file, name), address, rem);
                    if (rem == 0) {
                        if (n10 <= 0) {
                            return 0;
                        }
                        throw new UnixException(UnixConstants.ERANGE);
                    }
                    if (nb2 != null) {
                        for (int i10 = 0; i10 < n10; i10++) {
                            byteBuffer.put(unsafe.getByte(i10 + address));
                        }
                    }
                    int i11 = pos + n10;
                    byteBuffer.position(i11);
                    if (nb2 != null) {
                        nb2.release();
                    }
                    return n10;
                } catch (UnixException x10) {
                    String msg = x10.errno() == UnixConstants.ERANGE ? "Insufficient space in buffer" : x10.getMessage();
                    throw new FileSystemException(this.file.getPathForExceptionMessage(), null, "Error reading extended attribute '" + name + "': " + msg);
                }
            } finally {
                LinuxNativeDispatcher.close(fd2);
            }
        } finally {
            if (nb2 != null) {
                nb2.release();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.file.attribute.UserDefinedFileAttributeView
    public int write(String name, ByteBuffer byteBuffer) throws IOException {
        NativeBuffer nb2;
        long address;
        if (System.getSecurityManager() != null) {
            checkAccess(this.file.getPathForPermissionCheck(), false, true);
        }
        int pos = byteBuffer.position();
        int lim = byteBuffer.limit();
        int rem = pos <= lim ? lim - pos : 0;
        if (byteBuffer instanceof DirectBuffer) {
            nb2 = null;
            address = ((DirectBuffer) byteBuffer).address() + pos;
        } else {
            nb2 = NativeBuffers.getNativeBuffer(rem);
            address = nb2.address();
            if (byteBuffer.hasArray()) {
                for (int i10 = 0; i10 < rem; i10++) {
                    unsafe.putByte(i10 + address, byteBuffer.get());
                }
            } else {
                byte[] tmp = new byte[rem];
                byteBuffer.get(tmp);
                byteBuffer.position(pos);
                for (int i11 = 0; i11 < rem; i11++) {
                    unsafe.putByte(i11 + address, tmp[i11]);
                }
            }
        }
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        try {
            try {
                try {
                    LinuxNativeDispatcher.fsetxattr(fd2, nameAsBytes(this.file, name), address, rem);
                    byteBuffer.position(pos + rem);
                    return rem;
                } finally {
                    if (nb2 != null) {
                        nb2.release();
                    }
                }
            } catch (UnixException x10) {
                throw new FileSystemException(this.file.getPathForExceptionMessage(), null, "Error writing extended attribute '" + name + "': " + x10.getMessage());
            }
        } finally {
            LinuxNativeDispatcher.close(fd2);
        }
    }

    @Override // java.nio.file.attribute.UserDefinedFileAttributeView
    public void delete(String name) throws IOException {
        if (System.getSecurityManager() != null) {
            checkAccess(this.file.getPathForPermissionCheck(), false, true);
        }
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        try {
            try {
                LinuxNativeDispatcher.fremovexattr(fd2, nameAsBytes(this.file, name));
            } catch (UnixException x10) {
                throw new FileSystemException(this.file.getPathForExceptionMessage(), null, "Unable to delete extended attribute '" + name + "': " + x10.getMessage());
            }
        } finally {
            LinuxNativeDispatcher.close(fd2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0012, code lost:
    
        r2 = r0.address();
        r4 = 0;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r5 >= r2) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (sun.nio.fs.LinuxUserDefinedFileAttributeView.unsafe.getByte(r5 + r2) != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r6 = r5 - r4;
        r7 = new byte[r6];
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r8 >= r6) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        r7[r8] = sun.nio.fs.LinuxUserDefinedFileAttributeView.unsafe.getByte((r4 + r2) + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        copyExtendedAttribute(r14, r7, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        if (r0 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        r0.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void copyExtendedAttributes(int r14, int r15) {
        /*
            r0 = 0
            r1 = 1024(0x400, float:1.435E-42)
            sun.nio.fs.NativeBuffer r2 = sun.nio.fs.NativeBuffers.getNativeBuffer(r1)     // Catch: java.lang.Throwable -> L6a
            r0 = r2
        L8:
            long r2 = r0.address()     // Catch: sun.nio.fs.UnixException -> L4a java.lang.Throwable -> L6a
            int r2 = sun.nio.fs.LinuxNativeDispatcher.flistxattr(r14, r2, r1)     // Catch: sun.nio.fs.UnixException -> L4a java.lang.Throwable -> L6a
            r1 = r2
            long r2 = r0.address()     // Catch: java.lang.Throwable -> L6a
            r4 = 0
            r5 = 0
        L18:
            if (r5 >= r1) goto L44
            sun.misc.Unsafe r6 = sun.nio.fs.LinuxUserDefinedFileAttributeView.unsafe     // Catch: java.lang.Throwable -> L6a
            long r7 = (long) r5     // Catch: java.lang.Throwable -> L6a
            long r7 = r7 + r2
            byte r6 = r6.getByte(r7)     // Catch: java.lang.Throwable -> L6a
            if (r6 != 0) goto L41
            int r6 = r5 - r4
            byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> L6a
            r8 = 0
        L29:
            if (r8 >= r6) goto L3a
            sun.misc.Unsafe r9 = sun.nio.fs.LinuxUserDefinedFileAttributeView.unsafe     // Catch: java.lang.Throwable -> L6a
            long r10 = (long) r4     // Catch: java.lang.Throwable -> L6a
            long r10 = r10 + r2
            long r12 = (long) r8     // Catch: java.lang.Throwable -> L6a
            long r10 = r10 + r12
            byte r9 = r9.getByte(r10)     // Catch: java.lang.Throwable -> L6a
            r7[r8] = r9     // Catch: java.lang.Throwable -> L6a
            int r8 = r8 + 1
            goto L29
        L3a:
            copyExtendedAttribute(r14, r7, r15)     // Catch: sun.nio.fs.UnixException -> L3e java.lang.Throwable -> L6a
            goto L3f
        L3e:
            r8 = move-exception
        L3f:
            int r4 = r5 + 1
        L41:
            int r5 = r5 + 1
            goto L18
        L44:
            if (r0 == 0) goto L49
            r0.release()
        L49:
            return
        L4a:
            r2 = move-exception
            int r3 = r2.errno()     // Catch: java.lang.Throwable -> L6a
            int r4 = sun.nio.fs.UnixConstants.ERANGE     // Catch: java.lang.Throwable -> L6a
            if (r3 != r4) goto L64
            r3 = 32768(0x8000, float:4.5918E-41)
            if (r1 >= r3) goto L64
            r0.release()     // Catch: java.lang.Throwable -> L6a
            int r1 = r1 * 2
            r0 = 0
            sun.nio.fs.NativeBuffer r3 = sun.nio.fs.NativeBuffers.getNativeBuffer(r1)     // Catch: java.lang.Throwable -> L6a
            r0 = r3
            goto L8
        L64:
            if (r0 == 0) goto L69
            r0.release()
        L69:
            return
        L6a:
            r1 = move-exception
            if (r0 == 0) goto L70
            r0.release()
        L70:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.LinuxUserDefinedFileAttributeView.copyExtendedAttributes(int, int):void");
    }

    private static void copyExtendedAttribute(int ofd, byte[] name, int nfd) throws UnixException {
        int size = LinuxNativeDispatcher.fgetxattr(ofd, name, 0L, 0);
        NativeBuffer buffer = NativeBuffers.getNativeBuffer(size);
        try {
            long address = buffer.address();
            LinuxNativeDispatcher.fsetxattr(nfd, name, address, LinuxNativeDispatcher.fgetxattr(ofd, name, address, size));
        } finally {
            buffer.release();
        }
    }
}
