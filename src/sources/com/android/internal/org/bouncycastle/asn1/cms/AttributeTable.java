package com.android.internal.org.bouncycastle.asn1.cms;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.DERSet;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AttributeTable {
    private Hashtable attributes;

    public AttributeTable(Hashtable attrs) {
        this.attributes = new Hashtable();
        this.attributes = copyTable(attrs);
    }

    public AttributeTable(ASN1EncodableVector v2) {
        this.attributes = new Hashtable();
        for (int i10 = 0; i10 != v2.size(); i10++) {
            Attribute a10 = Attribute.getInstance(v2.get(i10));
            addAttribute(a10.getAttrType(), a10);
        }
    }

    public AttributeTable(ASN1Set s2) {
        this.attributes = new Hashtable();
        for (int i10 = 0; i10 != s2.size(); i10++) {
            Attribute a10 = Attribute.getInstance(s2.getObjectAt(i10));
            addAttribute(a10.getAttrType(), a10);
        }
    }

    public AttributeTable(Attribute attr) {
        this.attributes = new Hashtable();
        addAttribute(attr.getAttrType(), attr);
    }

    public AttributeTable(Attributes attrs) {
        this(ASN1Set.getInstance(attrs.toASN1Primitive()));
    }

    private void addAttribute(ASN1ObjectIdentifier oid, Attribute a10) {
        Vector v2;
        Object value = this.attributes.get(oid);
        if (value == null) {
            this.attributes.put(oid, a10);
            return;
        }
        if (value instanceof Attribute) {
            v2 = new Vector();
            v2.addElement(value);
            v2.addElement(a10);
        } else {
            v2 = (Vector) value;
            v2.addElement(a10);
        }
        this.attributes.put(oid, v2);
    }

    public Attribute get(ASN1ObjectIdentifier oid) {
        Object value = this.attributes.get(oid);
        if (value instanceof Vector) {
            return (Attribute) ((Vector) value).elementAt(0);
        }
        return (Attribute) value;
    }

    public ASN1EncodableVector getAll(ASN1ObjectIdentifier oid) {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        Object value = this.attributes.get(oid);
        if (value instanceof Vector) {
            Enumeration e2 = ((Vector) value).elements();
            while (e2.hasMoreElements()) {
                v2.add((Attribute) e2.nextElement());
            }
        } else if (value != null) {
            v2.add((Attribute) value);
        }
        return v2;
    }

    public int size() {
        int size = 0;
        Enumeration en = this.attributes.elements();
        while (en.hasMoreElements()) {
            Object o10 = en.nextElement();
            if (o10 instanceof Vector) {
                size += ((Vector) o10).size();
            } else {
                size++;
            }
        }
        return size;
    }

    public Hashtable toHashtable() {
        return copyTable(this.attributes);
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        Enumeration e2 = this.attributes.elements();
        while (e2.hasMoreElements()) {
            Object value = e2.nextElement();
            if (value instanceof Vector) {
                Enumeration en = ((Vector) value).elements();
                while (en.hasMoreElements()) {
                    v2.add(Attribute.getInstance(en.nextElement()));
                }
            } else {
                v2.add(Attribute.getInstance(value));
            }
        }
        return v2;
    }

    public Attributes toASN1Structure() {
        return new Attributes(toASN1EncodableVector());
    }

    private Hashtable copyTable(Hashtable in) {
        Hashtable out = new Hashtable();
        Enumeration e2 = in.keys();
        while (e2.hasMoreElements()) {
            Object key = e2.nextElement();
            out.put(key, in.get(key));
        }
        return out;
    }

    public AttributeTable add(ASN1ObjectIdentifier attrType, ASN1Encodable attrValue) {
        AttributeTable newTable = new AttributeTable(this.attributes);
        newTable.addAttribute(attrType, new Attribute(attrType, new DERSet(attrValue)));
        return newTable;
    }

    public AttributeTable remove(ASN1ObjectIdentifier attrType) {
        AttributeTable newTable = new AttributeTable(this.attributes);
        newTable.attributes.remove(attrType);
        return newTable;
    }
}
