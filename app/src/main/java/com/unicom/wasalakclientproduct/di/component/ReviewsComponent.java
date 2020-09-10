//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import com.unicom.waslak_client.di.module.ReviewsModule;
//import com.unicom.waslak_client.di.module.ReviewsViewModelModule;
//import com.unicom.waslak_client.di.module.UserServiceModule;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.di.scope.FragmentScope;
//import com.unicom.waslak_client.ui.user.AddReviewFragment;
//import com.unicom.waslak_client.ui.user.ReviewsFragment;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {ReviewsViewModelModule.class , UserServiceModule.class, ReviewsModule.class})
//public interface ReviewsComponent {
//
//    void inject(ReviewsFragment reviewsFragment);
//    void inject(AddReviewFragment addReviewFragment);
//
//    @Subcomponent.Builder
//    interface Builder{
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//
//        ReviewsComponent build();
//    }
//}
