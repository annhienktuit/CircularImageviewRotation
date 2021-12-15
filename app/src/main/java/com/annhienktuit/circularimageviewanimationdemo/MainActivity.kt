package com.annhienktuit.circularimageviewanimationdemo

import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.annhienktuit.circularrotationimageview.CircularImageView
import com.annhienktuit.circularrotationimageview.RotateAnimation
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSource

class MainActivity : AppCompatActivity() {
    private lateinit var exoPlayer: ExoPlayer
    private lateinit var playerView: PlayerView
    private lateinit var mediaSource: MediaSource
    private lateinit var imgArtwork: CircularImageView
    private lateinit var animation: RotateAnimation
    val mediaURL = "https://media1.vocaroo.com/mp3/18S66hPGIhOV"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#FFFFFF")
        bindView()
        animation = RotateAnimation(this, imgArtwork)
        animation.startAnimation()
        initializeMedia()
        initializePlayer()
    }

    private fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(this).setMediaSourceFactory(DefaultMediaSourceFactory(this))
            .setTrackSelector(DefaultTrackSelector())
            .setLoadControl(DefaultLoadControl())
            .build()
        exoPlayer.playWhenReady = true
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        playerView.player = exoPlayer
        addListener()
    }

    private fun addListener() {
        exoPlayer.addListener(object : Player.EventListener {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                if (playWhenReady && playbackState == Player.STATE_READY) {
                    animation.resume()
                } else if (playWhenReady) {
                    animation.pause()
                } else {
                    animation.pause()
                }
            }
        })
    }

    private fun initializeMedia() {
        mediaSource = ProgressiveMediaSource.Factory(DefaultDataSource.Factory(this))
            .createMediaSource(Uri.parse(mediaURL))
    }

    private fun bindView() {
        playerView = findViewById(R.id.player_view)
        imgArtwork = findViewById(R.id.exo_artwork)

    }
}