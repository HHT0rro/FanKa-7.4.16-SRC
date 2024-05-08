package sun.nio.fs;

import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class AbstractUserDefinedFileAttributeView implements UserDefinedFileAttributeView, DynamicFileAttributeView {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkAccess(String file, boolean checkRead, boolean checkWrite) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            if (checkRead) {
                sm.checkRead(file);
            }
            if (checkWrite) {
                sm.checkWrite(file);
            }
            sm.checkPermission(new RuntimePermission("accessUserDefinedAttributes"));
        }
    }

    @Override // java.nio.file.attribute.UserDefinedFileAttributeView, java.nio.file.attribute.AttributeView
    public final String name() {
        return UserData.NAME;
    }

    @Override // sun.nio.fs.DynamicFileAttributeView
    public final void setAttribute(String attribute, Object value) throws IOException {
        ByteBuffer bb2;
        if (value instanceof byte[]) {
            bb2 = ByteBuffer.wrap((byte[]) value);
        } else {
            bb2 = (ByteBuffer) value;
        }
        write(attribute, bb2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r1 = new java.util.HashMap<>();
        r2 = r0.iterator2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r2.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        r3 = r2.next();
        r4 = size(r3);
        r5 = new byte[r4];
        r6 = read(r3, java.nio.ByteBuffer.wrap(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        if (r6 != r4) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        r1.put(r3, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r7 = java.util.Arrays.copyOf(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        return r1;
     */
    @Override // sun.nio.fs.DynamicFileAttributeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.Object> readAttributes(java.lang.String[] r9) throws java.io.IOException {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r9.length
            r2 = 0
        L7:
            if (r2 >= r1) goto L2a
            r3 = r9[r2]
            java.lang.String r4 = "*"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L18
            java.util.List r0 = r8.list()
            goto L2a
        L18:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L24
            r0.add(r3)
            int r2 = r2 + 1
            goto L7
        L24:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L2a:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Iterator r2 = r0.iterator2()
        L33:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r8.size(r3)
            byte[] r5 = new byte[r4]
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r5)
            int r6 = r8.read(r3, r6)
            if (r6 != r4) goto L51
            r7 = r5
            goto L55
        L51:
            byte[] r7 = java.util.Arrays.copyOf(r5, r6)
        L55:
            r1.put(r3, r7)
            goto L33
        L59:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.AbstractUserDefinedFileAttributeView.readAttributes(java.lang.String[]):java.util.Map");
    }
}
