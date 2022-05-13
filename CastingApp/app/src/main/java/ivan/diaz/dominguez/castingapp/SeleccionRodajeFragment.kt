package ivan.diaz.dominguez.castingapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import ivan.diaz.dominguez.castingapp.databinding.SeleccionRodajeFragmentBinding

class SeleccionRodajeFragment : Fragment() {

    companion object {
        fun newInstance() = SeleccionRodajeFragment()
    }
    private var _binding: SeleccionRodajeFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SeleccionRodajeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Introduzca datos de rodaje"
        _binding = SeleccionRodajeFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SeleccionRodajeViewModel::class.java)

        binding.button.setOnClickListener {
            var paquete = viewModel.getDataBundle(
                binding.editTextFecha.text.toString(),
                binding.editTextLugar.text.toString()
                )
            findNavController().navigate(R.id.action_seleccionRodajeFragment_to_seleccionCandidatos,paquete)
        }

        binding.spinnerPelicula.adapter = ArrayAdapter <String> (this.requireContext(),android.R.layout.simple_list_item_1,viewModel.peliculas)
        binding.spinnerPelicula.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.peliculaSeleccionada = viewModel.peliculas[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Al pulsar el botón, navegamos al segundo fragmento.

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}