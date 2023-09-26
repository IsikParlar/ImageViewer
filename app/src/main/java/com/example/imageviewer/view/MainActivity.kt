package com.example.imageviewer.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import com.example.imageviewer.model.Member
import com.example.imageviewer.presenter.Presenter
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

class MainActivity : ComponentActivity(), MainView {

    private val presenter by lazy { Presenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.sendActivity(this)
        presenter.getMembers()
    }

    override fun showMembers(members: List<Member>) {
        setContent {

            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                itemsIndexed(members) { _, member ->
                    GlideImage(
                        { member.avatarUrl },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.Center
                        )
                    )
                }
            }
        }
    }

}
