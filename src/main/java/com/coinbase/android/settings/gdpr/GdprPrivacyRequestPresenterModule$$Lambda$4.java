package com.coinbase.android.settings.gdpr;

import android.app.Application;
import com.coinbase.android.settings.SettingsPreferenceItemClickedConnector;
import rx.functions.Func0;

final /* synthetic */ class GdprPrivacyRequestPresenterModule$$Lambda$4 implements Func0 {
    private final Application arg$1;
    private final SettingsPreferenceItemClickedConnector arg$2;

    private GdprPrivacyRequestPresenterModule$$Lambda$4(Application application, SettingsPreferenceItemClickedConnector settingsPreferenceItemClickedConnector) {
        this.arg$1 = application;
        this.arg$2 = settingsPreferenceItemClickedConnector;
    }

    public static Func0 lambdaFactory$(Application application, SettingsPreferenceItemClickedConnector settingsPreferenceItemClickedConnector) {
        return new GdprPrivacyRequestPresenterModule$$Lambda$4(application, settingsPreferenceItemClickedConnector);
    }

    public Object call() {
        return new RequestRestrictionProcessingViewModel(this.arg$1, this.arg$2);
    }
}
