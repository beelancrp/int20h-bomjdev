package com.bomjdev.myfood

import java.util.*

/**
 * Created by azazellj on 2/23/19.
 */

data class Doctor @JvmOverloads constructor(
    val id: String = UUID.randomUUID().toString(),
    val displayName: String = "Mr. Doctor"
)