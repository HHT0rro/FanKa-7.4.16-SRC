package sun.nio.fs;

import java.io.IOException;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import java.util.Set;
import sun.misc.Unsafe;
import sun.nio.fs.AbstractBasicFileAttributeView;
import sun.nio.fs.UnixFileAttributeViews;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class LinuxDosFileAttributeView extends UnixFileAttributeViews.Basic implements DosFileAttributeView {
    private static final int DOS_XATTR_ARCHIVE = 32;
    private static final int DOS_XATTR_HIDDEN = 2;
    private static final int DOS_XATTR_READONLY = 1;
    private static final int DOS_XATTR_SYSTEM = 4;
    private static final String HIDDEN_NAME = "hidden";
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final String DOS_XATTR_NAME = "user.DOSATTRIB";
    private static final byte[] DOS_XATTR_NAME_AS_BYTES = Util.toBytes(DOS_XATTR_NAME);
    private static final String READONLY_NAME = "readonly";
    private static final String ARCHIVE_NAME = "archive";
    private static final String SYSTEM_NAME = "system";
    private static final Set<String> dosAttributeNames = Util.newSet(basicAttributeNames, READONLY_NAME, ARCHIVE_NAME, SYSTEM_NAME, "hidden");

    LinuxDosFileAttributeView(UnixPath file, boolean followLinks) {
        super(file, followLinks);
    }

    @Override // sun.nio.fs.AbstractBasicFileAttributeView, java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
    public String name() {
        return "dos";
    }

    @Override // sun.nio.fs.AbstractBasicFileAttributeView, sun.nio.fs.DynamicFileAttributeView
    public void setAttribute(String attribute, Object value) throws IOException {
        if (attribute.equals(READONLY_NAME)) {
            setReadOnly(((Boolean) value).booleanValue());
            return;
        }
        if (attribute.equals(ARCHIVE_NAME)) {
            setArchive(((Boolean) value).booleanValue());
            return;
        }
        if (attribute.equals(SYSTEM_NAME)) {
            setSystem(((Boolean) value).booleanValue());
        } else if (attribute.equals("hidden")) {
            setHidden(((Boolean) value).booleanValue());
        } else {
            super.setAttribute(attribute, value);
        }
    }

    @Override // sun.nio.fs.AbstractBasicFileAttributeView, sun.nio.fs.DynamicFileAttributeView
    public Map<String, Object> readAttributes(String[] attributes) throws IOException {
        AbstractBasicFileAttributeView.AttributesBuilder builder = AbstractBasicFileAttributeView.AttributesBuilder.create(dosAttributeNames, attributes);
        DosFileAttributes attrs = readAttributes();
        addRequestedBasicAttributes(attrs, builder);
        if (builder.match(READONLY_NAME)) {
            builder.add(READONLY_NAME, Boolean.valueOf(attrs.isReadOnly()));
        }
        if (builder.match(ARCHIVE_NAME)) {
            builder.add(ARCHIVE_NAME, Boolean.valueOf(attrs.isArchive()));
        }
        if (builder.match(SYSTEM_NAME)) {
            builder.add(SYSTEM_NAME, Boolean.valueOf(attrs.isSystem()));
        }
        if (builder.match("hidden")) {
            builder.add("hidden", Boolean.valueOf(attrs.isHidden()));
        }
        return builder.unmodifiableMap();
    }

    @Override // sun.nio.fs.UnixFileAttributeViews.Basic, java.nio.file.attribute.BasicFileAttributeView
    public DosFileAttributes readAttributes() throws IOException {
        this.file.checkRead();
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        try {
            try {
                final UnixFileAttributes attrs = UnixFileAttributes.get(fd2);
                final int dosAttribute = getDosAttribute(fd2);
                return new DosFileAttributes() { // from class: sun.nio.fs.LinuxDosFileAttributeView.1
                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public FileTime lastModifiedTime() {
                        return attrs.lastModifiedTime();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public FileTime lastAccessTime() {
                        return attrs.lastAccessTime();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public FileTime creationTime() {
                        return attrs.creationTime();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public boolean isRegularFile() {
                        return attrs.isRegularFile();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public boolean isDirectory() {
                        return attrs.isDirectory();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public boolean isSymbolicLink() {
                        return attrs.isSymbolicLink();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public boolean isOther() {
                        return attrs.isOther();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public long size() {
                        return attrs.size();
                    }

                    @Override // java.nio.file.attribute.BasicFileAttributes
                    public Object fileKey() {
                        return attrs.fileKey();
                    }

                    @Override // java.nio.file.attribute.DosFileAttributes
                    public boolean isReadOnly() {
                        return (dosAttribute & 1) != 0;
                    }

                    @Override // java.nio.file.attribute.DosFileAttributes
                    public boolean isHidden() {
                        return (dosAttribute & 2) != 0;
                    }

                    @Override // java.nio.file.attribute.DosFileAttributes
                    public boolean isArchive() {
                        return (dosAttribute & 32) != 0;
                    }

                    @Override // java.nio.file.attribute.DosFileAttributes
                    public boolean isSystem() {
                        return (dosAttribute & 4) != 0;
                    }
                };
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
                UnixNativeDispatcher.close(fd2);
                return null;
            }
        } finally {
            UnixNativeDispatcher.close(fd2);
        }
    }

    @Override // java.nio.file.attribute.DosFileAttributeView
    public void setReadOnly(boolean value) throws IOException {
        updateDosAttribute(1, value);
    }

    @Override // java.nio.file.attribute.DosFileAttributeView
    public void setHidden(boolean value) throws IOException {
        updateDosAttribute(2, value);
    }

    @Override // java.nio.file.attribute.DosFileAttributeView
    public void setArchive(boolean value) throws IOException {
        updateDosAttribute(32, value);
    }

    @Override // java.nio.file.attribute.DosFileAttributeView
    public void setSystem(boolean value) throws IOException {
        updateDosAttribute(4, value);
    }

    private int getDosAttribute(int fd2) throws UnixException {
        NativeBuffer buffer = NativeBuffers.getNativeBuffer(24);
        try {
            try {
                int len = LinuxNativeDispatcher.fgetxattr(fd2, DOS_XATTR_NAME_AS_BYTES, buffer.address(), 24);
                if (len > 0) {
                    if (unsafe.getByte((buffer.address() + len) - 1) == 0) {
                        len--;
                    }
                    byte[] buf = new byte[len];
                    for (int i10 = 0; i10 < len; i10++) {
                        buf[i10] = unsafe.getByte(buffer.address() + i10);
                    }
                    String value = Util.toString(buf);
                    if (value.length() >= 3 && value.startsWith("0x")) {
                        try {
                            return Integer.parseInt(value.substring(2), 16);
                        } catch (NumberFormatException e2) {
                        }
                    }
                }
                throw new UnixException("Value of user.DOSATTRIB attribute is invalid");
            } catch (UnixException x10) {
                if (x10.errno() != UnixConstants.ENODATA) {
                    throw x10;
                }
                buffer.release();
                return 0;
            }
        } finally {
            buffer.release();
        }
    }

    private void updateDosAttribute(int flag, boolean enable) throws IOException {
        int newValue;
        this.file.checkWrite();
        int fd2 = this.file.openForAttributeAccess(this.followLinks);
        try {
            try {
                int oldValue = getDosAttribute(fd2);
                if (!enable) {
                    newValue = oldValue & (~flag);
                } else {
                    newValue = oldValue | flag;
                }
                if (newValue != oldValue) {
                    byte[] value = Util.toBytes("0x" + Integer.toHexString(newValue));
                    NativeBuffer buffer = NativeBuffers.asNativeBuffer(value);
                    try {
                        LinuxNativeDispatcher.fsetxattr(fd2, DOS_XATTR_NAME_AS_BYTES, buffer.address(), value.length + 1);
                        buffer.release();
                    } catch (Throwable th) {
                        buffer.release();
                        throw th;
                    }
                }
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
            }
        } finally {
            UnixNativeDispatcher.close(fd2);
        }
    }
}
