
package simplenoteapp;

import java.util.ArrayList;
import java.util.Scanner;

class Note {
    private String title;
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content;
    }
}

public class SimpleNoteApp {
    private ArrayList<Note> notes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SimpleNoteApp noteApp = new SimpleNoteApp();
        noteApp.run();
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character after reading the integer choice

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    editNote();
                    break;
                case 4:
                    deleteNote();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Aplikasi Catatan. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan pilih lagi.");
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nAplikasi Catatan");
        System.out.println("1. Tambah Catatan");
        System.out.println("2. Lihat Catatan");
        System.out.println("3. Edit Catatan");
        System.out.println("4. Hapus Catatan");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1/2/3/4/5): ");
    }

    private void addNote() {
        System.out.println("\nTambah Catatan");
        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("Isi catatan: ");
        String content = scanner.nextLine();

        Note note = new Note(title, content);
        notes.add(note);

        System.out.println("Catatan berhasil ditambahkan.");
    }

    private void viewNotes() {
        System.out.println("\nDaftar Catatan");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan yang tersedia.");
        } else {
            int index = 1;
            for (Note note : notes) {
                System.out.println("\nCatatan ke-" + index++);
                System.out.println(note);
            }
        }
    }

    private void editNote() {
        System.out.println("\nEdit Catatan");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan yang tersedia.");
        } else {
            viewNotes();
            System.out.print("\nPilih nomor catatan yang ingin diedit: ");
            int noteIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character after reading the integer choice

            if (noteIndex < 1 || noteIndex > notes.size()) {
                System.out.println("Nomor catatan tidak valid.");
            } else {
                System.out.print("Judul baru: ");
                String newTitle = scanner.nextLine();
                System.out.print("Isi catatan baru: ");
                String newContent = scanner.nextLine();

                Note selectedNote = notes.get(noteIndex - 1);
                selectedNote.setTitle(newTitle);
                selectedNote.setContent(newContent);

                System.out.println("Catatan berhasil diubah.");
            }
        }
    }

    private void deleteNote() {
        System.out.println("\nHapus Catatan");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan yang tersedia.");
        } else {
            viewNotes();
            System.out.print("\nPilih nomor catatan yang ingin dihapus: ");
            int noteIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character after reading the integer choice

            if (noteIndex < 1 || noteIndex > notes.size()) {
                System.out.println("Nomor catatan tidak valid.");
            } else {
                Note selectedNote = notes.get(noteIndex - 1);
                notes.remove(selectedNote);
                System.out.println("Catatan berhasil dihapus.");
            }
        }
    }
}

