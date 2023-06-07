package com.rishabhsharma1212.scrapitems.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.rishabhsharma1212.scrapitems.R


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var videoView: VideoView
val videoUrl = "https://youtu.be/s4LZwCDaoQM"
/**
 * A simple [Fragment] subclass.
 * Use the [AboutAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutAppFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        //val view= inflater.inflate(R.layout.fragment_about_app, container, false)

        /*val filename = "video"
        val filePlace = "android.resource://" + (activity?.packageName ) + "/raw/" + R.raw.video1
        val videoView = view.findViewById <View>(R.id.videoView) as VideoView
        videoView.setVideoURI(Uri.parse(filePlace))

        //videoView.setMediaController(MediaController(this))
        videoView.start()*/

        /*val filePlace = "android.resource://" + (packageName ) + "/raw/" + R.raw.video1
        val videoView = findViewById <View>(R.id.videoView) as VideoView
        videoView.setVideoURI(Uri.parse(filePlace))
        videoView.setMediaController(MediaController(this))
        videoView.start()*/


        /*videoView = view?.findViewById <View>(R.id.videoView) as VideoView

        val uri = Uri.parse(videoUrl)

        videoView.setVideoURI(uri)

        // media controller class
        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)

        mediaController.setMediaPlayer(videoView)

        videoView.setMediaController(mediaController);

        videoView.start();*/
        return inflater.inflate(R.layout.fragment_about_app, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutAppFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutAppFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}