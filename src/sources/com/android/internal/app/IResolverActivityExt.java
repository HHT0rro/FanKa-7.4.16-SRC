package com.android.internal.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IResolverActivityExt {
    public static final IResolverActivityExt DEFAULT = new IResolverActivityExt() { // from class: com.android.internal.app.IResolverActivityExt.1
    };

    default void setMultiProfilePagerAdapter(Object abstractMultiProfilePagerAdapter) {
    }

    default Activity getResolverActivity() {
        return null;
    }

    default void hookonCreate(Bundle savedInstanceState) {
    }

    default void hookonResume() {
    }

    default void hookonPause() {
    }

    default void hookFinish() {
    }

    default void hookonDestroy() {
    }

    default boolean hookonSaveInstanceState(Bundle outState, String tabKey) {
        return false;
    }

    default boolean hookonRestoreInstanceState(Bundle savedInstanceState, String tabKey) {
        return false;
    }

    default void hookonMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
    }

    default void hookonConfigurationChanged(Configuration newConfig) {
    }

    default void cacheCustomInfo(Intent intent) {
    }

    default boolean isOriginUi() {
        return true;
    }

    default boolean addExtraOneAppFinish() {
        return true;
    }

    default <T> boolean hookIsLastChosen() {
        return false;
    }

    default void hookconfigureContentView(boolean safeForwardingMode, boolean supportsAlwaysUseOption, int layoutId) {
    }

    default void initView(boolean safeForwardingMode, boolean supportsAlwaysUseOption) {
    }

    default void updateView(boolean safeForwardingMode, boolean supportsAlwaysUseOption) {
    }

    default void initActionSend() {
    }

    default void statisticsData(ResolveInfo ri, int which) {
    }

    default boolean hookonListRebuilt() {
        return false;
    }

    default boolean initPreferenceAndPinList() {
        return true;
    }

    default void performAnimation() {
    }

    default void setChooserPreFileSingleIconView(int iconResId, ImageView fileIconView, boolean needTry, TextView fileNameView, boolean singleFile, String fileName, Uri uri) {
        fileIconView.setImageResource(iconResId);
    }

    default ViewGroup getDisplayFileContentPreview(LayoutInflater layoutInflater, ViewGroup parent) {
        return null;
    }

    default ViewGroup hookdisplayTextContentPreview(Intent targetIntent, LayoutInflater layoutInflater, ViewGroup parent, View.OnClickListener listener) {
        return null;
    }

    default ViewGroup getDisplayImageContentPreview(LayoutInflater layoutInflater, ViewGroup parent) {
        return null;
    }

    default void restoreProfilePager(int pageNumber) {
    }

    default boolean tryApkResourceName(Uri uri, ImageView imageView, TextView textView) {
        return false;
    }

    default void displayTextAddActionButton(ViewGroup actionRow, View.OnClickListener listener) {
    }

    default void setCustomRoundImage(Paint roundRectPaint, Paint textPaint, Paint overlayPaint) {
    }

    default int getCornerRadius(Context context) {
        return 0;
    }

    default UserHandle getWorkProfileUserHandle() {
        return UserHandle.CURRENT;
    }

    default void getWorkProfileUserHandle(UserHandle userHandle) {
    }

    default boolean hasCustomFlag(int flag) {
        return false;
    }

    default Object getMultiProfilePagerAdapter() {
        return null;
    }

    default boolean hookonCopyButtonClicked(ArrayList<Uri> streams) {
        return false;
    }

    default ClipData getclipData(Intent targetIntent) {
        return null;
    }

    default boolean hookgetNearbySharingComponent() {
        return false;
    }

    default void hookmaybeHideContentPreview() {
    }

    default String getChooserPreFileName(Context context, int fileCount, String fileName) {
        return null;
    }

    default boolean getFileSharedDisabled() {
        return false;
    }

    default void clearInactiveProfileCache(int page) {
    }

    default void adaptFontSize(TextView textView) {
    }

    default Bitmap orientationThumbnailBitmap(ContentResolver contentResolver, Uri uri, Bitmap originBitmap) {
        return originBitmap;
    }

    default void setMultiAppAccessMode(String pkgName, int accessMode) {
    }

    default void hookeConfigureMiniResolverContent() {
    }
}
