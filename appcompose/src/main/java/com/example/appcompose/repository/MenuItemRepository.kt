import androidx.compose.runtime.mutableStateListOf
import com.example.appcompose.model.MenuItem

class MenuItemRepository {
    private val _menuItems = mutableStateListOf<MenuItem>(MenuItem.Switch)
    val menuItems: List<MenuItem> = _menuItems

    fun addMenuItem(menuItem: MenuItem): Boolean {
        if (_menuItems.size < 5) {
            _menuItems.add(menuItem)
            return true
        } else {
            println("Limit doldu")
            return false
        }
    }

    fun removeMenuItem(menuItem: MenuItem): Boolean {
        if (_menuItems.contains(menuItem)) {
            _menuItems.remove(menuItem)
            return true
        } else {
            println("Kaldırma işlemi başarısız oldu")
            return false
        }
    }
}
