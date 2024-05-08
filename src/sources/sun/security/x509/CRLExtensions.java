package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CRLExtensions {
    private static final Class[] PARAMS = {Boolean.class, Object.class};
    private Map<String, Extension> map = Collections.synchronizedMap(new TreeMap());
    private boolean unsupportedCritExt = false;

    public CRLExtensions() {
    }

    public CRLExtensions(DerInputStream in) throws CRLException {
        init(in);
    }

    private void init(DerInputStream derStrm) throws CRLException {
        DerInputStream str = derStrm;
        try {
            byte nextByte = (byte) derStrm.peekByte();
            if ((nextByte & 192) == 128 && (nextByte & 31) == 0) {
                DerValue val = str.getDerValue();
                str = val.data;
            }
            DerValue[] exts = str.getSequence(5);
            for (DerValue derValue : exts) {
                Extension ext = new Extension(derValue);
                parseExtension(ext);
            }
        } catch (IOException e2) {
            throw new CRLException("Parsing error: " + e2.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void parseExtension(Extension ext) throws CRLException {
        try {
            Class<?> extClass = OIDMap.getClass(ext.getExtensionId());
            if (extClass == null) {
                if (ext.isCritical()) {
                    this.unsupportedCritExt = true;
                }
                if (this.map.put(ext.getExtensionId().toString(), ext) != null) {
                    throw new CRLException("Duplicate extensions not allowed");
                }
                return;
            }
            Constructor<?> cons = extClass.getConstructor(PARAMS);
            Object[] passed = {Boolean.valueOf(ext.isCritical()), ext.getExtensionValue()};
            CertAttrSet certAttrSet = (CertAttrSet) cons.newInstance(passed);
            if (this.map.put(certAttrSet.getName(), (Extension) certAttrSet) != null) {
                throw new CRLException("Duplicate extensions not allowed");
            }
        } catch (InvocationTargetException invk) {
            throw new CRLException(invk.getTargetException().getMessage());
        } catch (Exception e2) {
            throw new CRLException(e2.toString());
        }
    }

    public void encode(OutputStream out, boolean isExplicit) throws CRLException {
        try {
            DerOutputStream extOut = new DerOutputStream();
            Collection<Extension> allExts = this.map.values();
            Object[] objs = allExts.toArray();
            for (int i10 = 0; i10 < objs.length; i10++) {
                if (objs[i10] instanceof CertAttrSet) {
                    ((CertAttrSet) objs[i10]).encode(extOut);
                } else if (objs[i10] instanceof Extension) {
                    ((Extension) objs[i10]).encode(extOut);
                } else {
                    throw new CRLException("Illegal extension object");
                }
            }
            DerOutputStream seq = new DerOutputStream();
            seq.write((byte) 48, extOut);
            DerOutputStream tmp = new DerOutputStream();
            if (isExplicit) {
                tmp.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), seq);
            } else {
                tmp = seq;
            }
            out.write(tmp.toByteArray());
        } catch (IOException e2) {
            throw new CRLException("Encoding error: " + e2.toString());
        } catch (CertificateException e10) {
            throw new CRLException("Encoding error: " + e10.toString());
        }
    }

    public Extension get(String alias) {
        String name;
        X509AttributeName attr = new X509AttributeName(alias);
        String id2 = attr.getPrefix();
        if (id2.equalsIgnoreCase(X509CertImpl.NAME)) {
            int index = alias.lastIndexOf(".");
            name = alias.substring(index + 1);
        } else {
            name = alias;
        }
        return this.map.get(name);
    }

    public void set(String alias, Object obj) {
        this.map.put(alias, (Extension) obj);
    }

    public void delete(String alias) {
        this.map.remove(alias);
    }

    public Enumeration<Extension> getElements() {
        return Collections.enumeration(this.map.values());
    }

    public Collection<Extension> getAllExtensions() {
        return this.map.values();
    }

    public boolean hasUnsupportedCriticalExtension() {
        return this.unsupportedCritExt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CRLExtensions)) {
            return false;
        }
        Collection<Extension> otherC = ((CRLExtensions) other).getAllExtensions();
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
        return true;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }
}
