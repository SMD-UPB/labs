package com.smd.retrofitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.smd.retrofitdemo.databinding.ActivityMainBinding
import com.smd.retrofitdemo.network.PeopleInSpace
import timber.log.Timber
import java.util.ArrayList

/**
 * Shows a list of the astronauts who are on ISS or in transit to it
 */
class MainActivity : AppCompatActivity() {
    private lateinit var peopleInSpaceViewModel: PeopleInSpaceViewModel
    private lateinit var peopleInSpaceAdapter: PeopleInSpaceAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // view binding (the ActivityMainBinding is generated based on the layout file's name)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViewModel()
        initUI()
    }

    private fun initViewModel() {
        peopleInSpaceViewModel = ViewModelProviders.of(this).get(
            PeopleInSpaceViewModel::class.java
        )
        peopleInSpaceViewModel.init()
        peopleInSpaceViewModel.peopleInSpaceLiveData?.observe(
            this,
            { peopleInSpace: PeopleInSpace? ->
                if (peopleInSpace != null) {
                    Timber.d("People in space ${peopleInSpace.number}")

                    // Update the recycler view adapter
                    peopleInSpaceAdapter.replaceAll(peopleInSpace.people)
                    binding.astronautsCountTextview.text =
                        getString(R.string.astronauts_count, peopleInSpace.number)
                }
            })
    }

    private fun initUI() {
        peopleInSpaceAdapter = PeopleInSpaceAdapter(ArrayList())

        binding.showButton.setOnClickListener { peopleInSpaceViewModel.peopleInSpace }
        binding.astronautsList.adapter = peopleInSpaceAdapter
    }
}