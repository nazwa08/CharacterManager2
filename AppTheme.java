
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    // Warna utama aplikasi
    public static final Color BG_MAIN = new Color(19, 19, 31);
    public static final Color TEXT_MAIN = new Color(223, 230, 233);
    public static final Color TEXT_LIGHT = Color.WHITE;
    public static final Color GOLD = new Color(253, 203, 110);

    // Warna berdasarkan role
    public static final Color WARRIOR_COLOR = new Color(214, 48, 49);
    public static final Color MAGE_COLOR = new Color(9, 132, 227);
    public static final Color ARCHER_COLOR = new Color(0, 184, 148);
    public static final Color ASSASSIN_COLOR = new Color(142, 68, 173);

    // Font aplikasi
    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);

    // Border kartu karakter
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12);

    // Batas level tinggi
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    private AppTheme() {
        // Mencegah objek AppTheme dibuat
    }

    // Mengatur warna berdasarkan role karakter
    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return Color.GRAY;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case ASSASSIN:
                return ASSASSIN_COLOR;

            default:
                return Color.GRAY;
        }
    }

    // Keterangan role untuk tooltip
    public static String describe(CharacterType type) {

        if (type == null) {
            return "Role tidak diketahui";
        }

        switch (type) {
            case WARRIOR:
                return "Warrior - Petarung jarak dekat";

            case MAGE:
                return "Mage - Pengguna kekuatan sihir";

            case ARCHER:
                return "Archer - Penyerang jarak jauh";

            case ASSASSIN:
                return "Assassin - Penyerang cepat dan lincah";

            default:
                return "Role karakter";
        }
    }
}
