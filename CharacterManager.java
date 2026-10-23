
package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    private final List<Character> characters = new ArrayList<>();

    // Menambahkan karakter dan menolak nama duplikat
    public boolean addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException(
                "Karakter tidak boleh null."
            );
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                "Nama duplikat ditolak: " + character.getName()
            );
            return false;
        }

        characters.add(character);
        System.out.println(
            "Berhasil menambahkan: " + character.getName()
        );
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    // Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan daftar, bukan daftar internal
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }
    
/**
 * Menghitung rata-rata level seluruh karakter.
 * Mengembalikan 0 jika belum ada karakter.
 */
public double getAverageLevel() {
    if (characters.isEmpty()) {
        return 0;
    }

    int totalLevel = 0;

    for (Character character : characters) {
        totalLevel += character.getLevel();
    }

    return (double) totalLevel / characters.size();
}

/**
 * Mencari semua karakter berdasarkan tipe.
 */
public ArrayList<Character> findByType(CharacterType type) {
    ArrayList<Character> hasil = new ArrayList<>();

    if (type == null) {
        return hasil;
    }

    for (Character character : characters) {
        if (character.getType() == type) {
            hasil.add(character);
        }
    }

    return hasil;
}

/**
 * Mencari karakter dengan nilai attack tertinggi.
 * Mengembalikan null jika daftar karakter kosong.
 *
 * @return karakter dengan attack tertinggi, atau null jika kosong
 */
public Character findStrongest() {
    if (characters.isEmpty()) {
        return null;
    }

    Character strongest = characters.get(0);

    for (Character character : characters) {
        if (character.getAttack() > strongest.getAttack()) {
            strongest = character;
        }
    }

    return strongest;
}

}
