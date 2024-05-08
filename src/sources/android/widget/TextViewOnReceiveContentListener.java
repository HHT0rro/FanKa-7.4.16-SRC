package android.widget;

import android.compat.Compatibility;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import com.huawei.quickcard.base.http.ContentType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final long AUTOFILL_NON_TEXT_REQUIRES_ON_RECEIVE_CONTENT_LISTENER = 163400105;
    private static final String LOG_TAG = "ReceiveContent";
    private InputConnectionInfo mInputConnectionInfo;

    @Override // android.view.OnReceiveContentListener
    public ContentInfo onReceiveContent(View view, ContentInfo payload) {
        CharSequence itemText;
        if (Log.isLoggable(LOG_TAG, 3)) {
            Log.d(LOG_TAG, "onReceive: " + ((Object) payload));
        }
        int source = payload.getSource();
        if (source == 2) {
            return payload;
        }
        if (source == 4) {
            onReceiveForAutofill((TextView) view, payload);
            return null;
        }
        ClipData clip = payload.getClip();
        int flags = payload.getFlags();
        Editable editable = (Editable) ((TextView) view).getText();
        Context context = view.getContext();
        boolean didFirst = false;
        for (int i10 = 0; i10 < clip.getItemCount(); i10++) {
            if ((flags & 1) != 0) {
                CharSequence itemText2 = clip.getItemAt(i10).coerceToText(context);
                itemText = itemText2 instanceof Spanned ? itemText2.toString() : itemText2;
            } else {
                itemText = clip.getItemAt(i10).coerceToStyledText(context);
            }
            if (itemText != null) {
                if (!didFirst) {
                    replaceSelection(editable, itemText);
                    didFirst = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), itemText);
                }
            }
        }
        return null;
    }

    private static void replaceSelection(Editable editable, CharSequence replacement) {
        int selStart = Selection.getSelectionStart(editable);
        int selEnd = Selection.getSelectionEnd(editable);
        int start = Math.max(0, Math.min(selStart, selEnd));
        int end = Math.max(0, Math.max(selStart, selEnd));
        Selection.setSelection(editable, end);
        editable.replace(start, end, replacement);
    }

    private void onReceiveForAutofill(TextView view, ContentInfo payload) {
        ClipData clip = payload.getClip();
        if (isUsageOfImeCommitContentEnabled(view) && (clip = handleNonTextViaImeCommitContent(clip)) == null) {
            if (Log.isLoggable(LOG_TAG, 2)) {
                Log.v(LOG_TAG, "onReceive: Handled via IME");
            }
        } else {
            CharSequence text = coerceToText(clip, view.getContext(), payload.getFlags());
            view.setText(text);
            Editable editable = (Editable) view.getText();
            Selection.setSelection(editable, editable.length());
        }
    }

    private static CharSequence coerceToText(ClipData clip, Context context, int flags) {
        CharSequence itemText;
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        for (int i10 = 0; i10 < clip.getItemCount(); i10++) {
            if ((flags & 1) != 0) {
                CharSequence itemText2 = clip.getItemAt(i10).coerceToText(context);
                itemText = itemText2 instanceof Spanned ? itemText2.toString() : itemText2;
            } else {
                itemText = clip.getItemAt(i10).coerceToStyledText(context);
            }
            if (itemText != null) {
                ssb.append(itemText);
            }
        }
        return ssb;
    }

    private static boolean isUsageOfImeCommitContentEnabled(View view) {
        return view.getReceiveContentMimeTypes() == null && !Compatibility.isChangeEnabled(AUTOFILL_NON_TEXT_REQUIRES_ON_RECEIVE_CONTENT_LISTENER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class InputConnectionInfo {
        private final String[] mEditorInfoContentMimeTypes;
        private final WeakReference<InputConnection> mInputConnection;

        private InputConnectionInfo(InputConnection inputConnection, String[] editorInfoContentMimeTypes) {
            this.mInputConnection = new WeakReference<>(inputConnection);
            this.mEditorInfoContentMimeTypes = editorInfoContentMimeTypes;
        }

        public String toString() {
            return "InputConnectionInfo{mimeTypes=" + Arrays.toString(this.mEditorInfoContentMimeTypes) + ", ic=" + ((Object) this.mInputConnection) + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInputConnectionInfo(TextView view, InputConnection ic2, EditorInfo editorInfo) {
        if (!isUsageOfImeCommitContentEnabled(view)) {
            this.mInputConnectionInfo = null;
            return;
        }
        String[] contentMimeTypes = editorInfo.contentMimeTypes;
        if (contentMimeTypes == null || contentMimeTypes.length == 0) {
            this.mInputConnectionInfo = null;
        } else {
            this.mInputConnectionInfo = new InputConnectionInfo(ic2, contentMimeTypes);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearInputConnectionInfo() {
        this.mInputConnectionInfo = null;
    }

    public String[] getFallbackMimeTypesForAutofill(TextView view) {
        InputConnectionInfo icInfo;
        if (isUsageOfImeCommitContentEnabled(view) && (icInfo = this.mInputConnectionInfo) != null) {
            return icInfo.mEditorInfoContentMimeTypes;
        }
        return null;
    }

    private ClipData handleNonTextViaImeCommitContent(ClipData clip) {
        ClipDescription description = clip.getDescription();
        if (containsUri(clip) && !containsOnlyText(clip)) {
            InputConnectionInfo icInfo = this.mInputConnectionInfo;
            InputConnection inputConnection = icInfo != null ? (InputConnection) icInfo.mInputConnection.get() : null;
            if (inputConnection == null) {
                if (Log.isLoggable(LOG_TAG, 3)) {
                    Log.d(LOG_TAG, "onReceive: No usable EditorInfo/InputConnection");
                }
                return clip;
            }
            String[] editorInfoContentMimeTypes = icInfo.mEditorInfoContentMimeTypes;
            if (!isClipMimeTypeSupported(editorInfoContentMimeTypes, clip.getDescription())) {
                if (Log.isLoggable(LOG_TAG, 3)) {
                    Log.d(LOG_TAG, "onReceive: MIME type is not supported by the app's commitContent impl");
                }
                return clip;
            }
            if (Log.isLoggable(LOG_TAG, 2)) {
                Log.v(LOG_TAG, "onReceive: Trying to insert via IME: " + ((Object) description));
            }
            int i10 = 0;
            ArrayList<ClipData.Item> remainingItems = new ArrayList<>(0);
            int i11 = 0;
            while (i11 < clip.getItemCount()) {
                ClipData.Item item = clip.getItemAt(i11);
                Uri uri = item.getUri();
                if (uri == null || !"content".equals(uri.getScheme())) {
                    if (Log.isLoggable(LOG_TAG, 2)) {
                        Log.v(LOG_TAG, "onReceive: No content URI in item: uri=" + ((Object) uri));
                    }
                    remainingItems.add(item);
                } else {
                    if (Log.isLoggable(LOG_TAG, 2)) {
                        Log.v(LOG_TAG, "onReceive: Calling commitContent: uri=" + ((Object) uri));
                    }
                    InputContentInfo contentInfo = new InputContentInfo(uri, description);
                    if (!inputConnection.commitContent(contentInfo, i10, null)) {
                        if (Log.isLoggable(LOG_TAG, 2)) {
                            Log.v(LOG_TAG, "onReceive: Call to commitContent returned false: uri=" + ((Object) uri));
                        }
                        remainingItems.add(item);
                    }
                }
                i11++;
                i10 = 0;
            }
            if (remainingItems.isEmpty()) {
                return null;
            }
            return new ClipData(description, remainingItems);
        }
        if (Log.isLoggable(LOG_TAG, 2)) {
            Log.v(LOG_TAG, "onReceive: Clip doesn't contain any non-text URIs: " + ((Object) description));
        }
        return clip;
    }

    private static boolean isClipMimeTypeSupported(String[] supportedMimeTypes, ClipDescription description) {
        for (String imeSupportedMimeType : supportedMimeTypes) {
            if (description.hasMimeType(imeSupportedMimeType)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUri(ClipData clip) {
        for (int i10 = 0; i10 < clip.getItemCount(); i10++) {
            ClipData.Item item = clip.getItemAt(i10);
            if (item.getUri() != null) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsOnlyText(ClipData clip) {
        ClipDescription description = clip.getDescription();
        for (int i10 = 0; i10 < description.getMimeTypeCount(); i10++) {
            String mimeType = description.getMimeType(i10);
            if (!mimeType.startsWith(ContentType.TEXT)) {
                return false;
            }
        }
        return true;
    }
}
