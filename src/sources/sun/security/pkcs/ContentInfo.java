package sun.security.pkcs;

import com.android.internal.midi.MidiConstants;
import java.io.IOException;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ContentInfo {
    private static final int[] OLD_DATA;
    public static ObjectIdentifier OLD_DATA_OID;
    private static final int[] OLD_SDATA;
    public static ObjectIdentifier OLD_SIGNED_DATA_OID;
    public static ObjectIdentifier PKCS7_OID;
    private static int[] pkcs7;
    DerValue content;
    ObjectIdentifier contentType;
    private static int[] data = {1, 2, 840, 113549, 1, 7, 1};
    private static int[] sdata = {1, 2, 840, 113549, 1, 7, 2};
    private static int[] edata = {1, 2, 840, 113549, 1, 7, 3};
    private static int[] sedata = {1, 2, 840, 113549, 1, 7, 4};
    private static int[] ddata = {1, 2, 840, 113549, 1, 7, 5};
    private static int[] crdata = {1, 2, 840, 113549, 1, 7, 6};
    private static int[] nsdata = {2, 16, 840, 1, 113730, 2, 5};
    private static int[] tstInfo = {1, 2, 840, 113549, 1, 9, 16, 1, 4};
    public static ObjectIdentifier DATA_OID = ObjectIdentifier.newInternal(data);
    public static ObjectIdentifier SIGNED_DATA_OID = ObjectIdentifier.newInternal(sdata);
    public static ObjectIdentifier ENVELOPED_DATA_OID = ObjectIdentifier.newInternal(edata);
    public static ObjectIdentifier SIGNED_AND_ENVELOPED_DATA_OID = ObjectIdentifier.newInternal(sedata);
    public static ObjectIdentifier DIGESTED_DATA_OID = ObjectIdentifier.newInternal(ddata);
    public static ObjectIdentifier ENCRYPTED_DATA_OID = ObjectIdentifier.newInternal(crdata);
    public static ObjectIdentifier NETSCAPE_CERT_SEQUENCE_OID = ObjectIdentifier.newInternal(nsdata);
    public static ObjectIdentifier TIMESTAMP_TOKEN_INFO_OID = ObjectIdentifier.newInternal(tstInfo);

    static {
        int[] iArr = {1, 2, 840, 113549, 1, 7};
        pkcs7 = iArr;
        int[] iArr2 = {1, 2, 840, 1113549, 1, 7, 2};
        OLD_SDATA = iArr2;
        int[] iArr3 = {1, 2, 840, 1113549, 1, 7, 1};
        OLD_DATA = iArr3;
        PKCS7_OID = ObjectIdentifier.newInternal(iArr);
        OLD_SIGNED_DATA_OID = ObjectIdentifier.newInternal(iArr2);
        OLD_DATA_OID = ObjectIdentifier.newInternal(iArr3);
    }

    public ContentInfo(ObjectIdentifier contentType, DerValue content) {
        this.contentType = contentType;
        this.content = content;
    }

    public ContentInfo(byte[] bytes) {
        DerValue octetString = new DerValue((byte) 4, bytes);
        this.contentType = DATA_OID;
        this.content = octetString;
    }

    public ContentInfo(DerInputStream derin) throws IOException, ParsingException {
        this(derin, false);
    }

    public ContentInfo(DerInputStream derin, boolean oldStyle) throws IOException, ParsingException {
        DerValue[] typeAndContent = derin.getSequence(2);
        DerValue type = typeAndContent[0];
        DerInputStream disType = new DerInputStream(type.toByteArray());
        this.contentType = disType.getOID();
        if (!oldStyle) {
            if (typeAndContent.length > 1) {
                DerValue taggedContent = typeAndContent[1];
                DerInputStream disTaggedContent = new DerInputStream(taggedContent.toByteArray());
                DerValue[] contents = disTaggedContent.getSet(1, true);
                this.content = contents[0];
                return;
            }
            return;
        }
        this.content = typeAndContent[1];
    }

    public DerValue getContent() {
        return this.content;
    }

    public ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public byte[] getData() throws IOException {
        if (this.contentType.equals((Object) DATA_OID) || this.contentType.equals((Object) OLD_DATA_OID) || this.contentType.equals((Object) TIMESTAMP_TOKEN_INFO_OID)) {
            DerValue derValue = this.content;
            if (derValue == null) {
                return null;
            }
            return derValue.getOctetString();
        }
        throw new IOException("content type is not DATA: " + ((Object) this.contentType));
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream seq = new DerOutputStream();
        seq.putOID(this.contentType);
        if (this.content != null) {
            DerOutputStream contentDerCode = new DerOutputStream();
            this.content.encode(contentDerCode);
            DerValue taggedContent = new DerValue(MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, contentDerCode.toByteArray());
            seq.putDerValue(taggedContent);
        }
        out.write((byte) 48, seq);
    }

    public byte[] getContentBytes() throws IOException {
        DerValue derValue = this.content;
        if (derValue == null) {
            return null;
        }
        DerInputStream dis = new DerInputStream(derValue.toByteArray());
        return dis.getOctetString();
    }

    public String toString() {
        String out = "Content Info Sequence\n\tContent type: " + ((Object) this.contentType) + "\n";
        return out + "\tContent: " + ((Object) this.content);
    }
}
