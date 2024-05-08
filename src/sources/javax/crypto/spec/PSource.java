package javax.crypto.spec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PSource {
    private String pSrcName;

    protected PSource(String pSrcName) {
        if (pSrcName == null) {
            throw new NullPointerException("pSource algorithm is null");
        }
        this.pSrcName = pSrcName;
    }

    public String getAlgorithm() {
        return this.pSrcName;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class PSpecified extends PSource {
        public static final PSpecified DEFAULT = new PSpecified(new byte[0]);

        /* renamed from: p, reason: collision with root package name */
        private byte[] f50550p;

        public PSpecified(byte[] p10) {
            super("PSpecified");
            this.f50550p = new byte[0];
            this.f50550p = (byte[]) p10.clone();
        }

        public byte[] getValue() {
            byte[] bArr = this.f50550p;
            return bArr.length == 0 ? bArr : (byte[]) bArr.clone();
        }
    }
}
