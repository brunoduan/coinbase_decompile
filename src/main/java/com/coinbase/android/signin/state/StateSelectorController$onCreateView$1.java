package com.coinbase.android.signin.state;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: StateSelectorController.kt */
final class StateSelectorController$onCreateView$1 implements OnClickListener {
    final /* synthetic */ StateSelectorController this$0;

    StateSelectorController$onCreateView$1(StateSelectorController stateSelectorController) {
        this.this$0 = stateSelectorController;
    }

    public final void onClick(View $noName_0) {
        this.this$0.getMPresenter().onStateSelectorClicked$coinbase_android_productionRelease();
    }
}
