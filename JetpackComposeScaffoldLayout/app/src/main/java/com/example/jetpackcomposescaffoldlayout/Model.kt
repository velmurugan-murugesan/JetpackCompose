package com.example.jetpackcomposescaffoldlayout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


object BottomMenu {

    data class MenuItem(val title: String, val icon: ImageVector)

    fun getMenuList() : List<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        menuItems.add(MenuItem(Navigations.HOME.name, Icons.Filled.Home))
        menuItems.add(MenuItem(Navigations.SEARCH.name, Icons.Filled.Search))
        menuItems.add(MenuItem(Navigations.FAVORITE.name, Icons.Filled.Favorite))
        menuItems.add(MenuItem(Navigations.SETTINGS.name, Icons.Filled.Settings))
        return menuItems
    }

}