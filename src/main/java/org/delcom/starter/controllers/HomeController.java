package org.delcom.starter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcomeMessage() {
        return "Hay Abdullah, selamat datang di pengembangan aplikasi dengan Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    public String personalizedGreeting(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // ======================================
    // Bagian Logika Aplikasi Utama
    // ======================================

    /**
     * Menganalisis NIM untuk mendapatkan detail program studi, angkatan, dan nomor urut.
     */
    @GetMapping("/informasiNim/{nim}")
    public String getNimDetails(@PathVariable String nim) {
        String studyProgram = mapNimPrefixToStudyProgram(nim.substring(0, 3));
        String enrollmentYear = "20" + nim.substring(3, 5);
        String sequenceNumber = String.valueOf(Integer.parseInt(nim.substring(5)));

        return String.format(
            "Informasi NIM %s:<br>> Program Studi: %s<br>> Angkatan: %s<br>> Urutan: %s",
            nim, studyProgram, enrollmentYear, sequenceNumber
        );
    }

    private String mapNimPrefixToStudyProgram(String prefix) {
        switch (prefix) {
            case "11S": return "Sarjana Informatika";
            case "12S": return "Sarjana Sistem Informasi";
            case "14S": return "Sarjana Teknik Elektro";
            case "21S": return "Sarjana Manajemen Rekayasa";
            case "22S": return "Sarjana Teknik Metalurgi";
            case "31S": return "Sarjana Teknik Bioproses";
            case "114": return "Diploma 4 Teknologi Rekasaya Perangkat Lunak";
            case "113": return "Diploma 3 Teknologi Informasi";
            case "133": return "Diploma 3 Teknologi Komputer";
            default: return "Program Studi Tidak Dikenal";
        }
    }

    /**
     * Mendekode string Base64 dan menampilkannya sebagai nilai.
     */
    @GetMapping("/perolehanNilai")
    public String decodeGradesFromBase64(@RequestParam String base64Input) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Input);
        String decodedString = new String(decodedBytes);
        return "Perolehan Nilai: " + decodedString;
    }

    /**
     * Membandingkan sebuah string dengan kebalikannya dan menunjukkan perbedaannya.
     */
    @GetMapping("/perbedaanL")
    public String findReversalDifferences(@RequestParam String base64Input) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Input);
        String originalText = new String(decodedBytes);

        StringBuilder reversedText = new StringBuilder(originalText).reverse();
        StringBuilder differences = new StringBuilder();

        for (int i = 0; i < originalText.length(); i++) {
            if (originalText.charAt(i) != reversedText.charAt(i)) {
                differences.append(originalText.charAt(i));
            }
        }

        return String.format(
            "Teks Asli: %s<br>Kebalikannya: %s<br>Perbedaannya: %s",
            originalText, reversedText, differences
        );
    }

    /**
     * Menemukan kata terpendek dan terpanjang dalam sebuah kalimat dari input Base64.
     */
    @GetMapping("/palingTer")
    public String findShortestAndLongestWords(@RequestParam String base64Input) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Input);
        String sentence = new String(decodedBytes);

        String[] words = sentence.split("\\s+");
        String shortestWord = words[0];
        String longestWord = words[0];

        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return String.format(
            "Kalimat: %s<br>Paling Pendek: %s<br>Paling Panjang: %s",
            sentence, shortestWord, longestWord);
    }
}