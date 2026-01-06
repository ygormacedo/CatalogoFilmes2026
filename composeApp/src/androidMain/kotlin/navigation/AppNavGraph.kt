import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.catalogofilme.ui.components.screen.login.LoginScreen
import ui.components.screen.login.HomeScreen
import ui.components.viewmodel.HomeViewModel
import ui.components.screen.login.LoginViewModel
import ui.components.screen.login.details.MovieDetailsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController // 🔹 RECEBE o controller
) {
    NavHost(
        navController = navController, // 🔹 USA o controller
        startDestination = "login"
    ) {

        composable("login") {
            val loginViewModel = remember { LoginViewModel() }

            LoginScreen(
                viewModel = loginViewModel,
                onLoginSuccess = {
                    // 🔹 Navegação feita AQUI
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        composable("home") {
            val homeViewModel = remember { HomeViewModel() }

            HomeScreen(
                viewModel = homeViewModel,
                onMovieClick = { movieId ->
                    // 🔹 Navegação com argumento
                    navController.navigate("details/$movieId")
                }
            )
        }

        composable("details/{id}") { backStack ->
            val id = backStack.arguments!!
                .getString("id")!!
                .toInt()

            MovieDetailsScreen(movieId = id)
        }
    }
}