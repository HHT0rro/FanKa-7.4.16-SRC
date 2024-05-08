package android.view.autofill;

import android.annotation.SuppressLint;
import com.android.internal.util.AnnotationValidations;
import java.lang.annotation.Annotation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class VirtualViewFillInfo {
    private String[] mAutofillHints;

    /* renamed from: -$$Nest$smdefaultAutofillHints, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m581$$Nest$smdefaultAutofillHints() {
        return defaultAutofillHints();
    }

    private static String[] defaultAutofillHints() {
        return null;
    }

    VirtualViewFillInfo(String[] autofillHints) {
        this.mAutofillHints = autofillHints;
        AnnotationValidations.validate(SuppressLint.class, (Annotation) null, autofillHints, new Object[]{"value", "NullableCollection"});
    }

    public String[] getAutofillHints() {
        return this.mAutofillHints;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private String[] mAutofillHints;
        private long mBuilderFieldsSet = 0;

        public Builder setAutofillHints(String... value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 1;
            this.mAutofillHints = value;
            return this;
        }

        public VirtualViewFillInfo build() {
            checkNotUsed();
            long j10 = this.mBuilderFieldsSet | 2;
            this.mBuilderFieldsSet = j10;
            if ((j10 & 1) == 0) {
                this.mAutofillHints = VirtualViewFillInfo.m581$$Nest$smdefaultAutofillHints();
            }
            VirtualViewFillInfo o10 = new VirtualViewFillInfo(this.mAutofillHints);
            return o10;
        }

        private void checkNotUsed() {
            if ((this.mBuilderFieldsSet & 2) != 0) {
                throw new IllegalStateException("This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @Deprecated
    private void __metadata() {
    }
}
