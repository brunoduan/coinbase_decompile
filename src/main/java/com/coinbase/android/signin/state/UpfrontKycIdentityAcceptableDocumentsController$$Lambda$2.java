package com.coinbase.android.signin.state;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import permissions.dispatcher.PermissionRequest;

final /* synthetic */ class UpfrontKycIdentityAcceptableDocumentsController$$Lambda$2 implements OnClickListener {
    private final PermissionRequest arg$1;

    private UpfrontKycIdentityAcceptableDocumentsController$$Lambda$2(PermissionRequest permissionRequest) {
        this.arg$1 = permissionRequest;
    }

    public static OnClickListener lambdaFactory$(PermissionRequest permissionRequest) {
        return new UpfrontKycIdentityAcceptableDocumentsController$$Lambda$2(permissionRequest);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.arg$1.cancel();
    }
}
