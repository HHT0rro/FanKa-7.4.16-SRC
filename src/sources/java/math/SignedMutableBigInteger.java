package java.math;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SignedMutableBigInteger extends MutableBigInteger {
    int sign;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignedMutableBigInteger() {
        this.sign = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignedMutableBigInteger(int val) {
        super(val);
        this.sign = 1;
    }

    SignedMutableBigInteger(MutableBigInteger val) {
        super(val);
        this.sign = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void signedAdd(SignedMutableBigInteger addend) {
        int i10 = this.sign;
        if (i10 == addend.sign) {
            add(addend);
        } else {
            this.sign = i10 * subtract(addend);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void signedAdd(MutableBigInteger addend) {
        int i10 = this.sign;
        if (i10 == 1) {
            add(addend);
        } else {
            this.sign = i10 * subtract(addend);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void signedSubtract(SignedMutableBigInteger addend) {
        int i10 = this.sign;
        if (i10 == addend.sign) {
            this.sign = i10 * subtract(addend);
        } else {
            add(addend);
        }
    }

    void signedSubtract(MutableBigInteger addend) {
        int i10 = this.sign;
        if (i10 == 1) {
            this.sign = i10 * subtract(addend);
        } else {
            add(addend);
        }
        if (this.intLen == 0) {
            this.sign = 1;
        }
    }

    @Override // java.math.MutableBigInteger
    public String toString() {
        return toBigInteger(this.sign).toString();
    }
}
