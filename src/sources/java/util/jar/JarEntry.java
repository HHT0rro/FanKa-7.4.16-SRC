package java.util.jar;

import java.io.IOException;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.zip.ZipEntry;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarEntry extends ZipEntry {
    Attributes attr;
    Certificate[] certs;
    CodeSigner[] signers;

    public JarEntry(String name) {
        super(name);
    }

    public JarEntry(ZipEntry ze) {
        super(ze);
    }

    public JarEntry(JarEntry je2) {
        this((ZipEntry) je2);
        this.attr = je2.attr;
        this.certs = je2.certs;
        this.signers = je2.signers;
    }

    public Attributes getAttributes() throws IOException {
        return this.attr;
    }

    public Certificate[] getCertificates() {
        Certificate[] certificateArr = this.certs;
        if (certificateArr == null) {
            return null;
        }
        return (Certificate[]) certificateArr.clone();
    }

    public CodeSigner[] getCodeSigners() {
        CodeSigner[] codeSignerArr = this.signers;
        if (codeSignerArr == null) {
            return null;
        }
        return (CodeSigner[]) codeSignerArr.clone();
    }

    public String getRealName() {
        return super.getName();
    }
}
