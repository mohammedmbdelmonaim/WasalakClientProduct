package com.unicom.wasalakclientproduct.ui.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.unicom.wasalakclientproduct.MainApplication;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentEditProfileBinding;
import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.EditProfileFragmentComponent;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.model.CityClass;
import com.unicom.wasalakclientproduct.model.CountryClass;
import com.unicom.wasalakclientproduct.model.user.AccountModel;
import com.unicom.wasalakclientproduct.model.user.GenderDTO;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileDTO;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileModel;
import com.unicom.wasalakclientproduct.model.user.UploadImageModel;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;
import com.unicom.wasalakclientproduct.viewmodel.ViewModelFactory;
import com.unicom.wasalakclientproduct.viewmodel.user.EditProfileViewModel;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class EditProfileFragment extends Fragment {

    FragmentEditProfileBinding binding;
    private NavController navController;
    @ActivityContext
    @Inject
    Context context;
    @Inject
    ViewModelFactory viewModelFactory;
    private EditProfileViewModel editProfileViewModel;

    @Inject
    PreferenceUtils preference;
    private CircularProgressDrawable circularProgressDrawable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // dagger
        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
        EditProfileFragmentComponent editProfileFragmentComponent = applicationComponent.editProfileFragmentComponentBuilder().getContext(getActivity()).build();
        editProfileFragmentComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }
        binding.ccp.registerPhoneNumberTextView(binding.edtPhone);


        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.navigateUp();
            }
        });

        //data binding to view
        editProfileViewModel = new ViewModelProvider(this, viewModelFactory).get(EditProfileViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(editProfileViewModel);
        binding.setFragment(this);

        getProfileData();

        editProfileViewModel.getGenderLiveData().observe(getViewLifecycleOwner(), new Observer<List<GenderDTO>>() {
            @Override
            public void onChanged(List<GenderDTO> genders) {
                ArrayAdapter<GenderDTO> adapter = new ArrayAdapter<GenderDTO>
                        (context, android.R.layout.simple_list_item_1, genders);
                binding.edtGender.setThreshold(1);
                binding.edtGender.setAdapter(adapter);
                binding.edtGender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editProfileViewModel.gender.setValue(((GenderDTO) parent.getItemAtPosition(position)).getName());
                    }
                });
            }
        });

        //get countries
        editProfileViewModel.getCountriesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<CountryClass>>() {
            @Override
            public void onChanged(List<CountryClass> countryClassList) {
                ArrayAdapter<CountryClass> adapter = new ArrayAdapter<CountryClass>
                        (context, android.R.layout.simple_list_item_1, countryClassList);
                binding.edtCountry.setThreshold(1);
                binding.edtCountry.setAdapter(adapter);
                binding.edtCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        binding.edtCity.setText("");
                        binding.ccp.setCountryForNameCode("EG");
                        editProfileViewModel.countryId.setValue(((CountryClass) parent.getItemAtPosition(position)).getId());
                        editProfileViewModel.retrieveCities();
                    }
                });
            }
        });

        editProfileViewModel.getCitiesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<CityClass>>() {
            @Override
            public void onChanged(List<CityClass> cityClassList) {
                ArrayAdapter<CityClass> adapter = new ArrayAdapter<CityClass>
                        (context, android.R.layout.simple_list_item_1, cityClassList);
                binding.edtCity.setThreshold(1);
                binding.edtCity.setAdapter(adapter);
                binding.edtCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editProfileViewModel.cityId.setValue(((CityClass) parent.getItemAtPosition(position)).getId());
                    }
                });
            }
        });

        editProfileViewModel.getUploadImageModelMutableLiveData().observe(getViewLifecycleOwner(), new Observer<UploadImageModel>() {
            @Override
            public void onChanged(UploadImageModel uploadImageModel) {
                List<UpdateProfileDTO.FilesKey> list = new ArrayList<>();
                list.add(new UpdateProfileDTO.FilesKey(uploadImageModel.getResult().get(0), "", 7));
                editProfileViewModel.getFileKeysMutableLiveData().setValue(list);
            }
        });

        editProfileViewModel.getUriImageMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Uri>() {
            @Override
            public void onChanged(Uri uri) {
                Glide.with(EditProfileFragment.this)
                        .load(uri)
                        .placeholder(R.drawable.ic_wasellak_logo_color)
                        .into(binding.profileImage);
            }
        });

        //         get user data and validate then call network
        editProfileViewModel.getUserMutableLiveData().observe(getViewLifecycleOwner(), new Observer<UpdateProfileDTO>() {
            @Override
            public void onChanged(UpdateProfileDTO user) {
                binding.txtLayoutFirstName.setError(null);
                binding.txtLayoutLastName.setError(null);
                binding.txtLayoutEmail.setError(null);
                binding.txtLayoutPhone.setError(null);
                binding.txtLayoutCountry.setError(null);
                binding.txtLayoutCity.setError(null);
                binding.txtLayoutGender.setError(null);
                binding.dateButton.setError(null);
                if (user.getFirstname() == null || user.getFirstname().isEmpty()) {
                    binding.txtLayoutFirstName.setError(getString(R.string.first_name_required));
                    editProfileViewModel.enableButton.setValue(true);
                } else if (user.getLastname() == null || user.getLastname().isEmpty()) {
                    binding.txtLayoutLastName.setError(getString(R.string.last_name_required));
                    editProfileViewModel.enableButton.setValue(true);
                } else if (user.getEmailaddress() == null || user.getEmailaddress().isEmpty()) {
                    binding.txtLayoutEmail.setError(getString(R.string.email_mandatory));
                    editProfileViewModel.enableButton.setValue(true);
                } else if (user.getPhonenumber() == null || user.getPhonenumber().isEmpty()) {
                    binding.txtLayoutPhone.setError(getString(R.string.phone_required));
                    editProfileViewModel.enableButton.setValue(true);
                } else if (user.getBirthDate() == null || user.getBirthDate().isEmpty()) {
                    binding.dateButton.setError(getString(R.string.required));
                    editProfileViewModel.enableButton.setValue(true);
                } else if (user.getCountryid() == null || user.getCountryid() == 0) {
                    binding.txtLayoutCountry.setError(getString(R.string.required));
                    editProfileViewModel.enableButton.setValue(true);
                } else if (user.getCityid() == null || user.getCityid() == 0) {
                    binding.txtLayoutCity.setError(getString(R.string.required));
                    editProfileViewModel.enableButton.setValue(true);
                } else {
                    user.setPhonenumber(binding.ccp.getNumber());
                    editProfileViewModel.updateNetwork();
                }
            }
        });
        editProfileViewModel.getUpdateProfileLiveData().observe(getViewLifecycleOwner(), new Observer<UpdateProfileModel>() {
            @Override
            public void onChanged(UpdateProfileModel updateProfileModel) {
                Toasty.success(context , getString(R.string.sucess_edit) , Toasty.LENGTH_LONG).show();
                profile.setLastName(updateProfileModel.getResult().getLastName());
                profile.setFirstName(updateProfileModel.getResult().getFirstName());
                profile.setUserImage(updateProfileModel.getResult().getUserImage());
                profile.setPhoneNumber(updateProfileModel.getResult().getPhoneNumber());
                profile.setBirthDate(updateProfileModel.getResult().getBirthDate());
                profile.setGender(updateProfileModel.getResult().getGender());
                profile.setCountry(updateProfileModel.getResult().getCountry());
                profile.setCity(updateProfileModel.getResult().getCity());
                navController.navigateUp();
            }
        });
    }

    private Integer resolveOrThrow(Context context, @AttrRes Integer attributeResId) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue.data;
        }
        throw new IllegalArgumentException(context.getResources().getResourceName(attributeResId));
    }

    public void clickImage() {
        ImagePicker.Companion.with(this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }

    public void clickDate(View v) {
        Integer fullscreenTheme = resolveOrThrow(context, R.attr.materialCalendarFullscreenTheme);
        MaterialDatePicker.Builder datePickerBuilder = MaterialDatePicker.Builder.datePicker();
        datePickerBuilder.setTheme(fullscreenTheme);
        datePickerBuilder.setTheme(R.style.MaterialCalendarTheme);

        MaterialDatePicker datePicker = datePickerBuilder.build();

        datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                Timestamp stamp = new Timestamp(Long.parseLong(String.valueOf(selection)));
                Date date = new Date(stamp.getTime());
                String d = date.toString();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
//                ((Button) v).setText(simpleDateFormat.format(date));
                editProfileViewModel.birthDate.setValue(date.toString());
            }
        });

        datePicker.show(getChildFragmentManager(), datePicker.toString());
    }
    AccountModel.Result profile;
    private void getProfileData() {
        //get store object
        if (getArguments() != null) {
            EditProfileFragmentArgs args = EditProfileFragmentArgs.fromBundle(getArguments());
            profile = args.getProfile();
            binding.editProfileToolbar.setTitle(profile.getFirstName() + " " + profile.getLastName());
            editProfileViewModel.id.setValue(profile.getId());
            editProfileViewModel.firstName.setValue(profile.getFirstName());
            editProfileViewModel.lastName.setValue(profile.getLastName());
            editProfileViewModel.emailAddress.setValue(profile.getEmailAddress());
            editProfileViewModel.mobile.setValue(profile.getPhoneNumber());

            editProfileViewModel.gender.setValue(profile.getGender());
            binding.edtGender.setText(profile.getGender());

            editProfileViewModel.birthDate.setValue(profile.getBirthDate());
            binding.dateButton.setText(profile.getBirthDate());


            editProfileViewModel.countryId.setValue(profile.getCountry().getId());
            binding.edtCountry.setText(preference.getLang().equals("en") ? profile.getCountry().getName() : profile.getCountry().getNameAr());

            editProfileViewModel.cityId.setValue(profile.getCity().getId());
            binding.edtCity.setText(preference.getLang().equals("en") ? profile.getCity().getName() : profile.getCity().getNameAr());

            Glide.with(EditProfileFragment.this)
                    .load("http://192.168.50.236:4101/api"+profile.getUserImage())
                    .placeholder(R.drawable.ic_wasellak_logo_color)
                    .into(binding.profileImage);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            editProfileViewModel.isLoading.setValue(true);
            //Image Uri will not be null for RESULT_OK
            Uri fileUri = data.getData();
            editProfileViewModel.getUriImageMutableLiveData().setValue(fileUri);
            //You can get File object from intent
            File file = ImagePicker.Companion.getFile(data);
            // create RequestBody instance from file
            RequestBody requestFile =
                    RequestBody.create(
                            file, MediaType.parse("getActivity().getContentResolver().getType(fileUri)")
                    );
            // MultipartBody.Part is used to send also the actual file name
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("file", file.getName(), requestFile);
            editProfileViewModel.uploadFile(body);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.Companion.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

}