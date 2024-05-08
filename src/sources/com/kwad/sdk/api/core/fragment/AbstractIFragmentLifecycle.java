package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbstractIFragmentLifecycle implements IFragmentLifecycle {
    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i10, int i11, Intent intent) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onAttach(Activity activity) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onAttach(Context context) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onAttachFragment(KsFragment ksFragment) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public Animation onCreateAnimation(int i10, boolean z10, int i11) {
        return null;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public Animator onCreateAnimator(int i10, boolean z10, int i11) {
        return null;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyOptionsMenu() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDetach() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onHiddenChanged(boolean z10) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onLowMemory() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onMultiWindowModeChanged(boolean z10) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onOptionsMenuClosed(Menu menu) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPictureInPictureModeChanged(boolean z10) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPrepareOptionsMenu(Menu menu) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStart() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onStop() {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewStateRestored(@Nullable Bundle bundle) {
    }
}
