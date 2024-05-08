package android.webkit;

import android.annotation.SystemApi;
import android.content.Context;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class WebSettings {

    @SystemApi
    public static final long ENABLE_SIMPLIFIED_DARK_MODE = 214741472;
    public static final int FORCE_DARK_AUTO = 1;
    public static final int FORCE_DARK_OFF = 0;
    public static final int FORCE_DARK_ON = 2;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;

    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    public static final int MENU_ITEM_NONE = 0;
    public static final int MENU_ITEM_PROCESS_TEXT = 4;
    public static final int MENU_ITEM_SHARE = 1;
    public static final int MENU_ITEM_WEB_SEARCH = 2;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface CacheMode {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ForceDark {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private @interface MenuItemFlags {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    @Deprecated
    public abstract boolean enableSmoothTransition();

    @SystemApi
    public abstract boolean getAcceptThirdPartyCookies();

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    public abstract boolean getBlockNetworkImage();

    public abstract boolean getBlockNetworkLoads();

    public abstract boolean getBuiltInZoomControls();

    public abstract int getCacheMode();

    public abstract String getCursiveFontFamily();

    public abstract boolean getDatabaseEnabled();

    @Deprecated
    public abstract String getDatabasePath();

    public abstract int getDefaultFixedFontSize();

    public abstract int getDefaultFontSize();

    public abstract String getDefaultTextEncodingName();

    @Deprecated
    public abstract ZoomDensity getDefaultZoom();

    public abstract int getDisabledActionModeMenuItems();

    public abstract boolean getDisplayZoomControls();

    public abstract boolean getDomStorageEnabled();

    public abstract String getFantasyFontFamily();

    public abstract String getFixedFontFamily();

    public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

    public abstract boolean getJavaScriptEnabled();

    public abstract LayoutAlgorithm getLayoutAlgorithm();

    @Deprecated
    public abstract boolean getLightTouchEnabled();

    public abstract boolean getLoadWithOverviewMode();

    public abstract boolean getLoadsImagesAutomatically();

    public abstract boolean getMediaPlaybackRequiresUserGesture();

    public abstract int getMinimumFontSize();

    public abstract int getMinimumLogicalFontSize();

    public abstract int getMixedContentMode();

    @SystemApi
    @Deprecated
    public abstract boolean getNavDump();

    public abstract boolean getOffscreenPreRaster();

    @Deprecated
    public abstract PluginState getPluginState();

    @SystemApi
    @Deprecated
    public abstract boolean getPluginsEnabled();

    public abstract boolean getSafeBrowsingEnabled();

    public abstract String getSansSerifFontFamily();

    @Deprecated
    public abstract boolean getSaveFormData();

    @Deprecated
    public abstract boolean getSavePassword();

    public abstract String getSerifFontFamily();

    public abstract String getStandardFontFamily();

    public abstract int getTextZoom();

    @SystemApi
    @Deprecated
    public abstract boolean getUseWebViewBackgroundForOverscrollBackground();

    public abstract boolean getUseWideViewPort();

    @SystemApi
    @Deprecated
    public abstract int getUserAgent();

    public abstract String getUserAgentString();

    @SystemApi
    public abstract boolean getVideoOverlayForEmbeddedEncryptedVideoEnabled();

    @SystemApi
    public abstract void setAcceptThirdPartyCookies(boolean z10);

    public abstract void setAllowContentAccess(boolean z10);

    public abstract void setAllowFileAccess(boolean z10);

    @Deprecated
    public abstract void setAllowFileAccessFromFileURLs(boolean z10);

    @Deprecated
    public abstract void setAllowUniversalAccessFromFileURLs(boolean z10);

    public abstract void setBlockNetworkImage(boolean z10);

    public abstract void setBlockNetworkLoads(boolean z10);

    public abstract void setBuiltInZoomControls(boolean z10);

    public abstract void setCacheMode(int i10);

    public abstract void setCursiveFontFamily(String str);

    public abstract void setDatabaseEnabled(boolean z10);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultFixedFontSize(int i10);

    public abstract void setDefaultFontSize(int i10);

    public abstract void setDefaultTextEncodingName(String str);

    @Deprecated
    public abstract void setDefaultZoom(ZoomDensity zoomDensity);

    public abstract void setDisabledActionModeMenuItems(int i10);

    public abstract void setDisplayZoomControls(boolean z10);

    public abstract void setDomStorageEnabled(boolean z10);

    @Deprecated
    public abstract void setEnableSmoothTransition(boolean z10);

    public abstract void setFantasyFontFamily(String str);

    public abstract void setFixedFontFamily(String str);

    @Deprecated
    public abstract void setGeolocationDatabasePath(String str);

    public abstract void setGeolocationEnabled(boolean z10);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z10);

    public abstract void setJavaScriptEnabled(boolean z10);

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    @Deprecated
    public abstract void setLightTouchEnabled(boolean z10);

    public abstract void setLoadWithOverviewMode(boolean z10);

    public abstract void setLoadsImagesAutomatically(boolean z10);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z10);

    public abstract void setMinimumFontSize(int i10);

    public abstract void setMinimumLogicalFontSize(int i10);

    public abstract void setMixedContentMode(int i10);

    @SystemApi
    @Deprecated
    public abstract void setNavDump(boolean z10);

    public abstract void setNeedInitialFocus(boolean z10);

    public abstract void setOffscreenPreRaster(boolean z10);

    @Deprecated
    public abstract void setPluginState(PluginState pluginState);

    @SystemApi
    @Deprecated
    public abstract void setPluginsEnabled(boolean z10);

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public abstract void setSafeBrowsingEnabled(boolean z10);

    public abstract void setSansSerifFontFamily(String str);

    @Deprecated
    public abstract void setSaveFormData(boolean z10);

    @Deprecated
    public abstract void setSavePassword(boolean z10);

    public abstract void setSerifFontFamily(String str);

    public abstract void setStandardFontFamily(String str);

    public abstract void setSupportMultipleWindows(boolean z10);

    public abstract void setSupportZoom(boolean z10);

    public abstract void setTextZoom(int i10);

    @SystemApi
    @Deprecated
    public abstract void setUseWebViewBackgroundForOverscrollBackground(boolean z10);

    public abstract void setUseWideViewPort(boolean z10);

    @SystemApi
    @Deprecated
    public abstract void setUserAgent(int i10);

    public abstract void setUserAgentString(String str);

    @SystemApi
    public abstract void setVideoOverlayForEmbeddedEncryptedVideoEnabled(boolean z10);

    public abstract boolean supportMultipleWindows();

    public abstract boolean supportZoom();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);

        int value;

        TextSize(int size) {
            this.value = size;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int size) {
            this.value = size;
        }

        public int getValue() {
            return this.value;
        }
    }

    @Deprecated
    public synchronized void setTextSize(TextSize t2) {
        setTextZoom(t2.value);
    }

    @Deprecated
    public synchronized TextSize getTextSize() {
        TextSize closestSize = null;
        int smallestDelta = Integer.MAX_VALUE;
        int textSize = getTextZoom();
        for (TextSize size : TextSize.values()) {
            int delta = Math.abs(textSize - size.value);
            if (delta == 0) {
                return size;
            }
            if (delta < smallestDelta) {
                smallestDelta = delta;
                closestSize = size;
            }
        }
        return closestSize != null ? closestSize : TextSize.NORMAL;
    }

    @Deprecated
    public void setUseDoubleTree(boolean use) {
    }

    @Deprecated
    public boolean getUseDoubleTree() {
        return false;
    }

    @Deprecated
    public void setPluginsPath(String pluginsPath) {
    }

    @Deprecated
    public void setAppCacheEnabled(boolean flag) {
    }

    @Deprecated
    public void setAppCachePath(String appCachePath) {
    }

    @Deprecated
    public void setAppCacheMaxSize(long appCacheMaxSize) {
    }

    @Deprecated
    public String getPluginsPath() {
        return "";
    }

    public static String getDefaultUserAgent(Context context) {
        return WebViewFactory.getProvider().getStatics().getDefaultUserAgent(context);
    }

    public void setForceDark(int forceDark) {
    }

    public int getForceDark() {
        return 1;
    }

    public void setAlgorithmicDarkeningAllowed(boolean allow) {
    }

    public boolean isAlgorithmicDarkeningAllowed() {
        return false;
    }
}
