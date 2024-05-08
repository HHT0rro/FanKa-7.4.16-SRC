package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import sun.misc.HexDumpEncoder;
import sun.security.util.Debug;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificateExtensions implements CertAttrSet<Extension> {
    public static final String IDENT = "x509.info.extensions";
    public static final String NAME = "extensions";
    private Map<String, Extension> unparseableExtensions;
    private static final Debug debug = Debug.getInstance(X509CertImpl.NAME);
    private static Class[] PARAMS = {Boolean.class, Object.class};
    private Map<String, Extension> map = Collections.synchronizedMap(new TreeMap());
    private boolean unsupportedCritExt = false;

    public CertificateExtensions() {
    }

    public CertificateExtensions(DerInputStream in) throws IOException {
        init(in);
    }

    private void init(DerInputStream in) throws IOException {
        DerValue[] exts = in.getSequence(5);
        for (DerValue derValue : exts) {
            Extension ext = new Extension(derValue);
            parseExtension(ext);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void parseExtension(Extension ext) throws IOException {
        try {
            Class<?> extClass = OIDMap.getClass(ext.getExtensionId());
            if (extClass == null) {
                if (ext.isCritical()) {
                    this.unsupportedCritExt = true;
                }
                if (this.map.put(ext.getExtensionId().toString(), ext) == null) {
                    return;
                } else {
                    throw new IOException("Duplicate extensions not allowed");
                }
            }
            Constructor<?> cons = extClass.getConstructor(PARAMS);
            Object[] passed = {Boolean.valueOf(ext.isCritical()), ext.getExtensionValue()};
            CertAttrSet certAttrSet = (CertAttrSet) cons.newInstance(passed);
            if (this.map.put(certAttrSet.getName(), (Extension) certAttrSet) != null) {
                throw new IOException("Duplicate extensions not allowed");
            }
        } catch (IOException e2) {
            throw e2;
        } catch (InvocationTargetException invk) {
            Throwable e10 = invk.getTargetException();
            if (!ext.isCritical()) {
                if (this.unparseableExtensions == null) {
                    this.unparseableExtensions = new TreeMap();
                }
                this.unparseableExtensions.put(ext.getExtensionId().toString(), new UnparseableExtension(ext, e10));
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Error parsing extension: " + ((Object) ext));
                    e10.printStackTrace();
                    HexDumpEncoder h10 = new HexDumpEncoder();
                    System.err.println(h10.encodeBuffer(ext.getExtensionValue()));
                    return;
                }
                return;
            }
            if (e10 instanceof IOException) {
                throw ((IOException) e10);
            }
            throw new IOException(e10);
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }

    @Override // sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws CertificateException, IOException {
        encode(out, false);
    }

    public void encode(OutputStream out, boolean isCertReq) throws CertificateException, IOException {
        DerOutputStream tmp;
        DerOutputStream extOut = new DerOutputStream();
        Collection<Extension> allExts = this.map.values();
        Object[] objs = allExts.toArray();
        for (int i10 = 0; i10 < objs.length; i10++) {
            if (objs[i10] instanceof CertAttrSet) {
                ((CertAttrSet) objs[i10]).encode(extOut);
            } else if (objs[i10] instanceof Extension) {
                ((Extension) objs[i10]).encode(extOut);
            } else {
                throw new CertificateException("Illegal extension object");
            }
        }
        DerOutputStream seq = new DerOutputStream();
        seq.write((byte) 48, extOut);
        if (!isCertReq) {
            tmp = new DerOutputStream();
            tmp.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 3), seq);
        } else {
            tmp = seq;
        }
        out.write(tmp.toByteArray());
    }

    @Override // sun.security.x509.CertAttrSet
    public void set(String name, Object obj) throws IOException {
        if (obj instanceof Extension) {
            this.map.put(name, (Extension) obj);
            return;
        }
        throw new IOException("Unknown extension type.");
    }

    @Override // sun.security.x509.CertAttrSet
    public Extension get(String name) throws IOException {
        Extension obj = this.map.get(name);
        if (obj == null) {
            throw new IOException("No extension found with name " + name);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Extension getExtension(String name) {
        return this.map.get(name);
    }

    @Override // sun.security.x509.CertAttrSet
    public void delete(String name) throws IOException {
        Object obj = this.map.get(name);
        if (obj == null) {
            throw new IOException("No extension found with name " + name);
        }
        this.map.remove(name);
    }

    public String getNameByOid(ObjectIdentifier oid) throws IOException {
        for (String name : this.map.h()) {
            if (this.map.get(name).getExtensionId().equals((Object) oid)) {
                return name;
            }
        }
        return null;
    }

    @Override // sun.security.x509.CertAttrSet
    public Enumeration<Extension> getElements() {
        return Collections.enumeration(this.map.values());
    }

    public Collection<Extension> getAllExtensions() {
        return this.map.values();
    }

    public Map<String, Extension> getUnparseableExtensions() {
        Map<String, Extension> map = this.unparseableExtensions;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    @Override // sun.security.x509.CertAttrSet
    public String getName() {
        return "extensions";
    }

    public boolean hasUnsupportedCriticalExtension() {
        return this.unsupportedCritExt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CertificateExtensions)) {
            return false;
        }
        Collection<Extension> otherC = ((CertificateExtensions) other).getAllExtensions();
        Object[] objs = otherC.toArray();
        int len = objs.length;
        if (len != this.map.size()) {
            return false;
        }
        String key = null;
        for (int i10 = 0; i10 < len; i10++) {
            if (objs[i10] instanceof CertAttrSet) {
                key = ((CertAttrSet) objs[i10]).getName();
            }
            Extension otherExt = (Extension) objs[i10];
            if (key == null) {
                key = otherExt.getExtensionId().toString();
            }
            Extension thisExt = this.map.get(key);
            if (thisExt == null || !thisExt.equals(otherExt)) {
                return false;
            }
        }
        return getUnparseableExtensions().equals(((CertificateExtensions) other).getUnparseableExtensions());
    }

    public int hashCode() {
        return this.map.hashCode() + getUnparseableExtensions().hashCode();
    }

    @Override // sun.security.x509.CertAttrSet
    public String toString() {
        return this.map.toString();
    }
}
