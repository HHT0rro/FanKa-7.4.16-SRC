package android.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MultiAutoCompleteTextView extends AutoCompleteTextView {
    private Tokenizer mTokenizer;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Tokenizer {
        int findTokenEnd(CharSequence charSequence, int i10);

        int findTokenStart(CharSequence charSequence, int i10);

        CharSequence terminateToken(CharSequence charSequence);
    }

    public MultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842859);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    void finishInit() {
    }

    public void setTokenizer(Tokenizer t2) {
        this.mTokenizer = t2;
    }

    @Override // android.widget.AutoCompleteTextView
    protected void performFiltering(CharSequence text, int keyCode) {
        if (enoughToFilter()) {
            int end = getSelectionEnd();
            int start = this.mTokenizer.findTokenStart(text, end);
            performFiltering(text, start, end, keyCode);
        } else {
            dismissDropDown();
            Filter f10 = getFilter();
            if (f10 != null) {
                f10.filter(null);
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        Tokenizer tokenizer;
        Editable text = getText();
        int end = getSelectionEnd();
        if (end < 0 || (tokenizer = this.mTokenizer) == null) {
            return false;
        }
        int start = tokenizer.findTokenStart(text, end);
        if (end - start < getThreshold()) {
            return false;
        }
        return true;
    }

    @Override // android.widget.AutoCompleteTextView
    public void performValidation() {
        AutoCompleteTextView.Validator v2 = getValidator();
        if (v2 == null || this.mTokenizer == null) {
            return;
        }
        Editable e2 = getText();
        int i10 = getText().length();
        while (i10 > 0) {
            int start = this.mTokenizer.findTokenStart(e2, i10);
            int end = this.mTokenizer.findTokenEnd(e2, start);
            CharSequence sub = e2.subSequence(start, end);
            if (TextUtils.isEmpty(sub)) {
                e2.replace(start, i10, "");
            } else if (!v2.isValid(sub)) {
                e2.replace(start, i10, this.mTokenizer.terminateToken(v2.fixText(sub)));
            }
            i10 = start;
        }
    }

    protected void performFiltering(CharSequence text, int start, int end, int keyCode) {
        getFilter().filter(text.subSequence(start, end), this);
    }

    @Override // android.widget.AutoCompleteTextView
    protected void replaceText(CharSequence text) {
        clearComposingText();
        int end = getSelectionEnd();
        int start = this.mTokenizer.findTokenStart(getText(), end);
        Editable editable = getText();
        String original = TextUtils.substring(editable, start, end);
        QwertyKeyListener.markAsReplaced(editable, start, end, original);
        editable.replace(start, end, this.mTokenizer.terminateToken(text));
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.EditText, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MultiAutoCompleteTextView.class.getName();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CommaTokenizer implements Tokenizer {
        @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
        public int findTokenStart(CharSequence text, int cursor) {
            int i10 = cursor;
            while (i10 > 0 && text.charAt(i10 - 1) != ',') {
                i10--;
            }
            while (i10 < cursor && text.charAt(i10) == ' ') {
                i10++;
            }
            return i10;
        }

        @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
        public int findTokenEnd(CharSequence text, int cursor) {
            int len = text.length();
            for (int i10 = cursor; i10 < len; i10++) {
                if (text.charAt(i10) == ',') {
                    return i10;
                }
            }
            return len;
        }

        @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
        public CharSequence terminateToken(CharSequence text) {
            int i10 = text.length();
            while (i10 > 0 && text.charAt(i10 - 1) == ' ') {
                i10--;
            }
            if (i10 > 0 && text.charAt(i10 - 1) == ',') {
                return text;
            }
            if (text instanceof Spanned) {
                SpannableString sp = new SpannableString(((Object) text) + ", ");
                TextUtils.copySpansFrom((Spanned) text, 0, text.length(), Object.class, sp, 0);
                return sp;
            }
            return ((Object) text) + ", ";
        }
    }
}
