package com.unicom.wasalakclientproduct.ui.guest.register;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.MainApplication;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentRegisterBinding;
import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.RegisterFragmentComponent;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.model.CityClass;
import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryClass;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterUser;
import com.unicom.wasalakclientproduct.viewmodel.ViewModelFactory;
import com.unicom.wasalakclientproduct.viewmodel.guest.RegisterViewModel;

import java.util.List;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private NavController navController;
    private FragmentRegisterBinding binding;
    private RegisterViewModel registerViewModel;
    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    @ActivityContext
    Context context;

    private static final String TAG = "RegisterFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }

        //dagger
        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
        RegisterFragmentComponent fragmentComponent = applicationComponent.registerFragmentComponentBuilder().getContext(getActivity()).build();
        fragmentComponent.inject(this);

        binding.ccp.registerPhoneNumberTextView(binding.edtPhone);

        //data binding to view
        registerViewModel = new ViewModelProvider(this, viewModelFactory).get(RegisterViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setRegisterViewModel(registerViewModel);
        binding.setFragment(this);


        //get countries
        registerViewModel.getCountriesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<CountryClass>>() {
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
                        registerViewModel.countryId.setValue(((CountryClass) parent.getItemAtPosition(position)).getId());
                        registerViewModel.retrieveCities();
                    }
                });
            }
        });

        registerViewModel.getCitiesMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<CityClass>>() {
            @Override
            public void onChanged(List<CityClass> cityClassList) {
                ArrayAdapter<CityClass> adapter = new ArrayAdapter<CityClass>
                        (context, android.R.layout.simple_list_item_1, cityClassList);
                binding.edtCity.setThreshold(1);
                binding.edtCity.setAdapter(adapter);
                binding.edtCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        registerViewModel.cityId.setValue(((CityClass) parent.getItemAtPosition(position)).getId());
                    }
                });
            }
        });

//         get user data and validate then call network
        registerViewModel.getUserMutableLiveData().observe(getViewLifecycleOwner(), new Observer<RegisterUser>() {
            @Override
            public void onChanged(RegisterUser registerUser) {
                binding.txtLayoutFirstName.setError(null);
                binding.txtLayoutLastName.setError(null);
                binding.txtLayoutUserName.setError(null);
                binding.txtLayoutEmail.setError(null);
                binding.txtLayoutPhone.setError(null);
                binding.txtLayoutCountry.setError(null);
                binding.txtLayoutCity.setError(null);
                binding.txtLayoutPassword.setError(null);
                binding.txtLayoutPasswordConfirm.setError(null);
                if (registerUser.getFirstname() == null || registerUser.getFirstname().isEmpty()) {
                    binding.txtLayoutFirstName.setError(getString(R.string.first_name_required));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getLastname() == null || registerUser.getLastname().isEmpty()) {
                    binding.txtLayoutLastName.setError(getString(R.string.last_name_required));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getEmailaddress() == null || registerUser.getEmailaddress().isEmpty()) {
                    binding.txtLayoutEmail.setError(getString(R.string.email_mandatory));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getPhonenumber() == null || registerUser.getPhonenumber().isEmpty()) {
                    binding.txtLayoutPhone.setError(getString(R.string.phone_required));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getCountryid() == null || registerUser.getCountryid() == 0) {
                    binding.txtLayoutCountry.setError(getString(R.string.required));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getCityid() == null || registerUser.getCityid() == 0) {
                    binding.txtLayoutCity.setError(getString(R.string.required));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getPassword() == null || registerUser.getPassword().isEmpty()) {
                    binding.txtLayoutPassword.setError(getString(R.string.password_mandatory));
                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.getPassword() == null || registerUser.getPassword().isEmpty()) {
                    binding.txtLayoutPassword.setError(getString(R.string.password_mandatory));
                    registerViewModel.enableButton.setValue(true);
                } else if (!registerUser.isEmailValid()) {
                    binding.txtLayoutEmail.setError(getString(R.string.email_error));
                    registerViewModel.enableButton.setValue(true);
//                } else if (!registerUser.isMobileValid()) {
//                    binding.txtLayoutPhone.setError(getString(R.string.phone_error));
//                    registerViewModel.enableButton.setValue(true);
                } else if (registerUser.isPasswordValid()) {
                    binding.txtLayoutPassword.setError(getString(R.string.password_error));
                    registerViewModel.enableButton.setValue(true);
                } else if (!registerUser.isPasswordMatch()) {
                    binding.txtLayoutPassword.setError(getString(R.string.password_not_match));
                    binding.txtLayoutPasswordConfirm.setError(getString(R.string.password_not_match));
                    registerViewModel.enableButton.setValue(true);
                }else if (!registerUser.isPasswordValid2()) {
                    binding.txtLayoutPassword.setError(getString(R.string.password_not_valid));
                    registerViewModel.enableButton.setValue(true);
                } else {
                    registerUser.setPhonenumber(binding.ccp.getNumber());
                    registerViewModel.registerNetwork();
                }
            }
        });
//
//        //get register network data
        registerViewModel.getRegisterMutableLiveData().observe(getViewLifecycleOwner(), new Observer<RegisterModel>() {
            @Override
            public void onChanged(RegisterModel registerModel) {
                navController.navigateUp();
                Toasty.success(context, R.string.register_success, Toasty.LENGTH_SHORT).show();
            }
        });

    }
}
