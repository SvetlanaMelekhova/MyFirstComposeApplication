package by.svetlana.project.myfirstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import by.svetlana.project.myfirstcomposeapplication.pokemonlist.PokemonListScreen
import by.svetlana.project.myfirstcomposeapplication.ui.theme.MyFirstComposeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeApplicationTheme {
                /* // A surface container using the 'background' color from the theme
                 Surface(color = MaterialTheme.colors.background) {
                     Greeting("Android")
                     }*/
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pokemon_list_screen") {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(navController = navController)
                    }
                    composable("pokemon_list_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                    }
                }
            }
        }
    }
}



/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
*/


/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstComposeApplicationTheme {

    }
}
*/
