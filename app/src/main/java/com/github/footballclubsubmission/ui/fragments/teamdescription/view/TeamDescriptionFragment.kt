package com.github.footballclubsubmission.ui.fragments.teamdescription.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.footballclubsubmission.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_team_description.*

/**
 * A simple [Fragment] subclass.
 *
 */
class TeamDescriptionFragment : Fragment() {

    companion object {
        private const val BUNDLE_KEY_STADIUM_NAME = "BUNDLE_KEY_STADIUM_NAME"
        private const val BUNDLE_KEY_STADIUM_DESC = "BUNDLE_KEY_STADIUM_DESC"
        private const val BUNDLE_KEY_STADIUM_THUMB = "BUNDLE_KEY_STADIUM_THUMB"
        private const val BUNDLE_KEY_DESCRIPTION_EN = "BUNDLE_KEY_DESCRIPTION_EN"

        fun newInstance(
            stadiumName: String?,
            stadiumThumb: String?,
            stadiumDesc: String?,
            DescEn: String?
        ): Fragment {
            val fragment = TeamDescriptionFragment()
            val bundle = Bundle()
            bundle.let {
                it.putString(BUNDLE_KEY_STADIUM_NAME, stadiumName)
                it.putString(BUNDLE_KEY_STADIUM_THUMB, stadiumThumb)
                it.putString(BUNDLE_KEY_STADIUM_DESC, stadiumDesc)
                it.putString(BUNDLE_KEY_DESCRIPTION_EN, DescEn)
                fragment.arguments = it
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initWidgets()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initWidgets() {
        Log.d(TeamDescriptionFragment::class.java.simpleName, arguments?.getString(BUNDLE_KEY_STADIUM_THUMB))
        Glide.with(context).load(arguments?.getString(BUNDLE_KEY_STADIUM_THUMB, ""))
            .centerCrop().error(R.drawable.ic_launcher_background).into(team_description_img_stadium)
        team_description_tv_stadium_desc.text = arguments?.getString(BUNDLE_KEY_STADIUM_DESC, "")
        team_description_tv_stadium.text = arguments?.getString(BUNDLE_KEY_STADIUM_NAME, "")
        team_description_tv_team_description.text = arguments?.getString(BUNDLE_KEY_DESCRIPTION_EN, "")

    }

}
