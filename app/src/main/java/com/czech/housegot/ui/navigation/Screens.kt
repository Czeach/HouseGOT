package com.czech.housegot.ui.navigation

sealed class Screens(val route: String) {

    object HousesScreen: Screens("houses_screen")
    object DetailsScreen: Screens("details_screen")
}
