
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel daftarPanel;
    private final JLabel statistikLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Judul aplikasi
        JLabel judul = new JLabel("Daftar Karakter");
        judul.setFont(new Font("Arial", Font.BOLD, 22));
        panelUtama.add(judul, BorderLayout.NORTH);

        // Panel daftar karakter yang dibuat secara dinamis
        daftarPanel = new JPanel();
        daftarPanel.setLayout(
            new BoxLayout(daftarPanel, BoxLayout.Y_AXIS)
        );

        JScrollPane scrollPane = new JScrollPane(daftarPanel);
        panelUtama.add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk statistik dan tombol
        JPanel panelBawah = new JPanel(new BorderLayout(10, 10));

        statistikLabel = new JLabel("Rata-rata Level: 0.00");
        statistikLabel.setFont(new Font("Arial", Font.BOLD, 15));
        panelBawah.add(statistikLabel, BorderLayout.NORTH);

        JButton tombolTambah = new JButton("Tambah Karakter");
        tombolTambah.addActionListener(e -> tambahKarakter());

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTombol.add(tombolTambah);
        panelBawah.add(panelTombol, BorderLayout.SOUTH);

        panelUtama.add(panelBawah, BorderLayout.SOUTH);

        add(panelUtama);

        // Menampilkan data awal
        refreshDaftarKarakter();

        setVisible(true);
    }

    private void tambahKarakter() {
        JTextField namaField = new JTextField();

        JComboBox<CharacterType> tipeComboBox =
            new JComboBox<>(CharacterType.values());

        JTextField levelField = new JTextField("1");

        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("Nama Karakter:"));
        form.add(namaField);
        form.add(new JLabel("Tipe Karakter:"));
        form.add(tipeComboBox);
        form.add(new JLabel("Level:"));
        form.add(levelField);

        int pilihan = JOptionPane.showConfirmDialog(
            this,
            form,
            "Tambah Karakter Baru",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (pilihan != JOptionPane.OK_OPTION) {
            return;
        }

        String nama = namaField.getText().trim();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Nama karakter tidak boleh kosong.",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int level;

        try {
            level = Integer.parseInt(levelField.getText().trim());

            if (level < 1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Level minimal adalah 1.",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Level harus berupa angka bulat.",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        CharacterType tipe =
            (CharacterType) tipeComboBox.getSelectedItem();

        try {
            Character karakterBaru = new Character(nama, tipe, level);

            boolean berhasil = manager.addCharacter(karakterBaru);

            if (berhasil) {
                refreshDaftarKarakter();

                JOptionPane.showMessageDialog(
                    this,
                    "Karakter berhasil ditambahkan!"
                );
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Nama karakter sudah digunakan.",
                    "Nama Duplikat",
                    JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Data Tidak Valid",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void refreshDaftarKarakter() {
        daftarPanel.removeAll();

        List<Character> characters = manager.getAllCharacters();
        int totalLevel = 0;

        for (Character character : characters) {
            JLabel label = new JLabel(
                character.getName()
                + " | Tipe: " + character.getType()
                + " | Level: " + character.getLevel()
                + " | Attack: " + character.getAttack()
            );

            label.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            );
            label.setAlignmentX(Component.LEFT_ALIGNMENT);

            daftarPanel.add(label);
            daftarPanel.add(Box.createVerticalStrut(5));

            totalLevel += character.getLevel();
        }

        double rataRata = characters.isEmpty()
            ? 0.0
            : (double) totalLevel / characters.size();

        statistikLabel.setText(
            String.format("Rata-rata Level: %.2f", rataRata)
        );

        daftarPanel.revalidate();
        daftarPanel.repaint();
    }
}
