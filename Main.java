
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        // Data karakter awal
        manager.addCharacter(
            new Character("Arthur", CharacterType.WARRIOR, 1)
        );

        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Robin", CharacterType.ARCHER, 2)
        );

        manager.addCharacter(
            new Character("Luna", CharacterType.MAGE, 4)
        );

        manager.addCharacter(
            new Character("Ragnar", CharacterType.WARRIOR, 5)
        );

        // Menjalankan GUI pada Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new MainWindow(manager);
        });
    }
}
