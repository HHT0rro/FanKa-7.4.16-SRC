package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralName;
import com.android.internal.org.bouncycastle.asn1.x509.GeneralSubtree;
import com.android.internal.org.bouncycastle.asn1.x509.NameConstraintValidatorException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PKIXNameConstraintValidator {
    com.android.internal.org.bouncycastle.asn1.x509.PKIXNameConstraintValidator validator = new com.android.internal.org.bouncycastle.asn1.x509.PKIXNameConstraintValidator();

    public int hashCode() {
        return this.validator.hashCode();
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator constraintValidator = (PKIXNameConstraintValidator) o10;
        return this.validator.equals(constraintValidator.validator);
    }

    public void checkPermittedDN(ASN1Sequence dns) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermittedDN(X500Name.getInstance(dns));
        } catch (NameConstraintValidatorException e2) {
            throw new PKIXNameConstraintValidatorException(e2.getMessage(), e2);
        }
    }

    public void checkExcludedDN(ASN1Sequence dns) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcludedDN(X500Name.getInstance(dns));
        } catch (NameConstraintValidatorException e2) {
            throw new PKIXNameConstraintValidatorException(e2.getMessage(), e2);
        }
    }

    public void checkPermitted(GeneralName name) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermitted(name);
        } catch (NameConstraintValidatorException e2) {
            throw new PKIXNameConstraintValidatorException(e2.getMessage(), e2);
        }
    }

    public void checkExcluded(GeneralName name) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcluded(name);
        } catch (NameConstraintValidatorException e2) {
            throw new PKIXNameConstraintValidatorException(e2.getMessage(), e2);
        }
    }

    public void intersectPermittedSubtree(GeneralSubtree permitted) {
        this.validator.intersectPermittedSubtree(permitted);
    }

    public void intersectPermittedSubtree(GeneralSubtree[] permitted) {
        this.validator.intersectPermittedSubtree(permitted);
    }

    public void intersectEmptyPermittedSubtree(int nameType) {
        this.validator.intersectEmptyPermittedSubtree(nameType);
    }

    public void addExcludedSubtree(GeneralSubtree subtree) {
        this.validator.addExcludedSubtree(subtree);
    }

    public String toString() {
        return this.validator.toString();
    }
}
