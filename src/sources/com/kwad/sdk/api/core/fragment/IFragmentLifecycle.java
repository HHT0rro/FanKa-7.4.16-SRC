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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
interface IFragmentLifecycle {
    @Deprecated
    void onActivityCreated(@Nullable Bundle bundle);

    void onActivityResult(int i10, int i11, Intent intent);

    void onAttach(Activity activity);

    void onAttach(Context context);

    void onAttachFragment(KsFragment ksFragment);

    void onConfigurationChanged(Configuration configuration);

    boolean onContextItemSelected(MenuItem menuItem);

    void onCreate(@Nullable Bundle bundle);

    Animation onCreateAnimation(int i10, boolean z10, int i11);

    Animator onCreateAnimator(int i10, boolean z10, int i11);

    void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    @Nullable
    View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    void onDestroy();

    void onDestroyOptionsMenu();

    void onDestroyView();

    void onDetach();

    void onHiddenChanged(boolean z10);

    void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle);

    void onInflate(Context context, AttributeSet attributeSet, Bundle bundle);

    void onLowMemory();

    void onMultiWindowModeChanged(boolean z10);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onOptionsMenuClosed(Menu menu);

    void onPause();

    void onPictureInPictureModeChanged(boolean z10);

    void onPrepareOptionsMenu(Menu menu);

    void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr);

    void onResume();

    void onSaveInstanceState(@NonNull Bundle bundle);

    void onStart();

    void onStop();

    void onViewCreated(@NonNull View view, @Nullable Bundle bundle);

    void onViewStateRestored(@Nullable Bundle bundle);
}
