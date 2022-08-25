package alex.eros.macropay.ui

import alex.eros.macropay.core.Resource
import alex.eros.macropay.data.UserDto
import alex.eros.macropay.data.remote.MacroDataSource
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import alex.eros.macropay.databinding.FragmentLoginBinding
import alex.eros.macropay.presentation.MacroViewModel
import alex.eros.macropay.presentation.MacroViewModelFactory
import alex.eros.macropay.repository.MacroRepositoryImpl
import alex.eros.macropay.repository.RetrofitClient
import android.util.Log
import androidx.fragment.app.viewModels

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<MacroViewModel> {
        MacroViewModelFactory(MacroRepositoryImpl(MacroDataSource(RetrofitClient.webservice)))
    }
    private val user:UserDto = UserDto("admin@macropay.mx","Admin1")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getResponse(user).observe(viewLifecycleOwner,{result->

            when(result){
                is Resource.Loading ->{
                    Log.d("LiveData","Loading...")
                }
                is Resource.Success -> {
                    Log.d("LiveData","${result.data}")
                }
                is Resource.Failure ->{
                    Log.d("Livedata","${result.exception}")
                }
            }

        })

    }

}