package android.webkit;

import android.annotation.SystemApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.view.translation.TranslationCapability;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import android.webkit.WebView;
import java.io.BufferedWriter;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@SystemApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface WebViewProvider {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ScrollDelegate {
        int computeHorizontalScrollOffset();

        int computeHorizontalScrollRange();

        void computeScroll();

        int computeVerticalScrollExtent();

        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();
    }

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoBackOrForward(int i10);

    boolean canGoForward();

    boolean canZoomIn();

    boolean canZoomOut();

    Picture capturePicture();

    void clearCache(boolean z10);

    void clearFormData();

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    void clearView();

    WebBackForwardList copyBackForwardList();

    PrintDocumentAdapter createPrintDocumentAdapter(String str);

    WebMessagePort[] createWebMessageChannel();

    void destroy();

    void documentHasImages(Message message);

    void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i10);

    void evaluateJavaScript(String str, ValueCallback<String> valueCallback);

    int findAll(String str);

    void findAllAsync(String str);

    View findHierarchyView(String str, int i10);

    void findNext(boolean z10);

    void flingScroll(int i10, int i11);

    void freeMemory();

    SslCertificate getCertificate();

    int getContentHeight();

    int getContentWidth();

    Bitmap getFavicon();

    WebView.HitTestResult getHitTestResult();

    String[] getHttpAuthUsernamePassword(String str, String str2);

    String getOriginalUrl();

    int getProgress();

    boolean getRendererPriorityWaivedWhenNotVisible();

    int getRendererRequestedPriority();

    float getScale();

    ScrollDelegate getScrollDelegate();

    WebSettings getSettings();

    String getTitle();

    String getTouchIconUrl();

    String getUrl();

    ViewDelegate getViewDelegate();

    int getVisibleTitleHeight();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    WebViewRenderProcess getWebViewRenderProcess();

    WebViewRenderProcessClient getWebViewRenderProcessClient();

    View getZoomControls();

    void goBack();

    void goBackOrForward(int i10);

    void goForward();

    void init(Map<String, Object> map, boolean z10);

    void insertVisualStateCallback(long j10, WebView.VisualStateCallback visualStateCallback);

    void invokeZoomPicker();

    boolean isPaused();

    boolean isPrivateBrowsingEnabled();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void notifyFindDialogDismissed();

    void onPause();

    void onResume();

    boolean overlayHorizontalScrollbar();

    boolean overlayVerticalScrollbar();

    boolean pageDown(boolean z10);

    boolean pageUp(boolean z10);

    void pauseTimers();

    void postMessageToMainFrame(WebMessage webMessage, Uri uri);

    void postUrl(String str, byte[] bArr);

    void reload();

    void removeJavascriptInterface(String str);

    void requestFocusNodeHref(Message message);

    void requestImageRef(Message message);

    boolean restorePicture(Bundle bundle, File file);

    WebBackForwardList restoreState(Bundle bundle);

    void resumeTimers();

    void savePassword(String str, String str2, String str3);

    boolean savePicture(Bundle bundle, File file);

    WebBackForwardList saveState(Bundle bundle);

    void saveWebArchive(String str);

    void saveWebArchive(String str, boolean z10, ValueCallback<String> valueCallback);

    void setCertificate(SslCertificate sslCertificate);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(WebView.FindListener findListener);

    void setHorizontalScrollbarOverlay(boolean z10);

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setInitialScale(int i10);

    void setMapTrackballToArrowKeys(boolean z10);

    void setNetworkAvailable(boolean z10);

    void setPictureListener(WebView.PictureListener pictureListener);

    void setRendererPriorityPolicy(int i10, boolean z10);

    void setVerticalScrollbarOverlay(boolean z10);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient);

    boolean showFindDialog(String str, boolean z10);

    void stopLoading();

    boolean zoomBy(float f10);

    boolean zoomIn();

    boolean zoomOut();

    default void setTextClassifier(TextClassifier textClassifier) {
    }

    default TextClassifier getTextClassifier() {
        return TextClassifier.NO_OP;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ViewDelegate {
        boolean dispatchKeyEvent(KeyEvent keyEvent);

        View findFocus(View view);

        AccessibilityNodeProvider getAccessibilityNodeProvider();

        Handler getHandler(Handler handler);

        void onActivityResult(int i10, int i11, Intent intent);

        void onAttachedToWindow();

        void onConfigurationChanged(Configuration configuration);

        InputConnection onCreateInputConnection(EditorInfo editorInfo);

        void onDetachedFromWindow();

        boolean onDragEvent(DragEvent dragEvent);

        void onDraw(Canvas canvas);

        void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i10, int i11, int i12, int i13);

        void onFinishTemporaryDetach();

        void onFocusChanged(boolean z10, int i10, Rect rect);

        boolean onGenericMotionEvent(MotionEvent motionEvent);

        boolean onHoverEvent(MotionEvent motionEvent);

        void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo);

        boolean onKeyDown(int i10, KeyEvent keyEvent);

        boolean onKeyMultiple(int i10, int i11, KeyEvent keyEvent);

        boolean onKeyUp(int i10, KeyEvent keyEvent);

        void onMeasure(int i10, int i11);

        void onOverScrolled(int i10, int i11, boolean z10, boolean z11);

        void onProvideVirtualStructure(ViewStructure viewStructure);

        void onScrollChanged(int i10, int i11, int i12, int i13);

        void onSizeChanged(int i10, int i11, int i12, int i13);

        void onStartTemporaryDetach();

        boolean onTouchEvent(MotionEvent motionEvent);

        boolean onTrackballEvent(MotionEvent motionEvent);

        void onVisibilityChanged(View view, int i10);

        void onWindowFocusChanged(boolean z10);

        void onWindowVisibilityChanged(int i10);

        boolean performAccessibilityAction(int i10, Bundle bundle);

        boolean performLongClick();

        void preDispatchDraw(Canvas canvas);

        boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10);

        boolean requestFocus(int i10, Rect rect);

        void setBackgroundColor(int i10);

        boolean setFrame(int i10, int i11, int i12, int i13);

        void setLayerType(int i10, Paint paint);

        void setLayoutParams(ViewGroup.LayoutParams layoutParams);

        void setOverScrollMode(int i10);

        void setScrollBarStyle(int i10);

        boolean shouldDelayChildPressedState();

        default void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        }

        default void autofill(SparseArray<AutofillValue> values) {
        }

        default boolean isVisibleToUserForAutofill(int virtualId) {
            return true;
        }

        default void onProvideContentCaptureStructure(ViewStructure structure, int flags) {
        }

        default void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        }

        default void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        }

        default void dispatchCreateViewTranslationRequest(Map<AutofillId, long[]> viewIds, int[] supportedFormats, TranslationCapability capability, List<ViewTranslationRequest> requests) {
        }

        default void onMovedToDisplay(int displayId, Configuration config) {
        }

        default boolean onCheckIsTextEditor() {
            return false;
        }

        default WindowInsets onApplyWindowInsets(WindowInsets insets) {
            return null;
        }
    }
}
