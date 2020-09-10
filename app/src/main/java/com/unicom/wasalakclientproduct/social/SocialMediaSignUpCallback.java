package com.unicom.wasalakclientproduct.social;

import com.ahmedadel.socialmediasignup.SocialMediaSignUp;
import com.ahmedadel.socialmediasignup.model.SocialMediaUser;

public interface SocialMediaSignUpCallback {
    void onSuccess(SocialMediaSignUp.SocialMediaType socialMediaType, SocialMediaUser socialMediaUser);
    void onError(Throwable error);
    void onSignOut(SocialMediaSignUp.SocialMediaType socialMediaType);
}
