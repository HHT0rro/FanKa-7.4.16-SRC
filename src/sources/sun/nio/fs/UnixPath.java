package sun.nio.fs;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.file.FileSystemException;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixPath extends AbstractPath {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ThreadLocal<SoftReference<CharsetEncoder>> encoder = new ThreadLocal<>();
    private final UnixFileSystem fs;
    private int hash;
    private volatile int[] offsets;
    private final byte[] path;
    private volatile String stringValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixPath(UnixFileSystem fs, byte[] path) {
        this.fs = fs;
        this.path = path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixPath(UnixFileSystem fs, String input) {
        this(fs, encode(fs, normalizeAndCheck(input)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String normalizeAndCheck(String input) {
        int n10 = input.length();
        char prevChar = 0;
        for (int i10 = 0; i10 < n10; i10++) {
            char c4 = input.charAt(i10);
            if (c4 == '/' && prevChar == '/') {
                return normalize(input, n10, i10 - 1);
            }
            checkNotNul(input, c4);
            prevChar = c4;
        }
        if (prevChar == '/') {
            return normalize(input, n10, n10 - 1);
        }
        return input;
    }

    private static void checkNotNul(String input, char c4) {
        if (c4 == 0) {
            throw new InvalidPathException(input, "Nul character not allowed");
        }
    }

    private static String normalize(String input, int len, int off) {
        if (len == 0) {
            return input;
        }
        int n10 = len;
        while (n10 > 0 && input.charAt(n10 - 1) == '/') {
            n10--;
        }
        if (n10 == 0) {
            return "/";
        }
        StringBuilder sb2 = new StringBuilder(input.length());
        if (off > 0) {
            sb2.append(input.substring(0, off));
        }
        char prevChar = 0;
        for (int i10 = off; i10 < n10; i10++) {
            char c4 = input.charAt(i10);
            if (c4 != '/' || prevChar != '/') {
                checkNotNul(input, c4);
                sb2.append(c4);
                prevChar = c4;
            }
        }
        return sb2.toString();
    }

    private static byte[] encode(UnixFileSystem fs, String input) {
        boolean error;
        SoftReference<CharsetEncoder> ref = encoder.get();
        CharsetEncoder ce2 = ref != null ? ref.get() : null;
        if (ce2 == null) {
            ce2 = Util.jnuEncoding().newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
            encoder.set(new SoftReference<>(ce2));
        }
        char[] ca2 = fs.normalizeNativePath(input.toCharArray());
        byte[] ba2 = new byte[(int) (ca2.length * ce2.maxBytesPerChar())];
        ByteBuffer bb2 = ByteBuffer.wrap(ba2);
        CharBuffer cb2 = CharBuffer.wrap(ca2);
        ce2.reset();
        CoderResult cr = ce2.encode(cb2, bb2, true);
        if (!cr.isUnderflow()) {
            error = true;
        } else {
            CoderResult cr2 = ce2.flush(bb2);
            error = true ^ cr2.isUnderflow();
        }
        if (error) {
            throw new InvalidPathException(input, "Malformed input or input contains unmappable characters");
        }
        int len = bb2.position();
        if (len != ba2.length) {
            return Arrays.copyOf(ba2, len);
        }
        return ba2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] asByteArray() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getByteArrayForSysCalls() {
        if (getFileSystem().needToResolveAgainstDefaultDirectory()) {
            return resolve(getFileSystem().defaultDirectory(), this.path);
        }
        if (!isEmpty()) {
            return this.path;
        }
        byte[] here = {46};
        return here;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPathForExceptionMessage() {
        return toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPathForPermissionCheck() {
        if (getFileSystem().needToResolveAgainstDefaultDirectory()) {
            return Util.toString(getByteArrayForSysCalls());
        }
        return toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnixPath toUnixPath(Path obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        if (!(obj instanceof UnixPath)) {
            throw new ProviderMismatchException();
        }
        return (UnixPath) obj;
    }

    private void initOffsets() {
        if (this.offsets == null) {
            int count = 0;
            int index = 0;
            if (!isEmpty()) {
                while (true) {
                    byte[] bArr = this.path;
                    if (index >= bArr.length) {
                        break;
                    }
                    int index2 = index + 1;
                    byte c4 = bArr[index];
                    if (c4 == 47) {
                        index = index2;
                    } else {
                        count++;
                        while (true) {
                            byte[] bArr2 = this.path;
                            if (index2 >= bArr2.length || bArr2[index2] == 47) {
                                break;
                            } else {
                                index2++;
                            }
                        }
                        index = index2;
                    }
                }
            } else {
                count = 1;
            }
            int[] result = new int[count];
            int count2 = 0;
            int index3 = 0;
            while (true) {
                byte[] bArr3 = this.path;
                if (index3 >= bArr3.length) {
                    break;
                }
                byte c10 = bArr3[index3];
                if (c10 == 47) {
                    index3++;
                } else {
                    int count3 = count2 + 1;
                    int index4 = index3 + 1;
                    result[count2] = index3;
                    while (true) {
                        byte[] bArr4 = this.path;
                        if (index4 >= bArr4.length || bArr4[index4] == 47) {
                            break;
                        } else {
                            index4++;
                        }
                    }
                    count2 = count3;
                    index3 = index4;
                }
            }
            synchronized (this) {
                if (this.offsets == null) {
                    this.offsets = result;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.path.length == 0;
    }

    private UnixPath emptyPath() {
        return new UnixPath(getFileSystem(), new byte[0]);
    }

    @Override // java.nio.file.Path
    public UnixFileSystem getFileSystem() {
        return this.fs;
    }

    @Override // java.nio.file.Path
    public UnixPath getRoot() {
        byte[] bArr = this.path;
        if (bArr.length > 0 && bArr[0] == 47) {
            return getFileSystem().rootDirectory();
        }
        return null;
    }

    @Override // java.nio.file.Path
    public UnixPath getFileName() {
        initOffsets();
        int count = this.offsets.length;
        if (count == 0) {
            return null;
        }
        if (count == 1) {
            byte[] bArr = this.path;
            if (bArr.length > 0 && bArr[0] != 47) {
                return this;
            }
        }
        int lastOffset = this.offsets[count - 1];
        byte[] bArr2 = this.path;
        int len = bArr2.length - lastOffset;
        byte[] result = new byte[len];
        System.arraycopy((Object) bArr2, lastOffset, (Object) result, 0, len);
        return new UnixPath(getFileSystem(), result);
    }

    @Override // java.nio.file.Path
    public UnixPath getParent() {
        initOffsets();
        int count = this.offsets.length;
        if (count == 0) {
            return null;
        }
        int len = this.offsets[count - 1] - 1;
        if (len <= 0) {
            return getRoot();
        }
        byte[] result = new byte[len];
        System.arraycopy((Object) this.path, 0, (Object) result, 0, len);
        return new UnixPath(getFileSystem(), result);
    }

    @Override // java.nio.file.Path
    public int getNameCount() {
        initOffsets();
        return this.offsets.length;
    }

    @Override // java.nio.file.Path
    public UnixPath getName(int index) {
        int len;
        initOffsets();
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index >= this.offsets.length) {
            throw new IllegalArgumentException();
        }
        int begin = this.offsets[index];
        if (index == this.offsets.length - 1) {
            len = this.path.length - begin;
        } else {
            len = (this.offsets[index + 1] - begin) - 1;
        }
        byte[] result = new byte[len];
        System.arraycopy((Object) this.path, begin, (Object) result, 0, len);
        return new UnixPath(getFileSystem(), result);
    }

    @Override // java.nio.file.Path
    public UnixPath subpath(int beginIndex, int endIndex) {
        int len;
        initOffsets();
        if (beginIndex < 0) {
            throw new IllegalArgumentException();
        }
        if (beginIndex >= this.offsets.length) {
            throw new IllegalArgumentException();
        }
        if (endIndex > this.offsets.length) {
            throw new IllegalArgumentException();
        }
        if (beginIndex >= endIndex) {
            throw new IllegalArgumentException();
        }
        int begin = this.offsets[beginIndex];
        if (endIndex == this.offsets.length) {
            len = this.path.length - begin;
        } else {
            len = (this.offsets[endIndex] - begin) - 1;
        }
        byte[] result = new byte[len];
        System.arraycopy((Object) this.path, begin, (Object) result, 0, len);
        return new UnixPath(getFileSystem(), result);
    }

    @Override // java.nio.file.Path
    public boolean isAbsolute() {
        byte[] bArr = this.path;
        return bArr.length > 0 && bArr[0] == 47;
    }

    private static byte[] resolve(byte[] base, byte[] child) {
        int baseLength = base.length;
        int childLength = child.length;
        if (childLength == 0) {
            return base;
        }
        if (baseLength == 0 || child[0] == 47) {
            return child;
        }
        if (baseLength == 1 && base[0] == 47) {
            byte[] result = new byte[childLength + 1];
            result[0] = 47;
            System.arraycopy((Object) child, 0, (Object) result, 1, childLength);
            return result;
        }
        byte[] result2 = new byte[baseLength + 1 + childLength];
        System.arraycopy((Object) base, 0, (Object) result2, 0, baseLength);
        result2[base.length] = 47;
        System.arraycopy((Object) child, 0, (Object) result2, baseLength + 1, childLength);
        return result2;
    }

    @Override // java.nio.file.Path
    public UnixPath resolve(Path obj) {
        byte[] other = toUnixPath(obj).path;
        if (other.length > 0 && other[0] == 47) {
            return (UnixPath) obj;
        }
        byte[] result = resolve(this.path, other);
        return new UnixPath(getFileSystem(), result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixPath resolve(byte[] other) {
        return resolve((Path) new UnixPath(getFileSystem(), other));
    }

    @Override // java.nio.file.Path
    public UnixPath relativize(Path obj) {
        UnixPath other = toUnixPath(obj);
        if (other.equals(this)) {
            return emptyPath();
        }
        if (isAbsolute() != other.isAbsolute()) {
            throw new IllegalArgumentException("'other' is different type of Path");
        }
        if (isEmpty()) {
            return other;
        }
        int bn = getNameCount();
        int cn2 = other.getNameCount();
        int n10 = bn > cn2 ? cn2 : bn;
        int i10 = 0;
        while (i10 < n10 && getName(i10).equals(other.getName(i10))) {
            i10++;
        }
        int dotdots = bn - i10;
        if (i10 < cn2) {
            UnixPath remainder = other.subpath(i10, cn2);
            if (dotdots == 0) {
                return remainder;
            }
            boolean isOtherEmpty = other.isEmpty();
            int len = (dotdots * 3) + remainder.path.length;
            if (isOtherEmpty) {
                len--;
            }
            byte[] result = new byte[len];
            int pos = 0;
            while (dotdots > 0) {
                int pos2 = pos + 1;
                result[pos] = 46;
                pos = pos2 + 1;
                result[pos2] = 46;
                if (!isOtherEmpty) {
                    result[pos] = 47;
                    pos++;
                } else if (dotdots > 1) {
                    result[pos] = 47;
                    pos++;
                }
                dotdots--;
            }
            byte[] bArr = remainder.path;
            System.arraycopy((Object) bArr, 0, (Object) result, pos, bArr.length);
            return new UnixPath(getFileSystem(), result);
        }
        byte[] result2 = new byte[(dotdots * 3) - 1];
        int pos3 = 0;
        while (dotdots > 0) {
            int pos4 = pos3 + 1;
            result2[pos3] = 46;
            pos3 = pos4 + 1;
            result2[pos4] = 46;
            if (dotdots > 1) {
                result2[pos3] = 47;
                pos3++;
            }
            dotdots--;
        }
        return new UnixPath(getFileSystem(), result2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00f7, code lost:
    
        return new sun.nio.fs.UnixPath(getFileSystem(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r4 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r6 = r3;
        r9 = -1;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (r10 >= r0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r1[r10] == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        if (r2[r10] == 2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0094, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
    
        r11 = r15.offsets[r10];
        r12 = r15.path;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        if (r12[r11] != 46) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        if (r12[r11 + 1] == 46) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r9 < 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
    
        r1[r9] = true;
        r1[r10] = true;
        r3 = r3 - 2;
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
    
        if (r5 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007e, code lost:
    
        r12 = false;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0080, code lost:
    
        if (r13 >= r10) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        if (r1[r13] != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
    
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        if (r12 != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
    
        r1[r10] = true;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0092, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0097, code lost:
    
        if (r6 > r3) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0099, code lost:
    
        if (r3 != r0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x009b, code lost:
    
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x009c, code lost:
    
        if (r3 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x009e, code lost:
    
        if (r5 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return getFileSystem().rootDirectory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ad, code lost:
    
        return emptyPath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ae, code lost:
    
        r6 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00b0, code lost:
    
        if (r5 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00b2, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00b4, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00b5, code lost:
    
        if (r7 >= r0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00b9, code lost:
    
        if (r1[r7] != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00bb, code lost:
    
        r6 = r6 + r2[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00be, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00c1, code lost:
    
        r7 = new byte[r6];
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c6, code lost:
    
        if (r5 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c8, code lost:
    
        r10 = 0 + 1;
        r7[0] = 47;
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00cd, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00ce, code lost:
    
        if (r10 >= r0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00d2, code lost:
    
        if (r1[r10] != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00d4, code lost:
    
        java.lang.System.arraycopy((java.lang.Object) r15.path, r15.offsets[r10], (java.lang.Object) r7, r8, r2[r10]);
        r8 = r8 + r2[r10];
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e4, code lost:
    
        if (r3 <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00e6, code lost:
    
        r7[r8] = 47;
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00eb, code lost:
    
        r10 = r10 + 1;
     */
    @Override // java.nio.file.Path
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.file.Path normalize() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.UnixPath.normalize():java.nio.file.Path");
    }

    @Override // java.nio.file.Path
    public boolean startsWith(Path other) {
        if (!(Objects.requireNonNull(other) instanceof UnixPath)) {
            return false;
        }
        UnixPath that = (UnixPath) other;
        if (that.path.length > this.path.length) {
            return false;
        }
        int thisOffsetCount = getNameCount();
        int thatOffsetCount = that.getNameCount();
        if (thatOffsetCount == 0 && isAbsolute()) {
            return !that.isEmpty();
        }
        if (thatOffsetCount > thisOffsetCount) {
            return false;
        }
        if (thatOffsetCount == thisOffsetCount && this.path.length != that.path.length) {
            return false;
        }
        for (int i10 = 0; i10 < thatOffsetCount; i10++) {
            Integer o12 = Integer.valueOf(this.offsets[i10]);
            Integer o22 = Integer.valueOf(that.offsets[i10]);
            if (!o12.equals(o22)) {
                return false;
            }
        }
        int i11 = 0;
        while (true) {
            byte[] bArr = that.path;
            if (i11 < bArr.length) {
                if (this.path[i11] != bArr[i11]) {
                    return false;
                }
                i11++;
            } else {
                byte[] bArr2 = this.path;
                return i11 >= bArr2.length || bArr2[i11] == 47;
            }
        }
    }

    @Override // java.nio.file.Path
    public boolean endsWith(Path other) {
        int thisOffsetCount;
        int thatOffsetCount;
        if (!(Objects.requireNonNull(other) instanceof UnixPath)) {
            return false;
        }
        UnixPath that = (UnixPath) other;
        int thisLen = this.path.length;
        int thatLen = that.path.length;
        if (thatLen > thisLen) {
            return false;
        }
        if (thisLen > 0 && thatLen == 0) {
            return false;
        }
        if ((that.isAbsolute() && !isAbsolute()) || (thatOffsetCount = that.getNameCount()) > (thisOffsetCount = getNameCount())) {
            return false;
        }
        if (thatOffsetCount == thisOffsetCount) {
            if (thisOffsetCount == 0) {
                return true;
            }
            int expectedLen = thisLen;
            if (isAbsolute() && !that.isAbsolute()) {
                expectedLen--;
            }
            if (thatLen != expectedLen) {
                return false;
            }
        } else if (that.isAbsolute()) {
            return false;
        }
        int thisPos = this.offsets[thisOffsetCount - thatOffsetCount];
        int thatPos = that.offsets[0];
        if (thatLen - thatPos != thisLen - thisPos) {
            return false;
        }
        while (thatPos < thatLen) {
            int thisPos2 = thisPos + 1;
            int thatPos2 = thatPos + 1;
            if (this.path[thisPos] != that.path[thatPos]) {
                return false;
            }
            thisPos = thisPos2;
            thatPos = thatPos2;
        }
        return true;
    }

    @Override // java.nio.file.Path, java.lang.Comparable
    public int compareTo(Path other) {
        int len1 = this.path.length;
        int len2 = ((UnixPath) other).path.length;
        int n10 = Math.min(len1, len2);
        byte[] v12 = this.path;
        byte[] v2 = ((UnixPath) other).path;
        for (int k10 = 0; k10 < n10; k10++) {
            int c12 = v12[k10] & 255;
            int c22 = v2[k10] & 255;
            if (c12 != c22) {
                return c12 - c22;
            }
        }
        return len1 - len2;
    }

    @Override // java.nio.file.Path
    public boolean equals(Object ob2) {
        return ob2 != null && (ob2 instanceof UnixPath) && compareTo((Path) ob2) == 0;
    }

    @Override // java.nio.file.Path
    public int hashCode() {
        int h10 = this.hash;
        if (h10 == 0) {
            int i10 = 0;
            while (true) {
                byte[] bArr = this.path;
                if (i10 >= bArr.length) {
                    break;
                }
                h10 = (h10 * 31) + (bArr[i10] & 255);
                i10++;
            }
            this.hash = h10;
        }
        return h10;
    }

    @Override // java.nio.file.Path
    public String toString() {
        if (this.stringValue == null) {
            this.stringValue = this.fs.normalizeJavaPath(Util.toString(this.path));
        }
        return this.stringValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int openForAttributeAccess(boolean followLinks) throws IOException {
        int flags = UnixConstants.O_RDONLY;
        if (!followLinks) {
            if (UnixConstants.O_NOFOLLOW == 0) {
                throw new IOException("NOFOLLOW_LINKS is not supported on this platform");
            }
            flags |= UnixConstants.O_NOFOLLOW;
        }
        try {
            return UnixNativeDispatcher.open(this, flags, 0);
        } catch (UnixException x10) {
            if (getFileSystem().isSolaris() && x10.errno() == UnixConstants.EINVAL) {
                x10.setError(UnixConstants.ELOOP);
            }
            if (x10.errno() == UnixConstants.ELOOP) {
                throw new FileSystemException(getPathForExceptionMessage(), null, x10.getMessage() + " or unable to access attributes of symbolic link");
            }
            x10.rethrowAsIOException(this);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkRead() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkRead(getPathForPermissionCheck());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkWrite() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkWrite(getPathForPermissionCheck());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkDelete() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkDelete(getPathForPermissionCheck());
        }
    }

    @Override // java.nio.file.Path
    public UnixPath toAbsolutePath() {
        if (isAbsolute()) {
            return this;
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPropertyAccess("user.dir");
        }
        return new UnixPath(getFileSystem(), resolve(getFileSystem().defaultDirectory(), this.path));
    }

    @Override // java.nio.file.Path
    public Path toRealPath(LinkOption... options) throws IOException {
        checkRead();
        UnixPath absolute = toAbsolutePath();
        if (Util.followLinks(options)) {
            try {
                byte[] rp = UnixNativeDispatcher.realpath(absolute);
                return new UnixPath(getFileSystem(), rp);
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this);
            }
        }
        UnixPath result = this.fs.rootDirectory();
        for (int i10 = 0; i10 < absolute.getNameCount(); i10++) {
            UnixPath element = absolute.getName(i10);
            if (element.asByteArray().length != 1 || element.asByteArray()[0] != 46) {
                if (element.asByteArray().length == 2 && element.asByteArray()[0] == 46 && element.asByteArray()[1] == 46) {
                    UnixFileAttributes attrs = null;
                    try {
                        attrs = UnixFileAttributes.get(result, false);
                    } catch (UnixException x11) {
                        x11.rethrowAsIOException(result);
                    }
                    if (!attrs.isSymbolicLink()) {
                        result = result.getParent();
                        if (result == null) {
                            result = this.fs.rootDirectory();
                        }
                    }
                }
                result = result.resolve((Path) element);
            }
        }
        try {
            UnixFileAttributes.get(result, false);
        } catch (UnixException x12) {
            x12.rethrowAsIOException(result);
        }
        return result;
    }

    @Override // java.nio.file.Path
    public URI toUri() {
        return UnixUriUtils.toUri(this);
    }

    @Override // java.nio.file.Path, java.nio.file.Watchable
    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        if (watcher == null) {
            throw new NullPointerException();
        }
        if (!(watcher instanceof AbstractWatchService)) {
            throw new ProviderMismatchException();
        }
        checkRead();
        return ((AbstractWatchService) watcher).register(this, events, modifiers);
    }
}
