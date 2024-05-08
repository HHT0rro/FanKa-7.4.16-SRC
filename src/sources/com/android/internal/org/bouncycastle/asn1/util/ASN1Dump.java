package com.android.internal.org.bouncycastle.asn1.util;

import com.android.internal.org.bouncycastle.asn1.ASN1ApplicationSpecific;
import com.android.internal.org.bouncycastle.asn1.ASN1Boolean;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1Enumerated;
import com.android.internal.org.bouncycastle.asn1.ASN1External;
import com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.ASN1UTCTime;
import com.android.internal.org.bouncycastle.asn1.BERApplicationSpecific;
import com.android.internal.org.bouncycastle.asn1.BEROctetString;
import com.android.internal.org.bouncycastle.asn1.BERSequence;
import com.android.internal.org.bouncycastle.asn1.BERSet;
import com.android.internal.org.bouncycastle.asn1.BERTaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERApplicationSpecific;
import com.android.internal.org.bouncycastle.asn1.DERBMPString;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DERGraphicString;
import com.android.internal.org.bouncycastle.asn1.DERIA5String;
import com.android.internal.org.bouncycastle.asn1.DERNull;
import com.android.internal.org.bouncycastle.asn1.DERPrintableString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.DERSet;
import com.android.internal.org.bouncycastle.asn1.DERT61String;
import com.android.internal.org.bouncycastle.asn1.DERUTF8String;
import com.android.internal.org.bouncycastle.asn1.DERVideotexString;
import com.android.internal.org.bouncycastle.asn1.DERVisibleString;
import com.android.internal.org.bouncycastle.asn1.DLApplicationSpecific;
import com.android.internal.org.bouncycastle.util.Strings;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    static void _dumpAsString(String indent, boolean verbose, ASN1Primitive obj, StringBuffer buf) {
        String nl = Strings.lineSeparator();
        if (obj instanceof ASN1Sequence) {
            Enumeration e2 = ((ASN1Sequence) obj).getObjects();
            String tab = indent + TAB;
            buf.append(indent);
            if (obj instanceof BERSequence) {
                buf.append("BER Sequence");
            } else if (obj instanceof DERSequence) {
                buf.append("DER Sequence");
            } else {
                buf.append("Sequence");
            }
            buf.append(nl);
            while (e2.hasMoreElements()) {
                Object o10 = e2.nextElement();
                if (o10 == null || o10.equals(DERNull.INSTANCE)) {
                    buf.append(tab);
                    buf.append("NULL");
                    buf.append(nl);
                } else if (o10 instanceof ASN1Primitive) {
                    _dumpAsString(tab, verbose, (ASN1Primitive) o10, buf);
                } else {
                    _dumpAsString(tab, verbose, ((ASN1Encodable) o10).toASN1Primitive(), buf);
                }
            }
            return;
        }
        if (obj instanceof ASN1TaggedObject) {
            String tab2 = indent + TAB;
            buf.append(indent);
            if (obj instanceof BERTaggedObject) {
                buf.append("BER Tagged [");
            } else {
                buf.append("Tagged [");
            }
            ASN1TaggedObject o11 = (ASN1TaggedObject) obj;
            buf.append(Integer.toString(o11.getTagNo()));
            buf.append(']');
            if (!o11.isExplicit()) {
                buf.append(" IMPLICIT ");
            }
            buf.append(nl);
            _dumpAsString(tab2, verbose, o11.getObject(), buf);
            return;
        }
        if (obj instanceof ASN1Set) {
            Enumeration e10 = ((ASN1Set) obj).getObjects();
            String tab3 = indent + TAB;
            buf.append(indent);
            if (obj instanceof BERSet) {
                buf.append("BER Set");
            } else if (obj instanceof DERSet) {
                buf.append("DER Set");
            } else {
                buf.append("Set");
            }
            buf.append(nl);
            while (e10.hasMoreElements()) {
                Object o12 = e10.nextElement();
                if (o12 == null) {
                    buf.append(tab3);
                    buf.append("NULL");
                    buf.append(nl);
                } else if (o12 instanceof ASN1Primitive) {
                    _dumpAsString(tab3, verbose, (ASN1Primitive) o12, buf);
                } else {
                    _dumpAsString(tab3, verbose, ((ASN1Encodable) o12).toASN1Primitive(), buf);
                }
            }
            return;
        }
        if (obj instanceof ASN1OctetString) {
            ASN1OctetString oct = (ASN1OctetString) obj;
            if (obj instanceof BEROctetString) {
                buf.append(indent + "BER Constructed Octet String[" + oct.getOctets().length + "] ");
            } else {
                buf.append(indent + "DER Octet String[" + oct.getOctets().length + "] ");
            }
            if (verbose) {
                buf.append(dumpBinaryDataAsString(indent, oct.getOctets()));
                return;
            } else {
                buf.append(nl);
                return;
            }
        }
        if (obj instanceof ASN1ObjectIdentifier) {
            buf.append(indent + "ObjectIdentifier(" + ((ASN1ObjectIdentifier) obj).getId() + ")" + nl);
            return;
        }
        if (obj instanceof ASN1Boolean) {
            buf.append(indent + "Boolean(" + ((ASN1Boolean) obj).isTrue() + ")" + nl);
            return;
        }
        if (obj instanceof ASN1Integer) {
            buf.append(indent + "Integer(" + ((Object) ((ASN1Integer) obj).getValue()) + ")" + nl);
            return;
        }
        if (obj instanceof DERBitString) {
            DERBitString bt = (DERBitString) obj;
            buf.append(indent + "DER Bit String[" + bt.getBytes().length + ", " + bt.getPadBits() + "] ");
            if (verbose) {
                buf.append(dumpBinaryDataAsString(indent, bt.getBytes()));
                return;
            } else {
                buf.append(nl);
                return;
            }
        }
        if (obj instanceof DERIA5String) {
            buf.append(indent + "IA5String(" + ((DERIA5String) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERUTF8String) {
            buf.append(indent + "UTF8String(" + ((DERUTF8String) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERPrintableString) {
            buf.append(indent + "PrintableString(" + ((DERPrintableString) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERVisibleString) {
            buf.append(indent + "VisibleString(" + ((DERVisibleString) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERBMPString) {
            buf.append(indent + "BMPString(" + ((DERBMPString) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERT61String) {
            buf.append(indent + "T61String(" + ((DERT61String) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERGraphicString) {
            buf.append(indent + "GraphicString(" + ((DERGraphicString) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof DERVideotexString) {
            buf.append(indent + "VideotexString(" + ((DERVideotexString) obj).getString() + ") " + nl);
            return;
        }
        if (obj instanceof ASN1UTCTime) {
            buf.append(indent + "UTCTime(" + ((ASN1UTCTime) obj).getTime() + ") " + nl);
            return;
        }
        if (obj instanceof ASN1GeneralizedTime) {
            buf.append(indent + "GeneralizedTime(" + ((ASN1GeneralizedTime) obj).getTime() + ") " + nl);
            return;
        }
        if (obj instanceof BERApplicationSpecific) {
            buf.append(outputApplicationSpecific(ASN1Encoding.BER, indent, verbose, obj, nl));
            return;
        }
        if (obj instanceof DERApplicationSpecific) {
            buf.append(outputApplicationSpecific(ASN1Encoding.DER, indent, verbose, obj, nl));
            return;
        }
        if (obj instanceof DLApplicationSpecific) {
            buf.append(outputApplicationSpecific("", indent, verbose, obj, nl));
            return;
        }
        if (obj instanceof ASN1Enumerated) {
            ASN1Enumerated en = (ASN1Enumerated) obj;
            buf.append(indent + "DER Enumerated(" + ((Object) en.getValue()) + ")" + nl);
            return;
        }
        if (obj instanceof ASN1External) {
            ASN1External ext = (ASN1External) obj;
            buf.append(indent + "External " + nl);
            String tab4 = indent + TAB;
            if (ext.getDirectReference() != null) {
                buf.append(tab4 + "Direct Reference: " + ext.getDirectReference().getId() + nl);
            }
            if (ext.getIndirectReference() != null) {
                buf.append(tab4 + "Indirect Reference: " + ext.getIndirectReference().toString() + nl);
            }
            if (ext.getDataValueDescriptor() != null) {
                _dumpAsString(tab4, verbose, ext.getDataValueDescriptor(), buf);
            }
            buf.append(tab4 + "Encoding: " + ext.getEncoding() + nl);
            _dumpAsString(tab4, verbose, ext.getExternalContent(), buf);
            return;
        }
        buf.append(indent + obj.toString() + nl);
    }

    private static String outputApplicationSpecific(String type, String indent, boolean verbose, ASN1Primitive obj, String nl) {
        ASN1ApplicationSpecific app = ASN1ApplicationSpecific.getInstance(obj);
        StringBuffer buf = new StringBuffer();
        if (app.isConstructed()) {
            try {
                ASN1Sequence s2 = ASN1Sequence.getInstance(app.getObject(16));
                buf.append(indent + type + " ApplicationSpecific[" + app.getApplicationTag() + "]" + nl);
                Enumeration e2 = s2.getObjects();
                while (e2.hasMoreElements()) {
                    _dumpAsString(indent + TAB, verbose, (ASN1Primitive) e2.nextElement(), buf);
                }
            } catch (IOException e10) {
                buf.append((Object) e10);
            }
            return buf.toString();
        }
        return indent + type + " ApplicationSpecific[" + app.getApplicationTag() + "] (" + Strings.fromByteArray(Hex.encode(app.getContents())) + ")" + nl;
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    public static String dumpAsString(Object obj, boolean verbose) {
        StringBuffer buf = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            _dumpAsString("", verbose, (ASN1Primitive) obj, buf);
        } else if (obj instanceof ASN1Encodable) {
            _dumpAsString("", verbose, ((ASN1Encodable) obj).toASN1Primitive(), buf);
        } else {
            return "unknown object type " + obj.toString();
        }
        return buf.toString();
    }

    private static String dumpBinaryDataAsString(String indent, byte[] bytes) {
        String nl = Strings.lineSeparator();
        StringBuffer buf = new StringBuffer();
        String indent2 = indent + TAB;
        buf.append(nl);
        for (int i10 = 0; i10 < bytes.length; i10 += 32) {
            if (bytes.length - i10 > 32) {
                buf.append(indent2);
                buf.append(Strings.fromByteArray(Hex.encode(bytes, i10, 32)));
                buf.append(TAB);
                buf.append(calculateAscString(bytes, i10, 32));
                buf.append(nl);
            } else {
                buf.append(indent2);
                buf.append(Strings.fromByteArray(Hex.encode(bytes, i10, bytes.length - i10)));
                for (int j10 = bytes.length - i10; j10 != 32; j10++) {
                    buf.append("  ");
                }
                buf.append(TAB);
                buf.append(calculateAscString(bytes, i10, bytes.length - i10));
                buf.append(nl);
            }
        }
        return buf.toString();
    }

    private static String calculateAscString(byte[] bytes, int off, int len) {
        StringBuffer buf = new StringBuffer();
        for (int i10 = off; i10 != off + len; i10++) {
            if (bytes[i10] >= 32 && bytes[i10] <= 126) {
                buf.append((char) bytes[i10]);
            }
        }
        return buf.toString();
    }
}
