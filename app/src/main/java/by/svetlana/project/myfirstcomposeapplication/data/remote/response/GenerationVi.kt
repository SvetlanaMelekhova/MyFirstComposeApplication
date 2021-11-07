package by.svetlana.project.myfirstcomposeapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y") val xY: XY
)