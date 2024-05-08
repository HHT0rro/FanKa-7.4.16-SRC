package java.util.jar;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarOutputStream extends ZipOutputStream {
    private static final int JAR_MAGIC = 51966;
    private boolean firstEntry;

    public JarOutputStream(OutputStream out, Manifest man) throws IOException {
        super(out);
        this.firstEntry = true;
        if (man == null) {
            throw new NullPointerException("man");
        }
        ZipEntry e2 = new ZipEntry(JarFile.MANIFEST_NAME);
        putNextEntry(e2);
        man.write(new BufferedOutputStream(this));
        closeEntry();
    }

    public JarOutputStream(OutputStream out) throws IOException {
        super(out);
        this.firstEntry = true;
    }

    @Override // java.util.zip.ZipOutputStream
    public void putNextEntry(ZipEntry ze) throws IOException {
        byte[] edata;
        if (this.firstEntry) {
            byte[] edata2 = ze.getExtra();
            if (edata2 == null || !hasMagic(edata2)) {
                if (edata2 != null) {
                    byte[] tmp = new byte[edata2.length + 4];
                    System.arraycopy((Object) edata2, 0, (Object) tmp, 4, edata2.length);
                    edata = tmp;
                } else {
                    edata = new byte[4];
                }
                set16(edata, 0, JAR_MAGIC);
                set16(edata, 2, 0);
                ze.setExtra(edata);
            }
            this.firstEntry = false;
        }
        super.putNextEntry(ze);
    }

    private static boolean hasMagic(byte[] edata) {
        int i10 = 0;
        while (i10 < edata.length) {
            try {
                if (get16(edata, i10) == JAR_MAGIC) {
                    return true;
                }
                i10 += get16(edata, i10 + 2) + 4;
            } catch (ArrayIndexOutOfBoundsException e2) {
                return false;
            }
        }
        return false;
    }

    private static int get16(byte[] b4, int off) {
        return Byte.toUnsignedInt(b4[off]) | (Byte.toUnsignedInt(b4[off + 1]) << 8);
    }

    private static void set16(byte[] b4, int off, int value) {
        b4[off + 0] = (byte) value;
        b4[off + 1] = (byte) (value >> 8);
    }
}
