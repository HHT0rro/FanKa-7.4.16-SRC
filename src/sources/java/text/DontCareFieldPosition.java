package java.text;

import java.text.Format;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DontCareFieldPosition extends FieldPosition {
    static final FieldPosition INSTANCE = new DontCareFieldPosition();
    private final Format.FieldDelegate noDelegate;

    private DontCareFieldPosition() {
        super(0);
        this.noDelegate = new Format.FieldDelegate() { // from class: java.text.DontCareFieldPosition.1
            @Override // java.text.Format.FieldDelegate
            public void formatted(Format.Field attr, Object value, int start, int end, StringBuffer buffer) {
            }

            @Override // java.text.Format.FieldDelegate
            public void formatted(int fieldID, Format.Field attr, Object value, int start, int end, StringBuffer buffer) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.text.FieldPosition
    public Format.FieldDelegate getFieldDelegate() {
        return this.noDelegate;
    }
}
