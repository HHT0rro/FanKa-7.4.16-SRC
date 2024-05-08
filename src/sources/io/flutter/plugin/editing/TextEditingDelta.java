package io.flutter.plugin.editing;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TextEditingDelta {
    private static final String TAG = "TextEditingDelta";
    private int deltaEnd;
    private int deltaStart;

    @NonNull
    private CharSequence deltaText;
    private int newComposingEnd;
    private int newComposingStart;
    private int newSelectionEnd;
    private int newSelectionStart;

    @NonNull
    private CharSequence oldText;

    public TextEditingDelta(@NonNull CharSequence charSequence, int i10, int i11, @NonNull CharSequence charSequence2, int i12, int i13, int i14, int i15) {
        this.newSelectionStart = i12;
        this.newSelectionEnd = i13;
        this.newComposingStart = i14;
        this.newComposingEnd = i15;
        setDeltas(charSequence, charSequence2.toString(), i10, i11);
    }

    private void setDeltas(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, int i10, int i11) {
        this.oldText = charSequence;
        this.deltaText = charSequence2;
        this.deltaStart = i10;
        this.deltaEnd = i11;
    }

    @VisibleForTesting
    public int getDeltaEnd() {
        return this.deltaEnd;
    }

    @VisibleForTesting
    public int getDeltaStart() {
        return this.deltaStart;
    }

    @NonNull
    @VisibleForTesting
    public CharSequence getDeltaText() {
        return this.deltaText;
    }

    @VisibleForTesting
    public int getNewComposingEnd() {
        return this.newComposingEnd;
    }

    @VisibleForTesting
    public int getNewComposingStart() {
        return this.newComposingStart;
    }

    @VisibleForTesting
    public int getNewSelectionEnd() {
        return this.newSelectionEnd;
    }

    @VisibleForTesting
    public int getNewSelectionStart() {
        return this.newSelectionStart;
    }

    @NonNull
    @VisibleForTesting
    public CharSequence getOldText() {
        return this.oldText;
    }

    @NonNull
    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.oldText.toString());
            jSONObject.put("deltaText", this.deltaText.toString());
            jSONObject.put("deltaStart", this.deltaStart);
            jSONObject.put("deltaEnd", this.deltaEnd);
            jSONObject.put("selectionBase", this.newSelectionStart);
            jSONObject.put("selectionExtent", this.newSelectionEnd);
            jSONObject.put("composingBase", this.newComposingStart);
            jSONObject.put("composingExtent", this.newComposingEnd);
        } catch (JSONException e2) {
            Log.e(TAG, "unable to create JSONObject: " + ((Object) e2));
        }
        return jSONObject;
    }

    public TextEditingDelta(@NonNull CharSequence charSequence, int i10, int i11, int i12, int i13) {
        this.newSelectionStart = i10;
        this.newSelectionEnd = i11;
        this.newComposingStart = i12;
        this.newComposingEnd = i13;
        setDeltas(charSequence, "", -1, -1);
    }
}
