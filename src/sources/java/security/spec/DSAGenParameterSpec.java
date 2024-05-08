package java.security.spec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DSAGenParameterSpec implements AlgorithmParameterSpec {
    private final int pLen;
    private final int qLen;
    private final int seedLen;

    public DSAGenParameterSpec(int primePLen, int subprimeQLen) {
        this(primePLen, subprimeQLen, subprimeQLen);
    }

    public DSAGenParameterSpec(int primePLen, int subprimeQLen, int seedLen) {
        switch (primePLen) {
            case 1024:
                if (subprimeQLen != 160) {
                    throw new IllegalArgumentException("subprimeQLen must be 160 when primePLen=1024");
                }
                break;
            case 2048:
                if (subprimeQLen != 224 && subprimeQLen != 256) {
                    throw new IllegalArgumentException("subprimeQLen must be 224 or 256 when primePLen=2048");
                }
                break;
            case 3072:
                if (subprimeQLen != 256) {
                    throw new IllegalArgumentException("subprimeQLen must be 256 when primePLen=3072");
                }
                break;
            default:
                throw new IllegalArgumentException("primePLen must be 1024, 2048, or 3072");
        }
        if (seedLen < subprimeQLen) {
            throw new IllegalArgumentException("seedLen must be equal to or greater than subprimeQLen");
        }
        this.pLen = primePLen;
        this.qLen = subprimeQLen;
        this.seedLen = seedLen;
    }

    public int getPrimePLength() {
        return this.pLen;
    }

    public int getSubprimeQLength() {
        return this.qLen;
    }

    public int getSeedLength() {
        return this.seedLen;
    }
}
