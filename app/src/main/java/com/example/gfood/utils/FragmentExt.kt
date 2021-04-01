package com.example.gfood.utils

import androidx.fragment.app.Fragment

fun Fragment.addFragment(fragment: Fragment, id: Int) {
    fragmentManager?.inTransaction {
        add(id, fragment)
        addToBackStack(null)
    }
}

fun Fragment.replaceFragment(fragment: Fragment, id: Int) {
    fragmentManager?.inTransaction {
        replace(id, fragment)
    }
}

fun Fragment.removeFragment(fragment: Fragment) {
    fragmentManager?.inTransaction {
        remove(fragment)
    }
}
