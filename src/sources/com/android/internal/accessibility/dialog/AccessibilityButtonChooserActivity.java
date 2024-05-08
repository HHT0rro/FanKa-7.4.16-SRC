package com.android.internal.accessibility.dialog;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.internal.accessibility.AccessibilityShortcutController;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.internal.widget.ResolverDrawerLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AccessibilityButtonChooserActivity extends Activity {
    private final List<AccessibilityTarget> mTargets = new ArrayList();

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        int i10;
        int i11;
        super.onCreate(savedInstanceState);
        setContentView(17367064);
        ResolverDrawerLayout rdl = findViewById(16908905);
        if (rdl != null) {
            rdl.setOnDismissedListener(new ResolverDrawerLayout.OnDismissedListener() { // from class: com.android.internal.accessibility.dialog.AccessibilityButtonChooserActivity$$ExternalSyntheticLambda0
                public final void onDismissed() {
                    AccessibilityButtonChooserActivity.this.finish();
                }
            });
        }
        String component = Settings.Secure.getString(getContentResolver(), "accessibility_button_target_component");
        AccessibilityManager accessibilityManager = (AccessibilityManager) getSystemService(AccessibilityManager.class);
        boolean isTouchExploreOn = accessibilityManager.isTouchExplorationEnabled();
        boolean isGestureNavigateEnabled = 2 == getResources().getInteger(17694906);
        if (isGestureNavigateEnabled) {
            TextView promptPrologue = (TextView) findViewById(16908699);
            if (isTouchExploreOn) {
                i11 = 17039584;
            } else {
                i11 = 17039586;
            }
            promptPrologue.setText(i11);
        }
        if (TextUtils.isEmpty(component)) {
            TextView prompt = (TextView) findViewById(16908698);
            if (isGestureNavigateEnabled) {
                if (isTouchExploreOn) {
                    i10 = 17039583;
                } else {
                    i10 = 17039585;
                }
                prompt.setText(i10);
            }
            prompt.setVisibility(0);
        }
        this.mTargets.addAll(AccessibilityTargetHelper.getTargets(this, 0));
        GridView gridview = (GridView) findViewById(16908697);
        gridview.setAdapter((ListAdapter) new ButtonTargetAdapter(this.mTargets));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.internal.accessibility.dialog.AccessibilityButtonChooserActivity$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                AccessibilityButtonChooserActivity.this.lambda$onCreate$0(adapterView, view, i12, j10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(AdapterView parent, View view, int position, long id2) {
        String name = this.mTargets.get(position).getId();
        if (name.equals(AccessibilityShortcutController.MAGNIFICATION_CONTROLLER_NAME)) {
            name = AccessibilityShortcutController.MAGNIFICATION_COMPONENT_NAME.flattenToString();
        }
        ComponentName componentName = ComponentName.unflattenFromString(name);
        AccessibilityStatsLogUtils.logAccessibilityButtonLongPressStatus(componentName);
        Settings.Secure.putString(getContentResolver(), "accessibility_button_target_component", this.mTargets.get(position).getId());
        finish();
    }
}
