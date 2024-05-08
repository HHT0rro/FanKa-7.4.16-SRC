package sun.security.x509;

import java.lang.reflect.Field;
import sun.misc.HexDumpEncoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: CertificateExtensions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnparseableExtension extends Extension {
    private String name;
    private Throwable why;

    public UnparseableExtension(Extension ext, Throwable why) {
        super(ext);
        this.name = "";
        try {
            Class<?> extClass = OIDMap.getClass(ext.getExtensionId());
            if (extClass != null) {
                Field field = extClass.getDeclaredField("NAME");
                this.name = ((String) field.get(null)) + " ";
            }
        } catch (Exception e2) {
        }
        this.why = why;
    }

    @Override // sun.security.x509.Extension, sun.security.x509.CertAttrSet
    public String toString() {
        return super.toString() + "Unparseable " + this.name + "extension due to\n" + ((Object) this.why) + "\n\n" + new HexDumpEncoder().encodeBuffer(getExtensionValue());
    }
}
