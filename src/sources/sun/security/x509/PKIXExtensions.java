package sun.security.x509;

import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKIXExtensions {
    public static final ObjectIdentifier AuthInfoAccess_Id;
    private static final int[] AuthInfoAccess_data;
    public static final ObjectIdentifier AuthorityKey_Id;
    private static final int[] AuthorityKey_data;
    public static final ObjectIdentifier BasicConstraints_Id;
    private static final int[] BasicConstraints_data;
    public static final ObjectIdentifier CRLDistributionPoints_Id;
    private static final int[] CRLDistributionPoints_data;
    public static final ObjectIdentifier CRLNumber_Id;
    private static final int[] CRLNumber_data;
    public static final ObjectIdentifier CertificateIssuer_Id;
    private static final int[] CertificateIssuer_data;
    public static final ObjectIdentifier CertificatePolicies_Id;
    private static final int[] CertificatePolicies_data;
    public static final ObjectIdentifier DeltaCRLIndicator_Id;
    private static final int[] DeltaCRLIndicator_data;
    public static final ObjectIdentifier ExtendedKeyUsage_Id;
    private static final int[] ExtendedKeyUsage_data;
    public static final ObjectIdentifier FreshestCRL_Id;
    private static final int[] FreshestCRL_data;
    public static final ObjectIdentifier HoldInstructionCode_Id;
    private static final int[] HoldInstructionCode_data;
    public static final ObjectIdentifier InhibitAnyPolicy_Id;
    private static final int[] InhibitAnyPolicy_data;
    public static final ObjectIdentifier InvalidityDate_Id;
    private static final int[] InvalidityDate_data;
    public static final ObjectIdentifier IssuerAlternativeName_Id;
    private static final int[] IssuerAlternativeName_data;
    public static final ObjectIdentifier IssuingDistributionPoint_Id;
    private static final int[] IssuingDistributionPoint_data;
    public static final ObjectIdentifier KeyUsage_Id;
    private static final int[] KeyUsage_data;
    public static final ObjectIdentifier NameConstraints_Id;
    private static final int[] NameConstraints_data;
    public static final ObjectIdentifier OCSPNoCheck_Id;
    private static final int[] OCSPNoCheck_data;
    public static final ObjectIdentifier PolicyConstraints_Id;
    private static final int[] PolicyConstraints_data;
    public static final ObjectIdentifier PolicyMappings_Id;
    private static final int[] PolicyMappings_data;
    public static final ObjectIdentifier PrivateKeyUsage_Id;
    private static final int[] PrivateKeyUsage_data;
    public static final ObjectIdentifier ReasonCode_Id;
    private static final int[] ReasonCode_data;
    public static final ObjectIdentifier SubjectAlternativeName_Id;
    private static final int[] SubjectAlternativeName_data;
    public static final ObjectIdentifier SubjectDirectoryAttributes_Id;
    private static final int[] SubjectDirectoryAttributes_data;
    public static final ObjectIdentifier SubjectInfoAccess_Id;
    private static final int[] SubjectInfoAccess_data;
    public static final ObjectIdentifier SubjectKey_Id;
    private static final int[] SubjectKey_data;

    static {
        int[] iArr = {2, 5, 29, 35};
        AuthorityKey_data = iArr;
        int[] iArr2 = {2, 5, 29, 14};
        SubjectKey_data = iArr2;
        int[] iArr3 = {2, 5, 29, 15};
        KeyUsage_data = iArr3;
        int[] iArr4 = {2, 5, 29, 16};
        PrivateKeyUsage_data = iArr4;
        int[] iArr5 = {2, 5, 29, 32};
        CertificatePolicies_data = iArr5;
        int[] iArr6 = {2, 5, 29, 33};
        PolicyMappings_data = iArr6;
        int[] iArr7 = {2, 5, 29, 17};
        SubjectAlternativeName_data = iArr7;
        int[] iArr8 = {2, 5, 29, 18};
        IssuerAlternativeName_data = iArr8;
        int[] iArr9 = {2, 5, 29, 9};
        SubjectDirectoryAttributes_data = iArr9;
        int[] iArr10 = {2, 5, 29, 19};
        BasicConstraints_data = iArr10;
        int[] iArr11 = {2, 5, 29, 30};
        NameConstraints_data = iArr11;
        int[] iArr12 = {2, 5, 29, 36};
        PolicyConstraints_data = iArr12;
        int[] iArr13 = {2, 5, 29, 31};
        CRLDistributionPoints_data = iArr13;
        int[] iArr14 = {2, 5, 29, 20};
        CRLNumber_data = iArr14;
        int[] iArr15 = {2, 5, 29, 28};
        IssuingDistributionPoint_data = iArr15;
        int[] iArr16 = {2, 5, 29, 27};
        DeltaCRLIndicator_data = iArr16;
        int[] iArr17 = {2, 5, 29, 21};
        ReasonCode_data = iArr17;
        int[] iArr18 = {2, 5, 29, 23};
        HoldInstructionCode_data = iArr18;
        int[] iArr19 = {2, 5, 29, 24};
        InvalidityDate_data = iArr19;
        int[] iArr20 = {2, 5, 29, 37};
        ExtendedKeyUsage_data = iArr20;
        int[] iArr21 = {2, 5, 29, 54};
        InhibitAnyPolicy_data = iArr21;
        int[] iArr22 = {2, 5, 29, 29};
        CertificateIssuer_data = iArr22;
        int[] iArr23 = {1, 3, 6, 1, 5, 5, 7, 1, 1};
        AuthInfoAccess_data = iArr23;
        int[] iArr24 = {1, 3, 6, 1, 5, 5, 7, 1, 11};
        SubjectInfoAccess_data = iArr24;
        int[] iArr25 = {2, 5, 29, 46};
        FreshestCRL_data = iArr25;
        int[] iArr26 = {1, 3, 6, 1, 5, 5, 7, 48, 1, 5};
        OCSPNoCheck_data = iArr26;
        AuthorityKey_Id = ObjectIdentifier.newInternal(iArr);
        SubjectKey_Id = ObjectIdentifier.newInternal(iArr2);
        KeyUsage_Id = ObjectIdentifier.newInternal(iArr3);
        PrivateKeyUsage_Id = ObjectIdentifier.newInternal(iArr4);
        CertificatePolicies_Id = ObjectIdentifier.newInternal(iArr5);
        PolicyMappings_Id = ObjectIdentifier.newInternal(iArr6);
        SubjectAlternativeName_Id = ObjectIdentifier.newInternal(iArr7);
        IssuerAlternativeName_Id = ObjectIdentifier.newInternal(iArr8);
        ExtendedKeyUsage_Id = ObjectIdentifier.newInternal(iArr20);
        InhibitAnyPolicy_Id = ObjectIdentifier.newInternal(iArr21);
        SubjectDirectoryAttributes_Id = ObjectIdentifier.newInternal(iArr9);
        BasicConstraints_Id = ObjectIdentifier.newInternal(iArr10);
        ReasonCode_Id = ObjectIdentifier.newInternal(iArr17);
        HoldInstructionCode_Id = ObjectIdentifier.newInternal(iArr18);
        InvalidityDate_Id = ObjectIdentifier.newInternal(iArr19);
        NameConstraints_Id = ObjectIdentifier.newInternal(iArr11);
        PolicyConstraints_Id = ObjectIdentifier.newInternal(iArr12);
        CRLDistributionPoints_Id = ObjectIdentifier.newInternal(iArr13);
        CRLNumber_Id = ObjectIdentifier.newInternal(iArr14);
        IssuingDistributionPoint_Id = ObjectIdentifier.newInternal(iArr15);
        DeltaCRLIndicator_Id = ObjectIdentifier.newInternal(iArr16);
        CertificateIssuer_Id = ObjectIdentifier.newInternal(iArr22);
        AuthInfoAccess_Id = ObjectIdentifier.newInternal(iArr23);
        SubjectInfoAccess_Id = ObjectIdentifier.newInternal(iArr24);
        FreshestCRL_Id = ObjectIdentifier.newInternal(iArr25);
        OCSPNoCheck_Id = ObjectIdentifier.newInternal(iArr26);
    }
}
