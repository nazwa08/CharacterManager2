
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        // Membuat 3 karakter
        Character c1 = new Character("Arthur", CharacterType.WARRIOR);
        Character c2 = new Character("Merlin", CharacterType.MAGE, 3);
        Character c3 = new Character("Robin", CharacterType.ARCHER, 2);

        System.out.println("=== DATA KARAKTER ===");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demo level up
        System.out.println("\n=== DEMO LEVEL UP ===");
        c1.setLevel(c1.getLevel() + 1);
        System.out.println(c1);

        // 5. Mini-Challenge Bagian B
        Character c4 = new Character("Luna", CharacterType.MAGE);
        c4.setMana(50);

        System.out.println("\n=== MINI-CHALLENGE BAGIAN B ===");
        System.out.println(c4);
        System.out.println("Mana Luna: " + c4.getMana());
        System.out.println("Apakah Luna masih hidup? " + c4.isAlive());
    }
}
