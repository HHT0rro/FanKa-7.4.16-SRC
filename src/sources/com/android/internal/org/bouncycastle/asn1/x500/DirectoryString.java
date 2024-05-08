package com.android.internal.org.bouncycastle.asn1.x500;

import com.android.internal.org.bouncycastle.asn1.ASN1Choice;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1String;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERBMPString;
import com.android.internal.org.bouncycastle.asn1.DERPrintableString;
import com.android.internal.org.bouncycastle.asn1.DERT61String;
import com.android.internal.org.bouncycastle.asn1.DERUTF8String;
import com.android.internal.org.bouncycastle.asn1.DERUniversalString;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DirectoryString extends ASN1Object implements ASN1Choice, ASN1String {
    private ASN1String string;

    public static DirectoryString getInstance(Object o10) {
        if (o10 == null || (o10 instanceof DirectoryString)) {
            return (DirectoryString) o10;
        }
        if (o10 instanceof DERT61String) {
            return new DirectoryString((DERT61String) o10);
        }
        if (o10 instanceof DERPrintableString) {
            return new DirectoryString((DERPrintableString) o10);
        }
        if (o10 instanceof DERUniversalString) {
            return new DirectoryString((DERUniversalString) o10);
        }
        if (o10 instanceof DERUTF8String) {
            return new DirectoryString((DERUTF8String) o10);
        }
        if (o10 instanceof DERBMPString) {
            return new DirectoryString((DERBMPString) o10);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + o10.getClass().getName());
    }

    public static DirectoryString getInstance(ASN1TaggedObject o10, boolean explicit) {
        if (!explicit) {
            throw new IllegalArgumentException("choice item must be explicitly tagged");
        }
        return getInstance(o10.getObject());
    }

    private DirectoryString(DERT61String string) {
        this.string = string;
    }

    private DirectoryString(DERPrintableString string) {
        this.string = string;
    }

    private DirectoryString(DERUniversalString string) {
        this.string = string;
    }

    private DirectoryString(DERUTF8String string) {
        this.string = string;
    }

    private DirectoryString(DERBMPString string) {
        this.string = string;
    }

    public DirectoryString(String string) {
        this.string = new DERUTF8String(string);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1String
    public String getString() {
        return this.string.getString();
    }

    public String toString() {
        return this.string.getString();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ((ASN1Encodable) this.string).toASN1Primitive();
    }
}
