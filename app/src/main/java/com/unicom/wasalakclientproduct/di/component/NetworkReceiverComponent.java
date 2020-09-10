package com.unicom.wasalakclientproduct.di.component;


import com.unicom.wasalakclientproduct.di.scope.ReceiverScope;
import com.unicom.wasalakclientproduct.reciever.NetworkReceiver;

import dagger.Subcomponent;

@ReceiverScope
@Subcomponent
public interface NetworkReceiverComponent {

    void inject(NetworkReceiver networkReceiver);
}
