package java.text;

import android.icu.text.Normalizer2;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Normalizer {
    private Normalizer() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Form {
        NFD(new Supplier() { // from class: java.text.Normalizer$Form$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Normalizer2.getNFDInstance();
            }
        }),
        NFC(new Supplier() { // from class: java.text.Normalizer$Form$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return Normalizer2.getNFCInstance();
            }
        }),
        NFKD(new Supplier() { // from class: java.text.Normalizer$Form$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return Normalizer2.getNFKDInstance();
            }
        }),
        NFKC(new Supplier() { // from class: java.text.Normalizer$Form$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return Normalizer2.getNFKCInstance();
            }
        });

        private final Supplier<Normalizer2> icuNormalizer;

        Form(Supplier supplier) {
            this.icuNormalizer = supplier;
        }
    }

    public static String normalize(CharSequence src, Form form) {
        return ((Normalizer2) form.icuNormalizer.get()).normalize(src);
    }

    public static boolean isNormalized(CharSequence src, Form form) {
        return ((Normalizer2) form.icuNormalizer.get()).isNormalized(src);
    }
}
