package com.example.imageviewer.view

import com.example.imageviewer.model.Member

interface MainView {
    fun showMembers(members: List<Member>)
}