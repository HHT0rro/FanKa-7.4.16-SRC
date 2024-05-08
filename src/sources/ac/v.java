package ac;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f784a = "1234567812345678".getBytes();

    static {
        System.setProperty("org.bouncycastle.asn1.allow_unsafe_integer", "true");
    }

    public static v a() {
        return new v();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10400);
        }
        if (bArr2 == null) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10400);
        }
        if (bArr2.length == 0) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10415);
        }
        if (bArr.length != 65) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10417);
        }
        if (bArr[0] != 4) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10403);
        }
        try {
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = new byte[32];
            System.arraycopy((Object) bArr, 1, (Object) bArr3, 0, 32);
            System.arraycopy((Object) bArr, 33, (Object) bArr4, 0, 32);
            ECPoint createPoint = ECNamedCurveTable.getParameterSpec("sm2p256v1").getCurve().createPoint(new BigInteger(1, bArr3), new BigInteger(1, bArr4));
            ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("sm2p256v1");
            ECPublicKeyParameters eCPublicKeyParameters = new ECPublicKeyParameters(createPoint, new ECDomainParameters(parameterSpec.getCurve(), parameterSpec.getG(), parameterSpec.getN(), parameterSpec.getH(), parameterSpec.getSeed()));
            SM2Engine sM2Engine = new SM2Engine();
            sM2Engine.init(true, new ParametersWithRandom(eCPublicKeyParameters, new SecureRandom()));
            try {
                byte[] processBlock = sM2Engine.processBlock(bArr2, 0, bArr2.length);
                if (processBlock == null || processBlock.length < 97) {
                    throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10406);
                }
                byte[] bArr5 = new byte[processBlock.length];
                System.arraycopy((Object) processBlock, 0, (Object) bArr5, 0, 65);
                System.arraycopy((Object) processBlock, processBlock.length - 32, (Object) bArr5, 65, 32);
                System.arraycopy((Object) processBlock, 65, (Object) bArr5, 97, processBlock.length - 97);
                return bArr5;
            } catch (InvalidCipherTextException e2) {
                throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10200, e2);
            }
        } catch (Exception unused) {
            throw new com.unicom.online.account.kernel.o(com.unicom.online.account.kernel.j.E10416);
        }
    }
}
