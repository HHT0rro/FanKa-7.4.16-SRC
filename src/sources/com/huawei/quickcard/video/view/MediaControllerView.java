package com.huawei.quickcard.video.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.video.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MediaControllerView extends FrameLayout {
    private static final String B = "MediaControllerView";
    private static final int C = 1;
    private static final int D = 2;
    private static final int E = 3;
    private static final int F = 3000;
    private ExitFullChangeListener A;

    /* renamed from: a, reason: collision with root package name */
    private boolean f34396a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f34397b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34398c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34399d;

    /* renamed from: e, reason: collision with root package name */
    private Context f34400e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f34401f;

    /* renamed from: g, reason: collision with root package name */
    private SeekBar f34402g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f34403h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f34404i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f34405j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f34406k;

    /* renamed from: l, reason: collision with root package name */
    private LinearLayout f34407l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f34408m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f34409n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f34410o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f34411p;

    /* renamed from: q, reason: collision with root package name */
    private LinearLayout f34412q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f34413r;

    /* renamed from: s, reason: collision with root package name */
    private View f34414s;

    /* renamed from: t, reason: collision with root package name */
    private LinearLayout f34415t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f34416u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f34417v;

    /* renamed from: w, reason: collision with root package name */
    private FastMediaController f34418w;

    /* renamed from: x, reason: collision with root package name */
    private SeekBarChangeListener f34419x;

    /* renamed from: y, reason: collision with root package name */
    private MutedChangeListener f34420y;

    /* renamed from: z, reason: collision with root package name */
    private FullScreenChangeListener f34421z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ExitFullChangeListener {
        void onChange();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FastMediaController {
        boolean canPause();

        boolean canSeekBackward();

        boolean canSeekForward();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        boolean isPaused();

        boolean isPlaying();

        boolean isPreparing();

        void pause();

        void seekTo(int i10);

        void setUserPaused(boolean z10);

        void start();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FullScreenChangeListener {
        void onChange();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface MutedChangeListener {
        void onChange();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface SeekBarChangeListener {
        void onSeeked(int i10);

        void onSeeking(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                MediaControllerView.this.g();
                return;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                MediaControllerView.this.setShowFullScreenLock(false);
            } else {
                int q10 = MediaControllerView.this.q();
                if (!MediaControllerView.this.f34417v && MediaControllerView.this.k() && MediaControllerView.this.f34418w.isPlaying()) {
                    sendMessageDelayed(obtainMessage(2), 1000 - (q10 % 1000));
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                int duration = (MediaControllerView.this.f34418w.getDuration() / 1000) * i10;
                if (MediaControllerView.this.f34406k != null) {
                    MediaControllerView.this.f34406k.setText(com.huawei.quickcard.video.b.a(duration));
                }
                if (MediaControllerView.this.f34419x != null) {
                    MediaControllerView.this.f34419x.onSeeking(duration);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            MediaControllerView.this.b(0);
            MediaControllerView.this.f34417v = true;
            MediaControllerView.this.f34401f.removeMessages(2);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaControllerView.this.f34417v = false;
            int duration = (int) ((MediaControllerView.this.f34418w.getDuration() * seekBar.getProgress()) / 1000.0d);
            MediaControllerView.this.f34418w.seekTo(duration);
            if (!MediaControllerView.this.f34418w.isPlaying()) {
                MediaControllerView.this.f34418w.start();
            }
            MediaControllerView.this.a();
            MediaControllerView.this.q();
            if (MediaControllerView.this.f34418w.isPlaying()) {
                MediaControllerView.this.b(3000);
            } else {
                MediaControllerView.this.b(0);
            }
            MediaControllerView.this.f34401f.sendEmptyMessage(2);
            if (MediaControllerView.this.f34419x != null) {
                MediaControllerView.this.f34419x.onSeeked(duration);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MediaControllerView.this.f34420y != null) {
                MediaControllerView.this.f34420y.onChange();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MediaControllerView.this.f34421z != null) {
                MediaControllerView.this.f34421z.onChange();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MediaControllerView.this.A != null) {
                MediaControllerView.this.A.onChange();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaControllerView.this.m();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MediaControllerView.this.f34401f.removeMessages(3);
            if (MediaControllerView.this.f34412q == null || MediaControllerView.this.f34412q.getVisibility() != 0) {
                MediaControllerView.this.setShowFullScreenLock(true);
                MediaControllerView.this.f34401f.sendMessageDelayed(MediaControllerView.this.f34401f.obtainMessage(3), com.huawei.openalliance.ad.ipc.c.Code);
            } else {
                MediaControllerView.this.setShowFullScreenLock(false);
            }
        }
    }

    public MediaControllerView(@NonNull Context context) {
        super(context);
        this.f34396a = true;
        this.f34397b = false;
        this.f34398c = false;
        this.f34399d = true;
        this.f34400e = context;
        i();
        h();
    }

    private boolean a(int i10) {
        return i10 == 79 || i10 == 85 || i10 == 62;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.f34397b) {
            l();
        } else {
            s();
        }
    }

    private void o() {
        if (this.f34402g == null || this.f34418w.canSeekBackward() || this.f34418w.canSeekForward()) {
            return;
        }
        this.f34402g.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q() {
        FastMediaController fastMediaController = this.f34418w;
        if (fastMediaController == null || this.f34417v) {
            return 0;
        }
        int currentPosition = fastMediaController.getCurrentPosition();
        int duration = this.f34418w.getDuration();
        SeekBar seekBar = this.f34402g;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 1000) / duration));
            }
            this.f34402g.setSecondaryProgress(this.f34418w.getBufferPercentage() * 10);
        }
        TextView textView = this.f34405j;
        if (textView != null) {
            textView.setText(com.huawei.quickcard.video.b.a(duration));
        }
        TextView textView2 = this.f34406k;
        if (textView2 == null) {
            return currentPosition;
        }
        textView2.setText(com.huawei.quickcard.video.b.a(currentPosition));
        return currentPosition;
    }

    private void r() {
        if (this.f34418w.isPlaying()) {
            this.f34418w.setUserPaused(true);
            this.f34418w.pause();
        } else {
            this.f34418w.setUserPaused(false);
            this.f34418w.start();
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowFullScreenLock(boolean z10) {
        LinearLayout linearLayout = this.f34412q;
        if (linearLayout != null) {
            linearLayout.setVisibility(z10 ? 0 : 8);
        }
    }

    private void setStartLayoutShow(boolean z10) {
        LinearLayout linearLayout = this.f34403h;
        if (linearLayout != null) {
            linearLayout.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z10 = false;
        boolean z11 = !((keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0) ? false : true);
        if (a(keyCode)) {
            if (!z11) {
                return true;
            }
            r();
            b(3000);
        } else if (keyCode != 126) {
            if (keyCode != 86 && keyCode != 127) {
                if (keyCode != 25 && keyCode != 24 && keyCode != 164 && keyCode != 27) {
                    z10 = true;
                }
                if (!z10) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyCode != 4 && keyCode != 82) {
                    b(3000);
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (z11) {
                    g();
                }
                return true;
            }
            if (z11 && this.f34418w.isPlaying()) {
                this.f34418w.pause();
                a();
                b(3000);
            }
        } else if (z11 && !this.f34418w.isPlaying()) {
            this.f34418w.start();
            a();
            b(3000);
        } else {
            CardLogUtils.i("other state");
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MediaController.class.getName();
    }

    public void n() {
        ImageView imageView = this.f34410o;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.quick_card_video_player_enter_fullscreen);
        }
        c();
        s();
        if (this.f34399d) {
            a(false);
        }
        this.f34398c = false;
        setShowFullScreenLock(false);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        b(3000);
        return false;
    }

    public void p() {
        b(3000);
    }

    public void s() {
        try {
            this.f34401f.removeMessages(3);
        } catch (IllegalArgumentException unused) {
            CardLogUtils.i(B, "remove message fail");
        }
        setOnClickListener(null);
        setClickable(false);
        View view = this.f34414s;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = this.f34412q;
        if (linearLayout != null && this.f34397b && this.f34398c) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f34415t;
        if (linearLayout2 != null && this.f34399d && this.f34398c) {
            linearLayout2.setVisibility(0);
        }
        setStartLayoutShow(true);
        ImageView imageView = this.f34413r;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.quick_card_video_full_player_unlock);
        }
        this.f34397b = false;
        FastMediaController fastMediaController = this.f34418w;
        if (fastMediaController != null) {
            if (fastMediaController.isPlaying()) {
                b(3000);
            } else {
                b(0);
            }
        }
    }

    public void setCanShow(boolean z10) {
        this.f34396a = z10;
    }

    public void setControllerDirection(String str) {
        if (Attributes.LayoutDirection.RTL.equals(str)) {
            b(this.f34414s, 1);
            a(this.f34404i, 180);
            a(this.f34407l, 180);
            a(this.f34411p, 180);
            b(this.f34416u, 1);
            return;
        }
        if (Attributes.LayoutDirection.LTR.equals(str)) {
            b(this.f34414s, 0);
            a(this.f34404i, 0);
            a(this.f34407l, 0);
            a(this.f34411p, 0);
            b(this.f34416u, 0);
            return;
        }
        b(this.f34414s, 3);
        a(this.f34404i, 0);
        a(this.f34407l, 0);
        a(this.f34411p, 0);
        b(this.f34416u, 3);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        ImageView imageView = this.f34404i;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
        SeekBar seekBar = this.f34402g;
        if (seekBar != null) {
            seekBar.setEnabled(z10);
        }
        o();
        super.setEnabled(z10);
    }

    public void setExitFullChangeListener(ExitFullChangeListener exitFullChangeListener) {
        this.A = exitFullChangeListener;
    }

    public void setFullScreenChangeListener(FullScreenChangeListener fullScreenChangeListener) {
        this.f34421z = fullScreenChangeListener;
    }

    public void setFullScreenEnable(boolean z10) {
        LinearLayout linearLayout = this.f34409n;
        if (linearLayout != null) {
            linearLayout.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setMediaPlayer(FastMediaController fastMediaController) {
        this.f34418w = fastMediaController;
        a();
    }

    public void setMutedChangeListener(MutedChangeListener mutedChangeListener) {
        this.f34420y = mutedChangeListener;
    }

    public void setSeekBarChangeListener(SeekBarChangeListener seekBarChangeListener) {
        this.f34419x = seekBarChangeListener;
    }

    public void setTitleBarVisibility(boolean z10) {
        this.f34399d = z10;
    }

    public void setTitleBatText(String str) {
        TextView textView = this.f34416u;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void c() {
        int dip2IntPx = ViewUtils.dip2IntPx(this, 40.0f);
        int dip2IntPx2 = ViewUtils.dip2IntPx(this, 32.0f);
        int dip2IntPx3 = ViewUtils.dip2IntPx(this, 18.0f);
        int dip2IntPx4 = ViewUtils.dip2IntPx(this, 7.0f);
        int dip2IntPx5 = ViewUtils.dip2IntPx(this, 5.0f);
        int dip2IntPx6 = ViewUtils.dip2IntPx(this, 2.0f);
        int dip2IntPx7 = ViewUtils.dip2IntPx(this, 1.0f);
        ImageView imageView = this.f34404i;
        if (imageView != null) {
            imageView.setLayoutParams(new LinearLayout.LayoutParams(dip2IntPx, dip2IntPx));
        }
        if (this.f34407l != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2IntPx2, dip2IntPx2);
            layoutParams.setMarginStart(dip2IntPx5);
            layoutParams.setMarginEnd(dip2IntPx7);
            this.f34407l.setLayoutParams(layoutParams);
        }
        if (this.f34408m != null) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dip2IntPx3, dip2IntPx3);
            layoutParams2.gravity = 17;
            layoutParams2.setMargins(dip2IntPx4, dip2IntPx4, dip2IntPx4, dip2IntPx4);
            this.f34408m.setLayoutParams(layoutParams2);
        }
        if (this.f34409n != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dip2IntPx2, dip2IntPx2);
            layoutParams3.setMarginStart(dip2IntPx6);
            layoutParams3.setMarginEnd(dip2IntPx7);
            this.f34409n.setLayoutParams(layoutParams3);
        }
        if (this.f34410o != null) {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(dip2IntPx3, dip2IntPx3);
            layoutParams4.gravity = 17;
            layoutParams4.setMargins(dip2IntPx4, dip2IntPx4, dip2IntPx4, dip2IntPx4);
            this.f34410o.setLayoutParams(layoutParams4);
        }
    }

    private void h() {
        View inflate = View.inflate(this.f34400e, R.layout.quick_card_video_media_controller, this);
        j();
        a(inflate);
    }

    private void i() {
        this.f34401f = new a();
    }

    private void j() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f34403h = linearLayout;
        linearLayout.setGravity(17);
        this.f34403h.setBackgroundColor(436207616);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f34404i = new ImageView(context);
        this.f34404i.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dip2IntPx(this, 40.0f), ViewUtils.dip2IntPx(this, 40.0f)));
        this.f34404i.setImageResource(R.drawable.quick_card_video_player_start_play);
        this.f34404i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f34403h.addView(this.f34404i);
        addView(this.f34403h, layoutParams);
        this.f34404i.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.quickcard.video.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaControllerView.this.b(view);
            }
        });
    }

    private void l() {
        try {
            this.f34401f.removeMessages(1);
            this.f34401f.removeMessages(3);
        } catch (IllegalArgumentException unused) {
            CardLogUtils.i(B, "remove message fail");
        }
        View view = this.f34414s;
        if (view != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.f34415t;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView = this.f34413r;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.quick_card_video_full_player_lock);
        }
        setStartLayoutShow(false);
        Handler handler = this.f34401f;
        handler.sendMessageDelayed(handler.obtainMessage(3), com.huawei.openalliance.ad.ipc.c.Code);
        setOnClickListener(new g());
        this.f34397b = true;
    }

    public void d() {
        ImageView imageView = this.f34410o;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.quick_card_video_player_exit_fullscreen);
        }
        b();
        if (this.f34399d) {
            a(true);
        }
        this.f34398c = true;
        setShowFullScreenLock(true);
    }

    public void e() {
        ImageView imageView = this.f34408m;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.quick_card_video_player_volume_off);
        }
    }

    public void f() {
        ImageView imageView = this.f34408m;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.quick_card_video_player_volume_on);
        }
    }

    public void g() {
        if (k()) {
            try {
                this.f34401f.removeMessages(2);
            } catch (IllegalArgumentException unused) {
                CardLogUtils.i(B, "remove message fail");
            }
            setVisibility(8);
        }
    }

    public boolean k() {
        return getVisibility() == 0;
    }

    private void a(View view) {
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.video_controls_seek_bar);
        this.f34402g = seekBar;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new b());
            this.f34402g.setMax(1000);
        }
        this.f34405j = (TextView) view.findViewById(R.id.video_controls_total_time);
        this.f34406k = (TextView) view.findViewById(R.id.video_controls_current_time);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_controls_volume_layout);
        this.f34407l = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new c());
        }
        this.f34408m = (ImageView) view.findViewById(R.id.video_controls_volume);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.video_controls_full_screen_layout);
        this.f34409n = linearLayout2;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new d());
        }
        this.f34410o = (ImageView) view.findViewById(R.id.video_controls_full_screen);
        ImageView imageView = (ImageView) view.findViewById(R.id.video_controls_back);
        this.f34411p = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new e());
        }
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.video_controls_full_player_lock_layout);
        this.f34412q = linearLayout3;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new f());
        }
        this.f34413r = (ImageView) view.findViewById(R.id.video_controls_full_player_lock);
        View findViewById = view.findViewById(R.id.video_controls_bottom);
        this.f34414s = findViewById;
        if (findViewById != null) {
            findViewById.setClickable(true);
        }
        this.f34415t = (LinearLayout) view.findViewById(R.id.video_controls_title_bar);
        this.f34416u = (TextView) view.findViewById(R.id.video_controls_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        r();
        if (this.f34418w.isPlaying()) {
            b(3000);
        } else {
            b(0);
        }
    }

    private void b(View view, int i10) {
        if (view != null) {
            view.setLayoutDirection(i10);
        }
    }

    public void b(int i10) {
        if (this.f34396a) {
            if (!k()) {
                setVisibility(0);
                q();
                o();
            }
            a();
            this.f34401f.sendEmptyMessage(2);
            this.f34401f.removeMessages(1);
            if (i10 != 0) {
                Handler handler = this.f34401f;
                handler.sendMessageDelayed(handler.obtainMessage(1), i10);
            }
        }
    }

    public MediaControllerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34396a = true;
        this.f34397b = false;
        this.f34398c = false;
        this.f34399d = true;
    }

    public MediaControllerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f34396a = true;
        this.f34397b = false;
        this.f34398c = false;
        this.f34399d = true;
    }

    private void b() {
        int dip2IntPx = ViewUtils.dip2IntPx(this, 64.0f);
        int dip2IntPx2 = ViewUtils.dip2IntPx(this, 40.0f);
        int dip2IntPx3 = ViewUtils.dip2IntPx(this, 24.0f);
        int dip2IntPx4 = ViewUtils.dip2IntPx(this, 16.0f);
        int dip2IntPx5 = ViewUtils.dip2IntPx(this, 8.0f);
        ImageView imageView = this.f34404i;
        if (imageView != null) {
            imageView.setLayoutParams(new LinearLayout.LayoutParams(dip2IntPx, dip2IntPx));
        }
        if (this.f34407l != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2IntPx2, dip2IntPx2);
            layoutParams.setMarginStart(dip2IntPx4);
            layoutParams.setMarginEnd(0);
            this.f34407l.setLayoutParams(layoutParams);
        }
        if (this.f34408m != null) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dip2IntPx3, dip2IntPx3);
            layoutParams2.gravity = 17;
            layoutParams2.setMargins(dip2IntPx5, dip2IntPx5, dip2IntPx5, dip2IntPx5);
            this.f34408m.setLayoutParams(layoutParams2);
        }
        if (this.f34409n != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dip2IntPx2, dip2IntPx2);
            layoutParams3.setMarginStart(0);
            layoutParams3.setMarginEnd(dip2IntPx4);
            this.f34409n.setLayoutParams(layoutParams3);
        }
        if (this.f34410o != null) {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(dip2IntPx3, dip2IntPx3);
            layoutParams4.gravity = 17;
            layoutParams4.setMargins(dip2IntPx5, dip2IntPx5, dip2IntPx5, dip2IntPx5);
            this.f34410o.setLayoutParams(layoutParams4);
        }
    }

    public MediaControllerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f34396a = true;
        this.f34397b = false;
        this.f34398c = false;
        this.f34399d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        FastMediaController fastMediaController = this.f34418w;
        if (fastMediaController == null || this.f34404i == null) {
            return;
        }
        if (fastMediaController.isPlaying()) {
            this.f34404i.setImageResource(R.drawable.quick_card_video_player_stop_play);
            this.f34403h.setBackgroundColor(0);
        } else {
            this.f34404i.setImageResource(R.drawable.quick_card_video_player_start_play);
            this.f34403h.setBackgroundColor(436207616);
        }
    }

    private void a(View view, int i10) {
        if (view != null) {
            view.setRotation(i10);
        }
    }

    private void a(boolean z10) {
        LinearLayout linearLayout = this.f34415t;
        if (linearLayout == null) {
            return;
        }
        if (z10 && this.f34399d && this.f34396a) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }
}
